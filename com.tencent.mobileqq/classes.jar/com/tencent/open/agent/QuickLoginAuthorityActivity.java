package com.tencent.open.agent;

import Override;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvx;
import auuv;
import bdla;
import bisl;
import bizq;
import bizw;
import bjfl;
import bjfm;
import bjfn;
import bjfo;
import bjfp;
import bjfq;
import bjfr;
import bjfs;
import bjgx;
import bjhh;
import bjhv;
import bjkx;
import bjlj;
import bjmq;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.widget.MaxHeightScrollView;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.MalformedURLException;
import java.net.URL;
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
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class QuickLoginAuthorityActivity
  extends BaseActivity
  implements View.OnClickListener, bjlj
{
  protected static final String[] a;
  protected float a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  protected SharedPreferences a;
  public Bundle a;
  public Handler a;
  protected View a;
  protected Button a;
  protected RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bisl a;
  public CardContainer a;
  private MaxHeightScrollView jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public String a;
  protected List<String> a;
  public WtloginManager a;
  protected SSOAccountObserver a;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new bjfn(this);
  protected boolean a;
  public byte[] a;
  public Handler b;
  protected View b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  private WtloginObserver jdField_b_of_type_MqqObserverWtloginObserver = new bjfo(this);
  private boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  protected String c;
  private boolean jdField_c_of_type_Boolean;
  protected String d;
  private boolean d;
  private String e;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "http://ptlogin2.qq.com", "http://ptlogin2.soso.com", "http://ptlogin2.paipai.com", "http://ptlogin2.tenpay.com", "http://ptlogin2.taotao.com", "http://ptlogin2.tencent.com", "http://ptlogin2.oa.com", "http://ptlogin2.webdev.com", "http://ptlogin2.3366.com", "http://ptlogin2.imqq.com", "http://ptlogin2.pengyou.com", "http://ptlogin2.qplus.com", "http://ptlogin2.qzone.com", "http://ptlogin2.id.qq.com", "http://ptlogin2.myapp.com", "http://ptlogin2.kuyoo.cn", "http://ptlogin2.function.qq.com", "http://ptlogin2.crm2.qq.com", "http://ptlogin2.weiyun.com", "http://ptlogin2.wechatapp.com", "http://ptlogin2.51buy.com", "http://ptlogin2.qcloud.com", "http://ptlogin2.wechat.com", "http://ptlogin2.qmail.com", "http://ptlogin2.ejinshang.com", "http://ptlogin2.lvren.com", "http://ptlogin2.weishi.com", "https://ssl.ptlogin2.qq.com", "https://ssl.ptlogin2.tenpay.com", "https://ssl.ptlogin2.paipai.com", "https://ssl.ptlogin2.soso.com", "https://ssl.ptlogin2.3366.com", "https://ssl.ptlogin2.pengyou.com", "https://ssl.ptlogin2.imqq.com", "https://ssl.ptlogin2.qzone.com", "https://ssl.ptlogin2.qcloud.com", "https://ssl.ptlogin2.51buy.com", "https://ssl.ptlogin2.weiyun.com", "https://ssl.ptlogin2.myapp.com", "https://ssl.ptlogin2.yixun.com", "https://ssl.ptlogin2.wanggou.com", "https://ssl.ptlogin2.ejinshang.com" };
  }
  
  public QuickLoginAuthorityActivity()
  {
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new bjfl(this);
    this.jdField_a_of_type_AndroidOsHandler = new bjfr(this, ThreadManager.getSubThreadLooper());
    this.jdField_b_of_type_AndroidOsHandler = new bjfs(this, Looper.getMainLooper());
  }
  
  private int a()
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->verifyQRCode()");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("qrcode");
    int i = str.indexOf("?k=") + 3;
    str = str.substring(i, i + 32);
    this.jdField_b_of_type_ArrayOfByte = QRLoginAuthActivity.a(str.getBytes(), str.length());
    return this.jdField_a_of_type_MqqManagerWtloginManager.verifyCode(this.jdField_a_of_type_JavaLangString, 16L, true, this.jdField_b_of_type_ArrayOfByte, null, 1, this.jdField_b_of_type_MqqObserverWtloginObserver);
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
  
  private OpenSDKAppInterface a()
  {
    OpenSDKAppInterface localOpenSDKAppInterface = (OpenSDKAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "waitAppRuntime app=" + localOpenSDKAppInterface.hashCode());
    return localOpenSDKAppInterface;
  }
  
  private int b()
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->getAppidByWtlogin()");
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("qrcode");
    int i = ((String)localObject).indexOf("?k=") + 3;
    localObject = ((String)localObject).substring(i, i + 32);
    this.jdField_b_of_type_ArrayOfByte = QRLoginAuthActivity.a(((String)localObject).getBytes(), ((String)localObject).length());
    localObject = this.jdField_a_of_type_MqqManagerWtloginManager;
    String str = this.jdField_a_of_type_JavaLangString;
    byte[] arrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    WtloginObserver localWtloginObserver = this.jdField_a_of_type_MqqObserverWtloginObserver;
    return ((WtloginManager)localObject).verifyCode(str, 16L, true, arrayOfByte, new int[] { 3, 5, 32, 54 }, 1, localWtloginObserver);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131379099));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131369231));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131369278));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131369262));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694444);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690697);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.a(0);
  }
  
  protected void a()
  {
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences = super.getSharedPreferences("accountList", i);
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)a().getManager(1));
      d();
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
    f();
    super.finish();
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setSdkResult:error:" + paramString2);
    if (this.jdField_b_of_type_Boolean) {}
    try
    {
      paramString1 = bjgx.a();
      paramString2 = this.jdField_a_of_type_JavaLangString;
      if (paramInt != 0) {
        break label208;
      }
      paramArrayOfByte = "0";
    }
    catch (Exception paramArrayOfByte)
    {
      try
      {
        if ((TextUtils.isEmpty(a().getAccount())) || (this.jdField_a_of_type_JavaLangString.equals(a().getAccount()))) {
          break label207;
        }
        paramString1 = bjgx.a();
        paramString2 = this.jdField_a_of_type_JavaLangString;
        if (paramInt != 0) {
          break label229;
        }
        for (paramArrayOfByte = "0";; paramArrayOfByte = "1")
        {
          paramString1.a(paramString2, "", "", "1", "10", paramArrayOfByte, true, true);
          return;
          paramArrayOfByte = "1";
          break;
          paramArrayOfByte = paramArrayOfByte;
          QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setSdkResult report exception1:", paramArrayOfByte);
          break label138;
        }
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setSdkResult report exception2:", paramArrayOfByte);
      }
    }
    paramString1.a(paramString2, "", "", "1", "9", paramArrayOfByte, true, true);
  }
  
  public void a(long paramLong, String paramString)
  {
    this.jdField_a_of_type_Long = paramLong;
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "getAppInfo appid =" + paramLong + ",comfrom =" + paramString);
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong);
    localGetAppinfoRequest.sdkp.set(paramString);
    if (Build.VERSION.RELEASE == null) {}
    for (paramString = "";; paramString = Build.VERSION.RELEASE)
    {
      localGetAppinfoRequest.os.set(paramString);
      localGetAppinfoRequest.qqv.set(bizw.a().d());
      localGetAppinfoRequest.setHasFlag(true);
      paramString = bjhh.a(this);
      if (!TextUtils.isEmpty(paramString)) {
        localGetAppinfoRequest.appUniqueIdentifier.set(paramString);
      }
      localGetAppinfoRequest.referer.set(1);
      paramString = new NewIntent(BaseApplicationImpl.getContext(), bjhv.class);
      paramString.setWithouLogin(true);
      paramString.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      paramString.putExtra("data", localGetAppinfoRequest.toByteArray());
      paramString.putExtra("cmd", "ConnAuthSvr.get_app_info");
      paramString.setObserver(new bjfm(this));
      super.getAppRuntime().startServlet(paramString);
      return;
    }
  }
  
  public void a(Intent paramIntent)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setResultCancel data=" + paramIntent);
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
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->showLoginActivity--uin = *" + bjhh.a(paramString) + ",mIsPtloginAction=" + this.jdField_a_of_type_Boolean + ", mThirdAppId=" + this.jdField_a_of_type_Long);
    Intent localIntent = new Intent(this, Login.class);
    if (paramString != null) {
      localIntent.putExtra("param_uin", paramString);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localIntent.putExtra("key_req_src", 3);
      localIntent.putExtra("appid", Long.toString(this.jdField_a_of_type_Long));
    }
    for (;;)
    {
      super.startActivityForResult(localIntent, 1);
      return;
      localIntent.putExtra("key_req_src", 2);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        localIntent.putExtra("appid", Long.toString(this.jdField_a_of_type_AndroidOsBundle.getLong("dstAppid", 0L)));
      }
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("-->onTaskCompleted--identifier = ").append(paramString).append("bitmap = null ? ");
      if (paramBitmap != null) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, bool);
      if (paramString.equals(this.jdField_a_of_type_JavaLangString)) {
        runOnUiThread(new QuickLoginAuthorityActivity.10(this, paramBitmap));
      }
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (bjhh.b(this.jdField_a_of_type_MqqManagerWtloginManager, paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "-->login--has aone");
      }
      if (paramBoolean)
      {
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "changeAccountLogin, auto login is true, account is " + paramString + " ;currentAccount is" + this.jdField_a_of_type_JavaLangString);
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
    if (super.getIntent() == null) {
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, " checkIntentValidity() [[[return false]]] intent = null activity=" + this);
    }
    do
    {
      return false;
      this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
      if (this.jdField_a_of_type_AndroidOsBundle == null)
      {
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, " checkIntentValidity() [[[return false]]] mParams = null, activity=" + this);
        return false;
      }
      str = super.getIntent().getStringExtra("key_action");
      if ((!"action_ptlogin_login".equals(str)) && (!"action_quick_login".equals(str)))
      {
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "checkIntentValidity() invalid action = " + str);
        return false;
      }
      this.jdField_a_of_type_Boolean = "action_ptlogin_login".equals(str);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      if ((this.jdField_a_of_type_AndroidOsBundle.containsKey("qrcode")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("schemacallback"))) {
        return true;
      }
    } while (!this.jdField_a_of_type_AndroidOsBundle.containsKey("p"));
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("p");
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (str.startsWith(arrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "checkIntentValidity() invalid path! " + str);
    return false;
    this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidOsBundle.getByteArray("publickey");
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("packagename");
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "mSrcPackageName: " + this.jdField_d_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("dstSsoVer")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("subDstAppid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("dstAppid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("dstAppVer"))) {
      return true;
    }
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "checkIntentValidity() invalid parameters! " + this.jdField_a_of_type_AndroidOsBundle.toString());
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, new Object[] { "checkSignature packageName:", paramString1, " targetSig:", paramString2 });
            return false;
          }
        }
        else
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
            if (i == arrayOfByte.length - 1) {
              break label245;
            }
            localStringBuilder.append(":");
            break label245;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, new Object[] { "checkSignature packageName:", paramString1, " targetSig:", paramString2, " hexStr:", localStringBuilder });
          }
          boolean bool = paramString2.equals(localStringBuilder.toString());
          return bool;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, paramString1, new Object[0]);
      }
      return false;
      label245:
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
    bjkx.a().a(this, this.jdField_a_of_type_JavaLangString, str, a().b(this.jdField_a_of_type_JavaLangString), this);
  }
  
  /* Error */
  protected void b(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +13 -> 17
    //   7: aload_1
    //   8: ldc_w 416
    //   11: invokevirtual 432	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +13 -> 27
    //   17: ldc 173
    //   19: iconst_1
    //   20: ldc_w 786
    //   23: invokestatic 788	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: return
    //   27: new 790	oicq/wlogin_sdk/sharemem/WloginSimpleInfo
    //   30: dup
    //   31: invokespecial 791	oicq/wlogin_sdk/sharemem/WloginSimpleInfo:<init>	()V
    //   34: astore 4
    //   36: aload_0
    //   37: getfield 217	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_MqqManagerWtloginManager	Lmqq/manager/WtloginManager;
    //   40: aload_1
    //   41: aload 4
    //   43: invokeinterface 795 3 0
    //   48: pop
    //   49: new 40	java/lang/String
    //   52: dup
    //   53: aload 4
    //   55: getfield 798	oicq/wlogin_sdk/sharemem/WloginSimpleInfo:_nick	[B
    //   58: invokespecial 801	java/lang/String:<init>	([B)V
    //   61: astore 5
    //   63: aload 5
    //   65: astore 4
    //   67: aload 5
    //   69: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   72: ifeq +6 -> 78
    //   75: aload_1
    //   76: astore 4
    //   78: aload_1
    //   79: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   82: ifne +927 -> 1009
    //   85: aload_0
    //   86: invokespecial 303	com/tencent/open/agent/QuickLoginAuthorityActivity:a	()Lcom/tencent/qqconnect/wtlogin/OpenSDKAppInterface;
    //   89: aload_1
    //   90: ldc_w 802
    //   93: aload_0
    //   94: getfield 804	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_Float	F
    //   97: fmul
    //   98: f2i
    //   99: iconst_1
    //   100: invokevirtual 807	com/tencent/qqconnect/wtlogin/OpenSDKAppInterface:a	(Ljava/lang/String;IZ)Landroid/graphics/Bitmap;
    //   103: astore 5
    //   105: aload_0
    //   106: getfield 318	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   109: aload_1
    //   110: aload 4
    //   112: aload 5
    //   114: iconst_1
    //   115: invokevirtual 810	com/tencent/open/agent/CardContainer:a	(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Z)V
    //   118: aload 5
    //   120: ifnull +33 -> 153
    //   123: invokestatic 816	android/os/Message:obtain	()Landroid/os/Message;
    //   126: astore 4
    //   128: aload 4
    //   130: sipush 1000
    //   133: putfield 819	android/os/Message:what	I
    //   136: aload 4
    //   138: aload 5
    //   140: putfield 823	android/os/Message:obj	Ljava/lang/Object;
    //   143: aload_0
    //   144: getfield 160	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   147: aload 4
    //   149: invokevirtual 829	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   152: pop
    //   153: aload_0
    //   154: getfield 570	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_Boolean	Z
    //   157: ifeq +35 -> 192
    //   160: aload_0
    //   161: invokevirtual 833	com/tencent/open/agent/QuickLoginAuthorityActivity:getResources	()Landroid/content/res/Resources;
    //   164: ldc_w 834
    //   167: invokevirtual 838	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   170: astore 4
    //   172: aload_0
    //   173: getfield 318	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   176: aload 4
    //   178: aconst_null
    //   179: invokevirtual 840	com/tencent/open/agent/CardContainer:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   182: aload_0
    //   183: getfield 318	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   186: ldc_w 842
    //   189: invokevirtual 845	com/tencent/open/agent/CardContainer:setAppType	(Ljava/lang/String;)V
    //   192: aload_0
    //   193: getfield 183	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   196: ldc_w 684
    //   199: invokevirtual 191	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   202: astore 6
    //   204: ldc_w 418
    //   207: astore 7
    //   209: aload 7
    //   211: astore 5
    //   213: aload_0
    //   214: getfield 570	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_Boolean	Z
    //   217: ifeq +452 -> 669
    //   220: aload_0
    //   221: aload_0
    //   222: getfield 183	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   225: ldc_w 669
    //   228: invokevirtual 191	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   231: invokespecial 847	com/tencent/open/agent/QuickLoginAuthorityActivity:a	(Ljava/lang/String;)Landroid/os/Bundle;
    //   234: astore 8
    //   236: aload_0
    //   237: getfield 183	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   240: ldc_w 849
    //   243: invokevirtual 191	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   246: astore 5
    //   248: aload 5
    //   250: astore 4
    //   252: aload 5
    //   254: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   257: ifeq +13 -> 270
    //   260: aload 8
    //   262: ldc_w 851
    //   265: invokevirtual 191	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   268: astore 4
    //   270: aload 4
    //   272: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   275: ifne +42 -> 317
    //   278: aload 4
    //   280: astore 5
    //   282: aload 4
    //   284: invokevirtual 208	java/lang/String:length	()I
    //   287: bipush 20
    //   289: if_icmple +13 -> 302
    //   292: aload 4
    //   294: iconst_0
    //   295: bipush 20
    //   297: invokevirtual 201	java/lang/String:substring	(II)Ljava/lang/String;
    //   300: astore 5
    //   302: aload_0
    //   303: iconst_1
    //   304: putfield 307	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_d_of_type_Boolean	Z
    //   307: aload_0
    //   308: getfield 318	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   311: aload 5
    //   313: aconst_null
    //   314: invokevirtual 840	com/tencent/open/agent/CardContainer:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   317: aload_0
    //   318: getfield 183	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   321: ldc_w 853
    //   324: invokevirtual 191	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   327: astore 4
    //   329: aload 4
    //   331: astore 5
    //   333: aload 4
    //   335: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   338: ifeq +13 -> 351
    //   341: aload 8
    //   343: ldc_w 855
    //   346: invokevirtual 191	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   349: astore 5
    //   351: aload 5
    //   353: astore 4
    //   355: aload 5
    //   357: ifnull +27 -> 384
    //   360: aload 5
    //   362: astore 4
    //   364: aload 5
    //   366: invokevirtual 208	java/lang/String:length	()I
    //   369: bipush 100
    //   371: if_icmple +13 -> 384
    //   374: aload 5
    //   376: iconst_0
    //   377: bipush 100
    //   379: invokevirtual 201	java/lang/String:substring	(II)Ljava/lang/String;
    //   382: astore 4
    //   384: aload 4
    //   386: astore 6
    //   388: aload 7
    //   390: astore 5
    //   392: aload 4
    //   394: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   397: ifeq +272 -> 669
    //   400: aload 4
    //   402: astore 6
    //   404: aload 7
    //   406: astore 5
    //   408: aload 8
    //   410: ifnull +259 -> 669
    //   413: aload 4
    //   415: astore 6
    //   417: aload 7
    //   419: astore 5
    //   421: aload 8
    //   423: ldc_w 857
    //   426: invokevirtual 191	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   429: ifnull +240 -> 669
    //   432: aload 8
    //   434: ldc_w 857
    //   437: ldc_w 418
    //   440: invokevirtual 860	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   443: astore 7
    //   445: aload 7
    //   447: ldc_w 862
    //   450: invokevirtual 432	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   453: ifeq +197 -> 650
    //   456: aload_0
    //   457: iconst_1
    //   458: putfield 307	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_d_of_type_Boolean	Z
    //   461: aload_0
    //   462: getfield 318	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   465: ldc_w 864
    //   468: aconst_null
    //   469: invokevirtual 840	com/tencent/open/agent/CardContainer:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   472: ldc_w 866
    //   475: astore 5
    //   477: aload 7
    //   479: astore 4
    //   481: aload 5
    //   483: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   486: ifeq +227 -> 713
    //   489: aload 4
    //   491: ldc_w 868
    //   494: invokevirtual 432	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   497: ifeq +115 -> 612
    //   500: aload_0
    //   501: getfield 183	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   504: ldc_w 669
    //   507: invokevirtual 191	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   510: invokestatic 873	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   513: astore_1
    //   514: aload_0
    //   515: aload_1
    //   516: invokespecial 847	com/tencent/open/agent/QuickLoginAuthorityActivity:a	(Ljava/lang/String;)Landroid/os/Bundle;
    //   519: ldc_w 874
    //   522: ldc_w 876
    //   525: invokevirtual 860	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   528: invokestatic 880	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   531: invokevirtual 884	java/lang/Long:longValue	()J
    //   534: lstore_2
    //   535: invokestatic 604	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   538: ifeq +39 -> 577
    //   541: ldc 173
    //   543: iconst_2
    //   544: new 280	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   551: ldc_w 886
    //   554: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: aload_1
    //   558: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: ldc_w 888
    //   564: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: lload_2
    //   568: invokevirtual 449	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   571: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 300	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: aload_0
    //   578: lload_2
    //   579: ldc_w 842
    //   582: invokevirtual 890	com/tencent/open/agent/QuickLoginAuthorityActivity:a	(JLjava/lang/String;)V
    //   585: invokestatic 816	android/os/Message:obtain	()Landroid/os/Message;
    //   588: astore_1
    //   589: aload_1
    //   590: sipush 1004
    //   593: putfield 819	android/os/Message:what	I
    //   596: aload_1
    //   597: ldc_w 842
    //   600: putfield 823	android/os/Message:obj	Ljava/lang/Object;
    //   603: aload_0
    //   604: getfield 170	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   607: aload_1
    //   608: invokevirtual 829	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   611: pop
    //   612: ldc 173
    //   614: iconst_1
    //   615: iconst_4
    //   616: anewarray 289	java/lang/Object
    //   619: dup
    //   620: iconst_0
    //   621: ldc_w 892
    //   624: aastore
    //   625: dup
    //   626: iconst_1
    //   627: aload_0
    //   628: getfield 570	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_Boolean	Z
    //   631: invokestatic 897	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   634: aastore
    //   635: dup
    //   636: iconst_2
    //   637: ldc_w 899
    //   640: aastore
    //   641: dup
    //   642: iconst_3
    //   643: aload 4
    //   645: aastore
    //   646: invokestatic 707	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   649: return
    //   650: aload 4
    //   652: astore 6
    //   654: aload 7
    //   656: astore 5
    //   658: aload 7
    //   660: ldc_w 868
    //   663: invokevirtual 432	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   666: ifeq +3 -> 669
    //   669: aload 5
    //   671: astore 4
    //   673: aload 6
    //   675: astore 5
    //   677: goto -196 -> 481
    //   680: astore_1
    //   681: ldc 173
    //   683: iconst_1
    //   684: new 280	java/lang/StringBuilder
    //   687: dup
    //   688: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   691: ldc_w 901
    //   694: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: aload_1
    //   698: invokevirtual 904	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   701: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: invokestatic 788	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   710: goto -98 -> 612
    //   713: aload 5
    //   715: aload_1
    //   716: invokestatic 908	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   719: invokestatic 911	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   722: invokevirtual 884	java/lang/Long:longValue	()J
    //   725: invokestatic 917	oicq/wlogin_sdk/request/WtloginHelper:GetFastLoginUrl	(Ljava/lang/String;J)Loicq/wlogin_sdk/request/WFastLoginInfo;
    //   728: astore 4
    //   730: aload 4
    //   732: ifnonnull +30 -> 762
    //   735: ldc 173
    //   737: iconst_1
    //   738: ldc_w 919
    //   741: invokestatic 788	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   744: return
    //   745: astore_1
    //   746: ldc 173
    //   748: iconst_1
    //   749: ldc_w 921
    //   752: aload_1
    //   753: invokestatic 439	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   756: aconst_null
    //   757: astore 4
    //   759: goto -29 -> 730
    //   762: ldc 173
    //   764: iconst_1
    //   765: iconst_5
    //   766: anewarray 289	java/lang/Object
    //   769: dup
    //   770: iconst_0
    //   771: ldc_w 923
    //   774: aastore
    //   775: dup
    //   776: iconst_1
    //   777: aload_0
    //   778: getfield 570	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_Boolean	Z
    //   781: invokestatic 897	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   784: aastore
    //   785: dup
    //   786: iconst_2
    //   787: ldc_w 925
    //   790: aastore
    //   791: dup
    //   792: iconst_3
    //   793: new 280	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   800: aload 4
    //   802: getfield 930	oicq/wlogin_sdk/request/WFastLoginInfo:iconUrl	Ljava/lang/String;
    //   805: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: ldc_w 932
    //   811: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: aastore
    //   818: dup
    //   819: iconst_4
    //   820: aload 4
    //   822: getfield 935	oicq/wlogin_sdk/request/WFastLoginInfo:adUrl	Ljava/lang/String;
    //   825: aastore
    //   826: invokestatic 707	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   829: aload 4
    //   831: getfield 930	oicq/wlogin_sdk/request/WFastLoginInfo:iconUrl	Ljava/lang/String;
    //   834: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   837: ifne +37 -> 874
    //   840: aload_0
    //   841: iconst_1
    //   842: putfield 314	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_c_of_type_Boolean	Z
    //   845: invokestatic 816	android/os/Message:obtain	()Landroid/os/Message;
    //   848: astore_1
    //   849: aload_1
    //   850: sipush 1001
    //   853: putfield 819	android/os/Message:what	I
    //   856: aload_1
    //   857: aload 4
    //   859: getfield 930	oicq/wlogin_sdk/request/WFastLoginInfo:iconUrl	Ljava/lang/String;
    //   862: putfield 823	android/os/Message:obj	Ljava/lang/Object;
    //   865: aload_0
    //   866: getfield 160	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   869: aload_1
    //   870: invokevirtual 829	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   873: pop
    //   874: aload_0
    //   875: getfield 570	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_Boolean	Z
    //   878: ifne +70 -> 948
    //   881: ldc_w 418
    //   884: astore 7
    //   886: aload_0
    //   887: invokespecial 936	com/tencent/mobileqq/app/BaseActivity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   890: astore_1
    //   891: aload_1
    //   892: aload 5
    //   894: iconst_0
    //   895: invokevirtual 940	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   898: astore 6
    //   900: aload_1
    //   901: astore 5
    //   903: aload 6
    //   905: astore_1
    //   906: aload 7
    //   908: astore 6
    //   910: aload_1
    //   911: ifnull +14 -> 925
    //   914: aload 5
    //   916: aload_1
    //   917: invokevirtual 944	android/content/pm/PackageManager:getApplicationLabel	(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    //   920: checkcast 40	java/lang/String
    //   923: astore 6
    //   925: aload 6
    //   927: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   930: ifne +18 -> 948
    //   933: aload_0
    //   934: iconst_1
    //   935: putfield 307	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_d_of_type_Boolean	Z
    //   938: aload_0
    //   939: getfield 318	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   942: aload 6
    //   944: aconst_null
    //   945: invokevirtual 840	com/tencent/open/agent/CardContainer:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   948: aload 4
    //   950: getfield 935	oicq/wlogin_sdk/request/WFastLoginInfo:adUrl	Ljava/lang/String;
    //   953: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   956: ifne -930 -> 26
    //   959: new 946	java/lang/StringBuffer
    //   962: dup
    //   963: aload 4
    //   965: getfield 935	oicq/wlogin_sdk/request/WFastLoginInfo:adUrl	Ljava/lang/String;
    //   968: invokespecial 947	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   971: astore_1
    //   972: aload_0
    //   973: getfield 318	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   976: aconst_null
    //   977: aload_1
    //   978: iconst_0
    //   979: iconst_4
    //   980: ldc_w 949
    //   983: invokevirtual 953	java/lang/StringBuffer:replace	(IILjava/lang/String;)Ljava/lang/StringBuffer;
    //   986: invokevirtual 954	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   989: invokevirtual 958	com/tencent/open/agent/CardContainer:setAdImageByURL	(Lcom/tencent/mobileqq/widget/AnyScaleTypeImageView;Ljava/lang/String;)V
    //   992: return
    //   993: astore_1
    //   994: aconst_null
    //   995: astore_1
    //   996: aload_1
    //   997: astore 5
    //   999: aconst_null
    //   1000: astore_1
    //   1001: goto -95 -> 906
    //   1004: astore 5
    //   1006: goto -10 -> 996
    //   1009: aconst_null
    //   1010: astore 5
    //   1012: goto -907 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1015	0	this	QuickLoginAuthorityActivity
    //   0	1015	1	paramString	String
    //   534	45	2	l	long
    //   34	930	4	localObject1	Object
    //   61	937	5	localObject2	Object
    //   1004	1	5	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   1010	1	5	localObject3	Object
    //   202	741	6	localObject4	Object
    //   207	700	7	str	String
    //   234	199	8	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   500	577	680	java/lang/Exception
    //   577	612	680	java/lang/Exception
    //   713	730	745	java/lang/NumberFormatException
    //   886	891	993	android/content/pm/PackageManager$NameNotFoundException
    //   891	900	1004	android/content/pm/PackageManager$NameNotFoundException
  }
  
  protected void c()
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
  
  protected void c(String paramString)
  {
    Object localObject2 = new ArrayList();
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null) != null)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null);
      if (localObject1 == null) {}
    }
    for (Object localObject1 = ((String)localObject1).split(",");; localObject1 = null)
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
    if (a() == null)
    {
      c();
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "login mAccountString :" + this.jdField_c_of_type_JavaLangString);
      }
    }
    b(this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      boolean bool;
      if (this.jdField_a_of_type_Boolean) {
        if (!bjhh.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString)) {
          bool = true;
        }
      }
      while (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "login have");
        }
        b();
        return;
        bool = false;
        continue;
        bool = bjhh.b(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString);
      }
      c();
      QQToast.a(BaseApplicationImpl.getContext(), 2131694465, 0).b(getResources().getDimensionPixelSize(2131299080));
      return;
    }
    c();
  }
  
  protected void d(String paramString)
  {
    bjmq.a(paramString);
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(paramString, localWloginSimpleInfo);
    paramString = "" + a().a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_JavaUtilList.contains(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "isLogin: true");
      }
    }
    for (boolean bool = true;; bool = false)
    {
      paramString = new WloginSimpleInfo();
      this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(this.jdField_a_of_type_JavaLangString, paramString);
      paramString = new String(paramString._nick);
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_a_of_type_JavaLangString, paramString, null, true);
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "isLogin:" + bool);
        }
        c(this.jdField_a_of_type_JavaLangString);
      }
      return;
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = false;
    QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doOnCreate--");
    return super.doOnCreate(paramBundle);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    String str = Build.MANUFACTURER + Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 2, "MANUFACTURER = " + Build.MANUFACTURER + ", MODEL = " + Build.MODEL);
    }
    if ((str != null) && ((str.equals("MeizuPRO 7-S")) || (str.equalsIgnoreCase("MeizuM711C")))) {
      ImmersiveUtils.a(getWindow(), true);
    }
    for (;;)
    {
      ImmersiveUtils.a(true, getActivity().getWindow());
      return;
      ImmersiveUtils.a(getActivity().getWindow());
    }
  }
  
  public void e()
  {
    super.setResult(-1, new Intent());
    f();
    super.finish();
    if (this.jdField_b_of_type_Boolean) {}
    try
    {
      bjgx.a().a(this.jdField_a_of_type_JavaLangString, "", "", "1", "9", "0", true, true);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if ((!TextUtils.isEmpty(a().getAccount())) && (!this.jdField_a_of_type_JavaLangString.equals(a().getAccount()))) {
            bjgx.a().a(this.jdField_a_of_type_JavaLangString, "", "", "1", "10", "0", true, true);
          }
          new QuickLoginAuthorityActivity.9(this).start();
          QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setPtloginSdkResult:");
          return;
          localException1 = localException1;
          QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setPtloginSdkResult report exception1:", localException1);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setPtloginSdkResult report exception2:", localException2);
        }
      }
    }
  }
  
  protected void e(String paramString)
  {
    bjmq.a(paramString);
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(paramString, localWloginSimpleInfo);
    paramString = "" + a().a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_JavaUtilList.contains(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "isLogin: true");
      }
    }
    for (boolean bool = true;; bool = false)
    {
      paramString = new WloginSimpleInfo();
      this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(this.jdField_a_of_type_JavaLangString, paramString);
      paramString = new String(paramString._nick);
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_a_of_type_JavaLangString, paramString, null, true);
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "isLogin:" + bool);
        }
        c(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
  
  public void f()
  {
    if ((!super.isFinishing()) && (this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bisl.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void g()
  {
    this.jdField_a_of_type_Bisl.a(super.getString(2131694459));
    if (!this.jdField_a_of_type_Bisl.isShowing()) {
      this.jdField_a_of_type_Bisl.show();
    }
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doAuthorize()");
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = new Bundle();
      localObject2 = (TicketManager)a().getManager(2);
      if ((localObject2 != null) && (TextUtils.isEmpty(((TicketManager)localObject2).getStweb(this.jdField_a_of_type_JavaLangString))))
      {
        ((Bundle)localObject1).putByteArray("connect_data", bjhh.a(Long.toString(this.jdField_a_of_type_Long)));
        ((Bundle)localObject1).putLong("dwSrcAppid", 1600001540L);
        ((Bundle)localObject1).putLong("dwDstAppid", 1600001540L);
      }
      if ((this.jdField_a_of_type_AndroidOsBundle.containsKey("qrcode")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("schemacallback"))) {
        if (this.jdField_a_of_type_JavaLangString.equals(a().getAccount()))
        {
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doAuthorize verifyQRCode");
          a();
        }
      }
      while (!this.jdField_a_of_type_AndroidOsBundle.containsKey("p"))
      {
        return;
        auuv.a("qrcode_ssoGetTicketNoPasswd", 0L);
        a().ssoGetTicketNoPasswd(this.jdField_a_of_type_JavaLangString, 32, this.jdField_a_of_type_MqqObserverSSOAccountObserver, (Bundle)localObject1);
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doAuthorize URL_PARAM_QRCODE");
        return;
      }
      QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doAuthorize URL_PARAM_PATH");
      a().ssoGetTicketNoPasswd(this.jdField_a_of_type_JavaLangString, 32, this.jdField_a_of_type_MqqObserverSSOAccountObserver, (Bundle)localObject1);
      return;
    }
    long l1 = this.jdField_a_of_type_AndroidOsBundle.getLong("dstSsoVer", 0L);
    long l2 = this.jdField_a_of_type_AndroidOsBundle.getLong("subDstAppid", 0L);
    long l3 = this.jdField_a_of_type_AndroidOsBundle.getLong("dstAppid", 0L);
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getByteArray("dstAppVer");
    Object localObject2 = this.jdField_a_of_type_MqqManagerWtloginManager.getPkgSigFromApkName(this, this.jdField_d_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "mSrcPackageName: " + this.jdField_d_of_type_JavaLangString);
      localObject3 = HexUtil.bytes2HexStr((byte[])localObject2);
      QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "dstAppSign: " + (String)localObject3);
    }
    Object localObject3 = new Bundle();
    if (!this.jdField_a_of_type_MqqManagerWtloginManager.isUserHaveA1(this.jdField_a_of_type_JavaLangString, 16L))
    {
      ((Bundle)localObject3).putLong("dwSrcAppid", 1600001540L);
      ((Bundle)localObject3).putLong("dwSubSrcAppid", 1600001540L);
    }
    a().ssoGetA1WithA1(this.jdField_a_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString.getBytes(), l1, l3, l2, (byte[])localObject1, (byte[])localObject2, this.jdField_a_of_type_MqqObserverSSOAccountObserver, (Bundle)localObject3);
  }
  
  public void h()
  {
    int i = getResources().getColor(2131167363);
    ColorStateList localColorStateList = getResources().getColorStateList(2131165948);
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onActivityResult: resultcode:").append(paramInt2).append("requestCode:").append(paramInt1).append("data null?");
      if (paramIntent == null)
      {
        bool = true;
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, bool);
      }
    }
    else
    {
      if (paramInt1 != 100) {
        break label107;
      }
      if (paramInt2 != -1) {
        break label101;
      }
      if (paramIntent != null) {
        this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("uin");
      }
      a();
    }
    label101:
    label107:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        a(null);
        return;
        f();
        if (paramInt2 != 0) {
          break label199;
        }
        if (this.jdField_a_of_type_JavaLangString == null)
        {
          a(paramIntent);
          return;
        }
      } while (this.jdField_b_of_type_JavaLangString == null);
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onActivityResult cancel , current account is : " + this.jdField_a_of_type_JavaLangString + ", preAccount is : " + this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      b(this.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_JavaLangString = null;
      return;
    } while ((-1 != paramInt2) || (paramIntent == null));
    label199:
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("last_account");
    boolean bool = paramIntent.getBooleanExtra("isLogin", false);
    Object localObject = new WloginSimpleInfo();
    if (this.jdField_a_of_type_MqqManagerWtloginManager != null) {
      this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(this.jdField_a_of_type_JavaLangString, (WloginSimpleInfo)localObject);
    }
    for (paramIntent = new String(((WloginSimpleInfo)localObject)._nick);; paramIntent = paramIntent.getStringExtra("nick"))
    {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_a_of_type_JavaLangString, paramIntent, null, true);
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "isLogin:" + bool);
        }
        c(this.jdField_a_of_type_JavaLangString);
      }
      b();
      paramIntent = Message.obtain();
      paramIntent.what = 1005;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramIntent);
      return;
    }
  }
  
  public void onBackPressed()
  {
    QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onBackPressed mIsPtloginAction=" + this.jdField_a_of_type_Boolean);
    a(null);
    if (this.jdField_a_of_type_Boolean) {
      bizq.c();
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.jdField_c_of_type_AndroidWidgetTextView)
      {
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onClick cancel mIsPtloginAction=" + this.jdField_a_of_type_Boolean);
        a(null);
        if (this.jdField_a_of_type_Boolean) {
          bizq.c();
        }
      }
      else if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
      {
        String str4 = "2";
        String str1;
        if (this.jdField_d_of_type_Boolean)
        {
          str1 = "1";
          label94:
          if (!this.jdField_c_of_type_Boolean) {
            break label281;
          }
        }
        label281:
        for (String str2 = "1";; str2 = "2")
        {
          String str3 = str4;
          if (!TextUtils.isEmpty(a().getAccount()))
          {
            str3 = str4;
            if (!this.jdField_a_of_type_JavaLangString.equals(a().getAccount())) {
              str3 = "1";
            }
          }
          bdla.b(null, "dc00898", "", "", "0X800A7BE", "0X800A7BE", this.jdField_a_of_type_Int, 0, str3, str1, str2, "");
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, new Object[] { "report-dc00898-0X800A7BE-fromType=", Integer.valueOf(this.jdField_a_of_type_Int), ",changeaccount=", str3, ", hasGetName=", str1, ", hasGetIcon=", str2 });
          if (NetworkUtil.isNetworkAvailable(this)) {
            break label289;
          }
          f();
          a().a(this, getResources().getString(2131694461));
          break;
          str1 = "2";
          break label94;
        }
        label289:
        boolean bool;
        if (this.jdField_a_of_type_Boolean) {
          if (!bjhh.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString)) {
            bool = true;
          }
        }
        for (;;)
        {
          QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onClick login have");
          if (!bool) {
            break label352;
          }
          g();
          break;
          bool = false;
          continue;
          bool = bjhh.b(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString);
        }
        label352:
        c();
        QQToast.a(BaseApplicationImpl.getContext(), 2131694465, 0).b(super.getResources().getDimensionPixelSize(2131299080));
      }
      else
      {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131363070: 
          a(this.jdField_a_of_type_JavaLangString);
          if (this.jdField_a_of_type_ComTencentOpenAgentCardContainer != null) {
            this.jdField_a_of_type_ComTencentOpenAgentCardContainer.b();
          }
          break;
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onCreate return for savedInstanceState is not null");
      a(null);
    }
    String str1;
    label671:
    label696:
    do
    {
      return;
      if (!a())
      {
        QQToast.a(BaseApplicationImpl.getContext(), anvx.a(2131710697), 0).a();
        a(null);
        return;
      }
      this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("authority_start_qq_login", false);
      str1 = this.jdField_a_of_type_AndroidOsBundle.getString("schemacallback");
      String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("packagename");
      paramBundle = super.getIntent().getStringExtra("key_action");
      String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("p");
      StringBuilder localStringBuilder = new StringBuilder("onCreate()=> mFromSdkLoginAuthority=");
      localStringBuilder.append(this.jdField_b_of_type_Boolean).append("\n schemacallback=").append(str1).append("\n packageName=").append(str2).append("\n action=").append(paramBundle).append("\n urlPraram=").append(str3);
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, localStringBuilder.toString());
      super.setContentView(2131559712);
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer = ((CardContainer)super.findViewById(2131364354));
      i();
      this.jdField_a_of_type_AndroidViewView = findViewById(2131376947);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131363875);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131372242));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131363072));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
      this.jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView = ((MaxHeightScrollView)findViewById(2131364355));
      this.jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new bjfp(this));
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Bisl = new bisl(this, 0, 2131561450, 17);
        this.jdField_a_of_type_Bisl.a(-1);
        this.jdField_a_of_type_Int = 1;
        if (TextUtils.isEmpty(str2)) {
          break label671;
        }
      }
      for (this.jdField_a_of_type_Int = 3;; this.jdField_a_of_type_Int = 2) {
        do
        {
          bdla.b(null, "dc00898", "", "", "0X800A7BC", "0X800A7BC", this.jdField_a_of_type_Int, 0, "", "", "", "");
          QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "report-dc00898-0X800A7BC-fromType=" + this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setChangeAccountListener(new bjfq(this));
          this.jdField_a_of_type_Bisl.setCanceledOnTouchOutside(false);
          this.jdField_a_of_type_JavaUtilList = bjmq.a();
          if (a().isLogin()) {
            this.jdField_a_of_type_JavaLangString = a().getAccount();
          }
          if ((this.jdField_a_of_type_JavaLangString == null) && (this.jdField_a_of_type_JavaUtilList != null)) {
            this.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilList.get(0));
          }
          this.e = getIntent().getStringExtra("login_success_uin");
          if ((!TextUtils.isEmpty(this.e)) && (!this.e.equals(this.jdField_a_of_type_JavaLangString))) {
            this.jdField_a_of_type_JavaLangString = this.e;
          }
          paramBundle = super.getAppRuntime().getAccount();
          if ((!GesturePWDUtils.getJumpLock(this, paramBundle)) || (GesturePWDUtils.getAppForground(this))) {
            break label696;
          }
          QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->onCreate--has gesture password, will start unlock activity");
          this.jdField_c_of_type_JavaLangString = paramBundle;
          paramBundle = new Intent(this, GesturePWDUnlockActivity.class);
          paramBundle.putExtra("key_gesture_from_authority", true);
          super.startActivityForResult(paramBundle, 100);
          return;
          if (isChild()) {}
          for (paramBundle = getParent();; paramBundle = this)
          {
            this.jdField_a_of_type_Bisl = new bisl(paramBundle, super.getTitleBarHeight());
            break;
          }
        } while ((TextUtils.isEmpty(str1)) || (!str1.contains("weixin://")));
      }
      a();
    } while ((TextUtils.isEmpty(str1)) || (!str1.contains("weixin://")));
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a();
    ThreadManager.getSubThreadHandler().post(new QuickLoginAuthorityActivity.6(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "ondestroy");
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity
 * JD-Core Version:    0.7.0.1
 */