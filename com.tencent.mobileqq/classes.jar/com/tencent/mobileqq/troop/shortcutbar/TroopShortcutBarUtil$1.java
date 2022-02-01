package com.tencent.mobileqq.troop.shortcutbar;

import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopapps.AddTroopAppCgi.CgiCallBack;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class TroopShortcutBarUtil$1
  implements AddTroopAppCgi.CgiCallBack
{
  TroopShortcutBarUtil$1(boolean paramBoolean, String paramString, QQAppInterface paramQQAppInterface, long paramLong) {}
  
  private void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {}
    try
    {
      if (!this.a) {
        ReportController.b(null, "dc00898", "", this.b, "0X800B448", "0X800B448", 0, 0, String.valueOf(TroopShortcutBarUtil.b(this.c, this.b)), String.valueOf(this.d), "1", "");
      } else {
        ReportController.b(null, "dc00898", "", this.b, "0X800B448", "0X800B448", 0, 0, String.valueOf(TroopShortcutBarUtil.b(this.c, this.b)), String.valueOf(this.d), "2", "");
      }
      if ((paramInt == 0) || (BaseActivity.sTopActivity == null)) {
        break label207;
      }
      if (paramInt == 41005)
      {
        if (this.a) {
          QQToast.makeText(BaseActivity.sTopActivity, 1, BaseApplicationImpl.getContext().getResources().getString(2131917658), 0).show();
        }
      }
      else
      {
        if (paramInt != 41020) {
          break label296;
        }
        QQToast.makeText(BaseActivity.sTopActivity, 1, BaseApplicationImpl.getContext().getResources().getString(2131917659), 0).show();
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject;
        continue;
        if ((paramInt != 41004) && (paramInt != 41005)) {
          if (paramInt != 41012) {}
        }
      }
    }
    QQToast.makeText(BaseActivity.sTopActivity, 1, BaseApplicationImpl.getContext().getResources().getString(2131917660), 0).show();
    label207:
    paramString = (TroopShortcutBarHandler)this.c.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
    if (paramString == null) {
      return;
    }
    localObject = (TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject == null) {
      return;
    }
    localObject = ((TroopManager)localObject).f(this.b);
    if (localObject == null) {
      return;
    }
    paramString.a(Long.parseLong(this.b), (int)((TroopInfo)localObject).dwGroupClassExt, new Long(this.d));
    return;
    paramString.printStackTrace();
  }
  
  public void a(int paramInt, String paramString, Object paramObject)
  {
    a(paramInt, paramString);
  }
  
  public void a(Object paramObject)
  {
    a(0, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarUtil.1
 * JD-Core Version:    0.7.0.1
 */