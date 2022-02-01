package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import com.tencent.qphone.base.util.QLog;

final class ReadInJoyCommentPBModule$12
  implements IBitmapCallback
{
  ReadInJoyCommentPBModule$12(String paramString) {}
  
  public void a(ImageRequest paramImageRequest, int paramInt) {}
  
  public void a(ImageRequest paramImageRequest, ICloseableBitmap paramICloseableBitmap)
  {
    paramImageRequest = new StringBuilder();
    paramImageRequest.append("preload success ");
    paramImageRequest.append(this.a);
    QLog.d("ReadInJoyCommentPBModule", 2, paramImageRequest.toString());
  }
  
  public void a(ImageRequest paramImageRequest, Throwable paramThrowable)
  {
    paramImageRequest = new StringBuilder();
    paramImageRequest.append("preload failed ");
    paramImageRequest.append(this.a);
    QLog.e("ReadInJoyCommentPBModule", 2, paramImageRequest.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentPBModule.12
 * JD-Core Version:    0.7.0.1
 */