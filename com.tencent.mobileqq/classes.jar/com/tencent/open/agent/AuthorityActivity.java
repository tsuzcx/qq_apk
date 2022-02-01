package com.tencent.open.agent;

import Override;
import amtj;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TextView;
import atqa;
import bhht;
import bhpc;
import bhpo;
import bhpp;
import bhpq;
import bhpr;
import bhps;
import bhpu;
import bhpv;
import bhpw;
import bhrj;
import bhuh;
import bhvw;
import bhwb;
import bhwf;
import bhwt;
import bhzm;
import bhzv;
import biah;
import bibo;
import biej;
import biek;
import biew;
import bifi;
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
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.widget.MaxHeightScrollView;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  implements View.OnClickListener, biah
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
  protected bhht a;
  private bhwb jdField_a_of_type_Bhwb = new bhwb();
  public biej a;
  public CardContainer a;
  private MaxHeightScrollView jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView;
  public SdkAuthorize.AuthorizeResponse a;
  public OpenSDKAppInterface a;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public HandlerPlus a;
  public Runnable a;
  public String a;
  protected List<String> a;
  protected WtloginManager a;
  public SSOAccountObserver a;
  public int b;
  public long b;
  protected SharedPreferences b;
  protected View b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bhwb jdField_b_of_type_Bhwb = new bhwb();
  public String b;
  public boolean b;
  public int c;
  protected long c;
  protected SharedPreferences c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private bhwb jdField_c_of_type_Bhwb = new bhwb();
  public String c;
  public boolean c;
  public int d;
  public long d;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private bhwb jdField_d_of_type_Bhwb = new bhwb();
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
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public AuthorityActivity()
  {
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new bhpo(this);
    this.jdField_a_of_type_JavaLangRunnable = new AuthorityActivity.5(this);
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler$Callback = new bhpw(this);
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
    atqa.a(paramString, this.jdField_a_of_type_Biej, localHashMap, paramBoolean);
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
      ((TextView)((AuthorityAccountView)localObject).findViewById(2131361862)).setVisibility(0);
      localTextView = (TextView)((AuthorityAccountView)localObject).findViewById(2131361861);
      str = this.jdField_a_of_type_AndroidOsBundle.getString("sdkp");
      localObject = amtj.a(2131699950);
      if (!"web".equals(str)) {
        break label87;
      }
      localObject = amtj.a(2131699945);
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      return;
      label87:
      if ("android".equals(str)) {
        localObject = amtj.a(2131699951);
      }
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131378806));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131369068));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131369115));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131369099));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131690620);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getResources().getString(2131694247), new Object[] { localObject }));
    }
    Object localObject = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(this.jdField_a_of_type_Biej.jdField_a_of_type_JavaLangString, (WloginSimpleInfo)localObject);
    String str = new String(((WloginSimpleInfo)localObject)._nick);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_Biej.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_a_of_type_Biej.jdField_a_of_type_JavaLangString, (String)localObject, null, false);
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
        break label383;
      }
    }
    label383:
    for (localObject1 = "";; localObject1 = Build.VERSION.RELEASE)
    {
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).os.set((String)localObject1);
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).qqv.set(bhpc.a().d());
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).app_type.set(1);
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).setHasFlag(true);
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).need_ads.set(1);
      localObject1 = bhwf.a(this);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((GetAppInfoProto.GetAppinfoRequest)localObject2).appUniqueIdentifier.set((String)localObject1);
      }
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).referer.set(1);
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).skey.set(this.jdField_a_of_type_Biej.jdField_b_of_type_JavaLangString);
      String str = bhwf.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.jdField_a_of_type_Biej, ((GetAppInfoProto.GetAppinfoRequest)localObject2).login_sig, "ConnAuthSvr.get_app_info", "ConnAuthSvr.get_app_info_emp");
      boolean bool = "ConnAuthSvr.get_app_info_emp".equals(str);
      NewIntent localNewIntent = new NewIntent(this, bhwt.class);
      localNewIntent.setWithouLogin(true);
      localNewIntent.putExtra("uin", this.jdField_a_of_type_Biej.jdField_a_of_type_JavaLangString);
      localObject2 = ((GetAppInfoProto.GetAppinfoRequest)localObject2).toByteArray();
      localObject1 = localObject2;
      if (bool) {
        localObject1 = bifi.a((byte[])localObject2, this.jdField_a_of_type_Biej);
      }
      localNewIntent.putExtra("data", (byte[])localObject1);
      localNewIntent.putExtra("cmd", str);
      QLog.d("AuthorityActivity", 1, new Object[] { "getAppInfo cmd=", str });
      localNewIntent.setObserver(new bhpu(this, bool));
      atqa.a("KEY_GET_APP_INFO_REQUEST");
      super.getAppRuntime().startServlet(localNewIntent);
      this.jdField_c_of_type_Bhwb.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_c_of_type_Bhwb.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
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
    NewIntent localNewIntent = new NewIntent(this, bhwt.class);
    localNewIntent.setWithouLogin(true);
    localNewIntent.putExtra("uin", this.jdField_a_of_type_Biej.jdField_a_of_type_JavaLangString);
    String str = bhwf.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.jdField_a_of_type_Biej, paramGetAuthApiListRequest.login_sig, "ConnAuthSvr.get_auth_api_list", "ConnAuthSvr.get_auth_api_list_emp");
    boolean bool = "ConnAuthSvr.get_auth_api_list_emp".equals(str);
    byte[] arrayOfByte = paramGetAuthApiListRequest.toByteArray();
    paramGetAuthApiListRequest = arrayOfByte;
    if (bool)
    {
      if ((this.jdField_a_of_type_Biej.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_Biej.jdField_a_of_type_ArrayOfByte.length == 0))
      {
        paramGetAuthApiListRequest = this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
        paramGetAuthApiListRequest.what = 6;
        paramGetAuthApiListRequest.arg1 = 3000;
        paramGetAuthApiListRequest.obj = getResources().getString(2131694255);
        this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramGetAuthApiListRequest);
        return;
      }
      paramGetAuthApiListRequest = bifi.a(arrayOfByte, this.jdField_a_of_type_Biej);
    }
    localNewIntent.putExtra("data", paramGetAuthApiListRequest);
    localNewIntent.putExtra("cmd", str);
    this.jdField_a_of_type_Int = 0;
    localNewIntent.setObserver(new bhps(this, bool, str));
    if (this.jdField_c_of_type_Int == 0) {
      atqa.a("KEY_GET_AUTH_API_LIST_REQUEST");
    }
    super.getAppRuntime().startServlet(localNewIntent);
    this.jdField_b_of_type_Bhwb.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Bhwb.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    QLog.d("AuthorityActivity", 1, "send | cmd: " + str + " | uin : *" + bhwf.a(this.jdField_a_of_type_Biej.jdField_a_of_type_JavaLangString));
  }
  
  protected void a(String paramString)
  {
    if ((this.m) || (TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {
      return;
    }
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(paramString, localWloginSimpleInfo);
    Object localObject2 = new String(localWloginSimpleInfo._nick);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramString;
    }
    this.jdField_a_of_type_JavaLangString = Long.toString(localWloginSimpleInfo._uin);
    paramString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(paramString, (int)(58.0F * this.jdField_a_of_type_Float), true);
    if (paramString != null)
    {
      localObject2 = bhwf.a(this, paramString, 63, 63);
      paramString.recycle();
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_a_of_type_JavaLangString, (String)localObject1, (Bitmap)localObject2, false);
      return;
    }
    ThreadManager.executeOnSubThread(new AuthorityActivity.2(this, (String)localObject1));
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    bhzm.c("AuthorityActivity", "-->onTaskCompleted identifier = " + paramString + " - b = " + paramBitmap);
    if ((this.jdField_a_of_type_Biej != null) && (paramString.equals(this.jdField_a_of_type_Biej.jdField_a_of_type_JavaLangString)) && (paramBitmap != null)) {
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
      QLog.d("AuthorityActivity", 2, "-->loginSuccess--userAccount = *" + bhwf.a(paramString1));
    }
    if (!this.m) {
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(5);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    paramString1 = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
    biej localbiej = new biej();
    localbiej.jdField_a_of_type_JavaLangString = paramString1;
    localbiej.jdField_b_of_type_JavaLangString = paramString2;
    if (paramBundle != null)
    {
      localbiej.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp");
      localbiej.jdField_b_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp_key");
    }
    this.jdField_a_of_type_Biej = localbiej;
    this.jdField_a_of_type_JavaLangString = paramString1;
    atqa.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", this.jdField_a_of_type_Biej);
    atqa.a("KEY_LOGIN_STAGE_1_TOTAL", paramString1, this.jdField_a_of_type_Long, null, true);
    if (this.jdField_e_of_type_Int == 1)
    {
      k();
      return;
    }
    i();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (bhwf.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString))
    {
      QLog.d("AuthorityActivity", 1, "changeAccountLogin IsNeedLoginWithPasswd | uin : *" + bhwf.a(paramString));
      c(paramString);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      return;
      QLog.d("AuthorityActivity", 1, "changeAccountLogin send | cmd: g_t_n_p | uin : *" + bhwf.a(paramString));
      atqa.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      biek.a().a(paramString, this.jdField_a_of_type_MqqObserverSSOAccountObserver, jdField_e_of_type_JavaLangString, 1);
      bhwf.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, paramString);
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
      localIntent2.putExtra("third_app_id", jdField_e_of_type_JavaLangString);
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
      localIntent2.putExtra("appid", jdField_e_of_type_JavaLangString);
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
      biej localbiej = new biej();
      localbiej.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("uin");
      localbiej.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).getString("skey");
      localbiej.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp");
      localbiej.jdField_b_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp_key");
      if ((localbiej.jdField_a_of_type_JavaLangString != null) && (localbiej.jdField_b_of_type_JavaLangString != null)) {
        this.jdField_a_of_type_Biej = localbiej;
      }
      if (this.jdField_a_of_type_Biej != null) {
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
    bhzv.a().a(this, this.jdField_a_of_type_Biej.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Biej.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b(this.jdField_a_of_type_Biej.jdField_a_of_type_JavaLangString), this);
  }
  
  public void b(int paramInt, String paramString)
  {
    j();
    if (TextUtils.isEmpty(paramString)) {
      bhwf.a(this, String.format(super.getString(2131694252), new Object[] { Integer.valueOf(paramInt) }), new bhpp(this));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131694259);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(2131694255));
    d(paramInt, paramString);
  }
  
  public void b(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    ForwardUtils.reportAuthorityTotal(paramInt, this.jdField_a_of_type_Biej);
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
    if (!this.l) {
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
      StatisticCollector.getInstance(this).collectPerformance(this.jdField_a_of_type_JavaLangString, "connect_sso_authfail", false, 0L, 0L, paramString1, "");
      paramString1 = "0";
      if (i1 != 0) {
        paramString1 = "1";
      }
      ForwardUtils.reportLoginResult(i1, jdField_e_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      if (this.l) {}
      try
      {
        for (;;)
        {
          bhvw.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_e_of_type_JavaLangString, "1", "9", paramString1, true);
          try
          {
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) && (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))) {
              bhvw.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_e_of_type_JavaLangString, "1", "10", paramString1, true);
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
              bhvw.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_e_of_type_JavaLangString, "1", "6", "0", false);
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
    localEditor.putString(paramString, this.jdField_a_of_type_Biej.jdField_a_of_type_JavaLangString);
    if ((TextUtils.isEmpty(jdField_e_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_Biej.jdField_a_of_type_JavaLangString))) {
      return;
    }
    localEditor.putString(jdField_e_of_type_JavaLangString + ":" + this.jdField_a_of_type_Biej.jdField_a_of_type_JavaLangString, paramString);
    localEditor.commit();
  }
  
  public void b(String paramString1, String paramString2)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).reportToAds(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, paramString1, jdField_e_of_type_JavaLangString + "|" + paramString2 + "|" + this.g);
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
      StatisticCollector.getInstance(this).collectPerformance(this.jdField_a_of_type_JavaLangString, "connect_sso_backto3rd", false, 0L, 0L, localHashMap, "");
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
    for (paramString = String.format(super.getString(2131694252), new Object[] { Integer.valueOf(paramInt) });; paramString = String.format(super.getString(2131695971), new Object[] { paramString, Integer.valueOf(paramInt) }))
    {
      bhwf.a(this, paramString, new bhpq(this, paramInt, localJSONObject));
      return;
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->showLoginActivity--uin = *" + bhwf.a(this.jdField_a_of_type_JavaLangString));
    }
    Intent localIntent = new Intent(this, Login.class);
    localIntent.putExtra("appid", jdField_e_of_type_JavaLangString);
    if (paramString != null) {
      localIntent.putExtra("param_uin", paramString);
    }
    super.startActivityForResult(localIntent, 1);
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376679);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131363803);
    this.jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView = ((MaxHeightScrollView)findViewById(2131364277));
    this.jdField_b_of_type_JavaLangString = ((String)super.getText(2131694259));
    this.jdField_c_of_type_JavaLangString = ((String)super.getText(2131694249));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131372050));
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer = ((CardContainer)super.findViewById(2131364276));
    if (this.m) {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setTag(Boolean.valueOf(this.m));
    }
    n();
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131694246);
    if (this.m)
    {
      this.jdField_c_of_type_JavaLangString = ((String)super.getText(2131694250));
      this.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131694259);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131371773).setVisibility(8);
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new bhpr(this));
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
      StatisticCollector.getInstance(this).collectPerformance(this.jdField_a_of_type_JavaLangString, "connect_sso_authfail", false, 0L, 0L, localHashMap, "");
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
      QLog.d("AuthorityActivity", 2, "-->LocalAccountCache--userAccount = *" + bhwf.a(paramString));
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString("last_account", paramString);
    Object localObject2 = new ArrayList();
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null) != null)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null);
      if (localObject1 == null) {}
    }
    for (Object localObject1 = ((String)localObject1).split(",");; localObject1 = null)
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
    if (!NetworkUtil.isNetworkAvailable(this))
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
    if (!bhwf.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString))
    {
      QLog.d("AuthorityActivity", 1, "send | cmd: g_t_n_p | uin : *" + bhwf.a(this.jdField_a_of_type_JavaLangString));
      atqa.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      biek.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverSSOAccountObserver, jdField_e_of_type_JavaLangString, 1);
      this.jdField_a_of_type_Bhwb.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Bhht.a(getResources().getString(2131694256));
      if ((!super.isFinishing()) && (!this.jdField_a_of_type_Bhht.isShowing())) {}
      try
      {
        this.jdField_a_of_type_Bhht.show();
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
    if (!bibo.a())
    {
      a(true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("appid", jdField_e_of_type_JavaLangString);
      localHashMap.put("p1", "notlogged");
      localHashMap.put("p2", "uauth");
      StatisticCollector.getInstance(this).collectPerformance(this.jdField_a_of_type_JavaLangString, "connect_sso_pageview", false, System.currentTimeMillis() - this.jdField_a_of_type_Long, 0L, localHashMap, "");
      return;
    }
    f();
  }
  
  protected void h()
  {
    QLog.d("AuthorityActivity", 1, "-->loginSSO--");
    this.jdField_a_of_type_Bhht.a(super.getString(2131694262));
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_Bhht.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bhht.show();
      if (this.jdField_a_of_type_JavaLangString != null) {
        if (bhwf.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString))
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
      QLog.d("AuthorityActivity", 1, "send | cmd: g_t_n_p | uin :*" + bhwf.a(this.jdField_a_of_type_JavaLangString));
      atqa.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      biek.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverSSOAccountObserver, jdField_e_of_type_JavaLangString, 1);
      this.jdField_a_of_type_Bhwb.jdField_a_of_type_Long = System.currentTimeMillis();
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
    if (this.jdField_a_of_type_Biej == null)
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
      localGetAuthApiListRequest.qqv.set(bhpc.a().d());
      localGetAuthApiListRequest.app_type.set(1);
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
        break label446;
      }
      localGetAuthApiListRequest.sdkp.set("android");
      label264:
      if (this.k) {
        localGetAuthApiListRequest.referer.set(4);
      }
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("sdkv");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label459;
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
      if (this.jdField_a_of_type_Biej != null) {
        localGetAuthApiListRequest.skey.set(this.jdField_a_of_type_Biej.jdField_b_of_type_JavaLangString);
      }
      localObject = bhwf.a(this);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localGetAuthApiListRequest.appUniqueIdentifier.set((String)localObject);
      }
      a(localGetAuthApiListRequest);
      return;
      localObject = Build.VERSION.RELEASE;
      break;
      label446:
      localGetAuthApiListRequest.sdkp.set((String)localObject);
      break label264;
      label459:
      localGetAuthApiListRequest.sdkv.set((String)localObject);
    }
  }
  
  public void j()
  {
    if ((!super.isFinishing()) && (this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bhht.dismiss();
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
    Object localObject3 = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
    ((Bundle)localObject3).putString("openapi", "");
    ((Bundle)localObject3).putBoolean("doAuthorize", true);
    ((Bundle)localObject3).putString("need_pay", "1");
    ((Bundle)localObject3).putString("appid_for_getting_config", ((Bundle)localObject3).getString("client_id") + "");
    this.jdField_a_of_type_Bhht.a(getResources().getString(2131694262));
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_Bhht.isShowing())) {
      this.jdField_a_of_type_Bhht.show();
    }
    if (this.k) {
      bhuh.a().a((Bundle)localObject3, true);
    }
    label362:
    do
    {
      return;
      long l1 = Long.parseLong(jdField_e_of_type_JavaLangString);
      SdkAuthorize.AuthorizeRequest localAuthorizeRequest = new SdkAuthorize.AuthorizeRequest();
      localAuthorizeRequest.client_id.set(l1);
      localAuthorizeRequest.need_pay.set(1);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bhrj)((Iterator)localObject1).next();
        if (((bhrj)localObject2).jdField_a_of_type_Int > 0) {
          localAuthorizeRequest.openapi.add(Integer.valueOf(((bhrj)localObject2).b));
        }
      }
      String str;
      if (Build.VERSION.RELEASE == null)
      {
        localObject1 = "";
        localAuthorizeRequest.os.set((String)localObject1);
        localAuthorizeRequest.app_type.set(1);
        localAuthorizeRequest.qqv.set(bhpc.a().d());
        localObject2 = ((Bundle)localObject3).getString("pf");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "openmobile_android";
        }
        localAuthorizeRequest.pf.set((String)localObject1);
        localObject1 = ((Bundle)localObject3).getString("sdkp");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label661;
        }
        localAuthorizeRequest.sdkp.set("android");
        localObject1 = ((Bundle)localObject3).getString("sdkv");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label674;
        }
        localAuthorizeRequest.sdkv.set("1.5.9");
        localAuthorizeRequest.response_type.set("token");
        localObject1 = bhwf.a(this);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label687;
        }
        localAuthorizeRequest.appUniqueIdentifier.set((String)localObject1);
        localObject2 = ((Bundle)localObject3).getString("sign");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label699;
        }
        localAuthorizeRequest.sign.set((String)localObject2);
        localObject1 = ((Bundle)localObject3).getString("time");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l1 = Long.parseLong((String)localObject1);
          localAuthorizeRequest.time.set(l1);
        }
        localObject1 = ((Bundle)localObject3).keySet();
        ((Set)localObject1).remove("sdkp");
        ((Set)localObject1).remove("sign");
        ((Set)localObject1).remove("sdkv");
        ((Set)localObject1).remove("sign");
        ((Set)localObject1).remove("time");
        localObject2 = new StringBuffer();
        localObject4 = ((Set)localObject1).iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label791;
        }
        str = (String)((Iterator)localObject4).next();
        localObject1 = ((Bundle)localObject3).get(str);
        if (localObject1 == null) {
          break label784;
        }
      }
      for (localObject1 = localObject1.toString();; localObject1 = "")
      {
        ((StringBuffer)localObject2).append(str + "=" + URLEncoder.encode((String)localObject1) + "&");
        break label566;
        localObject1 = Build.VERSION.RELEASE;
        break;
        localAuthorizeRequest.sdkp.set((String)localObject1);
        break label362;
        localAuthorizeRequest.sdkv.set((String)localObject1);
        break label391;
        QLog.d("AuthorityActivity", 1, "doAuthorize.appUniqueIdentifier is null");
        break label426;
        localObject2 = bifi.a(this, (String)localObject1);
        localObject1 = localObject2[1];
        localObject2 = localObject2[2];
        QLog.d("AuthorityActivity", 1, "doAuthorize.getAuthorizeSign again");
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          QLog.d("AuthorityActivity", 1, "doAuthorize.getAuthorizeSign sign is null");
          break label487;
        }
        localAuthorizeRequest.sign.set((String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label487;
        }
        l1 = Long.parseLong((String)localObject2);
        localAuthorizeRequest.time.set(l1);
        break label487;
      }
      if (((StringBuffer)localObject2).length() > 0)
      {
        ((StringBuffer)localObject2).delete(((StringBuffer)localObject2).length() - 1, ((StringBuffer)localObject2).length());
        localAuthorizeRequest.passData.set(((StringBuffer)localObject2).toString());
      }
      localAuthorizeRequest.skey.set(this.jdField_a_of_type_Biej.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Int = 1;
      localObject3 = new NewIntent(this, bhwt.class);
      ((NewIntent)localObject3).setWithouLogin(true);
      ((NewIntent)localObject3).putExtra("uin", this.jdField_a_of_type_Biej.jdField_a_of_type_JavaLangString);
      Object localObject4 = bhwf.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.jdField_a_of_type_Biej, localAuthorizeRequest.login_sig, "ConnAuthSvr.sdk_auth_api", "ConnAuthSvr.sdk_auth_api_emp");
      boolean bool = "ConnAuthSvr.sdk_auth_api_emp".equals(localObject4);
      Object localObject2 = localAuthorizeRequest.toByteArray();
      localObject1 = localObject2;
      if (bool) {
        localObject1 = bifi.a((byte[])localObject2, this.jdField_a_of_type_Biej);
      }
      ((NewIntent)localObject3).putExtra("data", (byte[])localObject1);
      ((NewIntent)localObject3).putExtra("cmd", (String)localObject4);
      bifi.a((NewIntent)localObject3);
      ((NewIntent)localObject3).setObserver(new bhpv(this, bool, (String)localObject4));
      if (this.jdField_d_of_type_Int == 0) {
        atqa.a("KEY_AUTHORIZE_REQUEST");
      }
      super.getAppRuntime().startServlet((NewIntent)localObject3);
      this.jdField_d_of_type_Bhwb.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_d_of_type_Bhwb.jdField_a_of_type_JavaLangString = ((String)localObject4);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      QLog.d("AuthorityActivity", 1, "send | cmd: " + (String)localObject4 + " | uin : *" + bhwf.a(this.jdField_a_of_type_Biej.jdField_a_of_type_JavaLangString));
    } while (!QLog.isColorLevel());
    label391:
    label426:
    label487:
    QLog.d("SDKQQAgentPref", 2, "AuthorSwitch_AGENT:" + SystemClock.elapsedRealtime());
    label566:
    label699:
    return;
  }
  
  public void l()
  {
    int i1 = getResources().getColor(2131165939);
    ColorStateList localColorStateList = getResources().getColorStateList(2131165939);
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
        bhzm.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.jdField_e_of_type_Long - this.jdField_d_of_type_Long));
        return;
      }
      if (-1 == paramInt2)
      {
        this.jdField_e_of_type_Long = SystemClock.elapsedRealtime();
        bhzm.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.jdField_e_of_type_Long - this.jdField_d_of_type_Long));
        this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
        this.jdField_c_of_type_Boolean = a(paramIntent);
        try
        {
          a(Long.parseLong(jdField_e_of_type_JavaLangString));
          if (jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("last_account");
            boolean bool = paramIntent.getBooleanExtra("isLogin", false);
            Object localObject1 = new WloginSimpleInfo();
            if (this.jdField_a_of_type_MqqManagerWtloginManager != null)
            {
              this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(this.jdField_a_of_type_JavaLangString, (WloginSimpleInfo)localObject1);
              this.jdField_a_of_type_JavaLangString = Long.toString(((WloginSimpleInfo)localObject1)._uin);
            }
            this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(1);
            a(this.jdField_a_of_type_JavaLangString);
            if (bool)
            {
              d(this.jdField_a_of_type_JavaLangString);
              bhwf.a(getAppRuntime(), this.jdField_a_of_type_JavaLangString);
            }
            Object localObject2 = paramIntent.getBundleExtra("ssobundle");
            if (localObject2 != null)
            {
              localObject1 = ((Bundle)localObject2).getByteArray("st_temp");
              localObject2 = ((Bundle)localObject2).getByteArray("st_temp_key");
              if ((localObject1 != null) && (localObject2 != null))
              {
                this.jdField_a_of_type_Biej.jdField_a_of_type_ArrayOfByte = ((byte[])localObject1);
                this.jdField_a_of_type_Biej.jdField_b_of_type_ArrayOfByte = ((byte[])localObject2);
              }
            }
            this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(5);
            this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(11);
            this.jdField_b_of_type_Boolean = true;
            this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
            if ((paramIntent.getBooleanExtra("fromLoginPhoneNum", false)) && (this.jdField_a_of_type_Biej != null) && (this.jdField_a_of_type_Biej.jdField_b_of_type_ArrayOfByte == null))
            {
              f();
              return;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            bhzm.e("AuthorityActivity", "mAuthAppId " + jdField_e_of_type_JavaLangString + " can not cast to long ");
          }
          i();
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Biej != null)) {}
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
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
            continue;
          }
          this.jdField_c_of_type_Long = l1;
          if (!NetworkUtil.isNetworkAvailable(this))
          {
            this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
            this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.jdField_a_of_type_JavaLangRunnable);
            continue;
          }
        }
        finally {}
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        if ((this.i) || (this.jdField_a_of_type_Biej == null))
        {
          f();
        }
        else if (this.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_Bhht.a(super.getString(2131694256));
          if ((!super.isFinishing()) && (!this.jdField_a_of_type_Bhht.isShowing())) {
            this.jdField_a_of_type_Bhht.show();
          }
          i();
        }
        else if (this.jdField_a_of_type_AndroidWidgetButton.getTag().equals(super.getString(2131694255)))
        {
          f();
        }
        else
        {
          atqa.a("KEY_LOGIN_STAGE_2_OLD_TOTAL", this.jdField_a_of_type_Biej);
          atqa.a("KEY_LOGIN_STAGE_3_TOTAL");
          if (this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SDKQQAgentPref", 2, "ClickAuthButton: " + SystemClock.elapsedRealtime());
            }
            Message localMessage = this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
            localMessage.what = 1;
            localMessage.obj = this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse;
            this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
            this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
          }
          for (;;)
          {
            bhvw.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_e_of_type_JavaLangString, "1", "2", "0", false);
            break;
            if (QLog.isColorLevel()) {
              QLog.d("SDKQQAgentPref", 2, "ClickAuthButton -- doAuthorize(): " + SystemClock.elapsedRealtime());
            }
            k();
          }
        }
      }
      else
      {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131363053: 
          c(this.jdField_a_of_type_JavaLangString);
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
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onCreate--");
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    atqa.a("KEY_LOGIN_STAGE_2_OLD_TOTAL");
    if (!(super.getAppRuntime() instanceof OpenSDKAppInterface)) {
      return;
    }
    super.setContentView(2131559676);
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
    this.k = this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_login_by_qr_scan", false);
    jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("client_id");
    this.m = super.getIntent().getBooleanExtra("internal_authority", false);
    this.l = getIntent().getBooleanExtra("authority_start_qq_login", false);
    QLog.d("AuthorityActivity", 1, new Object[] { "-->AuthorityActivity onCreateView mIsInternalAuthority=", Boolean.valueOf(this.m), ", mFromSdkLoginAuthority=", Boolean.valueOf(this.l) });
    String str2;
    String str1;
    if (this.m)
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
      str1 = HexUtil.bytes2HexStr(localMessageDigest.digest());
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
          this.jdField_a_of_type_Bhht = new bhht(paramBundle, super.getTitleBarHeight());
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
      this.n = true;
      label859:
      if (!this.n) {
        break label987;
      }
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("sign", paramBundle);
    this.jdField_a_of_type_AndroidOsBundle.putString("time", str2);
    biek.a().a();
    this.jdField_a_of_type_JavaUtilList = bibo.a();
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
    this.jdField_b_of_type_AndroidContentSharedPreferences = biew.a(this, "uin_openid_store");
    this.jdField_c_of_type_AndroidContentSharedPreferences = biew.a(this, "openid_encrytoken");
    if (this.l)
    {
      this.jdField_a_of_type_Bhht = new bhht(this, 0, 2131561388, 17);
      this.jdField_a_of_type_Bhht.a(-1);
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
      if ((!this.m) && (!"action_login".equals(paramBundle))) {
        break label930;
      }
      jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = false;
      paramBundle = super.getAppRuntime().getAccount();
      if ((this.m) || (!GesturePWDUtils.getJumpLock(this, paramBundle)) || (GesturePWDUtils.getAppForground(this))) {
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
      bhvw.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_e_of_type_JavaLangString, "1", "1", "0", false);
      if (this.l) {
        this.jdField_b_of_type_Boolean = true;
      }
      if (!this.k) {
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
  }
  
  public void onResume()
  {
    super.onResume();
    this.j = false;
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onResume-- SDKQQAgentPref|FirstLaunch_AGENT:" + SystemClock.elapsedRealtime());
    }
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity
 * JD-Core Version:    0.7.0.1
 */