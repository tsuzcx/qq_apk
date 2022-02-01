package com.tencent.open.agent;

import android.app.Activity;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.AppInfo;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.OpenSdkQIPCClient;
import com.tencent.open.agent.authority.AuthCallback;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.AuthCmdCost.Record;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.AvatarUpdateService;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpImageDownloadAsyncTask.TaskCompleteCallback;
import com.tencent.open.data.SharedPrefs;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.model.AccountManage;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.open.model.VirtualInfo;
import com.tencent.open.settings.OpensdkPreference;
import com.tencent.open.virtual.OpenSdkVirtualManager;
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
  implements View.OnClickListener, HttpImageDownloadAsyncTask.TaskCompleteCallback
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  protected Handler.Callback a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public OpenCardContainer.OnDeleteVirtualListener a;
  private OpenCardContainer jdField_a_of_type_ComTencentOpenAgentOpenCardContainer;
  public AuthCallback a;
  private ReportDef.AuthCmdCost.Record jdField_a_of_type_ComTencentOpenAgentReportReportDef$AuthCmdCost$Record = new ReportDef.AuthCmdCost.Record();
  private AccountInfo jdField_a_of_type_ComTencentOpenModelAccountInfo = null;
  private OpenSdkVirtualManager jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager = null;
  private preAuth.PreAuthResponse jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthResponse;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  protected HandlerPlus a;
  protected Runnable a;
  protected String a;
  private List<String> jdField_a_of_type_JavaUtilList;
  private WtloginManager jdField_a_of_type_MqqManagerWtloginManager;
  protected SSOAccountObserver a;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  private SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = null;
  private SSOAccountObserver jdField_b_of_type_MqqObserverSSOAccountObserver;
  private boolean jdField_b_of_type_Boolean = false;
  private final int jdField_c_of_type_Int = 1000;
  private long jdField_c_of_type_Long = 0L;
  private SharedPreferences jdField_c_of_type_AndroidContentSharedPreferences;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = false;
  private long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private long jdField_g_of_type_Long;
  private String jdField_g_of_type_JavaLangString = null;
  private boolean jdField_g_of_type_Boolean = false;
  private long jdField_h_of_type_Long;
  private boolean jdField_h_of_type_Boolean;
  private long jdField_i_of_type_Long;
  private boolean jdField_i_of_type_Boolean;
  private long jdField_j_of_type_Long = 0L;
  private boolean jdField_j_of_type_Boolean;
  private long jdField_k_of_type_Long = 0L;
  private boolean jdField_k_of_type_Boolean;
  
  public OpenAuthorityFragment()
  {
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new OpenAuthorityFragment.1(this);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangRunnable = new OpenAuthorityFragment.6(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new OpenAuthorityFragment.8(this);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus = new HandlerPlus(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback = new OpenAuthorityFragment.12(this);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$OnDeleteVirtualListener = new OpenAuthorityFragment.15(this);
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
  
  private List<CardContainer.Permission> a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(c());
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CardContainer.Permission localPermission1 = (CardContainer.Permission)((Iterator)localObject).next();
        CardContainer.Permission localPermission2 = new CardContainer.Permission();
        localPermission2.jdField_b_of_type_JavaLangString = localPermission1.jdField_b_of_type_JavaLangString;
        localPermission2.jdField_a_of_type_Int = localPermission1.jdField_a_of_type_Int;
        localPermission2.jdField_b_of_type_Int = localPermission1.jdField_b_of_type_Int;
        localPermission2.jdField_a_of_type_Boolean = localPermission1.jdField_a_of_type_Boolean;
        localPermission2.jdField_a_of_type_JavaLangString = localPermission1.jdField_a_of_type_JavaLangString;
        localPermission2.jdField_b_of_type_Boolean = true;
        localArrayList.add(localPermission2);
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    Object localObject = c();
    localObject = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a((String)localObject);
    this.jdField_b_of_type_MqqObserverSSOAccountObserver = this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, ((AccountInfo)localObject).jdField_a_of_type_JavaLangString, c(), 3, new OpenAuthorityFragment.13(this, paramInt));
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
        localObject = new AccountInfo();
        ((AccountInfo)localObject).jdField_a_of_type_JavaLangString = localJSONObject.getString("uin");
        ((AccountInfo)localObject).jdField_b_of_type_JavaLangString = localJSONObject.getString("skey");
        ((AccountInfo)localObject).jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp");
        ((AccountInfo)localObject).jdField_b_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp_key");
        paramIntent = AuthorityUtil.a(((AccountInfo)localObject).jdField_a_of_type_JavaLangString);
        if (((AccountInfo)localObject).jdField_b_of_type_JavaLangString != null) {
          bool = true;
        }
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "uin", paramIntent, "key valid=", Boolean.valueOf(bool) });
        if ((((AccountInfo)localObject).jdField_a_of_type_JavaLangString != null) && (((AccountInfo)localObject).jdField_b_of_type_JavaLangString != null))
        {
          this.jdField_a_of_type_ComTencentOpenModelAccountInfo = ((AccountInfo)localObject);
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
  
  private boolean a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    return (localFragmentActivity != null) && (!localFragmentActivity.isFinishing());
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "handle110509 mIn110509Retry=", Boolean.valueOf(this.jdField_i_of_type_Boolean), ", errorCode=", Integer.valueOf(paramInt1), ", triggerReason=", Integer.valueOf(paramInt2), "mAccount=", this.jdField_a_of_type_ComTencentOpenModelAccountInfo });
    if ((paramInt1 != 110509) || (this.jdField_a_of_type_ComTencentOpenModelAccountInfo == null)) {
      return false;
    }
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_i_of_type_Boolean = false;
      c(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString);
      return true;
    }
    this.jdField_i_of_type_Boolean = true;
    a(paramInt2);
    return true;
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "handle110537 mIn110537Retry=", Boolean.valueOf(this.jdField_h_of_type_Boolean), ", errorCode=", Integer.valueOf(paramInt), ", isGetVirtualList=", Boolean.valueOf(paramBoolean), "mAccount=", this.jdField_a_of_type_ComTencentOpenModelAccountInfo });
    if ((paramInt != 110537) || (this.jdField_a_of_type_ComTencentOpenModelAccountInfo == null)) {
      return false;
    }
    OpenSdkQIPCClient.a(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString);
    if ((this.jdField_h_of_type_Boolean) || (AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, false) == null))
    {
      this.jdField_h_of_type_Boolean = false;
      c(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString);
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
    if (TextUtils.isEmpty(paramString))
    {
      String str = String.format(super.getString(2131694667), new Object[] { Integer.valueOf(paramInt) });
      AuthorityUtil.a(getActivity(), str, new OpenAuthorityFragment.10(this));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(getString(2131694670));
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
    for (paramString = String.format(super.getString(2131694667), new Object[] { Integer.valueOf(paramInt) });; paramString = String.format(super.getString(2131696476), new Object[] { paramString, Integer.valueOf(paramInt) }))
    {
      AuthorityUtil.a(getActivity(), paramString, new OpenAuthorityFragment.11(this, paramInt, localJSONObject));
      return;
    }
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
        break label116;
      }
      localHashMap.put("network", "wifi");
    }
    for (;;)
    {
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(this.jdField_b_of_type_JavaLangString, "connect_sso_authfail", false, 0L, 0L, localHashMap, "");
      AuthReporter.a(this.jdField_b_of_type_JavaLangString, "0X800B65F");
      return;
      label116:
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
    ((ImmersiveTitleBar2)this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131379533)).resetBkColor(0);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131369534));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131369518));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690800);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131369487).setOnClickListener(this);
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
    if (this.jdField_a_of_type_ComTencentOpenModelAccountInfo == null)
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "queryAuthorityUseCache mAccount is null");
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = getActivity().getIntent().getBundleExtra("key_params");
    preAuth.PreAuthResponse localPreAuthResponse = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(c());
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->queryAuthorityUseCache use cache preAuth.PreAuthResponse");
    if (localPreAuthResponse == null)
    {
      this.jdField_h_of_type_Boolean = false;
      this.jdField_i_of_type_Boolean = false;
      n();
      return;
    }
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
    if (!NetworkUtil.g(BaseApplicationImpl.getApplication()))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->updatePreAuthFromServer isNetworkAvailable false--");
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    if (this.jdField_a_of_type_ComTencentOpenModelAccountInfo == null)
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
    if ((this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_ArrayOfByte.length == 0))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->updatePreAuthFromServer mAccount.st == null || mAccount.st.length == 0");
      Message localMessage = this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
      localMessage.what = 6;
      localMessage.arg1 = 3000;
      localMessage.obj = getResources().getString(2131694670);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
      return;
    }
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(a(), c(), getActivity(), AuthorityUtil.a(getActivity()), this.jdField_a_of_type_AndroidOsBundle, new OpenAuthorityFragment.7(this));
  }
  
  private void o()
  {
    if (!a())
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "getAppInfo return for activity is finished");
      return;
    }
    this.jdField_a_of_type_Int = 2;
    AppInfo localAppInfo = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(c());
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "getAppInfo use cached appid=", c(), ", appInfo=", localAppInfo });
    Message localMessage = this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    localMessage.what = 3;
    localMessage.obj = localAppInfo;
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
  }
  
  private void p()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->getVirtualListFromServer");
    if (!NetworkUtil.g(BaseApplicationImpl.getApplication()))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->getVirtualList isNetworkAvailable false");
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(a(), c(), getActivity(), AuthorityUtil.a(getActivity()), this.jdField_a_of_type_AndroidOsBundle, new OpenAuthorityFragment.14(this));
  }
  
  protected void a()
  {
    Object localObject = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, (WloginSimpleInfo)localObject);
    String str = new String(((WloginSimpleInfo)localObject)._nick);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, (String)localObject, null, false);
    b();
  }
  
  protected void a(int paramInt, String paramString)
  {
    Message localMessage = this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    localMessage.what = 6;
    localMessage.arg1 = 3004;
    localMessage.obj = paramString;
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, String paramString3)
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
    this.jdField_c_of_type_JavaLangString = ((String)super.getText(2131694674));
    this.jdField_d_of_type_JavaLangString = ((String)super.getText(2131694664));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131372545));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364546));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer = ((OpenCardContainer)paramView.findViewById(2131364461));
    if (this.jdField_j_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setTag(Boolean.valueOf(this.jdField_j_of_type_Boolean));
    }
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setOnUpdateStatusBarListener(new OpenAuthorityFragment.3(this));
    l();
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_d_of_type_JavaLangString = ((String)super.getText(2131694665));
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidWidgetButton.setTag(this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131372269).setVisibility(8);
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
          OpenCardContainer.VirtualAccountInfo localVirtualAccountInfo = new OpenCardContainer.VirtualAccountInfo(localVirtualInfo.jdField_a_of_type_Long, localVirtualInfo.jdField_a_of_type_JavaLangString, localVirtualInfo.jdField_b_of_type_JavaLangString);
          if (localVirtualInfo.jdField_a_of_type_Long == l) {
            localVirtualAccountInfo.jdField_a_of_type_Boolean = true;
          }
          paramView.add(localVirtualAccountInfo);
        }
        this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter.a(paramView, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount());
      }
    }
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setCreateVirtualListner(new OpenAuthorityFragment.4(this));
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setOndeleteVirtualListener(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$OnDeleteVirtualListener);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setOnAccountEventListener(new OpenAuthorityFragment.5(this));
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setCurrentAppid(c());
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  protected void a(String paramString)
  {
    if ((this.jdField_j_of_type_Boolean) || (TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {
      return;
    }
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(paramString, localWloginSimpleInfo);
    Object localObject2 = new String(localWloginSimpleInfo._nick);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramString;
    }
    this.jdField_b_of_type_JavaLangString = Long.toString(localWloginSimpleInfo._uin);
    paramString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(paramString, (int)(58.0F * this.jdField_a_of_type_Float), true);
    if (paramString != null)
    {
      localObject2 = AuthorityUtil.a(getActivity(), paramString, 63, 63);
      paramString.recycle();
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(this.jdField_b_of_type_JavaLangString, (String)localObject1, (Bitmap)localObject2, false);
      return;
    }
    ThreadManager.executeOnSubThread(new OpenAuthorityFragment.2(this, (String)localObject1));
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    LogUtility.c("SDK_LOGIN.OpenAuthorityFragment", "-->onTaskCompleted identifier = " + paramString + " - b = " + paramBitmap);
    if ((this.jdField_a_of_type_ComTencentOpenModelAccountInfo != null) && (paramString.equals(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString)))
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
  
  protected void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      SharedPreferences.Editor localEditor = this.jdField_c_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
    }
  }
  
  protected void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->loginSuccess--userAccount = *", AuthorityUtil.a(paramString1) });
    if (!this.jdField_j_of_type_Boolean) {
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(5);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    paramString1 = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
    AccountInfo localAccountInfo = new AccountInfo();
    localAccountInfo.jdField_a_of_type_JavaLangString = paramString1;
    localAccountInfo.jdField_b_of_type_JavaLangString = paramString2;
    if (paramBundle != null)
    {
      localAccountInfo.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp");
      localAccountInfo.jdField_b_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp_key");
    }
    this.jdField_a_of_type_ComTencentOpenModelAccountInfo = localAccountInfo;
    this.jdField_b_of_type_JavaLangString = paramString1;
    ForwardStatisticsReporter.a("KEY_LOGIN_STAGE_1_TOTAL", paramString1, this.jdField_a_of_type_Long, null, true);
    ForwardStatisticsReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
    paramString1 = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(c());
    if ((paramString1 == null) || (!paramString1.jdField_a_of_type_JavaLangString.equals(localAccountInfo.jdField_a_of_type_JavaLangString))) {
      if (paramString1 != null) {
        break label335;
      }
    }
    label335:
    for (paramString1 = "null";; paramString1 = AuthorityUtil.a(paramString1.jdField_a_of_type_JavaLangString))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "--loginSuccess, changeAccount old uin=", paramString1, ", new uin=", AuthorityUtil.a(localAccountInfo.jdField_a_of_type_JavaLangString) });
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(c(), this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
      k();
      if (this.jdField_e_of_type_Int != 1) {
        break;
      }
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "loginSuccess============= mSKeyErrorStep == AUTHORIZE_DONE");
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager.a(this.jdField_d_of_type_Boolean, a(), b(), new ArrayList(), this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(), this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback, AuthorityUtil.a(getActivity()), getActivity());
      return;
    }
    m();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "changeAccountLogin account=", AuthorityUtil.a(paramString), ", canAutoLogin=", Boolean.valueOf(paramBoolean) });
    if (!NetworkUtil.g(BaseApplicationImpl.getApplication()))
    {
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    if (AuthorityUtil.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString)) {
      c(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "send | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString));
      ForwardStatisticsReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      AccountManage.a().a(paramString, this.jdField_a_of_type_MqqObserverSSOAccountObserver, c(), 1);
      AuthorityUtil.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, paramString);
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
      localIntent2.putExtra("param_qr_code_url", getActivity().getIntent().getStringExtra("param_qr_code_url"));
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
      localIntent2.putExtra("param_qr_code_url", getActivity().getIntent().getStringExtra("param_qr_code_url"));
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
    AvatarUpdateService.a().a(getActivity(), this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString), this);
  }
  
  protected void b(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    ForwardUtils.a(paramInt, this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->setSdkResult--error = " + paramInt);
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
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(this.jdField_b_of_type_JavaLangString, "connect_sso_authfail", false, 0L, 0L, paramString1, "");
        label261:
        if (m != 0) {
          break label520;
        }
        paramString1 = "0";
        label270:
        ForwardUtils.a(m, c(), this.jdField_b_of_type_JavaLangString);
        if (this.jdField_g_of_type_Boolean) {
          AuthorityUtil.a(this.jdField_b_of_type_JavaLangString, "", c(), "1", "9", paramString1, true);
        }
        if ((this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface != null) && (this.jdField_b_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) && (!this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))) {
          AuthorityUtil.a(this.jdField_b_of_type_JavaLangString, "", c(), "1", "10", paramString1, true);
        }
        if (m != 0) {
          break label527;
        }
      }
    }
    label520:
    label527:
    for (paramString1 = "0X800B65E";; paramString1 = "0X800B65F")
    {
      AuthReporter.a(this.jdField_b_of_type_JavaLangString, paramString1);
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
        AuthorityUtil.a(this.jdField_b_of_type_JavaLangString, "", c(), "1", "6", "0", false);
        break label261;
        paramString1 = "1";
        break label270;
      }
    }
  }
  
  protected void b(String paramString)
  {
    if ((TextUtils.isEmpty(c())) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString)))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "updateUinOpenIDStore realAppId=", c(), ", mAccount.uin=", this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString });
      return;
    }
    SharedPreferences.Editor localEditor = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString(paramString, this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString);
    localEditor.putString(c() + ":" + this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, paramString);
    localEditor.commit();
  }
  
  protected void b(String paramString1, String paramString2)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).reportToAds(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, paramString1, c() + "|" + paramString2 + "|" + this.jdField_a_of_type_JavaLangString);
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
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(this.jdField_b_of_type_JavaLangString, "connect_sso_backto3rd", false, 0L, 0L, localHashMap, "");
      return;
      str = "logged";
      break;
    }
  }
  
  protected void c(String paramString)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->showLoginActivity--uin = *" + AuthorityUtil.a(this.jdField_b_of_type_JavaLangString));
    if (getActivity() != null)
    {
      Intent localIntent = new Intent(getActivity(), Login.class);
      if (paramString != null) {
        localIntent.putExtra("param_uin", paramString);
      }
      localIntent.putExtra("appid", c());
      localIntent.putExtra("param_qr_code_url", getActivity().getIntent().getStringExtra("param_qr_code_url"));
      super.startActivityForResult(localIntent, 1);
      return;
    }
    QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "showLoginActivity activity is null");
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentOpenModelAccountInfo == null) {
      f();
    }
  }
  
  protected void d(String paramString)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->LocalAccountCache--userAccount = *" + AuthorityUtil.a(paramString));
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
  
  protected void e()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->login--");
    this.jdField_d_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    if (!NetworkUtil.g(getActivity()))
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
    if (!AuthorityUtil.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_b_of_type_JavaLangString))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "send | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(this.jdField_b_of_type_JavaLangString));
      ForwardStatisticsReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      AccountManage.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverSSOAccountObserver, c(), 1);
      this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$AuthCmdCost$Record.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getResources().getString(2131694671));
      if ((!getActivity().isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
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
    if (!SharedPrefs.a())
    {
      a(true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("appid", c());
      localHashMap.put("p1", "notlogged");
      localHashMap.put("p2", "uauth");
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(this.jdField_b_of_type_JavaLangString, "connect_sso_pageview", false, System.currentTimeMillis() - this.jdField_a_of_type_Long, 0L, localHashMap, "");
      return;
    }
    e();
  }
  
  protected void g()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->loginSSO--");
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(super.getString(2131694677));
    if ((!getActivity().isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      if (this.jdField_b_of_type_JavaLangString != null) {
        if (AuthorityUtil.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_b_of_type_JavaLangString))
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
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "send | cmd: g_t_n_p | uin :*" + AuthorityUtil.a(this.jdField_b_of_type_JavaLangString));
      ForwardStatisticsReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      AccountManage.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverSSOAccountObserver, c(), 1);
      this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$AuthCmdCost$Record.jdField_a_of_type_Long = System.currentTimeMillis();
      a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_b_of_type_JavaLangString));
      return;
    }
    a(true);
    this.jdField_b_of_type_Boolean = true;
    b("wtl_notlogged", "0");
  }
  
  protected void h()
  {
    if (getActivity() == null) {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, " dismissDialogProgress activity is null");
    }
    while ((getActivity().isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      return;
    }
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
      int m = getResources().getColor(2131165952);
      ColorStateList localColorStateList = getResources().getColorStateList(2131165952);
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
    this.jdField_i_of_type_Boolean = false;
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
    if ((paramInt1 == 101) && (paramIntent != null))
    {
      paramInt1 = paramIntent.getIntExtra("createVirtualAccount", 0);
      if (paramInt1 == 1)
      {
        this.jdField_k_of_type_Long = paramIntent.getLongExtra("createVirtualVid", 0L);
        k();
      }
    }
    label201:
    label485:
    label487:
    do
    {
      do
      {
        break label201;
        break label201;
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "--onActivityResult, CreateVirtualAccount code = " + this.jdField_b_of_type_JavaLangString);
        do
        {
          for (;;)
          {
            h();
            if (paramInt2 != 0) {
              break label545;
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
            return;
            if (paramInt1 != 2) {
              break;
            }
            c(this.jdField_b_of_type_JavaLangString);
            break;
            if ((paramInt1 != 102) || (paramIntent == null)) {
              break label487;
            }
            paramInt1 = paramIntent.getIntExtra("key_cancel_auth", 0);
            int m = paramIntent.getIntExtra("key_error_code", 0);
            if (paramIntent.getIntExtra("key_need_login", 0) == 1)
            {
              QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "OpenVirtual.onActivityResult  REQUEST_CODE_SELECT_PERMISSION needLogin ");
              c(this.jdField_b_of_type_JavaLangString);
              return;
            }
            if (paramInt1 == 1) {
              if (getActivity() != null) {
                getActivity().setResult(0);
              }
            }
            for (;;)
            {
              if (getActivity() == null) {
                break label485;
              }
              getActivity().finish();
              break;
              if ((m == 0) && (this.jdField_d_of_type_Boolean))
              {
                QrAgentLoginManager.a().a(this.jdField_a_of_type_AndroidOsBundle, true);
              }
              else
              {
                localObject1 = paramIntent.getStringExtra("key_error_msg");
                localObject2 = paramIntent.getStringExtra("key_error_detail");
                String str = paramIntent.getStringExtra("key_response");
                QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "OpenVirtual.onActivityResult, error: ", Integer.valueOf(m), ", msg:", localObject1, ", detail:", localObject2 });
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
          }
        } while (paramInt1 != 100);
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
      } while ((-1 != paramInt2) || (AuthorityUtil.a(getActivity(), paramIntent)));
      this.jdField_e_of_type_Long = SystemClock.elapsedRealtime();
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "<TimeStamp> login cost : " + (this.jdField_e_of_type_Long - this.jdField_d_of_type_Long));
      a(paramIntent);
    } while (paramIntent == null);
    label545:
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("last_account");
    boolean bool = paramIntent.getBooleanExtra("isLogin", false);
    Object localObject1 = new WloginSimpleInfo();
    if (this.jdField_a_of_type_MqqManagerWtloginManager != null)
    {
      this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(this.jdField_b_of_type_JavaLangString, (WloginSimpleInfo)localObject1);
      this.jdField_b_of_type_JavaLangString = Long.toString(((WloginSimpleInfo)localObject1)._uin);
    }
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(1);
    a(this.jdField_b_of_type_JavaLangString);
    if (bool)
    {
      d(this.jdField_b_of_type_JavaLangString);
      AuthorityUtil.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.jdField_b_of_type_JavaLangString);
    }
    Object localObject2 = paramIntent.getBundleExtra("ssobundle");
    if (localObject2 != null)
    {
      localObject1 = ((Bundle)localObject2).getByteArray("st_temp");
      localObject2 = ((Bundle)localObject2).getByteArray("st_temp_key");
      if ((localObject1 != null) && (localObject2 != null))
      {
        this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_ArrayOfByte = ((byte[])localObject1);
        this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_b_of_type_ArrayOfByte = ((byte[])localObject2);
      }
    }
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(5);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(11);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter.a(null, this.jdField_b_of_type_JavaLangString);
    if ((paramIntent.getBooleanExtra("fromLoginPhoneNum", false)) && (this.jdField_a_of_type_ComTencentOpenModelAccountInfo != null) && (this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_b_of_type_ArrayOfByte == null))
    {
      e();
      return;
    }
    this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager.a(c(), this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    if ((bool) || (this.jdField_f_of_type_Boolean))
    {
      this.jdField_f_of_type_Boolean = false;
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "hasQQD2=", Boolean.valueOf(AuthorityUtil.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface)) });
      this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager.a(this.jdField_b_of_type_JavaLangString);
    }
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
        break label883;
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
      if (!NetworkUtil.g(getActivity()))
      {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick isNetworkAvailable false");
        this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      else if ((this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_ComTencentOpenModelAccountInfo == null))
      {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick mGetTicketFailed || mAccount == null");
        e();
      }
      else if (this.jdField_a_of_type_Int == 0)
      {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick mSsoRequest == 0");
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(super.getString(2131694671));
        if ((!getActivity().isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        m();
      }
      else
      {
        if (!super.getString(2131694670).equals(this.jdField_a_of_type_AndroidWidgetButton.getTag())) {
          break;
        }
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick get auth_api_list again");
        e();
      }
    }
    ForwardStatisticsReporter.a("KEY_LOGIN_STAGE_2_1_NEW_TOTAL", this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
    int n = 0;
    Object localObject2 = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(c());
    int m = n;
    label342:
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
          localObject3 = (CardContainer.Permission)((Iterator)localObject2).next();
          if ((((CardContainer.Permission)localObject3).jdField_a_of_type_Int != 2) && (((CardContainer.Permission)localObject3).jdField_a_of_type_Int != 3)) {
            break label913;
          }
          m = 1;
        }
      }
    }
    label913:
    for (;;)
    {
      break label342;
      localObject3 = a();
      this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager.a(c(), this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
      this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager.a(c(), this.jdField_a_of_type_AndroidOsBundle);
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
          ((Intent)localObject2).putExtra("packagename", this.jdField_a_of_type_AndroidOsBundle.getString("packagename"));
          ((Intent)localObject2).putExtra("packagesign", this.jdField_a_of_type_AndroidOsBundle.getString("packagesign"));
          localObject3 = AuthorityUtil.a(getActivity());
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((Intent)localObject2).putExtra("pkg_name", (String)localObject3);
          }
          ForwardStatisticsReporter.a("KEY_LOGIN_STAGE_2_2_NEW_TOTAL");
          PublicFragmentActivity.Launcher.a(getActivity(), (Intent)localObject2, PublicFragmentActivityForOpenSDK.class, OpenSelectPermissionFragment.class, 102);
          ReportCenter.a().a(this.jdField_b_of_type_JavaLangString, "", c(), "1", "2", "0", false, true);
          break;
        }
      }
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick doAuthorize");
      if (this.jdField_d_of_type_Boolean)
      {
        m = 2;
        label749:
        l = this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a();
        if (l != 0L) {
          break label875;
        }
      }
      label875:
      for (localObject2 = "0X800A117";; localObject2 = "0X800A116")
      {
        ReportController.b(null, "dc00898", "", "", (String)localObject2, (String)localObject2, m, 0, "", "", "", "");
        ForwardStatisticsReporter.a("KEY_AUTHORIZE_REQUEST");
        ForwardStatisticsReporter.a("KEY_LOGIN_STAGE_2_NEW_TOTAL", this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
        ForwardStatisticsReporter.a("KEY_LOGIN_STAGE_3_TOTAL");
        this.jdField_d_of_type_Int = 0;
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager.a(this.jdField_d_of_type_Boolean, a(), b(), (List)localObject3, l, this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback, AuthorityUtil.a(getActivity()), getActivity());
        break;
        m = 1;
        break label749;
      }
      label883:
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
    paramViewGroup = paramLayoutInflater.inflate(2131559789, paramViewGroup, false);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ForwardStatisticsReporter.a("KEY_LOGIN_STAGE_2_NEW_TOTAL");
    ForwardStatisticsReporter.a("KEY_LOGIN_STAGE_2_1_NEW_TOTAL");
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
        this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a();
        this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_login_by_qr_scan", false);
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("client_id");
        this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("key_proxy_appid");
        this.jdField_j_of_type_Boolean = getActivity().getIntent().getBooleanExtra("internal_authority", false);
        this.jdField_g_of_type_Boolean = getActivity().getIntent().getBooleanExtra("authority_start_qq_login", false);
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onCreateView mIsInternalAuthority=", Boolean.valueOf(this.jdField_j_of_type_Boolean), ", mFromSdkLoginAuthority=", Boolean.valueOf(this.jdField_g_of_type_Boolean), ", mAuthAppId=", this.jdField_e_of_type_JavaLangString, ", mProxyAuthAppId=", this.jdField_f_of_type_JavaLangString });
        if (this.jdField_j_of_type_Boolean)
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
        paramBundle = HexUtil.bytes2HexStr(localMessageDigest.digest());
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
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramLayoutInflater, getActivity().getTitleBarHeight());
            break;
          }
          m = 0;
        }
        if (Build.VERSION.SDK_INT < 17) {
          break label877;
        }
        m = Settings.Global.getInt(getActivity().getContentResolver(), "always_finish_activities", 0);
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          break label877;
        }
        boolean bool = a(this.jdField_b_of_type_JavaLangString);
        if ((m != 1) || (!bool)) {
          break label877;
        }
        this.jdField_k_of_type_Boolean = true;
        if (!this.jdField_k_of_type_Boolean) {
          break label1072;
        }
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("sign", paramLayoutInflater);
      this.jdField_a_of_type_AndroidOsBundle.putString("time", str);
      this.jdField_a_of_type_JavaUtilList = SharedPrefs.a();
      this.jdField_b_of_type_JavaLangString = AuthorityUtil.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.jdField_a_of_type_JavaUtilList, getActivity().getIntent());
      AuthReporter.a(this.jdField_b_of_type_JavaLangString, "0X800B65C");
      a(paramViewGroup);
      paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("oauth_app_name");
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("sdkv");
      this.jdField_b_of_type_AndroidContentSharedPreferences = OpensdkPreference.a(BaseApplicationImpl.getApplication(), "uin_openid_store");
      this.jdField_c_of_type_AndroidContentSharedPreferences = OpensdkPreference.a(BaseApplicationImpl.getApplication(), "openid_encrytoken");
      if (!this.jdField_g_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), 0, 2131561558, 17);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(-1);
      if (paramBundle != null) {
        this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(paramBundle, null);
      }
      paramLayoutInflater = getActivity();
      if (Build.VERSION.SDK_INT <= 10) {
        break label811;
      }
      m = 4;
      this.jdField_a_of_type_AndroidContentSharedPreferences = paramLayoutInflater.getSharedPreferences("accountList", m);
      paramLayoutInflater = getActivity().getIntent().getStringExtra("key_action");
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
      if ((!this.jdField_j_of_type_Boolean) && (!"action_login".equals(paramLayoutInflater))) {
        break label948;
      }
      this.jdField_a_of_type_Boolean = false;
      paramLayoutInflater = getActivity().getAppRuntime().getAccount();
      if ((this.jdField_j_of_type_Boolean) || (!GesturePWDUtils.getJumpLock(BaseApplicationImpl.getApplication(), paramLayoutInflater)) || (GesturePWDUtils.getAppForground(BaseApplicationImpl.getApplication()))) {
        break label817;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 2, "-->onCreate--has gesture password, will start unlock activity");
      }
      this.jdField_g_of_type_JavaLangString = paramLayoutInflater;
      paramLayoutInflater = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      paramLayoutInflater.putExtra("key_gesture_from_authority", true);
      super.startActivityForResult(paramLayoutInflater, 100);
    }
    label811:
    label817:
    label877:
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_b_of_type_JavaLangString));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    b(this.jdField_b_of_type_JavaLangString, false);
    label948:
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(1);
    AuthorityUtil.a(this.jdField_b_of_type_JavaLangString, "", c(), "1", "1", "0", false);
    if (this.jdField_d_of_type_Boolean) {}
    for (int m = 2;; m = 1)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A115", "0X800A115", m, 0, "", "", "", "");
      AuthorityUtil.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, "0X800B934", new String[] { "", "", paramBundle, "" });
      if (this.jdField_g_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a();
      }
      break;
      label1072:
      d();
      break label948;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_b_of_type_MqqObserverSSOAccountObserver = null;
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
    ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.c();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment
 * JD-Core Version:    0.7.0.1
 */