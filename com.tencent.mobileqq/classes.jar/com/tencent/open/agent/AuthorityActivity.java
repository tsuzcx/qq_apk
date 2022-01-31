package com.tencent.open.agent;

import akkc;
import akkd;
import akke;
import akkf;
import akkg;
import akki;
import akkj;
import akkk;
import akkm;
import akkn;
import akko;
import akkw;
import android.annotation.TargetApi;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.NetworkInfo;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.AuthCmdCost.Record;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.AvatarUpdateService;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpImageDownloadAsyncTask.TaskCompleteCallback;
import com.tencent.open.data.SharedPrefs;
import com.tencent.open.model.AccountManage;
import com.tencent.open.settings.OpensdkPreference;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
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
import oicq.wlogin_sdk.tools.cryptor;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorityActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, HttpImageDownloadAsyncTask.TaskCompleteCallback
{
  protected static boolean a;
  public static final String b;
  public static String f;
  protected float a;
  public int a;
  public long a;
  protected SharedPreferences a;
  protected Bundle a;
  protected Handler.Callback a;
  public View a;
  public Button a;
  protected TextView a;
  public BounceScrollView a;
  protected QQProgressDialog a;
  public AuthorityActivity.AccountInfo a;
  public CardContainer a;
  private ReportDef.AuthCmdCost.Record jdField_a_of_type_ComTencentOpenAgentReportReportDef$AuthCmdCost$Record = new ReportDef.AuthCmdCost.Record();
  public SdkAuthorize.AuthorizeResponse a;
  public OpenSDKAppInterface a;
  public HandlerPlus a;
  public Runnable a;
  public String a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  protected List a;
  protected WtloginManager a;
  public SSOAccountObserver a;
  public int b;
  public long b;
  protected SharedPreferences b;
  public View b;
  protected TextView b;
  private ReportDef.AuthCmdCost.Record b;
  public Runnable b;
  public boolean b;
  public int c;
  protected long c;
  protected SharedPreferences c;
  private ReportDef.AuthCmdCost.Record c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  private ReportDef.AuthCmdCost.Record d;
  public String d;
  protected boolean d;
  public int e;
  public long e;
  protected String e;
  public boolean e;
  public int f;
  public long f;
  public boolean f;
  private int g;
  public long g;
  protected String g;
  public boolean g;
  public long h;
  protected String h = "";
  public boolean h;
  public long i;
  private String i;
  public boolean i;
  public boolean j;
  public boolean k;
  public boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  
  static
  {
    jdField_b_of_type_JavaLangString = AppConstants.aJ + "qqconnect/";
    jdField_a_of_type_Boolean = true;
  }
  
  public AuthorityActivity()
  {
    this.jdField_b_of_type_ComTencentOpenAgentReportReportDef$AuthCmdCost$Record = new ReportDef.AuthCmdCost.Record();
    this.jdField_c_of_type_ComTencentOpenAgentReportReportDef$AuthCmdCost$Record = new ReportDef.AuthCmdCost.Record();
    this.jdField_d_of_type_ComTencentOpenAgentReportReportDef$AuthCmdCost$Record = new ReportDef.AuthCmdCost.Record();
    this.jdField_b_of_type_Int = 6;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new akkc(this);
    this.jdField_a_of_type_JavaLangRunnable = new akkk(this);
    this.jdField_g_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler$Callback = new akko(this);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus = new HandlerPlus(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_b_of_type_JavaLangRunnable = new akkf(this);
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
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.d("AuthorityActivity", 1, "-->getbitmap decodeStream oom, url = " + paramString);
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_e_of_type_JavaLangString != null))
    {
      localObject = this.jdField_e_of_type_JavaLangString;
      if (this.jdField_e_of_type_JavaLangString.length() > 12) {
        localObject = this.jdField_e_of_type_JavaLangString.substring(0, 12) + "...";
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(getResources().getString(2131435585), new Object[] { localObject }));
    }
    Object localObject = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString, (WloginSimpleInfo)localObject);
    String str = new String(((WloginSimpleInfo)localObject)._nick);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString, (String)localObject, null, false);
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
    paramString1 = "0";
    if (paramInt != 0) {
      paramString1 = "1";
    }
    try
    {
      ReportCenter.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_f_of_type_JavaLangString, "1", "3", paramString1, true);
      label112:
      if (this.m) {}
      try
      {
        ReportCenter.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_f_of_type_JavaLangString, "1", "9", paramString1, true);
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          try
          {
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) && (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))) {
              ReportCenter.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_f_of_type_JavaLangString, "1", "10", paramString1, true);
            }
            return;
          }
          catch (Exception paramString1)
          {
            paramString1.printStackTrace();
            return;
          }
          paramString2 = paramString2;
          paramString2.printStackTrace();
        }
      }
    }
    catch (Exception paramString2)
    {
      break label112;
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject2 = new GetAppInfoProto.GetAppinfoRequest();
    this.jdField_a_of_type_Int = 2;
    ((GetAppInfoProto.GetAppinfoRequest)localObject2).client_id.set(paramLong);
    ((GetAppInfoProto.GetAppinfoRequest)localObject2).sdkp.set("android");
    if (Build.VERSION.RELEASE == null) {}
    for (Object localObject1 = "";; localObject1 = Build.VERSION.RELEASE)
    {
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).os.set((String)localObject1);
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).qqv.set(CommonDataAdapter.a().d());
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).setHasFlag(true);
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).need_ads.set(1);
      NewIntent localNewIntent = new NewIntent(this, OpensdkServlet.class);
      localNewIntent.setWithouLogin(true);
      localNewIntent.putExtra("uin", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString);
      byte[] arrayOfByte = ((GetAppInfoProto.GetAppinfoRequest)localObject2).toByteArray();
      localObject2 = "ConnAuthSvr.get_app_info";
      localObject1 = arrayOfByte;
      if (!this.j)
      {
        localObject1 = a(arrayOfByte);
        localObject2 = "ConnAuthSvr.get_app_info_emp";
      }
      localNewIntent.putExtra("data", (byte[])localObject1);
      localNewIntent.putExtra("cmd", (String)localObject2);
      localNewIntent.setObserver(new akkm(this));
      super.getAppRuntime().startServlet(localNewIntent);
      this.jdField_c_of_type_ComTencentOpenAgentReportReportDef$AuthCmdCost$Record.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_c_of_type_ComTencentOpenAgentReportReportDef$AuthCmdCost$Record.jdField_a_of_type_JavaLangString = ((String)localObject2);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      if (QLog.isColorLevel()) {
        QLog.i("AuthorityActivity", 2, "getAppInfo");
      }
      return;
    }
  }
  
  public void a(SdkAuthorize.GetAuthApiListRequest paramGetAuthApiListRequest)
  {
    if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    }
    this.j = false;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((SimpleAccount)((Iterator)localObject).next()).getUin().equals(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString)) {
          this.j = true;
        }
      }
    }
    NewIntent localNewIntent = new NewIntent(this, OpensdkServlet.class);
    localNewIntent.setWithouLogin(true);
    localNewIntent.putExtra("uin", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString);
    byte[] arrayOfByte = paramGetAuthApiListRequest.toByteArray();
    String str = "ConnAuthSvr.get_auth_api_list";
    Object localObject = "g_a_a_l";
    paramGetAuthApiListRequest = arrayOfByte;
    if (!this.j)
    {
      if ((this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_ArrayOfByte.length == 0))
      {
        paramGetAuthApiListRequest = this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
        paramGetAuthApiListRequest.what = 6;
        paramGetAuthApiListRequest.arg1 = 3000;
        paramGetAuthApiListRequest.obj = getResources().getString(2131435589);
        this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramGetAuthApiListRequest);
        return;
      }
      paramGetAuthApiListRequest = a(arrayOfByte);
      str = "ConnAuthSvr.get_auth_api_list_emp";
      localObject = "g_a_a_l_emp";
    }
    localNewIntent.putExtra("data", paramGetAuthApiListRequest);
    localNewIntent.putExtra("cmd", str);
    this.jdField_a_of_type_Int = 0;
    localNewIntent.setObserver(new akkj(this));
    super.getAppRuntime().startServlet(localNewIntent);
    this.jdField_b_of_type_ComTencentOpenAgentReportReportDef$AuthCmdCost$Record.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_ComTencentOpenAgentReportReportDef$AuthCmdCost$Record.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    QLog.d("AuthorityActivity", 1, "send | cmd: " + (String)localObject + " | uin : *" + AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString));
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
      localObject2 = AuthorityUtil.a(this, paramString, 63, 63);
      paramString.recycle();
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_a_of_type_JavaLangString, (String)localObject1, (Bitmap)localObject2, false);
      return;
    }
    ThreadManager.executeOnSubThread(new akkg(this, (String)localObject1));
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
        DialogUtil.b(this, 230).setMessageWithUrl(paramString).setTitle(super.getString(2131434119)).setPositiveButton(17039370, paramOnClickListener).show();
      }
    }
    return;
    label54:
    DialogUtil.b(this, 230).setMessageWithUrl(paramString).setTitle(super.getString(2131434119)).setPositiveButton(17039370, paramOnClickListener).show();
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    LogUtility.c("AuthorityActivity", "-->onTaskCompleted identifier = " + paramString + " - b = " + paramBitmap);
    if ((this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null) && (paramString.equals(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString)) && (paramBitmap != null)) {
      runOnUiThread(new akkw(this, paramBitmap));
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
  
  /* Error */
  public void a(String paramString1, String paramString2, long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 647	java/io/File
    //   6: dup
    //   7: getstatic 71	com/tencent/open/agent/AuthorityActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   10: invokespecial 648	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore 9
    //   15: aload 9
    //   17: invokevirtual 651	java/io/File:exists	()Z
    //   20: ifne +118 -> 138
    //   23: aload 9
    //   25: invokevirtual 654	java/io/File:mkdirs	()Z
    //   28: pop
    //   29: new 51	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   36: aload_1
    //   37: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 656
    //   43: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_2
    //   47: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 660	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_2
    //   57: new 647	java/io/File
    //   60: dup
    //   61: aload 9
    //   63: aload_2
    //   64: invokespecial 663	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual 651	java/io/File:exists	()Z
    //   72: ifeq +8 -> 80
    //   75: aload_1
    //   76: invokevirtual 666	java/io/File:delete	()Z
    //   79: pop
    //   80: invokestatic 462	java/lang/System:currentTimeMillis	()J
    //   83: ldc2_w 311
    //   86: ldiv
    //   87: lstore 6
    //   89: new 668	java/io/DataOutputStream
    //   92: dup
    //   93: new 670	java/io/FileOutputStream
    //   96: dup
    //   97: aload_1
    //   98: invokespecial 673	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   101: invokespecial 676	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   104: astore_1
    //   105: aload_1
    //   106: lload 6
    //   108: lload_3
    //   109: ladd
    //   110: invokevirtual 679	java/io/DataOutputStream:writeLong	(J)V
    //   113: aload_1
    //   114: aload 5
    //   116: aload_2
    //   117: ldc_w 681
    //   120: invokevirtual 685	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   123: invokestatic 690	com/tencent/util/ThreeDes:a	([B[B)[B
    //   126: invokevirtual 693	java/io/DataOutputStream:write	([B)V
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 694	java/io/DataOutputStream:close	()V
    //   137: return
    //   138: aload 9
    //   140: invokevirtual 697	java/io/File:isFile	()Z
    //   143: ifeq -114 -> 29
    //   146: aload 9
    //   148: invokevirtual 666	java/io/File:delete	()Z
    //   151: pop
    //   152: aload 9
    //   154: invokevirtual 654	java/io/File:mkdirs	()Z
    //   157: pop
    //   158: goto -129 -> 29
    //   161: astore_1
    //   162: aload 8
    //   164: astore_1
    //   165: aload_1
    //   166: ifnull -29 -> 137
    //   169: aload_1
    //   170: invokevirtual 694	java/io/DataOutputStream:close	()V
    //   173: return
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   179: return
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   185: return
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_1
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 694	java/io/DataOutputStream:close	()V
    //   197: aload_2
    //   198: athrow
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   204: goto -7 -> 197
    //   207: astore_2
    //   208: goto -19 -> 189
    //   211: astore_2
    //   212: goto -47 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	AuthorityActivity
    //   0	215	1	paramString1	String
    //   0	215	2	paramString2	String
    //   0	215	3	paramLong	long
    //   0	215	5	paramArrayOfByte	byte[]
    //   87	20	6	l1	long
    //   1	162	8	localObject	Object
    //   13	140	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   3	29	161	java/io/IOException
    //   29	80	161	java/io/IOException
    //   80	105	161	java/io/IOException
    //   138	158	161	java/io/IOException
    //   169	173	174	java/io/IOException
    //   133	137	180	java/io/IOException
    //   3	29	186	finally
    //   29	80	186	finally
    //   80	105	186	finally
    //   138	158	186	finally
    //   193	197	199	java/io/IOException
    //   105	129	207	finally
    //   105	129	211	java/io/IOException
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->loginSuccess--userAccount = *" + AuthorityUtil.a(paramString1));
    }
    if (!this.n) {
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(5);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    paramString1 = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
    AuthorityActivity.AccountInfo localAccountInfo = new AuthorityActivity.AccountInfo(this);
    localAccountInfo.jdField_a_of_type_JavaLangString = paramString1;
    localAccountInfo.jdField_b_of_type_JavaLangString = paramString2;
    if (paramBundle != null)
    {
      localAccountInfo.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp");
      localAccountInfo.jdField_b_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp_key");
    }
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo = localAccountInfo;
    this.jdField_a_of_type_JavaLangString = paramString1;
    if (this.jdField_g_of_type_Int == 1)
    {
      k();
      return;
    }
    i();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(paramString, 16)) {
      c(paramString);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      return;
      QLog.d("AuthorityActivity", 1, "send | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString));
      AccountManage.a().a(paramString, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, false);
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
      AuthorityActivity.AccountInfo localAccountInfo = new AuthorityActivity.AccountInfo(this);
      localAccountInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("uin");
      localAccountInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).getString("skey");
      localAccountInfo.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp");
      localAccountInfo.jdField_b_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp_key");
      if ((localAccountInfo.jdField_a_of_type_JavaLangString != null) && (localAccountInfo.jdField_b_of_type_JavaLangString != null)) {
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo = localAccountInfo;
      }
      if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null) {
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
  
  /* Error */
  public byte[] a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 51	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   10: aload_1
    //   11: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc_w 656
    //   17: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_2
    //   21: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 660	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore_2
    //   31: new 647	java/io/File
    //   34: dup
    //   35: new 51	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   42: getstatic 71	com/tencent/open/agent/AuthorityActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   45: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_2
    //   49: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 648	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 651	java/io/File:exists	()Z
    //   63: istore 4
    //   65: iload 4
    //   67: ifne +25 -> 92
    //   70: iconst_0
    //   71: ifeq +11 -> 82
    //   74: new 838	java/lang/NullPointerException
    //   77: dup
    //   78: invokespecial 839	java/lang/NullPointerException:<init>	()V
    //   81: athrow
    //   82: aload 5
    //   84: areturn
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 183	java/lang/Exception:printStackTrace	()V
    //   90: aconst_null
    //   91: areturn
    //   92: new 841	java/io/DataInputStream
    //   95: dup
    //   96: new 843	java/io/FileInputStream
    //   99: dup
    //   100: aload_1
    //   101: invokespecial 844	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   104: invokespecial 847	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 850	java/io/DataInputStream:readLong	()J
    //   112: invokestatic 462	java/lang/System:currentTimeMillis	()J
    //   115: ldc2_w 311
    //   118: ldiv
    //   119: lcmp
    //   120: ifle +61 -> 181
    //   123: aload_1
    //   124: invokevirtual 853	java/io/DataInputStream:available	()I
    //   127: istore_3
    //   128: iload_3
    //   129: ifle +52 -> 181
    //   132: iload_3
    //   133: newarray byte
    //   135: astore 6
    //   137: aload_1
    //   138: aload 6
    //   140: invokevirtual 857	java/io/DataInputStream:read	([B)I
    //   143: pop
    //   144: aload_1
    //   145: invokevirtual 858	java/io/DataInputStream:close	()V
    //   148: aload 6
    //   150: aload_2
    //   151: ldc_w 681
    //   154: invokevirtual 685	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   157: invokestatic 860	com/tencent/util/ThreeDes:b	([B[B)[B
    //   160: astore_2
    //   161: aload_2
    //   162: astore 5
    //   164: aload_1
    //   165: ifnull -83 -> 82
    //   168: aload_1
    //   169: invokevirtual 858	java/io/DataInputStream:close	()V
    //   172: aload_2
    //   173: areturn
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 183	java/lang/Exception:printStackTrace	()V
    //   179: aload_2
    //   180: areturn
    //   181: aload_1
    //   182: ifnull -100 -> 82
    //   185: aload_1
    //   186: invokevirtual 858	java/io/DataInputStream:close	()V
    //   189: aconst_null
    //   190: areturn
    //   191: astore_1
    //   192: aload_1
    //   193: invokevirtual 183	java/lang/Exception:printStackTrace	()V
    //   196: aconst_null
    //   197: areturn
    //   198: astore_1
    //   199: aconst_null
    //   200: astore_1
    //   201: aload_1
    //   202: ifnull -120 -> 82
    //   205: aload_1
    //   206: invokevirtual 858	java/io/DataInputStream:close	()V
    //   209: aconst_null
    //   210: areturn
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 183	java/lang/Exception:printStackTrace	()V
    //   216: aconst_null
    //   217: areturn
    //   218: astore_2
    //   219: aconst_null
    //   220: astore_1
    //   221: aload_1
    //   222: ifnull +7 -> 229
    //   225: aload_1
    //   226: invokevirtual 858	java/io/DataInputStream:close	()V
    //   229: aload_2
    //   230: athrow
    //   231: astore_1
    //   232: aload_1
    //   233: invokevirtual 183	java/lang/Exception:printStackTrace	()V
    //   236: goto -7 -> 229
    //   239: astore_2
    //   240: goto -19 -> 221
    //   243: astore_2
    //   244: goto -43 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	AuthorityActivity
    //   0	247	1	paramString1	String
    //   0	247	2	paramString2	String
    //   127	6	3	i1	int
    //   63	3	4	bool	boolean
    //   1	162	5	localObject	Object
    //   135	14	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   74	82	85	java/lang/Exception
    //   168	172	174	java/lang/Exception
    //   185	189	191	java/lang/Exception
    //   3	65	198	java/io/IOException
    //   92	108	198	java/io/IOException
    //   205	209	211	java/lang/Exception
    //   3	65	218	finally
    //   92	108	218	finally
    //   225	229	231	java/lang/Exception
    //   108	128	239	finally
    //   132	161	239	finally
    //   108	128	243	java/io/IOException
    //   132	161	243	java/io/IOException
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_ArrayOfByte;
    byte[] arrayOfByte2 = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_ArrayOfByte;
    paramArrayOfByte = cryptor.encrypt(paramArrayOfByte, 0, paramArrayOfByte.length, arrayOfByte2);
    arrayOfByte2 = new byte[arrayOfByte1.length + 4 + paramArrayOfByte.length];
    byte[] arrayOfByte3 = new byte[4];
    arrayOfByte3[0] = ((byte)(arrayOfByte1.length >> 24));
    arrayOfByte3[1] = ((byte)(arrayOfByte1.length >> 16));
    arrayOfByte3[2] = ((byte)(arrayOfByte1.length >> 8));
    arrayOfByte3[3] = ((byte)(arrayOfByte1.length >> 0));
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, 0, arrayOfByte3.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, arrayOfByte3.length, arrayOfByte1.length);
    int i1 = arrayOfByte3.length;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length + i1, paramArrayOfByte.length);
    return arrayOfByte2;
  }
  
  protected void b()
  {
    AvatarUpdateService.a().a(this, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString), this);
  }
  
  public void b(int paramInt, String paramString)
  {
    j();
    if (TextUtils.isEmpty(paramString)) {
      a(String.format(super.getString(2131435587), new Object[] { Integer.valueOf(paramInt) }), new akkd(this));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131435589);
    d(paramInt, paramString);
  }
  
  public void b(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->setSdkResult--error = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString2);
    localIntent.putExtra("key_error_detail", paramString3);
    localIntent.putExtra("key_response", paramString1);
    super.setResult(-1, localIntent);
    super.finish();
    if (!this.m) {
      j();
    }
    if (paramInt != 0)
    {
      paramString1 = new HashMap();
      paramString1.put("appid", jdField_f_of_type_JavaLangString);
      paramString1.put("errorcode", paramInt + "");
      paramString1.put("errormsg", paramString2);
      paramString1.put("errordetail", paramString3);
      paramString2 = AppNetConnInfo.getRecentNetworkInfo();
      if (paramString2 != null)
      {
        if (paramString2.getType() != 1) {
          break label344;
        }
        paramString1.put("network", "wifi");
      }
    }
    for (;;)
    {
      StatisticCollector.a(this).a(this.jdField_a_of_type_JavaLangString, "connect_sso_authfail", false, 0L, 0L, paramString1, "");
      label225:
      paramString1 = "0";
      if (paramInt != 0) {
        paramString1 = "1";
      }
      try
      {
        ReportCenter.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_f_of_type_JavaLangString, "1", "3", paramString1, true);
        if (!this.m) {}
      }
      catch (Exception paramString2)
      {
        try
        {
          for (;;)
          {
            ReportCenter.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_f_of_type_JavaLangString, "1", "9", paramString1, true);
            try
            {
              if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) && (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))) {
                ReportCenter.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_f_of_type_JavaLangString, "1", "10", paramString1, true);
              }
              return;
            }
            catch (Exception paramString1)
            {
              label344:
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
                ReportCenter.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_f_of_type_JavaLangString, "1", "6", "0", false);
              }
              catch (Exception paramString1)
              {
                paramString1.printStackTrace();
              }
            }
          }
          break label225;
          paramString2 = paramString2;
          paramString2.printStackTrace();
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
  }
  
  public void b(String paramString)
  {
    SharedPreferences.Editor localEditor = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString(paramString, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString);
    if ((TextUtils.isEmpty(jdField_f_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    localEditor.putString(jdField_f_of_type_JavaLangString + ":" + this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString, paramString);
    localEditor.commit();
  }
  
  public void b(String paramString1, String paramString2)
  {
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, paramString1, jdField_f_of_type_JavaLangString + "|" + paramString2 + "|" + this.h);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences("qapp_login_" + paramString, 0).edit();
    paramString.putBoolean("qapp_login_flag", paramBoolean);
    paramString.commit();
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_ArrayOfByte;
    return cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, arrayOfByte);
  }
  
  protected void c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", jdField_f_of_type_JavaLangString);
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
      StatisticCollector.a(this).a(this.jdField_a_of_type_JavaLangString, "connect_sso_backto3rd", false, 0L, 0L, localHashMap, "");
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
    for (paramString = String.format(super.getString(2131435587), new Object[] { Integer.valueOf(paramInt) });; paramString = String.format(super.getString(2131435592), new Object[] { paramString, Integer.valueOf(paramInt) }))
    {
      a(paramString, new akke(this, paramInt, localJSONObject));
      return;
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->showLoginActivity--uin = *" + AuthorityUtil.a(this.jdField_a_of_type_JavaLangString));
    }
    Intent localIntent = new Intent(this, Login.class);
    if (paramString != null) {
      localIntent.putExtra("param_uin", paramString);
    }
    super.startActivityForResult(localIntent, 1);
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362822);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131365740);
    this.jdField_c_of_type_JavaLangString = ((String)super.getText(2131435574));
    this.jdField_d_of_type_JavaLangString = ((String)super.getText(2131435582));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131365741));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365742));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)super.findViewById(2131363746));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer = ((CardContainer)super.findViewById(2131365730));
    if (this.n) {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setTag(Boolean.valueOf(this.n));
    }
    super.setLeftViewName(2131435584);
    if (this.n)
    {
      super.setTitle(2131435580);
      this.jdField_d_of_type_JavaLangString = ((String)super.getText(2131435581));
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131365725).setVisibility(8);
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setVisibility(4);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new akki(this));
      return;
      super.setTitle(2131435579);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (AppSetting.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText() + "按钮");
      }
    }
  }
  
  public void d(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", jdField_f_of_type_JavaLangString);
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
      StatisticCollector.a(this).a(this.jdField_a_of_type_JavaLangString, "connect_sso_authfail", false, 0L, 0L, localHashMap, "");
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
      QLog.d("AuthorityActivity", 2, "-->LocalAccountCache--userAccount = *" + AuthorityUtil.a(paramString));
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
  
  protected void e()
  {
    if (!a(null)) {
      g();
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->login--");
    }
    this.jdField_d_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    if (!NetworkUtil.g(this))
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
    if (this.jdField_g_of_type_JavaLangString != null) {
      this.jdField_a_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
    }
    if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.jdField_a_of_type_JavaLangString, 16))
    {
      QLog.d("AuthorityActivity", 1, "send | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(this.jdField_a_of_type_JavaLangString));
      AccountManage.a().a(this.jdField_a_of_type_JavaLangString, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, false);
      this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$AuthCmdCost$Record.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getResources().getString(2131435591));
      if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
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
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->startAccountActivity--");
    }
    if (!SharedPrefs.a())
    {
      a(true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("appid", jdField_f_of_type_JavaLangString);
      localHashMap.put("p1", "notlogged");
      localHashMap.put("p2", "uauth");
      StatisticCollector.a(this).a(this.jdField_a_of_type_JavaLangString, "connect_sso_pageview", false, System.currentTimeMillis() - this.jdField_a_of_type_Long, 0L, localHashMap, "");
      return;
    }
    f();
  }
  
  protected void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->loginSSO--");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(super.getString(2131435588));
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
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
      QLog.d("AuthorityActivity", 1, "send | cmd: g_t_n_p | uin :*" + AuthorityUtil.a(this.jdField_a_of_type_JavaLangString));
      AccountManage.a().a(this.jdField_a_of_type_JavaLangString, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, false);
      this.jdField_a_of_type_ComTencentOpenAgentReportReportDef$AuthCmdCost$Record.jdField_a_of_type_Long = System.currentTimeMillis();
      a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString));
      return;
    }
    a(true);
    this.jdField_e_of_type_Boolean = true;
    b("wtl_notlogged", "0");
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->queryAuthority");
    }
    this.jdField_f_of_type_Long = SystemClock.elapsedRealtime();
    if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo == null)
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
      label119:
      String str;
      break label119;
    }
    localGetAuthApiListRequest.client_id.set(l1);
    if (Build.VERSION.RELEASE == null)
    {
      localObject = "";
      localGetAuthApiListRequest.os.set((String)localObject);
      localGetAuthApiListRequest.qqv.set(CommonDataAdapter.a().d());
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
        break label405;
      }
      localGetAuthApiListRequest.sdkp.set("android");
      label263:
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("sdkv");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label418;
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
      if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null) {
        localGetAuthApiListRequest.skey.set(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_JavaLangString);
      }
      a(localGetAuthApiListRequest);
      return;
      localObject = Build.VERSION.RELEASE;
      break;
      label405:
      localGetAuthApiListRequest.sdkp.set((String)localObject);
      break label263;
      label418:
      localGetAuthApiListRequest.sdkv.set((String)localObject);
    }
  }
  
  public void j()
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
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityActivity", 2, "doAuthorize");
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a();
    this.jdField_a_of_type_AndroidOsBundle.putString("openapi", "");
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("doAuthorize", true);
    this.jdField_a_of_type_AndroidOsBundle.putString("need_pay", "1");
    this.jdField_a_of_type_AndroidOsBundle.putString("appid_for_getting_config", this.jdField_a_of_type_AndroidOsBundle.getString("client_id") + "");
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getResources().getString(2131435588));
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    long l1 = Long.parseLong(jdField_f_of_type_JavaLangString);
    Object localObject3 = new SdkAuthorize.AuthorizeRequest();
    ((SdkAuthorize.AuthorizeRequest)localObject3).client_id.set(l1);
    ((SdkAuthorize.AuthorizeRequest)localObject3).need_pay.set(1);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CardContainer.Permission)((Iterator)localObject1).next();
      if (((CardContainer.Permission)localObject2).jdField_a_of_type_Int > 0) {
        ((SdkAuthorize.AuthorizeRequest)localObject3).openapi.add(Integer.valueOf(((CardContainer.Permission)localObject2).jdField_b_of_type_Int));
      }
    }
    if (Build.VERSION.RELEASE == null)
    {
      localObject1 = "";
      ((SdkAuthorize.AuthorizeRequest)localObject3).os.set((String)localObject1);
      ((SdkAuthorize.AuthorizeRequest)localObject3).qqv.set(CommonDataAdapter.a().d());
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("pf");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "openmobile_android";
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).pf.set((String)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("sdkp");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label592;
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkp.set("android");
      label327:
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("sdkv");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label604;
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkv.set("1.5.9");
      label356:
      ((SdkAuthorize.AuthorizeRequest)localObject3).response_type.set("token");
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("sign");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((SdkAuthorize.AuthorizeRequest)localObject3).sign.set((String)localObject1);
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("time");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l1 = Long.parseLong((String)localObject1);
          ((SdkAuthorize.AuthorizeRequest)localObject3).time.set(l1);
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.keySet();
      ((Set)localObject1).remove("sdkp");
      ((Set)localObject1).remove("sign");
      ((Set)localObject1).remove("sdkv");
      ((Set)localObject1).remove("sign");
      ((Set)localObject1).remove("time");
      localObject2 = new StringBuffer();
      localObject4 = ((Set)localObject1).iterator();
      label501:
      if (!((Iterator)localObject4).hasNext()) {
        break label622;
      }
      localObject5 = (String)((Iterator)localObject4).next();
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.get((String)localObject5);
      if (localObject1 == null) {
        break label616;
      }
    }
    label592:
    label604:
    label616:
    for (localObject1 = localObject1.toString();; localObject1 = "")
    {
      ((StringBuffer)localObject2).append((String)localObject5 + "=" + URLEncoder.encode((String)localObject1) + "&");
      break label501;
      localObject1 = Build.VERSION.RELEASE;
      break;
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkp.set((String)localObject1);
      break label327;
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkv.set((String)localObject1);
      break label356;
    }
    label622:
    if (((StringBuffer)localObject2).length() > 0)
    {
      ((StringBuffer)localObject2).delete(((StringBuffer)localObject2).length() - 1, ((StringBuffer)localObject2).length());
      ((SdkAuthorize.AuthorizeRequest)localObject3).passData.set(((StringBuffer)localObject2).toString());
    }
    ((SdkAuthorize.AuthorizeRequest)localObject3).skey.set(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Int = 1;
    Object localObject5 = new NewIntent(this, OpensdkServlet.class);
    ((NewIntent)localObject5).setWithouLogin(true);
    ((NewIntent)localObject5).putExtra("uin", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString);
    Object localObject4 = ((SdkAuthorize.AuthorizeRequest)localObject3).toByteArray();
    localObject3 = "ConnAuthSvr.sdk_auth_api";
    Object localObject2 = "s_a_a";
    localObject1 = localObject4;
    if (!this.j)
    {
      localObject1 = a((byte[])localObject4);
      localObject3 = "ConnAuthSvr.sdk_auth_api_emp";
      localObject2 = "s_a_a_emp";
    }
    ((NewIntent)localObject5).putExtra("data", (byte[])localObject1);
    ((NewIntent)localObject5).putExtra("cmd", (String)localObject3);
    ((NewIntent)localObject5).setObserver(new akkn(this));
    super.getAppRuntime().startServlet((NewIntent)localObject5);
    this.jdField_d_of_type_ComTencentOpenAgentReportReportDef$AuthCmdCost$Record.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_d_of_type_ComTencentOpenAgentReportReportDef$AuthCmdCost$Record.jdField_a_of_type_JavaLangString = ((String)localObject3);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    QLog.d("AuthorityActivity", 1, "send | cmd: " + (String)localObject2 + " | uin : *" + AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString));
    if (QLog.isColorLevel()) {
      QLog.d("SDKQQAgentPref", 2, "AuthorSwitch_AGENT:" + SystemClock.elapsedRealtime());
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "--onActivityResult, requestCode: " + paramInt1 + " | resultCode:" + paramInt2 + " | data: " + paramIntent);
    }
    if (paramInt1 == 100) {
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          this.jdField_g_of_type_JavaLangString = paramIntent.getStringExtra("uin");
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
        LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.jdField_e_of_type_Long - this.jdField_d_of_type_Long));
        return;
      }
      if (-1 != paramInt2) {
        continue;
      }
      this.jdField_e_of_type_Long = SystemClock.elapsedRealtime();
      LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.jdField_e_of_type_Long - this.jdField_d_of_type_Long));
      this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      this.jdField_c_of_type_Boolean = a(paramIntent);
      try
      {
        a(Long.parseLong(jdField_f_of_type_JavaLangString));
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
            this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_ArrayOfByte = paramIntent;
            this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_ArrayOfByte = ((byte[])localObject);
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
          LogUtility.e("AuthorityActivity", "mAuthAppId " + jdField_f_of_type_JavaLangString + " can not cast to long ");
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null)) {}
    super.setResult(0);
    super.finish();
    c();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.leftView)
    {
      super.setResult(0);
      super.finish();
      c();
      return;
    }
    if (paramView == this.jdField_a_of_type_AndroidWidgetTextView)
    {
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      if (this.jdField_i_of_type_Boolean)
      {
        this.jdField_i_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_c_of_type_JavaLangString);
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("appid", jdField_f_of_type_JavaLangString);
      localHashMap.put("p1", "logged");
      localHashMap.put("p2", "uauth");
      paramView = "0";
      if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null) {
        paramView = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString + "";
      }
      StatisticCollector.a(this).a(paramView, "connect_sso_change", false, 0L, 0L, localHashMap, "");
      ReportCenter.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_f_of_type_JavaLangString, "1000", "200", "0", false);
      a(false);
      this.l = true;
      return;
    }
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
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      if (!NetworkUtil.g(this))
      {
        this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.jdField_a_of_type_JavaLangRunnable);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      if ((this.k) || (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo == null))
      {
        f();
        return;
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(super.getString(2131435591));
        if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        i();
        return;
      }
      if (this.jdField_a_of_type_AndroidWidgetButton.getText().equals(super.getString(2131435589)))
      {
        f();
        return;
      }
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
        ReportCenter.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_f_of_type_JavaLangString, "1", "2", "0", false);
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
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onCreate--");
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    super.setContentView(2130969253);
    if (!(super.getAppRuntime() instanceof OpenSDKAppInterface)) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)super.getAppRuntime());
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("client_id");
    this.n = super.getIntent().getBooleanExtra("internal_authority", false);
    this.m = getIntent().getBooleanExtra("authority_start_qq_login", false);
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
      str1 = HexUtil.a(localMessageDigest.digest());
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
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramBundle, super.getTitleBarHeight());
          break;
        }
        i1 = 0;
      }
      if (Build.VERSION.SDK_INT < 17) {
        break label758;
      }
      int i1 = Settings.Global.getInt(getContentResolver(), "always_finish_activities", 0);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label758;
      }
      boolean bool = a(this.jdField_a_of_type_JavaLangString);
      if ((i1 != 1) || (!bool)) {
        break label758;
      }
      this.o = true;
      if (!this.o) {
        break label882;
      }
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("sign", paramBundle);
    this.jdField_a_of_type_AndroidOsBundle.putString("time", str2);
    AccountManage.a().a();
    this.jdField_a_of_type_JavaUtilList = SharedPrefs.a();
    if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.isLogin()) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount();
    }
    if ((this.jdField_a_of_type_JavaLangString == null) && (this.jdField_a_of_type_JavaUtilList != null)) {
      this.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilList.get(0));
    }
    this.jdField_i_of_type_JavaLangString = getIntent().getStringExtra("login_success_uin");
    if ((!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) && (!this.jdField_i_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
    }
    d();
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("oauth_app_name");
    this.h = this.jdField_a_of_type_AndroidOsBundle.getString("sdkv");
    this.jdField_b_of_type_AndroidContentSharedPreferences = OpensdkPreference.a(this, "uin_openid_store");
    this.jdField_c_of_type_AndroidContentSharedPreferences = OpensdkPreference.a(this, "openid_encrytoken");
    if (this.m)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, 0, 2130970535, 17);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(-1);
      if (this.jdField_e_of_type_JavaLangString != null) {
        this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_e_of_type_JavaLangString, null);
      }
      if (Build.VERSION.SDK_INT <= 10) {
        break label700;
      }
      i1 = 4;
      this.jdField_a_of_type_AndroidContentSharedPreferences = super.getSharedPreferences("accountList", i1);
      paramBundle = super.getIntent().getStringExtra("key_action");
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
      if ((!this.n) && (!"action_login".equals(paramBundle))) {
        break label829;
      }
      jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = false;
      paramBundle = super.getAppRuntime().getAccount();
      if ((this.n) || (!GesturePWDUtils.getJumpLock(this, paramBundle)) || (GesturePWDUtils.getAppForground(this))) {
        break label705;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AuthorityActivity", 2, "-->onCreate--has gesture password, will start unlock activity");
      }
      this.jdField_g_of_type_JavaLangString = paramBundle;
      paramBundle = new Intent(this, GesturePWDUnlockActivity.class);
      paramBundle.putExtra("key_gesture_from_authority", true);
      super.startActivityForResult(paramBundle, 100);
    }
    label700:
    label705:
    label758:
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    b(this.jdField_a_of_type_JavaLangString, false);
    for (;;)
    {
      label829:
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(1);
      ReportCenter.a().a(this.jdField_a_of_type_JavaLangString, "", jdField_f_of_type_JavaLangString, "1", "1", "0", false);
      if (!this.m) {
        break;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a();
      return;
      label882:
      e();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    j();
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onDestroy--");
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Long = 0L;
    this.j = false;
  }
  
  protected void onResume()
  {
    super.onResume();
    this.l = false;
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onResume-- SDKQQAgentPref|FirstLaunch_AGENT:" + SystemClock.elapsedRealtime());
    }
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity
 * JD-Core Version:    0.7.0.1
 */