package com.tencent.mobileqq.dating;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.nearby.NearbyProcessMonitor;

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
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    NearbyProcessMonitor.a(this.a, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxListActivity.PreloadCallBack
 * JD-Core Version:    0.7.0.1
 */