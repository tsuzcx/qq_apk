package com.tencent.mobileqq.teamwork;

import android.graphics.Bitmap;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class TeamWorkForceShare$2$1
  implements Runnable
{
  TeamWorkForceShare$2$1(TeamWorkForceShare.2 param2, String paramString, Bitmap paramBitmap) {}
  
  public void run()
  {
    TeamWorkForceShare.2.1.1 local1 = new TeamWorkForceShare.2.1.1(this);
    WXShareHelper.a().a(local1);
    TeamWorkForceShare.a(this.c.this$0, String.valueOf(System.currentTimeMillis()));
    WXShareHelper.a().a(this.a, this.b, 280, this.c.a ^ true, TeamWorkForceShare.e(this.c.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare.2.1
 * JD-Core Version:    0.7.0.1
 */