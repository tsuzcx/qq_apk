package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.mobileqq.qqgamepub.api.IQQGameFlutterApi;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter;
import com.tencent.mobileqq.qqgamepub.mvp.view.buisness.IQQGameHippyBaseView;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public abstract class GamePAHippyBaseFragment<P extends QQGameHippyBasePresenter>
  extends BaseHippyFragment
  implements IQQGameHippyBaseView<P>
{
  P a = (QQGameHippyBasePresenter)m();
  
  private void e()
  {
    ((IWebProcessManagerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IWebProcessManagerService.class, "")).startWebProcess(-1, null);
  }
  
  public void a() {}
  
  public void a(long paramLong) {}
  
  public void b() {}
  
  public void b(long paramLong)
  {
    ((IQQGameFlutterApi)QRoute.api(IQQGameFlutterApi.class)).preloadFlutter();
    ((IQQGameFlutterApi)QRoute.api(IQQGameFlutterApi.class)).updateDnFlutter(GamePubAccountHelper.g());
    e();
  }
  
  public HippyQQPreloadEngine c()
  {
    return this.mHippyQQEngine;
  }
  
  protected JSONObject doBussinessInitData(JSONObject paramJSONObject)
  {
    return this.a.a(paramJSONObject);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    this.a.c(getActivity());
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.a.a(this);
    this.a.a(paramActivity);
  }
  
  public boolean onBackEvent()
  {
    return this.a.j();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a.a(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a.a(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, localView);
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.i();
    this.a.d();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.a.g();
  }
  
  public void onFinish()
  {
    super.onFinish();
    this.a.h();
  }
  
  public void onPause()
  {
    super.onPause();
    this.a.f();
  }
  
  public void onResume()
  {
    super.onResume();
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment
 * JD-Core Version:    0.7.0.1
 */