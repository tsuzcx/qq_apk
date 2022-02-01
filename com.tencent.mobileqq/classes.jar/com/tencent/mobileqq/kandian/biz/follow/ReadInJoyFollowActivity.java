package com.tencent.mobileqq.kandian.biz.follow;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelViewController;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.repo.playfeeds.PlayFeedsSPUtils;

public class ReadInJoyFollowActivity
  extends IphoneTitleBarActivity
{
  protected ReadInJoyChannelViewController a = null;
  
  private void a()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131376123);
    this.a = new ReadInJoyChannelViewController(this);
    this.a.a(70);
    this.a.b(0);
    this.a.a(localViewGroup);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    VideoVolumeControl.getInstance().inKandianModule(this);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    setContentView(2131560199);
    getWindow().setBackgroundDrawable(null);
    setClickableTitle("BB圈", new ReadInJoyFollowActivity.1(this));
    a();
    this.a.aw_();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.a.e();
    VideoVolumeControl.getInstance().outKandianModule(this);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.a.h();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.a.i();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    PlayFeedsSPUtils.a(getAppRuntime());
    this.a.f();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.a.g();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.ReadInJoyFollowActivity
 * JD-Core Version:    0.7.0.1
 */