package com.tencent.mobileqq.fragment;

import afez;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import antf;
import aunh;
import avfr;
import avfs;
import bdll;
import bjbs;
import blir;
import bliz;
import blji;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.BinderWarpper;
import com.tencent.util.VersionUtils;
import zxx;

public class QQSettingMsgClearFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private static long jdField_b_of_type_Long;
  private long jdField_a_of_type_Long;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  public bjbs a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private View jdField_b_of_type_AndroidViewView;
  
  public QQSettingMsgClearFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new avfs(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.mContentView.findViewById(2131377110));
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131374427);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.mContentView.findViewById(2131365342).setOnClickListener(this);
    this.mContentView.findViewById(2131380528).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131365339);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131691309));
    if (VersionUtils.isGingerBread()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
    }
    if (this.jdField_a_of_type_Bjbs == null)
    {
      this.jdField_a_of_type_Bjbs = new bjbs(getActivity(), getActivity().getTitleBarHeight());
      this.jdField_a_of_type_Bjbs.a(getString(2131690711));
      this.jdField_a_of_type_Bjbs.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_Bjbs.c(true);
      this.jdField_a_of_type_Bjbs.a(false);
      this.jdField_a_of_type_Bjbs.b(true);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bjbs != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_Bjbs.isShowing())) {
        break label29;
      }
      this.jdField_a_of_type_Bjbs.show();
    }
    label29:
    while ((paramBoolean) || (!this.jdField_a_of_type_Bjbs.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bjbs.dismiss();
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
    return 2131561566;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = null;
    int j = 0;
    if (paramView.getId() == 2131365342)
    {
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), FMActivity.class);
      ((Intent)localObject1).putExtra("selectMode", true);
      ((Intent)localObject1).putExtra("targetUin", antf.z);
      ((Intent)localObject1).putExtra("tab_tab_type", 8);
      ((Intent)localObject1).putExtra("only_show_local_tab", true);
      ((Intent)localObject1).putExtra("max_select_count", 999999);
      bdll.b(null, "dc00898", "", "", "0X800A0C8", "0X800A0C8", 0, 0, "", "", "", "");
      startActivityForResult((Intent)localObject1, 1);
      getActivity().overridePendingTransition(2130771979, 2130771980);
      aunh.a("0x80087C4");
      bdll.b(null, "dc00898", "", "", "0X800A0C2", "0X800A0C2", 0, 0, "", "", "", "");
      QQSettingMsgHistoryActivity.a();
    }
    long l1;
    long l2;
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (paramView.getId() == 2131380528)
        {
          localObject1 = new Intent(getActivity(), QQSettingMsgHistoryActivity.class);
          ((Intent)localObject1).putExtra("set_display_type", 1);
          getActivity().startActivity((Intent)localObject1);
          bdll.b(null, "CliOper", "", "", "0X800A2D1", "0X800A2D1", 0, 0, "", "", "", "");
        }
        else
        {
          if (paramView.getId() != 2131374427) {
            break;
          }
          if (!a())
          {
            localObject1 = new Intent();
            localObject2 = AIOImageProviderService.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "", 0, null, false);
            Bundle localBundle = new Bundle();
            localBundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(((AIOImageProviderService)localObject2).asBinder()));
            localBundle.putInt("jump", 1);
            ((Intent)localObject1).putExtras(localBundle);
            ((Intent)localObject1).setFlags(805306368);
            bdll.b(null, "dc00898", "", "", "0X800A0C1", "0X800A0C1", 0, 0, "", "", "", "");
            afez.a(this, (Intent)localObject1, PublicFragmentActivityForPeak.class, SessionClearFragment.class, 1);
            QQSettingMsgHistoryActivity.a();
          }
        }
      }
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
    } while ((!getActivity().isFinishing()) && (l1 - l2 < 500L));
    this.jdField_a_of_type_Long = l1;
    Object localObject2 = (blir)blji.a(getActivity(), null);
    int i;
    switch (paramView.getId())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      ((blir)localObject2).a(i, 3);
      ((blir)localObject2).d(getString(2131690580));
      ((blir)localObject2).a((bliz)localObject1);
      ((blir)localObject2).a(j);
      ((blir)localObject2).show();
      break;
      i = 2131691308;
      j = 2131698353;
      localObject1 = new avfr(this, (blir)localObject2);
    }
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131698356));
    return localView;
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
      a(false);
    }
    super.onDestroy();
    QQSettingMsgHistoryActivity.a();
    zxx.a(getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment
 * JD-Core Version:    0.7.0.1
 */