package com.tencent.mobileqq.newnearby.util;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mtt.hippy.modules.Promise;

final class PickLocationHelper$2
  implements Runnable
{
  PickLocationHelper$2(String paramString, Activity paramActivity, Promise paramPromise) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(PickLocationHelper.b())) {
      return;
    }
    PickLocationHelper.c();
    PickLocationHelper.b(this.a);
    this.b.runOnUiThread(new PickLocationHelper.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.util.PickLocationHelper.2
 * JD-Core Version:    0.7.0.1
 */