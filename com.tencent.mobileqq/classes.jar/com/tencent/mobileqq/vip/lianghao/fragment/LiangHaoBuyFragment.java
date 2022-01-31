package com.tencent.mobileqq.vip.lianghao.fragment;

import adpn;
import alud;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Window;
import bdin;
import bebr;
import bebv;
import becg;
import bech;
import beci;
import becj;
import beco;
import bety;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class LiangHaoBuyFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int = 1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private becg jdField_a_of_type_Becg;
  private bety jdField_a_of_type_Bety;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private boolean jdField_b_of_type_Boolean;
  
  public static int a(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LiangHaoBuyFragment", 2, "onActivityResult data=null");
      }
      return -1;
    }
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getString("result");; paramIntent = "{}")
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiangHaoBuyFragment", 2, "onActivityResult data=" + paramIntent);
      }
      try
      {
        int i = new JSONObject(paramIntent).optInt("resultCode", -1);
        return i;
      }
      catch (JSONException paramIntent)
      {
        if (!QLog.isColorLevel()) {
          break label122;
        }
        QLog.e("LiangHaoBuyFragment", 2, "getPayResultCode " + paramIntent);
      }
    }
    label122:
    return -1;
  }
  
  private void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog = new beco().a(localFragmentActivity, this.jdField_a_of_type_Becg, new bech(this));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new beci(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, becg parambecg)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("lh_request_code", 2);
    localIntent.putExtra("lh_uin", parambecg.a);
    localIntent.putExtra("lh_light", parambecg.b);
    adpn.a(paramActivity, localIntent, PublicTransFragmentActivity.class, LiangHaoBuyFragment.class, 2);
  }
  
  public static void a(Context paramContext, Intent paramIntent, becg parambecg)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("lh_request_code", 1);
    localIntent.putExtra("lh_uin", parambecg.a);
    localIntent.putExtra("lh_light", parambecg.b);
    adpn.a(paramContext, localIntent, PublicTransFragmentActivity.class, LiangHaoBuyFragment.class);
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 1, paramString, 0).a();
      return;
    }
    if (!bdin.g(BaseApplicationImpl.sApplication))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 1, 2131693890, 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.sApplication, 1, 2131693882, 0).a();
  }
  
  private void a(String paramString, byte[] paramArrayOfByte)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    String str;
    if (this.jdField_b_of_type_Int != 2)
    {
      str = "mvip.p.a.lianghao_tj";
      if (paramArrayOfByte == null) {
        break label303;
      }
    }
    label303:
    for (paramArrayOfByte = SecUtil.toHexString(paramArrayOfByte);; paramArrayOfByte = "")
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("unit", alud.a(2131706411));
        localJSONObject.put("userId", paramString);
        localJSONObject.put("openMonth", "1");
        localJSONObject.put("offerId", "1450000833");
        localJSONObject.put("aid", str);
        localJSONObject.put("ticketValue", paramArrayOfByte);
        localJSONObject.put("ticketName", "vask_27");
        localJSONObject.put("isCanChange", false);
        localJSONObject.put("serviceCode", "CJCLUBT");
        localJSONObject.put("serviceName", "QQ超级会员");
        if (QLog.isDevelopLevel()) {
          QLog.i("LiangHaoBuyFragment", 4, "jumpToPay " + localJSONObject.toString());
        }
        paramString = new Intent(localFragmentActivity, PayBridgeActivity.class);
        paramArrayOfByte = new Bundle();
        paramArrayOfByte.putString("json", localJSONObject.toString());
        paramArrayOfByte.putString("callbackSn", "lhPaySn");
        paramString.putExtras(paramArrayOfByte);
        paramString.putExtra("payparmas_from_is_login_state", false);
        paramString.putExtra("pay_requestcode", 4);
        localFragmentActivity.startActivityForResult(paramString, this.jdField_b_of_type_Int);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        e();
        return;
      }
      str = "mvip.p.a.lianghao_gd";
      break;
    }
  }
  
  private void b()
  {
    if (getActivity() == null) {
      return;
    }
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      this.jdField_a_of_type_Bety.dismiss();
    }
    this.jdField_a_of_type_Bety = new bety(getActivity(), getActivity().getTitleBarHeight());
    this.jdField_a_of_type_Bety.c(2131695090);
    this.jdField_a_of_type_Bety.show();
  }
  
  public static void b(Context paramContext, Intent paramIntent, becg parambecg)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("lh_request_code", 3);
    localIntent.putExtra("lh_uin", parambecg.a);
    localIntent.putExtra("lh_light", parambecg.b);
    adpn.a(paramContext, localIntent, PublicTransFragmentActivity.class, LiangHaoBuyFragment.class);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bety != null) {
      this.jdField_a_of_type_Bety.dismiss();
    }
  }
  
  private void d()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LiangHaoBuyFragment", 4, "lockLiangHao uin=" + this.jdField_a_of_type_Becg.a);
    }
    b();
    new bebr(localFragmentActivity.app).a(localFragmentActivity.getIntent(), this.jdField_a_of_type_Becg.a, new becj(this));
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_Boolean) {}
    FragmentActivity localFragmentActivity;
    do
    {
      return;
      this.jdField_b_of_type_Boolean = true;
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      localFragmentActivity = getActivity();
    } while (localFragmentActivity == null);
    if (this.jdField_b_of_type_Int == 2) {}
    Intent localIntent1;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      Intent localIntent2 = this.jdField_a_of_type_AndroidContentIntent;
      localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = localFragmentActivity.getIntent();
      }
      switch (this.jdField_a_of_type_Int)
      {
      }
      break;
    }
    for (;;)
    {
      localFragmentActivity.finish();
      return;
      localFragmentActivity.setResult(4660);
      break;
      bebv.a(localFragmentActivity, true, this.jdField_a_of_type_Becg.a, this.jdField_a_of_type_Becg.b, localIntent1);
      continue;
      bebv.a(localFragmentActivity, false, this.jdField_a_of_type_Becg.a, this.jdField_a_of_type_Becg.b, localIntent1);
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().addFlags(1024);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null) {
      return;
    }
    paramBundle = paramBundle.getIntent();
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("lh_request_code", 1);
    this.jdField_a_of_type_Becg = new becg(paramBundle.getStringExtra("lh_uin"), paramBundle.getStringExtra("lh_light"));
    if (QLog.isDevelopLevel()) {
      QLog.i("LiangHaoBuyFragment", 4, "onActivityCreated from=" + this.jdField_b_of_type_Int + ",lh=" + this.jdField_a_of_type_Becg.toString());
    }
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 1: 
    case 2: 
      a();
      return;
    }
    a(this.jdField_a_of_type_Becg.a, paramBundle.getByteArrayExtra("key_register_lhsig"));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_b_of_type_Int != paramInt1)
    {
      e();
      return;
    }
    if (a(paramIntent) == 0) {}
    for (this.jdField_a_of_type_Int = 2;; this.jdField_a_of_type_Int = 3)
    {
      e();
      return;
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    localFragmentActivity.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment
 * JD-Core Version:    0.7.0.1
 */