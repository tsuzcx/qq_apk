package com.tencent.open.agent;

import aljx;
import aljy;
import aljz;
import alka;
import alkb;
import alkc;
import alkd;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRLoginActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.OpenConst;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.base.http.AvatarUpdateService;
import com.tencent.open.base.http.HttpImageDownloadAsyncTask.TaskCompleteCallback;
import com.tencent.open.data.SharedPrefs;
import com.tencent.open.model.AccountManage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class QuickLoginAuthorityActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, OpenConst, HttpImageDownloadAsyncTask.TaskCompleteCallback
{
  protected static final String[] a;
  protected float a;
  protected SharedPreferences a;
  public Bundle a;
  protected Handler a;
  public View a;
  protected Button a;
  protected RelativeLayout a;
  protected TextView a;
  public BounceScrollView a;
  protected QQProgressDialog a;
  public CardContainer a;
  public OpenSDKAppInterface a;
  public String a;
  protected List a;
  public WtloginManager a;
  protected SSOAccountObserver a;
  private WtloginObserver a;
  protected boolean a;
  public byte[] a;
  public Handler b;
  public View b;
  protected String b;
  private boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  protected String c;
  private String d;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "http://ptlogin2.qq.com", "http://ptlogin2.soso.com", "http://ptlogin2.paipai.com", "http://ptlogin2.tenpay.com", "http://ptlogin2.taotao.com", "http://ptlogin2.tencent.com", "http://ptlogin2.oa.com", "http://ptlogin2.webdev.com", "http://ptlogin2.3366.com", "http://ptlogin2.imqq.com", "http://ptlogin2.pengyou.com", "http://ptlogin2.qplus.com", "http://ptlogin2.qzone.com", "http://ptlogin2.id.qq.com", "http://ptlogin2.myapp.com", "http://ptlogin2.kuyoo.cn", "http://ptlogin2.function.qq.com", "http://ptlogin2.crm2.qq.com", "http://ptlogin2.weiyun.com", "http://ptlogin2.wechatapp.com", "http://ptlogin2.51buy.com", "http://ptlogin2.qcloud.com", "http://ptlogin2.wechat.com", "http://ptlogin2.qmail.com", "http://ptlogin2.ejinshang.com", "http://ptlogin2.lvren.com", "http://ptlogin2.weishi.com", "https://ssl.ptlogin2.qq.com", "https://ssl.ptlogin2.tenpay.com", "https://ssl.ptlogin2.paipai.com", "https://ssl.ptlogin2.soso.com", "https://ssl.ptlogin2.3366.com", "https://ssl.ptlogin2.pengyou.com", "https://ssl.ptlogin2.imqq.com", "https://ssl.ptlogin2.qzone.com", "https://ssl.ptlogin2.qcloud.com", "https://ssl.ptlogin2.51buy.com", "https://ssl.ptlogin2.weiyun.com", "https://ssl.ptlogin2.myapp.com", "https://ssl.ptlogin2.yixun.com", "https://ssl.ptlogin2.wanggou.com", "https://ssl.ptlogin2.ejinshang.com" };
  }
  
  public QuickLoginAuthorityActivity()
  {
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new aljx(this);
    this.jdField_a_of_type_MqqObserverWtloginObserver = new aljy(this);
    this.jdField_a_of_type_AndroidOsHandler = new alka(this, ThreadManager.getSubThreadLooper());
    this.jdField_b_of_type_AndroidOsHandler = new alkb(this, Looper.getMainLooper());
  }
  
  private int a()
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("qrcode");
    int i = str.indexOf("?k=") + 3;
    str = str.substring(i, i + 32);
    this.jdField_b_of_type_ArrayOfByte = QRLoginActivity.a(str.getBytes(), str.length());
    return this.jdField_a_of_type_MqqManagerWtloginManager.VerifyCode(this.jdField_a_of_type_JavaLangString, 16L, true, this.jdField_b_of_type_ArrayOfByte, null, 1, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  private Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    try
    {
      paramString = new URL(paramString);
      paramString = paramString.getQuery();
      if (TextUtils.isEmpty(paramString)) {
        return localBundle;
      }
    }
    catch (MalformedURLException paramString)
    {
      return localBundle;
    }
    paramString = paramString.split("&");
    int i = 0;
    while (i < paramString.length)
    {
      Object localObject = paramString[i];
      int j = localObject.indexOf('=');
      if (j > 0) {
        localBundle.putString(localObject.substring(0, j), localObject.substring(j + 1, localObject.length()));
      }
      i += 1;
    }
    return localBundle;
  }
  
  protected void a()
  {
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences = super.getSharedPreferences("accountList", i);
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
      e();
      return;
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("quicklogin_errmsg", paramString2);
    localIntent.putExtra("quicklogin_uin", paramString1);
    localIntent.putExtra("quicklogin_ret", paramInt);
    localIntent.putExtra("quicklogin_buff", paramArrayOfByte);
    super.setResult(-1, localIntent);
    g();
    super.finish();
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "setSdkResult:error:" + paramString2);
    }
    if (this.jdField_b_of_type_Boolean) {}
    try
    {
      paramString1 = ReportCenter.a();
      paramString2 = this.jdField_a_of_type_JavaLangString;
      if (paramInt != 0) {
        break label213;
      }
      paramArrayOfByte = "0";
    }
    catch (Exception paramArrayOfByte)
    {
      try
      {
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) || (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))) {
          break label212;
        }
        paramString1 = ReportCenter.a();
        paramString2 = this.jdField_a_of_type_JavaLangString;
        if (paramInt != 0) {
          break label228;
        }
        for (paramArrayOfByte = "0";; paramArrayOfByte = "1")
        {
          paramString1.a(paramString2, "", "", "1", "10", paramArrayOfByte, true);
          return;
          paramArrayOfByte = "1";
          break;
          paramArrayOfByte = paramArrayOfByte;
          paramArrayOfByte.printStackTrace();
          break label144;
        }
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    paramString1.a(paramString2, "", "", "1", "9", paramArrayOfByte, true);
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      super.setResult(0);
    }
    for (;;)
    {
      super.finish();
      return;
      super.setResult(0, paramIntent);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "-->showLoginActivity--uin = *" + AuthorityUtil.a(paramString));
    }
    Intent localIntent = new Intent(this, Login.class);
    if (paramString != null) {
      localIntent.putExtra("param_uin", paramString);
    }
    if (this.jdField_a_of_type_Boolean) {
      localIntent.putExtra("key_req_src", 3);
    }
    for (;;)
    {
      super.startActivityForResult(localIntent, 1);
      return;
      localIntent.putExtra("key_req_src", 2);
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("-->onTaskCompleted--identifier = ").append(paramString).append("bitmap = null ? ");
      if (paramBitmap != null) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.quicklogin.", 2, bool);
      if (paramString.equals(this.jdField_a_of_type_JavaLangString)) {
        runOnUiThread(new alkd(this, paramBitmap));
      }
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_MqqManagerWtloginManager.IsUserHaveA1(paramString, 16L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "-->login--has aone");
      }
      if (paramBoolean)
      {
        d(paramString);
        return;
      }
      e(paramString);
      return;
    }
    a(paramString);
  }
  
  protected boolean a(Bundle paramBundle)
  {
    if ((super.getIntent() == null) || (paramBundle != null)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
            } while (this.jdField_a_of_type_AndroidOsBundle == null);
            paramBundle = super.getIntent().getStringExtra("key_action");
            if (("action_ptlogin_login".equals(paramBundle)) || ("action_quick_login".equals(paramBundle))) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("Q.quicklogin.", 2, "invalid action! " + paramBundle);
          return false;
          this.jdField_a_of_type_Boolean = "action_ptlogin_login".equals(paramBundle);
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          if ((this.jdField_a_of_type_AndroidOsBundle.containsKey("qrcode")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("schemacallback"))) {
            return true;
          }
        } while (!this.jdField_a_of_type_AndroidOsBundle.containsKey("p"));
        paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("p");
        if (!TextUtils.isEmpty(paramBundle))
        {
          String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            if (paramBundle.startsWith(arrayOfString[i])) {
              return true;
            }
            i += 1;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.quicklogin.", 2, "invalid path! " + paramBundle);
      return false;
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidOsBundle.getByteArray("publickey");
      this.c = this.jdField_a_of_type_AndroidOsBundle.getString("packagename");
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.", 2, "mSrcPackageName: " + this.c);
      }
      if ((this.jdField_a_of_type_ArrayOfByte != null) && (!TextUtils.isEmpty(this.c)) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("dstSsoVer")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("subDstAppid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("dstAppid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("dstAppVer"))) {
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.quicklogin.", 2, "invalid parameters! " + this.jdField_a_of_type_AndroidOsBundle.toString());
    return false;
  }
  
  protected void b()
  {
    c();
  }
  
  protected void b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {
      return;
    }
    Object localObject1 = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1);
    Object localObject2 = new String(((WloginSimpleInfo)localObject1)._nick);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramString;
    }
    if (!TextUtils.isEmpty(paramString)) {}
    label479:
    label488:
    for (localObject2 = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(paramString, (int)(58.0F * this.jdField_a_of_type_Float), true);; localObject2 = null) {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(paramString, (String)localObject1, (Bitmap)localObject2, true);
        if (localObject2 != null)
        {
          localObject1 = Message.obtain();
          ((Message)localObject1).what = 1000;
          ((Message)localObject1).obj = localObject2;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
        }
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("packagename");
        if (this.jdField_a_of_type_Boolean)
        {
          Bundle localBundle = a(this.jdField_a_of_type_AndroidOsBundle.getString("p"));
          localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("appname");
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = localBundle.getString("pt_appname");
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = localObject1;
            if (((String)localObject1).length() > 20) {
              localObject2 = ((String)localObject1).substring(0, 20);
            }
            this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a((String)localObject2, null);
          }
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("package");
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = localBundle.getString("pt_package");
          }
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (((String)localObject2).length() > 100) {
              localObject1 = ((String)localObject2).substring(0, 100);
            }
          }
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        try
        {
          localObject2 = WtloginHelper.GetFastLoginUrl((String)localObject1, Long.valueOf(Long.parseLong(paramString)).longValue());
          if (localObject2 == null) {
            break;
          }
          if (!TextUtils.isEmpty(((WFastLoginInfo)localObject2).iconUrl))
          {
            paramString = Message.obtain();
            paramString.what = 1001;
            paramString.obj = ((WFastLoginInfo)localObject2).iconUrl;
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
          }
          if (!this.jdField_a_of_type_Boolean) {}
          try
          {
            paramString = super.getPackageManager();
          }
          catch (PackageManager.NameNotFoundException paramString)
          {
            for (;;)
            {
              label375:
              paramString = null;
              localObject1 = null;
            }
          }
          try
          {
            localObject1 = paramString.getApplicationInfo((String)localObject1, 0);
            if (localObject1 == null) {
              break label488;
            }
            paramString = (String)paramString.getApplicationLabel((ApplicationInfo)localObject1);
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            break label479;
            paramString = "";
            break label375;
          }
          if (!TextUtils.isEmpty(paramString)) {
            this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(paramString, null);
          }
          if (TextUtils.isEmpty(((WFastLoginInfo)localObject2).adUrl)) {
            break;
          }
          paramString = new StringBuffer(((WFastLoginInfo)localObject2).adUrl);
          this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setAdImageByURL(null, paramString.replace(0, 4, "gamead").toString());
          return;
        }
        catch (NumberFormatException paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.quicklogin.", 2, "Long.parseLong(uin) has NumberFormatException" + paramString.getMessage());
            }
            localObject2 = null;
          }
        }
      }
    }
  }
  
  protected void c()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "updatePortrait");
    }
    String str = ((TicketManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_JavaLangString);
    AvatarUpdateService.a().a(this, this.jdField_a_of_type_JavaLangString, str, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b(this.jdField_a_of_type_JavaLangString), this);
  }
  
  protected void c(String paramString)
  {
    Object localObject2 = new ArrayList();
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null) != null) {}
    for (Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null).split(",");; localObject1 = null)
    {
      Object localObject3;
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          localObject3 = localObject1[i];
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((ArrayList)localObject2).add(localObject3);
          }
          i += 1;
        }
      }
      if (!((ArrayList)localObject2).contains(paramString)) {
        ((ArrayList)localObject2).add(paramString);
      }
      for (;;)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + "," + (String)localObject3) {
          localObject3 = (String)((Iterator)localObject2).next();
        }
        ((ArrayList)localObject2).remove(paramString);
        ((ArrayList)localObject2).add(paramString);
      }
      localObject2 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject2).putString("last_account", paramString);
      ((SharedPreferences.Editor)localObject2).putString("accList", (String)localObject1);
      ((SharedPreferences.Editor)localObject2).commit();
      return;
    }
  }
  
  protected void d()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = this.jdField_a_of_type_JavaUtilList.size();
    }
    if (i > 1)
    {
      Intent localIntent = new Intent(this, SwitchAccountActivity.class);
      if (this.jdField_a_of_type_JavaLangString != null) {
        localIntent.putExtra("param_uin", this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Boolean) {
        localIntent.putExtra("key_req_src", 3);
      }
      for (;;)
      {
        super.startActivityForResult(localIntent, 1);
        return;
        localIntent.putExtra("key_req_src", 2);
      }
    }
    a(this.jdField_a_of_type_JavaLangString);
  }
  
  protected void d(String paramString)
  {
    SharedPrefs.a(paramString);
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, localWloginSimpleInfo);
    paramString = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    boolean bool;
    if (this.jdField_a_of_type_JavaUtilList.contains(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "isLogin: true");
      }
      bool = true;
      paramString = new WloginSimpleInfo();
      if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {
        break label203;
      }
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.jdField_a_of_type_JavaLangString, paramString);
    }
    label203:
    for (paramString = new String(paramString._nick);; paramString = null)
    {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_a_of_type_JavaLangString, paramString, null, true);
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.", 2, "isLogin:" + bool);
        }
        c(this.jdField_a_of_type_JavaLangString);
      }
      h();
      return;
      bool = false;
      break;
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface == null)
    {
      d();
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.", 2, "login mAccountString :" + this.jdField_b_of_type_JavaLangString);
      }
    }
    b(this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      boolean bool;
      if (this.jdField_a_of_type_Boolean) {
        if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.jdField_a_of_type_JavaLangString, 16)) {
          bool = true;
        }
      }
      while (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.", 2, "login have");
        }
        b();
        return;
        bool = false;
        continue;
        bool = this.jdField_a_of_type_MqqManagerWtloginManager.IsUserHaveA1(this.jdField_a_of_type_JavaLangString, 16L);
      }
      d();
      QQToast.a(BaseApplicationImpl.getContext(), 2131435630, 0).b(getResources().getDimensionPixelSize(2131558448));
      return;
    }
    d();
  }
  
  protected void e(String paramString)
  {
    SharedPrefs.a(paramString);
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, localWloginSimpleInfo);
    paramString = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    boolean bool;
    if (this.jdField_a_of_type_JavaUtilList.contains(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "isLogin: true");
      }
      bool = true;
      paramString = new WloginSimpleInfo();
      if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {
        break label199;
      }
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.jdField_a_of_type_JavaLangString, paramString);
    }
    label199:
    for (paramString = new String(paramString._nick);; paramString = null)
    {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_a_of_type_JavaLangString, paramString, null, true);
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.", 2, "isLogin:" + bool);
        }
        c(this.jdField_a_of_type_JavaLangString);
      }
      return;
      bool = false;
      break;
    }
  }
  
  public void f()
  {
    super.setResult(-1, new Intent());
    g();
    super.finish();
    if (this.jdField_b_of_type_Boolean) {}
    try
    {
      ReportCenter.a().a(this.jdField_a_of_type_JavaLangString, "", "", "1", "9", "0", true);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) && (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))) {
            ReportCenter.a().a(this.jdField_a_of_type_JavaLangString, "", "", "1", "10", "0", true);
          }
          new alkc(this).start();
          if (QLog.isColorLevel()) {
            QLog.d("Q.quicklogin.", 2, "setPtloginSdkResult:");
          }
          return;
          localException1 = localException1;
          localException1.printStackTrace();
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  public void g()
  {
    if ((!super.isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(super.getString(2131435627));
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "doAuthorize");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_AndroidOsBundle.containsKey("qrcode")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("schemacallback"))) {
        if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) {
          a();
        }
      }
      while (!this.jdField_a_of_type_AndroidOsBundle.containsKey("p"))
      {
        return;
        this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd(this.jdField_a_of_type_JavaLangString, 32, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
        return;
      }
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd(this.jdField_a_of_type_JavaLangString, 32, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      return;
    }
    long l1 = this.jdField_a_of_type_AndroidOsBundle.getLong("dstSsoVer", 0L);
    long l2 = this.jdField_a_of_type_AndroidOsBundle.getLong("subDstAppid", 0L);
    long l3 = this.jdField_a_of_type_AndroidOsBundle.getLong("dstAppid", 0L);
    byte[] arrayOfByte1 = this.jdField_a_of_type_AndroidOsBundle.getByteArray("dstAppVer");
    byte[] arrayOfByte2 = this.jdField_a_of_type_MqqManagerWtloginManager.getPkgSigFromApkName(this, this.c);
    if (QLog.isColorLevel())
    {
      QLog.d("Q.quicklogin.", 2, "dstAppSign.length: " + arrayOfByte2.length);
      String str = HexUtil.a(arrayOfByte2);
      QLog.d("Q.quicklogin.", 2, "dstAppSign: " + str);
    }
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetA1WithA1(this.jdField_a_of_type_JavaLangString, this.c.getBytes(), l1, l3, l2, arrayOfByte1, arrayOfByte2, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onActivityResult: resultcode:").append(paramInt2).append("requestCode:").append(paramInt1).append("data null?");
      if (paramIntent == null)
      {
        bool = true;
        QLog.d("Q.quicklogin.", 2, bool);
      }
    }
    else
    {
      if (paramInt1 != 100) {
        break label108;
      }
      if (paramInt2 != -1) {
        break label102;
      }
      if (paramIntent != null) {
        this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("uin");
      }
      a();
    }
    label102:
    label108:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        a(null);
        return;
        g();
        if (paramInt2 != 0) {
          break label129;
        }
      } while (this.jdField_a_of_type_JavaLangString != null);
      a(paramIntent);
      return;
    } while ((-1 != paramInt2) || (paramIntent == null));
    label129:
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("last_account");
    boolean bool = paramIntent.getBooleanExtra("isLogin", false);
    Object localObject = new WloginSimpleInfo();
    if (this.jdField_a_of_type_MqqManagerWtloginManager != null) {
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.jdField_a_of_type_JavaLangString, (WloginSimpleInfo)localObject);
    }
    for (paramIntent = new String(((WloginSimpleInfo)localObject)._nick);; paramIntent = paramIntent.getStringExtra("nick"))
    {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_a_of_type_JavaLangString, paramIntent, null, true);
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.", 2, "isLogin:" + bool);
        }
        c(this.jdField_a_of_type_JavaLangString);
      }
      h();
      return;
    }
  }
  
  public void onBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "onBackPressed");
    }
    a(null);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {
      return;
    }
    if (paramView == this.leftView)
    {
      a(null);
      return;
    }
    if (paramView == this.jdField_a_of_type_AndroidWidgetTextView)
    {
      ReportCenter.a().a(this.jdField_a_of_type_JavaLangString, "", "", "1000", "200", "0", false);
      d();
      return;
    }
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (!NetworkUtil.g(this))
      {
        g();
        this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this, getResources().getString(2131435619));
        return;
      }
      boolean bool;
      if (this.jdField_a_of_type_Boolean) {
        if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.jdField_a_of_type_JavaLangString, 16)) {
          bool = true;
        }
      }
      while (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.", 2, "onClick login have");
        }
        h();
        return;
        bool = false;
        continue;
        bool = this.jdField_a_of_type_MqqManagerWtloginManager.IsUserHaveA1(this.jdField_a_of_type_JavaLangString, 16L);
      }
      d();
      QQToast.a(BaseApplicationImpl.getContext(), 2131435630, 0).b(super.getResources().getDimensionPixelSize(2131558448));
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a(this.jdField_a_of_type_JavaLangString);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)super.getAppRuntime());
    if (!a(paramBundle))
    {
      QQToast.a(BaseApplicationImpl.getContext(), "参数错误", 0).a();
      a(null);
    }
    do
    {
      return;
      this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("authority_start_qq_login", false);
      super.setContentView(2130969252);
      this.leftView.setText(2131435617);
      super.setTitle(2131435612);
      this.leftView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131362845);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131365772);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131365773));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365774));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365768));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (AppSetting.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText() + "按钮");
      }
      this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)super.findViewById(2131363793));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer = ((CardContainer)super.findViewById(2131365762));
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, 0, 2130970592, 17);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(-1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
        AccountManage.a().a();
        this.jdField_a_of_type_JavaUtilList = SharedPrefs.a();
        if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.isLogin()) {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount();
        }
        if ((this.jdField_a_of_type_JavaLangString == null) && (this.jdField_a_of_type_JavaUtilList != null)) {
          this.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilList.get(0));
        }
        this.d = getIntent().getStringExtra("login_success_uin");
        if ((!TextUtils.isEmpty(this.d)) && (!this.d.equals(this.jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_JavaLangString = this.d;
        }
        paramBundle = super.getAppRuntime().getAccount();
        if ((GesturePWDUtils.getJumpLock(this, paramBundle)) && (!GesturePWDUtils.getAppForground(this)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.quicklogin.", 2, "-->onCreate--has gesture password, will start unlock activity");
          }
          this.jdField_b_of_type_JavaLangString = paramBundle;
          paramBundle = new Intent(this, GesturePWDUnlockActivity.class);
          paramBundle.putExtra("key_gesture_from_authority", true);
          super.startActivityForResult(paramBundle, 100);
        }
      }
      else
      {
        if (isChild()) {}
        for (paramBundle = getParent();; paramBundle = this)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramBundle, super.getTitleBarHeight());
          break;
        }
      }
      a();
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new aljz(this));
    } while (!this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a();
    h();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QLog.d("Q.quicklogin.", 2, "ondestroy");
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity
 * JD-Core Version:    0.7.0.1
 */