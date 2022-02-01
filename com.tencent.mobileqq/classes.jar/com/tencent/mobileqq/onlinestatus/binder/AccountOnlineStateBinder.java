package com.tencent.mobileqq.onlinestatus.binder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.mvvm.BaseViewBinder;
import com.tencent.mobileqq.onlinestatus.AutoReplyAdapter;
import com.tencent.mobileqq.onlinestatus.AutoReplyAdapter.OnAutoReplyItemListener;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo.UpdateUIListener;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnLineStatusCustomSmartViewCtrl;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusConstants;
import com.tencent.mobileqq.onlinestatus.OnlineStatusDataReporter;
import com.tencent.mobileqq.onlinestatus.OnlineStatusDisplayInfoBuilder;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPagerAdapter.OnStatusItemClickListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.OnlineStatusPanelListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanelParams;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusViewCtrl;
import com.tencent.mobileqq.onlinestatus.OnlineStatusViewCtrl.OnStatusItemCheckListener;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusData;
import com.tencent.mobileqq.onlinestatus.view.AutoStatusAccountView;
import com.tencent.mobileqq.onlinestatus.view.BaseStatusCardView.OnDismissCallback;
import com.tencent.mobileqq.onlinestatus.view.MyMoodView;
import com.tencent.mobileqq.onlinestatus.view.StatusCardViewHolder;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.ICardHandler;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime.Status;

