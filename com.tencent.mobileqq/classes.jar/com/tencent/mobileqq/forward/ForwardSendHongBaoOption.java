package com.tencent.mobileqq.forward;

import agej;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import anzj;
import auxu;
import avcf;
import avcg;
import avch;
import avci;
import bhjx;
import bhlq;
import bhnv;
import bhpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import nok;
import org.json.JSONException;
import org.json.JSONObject;

public class ForwardSendHongBaoOption
  extends auxu
{
  protected int e;
  int f = 5;
  private String h;
  
  public ForwardSendHongBaoOption(Intent paramIntent)
  {
    super(paramIntent);
    this.e = paramIntent.getIntExtra("item", 273);
    if (paramIntent.hasExtra("title")) {}
    for (paramIntent = paramIntent.getStringExtra("title");; paramIntent = "")
    {
      this.h = paramIntent;
      return;
    }
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (((!bhjx.a(localRecentUser.uin)) && (localRecentUser.getType() != 10004) && ((localRecentUser.getType() != 0) || (!nok.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && ((localRecentUser.getType() != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.getType() == 0) || (localRecentUser.getType() == 1) || (localRecentUser.getType() == 3000))) || (((localRecentUser.getType() == 1004) || (localRecentUser.getType() == 1000)) && (this.jdField_b_of_type_Boolean) && (((this.e & 0x1) <= 0) || (localRecentUser.getType() == 0))))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    if ((m()) && ((this.e & 0x100) > 0)) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if ((n()) && ((this.e & 0x10) > 0)) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if ((o()) && ((this.e & 0x1) > 0)) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramInt2 = 1;
    z();
    paramIntent = paramIntent.getStringExtra("result");
    if (QLog.isColorLevel()) {
      QLog.d("Q.send_hong_bao", 2, "ForwardOperations.onActivityResult_sendHongBao(). result_from_cai_fu_tong_SDK=" + paramIntent);
    }
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramIntent);
        paramInt1 = paramInt2;
        if (localJSONObject.has("resultCode"))
        {
          i = localJSONObject.getInt("resultCode");
          if (i != 0) {
            break label424;
          }
          paramIntent = this.jdField_a_of_type_AndroidOsBundle.getString("invoke_from");
          if (QLog.isColorLevel()) {
            QLog.d("Q.send_hong_bao", 2, "ForwardOperations.onActivityResult_sendHongBao(). from=" + paramIntent);
          }
          if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("qwallet")))
          {
            paramIntent = agej.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
            paramIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
            this.jdField_a_of_type_AndroidAppActivity.startActivity(paramIntent);
            this.jdField_a_of_type_AndroidAppActivity.setResult(-1);
          }
          this.jdField_a_of_type_AndroidAppActivity.setResult(-1);
          this.jdField_a_of_type_AndroidAppActivity.finish();
          paramInt1 = 0;
        }
        if (paramInt1 != 0)
        {
          String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131692410);
          paramIntent = str;
          if (localJSONObject.has("retmsg"))
          {
            paramIntent = str;
            if (!TextUtils.isEmpty(localJSONObject.getString("retmsg"))) {
              paramIntent = localJSONObject.getString("retmsg");
            }
          }
          if (this.f > 0)
          {
            this.f -= 1;
            paramIntent = bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230, anzj.a(2131703712), paramIntent, null, null);
            paramIntent.setPositiveButton(2131692402, new avcg(this, paramIntent));
            paramIntent.setNegativeButton(2131690580, new avch(this, paramIntent));
            paramIntent.show();
            return;
            paramIntent = bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230, anzj.a(2131703710), this.jdField_a_of_type_AndroidAppActivity.getString(2131692410), null, null);
            paramIntent.setNegativeButton(2131690559, new avcf(this, paramIntent));
            paramIntent.show();
            paramInt1 = 0;
            continue;
          }
          paramIntent = bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230, anzj.a(2131703698), paramIntent, null, null);
          paramIntent.setNegativeButton(2131690559, new avci(this, paramIntent));
          paramIntent.show();
          return;
        }
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
      }
      return;
      label424:
      if (i != 66201004)
      {
        paramInt1 = paramInt2;
        if (i != 66209015) {}
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
  
  public boolean c()
  {
    if (!bhnv.d(BaseApplication.getContext()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131693963, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299011));
      return true;
    }
    Object localObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("listid", this.jdField_a_of_type_AndroidOsBundle.getString("hb_id"));
        ((JSONObject)localObject2).put("send_uin", this.jdField_a_of_type_AndroidOsBundle.getString("send_uin"));
        ((JSONObject)localObject2).put("hb_type", Integer.parseInt(this.jdField_a_of_type_AndroidOsBundle.getString("hb_type")));
        switch (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"))
        {
        case 1: 
          ((JSONObject)localObject2).put("recv_uin", this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
          ((JSONObject)localObject2).put("appid", String.valueOf(AppSetting.a()));
          ((JSONObject)localObject2).put("from_memo", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
          ((JSONObject)localObject1).put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          ((JSONObject)localObject1).put("viewTag", "qpay_hb_share");
          ((JSONObject)localObject1).put("extra_data", localObject2);
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        continue;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("json", ((JSONObject)localObject1).toString());
      ((Bundle)localObject2).putString("callbackSn", "0");
      if (QLog.isColorLevel()) {
        QLog.d("Q.send_hong_bao", 2, "ForwardOperations.forwardTo(). passed data=" + ((Bundle)localObject2).toString());
      }
      localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, PayBridgeActivity.class);
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      ((Intent)localObject1).putExtra("pay_requestcode", 5);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject1, 20002);
      a(2131692403);
      return true;
      ((JSONObject)localObject2).put("recv_type", 3);
      ((JSONObject)localObject2).put("group_id", this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
      continue;
      ((JSONObject)localObject2).put("recv_type", 2);
      ((JSONObject)localObject2).put("group_id", this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
      continue;
      ((JSONObject)localObject2).put("recv_type", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSendHongBaoOption
 * JD-Core Version:    0.7.0.1
 */