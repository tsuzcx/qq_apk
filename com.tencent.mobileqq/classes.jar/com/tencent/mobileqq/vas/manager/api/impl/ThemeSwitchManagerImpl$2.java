package com.tencent.mobileqq.vas.manager.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ThemeSwitchManagerImpl$2
  extends Handler
{
  ThemeSwitchManagerImpl$2(ThemeSwitchManagerImpl paramThemeSwitchManagerImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject;
    if ((this.a.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      localObject = (Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMessage activity is not TitleBarActivity, , what=");
      ((StringBuilder)localObject).append(paramMessage.what);
      QLog.d("ThemeSwitchManager", 2, ((StringBuilder)localObject).toString());
      return;
    }
    int i = paramMessage.what;
    if (i != 200)
    {
      if (i == 201)
      {
        this.a.onPostThemeChanged();
        QQToast.a((Context)localObject, HardCodeUtil.a(2131714730), 4000).a();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unexpected value: ");
      ((StringBuilder)localObject).append(paramMessage.what);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    if ((!((Activity)localObject).isFinishing()) && ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog((Context)localObject, ((QBaseActivity)localObject).getTitleBarHeight());
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131719399);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.manager.api.impl.ThemeSwitchManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */