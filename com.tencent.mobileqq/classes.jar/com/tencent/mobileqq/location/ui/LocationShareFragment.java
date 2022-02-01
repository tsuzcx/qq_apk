package com.tencent.mobileqq.location.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.location.LocationShareViewModel;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.net.LocationShareLocationManager;
import com.tencent.mobileqq.location.net.ReportLocationHandler;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class LocationShareFragment
  extends QPublicBaseFragment
{
  private static long d;
  private MapWidget a;
  private View b;
  private LocationShareController c;
  private LocationRoom.RoomKey e;
  private HeadSetView f;
  
  private void a()
  {
    Object localObject1 = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    Object localObject2 = getActivity().getIntent();
    int i = ((Intent)localObject2).getIntExtra("FROM_KEY", -1);
    LocationHandler.a().b(i);
    String str = ((Intent)localObject2).getStringExtra("uin");
    int j = ((Intent)localObject2).getIntExtra("uintype", -1);
    this.e = new LocationRoom.RoomKey(j, str);
    localObject2 = ((ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment(getActivity());
    Object localObject3 = (LocationShareViewModel)ViewModelProviderHelper.a((ViewModelStoreOwner)localObject2, LocationShareViewModel.d).get(LocationShareViewModel.class);
    ((LocationShareViewModel)localObject3).a((AppInterface)localObject1, getQBaseActivity(), this.e);
    this.c = new LocationShareController((LocationShareViewModel)localObject3, (LifeCycleAndViewModelStoreOwner)localObject2);
    localObject1 = this.f;
    localObject2 = this.c;
    localObject3 = this.e;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    ((HeadSetView)localObject1).setLocationController((LocationShareController)localObject2, (LocationRoom.RoomKey)localObject3, bool);
    localObject1 = (TextView)this.b.findViewById(2131437711);
    ((TextView)localObject1).setOnClickListener(new LocationShareFragment.1(this, j, str));
    if (QQUIDelegate.c())
    {
      ((TextView)localObject1).setBackgroundResource(2130841425);
      return;
    }
    ((TextView)localObject1).setBackgroundResource(2130841428);
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    if (System.currentTimeMillis() - d < 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareFragment", 2, new Object[] { "launch: invoked. ", " sLastLaunchTime: ", Long.valueOf(d) });
      }
      return;
    }
    d = System.currentTimeMillis();
    if (MapUtils.a(paramActivity) <= 0)
    {
      QQToast.makeText(paramActivity, 1, paramActivity.getString(2131892141), 1).show();
      return;
    }
    ReportLocationHandler localReportLocationHandler = LocationShareLocationManager.a().a;
    boolean bool = localReportLocationHandler.a(paramString, paramInt1) ^ true;
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, new Object[] { "[location_fragment]launch: invoked. ", " notSameSession: ", Boolean.valueOf(bool) });
    }
    if (!localReportLocationHandler.c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareFragment", 2, new Object[] { "launch: invoked. not reporting ", " from: ", Integer.valueOf(paramInt2) });
      }
      if (paramInt2 != 1)
      {
        LocationDialogUtil.a(paramActivity, paramInt1, paramString, paramInt2);
        return;
      }
      a(paramActivity, paramInt1, paramString, paramInt2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, new Object[] { "launch: invoked. reporting ", " from: ", Integer.valueOf(paramInt2) });
    }
    if (bool)
    {
      LocationDialogUtil.b(paramActivity, paramInt1, paramString, paramInt2);
      return;
    }
    a(paramActivity, paramInt1, paramString, paramInt2);
  }
  
  static void a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("FROM_KEY", paramInt2);
    localIntent.putExtra("FRAGMENT_KEY", "LocationShareFragment");
    if (!(paramContext instanceof Activity)) {
      localIntent.setFlags(268435456);
    }
    QPublicFragmentActivity.start(paramContext, localIntent, LocationShareFragment.class);
  }
  
  private void b()
  {
    this.a = ((MapWidget)this.b.findViewById(2131437696));
    MapUtils.a(this.a, "地图 你正在共享位置");
    Object localObject = (ImageView)this.b.findViewById(2131437703);
    MapUtils.a((View)localObject, "在地图区回到我的位置");
    this.c.a(getQBaseActivity(), this.e, this.a, this.f.a, (ImageView)localObject, this.b.findViewById(2131437710), this.b.findViewById(2131437711), this.b.findViewById(2131429656));
    localObject = this.b.findViewById(2131431578);
    if (QQUIDelegate.c()) {
      ((View)localObject).setVisibility(0);
    } else {
      ((View)localObject).setVisibility(8);
    }
    ((IFloatMapService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFloatMapService.class, "")).quitFloat(1);
    ReportController.b(null, "CliOper", "", "", "0X800A8BA", "0X800A8BA", 0, 0, "", "0", "0", "");
  }
  
  private void c()
  {
    a();
    b();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 0)
    {
      this.a.c();
      if (paramInt2 == -1)
      {
        paramIntent = (LocationRoom.Venue)paramIntent.getParcelableExtra("key_picked_location");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[venue] share fragment onActivityResult: venue: ");
          localStringBuilder.append(paramIntent);
          QLog.d("LocationShareFragment", 2, localStringBuilder.toString());
        }
        if (paramIntent != null)
        {
          this.c.a(paramIntent);
          return;
        }
        QQToast.makeText(getActivity(), 1, 2131891392, 1).show();
        return;
      }
      if (paramInt2 == 1) {
        getActivity().finish();
      }
    }
  }
  
  public boolean onBackEvent()
  {
    getActivity().overridePendingTransition(0, 2130772092);
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (((IFloatMapService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFloatMapService.class, "")).enterFloat(localQBaseActivity, this.e)) {
      return super.onBackEvent();
    }
    return true;
  }
  
  @SuppressLint({"InflateParams"})
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("[location_fragment]onCreateView: invoked. this: ");
      paramViewGroup.append(this);
      paramViewGroup.append(" activity: ");
      paramViewGroup.append(getActivity());
      QLog.d("LocationShareFragment", 2, paramViewGroup.toString());
    }
    this.b = paramLayoutInflater.inflate(2131624875, null);
    this.f = ((HeadSetView)this.b.findViewById(2131434932));
    this.f.a();
    getActivity().overridePendingTransition(2130772090, 17432577);
    paramLayoutInflater = this.b;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[location_fragment]onDestroy: invoked. this: ");
      localStringBuilder.append(this);
      localStringBuilder.append(" activity: ");
      localStringBuilder.append(getActivity());
      QLog.d("LocationShareFragment", 2, localStringBuilder.toString());
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[location_fragment]onFinish: invoked. this: ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" activity: ");
      ((StringBuilder)localObject).append(getActivity());
      QLog.d("LocationShareFragment", 2, ((StringBuilder)localObject).toString());
    }
    super.onFinish();
    Object localObject = getActivity();
    if (localObject != null) {
      ((Activity)localObject).overridePendingTransition(0, 2130772092);
    }
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[location_fragment]onPause: invoked. this: ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" isFinishing: ");
      ((StringBuilder)localObject).append(getActivity().isFinishing());
      ((StringBuilder)localObject).append(" activity: ");
      ((StringBuilder)localObject).append(getActivity());
      QLog.d("LocationShareFragment", 2, ((StringBuilder)localObject).toString());
    }
    super.onPause();
    Object localObject = this.a;
    if (localObject != null)
    {
      ((MapWidget)localObject).b(false);
      this.a.onPause();
    }
    if (getActivity().isFinishing())
    {
      MapUtils.a();
      ThreadManager.getUIHandler().postDelayed(new LocationShareFragment.4(this), 200L);
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[location_fragment]onResume: invoked. this: ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" activity: ");
      ((StringBuilder)localObject).append(getActivity());
      QLog.d("LocationShareFragment", 2, ((StringBuilder)localObject).toString());
    }
    super.onResume();
    Object localObject = this.a;
    if (localObject != null)
    {
      ((MapWidget)localObject).b(true);
      this.a.onResume();
    }
    this.f.c();
    if ((this.e != null) && (LocationShareLocationManager.a().a.a(this.e))) {
      LocationHandler.a().a(this.e.a(), this.e.b());
    }
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[location_fragment]onStart: invoked. this: ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" activity: ");
      ((StringBuilder)localObject).append(getActivity());
      QLog.d("LocationShareFragment", 2, ((StringBuilder)localObject).toString());
    }
    super.onStart();
    Object localObject = this.a;
    if (localObject != null) {
      ((MapWidget)localObject).onStart();
    }
    ThreadManager.getSubThreadHandler().post(new LocationShareFragment.3(this));
  }
  
  public void onStop()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[location_fragment]onStop: invoked. this: ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" activity: ");
      ((StringBuilder)localObject).append(getActivity());
      QLog.d("LocationShareFragment", 2, ((StringBuilder)localObject).toString());
    }
    super.onStop();
    Object localObject = this.a;
    if (localObject != null) {
      ((MapWidget)localObject).onStop();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[location_fragment]onViewCreated: invoked. this: ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" activity: ");
      ((StringBuilder)localObject).append(getActivity());
      QLog.d("LocationShareFragment", 2, ((StringBuilder)localObject).toString());
    }
    super.onViewCreated(paramView, paramBundle);
    paramView = getQBaseActivity();
    paramBundle = paramView.getIntent();
    int i = paramBundle.getIntExtra("FROM_KEY", -1);
    Object localObject = paramBundle.getStringExtra("uin");
    int j = paramBundle.getIntExtra("uintype", -1);
    if (!NetworkUtil.isNetworkAvailable()) {
      LocationDialogUtil.a(paramView, i, j, (String)localObject);
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView.requestPermissions(new LocationShareFragment.2(this, paramView, j, (String)localObject, i), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    c();
  }
  
  public boolean overrideFinish()
  {
    boolean bool = super.overrideFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.overridePendingTransition(0, 2130772092);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareFragment
 * JD-Core Version:    0.7.0.1
 */