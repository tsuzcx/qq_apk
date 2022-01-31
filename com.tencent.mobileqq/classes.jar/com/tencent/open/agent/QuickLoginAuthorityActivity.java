package com.tencent.open.agent;

import ajyc;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.Signature;
import android.content.res.ColorStateList;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import axqw;
import bbdm;
import bbev;
import bcpq;
import bcpw;
import bcxk;
import bcxm;
import bdcv;
import bdcw;
import bdcx;
import bdcy;
import bdcz;
import bdda;
import bddb;
import bddc;
import bded;
import bdem;
import bdfa;
import bdif;
import bdir;
import bdke;
import bdnb;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.widget.MaxHeightScrollView;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
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
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class QuickLoginAuthorityActivity
  extends BaseActivity
  implements View.OnClickListener, bdir
{
  protected static final String[] a;
  protected float a;
  private int jdField_a_of_type_Int;
  protected SharedPreferences a;
  public Bundle a;
  public Handler a;
  protected View a;
  protected Button a;
  protected RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bcpq a;
  public CardContainer a;
  private MaxHeightScrollView jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView;
  public OpenSDKAppInterface a;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public String a;
  protected List<String> a;
  public WtloginManager a;
  protected SSOAccountObserver a;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new bdcx(this);
  protected boolean a;
  public byte[] a;
  public Handler b;
  protected View b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  private WtloginObserver jdField_b_of_type_MqqObserverWtloginObserver = new bdcy(this);
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
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new bdcv(this);
    this.jdField_a_of_type_AndroidOsHandler = new bddb(this, ThreadManager.getSubThreadLooper());
    this.jdField_b_of_type_AndroidOsHandler = new bddc(this, Looper.getMainLooper());
  }
  
  private int a()
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->verifyQRCode()");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("qrcode");
    int i = str.indexOf("?k=") + 3;
    str = str.substring(i, i + 32);
    this.jdField_b_of_type_ArrayOfByte = QRLoginAuthActivity.a(str.getBytes(), str.length());
    return this.jdField_a_of_type_MqqManagerWtloginManager.VerifyCode(this.jdField_a_of_type_JavaLangString, 16L, true, this.jdField_b_of_type_ArrayOfByte, null, 1, this.jdField_b_of_type_MqqObserverWtloginObserver);
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
    return ((WtloginManager)localObject).VerifyCode(str, 16L, true, arrayOfByte, new int[] { 3, 5, 32, 54 }, 1, localWtloginObserver);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131377439));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131368429));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131368472));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131368457));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694885);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690596);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.a(0);
  }
  
  protected void a()
  {
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences = super.getSharedPreferences("accountList", i);
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
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
      paramString1 = bded.a();
      paramString2 = this.jdField_a_of_type_JavaLangString;
      if (paramInt != 0) {
        break label206;
      }
      paramArrayOfByte = "0";
    }
    catch (Exception paramArrayOfByte)
    {
      try
      {
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) || (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))) {
          break label205;
        }
        paramString1 = bded.a();
        paramString2 = this.jdField_a_of_type_JavaLangString;
        if (paramInt != 0) {
          break label227;
        }
        for (paramArrayOfByte = "0";; paramArrayOfByte = "1")
        {
          paramString1.a(paramString2, "", "", "1", "10", paramArrayOfByte, true);
          return;
          paramArrayOfByte = "1";
          break;
          paramArrayOfByte = paramArrayOfByte;
          QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setSdkResult report exception1:", paramArrayOfByte);
          break label137;
        }
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setSdkResult report exception2:", paramArrayOfByte);
      }
    }
    paramString1.a(paramString2, "", "", "1", "9", paramArrayOfByte, true);
  }
  
  public void a(long paramLong, String paramString)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "getAppInfo appid =" + paramLong + ",comfrom =" + paramString);
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong);
    localGetAppinfoRequest.sdkp.set(paramString);
    if (Build.VERSION.RELEASE == null) {}
    for (paramString = "";; paramString = Build.VERSION.RELEASE)
    {
      localGetAppinfoRequest.os.set(paramString);
      localGetAppinfoRequest.qqv.set(bcxm.a().d());
      localGetAppinfoRequest.setHasFlag(true);
      paramString = bdem.a(this);
      if (!TextUtils.isEmpty(paramString)) {
        localGetAppinfoRequest.appUniqueIdentifier.set(paramString);
      }
      localGetAppinfoRequest.referer.set(1);
      paramString = new NewIntent(BaseApplicationImpl.getContext(), bdfa.class);
      paramString.setWithouLogin(true);
      paramString.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      paramString.putExtra("data", localGetAppinfoRequest.toByteArray());
      paramString.putExtra("cmd", "ConnAuthSvr.get_app_info");
      paramString.setObserver(new bdcw(this));
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
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->showLoginActivity--uin = *" + bdem.a(paramString) + ",mIsPtloginAction=" + this.jdField_a_of_type_Boolean);
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
    if (this.jdField_a_of_type_MqqManagerWtloginManager.IsUserHaveA1(paramString, 16L))
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
    String str = ((TicketManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_JavaLangString);
    bdif.a().a(this, this.jdField_a_of_type_JavaLangString, str, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b(this.jdField_a_of_type_JavaLangString), this);
  }
  
  /* Error */
  protected void b(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +13 -> 17
    //   7: aload_1
    //   8: ldc_w 392
    //   11: invokevirtual 408	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +13 -> 27
    //   17: ldc 173
    //   19: iconst_1
    //   20: ldc_w 752
    //   23: invokestatic 754	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: return
    //   27: new 756	oicq/wlogin_sdk/sharemem/WloginSimpleInfo
    //   30: dup
    //   31: invokespecial 757	oicq/wlogin_sdk/sharemem/WloginSimpleInfo:<init>	()V
    //   34: astore 4
    //   36: aload_0
    //   37: getfield 217	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_MqqManagerWtloginManager	Lmqq/manager/WtloginManager;
    //   40: aload_1
    //   41: aload 4
    //   43: invokeinterface 761 3 0
    //   48: pop
    //   49: new 40	java/lang/String
    //   52: dup
    //   53: aload 4
    //   55: getfield 764	oicq/wlogin_sdk/sharemem/WloginSimpleInfo:_nick	[B
    //   58: invokespecial 767	java/lang/String:<init>	([B)V
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
    //   86: getfield 329	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface	Lcom/tencent/qqconnect/wtlogin/OpenSDKAppInterface;
    //   89: aload_1
    //   90: ldc_w 768
    //   93: aload_0
    //   94: getfield 770	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_Float	F
    //   97: fmul
    //   98: f2i
    //   99: iconst_1
    //   100: invokevirtual 773	com/tencent/qqconnect/wtlogin/OpenSDKAppInterface:a	(Ljava/lang/String;IZ)Landroid/graphics/Bitmap;
    //   103: astore 5
    //   105: aload_0
    //   106: getfield 280	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   109: aload_1
    //   110: aload 4
    //   112: aload 5
    //   114: iconst_1
    //   115: invokevirtual 776	com/tencent/open/agent/CardContainer:a	(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Z)V
    //   118: aload 5
    //   120: ifnull +33 -> 153
    //   123: invokestatic 782	android/os/Message:obtain	()Landroid/os/Message;
    //   126: astore 4
    //   128: aload 4
    //   130: sipush 1000
    //   133: putfield 785	android/os/Message:what	I
    //   136: aload 4
    //   138: aload 5
    //   140: putfield 789	android/os/Message:obj	Ljava/lang/Object;
    //   143: aload_0
    //   144: getfield 160	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   147: aload 4
    //   149: invokevirtual 795	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   152: pop
    //   153: aload_0
    //   154: getfield 544	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_Boolean	Z
    //   157: ifeq +35 -> 192
    //   160: aload_0
    //   161: invokevirtual 799	com/tencent/open/agent/QuickLoginAuthorityActivity:getResources	()Landroid/content/res/Resources;
    //   164: ldc_w 800
    //   167: invokevirtual 804	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   170: astore 4
    //   172: aload_0
    //   173: getfield 280	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   176: aload 4
    //   178: aconst_null
    //   179: invokevirtual 806	com/tencent/open/agent/CardContainer:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   182: aload_0
    //   183: getfield 280	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   186: ldc_w 808
    //   189: invokevirtual 811	com/tencent/open/agent/CardContainer:setAppType	(Ljava/lang/String;)V
    //   192: aload_0
    //   193: getfield 183	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   196: ldc_w 646
    //   199: invokevirtual 191	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   202: astore 6
    //   204: ldc_w 394
    //   207: astore 7
    //   209: aload 7
    //   211: astore 5
    //   213: aload_0
    //   214: getfield 544	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_Boolean	Z
    //   217: ifeq +452 -> 669
    //   220: aload_0
    //   221: aload_0
    //   222: getfield 183	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   225: ldc_w 631
    //   228: invokevirtual 191	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   231: invokespecial 813	com/tencent/open/agent/QuickLoginAuthorityActivity:a	(Ljava/lang/String;)Landroid/os/Bundle;
    //   234: astore 8
    //   236: aload_0
    //   237: getfield 183	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   240: ldc_w 815
    //   243: invokevirtual 191	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   246: astore 5
    //   248: aload 5
    //   250: astore 4
    //   252: aload 5
    //   254: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   257: ifeq +13 -> 270
    //   260: aload 8
    //   262: ldc_w 817
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
    //   304: putfield 269	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_d_of_type_Boolean	Z
    //   307: aload_0
    //   308: getfield 280	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   311: aload 5
    //   313: aconst_null
    //   314: invokevirtual 806	com/tencent/open/agent/CardContainer:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   317: aload_0
    //   318: getfield 183	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   321: ldc_w 819
    //   324: invokevirtual 191	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   327: astore 4
    //   329: aload 4
    //   331: astore 5
    //   333: aload 4
    //   335: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   338: ifeq +13 -> 351
    //   341: aload 8
    //   343: ldc_w 821
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
    //   423: ldc_w 823
    //   426: invokevirtual 191	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   429: ifnull +240 -> 669
    //   432: aload 8
    //   434: ldc_w 823
    //   437: ldc_w 394
    //   440: invokevirtual 826	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   443: astore 7
    //   445: aload 7
    //   447: ldc_w 828
    //   450: invokevirtual 408	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   453: ifeq +197 -> 650
    //   456: aload_0
    //   457: iconst_1
    //   458: putfield 269	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_d_of_type_Boolean	Z
    //   461: aload_0
    //   462: getfield 280	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   465: ldc_w 830
    //   468: aconst_null
    //   469: invokevirtual 806	com/tencent/open/agent/CardContainer:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   472: ldc_w 832
    //   475: astore 5
    //   477: aload 7
    //   479: astore 4
    //   481: aload 5
    //   483: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   486: ifeq +227 -> 713
    //   489: aload 4
    //   491: ldc_w 834
    //   494: invokevirtual 408	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   497: ifeq +115 -> 612
    //   500: aload_0
    //   501: getfield 183	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   504: ldc_w 631
    //   507: invokevirtual 191	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   510: invokestatic 839	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   513: astore_1
    //   514: aload_0
    //   515: aload_1
    //   516: invokespecial 813	com/tencent/open/agent/QuickLoginAuthorityActivity:a	(Ljava/lang/String;)Landroid/os/Bundle;
    //   519: ldc_w 840
    //   522: ldc_w 842
    //   525: invokevirtual 826	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   528: invokestatic 848	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   531: invokevirtual 852	java/lang/Long:longValue	()J
    //   534: lstore_2
    //   535: invokestatic 563	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   538: ifeq +39 -> 577
    //   541: ldc 173
    //   543: iconst_2
    //   544: new 373	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 374	java/lang/StringBuilder:<init>	()V
    //   551: ldc_w 854
    //   554: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: aload_1
    //   558: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: ldc_w 856
    //   564: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: lload_2
    //   568: invokevirtual 423	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   571: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 569	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: aload_0
    //   578: lload_2
    //   579: ldc_w 808
    //   582: invokevirtual 858	com/tencent/open/agent/QuickLoginAuthorityActivity:a	(JLjava/lang/String;)V
    //   585: invokestatic 782	android/os/Message:obtain	()Landroid/os/Message;
    //   588: astore_1
    //   589: aload_1
    //   590: sipush 1004
    //   593: putfield 785	android/os/Message:what	I
    //   596: aload_1
    //   597: ldc_w 808
    //   600: putfield 789	android/os/Message:obj	Ljava/lang/Object;
    //   603: aload_0
    //   604: getfield 170	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   607: aload_1
    //   608: invokevirtual 795	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   611: pop
    //   612: ldc 173
    //   614: iconst_1
    //   615: iconst_4
    //   616: anewarray 666	java/lang/Object
    //   619: dup
    //   620: iconst_0
    //   621: ldc_w 860
    //   624: aastore
    //   625: dup
    //   626: iconst_1
    //   627: aload_0
    //   628: getfield 544	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_Boolean	Z
    //   631: invokestatic 865	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   634: aastore
    //   635: dup
    //   636: iconst_2
    //   637: ldc_w 867
    //   640: aastore
    //   641: dup
    //   642: iconst_3
    //   643: aload 4
    //   645: aastore
    //   646: invokestatic 673	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   649: return
    //   650: aload 4
    //   652: astore 6
    //   654: aload 7
    //   656: astore 5
    //   658: aload 7
    //   660: ldc_w 834
    //   663: invokevirtual 408	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   666: ifeq +3 -> 669
    //   669: aload 5
    //   671: astore 4
    //   673: aload 6
    //   675: astore 5
    //   677: goto -196 -> 481
    //   680: astore_1
    //   681: ldc 173
    //   683: iconst_1
    //   684: new 373	java/lang/StringBuilder
    //   687: dup
    //   688: invokespecial 374	java/lang/StringBuilder:<init>	()V
    //   691: ldc_w 869
    //   694: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: aload_1
    //   698: invokevirtual 872	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   701: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: invokestatic 754	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   710: goto -98 -> 612
    //   713: aload 5
    //   715: aload_1
    //   716: invokestatic 876	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   719: invokestatic 879	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   722: invokevirtual 852	java/lang/Long:longValue	()J
    //   725: invokestatic 885	oicq/wlogin_sdk/request/WtloginHelper:GetFastLoginUrl	(Ljava/lang/String;J)Loicq/wlogin_sdk/request/WFastLoginInfo;
    //   728: astore 4
    //   730: aload 4
    //   732: ifnonnull +30 -> 762
    //   735: ldc 173
    //   737: iconst_1
    //   738: ldc_w 887
    //   741: invokestatic 754	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   744: return
    //   745: astore_1
    //   746: ldc 173
    //   748: iconst_1
    //   749: ldc_w 889
    //   752: aload_1
    //   753: invokestatic 415	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   756: aconst_null
    //   757: astore 4
    //   759: goto -29 -> 730
    //   762: ldc 173
    //   764: iconst_1
    //   765: iconst_5
    //   766: anewarray 666	java/lang/Object
    //   769: dup
    //   770: iconst_0
    //   771: ldc_w 891
    //   774: aastore
    //   775: dup
    //   776: iconst_1
    //   777: aload_0
    //   778: getfield 544	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_Boolean	Z
    //   781: invokestatic 865	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   784: aastore
    //   785: dup
    //   786: iconst_2
    //   787: ldc_w 893
    //   790: aastore
    //   791: dup
    //   792: iconst_3
    //   793: new 373	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 374	java/lang/StringBuilder:<init>	()V
    //   800: aload 4
    //   802: getfield 898	oicq/wlogin_sdk/request/WFastLoginInfo:iconUrl	Ljava/lang/String;
    //   805: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: ldc_w 900
    //   811: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: aastore
    //   818: dup
    //   819: iconst_4
    //   820: aload 4
    //   822: getfield 903	oicq/wlogin_sdk/request/WFastLoginInfo:adUrl	Ljava/lang/String;
    //   825: aastore
    //   826: invokestatic 673	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   829: aload 4
    //   831: getfield 898	oicq/wlogin_sdk/request/WFastLoginInfo:iconUrl	Ljava/lang/String;
    //   834: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   837: ifne +37 -> 874
    //   840: aload_0
    //   841: iconst_1
    //   842: putfield 276	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_c_of_type_Boolean	Z
    //   845: invokestatic 782	android/os/Message:obtain	()Landroid/os/Message;
    //   848: astore_1
    //   849: aload_1
    //   850: sipush 1001
    //   853: putfield 785	android/os/Message:what	I
    //   856: aload_1
    //   857: aload 4
    //   859: getfield 898	oicq/wlogin_sdk/request/WFastLoginInfo:iconUrl	Ljava/lang/String;
    //   862: putfield 789	android/os/Message:obj	Ljava/lang/Object;
    //   865: aload_0
    //   866: getfield 160	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   869: aload_1
    //   870: invokevirtual 795	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   873: pop
    //   874: aload_0
    //   875: getfield 544	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_Boolean	Z
    //   878: ifne +70 -> 948
    //   881: ldc_w 394
    //   884: astore 7
    //   886: aload_0
    //   887: invokespecial 904	com/tencent/mobileqq/app/BaseActivity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   890: astore_1
    //   891: aload_1
    //   892: aload 5
    //   894: iconst_0
    //   895: invokevirtual 908	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
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
    //   917: invokevirtual 912	android/content/pm/PackageManager:getApplicationLabel	(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    //   920: checkcast 40	java/lang/String
    //   923: astore 6
    //   925: aload 6
    //   927: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   930: ifne +18 -> 948
    //   933: aload_0
    //   934: iconst_1
    //   935: putfield 269	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_d_of_type_Boolean	Z
    //   938: aload_0
    //   939: getfield 280	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   942: aload 6
    //   944: aconst_null
    //   945: invokevirtual 806	com/tencent/open/agent/CardContainer:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   948: aload 4
    //   950: getfield 903	oicq/wlogin_sdk/request/WFastLoginInfo:adUrl	Ljava/lang/String;
    //   953: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   956: ifne -930 -> 26
    //   959: new 914	java/lang/StringBuffer
    //   962: dup
    //   963: aload 4
    //   965: getfield 903	oicq/wlogin_sdk/request/WFastLoginInfo:adUrl	Ljava/lang/String;
    //   968: invokespecial 915	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   971: astore_1
    //   972: aload_0
    //   973: getfield 280	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   976: aconst_null
    //   977: aload_1
    //   978: iconst_0
    //   979: iconst_4
    //   980: ldc_w 917
    //   983: invokevirtual 921	java/lang/StringBuffer:replace	(IILjava/lang/String;)Ljava/lang/StringBuffer;
    //   986: invokevirtual 922	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   989: invokevirtual 926	com/tencent/open/agent/CardContainer:setAdImageByURL	(Lcom/tencent/mobileqq/widget/AnyScaleTypeImageView;Ljava/lang/String;)V
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
    if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface == null)
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
        if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.jdField_a_of_type_JavaLangString, 16)) {
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
        bool = this.jdField_a_of_type_MqqManagerWtloginManager.IsUserHaveA1(this.jdField_a_of_type_JavaLangString, 16L);
      }
      c();
      bcpw.a(BaseApplicationImpl.getContext(), 2131694910, 0).b(getResources().getDimensionPixelSize(2131298865));
      return;
    }
    c();
  }
  
  protected void d(String paramString)
  {
    bdke.a(paramString);
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
        break label198;
      }
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.jdField_a_of_type_JavaLangString, paramString);
    }
    label198:
    for (paramString = new String(paramString._nick);; paramString = null)
    {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_a_of_type_JavaLangString, paramString, null, true);
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "isLogin:" + bool);
        }
        c(this.jdField_a_of_type_JavaLangString);
      }
      return;
      bool = false;
      break;
    }
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
      bded.a().a(this.jdField_a_of_type_JavaLangString, "", "", "1", "9", "0", true);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) && (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))) {
            bded.a().a(this.jdField_a_of_type_JavaLangString, "", "", "1", "10", "0", true);
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
    bdke.a(paramString);
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
        break label198;
      }
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.jdField_a_of_type_JavaLangString, paramString);
    }
    label198:
    for (paramString = new String(paramString._nick);; paramString = null)
    {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_a_of_type_JavaLangString, paramString, null, true);
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "isLogin:" + bool);
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
    if ((!super.isFinishing()) && (this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bcpq.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void g()
  {
    this.jdField_a_of_type_Bcpq.a(super.getString(2131694902));
    if (!this.jdField_a_of_type_Bcpq.isShowing()) {
      this.jdField_a_of_type_Bcpq.show();
    }
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 2, "-->doAuthorize()");
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
    byte[] arrayOfByte2 = this.jdField_a_of_type_MqqManagerWtloginManager.getPkgSigFromApkName(this, this.jdField_d_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "mSrcPackageName: " + this.jdField_d_of_type_JavaLangString);
      String str = bbdm.a(arrayOfByte2);
      QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "dstAppSign: " + str);
    }
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetA1WithA1(this.jdField_a_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString.getBytes(), l1, l3, l2, arrayOfByte1, arrayOfByte2, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
  }
  
  public void h()
  {
    int i = getResources().getColor(2131167134);
    ColorStateList localColorStateList = getResources().getColorStateList(2131165827);
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
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.jdField_a_of_type_JavaLangString, (WloginSimpleInfo)localObject);
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
      bcxk.a();
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {}
    label267:
    label274:
    do
    {
      do
      {
        return;
        if (paramView != this.jdField_c_of_type_AndroidWidgetTextView) {
          break;
        }
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onClick cancel mIsPtloginAction=" + this.jdField_a_of_type_Boolean);
        a(null);
      } while (!this.jdField_a_of_type_Boolean);
      bcxk.a();
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
      {
        String str3 = "2";
        if (this.jdField_d_of_type_Boolean)
        {
          paramView = "1";
          if (!this.jdField_c_of_type_Boolean) {
            break label267;
          }
        }
        for (String str1 = "1";; str1 = "2")
        {
          String str2 = str3;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))
          {
            str2 = str3;
            if (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) {
              str2 = "1";
            }
          }
          axqw.b(null, "dc00898", "", "", "0X800A7BE", "0X800A7BE", this.jdField_a_of_type_Int, 0, str2, paramView, str1, "");
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, new Object[] { "report-dc00898-0X800A7BE-fromType=", Integer.valueOf(this.jdField_a_of_type_Int), ",changeaccount=", str2, ", hasGetName=", paramView, ", hasGetIcon=", str1 });
          if (bbev.g(this)) {
            break label274;
          }
          f();
          this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this, getResources().getString(2131694905));
          return;
          paramView = "2";
          break;
        }
        boolean bool;
        if (this.jdField_a_of_type_Boolean) {
          if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.jdField_a_of_type_JavaLangString, 16)) {
            bool = true;
          }
        }
        for (;;)
        {
          QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onClick login have");
          if (!bool) {
            break;
          }
          g();
          return;
          bool = false;
          continue;
          bool = this.jdField_a_of_type_MqqManagerWtloginManager.IsUserHaveA1(this.jdField_a_of_type_JavaLangString, 16L);
        }
        c();
        bcpw.a(BaseApplicationImpl.getContext(), 2131694910, 0).b(super.getResources().getDimensionPixelSize(2131298865));
        return;
      }
      switch (paramView.getId())
      {
      default: 
        return;
      }
      a(this.jdField_a_of_type_JavaLangString);
    } while (this.jdField_a_of_type_ComTencentOpenAgentCardContainer == null);
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)super.getAppRuntime());
    if (paramBundle != null)
    {
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onCreate return for savedInstanceState is not null");
      a(null);
    }
    String str1;
    label688:
    label713:
    do
    {
      return;
      if (!a())
      {
        bcpw.a(BaseApplicationImpl.getContext(), ajyc.a(2131711236), 0).a();
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
      super.setContentView(2131559481);
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer = ((CardContainer)super.findViewById(2131363952));
      i();
      this.jdField_a_of_type_AndroidViewView = findViewById(2131375491);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131363510);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131371068));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131362870));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
      this.jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView = ((MaxHeightScrollView)findViewById(2131363953));
      this.jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new bdcz(this));
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Bcpq = new bcpq(this, 0, 2131561036, 17);
        this.jdField_a_of_type_Bcpq.a(-1);
        this.jdField_a_of_type_Int = 1;
        if (TextUtils.isEmpty(str2)) {
          break label688;
        }
      }
      for (this.jdField_a_of_type_Int = 3;; this.jdField_a_of_type_Int = 2) {
        do
        {
          axqw.b(null, "dc00898", "", "", "0X800A7BC", "0X800A7BC", this.jdField_a_of_type_Int, 0, "", "", "", "");
          QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "report-dc00898-0X800A7BC-fromType=" + this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setChangeAccountListener(new bdda(this));
          this.jdField_a_of_type_Bcpq.setCanceledOnTouchOutside(false);
          bdnb.a().a();
          this.jdField_a_of_type_JavaUtilList = bdke.a();
          if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.isLogin()) {
            this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount();
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
            break label713;
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
            this.jdField_a_of_type_Bcpq = new bcpq(paramBundle, super.getTitleBarHeight());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity
 * JD-Core Version:    0.7.0.1
 */