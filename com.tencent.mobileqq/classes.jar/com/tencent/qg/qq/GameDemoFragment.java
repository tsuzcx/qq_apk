package com.tencent.qg.qq;

import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.miniapp.ui.MiniAppBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qg.sdk.QGGLSurfaceView;
import com.tencent.qg.sdk.doraemon.DoraemonApiWrapper;
import com.tencent.qg.sdk.doraemon.impl.DoraemonApiWrapperMockImpl;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class GameDemoFragment
  extends MiniAppBaseFragment
{
  DoraemonApiWrapper a;
  private QGGLSurfaceView b;
  private String[] c;
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.c = getArguments().getStringArray("key_run_js");
    getBaseActivity().getWindowManager().getDefaultDisplay().getWidth();
    getBaseActivity().getWindowManager().getDefaultDisplay().getHeight();
    ((IDoraemonService)QRoute.api(IDoraemonService.class)).createAPIManager(getBaseActivity(), 3, a());
    this.b = new QGGLSurfaceView(getBaseActivity());
    this.a = new DoraemonApiWrapperMockImpl(this.b);
    this.b.setQGEventListener(new GameDemoFragment.1(this));
    paramLayoutInflater = this.b;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    DoraemonApiWrapper localDoraemonApiWrapper = this.a;
    if (localDoraemonApiWrapper != null)
    {
      localDoraemonApiWrapper.release();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.qq.GameDemoFragment
 * JD-Core Version:    0.7.0.1
 */