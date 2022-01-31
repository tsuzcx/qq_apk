package com.tencent.open.agent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import aseh;
import bety;
import bfds;
import bfgk;
import bfgl;
import bfqv;
import bfrh;
import bfrj;
import bfrs;
import bhta;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class OpenSelectPermissionFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  protected SharedPreferences a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bety a;
  private bfgl jdField_a_of_type_Bfgl;
  private bfrj jdField_a_of_type_Bfrj;
  private bfrs jdField_a_of_type_Bfrs = new bfgk(this);
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  protected SharedPreferences b;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private long e;
  
  private List<bfds> a()
  {
    Object localObject = this.jdField_a_of_type_Bfrj.a(String.valueOf(this.jdField_a_of_type_Long));
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      bfds localbfds1 = (bfds)((Iterator)localObject).next();
      bfds localbfds2 = new bfds();
      localbfds2.jdField_a_of_type_Int = localbfds1.jdField_a_of_type_Int;
      if ((localbfds2.jdField_a_of_type_Int == 2) || (localbfds2.jdField_a_of_type_Int == 3))
      {
        localbfds2.jdField_b_of_type_JavaLangString = localbfds1.jdField_b_of_type_JavaLangString;
        localbfds2.jdField_b_of_type_Int = localbfds1.jdField_b_of_type_Int;
        localbfds2.jdField_a_of_type_Boolean = localbfds1.jdField_a_of_type_Boolean;
        localbfds2.jdField_a_of_type_JavaLangString = localbfds1.jdField_a_of_type_JavaLangString;
        if (localbfds2.jdField_a_of_type_Int == 2) {}
        for (boolean bool = true;; bool = false)
        {
          localbfds2.jdField_b_of_type_Boolean = bool;
          localArrayList.add(localbfds2);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (getActivity() == null)
    {
      QLog.e("OpenSelectPermissionFragment", 1, "showToast activity is null");
      return;
    }
    bhta.a(new OpenSelectPermissionFragment.2(this, paramBoolean, paramString));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ThreadManager.executeOnFileThread(new OpenSelectPermissionFragment.1(this));
    }
  }
  
  private void b()
  {
    bfqv localbfqv = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(Long.toString(this.jdField_a_of_type_Long));
    aseh.a("KEY_LOGIN_STAGE_2_NEW_TOTAL", localbfqv);
    aseh.a("KEY_LOGIN_STAGE_2_2_NEW_TOTAL", localbfqv);
    aseh.a("KEY_LOGIN_STAGE_3_TOTAL");
    c();
    ThreadManager.executeOnNetWorkThread(new OpenSelectPermissionFragment.3(this));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bety != null)
    {
      if (this.jdField_a_of_type_Bety.isShowing()) {
        return;
      }
      this.jdField_a_of_type_Bety.show();
      return;
    }
    this.jdField_a_of_type_Bety = new bety(getActivity(), 0, 2131561238, 17);
    this.jdField_a_of_type_Bety.a(-1);
    this.jdField_a_of_type_Bety.show();
  }
  
  protected void a()
  {
    if (getActivity() == null) {
      QLog.e("OpenSelectPermissionFragment", 1, "dismissDialogProgress activity is null");
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
      QLog.e("OpenSelectPermissionFragment", 1, "dismissDialogProgress Exception", localException);
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(Long.toString(this.jdField_a_of_type_Long));
    ForwardUtils.a(paramInt, (bfqv)localObject);
    String str = Long.toString(this.jdField_a_of_type_Long);
    if (localObject == null)
    {
      localObject = "";
      ForwardUtils.a(paramInt, str, (String)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_cancel_auth", 0);
      ((Intent)localObject).putExtra("key_error_code", paramInt);
      ((Intent)localObject).putExtra("key_error_msg", paramString2);
      ((Intent)localObject).putExtra("key_error_detail", paramString3);
      ((Intent)localObject).putExtra("key_response", paramString1);
      QLog.d("OpenSelectPermissionFragment", 1, new Object[] { "OpenVirtual.setSdkResult, error: ", Integer.valueOf(paramInt), ", msg:", paramString2, ", detail:", paramString3 });
      getActivity().setResult(102, (Intent)localObject);
      getActivity().finish();
      this.jdField_a_of_type_Bety.dismiss();
      if (paramInt != 0)
      {
        paramString1 = new HashMap();
        paramString1.put("appid", String.valueOf(this.jdField_a_of_type_Long));
        paramString1.put("errorcode", paramInt + "");
        paramString1.put("errormsg", paramString2);
        paramString1.put("errordetail", paramString3);
        paramString2 = AppNetConnInfo.getRecentNetworkInfo();
        if (paramString2 != null)
        {
          if (paramString2.getType() != 1) {
            break label287;
          }
          paramString1.put("network", "wifi");
        }
      }
    }
    label287:
    while (paramString2.getType() != 0)
    {
      return;
      localObject = ((bfqv)localObject).jdField_a_of_type_JavaLangString;
      break;
    }
    switch (paramString2.getSubtype())
    {
    case 7: 
    default: 
      paramString1.put("network", "2G");
      return;
    case 1: 
    case 2: 
    case 4: 
      paramString1.put("network", "2G");
      return;
    }
    paramString1.put("network", "3G");
  }
  
  protected void a(String paramString)
  {
    String str = String.valueOf(this.jdField_a_of_type_Long);
    bfqv localbfqv = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(str);
    SharedPreferences.Editor localEditor;
    if (localbfqv != null)
    {
      localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putString(paramString, localbfqv.jdField_a_of_type_JavaLangString);
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(localbfqv.jdField_a_of_type_JavaLangString))) {}
    }
    else
    {
      return;
    }
    localEditor.putString(str + ":" + localbfqv.jdField_a_of_type_JavaLangString, paramString);
    localEditor.commit();
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      SharedPreferences.Editor localEditor = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView) {
      if (getActivity() != null) {
        getActivity().finish();
      }
    }
    do
    {
      return;
      if (paramView == this.jdField_d_of_type_AndroidViewView)
      {
        b();
        return;
      }
    } while (paramView != this.jdField_b_of_type_AndroidViewView);
    paramView = new Intent();
    paramView.putExtra("key_cancel_auth", 1);
    getActivity().setResult(102, paramView);
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559543, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getActivity().getAppRuntime());
    this.jdField_a_of_type_Bfrj = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131363024);
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131363915);
    this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131378030);
    this.jdField_c_of_type_AndroidViewView.setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131362703));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131362705));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131364694);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_Bety = new bety(getActivity(), 0, 2131561238, 17);
    this.jdField_a_of_type_Bety.a(-1);
    QLog.d("OpenSelectPermissionFragment", 2, "========> init appid = " + this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131371715));
    this.jdField_a_of_type_Bfgl = new bfgl(this);
    paramViewGroup = getActivity().getIntent();
    this.jdField_a_of_type_Long = Long.parseLong(paramViewGroup.getStringExtra("appId"));
    this.jdField_a_of_type_JavaLangString = paramViewGroup.getStringExtra("pkg_name");
    this.jdField_b_of_type_Long = paramViewGroup.getLongExtra("vid", 0L);
    this.jdField_b_of_type_JavaLangString = paramViewGroup.getStringExtra("appName");
    this.jdField_b_of_type_Boolean = paramViewGroup.getBooleanExtra("hasIcon", false);
    this.e = paramViewGroup.getLongExtra("login_cost", 0L);
    this.jdField_d_of_type_Long = paramViewGroup.getLongExtra("authListCostTime", 0L);
    this.jdField_c_of_type_Long = paramViewGroup.getLongExtra("authStartTime", SystemClock.elapsedRealtime());
    this.jdField_c_of_type_Boolean = paramViewGroup.getBooleanExtra("is_from_qr_login", false);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Bfgl);
    this.jdField_a_of_type_Bfgl.a(a());
    a(this.jdField_b_of_type_Boolean);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = bfrh.a(getActivity(), "uin_openid_store");
    this.jdField_b_of_type_AndroidContentSharedPreferences = bfrh.a(getActivity(), "openid_encrytoken");
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Bfrs = null;
    this.jdField_a_of_type_Bfrj = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(getActivity(), true, getResources().getColor(2131167194));
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(getResources().getColor(2131167194));
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
    }
    this.jdField_a_of_type_Boolean = true;
    String str = Build.MANUFACTURER + Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.i("OpenSelectPermissionFragment", 2, "MANUFACTURER = " + Build.MANUFACTURER + ", MODEL = " + Build.MODEL);
    }
    if ((str != null) && ((str.equals("MeizuPRO 7-S")) || (str.equalsIgnoreCase("MeizuM711C")))) {
      ImmersiveUtils.a(getActivity().getWindow(), true);
    }
    for (;;)
    {
      ImmersiveUtils.a(true, getActivity().getWindow());
      return;
      ImmersiveUtils.a(getActivity().getWindow());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment
 * JD-Core Version:    0.7.0.1
 */