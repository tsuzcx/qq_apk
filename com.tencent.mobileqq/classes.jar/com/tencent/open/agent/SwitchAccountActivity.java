package com.tencent.open.agent;

import Override;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import auuv;
import bisl;
import bjfy;
import bjfz;
import bjgx;
import bjhh;
import bjmq;
import bjpm;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class SwitchAccountActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected float a;
  protected int a;
  public long a;
  protected SharedPreferences.Editor a;
  protected SharedPreferences a;
  protected View.OnTouchListener a;
  protected LinearLayout a;
  protected bisl a;
  public OpenSDKAppInterface a;
  protected String a;
  protected ArrayList<String> a;
  public WtloginManager a;
  protected SSOAccountObserver a;
  public boolean a;
  protected String b;
  
  public SwitchAccountActivity()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new bjfy(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new bjfz(this);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("uin:'").append(paramString1).append("',");
    localStringBuilder.append("skey:'");
    if (paramString2 != null) {
      localStringBuilder.append(paramString2);
    }
    localStringBuilder.append("'}");
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    LayoutInflater localLayoutInflater = super.getLayoutInflater();
    int j = 0;
    int i = 0;
    for (;;)
    {
      int k = i;
      Object localObject1;
      if (j < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        View localView = localLayoutInflater.inflate(2131558411, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        TextView localTextView1 = (TextView)localView.findViewById(2131371958);
        TextView localTextView2 = (TextView)localView.findViewById(2131380440);
        ImageView localImageView = (ImageView)localView.findViewById(2131366345);
        String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        localObject1 = new WloginSimpleInfo();
        this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(str, (WloginSimpleInfo)localObject1);
        Object localObject2 = new String(((WloginSimpleInfo)localObject1)._nick);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = str;
        }
        localTextView1.setText((CharSequence)localObject1);
        localTextView2.setText(str);
        localObject1 = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a("" + str, (int)(60.0F * this.jdField_a_of_type_Float), true);
        if (localObject1 != null)
        {
          localObject2 = bjhh.a(this, (Bitmap)localObject1, 63, 63);
          ((Bitmap)localObject1).recycle();
          if (localObject2 != null) {
            localImageView.setImageBitmap((Bitmap)localObject2);
          }
        }
        if (i == 0) {
          localView.setBackgroundResource(2130839512);
        }
        ((Button)localView.findViewById(2131365461)).setOnClickListener(this);
        localView.setOnClickListener(this);
        localView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        localView.setTag(str);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
        i += 1;
        if (i >= 10) {
          k = i;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwitchAccountActivity", 2, "-->showAccountList--count = " + k);
        }
        bjgx.a().a("", "", "", "1010", String.valueOf(k), "0", false, true);
        localObject1 = localLayoutInflater.inflate(2131558427, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        ((View)localObject1).setOnClickListener(this);
        return;
      }
      j += 1;
    }
  }
  
  protected void a(String paramString)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.d("SwitchAccountActivity", 2, "-->deleteAccount--account to delete is " + paramString);
    }
    bjmq.c(paramString);
    Object localObject1 = localObject2;
    String str;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null) != null)
    {
      str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null);
      localObject1 = localObject2;
      if (str != null) {
        localObject1 = str.split(",");
      }
    }
    localObject2 = new ArrayList();
    if (localObject1 != null)
    {
      int j = localObject1.length;
      i = 0;
      while (i < j)
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
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + "," + str) {
        str = (String)((Iterator)localObject2).next();
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("accList", (String)localObject1);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
    }
    if (paramString.equals(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_account", "")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwitchAccountActivity", 2, "-->deleteAccount--account to delete equals last account, clear last account");
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove("last_account").commit();
    }
    long l = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString);
    localObject1 = new File(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b("" + l));
    if (!((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        if (!((View)localObject1).getTag().equals(paramString)) {
          break label456;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView((View)localObject1);
        if (i == 0)
        {
          paramString = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() != 1) {
            break label449;
          }
          paramString.setBackgroundResource(2130839496);
        }
      }
      return;
      label449:
      paramString.setBackgroundResource(2130839512);
      return;
      label456:
      i += 1;
    }
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("-->loginSucess--mReqSrc = ").append(this.jdField_a_of_type_Int).append(", userAccount = *").append(bjhh.a(paramString1)).append(", bundle = null ? ");
      if (paramBundle == null)
      {
        bool = true;
        QLog.d("Q.quicklogin.SwitchAccountActivity", 2, bool);
      }
    }
    else
    {
      bjmq.a(paramString1);
      if ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 3)) {
        break label227;
      }
      paramString2 = new WloginSimpleInfo();
      this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(this.jdField_a_of_type_JavaLangString, paramString2);
      paramString2 = new Intent();
      paramString1 = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
      paramString2.putExtra("last_account", paramString1);
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString1)) {
        break label215;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "isLogin: true");
      }
      paramString2.putExtra("isLogin", true);
    }
    for (;;)
    {
      super.setResult(-1, paramString2);
      super.finish();
      return;
      bool = false;
      break;
      label215:
      paramString2.putExtra("isLogin", false);
    }
    label227:
    Object localObject2 = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(paramString1, (WloginSimpleInfo)localObject2);
    Object localObject1 = new Intent();
    String str = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
    auuv.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", str, true);
    localObject2 = new String(((WloginSimpleInfo)localObject2)._nick);
    if (paramString2 != null)
    {
      paramString1 = new String(paramString2);
      label326:
      ((Intent)localObject1).putExtra("result_data", a(str, paramString1));
      ((Intent)localObject1).putExtra("nick", (String)localObject2);
      ((Intent)localObject1).putExtra("last_account", str);
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(str)) {
        break label440;
      }
      ((Intent)localObject1).putExtra("isLogin", false);
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        paramString1 = paramBundle.getByteArray("st_temp");
        paramString2 = paramBundle.getByteArray("st_temp_key");
        ((Intent)localObject1).putExtra("st_temp", paramString1);
        ((Intent)localObject1).putExtra("st_temp_key", paramString2);
      }
      super.setResult(-1, (Intent)localObject1);
      break;
      paramString1 = null;
      break label326;
      label440:
      ((Intent)localObject1).putExtra("isLogin", true);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwitchAccountActivity", 2, "-->showLoginActivity");
    }
    Intent localIntent = new Intent(this, Login.class);
    localIntent.putExtra("key_req_src", this.jdField_a_of_type_Int);
    localIntent.putExtra("appid", this.b);
    super.startActivityForResult(localIntent, 1);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (bjhh.b(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "-->login--has aone");
        }
        a(this.jdField_a_of_type_JavaLangString, null, null);
        return;
      }
      b();
      return;
    }
    if (this.jdField_a_of_type_Int == 3)
    {
      if (!bjhh.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "-->login--has atwo");
        }
        a(this.jdField_a_of_type_JavaLangString, null, null);
        return;
      }
      b();
      return;
    }
    if (bjhh.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString)) {
      b();
    }
    for (;;)
    {
      d();
      return;
      QLog.d("SwitchAccountActivity", 1, "send | cmd: g_t_n_p | uin : *" + bjhh.a(this.jdField_a_of_type_JavaLangString));
      auuv.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      bjpm.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverSSOAccountObserver, this.b, 1);
    }
  }
  
  protected void d()
  {
    this.jdField_a_of_type_Bisl.a(super.getString(2131694460));
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_Bisl.isShowing()) && (getWindow().isActive())) {
      this.jdField_a_of_type_Bisl.show();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bisl.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("-->onActivityResult--reqCode = ").append(paramInt1).append(", resCode = ").append(paramInt2).append(", data = null ? ");
      if (paramIntent == null)
      {
        bool = true;
        QLog.d("SwitchAccountActivity", 2, bool);
      }
    }
    else
    {
      switch (paramInt1)
      {
      }
    }
    label124:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        super.getIntent().getStringExtra("key_action");
        if (paramInt2 != 0) {
          break label124;
        }
      } while (!this.jdField_a_of_type_Bisl.isShowing());
      this.jdField_a_of_type_Bisl.dismiss();
      return;
    } while (-1 != paramInt2);
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      View localView = (View)paramView.getParent().getParent();
      if ((localView != null) && (localView.getTag() != null))
      {
        a((String)localView.getTag());
        continue;
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaLangString = ((String)paramView.getTag());
          c();
          continue;
          b();
        }
      }
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
    super.setContentView(2131562922);
    this.jdField_a_of_type_AndroidContentSharedPreferences = super.getSharedPreferences("accountList", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    paramBundle = super.getIntent();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getExtras();
      if (paramBundle != null)
      {
        this.jdField_a_of_type_Int = paramBundle.getInt("key_req_src", 1);
        this.b = paramBundle.getString("third_app_id", "");
      }
    }
    QLog.d("Q.quicklogin.SwitchAccountActivity", 1, "mReqSrc:" + this.jdField_a_of_type_Int);
    super.setTitle(2131694468);
    this.jdField_a_of_type_Bisl = new bisl(this, getTitleBarHeight());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131361898));
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)super.getAppRuntime());
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    this.jdField_a_of_type_JavaUtilArrayList = bjmq.a();
    paramBundle = super.getIntent().getStringExtra("param_uin");
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramBundle);
    }
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.SwitchAccountActivity
 * JD-Core Version:    0.7.0.1
 */