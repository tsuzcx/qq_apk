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
  protected int a;
  protected String a;
  protected boolean a;
  public int b;
  protected String b;
  protected String c;
  public String d;
  
  public TroopTagViewActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 1;
    this.mFragmentClass = TroopTagViewActivity.TroopTagViewFragment.class;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
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
    this.jdField_a_of_type_Int = localBundle.getInt("act_type", 3);
    this.jdField_b_of_type_JavaLangString = localBundle.getString("tags");
    if (localBundle.containsKey("subclass")) {}
    for (this.c = localBundle.getString("subclass");; this.c = "")
    {
      this.jdField_a_of_type_JavaLangString = localBundle.getString("troopuin");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      super.finish();
      return true;
    }
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("isAdmin");
    localIntent.putExtra("hide_operation_bar", true);
    String str;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      str = "";
      this.jdField_b_of_type_Int = localBundle.getInt("modifyToSrv", 1);
      if (this.jdField_a_of_type_Int != 1) {
        break label263;
      }
      localIntent.putExtra("url", String.format("https://web.qun.qq.com/tag/index.html?_bid=146&t=%d#tags=%s&gc=%s&base=%s&modifyToSrv=%s", new Object[] { Long.valueOf(System.currentTimeMillis() / 1000L), str, this.jdField_a_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_b_of_type_Int) }));
    }
    for (;;)
    {
      localIntent.putExtra("isShowAd", false);
      super.doOnCreate(paramBundle);
      localIntent.putExtra("act_type", 3);
      return true;
      str = URLEncoder.encode(this.jdField_b_of_type_JavaLangString).replace("+", "%20");
      break;
      label263:
      if (this.jdField_a_of_type_Int == 2) {
        localIntent.putExtra("url", String.format("https://web.qun.qq.com/tag/edit.html?_bid=146#tags=%s&gc=%s&base=%s&modifyToSrv=%s", new Object[] { str, this.jdField_a_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_b_of_type_Int) }));
      } else {
        localIntent.putExtra("url", localBundle.getString("url"));
      }
    }
  }
  
  public void finish()
  {
    if (!TextUtils.isEmpty(this.d))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("tags", this.d);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopTagViewActivity
 * JD-Core Version:    0.7.0.1
 */