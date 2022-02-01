package com.tencent.tkd.topicsdk.ucrop.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.tkd.topicsdk.common.CompressUtils;
import com.tencent.tkd.topicsdk.ucrop.callback.BitmapCropCallback;
import com.tencent.tkd.topicsdk.ucrop.model.ImageState;
import com.tencent.tkd.topicsdk.ucrop.util.BitmapUtils;
import java.io.File;

class CropImageView$1
  implements Runnable
{
  CropImageView$1(CropImageView paramCropImageView, Bitmap paramBitmap, ImageState paramImageState, String paramString, Bitmap.CompressFormat paramCompressFormat, int paramInt, BitmapCropCallback paramBitmapCropCallback) {}
  
  public void run()
  {
    Bitmap localBitmap = BitmapUtils.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ComTencentTkdTopicsdkUcropModelImageState.a(), this.jdField_a_of_type_ComTencentTkdTopicsdkUcropModelImageState.b(), this.jdField_a_of_type_ComTencentTkdTopicsdkUcropModelImageState.a());
    boolean bool2 = true;
    int i;
    if (localBitmap != null) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject = new File(this.jdField_a_of_type_JavaLangString);
    boolean bool1;
    if (!((File)localObject).exists()) {
      bool1 = ((File)localObject).mkdirs();
    } else {
      bool1 = true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".jpg");
    localObject = ((StringBuilder)localObject).toString();
    int j;
    if ((i != 0) && (CompressUtils.a(localBitmap, (String)localObject, this.jdField_a_of_type_AndroidGraphicsBitmap$CompressFormat, this.jdField_a_of_type_Int) == 0)) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i != 0) && (bool1) && (j != 0)) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    CropImageView.a(this.this$0, (String)localObject, bool1, this.jdField_a_of_type_ComTencentTkdTopicsdkUcropCallbackBitmapCropCallback);
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      localBitmap.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.view.CropImageView.1
 * JD-Core Version:    0.7.0.1
 */