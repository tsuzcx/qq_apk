package com.tencent.mobileqq.c2cshortcutbar;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class C2CAppShortcutBarHelper$2
  extends C2CShortcutBarObserver
{
  C2CAppShortcutBarHelper$2(C2CAppShortcutBarHelper paramC2CAppShortcutBarHelper) {}
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (C2CAppShortcutBarHelper.a(this.a) != paramLong) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarObserver", 2, "onRecieveNewC2CShortcutAppListPush");
    }
    if (paramBoolean) {
      C2CAppShortcutBarHelper.d(this.a);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, List<C2CShortcutAppInfo> paramList)
  {
    if (C2CAppShortcutBarHelper.a(this.a) != paramLong) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarObserver", 2, "C2CShortcutBarAIOHelper onRequestC2cShortcutAppList");
    }
    if (paramBoolean)
    {
      paramList = C2CShortcutBarManager.a((QQAppInterface)C2CAppShortcutBarHelper.b(this.a)).c(Long.valueOf(paramLong));
      C2CAppShortcutBarHelper.c(this.a).a(paramList);
      this.a.m();
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (C2CAppShortcutBarHelper.e(this.a) != null)
    {
      if (TextUtils.isEmpty(C2CAppShortcutBarHelper.f(this.a).b)) {
        return;
      }
      if ((paramBoolean1) && (C2CAppShortcutBarHelper.g(this.a).b.equals(paramString)))
      {
        if (paramBoolean2)
        {
          this.a.m();
          C2CAppShortcutBarHelper.d(this.a);
          return;
        }
        this.a.o();
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSetGlobalSwitcherStatus isSuccess = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",isGlobalOpen = ");
      localStringBuilder.append(paramBoolean2);
      QLog.d("C2CShortcutBarObserver", 2, localStringBuilder.toString());
    }
    if ((paramBoolean1) && (!paramBoolean2)) {
      this.a.o();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CAppShortcutBarHelper.2
 * JD-Core Version:    0.7.0.1
 */