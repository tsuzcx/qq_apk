package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import awqx;
import ayds;
import aydt;
import aydu;
import azgm;
import azho;
import babr;
import bafb;
import bbms;
import bbmy;
import beex;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import mpl;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QLifeCommentActivity
  extends TroopBarPublishActivity
{
  protected String A;
  protected String B;
  public double a;
  protected QLifeCommentActivity.ShopSelectReceiver a;
  public double b;
  protected TextView d;
  protected View e;
  protected TextView e;
  protected View f;
  protected TextView f;
  protected boolean o;
  protected String t;
  protected String u;
  protected String v;
  protected String w;
  protected String x;
  protected String y;
  public String z;
  
  private void a(double paramDouble1, double paramDouble2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("BUNDLE", new Bundle());
    localHashMap.put("CONTEXT", getApplicationContext());
    new azgm("http://s.p.qq.com/cgi-bin/coupon_q/shop/shop_list.fcg?cid=" + this.v + "&maplat=" + paramDouble1 + "&maplng=" + paramDouble2 + "&coordinate=1", "", this, 1002, null).a(localHashMap);
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_e_of_type_AndroidViewView = ((ViewStub)findViewById(2131313402)).inflate();
    this.d = ((TextView)findViewById(2131312566));
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidViewView = findViewById(2131303344);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312567));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312566));
    if (TextUtils.isEmpty(this.A)) {
      this.jdField_f_of_type_AndroidWidgetTextView.setHint(2131630778);
    }
    for (;;)
    {
      if (!this.jdField_g_of_type_Boolean) {
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      }
      if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_g_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.h)) {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.h);
      }
      this.rightViewText.setEnabled(false);
      if ((!TextUtils.isEmpty(this.v)) && (this.jdField_g_of_type_Boolean)) {
        SosoInterface.a(new ayds(this, 0, true, true, 0L, false, false, "QLifeCommentActivity"));
      }
      return;
      this.jdField_f_of_type_AndroidWidgetTextView.setHint(this.A);
    }
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.u = paramJSONObject.optString("shopID");
    this.v = paramJSONObject.optString("couponID");
    this.w = paramJSONObject.optString("sp");
    this.x = paramJSONObject.optString("idType");
    this.y = paramJSONObject.optString("source");
    this.z = paramJSONObject.optString("stype");
    boolean bool2 = this.jdField_f_of_type_Boolean;
    if (!this.jdField_g_of_type_Boolean) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_f_of_type_Boolean = (bool1 & bool2);
      this.A = paramJSONObject.optString("selectHint");
      this.B = paramJSONObject.optString("selectWarning");
      return;
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (isFinishing()) {}
    label7:
    do
    {
      do
      {
        return;
      } while (paramJSONObject == null);
      switch (paramInt)
      {
      default: 
        return;
      case 1001: 
        paramInt = paramJSONObject.optInt("ret", -1);
        if (paramInt == 0)
        {
          paramBundle = new Intent();
          paramBundle.putExtra("result", paramJSONObject.toString());
          setResult(-1, paramBundle);
          finish();
          bbmy.a(this, 2, 2131630839, 1).b(getTitleBarHeight());
          awqx.b(null, "P_CliOper", "Pb_account_lifeservice", "", "qlife_comment", "success", 0, 0, paramJSONObject.optString("comment_id"), this.w, this.jdField_a_of_type_JavaUtilArrayList.size() + "", this.z);
        }
        for (;;)
        {
          this.o = false;
          return;
          paramBundle = paramJSONObject.optString("msg");
          paramJSONObject = paramBundle;
          if (TextUtils.isEmpty(paramBundle)) {
            paramJSONObject = getString(2131630857, new Object[] { Integer.valueOf(paramInt) });
          }
          bbmy.a(this, 1, paramJSONObject, 0).b(getTitleBarHeight());
          c(false);
          if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
            this.jdField_a_of_type_Bbms.dismiss();
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
          this.rightViewText.setEnabled(true);
          awqx.b(null, "P_CliOper", "Pb_account_lifeservice", "", "qlife_comment", "fail", 0, 0, "", this.w, this.jdField_a_of_type_JavaUtilArrayList.size() + "", this.z);
        }
      }
    } while (paramJSONObject.optInt("retcode", -1) != 0);
    for (;;)
    {
      try
      {
        paramBundle = paramJSONObject.optJSONObject("result");
        if (paramBundle == null) {
          break label7;
        }
        paramJSONObject = paramBundle.optString("biz_name");
        paramBundle = paramBundle.optJSONArray("shops");
        if ((paramBundle == null) || (paramBundle.length() <= 0)) {
          break label7;
        }
        paramBundle = paramBundle.getJSONObject(0);
        this.x = "1";
        this.w = paramBundle.optString("source_id");
        if (!this.w.equals("1")) {
          break label519;
        }
        this.u = paramBundle.optString("shop_id");
        if ((TextUtils.isEmpty(this.u)) || (TextUtils.isEmpty(paramJSONObject))) {
          break label7;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setText(paramJSONObject);
        this.jdField_e_of_type_JavaLangString = ("http://s.p.qq.com/cgi-bin/coupon_q/social/binary_upload.fcg?&sp=" + this.w + "&shopid=" + this.u);
        return;
      }
      catch (JSONException paramJSONObject) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QLifeCommentActivity", 2, "get nearest shop, JSONException :" + paramJSONObject);
      return;
      label519:
      this.u = paramBundle.optString("sp_id");
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = (TicketManager)this.app.getManager(2);
    if (paramBundle == null) {}
    do
    {
      return false;
      this.t = paramBundle.getSkey(this.app.getAccount());
    } while (TextUtils.isEmpty(this.t));
    this.jdField_e_of_type_JavaLangString = ("http://s.p.qq.com/cgi-bin/coupon_q/social/binary_upload.fcg?&sp=" + this.w + "&shopid=" + this.u);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityQLifeCommentActivity$ShopSelectReceiver = new QLifeCommentActivity.ShopSelectReceiver(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    registerReceiver(this.jdField_a_of_type_ComTencentMobileqqTroopActivityQLifeCommentActivity$ShopSelectReceiver, paramBundle, "com.tencent.msg.permission.pushnotify", null);
    awqx.b(null, "P_CliOper", "Pb_account_lifeservice", "", "qlife_comment", "write", 0, 0, "", "", "", this.z);
    awqx.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "qlife.activity.show", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqTroopActivityQLifeCommentActivity$ShopSelectReceiver);
  }
  
  public void l()
  {
    int j = 0;
    try
    {
      beex.b(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.a = true;
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = null;
      }
      if (!mpl.a(this)) {
        bbmy.a(this, 2131628882, 0).b(getTitleBarHeight());
      }
      do
      {
        return;
        if (TextUtils.isEmpty(this.u))
        {
          if (TextUtils.isEmpty(this.B)) {
            bbmy.a(this, 2131630779, 1).b(getTitleBarHeight());
          }
          for (;;)
          {
            o();
            return;
            bbmy.a(this, this.B, 1).b(getTitleBarHeight());
          }
        }
        localObject1 = azho.a(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localObject1 = ((String)localObject1).trim();
        i = ((String)localObject1).length();
        if (i < this.jdField_e_of_type_Int)
        {
          bbmy.a(this, getString(2131630823, new Object[] { Integer.valueOf(this.jdField_e_of_type_Int) }), 0).b(getTitleBarHeight());
          return;
        }
        if (i > this.jdField_f_of_type_Int)
        {
          bbmy.a(this, getString(2131630824, new Object[] { Integer.valueOf(this.jdField_f_of_type_Int) }), 0).b(getTitleBarHeight());
          return;
        }
      } while (!a(this.jdField_i_of_type_Int, false));
      c(true);
      this.rightViewText.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(false);
      this.o = true;
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject2 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((TroopBarPublishActivity.Pic_list)azho.a.get(localObject2) == null)
        {
          a(1, this.jdField_a_of_type_AndroidOsHandler);
          return;
        }
        i += 1;
      }
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("cmd", "100");
      ((Bundle)localObject2).putString("sp", this.w);
      ((Bundle)localObject2).putString("shop_id", this.u);
      ((Bundle)localObject2).putString("id_type", this.x);
      ((Bundle)localObject2).putString("source", this.y);
      ((Bundle)localObject2).putString("text", (String)localObject1);
      ((Bundle)localObject2).putString("time", System.currentTimeMillis() + "");
      Object localObject1 = new StringBuilder();
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
        i = j;
        while (i < localArrayList.size())
        {
          Object localObject3 = (String)localArrayList.get(i);
          localObject3 = (TroopBarPublishActivity.Pic_list)azho.a.get(localObject3);
          if (localObject3 != null) {
            ((StringBuilder)localObject1).append(((TroopBarPublishActivity.Pic_list)localObject3).url).append(",");
          }
          i += 1;
        }
        ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
      }
      ((Bundle)localObject2).putString("spic", ((StringBuilder)localObject1).toString());
      ((Bundle)localObject2).putString("version", "8.2.6");
      ((Bundle)localObject2).putString("platform", "android");
      ((Bundle)localObject2).putString("Origin", "http://qlife.qq.com");
      ((Bundle)localObject2).putString("Cookie", "skey=" + this.t + ";uin=" + this.app.getCurrentAccountUin());
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("BUNDLE", localObject2);
      ((HashMap)localObject1).put("CONTEXT", getApplicationContext());
      new azgm("http://s.p.qq.com/cgi-bin/coupon_q/social/comment.fcg?", "", this, 1001, null).a((HashMap)localObject1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        int i = 0;
      }
    }
  }
  
  protected void o()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_i_of_type_JavaLangString).append("&coordinate=1&maplat=");
    if (this.jdField_a_of_type_Double == 0.0D)
    {
      localObject = "0";
      localStringBuilder = localStringBuilder.append(localObject).append("&maplng=");
      if (this.jdField_b_of_type_Double != 0.0D) {
        break label103;
      }
    }
    label103:
    for (Object localObject = "0";; localObject = Double.valueOf(this.jdField_b_of_type_Double))
    {
      localIntent.putExtra("url", localObject);
      startActivity(localIntent);
      return;
      localObject = Double.valueOf(this.jdField_a_of_type_Double);
      break;
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.o)
    {
      a(this);
      awqx.b(null, "P_CliOper", "Pb_account_lifeservice", "", "qlife_comment", "cancel", 0, 0, "", "", "", this.z);
      return true;
    }
    Object localObject = getString(2131654355);
    String str = getString(2131630777);
    localObject = babr.a(this, 230).setTitle((String)localObject).setMessage(str);
    ((bafb)localObject).setPositiveButton(getString(2131655020), new aydt(this, (bafb)localObject));
    ((bafb)localObject).setNegativeButton(getString(2131628983), new aydu(this, (bafb)localObject));
    ((bafb)localObject).setPositiveButtonContentDescription(getString(2131655020));
    ((bafb)localObject).setNegativeButtonContentDescription(getString(2131655020));
    ((bafb)localObject).show();
    return true;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() == 0)
    {
      this.rightViewText.setEnabled(false);
      return;
    }
    this.rightViewText.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.QLifeCommentActivity
 * JD-Core Version:    0.7.0.1
 */