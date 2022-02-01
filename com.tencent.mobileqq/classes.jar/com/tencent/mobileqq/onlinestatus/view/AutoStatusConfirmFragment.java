package com.tencent.mobileqq.onlinestatus.view;

import afur;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import ayox;
import aypi;
import aypj;
import aypy;
import ayqb;
import ayqi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;

public class AutoStatusConfirmFragment
  extends PublicBaseFragment
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
    paramActivity.overridePendingTransition(2130771979, 2130771977);
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
    int i;
    if (this.jdField_a_of_type_Int == 1) {
      i = 2;
    }
    for (;;)
    {
      if (paramView.getId() == 2131376807) {
        getActivity().finish();
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.jdField_a_of_type_Int != 0) {
          break label220;
        }
        i = 1;
        break;
        if (paramView.getId() == 2131364119)
        {
          getActivity().finish();
          if (i != 0) {
            aypy.a("0X800AFA5", i);
          }
        }
        else if (paramView.getId() == 2131372788)
        {
          ayqb localayqb = ((aypj)BaseApplicationImpl.getApplication().getRuntime().getManager(369)).a();
          getActivity().finish();
          if (i != 0) {
            aypy.a("0X800AFA4", i);
          }
          i = localayqb.a();
          if (this.jdField_a_of_type_Long != i)
          {
            if (QLog.isColorLevel()) {
              QLog.e("AutoStatusConfirmFragment", 2, "[status][autoMgr] submitStatus ignore submitStatus: " + ayqi.a((int)this.jdField_a_of_type_Long) + " curStatus: " + ayqi.a(i));
            }
            QQToast.a(BaseApplicationImpl.getApplication(), "当前状态已改变，无法切换", 0).a();
          }
          else
          {
            ayqb.a(BaseActivity.sTopActivity.app, this.jdField_a_of_type_Long, false, "dialog_switch");
          }
        }
      }
      label220:
      i = 0;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = paramLayoutInflater.inflate(2131558417, null);
    paramViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131371951));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131364119));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.b = ((Button)paramViewGroup.findViewById(2131372788));
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_Long = getActivity().getIntent().getLongExtra("ext_status", 0L);
    this.jdField_a_of_type_Int = getActivity().getIntent().getIntExtra("is_background", -1);
    paramLayoutInflater = ayox.a().a(AppRuntime.Status.online, this.jdField_a_of_type_Long);
    paramBundle = getResources().getString(2131697651, new Object[] { paramLayoutInflater.a });
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle);
    int i = afur.a(24.0F, getResources());
    paramBundle = URLDrawable.URLDrawableOptions.obtain();
    paramBundle.mRequestWidth = i;
    paramBundle.mRequestHeight = i;
    if (!TextUtils.isEmpty(paramLayoutInflater.b))
    {
      paramLayoutInflater = URLDrawable.getDrawable(paramLayoutInflater.b, paramBundle);
      paramLayoutInflater.setBounds(0, 0, i, i);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramLayoutInflater, null, null, null);
      if (this.jdField_a_of_type_Int == 1) {
        i = 2;
      }
      for (;;)
      {
        if (i != 0) {
          aypy.a("0X800AFA3", i);
        }
        V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
        return paramViewGroup;
        if (this.jdField_a_of_type_Int == 0) {
          i = 1;
        } else {
          i = 0;
        }
      }
      paramLayoutInflater = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AutoStatusConfirmFragment
 * JD-Core Version:    0.7.0.1
 */