package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.QBaseActivity;
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
  protected boolean c;
  String d;
  String e;
  String f;
  String g;
  String h = "0";
  protected String i;
  
  public TroopBarCommentWindow(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super(paramQBaseActivity, paramBundle);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramQBaseActivity.getApplicationContext();
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.d = this.jdField_a_of_type_OrgJsonJSONObject.optString("bid");
    this.e = this.jdField_a_of_type_OrgJsonJSONObject.optString("pid");
    this.f = this.jdField_a_of_type_OrgJsonJSONObject.optString("cid");
    this.g = this.jdField_a_of_type_OrgJsonJSONObject.optString("rid");
    if ("detail".equals(this.jdField_a_of_type_OrgJsonJSONObject.optString("from"))) {
      paramBundle = "0";
    } else {
      paramBundle = "1";
    }
    this.h = paramBundle;
    this.i = this.jdField_a_of_type_OrgJsonJSONObject.optString("extparam");
    paramBundle = new StringBuilder();
    paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getAccount());
    paramBundle.append("-");
    paramBundle.append(this.d);
    paramBundle.append("-");
    paramBundle.append(this.e);
    paramBundle.append("-");
    paramBundle.append(this.f);
    paramBundle.append("-");
    paramBundle.append(this.g);
    this.jdField_a_of_type_JavaLangString = paramBundle.toString();
    TroopBarUtils.a("two_comment", "exp", this.d, this.h, "", "");
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
      localJSONObject.put("version", "8.7.0.5295");
      localJSONObject.put("extparam", this.i);
      paramString = new NewIntent(this.jdField_a_of_type_AndroidContentContext, ProtoServlet.class);
      paramString.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.recomment");
      WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localWebSsoRequestBody.type.set(0);
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      paramString.setObserver(new TroopBarCommentWindow.1(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      label194:
      break label194;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, 2131696272, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void dismiss()
  {
    super.dismiss();
    String str;
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidWidgetEditText.length() > 0)) {
      str = "0";
    } else {
      str = "1";
    }
    TroopBarUtils.a("two_comment", "un", this.d, str, "", "");
    if (!this.jdField_a_of_type_Boolean) {
      a(this.jdField_c_of_type_JavaLangString, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarCommentWindow
 * JD-Core Version:    0.7.0.1
 */