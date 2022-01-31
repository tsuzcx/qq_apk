package com.tencent.mobileqq.shortvideo.ptvfilter;

import android.graphics.Bitmap;
import com.tencent.filter.Param.TextureParam;
import com.tencent.ttpic.cache.ImageMemoryManager;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.filter.StaticStickerFilter;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;

public class StaticCountFilter
  extends StaticStickerFilter
{
  private int a = 0;
  
  public StaticCountFilter(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
  }
  
  private int a(int paramInt)
  {
    this.isImageReady = false;
    Object localObject = ImageMemoryManager.getInstance().loadImage(this.item.id, paramInt);
    if (localObject == null)
    {
      localObject = this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + "_" + paramInt + ".png";
      localObject = VideoBitmapUtil.decodeSampleBitmap(VideoGlobalContext.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if (VideoBitmapUtil.isLegal((Bitmap)localObject))
      {
        GlUtil.loadTexture(this.tex[0], (Bitmap)localObject);
        if (paramInt != 0) {
          ((Bitmap)localObject).recycle();
        }
        this.isImageReady = true;
      }
      return this.tex[0];
    }
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  protected void updateTextureParam(int paramInt, long paramLong)
  {
    paramInt = 0;
    if (this.item.id.equals("shi")) {
      paramInt = this.a / 10;
    }
    while (paramInt == this.lastImageIndex)
    {
      return;
      if (this.item.id.equals("ge")) {
        paramInt = this.a % 10;
      }
    }
    addParam(new Param.TextureParam("inputImageTexture2", a(paramInt), 33986));
    this.lastImageIndex = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.StaticCountFilter
 * JD-Core Version:    0.7.0.1
 */