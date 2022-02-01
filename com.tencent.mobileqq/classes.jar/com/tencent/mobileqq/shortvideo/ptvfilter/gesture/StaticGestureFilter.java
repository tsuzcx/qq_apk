package com.tencent.mobileqq.shortvideo.ptvfilter.gesture;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil.Player;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.AlgoUtils;
import java.io.File;
import java.util.List;

public class StaticGestureFilter
  extends VideoFilterBase
{
  public static final String TAG = "StaticGestureFilter";
  protected long frameStartTime;
  private boolean havePlayEnd = false;
  private boolean initialized = false;
  private StickerItem item;
  private int lastDecodeImageIndex = -1;
  private int lastImageIndex = -1;
  private boolean mAlwayslastFrame = false;
  public int mGestureAnimGapTime = -1;
  public int mGestureAnimType = -1;
  public int mGesturePointIndex = -1;
  private String mGestureType = "qheart";
  private int mItemCount = 0;
  private long mLastReconizeTime = 0L;
  private PlayerUtil.Player mPlayer;
  protected UniformParam.TextureBitmapParam mTextureParam;
  protected String materialId;
  protected int playCount = 0;
  float[] postion = { -1.0F, 1.0F, 1.0F, -1.0F };
  private int[] tex = new int[1];
  
  public StaticGestureFilter(StickerItem paramStickerItem, String paramString)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_NORMAL));
    this.dataPath = paramString;
    paramStickerItem.playCount = 1;
    this.materialId = VideoMaterialUtil.getMaterialId(paramString);
    setCurrentItem(paramStickerItem, 0);
    initParams();
  }
  
  public static void filterLog(String paramString)
  {
    if (SLog.isEnable()) {
      SLog.i("StaticGestureFilter", paramString);
    }
  }
  
  private int getCount(long paramLong)
  {
    if (this.item.playCount == 0) {}
    int i = (int)((paramLong - this.frameStartTime) / Math.max(this.item.frameDuration, 1.0D));
    if (i >= this.item.frames * (this.playCount + 1)) {
      this.playCount += 1;
    }
    return i % Math.max(this.item.frames, 1);
  }
  
  private int getNextFrame(int paramInt)
  {
    boolean bool2 = true;
    Object localObject = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
    if (localObject == null)
    {
      localObject = this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + "_" + paramInt + ".png";
      localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if (BitmapUtils.isLegal((Bitmap)localObject))
      {
        GlUtil.loadTexture(this.tex[0], (Bitmap)localObject);
        if (paramInt != 0) {
          ((Bitmap)localObject).recycle();
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject = new StringBuilder().append("getNextFrame load cache:");
        if (paramInt == 0) {}
        for (;;)
        {
          filterLog(bool2 + ", updateTexture:" + bool1);
          return this.tex[0];
          bool2 = false;
        }
      }
    }
  }
  
  private void resetAnimationStatus(long paramLong)
  {
    this.havePlayEnd = false;
    this.frameStartTime = paramLong;
    this.mAlwayslastFrame = false;
    this.mItemCount = -1;
    this.lastImageIndex = -1;
    this.lastDecodeImageIndex = -1;
  }
  
  private void updateTextureParam(long paramLong)
  {
    int i = getCount(paramLong);
    if (i == this.lastImageIndex)
    {
      filterLog("updateTextureParam return! + lastImageIndex:" + this.lastImageIndex + ";count is" + i + ":timestamp:=" + paramLong + ":framestartTimes " + this.frameStartTime);
      return;
    }
    filterLog("updateTextureParam" + i);
    addParam(new UniformParam.TextureParam("inputImageTexture2", getNextFrame(i), 33986));
    this.lastImageIndex = i;
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    GLES20.glGenTextures(this.tex.length, this.tex, 0);
  }
  
  public void OnDrawFrameGLSL()
  {
    super.OnDrawFrameGLSL();
  }
  
  public void adjustPosition()
  {
    setPositions(AlgoUtils.calPositions(0.0F, 100.0F, 100.0F, 0.0F, 100, 100));
  }
  
  public boolean canUseBlendMode()
  {
    return true;
  }
  
  public void clearGLSLSelf()
  {
    if (SLog.isEnable()) {
      SLog.d("GestureTEST", "StaticGestureFilter clearGLSLSelf");
    }
    filterLog("clearGLSLSelf!");
    clearTextureParam();
    destroyAudio();
    this.mLastReconizeTime = 0L;
    super.clearGLSLSelf();
    GLES20.glDeleteTextures(this.tex.length, this.tex, 0);
  }
  
  public void clearTextureParam()
  {
    if (this.mTextureParam != null)
    {
      this.mTextureParam.clear();
      this.mTextureParam = null;
    }
    setPositions(GlUtil.EMPTY_POSITIONS);
    this.initialized = false;
    this.lastImageIndex = -1;
    this.lastDecodeImageIndex = -1;
    this.mAlwayslastFrame = false;
    filterLog("clearTextureParam!");
  }
  
  public void destroyAudio()
  {
    filterLog("destroyAudio!");
    PlayerUtil.destroyPlayer(this.mPlayer);
    this.mPlayer = null;
  }
  
  public boolean hasAnimationEnd(long paramLong)
  {
    return paramLong - this.frameStartTime > this.item.frames * this.item.frameDuration;
  }
  
  public boolean haveAnimationStart()
  {
    return this.frameStartTime != 0L;
  }
  
  public void initParams()
  {
    addParam(new UniformParam.IntParam("texNeedTransform", -1));
    addParam(new UniformParam.IntParam("blendMode", this.item.blendMode));
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.Float2fParam("displacement", 0.0F, 0.0F));
    addParam(new UniformParam.IntParam("displacementEnableLut", 0));
  }
  
  public String printControllerInfo()
  {
    return "mGestureAnimType:=" + this.mGestureAnimType + ";" + this.mGestureAnimGapTime + ";" + this.mGesturePointIndex;
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void setControllerInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mGestureAnimType = paramInt1;
    this.mGestureAnimGapTime = paramInt2;
    this.mGesturePointIndex = paramInt3;
  }
  
  public void setCurrentItem(StickerItem paramStickerItem, int paramInt)
  {
    this.item = paramStickerItem;
    this.lastImageIndex = -1;
    this.lastDecodeImageIndex = -1;
    this.playCount = 0;
    this.mItemCount = 0;
    this.mAlwayslastFrame = false;
    destroyAudio();
    VideoMemoryManager.getInstance().reset(paramStickerItem.id);
    filterLog("currentItem id:" + this.item.id);
  }
  
  public boolean setRenderMode(int paramInt)
  {
    return super.setRenderMode(paramInt);
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat) {}
  
  public void updatePreview(Object paramObject)
  {
    int j = 1;
    if ((paramObject instanceof PTDetectInfo)) {}
    for (paramObject = (PTDetectInfo)paramObject; paramObject == null; paramObject = null) {
      return;
    }
    if ((this.item.getTriggerTypeInt() == 1001) && (this.item.type == 1)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        GestureKeyInfo localGestureKeyInfo = GestureMgrRecognize.getInstance().getGestureInfo();
        if ((localGestureKeyInfo != null) && (localGestureKeyInfo.vaild) && (localGestureKeyInfo.type.equalsIgnoreCase(GestureFilterManager.sGestureType)))
        {
          if (this.mLastReconizeTime == 0L) {
            this.frameStartTime = paramObject.timestamp;
          }
          this.mLastReconizeTime = paramObject.timestamp;
          i = j;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          if (hasAnimationEnd(paramObject.timestamp)) {
            resetAnimationStatus(paramObject.timestamp);
          }
          adjustPosition();
          updateTextureParam(paramObject.timestamp);
          return;
        }
        if ((hasAnimationEnd(paramObject.timestamp)) || (this.frameStartTime == 0L))
        {
          clearTextureParam();
          this.frameStartTime = 0L;
          this.mLastReconizeTime = 0L;
          return;
        }
        adjustPosition();
        updateTextureParam(paramObject.timestamp);
        if (!SLog.isEnable()) {
          break;
        }
        SLog.d("StaticGestureFilter", "updatePreview continue");
        return;
        i = 0;
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    setPositions(GlUtil.EMPTY_POSITIONS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.gesture.StaticGestureFilter
 * JD-Core Version:    0.7.0.1
 */