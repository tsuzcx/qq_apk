package com.tencent.mobileqq.quicklogin;

import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.quicklogin.business.QuickLoginHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class ClosePCVerifyImpl
  implements ClosePCVerifyInterface
{
  private static volatile ClosePCVerifyImpl jdField_a_of_type_ComTencentMobileqqQuickloginClosePCVerifyImpl;
  private ClosePCVerifyProxy jdField_a_of_type_ComTencentMobileqqQuickloginClosePCVerifyProxy;
  
  public static ClosePCVerifyImpl a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQuickloginClosePCVerifyImpl == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqQuickloginClosePCVerifyImpl == null) {
        jdField_a_of_type_ComTencentMobileqqQuickloginClosePCVerifyImpl = new ClosePCVerifyImpl();
      }
      return jdField_a_of_type_ComTencentMobileqqQuickloginClosePCVerifyImpl;
    }
    finally {}
  }
  
  private void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    try
    {
      QLog.d("ClosePCVerifyImpl", 1, "showCloseVerifyDialog");
      if ((paramQQAppInterface == null) || (paramBaseActivity == null))
      {
        QLog.e("ClosePCVerifyImpl", 1, "showCloseVerifyDialog error: params wrong");
        return;
      }
      paramBaseActivity = DialogUtil.a(paramBaseActivity, 230);
      paramBaseActivity.setMessage(2131698633);
      paramBaseActivity.setTitle(2131698636);
      paramBaseActivity.setNegativeButton(2131698631, new ClosePCVerifyImpl.1(this, paramBaseActivity));
      paramBaseActivity.setPositiveButton(2131698632, new ClosePCVerifyImpl.2(this, paramQQAppInterface, paramBaseActivity));
      if (!paramBaseActivity.isShowing())
      {
        paramBaseActivity.show();
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ClosePCVerifyImpl", 1, "showCloseVerifyDialog error: " + paramQQAppInterface.getMessage());
    }
  }
  
  private boolean a(String paramString, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    return (TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null) || (paramBaseActivity == null);
  }
  
  public SpannableString a(String paramString, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    try
    {
      QLog.d("ClosePCVerifyImpl", 1, "getClosePCVerifySpannable subTips: " + paramString);
      if (a(paramString, paramQQAppInterface, paramBaseActivity))
      {
        QLog.e("ClosePCVerifyImpl", 1, "getClosePCVerifySpannable error: params wrong");
        return new SpannableString("");
      }
      String str = paramBaseActivity.getString(2131698630);
      paramString = paramString + str;
      int i = paramString.indexOf(str);
      paramString = new SpannableString(paramString);
      paramString.setSpan(new ClosePCVerifyImpl.ClosePCVerifyClickableSpan(this, new WeakReference(paramQQAppInterface), new WeakReference(paramBaseActivity)), i, str.length() + i, 33);
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("ClosePCVerifyImpl", 1, "getClosePCVerifySpannable error: " + paramString.getMessage());
    }
    return new SpannableString("");
  }
  
  public void a()
  {
    QLog.d("ClosePCVerifyImpl", 1, "removeObserver");
    this.jdField_a_of_type_ComTencentMobileqqQuickloginClosePCVerifyProxy = null;
  }
  
  public void a(ClosePCVerifyProxy paramClosePCVerifyProxy)
  {
    QLog.d("ClosePCVerifyImpl", 1, "addObserver");
    this.jdField_a_of_type_ComTencentMobileqqQuickloginClosePCVerifyProxy = paramClosePCVerifyProxy;
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    QuickLoginHandler localQuickLoginHandler;
    try
    {
      QLog.d("ClosePCVerifyImpl", 1, "requestSetPCVerify isSwitchOn: " + paramBoolean);
      if (paramQQAppInterface == null)
      {
        QLog.e("ClosePCVerifyImpl", 1, "requestSetPCVerify error: appInterface == null");
        return;
      }
      localQuickLoginHandler = (QuickLoginHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QUICK_LOGIN);
      if (localQuickLoginHandler == null)
      {
        QLog.e("ClosePCVerifyImpl", 1, "requestSetPCVerify error: handler == null");
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ClosePCVerifyImpl", 1, "requestSetPCVerify error: " + paramQQAppInterface.getMessage());
      return;
    }
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    ClosePCVerifyImpl.ClosePCVerifyQuickLoginObserver localClosePCVerifyQuickLoginObserver = new ClosePCVerifyImpl.ClosePCVerifyQuickLoginObserver(l, new WeakReference(localHashMap), new WeakReference(paramQQAppInterface), new WeakReference(this.jdField_a_of_type_ComTencentMobileqqQuickloginClosePCVerifyProxy));
    QLog.d("ClosePCVerifyImpl", 1, "wrapper.put");
    localHashMap.put(Long.valueOf(l), localClosePCVerifyQuickLoginObserver);
    QLog.d("ClosePCVerifyImpl", 1, "appInterface.addObserver");
    paramQQAppInterface.addObserver(localClosePCVerifyQuickLoginObserver);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localQuickLoginHandler.a(i, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.quicklogin.ClosePCVerifyImpl
 * JD-Core Version:    0.7.0.1
 */