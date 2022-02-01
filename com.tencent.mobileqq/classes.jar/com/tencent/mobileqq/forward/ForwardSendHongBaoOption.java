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
  protected int a;
  int ad = 5;
  private String ae = null;
  
  public ForwardSendHongBaoOption(Intent paramIntent)
  {
    super(paramIntent);
    this.a = paramIntent.getIntExtra("item", 273);
    if (paramIntent.hasExtra("title")) {
      paramIntent = paramIntent.getStringExtra("title");
    } else {
      paramIntent = "";
    }
    this.ae = paramIntent;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (((!Utils.b(localRecentUser.uin)) && (localRecentUser.getType() != 10004) && ((localRecentUser.getType() != 0) || (!CrmUtils.a(this.q, localRecentUser.uin, localRecentUser.getType()))) && ((localRecentUser.getType() != 1) || (!c(localRecentUser.uin))) && ((localRecentUser.getType() == 0) || (localRecentUser.getType() == 1) || (localRecentUser.getType() == 3000))) || (((localRecentUser.getType() == 1004) || (localRecentUser.getType() == 1000)) && (this.E) && (((localRecentUser.getType() == 0) && (a(c))) || ((localRecentUser.getType() == 1) && (a(d))) || ((localRecentUser.getType() == 3000) && (a(e))))))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ae();
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
        paramIntent = this.t.getString("invoke_from");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ForwardOperations.onActivityResult_sendHongBao(). from=");
          ((StringBuilder)localObject).append(paramIntent);
          QLog.d("Q.send_hong_bao", 2, ((StringBuilder)localObject).toString());
        }
        if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("qwallet")))
        {
          paramIntent = AIOUtils.a(new Intent(this.s, SplashActivity.class), null);
          paramIntent.putExtras(this.t);
          this.s.startActivity(paramIntent);
          this.s.setResult(-1);
        }
        this.s.setResult(-1);
        this.s.finish();
        continue;
        paramIntent = DialogUtil.a(this.s, 230, HardCodeUtil.a(2131902807), this.s.getString(2131889678), null, null);
        paramIntent.setNegativeButton(2131887625, new ForwardSendHongBaoOption.1(this, paramIntent));
        paramIntent.show();
        if (paramInt1 != 0)
        {
          localObject = this.s.getString(2131889678);
          paramIntent = (Intent)localObject;
          if (localJSONObject.has("retmsg"))
          {
            paramIntent = (Intent)localObject;
            if (!TextUtils.isEmpty(localJSONObject.getString("retmsg"))) {
              paramIntent = localJSONObject.getString("retmsg");
            }
          }
          if (this.ad > 0)
          {
            this.ad -= 1;
            paramIntent = DialogUtil.a(this.s, 230, HardCodeUtil.a(2131902809), paramIntent, null, null);
            paramIntent.setPositiveButton(2131889670, new ForwardSendHongBaoOption.2(this, paramIntent));
            paramIntent.setNegativeButton(2131887648, new ForwardSendHongBaoOption.3(this, paramIntent));
            paramIntent.show();
            return;
          }
          paramIntent = DialogUtil.a(this.s, 230, HardCodeUtil.a(2131902795), paramIntent, null, null);
          paramIntent.setNegativeButton(2131887625, new ForwardSendHongBaoOption.4(this, paramIntent));
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
  
  protected void c()
  {
    if ((ag()) && ((this.a & 0x100) > 0)) {
      this.C.add(e);
    }
    if ((ah()) && ((this.a & 0x10) > 0)) {
      this.C.add(d);
    }
    if ((ai()) && ((this.a & 0x1) > 0)) {
      this.C.add(c);
    }
  }
  
  protected boolean f()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.makeText(BaseApplicationImpl.sApplication, 2131892102, 0).show(this.s.getResources().getDimensionPixelSize(2131299920));
      return true;
    }
    Object localObject1 = new JSONObject();
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("listid", this.t.getString("hb_id"));
      ((JSONObject)localObject2).put("send_uin", this.t.getString("send_uin"));
      ((JSONObject)localObject2).put("hb_type", Integer.parseInt(this.t.getString("hb_type")));
      int i = this.t.getInt("uintype");
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 3000)
          {
            ((JSONObject)localObject2).put("recv_type", 2);
            ((JSONObject)localObject2).put("group_id", this.t.getString("uin"));
          }
        }
        else
        {
          ((JSONObject)localObject2).put("recv_type", 3);
          ((JSONObject)localObject2).put("group_id", this.t.getString("uin"));
        }
      }
      else {
        ((JSONObject)localObject2).put("recv_type", 1);
      }
      ((JSONObject)localObject2).put("recv_uin", this.t.getString("uin"));
      ((JSONObject)localObject2).put("appid", String.valueOf(AppSetting.d()));
      ((JSONObject)localObject2).put("from_memo", this.q.getCurrentNickname());
      ((JSONObject)localObject1).put("userId", this.q.getCurrentAccountUin());
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
    localObject1 = new Intent(this.s, PayBridgeActivity.class);
    ((Intent)localObject1).putExtras((Bundle)localObject2);
    ((Intent)localObject1).putExtra("pay_requestcode", 5);
    this.s.startActivityForResult((Intent)localObject1, 20002);
    a(2131889671);
    return true;
  }
  
  public String u()
  {
    if (TextUtils.isEmpty(this.ae)) {
      return super.u();
    }
    return this.ae;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSendHongBaoOption
 * JD-Core Version:    0.7.0.1
 */