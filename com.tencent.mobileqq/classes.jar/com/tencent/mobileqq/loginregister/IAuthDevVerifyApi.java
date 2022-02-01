package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;

public abstract interface IAuthDevVerifyApi
{
  public abstract void a();
  
  public abstract void a(QBaseActivity paramQBaseActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView);
  
  public abstract boolean a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView);
  
  public abstract boolean a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView, String paramString);
  
  public abstract void b();
  
  public abstract boolean b(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.IAuthDevVerifyApi
 * JD-Core Version:    0.7.0.1
 */