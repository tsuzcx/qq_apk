package com.tencent.mobileqq.onlinestatus.music;

import azff;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class OnlineStatusHandler$1
  implements Runnable
{
  public OnlineStatusHandler$1(azff paramazff) {}
  
  public void run()
  {
    QQToast.a(this.this$0.app.getApp(), 1, "“我的位置” 切换失败，请重试。", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler.1
 * JD-Core Version:    0.7.0.1
 */