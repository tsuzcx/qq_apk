package com.tencent.open.downloadnew;

import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.open.business.base.StaticAnalyz;

class MyAppApi$10
  implements Runnable
{
  MyAppApi$10(MyAppApi paramMyAppApi, String paramString1, String paramString2) {}
  
  public void run()
  {
    StaticAnalyz.a("100", StaticAnalyz.a(this.a, "NEWYYB"), this.b);
    ControlPolicyUtil.j();
    if (("ANDROID.QQ.YYBXZGAMECENTER".equals(this.a)) || ("ANDROID.QQ.NEWYYBXZGAMECENTER".equals(this.a))) {
      GameCenterUtils.a(null, "765", "205008", this.b, "76501", "1", "156");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.10
 * JD-Core Version:    0.7.0.1
 */