package com.tencent.mobileqq.onlinestatus.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineStatusBean;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.BlurBgItem;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.OnLineStatusBlurBgListener;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPagerAdapter.OnStatusItemClickListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.OnlineStatusPanelListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanelParams;
import com.tencent.mobileqq.onlinestatus.OnlineStatusViewCtrl;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class MyMoodView
  extends BaseStatusCardView
  implements View.OnClickListener, OnLineStatusBlurBg.OnLineStatusBlurBgListener, OnlineStatusPagerAdapter.OnStatusItemClickListener, OnlineStatusPanel.OnlineStatusPanelListener
{
  private long jdField_a_of_type_Long;
  protected ViewGroup a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected BaseActivity a;
  private OnLineStatusBlurBg jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg;
  protected OnlineStatusViewCtrl a;
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private boolean jdField_a_of_type_Boolean = false;
  private View c;
  private View d;
  
  public MyMoodView(@NonNull BaseActivity paramBaseActivity, OnLineStatusBlurBg paramOnLineStatusBlurBg, BaseStatusCardView.OnDismissCallback paramOnDismissCallback)
  {
    super(paramBaseActivity, paramOnDismissCallback);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg = paramOnLineStatusBlurBg;
    if (paramOnLineStatusBlurBg == null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg = new OnLineStatusBlurBg();
    }
    a();
  }
  
  private void a()
  {
    this.c = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131559257, null);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.c.findViewById(2131380651));
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(1));
    this.d = this.c.findViewById(2131365320);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.c.findViewById(2131372525));
    this.b = this.d;
    this.jdField_a_of_type_AndroidViewView = this.c;
    setContentView(this.c);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl == null)
    {
      OnlineStatusPanelParams localOnlineStatusPanelParams = new OnlineStatusPanelParams();
      localOnlineStatusPanelParams.jdField_a_of_type_Int = 4;
      localOnlineStatusPanelParams.c = true;
      localOnlineStatusPanelParams.b = false;
      localOnlineStatusPanelParams.jdField_a_of_type_Boolean = false;
      localOnlineStatusPanelParams.f = 5;
      localOnlineStatusPanelParams.h = (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().widthPixels - AIOUtils.a(26.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()));
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl = new OnlineStatusViewCtrl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewViewGroup, this, localOnlineStatusPanelParams, this);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      return;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.b();
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.jdField_a_of_type_MqqAppAppRuntime$Status = localQQAppInterface.getOnlineStatus();
    this.jdField_a_of_type_Long = OnLineStatusHelper.a().a(localQQAppInterface);
  }
  
  public void a(View paramView) {}
  
  public void a(OnlineStatusItem paramOnlineStatusItem1, OnlineStatusItem paramOnlineStatusItem2, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyMoodView", 2, new Object[] { "oldItem =", paramOnlineStatusItem1, " curItem=", paramOnlineStatusItem2 });
    }
    if ((paramOnlineStatusItem1 == paramOnlineStatusItem2) || (!isShowing())) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback.a(paramOnlineStatusItem2.jdField_a_of_type_Long);
      dismiss();
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131719505, 0).a();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback.a(1055);
    }
    for (;;)
    {
      m();
      return;
      if (paramOnlineStatusItem2 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.updateOnlineStatus(paramOnlineStatusItem2.jdField_a_of_type_MqqAppAppRuntime$Status, paramOnlineStatusItem2.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback.a(paramOnlineStatusItem2.jdField_a_of_type_Long);
        ReportHelperKt.a("0X8009DE0", (int)paramOnlineStatusItem2.jdField_a_of_type_Long);
      }
    }
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong)
  {
    this.jdField_a_of_type_MqqAppAppRuntime$Status = paramStatus;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean, Bitmap paramBitmap, int paramInt)
  {
    if ((paramBoolean) && (paramBitmap != null) && (this.c != null)) {
      this.c.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
    }
    while (this.c == null) {
      return;
    }
    this.c.setBackgroundColor(paramInt);
  }
  
  protected void a(int[] paramArrayOfInt)
  {
    if ((this.b.getWidth() != 0) && (this.b.getHeight() != 0))
    {
      paramArrayOfInt[0] = this.b.getWidth();
      paramArrayOfInt[1] = this.b.getHeight();
      return;
    }
    paramArrayOfInt[0] = (this.b.getResources().getDisplayMetrics().widthPixels - AIOUtils.a(78.0F, this.b.getResources()));
    paramArrayOfInt[1] = AIOUtils.a(300.0F, this.b.getResources());
  }
  
  public ArrayList<OnlineStatusItem> b()
  {
    Object localObject = (OnlineStatusBean)QConfigManager.a().a(578);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    ArrayList localArrayList;
    do
    {
      return localObject;
      localArrayList = ((OnlineStatusBean)localObject).c();
      localObject = localArrayList;
    } while (localArrayList != null);
    return new ArrayList();
  }
  
  public ArrayList<OnlineStatusItem> c()
  {
    Object localObject = (OnlineStatusBean)QConfigManager.a().a(578);
    OnlineStatusItem localOnlineStatusItem = ((OnlineStatusBean)localObject).a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    if (!((OnlineStatusBean)localObject).a(localOnlineStatusItem.jdField_a_of_type_MqqAppAppRuntime$Status, localOnlineStatusItem.jdField_a_of_type_Long)) {
      return null;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(localOnlineStatusItem);
    return localObject;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback.a(1055);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131377364)
    {
      dismiss();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback.a(1055);
      ReportHelperKt.a("0X800AF94");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void show()
  {
    if (ThemeUtil.isNowThemeIsNight(null, false, ""))
    {
      this.d.setBackgroundResource(2130846455);
      a(false, null, Color.parseColor("#FF010101"));
      if (!this.jdField_a_of_type_Boolean) {
        if (!OnLineStatusHelper.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long)) {
          break label135;
        }
      }
    }
    label135:
    for (int i = 2;; i = 1)
    {
      ReportHelperKt.a("0X800B7AE", i);
      c();
      b();
      a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      super.show();
      b(true);
      return;
      this.d.setBackgroundResource(2130846454);
      OnLineStatusBlurBg.BlurBgItem localBlurBgItem = new OnLineStatusBlurBg.BlurBgItem();
      localBlurBgItem.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg.a(localBlurBgItem, this);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.MyMoodView
 * JD-Core Version:    0.7.0.1
 */