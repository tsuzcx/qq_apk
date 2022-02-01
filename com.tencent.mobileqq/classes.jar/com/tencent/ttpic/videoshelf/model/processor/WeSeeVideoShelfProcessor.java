package com.tencent.ttpic.videoshelf.model.processor;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal;
import com.tencent.ttpic.video.AECoderFactory;
import com.tencent.ttpic.video.AEDecoder;
import com.tencent.ttpic.videoshelf.filter.VideoShelfAlphaFilter;
import com.tencent.ttpic.videoshelf.filter.VideoShelfMergeFilter;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.template.VideoFrameItem;
import com.tencent.vbox.util.VideoUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeSeeVideoShelfProcessor
  implements IVideoShelfProcessor
{
  private static final String TAG = "WeSeeVideoShelfProcessor";
  public static final String WESEE_VS_LUT_PATH = "WeSeeVideoShelfProcessor_2";
  public static final String WESEE_VS_VIDEO_PATH = "WeSeeVideoShelfProcessor_1";
  public static final String WESEE_VS_VIDEO_TEMPLATE_TYPE = "WeSeeVideoShelfProcessor_3";
  private VideoShelfAlphaFilter alphaFilter;
  private int canvasH;
  private int canvasW;
  private Frame effectFilterFrame = new Frame();
  private Frame mAlphaFrame = new Frame();
  private int mDecodeTexture;
  private BaseFilter mEffectFilter;
  private int mFrameIndex = 0;
  private List<Long> mFrameStamps = new ArrayList();
  private String mInputVideo;
  private String mLutPath;
  private AEDecoder mVideoDecoder;
  private int mVideoTemplateType;
  private VideoShelfMergeFilter mergeFilter;
  private Frame mergeFrame = new Frame();
  
  private void initLutFilter(String paramString)
  {
    Bitmap localBitmap2 = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), paramString, 1);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(paramString);
    }
    this.mEffectFilter = TTPicFilterFactoryLocal.lutFilterWithBitmap(localBitmap1);
    paramString = this.mEffectFilter;
    if (paramString == null) {
      return;
    }
    paramString.needFlipBlend = true;
    paramString.setSrcFilterIndex(-1);
    this.mEffectFilter.applyFilterChain(true, 1.0F, 1.0F);
  }
  
  public void clear()
  {
    Object localObject = this.mVideoDecoder;
    if (localObject != null)
    {
      ((AEDecoder)localObject).release();
      this.mVideoDecoder = null;
    }
    localObject = this.alphaFilter;
    if (localObject != null)
    {
      ((VideoShelfAlphaFilter)localObject).clearGLSLSelf();
      this.alphaFilter = null;
    }
    localObject = this.mergeFilter;
    if (localObject != null)
    {
      ((VideoShelfMergeFilter)localObject).clearGLSLSelf();
      this.mergeFilter = null;
    }
    localObject = this.mEffectFilter;
    if (localObject != null) {
      ((BaseFilter)localObject).clearGLSLSelf();
    }
    this.effectFilterFrame.clear();
    this.mAlphaFrame.clear();
    localObject = this.mergeFrame;
    if (localObject != null) {
      ((Frame)localObject).clear();
    }
  }
  
  public Frame draw()
  {
    Object localObject = this.alphaFilter;
    if ((localObject != null) && (this.mergeFilter != null))
    {
      ((VideoShelfAlphaFilter)localObject).updateVideoTemplateType(this.mVideoTemplateType);
      this.alphaFilter.RenderProcess(this.mDecodeTexture, this.canvasW, this.canvasH, -1, 0.0D, this.mAlphaFrame);
      localObject = this.mAlphaFrame;
      this.mergeFilter.update(this.mFrameIndex);
      this.mergeFrame = this.mergeFilter.updateAndRender(((Frame)localObject).getTextureId(), this.canvasW, this.canvasH);
      Frame localFrame = this.mergeFrame;
      BaseFilter localBaseFilter = this.mEffectFilter;
      localObject = localFrame;
      if (localBaseFilter != null)
      {
        localBaseFilter.RenderProcess(localFrame.getTextureId(), this.canvasW, this.canvasH, -1, 0.0D, this.effectFilterFrame);
        localObject = this.effectFilterFrame;
      }
      GLES20.glFinish();
      return localObject;
    }
    return null;
  }
  
  public long getCurFrameTimeStamp()
  {
    if (this.mFrameIndex < this.mFrameStamps.size()) {
      return ((Long)this.mFrameStamps.get(this.mFrameIndex)).longValue();
    }
    return 0L;
  }
  
  public int getProgress()
  {
    long l = ((Long)this.mFrameStamps.get(this.mFrameIndex)).longValue();
    List localList = this.mFrameStamps;
    int i = (int)(l * 100L / ((Long)localList.get(localList.size() - 1)).longValue());
    if (i > 1) {
      return i;
    }
    return 1;
  }
  
  public void init(int[] paramArrayOfInt, List<VideoFrameItem> paramList, List<NodeGroup> paramList1)
  {
    this.mDecodeTexture = paramArrayOfInt[0];
    if (!TextUtils.isEmpty(this.mLutPath)) {
      initLutFilter(this.mLutPath);
    }
    this.alphaFilter = new VideoShelfAlphaFilter();
    this.alphaFilter.ApplyGLSLFilter();
    this.mergeFilter = new VideoShelfMergeFilter(paramList, paramList1);
    this.mergeFilter.ApplyGLSLFilter();
    this.mFrameStamps = VideoUtil.getFramestamps(this.mInputVideo);
    paramArrayOfInt = this.mFrameStamps;
    if (paramArrayOfInt != null) {
      Collections.sort(paramArrayOfInt);
    }
    this.mVideoDecoder = AECoderFactory.createDecoder(this.mInputVideo);
    this.mVideoDecoder.setTexture(this.mDecodeTexture);
    this.mFrameIndex = 0;
  }
  
  public int isPrepareInit()
  {
    File localFile = new File(this.mInputVideo);
    if ((!TextUtils.isEmpty(this.mInputVideo)) && (localFile.exists())) {
      return 0;
    }
    return 1;
  }
  
  public int parseFrame()
  {
    AEDecoder localAEDecoder = this.mVideoDecoder;
    if (localAEDecoder != null) {
      return localAEDecoder.getNextFrameTexture();
    }
    return -1;
  }
  
  public void setParam(String paramString, Object paramObject)
  {
    int i = paramString.hashCode();
    if (i != -1549738368)
    {
      switch (i)
      {
      default: 
        break;
      case -825523118: 
        if (!paramString.equals("WeSeeVideoShelfProcessor_3")) {
          break;
        }
        i = 3;
        break;
      case -825523119: 
        if (!paramString.equals("WeSeeVideoShelfProcessor_2")) {
          break;
        }
        i = 1;
        break;
      case -825523120: 
        if (!paramString.equals("WeSeeVideoShelfProcessor_1")) {
          break;
        }
        i = 0;
        break;
      }
    }
    else if (paramString.equals("outVideoWidthHeight"))
    {
      i = 2;
      break label101;
    }
    i = -1;
    label101:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          if ((paramObject != null) && ((paramObject instanceof Integer))) {
            this.mVideoTemplateType = ((Integer)paramObject).intValue();
          }
        }
        else if ((paramObject != null) && ((paramObject instanceof int[])))
        {
          paramString = (int[])paramObject;
          this.canvasW = paramString[0];
          this.canvasH = paramString[1];
        }
      }
      else if ((paramObject != null) && ((paramObject instanceof String))) {
        this.mLutPath = ((String)paramObject);
      }
    }
    else if ((paramObject != null) && ((paramObject instanceof String))) {
      this.mInputVideo = ((String)paramObject);
    }
  }
  
  public boolean updateFrameCursor()
  {
    if (this.mFrameIndex < this.mFrameStamps.size() - 2)
    {
      this.mFrameIndex += 1;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.processor.WeSeeVideoShelfProcessor
 * JD-Core Version:    0.7.0.1
 */