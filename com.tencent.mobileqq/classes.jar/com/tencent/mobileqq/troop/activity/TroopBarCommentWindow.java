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
  protected String A;
  Context t;
  protected boolean u = false;
  String v;
  String w;
  String x;
  String y;
  String z = "0";
  
  public TroopBarCommentWindow(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super(paramQBaseActivity, paramBundle);
    this.t = paramQBaseActivity.getApplicationContext();
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.v = this.g.optString("bid");
    this.w = this.g.optString("pid");
    this.x = this.g.optString("cid");
    this.y = this.g.optString("rid");
    if ("detail".equals(this.g.optString("from"))) {
      paramBundle = "0";
    } else {
      paramBundle = "1";
    }
    this.z = paramBundle;
    this.A = this.g.optString("extparam");
    paramBundle = new StringBuilder();
    paramBundle.append(this.r.getAppRuntime().getAccount());
    paramBundle.append("-");
    paramBundle.append(this.v);
    paramBundle.append("-");
    paramBundle.append(this.w);
    paramBundle.append("-");
    paramBundle.append(this.x);
    paramBundle.append("-");
    paramBundle.append(this.y);
    this.h = paramBundle.toString();
    TroopBarUtils.a("two_comment", "exp", this.v, this.z, "", "");
  }
  
  protected void a(String paramString)
  {
    if (this.u) {
      return;
    }
    this.u = true;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("pid", this.w);
      localJSONObject.put("cid", this.x);
      localJSONObject.put("bid", Long.parseLong(this.v));
      localJSONObject.put("target_rid", this.y);
      localJSONObject.put("comment", TroopBarPublishUtils.a(paramString, null, null));
      localJSONObject.put("version", "8.8.17.5770");
      localJSONObject.put("extparam", this.A);
      paramString = new NewIntent(this.t, ProtoServlet.class);
      paramString.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.recomment");
      WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localWebSsoRequestBody.type.set(0);
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
      this.c.setEnabled(false);
      paramString.setObserver(new TroopBarCommentWindow.1(this));
      this.r.getAppRuntime().startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      label194:
      break label194;
    }
    QQToast.makeText(this.r, 1, 2131894038, 0).show(this.r.getTitleBarHeight());
    this.u = false;
  }
  
  public void dismiss()
  {
    super.dismiss();
    String str;
    if ((this.b != null) && (this.b.length() > 0)) {
      str = "0";
    } else {
      str = "1";
    }
    TroopBarUtils.a("two_comment", "un", this.v, str, "", "");
    if (!this.l) {
      a(this.s, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarCommentWindow
 * JD-Core Version:    0.7.0.1
 */