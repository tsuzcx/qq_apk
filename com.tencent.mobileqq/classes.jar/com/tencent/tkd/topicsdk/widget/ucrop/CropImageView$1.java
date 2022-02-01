package com.tencent.tkd.topicsdk.widget.ucrop;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.common.BitmapUtils;
import com.tencent.tkd.topicsdk.interfaces.IStorageConfig;
import com.tencent.tkd.topicsdk.widget.ucrop.callback.CropCallback;
import com.tencent.tkd.topicsdk.widget.ucrop.model.ImageState;
import java.io.File;

class CropImageView$1
  implements Runnable
{
  CropImageView$1(CropImageView paramCropImageView, Bitmap paramBitmap, ImageState paramImageState, Bitmap.CompressFormat paramCompressFormat, int paramInt, CropCallback paramCropCallback) {}
  
  public void run()
  {
    boolean bool2 = true;
    Bitmap localBitmap = BitmapUtils.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetUcropModelImageState.a(), this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetUcropModelImageState.b(), this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetUcropModelImageState.a());
    int i;
    String str;
    File localFile;
    if (localBitmap != null)
    {
      i = 1;
      str = TopicSDK.b().a().a().c();
      localFile = new File(str);
      if (localFile.exists()) {
        break label179;
      }
    }
    label179:
    for (boolean bool1 = localFile.mkdirs();; bool1 = true)
    {
      str = str + System.currentTimeMillis() + ".jpg";
      if ((i != 0) && (bool1) && (BitmapUtils.a(localBitmap, this.jdField_a_of_type_AndroidGraphicsBitmap$CompressFormat, this.jdField_a_of_type_Int, str))) {}
      for (bool1 = bool2;; bool1 = false)
      {
        CropImageView.a(this.this$0, str, bool1, this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetUcropCallbackCropCallback);
        if ((localBitmap != null) && (!localBitmap.isRecycled())) {
          localBitmap.recycle();
        }
        return;
        i = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.ucrop.CropImageView.1
 * JD-Core Version:    0.7.0.1
 */