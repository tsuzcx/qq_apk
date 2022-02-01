package com.tencent.mobileqq.quicklogin;

import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
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
  private static volatile ClosePCVerifyImpl a;
  private ClosePCVerifyProxy b;
  
  public static ClosePCVerifyImpl a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ClosePCVerifyImpl();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    try
    {
      QLog.d("ClosePCVerifyImpl", 1, "showCloseVerifyDialog");
      if ((paramBaseQQAppInterface != null) && (paramQBaseActivity != null))
      {
        paramQBaseActivity = DialogUtil.a(paramQBaseActivity, 230);
        paramQBaseActivity.setMessage(2131896657);
        paramQBaseActivity.setTitle(2131896660);
        paramQBaseActivity.setNegativeButton(2131896655, new ClosePCVerifyImpl.1(this, paramQBaseActivity));
        paramQBaseActivity.setPositiveButton(2131896656, new ClosePCVerifyImpl.2(this, paramBaseQQAppInterface, paramQBaseActivity));
        if (!paramQBaseActivity.isShowing()) {
          paramQBaseActivity.show();
        }
      }
      else
      {
        QLog.e("ClosePCVerifyImpl", 1, "showCloseVerifyDialog error: params wrong");
        return;
      }
    }
    catch (Exception paramBaseQQAppInterface)
    {
      paramQBaseActivity = new StringBuilder();
      paramQBaseActivity.append("showCloseVerifyDialog error: ");
      paramQBaseActivity.append(paramBaseQQAppInterface.getMessage());
      QLog.e("ClosePCVerifyImpl", 1, paramQBaseActivity.toString());
    }
  }
  
  private boolean b(String paramString, BaseQQAppInterface paramBaseQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    return (TextUtils.isEmpty(paramString)) || (paramBaseQQAppInterface == null) || (paramQBaseActivity == null);
  }
  
  public SpannableString a(String paramString, BaseQQAppInterface paramBaseQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getClosePCVerifySpannable subTips: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ClosePCVerifyImpl", 1, ((StringBuilder)localObject).toString());
      if (b(paramString, paramBaseQQAppInterface, paramQBaseActivity))
      {
        QLog.e("ClosePCVerifyImpl", 1, "getClosePCVerifySpannable error: params wrong");
        return new SpannableString("");
      }
      localObject = paramQBaseActivity.getString(2131896654);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append((String)localObject);
      paramString = localStringBuilder.toString();
      int i = paramString.indexOf((String)localObject);
      paramString = new SpannableString(paramString);
      paramString.setSpan(new ClosePCVerifyImpl.ClosePCVerifyClickableSpan(this, new WeakReference(paramBaseQQAppInterface), new WeakReference(paramQBaseActivity)), i, ((String)localObject).length() + i, 33);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("getClosePCVerifySpannable error: ");
      paramBaseQQAppInterface.append(paramString.getMessage());
      QLog.e("ClosePCVerifyImpl", 1, paramBaseQQAppInterface.toString());
    }
    return new SpannableString("");
  }
  
  public void a(ClosePCVerifyProxy paramClosePCVerifyProxy)
  {
    QLog.d("ClosePCVerifyImpl", 1, "addObserver");
    this.b = paramClosePCVerifyProxy;
  }
  
  public void a(boolean paramBoolean, BaseQQAppInterface paramBaseQQAppInterface)
  {
    for (;;)
    {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("requestSetPCVerify isSwitchOn: ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("ClosePCVerifyImpl", 1, ((StringBuilder)localObject).toString());
        if (paramBaseQQAppInterface == null)
        {
          QLog.e("ClosePCVerifyImpl", 1, "requestSetPCVerify error: appInterface == null");
          return;
        }
        localObject = (QuickLoginHandler)paramBaseQQAppInterface.getBusinessHandler(QuickLoginHandler.class.getName());
        if (localObject == null)
        {
          QLog.e("ClosePCVerifyImpl", 1, "requestSetPCVerify error: handler == null");
          return;
        }
        long l = System.currentTimeMillis();
        HashMap localHashMap = new HashMap();
        ClosePCVerifyImpl.ClosePCVerifyQuickLoginObserver localClosePCVerifyQuickLoginObserver = new ClosePCVerifyImpl.ClosePCVerifyQuickLoginObserver(l, new WeakReference(localHashMap), new WeakReference(paramBaseQQAppInterface), new WeakReference(this.b));
        QLog.d("ClosePCVerifyImpl", 1, "wrapper.put");
        localHashMap.put(Long.valueOf(l), localClosePCVerifyQuickLoginObserver);
        QLog.d("ClosePCVerifyImpl", 1, "appInterface.addObserver");
        paramBaseQQAppInterface.addObserver(localClosePCVerifyQuickLoginObserver);
        if (paramBoolean)
        {
          i = 1;
          ((QuickLoginHandler)localObject).a(i, l);
          return;
        }
      }
      catch (Exception paramBaseQQAppInterface)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("requestSetPCVerify error: ");
        ((StringBuilder)localObject).append(paramBaseQQAppInterface.getMessage());
        QLog.e("ClosePCVerifyImpl", 1, ((StringBuilder)localObject).toString());
        return;
      }
      int i = 0;
    }
  }
  
  public void b()
  {
    QLog.d("ClosePCVerifyImpl", 1, "removeObserver");
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.quicklogin.ClosePCVerifyImpl
 * JD-Core Version:    0.7.0.1
 */