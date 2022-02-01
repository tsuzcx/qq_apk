package com.tencent.open.appcommon.js;

import android.os.Bundle;
import com.tencent.open.downloadnew.MyAppApi;

class BaseJsCallBack$2
  implements Runnable
{
  BaseJsCallBack$2(BaseJsCallBack paramBaseJsCallBack, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    MyAppApi.l().a(this.this$0.activity, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.js.BaseJsCallBack.2
 * JD-Core Version:    0.7.0.1
 */