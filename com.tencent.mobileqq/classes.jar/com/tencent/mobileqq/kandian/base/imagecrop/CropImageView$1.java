package com.tencent.mobileqq.kandian.base.imagecrop;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.kandian.base.imagecrop.callback.CropCallback;
import com.tencent.mobileqq.kandian.base.imagecrop.model.ImageState;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.io.File;

class CropImageView$1
  implements Runnable
{
  CropImageView$1(CropImageView paramCropImageView, Bitmap paramBitmap, ImageState paramImageState, Bitmap.CompressFormat paramCompressFormat, int paramInt, CropCallback paramCropCallback) {}
  
  public void run()
  {
    Bitmap localBitmap = BitmapUtils.a(this.a, this.b.a(), this.b.b(), this.b.c());
    boolean bool = true;
    int i;
    if (localBitmap != null) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(URLDrawableHelper.diskCachePath);
    ((StringBuilder)localObject).append(File.separator);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CropImageView");
    localStringBuilder.append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(AbsDownloader.getFileName(localStringBuilder.toString()));
    localObject = ((StringBuilder)localObject).toString();
    if ((i == 0) || (!BitmapUtils.a(localBitmap, this.c, this.d, (String)localObject))) {
      bool = false;
    }
    CropImageView.a(this.this$0, (String)localObject, bool, this.e);
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      localBitmap.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.CropImageView.1
 * JD-Core Version:    0.7.0.1
 */