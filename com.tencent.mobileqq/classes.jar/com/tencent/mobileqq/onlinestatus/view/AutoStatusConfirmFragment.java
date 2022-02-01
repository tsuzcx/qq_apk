package com.tencent.mobileqq.onlinestatus.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.IAutoStatusManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class AutoStatusConfirmFragment
  extends QPublicBaseFragment
  implements View.OnClickListener
{
  private long a;
  private TextView b;
  private Button c;
  private Button d;
  private int e;
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(3);
    paramActivity.overridePendingTransition(2130771996, 2130771994);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    int j = this.e;
    int i = 1;
    if (j == 1) {
      i = 2;
    } else if (j != 0) {
      i = 0;
    }
    if (paramView.getId() == 2131445159)
    {
      getQBaseActivity().finish();
    }
    else if (paramView.getId() == 2131430282)
    {
      getQBaseActivity().finish();
      if (i != 0) {
        ReportHelperKt.a("0X800AFA5", i);
      }
    }
    else if (paramView.getId() == 2131440536)
    {
      Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
      AutoStatusManager localAutoStatusManager = (AutoStatusManager)((IOnlineStatusManagerService)((AppRuntime)localObject).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IAutoStatusManager.class);
      getQBaseActivity().finish();
      if (i != 0) {
        ReportHelperKt.a("0X800AFA4", i);
      }
      i = localAutoStatusManager.a();
      long l = this.a;
      if (l != i)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[status][autoMgr] submitStatus ignore submitStatus: ");
          ((StringBuilder)localObject).append(Constant.c((int)this.a));
          ((StringBuilder)localObject).append(" curStatus: ");
          ((StringBuilder)localObject).append(Constant.c(i));
          QLog.e("AutoStatusConfirmFragment", 2, ((StringBuilder)localObject).toString());
        }
        QQToast.makeText(MobileQQ.sMobileQQ, "当前状态已改变，无法切换", 0).show();
      }
      else
      {
        AutoStatusManager.a((AppInterface)localObject, l, false, "dialog_switch");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = paramLayoutInflater.inflate(2131623982, null);
    paramViewGroup.setOnClickListener(this);
    this.b = ((TextView)paramViewGroup.findViewById(2131439579));
    this.c = ((Button)paramViewGroup.findViewById(2131430282));
    this.c.setOnClickListener(this);
    this.d = ((Button)paramViewGroup.findViewById(2131440536));
    this.d.setOnClickListener(this);
    this.a = getQBaseActivity().getIntent().getLongExtra("ext_status", 0L);
    this.e = getQBaseActivity().getIntent().getIntExtra("is_background", -1);
    paramLayoutInflater = OnLineStatusHelper.a().a(AppRuntime.Status.online, this.a);
    paramBundle = getResources();
    int i = 1;
    paramBundle = paramBundle.getString(2131896448, new Object[] { paramLayoutInflater.c });
    this.b.setText(paramBundle);
    int j = Utils.a(24.0F, getResources());
    paramBundle = URLDrawable.URLDrawableOptions.obtain();
    paramBundle.mRequestWidth = j;
    paramBundle.mRequestHeight = j;
    if (!TextUtils.isEmpty(paramLayoutInflater.d))
    {
      paramLayoutInflater = URLDrawable.getDrawable(paramLayoutInflater.d, paramBundle);
      paramLayoutInflater.setBounds(0, 0, j, j);
    }
    else
    {
      paramLayoutInflater = null;
    }
    this.b.setCompoundDrawables(paramLayoutInflater, null, null, null);
    j = this.e;
    if (j == 1) {
      i = 2;
    } else if (j != 0) {
      i = 0;
    }
    if (i != 0) {
      ReportHelperKt.a("0X800AFA3", i);
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AutoStatusConfirmFragment
 * JD-Core Version:    0.7.0.1
 */