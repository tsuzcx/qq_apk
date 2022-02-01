package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.HbInfo.BundleInfo;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public abstract class BaseHbFragment
  extends QBaseFragment
{
  protected int a;
  protected Bundle a;
  protected BaseQQAppInterface a;
  protected SendHbLogic a;
  protected SendHbActivity a;
  protected boolean a;
  protected boolean b;
  
  private void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.b))
    {
      this.jdField_a_of_type_Boolean = false;
      try
      {
        aN_();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("BaseHbFragment", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsBundle = getArguments();
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("channel", String.valueOf(1));
    try
    {
      this.jdField_a_of_type_Int = Integer.valueOf(str).intValue();
      label33:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("base params channel = ");
      localStringBuilder.append(str);
      localStringBuilder.append(" : ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.i("BaseHbFragment", 2, localStringBuilder.toString());
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label33;
    }
  }
  
  public int a()
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BaseHbFragment", 2, "getChooseViewHeight compact device");
      }
      return DisplayUtil.a(getQBaseActivity(), 200.0F);
    }
    return DisplayUtil.a(getQBaseActivity(), 280.0F);
  }
  
  protected void a(HbInfo.BundleInfo paramBundleInfo, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("number#");
      localStringBuffer.append(paramInt2);
      localStringBuffer.append(",type#");
      if ((!"1".equals(paramBundleInfo.recv_type)) && (!"7".equals(paramBundleInfo.recv_type)) && (!"4".equals(paramBundleInfo.recv_type)) && (!"5".equals(paramBundleInfo.recv_type)))
      {
        if ("2".equals(paramBundleInfo.recv_type)) {
          localStringBuffer.append("crowd");
        } else {
          localStringBuffer.append("group");
        }
      }
      else {
        localStringBuffer.append("person");
      }
      localStringBuffer.append(",channel#");
      localStringBuffer.append(paramInt1);
      localStringBuffer.append(",money#");
      localStringBuffer.append(paramString1);
      a(paramString2, localStringBuffer.toString());
      return;
    }
    catch (Throwable paramBundleInfo) {}
  }
  
  protected void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openUrl = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("BaseHbFragment", 2, ((StringBuilder)localObject).toString());
    localObject = new Intent();
    ((Intent)localObject).putExtra("url", paramString);
    ((Intent)localObject).putExtra("hide_operation_bar", true);
    ((Intent)localObject).putExtra("hide_more_button", true);
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    RouteUtils.a(getQBaseActivity(), (Intent)localObject, "/base/browser", 16);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      SendHbActivity localSendHbActivity = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity;
      if ((localSendHbActivity != null) && (!localSendHbActivity.isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addCommonHbUploadData(paramString1, paramString2, 2);
      }
    }
  }
  
  protected boolean a(String paramString)
  {
    if (StringUtil.a(paramString)) {
      return false;
    }
    if ((paramString.indexOf('.') > 0) && (paramString.indexOf('.') < paramString.length() - 3))
    {
      paramString = getString(R.string.J);
      SendHbActivity localSendHbActivity = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity;
      if (localSendHbActivity != null) {
        localSendHbActivity.showCommonHbToast(paramString);
      }
      return false;
    }
    return true;
  }
  
  protected void aN_()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLazyLoad: ");
      localStringBuilder.append(getClass().getSimpleName());
      QLog.i("BaseHbFragment", 2, localStringBuilder.toString());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreateView: ");
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    QLog.i("BaseHbFragment", 2, ((StringBuilder)localObject).toString());
    localObject = (SendHbActivity)getQBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity = ((SendHbActivity)localObject);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplSendHbLogic = new SendHbLogic((SendHbActivity)localObject);
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = ((BaseQQAppInterface)this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getWindow().setSoftInputMode(19);
    c();
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_Boolean = true;
    b();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setUserVisibleHint: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(getClass().getSimpleName());
      QLog.i("BaseHbFragment", 2, localStringBuilder.toString());
    }
    this.b = paramBoolean;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbFragment
 * JD-Core Version:    0.7.0.1
 */