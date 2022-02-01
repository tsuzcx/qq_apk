package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.BaseOpenSdkQIPCClient;
import com.tencent.open.OpenConst;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.AuthParamUtil;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.QQLiteStatusUtil;
import com.tencent.open.agent.util.QRLoginAuthUtil;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.open.base.http.AvatarUpdateService;
import com.tencent.open.base.http.HttpImageDownloadAsyncTask.TaskCompleteCallback;
import com.tencent.open.data.SharedPrefs;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.open.widget.MaxHeightScrollView;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class QuickLoginAuthorityActivity
  extends QBaseActivity
  implements View.OnClickListener, OpenConst, HttpImageDownloadAsyncTask.TaskCompleteCallback
{
  protected static final String[] a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  protected SharedPreferences a;
  protected Bundle a;
  protected Handler a;
  protected View a;
  protected Button a;
  protected RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected QQProgressDialog a;
  protected CardContainer a;
  private MaxHeightScrollView jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  protected String a;
  protected List<String> a;
  protected WtloginManager a;
  protected SSOAccountObserver a;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new QuickLoginAuthorityActivity.2(this);
  protected boolean a;
  protected byte[] a;
  protected Handler b;
  protected View b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected String b;
  private WtloginObserver jdField_b_of_type_MqqObserverWtloginObserver = new QuickLoginAuthorityActivity.3(this);
  private boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  protected String c;
  private boolean jdField_c_of_type_Boolean = false;
  protected String d;
  private boolean d;
  private String e;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "http://ptlogin2.qq.com", "http://ptlogin2.soso.com", "http://ptlogin2.paipai.com", "http://ptlogin2.tenpay.com", "http://ptlogin2.taotao.com", "http://ptlogin2.tencent.com", "http://ptlogin2.oa.com", "http://ptlogin2.webdev.com", "http://ptlogin2.3366.com", "http://ptlogin2.imqq.com", "http://ptlogin2.pengyou.com", "http://ptlogin2.qplus.com", "http://ptlogin2.qzone.com", "http://ptlogin2.id.qq.com", "http://ptlogin2.myapp.com", "http://ptlogin2.kuyoo.cn", "http://ptlogin2.function.qq.com", "http://ptlogin2.crm2.qq.com", "http://ptlogin2.weiyun.com", "http://ptlogin2.wechatapp.com", "http://ptlogin2.51buy.com", "http://ptlogin2.qcloud.com", "http://ptlogin2.wechat.com", "http://ptlogin2.qmail.com", "http://ptlogin2.ejinshang.com", "http://ptlogin2.lvren.com", "http://ptlogin2.weishi.com", "https://ssl.ptlogin2.qq.com", "https://ssl.ptlogin2.tenpay.com", "https://ssl.ptlogin2.paipai.com", "https://ssl.ptlogin2.soso.com", "https://ssl.ptlogin2.3366.com", "https://ssl.ptlogin2.pengyou.com", "https://ssl.ptlogin2.imqq.com", "https://ssl.ptlogin2.qzone.com", "https://ssl.ptlogin2.qcloud.com", "https://ssl.ptlogin2.51buy.com", "https://ssl.ptlogin2.weiyun.com", "https://ssl.ptlogin2.myapp.com", "https://ssl.ptlogin2.yixun.com", "https://ssl.ptlogin2.wanggou.com", "https://ssl.ptlogin2.ejinshang.com" };
  }
  
  public QuickLoginAuthorityActivity()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_MqqManagerWtloginManager = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new QuickLoginAuthorityActivity.1(this);
    this.jdField_a_of_type_AndroidOsHandler = new QuickLoginAuthorityActivity.7(this, ThreadManager.getSubThreadLooper());
    this.jdField_b_of_type_AndroidOsHandler = new QuickLoginAuthorityActivity.8(this, Looper.getMainLooper());
  }
  
  private int a()
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->verifyQRCode()");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("qrcode");
    int i = str.indexOf("?k=") + 3;
    str = str.substring(i, i + 32);
    this.jdField_b_of_type_ArrayOfByte = QRLoginAuthUtil.a(str.getBytes(), str.length());
    return this.jdField_a_of_type_MqqManagerWtloginManager.verifyCode(this.jdField_a_of_type_JavaLangString, 16L, true, this.jdField_b_of_type_ArrayOfByte, null, 1, this.jdField_b_of_type_MqqObserverWtloginObserver);
  }
  
  private Intent a(Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("moveTaskToBack", true);
    return localIntent;
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
    catch (MalformedURLException paramString) {}
    return localBundle;
  }
  
  private AbstractOpenSdkAppInterface a()
  {
    AbstractOpenSdkAppInterface localAbstractOpenSdkAppInterface = (AbstractOpenSdkAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("waitAppRuntime app=");
    localStringBuilder.append(localAbstractOpenSdkAppInterface.hashCode());
    QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, localStringBuilder.toString());
    return localAbstractOpenSdkAppInterface;
  }
  
  private int b()
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->getAppidByWtlogin()");
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("qrcode");
    int i = ((String)localObject).indexOf("?k=") + 3;
    localObject = ((String)localObject).substring(i, i + 32);
    this.jdField_b_of_type_ArrayOfByte = QRLoginAuthUtil.a(((String)localObject).getBytes(), ((String)localObject).length());
    localObject = this.jdField_a_of_type_MqqManagerWtloginManager;
    String str = this.jdField_a_of_type_JavaLangString;
    byte[] arrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    WtloginObserver localWtloginObserver = this.jdField_a_of_type_MqqObserverWtloginObserver;
    return ((WtloginManager)localObject).verifyCode(str, 16L, true, arrayOfByte, new int[] { 3, 5, 32, 54 }, 1, localWtloginObserver);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131378881));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131369202));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131369249));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131369233));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694629);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690728);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.resetBkColor(0);
  }
  
  protected void a()
  {
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    } else {
      i = 0;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = super.getSharedPreferences("accountList", i);
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)a().getManager(1));
    d();
  }
  
  protected void a(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("quicklogin_errmsg", paramString2);
    localIntent.putExtra("quicklogin_uin", paramString1);
    localIntent.putExtra("quicklogin_ret", paramInt);
    localIntent.putExtra("quicklogin_buff", paramArrayOfByte);
    super.setResult(-1, localIntent);
    f();
    super.finish();
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("setSdkResult:error:");
    paramArrayOfByte.append(paramString2);
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, paramArrayOfByte.toString());
    if (this.jdField_b_of_type_Boolean) {
      try
      {
        paramString1 = ReportCenter.a();
        paramString2 = this.jdField_a_of_type_JavaLangString;
        if (paramInt == 0)
        {
          paramArrayOfByte = "0";
          paramString1.a(paramString2, "", "", "1", "9", paramArrayOfByte, true, true);
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setSdkResult report exception1:", paramArrayOfByte);
      }
    }
    for (;;)
    {
      try
      {
        if ((!TextUtils.isEmpty(a().getAccount())) && (!this.jdField_a_of_type_JavaLangString.equals(a().getAccount())))
        {
          paramString1 = ReportCenter.a();
          paramString2 = this.jdField_a_of_type_JavaLangString;
          if (paramInt != 0) {
            break label253;
          }
          paramArrayOfByte = "0";
          paramString1.a(paramString2, "", "", "1", "10", paramArrayOfByte, true, true);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setSdkResult report exception2:", paramArrayOfByte);
      }
      return;
      paramArrayOfByte = "1";
      break;
      label253:
      paramArrayOfByte = "1";
    }
  }
  
  protected void a(long paramLong, String paramString)
  {
    this.jdField_a_of_type_Long = paramLong;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getAppInfo appid =");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(",comfrom =");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, ((StringBuilder)localObject).toString());
    localObject = new GetAppInfoProto.GetAppinfoRequest();
    ((GetAppInfoProto.GetAppinfoRequest)localObject).client_id.set(paramLong);
    ((GetAppInfoProto.GetAppinfoRequest)localObject).sdkp.set(paramString);
    if (Build.VERSION.RELEASE == null) {
      paramString = "";
    } else {
      paramString = Build.VERSION.RELEASE;
    }
    ((GetAppInfoProto.GetAppinfoRequest)localObject).os.set(paramString);
    ((GetAppInfoProto.GetAppinfoRequest)localObject).qqv.set(CommonDataAdapter.a().d());
    ((GetAppInfoProto.GetAppinfoRequest)localObject).setHasFlag(true);
    paramString = AuthParamUtil.a(this);
    if (!TextUtils.isEmpty(paramString)) {
      ((GetAppInfoProto.GetAppinfoRequest)localObject).appUniqueIdentifier.set(paramString);
    }
    ((GetAppInfoProto.GetAppinfoRequest)localObject).referer.set(1);
    paramString = new NewIntent(MobileQQ.sMobileQQ, OpensdkServlet.class);
    paramString.setWithouLogin(true);
    paramString.putExtra("uin", this.jdField_a_of_type_JavaLangString);
    paramString.putExtra("data", ((GetAppInfoProto.GetAppinfoRequest)localObject).toByteArray());
    paramString.putExtra("cmd", "ConnAuthSvr.get_app_info");
    paramString.setObserver(new QuickLoginAuthorityActivity.11(this));
    super.getAppRuntime().startServlet(paramString);
  }
  
  protected void a(Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setResultCancel data=");
    localStringBuilder.append(paramIntent);
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, localStringBuilder.toString());
    if (paramIntent == null) {
      super.setResult(0);
    } else {
      super.setResult(0, paramIntent);
    }
    super.finish();
  }
  
  protected void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->showLoginActivity--uin = *");
    ((StringBuilder)localObject).append(AuthorityUtil.a(paramString));
    ((StringBuilder)localObject).append(",mIsPtloginAction=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
    ((StringBuilder)localObject).append(", mThirdAppId=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, ((StringBuilder)localObject).toString());
    localObject = new Intent();
    if (paramString != null) {
      ((Intent)localObject).putExtra("param_uin", paramString);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      ((Intent)localObject).putExtra("key_req_src", 3);
      ((Intent)localObject).putExtra("appid", Long.toString(this.jdField_a_of_type_Long));
    }
    else
    {
      ((Intent)localObject).putExtra("key_req_src", 2);
      paramString = this.jdField_a_of_type_AndroidOsBundle;
      if (paramString != null) {
        ((Intent)localObject).putExtra("appid", Long.toString(paramString.getLong("dstAppid", 0L)));
      }
    }
    RouteUtils.a(this, (Intent)localObject, "/base/openSdkLogin", 1);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->onTaskCompleted--identifier = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("bitmap = null ? ");
      boolean bool;
      if (paramBitmap == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, localStringBuilder.toString());
    }
    if (paramString.equals(this.jdField_a_of_type_JavaLangString)) {
      runOnUiThread(new QuickLoginAuthorityActivity.10(this, paramBitmap));
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (AuthorityUtil.b(this.jdField_a_of_type_MqqManagerWtloginManager, paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "-->login--has aone");
      }
      if (paramBoolean)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("changeAccountLogin, auto login is true, account is ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" ;currentAccount is");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, localStringBuilder.toString());
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        d(paramString);
        return;
      }
      e(paramString);
      this.jdField_b_of_type_JavaLangString = null;
      return;
    }
    a(paramString);
  }
  
  protected boolean a()
  {
    if (super.getIntent() == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" checkIntentValidity() [[[return false]]] intent = null activity=");
      ((StringBuilder)localObject1).append(this);
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, ((StringBuilder)localObject1).toString());
      return false;
    }
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    if (this.jdField_a_of_type_AndroidOsBundle == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" checkIntentValidity() [[[return false]]] mParams = null, activity=");
      ((StringBuilder)localObject1).append(this);
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, ((StringBuilder)localObject1).toString());
      return false;
    }
    Object localObject1 = super.getIntent().getStringExtra("key_action");
    Object localObject2;
    if ((!"action_ptlogin_login".equals(localObject1)) && (!"action_quick_login".equals(localObject1)))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkIntentValidity() invalid action = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, ((StringBuilder)localObject2).toString());
      return false;
    }
    this.jdField_a_of_type_Boolean = "action_ptlogin_login".equals(localObject1);
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_AndroidOsBundle.containsKey("qrcode")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("schemacallback"))) {
        return true;
      }
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("p"))
      {
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("p");
        if (QQLiteStatusUtil.b()) {
          localObject1 = "/";
        } else {
          localObject1 = "";
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            String str = arrayOfString[i];
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str);
            localStringBuilder.append((String)localObject1);
            if (((String)localObject2).startsWith(localStringBuilder.toString())) {
              return true;
            }
            i += 1;
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkIntentValidity() invalid path! ");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, ((StringBuilder)localObject1).toString());
        return false;
      }
    }
    else
    {
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidOsBundle.getByteArray("publickey");
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("packagename");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("mSrcPackageName: ");
        ((StringBuilder)localObject1).append(this.jdField_d_of_type_JavaLangString);
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, ((StringBuilder)localObject1).toString());
      }
      if ((this.jdField_a_of_type_ArrayOfByte != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("dstSsoVer")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("subDstAppid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("dstAppid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("dstAppVer"))) {
        return true;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkIntentValidity() invalid parameters! ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidOsBundle.toString());
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      try
      {
        boolean bool = TextUtils.isEmpty(paramString1);
        if ((!bool) && (!TextUtils.isEmpty(paramString2)))
        {
          byte[] arrayOfByte = getPackageManager().getPackageInfo(paramString1, 64).signatures[0].toByteArray();
          arrayOfByte = MessageDigest.getInstance("SHA1").digest(arrayOfByte);
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < arrayOfByte.length)
          {
            String str = Integer.toHexString(arrayOfByte[i] & 0xFF).toUpperCase(Locale.US);
            if (str.length() == 1) {
              localStringBuilder.append("0");
            }
            localStringBuilder.append(str);
            if (i != arrayOfByte.length - 1) {
              localStringBuilder.append(":");
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, new Object[] { "checkSignature packageName:", paramString1, " targetSig:", paramString2, " hexStr:", localStringBuilder });
            }
            return paramString2.equals(localStringBuilder.toString());
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, new Object[] { "checkSignature packageName:", paramString1, " targetSig:", paramString2 });
          }
          return false;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, paramString1, new Object[0]);
        return false;
      }
      i += 1;
    }
  }
  
  protected void b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "updateViews() return for empry account");
      return;
    }
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "updateViews()");
    String str = ((TicketManager)a().getManager(2)).getSkey(this.jdField_a_of_type_JavaLangString);
    AvatarUpdateService.a().a(this, this.jdField_a_of_type_JavaLangString, str, this);
  }
  
  protected void b(String paramString)
  {
    Object localObject2;
    String str;
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("0")))
    {
      localObject1 = new WloginSimpleInfo();
      this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(paramString, (WloginSimpleInfo)localObject1);
      localObject2 = new String(((WloginSimpleInfo)localObject1)._nick);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramString;
      }
      if (!TextUtils.isEmpty(paramString)) {
        localObject2 = OpenSdkVirtualUtil.a(paramString, 58, true);
      } else {
        localObject2 = null;
      }
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(paramString, (String)localObject1, (Bitmap)localObject2);
      if (localObject2 != null)
      {
        localObject1 = Message.obtain();
        ((Message)localObject1).what = 1000;
        ((Message)localObject1).obj = localObject2;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        localObject1 = getResources().getString(2131694615);
        this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a((String)localObject1, null);
        this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setAppType("web");
      }
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("packagename");
      boolean bool = this.jdField_a_of_type_Boolean;
      str = "";
      if (bool)
      {
        localObject3 = a(this.jdField_a_of_type_AndroidOsBundle.getString("p"));
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("appname");
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = ((Bundle)localObject3).getString("pt_appname");
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() > 20) {
            localObject2 = ((String)localObject1).substring(0, 20);
          }
          this.jdField_d_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a((String)localObject2, null);
        }
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("package");
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = ((Bundle)localObject3).getString("pt_package");
        }
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 100) {
            localObject1 = ((String)localObject2).substring(0, 100);
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            localObject2 = localObject1;
            if (((Bundle)localObject3).getString("daid") != null)
            {
              localObject2 = ((Bundle)localObject3).getString("daid", "");
              if (((String)localObject2).equals("5"))
              {
                this.jdField_d_of_type_Boolean = true;
                this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a("QQ空间", null);
                localObject1 = "com.qzone";
                break label478;
              }
              ((String)localObject2).equals("383");
              break label478;
            }
          }
        }
      }
      Object localObject3 = "";
      localObject1 = localObject2;
      localObject2 = localObject3;
      label478:
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (((String)localObject2).equals("383")) {
          try
          {
            paramString = URLDecoder.decode(this.jdField_a_of_type_AndroidOsBundle.getString("p"));
            long l = Long.valueOf(a(paramString).getString("client_id", "-1")).longValue();
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("login have urlDecode =");
              ((StringBuilder)localObject1).append(paramString);
              ((StringBuilder)localObject1).append(",clientId =");
              ((StringBuilder)localObject1).append(l);
              QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, ((StringBuilder)localObject1).toString());
            }
            a(l, "web");
            paramString = Message.obtain();
            paramString.what = 1004;
            paramString.obj = "web";
            this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
          }
          catch (Exception paramString)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("zhihu deal error  =");
            ((StringBuilder)localObject1).append(paramString.getMessage());
            QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, ((StringBuilder)localObject1).toString());
          }
        }
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, new Object[] { "showLocalInfo() => return for package is empty mIsPtloginAction=", Boolean.valueOf(this.jdField_a_of_type_Boolean), ", daid=", localObject2 });
        return;
      }
      try
      {
        localObject2 = WtloginHelper.GetFastLoginUrl((String)localObject1, Long.valueOf(Long.parseLong(paramString)).longValue());
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "Long.parseLong(uin) has NumberFormatException:", paramString);
        localObject2 = null;
      }
      if (localObject2 == null)
      {
        QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "showLocalInfo() return for loginInfo == null");
        return;
      }
      bool = this.jdField_a_of_type_Boolean;
      paramString = new StringBuilder();
      paramString.append(((WFastLoginInfo)localObject2).iconUrl);
      paramString.append(", adUrl=");
      QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, new Object[] { "showLocalInfo() => mIsPtloginAction=", Boolean.valueOf(bool), ", [loginInfo.iconUrl=", paramString.toString(), ((WFastLoginInfo)localObject2).adUrl });
      if (!TextUtils.isEmpty(((WFastLoginInfo)localObject2).iconUrl))
      {
        this.jdField_c_of_type_Boolean = true;
        paramString = Message.obtain();
        paramString.what = 1001;
        paramString.obj = ((WFastLoginInfo)localObject2).iconUrl;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      }
      if (this.jdField_a_of_type_Boolean) {}
    }
    try
    {
      paramString = super.getPackageManager();
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      label899:
      break label899;
    }
    try
    {
      localObject1 = paramString.getApplicationInfo((String)localObject1, 0);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label901;
    }
    paramString = null;
    label901:
    Object localObject1 = null;
    if (localObject1 != null) {
      str = (String)paramString.getApplicationLabel((ApplicationInfo)localObject1);
    }
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(str, null);
    }
    if (!TextUtils.isEmpty(((WFastLoginInfo)localObject2).adUrl))
    {
      paramString = new StringBuffer(((WFastLoginInfo)localObject2).adUrl);
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(null, paramString.replace(0, 4, "gamead").toString());
    }
    return;
    QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "showLocalInfo() return for uin invalid");
  }
  
  protected void c()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    int i;
    if (localObject != null) {
      i = ((List)localObject).size();
    } else {
      i = 0;
    }
    if (i > 1)
    {
      localObject = new Intent();
      String str = this.jdField_a_of_type_JavaLangString;
      if (str != null) {
        ((Intent)localObject).putExtra("param_uin", str);
      }
      if (this.jdField_a_of_type_Boolean) {
        i = 3;
      } else {
        i = 2;
      }
      ((Intent)localObject).putExtra("key_req_src", i);
      RouteUtils.a(this, (Intent)localObject, "/base/switchAccount", 1);
      return;
    }
    a(this.jdField_a_of_type_JavaLangString);
  }
  
  protected void c(String paramString)
  {
    Object localObject3 = new ArrayList();
    Object localObject4 = this.jdField_a_of_type_AndroidContentSharedPreferences;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (((SharedPreferences)localObject4).getString("accList", null) != null)
    {
      localObject4 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null);
      localObject1 = localObject2;
      if (localObject4 != null) {
        localObject1 = ((String)localObject4).split(",");
      }
    }
    if (localObject1 != null)
    {
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((ArrayList)localObject3).add(localObject2);
        }
        i += 1;
      }
    }
    if (!((ArrayList)localObject3).contains(paramString))
    {
      ((ArrayList)localObject3).add(paramString);
    }
    else
    {
      ((ArrayList)localObject3).remove(paramString);
      ((ArrayList)localObject3).add(paramString);
    }
    localObject2 = ((ArrayList)localObject3).iterator();
    for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = ((StringBuilder)localObject4).toString())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append(",");
      ((StringBuilder)localObject4).append((String)localObject3);
    }
    localObject2 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject2).putString("last_account", paramString);
    ((SharedPreferences.Editor)localObject2).putString("accList", (String)localObject1);
    ((SharedPreferences.Editor)localObject2).commit();
  }
  
  protected void d()
  {
    if (a() == null)
    {
      c();
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("login mAccountString :");
        localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, localStringBuilder.toString());
      }
    }
    b(this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      boolean bool;
      if (this.jdField_a_of_type_Boolean) {
        bool = AuthorityUtil.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString) ^ true;
      } else {
        bool = AuthorityUtil.b(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString);
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "login have");
        }
        b();
        return;
      }
      c();
      QQToast.a(MobileQQ.sMobileQQ, 2131694651, 0).b(getResources().getDimensionPixelSize(2131299168));
      return;
    }
    c();
  }
  
  protected void d(String paramString)
  {
    SharedPrefs.a(paramString);
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(paramString, localWloginSimpleInfo);
    paramString = OpenSdkVirtualUtil.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    boolean bool;
    if (this.jdField_a_of_type_JavaUtilList.contains(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "isLogin: true");
      }
      bool = true;
    }
    else
    {
      bool = false;
    }
    paramString = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(this.jdField_a_of_type_JavaLangString, paramString);
    paramString = new String(paramString._nick);
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_a_of_type_JavaLangString, paramString, null);
    if (bool)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("isLogin:");
        paramString.append(bool);
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, paramString.toString());
      }
      c(this.jdField_a_of_type_JavaLangString);
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = false;
    QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doOnCreate--");
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MANUFACTURER = ");
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append(", MODEL = ");
      localStringBuilder.append(Build.MODEL);
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 2, localStringBuilder.toString());
    }
    if ((localObject != null) && ((((String)localObject).equals("MeizuPRO 7-S")) || (((String)localObject).equalsIgnoreCase("MeizuM711C")))) {
      ImmersiveUtils.clearCoverForStatus(getWindow(), true);
    } else {
      ImmersiveUtils.trySetImmersiveStatusBar(getActivity().getWindow());
    }
    ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
  }
  
  protected void e()
  {
    super.setResult(-1, new Intent());
    f();
    super.finish();
    if (this.jdField_b_of_type_Boolean) {
      try
      {
        ReportCenter.a().a(this.jdField_a_of_type_JavaLangString, "", "", "1", "9", "0", true, true);
      }
      catch (Exception localException1)
      {
        QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setPtloginSdkResult report exception1:", localException1);
      }
    }
    try
    {
      if ((!TextUtils.isEmpty(a().getAccount())) && (!this.jdField_a_of_type_JavaLangString.equals(a().getAccount()))) {
        ReportCenter.a().a(this.jdField_a_of_type_JavaLangString, "", "", "1", "10", "0", true, true);
      }
    }
    catch (Exception localException2)
    {
      QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setPtloginSdkResult report exception2:", localException2);
    }
    new QuickLoginAuthorityActivity.9(this).start();
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setPtloginSdkResult:");
  }
  
  protected void e(String paramString)
  {
    SharedPrefs.a(paramString);
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(paramString, localWloginSimpleInfo);
    paramString = OpenSdkVirtualUtil.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    boolean bool;
    if (this.jdField_a_of_type_JavaUtilList.contains(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "isLogin: true");
      }
      bool = true;
    }
    else
    {
      bool = false;
    }
    paramString = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(this.jdField_a_of_type_JavaLangString, paramString);
    paramString = new String(paramString._nick);
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_a_of_type_JavaLangString, paramString, null);
    if (bool)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("isLogin:");
        paramString.append(bool);
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, paramString.toString());
      }
      c(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected void f()
  {
    if (!super.isFinishing())
    {
      QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
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
    }
  }
  
  protected void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(super.getString(2131694645));
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doAuthorize()");
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = new Bundle();
      localObject2 = (TicketManager)a().getManager(2);
      if ((localObject2 != null) && (TextUtils.isEmpty(((TicketManager)localObject2).getStweb(this.jdField_a_of_type_JavaLangString))))
      {
        ((Bundle)localObject1).putByteArray("connect_data", AuthorityUtil.a(Long.toString(this.jdField_a_of_type_Long)));
        ((Bundle)localObject1).putLong("dwSrcAppid", 1600001540L);
        ((Bundle)localObject1).putLong("dwDstAppid", 1600001540L);
      }
      if ((this.jdField_a_of_type_AndroidOsBundle.containsKey("qrcode")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("schemacallback")))
      {
        if (this.jdField_a_of_type_JavaLangString.equals(a().getAccount()))
        {
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doAuthorize verifyQRCode");
          a();
          return;
        }
        AuthReporter.a("qrcode_ssoGetTicketNoPasswd", 0L);
        a().ssoGetTicketNoPasswd(this.jdField_a_of_type_JavaLangString, 32, this.jdField_a_of_type_MqqObserverSSOAccountObserver, (Bundle)localObject1);
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doAuthorize URL_PARAM_QRCODE");
        return;
      }
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("p"))
      {
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doAuthorize URL_PARAM_PATH");
        a().ssoGetTicketNoPasswd(this.jdField_a_of_type_JavaLangString, 32, this.jdField_a_of_type_MqqObserverSSOAccountObserver, (Bundle)localObject1);
      }
    }
    else
    {
      long l1 = this.jdField_a_of_type_AndroidOsBundle.getLong("dstSsoVer", 0L);
      long l2 = this.jdField_a_of_type_AndroidOsBundle.getLong("subDstAppid", 0L);
      long l3 = this.jdField_a_of_type_AndroidOsBundle.getLong("dstAppid", 0L);
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getByteArray("dstAppVer");
      localObject2 = this.jdField_a_of_type_MqqManagerWtloginManager.getPkgSigFromApkName(this, this.jdField_d_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("mSrcPackageName: ");
        ((StringBuilder)localObject3).append(this.jdField_d_of_type_JavaLangString);
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, ((StringBuilder)localObject3).toString());
        localObject3 = HexUtil.bytes2HexStr((byte[])localObject2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dstAppSign: ");
        localStringBuilder.append((String)localObject3);
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, localStringBuilder.toString());
      }
      Object localObject3 = new Bundle();
      if (!this.jdField_a_of_type_MqqManagerWtloginManager.isUserHaveA1(this.jdField_a_of_type_JavaLangString, 16L))
      {
        ((Bundle)localObject3).putLong("dwSrcAppid", 1600001540L);
        ((Bundle)localObject3).putLong("dwSubSrcAppid", 1600001540L);
      }
      a().ssoGetA1WithA1(this.jdField_a_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString.getBytes(), l1, l3, l2, (byte[])localObject1, (byte[])localObject2, this.jdField_a_of_type_MqqObserverSSOAccountObserver, (Bundle)localObject3);
    }
  }
  
  public void h()
  {
    int i = getResources().getColor(2131167394);
    ColorStateList localColorStateList = getResources().getColorStateList(2131165963);
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      localTextView.setTextColor(i);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    }
    localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setTextColor(localColorStateList);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult: resultcode:");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("requestCode:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("data null?");
      if (paramIntent == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 100)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("uin");
        }
        a();
        return;
      }
      a(null);
      return;
    }
    f();
    if (paramInt2 == 0)
    {
      if (this.jdField_a_of_type_JavaLangString == null)
      {
        a(paramIntent);
        return;
      }
      if (this.jdField_b_of_type_JavaLangString != null)
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onActivityResult cancel , current account is : ");
        paramIntent.append(this.jdField_a_of_type_JavaLangString);
        paramIntent.append(", preAccount is : ");
        paramIntent.append(this.jdField_b_of_type_JavaLangString);
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, paramIntent.toString());
        this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        b(this.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_JavaLangString = null;
      }
    }
    else if ((-1 == paramInt2) && (paramIntent != null))
    {
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("last_account");
      bool = paramIntent.getBooleanExtra("isLogin", false);
      localObject = new WloginSimpleInfo();
      WtloginManager localWtloginManager = this.jdField_a_of_type_MqqManagerWtloginManager;
      if (localWtloginManager != null)
      {
        localWtloginManager.getBasicUserInfo(this.jdField_a_of_type_JavaLangString, (WloginSimpleInfo)localObject);
        paramIntent = new String(((WloginSimpleInfo)localObject)._nick);
      }
      else
      {
        paramIntent = paramIntent.getStringExtra("nick");
      }
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_a_of_type_JavaLangString, paramIntent, null);
      if (bool)
      {
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("isLogin:");
          paramIntent.append(bool);
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, paramIntent.toString());
        }
        c(this.jdField_a_of_type_JavaLangString);
      }
      b();
      paramIntent = Message.obtain();
      paramIntent.what = 1005;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBackPressed mIsPtloginAction=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, localStringBuilder.toString());
    a(null);
    if (this.jdField_a_of_type_Boolean) {
      BaseOpenSdkQIPCClient.a();
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_MqqManagerWtloginManager != null)
    {
      Object localObject;
      if (paramView == this.jdField_c_of_type_AndroidWidgetTextView)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClick cancel mIsPtloginAction=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, ((StringBuilder)localObject).toString());
        a(null);
        if (this.jdField_a_of_type_Boolean) {
          BaseOpenSdkQIPCClient.a();
        }
      }
      else if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
      {
        boolean bool = this.jdField_d_of_type_Boolean;
        String str2 = "1";
        if (bool) {
          localObject = "1";
        } else {
          localObject = "2";
        }
        String str1;
        if (this.jdField_c_of_type_Boolean) {
          str1 = "1";
        } else {
          str1 = "2";
        }
        if ((TextUtils.isEmpty(a().getAccount())) || (this.jdField_a_of_type_JavaLangString.equals(a().getAccount()))) {
          str2 = "2";
        }
        ReportController.b(null, "dc00898", "", "", "0X800A7BE", "0X800A7BE", this.jdField_a_of_type_Int, 0, str2, (String)localObject, str1, "");
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, new Object[] { "report-dc00898-0X800A7BE-fromType=", Integer.valueOf(this.jdField_a_of_type_Int), ",changeaccount=", str2, ", hasGetName=", localObject, ", hasGetIcon=", str1 });
        if (!NetworkUtil.isNetworkAvailable(this))
        {
          f();
          AuthUIUtil.a(this, getResources().getString(2131694647));
        }
        else
        {
          if (this.jdField_a_of_type_Boolean) {
            bool = AuthorityUtil.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString) ^ true;
          } else {
            bool = AuthorityUtil.b(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString);
          }
          QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onClick login have");
          if (bool)
          {
            g();
          }
          else
          {
            c();
            QQToast.a(MobileQQ.sMobileQQ, 2131694651, 0).b(super.getResources().getDimensionPixelSize(2131299168));
          }
          AuthorityUtil.a("0X800BA84");
        }
      }
      else if (paramView.getId() == 2131363053)
      {
        a(this.jdField_a_of_type_JavaLangString);
        localObject = this.jdField_a_of_type_ComTencentOpenAgentCardContainer;
        if (localObject != null) {
          ((CardContainer)localObject).c();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onCreate return for savedInstanceState is not null");
      a(null);
      return;
    }
    if (!a())
    {
      QQToast.a(MobileQQ.sMobileQQ, HardCodeUtil.a(2131711188), 0).a();
      a(null);
      return;
    }
    this.jdField_b_of_type_Boolean = AuthParamUtil.a(getIntent());
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("schemacallback");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("packagename");
    paramBundle = super.getIntent().getStringExtra("key_action");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("p");
    StringBuilder localStringBuilder = new StringBuilder("onCreate()=> mFromSdkLoginAuthority=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("\n schemacallback=");
    localStringBuilder.append(str1);
    localStringBuilder.append("\n packageName=");
    localStringBuilder.append(str2);
    localStringBuilder.append("\n action=");
    localStringBuilder.append(paramBundle);
    localStringBuilder.append("\n urlPraram=");
    localStringBuilder.append(str3);
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, localStringBuilder.toString());
    super.setContentView(2131559665);
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer = ((CardContainer)super.findViewById(2131364351));
    i();
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376809);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131363900);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131372129));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131363055));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView = ((MaxHeightScrollView)findViewById(2131364352));
    this.jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new QuickLoginAuthorityActivity.4(this));
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, 0, 2131561399, 17);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(-1);
    }
    else
    {
      if (isChild()) {
        paramBundle = getParent();
      } else {
        paramBundle = this;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramBundle, super.getTitleBarHeight());
    }
    this.jdField_a_of_type_Int = 1;
    if (!TextUtils.isEmpty(str2)) {
      this.jdField_a_of_type_Int = 3;
    } else if ((!TextUtils.isEmpty(str1)) && (str1.contains("weixin://"))) {
      this.jdField_a_of_type_Int = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A7BC", "0X800A7BC", this.jdField_a_of_type_Int, 0, "", "", "", "");
    paramBundle = new StringBuilder();
    paramBundle.append("report-dc00898-0X800A7BC-fromType=");
    paramBundle.append(this.jdField_a_of_type_Int);
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, paramBundle.toString());
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setChangeAccountListener(new QuickLoginAuthorityActivity.5(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_JavaUtilList = SharedPrefs.a();
    if (a().isLogin()) {
      this.jdField_a_of_type_JavaLangString = a().getAccount();
    }
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      paramBundle = this.jdField_a_of_type_JavaUtilList;
      if (paramBundle != null) {
        this.jdField_a_of_type_JavaLangString = ((String)paramBundle.get(0));
      }
    }
    this.e = getIntent().getStringExtra("login_success_uin");
    if ((!TextUtils.isEmpty(this.e)) && (!this.e.equals(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaLangString = this.e;
    }
    AuthorityUtil.a("0X800BA83");
    if (QQLiteStatusUtil.a(this))
    {
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->onCreate--has gesture password, will start unlock activity");
      this.jdField_c_of_type_JavaLangString = super.getAppRuntime().getAccount();
      AuthorityUtil.a(this);
      return;
    }
    a();
    if ((!TextUtils.isEmpty(str1)) && (str1.contains("weixin://")))
    {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.b();
      ThreadManager.getSubThreadHandler().post(new QuickLoginAuthorityActivity.6(this));
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "ondestroy");
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity
 * JD-Core Version:    0.7.0.1
 */