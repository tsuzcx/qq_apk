package com.tencent.mobileqq.phonecontact;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class ContactBindObserver
  implements BusinessObserver
{
  private void h(boolean paramBoolean, int paramInt)
  {
    b(paramBoolean, paramInt);
    if (paramBoolean) {
      d(true, 7);
    }
  }
  
  public String a(int paramInt)
  {
    if (paramInt == 217) {
      return "手机号码不正确，请确认！";
    }
    if ((paramInt == 219) || (paramInt == 216)) {
      return "请求频率太高，请稍后重试！";
    }
    if (paramInt == 224) {
      return "所属地区运营商暂未支持开通服务";
    }
    if (paramInt == 223) {
      return "绑定失败，请稍后再试";
    }
    return "请求失败，请稍候重试。";
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString) {}
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean, int paramInt) {}
  
  public void b(boolean paramBoolean, Bundle paramBundle) {}
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void c(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean, int paramInt) {}
  
  public void c(boolean paramBoolean, Bundle paramBundle) {}
  
  public void d(boolean paramBoolean) {}
  
  public void d(boolean paramBoolean, int paramInt) {}
  
  protected void e(boolean paramBoolean) {}
  
  public void e(boolean paramBoolean, int paramInt) {}
  
  protected void f(boolean paramBoolean) {}
  
  public void f(boolean paramBoolean, int paramInt) {}
  
  public void g(boolean paramBoolean, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int k = 0;
    int i = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int j = 0;
    switch (paramInt)
    {
    default: 
      return;
    case -1: 
      c(paramBoolean, paramBundle);
      return;
    case 12: 
      if (paramBoolean)
      {
        if (paramBundle.getBoolean("bind_state"))
        {
          a(true, true);
          return;
        }
        a(true, false);
        return;
      }
      a(false, false);
      return;
    case 35: 
      a(paramBoolean, paramBundle);
      return;
    case 14: 
      paramInt = j;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      b(paramBoolean, paramInt);
      return;
    case 15: 
      paramInt = k;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      a(paramBoolean, paramInt);
      return;
    case 28: 
      paramInt = i;
      if (paramBundle != null)
      {
        paramInt = i;
        if (paramBundle.getBoolean("hasUpdate")) {
          paramInt = 1;
        }
      }
      d(paramBoolean, paramInt);
      return;
    case 16: 
      if (paramBundle != null) {}
      for (paramInt = paramBundle.getInt("k_result");; paramInt = -1)
      {
        c(paramBoolean, paramInt);
        return;
      }
    case 17: 
      e(paramBoolean);
      return;
    case 19: 
      b(paramBoolean, paramBundle);
      return;
    case 20: 
      b(paramBoolean);
      return;
    case 23: 
      f(paramBoolean);
      return;
    case 26: 
      a(paramBoolean, paramBundle.getBoolean("bindOK"), paramBundle.getBoolean("hadBind"), paramBundle.getString("bindUin"));
      return;
    case 27: 
      b(paramBoolean, paramBundle.getBoolean("bind_state", false));
      return;
    case 31: 
      paramInt = m;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      h(paramBoolean, paramInt);
      return;
    case 30: 
      paramInt = n;
      if (paramBoolean) {
        paramInt = paramBundle.getInt("param_update_flag");
      }
      d(paramBoolean, paramInt);
      return;
    case 100: 
      a(paramBundle.getInt("current_percentage"), paramBundle.getInt("expected_percentage"));
      return;
    case 32: 
      d(paramBoolean);
      return;
    case 33: 
      c(paramBoolean);
      return;
    case 34: 
      a(paramBoolean);
      return;
    case 38: 
      paramInt = i1;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      f(paramBoolean, paramInt);
      return;
    case 37: 
      paramInt = i2;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      e(paramBoolean, paramInt);
      return;
    }
    paramInt = i3;
    if (paramBoolean) {
      paramInt = paramBundle.getInt("param_update_flag");
    }
    g(paramBoolean, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.ContactBindObserver
 * JD-Core Version:    0.7.0.1
 */