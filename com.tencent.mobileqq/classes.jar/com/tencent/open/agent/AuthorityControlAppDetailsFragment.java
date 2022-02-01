package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.manager.OpenAgentHandler;
import com.tencent.open.manager.OpenAgentObserver;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xf26.oidb_0xf26.AuthItem;

public class AuthorityControlAppDetailsFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private OpenAgentHandler jdField_a_of_type_ComTencentOpenManagerOpenAgentHandler;
  private OpenAgentObserver jdField_a_of_type_ComTencentOpenManagerOpenAgentObserver;
  private AppInfo jdField_a_of_type_ComTencentOpenModelAppInfo;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AuthorityControlAppDetailsFragment.4(this);
  private Runnable b = new AuthorityControlAppDetailsFragment.5(this);
  
  private View a(AuthorityControlAppDetailsFragment.AuthPermission paramAuthPermission, ViewGroup paramViewGroup)
  {
    paramViewGroup = getActivity().getLayoutInflater().inflate(2131558748, paramViewGroup, false);
    if (!TextUtils.isEmpty(paramAuthPermission.b))
    {
      localObject = (TextView)paramViewGroup.findViewById(2131363117);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(paramAuthPermission.b);
    }
    Object localObject = (FormSwitchItem)paramViewGroup.findViewById(2131363122);
    ((FormSwitchItem)localObject).setText(paramAuthPermission.jdField_a_of_type_JavaLangString);
    ((FormSwitchItem)localObject).setContentDescription(paramAuthPermission.jdField_a_of_type_JavaLangString);
    ((FormSwitchItem)localObject).setChecked(paramAuthPermission.jdField_a_of_type_Boolean);
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new AuthorityControlAppDetailsFragment.7(this, paramAuthPermission));
    return paramViewGroup;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentOpenManagerOpenAgentObserver = new AuthorityControlAppDetailsFragment.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentOpenManagerOpenAgentObserver);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, new Object[] { "operateAuthItem type=", Integer.valueOf(paramInt1), ", id=", Integer.valueOf(paramInt2), ", mStatus=", Integer.valueOf(this.jdField_a_of_type_Int) });
    if (!NetworkUtil.g(getActivity())) {
      QQToast.a(getActivity(), HardCodeUtil.a(2131694678), 0).a();
    }
    while (this.jdField_a_of_type_Int != 0) {
      return;
    }
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentOpenManagerOpenAgentHandler.a(this.jdField_a_of_type_ComTencentOpenModelAppInfo.a(), paramInt1, Arrays.asList(new Integer[] { Integer.valueOf(paramInt2) }));
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
    ThreadManager.getUIHandler().postDelayed(this.b, 15000L);
  }
  
  public static void a(Activity paramActivity, AppInfo paramAppInfo)
  {
    Intent localIntent = new Intent(paramActivity, AuthorityControlAppDetailsFragment.class);
    localIntent.putExtra("KEY_APP_INFO", paramAppInfo);
    PublicFragmentActivity.a(paramActivity, localIntent, AuthorityControlAppDetailsFragment.class, 996);
  }
  
  private void a(View paramView)
  {
    paramView = new AuthorityControlAppDetailsFragment.2(this);
    AuthorityControlAppDetailsFragment.3 local3 = new AuthorityControlAppDetailsFragment.3(this);
    String str = HardCodeUtil.a(2131700885) + this.jdField_a_of_type_ComTencentOpenModelAppInfo.b() + HardCodeUtil.a(2131700876);
    paramView = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, str, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718529), 2131690800, 2131694615, paramView, local3);
    try
    {
      paramView.show();
      label92:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC5", "0X8009DC5", 0, 0, "", "", String.valueOf(this.jdField_a_of_type_ComTencentOpenModelAppInfo.a()), "");
      AuthorityUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B931", new String[] { "", "", this.jdField_a_of_type_ComTencentOpenModelAppInfo.b(), "" });
      return;
    }
    catch (Throwable paramView)
    {
      break label92;
    }
  }
  
  private void a(List<oidb_0xf26.AuthItem> paramList)
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, new Object[] { "showAuthItems size=", Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty()) {}
    int i;
    label169:
    label246:
    do
    {
      return;
      localObject = (LinearLayout)this.mContentView.findViewById(2131363126);
      ((LinearLayout)localObject).setVisibility(0);
      ((LinearLayout)localObject).removeAllViews();
      int k = Math.min(paramList.size(), 20);
      int j = 0;
      i = 0;
      if (j < k)
      {
        oidb_0xf26.AuthItem localAuthItem = (oidb_0xf26.AuthItem)paramList.get(j);
        AuthorityControlAppDetailsFragment.AuthPermission localAuthPermission = new AuthorityControlAppDetailsFragment.AuthPermission(null);
        localAuthPermission.jdField_a_of_type_Int = localAuthItem.auth_group_id.get();
        localAuthPermission.jdField_a_of_type_JavaLangString = localAuthItem.auth_group_name.get().toStringUtf8();
        localAuthPermission.b = localAuthItem.auth_group_desc.get().toStringUtf8();
        boolean bool;
        if (localAuthItem.auth_result.get() == 1)
        {
          bool = true;
          localAuthPermission.jdField_a_of_type_Boolean = bool;
          QLog.d("AuthorityControlAppDetailsActivity", 1, new Object[] { "showAuthItems ", localAuthPermission });
          ((LinearLayout)localObject).addView(a(localAuthPermission, (ViewGroup)localObject), new LinearLayout.LayoutParams(-1, -2));
          if (TextUtils.isEmpty(localAuthPermission.b)) {
            break label246;
          }
        }
        for (i = 1;; i = 0)
        {
          j += 1;
          break;
          bool = false;
          break label169;
        }
      }
    } while (i == 0);
    paramList = this.mContentView.findViewById(2131376910);
    Object localObject = (LinearLayout.LayoutParams)paramList.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    paramList.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = 0;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().removeCallbacks(this.b);
    e();
  }
  
  private void c()
  {
    this.mContentView.findViewById(2131376910).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentOpenModelAppInfo = ((AppInfo)getActivity().getIntent().getParcelableExtra("KEY_APP_INFO"));
    setTitle(this.jdField_a_of_type_ComTencentOpenModelAppInfo.b());
    this.jdField_a_of_type_ComTencentOpenManagerOpenAgentHandler = ((OpenAgentHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.OPEN_AGENT_HANDLER));
  }
  
  private void d()
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, "showLoadingDialog");
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getActivity().getResources().getDimensionPixelSize(2131299166));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131700886));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(new AuthorityControlAppDetailsFragment.6(this));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void e()
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, "dismissLoadingDialog");
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131558446;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(paramView);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentOpenManagerOpenAgentObserver);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    QLog.d("AuthorityControlAppDetailsActivity", 1, "onDestroyView");
    b();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_AndroidAppActivity = getActivity();
    a();
    c();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC4", "0X8009DC4", 0, 0, "", "", "", "");
    a(1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment
 * JD-Core Version:    0.7.0.1
 */