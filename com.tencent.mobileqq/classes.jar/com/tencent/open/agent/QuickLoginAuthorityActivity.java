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
  protected static final String[] a = { "http://ptlogin2.qq.com", "http://ptlogin2.soso.com", "http://ptlogin2.paipai.com", "http://ptlogin2.tenpay.com", "http://ptlogin2.taotao.com", "http://ptlogin2.tencent.com", "http://ptlogin2.oa.com", "http://ptlogin2.webdev.com", "http://ptlogin2.3366.com", "http://ptlogin2.imqq.com", "http://ptlogin2.pengyou.com", "http://ptlogin2.qplus.com", "http://ptlogin2.qzone.com", "http://ptlogin2.id.qq.com", "http://ptlogin2.myapp.com", "http://ptlogin2.kuyoo.cn", "http://ptlogin2.function.qq.com", "http://ptlogin2.crm2.qq.com", "http://ptlogin2.weiyun.com", "http://ptlogin2.wechatapp.com", "http://ptlogin2.51buy.com", "http://ptlogin2.qcloud.com", "http://ptlogin2.wechat.com", "http://ptlogin2.qmail.com", "http://ptlogin2.ejinshang.com", "http://ptlogin2.lvren.com", "http://ptlogin2.weishi.com", "https://ssl.ptlogin2.qq.com", "https://ssl.ptlogin2.tenpay.com", "https://ssl.ptlogin2.paipai.com", "https://ssl.ptlogin2.soso.com", "https://ssl.ptlogin2.3366.com", "https://ssl.ptlogin2.pengyou.com", "https://ssl.ptlogin2.imqq.com", "https://ssl.ptlogin2.qzone.com", "https://ssl.ptlogin2.qcloud.com", "https://ssl.ptlogin2.51buy.com", "https://ssl.ptlogin2.weiyun.com", "https://ssl.ptlogin2.myapp.com", "https://ssl.ptlogin2.yixun.com", "https://ssl.ptlogin2.wanggou.com", "https://ssl.ptlogin2.ejinshang.com" };
  private MaxHeightScrollView A;
  private int B;
  private long C;
  private boolean D = false;
  private boolean E = false;
  private byte[] F;
  private WtloginObserver G = new QuickLoginAuthorityActivity.2(this);
  private WtloginObserver H = new QuickLoginAuthorityActivity.3(this);
  protected String b = null;
  protected String c = null;
  protected View d;
  protected View e;
  protected Button f;
  protected RelativeLayout g;
  protected Bundle h;
  protected QQProgressDialog i;
  protected SharedPreferences j;
  protected WtloginManager k = null;
  protected List<String> l;
  protected String m = null;
  protected String n;
  protected byte[] o = null;
  protected boolean p = false;
  protected CardContainer q;
  protected SSOAccountObserver r = new QuickLoginAuthorityActivity.1(this);
  protected Handler s = new QuickLoginAuthorityActivity.7(this, ThreadManager.getSubThreadLooper());
  protected Handler t = new QuickLoginAuthorityActivity.8(this, Looper.getMainLooper());
  private boolean u;
  private ImmersiveTitleBar2 v;
  private TextView w;
  private TextView x;
  private TextView y;
  private String z;
  
  private Intent b(Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("moveTaskToBack", true);
    return localIntent;
  }
  
  private Bundle f(String paramString)
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
      int i1 = 0;
      while (i1 < paramString.length)
      {
        Object localObject = paramString[i1];
        int i2 = localObject.indexOf('=');
        if (i2 > 0) {
          localBundle.putString(localObject.substring(0, i2), localObject.substring(i2 + 1, localObject.length()));
        }
        i1 += 1;
      }
      return localBundle;
    }
    catch (MalformedURLException paramString) {}
    return localBundle;
  }
  
  private AbstractOpenSdkAppInterface j()
  {
    AbstractOpenSdkAppInterface localAbstractOpenSdkAppInterface = (AbstractOpenSdkAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("waitAppRuntime app=");
    localStringBuilder.append(localAbstractOpenSdkAppInterface.hashCode());
    QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, localStringBuilder.toString());
    return localAbstractOpenSdkAppInterface;
  }
  
  private void k()
  {
    this.v = ((ImmersiveTitleBar2)this.q.findViewById(2131447582));
    this.w = ((TextView)this.q.findViewById(2131436180));
    this.x = ((TextView)this.q.findViewById(2131436227));
    this.y = ((TextView)this.q.findViewById(2131436211));
    this.w.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.x.setText(2131892313);
    this.y.setText(2131887648);
    this.v.resetBkColor(0);
  }
  
  private int l()
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->verifyQRCode()");
    String str = this.h.getString("qrcode");
    int i1 = str.indexOf("?k=") + 3;
    str = str.substring(i1, i1 + 32);
    this.F = QRLoginAuthUtil.a(str.getBytes(), str.length());
    return this.k.verifyCode(this.b, 16L, true, this.F, null, 1, this.H);
  }
  
  private int m()
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->getAppidByWtlogin()");
    Object localObject = this.h.getString("qrcode");
    int i1 = ((String)localObject).indexOf("?k=") + 3;
    localObject = ((String)localObject).substring(i1, i1 + 32);
    this.F = QRLoginAuthUtil.a(((String)localObject).getBytes(), ((String)localObject).length());
    localObject = this.k;
    String str = this.b;
    byte[] arrayOfByte = this.F;
    WtloginObserver localWtloginObserver = this.G;
    return ((WtloginManager)localObject).verifyCode(str, 16L, true, arrayOfByte, new int[] { 3, 5, 32, 54 }, 1, localWtloginObserver);
  }
  
  protected void a(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("quicklogin_errmsg", paramString2);
    localIntent.putExtra("quicklogin_uin", paramString1);
    localIntent.putExtra("quicklogin_ret", paramInt);
    localIntent.putExtra("quicklogin_buff", paramArrayOfByte);
    super.setResult(-1, localIntent);
    g();
    super.finish();
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("setSdkResult:error:");
    paramArrayOfByte.append(paramString2);
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, paramArrayOfByte.toString());
    if (this.u) {
      try
      {
        paramString1 = ReportCenter.a();
        paramString2 = this.b;
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
        if ((!TextUtils.isEmpty(j().getAccount())) && (!this.b.equals(j().getAccount())))
        {
          paramString1 = ReportCenter.a();
          paramString2 = this.b;
          if (paramInt != 0) {
            break label256;
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
      label256:
      paramArrayOfByte = "1";
    }
  }
  
  protected void a(long paramLong, String paramString)
  {
    this.C = paramLong;
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
    ((GetAppInfoProto.GetAppinfoRequest)localObject).qqv.set(CommonDataAdapter.a().j());
    ((GetAppInfoProto.GetAppinfoRequest)localObject).setHasFlag(true);
    paramString = AuthParamUtil.a(this);
    if (!TextUtils.isEmpty(paramString)) {
      ((GetAppInfoProto.GetAppinfoRequest)localObject).appUniqueIdentifier.set(paramString);
    }
    ((GetAppInfoProto.GetAppinfoRequest)localObject).referer.set(1);
    paramString = new NewIntent(MobileQQ.sMobileQQ, OpensdkServlet.class);
    paramString.setWithouLogin(true);
    paramString.putExtra("uin", this.b);
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
    ((StringBuilder)localObject).append(this.p);
    ((StringBuilder)localObject).append(", mThirdAppId=");
    ((StringBuilder)localObject).append(this.C);
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, ((StringBuilder)localObject).toString());
    localObject = new Intent();
    if (paramString != null) {
      ((Intent)localObject).putExtra("param_uin", paramString);
    }
    if (this.p)
    {
      ((Intent)localObject).putExtra("key_req_src", 3);
      ((Intent)localObject).putExtra("appid", Long.toString(this.C));
    }
    else
    {
      ((Intent)localObject).putExtra("key_req_src", 2);
      paramString = this.h;
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
    if (paramString.equals(this.b)) {
      runOnUiThread(new QuickLoginAuthorityActivity.10(this, paramBitmap));
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (AuthorityUtil.b(this.k, paramString))
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
        localStringBuilder.append(this.b);
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, localStringBuilder.toString());
        this.c = this.b;
        d(paramString);
        return;
      }
      e(paramString);
      this.c = null;
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
    this.h = super.getIntent().getBundleExtra("key_params");
    if (this.h == null)
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
    this.p = "action_ptlogin_login".equals(localObject1);
    if (this.p)
    {
      if ((this.h.containsKey("qrcode")) && (this.h.containsKey("schemacallback"))) {
        return true;
      }
      if (this.h.containsKey("p"))
      {
        localObject2 = this.h.getString("p");
        if (QQLiteStatusUtil.b()) {
          localObject1 = "/";
        } else {
          localObject1 = "";
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          String[] arrayOfString = a;
          int i2 = arrayOfString.length;
          int i1 = 0;
          while (i1 < i2)
          {
            String str = arrayOfString[i1];
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str);
            localStringBuilder.append((String)localObject1);
            if (((String)localObject2).startsWith(localStringBuilder.toString())) {
              return true;
            }
            i1 += 1;
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
      this.o = this.h.getByteArray("publickey");
      this.n = this.h.getString("packagename");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("mSrcPackageName: ");
        ((StringBuilder)localObject1).append(this.n);
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, ((StringBuilder)localObject1).toString());
      }
      if ((this.o != null) && (!TextUtils.isEmpty(this.n)) && (this.h.containsKey("dstSsoVer")) && (this.h.containsKey("subDstAppid")) && (this.h.containsKey("dstAppid")) && (this.h.containsKey("dstAppVer"))) {
        return true;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkIntentValidity() invalid parameters! ");
      ((StringBuilder)localObject1).append(this.h.toString());
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    for (;;)
    {
      int i1;
      try
      {
        boolean bool = TextUtils.isEmpty(paramString1);
        if ((!bool) && (!TextUtils.isEmpty(paramString2)))
        {
          byte[] arrayOfByte = getPackageManager().getPackageInfo(paramString1, 64).signatures[0].toByteArray();
          arrayOfByte = MessageDigest.getInstance("SHA1").digest(arrayOfByte);
          StringBuilder localStringBuilder = new StringBuilder();
          i1 = 0;
          if (i1 < arrayOfByte.length)
          {
            String str = Integer.toHexString(arrayOfByte[i1] & 0xFF).toUpperCase(Locale.US);
            if (str.length() == 1) {
              localStringBuilder.append("0");
            }
            localStringBuilder.append(str);
            if (i1 != arrayOfByte.length - 1) {
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
      i1 += 1;
    }
  }
  
  protected void b()
  {
    int i1;
    if (Build.VERSION.SDK_INT > 10) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    this.j = super.getSharedPreferences("accountList", i1);
    this.k = ((WtloginManager)j().getManager(1));
    e();
  }
  
  protected void b(String paramString)
  {
    Object localObject2;
    String str;
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("0")))
    {
      localObject1 = new WloginSimpleInfo();
      this.k.getBasicUserInfo(paramString, (WloginSimpleInfo)localObject1);
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
      this.q.a(paramString, (String)localObject1, (Bitmap)localObject2);
      if (localObject2 != null)
      {
        localObject1 = Message.obtain();
        ((Message)localObject1).what = 1000;
        ((Message)localObject1).obj = localObject2;
        this.s.sendMessage((Message)localObject1);
      }
      if (this.p)
      {
        localObject1 = getResources().getString(2131892299);
        this.q.a((String)localObject1, null);
        this.q.setAppType("web");
      }
      localObject2 = this.h.getString("packagename");
      boolean bool = this.p;
      str = "";
      if (bool)
      {
        localObject3 = f(this.h.getString("p"));
        localObject2 = this.h.getString("appname");
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
          this.E = true;
          this.q.a((String)localObject2, null);
        }
        localObject1 = this.h.getString("package");
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
                this.E = true;
                this.q.a("QQ空间", null);
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
            paramString = URLDecoder.decode(this.h.getString("p"));
            long l1 = Long.valueOf(f(paramString).getString("client_id", "-1")).longValue();
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("login have urlDecode =");
              ((StringBuilder)localObject1).append(paramString);
              ((StringBuilder)localObject1).append(",clientId =");
              ((StringBuilder)localObject1).append(l1);
              QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, ((StringBuilder)localObject1).toString());
            }
            a(l1, "web");
            paramString = Message.obtain();
            paramString.what = 1004;
            paramString.obj = "web";
            this.t.sendMessage(paramString);
          }
          catch (Exception paramString)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("zhihu deal error  =");
            ((StringBuilder)localObject1).append(paramString.getMessage());
            QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, ((StringBuilder)localObject1).toString());
          }
        }
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, new Object[] { "showLocalInfo() => return for package is empty mIsPtloginAction=", Boolean.valueOf(this.p), ", daid=", localObject2 });
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
      bool = this.p;
      paramString = new StringBuilder();
      paramString.append(((WFastLoginInfo)localObject2).iconUrl);
      paramString.append(", adUrl=");
      QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, new Object[] { "showLocalInfo() => mIsPtloginAction=", Boolean.valueOf(bool), ", [loginInfo.iconUrl=", paramString.toString(), ((WFastLoginInfo)localObject2).adUrl });
      if (!TextUtils.isEmpty(((WFastLoginInfo)localObject2).iconUrl))
      {
        this.D = true;
        paramString = Message.obtain();
        paramString.what = 1001;
        paramString.obj = ((WFastLoginInfo)localObject2).iconUrl;
        this.s.sendMessage(paramString);
      }
      if (this.p) {}
    }
    try
    {
      paramString = super.getPackageManager();
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      label905:
      break label905;
    }
    try
    {
      localObject1 = paramString.getApplicationInfo((String)localObject1, 0);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label907;
    }
    paramString = null;
    label907:
    Object localObject1 = null;
    if (localObject1 != null) {
      str = (String)paramString.getApplicationLabel((ApplicationInfo)localObject1);
    }
    if (!TextUtils.isEmpty(str))
    {
      this.E = true;
      this.q.a(str, null);
    }
    if (!TextUtils.isEmpty(((WFastLoginInfo)localObject2).adUrl))
    {
      paramString = new StringBuffer(((WFastLoginInfo)localObject2).adUrl);
      this.q.a(null, paramString.replace(0, 4, "gamead").toString());
    }
    return;
    QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "showLocalInfo() return for uin invalid");
  }
  
  protected void c()
  {
    if (TextUtils.isEmpty(this.b))
    {
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "updateViews() return for empry account");
      return;
    }
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "updateViews()");
    String str = ((TicketManager)j().getManager(2)).getSkey(this.b);
    AvatarUpdateService.a().a(this, this.b, str, this);
  }
  
  protected void c(String paramString)
  {
    Object localObject3 = new ArrayList();
    Object localObject4 = this.j;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (((SharedPreferences)localObject4).getString("accList", null) != null)
    {
      localObject4 = this.j.getString("accList", null);
      localObject1 = localObject2;
      if (localObject4 != null) {
        localObject1 = ((String)localObject4).split(",");
      }
    }
    if (localObject1 != null)
    {
      int i2 = localObject1.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localObject2 = localObject1[i1];
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((ArrayList)localObject3).add(localObject2);
        }
        i1 += 1;
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
    localObject2 = this.j.edit();
    ((SharedPreferences.Editor)localObject2).putString("last_account", paramString);
    ((SharedPreferences.Editor)localObject2).putString("accList", (String)localObject1);
    ((SharedPreferences.Editor)localObject2).commit();
  }
  
  protected void d()
  {
    Object localObject = this.l;
    int i1;
    if (localObject != null) {
      i1 = ((List)localObject).size();
    } else {
      i1 = 0;
    }
    if (i1 > 1)
    {
      localObject = new Intent();
      String str = this.b;
      if (str != null) {
        ((Intent)localObject).putExtra("param_uin", str);
      }
      if (this.p) {
        i1 = 3;
      } else {
        i1 = 2;
      }
      ((Intent)localObject).putExtra("key_req_src", i1);
      RouteUtils.a(this, (Intent)localObject, "/base/switchAccount", 1);
      return;
    }
    a(this.b);
  }
  
  protected void d(String paramString)
  {
    SharedPrefs.b(paramString);
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.k.getBasicUserInfo(paramString, localWloginSimpleInfo);
    paramString = OpenSdkVirtualUtil.a(this.k, paramString);
    this.b = paramString;
    boolean bool;
    if (this.l.contains(paramString))
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
    this.k.getBasicUserInfo(this.b, paramString);
    paramString = new String(paramString._nick);
    this.q.a(this.b, paramString, null);
    if (bool)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("isLogin:");
        paramString.append(bool);
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, paramString.toString());
      }
      c(this.b);
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
    if (j() == null)
    {
      d();
      return;
    }
    if (!TextUtils.isEmpty(this.m))
    {
      this.b = this.m;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("login mAccountString :");
        localStringBuilder.append(this.m);
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, localStringBuilder.toString());
      }
    }
    b(this.b);
    if (!TextUtils.isEmpty(this.b))
    {
      boolean bool;
      if (this.p) {
        bool = AuthorityUtil.a(this.k, this.b) ^ true;
      } else {
        bool = AuthorityUtil.b(this.k, this.b);
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "login have");
        }
        c();
        return;
      }
      d();
      QQToast.makeText(MobileQQ.sMobileQQ, 2131892337, 0).show(getResources().getDimensionPixelSize(2131299920));
      return;
    }
    d();
  }
  
  protected void e(String paramString)
  {
    SharedPrefs.b(paramString);
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.k.getBasicUserInfo(paramString, localWloginSimpleInfo);
    paramString = OpenSdkVirtualUtil.a(this.k, paramString);
    this.b = paramString;
    boolean bool;
    if (this.l.contains(paramString))
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
    this.k.getBasicUserInfo(this.b, paramString);
    paramString = new String(paramString._nick);
    this.q.a(this.b, paramString, null);
    if (bool)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("isLogin:");
        paramString.append(bool);
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, paramString.toString());
      }
      c(this.b);
    }
  }
  
  protected void f()
  {
    super.setResult(-1, new Intent());
    g();
    super.finish();
    if (this.u) {
      try
      {
        ReportCenter.a().a(this.b, "", "", "1", "9", "0", true, true);
      }
      catch (Exception localException1)
      {
        QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setPtloginSdkResult report exception1:", localException1);
      }
    }
    try
    {
      if ((!TextUtils.isEmpty(j().getAccount())) && (!this.b.equals(j().getAccount()))) {
        ReportCenter.a().a(this.b, "", "", "1", "10", "0", true, true);
      }
    }
    catch (Exception localException2)
    {
      QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setPtloginSdkResult report exception2:", localException2);
    }
    new QuickLoginAuthorityActivity.9(this).start();
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setPtloginSdkResult:");
  }
  
  protected void g()
  {
    if (!super.isFinishing())
    {
      QQProgressDialog localQQProgressDialog = this.i;
      if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
        try
        {
          this.i.dismiss();
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  protected void h()
  {
    this.i.a(super.getString(2131892331));
    if (!this.i.isShowing()) {
      this.i.show();
    }
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doAuthorize()");
    Object localObject1;
    Object localObject2;
    if (this.p)
    {
      localObject1 = new Bundle();
      localObject2 = (TicketManager)j().getManager(2);
      if ((localObject2 != null) && (TextUtils.isEmpty(((TicketManager)localObject2).getStweb(this.b))))
      {
        ((Bundle)localObject1).putByteArray("connect_data", AuthorityUtil.b(Long.toString(this.C)));
        ((Bundle)localObject1).putLong("dwSrcAppid", 1600001540L);
        ((Bundle)localObject1).putLong("dwDstAppid", 1600001540L);
      }
      if ((this.h.containsKey("qrcode")) && (this.h.containsKey("schemacallback")))
      {
        if (this.b.equals(j().getAccount()))
        {
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doAuthorize verifyQRCode");
          l();
          return;
        }
        AuthReporter.a("qrcode_ssoGetTicketNoPasswd", 0L);
        j().ssoGetTicketNoPasswd(this.b, 32, this.r, (Bundle)localObject1);
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doAuthorize URL_PARAM_QRCODE");
        return;
      }
      if (this.h.containsKey("p"))
      {
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doAuthorize URL_PARAM_PATH");
        j().ssoGetTicketNoPasswd(this.b, 32, this.r, (Bundle)localObject1);
      }
    }
    else
    {
      long l1 = this.h.getLong("dstSsoVer", 0L);
      long l2 = this.h.getLong("subDstAppid", 0L);
      long l3 = this.h.getLong("dstAppid", 0L);
      localObject1 = this.h.getByteArray("dstAppVer");
      localObject2 = this.k.getPkgSigFromApkName(this, this.n);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("mSrcPackageName: ");
        ((StringBuilder)localObject3).append(this.n);
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, ((StringBuilder)localObject3).toString());
        localObject3 = HexUtil.bytes2HexStr((byte[])localObject2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dstAppSign: ");
        localStringBuilder.append((String)localObject3);
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, localStringBuilder.toString());
      }
      Object localObject3 = new Bundle();
      if (!this.k.isUserHaveA1(this.b, 16L))
      {
        ((Bundle)localObject3).putLong("dwSrcAppid", 1600001540L);
        ((Bundle)localObject3).putLong("dwSubSrcAppid", 1600001540L);
      }
      j().ssoGetA1WithA1(this.b, this.n.getBytes(), l1, l3, l2, (byte[])localObject1, (byte[])localObject2, this.r, (Bundle)localObject3);
    }
  }
  
  public void i()
  {
    int i1 = getResources().getColor(2131168464);
    ColorStateList localColorStateList = getResources().getColorStateList(2131166684);
    TextView localTextView = this.x;
    if (localTextView != null)
    {
      localTextView.setTextColor(i1);
      this.x.setText("");
    }
    localTextView = this.y;
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
          this.m = paramIntent.getStringExtra("uin");
        }
        b();
        return;
      }
      a(null);
      return;
    }
    g();
    if (paramInt2 == 0)
    {
      if (this.b == null)
      {
        a(paramIntent);
        return;
      }
      if (this.c != null)
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onActivityResult cancel , current account is : ");
        paramIntent.append(this.b);
        paramIntent.append(", preAccount is : ");
        paramIntent.append(this.c);
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, paramIntent.toString());
        this.b = this.c;
        b(this.b);
        this.c = null;
      }
    }
    else if ((-1 == paramInt2) && (paramIntent != null))
    {
      this.b = paramIntent.getStringExtra("last_account");
      bool = paramIntent.getBooleanExtra("isLogin", false);
      localObject = new WloginSimpleInfo();
      WtloginManager localWtloginManager = this.k;
      if (localWtloginManager != null)
      {
        localWtloginManager.getBasicUserInfo(this.b, (WloginSimpleInfo)localObject);
        paramIntent = new String(((WloginSimpleInfo)localObject)._nick);
      }
      else
      {
        paramIntent = paramIntent.getStringExtra("nick");
      }
      this.q.a(this.b, paramIntent, null);
      if (bool)
      {
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("isLogin:");
          paramIntent.append(bool);
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, paramIntent.toString());
        }
        c(this.b);
      }
      c();
      paramIntent = Message.obtain();
      paramIntent.what = 1005;
      this.s.sendMessage(paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBackPressed mIsPtloginAction=");
    localStringBuilder.append(this.p);
    QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, localStringBuilder.toString());
    a(null);
    if (this.p) {
      BaseOpenSdkQIPCClient.a();
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.k != null)
    {
      Object localObject;
      if (paramView == this.y)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClick cancel mIsPtloginAction=");
        ((StringBuilder)localObject).append(this.p);
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, ((StringBuilder)localObject).toString());
        a(null);
        if (this.p) {
          BaseOpenSdkQIPCClient.a();
        }
      }
      else if (paramView == this.f)
      {
        boolean bool = this.E;
        String str2 = "1";
        if (bool) {
          localObject = "1";
        } else {
          localObject = "2";
        }
        String str1;
        if (this.D) {
          str1 = "1";
        } else {
          str1 = "2";
        }
        if ((TextUtils.isEmpty(j().getAccount())) || (this.b.equals(j().getAccount()))) {
          str2 = "2";
        }
        ReportController.b(null, "dc00898", "", "", "0X800A7BE", "0X800A7BE", this.B, 0, str2, (String)localObject, str1, "");
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, new Object[] { "report-dc00898-0X800A7BE-fromType=", Integer.valueOf(this.B), ",changeaccount=", str2, ", hasGetName=", localObject, ", hasGetIcon=", str1 });
        if (!NetworkUtil.isNetworkAvailable(this))
        {
          g();
          AuthUIUtil.a(this, getResources().getString(2131892333));
        }
        else
        {
          if (this.p) {
            bool = AuthorityUtil.a(this.k, this.b) ^ true;
          } else {
            bool = AuthorityUtil.b(this.k, this.b);
          }
          QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onClick login have");
          if (bool)
          {
            h();
          }
          else
          {
            d();
            QQToast.makeText(MobileQQ.sMobileQQ, 2131892337, 0).show(super.getResources().getDimensionPixelSize(2131299920));
          }
          AuthorityUtil.e("0X800BA84");
        }
      }
      else if (paramView.getId() == 2131428886)
      {
        a(this.b);
        localObject = this.q;
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
      QQToast.makeText(MobileQQ.sMobileQQ, HardCodeUtil.a(2131908846), 0).show();
      a(null);
      return;
    }
    this.u = AuthParamUtil.a(getIntent());
    String str1 = this.h.getString("schemacallback");
    String str2 = this.h.getString("packagename");
    paramBundle = super.getIntent().getStringExtra("key_action");
    String str3 = this.h.getString("p");
    StringBuilder localStringBuilder = new StringBuilder("onCreate()=> mFromSdkLoginAuthority=");
    localStringBuilder.append(this.u);
    localStringBuilder.append("\n schemacallback=");
    localStringBuilder.append(str1);
    localStringBuilder.append("\n packageName=");
    localStringBuilder.append(str2);
    localStringBuilder.append("\n action=");
    localStringBuilder.append(paramBundle);
    localStringBuilder.append("\n urlPraram=");
    localStringBuilder.append(str3);
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, localStringBuilder.toString());
    super.setContentView(2131625695);
    this.q = ((CardContainer)super.findViewById(2131430379));
    k();
    this.d = findViewById(2131445137);
    this.e = findViewById(2131429850);
    this.f = ((Button)super.findViewById(2131439600));
    this.f.setOnClickListener(this);
    this.g = ((RelativeLayout)super.findViewById(2131428888));
    this.g.setVisibility(8);
    this.A = ((MaxHeightScrollView)findViewById(2131430380));
    this.A.getViewTreeObserver().addOnGlobalLayoutListener(new QuickLoginAuthorityActivity.4(this));
    if (this.u)
    {
      this.i = new QQProgressDialog(this, 0, 2131627755, 17);
      this.i.a(-1);
    }
    else
    {
      if (isChild()) {
        paramBundle = getParent();
      } else {
        paramBundle = this;
      }
      this.i = new QQProgressDialog(paramBundle, super.getTitleBarHeight());
    }
    this.B = 1;
    if (!TextUtils.isEmpty(str2)) {
      this.B = 3;
    } else if ((!TextUtils.isEmpty(str1)) && (str1.contains("weixin://"))) {
      this.B = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A7BC", "0X800A7BC", this.B, 0, "", "", "", "");
    paramBundle = new StringBuilder();
    paramBundle.append("report-dc00898-0X800A7BC-fromType=");
    paramBundle.append(this.B);
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, paramBundle.toString());
    this.q.setChangeAccountListener(new QuickLoginAuthorityActivity.5(this));
    this.i.setCanceledOnTouchOutside(false);
    this.l = SharedPrefs.b();
    if (j().isLogin()) {
      this.b = j().getAccount();
    }
    if (this.b == null)
    {
      paramBundle = this.l;
      if (paramBundle != null) {
        this.b = ((String)paramBundle.get(0));
      }
    }
    this.z = getIntent().getStringExtra("login_success_uin");
    if ((!TextUtils.isEmpty(this.z)) && (!this.z.equals(this.b))) {
      this.b = this.z;
    }
    AuthorityUtil.e("0X800BA83");
    if (QQLiteStatusUtil.a(this))
    {
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->onCreate--has gesture password, will start unlock activity");
      this.m = super.getAppRuntime().getAccount();
      AuthorityUtil.a(this);
      return;
    }
    b();
    if ((!TextUtils.isEmpty(str1)) && (str1.contains("weixin://")))
    {
      this.q.b();
      ThreadManager.getSubThreadHandler().post(new QuickLoginAuthorityActivity.6(this));
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "ondestroy");
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity
 * JD-Core Version:    0.7.0.1
 */