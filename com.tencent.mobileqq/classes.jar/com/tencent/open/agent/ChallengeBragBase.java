package com.tencent.open.agent;

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
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.business.base.Constants;
import com.tencent.open.settings.ServerSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.Set;

public abstract class ChallengeBragBase
  extends QBaseActivity
  implements View.OnClickListener
{
  protected ProgressDialog a;
  protected Bundle a;
  protected EditText a;
  protected TextView a;
  protected TextView b;
  protected TextView c;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected String i;
  protected String j;
  protected String k = null;
  protected String l = null;
  protected String m;
  protected String n;
  protected String o;
  protected String p;
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_AndroidAppProgressDialog = ProgressDialog.show(this, "", super.getResources().getString(2131690967), true);
    this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.jdField_c_of_type_JavaLangString);
    localBundle.putString("hopenid", this.d);
    localBundle.putString("keystr", this.e);
    localBundle.putString("keytype", this.f);
    localBundle.putString("encrytoken", this.m);
    localBundle.putString("platform", this.g);
    paramString = TextUtils.split(paramString, ",");
    if ((paramString != null) && (paramString.length != 0))
    {
      localBundle.putString("fopenids", paramString[0]);
      paramString = this.l;
      if (paramString != null) {
        localBundle.putString("pf", paramString);
      }
      localBundle.putString("appid_for_getting_config", this.jdField_c_of_type_JavaLangString);
      paramString = this.n;
      if (paramString != null) {
        new HttpCgiAsyncTask(paramString, "GET", new ChallengeBragBase.GetNickNameCallback(this), true).a(localBundle);
      }
      return;
    }
    c();
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
        if ((!"".equals(this.jdField_c_of_type_JavaLangString.trim())) && (!"".equals(this.d.trim())) && (!"".equals(this.e.trim())) && (!"".equals(this.f.trim())) && (!"".equals(this.g.trim())) && (!"".equals(this.j.trim())) && (!"".equals(this.h.trim())))
        {
          if (this.jdField_a_of_type_AndroidOsBundle.containsKey("pf")) {
            this.l = this.jdField_a_of_type_AndroidOsBundle.getString("pf");
          }
          if (this.jdField_a_of_type_AndroidOsBundle.containsKey("source")) {
            this.k = this.jdField_a_of_type_AndroidOsBundle.getString("source");
          }
          this.n = ServerSetting.a().a("https://fusion.qq.com/cgi-bin/qzapps/mapp_getuserinfo.cgi");
          this.o = ServerSetting.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_sendbragging.cgi");
          return true;
        }
        c();
        return false;
      }
      c();
      return false;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initParams exception.");
      localStringBuilder.append(localException.getMessage());
      LogUtility.c("qqBaseActivity", localStringBuilder.toString(), localException);
      c();
    }
    return false;
  }
  
  protected void c()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", -5);
    localIntent.putExtra("key_error_msg", Constants.jdField_c_of_type_JavaLangString);
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("initParams:error code:-5; error msg:");
    localStringBuilder1.append(Constants.jdField_c_of_type_JavaLangString);
    LogUtility.e("qqBaseActivity", localStringBuilder1.toString());
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      localStringBuilder1 = new StringBuilder();
      Object localObject = this.jdField_a_of_type_AndroidOsBundle.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(str);
        localStringBuilder2.append(": ");
        localStringBuilder2.append(this.jdField_a_of_type_AndroidOsBundle.get(str).toString());
        localStringBuilder2.append(" ");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("params=");
      ((StringBuilder)localObject).append(localStringBuilder1.toString());
      LogUtility.e("qqBaseActivity", ((StringBuilder)localObject).toString());
    }
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  protected void d()
  {
    ProgressDialog localProgressDialog = this.jdField_a_of_type_AndroidAppProgressDialog;
    if ((localProgressDialog != null) && (localProgressDialog.isShowing())) {
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
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GetPKFriendInfoSwitch_AGENT:");
      localStringBuilder.append(SystemClock.elapsedRealtime());
      QLog.d("SDKQQAgentPref", 2, localStringBuilder.toString());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.b)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("appid", this.jdField_c_of_type_JavaLangString);
      localBundle.putString("hopenid", this.d);
      localBundle.putString("keystr", this.e);
      localBundle.putString("keytype", this.f);
      localBundle.putString("encrytoken", this.m);
      localBundle.putString("platform", this.g);
      localBundle.putString("sendmsg", this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      localBundle.putString("imgurl", this.j);
      localBundle.putString("receiver", this.h);
      int i1 = 2131690986;
      if ("action_brag".equals(this.p))
      {
        localBundle.putString("typeid", "52");
      }
      else if ("action_challenge".equals(this.p))
      {
        localBundle.putString("typeid", "53");
        i1 = 2131690987;
      }
      localBundle.putString("appid_for_getting_config", this.jdField_c_of_type_JavaLangString);
      String str = this.k;
      if (str != null) {
        localBundle.putString("app_custom", str);
      }
      str = this.l;
      if (str != null) {
        localBundle.putString("pf", str);
      }
      this.jdField_a_of_type_AndroidAppProgressDialog = ProgressDialog.show(this, "", super.getResources().getString(i1), true);
      new HttpCgiAsyncTask(this.o, "POST", new ChallengeBragBase.SendChallengeCallback(this), true).a(localBundle);
    }
    else if (paramView == this.jdField_c_of_type_AndroidWidgetTextView)
    {
      super.setResult(0);
      super.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.ChallengeBragBase
 * JD-Core Version:    0.7.0.1
 */