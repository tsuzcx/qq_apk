package com.tencent.open.agent;

import aevv;
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
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import aufu;
import aukw;
import bcst;
import bctj;
import bglp;
import bgmj;
import bgnt;
import bgpa;
import biau;
import biik;
import bikw;
import bime;
import bimf;
import bimg;
import bimh;
import bimi;
import bimj;
import bimk;
import biml;
import bimm;
import bimn;
import bimp;
import bimq;
import binb;
import bine;
import binh;
import bint;
import bior;
import bipi;
import bipn;
import bipr;
import bisy;
import bitk;
import bitw;
import bivh;
import biyc;
import biyn;
import biyp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.model.AccountManage;
import com.tencent.open.model.AccountManage.RefreshReason;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.open.model.VirtualInfo;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.util.HandlerPlus;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenAuthorityFragment
  extends PublicBaseFragment
  implements View.OnClickListener, bitw
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  protected Handler.Callback a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private biau jdField_a_of_type_Biau;
  public binb a;
  public bior a;
  private bipn jdField_a_of_type_Bipn = new bipn();
  private biyc jdField_a_of_type_Biyc;
  private biyp jdField_a_of_type_Biyp;
  private OpenCardContainer jdField_a_of_type_ComTencentOpenAgentOpenCardContainer;
  private SdkAuthorize.AuthorizeResponse jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse;
  private preAuth.PreAuthResponse jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthResponse;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  public HandlerPlus a;
  public Runnable a;
  protected String a;
  private List<String> jdField_a_of_type_JavaUtilList;
  private WtloginManager jdField_a_of_type_MqqManagerWtloginManager;
  public SSOAccountObserver a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int = 1000;
  private long jdField_c_of_type_Long;
  private SharedPreferences jdField_c_of_type_AndroidContentSharedPreferences;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private long jdField_g_of_type_Long;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean;
  private long jdField_h_of_type_Long;
  private boolean jdField_h_of_type_Boolean;
  private long jdField_i_of_type_Long;
  private boolean jdField_i_of_type_Boolean;
  private long jdField_j_of_type_Long;
  private boolean jdField_j_of_type_Boolean;
  private long k;
  
  public OpenAuthorityFragment()
  {
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new bime(this);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangRunnable = new OpenAuthorityFragment.6(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new bimq(this);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus = new HandlerPlus(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_Bior = new bimh(this);
    this.jdField_a_of_type_Binb = new bimk(this);
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
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->getbitmap exception, url=", paramString, localIOException });
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->getbitmap decodeStream oom, url = " + paramString);
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private String a()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  private List<bikw> a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(c());
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bikw localbikw1 = (bikw)((Iterator)localObject).next();
        bikw localbikw2 = new bikw();
        localbikw2.jdField_b_of_type_JavaLangString = localbikw1.jdField_b_of_type_JavaLangString;
        localbikw2.jdField_a_of_type_Int = localbikw1.jdField_a_of_type_Int;
        localbikw2.jdField_b_of_type_Int = localbikw1.jdField_b_of_type_Int;
        localbikw2.jdField_a_of_type_Boolean = localbikw1.jdField_a_of_type_Boolean;
        localbikw2.jdField_a_of_type_JavaLangString = localbikw1.jdField_a_of_type_JavaLangString;
        localbikw2.jdField_b_of_type_Boolean = true;
        localArrayList.add(localbikw2);
      }
    }
    return localArrayList;
  }
  
  private void a(Intent paramIntent)
  {
    boolean bool = false;
    if (paramIntent == null) {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->updateAccount");
    }
    for (;;)
    {
      return;
      Object localObject = paramIntent.getStringExtra("result_data");
      try
      {
        JSONObject localJSONObject = HttpBaseUtil.a((String)localObject);
        localObject = new biyc();
        ((biyc)localObject).jdField_a_of_type_JavaLangString = localJSONObject.getString("uin");
        ((biyc)localObject).jdField_b_of_type_JavaLangString = localJSONObject.getString("skey");
        ((biyc)localObject).jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp");
        ((biyc)localObject).jdField_b_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp_key");
        paramIntent = bipr.a(((biyc)localObject).jdField_a_of_type_JavaLangString);
        if (((biyc)localObject).jdField_b_of_type_JavaLangString != null) {
          bool = true;
        }
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "uin", paramIntent, "key valid=", Boolean.valueOf(bool) });
        if ((((biyc)localObject).jdField_a_of_type_JavaLangString != null) && (((biyc)localObject).jdField_b_of_type_JavaLangString != null))
        {
          this.jdField_a_of_type_Biyc = ((biyc)localObject);
          return;
        }
      }
      catch (JSONException paramIntent)
      {
        QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "JSONException", paramIntent);
        a(3005, paramIntent.getMessage());
      }
    }
  }
  
  private void a(AccountManage.RefreshReason paramRefreshReason)
  {
    Object localObject = c();
    localObject = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a((String)localObject);
    this.jdField_a_of_type_Biyp.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, ((biyc)localObject).jdField_a_of_type_JavaLangString, c(), paramRefreshReason, new bimi(this));
  }
  
  private boolean a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    return (localFragmentActivity != null) && (!localFragmentActivity.isFinishing());
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "handle110537 mIn110537Retry=", Boolean.valueOf(this.jdField_h_of_type_Boolean), ", errorCode=", Integer.valueOf(paramInt), ", isGetVirtualList=", Boolean.valueOf(paramBoolean), "mAccount=", this.jdField_a_of_type_Biyc });
    if ((paramInt != 110537) || (this.jdField_a_of_type_Biyc == null)) {
      return false;
    }
    biik.a(this.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString);
    if ((this.jdField_h_of_type_Boolean) || (bipr.a(this.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, false) == null))
    {
      this.jdField_h_of_type_Boolean = false;
      c(this.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString);
      return true;
    }
    if (paramBoolean)
    {
      this.jdField_h_of_type_Boolean = true;
      p();
      return true;
    }
    this.jdField_h_of_type_Boolean = true;
    n();
    return true;
  }
  
  private String b()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  private void b(int paramInt, String paramString)
  {
    h();
    if (TextUtils.isEmpty(paramString)) {
      a(String.format(super.getString(2131694131), new Object[] { Integer.valueOf(paramInt) }), new bimf(this));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(getString(2131694134));
    d(paramInt, paramString);
  }
  
  private boolean b()
  {
    return (getActivity() == null) || (getActivity().isFinishing());
  }
  
  private String c()
  {
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      return this.jdField_e_of_type_JavaLangString;
    }
    return this.jdField_f_of_type_JavaLangString;
  }
  
  private void c(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ret", paramInt);
    localJSONObject.put("msg", paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = String.format(super.getString(2131694131), new Object[] { Integer.valueOf(paramInt) });; paramString = String.format(super.getString(2131695788), new Object[] { paramString, Integer.valueOf(paramInt) }))
    {
      a(paramString, new bimg(this, paramInt, localJSONObject));
      return;
    }
  }
  
  private void c(String paramString, boolean paramBoolean)
  {
    if (c())
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "showToast activity is null");
      return;
    }
    getActivity().runOnUiThread(new OpenAuthorityFragment.16(this, paramBoolean, paramString));
  }
  
  private boolean c()
  {
    FragmentActivity localFragmentActivity = getActivity();
    return (localFragmentActivity == null) || (localFragmentActivity.isFinishing());
  }
  
  private void d(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", c());
    localHashMap.put("errorcode", paramInt + "");
    localHashMap.put("errormsg", paramString);
    paramString = AppNetConnInfo.getRecentNetworkInfo();
    if (paramString != null)
    {
      if (paramString.getType() != 1) {
        break label106;
      }
      localHashMap.put("network", "wifi");
    }
    for (;;)
    {
      bctj.a(BaseApplicationImpl.getApplication()).a(this.jdField_b_of_type_JavaLangString, "connect_sso_authfail", false, 0L, 0L, localHashMap, "");
      return;
      label106:
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
  
  private void l()
  {
    ((ImmersiveTitleBar2)this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131378874)).a(0);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131368994));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131368979));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690582);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131368947).setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private void m()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->queryAuthorityUseCache");
    this.jdField_f_of_type_Long = SystemClock.elapsedRealtime();
    if (getActivity() == null)
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "queryAuthorityUseCache activity is null");
      return;
    }
    if (this.jdField_a_of_type_Biyc == null)
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "queryAuthorityUseCache mAccount is null");
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = getActivity().getIntent().getBundleExtra("key_params");
    preAuth.PreAuthResponse localPreAuthResponse = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(c());
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->queryAuthorityUseCache use cache preAuth.PreAuthResponse");
    Message localMessage = this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    localMessage.what = 0;
    localMessage.obj = localPreAuthResponse;
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
  }
  
  private void n()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->updatePreAuthFromServer--");
    if (!a())
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "updatePreAuthFromServer for activity is finished");
      return;
    }
    if (!bgnt.g(BaseApplicationImpl.getApplication()))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->updatePreAuthFromServer isNetworkAvailable false--");
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    if (this.jdField_a_of_type_Biyc == null)
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->updatePreAuthFromServer mAccount == null");
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = getActivity().getIntent().getBundleExtra("key_params");
    if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    }
    if ((this.jdField_a_of_type_Biyc.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_Biyc.jdField_a_of_type_ArrayOfByte.length == 0))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->updatePreAuthFromServer mAccount.st == null || mAccount.st.length == 0");
      Message localMessage = this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
      localMessage.what = 6;
      localMessage.arg1 = 3000;
      localMessage.obj = getResources().getString(2131694134);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
      return;
    }
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(a(), c(), getActivity(), bipr.a(getActivity()), this.jdField_a_of_type_AndroidOsBundle, new bimp(this));
  }
  
  private void o()
  {
    if (!a())
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "getAppInfo return for activity is finished");
      return;
    }
    this.jdField_a_of_type_Int = 2;
    aufu localaufu = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(c());
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "getAppInfo use cached appid=", c(), ", appInfo=", localaufu.toString() });
    Message localMessage = this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    localMessage.what = 3;
    localMessage.obj = localaufu;
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
  }
  
  private void p()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->getVirtualListFromServer");
    if (!bgnt.g(BaseApplicationImpl.getApplication()))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->getVirtualList isNetworkAvailable false");
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(a(), c(), getActivity(), bipr.a(getActivity()), this.jdField_a_of_type_AndroidOsBundle, new bimj(this));
  }
  
  public void a()
  {
    Object localObject = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString, (WloginSimpleInfo)localObject);
    String str = new String(((WloginSimpleInfo)localObject)._nick);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(this.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString, (String)localObject, null, false);
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
  
  protected void a(View paramView)
  {
    this.jdField_c_of_type_JavaLangString = ((String)super.getText(2131694138));
    this.jdField_d_of_type_JavaLangString = ((String)super.getText(2131694128));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131371971));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364294));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer = ((OpenCardContainer)paramView.findViewById(2131364212));
    if (this.jdField_i_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setTag(Boolean.valueOf(this.jdField_i_of_type_Boolean));
    }
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setOnUpdateStatusBarListener(new biml(this));
    l();
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_d_of_type_JavaLangString = ((String)super.getText(2131694129));
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidWidgetButton.setTag(this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131371701).setVisibility(8);
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    paramView = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(c());
    if (paramView != null)
    {
      Object localObject = paramView.jdField_a_of_type_JavaUtilArrayList;
      long l = paramView.jdField_a_of_type_Long;
      if (localObject != null)
      {
        paramView = new LinkedList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          VirtualInfo localVirtualInfo = (VirtualInfo)((Iterator)localObject).next();
          binh localbinh = new binh(localVirtualInfo.jdField_a_of_type_Long, localVirtualInfo.jdField_a_of_type_JavaLangString, localVirtualInfo.jdField_b_of_type_JavaLangString);
          if (localVirtualInfo.jdField_a_of_type_Long == l) {
            localbinh.jdField_a_of_type_Boolean = true;
          }
          paramView.add(localbinh);
        }
        this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_Bine.a(paramView, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount());
      }
    }
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setCreateVirtualListner(new bimm(this));
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setOndeleteVirtualListener(this.jdField_a_of_type_Binb);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setOnAccountEventListener(new bimn(this));
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setCurrentAppid(c());
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  protected void a(String paramString)
  {
    if ((this.jdField_i_of_type_Boolean) || (TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {
      return;
    }
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, localWloginSimpleInfo);
    Object localObject2 = new String(localWloginSimpleInfo._nick);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramString;
    }
    this.jdField_b_of_type_JavaLangString = Long.toString(localWloginSimpleInfo._uin);
    paramString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(paramString, (int)(58.0F * this.jdField_a_of_type_Float), true);
    if (paramString != null)
    {
      localObject2 = bipr.a(getActivity(), paramString, 63, 63);
      paramString.recycle();
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(this.jdField_b_of_type_JavaLangString, (String)localObject1, (Bitmap)localObject2, false);
      return;
    }
    ThreadManager.executeOnSubThread(new OpenAuthorityFragment.2(this, (String)localObject1));
  }
  
  @TargetApi(17)
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (!getActivity().isFinishing())
    {
      if (Build.VERSION.SDK_INT < 17) {
        break label63;
      }
      if (!getActivity().isDestroyed()) {
        bglp.b(getActivity(), 230).setMessageWithUrl(paramString).setTitle(super.getString(2131717436)).setPositiveButton(17039370, paramOnClickListener).show();
      }
    }
    return;
    label63:
    bglp.b(getActivity(), 230).setMessageWithUrl(paramString).setTitle(super.getString(2131717436)).setPositiveButton(17039370, paramOnClickListener).show();
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    bisy.c("SDK_LOGIN.OpenAuthorityFragment", "-->onTaskCompleted identifier = " + paramString + " - b = " + paramBitmap);
    if ((this.jdField_a_of_type_Biyc != null) && (paramString.equals(this.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString)))
    {
      if (getActivity() != null) {
        break label73;
      }
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "onTaskCompleted activity is null");
    }
    label73:
    while (paramBitmap == null) {
      return;
    }
    getActivity().runOnUiThread(new OpenAuthorityFragment.9(this, paramBitmap));
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
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->loginSuccess--userAccount = *", bipr.a(paramString1) });
    if (!this.jdField_i_of_type_Boolean) {
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(5);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    paramString1 = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
    biyc localbiyc = new biyc();
    localbiyc.jdField_a_of_type_JavaLangString = paramString1;
    localbiyc.jdField_b_of_type_JavaLangString = paramString2;
    if (paramBundle != null)
    {
      localbiyc.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp");
      localbiyc.jdField_b_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp_key");
    }
    this.jdField_a_of_type_Biyc = localbiyc;
    this.jdField_b_of_type_JavaLangString = paramString1;
    aukw.a("KEY_LOGIN_STAGE_1_TOTAL", paramString1, this.jdField_a_of_type_Long, null, true);
    aukw.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", this.jdField_a_of_type_Biyc);
    paramString1 = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(c());
    if ((paramString1 == null) || (!paramString1.jdField_a_of_type_JavaLangString.equals(localbiyc.jdField_a_of_type_JavaLangString))) {
      if (paramString1 != null) {
        break label328;
      }
    }
    label328:
    for (paramString1 = "null";; paramString1 = bipr.a(paramString1.jdField_a_of_type_JavaLangString))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "--loginSuccess, changeAccount old uin=", paramString1, ", new uin=", bipr.a(localbiyc.jdField_a_of_type_JavaLangString) });
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(c(), this.jdField_a_of_type_Biyc);
      k();
      if (this.jdField_e_of_type_Int != 1) {
        break;
      }
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "loginSuccess============= mSKeyErrorStep == AUTHORIZE_DONE");
      this.jdField_a_of_type_Biyp.a(this.jdField_d_of_type_Boolean, a(), b(), new ArrayList(), this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(), this.jdField_a_of_type_Bior, bipr.a(getActivity()), getActivity());
      return;
    }
    m();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "changeAccountLogin account=", bipr.a(paramString), ", canAutoLogin=", Boolean.valueOf(paramBoolean) });
    if (!bgnt.g(BaseApplicationImpl.getApplication()))
    {
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    if (bipr.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString)) {
      c(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      return;
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "send | cmd: g_t_n_p | uin : *" + bipr.a(paramString));
      aukw.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      AccountManage.a().a(paramString, this.jdField_a_of_type_MqqObserverSSOAccountObserver, c(), AccountManage.RefreshReason.useCacheFirst);
      bipr.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, paramString);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->changeAccountActivity--isFirstLogin = " + paramBoolean);
    int m = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      m = this.jdField_a_of_type_JavaUtilList.size();
    }
    Intent localIntent2;
    Intent localIntent1;
    if (m > 1)
    {
      localIntent2 = new Intent(getActivity(), SwitchAccountActivity.class);
      localIntent2.putExtra("key_req_src", 1);
      localIntent2.putExtra("third_app_id", c());
      localIntent1 = localIntent2;
      if (this.jdField_b_of_type_JavaLangString != null)
      {
        localIntent2.putExtra("param_uin", this.jdField_b_of_type_JavaLangString);
        localIntent1 = localIntent2;
      }
    }
    for (;;)
    {
      super.startActivityForResult(localIntent1, 1);
      return;
      localIntent2 = new Intent(getActivity(), Login.class);
      localIntent2.putExtra("key_req_src", 1);
      localIntent2.putExtra("appid", c());
      localIntent1 = localIntent2;
      if (paramBoolean)
      {
        localIntent2.putExtra("is_first_login", true);
        localIntent1 = localIntent2;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qapp_login_" + paramString, 0).getBoolean("qapp_login_flag", false);
  }
  
  protected void b()
  {
    bitk.a().a(getActivity(), this.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Biyc.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b(this.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString), this);
  }
  
  public void b(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    ForwardUtils.a(paramInt, this.jdField_a_of_type_Biyc);
    if (QLog.isColorLevel()) {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 2, "-->setSdkResult--error = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
    int m;
    if (paramInt != 110405)
    {
      m = paramInt;
      if (paramInt != 110513) {}
    }
    else
    {
      m = 0;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", m);
    localIntent.putExtra("key_error_msg", paramString2);
    localIntent.putExtra("key_error_detail", paramString3);
    localIntent.putExtra("key_response", paramString1);
    if (getActivity() != null)
    {
      getActivity().setResult(-1, localIntent);
      getActivity().finish();
    }
    if (!this.jdField_g_of_type_Boolean) {
      h();
    }
    if (m != 0)
    {
      paramString1 = new HashMap();
      paramString1.put("appid", c());
      paramString1.put("errorcode", m + "");
      paramString1.put("errormsg", paramString2);
      paramString1.put("errordetail", paramString3);
      paramString2 = AppNetConnInfo.getRecentNetworkInfo();
      if (paramString2 != null)
      {
        if (paramString2.getType() == 1) {
          paramString1.put("network", "wifi");
        }
      }
      else
      {
        bctj.a(BaseApplicationImpl.getApplication()).a(this.jdField_b_of_type_JavaLangString, "connect_sso_authfail", false, 0L, 0L, paramString1, "");
        label272:
        if (m != 0) {
          break label512;
        }
      }
    }
    label512:
    for (paramString1 = "0";; paramString1 = "1")
    {
      ForwardUtils.a(m, c(), this.jdField_b_of_type_JavaLangString);
      if (this.jdField_g_of_type_Boolean) {
        bipr.a(this.jdField_b_of_type_JavaLangString, "", c(), "1", "9", paramString1, true);
      }
      if ((this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface != null) && (this.jdField_b_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) && (!this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))) {
        bipr.a(this.jdField_b_of_type_JavaLangString, "", c(), "1", "10", paramString1, true);
      }
      return;
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
        bipr.a(this.jdField_b_of_type_JavaLangString, "", c(), "1", "6", "0", false);
        break label272;
      }
    }
  }
  
  public void b(String paramString)
  {
    if ((TextUtils.isEmpty(c())) || (TextUtils.isEmpty(this.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString)))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "updateUinOpenIDStore realAppId=", c(), ", mAccount.uin=", this.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString });
      return;
    }
    SharedPreferences.Editor localEditor = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString(paramString, this.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString);
    localEditor.putString(c() + ":" + this.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString, paramString);
    localEditor.commit();
  }
  
  public void b(String paramString1, String paramString2)
  {
    bctj.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, paramString1, c() + "|" + paramString2 + "|" + this.jdField_a_of_type_JavaLangString);
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
    localHashMap.put("appid", c());
    if (this.jdField_b_of_type_Boolean)
    {
      str = "notlogged";
      localHashMap.put("p1", str);
      if (!this.jdField_c_of_type_Boolean) {
        break label90;
      }
    }
    label90:
    for (String str = "auth";; str = "uauth")
    {
      localHashMap.put("p2", str);
      bctj.a(BaseApplicationImpl.getApplication()).a(this.jdField_b_of_type_JavaLangString, "connect_sso_backto3rd", false, 0L, 0L, localHashMap, "");
      return;
      str = "logged";
      break;
    }
  }
  
  public void c(String paramString)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->showLoginActivity--uin = *" + bipr.a(this.jdField_b_of_type_JavaLangString));
    if (getActivity() != null)
    {
      Intent localIntent = new Intent(getActivity(), Login.class);
      if (paramString != null) {
        localIntent.putExtra("param_uin", paramString);
      }
      localIntent.putExtra("appid", c());
      super.startActivityForResult(localIntent, 1);
      return;
    }
    QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "showLoginActivity activity is null");
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Biyc == null) {
      f();
    }
  }
  
  protected void d(String paramString)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->LocalAccountCache--userAccount = *" + bipr.a(paramString));
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString("last_account", paramString);
    Object localObject2 = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null);
    if (localObject1 != null) {}
    for (localObject1 = ((String)localObject1).split(",");; localObject1 = null)
    {
      if (localObject1 != null)
      {
        int n = localObject1.length;
        int m = 0;
        while (m < n)
        {
          CharSequence localCharSequence = localObject1[m];
          if (!TextUtils.isEmpty(localCharSequence)) {
            ((ArrayList)localObject2).add(localCharSequence);
          }
          m += 1;
        }
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
  
  public void e()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->login--");
    this.jdField_d_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    if (!bgnt.g(getActivity()))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "login isNetworkAvailable false");
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
      g();
      return;
    }
    if (this.jdField_g_of_type_JavaLangString != null) {
      this.jdField_b_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
    }
    if (!bipr.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_b_of_type_JavaLangString))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "send | cmd: g_t_n_p | uin : *" + bipr.a(this.jdField_b_of_type_JavaLangString));
      aukw.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      AccountManage.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverSSOAccountObserver, c(), AccountManage.RefreshReason.useCacheFirst);
      this.jdField_a_of_type_Bipn.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Biau.a(getResources().getString(2131694135));
      if ((!getActivity().isFinishing()) && (!this.jdField_a_of_type_Biau.isShowing())) {}
      try
      {
        this.jdField_a_of_type_Biau.show();
        a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_b_of_type_JavaLangString));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->login(), mProgress.show();", localException);
        }
      }
    }
    g();
  }
  
  protected void f()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->startAccountActivity--");
    if (!bivh.a())
    {
      a(true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("appid", c());
      localHashMap.put("p1", "notlogged");
      localHashMap.put("p2", "uauth");
      bctj.a(BaseApplicationImpl.getApplication()).a(this.jdField_b_of_type_JavaLangString, "connect_sso_pageview", false, System.currentTimeMillis() - this.jdField_a_of_type_Long, 0L, localHashMap, "");
      return;
    }
    e();
  }
  
  protected void g()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->loginSSO--");
    this.jdField_a_of_type_Biau.a(super.getString(2131694141));
    if ((!getActivity().isFinishing()) && (!this.jdField_a_of_type_Biau.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Biau.show();
      if (this.jdField_b_of_type_JavaLangString != null) {
        if (bipr.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_b_of_type_JavaLangString))
        {
          c(this.jdField_b_of_type_JavaLangString);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->loginSSO(), mProgress.show();", localException);
      }
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "send | cmd: g_t_n_p | uin :*" + bipr.a(this.jdField_b_of_type_JavaLangString));
      aukw.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      AccountManage.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverSSOAccountObserver, c(), AccountManage.RefreshReason.useCacheFirst);
      this.jdField_a_of_type_Bipn.jdField_a_of_type_Long = System.currentTimeMillis();
      a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_b_of_type_JavaLangString));
      return;
    }
    a(true);
    this.jdField_b_of_type_Boolean = true;
    b("wtl_notlogged", "0");
  }
  
  public void h()
  {
    if (getActivity() == null) {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, " dismissDialogProgress activity is null");
    }
    while ((getActivity().isFinishing()) || (this.jdField_a_of_type_Biau == null) || (!this.jdField_a_of_type_Biau.isShowing())) {
      return;
    }
    try
    {
      this.jdField_a_of_type_Biau.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void i()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onBackPressed");
    getActivity().setResult(0);
    getActivity().finish();
    if (getActivity() != null)
    {
      getActivity().setResult(0);
      getActivity().finish();
    }
    c();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    if (getActivity() != null)
    {
      int m = getResources().getColor(2131165920);
      ColorStateList localColorStateList = getResources().getColorStateList(2131165920);
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(m);
        this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
      }
      return;
    }
    QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "updateTitleColor activity is null");
  }
  
  public void k()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->getVirtualList");
    this.jdField_h_of_type_Boolean = false;
    p();
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->onActivityCreated--");
    super.onActivityCreated(paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "--onActivityResult, requestCode: " + paramInt1 + " | resultCode:" + paramInt2 + " | data: " + paramIntent);
    if ((paramInt1 == 101) && (paramIntent != null) && (paramIntent.getIntExtra("createVirtualAccount", 0) == 1))
    {
      this.k = paramIntent.getLongExtra("createVirtualVid", 0L);
      k();
      h();
      if (paramInt2 != 0) {
        break label481;
      }
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        if (getActivity() != null)
        {
          getActivity().setResult(0, paramIntent);
          getActivity().finish();
        }
        c();
      }
      this.jdField_e_of_type_Long = SystemClock.elapsedRealtime();
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "<TimeStamp> login cost : " + (this.jdField_e_of_type_Long - this.jdField_d_of_type_Long));
    }
    label421:
    label481:
    do
    {
      do
      {
        return;
        if ((paramInt1 == 102) && (paramIntent != null))
        {
          paramInt1 = paramIntent.getIntExtra("key_cancel_auth", 0);
          int m = paramIntent.getIntExtra("key_error_code", 0);
          if (paramInt1 == 1) {
            if (getActivity() != null) {
              getActivity().setResult(0);
            }
          }
          for (;;)
          {
            if (getActivity() == null) {
              break label421;
            }
            getActivity().finish();
            break;
            if ((m == 0) && (this.jdField_d_of_type_Boolean))
            {
              bint.a().a(this.jdField_a_of_type_AndroidOsBundle, true);
            }
            else
            {
              localObject1 = paramIntent.getStringExtra("key_error_msg");
              localObject2 = paramIntent.getStringExtra("key_error_detail");
              String str = paramIntent.getStringExtra("key_response");
              QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "OpenVirtual.onActivityResult, error: ", Integer.valueOf(m), ", msg:", localObject1, ", detail:", localObject2, ", response=", str });
              Intent localIntent = new Intent();
              localIntent.putExtra("key_error_code", m);
              localIntent.putExtra("key_error_msg", (String)localObject1);
              localIntent.putExtra("key_error_detail", (String)localObject2);
              localIntent.putExtra("key_response", str);
              if (getActivity() != null) {
                getActivity().setResult(-1, localIntent);
              }
            }
          }
          break;
        }
        if (paramInt1 != 100) {
          break;
        }
        if (paramInt2 == -1)
        {
          if (paramIntent != null) {
            this.jdField_g_of_type_JavaLangString = paramIntent.getStringExtra("uin");
          }
          d();
          return;
        }
        if (getActivity() != null)
        {
          getActivity().setResult(0);
          getActivity().finish();
        }
        c();
        return;
      } while (-1 != paramInt2);
      this.jdField_e_of_type_Long = SystemClock.elapsedRealtime();
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "<TimeStamp> login cost : " + (this.jdField_e_of_type_Long - this.jdField_d_of_type_Long));
      this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      a(paramIntent);
    } while (paramIntent == null);
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("last_account");
    boolean bool = paramIntent.getBooleanExtra("isLogin", false);
    Object localObject1 = new WloginSimpleInfo();
    if (this.jdField_a_of_type_MqqManagerWtloginManager != null)
    {
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.jdField_b_of_type_JavaLangString, (WloginSimpleInfo)localObject1);
      this.jdField_b_of_type_JavaLangString = Long.toString(((WloginSimpleInfo)localObject1)._uin);
    }
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(1);
    a(this.jdField_b_of_type_JavaLangString);
    if (bool)
    {
      d(this.jdField_b_of_type_JavaLangString);
      bipr.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.jdField_b_of_type_JavaLangString);
    }
    Object localObject2 = paramIntent.getBundleExtra("ssobundle");
    if (localObject2 != null)
    {
      localObject1 = ((Bundle)localObject2).getByteArray("st_temp");
      localObject2 = ((Bundle)localObject2).getByteArray("st_temp_key");
      if ((localObject1 != null) && (localObject2 != null))
      {
        this.jdField_a_of_type_Biyc.jdField_a_of_type_ArrayOfByte = ((byte[])localObject1);
        this.jdField_a_of_type_Biyc.jdField_b_of_type_ArrayOfByte = ((byte[])localObject2);
      }
    }
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(5);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(11);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_Bine.a(null, this.jdField_b_of_type_JavaLangString);
    if ((paramIntent.getBooleanExtra("fromLoginPhoneNum", false)) && (this.jdField_a_of_type_Biyc != null) && (this.jdField_a_of_type_Biyc.jdField_b_of_type_ArrayOfByte == null))
    {
      e();
      return;
    }
    this.jdField_a_of_type_Biyp.a(c(), this.jdField_a_of_type_Biyc);
    this.jdField_h_of_type_Boolean = false;
    n();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_c_of_type_AndroidWidgetTextView)
    {
      if (getActivity() != null)
      {
        getActivity().setResult(0);
        getActivity().finish();
      }
      c();
    }
    long l;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView != this.jdField_a_of_type_AndroidWidgetButton) {
        break label911;
      }
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "<user:>authorize btn is clicked");
      l = System.currentTimeMillis();
      try
      {
        if (l - this.jdField_c_of_type_Long < 500L)
        {
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick btn repeat click");
          continue;
        }
      }
      finally {}
      this.jdField_c_of_type_Long = l;
      if (!bgnt.g(getActivity()))
      {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick isNetworkAvailable false");
        this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      else if ((this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_Biyc == null))
      {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick mGetTicketFailed || mAccount == null");
        e();
      }
      else if (this.jdField_a_of_type_Int == 0)
      {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick mSsoRequest == 0");
        this.jdField_a_of_type_Biau.a(super.getString(2131694135));
        if ((!getActivity().isFinishing()) && (!this.jdField_a_of_type_Biau.isShowing())) {
          this.jdField_a_of_type_Biau.show();
        }
        m();
      }
      else if (this.jdField_a_of_type_AndroidWidgetButton.getTag().equals(super.getString(2131694134)))
      {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick get auth_api_list again");
        e();
      }
      else
      {
        aukw.a("KEY_LOGIN_STAGE_2_1_NEW_TOTAL", this.jdField_a_of_type_Biyc);
        if (this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse == null) {
          break;
        }
        aukw.a("KEY_LOGIN_STAGE_2_NEW_TOTAL", this.jdField_a_of_type_Biyc);
        aukw.a("KEY_LOGIN_STAGE_3_TOTAL");
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick null != mAuthResponse");
        localObject2 = this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
        ((Message)localObject2).what = 1;
        ((Message)localObject2).obj = this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse;
        this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject2);
        this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
        bipi.a().a(this.jdField_b_of_type_JavaLangString, "", c(), "1", "2", "0", false);
      }
    }
    int n = 0;
    Object localObject2 = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(c());
    int m = n;
    label442:
    Object localObject3;
    if (localObject2 != null)
    {
      m = n;
      if (!((List)localObject2).isEmpty())
      {
        localObject2 = ((List)localObject2).iterator();
        m = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bikw)((Iterator)localObject2).next();
          if ((((bikw)localObject3).jdField_a_of_type_Int != 2) && (((bikw)localObject3).jdField_a_of_type_Int != 3)) {
            break label941;
          }
          m = 1;
        }
      }
    }
    label784:
    label941:
    for (;;)
    {
      break label442;
      localObject3 = a();
      this.jdField_a_of_type_Biyp.a(c(), this.jdField_a_of_type_Biyc);
      this.jdField_a_of_type_Biyp.a(c(), this.jdField_a_of_type_AndroidOsBundle);
      if (m != 0)
      {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick to OpenSelectPermissionFragment");
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("appId", a());
        ((Intent)localObject2).putExtra("key_proxy_appid", b());
        ((Intent)localObject2).putExtra("vid", this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a());
        ((Intent)localObject2).putExtra("appName", this.jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthResponse.app_name.get());
        ((Intent)localObject2).putExtra("hasIcon", this.jdField_e_of_type_Boolean);
        ((Intent)localObject2).putExtra("login_cost", this.jdField_e_of_type_Long - this.jdField_d_of_type_Long);
        if (this.jdField_h_of_type_Long != 0L) {}
        for (l = this.jdField_h_of_type_Long;; l = SystemClock.elapsedRealtime())
        {
          ((Intent)localObject2).putExtra("authStartTime", l);
          ((Intent)localObject2).putExtra("authListCostTime", this.jdField_g_of_type_Long - this.jdField_f_of_type_Long);
          ((Intent)localObject2).putExtra("is_from_qr_login", this.jdField_d_of_type_Boolean);
          ((Intent)localObject2).putExtra("public_fragment_window_feature", 1);
          localObject3 = bipr.a(getActivity());
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((Intent)localObject2).putExtra("pkg_name", (String)localObject3);
          }
          aukw.a("KEY_LOGIN_STAGE_2_2_NEW_TOTAL");
          aevv.a(getActivity(), (Intent)localObject2, PublicFragmentActivityForOpenSDK.class, OpenSelectPermissionFragment.class, 102);
          break;
        }
      }
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick doAuthorize");
      if (this.jdField_d_of_type_Boolean)
      {
        m = 2;
        l = this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a();
        if (l != 0L) {
          break label903;
        }
      }
      for (localObject2 = "0X800A117";; localObject2 = "0X800A116")
      {
        bcst.b(null, "dc00898", "", "", (String)localObject2, (String)localObject2, m, 0, "", "", "", "");
        aukw.a("KEY_AUTHORIZE_REQUEST");
        aukw.a("KEY_LOGIN_STAGE_2_NEW_TOTAL", this.jdField_a_of_type_Biyc);
        aukw.a("KEY_LOGIN_STAGE_3_TOTAL");
        this.jdField_d_of_type_Int = 0;
        this.jdField_a_of_type_Biyp.a(this.jdField_d_of_type_Boolean, a(), b(), (List)localObject3, l, this.jdField_a_of_type_Bior, bipr.a(getActivity()), getActivity());
        break;
        m = 1;
        break label784;
      }
      if (paramView != this.jdField_a_of_type_AndroidWidgetTextView) {
        break;
      }
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick showAccountSheet");
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.e();
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131559669, paramViewGroup, false);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    aukw.a("KEY_LOGIN_STAGE_2_NEW_TOTAL");
    aukw.a("KEY_LOGIN_STAGE_2_1_NEW_TOTAL");
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->onCreateView");
    if (!(getActivity().getAppRuntime() instanceof OpenSDKAppInterface)) {}
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
      return paramViewGroup;
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getActivity().getAppRuntime());
      this.jdField_a_of_type_AndroidOsBundle = getActivity().getIntent().getBundleExtra("key_params");
      String str;
      if (this.jdField_a_of_type_AndroidOsBundle == null)
      {
        b(-5, "params is null", "params is null", "params is null");
      }
      else
      {
        this.jdField_a_of_type_Biyp = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a();
        this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_login_by_qr_scan", false);
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("client_id");
        this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("key_proxy_appid");
        this.jdField_i_of_type_Boolean = getActivity().getIntent().getBooleanExtra("internal_authority", false);
        this.jdField_g_of_type_Boolean = getActivity().getIntent().getBooleanExtra("authority_start_qq_login", false);
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onCreateView mIsInternalAuthority=", Boolean.valueOf(this.jdField_i_of_type_Boolean), ", mFromSdkLoginAuthority=", Boolean.valueOf(this.jdField_g_of_type_Boolean), ", mAuthAppId=", this.jdField_e_of_type_JavaLangString, ", mProxyAuthAppId=", this.jdField_f_of_type_JavaLangString });
        if (this.jdField_i_of_type_Boolean)
        {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount();
          str = System.currentTimeMillis() / 1000L + "";
          paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("package_name");
          paramLayoutInflater = this.jdField_a_of_type_AndroidOsBundle.getString("sign");
          paramBundle = paramBundle + "_" + paramLayoutInflater.replace(":", "").toLowerCase() + "_" + str;
        }
      }
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(paramBundle.getBytes());
        paramBundle = bgmj.a(localMessageDigest.digest());
        paramLayoutInflater = paramBundle;
      }
      catch (NoSuchAlgorithmException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          continue;
          if (getActivity().isChild()) {}
          for (paramLayoutInflater = getActivity().getParent();; paramLayoutInflater = getActivity())
          {
            this.jdField_a_of_type_Biau = new biau(paramLayoutInflater, getActivity().getTitleBarHeight());
            break;
          }
          m = 0;
        }
        if (Build.VERSION.SDK_INT < 17) {
          break label940;
        }
        m = Settings.Global.getInt(getActivity().getContentResolver(), "always_finish_activities", 0);
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          break label940;
        }
        boolean bool = a(this.jdField_b_of_type_JavaLangString);
        if ((m != 1) || (!bool)) {
          break label940;
        }
        this.jdField_j_of_type_Boolean = true;
        if (!this.jdField_j_of_type_Boolean) {
          break label1102;
        }
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("sign", paramLayoutInflater);
      this.jdField_a_of_type_AndroidOsBundle.putString("time", str);
      AccountManage.a().a();
      this.jdField_a_of_type_JavaUtilList = bivh.a();
      if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.isLogin()) {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount();
      }
      if ((this.jdField_b_of_type_JavaLangString == null) && (this.jdField_a_of_type_JavaUtilList != null)) {
        this.jdField_b_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilList.get(0));
      }
      paramLayoutInflater = getActivity().getIntent().getStringExtra("login_success_uin");
      if ((!TextUtils.isEmpty(paramLayoutInflater)) && (!paramLayoutInflater.equals(this.jdField_b_of_type_JavaLangString))) {
        this.jdField_b_of_type_JavaLangString = paramLayoutInflater;
      }
      a(paramViewGroup);
      paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("oauth_app_name");
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("sdkv");
      this.jdField_b_of_type_AndroidContentSharedPreferences = biyn.a(BaseApplicationImpl.getApplication(), "uin_openid_store");
      this.jdField_c_of_type_AndroidContentSharedPreferences = biyn.a(BaseApplicationImpl.getApplication(), "openid_encrytoken");
      if (!this.jdField_g_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_Biau = new biau(getActivity(), 0, 2131561463, 17);
      this.jdField_a_of_type_Biau.a(-1);
      if (paramBundle != null) {
        this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(paramBundle, null);
      }
      paramLayoutInflater = getActivity();
      if (Build.VERSION.SDK_INT <= 10) {
        break label874;
      }
      m = 4;
      this.jdField_a_of_type_AndroidContentSharedPreferences = paramLayoutInflater.getSharedPreferences("accountList", m);
      paramLayoutInflater = getActivity().getIntent().getStringExtra("key_action");
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
      if ((!this.jdField_i_of_type_Boolean) && (!"action_login".equals(paramLayoutInflater))) {
        break label1011;
      }
      this.jdField_a_of_type_Boolean = false;
      paramLayoutInflater = getActivity().getAppRuntime().getAccount();
      if ((this.jdField_i_of_type_Boolean) || (!GesturePWDUtils.getJumpLock(BaseApplicationImpl.getApplication(), paramLayoutInflater)) || (GesturePWDUtils.getAppForground(BaseApplicationImpl.getApplication()))) {
        break label880;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 2, "-->onCreate--has gesture password, will start unlock activity");
      }
      this.jdField_g_of_type_JavaLangString = paramLayoutInflater;
      paramLayoutInflater = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      paramLayoutInflater.putExtra("key_gesture_from_authority", true);
      super.startActivityForResult(paramLayoutInflater, 100);
    }
    label874:
    label880:
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_b_of_type_JavaLangString));
    }
    label940:
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    b(this.jdField_b_of_type_JavaLangString, false);
    label1011:
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(1);
    bipr.a(this.jdField_b_of_type_JavaLangString, "", c(), "1", "1", "0", false);
    if (this.jdField_d_of_type_Boolean) {}
    for (int m = 2;; m = 1)
    {
      bcst.b(null, "dc00898", "", "", "0X800A115", "0X800A115", m, 0, "", "", "", "");
      if (this.jdField_g_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a();
      }
      break;
      label1102:
      d();
      break label1011;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    h();
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->onDestroy--");
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void onResume()
  {
    super.onResume();
    ImmersiveUtils.a(true, getActivity().getWindow());
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.c();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment
 * JD-Core Version:    0.7.0.1
 */