package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.chat.autoreply.AutoReplyUtil;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.onlinestatus.view.AutoStatusAccountView;
import com.tencent.mobileqq.onlinestatus.view.BaseStatusCardView.OnDismissCallback;
import com.tencent.mobileqq.onlinestatus.view.MyMoodView;
import com.tencent.mobileqq.onlinestatus.view.StatusCardViewHolder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager.Utils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class AccountOnlineStateActivity
  extends IphoneTitleBarFragment
  implements View.OnClickListener, AutoReplyAdapter.OnAutoReplyItemListener, BaseOnlineStatusDisplayInfo.UpdateUIListener, OnlineStatusPagerAdapter.OnStatusItemClickListener, OnlineStatusPanel.OnlineStatusPanelListener, OnlineStatusPermissionManager.ReceiveDataListener, OnlineStatusViewCtrl.OnStatusItemCheckListener, BaseStatusCardView.OnDismissCallback
{
  private long jdField_a_of_type_Long;
  private volatile FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new AccountOnlineStateActivity.4(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AutoReplyText jdField_a_of_type_ComTencentMobileqqDataAutoReplyText;
  private AutoReplyAdapter jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter;
  private OnBatteryChangeObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnBatteryChangeObserver = new AccountOnlineStateActivity.8(this);
  private OnLineStatusBlurBg jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg = new OnLineStatusBlurBg();
  private OnLineStatusCustomSmartViewCtrl jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl = new OnLineStatusCustomSmartViewCtrl(false, false);
  private OnlineStatusDisplayInfoBuilder jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusDisplayInfoBuilder = new OnlineStatusDisplayInfoBuilder();
  private OnlineStatusObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver = new AccountOnlineStateActivity.7(this);
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
  private OnlineStatusPermissionObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver = new AccountOnlineStateActivity.6(this);
  private OnlineStatusViewCtrl jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl;
  private StatusCardViewHolder jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder = new StatusCardViewHolder();
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  protected QQProgressDialog a;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new AccountOnlineStateActivity.5(this);
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private AutoReplyText jdField_b_of_type_ComTencentMobileqqDataAutoReplyText;
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private AppRuntime.Status jdField_b_of_type_MqqAppAppRuntime$Status;
  private boolean jdField_b_of_type_Boolean = false;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View d;
  
  public AccountOnlineStateActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  }
  
  private void a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    if (paramOnlineStatusPermissionItem == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem != null) && (!this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.isAllHasPermission()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountOnlineStateActivity", 2, "account_online_status_show_all! mOnlinePermission is part");
      }
      this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = paramOnlineStatusPermissionItem;
  }
  
  private void a(boolean paramBoolean)
  {
    int j = 0;
    ArrayList localArrayList;
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter != null)
    {
      localArrayList = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter.a();
      if (this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText == null) {
        break label70;
      }
    }
    label70:
    for (int i = this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText.mTextId;; i = 0)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqDataAutoReplyText != null) {
        j = this.jdField_b_of_type_ComTencentMobileqqDataAutoReplyText.mTextId;
      }
      ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(localArrayList, i, j, paramBoolean);
      return;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, "onSubmitted online status " + paramBoolean + ", retCode = " + paramInt);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    if (paramBoolean)
    {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131719506, 1).a();
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
    }
    for (;;)
    {
      ReportHelperKt.a("0X800AF9D");
      return;
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131719504, 1).a();
    }
  }
  
  private boolean a(OnlineStatusItem paramOnlineStatusItem, AppRuntime.Status paramStatus)
  {
    AppRuntime.Status localStatus = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
    long l = OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return (paramStatus == localStatus) && ((l == paramOnlineStatusItem.jdField_a_of_type_Long) || ((l > 40000L) && (paramOnlineStatusItem.jdField_a_of_type_Long > 40000L)));
  }
  
  private boolean a(AppRuntime.Status paramStatus, long paramLong)
  {
    AppRuntime.Status localStatus = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
    long l = OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return (paramStatus == localStatus) && ((l == paramLong) || ((l > 40000L) && (paramLong > 40000L)));
  }
  
  private void b()
  {
    setRightButton(2131694615, new AccountOnlineStateActivity.1(this));
    setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131719514));
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130839537));
    Object localObject = getResources().getDrawable(2130844830);
    OnlineStatusPanelParams localOnlineStatusPanelParams = new OnlineStatusPanelParams();
    localOnlineStatusPanelParams.a = 2;
    localOnlineStatusPanelParams.jdField_b_of_type_Boolean = false;
    localOnlineStatusPanelParams.c = false;
    localOnlineStatusPanelParams.h = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl = new OnlineStatusViewCtrl(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localLinearLayout, this, localOnlineStatusPanelParams, this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter = new AutoReplyAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (Drawable)localObject);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter.a(this);
    this.jdField_a_of_type_MqqAppAppRuntime$Status = ((AppRuntime.Status)getActivity().getIntent().getSerializableExtra("KEY_ONLINE_STATUS"));
    this.jdField_a_of_type_Long = getActivity().getIntent().getLongExtra("KEY_ONLINE_EXT_STATUS", 0L);
    if (this.jdField_a_of_type_MqqAppAppRuntime$Status == null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
      this.jdField_a_of_type_Long = OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_b_of_type_MqqAppAppRuntime$Status = this.jdField_a_of_type_MqqAppAppRuntime$Status;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long, this);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)this.mContentView.findViewById(2131361919));
    if ((this.jdField_a_of_type_ComTencentWidgetListView instanceof SwipListView))
    {
      ((SwipListView)this.jdField_a_of_type_ComTencentWidgetListView).setDragEnable(true);
      ((SwipListView)this.jdField_a_of_type_ComTencentWidgetListView).setRightIconMenuListener(new AccountOnlineStateActivity.2(this));
    }
    this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView(localLinearLayout);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter);
    this.jdField_a_of_type_ComTencentWidgetListView.setDividerHeight(0);
    localObject = View.inflate(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131558423, null);
    if (getActivity().getIntent().getBooleanExtra("KEY_HAS_LEFT_BUTTON_TEXT", false)) {
      setLeftButton(2131690800, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localLinearLayout, 0);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.b().setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a().setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    b((View)localObject);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370783));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)paramView.findViewById(2131361911));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379381));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)paramView.findViewById(2131361916));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131372517);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378063));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378077));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131361914);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131369363);
    this.d = paramView.findViewById(2131378078);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361913));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361912));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    a(this.jdField_a_of_type_Long, false);
  }
  
  private void c()
  {
    int j = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.isAllHasPermission())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.d.setVisibility(8);
    }
    for (;;)
    {
      Object localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      int i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.isAllHasPermission()) {
        i = 8;
      }
      ((ImageView)localObject).setVisibility(i);
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.d.setVisibility(0);
      } while (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins() == null);
      localObject = new SpannableStringBuilder();
      i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size())
      {
        Long localLong = (Long)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().get(i);
        ((SpannableStringBuilder)localObject).append(ContactUtils.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localLong)));
        if (i != this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size() - 1) {
          ((SpannableStringBuilder)localObject).append("、");
        }
        i += 1;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(((SpannableStringBuilder)localObject).toString());
      localObject = getResources().getDrawable(2130839414);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size() > 0) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText("（" + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size() + "人）");
      } else {
        this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      }
    }
  }
  
  private void c(View paramView)
  {
    paramView = (MyMoodView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.a(paramView, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg, this, 1055L);
    paramView.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    if (OnLineStatusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus(), OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {}
    for (int i = 2;; i = 1)
    {
      ReportHelperKt.a("0X800B7AE", i);
      paramView.show();
      return;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)getActivity().getIntent().getSerializableExtra("online_status_permission_item"));
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null)
      {
        OnlineStatusFriendsPermissionItem localOnlineStatusFriendsPermissionItem = ((OnlineStatusPermissionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER)).a(40001L, false, this);
        if (localOnlineStatusFriendsPermissionItem != null)
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, localOnlineStatusFriendsPermissionItem.allHasPermission, localOnlineStatusFriendsPermissionItem.permissionUins);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem != null) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.filterNotFriend();
      }
      return;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, true, null);
      continue;
      this.jdField_a_of_type_Boolean = false;
      continue;
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void e()
  {
    boolean bool1 = OnLineStatusHelper.a(this.jdField_b_of_type_MqqAppAppRuntime$Status, this.jdField_b_of_type_Long);
    boolean bool2 = OnLineStatusHelper.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, new Object[] { "refreshPanelWhenMoodChange last=", Long.valueOf(this.jdField_b_of_type_Long), " curExtID=", Long.valueOf(this.jdField_a_of_type_Long) });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl != null) && ((bool2) || (bool1))) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(true, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, "onSubmit online status " + this.jdField_a_of_type_MqqAppAppRuntime$Status);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131719505, 1).a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter.b()) {
      a(true);
    }
    for (;;)
    {
      OnlineStatusDataReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      OnlineStatusDataReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText);
      int i = AutoReplyUtil.a(this.jdField_a_of_type_MqqAppAppRuntime$Status);
      if (i <= 0) {
        break;
      }
      ReportHelperKt.a("0X800B23A", i);
      return;
      OnlineStatusItem localOnlineStatusItem = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a();
      if (localOnlineStatusItem == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AccountOnlineStateActivity", 2, "onSubmit online status is empty");
        return;
      }
      AppRuntime.Status localStatus = OnLineStatusHelper.a().a(localOnlineStatusItem);
      BaseOnlineStatusDisplayInfo localBaseOnlineStatusDisplayInfo = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusDisplayInfoBuilder.a(localOnlineStatusItem.jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      if ((localStatus != null) && (!a(localOnlineStatusItem, localStatus)))
      {
        if (localBaseOnlineStatusDisplayInfo != null)
        {
          this.jdField_b_of_type_Boolean = true;
          localBaseOnlineStatusDisplayInfo.a(false, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateOnlineStatus(localStatus, localOnlineStatusItem.jdField_a_of_type_Long);
          this.jdField_b_of_type_Boolean = true;
        }
      }
      else if (localBaseOnlineStatusDisplayInfo != null)
      {
        this.jdField_b_of_type_Boolean = true;
        localBaseOnlineStatusDisplayInfo.a(true, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem);
      }
      else
      {
        a(true, 0);
      }
    }
  }
  
  private void g()
  {
    List localList = ((AutoReplyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AUTO_REPLY_MANAGER)).a();
    if ((localList != null) && (localList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter.a(localList);
    }
    ThreadManager.getSubThreadHandler().post(new AccountOnlineStateActivity.3(this));
  }
  
  TopGestureLayout a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent()) {
      if ((paramView instanceof TopGestureLayout)) {
        return (TopGestureLayout)paramView;
      }
    }
    return null;
  }
  
  public ArrayList<Integer> a()
  {
    AutoStatusAccountView localAutoStatusAccountView = (AutoStatusAccountView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.a(40000L);
    if (localAutoStatusAccountView == null) {
      return null;
    }
    return localAutoStatusAccountView.a();
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Long, false);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl != null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(this.jdField_b_of_type_MqqAppAppRuntime$Status, this.jdField_b_of_type_Long, this);
    }
  }
  
  public void a(long paramLong)
  {
    if (paramLong == 40001L)
    {
      a(((AutoStatusAccountView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.a(40000L)).a());
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(AppRuntime.Status.online, 40001L, this);
    }
    while (!OnLineStatusHelper.a(AppRuntime.Status.online, paramLong)) {
      return;
    }
    a(OnLineStatusHelper.a().a(AppRuntime.Status.online, paramLong), null);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
      return;
    }
    BaseOnlineStatusDisplayInfo localBaseOnlineStatusDisplayInfo = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusDisplayInfoBuilder.a(paramLong, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    if (localBaseOnlineStatusDisplayInfo == null)
    {
      this.jdField_a_of_type_ComTencentWidgetListView.removeFooterView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      return;
    }
    label79:
    String str;
    if (localBaseOnlineStatusDisplayInfo.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      d();
      c();
      if (paramBoolean) {
        break label246;
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent() == null) {
        this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!TextUtils.isEmpty(localBaseOnlineStatusDisplayInfo.jdField_a_of_type_JavaLangString)) {
        break label248;
      }
      str = "";
      label126:
      ((TextView)localObject).setText(str);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!TextUtils.isEmpty(localBaseOnlineStatusDisplayInfo.b)) {
        break label258;
      }
      str = "在线";
      label155:
      ((FormSimpleItem)localObject).setLeftText(str);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!TextUtils.isEmpty(localBaseOnlineStatusDisplayInfo.c)) {
        break label268;
      }
      str = "";
      label184:
      ((FormSimpleItem)localObject).setRightText(str);
      if (!localBaseOnlineStatusDisplayInfo.a()) {
        break label278;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(true);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localBaseOnlineStatusDisplayInfo.d)) {
        break label297;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      return;
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      break label79;
      label246:
      break;
      label248:
      str = localBaseOnlineStatusDisplayInfo.jdField_a_of_type_JavaLangString;
      break label126;
      label258:
      str = localBaseOnlineStatusDisplayInfo.b;
      break label155;
      label268:
      str = localBaseOnlineStatusDisplayInfo.c;
      break label184;
      label278:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(false);
    }
    label297:
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(localBaseOnlineStatusDisplayInfo.d);
  }
  
  public void a(View paramView) {}
  
  public void a(AutoReplyText paramAutoReplyText)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, "text is added, text = " + paramAutoReplyText);
    }
    setRightButtonEnable(true);
  }
  
  public void a(AutoReplyText paramAutoReplyText1, AutoReplyText paramAutoReplyText2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, paramAutoReplyText1 + " is checked, lastChecked is " + paramAutoReplyText2);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText = paramAutoReplyText1;
    this.jdField_b_of_type_ComTencentMobileqqDataAutoReplyText = paramAutoReplyText2;
    if (paramAutoReplyText2 != null) {
      setRightButtonEnable(true);
    }
  }
  
  public void a(AutoReplyText paramAutoReplyText, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, paramAutoReplyText + " is delete");
    }
    setRightButtonEnable(true);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009E88", "0X8009E88", 0, 0, "", "", "", "");
  }
  
  public void a(OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem, List<Integer> paramList)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, paramOnlineStatusFriendsPermissionItem.allHasPermission, paramOnlineStatusFriendsPermissionItem.permissionUins);
      a(this.jdField_a_of_type_Long, true);
    }
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem, View paramView)
  {
    setRightButtonEnable(true);
    if (paramOnlineStatusItem != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = OnLineStatusHelper.a().a(paramOnlineStatusItem);
      this.jdField_a_of_type_Long = paramOnlineStatusItem.jdField_a_of_type_Long;
    }
    if ((paramView != null) && (OnLineStatusHelper.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long))) {
      c(paramView);
    }
    do
    {
      return;
      e();
      this.jdField_b_of_type_MqqAppAppRuntime$Status = this.jdField_a_of_type_MqqAppAppRuntime$Status;
      this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter.a(OnlineStatusConstants.a(this.jdField_a_of_type_MqqAppAppRuntime$Status));
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      paramOnlineStatusItem = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusDisplayInfoBuilder.a(this.jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      if (paramOnlineStatusItem != null) {
        paramOnlineStatusItem.d();
      }
    } while (this.jdField_a_of_type_AndroidWidgetLinearLayout == null);
    a(this.jdField_a_of_type_Long, false);
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem1, OnlineStatusItem paramOnlineStatusItem2, View paramView)
  {
    a(paramOnlineStatusItem2, paramView);
  }
  
  public ArrayList<OnlineStatusItem> b()
  {
    return OnLineStatusHelper.a().a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
  }
  
  public void b(AutoReplyText paramAutoReplyText, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, paramAutoReplyText + " is click");
    }
    setRightButtonEnable(true);
    if ((paramAutoReplyText != null) && (paramAutoReplyText.getExtra().getBoolean("addFlag", false))) {
      OnlineStatusDataReporter.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      AutoReplyEditActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 325, paramAutoReplyText);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009E87", "0X8009E87", 0, 0, "", "", "", "");
  }
  
  public ArrayList<OnlineStatusItem> c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl != null) {
      return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a();
    }
    return null;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
      b();
      g();
      if (!a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long)) {
        break label109;
      }
      setRightButtonEnable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnBatteryChangeObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver);
      return;
      label109:
      setRightButtonEnable(true);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131558424;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {
      if ((paramInt1 == 100) && (paramInt2 == 0)) {
        ReportHelperKt.a("0X800AF4B", 2);
      }
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt1 != 325) {
            break;
          }
        } while (paramInt2 != 325);
        localObject = (AutoReplyText)paramIntent.getParcelableExtra("AutoReplyEditActivity:text");
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter.a((AutoReplyText)localObject);
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter.a(((AutoReplyText)localObject).getTextId());
        }
      } while ((!paramIntent.getBooleanExtra("AutoReplyEditActivity:new_text", false)) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null));
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131690331, 1).a();
      return;
      if (paramInt1 != 100) {
        break;
      }
      paramIntent = OnlineStatusPermissionChecker.a(paramIntent, paramInt2, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, false);
    } while (paramIntent == null);
    a(paramIntent);
    a(this.jdField_a_of_type_Long, true);
    ReportHelperKt.a("0X800AF4A", 2);
    return;
    if (paramInt1 == 1040)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusDisplayInfoBuilder.a(((OnlineStatusItem)localObject).jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).a(paramInt1, paramInt2, paramIntent);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter.b()) {
      if (NetworkUtil.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
        a(false);
      }
    }
    while (!getRightTextView().isEnabled())
    {
      ReportHelperKt.a("0X800AF9B", 1);
      super.onBackEvent();
      return true;
      QLog.d("AccountOnlineStateActivity", 2, "onBackEvent network is not available");
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("AccountOnlineStateActivity", 2, "onBackEvent auto reply list not changed!");
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698428);
    String str1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131695046);
    String str2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131718650);
    localObject = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, null, (CharSequence)localObject, str1, str2, new AccountOnlineStateActivity.9(this), new AccountOnlineStateActivity.10(this));
    ((QQCustomDialog)localObject).setMessageMaxLine(1);
    ((QQCustomDialog)localObject).show();
    ReportHelperKt.a("0X800AF9B", 2);
    return true;
  }
  
  public void onClick(View paramView)
  {
    setRightButtonEnable(true);
    Object localObject;
    switch (paramView.getId())
    {
    default: 
    case 2131361914: 
    case 2131365509: 
    case 2131365511: 
    case 2131361911: 
    case 2131361916: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("AccountOnlineStateActivity", 2, "account_online_status_show_all!");
        }
        if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)
        {
          a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(this.jdField_a_of_type_Long, true, null));
          a(this.jdField_a_of_type_Long, true);
        }
        ReportHelperKt.a("0X800AF99", 1);
        continue;
        AutoStatusAccountView localAutoStatusAccountView = (AutoStatusAccountView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.a(paramView, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg, this, 40000L);
        boolean bool = OnlineStatusItem.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
        if (this.jdField_a_of_type_Boolean) {}
        for (localObject = null;; localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem)
        {
          localAutoStatusAccountView.a(bool, (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject);
          break;
        }
        CustomOnlineStatusManager.Utils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "panel");
        ReportHelperKt.a("0X800AF42", 2);
        continue;
        localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusDisplayInfoBuilder.a(this.jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        if (localObject != null)
        {
          ((BaseOnlineStatusDisplayInfo)localObject).b();
          continue;
          localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusDisplayInfoBuilder.a(this.jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          if (localObject != null) {
            ((BaseOnlineStatusDisplayInfo)localObject).c();
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, "account_online_status_show_part!");
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
      if (QLog.isColorLevel())
      {
        if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null)
        {
          localObject = "null";
          label323:
          QLog.d("AccountOnlineStateActivity", 2, new Object[] { "account_online_status_show_part! mLastPartPermission:", localObject });
        }
      }
      else
      {
        if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem != null) {
          break label383;
        }
        OnlineStatusPermissionChecker.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem, false);
      }
    }
    for (;;)
    {
      ReportHelperKt.a("0X800AF99", 2);
      break;
      localObject = " not null";
      break label323;
      label383:
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
      a(this.jdField_a_of_type_Long, true);
      continue;
      OnlineStatusPermissionChecker.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem, false);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnBatteryChangeObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusDisplayInfoBuilder.a();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.b();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity
 * JD-Core Version:    0.7.0.1
 */