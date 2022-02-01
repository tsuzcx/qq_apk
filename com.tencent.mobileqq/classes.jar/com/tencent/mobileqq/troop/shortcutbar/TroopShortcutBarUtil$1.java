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
      if (!this.jdField_a_of_type_Boolean) {
        ReportController.b(null, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B448", "0X800B448", 0, 0, String.valueOf(TroopShortcutBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString)), String.valueOf(this.jdField_a_of_type_Long), "1", "");
      } else {
        ReportController.b(null, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B448", "0X800B448", 0, 0, String.valueOf(TroopShortcutBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString)), String.valueOf(this.jdField_a_of_type_Long), "2", "");
      }
      if ((paramInt == 0) || (BaseActivity.sTopActivity == null)) {
        break label207;
      }
      if (paramInt == 41005)
      {
        if (this.jdField_a_of_type_Boolean) {
          QQToast.a(BaseActivity.sTopActivity, 1, BaseApplicationImpl.getContext().getResources().getString(2131720037), 0).a();
        }
      }
      else
      {
        if (paramInt != 41020) {
          break label296;
        }
        QQToast.a(BaseActivity.sTopActivity, 1, BaseApplicationImpl.getContext().getResources().getString(2131720038), 0).a();
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
    QQToast.a(BaseActivity.sTopActivity, 1, BaseApplicationImpl.getContext().getResources().getString(2131720039), 0).a();
    label207:
    paramString = (TroopShortcutBarHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
    if (paramString == null) {
      return;
    }
    localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject == null) {
      return;
    }
    localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_JavaLangString);
    if (localObject == null) {
      return;
    }
    paramString.a(Long.parseLong(this.jdField_a_of_type_JavaLangString), (int)((TroopInfo)localObject).dwGroupClassExt, new Long(this.jdField_a_of_type_Long));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarUtil.1
 * JD-Core Version:    0.7.0.1
 */