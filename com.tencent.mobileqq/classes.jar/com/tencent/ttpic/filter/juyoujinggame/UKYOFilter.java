package com.tencent.ttpic.filter.juyoujinggame;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.util.PTFaceLogUtil;
import java.io.File;
import java.util.List;

public class UKYOFilter
  extends NormalVideoFilter
{
  private static final String TAG = "UKYOFilter";
  private String mImageID;
  
  public UKYOFilter(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
    this.mImageID = paramStickerItem.id;
  }
  
  protected int getNextFrame(int paramInt)
  {
    if (this.mImageID == null) {
      return this.tex[0];
    }
    Object localObject = VideoMemoryManager.getInstance().loadImage(this.mImageID, paramInt);
    int i;
    if ((localObject == null) && ((VideoMemoryManager.getInstance().isForceLoadFromSdCard()) || (!this.isImageReady) || (this.isRenderForBitmap)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FileUtils.genSeperateFileDir(this.dataPath));
      ((StringBuilder)localObject).append(this.item.subFolder);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.mImageID);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(".png");
      localObject = ((StringBuilder)localObject).toString();
      localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (BitmapUtils.isLegal((Bitmap)localObject))
    {
      BenchUtil.benchStart("normal loadTexture");
      try
      {
        GlUtil.loadTexture(this.tex[0], (Bitmap)localObject);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getNextFrame:loadTexture Exception:");
        localStringBuilder.append(localException.getMessage());
        PTFaceLogUtil.e("UKYOFilter", localStringBuilder.toString());
      }
      BenchUtil.benchEnd("normal loadTexture");
      if (i != 0) {
        ((Bitmap)localObject).recycle();
      } else {
        VideoMemoryManager.getInstance().recycleBitmap(this.mImageID, (Bitmap)localObject);
      }
      this.isImageReady = true;
      this.lastImageIndex = paramInt;
    }
    return this.tex[0];
  }
  
  public void setImageID(String paramString)
  {
    this.mImageID = paramString;
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat) {}
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      if ((this.item.isDisplacementMaterial()) && (paramObject.displacementMaskFrame != null) && (paramObject.displacementMaskFrame.getLastRenderTextureId() > 0))
      {
        addParam(new UniformParam.TextureParam("inputImageTexture5", paramObject.displacementMaskFrame.getLastRenderTextureId(), 33989));
        addParam(new UniformParam.FloatParam("useDisplacementMask", 1.0F));
      }
      else
      {
        addParam(new UniformParam.TextureParam("inputImageTexture5", 0, 33989));
        addParam(new UniformParam.FloatParam("useDisplacementMask", 0.0F));
      }
      updatePlayer(this.isFirstTriggered);
      int i = this.frameIndex;
      if (!needRenderTexture())
      {
        clearTextureParam();
        VideoMemoryManager.getInstance().reset(this.mImageID);
        updateTextureParam(0, paramObject.timestamp);
        return;
      }
      updatePositions(paramObject.facePoints, paramObject.faceAngles, paramObject.phoneAngle);
      updateTextureParam(i, paramObject.timestamp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOFilter
 * JD-Core Version:    0.7.0.1
 */