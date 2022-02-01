package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;

final class ScreenUtil$1
  implements Runnable
{
  ScreenUtil$1(View paramView, int paramInt) {}
  
  public void run()
  {
    Object localObject = (Activity)this.a.getContext();
    if (this.b == 1) {
      ((Activity)localObject).getWindow().addFlags(128);
    } else {
      ((Activity)localObject).getWindow().clearFlags(128);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SetKeepScreenOn :");
    ((StringBuilder)localObject).append(this.b);
    QLog.e("[cmshow]ScreenUtil", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.ScreenUtil.1
 * JD-Core Version:    0.7.0.1
 */