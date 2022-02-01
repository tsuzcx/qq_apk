package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;

public class TroopTagViewActivity
  extends QQBrowserActivity
{
  protected boolean a = false;
  protected String b;
  protected String c;
  protected String d;
  protected int e;
  public int f = 1;
  public String g;
  
  public TroopTagViewActivity()
  {
    this.mFragmentClass = TroopTagViewActivity.TroopTagViewFragment.class;
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = super.getIntent();
    if (localIntent == null)
    {
      super.finish();
      return true;
    }
    Bundle localBundle = localIntent.getExtras();
    if (localBundle == null)
    {
      super.finish();
      return true;
    }
    this.e = localBundle.getInt("act_type", 3);
    this.c = localBundle.getString("tags");
    boolean bool = localBundle.containsKey("subclass");
    String str = "";
    if (bool) {
      this.d = localBundle.getString("subclass");
    } else {
      this.d = "";
    }
    this.b = localBundle.getString("troopuin");
    if (TextUtils.isEmpty(this.b))
    {
      super.finish();
      return true;
    }
    this.a = localBundle.getBoolean("isAdmin");
    localIntent.putExtra("hide_operation_bar", true);
    if (!TextUtils.isEmpty(this.c)) {
      str = URLEncoder.encode(this.c).replace("+", "%20");
    }
    this.f = localBundle.getInt("modifyToSrv", 1);
    int i = this.e;
    if (i == 1) {
      localIntent.putExtra("url", String.format("https://web.qun.qq.com/tag/index.html?_bid=146&t=%d#tags=%s&gc=%s&base=%s&modifyToSrv=%s", new Object[] { Long.valueOf(System.currentTimeMillis() / 1000L), str, this.b, this.d, Integer.valueOf(this.f) }));
    } else if (i == 2) {
      localIntent.putExtra("url", String.format("https://web.qun.qq.com/tag/edit.html?_bid=146#tags=%s&gc=%s&base=%s&modifyToSrv=%s", new Object[] { str, this.b, this.d, Integer.valueOf(this.f) }));
    } else {
      localIntent.putExtra("url", localBundle.getString("url"));
    }
    localIntent.putExtra("isShowAd", false);
    super.doOnCreate(paramBundle);
    localIntent.putExtra("act_type", 3);
    return true;
  }
  
  public void finish()
  {
    if (!TextUtils.isEmpty(this.g))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("tags", this.g);
      setResult(-1, localIntent);
    }
    super.finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopTagViewActivity
 * JD-Core Version:    0.7.0.1
 */