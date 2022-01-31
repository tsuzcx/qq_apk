package com.tencent.mobileqq.troop.activity;

import aign;
import aigo;
import aigp;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QLifeCommentActivity
  extends TroopBarPublishActivity
{
  public String A;
  protected String B;
  protected String C;
  public double a;
  protected QLifeCommentActivity.ShopSelectReceiver a;
  public double b;
  protected TextView d;
  protected View e;
  protected TextView e;
  protected View f;
  protected TextView f;
  protected boolean o;
  protected String u;
  protected String v;
  protected String w;
  protected String x;
  protected String y;
  protected String z;
  
  private void a(double paramDouble1, double paramDouble2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("BUNDLE", new Bundle());
    localHashMap.put("CONTEXT", getApplicationContext());
    new HttpWebCgiAsyncTask2("http://s.p.qq.com/cgi-bin/coupon_q/shop/shop_list.fcg?cid=" + this.w + "&maplat=" + paramDouble1 + "&maplng=" + paramDouble2 + "&coordinate=1", "", this, 1002, null).a(localHashMap);
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_e_of_type_AndroidViewView = ((ViewStub)findViewById(2131366585)).inflate();
    this.d = ((TextView)findViewById(2131366605));
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidViewView = findViewById(2131366603);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366604));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366605));
    if (TextUtils.isEmpty(this.B)) {
      this.jdField_f_of_type_AndroidWidgetTextView.setHint(2131430288);
    }
    for (;;)
    {
      if (!this.g) {
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      }
      if (!TextUtils.isEmpty(this.h)) {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.h);
      }
      if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_i_of_type_JavaLangString);
      }
      this.rightViewText.setEnabled(false);
      if ((!TextUtils.isEmpty(this.w)) && (this.g)) {
        SosoInterface.a(new aign(this, 0, true, true, 0L, false, false, "QLifeCommentActivity"));
      }
      return;
      this.jdField_f_of_type_AndroidWidgetTextView.setHint(this.B);
    }
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.v = paramJSONObject.optString("shopID");
    this.w = paramJSONObject.optString("couponID");
    this.x = paramJSONObject.optString("sp");
    this.y = paramJSONObject.optString("idType");
    this.z = paramJSONObject.optString("source");
    this.A = paramJSONObject.optString("stype");
    boolean bool2 = this.jdField_f_of_type_Boolean;
    if (!this.g) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_f_of_type_Boolean = (bool1 & bool2);
      this.B = paramJSONObject.optString("selectHint");
      this.C = paramJSONObject.optString("selectWarning");
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
          QQToast.a(this, 2, 2131430329, 1).b(getTitleBarHeight());
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "qlife_comment", "success", 0, 0, paramJSONObject.optString("comment_id"), this.x, this.jdField_a_of_type_JavaUtilArrayList.size() + "", this.A);
        }
        for (;;)
        {
          this.o = false;
          return;
          paramBundle = paramJSONObject.optString("msg");
          paramJSONObject = paramBundle;
          if (TextUtils.isEmpty(paramBundle)) {
            paramJSONObject = getString(2131430292, new Object[] { Integer.valueOf(paramInt) });
          }
          QQToast.a(this, 1, paramJSONObject, 0).b(getTitleBarHeight());
          c(false);
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
          this.rightViewText.setEnabled(true);
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "qlife_comment", "fail", 0, 0, "", this.x, this.jdField_a_of_type_JavaUtilArrayList.size() + "", this.A);
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
        this.y = "1";
        this.x = paramBundle.optString("source_id");
        if (!this.x.equals("1")) {
          break label519;
        }
        this.v = paramBundle.optString("shop_id");
        if ((TextUtils.isEmpty(this.v)) || (TextUtils.isEmpty(paramJSONObject))) {
          break label7;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setText(paramJSONObject);
        this.jdField_f_of_type_JavaLangString = ("http://s.p.qq.com/cgi-bin/coupon_q/social/binary_upload.fcg?&sp=" + this.x + "&shopid=" + this.v);
        return;
      }
      catch (JSONException paramJSONObject) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QLifeCommentActivity", 2, "get nearest shop, JSONException :" + paramJSONObject);
      return;
      label519:
      this.v = paramBundle.optString("sp_id");
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = (TicketManager)this.app.getManager(2);
    if (paramBundle == null) {}
    do
    {
      return false;
      this.u = paramBundle.getSkey(this.app.getAccount());
    } while (TextUtils.isEmpty(this.u));
    this.jdField_f_of_type_JavaLangString = ("http://s.p.qq.com/cgi-bin/coupon_q/social/binary_upload.fcg?&sp=" + this.x + "&shopid=" + this.v);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityQLifeCommentActivity$ShopSelectReceiver = new QLifeCommentActivity.ShopSelectReceiver(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    registerReceiver(this.jdField_a_of_type_ComTencentMobileqqTroopActivityQLifeCommentActivity$ShopSelectReceiver, paramBundle, "com.tencent.msg.permission.pushnotify", null);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "qlife_comment", "write", 0, 0, "", "", "", this.A);
    ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "qlife.activity.show", 0, 0, "", "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqTroopActivityQLifeCommentActivity$ShopSelectReceiver);
  }
  
  public void k()
  {
    int j = 0;
    try
    {
      InputMethodUtil.b(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.a = true;
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = null;
      }
      if (!HttpUtil.a(this)) {
        QQToast.a(this, 2131433086, 0).b(getTitleBarHeight());
      }
      do
      {
        return;
        if (TextUtils.isEmpty(this.v))
        {
          if (TextUtils.isEmpty(this.C)) {
            QQToast.a(this, 2131430290, 1).b(getTitleBarHeight());
          }
          for (;;)
          {
            n();
            return;
            QQToast.a(this, this.C, 1).b(getTitleBarHeight());
          }
        }
        localObject1 = TroopBarUtils.a(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localObject1 = ((String)localObject1).trim();
        i = ((String)localObject1).length();
        if (i < this.jdField_e_of_type_Int)
        {
          QQToast.a(this, getString(2131430306, new Object[] { Integer.valueOf(this.jdField_e_of_type_Int) }), 0).b(getTitleBarHeight());
          return;
        }
        if (i > this.jdField_f_of_type_Int)
        {
          QQToast.a(this, getString(2131430307, new Object[] { Integer.valueOf(this.jdField_f_of_type_Int) }), 0).b(getTitleBarHeight());
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
        if ((TroopBarPublishActivity.Pic_list)TroopBarUtils.a.get(localObject2) == null)
        {
          a(1, this.jdField_a_of_type_AndroidOsHandler);
          return;
        }
        i += 1;
      }
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("cmd", "100");
      ((Bundle)localObject2).putString("sp", this.x);
      ((Bundle)localObject2).putString("shop_id", this.v);
      ((Bundle)localObject2).putString("id_type", this.y);
      ((Bundle)localObject2).putString("source", this.z);
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
          localObject3 = (TroopBarPublishActivity.Pic_list)TroopBarUtils.a.get(localObject3);
          if (localObject3 != null) {
            ((StringBuilder)localObject1).append(((TroopBarPublishActivity.Pic_list)localObject3).url).append(",");
          }
          i += 1;
        }
        ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
      }
      ((Bundle)localObject2).putString("spic", ((StringBuilder)localObject1).toString());
      ((Bundle)localObject2).putString("version", "7.6.0");
      ((Bundle)localObject2).putString("platform", "android");
      ((Bundle)localObject2).putString("Origin", "http://qlife.qq.com");
      ((Bundle)localObject2).putString("Cookie", "skey=" + this.u + ";uin=" + this.app.getCurrentAccountUin());
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("BUNDLE", localObject2);
      ((HashMap)localObject1).put("CONTEXT", getApplicationContext());
      new HttpWebCgiAsyncTask2("http://s.p.qq.com/cgi-bin/coupon_q/social/comment.fcg?", "", this, 1001, null).a((HashMap)localObject1);
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
  
  protected void n()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder().append(this.j).append("&coordinate=1&maplat=");
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
  
  protected boolean onBackEvent()
  {
    if (this.o)
    {
      a(this);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "qlife_comment", "cancel", 0, 0, "", "", "", this.A);
      return true;
    }
    Object localObject = getString(2131434764);
    String str = getString(2131430289);
    localObject = DialogUtil.a(this, 230).setTitle((String)localObject).setMessage(str);
    ((QQCustomDialog)localObject).setPositiveButton(getString(2131432994), new aigo(this, (QQCustomDialog)localObject));
    ((QQCustomDialog)localObject).setNegativeButton(getString(2131432995), new aigp(this, (QQCustomDialog)localObject));
    ((QQCustomDialog)localObject).setPositiveButtonContentDescription(getString(2131432994));
    ((QQCustomDialog)localObject).setNegativeButtonContentDescription(getString(2131432994));
    ((QQCustomDialog)localObject).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.QLifeCommentActivity
 * JD-Core Version:    0.7.0.1
 */