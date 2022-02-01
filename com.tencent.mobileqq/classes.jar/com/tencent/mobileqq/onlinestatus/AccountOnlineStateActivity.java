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
import anum;
import anuw;
import aqqy;
import azfd;
import azfe;
import azff;
import azfg;
import azfh;
import azfi;
import azfj;
import azfk;
import azfl;
import azfm;
import azgj;
import azgs;
import azhg;
import azhh;
import azhi;
import azhk;
import azhl;
import azho;
import azhq;
import azhv;
import azhx;
import azhz;
import azib;
import azie;
import azif;
import azih;
import azij;
import azik;
import azin;
import azip;
import aziq;
import azir;
import azlp;
import bdll;
import bhlg;
import bhlq;
import bhnv;
import bhpc;
import bhxv;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
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
  implements View.OnClickListener, azgs, azhi, azif, azij, aziq
{
  private long jdField_a_of_type_Long;
  private volatile FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anuw jdField_a_of_type_Anuw = new azfh(this);
  private azgj jdField_a_of_type_Azgj;
  private azhk jdField_a_of_type_Azhk = new azfl(this);
  private azhl jdField_a_of_type_Azhl = new azhl();
  private azho jdField_a_of_type_Azho = new azho(false, false);
  private azhz jdField_a_of_type_Azhz = new azhz();
  private azie jdField_a_of_type_Azie = new azfk(this);
  private azik jdField_a_of_type_Azik = new azfj(this);
  private azip jdField_a_of_type_Azip;
  private azlp jdField_a_of_type_Azlp;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AutoReplyText jdField_a_of_type_ComTencentMobileqqDataAutoReplyText;
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new azfi(this);
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
    if (this.jdField_a_of_type_Azgj != null)
    {
      localArrayList = this.jdField_a_of_type_Azgj.a();
      if (this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText == null) {
        break label68;
      }
    }
    label68:
    for (int i = this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText.mTextId;; i = 0)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqDataAutoReplyText != null) {
        j = this.jdField_b_of_type_ComTencentMobileqqDataAutoReplyText.mTextId;
      }
      ((anum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(localArrayList, i, j, paramBoolean);
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
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131718341, 1).a();
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
    }
    for (;;)
    {
      azir.a("0X800AF9D");
      return;
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131718339, 1).a();
    }
  }
  
  private boolean a(azib paramazib, AppRuntime.Status paramStatus)
  {
    AppRuntime.Status localStatus = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
    long l = azhq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return (paramStatus == localStatus) && ((l == paramazib.jdField_a_of_type_Long) || ((l > 40000L) && (paramazib.jdField_a_of_type_Long > 40000L)));
  }
  
  private boolean a(AppRuntime.Status paramStatus, long paramLong)
  {
    AppRuntime.Status localStatus = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
    long l = azhq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return (paramStatus == localStatus) && ((l == paramLong) || ((l > 40000L) && (paramLong > 40000L)));
  }
  
  private void b()
  {
    setRightButton(2131694098, new azfd(this));
    setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131718348));
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130839402));
    Object localObject = getResources().getDrawable(2130844727);
    this.jdField_a_of_type_Azip = new azip(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localLinearLayout, this, 3, 2);
    this.jdField_a_of_type_Azip.a();
    this.jdField_a_of_type_Azgj = new azgj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (Drawable)localObject);
    this.jdField_a_of_type_Azgj.a(this);
    this.jdField_a_of_type_MqqAppAppRuntime$Status = ((AppRuntime.Status)getActivity().getIntent().getSerializableExtra("KEY_ONLINE_STATUS"));
    this.jdField_a_of_type_Long = getActivity().getIntent().getLongExtra("KEY_ONLINE_EXT_STATUS", 0L);
    if (this.jdField_a_of_type_MqqAppAppRuntime$Status == null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
      this.jdField_a_of_type_Long = azhq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Azip.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long, this);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)this.mContentView.findViewById(2131361917));
    if ((this.jdField_a_of_type_ComTencentWidgetListView instanceof SwipListView))
    {
      ((SwipListView)this.jdField_a_of_type_ComTencentWidgetListView).setDragEnable(true);
      ((SwipListView)this.jdField_a_of_type_ComTencentWidgetListView).setRightIconMenuListener(new azfg(this));
    }
    this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView(localLinearLayout);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Azgj);
    this.jdField_a_of_type_ComTencentWidgetListView.setDividerHeight(0);
    localObject = View.inflate(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131558422, null);
    if (getActivity().getIntent().getBooleanExtra("KEY_HAS_LEFT_BUTTON_TEXT", false)) {
      setLeftButton(2131690580, null);
    }
    this.jdField_a_of_type_Azho.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localLinearLayout, 0);
    this.jdField_a_of_type_Azho.b().setOnClickListener(this);
    this.jdField_a_of_type_Azho.a().setOnClickListener(this);
    this.jdField_a_of_type_Azho.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Azho.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    b((View)localObject);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370351));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)paramView.findViewById(2131361909));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378885));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)paramView.findViewById(2131361914));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131372058);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377611));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377625));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131361912);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131368925);
    this.d = paramView.findViewById(2131377626);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361911));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361910));
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
        ((SpannableStringBuilder)localObject).append(bhlg.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localLong)));
        if (i != this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size() - 1) {
          ((SpannableStringBuilder)localObject).append("、");
        }
        i += 1;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(((SpannableStringBuilder)localObject).toString());
      localObject = getResources().getDrawable(2130839281);
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
        OnlineStatusFriendsPermissionItem localOnlineStatusFriendsPermissionItem = ((azih)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(370)).a(40001L, false, this);
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
    if (!bhnv.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131718340, 1).a();
      return;
    }
    if (this.jdField_a_of_type_Azgj.b()) {
      a(true);
    }
    for (;;)
    {
      azhx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      azhx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText);
      int i = aqqy.a(this.jdField_a_of_type_MqqAppAppRuntime$Status);
      if (i <= 0) {
        break;
      }
      azir.a("0X800B23A", i);
      return;
      azib localazib = this.jdField_a_of_type_Azip.a();
      AppRuntime.Status localStatus = azhq.a().a(localazib);
      azhh localazhh = this.jdField_a_of_type_Azhz.a(localazib.jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      if ((localStatus != null) && (!a(localazib, localStatus)))
      {
        if (localazhh != null)
        {
          this.jdField_b_of_type_Boolean = true;
          localazhh.a(false, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localStatus, localazib.jdField_a_of_type_Long);
          this.jdField_b_of_type_Boolean = true;
        }
      }
      else if (localazhh != null)
      {
        this.jdField_b_of_type_Boolean = true;
        localazhh.a(true, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem);
      }
      else
      {
        a(true, 0);
      }
    }
  }
  
  private void f()
  {
    List localList = ((azhg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(319)).a();
    if ((localList != null) && (localList.size() > 0) && (this.jdField_a_of_type_Azgj != null)) {
      this.jdField_a_of_type_Azgj.a(localList);
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
    if (this.jdField_a_of_type_Azlp == null) {
      return null;
    }
    return this.jdField_a_of_type_Azlp.c();
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
    azhh localazhh = this.jdField_a_of_type_Azhz.a(paramLong, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    if (localazhh == null)
    {
      this.jdField_a_of_type_ComTencentWidgetListView.removeFooterView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      return;
    }
    label79:
    String str;
    if (localazhh.jdField_a_of_type_Boolean)
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
      if (!TextUtils.isEmpty(localazhh.jdField_a_of_type_JavaLangString)) {
        break label248;
      }
      str = "";
      label126:
      ((TextView)localObject).setText(str);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!TextUtils.isEmpty(localazhh.b)) {
        break label258;
      }
      str = "在线";
      label155:
      ((FormSimpleItem)localObject).setLeftText(str);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!TextUtils.isEmpty(localazhh.c)) {
        break label268;
      }
      str = "";
      label184:
      ((FormSimpleItem)localObject).setRightText(str);
      if (!localazhh.a()) {
        break label278;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(true);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localazhh.d)) {
        break label297;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      return;
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      break label79;
      label246:
      break;
      label248:
      str = localazhh.jdField_a_of_type_JavaLangString;
      break label126;
      label258:
      str = localazhh.b;
      break label155;
      label268:
      str = localazhh.c;
      break label184;
      label278:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(false);
    }
    label297:
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(localazhh.d);
  }
  
  public void a(View paramView) {}
  
  public void a(azib paramazib)
  {
    setRightButtonEnable(true);
    if (paramazib != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = azhq.a().a(paramazib);
      this.jdField_a_of_type_Long = paramazib.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Azgj.a(azhv.a(this.jdField_a_of_type_MqqAppAppRuntime$Status));
    this.jdField_a_of_type_Azho.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    paramazib = this.jdField_a_of_type_Azhz.a(this.jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    if (paramazib != null) {
      paramazib.d();
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      a(this.jdField_a_of_type_Long, false);
    }
  }
  
  public void a(azib paramazib1, azib paramazib2, View paramView)
  {
    a(paramazib2);
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
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009E88", "0X8009E88", 0, 0, "", "", "", "");
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
      azhx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      AutoReplyEditActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 325, paramAutoReplyText);
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009E87", "0X8009E87", 0, 0, "", "", "", "");
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anuw);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Azhk);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Azie);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Azik);
      return;
      label109:
      setRightButtonEnable(true);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131558423;
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
        azir.a("0X800AF4B", 2);
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
            this.jdField_a_of_type_Azgj.a((AutoReplyText)localObject);
            this.jdField_a_of_type_Azgj.a(((AutoReplyText)localObject).getTextId());
          }
        } while ((!paramIntent.getBooleanExtra("AutoReplyEditActivity:new_text", false)) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null));
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131690203, 1).a();
        return;
        if (paramInt1 != 100) {
          break;
        }
        paramIntent = OnlineStatusPermissionChecker.a(paramIntent, paramInt2, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, false);
      } while (paramIntent == null);
      a(paramIntent);
      a(this.jdField_a_of_type_Long, true);
      azir.a("0X800AF4A", 2);
      return;
      if ((paramInt1 == 999) && (this.jdField_a_of_type_Azlp != null))
      {
        this.jdField_a_of_type_Azlp.a(paramInt1, paramInt2, paramIntent);
        return;
      }
    } while (paramInt1 != 1001);
    Object localObject = this.jdField_a_of_type_Azip.a();
    this.jdField_a_of_type_Azhz.a(((azib)localObject).jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Azgj.b()) {
      if (bhnv.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
        a(false);
      }
    }
    while (!getRightTextView().isEnabled())
    {
      azir.a("0X800AF9B", 1);
      super.onBackEvent();
      return true;
      QLog.d("AccountOnlineStateActivity", 2, "onBackEvent network is not available");
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("AccountOnlineStateActivity", 2, "onBackEvent auto reply list not changed!");
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131697723);
    String str1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131694493);
    String str2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131717528);
    localObject = bhlq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, null, (CharSequence)localObject, str1, str2, new azfm(this), new azfe(this));
    ((bhpc)localObject).setMessageMaxLine(1);
    ((bhpc)localObject).show();
    azir.a("0X800AF9B", 2);
    return true;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = null;
    setRightButtonEnable(true);
    switch (paramView.getId())
    {
    default: 
    case 2131361912: 
    case 2131365241: 
    case 2131363940: 
    case 2131365243: 
    case 2131361909: 
    case 2131361914: 
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
        azir.a("0X800AF99", 1);
        continue;
        if (this.jdField_a_of_type_Azlp == null)
        {
          this.jdField_a_of_type_Azlp = new azlp(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Azhl);
          this.jdField_a_of_type_Azlp.jdField_a_of_type_Int = 2;
          this.jdField_a_of_type_Azlp.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          this.jdField_a_of_type_Azlp.a(azin.a(paramView));
        }
        boolean bool = azib.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
        if (this.jdField_a_of_type_Boolean)
        {
          label216:
          if (Build.VERSION.SDK_INT < 23) {
            break label276;
          }
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.requestPermissions(new azff(this, bool, (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        }
        for (;;)
        {
          azir.a("0X800AF9A");
          azir.a("0X800AF3E", 2);
          break;
          localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
          break label216;
          label276:
          this.jdField_a_of_type_Azlp.a(bool);
          this.jdField_a_of_type_Azlp.a((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject);
          this.jdField_a_of_type_Azlp.show();
        }
        if (this.jdField_a_of_type_Azlp != null)
        {
          this.jdField_a_of_type_Azlp.c();
          a(this.jdField_a_of_type_Azlp.a());
          this.jdField_a_of_type_Azip.a(AppRuntime.Status.online, 40001L, this);
          this.jdField_a_of_type_Azlp.dismiss();
          azin.a(this.jdField_a_of_type_Azlp, paramView);
          continue;
          bhxv.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "panel");
          azir.a("0X800AF42", 2);
          continue;
          localObject = this.jdField_a_of_type_Azhz.a(this.jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          if (localObject != null)
          {
            ((azhh)localObject).b();
            continue;
            localObject = this.jdField_a_of_type_Azhz.a(this.jdField_a_of_type_Long, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
            if (localObject != null) {
              ((azhh)localObject).c();
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
      azir.a("0X800AF99", 2);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anuw);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azhk);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Azie);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azik);
    this.jdField_a_of_type_Azhz.a();
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