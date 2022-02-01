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
  private static final String TAG = "ImagePreLoader";
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
    for (paramInt = this.frontIndex; paramInt != this.rearIndex; paramInt = (paramInt + 1) % this.item.frames)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.item.id);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(".png");
      Object localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(FileUtils.genSeperateFileDir(this.mMaterialId));
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
      if (this.mMaterialId == null) {
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.item.id);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(".png");
      String str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.dataPath);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.item.subFolder);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
      Bitmap localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FileUtils.genSeperateFileDir(this.mMaterialId));
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
      if (this.mMaterialId == null) {
        if (TextUtils.isEmpty(this.materialId))
        {
          localObject = str;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.materialId);
          ((StringBuilder)localObject).append(File.separator);
          ((StringBuilder)localObject).append(str);
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      if ((BitmapUtils.isLegal(localBitmap)) && (!this.cache.containsKey(localObject))) {
        this.cache.put(localObject, localBitmap);
      }
      this.rearIndex = i;
      i += 1;
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