public class AccountOnlineStateBinder
  extends BaseViewBinder
  implements View.OnClickListener, AutoReplyAdapter.OnAutoReplyItemListener, BaseOnlineStatusDisplayInfo.UpdateUIListener, OnlineStatusPagerAdapter.OnStatusItemClickListener, OnlineStatusPanel.OnlineStatusPanelListener, OnlineStatusViewCtrl.OnStatusItemCheckListener, BaseStatusCardView.OnDismissCallback
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private AutoReplyText jdField_a_of_type_ComTencentMobileqqDataAutoReplyText;
  private AutoReplyAdapter jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter;
  private OnLineStatusBlurBg jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg = new OnLineStatusBlurBg();
  private OnLineStatusCustomSmartViewCtrl jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl = new OnLineStatusCustomSmartViewCtrl(false, false);
  private OnlineStatusDisplayInfoBuilder jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusDisplayInfoBuilder = new OnlineStatusDisplayInfoBuilder();
  private OnlineStatusViewCtrl jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl;
  private AccountOnlineStateBinder.BinderCallback jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder$BinderCallback;
  private StatusCardViewHolder jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder = new StatusCardViewHolder();
  private AccountOnlineStateViewModel jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel;
  private QFormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private AutoReplyText jdField_b_of_type_ComTencentMobileqqDataAutoReplyText;
  private QFormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  
  public AccountOnlineStateBinder(AppInterface paramAppInterface, QBaseActivity paramQBaseActivity, AccountOnlineStateViewModel paramAccountOnlineStateViewModel, AccountOnlineStateBinder.BinderCallback paramBinderCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder$BinderCallback = paramBinderCallback;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel = paramAccountOnlineStateViewModel;
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (localObject1 != null)
    {
      if (((QBaseActivity)localObject1).isFinishing()) {
        return;
      }
      BaseOnlineStatusDisplayInfo localBaseOnlineStatusDisplayInfo = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusDisplayInfoBuilder.a(paramLong, this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      if (localBaseOnlineStatusDisplayInfo == null)
      {
        this.jdField_a_of_type_ComTencentWidgetListView.removeFooterView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
        return;
      }
      if (localBaseOnlineStatusDisplayInfo.jdField_a_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
        c();
      }
      else
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      if (paramBoolean) {
        return;
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent() == null) {
        this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      Object localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      paramBoolean = TextUtils.isEmpty(localBaseOnlineStatusDisplayInfo.jdField_a_of_type_JavaLangString);
      String str = "";
      if (paramBoolean) {
        localObject1 = "";
      } else {
        localObject1 = localBaseOnlineStatusDisplayInfo.jdField_a_of_type_JavaLangString;
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem;
      if (TextUtils.isEmpty(localBaseOnlineStatusDisplayInfo.b)) {
        localObject1 = "在线";
      } else {
        localObject1 = localBaseOnlineStatusDisplayInfo.b;
      }
      ((QFormSimpleItem)localObject2).setLeftText((CharSequence)localObject1);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem;
      if (TextUtils.isEmpty(localBaseOnlineStatusDisplayInfo.c)) {
        localObject1 = str;
      } else {
        localObject1 = localBaseOnlineStatusDisplayInfo.c;
      }
      ((QFormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
      if (localBaseOnlineStatusDisplayInfo.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setClickable(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.a(true);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setClickable(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.a(false);
      }
      if (TextUtils.isEmpty(localBaseOnlineStatusDisplayInfo.d))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setVisibility(8);
        return;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setLeftText(localBaseOnlineStatusDisplayInfo.d);
    }
  }
  
  private void a(View paramView, long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370417));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem = ((QFormSimpleItem)paramView.findViewById(2131361917));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378732));
    this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem = ((QFormSimpleItem)paramView.findViewById(2131361922));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131372101);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377491));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377503));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131361920);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131369092);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131377504);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361919));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361918));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setOnClickListener(this);
    a(paramLong, false);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter;
    if (localObject != null)
    {
      localObject = ((AutoReplyAdapter)localObject).a();
      AutoReplyText localAutoReplyText = this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText;
      int j = 0;
      int i;
      if (localAutoReplyText != null) {
        i = localAutoReplyText.mTextId;
      } else {
        i = 0;
      }
      localAutoReplyText = this.jdField_b_of_type_ComTencentMobileqqDataAutoReplyText;
      if (localAutoReplyText != null) {
        j = localAutoReplyText.mTextId;
      }
      ((ICardHandler)QRoute.api(ICardHandler.class)).setAutoReplyList((ArrayList)localObject, i, j, paramBoolean);
    }
  }
  
  private void b(View paramView)
  {
    paramView = (MyMoodView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg, this, 1055L);
    OnlineStatusData localOnlineStatusData = (OnlineStatusData)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a().getValue();
    paramView.a(localOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status, localOnlineStatusData.jdField_a_of_type_Long);
    int i;
    if (OnLineStatusHelper.a(((IOnlineStatusService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus(), OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface))) {
      i = 2;
    } else {
      i = 1;
    }
    ReportHelperKt.a("0X800B7AE", i);
    paramView.show();
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
  }
  
  private void c()
  {
    OnlineStatusPermissionChecker.OnlineStatusPermissionItem localOnlineStatusPermissionItem = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.f().getValue();
    boolean bool = localOnlineStatusPermissionItem.isAllHasPermission();
    int j = 8;
    int i;
    if (bool)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      if (localOnlineStatusPermissionItem.getPermissionUins() == null) {
        return;
      }
      localObject1 = new SpannableStringBuilder();
      i = 0;
      Object localObject2;
      while (i < localOnlineStatusPermissionItem.getPermissionUins().size())
      {
        localObject2 = (Long)localOnlineStatusPermissionItem.getPermissionUins().get(i);
        ((SpannableStringBuilder)localObject1).append(((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getFriendShowName(String.valueOf(localObject2)));
        if (i != localOnlineStatusPermissionItem.getPermissionUins().size() - 1) {
          ((SpannableStringBuilder)localObject1).append("、");
        }
        i += 1;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(((SpannableStringBuilder)localObject1).toString());
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130839270);
      ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject1, null);
      if (localOnlineStatusPermissionItem.getPermissionUins().size() > 0)
      {
        localObject1 = this.jdField_c_of_type_AndroidWidgetTextView;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("（");
        ((StringBuilder)localObject2).append(localOnlineStatusPermissionItem.getPermissionUins().size());
        ((StringBuilder)localObject2).append("人）");
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      }
    }
    Object localObject1 = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localOnlineStatusPermissionItem.isAllHasPermission()) {
      i = j;
    } else {
      i = 0;
    }
    ((ImageView)localObject1).setVisibility(i);
  }
  
  private void d()
  {
    OnlineStatusData localOnlineStatusData1 = (OnlineStatusData)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a().getValue();
    OnlineStatusData localOnlineStatusData2 = (OnlineStatusData)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.b().getValue();
    boolean bool1 = OnLineStatusHelper.a(localOnlineStatusData2.jdField_a_of_type_MqqAppAppRuntime$Status, localOnlineStatusData2.jdField_a_of_type_Long);
    boolean bool2 = OnLineStatusHelper.a(localOnlineStatusData1.jdField_a_of_type_MqqAppAppRuntime$Status, localOnlineStatusData1.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateBinder", 2, new Object[] { "refreshPanelWhenMoodChange last=", Long.valueOf(localOnlineStatusData2.jdField_a_of_type_Long), " curExtID=", Long.valueOf(localOnlineStatusData1.jdField_a_of_type_Long) });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl != null) && ((bool2) || (bool1))) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(true, localOnlineStatusData1.jdField_a_of_type_MqqAppAppRuntime$Status, localOnlineStatusData1.jdField_a_of_type_Long);
    }
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
  
  public ArrayList<OnlineStatusItem> a()
  {
    OnlineStatusData localOnlineStatusData = (OnlineStatusData)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a().getValue();
    return OnLineStatusHelper.a().a(localOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status, localOnlineStatusData.jdField_a_of_type_Long);
  }
  
  public void a()
  {
    a(((OnlineStatusData)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a().getValue()).jdField_a_of_type_Long, false);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl != null)
    {
      OnlineStatusData localOnlineStatusData = (OnlineStatusData)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.b().getValue();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(localOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status, localOnlineStatusData.jdField_a_of_type_Long, this);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    OnlineStatusItem localOnlineStatusItem = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusDisplayInfoBuilder.a(localOnlineStatusItem.jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(long paramLong)
  {
    if (paramLong == 40001L)
    {
      AutoStatusAccountView localAutoStatusAccountView = (AutoStatusAccountView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.a(40000L);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a(localAutoStatusAccountView.a());
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(AppRuntime.Status.online, 40001L, this);
      return;
    }
    if (OnLineStatusHelper.a(AppRuntime.Status.online, paramLong)) {
      a(OnLineStatusHelper.a().a(AppRuntime.Status.online, paramLong), null);
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter.b())
    {
      if (NetworkUtil.isNetworkAvailable(paramActivity))
      {
        a(false);
        return;
      }
      QLog.d("AccountOnlineStateBinder", 2, "onBackEvent network is not available");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateBinder", 2, "onBackEvent auto reply list not changed!");
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = a(paramView);
  }
  
  public void a(View paramView, TextView paramTextView, OnlineStatusData paramOnlineStatusData)
  {
    this.jdField_d_of_type_AndroidWidgetTextView = paramTextView;
    paramTextView = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    paramTextView.setOrientation(1);
    paramTextView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130839393));
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130844706);
    OnlineStatusPanelParams localOnlineStatusPanelParams = new OnlineStatusPanelParams();
    localOnlineStatusPanelParams.a = 2;
    localOnlineStatusPanelParams.b = false;
    localOnlineStatusPanelParams.c = false;
    localOnlineStatusPanelParams.h = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl = new OnlineStatusViewCtrl(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramTextView, this, localOnlineStatusPanelParams, this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter = new AutoReplyAdapter(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, localDrawable);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(paramOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status, paramOnlineStatusData.jdField_a_of_type_Long, this);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramView.findViewById(2131361925));
    paramView = this.jdField_a_of_type_ComTencentWidgetListView;
    if ((paramView instanceof SwipListView))
    {
      ((SwipListView)paramView).setDragEnable(true);
      ((SwipListView)this.jdField_a_of_type_ComTencentWidgetListView).setRightIconMenuListener(new AccountOnlineStateBinder.1(this));
    }
    this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView(paramTextView);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter);
    this.jdField_a_of_type_ComTencentWidgetListView.setDividerHeight(0);
    paramView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131558451, null);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramTextView, 0);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.b().setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a().setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status, paramOnlineStatusData.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    a(paramView, paramOnlineStatusData.jdField_a_of_type_Long);
  }
  
  public void a(LifecycleOwner paramLifecycleOwner)
  {
    paramLifecycleOwner.getLifecycle().addObserver(new AccountOnlineStateBinder.2(this));
  }
  
  public void a(LifecycleOwner paramLifecycleOwner, AccountOnlineStateViewModel paramAccountOnlineStateViewModel)
  {
    paramAccountOnlineStateViewModel.a().observe(paramLifecycleOwner, new AccountOnlineStateBinder.3(this));
  }
  
  public void a(AutoReplyText paramAutoReplyText)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("text is added, text = ");
      localStringBuilder.append(paramAutoReplyText);
      QLog.d("AccountOnlineStateBinder", 2, localStringBuilder.toString());
    }
    b(true);
  }
  
  public void a(AutoReplyText paramAutoReplyText1, AutoReplyText paramAutoReplyText2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAutoReplyText1);
      localStringBuilder.append(" is checked, lastChecked is ");
      localStringBuilder.append(paramAutoReplyText2);
      QLog.d("AccountOnlineStateBinder", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText = paramAutoReplyText1;
    this.jdField_b_of_type_ComTencentMobileqqDataAutoReplyText = paramAutoReplyText2;
    if (paramAutoReplyText2 != null) {
      b(true);
    }
  }
  
  public void a(AutoReplyText paramAutoReplyText, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAutoReplyText);
      localStringBuilder.append(" is delete");
      QLog.d("AccountOnlineStateBinder", 2, localStringBuilder.toString());
    }
    b(true);
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8009E88", "0X8009E88", 0, 0, "", "", "", "");
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem, View paramView)
  {
    b(true);
    OnlineStatusData localOnlineStatusData = (OnlineStatusData)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a().getValue();
    if (paramOnlineStatusItem != null)
    {
      localOnlineStatusData = new OnlineStatusData(OnLineStatusHelper.a().a(paramOnlineStatusItem), paramOnlineStatusItem.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a().setValue(localOnlineStatusData);
    }
    if ((paramView != null) && (OnLineStatusHelper.a(localOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status, localOnlineStatusData.jdField_a_of_type_Long)))
    {
      b(paramView);
      return;
    }
    d();
    paramOnlineStatusItem = new OnlineStatusData(localOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status, localOnlineStatusData.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.b().setValue(paramOnlineStatusItem);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter.a(OnlineStatusConstants.a(localOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, localOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status, localOnlineStatusData.jdField_a_of_type_Long);
    paramOnlineStatusItem = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusDisplayInfoBuilder.a(localOnlineStatusData.jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    if (paramOnlineStatusItem != null) {
      paramOnlineStatusItem.d();
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      a(localOnlineStatusData.jdField_a_of_type_Long, false);
    }
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem1, OnlineStatusItem paramOnlineStatusItem2, View paramView)
  {
    a(paramOnlineStatusItem2, paramView);
  }
  
  public ArrayList<OnlineStatusItem> b()
  {
    OnlineStatusViewCtrl localOnlineStatusViewCtrl = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl;
    if (localOnlineStatusViewCtrl != null) {
      return localOnlineStatusViewCtrl.a();
    }
    return null;
  }
  
  public void b()
  {
    OnlineStatusData localOnlineStatusData = (OnlineStatusData)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a().getValue();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSubmit online status ");
      ((StringBuilder)localObject).append(localOnlineStatusData.jdField_a_of_type_Long);
      QLog.d("AccountOnlineStateBinder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (localObject == null) {
      return;
    }
    if (!NetworkUtil.isNetworkAvailable((Context)localObject))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, 2131719223, 1).a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter.b())
    {
      a(true);
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a();
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AccountOnlineStateBinder", 2, "onSubmit online status is empty");
        }
        return;
      }
      BaseOnlineStatusDisplayInfo localBaseOnlineStatusDisplayInfo = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusDisplayInfoBuilder.a(((OnlineStatusItem)localObject).jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a((OnlineStatusItem)localObject, localBaseOnlineStatusDisplayInfo, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a(localOnlineStatusData, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText);
  }
  
  public void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void b(LifecycleOwner paramLifecycleOwner, AccountOnlineStateViewModel paramAccountOnlineStateViewModel)
  {
    paramAccountOnlineStateViewModel.c().observe(paramLifecycleOwner, new AccountOnlineStateBinder.4(this));
  }
  
  public void b(AutoReplyText paramAutoReplyText)
  {
    if (paramAutoReplyText != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter.a(paramAutoReplyText);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyAdapter.a(paramAutoReplyText.getTextId());
    }
  }
  
  public void b(@Nullable AutoReplyText paramAutoReplyText, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAutoReplyText);
      ((StringBuilder)localObject).append(" is click");
      QLog.d("AccountOnlineStateBinder", 2, ((StringBuilder)localObject).toString());
    }
    b(true);
    if ((paramAutoReplyText != null) && (paramAutoReplyText.getExtra().getBoolean("addFlag", false))) {
      OnlineStatusDataReporter.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (localObject != null) {
      AutoReplyEditActivity.a((Activity)localObject, 325, paramAutoReplyText);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8009E87", "0X8009E87", 0, 0, "", "", "", "");
  }
  
  public ArrayList<Integer> c()
  {
    AutoStatusAccountView localAutoStatusAccountView = (AutoStatusAccountView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.a(40000L);
    if (localAutoStatusAccountView == null) {
      return null;
    }
    return localAutoStatusAccountView.c();
  }
  
  public void c(View paramView) {}
  
  public void c(LifecycleOwner paramLifecycleOwner, AccountOnlineStateViewModel paramAccountOnlineStateViewModel)
  {
    paramAccountOnlineStateViewModel.d().observe(paramLifecycleOwner, new AccountOnlineStateBinder.5(this));
  }
  
  public void d(LifecycleOwner paramLifecycleOwner, AccountOnlineStateViewModel paramAccountOnlineStateViewModel)
  {
    paramAccountOnlineStateViewModel.e().observe(paramLifecycleOwner, new AccountOnlineStateBinder.6(this, paramAccountOnlineStateViewModel));
  }
  
  public void e(LifecycleOwner paramLifecycleOwner, AccountOnlineStateViewModel paramAccountOnlineStateViewModel)
  {
    paramAccountOnlineStateViewModel.f().observe(paramLifecycleOwner, new AccountOnlineStateBinder.7(this));
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    b(true);
    int i = paramView.getId();
    Object localObject = (OnlineStatusData)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a().getValue();
    if (i == 2131361920)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountOnlineStateBinder", 2, "account_online_status_show_all!");
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)
      {
        localObject = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(((OnlineStatusData)localObject).jdField_a_of_type_Long, true, null);
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject);
      }
      ReportHelperKt.a("0X800AF99", 1);
    }
    else if (i == 2131365355)
    {
      ((AutoStatusAccountView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg, this, 40000L)).a(OnlineStatusItem.a(((OnlineStatusData)localObject).jdField_a_of_type_MqqAppAppRuntime$Status, ((OnlineStatusData)localObject).jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a());
    }
    else if (i == 2131365357)
    {
      ((ICustomOnlineStatusManager)QRoute.api(ICustomOnlineStatusManager.class)).openH5(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, "panel");
      ReportHelperKt.a("0X800AF42", 2);
    }
    else if (i == 2131361917)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusDisplayInfoBuilder.a(((OnlineStatusData)localObject).jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      if (localObject != null) {
        ((BaseOnlineStatusDisplayInfo)localObject).b();
      }
    }
    else if (i == 2131361922)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusDisplayInfoBuilder.a(((OnlineStatusData)localObject).jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      if (localObject != null) {
        ((BaseOnlineStatusDisplayInfo)localObject).c();
      }
    }
    else if (i == 2131369092)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel;
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0) {
        bool = false;
      }
      ((AccountOnlineStateViewModel)localObject).a(bool, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountOnlineStateBinder
 * JD-Core Version:    0.7.0.1
 */