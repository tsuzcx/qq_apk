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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Button b;
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(3);
    paramActivity.overridePendingTransition(2130771993, 2130771991);
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
    int j = this.jdField_a_of_type_Int;
    int i = 1;
    if (j == 1) {
      i = 2;
    } else if (j != 0) {
      i = 0;
    }
    if (paramView.getId() == 2131376828)
    {
      getQBaseActivity().finish();
    }
    else if (paramView.getId() == 2131364266)
    {
      getQBaseActivity().finish();
      if (i != 0) {
        ReportHelperKt.a("0X800AFA5", i);
      }
    }
    else if (paramView.getId() == 2131372968)
    {
      Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
      AutoStatusManager localAutoStatusManager = (AutoStatusManager)((IOnlineStatusManagerService)((AppRuntime)localObject).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IAutoStatusManager.class);
      getQBaseActivity().finish();
      if (i != 0) {
        ReportHelperKt.a("0X800AFA4", i);
      }
      i = localAutoStatusManager.a();
      long l = this.jdField_a_of_type_Long;
      if (l != i)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[status][autoMgr] submitStatus ignore submitStatus: ");
          ((StringBuilder)localObject).append(Constant.a((int)this.jdField_a_of_type_Long));
          ((StringBuilder)localObject).append(" curStatus: ");
          ((StringBuilder)localObject).append(Constant.a(i));
          QLog.e("AutoStatusConfirmFragment", 2, ((StringBuilder)localObject).toString());
        }
        QQToast.a(MobileQQ.sMobileQQ, "当前状态已改变，无法切换", 0).a();
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
    paramViewGroup = paramLayoutInflater.inflate(2131558446, null);
    paramViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372109));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131364266));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.b = ((Button)paramViewGroup.findViewById(2131372968));
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_Long = getQBaseActivity().getIntent().getLongExtra("ext_status", 0L);
    this.jdField_a_of_type_Int = getQBaseActivity().getIntent().getIntExtra("is_background", -1);
    paramLayoutInflater = OnLineStatusHelper.a().a(AppRuntime.Status.online, this.jdField_a_of_type_Long);
    paramBundle = getResources();
    int i = 1;
    paramBundle = paramBundle.getString(2131698506, new Object[] { paramLayoutInflater.b });
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle);
    int j = Utils.a(24.0F, getResources());
    paramBundle = URLDrawable.URLDrawableOptions.obtain();
    paramBundle.mRequestWidth = j;
    paramBundle.mRequestHeight = j;
    if (!TextUtils.isEmpty(paramLayoutInflater.c))
    {
      paramLayoutInflater = URLDrawable.getDrawable(paramLayoutInflater.c, paramBundle);
      paramLayoutInflater.setBounds(0, 0, j, j);
    }
    else
    {
      paramLayoutInflater = null;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramLayoutInflater, null, null, null);
    j = this.jdField_a_of_type_Int;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AutoStatusConfirmFragment
 * JD-Core Version:    0.7.0.1
 */