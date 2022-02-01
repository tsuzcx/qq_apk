package com.tencent.mobileqq.onlinestatus.view;

import android.annotation.TargetApi;
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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QBaseActivity;
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
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionServlet;
import com.tencent.mobileqq.onlinestatus.OnlineStatusViewCtrl;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusItem;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager.ReceiveDataListener;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
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
  protected QBaseActivity a;
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
  
  public AutoStatusSelectView(@NonNull QBaseActivity paramQBaseActivity, OnLineStatusBlurBg paramOnLineStatusBlurBg, BaseStatusCardView.OnDismissCallback paramOnDismissCallback)
  {
    super(paramQBaseActivity, paramOnDismissCallback);
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 40001;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg = paramOnLineStatusBlurBg;
    if (paramOnLineStatusBlurBg == null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg = new OnLineStatusBlurBg();
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    c();
  }
  
  @TargetApi(11)
  public static void a(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(paramFloat);
    }
  }
  
  private void c()
  {
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).inflate(2131559128, null);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131379930));
    this.jdField_d_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(1));
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131365195);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131364062));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131363890));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131364197));
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(2));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131379724));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131367349));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377138));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewView.findViewById(2131372110));
    this.jdField_b_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView;
    View localView = this.jdField_c_of_type_AndroidViewView;
    this.jdField_a_of_type_AndroidViewView = localView;
    setContentView(localView);
  }
  
  private void g()
  {
    boolean bool = OnlineStatusItem.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    int i;
    if (bool) {
      i = 0;
    } else {
      i = 8;
    }
    if (bool) {
      j = 32;
    } else {
      j = 86;
    }
    int j = Utils.a(j, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources());
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(i);
    if (i == 0) {
      ReportHelperKt.a("0X800B0F0");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(j, 0, j, 0);
  }
  
  public OnlineStatusPermissionChecker.OnlineStatusPermissionItem a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
  }
  
  public ArrayList<OnlineStatusItem> a()
  {
    OnlineAutoStatusBean localOnlineAutoStatusBean = (OnlineAutoStatusBean)QConfigManager.a().a(652);
    ArrayList localArrayList = new ArrayList();
    if (localOnlineAutoStatusBean != null)
    {
      if (localOnlineAutoStatusBean.a == null) {
        return localArrayList;
      }
      return OnlineStatusBean.a(localOnlineAutoStatusBean.a.a(false));
    }
    return localArrayList;
  }
  
  protected void a()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.jdField_a_of_type_MqqAppAppRuntime$Status = ((IOnlineStatusService)localAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    this.jdField_a_of_type_Long = OnLineStatusHelper.a().a(localAppRuntime);
    g();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == this.jdField_b_of_type_Int) && (paramInt2 == -1) && (paramIntent.getSerializableExtra("online_status_permission_item") != null))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramIntent.getSerializableExtra("online_status_permission_item"));
      c(false);
    }
  }
  
  protected void a(View paramView)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, 2131719223, 0).a();
      dismiss();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback.a(40001);
      return;
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    boolean bool = OnlineStatusItem.a(((IOnlineStatusService)localAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus(), OnLineStatusHelper.a().a(localAppRuntime));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback.a(40001L);
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusSelectView", 4, new Object[] { " isCurStatusSmart =", Boolean.valueOf(bool) });
    }
    OnlineStatusPermissionServlet.a(localAppRuntime, a(), c(), bool ^ true);
    dismiss();
    paramView = paramView.getTag();
    if ((paramView instanceof Integer))
    {
      int i = ((Integer)paramView).intValue();
      if (i == 2)
      {
        paramView = c().iterator();
        while (paramView.hasNext()) {
          ReportHelperKt.a("0X800AF40", ((Integer)paramView.next()).intValue(), "1");
        }
      }
      if (i == 1)
      {
        paramView = c().iterator();
        while (paramView.hasNext()) {
          ReportHelperKt.a("0X800B00F", ((Integer)paramView.next()).intValue(), "1");
        }
      }
    }
    ReportHelperKt.a("0X8009DE0", 40001);
  }
  
  public void a(OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem, List<Integer> paramList)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, paramOnlineStatusFriendsPermissionItem.allHasPermission, paramOnlineStatusFriendsPermissionItem.permissionUins);
      c(true);
    }
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem1, OnlineStatusItem paramOnlineStatusItem2, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusSelectView", 2, new Object[] { "oldItem =", paramOnlineStatusItem1, " oldItem=", paramOnlineStatusItem2 });
    }
    int i;
    if ((paramOnlineStatusItem1 == null) && (paramOnlineStatusItem2 != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691338);
    }
    else
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if ((paramOnlineStatusItem2 instanceof AutoStatusItem)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((AutoStatusItem)paramOnlineStatusItem2).e);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
    }
    c(false);
    if (i != 0) {
      ReportHelperKt.a("0X800AF3F", (int)paramOnlineStatusItem2.jdField_a_of_type_Long, String.valueOf(this.jdField_a_of_type_Int));
    }
  }
  
  public void a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = paramOnlineStatusPermissionItem;
    boolean bool;
    if (paramOnlineStatusPermissionItem == null) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public void a(boolean paramBoolean, Bitmap paramBitmap, int paramInt)
  {
    if ((paramBoolean) && (paramBitmap != null))
    {
      View localView = this.jdField_c_of_type_AndroidViewView;
      if (localView != null)
      {
        localView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
        return;
      }
    }
    paramBitmap = this.jdField_c_of_type_AndroidViewView;
    if (paramBitmap != null) {
      paramBitmap.setBackgroundColor(paramInt);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusSelectView", 2, new Object[] { "hasChange =", Boolean.valueOf(paramBoolean1), " isSmartListEmpty=", Boolean.valueOf(paramBoolean2) });
    }
    if (!OnlineStatusItem.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131691332);
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
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131691333);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131691333);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(1));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131693121);
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
    paramArrayOfInt[0] = (this.jdField_b_of_type_AndroidViewView.getResources().getDisplayMetrics().widthPixels - Utils.a(26.0F, this.jdField_b_of_type_AndroidViewView.getResources()));
    paramArrayOfInt[1] = Utils.a(480.0F, this.jdField_b_of_type_AndroidViewView.getResources());
  }
  
  protected boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
    if (localObject == null)
    {
      localObject = ((OnlineStatusPermissionManager)((IOnlineStatusManagerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class)).a(40001L, false, this);
      return (localObject != null) && (!((OnlineStatusFriendsPermissionItem)localObject).allHasPermission);
    }
    return true ^ ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject).isAllHasPermission();
  }
  
  protected boolean a(boolean paramBoolean)
  {
    OnlineStatusPermissionManager localOnlineStatusPermissionManager = (OnlineStatusPermissionManager)((IOnlineStatusManagerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class);
    OnlineStatusPermissionChecker.OnlineStatusPermissionItem localOnlineStatusPermissionItem = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
    if ((localOnlineStatusPermissionItem != null) && (localOnlineStatusPermissionManager.a(localOnlineStatusPermissionItem, this))) {
      return true;
    }
    if (paramBoolean) {
      return false;
    }
    return localOnlineStatusPermissionManager.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a());
  }
  
  public void aL_()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.requestPermissions(new AutoStatusSelectView.3(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
    else
    {
      a(null);
      show();
    }
    ReportHelperKt.a("0X800AF3E", 1);
  }
  
  public ArrayList<OnlineStatusItem> b()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = ((OnlineStatusPermissionManager)((IOnlineStatusManagerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class)).a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      ArrayList localArrayList2 = a();
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
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691338);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl;
    if (localObject == null)
    {
      localObject = new OnlineStatusPanelParams();
      ((OnlineStatusPanelParams)localObject).jdField_a_of_type_Int = 3;
      ((OnlineStatusPanelParams)localObject).c = true;
      ((OnlineStatusPanelParams)localObject).b = false;
      ((OnlineStatusPanelParams)localObject).jdField_a_of_type_Boolean = true;
      ((OnlineStatusPanelParams)localObject).f = 5;
      ((OnlineStatusPanelParams)localObject).h = (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDisplayMetrics().widthPixels - Utils.a(26.0F, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources()));
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl = new OnlineStatusViewCtrl(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_AndroidViewViewGroup, this, (OnlineStatusPanelParams)localObject, this);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a();
      return;
    }
    ((OnlineStatusViewCtrl)localObject).b();
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    int i = 2131691331;
    if (paramBoolean1) {
      i = 2131691337;
    }
    String str1 = getContext().getResources().getString(i);
    String str2 = getContext().getResources().getString(2131691336);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(new QQText(str1, 3, 16));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(str1);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(str2);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new AutoStatusSelectView.1(this, paramBoolean1));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(new AutoStatusSelectView.MyViewAlphaOnTouchListener());
    if (ThemeImageWrapper.isNightMode()) {
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837596, 0);
    } else {
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837595, 0);
    }
    if (AppSetting.d) {
      this.jdField_b_of_type_AndroidWidgetTextView.setAccessibilityDelegate(new AutoStatusSelectView.2(this));
    }
  }
  
  protected boolean b()
  {
    List localList = ((OnlineStatusPermissionManager)((IOnlineStatusManagerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class)).a();
    if (localList == null) {
      return true;
    }
    return localList.isEmpty();
  }
  
  public ArrayList<Integer> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a();
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() <= 0) {
        return localArrayList;
      }
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(Integer.valueOf((int)((OnlineStatusItem)((Iterator)localObject).next()).jdField_a_of_type_Long));
      }
    }
    return localArrayList;
  }
  
  public void c(View paramView) {}
  
  protected void c(boolean paramBoolean)
  {
    boolean bool1;
    if (paramBoolean) {
      bool1 = b();
    } else {
      bool1 = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a().isEmpty();
    }
    boolean bool2 = a();
    boolean bool3 = a(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusSelectView", 2, new Object[] { "isSmartListEmpty =", Boolean.valueOf(bool1), " hasPartVisible=", Boolean.valueOf(bool2), " hasDataChange=", Boolean.valueOf(bool3), " fromShow=", Boolean.valueOf(paramBoolean) });
    }
    a(bool3, bool1);
    b(bool2, bool1);
  }
  
  protected void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691338);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131376816)
    {
      dismiss();
      ReportHelperKt.a("0X800AF94");
    }
    else if (paramView.getId() == 2131363890)
    {
      ReportHelperKt.a("0X800B0F1");
      ((IOnlineStatusService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(AppRuntime.Status.online, 0L);
      dismiss();
    }
    else if (paramView.getId() == 2131364062)
    {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void show()
  {
    if (QQTheme.a())
    {
      this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130846335);
      a(false, null, Color.parseColor("#FF010101"));
    }
    else
    {
      this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130846334);
      OnLineStatusBlurBg.BlurBgItem localBlurBgItem = new OnLineStatusBlurBg.BlurBgItem();
      localBlurBgItem.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg.a(localBlurBgItem, this);
    }
    b();
    a();
    c(true);
    a(this.jdField_d_of_type_AndroidWidgetTextView);
    a(this.jdField_a_of_type_AndroidWidgetTextView, 2131165605, 2131167362);
    super.show();
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AutoStatusSelectView
 * JD-Core Version:    0.7.0.1
 */