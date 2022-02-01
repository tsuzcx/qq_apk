package com.tencent.open.agent;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.authority.AuthorityControlAdapter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.manager.OpenAgentHandler;
import com.tencent.open.manager.OpenAgentObserver;
import com.tencent.open.model.AppInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AuthorityControlFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private AuthorityControlAdapter jdField_a_of_type_ComTencentOpenAgentAuthorityAuthorityControlAdapter;
  private OpenAgentHandler jdField_a_of_type_ComTencentOpenManagerOpenAgentHandler;
  private OpenAgentObserver jdField_a_of_type_ComTencentOpenManagerOpenAgentObserver;
  private OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  @NonNull
  private ArrayList<AppInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    this.jdField_a_of_type_AndroidContentContext = getBaseActivity();
    c();
    d();
    e();
    b();
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.sApplication))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131692183, 0).a();
      f();
      return;
    }
    this.jdField_a_of_type_ComTencentOpenManagerOpenAgentHandler = ((OpenAgentHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.OPEN_AGENT_HANDLER));
    this.jdField_a_of_type_ComTencentOpenManagerOpenAgentHandler.a();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      label94:
      this.jdField_a_of_type_AndroidContentResColorStateList = this.rightViewText.getTextColors();
      this.jdField_a_of_type_AndroidViewView$OnTouchListener = new AuthorityControlFragment.1(this);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC3", "0X8009DC3", 0, 0, "", "", "", "");
      AuthorityUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B92E", null);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label94;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    PublicFragmentActivity.a(paramActivity, AuthorityControlFragment.class);
  }
  
  private void a(List<AppInfo> paramList)
  {
    AuthorityControlAdapter localAuthorityControlAdapter = this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthorityControlAdapter;
    if (localAuthorityControlAdapter == null) {
      return;
    }
    localAuthorityControlAdapter.b(paramList);
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthorityControlAdapter.a();
    if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthorityControlAdapter.getCount() == 0) {
      f();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
    }
    ThreadManager.getUIHandler().postDelayed(new AuthorityControlFragment.6(this), 800L);
  }
  
  private void b()
  {
    AuthorityControlFragment.2 local2 = new AuthorityControlFragment.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(AuthorityControlFragment.class, local2);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new AuthorityControlFragment.3(this);
  }
  
  private void d()
  {
    setTitle(getString(2131690223));
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthorityControlAdapter = new AuthorityControlAdapter(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)a(2131370165));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559642, null, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558649, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_AndroidViewView = a(2131366207);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131363076));
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthorityControlAdapter);
    localObject = this.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog((Context)localObject, ((Context)localObject).getResources().getDimensionPixelSize(2131299168));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131701029));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnCancelListener(new AuthorityControlFragment.4(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentOpenManagerOpenAgentObserver = new AuthorityControlFragment.5(this);
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.rightViewText.setVisibility(8);
    setLeftButton("", null);
    this.mLeftBackIcon.setVisibility(0);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthorityControlAdapter.b();
    setTextWithTalk(this.rightViewText, 2131690226);
    this.rightViewText.setTextColor(getResources().getColorStateList(2131165308));
    this.rightViewText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.rightViewText.setEnabled(false);
    setLeftButton(2131690728, new AuthorityControlFragment.7(this));
    Object localObject = this.leftViewNotBack.getLayoutParams();
    if ((localObject instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).setMargins(18, ((RelativeLayout.LayoutParams)localObject).topMargin, ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
      this.leftViewNotBack.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.leftView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718195);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(null);
    a(true);
    AuthorityUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B932", null);
  }
  
  private void h()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthorityControlAdapter.a();
    if (((List)localObject1).size() == 0)
    {
      AuthorityUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B933", null);
      return;
    }
    Object localObject2 = new AuthorityControlFragment.8(this, (List)localObject1);
    Object localObject3 = new AuthorityControlFragment.9(this);
    if (((List)localObject1).size() == 1) {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718194);
    } else {
      localObject1 = HardCodeUtil.a(2131701018);
    }
    int i = this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthorityControlAdapter.a().size();
    Object localObject4 = String.format(HardCodeUtil.a(2131701021), new Object[] { Integer.valueOf(i) });
    localObject1 = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, (String)localObject4, (String)localObject1, 2131690728, 2131694583, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject3);
    try
    {
      ((QQCustomDialog)localObject1).show();
      label145:
      localObject1 = new StringBuilder();
      localObject2 = new StringBuilder();
      localObject3 = this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthorityControlAdapter.a().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (AppInfo)((Iterator)localObject3).next();
        ((StringBuilder)localObject1).append(String.valueOf(((AppInfo)localObject4).a()));
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject2).append(((AppInfo)localObject4).b());
        ((StringBuilder)localObject2).append(" ");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC6", "0X8009DC6", 0, 0, "", "", ((StringBuilder)localObject1).toString(), "");
      AuthorityUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B933", new String[] { "", "", ((StringBuilder)localObject2).toString(), "" });
      return;
    }
    catch (Throwable localThrowable)
    {
      break label145;
    }
  }
  
  protected final <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  protected int getContentLayoutId()
  {
    return 2131558473;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 996) && (paramInt2 == -1)) {
      a(new AuthorityControlFragment.10(this, (AppInfo)paramIntent.getParcelableExtra("KEY_DELETED_INFO")));
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.rightViewText.getId() == paramView.getId()) {
      if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthorityControlAdapter.a()) {
        h();
      } else {
        g();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(AuthorityControlFragment.class);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthorityControlAdapter != null) && (localArrayList.size() == this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthorityControlAdapter.getCount())) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC7", "0X8009DC7", 0, 0, "", "", "", "");
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentOpenManagerOpenAgentObserver);
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentOpenManagerOpenAgentObserver);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlFragment
 * JD-Core Version:    0.7.0.1
 */