package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.intervideo.nowproxy.NowPluginObserver;
import com.tencent.mobileqq.app.BaseActivity;

class LoadingFragment$1
  implements NowPluginObserver
{
  LoadingFragment$1(LoadingFragment paramLoadingFragment) {}
  
  public void onCloseLoadingView()
  {
    BaseActivity localBaseActivity = this.a.getBaseActivity();
    if (localBaseActivity != null) {
      localBaseActivity.finish();
    }
  }
  
  public void onEnterAvPlugin(Bundle paramBundle) {}
  
  public void onEnterRoom(Bundle paramBundle)
  {
    this.a.a();
  }
  
  public void onExitRoom(Bundle paramBundle) {}
  
  public void onLoadingViewCreated(View paramView)
  {
    if (paramView != null)
    {
      this.a.getBaseActivity();
      FrameLayout localFrameLayout = (FrameLayout)this.a.getView();
      if ((paramView != null) && (localFrameLayout != null)) {
        localFrameLayout.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.LoadingFragment.1
 * JD-Core Version:    0.7.0.1
 */