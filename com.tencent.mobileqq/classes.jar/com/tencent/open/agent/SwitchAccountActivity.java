package com.tencent.open.agent;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.data.SharedPrefs;
import com.tencent.open.model.AccountManage;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

@RoutePage(desc="互联切换帐号页面", path="/base/switchAccount")
public class SwitchAccountActivity
  extends QIphoneTitleBarActivity
{
  private static final String TAG = "SwitchAccountActivity";
  private SharedPreferences.Editor accountEdi;
  private ArrayList<String> accountList;
  private SharedPreferences accountPre;
  private LinearLayout container;
  private String mAccount;
  private AbstractOpenSdkAppInterface mApp;
  private boolean mHasSlide;
  private long mLoginBTS;
  private QQProgressDialog mProgress;
  private int mReqSrc = 1;
  private String mThirdAppId;
  private View.OnTouchListener onTouch = new SwitchAccountActivity.5(this);
  private SSOAccountObserver ssoLoginObserver = new SwitchAccountActivity.1(this);
  private WtloginManager wtloginManager = null;
  
  private static String convertUserInfoToJson(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("uin:'");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("',");
    localStringBuilder.append("skey:'");
    if (paramString2 != null) {
      localStringBuilder.append(paramString2);
    }
    localStringBuilder.append("'}");
    return localStringBuilder.toString();
  }
  
  private void deleteAccount(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("-->deleteAccount--account to delete is ");
    ((StringBuilder)localObject1).append(AuthorityUtil.a(paramString));
    localObject1 = ((StringBuilder)localObject1).toString();
    int j = 0;
    SSOLog.a("SwitchAccountActivity", new Object[] { localObject1 });
    SharedPrefs.c(paramString);
    Object localObject3 = this.accountPre;
    Object localObject2 = null;
    localObject1 = localObject2;
    if (((SharedPreferences)localObject3).getString("accList", null) != null)
    {
      localObject3 = this.accountPre.getString("accList", null);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((String)localObject3).split(",");
      }
    }
    localObject2 = new ArrayList();
    if (localObject1 != null)
    {
      int k = localObject1.length;
      i = 0;
      while (i < k)
      {
        ((ArrayList)localObject2).add(localObject1[i]);
        i += 1;
      }
    }
    while (((ArrayList)localObject2).contains("")) {
      ((ArrayList)localObject2).remove("");
    }
    if (((ArrayList)localObject2).contains(paramString))
    {
      ((ArrayList)localObject2).remove(paramString);
      localObject2 = ((ArrayList)localObject2).iterator();
      StringBuilder localStringBuilder;
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = localStringBuilder.toString())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(",");
        localStringBuilder.append((String)localObject3);
      }
      this.accountEdi.putString("accList", (String)localObject1);
      this.accountEdi.commit();
    }
    if (paramString.equals(this.accountPre.getString("last_account", "")))
    {
      SSOLog.a("SwitchAccountActivity", new Object[] { "-->deleteAccount--account to delete equals last account, clear last account" });
      this.accountEdi.remove("last_account").commit();
    }
    localObject1 = new File(OpenSdkVirtualUtil.a(OpenSdkVirtualUtil.a(this.wtloginManager, paramString)));
    int i = j;
    if (!((File)localObject1).exists())
    {
      ((File)localObject1).delete();
      i = j;
    }
    while (i < this.container.getChildCount())
    {
      localObject1 = this.container.getChildAt(i);
      if (((View)localObject1).getTag().equals(paramString))
      {
        this.container.removeView((View)localObject1);
        if (i != 0) {
          break;
        }
        paramString = this.container.getChildAt(i);
        if (this.container.getChildCount() == 1)
        {
          paramString.setBackgroundResource(2130839433);
          return;
        }
        paramString.setBackgroundResource(2130839449);
        return;
      }
      i += 1;
    }
  }
  
  private void hideLoginTip()
  {
    QQProgressDialog localQQProgressDialog = this.mProgress;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {}
    try
    {
      this.mProgress.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void login()
  {
    int i = this.mReqSrc;
    if (i == 2)
    {
      if (AuthorityUtil.b(this.wtloginManager, this.mAccount))
      {
        SSOLog.a("SwitchAccountActivity", new Object[] { "-->login--has aone" });
        loginSuccess(this.mAccount, null, null);
        return;
      }
      showLoginActivity();
      return;
    }
    if (i == 3)
    {
      if (!AuthorityUtil.a(this.wtloginManager, this.mAccount))
      {
        SSOLog.a("SwitchAccountActivity", new Object[] { "-->login--has atwo" });
        loginSuccess(this.mAccount, null, null);
        return;
      }
      showLoginActivity();
      return;
    }
    if (AuthorityUtil.a(this.wtloginManager, this.mAccount))
    {
      showLoginActivity();
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send | cmd: g_t_n_p | uin : *");
      localStringBuilder.append(AuthorityUtil.a(this.mAccount));
      SSOLog.a("SwitchAccountActivity", new Object[] { localStringBuilder.toString() });
      AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      AccountManage.a().a(this.mAccount, this.ssoLoginObserver, this.mThirdAppId, 1);
    }
    showLoginTip();
  }
  
  private void loginSuccess(String paramString1, String paramString2, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->loginSucess--mReqSrc = ");
    ((StringBuilder)localObject).append(this.mReqSrc);
    ((StringBuilder)localObject).append(", userAccount = *");
    ((StringBuilder)localObject).append(AuthorityUtil.a(paramString1));
    ((StringBuilder)localObject).append(", bundle = null ? ");
    boolean bool;
    if (paramBundle == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    SSOLog.a("SwitchAccountActivity", new Object[] { ((StringBuilder)localObject).toString() });
    SharedPrefs.a(paramString1);
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    localObject = new Intent();
    int i = this.mReqSrc;
    if ((i != 2) && (i != 3))
    {
      this.wtloginManager.getBasicUserInfo(paramString1, localWloginSimpleInfo);
      paramString1 = OpenSdkVirtualUtil.a(this.wtloginManager, paramString1);
      AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramString1, true);
      ((Intent)localObject).putExtra("result_data", convertUserInfoToJson(paramString1, paramString2));
      ((Intent)localObject).putExtra("nick", new String(localWloginSimpleInfo._nick));
      ((Intent)localObject).putExtra("last_account", paramString1);
      ((Intent)localObject).putExtra("isLogin", this.accountList.contains(paramString1));
      if (paramBundle != null)
      {
        paramString1 = paramBundle.getByteArray("st_temp");
        paramString2 = paramBundle.getByteArray("st_temp_key");
        ((Intent)localObject).putExtra("st_temp", paramString1);
        ((Intent)localObject).putExtra("st_temp_key", paramString2);
      }
    }
    else
    {
      this.wtloginManager.getBasicUserInfo(this.mAccount, localWloginSimpleInfo);
      paramString1 = OpenSdkVirtualUtil.a(this.wtloginManager, paramString1);
      ((Intent)localObject).putExtra("last_account", paramString1);
      ((Intent)localObject).putExtra("isLogin", this.accountList.contains(paramString1));
    }
    super.setResult(-1, (Intent)localObject);
    super.finish();
  }
  
  private void showAccountList()
  {
    if (this.accountList == null) {
      return;
    }
    LayoutInflater localLayoutInflater = super.getLayoutInflater();
    int j = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j >= this.accountList.size()) {
        break;
      }
      View localView = localLayoutInflater.inflate(2131558439, this.container, false);
      TextView localTextView1 = (TextView)localView.findViewById(2131371854);
      TextView localTextView2 = (TextView)localView.findViewById(2131380147);
      ImageView localImageView = (ImageView)localView.findViewById(2131366401);
      String str = (String)this.accountList.get(j);
      localObject1 = new WloginSimpleInfo();
      this.wtloginManager.getBasicUserInfo(str, (WloginSimpleInfo)localObject1);
      Object localObject2 = new String(((WloginSimpleInfo)localObject1)._nick);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = str;
      }
      localTextView1.setText((CharSequence)localObject1);
      localTextView2.setText(str);
      localObject1 = OpenSdkVirtualUtil.a(str, 60, true);
      if (localObject1 != null)
      {
        localObject2 = AuthorityUtil.a(this, (Bitmap)localObject1, 63, 63);
        ((Bitmap)localObject1).recycle();
        if (localObject2 != null) {
          localImageView.setImageBitmap((Bitmap)localObject2);
        }
      }
      if (i == 0) {
        localView.setBackgroundResource(2130839449);
      }
      localView.findViewById(2131365466).setOnClickListener(new SwitchAccountActivity.2(this));
      localView.setOnClickListener(new SwitchAccountActivity.3(this));
      localView.setOnTouchListener(this.onTouch);
      localView.setTag(str);
      this.container.addView(localView);
      i += 1;
      if (i >= 10)
      {
        k = i;
        break;
      }
      j += 1;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("-->showAccountList--count = ");
    ((StringBuilder)localObject1).append(k);
    SSOLog.a("SwitchAccountActivity", new Object[] { ((StringBuilder)localObject1).toString() });
    ReportCenter.a().a("", "", "", "1010", String.valueOf(k), "0", false, true);
    localObject1 = localLayoutInflater.inflate(2131558455, this.container, false);
    this.container.addView((View)localObject1);
    ((View)localObject1).setOnClickListener(new SwitchAccountActivity.4(this));
  }
  
  private void showLoginActivity()
  {
    SSOLog.a("SwitchAccountActivity", new Object[] { "-->showLoginActivity" });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_req_src", this.mReqSrc);
    localIntent.putExtra("appid", this.mThirdAppId);
    localIntent.putExtra("param_qr_code_url", getIntent().getStringExtra("param_qr_code_url"));
    RouteUtils.a(this, localIntent, "/base/openSdkLogin", 1);
  }
  
  private void showLoginTip()
  {
    this.mProgress.a(super.getString(2131694646));
    if ((!super.isFinishing()) && (!this.mProgress.isShowing()) && (getWindow().isActive())) {
      this.mProgress.show();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-->onActivityResult--reqCode = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", resCode = ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", data = null ? ");
    boolean bool;
    if (paramIntent == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    SSOLog.a("SwitchAccountActivity", new Object[] { localStringBuilder.toString() });
    if (paramInt1 != 1) {
      return;
    }
    super.getIntent().getStringExtra("key_action");
    if (paramInt2 == 0)
    {
      if (this.mProgress.isShowing()) {
        this.mProgress.dismiss();
      }
    }
    else if (-1 == paramInt2)
    {
      super.setResult(-1, paramIntent);
      super.finish();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  @SuppressLint({"CommitPrefEdits"})
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131562895);
    this.accountPre = super.getSharedPreferences("accountList", 0);
    this.accountEdi = this.accountPre.edit();
    paramBundle = super.getIntent();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getExtras();
      if (paramBundle != null)
      {
        this.mReqSrc = paramBundle.getInt("key_req_src", 1);
        this.mThirdAppId = paramBundle.getString("third_app_id", "");
      }
    }
    paramBundle = new StringBuilder();
    paramBundle.append("mReqSrc:");
    paramBundle.append(this.mReqSrc);
    SSOLog.a("SwitchAccountActivity", new Object[] { paramBundle.toString() });
    super.setTitle(2131694654);
    this.mProgress = new QQProgressDialog(this, getTitleBarHeight());
    this.container = ((LinearLayout)super.findViewById(2131361904));
    this.mLoginBTS = SystemClock.elapsedRealtime();
    this.mApp = ((AbstractOpenSdkAppInterface)super.getAppRuntime());
    this.wtloginManager = ((WtloginManager)this.mApp.getManager(1));
    this.accountList = SharedPrefs.a();
    paramBundle = super.getIntent().getStringExtra("param_uin");
    ArrayList localArrayList = this.accountList;
    if (localArrayList != null) {
      localArrayList.remove(paramBundle);
    }
    showAccountList();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QQProgressDialog localQQProgressDialog = this.mProgress;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.mProgress.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.SwitchAccountActivity
 * JD-Core Version:    0.7.0.1
 */