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
  protected EditText A;
  protected String B;
  protected String i;
  protected String j;
  protected String k;
  protected String l;
  protected String m;
  protected String n;
  protected String o;
  protected String p;
  protected String q = null;
  protected String r = null;
  protected String s;
  protected String t;
  protected String u;
  protected Bundle v;
  protected ProgressDialog w;
  protected TextView x;
  protected TextView y;
  protected TextView z;
  
  protected void a(String paramString)
  {
    this.w = ProgressDialog.show(this, "", super.getResources().getString(2131887906), true);
    this.w.setCancelable(true);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.i);
    localBundle.putString("hopenid", this.j);
    localBundle.putString("keystr", this.k);
    localBundle.putString("keytype", this.l);
    localBundle.putString("encrytoken", this.s);
    localBundle.putString("platform", this.m);
    paramString = TextUtils.split(paramString, ",");
    if ((paramString != null) && (paramString.length != 0))
    {
      localBundle.putString("fopenids", paramString[0]);
      paramString = this.r;
      if (paramString != null) {
        localBundle.putString("pf", paramString);
      }
      localBundle.putString("appid_for_getting_config", this.i);
      paramString = this.t;
      if (paramString != null) {
        new HttpCgiAsyncTask(paramString, "GET", new ChallengeBragBase.GetNickNameCallback(this), true).a(localBundle);
      }
      return;
    }
    d();
  }
  
  protected boolean c()
  {
    try
    {
      this.v = super.getIntent().getBundleExtra("key_params");
      this.B = super.getIntent().getStringExtra("key_action");
      if ((this.v != null) && (this.v.containsKey("appid")) && (this.v.containsKey("hopenid")) && (this.v.containsKey("keystr")) && (this.v.containsKey("keytype")) && (this.v.containsKey("platform")) && (this.v.containsKey("img")) && (this.v.containsKey("receiver")) && (this.v.containsKey("encrytoken")))
      {
        this.i = this.v.getString("appid");
        this.j = this.v.getString("hopenid");
        this.k = this.v.getString("keystr");
        this.l = this.v.getString("keytype");
        this.m = this.v.getString("platform");
        this.p = this.v.getString("img");
        this.n = this.v.getString("receiver");
        this.o = this.v.getString("msg");
        this.s = this.v.getString("encrytoken");
        if ((!"".equals(this.i.trim())) && (!"".equals(this.j.trim())) && (!"".equals(this.k.trim())) && (!"".equals(this.l.trim())) && (!"".equals(this.m.trim())) && (!"".equals(this.p.trim())) && (!"".equals(this.n.trim())))
        {
          if (this.v.containsKey("pf")) {
            this.r = this.v.getString("pf");
          }
          if (this.v.containsKey("source")) {
            this.q = this.v.getString("source");
          }
          this.t = ServerSetting.a().a("https://fusion.qq.com/cgi-bin/qzapps/mapp_getuserinfo.cgi");
          this.u = ServerSetting.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_sendbragging.cgi");
          return true;
        }
        d();
        return false;
      }
      d();
      return false;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initParams exception.");
      localStringBuilder.append(localException.getMessage());
      LogUtility.c("qqBaseActivity", localStringBuilder.toString(), localException);
      d();
    }
    return false;
  }
  
  protected void d()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", -5);
    localIntent.putExtra("key_error_msg", Constants.c);
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("initParams:error code:-5; error msg:");
    localStringBuilder1.append(Constants.c);
    LogUtility.e("qqBaseActivity", localStringBuilder1.toString());
    if (this.v != null)
    {
      localStringBuilder1 = new StringBuilder();
      Object localObject = this.v.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(str);
        localStringBuilder2.append(": ");
        localStringBuilder2.append(this.v.get(str).toString());
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
  
  protected void e()
  {
    ProgressDialog localProgressDialog = this.w;
    if ((localProgressDialog != null) && (localProgressDialog.isShowing())) {
      this.w.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.y)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("appid", this.i);
      localBundle.putString("hopenid", this.j);
      localBundle.putString("keystr", this.k);
      localBundle.putString("keytype", this.l);
      localBundle.putString("encrytoken", this.s);
      localBundle.putString("platform", this.m);
      localBundle.putString("sendmsg", this.A.getText().toString());
      localBundle.putString("imgurl", this.p);
      localBundle.putString("receiver", this.n);
      int i1 = 2131887925;
      if ("action_brag".equals(this.B))
      {
        localBundle.putString("typeid", "52");
      }
      else if ("action_challenge".equals(this.B))
      {
        localBundle.putString("typeid", "53");
        i1 = 2131887926;
      }
      localBundle.putString("appid_for_getting_config", this.i);
      String str = this.q;
      if (str != null) {
        localBundle.putString("app_custom", str);
      }
      str = this.r;
      if (str != null) {
        localBundle.putString("pf", str);
      }
      this.w = ProgressDialog.show(this, "", super.getResources().getString(i1), true);
      new HttpCgiAsyncTask(this.u, "POST", new ChallengeBragBase.SendChallengeCallback(this), true).a(localBundle);
    }
    else if (paramView == this.z)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.ChallengeBragBase
 * JD-Core Version:    0.7.0.1
 */