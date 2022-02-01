package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.filter.CosFunHelper;
import com.tencent.ttpic.openapi.filter.CosFunHelper.CountDownListener;
import com.tencent.ttpic.openapi.filter.CosFunTransitionFilter;
import com.tencent.ttpic.openapi.filter.StyleChildFilter;
import com.tencent.ttpic.openapi.filter.stylizefilter.customFilter.StyleCustomFilterGroup;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.CosFunItem;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.PagIndexList;
import com.tencent.ttpic.trigger.TriggerManager;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FrameUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CosFunFilter
{
  private static final String TAG = "CosFunFilter";
  private final int STATE_AFTER = 5;
  private final int STATE_BEFORE = 0;
  private final int STATE_COS_FUN = 3;
  private final int STATE_FREEZE = 1;
  private final int STATE_REVERSE = 4;
  private final int STATE_TRANS = 2;
  private Frame copyFrame = new Frame();
  private CosFun.CosFunItem cosFunItem;
  private CosFunTransitionFilter cosFunTransitionFilter;
  private CosFunFilter.CosTransTime cosTransTime;
  private StyleCustomFilterGroup customFilterGroup;
  private boolean enableGAN;
  private boolean firstPagFrameRenderTriggered = false;
  private FreezeFilter freezeFilter;
  private StyleChildFilter ganFilter;
  private long initStartTime;
  private boolean isCosTransInit = false;
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private PagFilter pagFilter;
  private List<Bitmap> textureMaterials = new ArrayList();
  private TriggerManager triggerManager;
  private long triggerStartTime;
  
  private void decodeTextureMaterials(String paramString)
  {
    Object localObject1 = this.cosFunItem;
    if (localObject1 != null)
    {
      localObject1 = ((CosFun.CosFunItem)localObject1).getTextureMaterialsForGAN();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (String)((Iterator)localObject1).next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(FileUtils.genSeperateFileDir(paramString));
          localStringBuilder.append((String)localObject2);
          localObject2 = BitmapUtils.decodeBitmap(localStringBuilder.toString(), true);
          if (BitmapUtils.isLegal((Bitmap)localObject2)) {
            this.textureMaterials.add(localObject2);
          }
        }
      }
    }
  }
  
  private Frame fillBlackFrame(Frame paramFrame, int paramInt1, int paramInt2)
  {
    float f2 = paramFrame.width;
    float f1 = paramInt1;
    float f3 = f2 / f1;
    float f4 = paramFrame.height;
    f2 = paramInt2;
    f3 = Math.max(f3, f4 / f2);
    paramInt1 = (int)(f1 * f3);
    paramInt2 = (int)(f2 * f3);
    int i = (paramInt1 - paramFrame.width) / 2;
    int j = paramFrame.width;
    int k = (paramInt2 - paramFrame.height) / 2;
    int m = paramFrame.height;
    float[] arrayOfFloat = AlgoUtils.calPositions(i, m + k, j + i, k, paramInt1, paramInt2);
    FrameUtil.clearFrame(this.copyFrame, 0.0F, 0.0F, 0.0F, 1.0F, paramInt1, paramInt2);
    this.mCopyFilter.setPositions(arrayOfFloat);
    this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, -1, 0.0D, this.copyFrame);
    return this.copyFrame;
  }
  
  private void initCustomFilterGroup()
  {
    StyleCustomFilterGroup localStyleCustomFilterGroup = this.customFilterGroup;
    if (localStyleCustomFilterGroup != null) {
      localStyleCustomFilterGroup.apply();
    }
  }
  
  private CosFunFilter.TimeSection judgeTimeSection(long paramLong)
  {
    if (paramLong <= this.cosTransTime.freezeStart) {
      return new CosFunFilter.TimeSection(this, 0, 0.0F);
    }
    if (paramLong < this.cosTransTime.freezeStart + this.cosTransTime.freezeDuration) {
      return new CosFunFilter.TimeSection(this, 1, (float)(paramLong - this.cosTransTime.freezeStart) * 1.0F / this.cosTransTime.freezeDuration);
    }
    if ((this.cosTransTime.transStart > 0) && (paramLong < this.cosTransTime.transStart + this.cosTransTime.transDuration)) {
      return new CosFunFilter.TimeSection(this, 2, (float)(paramLong - this.cosTransTime.transStart) * 1.0F / this.cosTransTime.transDuration);
    }
    if ((this.cosTransTime.transStart > 0) && (this.cosTransTime.transReverseStart > 0) && (paramLong >= this.cosTransTime.transReverseStart))
    {
      if (paramLong < this.cosTransTime.transReverseStart + this.cosTransTime.transReverseDuration) {
        return new CosFunFilter.TimeSection(this, 4, 1.0F - (float)(paramLong - this.cosTransTime.transReverseStart) * 1.0F / this.cosTransTime.transReverseDuration);
      }
      return new CosFunFilter.TimeSection(this, 5, 0.0F);
    }
    return new CosFunFilter.TimeSection(this, 3, 1.0F);
  }
  
  private void parseCosTransition(String paramString, CosFun.CosFunItem paramCosFunItem)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramCosFunItem.getCrazyFacePath());
    this.cosFunTransitionFilter = new CosFunTransitionFilter(localStringBuilder.toString(), 2, paramCosFunItem.getBackgroundMode2());
    this.cosTransTime = new CosFunFilter.CosTransTime(this);
    this.cosTransTime.freezeStart = paramCosFunItem.getFreezeStart();
    this.cosTransTime.freezeDuration = paramCosFunItem.getFreezeDuration();
    this.cosTransTime.transStart = paramCosFunItem.getTransStart();
    this.cosTransTime.transDuration = paramCosFunItem.getTransDuration();
    this.cosTransTime.transReverseStart = paramCosFunItem.getTransReverseStart();
    this.cosTransTime.transReverseDuration = paramCosFunItem.getTransReverseDuration();
  }
  
  private void parseFreeze(CosFun.CosFunItem paramCosFunItem)
  {
    this.freezeFilter = new FreezeFilter(paramCosFunItem, this.triggerManager);
    this.freezeFilter.init();
  }
  
  private void parsePagFilter(String paramString, CosFun.CosFunItem paramCosFunItem)
  {
    this.pagFilter = new PagFilter(paramString, paramCosFunItem.getPagPath(), paramCosFunItem.getPagIndexList().getCosFun());
    this.pagFilter.init();
  }
  
  private void recyleTextureMaterials()
  {
    Object localObject = this.textureMaterials;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        BitmapUtils.recycle((Bitmap)((Iterator)localObject).next());
      }
    }
  }
  
  public boolean durationComplete(long paramLong)
  {
    return paramLong - this.triggerStartTime > this.cosFunItem.getDuration();
  }
  
  public long getDuration()
  {
    return this.cosFunItem.getDuration();
  }
  
  public void init(String paramString, CosFun.CosFunItem paramCosFunItem, TriggerManager paramTriggerManager, StyleCustomFilterGroup paramStyleCustomFilterGroup)
  {
    this.cosFunItem = paramCosFunItem;
    this.mCopyFilter.apply();
    this.triggerManager = paramTriggerManager;
    parseFreeze(paramCosFunItem);
    this.customFilterGroup = paramStyleCustomFilterGroup;
    initCustomFilterGroup();
    decodeTextureMaterials(paramString);
    parseCosTransition(paramString, paramCosFunItem);
    parsePagFilter(paramString, paramCosFunItem);
  }
  
  public boolean isTriggered()
  {
    int i = this.cosFunItem.getTriggerType();
    boolean bool = true;
    if (i != 1)
    {
      if (this.freezeFilter.isTriggered()) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void release()
  {
    Object localObject = this.freezeFilter;
    if (localObject != null)
    {
      ((FreezeFilter)localObject).destroy();
      this.freezeFilter = null;
    }
    localObject = this.cosFunTransitionFilter;
    if (localObject != null)
    {
      ((CosFunTransitionFilter)localObject).destroy();
      this.cosFunTransitionFilter = null;
    }
    localObject = this.customFilterGroup;
    if (localObject != null) {
      ((StyleCustomFilterGroup)localObject).destroy();
    }
    this.copyFrame.clear();
    if (this.cosTransTime != null) {
      this.cosTransTime = null;
    }
    this.isCosTransInit = false;
    localObject = this.pagFilter;
    if (localObject != null)
    {
      ((PagFilter)localObject).release();
      this.pagFilter = null;
    }
    this.mCopyFilter.clearGLSL();
    recyleTextureMaterials();
  }
  
  public Frame render(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr)
  {
    paramPTSegAttr = this.cosFunTransitionFilter;
    if (paramPTSegAttr != null)
    {
      if (!paramPTSegAttr.isInited()) {
        return paramFrame;
      }
      if (paramPTFaceAttr.getTimeStamp() - this.initStartTime < this.cosFunItem.getWaitInterval())
      {
        if (paramPTFaceAttr.getFaceCount() < 1) {
          return paramFrame;
        }
        if (!this.firstPagFrameRenderTriggered)
        {
          BenchUtil.benchStart("[pagFilter.render]");
          paramPTFaceAttr = fillBlackFrame(paramFrame, this.cosFunTransitionFilter.getWidth(), this.cosFunTransitionFilter.getHeight());
          this.pagFilter.render(paramPTFaceAttr, paramFrame.width, paramFrame.height, 0.0D);
          BenchUtil.benchEnd("[pagFilter.render]");
          this.firstPagFrameRenderTriggered = true;
        }
        return paramFrame;
      }
      long l = paramPTFaceAttr.getTimeStamp() - this.triggerStartTime;
      paramPTSegAttr = judgeTimeSection(l);
      int i = paramPTSegAttr.state;
      if (i != 1)
      {
        if ((i != 2) && (i != 3) && (i != 4))
        {
          if (i != 5) {
            paramPTFaceAttr = paramFrame;
          } else {
            paramPTFaceAttr = this.freezeFilter.getFreezeFrame(paramFrame);
          }
        }
        else
        {
          paramPTFaceAttr = this.freezeFilter;
          if ((paramPTFaceAttr != null) && (paramPTFaceAttr.hasFreezeFace())) {
            paramPTFaceAttr = this.cosFunTransitionFilter.getMergedFrame(paramPTSegAttr.fraction);
          } else {
            paramPTFaceAttr = this.freezeFilter.getFreezeFrame(paramFrame);
          }
        }
      }
      else
      {
        paramPTSegAttr = this.freezeFilter.getFreezeFrame(paramFrame);
        this.freezeFilter.setFreezeCount(paramPTFaceAttr);
        if ((!this.isCosTransInit) && (paramPTFaceAttr.getFaceCount() > 0))
        {
          paramAIAttr = this.ganFilter;
          if ((paramAIAttr != null) && (this.customFilterGroup != null))
          {
            paramAIAttr = paramAIAttr.getTextureBitmapList();
            this.ganFilter.setTextureBitmapList(this.textureMaterials);
            this.ganFilter.updateAndRender(paramFrame, paramPTFaceAttr, paramPTFaceAttr.getFaceDetectScale());
            this.customFilterGroup.updateVideoSize(paramFrame.width, paramFrame.height);
            this.cosFunTransitionFilter.setMaterialFrame(this.customFilterGroup.render(this.ganFilter.render(paramPTSegAttr)));
            this.ganFilter.setTextureBitmapList(paramAIAttr);
          }
          this.cosFunTransitionFilter.init(paramPTSegAttr.getTextureId(), paramPTSegAttr.width, paramPTSegAttr.height, (List)paramPTFaceAttr.getAllFacePoints().get(0), paramPTFaceAttr.getFaceDetectScale(), this.enableGAN);
          paramPTFaceAttr = this.cosFunItem;
          if (paramPTFaceAttr != null)
          {
            this.cosFunTransitionFilter.setTransType(paramPTFaceAttr.getTransType());
            this.cosFunTransitionFilter.setClampToEdge(this.cosFunItem.isClampToEdge());
          }
          this.isCosTransInit = true;
        }
        paramPTFaceAttr = paramPTSegAttr;
      }
      BenchUtil.benchStart("[CosFunFilter] pagFilter");
      paramPTSegAttr = paramPTFaceAttr;
      if (this.freezeFilter.isTriggered())
      {
        paramPTFaceAttr = fillBlackFrame(paramPTFaceAttr, this.cosFunTransitionFilter.getWidth(), this.cosFunTransitionFilter.getHeight());
        GLES20.glFinish();
        paramPTSegAttr = this.pagFilter;
        i = paramFrame.width;
        int j = paramFrame.height;
        double d1 = l;
        Double.isNaN(d1);
        double d2 = this.cosFunItem.getDuration();
        Double.isNaN(d2);
        paramPTSegAttr = paramPTSegAttr.render(paramPTFaceAttr, i, j, d1 * 1.0D / d2);
      }
      BenchUtil.benchEnd("[CosFunFilter] pagFilter");
      return paramPTSegAttr;
    }
    return paramFrame;
  }
  
  public void reset()
  {
    this.triggerStartTime = 0L;
  }
  
  public void setEnableGAN(boolean paramBoolean)
  {
    this.enableGAN = paramBoolean;
  }
  
  public void setGanFilter(StyleChildFilter paramStyleChildFilter)
  {
    this.ganFilter = paramStyleChildFilter;
  }
  
  public void updateParams(PTFaceAttr paramPTFaceAttr)
  {
    if (this.initStartTime <= 0L) {
      this.initStartTime = paramPTFaceAttr.getTimeStamp();
    }
    this.triggerStartTime = paramPTFaceAttr.getTimeStamp();
    if (paramPTFaceAttr.getTimeStamp() - this.initStartTime < this.cosFunItem.getWaitInterval())
    {
      if (paramPTFaceAttr.getFaceCount() < 1)
      {
        if (CosFunHelper.countDownListener != null) {
          CosFunHelper.countDownListener.onCountDownEnd();
        }
        CosFunHelper.isRestart = true;
      }
      return;
    }
    this.triggerStartTime = this.freezeFilter.updateActionTriggered(paramPTFaceAttr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.CosFunFilter
 * JD-Core Version:    0.7.0.1
 */