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
  protected ViewGroup a;
  protected OnlineStatusViewCtrl b;
  protected QBaseActivity c;
  private View d;
  private View e;
  private OnLineStatusBlurBg f;
  private AppRuntime.Status g;
  private long h;
  private TextView o;
  private boolean p = false;
  
  public MyMoodView(@NonNull QBaseActivity paramQBaseActivity, OnLineStatusBlurBg paramOnLineStatusBlurBg, BaseStatusCardView.OnDismissCallback paramOnDismissCallback)
  {
    super(paramQBaseActivity, paramOnDismissCallback);
    this.c = paramQBaseActivity;
    this.f = paramOnLineStatusBlurBg;
    if (paramOnLineStatusBlurBg == null) {
      this.f = new OnLineStatusBlurBg();
    }
    a();
  }
  
  private void a()
  {
    this.d = LayoutInflater.from(this.c).inflate(2131624877, null);
    this.d.setOnClickListener(this);
    this.o = ((TextView)this.d.findViewById(2131448814));
    this.o.setTypeface(Typeface.defaultFromStyle(1));
    this.e = this.d.findViewById(2131431357);
    this.e.setOnClickListener(this);
    this.a = ((ViewGroup)this.d.findViewById(2131439580));
    this.j = this.e;
    View localView = this.d;
    this.i = localView;
    setContentView(localView);
  }
  
  private void b()
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      localObject = new OnlineStatusPanelParams();
      ((OnlineStatusPanelParams)localObject).a = 4;
      ((OnlineStatusPanelParams)localObject).k = true;
      ((OnlineStatusPanelParams)localObject).j = false;
      ((OnlineStatusPanelParams)localObject).b = false;
      ((OnlineStatusPanelParams)localObject).g = 5;
      ((OnlineStatusPanelParams)localObject).i = (this.c.getResources().getDisplayMetrics().widthPixels - Utils.a(26.0F, this.c.getResources()));
      this.b = new OnlineStatusViewCtrl(this.c, this.a, this, (OnlineStatusPanelParams)localObject, this);
      this.b.a();
    }
    else
    {
      ((OnlineStatusViewCtrl)localObject).b();
    }
    this.b.a(this.g, this.h);
  }
  
  private void c()
  {
    if (this.p) {
      return;
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    this.g = ((IOnlineStatusService)localAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    this.h = OnLineStatusHelper.a().a(localAppRuntime);
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
      if (this.p)
      {
        this.n.a(paramOnlineStatusItem2.b);
        dismiss();
        return;
      }
      if (!AppNetConnInfo.isNetSupport())
      {
        QQToast.makeText(this.c, 1, 2131916775, 0).show();
        this.n.a(1055);
      }
      else if (paramOnlineStatusItem2 != null)
      {
        ((IOnlineStatusService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(paramOnlineStatusItem2.g, paramOnlineStatusItem2.b);
        this.n.a(paramOnlineStatusItem2.b);
        ReportHelperKt.a("0X8009DE0", (int)paramOnlineStatusItem2.b);
      }
      m();
    }
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong)
  {
    this.g = paramStatus;
    this.h = paramLong;
    this.p = true;
  }
  
  public void a(boolean paramBoolean, Bitmap paramBitmap, int paramInt)
  {
    if ((paramBoolean) && (paramBitmap != null))
    {
      View localView = this.d;
      if (localView != null)
      {
        localView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
        return;
      }
    }
    paramBitmap = this.d;
    if (paramBitmap != null) {
      paramBitmap.setBackgroundColor(paramInt);
    }
  }
  
  protected void a(int[] paramArrayOfInt)
  {
    if ((this.j.getWidth() != 0) && (this.j.getHeight() != 0))
    {
      paramArrayOfInt[0] = this.j.getWidth();
      paramArrayOfInt[1] = this.j.getHeight();
      return;
    }
    paramArrayOfInt[0] = (this.j.getResources().getDisplayMetrics().widthPixels - Utils.a(78.0F, this.j.getResources()));
    paramArrayOfInt[1] = Utils.a(300.0F, this.j.getResources());
  }
  
  public void c(View paramView) {}
  
  public ArrayList<OnlineStatusItem> d()
  {
    Object localObject = (OnlineStatusBean)QConfigManager.b().b(578);
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
  
  public ArrayList<OnlineStatusItem> e()
  {
    Object localObject = (OnlineStatusBean)QConfigManager.b().b(578);
    OnlineStatusItem localOnlineStatusItem = ((OnlineStatusBean)localObject).b(this.g, this.h);
    if (!((OnlineStatusBean)localObject).c(localOnlineStatusItem.g, localOnlineStatusItem.b)) {
      return null;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(localOnlineStatusItem);
    return localObject;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    this.n.a(1055);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131445146)
    {
      dismiss();
      this.n.a(1055);
      ReportHelperKt.a("0X800AF94");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void show()
  {
    if (QQTheme.isNowThemeIsNight())
    {
      this.e.setBackgroundResource(2130847806);
      a(false, null, Color.parseColor("#FF010101"));
    }
    else
    {
      this.e.setBackgroundResource(2130847805);
      OnLineStatusBlurBg.BlurBgItem localBlurBgItem = new OnLineStatusBlurBg.BlurBgItem();
      localBlurBgItem.a = this.c;
      this.f.a(localBlurBgItem, this);
    }
    if (!this.p)
    {
      int i;
      if (OnLineStatusHelper.c(this.g, this.h)) {
        i = 2;
      } else {
        i = 1;
      }
      ReportHelperKt.a("0X800B7AE", i);
    }
    c();
    b();
    a(this.o);
    super.show();
    e(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.MyMoodView
 * JD-Core Version:    0.7.0.1
 */