package com.tencent.mobileqq.utils;

import android.os.Handler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.ThreadManagerV2;

final class VipUtils$3
  implements Runnable
{
  VipUtils$3(FriendsManager paramFriendsManager, String paramString, VipUtils.UpdateRecentEfficientVipIconTask paramUpdateRecentEfficientVipIconTask) {}
  
  public void run()
  {
    this.a.m(this.b);
    ThreadManagerV2.getUIHandlerV2().post(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.3
 * JD-Core Version:    0.7.0.1
 */