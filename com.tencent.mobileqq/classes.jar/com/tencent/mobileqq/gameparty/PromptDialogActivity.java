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
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  private Button jdField_a_of_type_AndroidWidgetButton = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView = null;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private String jdField_a_of_type_JavaLangString = "";
  private Button jdField_b_of_type_AndroidWidgetButton = null;
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private String jdField_b_of_type_JavaLangString = "";
  private String c = "";
  private String d = "";
  private String e = "";
  
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
    int j = 268435456;
    try
    {
      int k = Integer.parseInt(paramString4);
      if ((k & 0x4000000) == 67108864) {
        j = 335544320;
      }
      int i = j;
      if ((k & 0x20000000) == 536870912) {
        i = j | 0x20000000;
      }
      j = i;
      if ((k & 0x400000) == 4194304) {
        j = i | 0x400000;
      }
    }
    catch (Exception paramString4)
    {
      label79:
      break label79;
    }
    j = 268435456;
    localAppLaucherHelper.a(this.app, this, paramString1, paramString2, paramString3, j);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject;
    if (a(this, this.jdField_b_of_type_JavaLangString))
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
      ((GamePartyManager)localObject).b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://openmobile.qq.com/gameteam/start_game?uin=");
      localStringBuilder.append(this.app.getCurrentAccountUin());
      ((GamePartyManager)localObject).a(localStringBuilder.toString(), null);
      if (paramBoolean) {
        localObject = this.d;
      } else {
        localObject = String.format("platform=qq_m&current_uin=$OPID$&launchfrom=&gamedata=%s&platformdata=&openid=$OPID$&atoken=$AT$&ptoken=$PT$", new Object[] { this.c });
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
      a(this.jdField_a_of_type_JavaLangString, (String)localObject, this.jdField_b_of_type_JavaLangString, "0");
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
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(this.app.getApp().getString(2131692812));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(this.app.getApp().getString(2131692809));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(this.app.getApp().getString(2131692811), this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(this.app.getApp().getString(2131692810), this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
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
    this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("appid");
    paramBundle = ((Intent)localObject).getStringExtra("packageName");
    int i = paramBundle.indexOf('|');
    if ((i >= 0) && (i < paramBundle.length() - 1))
    {
      this.jdField_b_of_type_JavaLangString = paramBundle.substring(0, i);
      this.e = paramBundle.substring(i + 1, paramBundle.length());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
      {
        if (((Intent)localObject).getBooleanExtra("direct_start", false))
        {
          this.d = ((Intent)localObject).getStringExtra("paramsStr");
          a(true);
          return true;
        }
        String str1 = ((Intent)localObject).getStringExtra("title");
        String str2 = ((Intent)localObject).getStringExtra("summary");
        paramBundle = ((Intent)localObject).getStringExtra("picUrl");
        this.c = ((Intent)localObject).getStringExtra("gamedata");
        ((Intent)localObject).getBooleanExtra("leader", false);
        super.getWindow().addFlags(524288);
        super.getWindow().addFlags(128);
        super.getWindow().addFlags(2097152);
        super.getWindow().addFlags(1024);
        setContentView(2131559168);
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131368448));
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131377828));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131368343));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378784));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378120));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(str2);
      }
    }
    try
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = super.getResources().getDimensionPixelSize(2131297152);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = super.getResources().getDimensionPixelSize(2131297151);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = super.getResources().getDrawable(2130839127);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = super.getResources().getDrawable(2130839127);
      paramBundle = URLDrawable.getDrawable(paramBundle, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBundle);
      return true;
    }
    catch (Exception paramBundle)
    {
      label429:
      break label429;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(super.getResources().getDrawable(2130839127));
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
    if (paramDialogInterface == this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog)
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
    else if (paramDialogInterface == this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog)
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
        if (!TextUtils.isEmpty(this.e))
        {
          Intent localIntent = new Intent(this, QQBrowserActivity.class);
          localIntent.putExtra("url", this.e);
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
    int i = paramView.getId();
    if (i != 2131368448)
    {
      if (i == 2131377828)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gameparty.PromptDialogActivity
 * JD-Core Version:    0.7.0.1
 */