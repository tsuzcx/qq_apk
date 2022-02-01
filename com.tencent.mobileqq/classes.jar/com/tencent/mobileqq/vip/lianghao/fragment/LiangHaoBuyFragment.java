package com.tencent.mobileqq.vip.lianghao.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
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
  private int a = 1;
  private int b = 1;
  private LiangHaoUinData c;
  private Dialog d;
  private QQProgressDialog e;
  private Intent f;
  private boolean g = false;
  private boolean h = false;
  
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
    if (paramIntent != null) {
      paramIntent = paramIntent.getString("result");
    } else {
      paramIntent = "{}";
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityResult data=");
      localStringBuilder.append(paramIntent);
      QLog.i("LiangHaoBuyFragment", 2, localStringBuilder.toString());
    }
    try
    {
      int i = new JSONObject(paramIntent).optInt("resultCode", -1);
      return i;
    }
    catch (JSONException paramIntent)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPayResultCode ");
        localStringBuilder.append(paramIntent);
        QLog.e("LiangHaoBuyFragment", 2, localStringBuilder.toString());
      }
    }
    return -1;
  }
  
  private void a()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity == null) {
      return;
    }
    this.d = new LiangHaoDialog().a(localQBaseActivity, this.c, new LiangHaoBuyFragment.1(this));
    this.d.setOnDismissListener(new LiangHaoBuyFragment.2(this));
    this.d.show();
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
      QQToast.makeText(BaseApplication.getContext(), 1, paramString, 0).show();
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
    {
      QQToast.makeText(BaseApplication.getContext(), 1, 2131891184, 0).show();
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), 1, 2131891176, 0).show();
  }
  
  private void a(String paramString, byte[] paramArrayOfByte)
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity == null) {
      return;
    }
    this.g = true;
    Object localObject = this.d;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      this.d.dismiss();
    }
    if (this.b != 2) {
      localObject = "mvip.p.a.lianghao_tj";
    } else {
      localObject = "mvip.p.a.lianghao_gd";
    }
    if (paramArrayOfByte != null) {
      paramArrayOfByte = SecUtil.toHexString(paramArrayOfByte);
    } else {
      paramArrayOfByte = "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("unit", HardCodeUtil.a(2131903976));
      localJSONObject.put("userId", paramString);
      localJSONObject.put("openMonth", "1");
      localJSONObject.put("offerId", "1450000833");
      localJSONObject.put("aid", localObject);
      localJSONObject.put("ticketValue", paramArrayOfByte);
      localJSONObject.put("ticketName", "vask_27");
      localJSONObject.put("isCanChange", false);
      localJSONObject.put("serviceCode", "CJCLUBT");
      localJSONObject.put("serviceName", "QQ超级会员");
      if (QLog.isDevelopLevel())
      {
        paramString = new StringBuilder();
        paramString.append("jumpToPay ");
        paramString.append(localJSONObject.toString());
        QLog.i("LiangHaoBuyFragment", 4, paramString.toString());
      }
      paramString = new Intent();
      paramArrayOfByte = new Bundle();
      paramArrayOfByte.putString("json", localJSONObject.toString());
      paramArrayOfByte.putString("callbackSn", "lhPaySn");
      paramString.putExtras(paramArrayOfByte);
      paramString.putExtra("payparmas_from_is_login_state", false);
      paramString.putExtra("pay_requestcode", 4);
      LoginUtils.a(localQBaseActivity, paramString, "/base/payBridge", this.b);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      e();
    }
  }
  
  private void b()
  {
    if (getQBaseActivity() == null) {
      return;
    }
    QQProgressDialog localQQProgressDialog = this.e;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.e.dismiss();
    }
    this.e = new QQProgressDialog(getQBaseActivity(), getQBaseActivity().getTitleBarHeight());
    this.e.c(2131892360);
    this.e.show();
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
    QQProgressDialog localQQProgressDialog = this.e;
    if (localQQProgressDialog != null) {
      localQQProgressDialog.dismiss();
    }
  }
  
  private void d()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity == null) {
      return;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("lockLiangHao uin=");
      localStringBuilder.append(this.c.a);
      QLog.i("LiangHaoBuyFragment", 4, localStringBuilder.toString());
    }
    b();
    new LHLoginMng(localQBaseActivity.getAppRuntime()).a(localQBaseActivity.getIntent(), this.c.a, new LiangHaoBuyFragment.3(this));
  }
  
  private void e()
  {
    if (this.h) {
      return;
    }
    this.h = true;
    Object localObject = this.d;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      this.d.dismiss();
    }
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity == null) {
      return;
    }
    if (this.b == 2)
    {
      i = this.a;
      if ((i == 2) || (i == 3)) {
        localQBaseActivity.setResult(4660);
      }
    }
    Intent localIntent = this.f;
    localObject = localIntent;
    if (localIntent == null) {
      localObject = localQBaseActivity.getIntent();
    }
    int i = this.a;
    if (i != 1) {
      if (i != 2)
      {
        if (i == 3) {
          RegisterLHAssistant.a(localQBaseActivity, false, this.c.a, this.c.b, (Intent)localObject);
        }
      }
      else {
        RegisterLHAssistant.a(localQBaseActivity, true, this.c.a, this.c.b, (Intent)localObject);
      }
    }
    localQBaseActivity.finish();
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
    paramBundle = getQBaseActivity();
    if (paramBundle == null) {
      return;
    }
    paramBundle = paramBundle.getIntent();
    this.b = paramBundle.getIntExtra("lh_request_code", 1);
    this.c = new LiangHaoUinData(paramBundle.getStringExtra("lh_uin"), paramBundle.getStringExtra("lh_light"));
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityCreated from=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(",lh=");
      localStringBuilder.append(this.c.toString());
      QLog.i("LiangHaoBuyFragment", 4, localStringBuilder.toString());
    }
    int i = this.b;
    if ((i != 1) && (i != 2))
    {
      if (i != 3) {
        return;
      }
      a(this.c.a, paramBundle.getByteArrayExtra("key_register_lhsig"));
      return;
    }
    a();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.b != paramInt1)
    {
      e();
      return;
    }
    if (a(paramIntent) == 0) {
      this.a = 2;
    } else {
      this.a = 3;
    }
    e();
  }
  
  public void onFinish()
  {
    super.onFinish();
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity == null) {
      return;
    }
    localQBaseActivity.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment
 * JD-Core Version:    0.7.0.1
 */