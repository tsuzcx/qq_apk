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
  protected Bundle e;
  protected SendHbActivity f;
  protected BaseQQAppInterface g;
  protected SendHbLogic h;
  protected int i;
  protected boolean j;
  protected boolean k;
  
  private void c()
  {
    if ((this.j) && (this.k))
    {
      this.j = false;
      try
      {
        dj_();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("BaseHbFragment", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  private void d()
  {
    this.e = getArguments();
    String str = this.e.getString("channel", String.valueOf(1));
    try
    {
      this.i = Integer.valueOf(str).intValue();
      label33:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("base params channel = ");
      localStringBuilder.append(str);
      localStringBuilder.append(" : ");
      localStringBuilder.append(this.i);
      QLog.i("BaseHbFragment", 2, localStringBuilder.toString());
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label33;
    }
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
      SendHbActivity localSendHbActivity = this.f;
      if ((localSendHbActivity != null) && (!localSendHbActivity.isFinishing())) {
        this.f.addCommonHbUploadData(paramString1, paramString2, 2);
      }
    }
  }
  
  public int b()
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
  
  protected boolean b(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return false;
    }
    if ((paramString.indexOf('.') > 0) && (paramString.indexOf('.') < paramString.length() - 3))
    {
      paramString = getString(R.string.J);
      SendHbActivity localSendHbActivity = this.f;
      if (localSendHbActivity != null) {
        localSendHbActivity.showCommonHbToast(paramString);
      }
      return false;
    }
    return true;
  }
  
  protected void dj_()
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
    this.f = ((SendHbActivity)localObject);
    this.h = new SendHbLogic((SendHbActivity)localObject);
    this.g = ((BaseQQAppInterface)this.f.getAppRuntime());
    this.f.getWindow().setSoftInputMode(19);
    d();
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.j = true;
    c();
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
    this.k = paramBoolean;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbFragment
 * JD-Core Version:    0.7.0.1
 */