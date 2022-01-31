package com.tencent.qqconnect.wtlogin;

import com.tencent.mobileqq.activity.AuthDevUgActivity;
import com.tencent.qphone.base.util.QLog;

public class AuthDevUgActivity2
  extends AuthDevUgActivity
{
  public void a()
  {
    QLog.d("Q.devlock.AuthDevUgActivity2", 1, "opensdk beforeOpenBrowser do nothing");
  }
  
  public void b()
  {
    QLog.d("Q.devlock.AuthDevUgActivity2", 1, "opensdk afterOpenBrowser do finish");
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.AuthDevUgActivity2
 * JD-Core Version:    0.7.0.1
 */