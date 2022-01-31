package com.tencent.mobileqq.troop.activity;

import aixd;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class TroopBarCommentWindow
  extends PublicCommentWindow
{
  Context a;
  public boolean c;
  public String d;
  String e;
  String f;
  String g;
  public String h = "0";
  protected String i;
  
  public TroopBarCommentWindow(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super(paramBaseActivity, paramBundle);
    this.jdField_a_of_type_AndroidContentContext = paramBaseActivity.getApplicationContext();
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.d = this.jdField_a_of_type_OrgJsonJSONObject.optString("bid");
    this.e = this.jdField_a_of_type_OrgJsonJSONObject.optString("pid");
    this.f = this.jdField_a_of_type_OrgJsonJSONObject.optString("cid");
    this.g = this.jdField_a_of_type_OrgJsonJSONObject.optString("rid");
    if ("detail".equals(this.jdField_a_of_type_OrgJsonJSONObject.optString("from"))) {}
    for (paramBundle = "0";; paramBundle = "1")
    {
      this.h = paramBundle;
      this.i = this.jdField_a_of_type_OrgJsonJSONObject.optString("extparam");
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime().getAccount() + "-" + this.d + "-" + this.e + "-" + this.f + "-" + this.g);
      TroopBarUtils.a("two_comment", "exp", this.d, this.h, "", "");
      return;
    }
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("pid", this.e);
      localJSONObject.put("cid", this.f);
      localJSONObject.put("bid", Long.parseLong(this.d));
      localJSONObject.put("target_rid", this.g);
      localJSONObject.put("comment", TroopBarPublishUtils.a(paramString, null, null));
      localJSONObject.put("version", "7.6.3.3565");
      localJSONObject.put("extparam", this.i);
      paramString = new NewIntent(this.jdField_a_of_type_AndroidContentContext, ProtoServlet.class);
      paramString.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.recomment");
      WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localWebSsoRequestBody.type.set(0);
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      paramString.setObserver(new aixd(this));
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime().startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131430308, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidWidgetEditText.length() > 0)) {}
    for (String str = "0";; str = "1")
    {
      TroopBarUtils.a("two_comment", "un", this.d, str, "", "");
      if (!this.jdField_a_of_type_Boolean) {
        a(this.jdField_c_of_type_JavaLangString, null, false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarCommentWindow
 * JD-Core Version:    0.7.0.1
 */