package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ForwardSendHongBaoOption
  extends ForwardBaseOption
{
  protected int e;
  int f = 5;
  private String h = null;
  
  public ForwardSendHongBaoOption(Intent paramIntent)
  {
    super(paramIntent);
    this.e = paramIntent.getIntExtra("item", 273);
    if (paramIntent.hasExtra("title")) {
      paramIntent = paramIntent.getStringExtra("title");
    } else {
      paramIntent = "";
    }
    this.h = paramIntent;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (((!Utils.a(localRecentUser.uin)) && (localRecentUser.getType() != 10004) && ((localRecentUser.getType() != 0) || (!CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && ((localRecentUser.getType() != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.getType() == 0) || (localRecentUser.getType() == 1) || (localRecentUser.getType() == 3000))) || (((localRecentUser.getType() == 1004) || (localRecentUser.getType() == 1000)) && (this.jdField_b_of_type_Boolean) && (((localRecentUser.getType() == 0) && (a(jdField_b_of_type_JavaLangInteger))) || ((localRecentUser.getType() == 1) && (a(c))) || ((localRecentUser.getType() == 3000) && (a(d))))))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    A();
    paramIntent = paramIntent.getStringExtra("result");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ForwardOperations.onActivityResult_sendHongBao(). result_from_cai_fu_tong_SDK=");
      ((StringBuilder)localObject).append(paramIntent);
      QLog.d("Q.send_hong_bao", 2, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramIntent);
        paramInt1 = 0;
        if (!localJSONObject.has("resultCode")) {
          break label452;
        }
        paramInt2 = localJSONObject.getInt("resultCode");
        if (paramInt2 != 0) {
          break label435;
        }
        paramIntent = this.jdField_a_of_type_AndroidOsBundle.getString("invoke_from");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ForwardOperations.onActivityResult_sendHongBao(). from=");
          ((StringBuilder)localObject).append(paramIntent);
          QLog.d("Q.send_hong_bao", 2, ((StringBuilder)localObject).toString());
        }
        if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("qwallet")))
        {
          paramIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
          paramIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramIntent);
          this.jdField_a_of_type_AndroidAppActivity.setResult(-1);
        }
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1);
        this.jdField_a_of_type_AndroidAppActivity.finish();
        continue;
        paramIntent = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, HardCodeUtil.a(2131704915), this.jdField_a_of_type_AndroidAppActivity.getString(2131692654), null, null);
        paramIntent.setNegativeButton(2131690706, new ForwardSendHongBaoOption.1(this, paramIntent));
        paramIntent.show();
        if (paramInt1 != 0)
        {
          localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692654);
          paramIntent = (Intent)localObject;
          if (localJSONObject.has("retmsg"))
          {
            paramIntent = (Intent)localObject;
            if (!TextUtils.isEmpty(localJSONObject.getString("retmsg"))) {
              paramIntent = localJSONObject.getString("retmsg");
            }
          }
          if (this.f > 0)
          {
            this.f -= 1;
            paramIntent = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, HardCodeUtil.a(2131704917), paramIntent, null, null);
            paramIntent.setPositiveButton(2131692646, new ForwardSendHongBaoOption.2(this, paramIntent));
            paramIntent.setNegativeButton(2131690728, new ForwardSendHongBaoOption.3(this, paramIntent));
            paramIntent.show();
            return;
          }
          paramIntent = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, HardCodeUtil.a(2131704903), paramIntent, null, null);
          paramIntent.setNegativeButton(2131690706, new ForwardSendHongBaoOption.4(this, paramIntent));
          paramIntent.show();
          return;
        }
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
      }
      return;
      label435:
      if ((paramInt2 != 66201004) && (paramInt2 != 66209015)) {
        label452:
        paramInt1 = 1;
      }
    }
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.h)) {
      return super.b();
    }
    return this.h;
  }
  
  protected void b()
  {
    if ((p()) && ((this.e & 0x100) > 0)) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if ((q()) && ((this.e & 0x10) > 0)) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if ((r()) && ((this.e & 0x1) > 0)) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
  }
  
  protected boolean c()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694422, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168));
      return true;
    }
    Object localObject1 = new JSONObject();
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("listid", this.jdField_a_of_type_AndroidOsBundle.getString("hb_id"));
      ((JSONObject)localObject2).put("send_uin", this.jdField_a_of_type_AndroidOsBundle.getString("send_uin"));
      ((JSONObject)localObject2).put("hb_type", Integer.parseInt(this.jdField_a_of_type_AndroidOsBundle.getString("hb_type")));
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 3000)
          {
            ((JSONObject)localObject2).put("recv_type", 2);
            ((JSONObject)localObject2).put("group_id", this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
          }
        }
        else
        {
          ((JSONObject)localObject2).put("recv_type", 3);
          ((JSONObject)localObject2).put("group_id", this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
        }
      }
      else {
        ((JSONObject)localObject2).put("recv_type", 1);
      }
      ((JSONObject)localObject2).put("recv_uin", this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
      ((JSONObject)localObject2).put("appid", String.valueOf(AppSetting.a()));
      ((JSONObject)localObject2).put("from_memo", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
      ((JSONObject)localObject1).put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((JSONObject)localObject1).put("viewTag", "qpay_hb_share");
      ((JSONObject)localObject1).put("extra_data", localObject2);
    }
    catch (Exception localException)
    {
      Object localObject2;
      label292:
      break label292;
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("json", ((JSONObject)localObject1).toString());
    ((Bundle)localObject2).putString("callbackSn", "0");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ForwardOperations.forwardTo(). passed data=");
      ((StringBuilder)localObject1).append(((Bundle)localObject2).toString());
      QLog.d("Q.send_hong_bao", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, PayBridgeActivity.class);
    ((Intent)localObject1).putExtras((Bundle)localObject2);
    ((Intent)localObject1).putExtra("pay_requestcode", 5);
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject1, 20002);
    a(2131692647);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSendHongBaoOption
 * JD-Core Version:    0.7.0.1
 */