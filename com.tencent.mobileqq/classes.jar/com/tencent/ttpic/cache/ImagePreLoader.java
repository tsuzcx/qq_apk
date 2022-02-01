package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.io.File;
import java.util.Map;

public class ImagePreLoader
  extends PreLoader
{
  private static final String TAG = ImagePreLoader.class.getSimpleName();
  private String mMaterialId;
  
  public ImagePreLoader(Map<String, Bitmap> paramMap, String paramString, StickerItem paramStickerItem, int paramInt)
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
      Object localObject1 = FileUtils.genSeperateFileDir(this.mMaterialId) + (String)localObject2;
      if (this.mMaterialId == null)
      {
        if (TextUtils.isEmpty(this.materialId)) {
          localObject1 = localObject2;
        }
      }
      else {
        label118:
        if (!this.cache.containsKey(localObject1)) {
          break label177;
        }
      }
      for (;;)
      {
        paramInt = (paramInt + 1) % this.item.frames;
        break;
        localObject1 = this.materialId + File.separator + (String)localObject2;
        break label118;
        label177:
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
    Object localObject;
    String str;
    Bitmap localBitmap;
    if ((i < this.capacity) && (i < this.item.frames))
    {
      localObject = this.item.id + "_" + i + ".png";
      str = this.dataPath + File.separator + this.item.subFolder + File.separator + (String)localObject;
      localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), str, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
      str = FileUtils.genSeperateFileDir(this.mMaterialId) + (String)localObject;
      if (this.mMaterialId != null) {
        break label240;
      }
      if (!TextUtils.isEmpty(this.materialId)) {}
    }
    for (;;)
    {
      if ((BitmapUtils.isLegal(localBitmap)) && (!this.cache.containsKey(localObject))) {
        this.cache.put(localObject, localBitmap);
      }
      this.rearIndex = i;
      i += 1;
      break;
      localObject = this.materialId + File.separator + (String)localObject;
      continue;
      return;
      label240:
      localObject = str;
    }
  }
  
  public void setDIYMaterialId(String paramString)
  {
    this.mMaterialId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.cache.ImagePreLoader
 * JD-Core Version:    0.7.0.1
 */