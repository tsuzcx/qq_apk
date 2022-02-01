package com.tencent.mobileqq.newfriend.ui.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;

public class NewFriendMoreSysMsgActivity
  extends QBaseActivity
{
  private NewFriendMoreSysMsgAdapter a;
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, NewFriendMoreSysMsgActivity.class);
    localIntent.putExtra("first_visible_index", paramInt2);
    paramActivity.startActivityForResult(localIntent, paramInt1);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @TargetApi(14)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    int i = getIntent().getIntExtra("first_visible_index", 0);
    setContentView(2131627600);
    paramBundle = (LinearLayout)findViewById(2131445137);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    paramBundle = (SwipListView)findViewById(2131446714);
    View localView = findViewById(2131439340);
    TextView localTextView = (TextView)findViewById(2131436227);
    localTextView.setVisibility(0);
    localTextView.setText(2131892124);
    setTitle(getString(2131892124));
    localTextView = (TextView)findViewById(2131436180);
    localTextView.setVisibility(0);
    localTextView.setText("");
    localTextView.setOnClickListener(new NewFriendMoreSysMsgActivity.1(this));
    localTextView = (TextView)findViewById(2131436211);
    localTextView.setVisibility(0);
    localTextView.setText(2131897409);
    this.a = new NewFriendMoreSysMsgAdapter(this, (AppInterface)getAppRuntime(), paramBundle, localView, localTextView, this.mFlingHandler, i);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    NewFriendServiceImpl localNewFriendServiceImpl = (NewFriendServiceImpl)getAppRuntime().getRuntimeService(INewFriendService.class, "");
    localNewFriendServiceImpl.markSystemMsgReaded();
    localNewFriendServiceImpl.clearAllSysSuspiciousCache();
    this.a.a();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.activity.NewFriendMoreSysMsgActivity
 * JD-Core Version:    0.7.0.1
 */