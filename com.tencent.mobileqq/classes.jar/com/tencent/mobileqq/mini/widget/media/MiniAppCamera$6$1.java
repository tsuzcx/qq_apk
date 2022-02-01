package com.tencent.mobileqq.mini.widget.media;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.qphone.base.util.QLog;
import zmv;

class MiniAppCamera$6$1
  implements zmv
{
  MiniAppCamera$6$1(MiniAppCamera.6 param6) {}
  
  public void onFailure(String paramString)
  {
    QLog.i("MiniAppCamera", 2, "compress failed " + paramString);
    MiniAppCamera.access$500(this.this$1.this$0, this.this$1.val$srcPath, this.this$1.val$wc, this.this$1.val$event, this.this$1.val$callBackId);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    QLog.i("MiniAppCamera", 2, "compress finish " + paramBoolean);
    this.this$1.val$wc.hideLoading();
  }
  
  public void onProgress(String paramString)
  {
    QLog.i("MiniAppCamera", 2, "compress progress " + paramString);
  }
  
  public void onStart()
  {
    QLog.i("MiniAppCamera", 2, "compress start");
  }
  
  public void onSuccess(String paramString)
  {
    QLog.i("MiniAppCamera", 2, "compress success " + paramString);
    MiniAppCamera.access$500(this.this$1.this$0, this.this$1.val$outPath, this.this$1.val$wc, this.this$1.val$event, this.this$1.val$callBackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppCamera.6.1
 * JD-Core Version:    0.7.0.1
 */