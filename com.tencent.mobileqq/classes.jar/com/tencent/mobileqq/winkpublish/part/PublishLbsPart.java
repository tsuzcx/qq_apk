package com.tencent.mobileqq.winkpublish.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.winkpublish.account.LoginData;
import com.tencent.mobileqq.winkpublish.adapter.PublishPoiAdapter;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.common.config.LocalConfig;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishPoiViewModel;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishViewModel;
import com.tencent.mobileqq.winkpublish.widget.PublishBubblePopupView;
import com.tencent.mobileqq.winkpublish.widget.PublishCustomDialog;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import cooperation.qzone.LbsDataV2.PoiInfo;

public class PublishLbsPart
  extends BlockPart
  implements View.OnClickListener
{
  public static final String a;
  private RelativeLayout b;
  private ViewGroup e;
  private HorizontalListView f;
  private PublishPoiAdapter g;
  private PublishPoiViewModel h;
  private PublishViewModel i;
  private TextView j = null;
  private TextView k;
  private ViewGroup l;
  private ImageView m;
  private PublishBubblePopupView n;
  private boolean o = false;
  private final Runnable p = new PublishLbsPart.2(this);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("FSLbsPart");
    a = localStringBuilder.toString();
  }
  
  private void a(LbsDataV2.PoiInfo paramPoiInfo)
  {
    if ((paramPoiInfo.poiId != null) && (paramPoiInfo.poiId.equals("invalide_poi_id")))
    {
      paramPoiInfo = this.h;
      if (paramPoiInfo != null) {
        paramPoiInfo.h = null;
      }
      paramPoiInfo = this.g;
      if (paramPoiInfo != null) {
        paramPoiInfo.a(null);
      }
      paramPoiInfo = this.e;
      if (paramPoiInfo != null) {
        paramPoiInfo.setVisibility(8);
      }
      paramPoiInfo = this.l;
      if (paramPoiInfo != null) {
        paramPoiInfo.setVisibility(8);
      }
      paramPoiInfo = this.j;
      if (paramPoiInfo != null) {
        paramPoiInfo.setVisibility(0);
      }
    }
  }
  
  private void a(LbsDataV2.PoiInfo paramPoiInfo, boolean paramBoolean)
  {
    Object localObject = this.g;
    if (localObject == null)
    {
      QLog.d(a, 1, "[setPoiInfoSelected] poi adapter not is null.");
      return;
    }
    ((PublishPoiAdapter)localObject).a(paramPoiInfo);
    if (paramPoiInfo == null)
    {
      localObject = this.l;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
      localObject = this.j;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
    }
    else
    {
      localObject = this.l;
      if (localObject != null)
      {
        ((ViewGroup)localObject).setVisibility(0);
        localObject = this.k;
        if (localObject != null)
        {
          ((TextView)localObject).setText(paramPoiInfo.poiName);
          this.k.post(new PublishLbsPart.13(this));
        }
      }
      localObject = this.j;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((PublishViewModel)localObject).a(paramBoolean);
      this.i.a(paramPoiInfo);
    }
  }
  
  private boolean b(LbsDataV2.PoiInfo paramPoiInfo)
  {
    PublishPoiViewModel localPublishPoiViewModel = this.h;
    int i1;
    if ((localPublishPoiViewModel != null) && (localPublishPoiViewModel.e())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      QLog.d(a, 1, "[selectFirstPoiInfo] current not selected first poi info.");
      return false;
    }
    if (!q())
    {
      QLog.d(a, 1, "[selectFirstPoiInfo] current not gps permission.");
      return false;
    }
    if (this.e.getVisibility() == 8) {
      this.e.setVisibility(0);
    }
    localPublishPoiViewModel = this.h;
    if (localPublishPoiViewModel != null) {
      localPublishPoiViewModel.h = paramPoiInfo;
    }
    if (paramPoiInfo != null)
    {
      QLog.d(a, 1, new Object[] { "[checkFirstPoiInfoSelected] poi id: ", paramPoiInfo.poiId, " | poiName: ", paramPoiInfo.poiName });
      a(paramPoiInfo, true);
    }
    return true;
  }
  
  private void e()
  {
    if (this.n == null) {
      this.n = new PublishBubblePopupView(g());
    }
  }
  
  private void f()
  {
    if ((LocalConfig.b("key_sp_bubble_view_show", true, LoginData.a().b())) && (this.n != null)) {
      this.l.post(new PublishLbsPart.3(this));
    }
  }
  
  private void l()
  {
    if (this.h == null)
    {
      QLog.d(a, 1, "[reloadPublishPoiData] mPoiViewModel == null.");
      return;
    }
    if (!q())
    {
      QLog.i(a, 1, "[reloadPublishPoiData] current not gps permission.");
      return;
    }
    this.h.a(null, true);
  }
  
  private void m()
  {
    this.h.c.observe(j(), new PublishLbsPart.4(this));
    this.h.d.observe(j(), new PublishLbsPart.5(this));
    this.h.e.observe(j(), new PublishLbsPart.6(this));
    this.i.c.observe(j(), new PublishLbsPart.7(this));
  }
  
  private void n()
  {
    if (!((LocationManager)c().getSystemService("location")).isProviderEnabled("gps"))
    {
      o();
      return;
    }
    if (!d())
    {
      if (Build.MODEL.toLowerCase().contains("mi"))
      {
        p();
        return;
      }
      if (Build.VERSION.SDK_INT >= 23) {
        ((CompatPublicActivity)c()).a(new PublishLbsPart.8(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      }
    }
    else
    {
      this.h.a(j());
    }
  }
  
  private void o()
  {
    Object localObject = QCircleConfigHelper.a("QZoneTextSetting", "secondary_qcircle_no_gps_title", "无法定位");
    String str = QCircleConfigHelper.a("QZoneTextSetting", "secondary_qcircle_no_gps_content", "无法获取到你的位置信息，请打开定位服务。");
    localObject = PublishCustomDialog.a(g(), (String)localObject, str, 2131887648, 2131890047, new PublishLbsPart.9(this), new PublishLbsPart.10(this));
    try
    {
      ((PublishCustomDialog)localObject).show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e(a, 1, "Exception:", localException);
    }
  }
  
  private void p()
  {
    Object localObject = QCircleConfigHelper.a("QZoneTextSetting", "secondary_qcircle_no_gps_title", "无法定位");
    String str = QCircleConfigHelper.a("QZoneTextSetting", "secondary_qcircle_no_application_gps_content", "你的位置权限被禁用，请到设置中授予QQ访问位置的权限。");
    localObject = PublishCustomDialog.a(g(), (String)localObject, str, 2131887648, 2131890047, new PublishLbsPart.11(this), new PublishLbsPart.12(this));
    try
    {
      ((PublishCustomDialog)localObject).show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e(a, 1, "Exception:", localException);
    }
  }
  
  private boolean q()
  {
    return (((LocationManager)c().getSystemService("location")).isProviderEnabled("gps")) && (d());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    HostUIHelper.closeHostEnvironment();
    if ((paramInt1 == 1208) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      this.h.a(paramIntent);
      paramIntent = paramIntent.getExtras().getParcelable("key_select_poi");
      if ((paramIntent instanceof LbsDataV2.PoiInfo)) {
        a((LbsDataV2.PoiInfo)paramIntent);
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.b = ((RelativeLayout)paramView.findViewById(2131441739));
    this.b.setOnClickListener(this);
    this.j = ((TextView)paramView.findViewById(2131441742));
    if (this.e != null)
    {
      QLog.d(a, 2, "[initPoiView] already inited");
      return;
    }
    this.e = ((ViewGroup)paramView.findViewById(2131441861));
    this.f = ((HorizontalListView)paramView.findViewById(2131441862));
    this.g = new PublishPoiAdapter(c());
    this.f.setAdapter(this.g);
    this.f.setOnItemClickListener(new PublishLbsPart.1(this));
    this.l = ((ViewGroup)paramView.findViewById(2131441868));
    this.k = ((TextView)paramView.findViewById(2131448651));
    this.l.setVisibility(8);
    this.m = ((ImageView)paramView.findViewById(2131436342));
    this.m.setOnClickListener(this);
    e();
    m();
    l();
  }
  
  public boolean d()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool;
      if (RFApplication.getApplication().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
        bool = true;
      } else {
        bool = false;
      }
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkHasGpsPermission result:");
      localStringBuilder.append(bool);
      QLog.d(str, 1, localStringBuilder.toString());
      return bool;
    }
    return true;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    if (this.h == null) {
      this.h = ((PublishPoiViewModel)a(PublishPoiViewModel.class));
    }
    if (this.i == null) {
      this.i = ((PublishViewModel)a(PublishViewModel.class));
    }
    SimpleEventBus.getInstance().registerReceiver(this.h);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this.h);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131441739)
    {
      if (E().a(PublishContentPart.class.getName()) != null) {
        ((PublishContentPart)E().a(PublishContentPart.class.getName())).m();
      }
      n();
    }
    else if (paramView.getId() == 2131436342)
    {
      a(null, false);
      PublishPoiViewModel localPublishPoiViewModel = this.h;
      localPublishPoiViewModel.h = null;
      localPublishPoiViewModel.m = true;
      if (this.g.getCount() == 0) {
        this.e.setVisibility(8);
      } else {
        this.e.setVisibility(0);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLbsPart
 * JD-Core Version:    0.7.0.1
 */