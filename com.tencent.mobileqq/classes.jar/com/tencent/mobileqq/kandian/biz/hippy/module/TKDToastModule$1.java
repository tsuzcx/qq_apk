package com.tencent.mobileqq.kandian.biz.hippy.module;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.modules.Promise;

class TKDToastModule$1
  implements Runnable
{
  TKDToastModule$1(TKDToastModule paramTKDToastModule, int paramInt1, String paramString, int paramInt2, Promise paramPromise) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getApplication(), TKDToastModule.access$000(this.this$0, this.val$type), this.val$message, this.val$duration).a();
    this.val$promise.resolve("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDToastModule.1
 * JD-Core Version:    0.7.0.1
 */