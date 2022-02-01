package com.tencent.open.agent;

import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;

class DeviceFriendListOpenFrame$1
  extends Handler
{
  DeviceFriendListOpenFrame$1(DeviceFriendListOpenFrame paramDeviceFriendListOpenFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        this.a.c.notifyDataSetChanged();
        return;
      }
      this.a.f.setPadding(0, 0, 0, 0);
      return;
    }
    this.a.f.setPadding(0, 0, 40, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.DeviceFriendListOpenFrame.1
 * JD-Core Version:    0.7.0.1
 */