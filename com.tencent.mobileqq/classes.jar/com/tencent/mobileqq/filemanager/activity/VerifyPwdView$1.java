package com.tencent.mobileqq.filemanager.activity;

import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

class VerifyPwdView$1
  extends FMObserver
{
  VerifyPwdView$1(VerifyPwdView paramVerifyPwdView) {}
  
  public void a(int paramInt, String paramString)
  {
    FMToastUtil.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      VerifyPwdView.a(this.a);
      return;
    }
    VerifyPwdView.b(this.a);
  }
  
  public void b(int paramInt, String paramString)
  {
    FMToastUtil.a(paramString);
    VerifyPwdView.c(this.a);
  }
  
  public void e()
  {
    VerifyPwdView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.VerifyPwdView.1
 * JD-Core Version:    0.7.0.1
 */