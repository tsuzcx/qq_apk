package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.io.File;
import java.util.Map;

public class ImagePreLoader3D
  extends PreLoader
{
  private static final String TAG = "ImagePreLoader3D";
  
  public ImagePreLoader3D(Map<String, Bitmap> paramMap, String paramString, StickerItem paramStickerItem, int paramInt)
  {
    super(paramMap, paramString, paramStickerItem, paramInt);
  }
  
  public void clear() {}
  
  public void preloadNewImages(int paramInt)
  {
    this.frontIndex = paramInt;
    this.rearIndex = ((this.frontIndex + this.capacity) % this.item.frames);
    for (paramInt = this.frontIndex; paramInt != this.rearIndex; paramInt = (paramInt + 1) % this.item.frames)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.item.id);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(".png");
      Object localObject2 = ((StringBuilder)localObject1).toString();
      if (TextUtils.isEmpty(this.materialId))
      {
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.materialId);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (!this.cache.containsKey(localObject1))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.dataPath);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(this.item.subFolder);
        localStringBuilder.append(File.separator);
        localStringBuilder.append((String)localObject2);
        localObject2 = localStringBuilder.toString();
        localObject2 = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject2, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
        if (BitmapUtils.isLegal((Bitmap)localObject2)) {
          this.cache.put(localObject1, localObject2);
        }
      }
    }
  }
  
  public void prepareImages()
  {
    int i = 0;
    this.frontIndex = 0;
    while ((i < this.capacity) && (i < this.item.frames))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.item.id);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(".png");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.dataPath);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(this.item.subFolder);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject2 = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject2, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
      if (!TextUtils.isEmpty(this.materialId))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.materialId);
        localStringBuilder.append(File.separator);
        localStringBuilder.append((String)localObject1);
        localObject1 = localStringBuilder.toString();
      }
      if ((BitmapUtils.isLegal((Bitmap)localObject2)) && (!this.cache.containsKey(localObject1))) {
        this.cache.put(localObject1, localObject2);
      }
      this.rearIndex = i;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.cache.ImagePreLoader3D
 * JD-Core Version:    0.7.0.1
 */