package com.tencent.mobileqq.gameparty;

import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PromptDialogActivity
  extends BaseActivity
  implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener, View.OnClickListener
{
  SharedPreferences a = null;
  QQCustomDialog b = null;
  QQCustomDialog c = null;
  private URLImageView d = null;
  private TextView e = null;
  private TextView f = null;
  private Button g = null;
  private Button h = null;
  private String i = "";
  private String j = "";
  private String k = "";
  private String l = "";
  private String m = "";
  
  @TargetApi(16)
  private void a()
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    try
    {
      KeyguardManager localKeyguardManager = (KeyguardManager)super.getSystemService("keyguard");
      if ((localKeyguardManager != null) && (localKeyguardManager.isKeyguardLocked()))
      {
        boolean bool = localKeyguardManager.isKeyguardSecure();
        if (bool) {
          return;
        }
      }
      super.startActivity(new Intent(super.getApplicationContext(), QQLSUnlockActivity.class));
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppLaucherHelper localAppLaucherHelper = new AppLaucherHelper();
    int i1 = 268435456;
    try
    {
      int i2 = Integer.parseInt(paramString4);
      if ((i2 & 0x4000000) == 67108864) {
        i1 = 335544320;
      }
      int n = i1;
      if ((i2 & 0x20000000) == 536870912) {
        n = i1 | 0x20000000;
      }
      i1 = n;
      if ((i2 & 0x400000) == 4194304) {
        i1 = n | 0x400000;
      }
    }
    catch (Exception paramString4)
    {
      label79:
      break label79;
    }
    i1 = 268435456;
    localAppLaucherHelper.a(this.app, this, paramString1, paramString2, paramString3, i1);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject;
    if (a(this, this.j))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startGame directStart = ");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(", app installed");
        QLog.d("PromptDialogActivity", 2, ((StringBuilder)localObject).toString());
      }
      localObject = (GamePartyManager)this.app.getManager(QQManagerFactory.GAME_PARTY_MANAGER);
      ((GamePartyManager)localObject).c();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://openmobile.qq.com/gameteam/start_game?uin=");
      localStringBuilder.append(this.app.getCurrentAccountUin());
      ((GamePartyManager)localObject).a(localStringBuilder.toString(), null);
      if (paramBoolean) {
        localObject = this.l;
      } else {
        localObject = String.format("platform=qq_m&current_uin=$OPID$&launchfrom=&gamedata=%s&platformdata=&openid=$OPID$&atoken=$AT$&ptoken=$PT$", new Object[] { this.k });
      }
      if (QQUtils.a(super.getApplicationContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PromptDialogActivity", 2, "startGame screen is locked, need unlock");
        }
        a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("PromptDialogActivity", 2, "startGame launch Game now");
      }
      a(this.i, (String)localObject, this.j, "0");
      ReportCenter.a().a(this.app.getCurrentAccountUin(), "", "", "2000", "2036", "0", false);
      finish();
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startGame directStart = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", app not installed");
      QLog.d("PromptDialogActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.b = DialogUtil.a(this, 230);
    this.b.setTitle(this.app.getApp().getString(2131889916));
    this.b.setMessage(this.app.getApp().getString(2131889913));
    this.b.setPositiveButton(this.app.getApp().getString(2131889915), this);
    this.b.setNegativeButton(this.app.getApp().getString(2131889914), this);
    this.b.setOnCancelListener(this);
    this.b.show();
    ReportCenter.a().a(this.app.getCurrentAccountUin(), "", "", "2000", "2036", "1", false);
    ReportCenter.a().a(this.app.getCurrentAccountUin(), "", "", "2000", "2039", "0", false);
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString.trim(), 0);
      return paramContext != null;
    }
    catch (Exception paramContext) {}
    return false;
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
    Object localObject = super.getIntent();
    if (localObject == null)
    {
      finish();
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PromptDialogActivity", 2, "doOnCreate start");
    }
    super.doOnCreate(paramBundle);
    this.i = ((Intent)localObject).getStringExtra("appid");
    paramBundle = ((Intent)localObject).getStringExtra("packageName");
    int n = paramBundle.indexOf('|');
    if ((n >= 0) && (n < paramBundle.length() - 1))
    {
      this.j = paramBundle.substring(0, n);
      this.m = paramBundle.substring(n + 1, paramBundle.length());
      if ((!TextUtils.isEmpty(this.i)) && (!TextUtils.isEmpty(this.j)))
      {
        if (((Intent)localObject).getBooleanExtra("direct_start", false))
        {
          this.l = ((Intent)localObject).getStringExtra("paramsStr");
          a(true);
          return true;
        }
        String str1 = ((Intent)localObject).getStringExtra("title");
        String str2 = ((Intent)localObject).getStringExtra("summary");
        paramBundle = ((Intent)localObject).getStringExtra("picUrl");
        this.k = ((Intent)localObject).getStringExtra("gamedata");
        ((Intent)localObject).getBooleanExtra("leader", false);
        super.getWindow().addFlags(524288);
        super.getWindow().addFlags(128);
        super.getWindow().addFlags(2097152);
        super.getWindow().addFlags(1024);
        setContentView(2131624923);
        this.g = ((Button)findViewById(2131435343));
        this.h = ((Button)findViewById(2131446297));
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.d = ((URLImageView)findViewById(2131435219));
        this.e = ((TextView)findViewById(2131447463));
        this.f = ((TextView)findViewById(2131446627));
        this.e.setText(str1);
        this.f.setText(str2);
      }
    }
    try
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = super.getResources().getDimensionPixelSize(2131297537);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = super.getResources().getDimensionPixelSize(2131297536);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = super.getResources().getDrawable(2130839283);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = super.getResources().getDrawable(2130839283);
      paramBundle = URLDrawable.getDrawable(paramBundle, (URLDrawable.URLDrawableOptions)localObject);
      this.d.setImageDrawable(paramBundle);
      return true;
    }
    catch (Exception paramBundle)
    {
      label429:
      break label429;
    }
    this.d.setImageDrawable(super.getResources().getDrawable(2130839283));
    return true;
    if (QLog.isColorLevel()) {
      QLog.d("PromptDialogActivity", 2, "doOnCreate appid or packageName is empty");
    }
    finish();
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("PromptDialogActivity", 2, "doOnCreate split packageName and downloadUrl failed");
    }
    finish();
    return false;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    finish();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface == this.c)
    {
      if (paramInt == 1)
      {
        a(true);
        paramDialogInterface.dismiss();
        return;
      }
      if (paramInt == 0)
      {
        paramDialogInterface.dismiss();
        finish();
      }
    }
    else if (paramDialogInterface == this.b)
    {
      if (paramInt == 1)
      {
        ReportCenter.a().a(this.app.getCurrentAccountUin(), "", "", "2000", "2041", "0", false);
        if (QQUtils.a(super.getApplicationContext()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PromptDialogActivity", 2, "on click download button, need unlock screen");
          }
          a();
        }
        if (!TextUtils.isEmpty(this.m))
        {
          Intent localIntent = new Intent(this, QQBrowserActivity.class);
          localIntent.putExtra("url", this.m);
          startActivity(localIntent);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("PromptDialogActivity", 2, "on click download button, download url is empty");
        }
        paramDialogInterface.dismiss();
        finish();
        return;
      }
      if (paramInt == 0)
      {
        ReportCenter.a().a(this.app.getCurrentAccountUin(), "", "", "2000", "2040", "0", false);
        paramDialogInterface.dismiss();
        finish();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    if (n != 2131435343)
    {
      if (n == 2131446297)
      {
        ReportCenter.a().a(this.app.getCurrentAccountUin(), "", "", "2000", "2045", "0", false);
        a(false);
      }
    }
    else
    {
      ReportCenter.a().a(this.app.getCurrentAccountUin(), "", "", "2000", "2046", "0", false);
      finish();
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
 * Qualified Name:     com.tencent.mobileqq.gameparty.PromptDialogActivity
 * JD-Core Version:    0.7.0.1
 */