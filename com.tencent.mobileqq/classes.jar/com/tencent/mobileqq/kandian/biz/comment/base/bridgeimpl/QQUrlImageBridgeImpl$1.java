package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import com.tencent.tkd.comment.publisher.qq.bridge.QQUrlImageBridge.Callback;

class QQUrlImageBridgeImpl$1
  implements IBitmapCallback
{
  QQUrlImageBridgeImpl$1(QQUrlImageBridgeImpl paramQQUrlImageBridgeImpl, QQUrlImageBridge.Callback paramCallback) {}
  
  public void a(ImageRequest paramImageRequest, int paramInt) {}
  
  public void a(ImageRequest paramImageRequest, ICloseableBitmap paramICloseableBitmap)
  {
    paramImageRequest = this.jdField_a_of_type_ComTencentTkdCommentPublisherQqBridgeQQUrlImageBridge$Callback;
    if (paramImageRequest != null) {
      paramImageRequest.onSuccess(paramICloseableBitmap.a());
    }
  }
  
  public void a(ImageRequest paramImageRequest, Throwable paramThrowable)
  {
    paramImageRequest = this.jdField_a_of_type_ComTencentTkdCommentPublisherQqBridgeQQUrlImageBridge$Callback;
    if (paramImageRequest != null) {
      paramImageRequest.onFail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQUrlImageBridgeImpl.1
 * JD-Core Version:    0.7.0.1
 */