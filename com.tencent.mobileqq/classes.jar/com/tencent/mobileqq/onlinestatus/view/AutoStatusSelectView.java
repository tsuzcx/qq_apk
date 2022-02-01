package com.tencent.mobileqq.onlinestatus.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.config.business.OnlineStatusBean;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.BlurBgItem;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.OnLineStatusBlurBgListener;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPagerAdapter.OnStatusItemClickListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.OnlineStatusPanelListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanelParams;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager.ReceiveDataListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionServlet;
import com.tencent.mobileqq.onlinestatus.OnlineStatusViewCtrl;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusItem;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class AutoStatusSelectView
  extends BaseStatusCardView
  implements Handler.Callback, View.OnClickListener, OnLineStatusBlurBg.OnLineStatusBlurBgListener, OnlineStatusPagerAdapter.OnStatusItemClickListener, OnlineStatusPanel.OnlineStatusPanelListener, OnlineStatusPermissionManager.ReceiveDataListener
{
  public int a;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected ViewGroup a;
  public Button a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected TextView a;
  protected BaseActivity a;
  private OnLineStatusBlurBg jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg;
  protected OnlineStatusPermissionChecker.OnlineStatusPermissionItem a;
  protected OnlineStatusViewCtrl a;
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private boolean jdField_a_of_type_Boolean = true;
  protected int b;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  
  public AutoStatusSelectView(@NonNull BaseActivity paramBaseActivity, OnLineStatusBlurBg paramOnLineStatusBlurBg, BaseStatusCardView.OnDismissCallback paramOnDismissCallback)
  {
    super(paramBaseActivity, paramOnDismissCallback);
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 40001;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg = paramOnLineStatusBlurBg;
    if (paramOnLineStatusBlurBg == null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg = new OnLineStatusBlurBg();
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    c();
  }
  
  private void c()
  {
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131559252, null);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131380651));
    this.jdField_d_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(1));
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131365320);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131364141));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131363963));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131364285));
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(2));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131380411));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131367591));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377710));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewView.findViewById(2131372525));
    this.jdField_b_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView;
    this.jdField_a_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView;
    setContentView(this.jdField_c_of_type_AndroidViewView);
  }
  
  private void g()
  {
    boolean bool = OnlineStatusItem.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    int i;
    if (bool)
    {
      i = 0;
      if (!bool) {
        break label73;
      }
    }
    label73:
    for (int j = 32;; j = 86)
    {
      j = AIOUtils.a(j, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(i);
      if (i == 0) {
        ReportHelperKt.a("0X800B0F0");
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(j, 0, j, 0);
      return;
      i = 8;
      break;
    }
  }
  
  public OnlineStatusPermissionChecker.OnlineStatusPermissionItem a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
  }
  
  public ArrayList<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a();
    if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
      return localArrayList;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(Integer.valueOf((int)((OnlineStatusItem)((Iterator)localObject).next()).jdField_a_of_type_Long));
    }
    return localArrayList;
  }
  
  protected void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.jdField_a_of_type_MqqAppAppRuntime$Status = localQQAppInterface.getOnlineStatus();
    this.jdField_a_of_type_Long = OnLineStatusHelper.a().a(localQQAppInterface);
    g();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == this.jdField_b_of_type_Int) && (paramInt2 == -1) && (paramIntent.getSerializableExtra("online_status_permission_item") != null))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramIntent.getSerializableExtra("online_status_permission_item"));
      b(false);
    }
  }
  
  public void a(View paramView) {}
  
  public void a(OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem, List<Integer> paramList)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, paramOnlineStatusFriendsPermissionItem.allHasPermission, paramOnlineStatusFriendsPermissionItem.permissionUins);
      b(true);
    }
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem1, OnlineStatusItem paramOnlineStatusItem2, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusSelectView", 2, new Object[] { "oldItem =", paramOnlineStatusItem1, " oldItem=", paramOnlineStatusItem2 });
    }
    int i;
    if ((paramOnlineStatusItem1 == null) && (paramOnlineStatusItem2 != null))
    {
      i = 1;
      if (i != 0) {
        break label106;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691416);
    }
    for (;;)
    {
      b(false);
      if (i != 0) {
        ReportHelperKt.a("0X800AF3F", (int)paramOnlineStatusItem2.jdField_a_of_type_Long, String.valueOf(this.jdField_a_of_type_Int));
      }
      return;
      i = 0;
      break;
      label106:
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if ((paramOnlineStatusItem2 instanceof AutoStatusItem)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((AutoStatusItem)paramOnlineStatusItem2).d);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
    }
  }
  
  public void a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = paramOnlineStatusPermissionItem;
    if (paramOnlineStatusPermissionItem == null) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public void a(boolean paramBoolean, Bitmap paramBitmap, int paramInt)
  {
    if ((paramBoolean) && (paramBitmap != null) && (this.jdField_c_of_type_AndroidViewView != null)) {
      this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
    }
    while (this.jdField_c_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setBackgroundColor(paramInt);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusSelectView", 2, new Object[] { "hasChange =", Boolean.valueOf(paramBoolean1), " isSmartListEmpty=", Boolean.valueOf(paramBoolean2) });
    }
    if (!OnlineStatusItem.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131691410);
      if (paramBoolean2)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    if ((paramBoolean1) && (paramBoolean2))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131691411);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131691411);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(1));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131693161);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(2));
  }
  
  protected void a(int[] paramArrayOfInt)
  {
    if ((this.jdField_b_of_type_AndroidViewView.getWidth() != 0) && (this.jdField_b_of_type_AndroidViewView.getHeight() != 0))
    {
      paramArrayOfInt[0] = this.jdField_b_of_type_AndroidViewView.getWidth();
      paramArrayOfInt[1] = this.jdField_b_of_type_AndroidViewView.getHeight();
      return;
    }
    paramArrayOfInt[0] = (this.jdField_b_of_type_AndroidViewView.getResources().getDisplayMetrics().widthPixels - AIOUtils.a(26.0F, this.jdField_b_of_type_AndroidViewView.getResources()));
    paramArrayOfInt[1] = AIOUtils.a(480.0F, this.jdField_b_of_type_AndroidViewView.getResources());
  }
  
  protected boolean a()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null)
    {
      OnlineStatusFriendsPermissionItem localOnlineStatusFriendsPermissionItem = ((OnlineStatusPermissionManager)((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER)).a(40001L, false, this);
      return (localOnlineStatusFriendsPermissionItem != null) && (!localOnlineStatusFriendsPermissionItem.allHasPermission);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.isAllHasPermission()) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  protected boolean a(boolean paramBoolean)
  {
    OnlineStatusPermissionManager localOnlineStatusPermissionManager = (OnlineStatusPermissionManager)((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER);
    if ((this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem != null) && (localOnlineStatusPermissionManager.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem, this))) {
      return true;
    }
    if (paramBoolean) {
      return false;
    }
    return localOnlineStatusPermissionManager.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a());
  }
  
  public void aA_()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new AutoStatusSelectView.3(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
    for (;;)
    {
      ReportHelperKt.a("0X800AF3E", 1);
      return;
      a(null);
      show();
    }
  }
  
  public ArrayList<OnlineStatusItem> b()
  {
    OnlineAutoStatusBean localOnlineAutoStatusBean = (OnlineAutoStatusBean)QConfigManager.a().a(652);
    ArrayList localArrayList = new ArrayList();
    if ((localOnlineAutoStatusBean == null) || (localOnlineAutoStatusBean.a == null)) {
      return localArrayList;
    }
    return OnlineStatusBean.a(localOnlineAutoStatusBean.a.a(false));
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691416);
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl == null)
    {
      OnlineStatusPanelParams localOnlineStatusPanelParams = new OnlineStatusPanelParams();
      localOnlineStatusPanelParams.jdField_a_of_type_Int = 3;
      localOnlineStatusPanelParams.c = true;
      localOnlineStatusPanelParams.b = false;
      localOnlineStatusPanelParams.jdField_a_of_type_Boolean = true;
      localOnlineStatusPanelParams.f = 5;
      localOnlineStatusPanelParams.h = (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().widthPixels - AIOUtils.a(26.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()));
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl = new OnlineStatusViewCtrl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewViewGroup, this, localOnlineStatusPanelParams, this);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.b();
  }
  
  protected void b(View paramView)
  {
    boolean bool1 = false;
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131719505, 0).a();
      dismiss();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback.a(40001);
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    boolean bool2 = OnlineStatusItem.a(localQQAppInterface.getOnlineStatus(), OnLineStatusHelper.a().a(localQQAppInterface));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback.a(40001L);
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusSelectView", 4, new Object[] { " isCurStatusSmart =", Boolean.valueOf(bool2) });
    }
    OnlineStatusPermissionChecker.OnlineStatusPermissionItem localOnlineStatusPermissionItem = a();
    ArrayList localArrayList = a();
    if (!bool2) {
      bool1 = true;
    }
    OnlineStatusPermissionServlet.a(localQQAppInterface, localOnlineStatusPermissionItem, localArrayList, bool1);
    dismiss();
    paramView = paramView.getTag();
    if ((paramView instanceof Integer))
    {
      int i = ((Integer)paramView).intValue();
      if (i == 2)
      {
        paramView = a().iterator();
        while (paramView.hasNext()) {
          ReportHelperKt.a("0X800AF40", ((Integer)paramView.next()).intValue(), "1");
        }
      }
      if (i == 1)
      {
        paramView = a().iterator();
        while (paramView.hasNext()) {
          ReportHelperKt.a("0X800B00F", ((Integer)paramView.next()).intValue(), "1");
        }
      }
    }
    ReportHelperKt.a("0X8009DE0", 40001);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (boolean bool1 = b();; bool1 = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a().isEmpty())
    {
      boolean bool2 = a();
      boolean bool3 = a(paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusSelectView", 2, new Object[] { "isSmartListEmpty =", Boolean.valueOf(bool1), " hasPartVisible=", Boolean.valueOf(bool2), " hasDataChange=", Boolean.valueOf(bool3), " fromShow=", Boolean.valueOf(paramBoolean) });
      }
      a(bool3, bool1);
      b(bool2, bool1);
      return;
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    for (;;)
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      int i = 2131691409;
      if (paramBoolean1) {
        i = 2131691415;
      }
      String str1 = getContext().getResources().getString(i);
      String str2 = getContext().getResources().getString(2131691414);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(new QQText(str1, 3, 16));
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(str1);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(str2);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new AutoStatusSelectView.1(this, paramBoolean1));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
      if (ThemeImageWrapper.isNightMode()) {
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837509, 0);
      }
      while (AppSetting.d)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setAccessibilityDelegate(new AutoStatusSelectView.2(this));
        return;
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837508, 0);
      }
    }
  }
  
  protected boolean b()
  {
    List localList = ((OnlineStatusPermissionManager)((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER)).a();
    if (localList == null) {
      return true;
    }
    return localList.isEmpty();
  }
  
  public ArrayList<OnlineStatusItem> c()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = ((OnlineStatusPermissionManager)((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER)).a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      ArrayList localArrayList2 = b();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        Iterator localIterator = localArrayList2.iterator();
        while (localIterator.hasNext())
        {
          OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)localIterator.next();
          if (localOnlineStatusItem.jdField_a_of_type_Long == localInteger.intValue()) {
            localArrayList1.add(localOnlineStatusItem);
          }
        }
      }
    }
    return localArrayList1;
  }
  
  protected void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691416);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131377364)
    {
      dismiss();
      ReportHelperKt.a("0X800AF94");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131363963)
      {
        ReportHelperKt.a("0X800B0F1");
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.updateOnlineStatus(AppRuntime.Status.online, 0L);
        dismiss();
      }
      else if (paramView.getId() == 2131364141)
      {
        b(paramView);
      }
    }
  }
  
  public void show()
  {
    if (ThemeUtil.isNowThemeIsNight(null, false, ""))
    {
      this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130846455);
      a(false, null, Color.parseColor("#FF010101"));
    }
    for (;;)
    {
      b();
      a();
      b(true);
      a(this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, 2131165628, 2131167334);
      super.show();
      b(true);
      return;
      this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130846454);
      OnLineStatusBlurBg.BlurBgItem localBlurBgItem = new OnLineStatusBlurBg.BlurBgItem();
      localBlurBgItem.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg.a(localBlurBgItem, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AutoStatusSelectView
 * JD-Core Version:    0.7.0.1
 */