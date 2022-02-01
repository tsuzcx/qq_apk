package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anri;
import aqnl;
import ayyw;
import ayyx;
import ayyy;
import ayyz;
import ayza;
import ayzb;
import ayzc;
import ayzd;
import ayze;
import ayzf;
import azac;
import azal;
import azaz;
import azba;
import azbb;
import azbd;
import azbe;
import azbh;
import azbj;
import azbo;
import azbq;
import azbs;
import azbu;
import azby;
import azbz;
import azcb;
import azcd;
import azce;
import azch;
import azcj;
import azck;
import azcl;
import azfj;
import bdla;
import bhdj;
import bhmz;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
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
  implements View.OnClickListener, azal, azbb, azbz, azcd, azck
{
  private long jdField_a_of_type_Long;
  private volatile FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private azac jdField_a_of_type_Azac;
  private azbd jdField_a_of_type_Azbd = new ayze(this);
  private azbe jdField_a_of_type_Azbe = new azbe();
  private azbh jdField_a_of_type_Azbh = new azbh(false, false);
  private azbs jdField_a_of_type_Azbs = new azbs();
  private azby jdField_a_of_type_Azby = new ayzd(this);
  private azce jdField_a_of_type_Azce = new ayzc(this);
  private azcj jdField_a_of_type_Azcj;
  private azfj jdField_a_of_type_Azfj;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ayza(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AutoReplyText jdField_a_of_type_ComTencentMobileqqDataAutoReplyText;
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new ayzb(this);
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private AutoReplyText jdField_b_of_type_ComTencentMobileqqDataAutoReplyText;
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View d;
  
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
    if (this.jdField_a_of_type_Azac != null)
    {
      localArrayList = this.jdField_a_of_type_Azac.a();
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
      ((anri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(localArrayList, i, j, paramBoolean);
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
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131718972, 1).a();
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
    }
    for (;;)
    {
      azcl.a("0X800AF9D");
      return;
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131718970, 1).a();
    }
  }
  
  private boolean a(azbu paramazbu, AppRuntime.Status paramStatus)
  {
    AppRuntime.Status localStatus = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
    long l = azbj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return (paramStatus == localStatus) && ((l == paramazbu.jdField_a_of_type_Long) || ((l > 40000L) && (paramazbu.jdField_a_of_type_Long > 40000L)));
  }
  
  private boolean a(AppRuntime.Status paramStatus, long paramLong)
  {
    AppRuntime.Status localStatus = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
    long l = azbj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return (paramStatus == localStatus) && ((l == paramLong) || ((l > 40000L) && (paramLong > 40000L)));
  }
  
  private void b()
  {
    setRightButton(2131694399, new ayyw(this));
    setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131718979));
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130839458));
    Object localObject = getResources().getDrawable(2130844669);
    this.jdField_a_of_type_Azcj = new azcj(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localLinearLayout, this, 3, 2);
    this.jdField_a_of_type_Azcj.a();
    this.jdField_a_of_type_Azac = new azac(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (Drawable)localObject);
    this.jdField_a_of_type_Azac.a(this);
    this.jdField_a_of_type_MqqAppAppRuntime$Status = ((AppRuntime.Status)getActivity().getIntent().getSerializableExtra("KEY_ONLINE_STATUS"));
    this.jdField_a_of_type_Long = getActivity().getIntent().getLongExtra("KEY_ONLINE_EXT_STATUS", 0L);
    if (this.jdField_a_of_type_MqqAppAppRuntime$Status == null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
      this.jdField_a_of_type_Long = azbj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Azcj.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long, this);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)this.mContentView.findViewById(2131361919));
    if ((this.jdField_a_of_type_ComTencentWidgetListView instanceof SwipListView))
    {
      ((SwipListView)this.jdField_a_of_type_ComTencentWidgetListView).setDragEnable(true);
      ((SwipListView)this.jdField_a_of_type_ComTencentWidgetListView).setRightIconMenuListener(new ayyz(this));
    }
    this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView(localLinearLayout);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Azac);
    this.jdField_a_of_type_ComTencentWidgetListView.setDividerHeight(0);
    localObject = View.inflate(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131558423, null);
    if (getActivity().getIntent().getBooleanExtra("KEY_HAS_LEFT_BUTTON_TEXT", false)) {
      setLeftButton(2131690697, null);
    }
    this.jdField_a_of_type_Azbh.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localLinearLayout, 0);
    this.jdField_a_of_type_Azbh.b().setOnClickListener(this);
    this.jdField_a_of_type_Azbh.a().setOnClickListener(this);
    this.jdField_a_of_type_Azbh.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Azbh.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    b((View)localObject);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370499));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)paramView.findViewById(2131361911));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378950));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)paramView.findViewById(2131361916));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131372215);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377652));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377666));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131361914);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131369112);
    this.d = paramView.findViewById(2131377667);
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
        ((SpannableStringBuilder)localObject).append(ContactUtils.getFriendShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localLong)));
        if (i != this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size() - 1) {
          ((SpannableStringBuilder)localObject).append("、");
        }
        i += 1;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(((SpannableStringBuilder)localObject).toString());
      localObject = getResources().getDrawable(2130839337);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size() > 0) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText("（" + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size() + "人）");
      } else {
        this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)getActivity().getIntent().getSerializableExtra("online_status_permission_item"));
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null)
      {
        OnlineStatusFriendsPermissionItem localOnlineStatusFriendsPermissionItem = ((azcb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER)).a(40001L, false, this);
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
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, "onSubmit online status " + this.jdField_a_of_type_MqqAppAppRuntime$Status);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131718971, 1).a();
      return;
    }
    if (this.jdField_a_of_type_Azac.b()) {
      a(true);
    }
    for (;;)
    {
      azbq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      azbq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText);
      int i = aqnl.a(this.jdField_a_of_type_MqqAppAppRuntime$Status);
      if (i <= 0) {
        break;
      }
      azcl.a("0X800B23A", i);
      return;
      azbu localazbu = this.jdField_a_of_type_Azcj.a();
      AppRuntime.Status localStatus = azbj.a().a(localazbu);
      azba localazba = this.jdField_a_of_type_Azbs.a(localazbu.jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      if ((localStatus != null) && (!a(localazbu, localStatus)))
      {
        if (localazba != null)
        {
          this.jdField_b_of_type_Boolean = true;
          localazba.a(false, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateOnlineStatus(localStatus, localazbu.jdField_a_of_type_Long);
          this.jdField_b_of_type_Boolean = true;
        }
      }
      else if (localazba != null)
      {
        this.jdField_b_of_type_Boolean = true;
        localazba.a(true, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem);
      }
      else
      {
        a(true, 0);
      }
    }
  }
  
  private void f()
  {
    List localList = ((azaz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AUTO_REPLY_MANAGER)).a();
    if ((localList != null) && (localList.size() > 0) && (this.jdField_a_of_type_Azac != null)) {
      this.jdField_a_of_type_Azac.a(localList);
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
    if (this.jdField_a_of_type_Azfj == null) {
      return null;
    }
    return this.jdField_a_of_type_Azfj.c();
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Long, false);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
      return;
    }
    azba localazba = this.jdField_a_of_type_Azbs.a(paramLong, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    if (localazba == null)
    {
      this.jdField_a_of_type_ComTencentWidgetListView.removeFooterView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      return;
    }
    label79:
    String str;
    if (localazba.jdField_a_of_type_Boolean)
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
      if (!TextUtils.isEmpty(localazba.jdField_a_of_type_JavaLangString)) {
        break label248;
      }
      str = "";
      label126:
      ((TextView)localObject).setText(str);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!TextUtils.isEmpty(localazba.b)) {
        break label258;
      }
      str = "在线";
      label155:
      ((FormSimpleItem)localObject).setLeftText(str);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!TextUtils.isEmpty(localazba.c)) {
        break label268;
      }
      str = "";
      label184:
      ((FormSimpleItem)localObject).setRightText(str);
      if (!localazba.a()) {
        break label278;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(true);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localazba.d)) {
        break label297;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      return;
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      break label79;
      label246:
      break;
      label248:
      str = localazba.jdField_a_of_type_JavaLangString;
      break label126;
      label258:
      str = localazba.b;
      break label155;
      label268:
      str = localazba.c;
      break label184;
      label278:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(false);
    }
    label297:
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(localazba.d);
  }
  
  public void a(View paramView) {}
  
  public void a(azbu paramazbu)
  {
    setRightButtonEnable(true);
    if (paramazbu != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = azbj.a().a(paramazbu);
      this.jdField_a_of_type_Long = paramazbu.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Azac.a(azbo.a(this.jdField_a_of_type_MqqAppAppRuntime$Status));
    this.jdField_a_of_type_Azbh.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    paramazbu = this.jdField_a_of_type_Azbs.a(this.jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    if (paramazbu != null) {
      paramazbu.d();
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      a(this.jdField_a_of_type_Long, false);
    }
  }
  
  public void a(azbu paramazbu1, azbu paramazbu2, View paramView)
  {
    a(paramazbu2);
  }
  
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
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009E88", "0X8009E88", 0, 0, "", "", "", "");
  }
  
  public void a(OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem, List<Integer> paramList)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, paramOnlineStatusFriendsPermissionItem.allHasPermission, paramOnlineStatusFriendsPermissionItem.permissionUins);
      a(this.jdField_a_of_type_Long, true);
    }
  }
  
  public void b(AutoReplyText paramAutoReplyText, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, paramAutoReplyText + " is click");
    }
    setRightButtonEnable(true);
    if ((paramAutoReplyText != null) && (paramAutoReplyText.getExtra().getBoolean("addFlag", false))) {
      azbq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      AutoReplyEditActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 325, paramAutoReplyText);
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009E87", "0X8009E87", 0, 0, "", "", "", "");
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
      b();
      f();
      if (!a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long)) {
        break label109;
      }
      setRightButtonEnable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Azbd);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Azby);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Azce);
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
        azcl.a("0X800AF4B", 2);
      }
    }
    do
    {
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
            this.jdField_a_of_type_Azac.a((AutoReplyText)localObject);
            this.jdField_a_of_type_Azac.a(((AutoReplyText)localObject).getTextId());
          }
        } while ((!paramIntent.getBooleanExtra("AutoReplyEditActivity:new_text", false)) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null));
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131690266, 1).a();
        return;
        if (paramInt1 != 100) {
          break;
        }
        paramIntent = OnlineStatusPermissionChecker.a(paramIntent, paramInt2, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, false);
      } while (paramIntent == null);
      a(paramIntent);
      a(this.jdField_a_of_type_Long, true);
      azcl.a("0X800AF4A", 2);
      return;
      if ((paramInt1 == 999) && (this.jdField_a_of_type_Azfj != null))
      {
        this.jdField_a_of_type_Azfj.a(paramInt1, paramInt2, paramIntent);
        return;
      }
    } while (paramInt1 != 1001);
    Object localObject = this.jdField_a_of_type_Azcj.a();
    this.jdField_a_of_type_Azbs.a(((azbu)localObject).jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Azac.b()) {
      if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
        a(false);
      }
    }
    while (!getRightTextView().isEnabled())
    {
      azcl.a("0X800AF9B", 1);
      super.onBackEvent();
      return true;
      QLog.d("AccountOnlineStateActivity", 2, "onBackEvent network is not available");
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("AccountOnlineStateActivity", 2, "onBackEvent auto reply list not changed!");
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698152);
    String str1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131694808);
    String str2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131718146);
    localObject = bhdj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, null, (CharSequence)localObject, str1, str2, new ayzf(this), new ayyx(this));
    ((QQCustomDialog)localObject).setMessageMaxLine(1);
    ((QQCustomDialog)localObject).show();
    azcl.a("0X800AF9B", 2);
    return true;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = null;
    setRightButtonEnable(true);
    switch (paramView.getId())
    {
    default: 
    case 2131361914: 
    case 2131365359: 
    case 2131364040: 
    case 2131365361: 
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
        azcl.a("0X800AF99", 1);
        continue;
        if (this.jdField_a_of_type_Azfj == null)
        {
          this.jdField_a_of_type_Azfj = new azfj(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Azbe);
          this.jdField_a_of_type_Azfj.jdField_a_of_type_Int = 2;
          this.jdField_a_of_type_Azfj.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          this.jdField_a_of_type_Azfj.a(azch.a(paramView));
        }
        boolean bool = azbu.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
        if (this.jdField_a_of_type_Boolean)
        {
          label216:
          if (Build.VERSION.SDK_INT < 23) {
            break label276;
          }
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.requestPermissions(new ayyy(this, bool, (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        }
        for (;;)
        {
          azcl.a("0X800AF9A");
          azcl.a("0X800AF3E", 2);
          break;
          localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
          break label216;
          label276:
          this.jdField_a_of_type_Azfj.a(bool);
          this.jdField_a_of_type_Azfj.a((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject);
          this.jdField_a_of_type_Azfj.show();
        }
        if (this.jdField_a_of_type_Azfj != null)
        {
          this.jdField_a_of_type_Azfj.c();
          a(this.jdField_a_of_type_Azfj.a());
          this.jdField_a_of_type_Azcj.a(AppRuntime.Status.online, 40001L, this);
          this.jdField_a_of_type_Azfj.dismiss();
          azch.a(this.jdField_a_of_type_Azfj, paramView);
          continue;
          bhmz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "panel");
          azcl.a("0X800AF42", 2);
          continue;
          localObject = this.jdField_a_of_type_Azbs.a(this.jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          if (localObject != null)
          {
            ((azba)localObject).b();
            continue;
            localObject = this.jdField_a_of_type_Azbs.a(this.jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
            if (localObject != null) {
              ((azba)localObject).c();
            }
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
          label485:
          QLog.d("AccountOnlineStateActivity", 2, new Object[] { "account_online_status_show_part! mLastPartPermission:", localObject });
        }
      }
      else
      {
        if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem != null) {
          break label545;
        }
        OnlineStatusPermissionChecker.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem, false);
      }
    }
    for (;;)
    {
      azcl.a("0X800AF99", 2);
      break;
      localObject = " not null";
      break label485;
      label545:
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azbd);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Azby);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azce);
    this.jdField_a_of_type_Azbs.a();
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