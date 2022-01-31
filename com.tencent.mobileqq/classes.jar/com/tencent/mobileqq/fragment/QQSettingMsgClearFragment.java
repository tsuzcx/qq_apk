package com.tencent.mobileqq.fragment;

import abtq;
import ajsd;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import apue;
import aqjg;
import aqjh;
import axqy;
import bcqf;
import bfnz;
import bfpc;
import bfpp;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import whj;

public class QQSettingMsgClearFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private static long jdField_b_of_type_Long;
  private long jdField_a_of_type_Long;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  public bcqf a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private View jdField_b_of_type_AndroidViewView;
  
  public QQSettingMsgClearFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new aqjh(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.mContentView.findViewById(2131375654));
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131373097);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.mContentView.findViewById(2131364974).setOnClickListener(this);
    this.mContentView.findViewById(2131378740).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131364971);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131691486));
    if (bfnz.c()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
    }
    if (this.jdField_a_of_type_Bcqf == null)
    {
      this.jdField_a_of_type_Bcqf = new bcqf(getActivity(), getActivity().getTitleBarHeight());
      this.jdField_a_of_type_Bcqf.a(getString(2131690811));
      this.jdField_a_of_type_Bcqf.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_Bcqf.c(true);
      this.jdField_a_of_type_Bcqf.a(false);
      this.jdField_a_of_type_Bcqf.b(true);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bcqf != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_Bcqf.isShowing())) {
        break label29;
      }
      this.jdField_a_of_type_Bcqf.show();
    }
    label29:
    while ((paramBoolean) || (!this.jdField_a_of_type_Bcqf.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bcqf.dismiss();
  }
  
  public static boolean a()
  {
    long l = System.currentTimeMillis();
    if (l - jdField_b_of_type_Long <= 200L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingMsgClearFragment", 2, "click too fast");
      }
      jdField_b_of_type_Long = l;
      return true;
    }
    jdField_b_of_type_Long = l;
    return false;
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        a();
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561090;
  }
  
  public void onClick(View paramView)
  {
    AIOImageProviderService localAIOImageProviderService = null;
    int j = 0;
    if (paramView.getId() == 2131364974)
    {
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), FMActivity.class);
      paramView.putExtra("selectMode", true);
      paramView.putExtra("targetUin", ajsd.z);
      paramView.putExtra("tab_tab_type", 8);
      paramView.putExtra("only_show_local_tab", true);
      paramView.putExtra("max_select_count", 999999);
      axqy.b(null, "dc00898", "", "", "0X800A0C8", "0X800A0C8", 0, 0, "", "", "", "");
      startActivityForResult(paramView, 1);
      getActivity().overridePendingTransition(2130771979, 2130771980);
      apue.a("0x80087C4");
      axqy.b(null, "dc00898", "", "", "0X800A0C2", "0X800A0C2", 0, 0, "", "", "", "");
      QQSettingMsgHistoryActivity.a();
    }
    long l1;
    long l2;
    do
    {
      do
      {
        return;
        if (paramView.getId() == 2131378740)
        {
          paramView = new Intent(getActivity(), QQSettingMsgHistoryActivity.class);
          paramView.putExtra("set_display_type", 1);
          getActivity().startActivity(paramView);
          axqy.b(null, "CliOper", "", "", "0X800A2D1", "0X800A2D1", 0, 0, "", "", "", "");
          return;
        }
        if (paramView.getId() != 2131373097) {
          break;
        }
      } while (a());
      paramView = new Intent();
      localAIOImageProviderService = AIOImageProviderService.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "", 0, null, false);
      localObject = new Bundle();
      ((Bundle)localObject).putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(localAIOImageProviderService.asBinder()));
      ((Bundle)localObject).putInt("jump", 1);
      paramView.putExtras((Bundle)localObject);
      axqy.b(null, "dc00898", "", "", "0X800A0C1", "0X800A0C1", 0, 0, "", "", "", "");
      abtq.a(this, paramView, PublicFragmentActivityForPeak.class, SessionClearFragment.class, 1);
      QQSettingMsgHistoryActivity.a();
      return;
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
    } while ((getActivity().isFinishing()) || (l1 - l2 < 500L));
    this.jdField_a_of_type_Long = l1;
    Object localObject = (bfpc)bfpp.a(getActivity(), null);
    int i;
    switch (paramView.getId())
    {
    default: 
      i = 0;
    }
    for (paramView = localAIOImageProviderService;; paramView = new aqjg(this, (bfpc)localObject))
    {
      ((bfpc)localObject).a(i, 3);
      ((bfpc)localObject).d(getString(2131690596));
      ((bfpc)localObject).a(paramView);
      ((bfpc)localObject).a(j);
      ((bfpc)localObject).show();
      return;
      i = 2131691485;
      j = 2131699417;
    }
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131699421));
    return localView;
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
      a(false);
    }
    super.onDestroy();
    QQSettingMsgHistoryActivity.a();
    whj.a(getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment
 * JD-Core Version:    0.7.0.1
 */