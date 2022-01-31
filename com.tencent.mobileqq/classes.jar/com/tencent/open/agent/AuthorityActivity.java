package com.tencent.open.agent;

import ajya;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TextView;
import aqgj;
import axrn;
import bbdj;
import bbea;
import bbfj;
import bbgu;
import bcqf;
import bcyb;
import bcym;
import bcyn;
import bcyo;
import bcyp;
import bcyq;
import bcys;
import bcyt;
import bcyu;
import bdah;
import bddh;
import bdes;
import bdex;
import bdfb;
import bdfp;
import bdii;
import bdiu;
import bdjg;
import bdkt;
import bdnp;
import bdnq;
import bdob;
import bdoo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.widget.MaxHeightScrollView;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.util.HandlerPlus;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorityActivity
  extends BaseActivity
  implements View.OnClickListener, bdjg
{
  protected static boolean a;
  public static String e;
  protected float a;
  protected int a;
  public long a;
  protected SharedPreferences a;
  public Bundle a;
  protected Handler.Callback a;
  protected View a;
  public Button a;
  protected TextView a;
  protected bcqf a;
  private bdex jdField_a_of_type_Bdex = new bdex();
  public bdnp a;
  public CardContainer a;
  private MaxHeightScrollView jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView;
  public SdkAuthorize.AuthorizeResponse a;
  public OpenSDKAppInterface a;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public HandlerPlus a;
  public Runnable a;
  public String a;
  ArrayList<SimpleAccount> jdField_a_of_type_JavaUtilArrayList;
  protected List<String> a;
  protected WtloginManager a;
  public SSOAccountObserver a;
  public int b;
  public long b;
  protected SharedPreferences b;
  protected View b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bdex jdField_b_of_type_Bdex = new bdex();
  public String b;
  public boolean b;
  public int c;
  protected long c;
  protected SharedPreferences c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private bdex jdField_c_of_type_Bdex = new bdex();
  public String c;
  public boolean c;
  public int d;
  public long d;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private bdex jdField_d_of_type_Bdex = new bdex();
  protected String d;
  protected boolean d;
  private int e;
  public long e;
  public boolean e;
  public long f;
  protected String f;
  public boolean f;
  public long g;
  protected String g = "";
  public boolean g;
  public long h;
  private String h;
  public boolean h;
  public long i;
  public boolean i;
  public boolean j;
  public boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public AuthorityActivity()
  {
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new bcym(this);
    this.jdField_a_of_type_JavaLangRunnable = new AuthorityActivity.5(this);
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler$Callback = new bcyu(this);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus = new HandlerPlus(this.jdField_a_of_type_AndroidOsHandler$Callback);
  }
  
  public static Bitmap a(String paramString)
  {
    try
    {
      Object localObject = (HttpURLConnection)new URL(paramString).openConnection();
      ((HttpURLConnection)localObject).setDoInput(true);
      ((HttpURLConnection)localObject).connect();
      localObject = ((HttpURLConnection)localObject).getInputStream();
      Bitmap localBitmap = SafeBitmapFactory.decodeStream((InputStream)localObject);
      ((InputStream)localObject).close();
      return localBitmap;
    }
    catch (IOException localIOException)
    {
      QLog.e("AuthorityActivity", 1, new Object[] { "-->getbitmap IOException, url = ", paramString, ", exception message : ", localIOException.getMessage() });
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("AuthorityActivity", 1, new Object[] { "-->getbitmap decodeStream oom, url = ", paramString });
      return null;
    }
    catch (Exception localException)
    {
      QLog.e("AuthorityActivity", 1, new Object[] { "-->getbitmap Exception, url = ", paramString, ", exception message : ", localException.getMessage() });
    }
    return null;
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_RETRY_COUNT", Integer.toString(paramInt));
    aqgj.a(paramString, this.jdField_a_of_type_Bdnp, localHashMap, paramBoolean);
  }
  
  private void m()
  {
    Object localObject = this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a;
    TextView localTextView;
    String str;
    if (localObject != null)
    {
      localTextView = ((AuthorityAccountView)localObject).jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView != null) {
        localTextView.setVisibility(8);
      }
      ((TextView)((AuthorityAccountView)localObject).findViewById(2131361828)).setVisibility(0);
      localTextView = (TextView)((AuthorityAccountView)localObject).findViewById(2131361827);
      str = this.jdField_a_of_type_AndroidOsBundle.getString("sdkp");
      localObject = ajya.a(2131700802);
      if (!"web".equals(str)) {
        break label87;
      }
      localObject = ajya.a(2131700797);
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      return;
      label87:
      if ("android".equals(str)) {
        localObject = ajya.a(2131700803);
      }
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131377439));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131368429));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131368472));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131368457));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131690596);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.a(0);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_d_of_type_JavaLangString != null))
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      if (this.jdField_d_of_type_JavaLangString.length() > 12) {
        localObject = this.jdField_d_of_type_JavaLangString.substring(0, 12) + "...";
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getResources().getString(2131694887), new Object[] { localObject }));
    }
    Object localObject = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString, (WloginSimpleInfo)localObject);
    String str = new String(((WloginSimpleInfo)localObject)._nick);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString, (String)localObject, null, false);
    b();
  }
  
  public void a(int paramInt, String paramString)
  {
    Message localMessage = this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    localMessage.what = 6;
    localMessage.arg1 = 3004;
    localMessage.obj = paramString;
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    paramString2 = this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    paramString3 = new Bundle();
    paramString3.putInt("error", paramInt);
    paramString3.putString("response", paramString1);
    paramString3.putString("msg", null);
    paramString3.putString("detail", null);
    paramString2.setData(paramString3);
    paramString2.what = 7;
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessageDelayed(paramString2, 1000L);
  }
  
  public void a(long paramLong)
  {
    Object localObject2 = new GetAppInfoProto.GetAppinfoRequest();
    this.jdField_a_of_type_Int = 2;
    ((GetAppInfoProto.GetAppinfoRequest)localObject2).client_id.set(paramLong);
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("sdkp");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).sdkp.set("android");
      if (Build.VERSION.RELEASE != null) {
        break label322;
      }
    }
    label322:
    for (localObject1 = "";; localObject1 = Build.VERSION.RELEASE)
    {
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).os.set((String)localObject1);
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).qqv.set(bcyb.a().d());
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).setHasFlag(true);
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).need_ads.set(1);
      localObject1 = bdfb.a(this);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((GetAppInfoProto.GetAppinfoRequest)localObject2).appUniqueIdentifier.set((String)localObject1);
      }
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).referer.set(1);
      NewIntent localNewIntent = new NewIntent(this, bdfp.class);
      localNewIntent.setWithouLogin(true);
      localNewIntent.putExtra("uin", this.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString);
      byte[] arrayOfByte = ((GetAppInfoProto.GetAppinfoRequest)localObject2).toByteArray();
      localObject2 = "ConnAuthSvr.get_app_info";
      localObject1 = arrayOfByte;
      if (!this.i)
      {
        localObject1 = bdoo.a(arrayOfByte, this.jdField_a_of_type_Bdnp);
        localObject2 = "ConnAuthSvr.get_app_info_emp";
      }
      localNewIntent.putExtra("data", (byte[])localObject1);
      localNewIntent.putExtra("cmd", (String)localObject2);
      localNewIntent.setObserver(new bcys(this));
      aqgj.a("KEY_GET_APP_INFO_REQUEST");
      super.getAppRuntime().startServlet(localNewIntent);
      this.jdField_c_of_type_Bdex.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_c_of_type_Bdex.jdField_a_of_type_JavaLangString = ((String)localObject2);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      if (QLog.isColorLevel()) {
        QLog.i("AuthorityActivity", 2, "getAppInfo");
      }
      return;
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).sdkp.set((String)localObject1);
      break;
    }
  }
  
  public void a(SdkAuthorize.GetAuthApiListRequest paramGetAuthApiListRequest)
  {
    if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    }
    this.i = false;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((SimpleAccount)((Iterator)localObject).next()).getUin().equals(this.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString)) {
          this.i = true;
        }
      }
    }
    NewIntent localNewIntent = new NewIntent(this, bdfp.class);
    localNewIntent.setWithouLogin(true);
    localNewIntent.putExtra("uin", this.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString);
    byte[] arrayOfByte = paramGetAuthApiListRequest.toByteArray();
    String str = "ConnAuthSvr.get_auth_api_list";
    Object localObject = "g_a_a_l";
    paramGetAuthApiListRequest = arrayOfByte;
    if (!this.i)
    {
      if ((this.jdField_a_of_type_Bdnp.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_Bdnp.jdField_a_of_type_ArrayOfByte.length == 0))
      {
        paramGetAuthApiListRequest = this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
        paramGetAuthApiListRequest.what = 6;
        paramGetAuthApiListRequest.arg1 = 3000;
        paramGetAuthApiListRequest.obj = getResources().getString(2131694897);
        this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramGetAuthApiListRequest);
        return;
      }
      paramGetAuthApiListRequest = bdoo.a(arrayOfByte, this.jdField_a_of_type_Bdnp);
      str = "ConnAuthSvr.get_auth_api_list_emp";
      localObject = "g_a_a_l_emp";
    }
    localNewIntent.putExtra("data", paramGetAuthApiListRequest);
    localNewIntent.putExtra("cmd", str);
    this.jdField_a_of_type_Int = 0;
    localNewIntent.setObserver(new bcyq(this));
    if (this.jdField_c_of_type_Int == 0) {
      aqgj.a("KEY_GET_AUTH_API_LIST_REQUEST");
    }
    super.getAppRuntime().startServlet(localNewIntent);
    this.jdField_b_of_type_Bdex.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Bdex.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    QLog.d("AuthorityActivity", 1, "send | cmd: " + (String)localObject + " | uin : *" + bdfb.a(this.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString));
  }
  
  protected void a(String paramString)
  {
    if ((this.n) || (TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {
      return;
    }
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, localWloginSimpleInfo);
    Object localObject2 = new String(localWloginSimpleInfo._nick);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramString;
    }
    this.jdField_a_of_type_JavaLangString = Long.toString(localWloginSimpleInfo._uin);
    paramString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(paramString, (int)(58.0F * this.jdField_a_of_type_Float), true);
    if (paramString != null)
    {
      localObject2 = bdfb.a(this, paramString, 63, 63);
      paramString.recycle();
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_a_of_type_JavaLangString, (String)localObject1, (Bitmap)localObject2, false);
      return;
    }
    ThreadManager.executeOnSubThread(new AuthorityActivity.2(this, (String)localObject1));
  }
  
  @TargetApi(17)
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (!isFinishing())
    {
      if (Build.VERSION.SDK_INT < 17) {
        break label54;
      }
      if (!isDestroyed()) {
        bbdj.b(this, 230).setMessageWithUrl(paramString).setTitle(super.getString(2131718891)).setPositiveButton(17039370, paramOnClickListener).show();
      }
    }
    return;
    label54:
    bbdj.b(this, 230).setMessageWithUrl(paramString).setTitle(super.getString(2131718891)).setPositiveButton(17039370, paramOnClickListener).show();
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    bdii.c("AuthorityActivity", "-->onTaskCompleted identifier = " + paramString + " - b = " + paramBitmap);
    if ((this.jdField_a_of_type_Bdnp != null) && (paramString.equals(this.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString)) && (paramBitmap != null)) {
      runOnUiThread(new AuthorityActivity.9(this, paramBitmap));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      SharedPreferences.Editor localEditor = this.jdField_c_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
    }
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->loginSuccess--userAccount = *" + bdfb.a(paramString1));
    }
    if (!this.n) {
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(5);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    paramString1 = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
    bdnp localbdnp = new bdnp();
    localbdnp.jdField_a_of_type_JavaLangString = paramString1;
    localbdnp.jdField_b_of_type_JavaLangString = paramString2;
    if (paramBundle != null)
    {
      localbdnp.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp");
      localbdnp.jdField_b_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp_key");
    }
    this.jdField_a_of_type_Bdnp = localbdnp;
    this.jdField_a_of_type_JavaLangString = paramString1;
    aqgj.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", this.jdField_a_of_type_Bdnp);
    aqgj.a("KEY_LOGIN_STAGE_1_TOTAL", paramString1, this.jdField_a_of_type_Long, null, true);
    if (this.jdField_e_of_type_Int == 1)
    {
      k();
      return;
    }
    i();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(paramString, 16))
    {
      QLog.d("AuthorityActivity", 1, "changeAccountLogin IsNeedLoginWithPasswd | uin : *" + bdfb.a(paramString));
      c(paramString);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      return;
      QLog.d("AuthorityActivity", 1, "changeAccountLogin send | cmd: g_t_n_p | uin : *" + bdfb.a(paramString));
      aqgj.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      bdnq.a().a(paramString, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, false);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->changeAccountActivity--isFirstLogin = " + paramBoolean);
    }
    int i1 = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i1 = this.jdField_a_of_type_JavaUtilList.size();
    }
    Intent localIntent2;
    Intent localIntent1;
    if (i1 > 1)
    {
      localIntent2 = new Intent(this, SwitchAccountActivity.class);
      localIntent2.putExtra("key_req_src", 1);
      localIntent1 = localIntent2;
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        localIntent2.putExtra("param_uin", this.jdField_a_of_type_JavaLangString);
        localIntent1 = localIntent2;
      }
    }
    for (;;)
    {
      super.startActivityForResult(localIntent1, 1);
      return;
      localIntent2 = new Intent(this, Login.class);
      localIntent2.putExtra("key_req_src", 1);
      localIntent1 = localIntent2;
      if (paramBoolean)
      {
        localIntent2.putExtra("is_first_login", true);
        localIntent1 = localIntent2;
      }
    }
  }
  
  protected boolean a(Intent paramIntent)
  {
    Object localObject;
    if (paramIntent != null) {
      localObject = paramIntent.getStringExtra("result_data");
    }
    try
    {
      localObject = HttpBaseUtil.a((String)localObject);
      bdnp localbdnp = new bdnp();
      localbdnp.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("uin");
      localbdnp.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).getString("skey");
      localbdnp.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp");
      localbdnp.jdField_b_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp_key");
      if ((localbdnp.jdField_a_of_type_JavaLangString != null) && (localbdnp.jdField_b_of_type_JavaLangString != null)) {
        this.jdField_a_of_type_Bdnp = localbdnp;
      }
      if (this.jdField_a_of_type_Bdnp != null) {
        return true;
      }
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        a(3005, paramIntent.getMessage());
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qapp_login_" + paramString, 0).getBoolean("qapp_login_flag", false);
  }
  
  protected void b()
  {
    bdiu.a().a(this, this.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bdnp.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b(this.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString), this);
  }
  
  public void b(int paramInt, String paramString)
  {
    j();
    if (TextUtils.isEmpty(paramString)) {
      a(String.format(super.getString(2131694894), new Object[] { Integer.valueOf(paramInt) }), new bcyn(this));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131694901);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(2131694897));
    d(paramInt, paramString);
  }
  
  public void b(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    ForwardUtils.a(paramInt, this.jdField_a_of_type_Bdnp);
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->setSdkResult--error = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
    int i1;
    if (paramInt != 110405)
    {
      i1 = paramInt;
      if (paramInt != 110513) {}
    }
    else
    {
      i1 = 0;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", i1);
    localIntent.putExtra("key_error_msg", paramString2);
    localIntent.putExtra("key_error_detail", paramString3);
    localIntent.putExtra("key_response", paramString1);
    super.setResult(-1, localIntent);
    super.finish();
    if (!this.m) {
      j();
    }
    if (i1 != 0)
    {
      paramString1 = new HashMap();
      paramString1.put("appid", jdField_e_of_type_JavaLangString);
      paramString1.put("errorcode", i1 + "");
      paramString1.put("errormsg", paramString2);
      paramString1.put("errordetail", paramString3);
      paramString2 = AppNetConnInfo.getRecentNetworkInfo();
      if (paramString2 != null)
      {
        if (paramString2.getType() != 1) {
          break label365;
        }
        paramString1.put("network", "wifi");
      }
    }
    for (;;)
    {
      axrn.a(this).a(this.jdField_a_of_type_JavaLangString, "connect_sso_authfail", false, 0L, 0L, paramString1, "");
      paramString1 = "0";
      if (i1 != 0) {
        paramString1 = "1";
      }
      ForwardUtils.a(i1, jdField_e_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      if (this.m) {}
      try
      {
        for (;;)
        {
          bdes.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_e_of_type_JavaLangString, "1", "9", paramString1, true);
          try
          {
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) && (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))) {
              bdes.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_e_of_type_JavaLangString, "1", "10", paramString1, true);
            }
            return;
          }
          catch (Exception paramString1)
          {
            label365:
            paramString1.printStackTrace();
          }
          if (paramString2.getType() != 0) {
            break;
          }
          switch (paramString2.getSubtype())
          {
          case 7: 
          default: 
            paramString1.put("network", "2G");
            break;
          case 1: 
          case 2: 
          case 4: 
            paramString1.put("network", "2G");
            break;
          case 3: 
          case 5: 
          case 6: 
          case 8: 
            paramString1.put("network", "3G");
            break;
            try
            {
              bdes.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_e_of_type_JavaLangString, "1", "6", "0", false);
            }
            catch (Exception paramString1)
            {
              paramString1.printStackTrace();
            }
          }
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    SharedPreferences.Editor localEditor = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString(paramString, this.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString);
    if ((TextUtils.isEmpty(jdField_e_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString))) {
      return;
    }
    localEditor.putString(jdField_e_of_type_JavaLangString + ":" + this.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString, paramString);
    localEditor.commit();
  }
  
  public void b(String paramString1, String paramString2)
  {
    axrn.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, paramString1, jdField_e_of_type_JavaLangString + "|" + paramString2 + "|" + this.g);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences("qapp_login_" + paramString, 0).edit();
    paramString.putBoolean("qapp_login_flag", paramBoolean);
    paramString.commit();
  }
  
  protected void c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", jdField_e_of_type_JavaLangString);
    if (this.jdField_e_of_type_Boolean)
    {
      str = "notlogged";
      localHashMap.put("p1", str);
      if (!this.jdField_f_of_type_Boolean) {
        break label87;
      }
    }
    label87:
    for (String str = "auth";; str = "uauth")
    {
      localHashMap.put("p2", str);
      axrn.a(this).a(this.jdField_a_of_type_JavaLangString, "connect_sso_backto3rd", false, 0L, 0L, localHashMap, "");
      return;
      str = "logged";
      break;
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ret", paramInt);
    localJSONObject.put("msg", paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = String.format(super.getString(2131694894), new Object[] { Integer.valueOf(paramInt) });; paramString = String.format(super.getString(2131696782), new Object[] { paramString, Integer.valueOf(paramInt) }))
    {
      a(paramString, new bcyo(this, paramInt, localJSONObject));
      return;
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->showLoginActivity--uin = *" + bdfb.a(this.jdField_a_of_type_JavaLangString));
    }
    Intent localIntent = new Intent(this, Login.class);
    if (paramString != null) {
      localIntent.putExtra("param_uin", paramString);
    }
    super.startActivityForResult(localIntent, 1);
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131375493);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131363509);
    this.jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView = ((MaxHeightScrollView)findViewById(2131363952));
    this.jdField_b_of_type_JavaLangString = ((String)super.getText(2131694901));
    this.jdField_c_of_type_JavaLangString = ((String)super.getText(2131694889));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131371068));
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer = ((CardContainer)super.findViewById(2131363951));
    if (this.n) {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setTag(Boolean.valueOf(this.n));
    }
    n();
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131694886);
    if (this.n)
    {
      this.jdField_c_of_type_JavaLangString = ((String)super.getText(2131694891));
      this.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131694901);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131370813).setVisibility(8);
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new bcyp(this));
  }
  
  public void d(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", jdField_e_of_type_JavaLangString);
    localHashMap.put("errorcode", paramInt + "");
    localHashMap.put("errormsg", paramString);
    paramString = AppNetConnInfo.getRecentNetworkInfo();
    if (paramString != null)
    {
      if (paramString.getType() != 1) {
        break label103;
      }
      localHashMap.put("network", "wifi");
    }
    for (;;)
    {
      axrn.a(this).a(this.jdField_a_of_type_JavaLangString, "connect_sso_authfail", false, 0L, 0L, localHashMap, "");
      return;
      label103:
      if (paramString.getType() == 0) {
        switch (paramString.getSubtype())
        {
        case 7: 
        default: 
          localHashMap.put("network", "2G");
          break;
        case 1: 
        case 2: 
        case 4: 
          localHashMap.put("network", "2G");
          break;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
          localHashMap.put("network", "3G");
        }
      }
    }
  }
  
  protected void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->LocalAccountCache--userAccount = *" + bdfb.a(paramString));
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString("last_account", paramString);
    Object localObject2 = new ArrayList();
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null) != null) {}
    for (Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null).split(",");; localObject1 = null)
    {
      if (localObject1 != null)
      {
        int i2 = localObject1.length;
        int i1 = 0;
        while (i1 < i2)
        {
          ((ArrayList)localObject2).add(localObject1[i1]);
          i1 += 1;
        }
      }
      while (((ArrayList)localObject2).contains("")) {
        ((ArrayList)localObject2).remove("");
      }
      if (!((ArrayList)localObject2).contains(paramString)) {
        ((ArrayList)localObject2).add(paramString);
      }
      for (;;)
      {
        localObject1 = ((ArrayList)localObject2).iterator();
        for (paramString = ""; ((Iterator)localObject1).hasNext(); paramString = paramString + "," + (String)localObject2) {
          localObject2 = (String)((Iterator)localObject1).next();
        }
        ((ArrayList)localObject2).remove(paramString);
        ((ArrayList)localObject2).add(paramString);
      }
      localEditor.putString("accList", paramString);
      localEditor.commit();
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = false;
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->doOnCreate--");
    }
    return super.doOnCreate(paramBundle);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    String str = Build.MANUFACTURER + Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityActivity", 2, "MANUFACTURER = " + Build.MANUFACTURER + ", MODEL = " + Build.MODEL);
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
  
  protected void e()
  {
    if (!a(null)) {
      g();
    }
  }
  
  public void f()
  {
    QLog.d("AuthorityActivity", 1, "-->login--");
    this.jdField_d_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    if (!bbfj.g(this))
    {
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface == null)
    {
      a(false);
      return;
    }
    if (!this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.isLogin())
    {
      h();
      return;
    }
    if (this.jdField_f_of_type_JavaLangString != null) {
      this.jdField_a_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    }
    if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.jdField_a_of_type_JavaLangString, 16))
    {
      QLog.d("AuthorityActivity", 1, "send | cmd: g_t_n_p | uin : *" + bdfb.a(this.jdField_a_of_type_JavaLangString));
      aqgj.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      bdnq.a().a(this.jdField_a_of_type_JavaLangString, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, false);
      this.jdField_a_of_type_Bdex.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Bcqf.a(getResources().getString(2131694898));
      if ((!super.isFinishing()) && (!this.jdField_a_of_type_Bcqf.isShowing())) {}
      try
      {
        this.jdField_a_of_type_Bcqf.show();
        a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AuthorityActivity", 2, "-->login(), mProgress.show();", localException);
          }
        }
      }
    }
    h();
  }
  
  protected void g()
  {
    QLog.d("AuthorityActivity", 1, "-->startAccountActivity--");
    if (!bdkt.a())
    {
      a(true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("appid", jdField_e_of_type_JavaLangString);
      localHashMap.put("p1", "notlogged");
      localHashMap.put("p2", "uauth");
      axrn.a(this).a(this.jdField_a_of_type_JavaLangString, "connect_sso_pageview", false, System.currentTimeMillis() - this.jdField_a_of_type_Long, 0L, localHashMap, "");
      return;
    }
    f();
  }
  
  protected void h()
  {
    QLog.d("AuthorityActivity", 1, "-->loginSSO--");
    this.jdField_a_of_type_Bcqf.a(super.getString(2131694904));
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_Bcqf.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bcqf.show();
      if (this.jdField_a_of_type_JavaLangString != null) {
        if (this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.jdField_a_of_type_JavaLangString, 16))
        {
          c(this.jdField_a_of_type_JavaLangString);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthorityActivity", 2, "-->loginSSO(), mProgress.show();", localException);
        }
      }
      QLog.d("AuthorityActivity", 1, "send | cmd: g_t_n_p | uin :*" + bdfb.a(this.jdField_a_of_type_JavaLangString));
      aqgj.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      bdnq.a().a(this.jdField_a_of_type_JavaLangString, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, false);
      this.jdField_a_of_type_Bdex.jdField_a_of_type_Long = System.currentTimeMillis();
      a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString));
      return;
    }
    a(true);
    this.jdField_e_of_type_Boolean = true;
    b("wtl_notlogged", "0");
  }
  
  public void i()
  {
    QLog.d("AuthorityActivity", 1, "-->queryAuthority");
    this.jdField_f_of_type_Long = SystemClock.elapsedRealtime();
    if (this.jdField_a_of_type_Bdnp == null)
    {
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    SdkAuthorize.GetAuthApiListRequest localGetAuthApiListRequest = new SdkAuthorize.GetAuthApiListRequest();
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("client_id") + "";
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong((String)localObject);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label113:
      String str;
      break label113;
    }
    localGetAuthApiListRequest.client_id.set(l1);
    if (Build.VERSION.RELEASE == null)
    {
      localObject = "";
      localGetAuthApiListRequest.os.set((String)localObject);
      localGetAuthApiListRequest.qqv.set(bcyb.a().d());
      str = this.jdField_a_of_type_AndroidOsBundle.getString("pf");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localGetAuthApiListRequest.pf.set((String)localObject);
      str = this.jdField_a_of_type_AndroidOsBundle.getString("scope");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localGetAuthApiListRequest.scope.set((String)localObject);
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("sdkp");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label438;
      }
      localGetAuthApiListRequest.sdkp.set("android");
      label256:
      if (this.l) {
        localGetAuthApiListRequest.referer.set(4);
      }
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("sdkv");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label451;
      }
      localGetAuthApiListRequest.sdkv.set("1.5.9");
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("sign");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localGetAuthApiListRequest.sign.set((String)localObject);
        localObject = this.jdField_a_of_type_AndroidOsBundle.getString("time");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          l1 = Long.parseLong((String)localObject);
          localGetAuthApiListRequest.time.set(l1);
        }
      }
      localGetAuthApiListRequest.need_pay.set(1);
      if (this.jdField_a_of_type_Bdnp != null) {
        localGetAuthApiListRequest.skey.set(this.jdField_a_of_type_Bdnp.jdField_b_of_type_JavaLangString);
      }
      localObject = bdfb.a(this);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localGetAuthApiListRequest.appUniqueIdentifier.set((String)localObject);
      }
      a(localGetAuthApiListRequest);
      return;
      localObject = Build.VERSION.RELEASE;
      break;
      label438:
      localGetAuthApiListRequest.sdkp.set((String)localObject);
      break label256;
      label451:
      localGetAuthApiListRequest.sdkv.set((String)localObject);
    }
  }
  
  public void j()
  {
    if ((!super.isFinishing()) && (this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bcqf.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityActivity", 2, "doAuthorize");
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a();
    Object localObject4 = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
    ((Bundle)localObject4).putString("openapi", "");
    ((Bundle)localObject4).putBoolean("doAuthorize", true);
    ((Bundle)localObject4).putString("need_pay", "1");
    ((Bundle)localObject4).putString("appid_for_getting_config", ((Bundle)localObject4).getString("client_id") + "");
    this.jdField_a_of_type_Bcqf.a(getResources().getString(2131694904));
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_Bcqf.isShowing())) {
      this.jdField_a_of_type_Bcqf.show();
    }
    if (this.l) {
      bddh.a().a((Bundle)localObject4, true);
    }
    label342:
    label369:
    label632:
    do
    {
      return;
      long l1 = Long.parseLong(jdField_e_of_type_JavaLangString);
      Object localObject3 = new SdkAuthorize.AuthorizeRequest();
      ((SdkAuthorize.AuthorizeRequest)localObject3).client_id.set(l1);
      ((SdkAuthorize.AuthorizeRequest)localObject3).need_pay.set(1);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bdah)((Iterator)localObject1).next();
        if (((bdah)localObject2).jdField_a_of_type_Int > 0) {
          ((SdkAuthorize.AuthorizeRequest)localObject3).openapi.add(Integer.valueOf(((bdah)localObject2).b));
        }
      }
      String str;
      if (Build.VERSION.RELEASE == null)
      {
        localObject1 = "";
        ((SdkAuthorize.AuthorizeRequest)localObject3).os.set((String)localObject1);
        ((SdkAuthorize.AuthorizeRequest)localObject3).qqv.set(bcyb.a().d());
        localObject2 = ((Bundle)localObject4).getString("pf");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "openmobile_android";
        }
        ((SdkAuthorize.AuthorizeRequest)localObject3).pf.set((String)localObject1);
        localObject1 = ((Bundle)localObject4).getString("sdkp");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label620;
        }
        ((SdkAuthorize.AuthorizeRequest)localObject3).sdkp.set("android");
        localObject1 = ((Bundle)localObject4).getString("sdkv");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label632;
        }
        ((SdkAuthorize.AuthorizeRequest)localObject3).sdkv.set("1.5.9");
        ((SdkAuthorize.AuthorizeRequest)localObject3).response_type.set("token");
        localObject1 = bdfb.a(this);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label644;
        }
        ((SdkAuthorize.AuthorizeRequest)localObject3).appUniqueIdentifier.set((String)localObject1);
        localObject2 = ((Bundle)localObject4).getString("sign");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label656;
        }
        ((SdkAuthorize.AuthorizeRequest)localObject3).sign.set((String)localObject2);
        localObject1 = ((Bundle)localObject4).getString("time");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l1 = Long.parseLong((String)localObject1);
          ((SdkAuthorize.AuthorizeRequest)localObject3).time.set(l1);
        }
        localObject1 = ((Bundle)localObject4).keySet();
        ((Set)localObject1).remove("sdkp");
        ((Set)localObject1).remove("sign");
        ((Set)localObject1).remove("sdkv");
        ((Set)localObject1).remove("sign");
        ((Set)localObject1).remove("time");
        localObject2 = new StringBuffer();
        localObject5 = ((Set)localObject1).iterator();
        if (!((Iterator)localObject5).hasNext()) {
          break label743;
        }
        str = (String)((Iterator)localObject5).next();
        localObject1 = ((Bundle)localObject4).get(str);
        if (localObject1 == null) {
          break label737;
        }
      }
      for (localObject1 = localObject1.toString();; localObject1 = "")
      {
        ((StringBuffer)localObject2).append(str + "=" + URLEncoder.encode((String)localObject1) + "&");
        break label531;
        localObject1 = Build.VERSION.RELEASE;
        break;
        ((SdkAuthorize.AuthorizeRequest)localObject3).sdkp.set((String)localObject1);
        break label342;
        ((SdkAuthorize.AuthorizeRequest)localObject3).sdkv.set((String)localObject1);
        break label369;
        QLog.d("AuthorityActivity", 1, "doAuthorize.appUniqueIdentifier is null");
        break label401;
        localObject2 = bdoo.a(this, (String)localObject1);
        localObject1 = localObject2[1];
        localObject2 = localObject2[2];
        QLog.d("AuthorityActivity", 1, "doAuthorize.getAuthorizeSign again");
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          QLog.d("AuthorityActivity", 1, "doAuthorize.getAuthorizeSign sign is null");
          break label459;
        }
        ((SdkAuthorize.AuthorizeRequest)localObject3).sign.set((String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label459;
        }
        l1 = Long.parseLong((String)localObject2);
        ((SdkAuthorize.AuthorizeRequest)localObject3).time.set(l1);
        break label459;
      }
      if (((StringBuffer)localObject2).length() > 0)
      {
        ((StringBuffer)localObject2).delete(((StringBuffer)localObject2).length() - 1, ((StringBuffer)localObject2).length());
        ((SdkAuthorize.AuthorizeRequest)localObject3).passData.set(((StringBuffer)localObject2).toString());
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).skey.set(this.jdField_a_of_type_Bdnp.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Int = 1;
      Object localObject5 = new NewIntent(this, bdfp.class);
      ((NewIntent)localObject5).setWithouLogin(true);
      ((NewIntent)localObject5).putExtra("uin", this.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString);
      localObject4 = ((SdkAuthorize.AuthorizeRequest)localObject3).toByteArray();
      localObject3 = "ConnAuthSvr.sdk_auth_api";
      Object localObject2 = "s_a_a";
      localObject1 = localObject4;
      if (!this.i)
      {
        localObject1 = bdoo.a((byte[])localObject4, this.jdField_a_of_type_Bdnp);
        localObject3 = "ConnAuthSvr.sdk_auth_api_emp";
        localObject2 = "s_a_a_emp";
      }
      ((NewIntent)localObject5).putExtra("data", (byte[])localObject1);
      ((NewIntent)localObject5).putExtra("cmd", (String)localObject3);
      ((NewIntent)localObject5).setObserver(new bcyt(this));
      if (this.jdField_d_of_type_Int == 0) {
        aqgj.a("KEY_AUTHORIZE_REQUEST");
      }
      super.getAppRuntime().startServlet((NewIntent)localObject5);
      this.jdField_d_of_type_Bdex.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_d_of_type_Bdex.jdField_a_of_type_JavaLangString = ((String)localObject3);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      QLog.d("AuthorityActivity", 1, "send | cmd: " + (String)localObject2 + " | uin : *" + bdfb.a(this.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString));
    } while (!QLog.isColorLevel());
    label401:
    label459:
    label620:
    QLog.d("SDKQQAgentPref", 2, "AuthorSwitch_AGENT:" + SystemClock.elapsedRealtime());
    label531:
    label737:
    label743:
    return;
  }
  
  public void l()
  {
    int i1 = getResources().getColor(2131165827);
    ColorStateList localColorStateList = getResources().getColorStateList(2131165827);
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
    }
    if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "--onActivityResult, requestCode: " + paramInt1 + " | resultCode:" + paramInt2 + " | data: " + paramIntent);
    }
    if (paramInt1 == 100) {
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          this.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("uin");
        }
        e();
      }
    }
    for (;;)
    {
      return;
      super.setResult(0);
      super.finish();
      c();
      return;
      j();
      if (paramInt2 == 0)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          super.setResult(0, paramIntent);
          super.finish();
          c();
        }
        this.jdField_e_of_type_Long = SystemClock.elapsedRealtime();
        bdii.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.jdField_e_of_type_Long - this.jdField_d_of_type_Long));
        return;
      }
      if (-1 != paramInt2) {
        continue;
      }
      this.jdField_e_of_type_Long = SystemClock.elapsedRealtime();
      bdii.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.jdField_e_of_type_Long - this.jdField_d_of_type_Long));
      this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      this.jdField_c_of_type_Boolean = a(paramIntent);
      try
      {
        a(Long.parseLong(jdField_e_of_type_JavaLangString));
        if (!jdField_a_of_type_Boolean) {
          continue;
        }
        this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("last_account");
        boolean bool = paramIntent.getBooleanExtra("isLogin", false);
        Object localObject = new WloginSimpleInfo();
        if (this.jdField_a_of_type_MqqManagerWtloginManager != null)
        {
          this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.jdField_a_of_type_JavaLangString, (WloginSimpleInfo)localObject);
          this.jdField_a_of_type_JavaLangString = Long.toString(((WloginSimpleInfo)localObject)._uin);
        }
        this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(1);
        a(this.jdField_a_of_type_JavaLangString);
        if (bool) {
          d(this.jdField_a_of_type_JavaLangString);
        }
        localObject = paramIntent.getBundleExtra("ssobundle");
        if (localObject != null)
        {
          paramIntent = ((Bundle)localObject).getByteArray("st_temp");
          localObject = ((Bundle)localObject).getByteArray("st_temp_key");
          if ((paramIntent != null) && (localObject != null))
          {
            this.jdField_a_of_type_Bdnp.jdField_a_of_type_ArrayOfByte = paramIntent;
            this.jdField_a_of_type_Bdnp.jdField_b_of_type_ArrayOfByte = ((byte[])localObject);
          }
        }
        this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(5);
        this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(11);
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        i();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          bdii.e("AuthorityActivity", "mAuthAppId " + jdField_e_of_type_JavaLangString + " can not cast to long ");
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Bdnp != null)) {}
    super.setResult(0);
    super.finish();
    c();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_d_of_type_AndroidWidgetTextView)
    {
      super.setResult(0);
      super.finish();
      c();
    }
    do
    {
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthorityActivity", 2, "<user:>authorize btn is clicked.");
        }
        long l1 = System.currentTimeMillis();
        try
        {
          if (l1 - this.jdField_c_of_type_Long < 500L) {
            return;
          }
        }
        finally {}
        this.jdField_c_of_type_Long = l1;
        if (!bbfj.g(this))
        {
          this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.jdField_a_of_type_JavaLangRunnable);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        if ((this.j) || (this.jdField_a_of_type_Bdnp == null))
        {
          f();
          return;
        }
        if (this.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_Bcqf.a(super.getString(2131694898));
          if ((!super.isFinishing()) && (!this.jdField_a_of_type_Bcqf.isShowing())) {
            this.jdField_a_of_type_Bcqf.show();
          }
          i();
          return;
        }
        if (this.jdField_a_of_type_AndroidWidgetButton.getTag().equals(super.getString(2131694897)))
        {
          f();
          return;
        }
        aqgj.a("KEY_LOGIN_STAGE_2_OLD_TOTAL", this.jdField_a_of_type_Bdnp);
        aqgj.a("KEY_LOGIN_STAGE_3_TOTAL");
        if (this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SDKQQAgentPref", 2, "ClickAuthButton: " + SystemClock.elapsedRealtime());
          }
          paramView = this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
          paramView.what = 1;
          paramView.obj = this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse;
          this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramView);
          this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
        }
        for (;;)
        {
          bdes.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_e_of_type_JavaLangString, "1", "2", "0", false);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("SDKQQAgentPref", 2, "ClickAuthButton -- doAuthorize(): " + SystemClock.elapsedRealtime());
          }
          k();
        }
      }
      switch (paramView.getId())
      {
      default: 
        return;
      }
      c(this.jdField_a_of_type_JavaLangString);
    } while (this.jdField_a_of_type_ComTencentOpenAgentCardContainer == null);
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onCreate--");
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    aqgj.a("KEY_LOGIN_STAGE_2_OLD_TOTAL");
    if (!(super.getAppRuntime() instanceof OpenSDKAppInterface)) {
      return;
    }
    super.setContentView(2131559481);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)super.getAppRuntime());
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    if (this.jdField_a_of_type_AndroidOsBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorityActivity", 2, "Params are null, finish activity");
      }
      b(-5, "params is null", "params is null", "params is null");
      return;
    }
    this.l = this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_login_by_qr_scan", false);
    jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("client_id");
    this.n = super.getIntent().getBooleanExtra("internal_authority", false);
    this.m = getIntent().getBooleanExtra("authority_start_qq_login", false);
    QLog.d("AuthorityActivity", 1, new Object[] { "-->AuthorityActivity onCreateView mIsInternalAuthority=", Boolean.valueOf(this.n), ", mFromSdkLoginAuthority=", Boolean.valueOf(this.m) });
    String str2;
    String str1;
    if (this.n)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount();
      str2 = System.currentTimeMillis() / 1000L + "";
      str1 = this.jdField_a_of_type_AndroidOsBundle.getString("package_name");
      paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("sign");
      str1 = str1 + "_" + paramBundle.replace(":", "").toLowerCase() + "_" + str2;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(str1.getBytes());
      str1 = bbea.a(localMessageDigest.digest());
      paramBundle = str1;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        localNoSuchAlgorithmException.printStackTrace();
        continue;
        if (isChild()) {}
        for (paramBundle = getParent();; paramBundle = this)
        {
          this.jdField_a_of_type_Bcqf = new bcqf(paramBundle, super.getTitleBarHeight());
          break;
        }
        label801:
        i1 = 0;
      }
      label806:
      if (Build.VERSION.SDK_INT < 17) {
        break label859;
      }
      int i1 = Settings.Global.getInt(getContentResolver(), "always_finish_activities", 0);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label859;
      }
      boolean bool = a(this.jdField_a_of_type_JavaLangString);
      if ((i1 != 1) || (!bool)) {
        break label859;
      }
      this.o = true;
      label859:
      if (!this.o) {
        break label987;
      }
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("sign", paramBundle);
    this.jdField_a_of_type_AndroidOsBundle.putString("time", str2);
    bdnq.a().a();
    this.jdField_a_of_type_JavaUtilList = bdkt.a();
    if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.isLogin()) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount();
    }
    if ((this.jdField_a_of_type_JavaLangString == null) && (this.jdField_a_of_type_JavaUtilList != null)) {
      this.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilList.get(0));
    }
    this.h = getIntent().getStringExtra("login_success_uin");
    if ((!TextUtils.isEmpty(this.h)) && (!this.h.equals(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaLangString = this.h;
    }
    d();
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("oauth_app_name");
    this.g = this.jdField_a_of_type_AndroidOsBundle.getString("sdkv");
    this.jdField_b_of_type_AndroidContentSharedPreferences = bdob.a(this, "uin_openid_store");
    this.jdField_c_of_type_AndroidContentSharedPreferences = bdob.a(this, "openid_encrytoken");
    if (this.m)
    {
      this.jdField_a_of_type_Bcqf = new bcqf(this, 0, 2131561035, 17);
      this.jdField_a_of_type_Bcqf.a(-1);
      if (this.jdField_d_of_type_JavaLangString != null) {
        this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_d_of_type_JavaLangString, null);
      }
      if (Build.VERSION.SDK_INT <= 10) {
        break label801;
      }
      i1 = 4;
      this.jdField_a_of_type_AndroidContentSharedPreferences = super.getSharedPreferences("accountList", i1);
      paramBundle = super.getIntent().getStringExtra("key_action");
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
      if ((!this.n) && (!"action_login".equals(paramBundle))) {
        break label930;
      }
      jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = false;
      paramBundle = super.getAppRuntime().getAccount();
      if ((this.n) || (!GesturePWDUtils.getJumpLock(this, paramBundle)) || (GesturePWDUtils.getAppForground(this))) {
        break label806;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AuthorityActivity", 2, "-->onCreate--has gesture password, will start unlock activity");
      }
      this.jdField_f_of_type_JavaLangString = paramBundle;
      paramBundle = new Intent(this, GesturePWDUnlockActivity.class);
      paramBundle.putExtra("key_gesture_from_authority", true);
      super.startActivityForResult(paramBundle, 100);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    b(this.jdField_a_of_type_JavaLangString, false);
    for (;;)
    {
      label930:
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(1);
      bdes.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_e_of_type_JavaLangString, "1", "1", "0", false);
      if (this.m) {
        this.jdField_b_of_type_Boolean = true;
      }
      if (!this.l) {
        break;
      }
      m();
      return;
      label987:
      e();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    j();
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onDestroy--");
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Long = 0L;
    this.i = false;
  }
  
  public void onResume()
  {
    super.onResume();
    this.k = false;
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onResume-- SDKQQAgentPref|FirstLaunch_AGENT:" + SystemClock.elapsedRealtime());
    }
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity
 * JD-Core Version:    0.7.0.1
 */