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
import com.tencent.mobileqq.app.QBaseActivity;
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
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class MyMoodView
  extends BaseStatusCardView
  implements View.OnClickListener, OnLineStatusBlurBg.OnLineStatusBlurBgListener, OnlineStatusPagerAdapter.OnStatusItemClickListener, OnlineStatusPanel.OnlineStatusPanelListener
{
  private long jdField_a_of_type_Long;
  protected ViewGroup a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected QBaseActivity a;
  private OnLineStatusBlurBg jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg;
  protected OnlineStatusViewCtrl a;
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private boolean jdField_a_of_type_Boolean = false;
  private View c;
  private View d;
  
  public MyMoodView(@NonNull QBaseActivity paramQBaseActivity, OnLineStatusBlurBg paramOnLineStatusBlurBg, BaseStatusCardView.OnDismissCallback paramOnDismissCallback)
  {
    super(paramQBaseActivity, paramOnDismissCallback);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg = paramOnLineStatusBlurBg;
    if (paramOnLineStatusBlurBg == null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg = new OnLineStatusBlurBg();
    }
    a();
  }
  
  private void a()
  {
    this.c = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).inflate(2131559133, null);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.c.findViewById(2131379930));
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(1));
    this.d = this.c.findViewById(2131365195);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.c.findViewById(2131372110));
    this.b = this.d;
    View localView = this.c;
    this.jdField_a_of_type_AndroidViewView = localView;
    setContentView(localView);
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl;
    if (localObject == null)
    {
      localObject = new OnlineStatusPanelParams();
      ((OnlineStatusPanelParams)localObject).jdField_a_of_type_Int = 4;
      ((OnlineStatusPanelParams)localObject).c = true;
      ((OnlineStatusPanelParams)localObject).b = false;
      ((OnlineStatusPanelParams)localObject).jdField_a_of_type_Boolean = false;
      ((OnlineStatusPanelParams)localObject).f = 5;
      ((OnlineStatusPanelParams)localObject).h = (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDisplayMetrics().widthPixels - Utils.a(26.0F, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources()));
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl = new OnlineStatusViewCtrl(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_AndroidViewViewGroup, this, (OnlineStatusPanelParams)localObject, this);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a();
    }
    else
    {
      ((OnlineStatusViewCtrl)localObject).b();
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    this.jdField_a_of_type_MqqAppAppRuntime$Status = ((IOnlineStatusService)localAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    this.jdField_a_of_type_Long = OnLineStatusHelper.a().a(localAppRuntime);
  }
  
  public ArrayList<OnlineStatusItem> a()
  {
    Object localObject = (OnlineStatusBean)QConfigManager.a().a(578);
    if (localObject == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = ((OnlineStatusBean)localObject).c();
    localObject = localArrayList;
    if (localArrayList == null) {
      localObject = new ArrayList();
    }
    return localObject;
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem1, OnlineStatusItem paramOnlineStatusItem2, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyMoodView", 2, new Object[] { "oldItem =", paramOnlineStatusItem1, " curItem=", paramOnlineStatusItem2 });
    }
    if (paramOnlineStatusItem1 != paramOnlineStatusItem2)
    {
      if (!isShowing()) {
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
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, 2131719223, 0).a();
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback.a(1055);
      }
      else if (paramOnlineStatusItem2 != null)
      {
        ((IOnlineStatusService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(paramOnlineStatusItem2.jdField_a_of_type_MqqAppAppRuntime$Status, paramOnlineStatusItem2.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback.a(paramOnlineStatusItem2.jdField_a_of_type_Long);
        ReportHelperKt.a("0X8009DE0", (int)paramOnlineStatusItem2.jdField_a_of_type_Long);
      }
      k();
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
    if ((paramBoolean) && (paramBitmap != null))
    {
      View localView = this.c;
      if (localView != null)
      {
        localView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
        return;
      }
    }
    paramBitmap = this.c;
    if (paramBitmap != null) {
      paramBitmap.setBackgroundColor(paramInt);
    }
  }
  
  protected void a(int[] paramArrayOfInt)
  {
    if ((this.b.getWidth() != 0) && (this.b.getHeight() != 0))
    {
      paramArrayOfInt[0] = this.b.getWidth();
      paramArrayOfInt[1] = this.b.getHeight();
      return;
    }
    paramArrayOfInt[0] = (this.b.getResources().getDisplayMetrics().widthPixels - Utils.a(78.0F, this.b.getResources()));
    paramArrayOfInt[1] = Utils.a(300.0F, this.b.getResources());
  }
  
  public ArrayList<OnlineStatusItem> b()
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
  
  public void c(View paramView) {}
  
  public void onBackPressed()
  {
    super.onBackPressed();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback.a(1055);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131376816)
    {
      dismiss();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback.a(1055);
      ReportHelperKt.a("0X800AF94");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void show()
  {
    if (QQTheme.a())
    {
      this.d.setBackgroundResource(2130846335);
      a(false, null, Color.parseColor("#FF010101"));
    }
    else
    {
      this.d.setBackgroundResource(2130846334);
      OnLineStatusBlurBg.BlurBgItem localBlurBgItem = new OnLineStatusBlurBg.BlurBgItem();
      localBlurBgItem.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg.a(localBlurBgItem, this);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      int i;
      if (OnLineStatusHelper.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long)) {
        i = 2;
      } else {
        i = 1;
      }
      ReportHelperKt.a("0X800B7AE", i);
    }
    c();
    b();
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    super.show();
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.MyMoodView
 * JD-Core Version:    0.7.0.1
 */