package com.tencent.open.agent;

import Override;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import bjch;
import bjci;
import bjko;
import bjlg;
import bjlp;
import bjpz;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.Set;

public abstract class ChallengeBragBase
  extends BaseActivity
  implements View.OnClickListener
{
  protected ProgressDialog a;
  protected Bundle a;
  protected EditText a;
  public TextView a;
  protected TextView b;
  protected TextView c;
  public String c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected String i;
  protected String j;
  protected String k;
  protected String l;
  protected String m;
  protected String n;
  protected String o;
  public String p;
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_AndroidAppProgressDialog = ProgressDialog.show(this, "", super.getResources().getString(2131690946), true);
    this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.jdField_c_of_type_JavaLangString);
    localBundle.putString("hopenid", this.d);
    localBundle.putString("keystr", this.e);
    localBundle.putString("keytype", this.f);
    localBundle.putString("encrytoken", this.m);
    localBundle.putString("platform", this.g);
    paramString = TextUtils.split(paramString, ",");
    if ((paramString == null) || (paramString.length == 0)) {
      c();
    }
    do
    {
      return;
      localBundle.putString("fopenids", paramString[0]);
      if (this.l != null) {
        localBundle.putString("pf", this.l);
      }
      localBundle.putString("appid_for_getting_config", this.jdField_c_of_type_JavaLangString);
    } while (this.n == null);
    new bjlg(this.n, "GET", new bjch(this), true).a(localBundle);
  }
  
  protected boolean a()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
      this.p = super.getIntent().getStringExtra("key_action");
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("appid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("hopenid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("keystr")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("keytype")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("platform")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("img")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("receiver")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("encrytoken")))
      {
        this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("appid");
        this.d = this.jdField_a_of_type_AndroidOsBundle.getString("hopenid");
        this.e = this.jdField_a_of_type_AndroidOsBundle.getString("keystr");
        this.f = this.jdField_a_of_type_AndroidOsBundle.getString("keytype");
        this.g = this.jdField_a_of_type_AndroidOsBundle.getString("platform");
        this.j = this.jdField_a_of_type_AndroidOsBundle.getString("img");
        this.h = this.jdField_a_of_type_AndroidOsBundle.getString("receiver");
        this.i = this.jdField_a_of_type_AndroidOsBundle.getString("msg");
        this.m = this.jdField_a_of_type_AndroidOsBundle.getString("encrytoken");
        if (("".equals(this.jdField_c_of_type_JavaLangString.trim())) || ("".equals(this.d.trim())) || ("".equals(this.e.trim())) || ("".equals(this.f.trim())) || ("".equals(this.g.trim())) || ("".equals(this.j.trim())) || ("".equals(this.h.trim())))
        {
          c();
          return false;
        }
      }
      else
      {
        c();
        return false;
      }
    }
    catch (Exception localException)
    {
      bjko.c("qqBaseActivity", "initParams exception." + localException.getMessage(), localException);
      c();
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("pf")) {
      this.l = this.jdField_a_of_type_AndroidOsBundle.getString("pf");
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("source")) {
      this.k = this.jdField_a_of_type_AndroidOsBundle.getString("source");
    }
    this.n = bjpz.a().a("https://fusion.qq.com/cgi-bin/qzapps/mapp_getuserinfo.cgi");
    this.o = bjpz.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_sendbragging.cgi");
    return true;
  }
  
  protected void c()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", -5);
    localIntent.putExtra("key_error_msg", bjlp.jdField_c_of_type_JavaLangString);
    bjko.e("qqBaseActivity", "initParams:error code:-5; error msg:" + bjlp.jdField_c_of_type_JavaLangString);
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_AndroidOsBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append(str + ": " + this.jdField_a_of_type_AndroidOsBundle.get(str).toString() + " ");
      }
      bjko.e("qqBaseActivity", "params=" + localStringBuilder.toString());
    }
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("SDKQQAgentPref", 2, "GetPKFriendInfoSwitch_AGENT:" + SystemClock.elapsedRealtime());
    }
  }
  
  public void onClick(View paramView)
  {
    Bundle localBundle;
    int i1;
    if (paramView == this.b)
    {
      localBundle = new Bundle();
      localBundle.putString("appid", this.jdField_c_of_type_JavaLangString);
      localBundle.putString("hopenid", this.d);
      localBundle.putString("keystr", this.e);
      localBundle.putString("keytype", this.f);
      localBundle.putString("encrytoken", this.m);
      localBundle.putString("platform", this.g);
      localBundle.putString("sendmsg", this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      localBundle.putString("imgurl", this.j);
      localBundle.putString("receiver", this.h);
      i1 = 2131690965;
      if ("action_brag".equals(this.p))
      {
        localBundle.putString("typeid", "52");
        localBundle.putString("appid_for_getting_config", this.jdField_c_of_type_JavaLangString);
        if (this.k != null) {
          localBundle.putString("app_custom", this.k);
        }
        if (this.l != null) {
          localBundle.putString("pf", this.l);
        }
        this.jdField_a_of_type_AndroidAppProgressDialog = ProgressDialog.show(this, "", super.getResources().getString(i1), true);
        new bjlg(this.o, "POST", new bjci(this), true).a(localBundle);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!"action_challenge".equals(this.p)) {
        break;
      }
      localBundle.putString("typeid", "53");
      i1 = 2131690966;
      break;
      if (paramView == this.jdField_c_of_type_AndroidWidgetTextView)
      {
        super.setResult(0);
        super.finish();
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.ChallengeBragBase
 * JD-Core Version:    0.7.0.1
 */