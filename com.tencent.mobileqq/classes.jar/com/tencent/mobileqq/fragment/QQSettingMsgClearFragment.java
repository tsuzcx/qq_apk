package com.tencent.mobileqq.fragment;

import adpn;
import alof;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import arrp;
import ashe;
import ashf;
import azqs;
import bety;
import bhtb;
import bhuf;
import bhus;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import yak;

public class QQSettingMsgClearFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private static long jdField_b_of_type_Long;
  private long jdField_a_of_type_Long;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  public bety a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private View jdField_b_of_type_AndroidViewView;
  
  public QQSettingMsgClearFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new ashf(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.mContentView.findViewById(2131376200));
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131373585);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.mContentView.findViewById(2131365061).setOnClickListener(this);
    this.mContentView.findViewById(2131379416).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131365058);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131691541));
    if (bhtb.c()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
    }
    if (this.jdField_a_of_type_Bety == null)
    {
      this.jdField_a_of_type_Bety = new bety(getActivity(), getActivity().getTitleBarHeight());
      this.jdField_a_of_type_Bety.a(getString(2131690864));
      this.jdField_a_of_type_Bety.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_Bety.c(true);
      this.jdField_a_of_type_Bety.a(false);
      this.jdField_a_of_type_Bety.b(true);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bety != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_Bety.isShowing())) {
        break label29;
      }
      this.jdField_a_of_type_Bety.show();
    }
    label29:
    while ((paramBoolean) || (!this.jdField_a_of_type_Bety.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bety.dismiss();
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
    return 2131561295;
  }
  
  public void onClick(View paramView)
  {
    AIOImageProviderService localAIOImageProviderService = null;
    int j = 0;
    if (paramView.getId() == 2131365061)
    {
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), FMActivity.class);
      paramView.putExtra("selectMode", true);
      paramView.putExtra("targetUin", alof.z);
      paramView.putExtra("tab_tab_type", 8);
      paramView.putExtra("only_show_local_tab", true);
      paramView.putExtra("max_select_count", 999999);
      azqs.b(null, "dc00898", "", "", "0X800A0C8", "0X800A0C8", 0, 0, "", "", "", "");
      startActivityForResult(paramView, 1);
      getActivity().overridePendingTransition(2130771979, 2130771980);
      arrp.a("0x80087C4");
      azqs.b(null, "dc00898", "", "", "0X800A0C2", "0X800A0C2", 0, 0, "", "", "", "");
      QQSettingMsgHistoryActivity.a();
    }
    long l1;
    long l2;
    do
    {
      do
      {
        return;
        if (paramView.getId() == 2131379416)
        {
          paramView = new Intent(getActivity(), QQSettingMsgHistoryActivity.class);
          paramView.putExtra("set_display_type", 1);
          getActivity().startActivity(paramView);
          azqs.b(null, "CliOper", "", "", "0X800A2D1", "0X800A2D1", 0, 0, "", "", "", "");
          return;
        }
        if (paramView.getId() != 2131373585) {
          break;
        }
      } while (a());
      paramView = new Intent();
      localAIOImageProviderService = AIOImageProviderService.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "", 0, null, false);
      localObject = new Bundle();
      ((Bundle)localObject).putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(localAIOImageProviderService.asBinder()));
      ((Bundle)localObject).putInt("jump", 1);
      paramView.putExtras((Bundle)localObject);
      paramView.setFlags(805306368);
      azqs.b(null, "dc00898", "", "", "0X800A0C1", "0X800A0C1", 0, 0, "", "", "", "");
      adpn.a(this, paramView, PublicFragmentActivityForPeak.class, SessionClearFragment.class, 1);
      QQSettingMsgHistoryActivity.a();
      return;
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
    } while ((getActivity().isFinishing()) || (l1 - l2 < 500L));
    this.jdField_a_of_type_Long = l1;
    Object localObject = (bhuf)bhus.a(getActivity(), null);
    int i;
    switch (paramView.getId())
    {
    default: 
      i = 0;
    }
    for (paramView = localAIOImageProviderService;; paramView = new ashe(this, (bhuf)localObject))
    {
      ((bhuf)localObject).a(i, 3);
      ((bhuf)localObject).d(getString(2131690648));
      ((bhuf)localObject).a(paramView);
      ((bhuf)localObject).a(j);
      ((bhuf)localObject).show();
      return;
      i = 2131691540;
      j = 2131699780;
    }
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131699784));
    return localView;
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      a(false);
    }
    super.onDestroy();
    QQSettingMsgHistoryActivity.a();
    yak.a(getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment
 * JD-Core Version:    0.7.0.1
 */