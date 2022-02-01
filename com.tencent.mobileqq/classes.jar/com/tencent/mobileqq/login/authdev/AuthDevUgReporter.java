package com.tencent.mobileqq.login.authdev;

import com.tencent.mobileqq.loginregister.LoginStaticField;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

public class AuthDevUgReporter
{
  private static volatile AuthDevUgReporter d;
  protected int a;
  protected int b;
  protected String c;
  
  public static AuthDevUgReporter a()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new AuthDevUgReporter();
        }
      }
      finally {}
    }
    return d;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.c = paramString;
    if (paramBoolean) {
      i = 3;
    } else {
      i = 0;
    }
    this.a = i;
    int i = LoginStaticField.a();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            this.b = 0;
            return;
          }
          this.b = 4;
          return;
        }
        this.b = 3;
        return;
      }
      this.b = 2;
      return;
    }
    this.b = 1;
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString)
  {
    ReportController.a(paramAppRuntime, "dc00898", "", this.c, paramString, paramString, this.a, 0, String.valueOf(this.b), "", "", this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.login.authdev.AuthDevUgReporter
 * JD-Core Version:    0.7.0.1
 */