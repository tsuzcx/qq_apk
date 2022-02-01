package com.tencent.mobileqq.dating;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.nearby.api.INearbyProcessMonitor;
import com.tencent.mobileqq.qroute.QRoute;

class MsgBoxListActivity$PreloadCallBack
  implements Handler.Callback
{
  private String a;
  
  public MsgBoxListActivity$PreloadCallBack(String paramString)
  {
    this.a = paramString;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 0) {
      return true;
    }
    ((INearbyProcessMonitor)QRoute.api(INearbyProcessMonitor.class)).startNearbyProcess(this.a, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxListActivity.PreloadCallBack
 * JD-Core Version:    0.7.0.1
 */