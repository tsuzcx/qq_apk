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
  private static final String TAG = ImagePreLoader3D.class.getSimpleName();
  
  public ImagePreLoader3D(Map<String, Bitmap> paramMap, String paramString, StickerItem paramStickerItem, int paramInt)
  {
    super(paramMap, paramString, paramStickerItem, paramInt);
  }
  
  public void clear() {}
  
  public void preloadNewImages(int paramInt)
  {
    this.frontIndex = paramInt;
    this.rearIndex = ((this.frontIndex + this.capacity) % this.item.frames);
    paramInt = this.frontIndex;
    if (paramInt != this.rearIndex)
    {
      Object localObject2 = this.item.id + "_" + paramInt + ".png";
      Object localObject1;
      if (TextUtils.isEmpty(this.materialId))
      {
        localObject1 = localObject2;
        label86:
        if (!this.cache.containsKey(localObject1)) {
          break label145;
        }
      }
      for (;;)
      {
        paramInt = (paramInt + 1) % this.item.frames;
        break;
        localObject1 = this.materialId + File.separator + (String)localObject2;
        break label86;
        label145:
        localObject2 = this.dataPath + File.separator + this.item.subFolder + File.separator + (String)localObject2;
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
    if ((i < this.capacity) && (i < this.item.frames))
    {
      String str = this.item.id + "_" + i + ".png";
      Object localObject = this.dataPath + File.separator + this.item.subFolder + File.separator + str;
      localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
      if (TextUtils.isEmpty(this.materialId)) {}
      for (;;)
      {
        if ((BitmapUtils.isLegal((Bitmap)localObject)) && (!this.cache.containsKey(str))) {
          this.cache.put(str, localObject);
        }
        this.rearIndex = i;
        i += 1;
        break;
        str = this.materialId + File.separator + str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.cache.ImagePreLoader3D
 * JD-Core Version:    0.7.0.1
 */