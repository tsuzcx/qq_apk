package com.tencent.mobileqq.vip.lianghao.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.QFragmentActivity;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.vip.lianghao.LHLoginMng;
import com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant;
import com.tencent.mobileqq.vip.lianghao.data.LiangHaoUinData;
import com.tencent.mobileqq.vip.lianghao.view.LiangHaoDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class LiangHaoBuyFragment
  extends QPublicBaseFragment
{
  private int jdField_a_of_type_Int = 1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private LiangHaoUinData jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoUinData;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 1;
  private boolean jdField_b_of_type_Boolean = false;
  
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
    QFragmentActivity localQFragmentActivity = getActivity();
    if (localQFragmentActivity == null) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog = new LiangHaoDialog().a(localQFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoUinData, new LiangHaoBuyFragment.1(this));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new LiangHaoBuyFragment.2(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public static void a(Context paramContext, Intent paramIntent, LiangHaoUinData paramLiangHaoUinData)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("lh_request_code", 1);
    localIntent.putExtra("lh_uin", paramLiangHaoUinData.a);
    localIntent.putExtra("lh_light", paramLiangHaoUinData.b);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicTransFragmentActivity.class, LiangHaoBuyFragment.class);
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      QQToast.a(BaseApplication.getContext(), 1, paramString, 0).a();
      return;
    }
    if (!NetworkUtil.g(BaseApplication.getContext()))
    {
      QQToast.a(BaseApplication.getContext(), 1, 2131693656, 0).a();
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, 2131693648, 0).a();
  }
  
  private void a(String paramString, byte[] paramArrayOfByte)
  {
    QFragmentActivity localQFragmentActivity = getActivity();
    if (localQFragmentActivity == null) {
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
        break label300;
      }
    }
    label300:
    for (paramArrayOfByte = SecUtil.toHexString(paramArrayOfByte);; paramArrayOfByte = "")
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("unit", HardCodeUtil.a(2131706053));
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
        paramString = new Intent();
        paramArrayOfByte = new Bundle();
        paramArrayOfByte.putString("json", localJSONObject.toString());
        paramArrayOfByte.putString("callbackSn", "lhPaySn");
        paramString.putExtras(paramArrayOfByte);
        paramString.putExtra("payparmas_from_is_login_state", false);
        paramString.putExtra("pay_requestcode", 4);
        LoginUtils.a(localQFragmentActivity, paramString, "/base/payBridge", this.jdField_b_of_type_Int);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        j();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getActivity().getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694694);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public static void b(Context paramContext, Intent paramIntent, LiangHaoUinData paramLiangHaoUinData)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("lh_request_code", 3);
    localIntent.putExtra("lh_uin", paramLiangHaoUinData.a);
    localIntent.putExtra("lh_light", paramLiangHaoUinData.b);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicTransFragmentActivity.class, LiangHaoBuyFragment.class);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void d()
  {
    QFragmentActivity localQFragmentActivity = getActivity();
    if (localQFragmentActivity == null) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LiangHaoBuyFragment", 4, "lockLiangHao uin=" + this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoUinData.a);
    }
    b();
    new LHLoginMng(localQFragmentActivity.getAppRuntime()).a(localQFragmentActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoUinData.a, new LiangHaoBuyFragment.3(this));
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_Boolean) {}
    QFragmentActivity localQFragmentActivity;
    do
    {
      return;
      this.jdField_b_of_type_Boolean = true;
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      localQFragmentActivity = getActivity();
    } while (localQFragmentActivity == null);
    if (this.jdField_b_of_type_Int == 2) {}
    Intent localIntent1;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      Intent localIntent2 = this.jdField_a_of_type_AndroidContentIntent;
      localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = localQFragmentActivity.getIntent();
      }
      switch (this.jdField_a_of_type_Int)
      {
      }
      break;
    }
    for (;;)
    {
      localQFragmentActivity.finish();
      return;
      localQFragmentActivity.setResult(4660);
      break;
      RegisterLHAssistant.a(localQFragmentActivity, true, this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoUinData.a, this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoUinData.b, localIntent1);
      continue;
      RegisterLHAssistant.a(localQFragmentActivity, false, this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoUinData.a, this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoUinData.b, localIntent1);
    }
  }
  
  public void a(Activity paramActivity)
  {
    super.a(paramActivity);
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().addFlags(1024);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean d_()
  {
    return false;
  }
  
  public void i()
  {
    super.i();
    QFragmentActivity localQFragmentActivity = getActivity();
    if (localQFragmentActivity == null) {
      return;
    }
    localQFragmentActivity.overridePendingTransition(0, 0);
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
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoUinData = new LiangHaoUinData(paramBundle.getStringExtra("lh_uin"), paramBundle.getStringExtra("lh_light"));
    if (QLog.isDevelopLevel()) {
      QLog.i("LiangHaoBuyFragment", 4, "onActivityCreated from=" + this.jdField_b_of_type_Int + ",lh=" + this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoUinData.toString());
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
    a(this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoUinData.a, paramBundle.getByteArrayExtra("key_register_lhsig"));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_b_of_type_Int != paramInt1)
    {
      j();
      return;
    }
    if (a(paramIntent) == 0) {}
    for (this.jdField_a_of_type_Int = 2;; this.jdField_a_of_type_Int = 3)
    {
      j();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment
 * JD-Core Version:    0.7.0.1
 */