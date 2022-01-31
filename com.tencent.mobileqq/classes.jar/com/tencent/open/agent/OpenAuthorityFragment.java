package com.tencent.open.agent;

import adpn;
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
import aryj;
import aseh;
import azqs;
import azri;
import bdgm;
import bdhe;
import bdin;
import bdjz;
import bety;
import bfbm;
import bfds;
import bffa;
import bffb;
import bffc;
import bffd;
import bffe;
import bfff;
import bffg;
import bffh;
import bffi;
import bffk;
import bffl;
import bffm;
import bffx;
import bffy;
import bfga;
import bfgd;
import bfgo;
import bfhz;
import bfie;
import bfii;
import bfiw;
import bflp;
import bfmb;
import bfmn;
import bfnz;
import bfqv;
import bfqw;
import bfrh;
import bfrj;
import bfrs;
import bfru;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.open.model.VirtualInfo;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenAuthorityFragment
  extends PublicBaseFragment
  implements View.OnClickListener, bfmn
{
  protected static boolean a;
  protected float a;
  protected int a;
  public long a;
  protected SharedPreferences a;
  public Bundle a;
  protected Handler.Callback a;
  protected View a;
  public Button a;
  protected TextView a;
  protected bety a;
  public bffx a;
  private bfie jdField_a_of_type_Bfie = new bfie();
  public bfqv a;
  private bfrj jdField_a_of_type_Bfrj;
  public bfrs a;
  public OpenCardContainer a;
  public SdkAuthorize.AuthorizeResponse a;
  public preAuth.PreAuthResponse a;
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
  protected TextView b;
  private bfie b;
  public String b;
  public boolean b;
  public int c;
  protected long c;
  protected SharedPreferences c;
  private TextView c;
  public String c;
  public boolean c;
  private final int jdField_d_of_type_Int = 1000;
  public long d;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  protected String d;
  protected boolean d;
  private int jdField_e_of_type_Int = -1;
  public long e;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  protected String e;
  public boolean e;
  public long f;
  protected String f;
  public boolean f;
  public long g;
  private String g;
  public boolean g;
  public long h;
  private String h;
  public boolean h;
  public long i;
  public boolean i;
  long j = 0L;
  public boolean j;
  private long jdField_k_of_type_Long;
  private boolean jdField_k_of_type_Boolean;
  private boolean l;
  private boolean m;
  private boolean n;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public OpenAuthorityFragment()
  {
    this.jdField_b_of_type_Bfie = new bfie();
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new bffa(this);
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangRunnable = new OpenAuthorityFragment.6(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new bffm(this);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus = new HandlerPlus(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_Bfrs = new bffd(this);
    this.jdField_a_of_type_Bffx = new bfff(this);
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
      QLog.d("OpenAuthorityFragment", 1, new Object[] { "-->getbitmap exception, url=", paramString, localIOException });
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.d("OpenAuthorityFragment", 1, "-->getbitmap decodeStream oom, url = " + paramString);
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_RETRY_COUNT", Integer.toString(paramInt));
    aseh.a(paramString, this.jdField_a_of_type_Bfqv, localHashMap, paramBoolean);
  }
  
  private boolean a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    return (localFragmentActivity != null) && (!localFragmentActivity.isFinishing());
  }
  
  private boolean b()
  {
    FragmentActivity localFragmentActivity = getActivity();
    return (localFragmentActivity == null) || (localFragmentActivity.isFinishing());
  }
  
  private void c(String paramString, boolean paramBoolean)
  {
    if (b())
    {
      QLog.e("OpenAuthorityFragment", 1, "showToast activity is null");
      return;
    }
    getActivity().runOnUiThread(new OpenAuthorityFragment.16(this, paramBoolean, paramString));
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131378030));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131368624));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131368670));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131368655));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690648);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.a(0);
  }
  
  private void o()
  {
    QLog.d("OpenAuthorityFragment", 1, "-->updatePreAuthFromServer--");
    if (!a())
    {
      QLog.e("OpenAuthorityFragment", 1, "updatePreAuthFromServer for activity is finished");
      return;
    }
    if (!bdin.g(BaseApplicationImpl.getApplication()))
    {
      QLog.d("OpenAuthorityFragment", 1, "-->updatePreAuthFromServer isNetworkAvailable false--");
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    if (this.jdField_a_of_type_Bfqv == null)
    {
      QLog.d("OpenAuthorityFragment", 1, "-->updatePreAuthFromServer mAccount == null");
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = getActivity().getIntent().getBundleExtra("key_params");
    if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    }
    if ((this.jdField_a_of_type_Bfqv.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_Bfqv.jdField_a_of_type_ArrayOfByte.length == 0))
    {
      QLog.d("OpenAuthorityFragment", 1, "-->updatePreAuthFromServer mAccount.st == null || mAccount.st.length == 0");
      Message localMessage = this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
      localMessage.what = 6;
      localMessage.arg1 = 3000;
      localMessage.obj = getResources().getString(2131695056);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
      return;
    }
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(this.jdField_g_of_type_JavaLangString, getActivity(), bfii.a(getActivity()), this.jdField_a_of_type_AndroidOsBundle, new bffk(this));
  }
  
  public void a()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_d_of_type_JavaLangString != null))
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      if (this.jdField_d_of_type_JavaLangString.length() > 12) {
        localObject = this.jdField_d_of_type_JavaLangString.substring(0, 12) + "...";
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(getResources().getString(2131695046), new Object[] { localObject }));
    }
    Object localObject = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString, (WloginSimpleInfo)localObject);
    String str = new String(((WloginSimpleInfo)localObject)._nick);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(this.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString, (String)localObject, null, false);
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
    Object localObject = getActivity();
    if ((localObject == null) || (((Activity)localObject).isFinishing()))
    {
      QLog.e("OpenAuthorityFragment", 1, "getAppInfo return for activity is finished");
      return;
    }
    this.jdField_a_of_type_Int = 2;
    localObject = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(Long.toString(paramLong));
    QLog.d("OpenAuthorityFragment", 1, new Object[] { "getAppInfo use cached appid=", Long.valueOf(paramLong), ", appInfo=", ((aryj)localObject).toString() });
    Message localMessage = this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    localMessage.what = 3;
    localMessage.obj = localObject;
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376034);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363552);
    this.jdField_b_of_type_JavaLangString = ((String)super.getText(2131695060));
    this.jdField_c_of_type_JavaLangString = ((String)super.getText(2131695048));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131371400));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364089));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer = ((OpenCardContainer)paramView.findViewById(2131364011));
    if (this.m) {
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setTag(Boolean.valueOf(this.m));
    }
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setOnUpdateStatusBarListener(new bffg(this));
    n();
    if (this.m)
    {
      this.jdField_c_of_type_JavaLangString = ((String)super.getText(2131695050));
      this.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidWidgetButton.setTag(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131371143).setVisibility(8);
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    paramView = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(this.jdField_g_of_type_JavaLangString);
    if (paramView != null)
    {
      Object localObject = paramView.jdField_a_of_type_JavaUtilArrayList;
      long l1 = paramView.jdField_a_of_type_Long;
      if (localObject != null)
      {
        paramView = new LinkedList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          VirtualInfo localVirtualInfo = (VirtualInfo)((Iterator)localObject).next();
          bfgd localbfgd = new bfgd(localVirtualInfo.jdField_a_of_type_Long, localVirtualInfo.jdField_a_of_type_JavaLangString, localVirtualInfo.jdField_b_of_type_JavaLangString);
          if (localVirtualInfo.jdField_a_of_type_Long == l1) {
            localbfgd.jdField_a_of_type_Boolean = true;
          }
          paramView.add(localbfgd);
        }
        this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_Bfga.a(paramView, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount());
      }
    }
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setCreateVirtualListner(new bffh(this));
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setOndeleteVirtualListener(this.jdField_a_of_type_Bffx);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setOnAccountEventListener(new bffi(this));
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setCurrentAppid(this.jdField_g_of_type_JavaLangString);
    if (this.jdField_k_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  protected void a(String paramString)
  {
    if ((this.m) || (TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {
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
      localObject2 = bfii.a(getActivity(), paramString, 63, 63);
      paramString.recycle();
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(this.jdField_a_of_type_JavaLangString, (String)localObject1, (Bitmap)localObject2, false);
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
        bdgm.b(getActivity(), 230).setMessageWithUrl(paramString).setTitle(super.getString(2131719379)).setPositiveButton(17039370, paramOnClickListener).show();
      }
    }
    return;
    label63:
    bdgm.b(getActivity(), 230).setMessageWithUrl(paramString).setTitle(super.getString(2131719379)).setPositiveButton(17039370, paramOnClickListener).show();
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    bflp.c("OpenAuthorityFragment", "-->onTaskCompleted identifier = " + paramString + " - b = " + paramBitmap);
    if ((this.jdField_a_of_type_Bfqv != null) && (paramString.equals(this.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString)))
    {
      if (getActivity() != null) {
        break label73;
      }
      QLog.e("OpenAuthorityFragment", 1, "onTaskCompleted activity is null");
    }
    label73:
    while (paramBitmap == null) {
      return;
    }
    getActivity().runOnUiThread(new OpenAuthorityFragment.10(this, paramBitmap));
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
    QLog.d("OpenAuthorityFragment", 1, new Object[] { "-->loginSuccess--userAccount = *", bfii.a(paramString1) });
    if (!this.m) {
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(5);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    paramString1 = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
    bfqv localbfqv = new bfqv();
    localbfqv.jdField_a_of_type_JavaLangString = paramString1;
    localbfqv.jdField_b_of_type_JavaLangString = paramString2;
    if (paramBundle != null)
    {
      localbfqv.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp");
      localbfqv.jdField_b_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp_key");
    }
    this.jdField_a_of_type_Bfqv = localbfqv;
    this.jdField_a_of_type_JavaLangString = paramString1;
    aseh.a("KEY_LOGIN_STAGE_1_TOTAL", paramString1, this.jdField_a_of_type_Long, null, true);
    aseh.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", this.jdField_a_of_type_Bfqv);
    paramString1 = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(this.jdField_g_of_type_JavaLangString);
    if ((paramString1 == null) || (!paramString1.jdField_a_of_type_JavaLangString.equals(localbfqv.jdField_a_of_type_JavaLangString))) {
      if (paramString1 != null) {
        break label275;
      }
    }
    label275:
    for (paramString1 = "null";; paramString1 = bfii.a(paramString1.jdField_a_of_type_JavaLangString))
    {
      QLog.d("OpenAuthorityFragment", 1, new Object[] { "--loginSuccess, changeAccount old uin=", paramString1, ", new uin=", bfii.a(localbfqv.jdField_a_of_type_JavaLangString) });
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Bfqv);
      m();
      if (this.jdField_e_of_type_Int != 1) {
        break;
      }
      j();
      return;
    }
    h();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    QLog.d("OpenAuthorityFragment", 1, new Object[] { "changeAccountLogin account=", paramString, ", canAutoLogin=", Boolean.valueOf(paramBoolean) });
    if (!bdin.g(BaseApplicationImpl.getApplication()))
    {
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    if (this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(paramString, 16)) {
      c(paramString);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      return;
      QLog.d("OpenAuthorityFragment", 1, "send | cmd: g_t_n_p | uin : *" + bfii.a(paramString));
      aseh.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      bfqw.a().a(paramString, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, false);
      bfii.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, paramString);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenAuthorityFragment", 2, "-->changeAccountActivity--isFirstLogin = " + paramBoolean);
    }
    int i1 = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i1 = this.jdField_a_of_type_JavaUtilList.size();
    }
    Intent localIntent2;
    Intent localIntent1;
    if (i1 > 1)
    {
      localIntent2 = new Intent(getActivity(), SwitchAccountActivity.class);
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
      localIntent2 = new Intent(getActivity(), Login.class);
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
      bfqv localbfqv = new bfqv();
      localbfqv.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("uin");
      localbfqv.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).getString("skey");
      localbfqv.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp");
      localbfqv.jdField_b_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp_key");
      if ((localbfqv.jdField_a_of_type_JavaLangString != null) && (localbfqv.jdField_b_of_type_JavaLangString != null)) {
        this.jdField_a_of_type_Bfqv = localbfqv;
      }
      if (this.jdField_a_of_type_Bfqv != null) {
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
    bfmb.a().a(getActivity(), this.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bfqv.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b(this.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString), this);
  }
  
  public void b(int paramInt, String paramString)
  {
    i();
    if (TextUtils.isEmpty(paramString)) {
      a(String.format(super.getString(2131695053), new Object[] { Integer.valueOf(paramInt) }), new bffb(this));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(2131695056));
    d(paramInt, paramString);
  }
  
  public void b(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    ForwardUtils.a(paramInt, this.jdField_a_of_type_Bfqv);
    if (QLog.isColorLevel()) {
      QLog.d("OpenAuthorityFragment", 2, "-->setSdkResult--error = " + paramInt);
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
    if (getActivity() != null)
    {
      getActivity().setResult(-1, localIntent);
      getActivity().finish();
    }
    if (!this.l) {
      i();
    }
    if (i1 != 0)
    {
      paramString1 = new HashMap();
      paramString1.put("appid", this.jdField_g_of_type_JavaLangString);
      paramString1.put("errorcode", i1 + "");
      paramString1.put("errormsg", paramString2);
      paramString1.put("errordetail", paramString3);
      paramString2 = AppNetConnInfo.getRecentNetworkInfo();
      if (paramString2 != null)
      {
        if (paramString2.getType() != 1) {
          break label384;
        }
        paramString1.put("network", "wifi");
      }
    }
    for (;;)
    {
      azri.a(BaseApplicationImpl.getApplication()).a(this.jdField_a_of_type_JavaLangString, "connect_sso_authfail", false, 0L, 0L, paramString1, "");
      paramString1 = "0";
      if (i1 != 0) {
        paramString1 = "1";
      }
      ForwardUtils.a(i1, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      if (this.l) {}
      try
      {
        for (;;)
        {
          bfhz.a().a(this.jdField_a_of_type_JavaLangString, "", this.jdField_g_of_type_JavaLangString, "1", "9", paramString1, true);
          try
          {
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) && (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))) {
              bfhz.a().a(this.jdField_a_of_type_JavaLangString, "", this.jdField_g_of_type_JavaLangString, "1", "10", paramString1, true);
            }
            return;
          }
          catch (Exception paramString1)
          {
            label384:
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
              bfhz.a().a(this.jdField_a_of_type_JavaLangString, "", this.jdField_g_of_type_JavaLangString, "1", "6", "0", false);
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
    localEditor.putString(paramString, this.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString);
    if ((TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString))) {
      return;
    }
    localEditor.putString(this.jdField_g_of_type_JavaLangString + ":" + this.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString, paramString);
    localEditor.commit();
  }
  
  public void b(String paramString1, String paramString2)
  {
    azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, paramString1, this.jdField_g_of_type_JavaLangString + "|" + paramString2 + "|" + this.jdField_f_of_type_JavaLangString);
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
    localHashMap.put("appid", this.jdField_g_of_type_JavaLangString);
    if (this.jdField_e_of_type_Boolean)
    {
      str = "notlogged";
      localHashMap.put("p1", str);
      if (!this.jdField_f_of_type_Boolean) {
        break label90;
      }
    }
    label90:
    for (String str = "auth";; str = "uauth")
    {
      localHashMap.put("p2", str);
      azri.a(BaseApplicationImpl.getApplication()).a(this.jdField_a_of_type_JavaLangString, "connect_sso_backto3rd", false, 0L, 0L, localHashMap, "");
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
    for (paramString = String.format(super.getString(2131695053), new Object[] { Integer.valueOf(paramInt) });; paramString = String.format(super.getString(2131696959), new Object[] { paramString, Integer.valueOf(paramInt) }))
    {
      a(paramString, new bffc(this, paramInt, localJSONObject));
      return;
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenAuthorityFragment", 2, "-->showLoginActivity--uin = *" + bfii.a(this.jdField_a_of_type_JavaLangString));
    }
    if (getActivity() != null)
    {
      Intent localIntent = new Intent(getActivity(), Login.class);
      if (paramString != null) {
        localIntent.putExtra("param_uin", paramString);
      }
      super.startActivityForResult(localIntent, 1);
      return;
    }
    QLog.e("OpenAuthorityFragment", 1, "showLoginActivity activity is null");
  }
  
  protected void d()
  {
    if (!a(null)) {
      f();
    }
  }
  
  public void d(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", this.jdField_g_of_type_JavaLangString);
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
      azri.a(BaseApplicationImpl.getApplication()).a(this.jdField_a_of_type_JavaLangString, "connect_sso_authfail", false, 0L, 0L, localHashMap, "");
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
  
  protected void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenAuthorityFragment", 2, "-->LocalAccountCache--userAccount = *" + bfii.a(paramString));
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString("last_account", paramString);
    Object localObject2 = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null);
    if (localObject1 != null) {}
    for (localObject1 = ((String)localObject1).split(",");; localObject1 = null)
    {
      if (localObject1 != null)
      {
        int i2 = localObject1.length;
        int i1 = 0;
        while (i1 < i2)
        {
          CharSequence localCharSequence = localObject1[i1];
          if (!TextUtils.isEmpty(localCharSequence)) {
            ((ArrayList)localObject2).add(localCharSequence);
          }
          i1 += 1;
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
    QLog.d("OpenAuthorityFragment", 1, "-->login--");
    this.jdField_d_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    if (!bdin.g(getActivity()))
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
      g();
      return;
    }
    if (this.jdField_e_of_type_JavaLangString != null) {
      this.jdField_a_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    }
    if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.jdField_a_of_type_JavaLangString, 16))
    {
      QLog.d("OpenAuthorityFragment", 1, "send | cmd: g_t_n_p | uin : *" + bfii.a(this.jdField_a_of_type_JavaLangString));
      aseh.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      bfqw.a().a(this.jdField_a_of_type_JavaLangString, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, false);
      this.jdField_a_of_type_Bfie.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Bety.a(getResources().getString(2131695057));
      if ((!getActivity().isFinishing()) && (!this.jdField_a_of_type_Bety.isShowing())) {}
      try
      {
        this.jdField_a_of_type_Bety.show();
        a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OpenAuthorityFragment", 2, "-->login(), mProgress.show();", localException);
          }
        }
      }
    }
    g();
  }
  
  protected void f()
  {
    QLog.d("OpenAuthorityFragment", 1, "-->startAccountActivity--");
    if (!bfnz.a())
    {
      a(true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("appid", this.jdField_g_of_type_JavaLangString);
      localHashMap.put("p1", "notlogged");
      localHashMap.put("p2", "uauth");
      azri.a(BaseApplicationImpl.getApplication()).a(this.jdField_a_of_type_JavaLangString, "connect_sso_pageview", false, System.currentTimeMillis() - this.jdField_a_of_type_Long, 0L, localHashMap, "");
      return;
    }
    e();
  }
  
  protected void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenAuthorityFragment", 2, "-->loginSSO--");
    }
    this.jdField_a_of_type_Bety.a(super.getString(2131695063));
    if ((!getActivity().isFinishing()) && (!this.jdField_a_of_type_Bety.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bety.show();
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
          QLog.d("OpenAuthorityFragment", 2, "-->loginSSO(), mProgress.show();", localException);
        }
      }
      QLog.d("OpenAuthorityFragment", 1, "send | cmd: g_t_n_p | uin :*" + bfii.a(this.jdField_a_of_type_JavaLangString));
      aseh.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      bfqw.a().a(this.jdField_a_of_type_JavaLangString, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, false);
      this.jdField_a_of_type_Bfie.jdField_a_of_type_Long = System.currentTimeMillis();
      a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString));
      return;
    }
    a(true);
    this.jdField_e_of_type_Boolean = true;
    b("wtl_notlogged", "0");
  }
  
  protected void h()
  {
    QLog.d("OpenAuthorityFragment", 1, "-->queryAuthorityUseCache");
    this.jdField_f_of_type_Long = SystemClock.elapsedRealtime();
    if (getActivity() == null)
    {
      QLog.e("OpenAuthorityFragment", 1, "queryAuthorityUseCache activity is null");
      return;
    }
    if (this.jdField_a_of_type_Bfqv == null)
    {
      QLog.d("OpenAuthorityFragment", 1, "queryAuthorityUseCache mAccount is null");
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = getActivity().getIntent().getBundleExtra("key_params");
    preAuth.PreAuthResponse localPreAuthResponse = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(this.jdField_g_of_type_JavaLangString);
    QLog.d("OpenAuthorityFragment", 1, new Object[] { "-->queryAuthorityUseCache use cache preAuth.PreAuthResponse ", localPreAuthResponse });
    Message localMessage = this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    localMessage.what = 0;
    localMessage.obj = localPreAuthResponse;
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
  }
  
  public void i()
  {
    if (getActivity() == null) {
      QLog.e("OpenAuthorityFragment", 1, " dismissDialogProgress activity is null");
    }
    while ((getActivity().isFinishing()) || (this.jdField_a_of_type_Bety == null) || (!this.jdField_a_of_type_Bety.isShowing())) {
      return;
    }
    try
    {
      this.jdField_a_of_type_Bety.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    QLog.i("OpenAuthorityFragment", 1, "doAuthorize");
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a();
    Object localObject4 = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
    ((Bundle)localObject4).putString("openapi", "");
    ((Bundle)localObject4).putBoolean("doAuthorize", true);
    ((Bundle)localObject4).putString("need_pay", "1");
    ((Bundle)localObject4).putString("appid_for_getting_config", ((Bundle)localObject4).getString("client_id") + "");
    this.jdField_a_of_type_Bety.a(getResources().getString(2131695063));
    if ((!getActivity().isFinishing()) && (!this.jdField_a_of_type_Bety.isShowing())) {
      this.jdField_a_of_type_Bety.show();
    }
    long l1 = Long.parseLong(this.jdField_g_of_type_JavaLangString);
    Object localObject3 = new SdkAuthorize.AuthorizeRequest();
    ((SdkAuthorize.AuthorizeRequest)localObject3).client_id.set(l1);
    ((SdkAuthorize.AuthorizeRequest)localObject3).need_pay.set(1);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bffy)((Iterator)localObject1).next();
      if (((bffy)localObject2).jdField_a_of_type_Int > 0) {
        ((SdkAuthorize.AuthorizeRequest)localObject3).openapi.add(Integer.valueOf(((bffy)localObject2).jdField_b_of_type_Int));
      }
    }
    label336:
    label365:
    String str;
    if (Build.VERSION.RELEASE == null)
    {
      localObject1 = "";
      ((SdkAuthorize.AuthorizeRequest)localObject3).os.set((String)localObject1);
      ((SdkAuthorize.AuthorizeRequest)localObject3).qqv.set(bfbm.a().d());
      localObject2 = ((Bundle)localObject4).getString("pf");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "openmobile_android";
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).pf.set((String)localObject1);
      localObject1 = ((Bundle)localObject4).getString("sdkp");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label639;
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkp.set("android");
      localObject1 = ((Bundle)localObject4).getString("sdkv");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label652;
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkv.set("1.5.9");
      localObject1 = bfii.a(getActivity());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((SdkAuthorize.AuthorizeRequest)localObject3).appUniqueIdentifier.set((String)localObject1);
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).response_type.set("token");
      localObject2 = ((Bundle)localObject4).getString("sign");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label665;
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).sign.set((String)localObject2);
      localObject1 = ((Bundle)localObject4).getString("time");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        l1 = Long.parseLong((String)localObject1);
        ((SdkAuthorize.AuthorizeRequest)localObject3).time.set(l1);
      }
      label464:
      localObject1 = ((Bundle)localObject4).keySet();
      ((Set)localObject1).remove("sdkp");
      ((Set)localObject1).remove("sign");
      ((Set)localObject1).remove("sdkv");
      ((Set)localObject1).remove("sign");
      ((Set)localObject1).remove("time");
      localObject2 = new StringBuffer();
      localObject5 = ((Set)localObject1).iterator();
      label544:
      if (!((Iterator)localObject5).hasNext()) {
        break label760;
      }
      str = (String)((Iterator)localObject5).next();
      localObject1 = ((Bundle)localObject4).get(str);
      if (localObject1 == null) {
        break label753;
      }
    }
    label652:
    label665:
    label753:
    for (localObject1 = localObject1.toString();; localObject1 = "")
    {
      ((StringBuffer)localObject2).append(str + "=" + URLEncoder.encode((String)localObject1) + "&");
      break label544;
      localObject1 = Build.VERSION.RELEASE;
      break;
      label639:
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkp.set((String)localObject1);
      break label336;
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkv.set((String)localObject1);
      break label365;
      localObject2 = bfru.a(getActivity(), (String)localObject1);
      localObject1 = localObject2[1];
      localObject2 = localObject2[2];
      QLog.d("OpenAuthorityFragment", 1, "doAuthorize.getAuthorizeSign again");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.d("OpenAuthorityFragment", 1, "doAuthorize.getAuthorizeSign sign is null");
        break label464;
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).sign.set((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label464;
      }
      l1 = Long.parseLong((String)localObject2);
      ((SdkAuthorize.AuthorizeRequest)localObject3).time.set(l1);
      break label464;
    }
    label760:
    if (((StringBuffer)localObject2).length() > 0)
    {
      ((StringBuffer)localObject2).delete(((StringBuffer)localObject2).length() - 1, ((StringBuffer)localObject2).length());
      ((SdkAuthorize.AuthorizeRequest)localObject3).passData.set(((StringBuffer)localObject2).toString());
    }
    ((SdkAuthorize.AuthorizeRequest)localObject3).skey.set(this.jdField_a_of_type_Bfqv.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Int = 1;
    Object localObject5 = new NewIntent(getActivity(), bfiw.class);
    ((NewIntent)localObject5).setWithouLogin(true);
    ((NewIntent)localObject5).putExtra("uin", this.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString);
    localObject4 = ((SdkAuthorize.AuthorizeRequest)localObject3).toByteArray();
    localObject3 = "ConnAuthSvr.sdk_auth_api";
    Object localObject2 = "s_a_a";
    boolean bool = bfii.a(this.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface);
    localObject1 = localObject4;
    if (!bool)
    {
      localObject1 = bfru.a((byte[])localObject4, this.jdField_a_of_type_Bfqv);
      localObject3 = "ConnAuthSvr.sdk_auth_api_emp";
      localObject2 = "s_a_a_emp";
    }
    ((NewIntent)localObject5).putExtra("data", (byte[])localObject1);
    ((NewIntent)localObject5).putExtra("cmd", (String)localObject3);
    ((NewIntent)localObject5).setObserver(new bffl(this, bool));
    if (this.jdField_c_of_type_Int == 0) {
      aseh.a("KEY_AUTHORIZE_REQUEST");
    }
    getActivity().getAppRuntime().startServlet((NewIntent)localObject5);
    this.jdField_b_of_type_Bfie.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Bfie.jdField_a_of_type_JavaLangString = ((String)localObject3);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    QLog.d("OpenAuthorityFragment", 1, new Object[] { "send | cmd: ", localObject2, " | uin : *", bfii.a(this.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString) });
    if (QLog.isColorLevel()) {
      QLog.d("SDKQQAgentPref", 2, "AuthorSwitch_AGENT:" + SystemClock.elapsedRealtime());
    }
  }
  
  public void k()
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Bfqv != null)) {}
    getActivity().setResult(0);
    getActivity().finish();
    if (getActivity() != null)
    {
      getActivity().setResult(0);
      getActivity().finish();
    }
    c();
  }
  
  public void l()
  {
    if (getActivity() != null)
    {
      int i1 = getResources().getColor(2131165865);
      ColorStateList localColorStateList = getResources().getColorStateList(2131165865);
      if (this.jdField_d_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_d_of_type_AndroidWidgetTextView.setText("");
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
      }
      return;
    }
    QLog.e("OpenAuthorityFragment", 1, "updateTitleColor activity is null");
  }
  
  public void m()
  {
    QLog.d("OpenAuthorityFragment", 1, "-->getVirtualList");
    if (!bdin.g(BaseApplicationImpl.getApplication()))
    {
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(this.jdField_g_of_type_JavaLangString, getActivity(), bfii.a(getActivity()), this.jdField_a_of_type_AndroidOsBundle, new bffe(this));
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    QLog.d("OpenAuthorityFragment", 1, "-->onActivityCreated--");
    super.onActivityCreated(paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenAuthorityFragment", 2, "--onActivityResult, requestCode: " + paramInt1 + " | resultCode:" + paramInt2 + " | data: " + paramIntent);
    }
    if ((paramInt1 == 101) && (paramIntent != null) && (paramIntent.getIntExtra("createVirtualAccount", 0) == 1))
    {
      this.j = paramIntent.getLongExtra("createVirtualVid", 0L);
      m();
      i();
      if (paramInt2 != 0) {
        break label493;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        if (getActivity() != null)
        {
          getActivity().setResult(0, paramIntent);
          getActivity().finish();
        }
        c();
      }
      this.jdField_e_of_type_Long = SystemClock.elapsedRealtime();
      bflp.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.jdField_e_of_type_Long - this.jdField_d_of_type_Long));
    }
    label433:
    label493:
    do
    {
      do
      {
        return;
        if ((paramInt1 == 102) && (paramIntent != null))
        {
          paramInt1 = paramIntent.getIntExtra("key_cancel_auth", 0);
          int i1 = paramIntent.getIntExtra("key_error_code", 0);
          if (paramInt1 == 1) {
            if (getActivity() != null) {
              getActivity().setResult(0);
            }
          }
          for (;;)
          {
            if (getActivity() == null) {
              break label433;
            }
            getActivity().finish();
            break;
            if ((i1 == 0) && (this.jdField_k_of_type_Boolean))
            {
              bfgo.a().a(this.jdField_a_of_type_AndroidOsBundle, true);
            }
            else
            {
              localObject = paramIntent.getStringExtra("key_error_msg");
              String str1 = paramIntent.getStringExtra("key_error_detail");
              String str2 = paramIntent.getStringExtra("key_response");
              if (QLog.isColorLevel()) {
                QLog.d("OpenAuthorityFragment", 2, new Object[] { "OpenVirtual.onActivityResult, error: ", Integer.valueOf(i1), ", msg:", localObject, ", detail:", str1, ", response=", str2 });
              }
              Intent localIntent = new Intent();
              localIntent.putExtra("key_error_code", i1);
              localIntent.putExtra("key_error_msg", (String)localObject);
              localIntent.putExtra("key_error_detail", str1);
              localIntent.putExtra("key_response", str2);
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
            this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("uin");
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
      bflp.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.jdField_e_of_type_Long - this.jdField_d_of_type_Long));
      this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      this.jdField_c_of_type_Boolean = a(paramIntent);
    } while ((paramIntent == null) || (!jdField_a_of_type_Boolean));
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("last_account");
    boolean bool = paramIntent.getBooleanExtra("isLogin", false);
    Object localObject = new WloginSimpleInfo();
    if (this.jdField_a_of_type_MqqManagerWtloginManager != null)
    {
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.jdField_a_of_type_JavaLangString, (WloginSimpleInfo)localObject);
      this.jdField_a_of_type_JavaLangString = Long.toString(((WloginSimpleInfo)localObject)._uin);
    }
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(1);
    a(this.jdField_a_of_type_JavaLangString);
    if (bool)
    {
      d(this.jdField_a_of_type_JavaLangString);
      bfii.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.jdField_a_of_type_JavaLangString);
    }
    localObject = paramIntent.getBundleExtra("ssobundle");
    if (localObject != null)
    {
      paramIntent = ((Bundle)localObject).getByteArray("st_temp");
      localObject = ((Bundle)localObject).getByteArray("st_temp_key");
      if ((paramIntent != null) && (localObject != null))
      {
        this.jdField_a_of_type_Bfqv.jdField_a_of_type_ArrayOfByte = paramIntent;
        this.jdField_a_of_type_Bfqv.jdField_b_of_type_ArrayOfByte = ((byte[])localObject);
      }
    }
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(5);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(11);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_Bfga.a(null, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Bfrj.a(this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Bfqv);
    o();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_e_of_type_AndroidWidgetTextView)
    {
      if (getActivity() != null)
      {
        getActivity().setResult(0);
        getActivity().finish();
      }
      c();
    }
    label810:
    do
    {
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
      {
        QLog.d("OpenAuthorityFragment", 1, "<user:>authorize btn is clicked.");
        long l1 = System.currentTimeMillis();
        try
        {
          if (l1 - this.jdField_c_of_type_Long < 500L) {
            return;
          }
        }
        finally {}
        this.jdField_c_of_type_Long = l1;
        if (!bdin.g(getActivity()))
        {
          this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.jdField_a_of_type_JavaLangRunnable);
          return;
        }
        if ((this.i) || (this.jdField_a_of_type_Bfqv == null))
        {
          e();
          return;
        }
        if (this.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_Bety.a(super.getString(2131695057));
          if ((!getActivity().isFinishing()) && (!this.jdField_a_of_type_Bety.isShowing())) {
            this.jdField_a_of_type_Bety.show();
          }
          h();
          return;
        }
        if (this.jdField_a_of_type_AndroidWidgetButton.getTag().equals(super.getString(2131695056)))
        {
          e();
          return;
        }
        aseh.a("KEY_LOGIN_STAGE_2_1_NEW_TOTAL", this.jdField_a_of_type_Bfqv);
        if (this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse != null)
        {
          aseh.a("KEY_LOGIN_STAGE_2_NEW_TOTAL", this.jdField_a_of_type_Bfqv);
          aseh.a("KEY_LOGIN_STAGE_3_TOTAL");
          if (QLog.isColorLevel()) {
            QLog.d("SDKQQAgentPref", 2, "ClickAuthButton: " + SystemClock.elapsedRealtime());
          }
          paramView = this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
          paramView.what = 1;
          paramView.obj = this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse;
          this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramView);
          this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
          bfhz.a().a(this.jdField_a_of_type_JavaLangString, "", this.jdField_g_of_type_JavaLangString, "1", "2", "0", false);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SDKQQAgentPref", 2, "ClickAuthButton -- doAuthorize(): " + SystemClock.elapsedRealtime());
        }
        int i2 = 0;
        Object localObject2 = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(this.jdField_g_of_type_JavaLangString);
        paramView = new ArrayList();
        int i1 = i2;
        if (localObject2 != null)
        {
          i1 = i2;
          if (!((List)localObject2).isEmpty())
          {
            localObject2 = ((List)localObject2).iterator();
            i1 = 0;
            while (((Iterator)localObject2).hasNext())
            {
              bfds localbfds1 = (bfds)((Iterator)localObject2).next();
              bfds localbfds2 = new bfds();
              localbfds2.jdField_b_of_type_JavaLangString = localbfds1.jdField_b_of_type_JavaLangString;
              localbfds2.jdField_a_of_type_Int = localbfds1.jdField_a_of_type_Int;
              if ((localbfds2.jdField_a_of_type_Int == 2) || (localbfds2.jdField_a_of_type_Int == 3)) {
                i1 = 1;
              }
              localbfds2.jdField_b_of_type_Int = localbfds1.jdField_b_of_type_Int;
              localbfds2.jdField_a_of_type_Boolean = localbfds1.jdField_a_of_type_Boolean;
              localbfds2.jdField_a_of_type_JavaLangString = localbfds1.jdField_a_of_type_JavaLangString;
              localbfds2.jdField_b_of_type_Boolean = true;
              paramView.add(localbfds2);
            }
          }
        }
        this.jdField_a_of_type_Bfrj.a(this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Bfqv);
        this.jdField_a_of_type_Bfrj.a(this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
        if (i1 != 0)
        {
          paramView = new Intent();
          paramView.putExtra("appId", this.jdField_g_of_type_JavaLangString);
          paramView.putExtra("vid", this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a());
          paramView.putExtra("appName", this.jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthResponse.app_name.get());
          paramView.putExtra("hasIcon", this.jdField_g_of_type_Boolean);
          paramView.putExtra("login_cost", this.jdField_e_of_type_Long - this.jdField_d_of_type_Long);
          if (this.jdField_h_of_type_Long != 0L) {}
          for (l1 = this.jdField_h_of_type_Long;; l1 = SystemClock.elapsedRealtime())
          {
            paramView.putExtra("authStartTime", l1);
            paramView.putExtra("authListCostTime", this.jdField_g_of_type_Long - this.jdField_f_of_type_Long);
            paramView.putExtra("is_from_qr_login", this.jdField_k_of_type_Boolean);
            paramView.putExtra("public_fragment_window_feature", 1);
            localObject2 = bfii.a(getActivity());
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              paramView.putExtra("pkg_name", (String)localObject2);
            }
            aseh.a("KEY_LOGIN_STAGE_2_2_NEW_TOTAL");
            adpn.a(getActivity(), paramView, PublicFragmentActivityForOpenSDK.class, OpenSelectPermissionFragment.class, 102);
            break;
          }
        }
        if (this.jdField_k_of_type_Boolean)
        {
          i1 = 2;
          l1 = this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a();
          if (l1 != 0L) {
            break label916;
          }
          azqs.b(null, "dc00898", "", "", "0X800A117", "0X800A117", i1, 0, "", "", "", "");
        }
        for (;;)
        {
          aseh.a("KEY_AUTHORIZE_REQUEST");
          aseh.a("KEY_LOGIN_STAGE_2_NEW_TOTAL", this.jdField_a_of_type_Bfqv);
          aseh.a("KEY_LOGIN_STAGE_3_TOTAL");
          this.jdField_a_of_type_Bfrj.a(this.jdField_k_of_type_Boolean, this.jdField_g_of_type_JavaLangString, paramView, l1, this.jdField_a_of_type_Bfrs, bfii.a(getActivity()), getActivity());
          break;
          i1 = 1;
          break label810;
          azqs.b(null, "dc00898", "", "", "0X800A116", "0X800A116", i1, 0, "", "", "", "");
        }
      }
    } while (paramView != this.jdField_a_of_type_AndroidWidgetTextView);
    label916:
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.e();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = paramLayoutInflater.inflate(2131559533, paramViewGroup, false);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    aseh.a("KEY_LOGIN_STAGE_2_NEW_TOTAL");
    aseh.a("KEY_LOGIN_STAGE_2_1_NEW_TOTAL");
    QLog.d("OpenAuthorityFragment", 1, new Object[] { "-->onCreateView time = ", Long.valueOf(System.currentTimeMillis()) });
    if (!(getActivity().getAppRuntime() instanceof OpenSDKAppInterface)) {
      return paramBundle;
    }
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getActivity().getAppRuntime());
    this.jdField_a_of_type_AndroidOsBundle = getActivity().getIntent().getBundleExtra("key_params");
    if (this.jdField_a_of_type_AndroidOsBundle == null)
    {
      b(-5, "params is null", "params is null", "params is null");
      return paramBundle;
    }
    this.jdField_a_of_type_Bfrj = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a();
    this.jdField_k_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_login_by_qr_scan", false);
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("client_id");
    this.m = getActivity().getIntent().getBooleanExtra("internal_authority", false);
    this.l = getActivity().getIntent().getBooleanExtra("authority_start_qq_login", false);
    QLog.d("OpenAuthorityFragment", 1, new Object[] { "-->OpenAuthorityFragment onCreateView mIsInternalAuthority=", Boolean.valueOf(this.m), ", mFromSdkLoginAuthority=", Boolean.valueOf(this.l) });
    String str;
    if (this.m)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount();
      str = System.currentTimeMillis() / 1000L + "";
      paramViewGroup = this.jdField_a_of_type_AndroidOsBundle.getString("package_name");
      paramLayoutInflater = this.jdField_a_of_type_AndroidOsBundle.getString("sign");
      paramViewGroup = paramViewGroup + "_" + paramLayoutInflater.replace(":", "").toLowerCase() + "_" + str;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramViewGroup.getBytes());
      paramViewGroup = bdhe.a(localMessageDigest.digest());
      paramLayoutInflater = paramViewGroup;
    }
    catch (NoSuchAlgorithmException paramViewGroup)
    {
      for (;;)
      {
        paramViewGroup.printStackTrace();
        continue;
        if (getActivity().isChild()) {}
        for (paramLayoutInflater = getActivity().getParent();; paramLayoutInflater = getActivity())
        {
          this.jdField_a_of_type_Bety = new bety(paramLayoutInflater, getActivity().getTitleBarHeight());
          break;
        }
        i1 = 0;
      }
      if (Build.VERSION.SDK_INT < 17) {
        break label931;
      }
      i1 = Settings.Global.getInt(getActivity().getContentResolver(), "always_finish_activities", 0);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label931;
      }
      boolean bool = a(this.jdField_a_of_type_JavaLangString);
      if ((i1 != 1) || (!bool)) {
        break label931;
      }
      this.n = true;
      if (!this.n) {
        break label1095;
      }
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("sign", paramLayoutInflater);
    this.jdField_a_of_type_AndroidOsBundle.putString("time", str);
    bfqw.a().a();
    this.jdField_a_of_type_JavaUtilList = bfnz.a();
    if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.isLogin()) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount();
    }
    if ((this.jdField_a_of_type_JavaLangString == null) && (this.jdField_a_of_type_JavaUtilList != null)) {
      this.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilList.get(0));
    }
    this.jdField_h_of_type_JavaLangString = getActivity().getIntent().getStringExtra("login_success_uin");
    if ((!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) && (!this.jdField_h_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
    }
    a(paramBundle);
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("oauth_app_name");
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("sdkv");
    this.jdField_b_of_type_AndroidContentSharedPreferences = bfrh.a(BaseApplicationImpl.getApplication(), "uin_openid_store");
    this.jdField_c_of_type_AndroidContentSharedPreferences = bfrh.a(BaseApplicationImpl.getApplication(), "openid_encrytoken");
    if (this.l)
    {
      this.jdField_a_of_type_Bety = new bety(getActivity(), 0, 2131561239, 17);
      this.jdField_a_of_type_Bety.a(-1);
      if (this.jdField_d_of_type_JavaLangString != null) {
        this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(this.jdField_d_of_type_JavaLangString, null);
      }
      paramLayoutInflater = getActivity();
      if (Build.VERSION.SDK_INT <= 10) {
        break label865;
      }
      i1 = 4;
      this.jdField_a_of_type_AndroidContentSharedPreferences = paramLayoutInflater.getSharedPreferences("accountList", i1);
      paramLayoutInflater = getActivity().getIntent().getStringExtra("key_action");
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
      if ((!this.m) && (!"action_login".equals(paramLayoutInflater))) {
        break label1002;
      }
      jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = false;
      paramLayoutInflater = getActivity().getAppRuntime().getAccount();
      if ((this.m) || (!GesturePWDUtils.getJumpLock(BaseApplicationImpl.getApplication(), paramLayoutInflater)) || (GesturePWDUtils.getAppForground(BaseApplicationImpl.getApplication()))) {
        break label871;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OpenAuthorityFragment", 2, "-->onCreate--has gesture password, will start unlock activity");
      }
      this.jdField_e_of_type_JavaLangString = paramLayoutInflater;
      paramLayoutInflater = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      paramLayoutInflater.putExtra("key_gesture_from_authority", true);
      super.startActivityForResult(paramLayoutInflater, 100);
      return paramBundle;
    }
    label865:
    label871:
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_a_of_type_JavaLangString));
    }
    label931:
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    b(this.jdField_a_of_type_JavaLangString, false);
    label1002:
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(1);
    bfhz.a().a(this.jdField_a_of_type_JavaLangString, "", this.jdField_g_of_type_JavaLangString, "1", "1", "0", false);
    if (this.jdField_k_of_type_Boolean) {}
    for (int i1 = 2;; i1 = 1)
    {
      azqs.b(null, "dc00898", "", "", "0X800A115", "0X800A115", i1, 0, "", "", "", "");
      if (this.l)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a();
      }
      return paramBundle;
      label1095:
      d();
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    i();
    QLog.d("OpenAuthorityFragment", 1, "-->onDestroy--");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment
 * JD-Core Version:    0.7.0.1
 */