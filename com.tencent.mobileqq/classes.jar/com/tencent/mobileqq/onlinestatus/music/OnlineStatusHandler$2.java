package com.tencent.mobileqq.onlinestatus.music;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQToast;

class OnlineStatusHandler$2
  implements Runnable
{
  OnlineStatusHandler$2(OnlineStatusHandler paramOnlineStatusHandler) {}
  
  public void run()
  {
    QQToast.makeText(OnlineStatusHandler.a(this.this$0).getApp(), 1, "“我的位置” 切换失败，请重试。", 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler.2
 * JD-Core Version:    0.7.0.1
 */