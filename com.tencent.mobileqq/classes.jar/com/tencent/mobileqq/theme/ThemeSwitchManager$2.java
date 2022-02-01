package com.tencent.mobileqq.theme;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ThemeSwitchManager$2
  extends Handler
{
  ThemeSwitchManager$2(ThemeSwitchManager paramThemeSwitchManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Activity localActivity;
    if ((this.a.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
    {
      localActivity = null;
      if (localActivity != null) {
        break label75;
      }
      QLog.d("ThemeSwitchManager", 2, "handleMessage activity is not TitleBarActivity, , what=" + paramMessage.what);
    }
    label75:
    do
    {
      return;
      localActivity = (Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      break;
      switch (paramMessage.what)
      {
      default: 
        return;
      }
    } while ((localActivity.isFinishing()) || ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(localActivity, ((BaseActivity)localActivity).getTitleBarHeight());
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131719680);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    return;
    this.a.c();
    QQToast.a(localActivity, HardCodeUtil.a(2131714800), 4000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitchManager.2
 * JD-Core Version:    0.7.0.1
 */