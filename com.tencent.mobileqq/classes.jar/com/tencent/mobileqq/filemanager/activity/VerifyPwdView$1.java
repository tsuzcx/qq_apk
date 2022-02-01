package com.tencent.mobileqq.filemanager.activity;

import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

class VerifyPwdView$1
  extends FMObserver
{
  VerifyPwdView$1(VerifyPwdView paramVerifyPwdView) {}
  
  protected void a(int paramInt, String paramString)
  {
    FMToastUtil.a(paramString);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      VerifyPwdView.a(this.a);
      return;
    }
    VerifyPwdView.b(this.a);
  }
  
  protected void b(int paramInt, String paramString)
  {
    FMToastUtil.a(paramString);
    VerifyPwdView.c(this.a);
  }
  
  protected void e()
  {
    VerifyPwdView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.VerifyPwdView.1
 * JD-Core Version:    0.7.0.1
 */