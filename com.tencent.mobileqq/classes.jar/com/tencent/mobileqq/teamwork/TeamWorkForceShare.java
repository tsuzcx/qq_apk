package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import aphp;
import awuw;
import axdl;
import axfs;
import axoa;
import bahv;
import bahx;
import baia;
import bbac;
import bbms;
import bbmy;
import bfpr;
import bfpy;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import xdt;

public class TeamWorkForceShare
  implements DialogInterface.OnCancelListener, AdapterView.OnItemClickListener, axdl
{
  private static final String jdField_a_of_type_JavaLangString = TeamWorkForceShare.class.getSimpleName();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bahv jdField_a_of_type_Bahv;
  private bbms jdField_a_of_type_Bbms;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private WebViewPlugin jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin;
  private String b;
  private String c;
  private String d;
  
  public TeamWorkForceShare(WebViewPlugin paramWebViewPlugin, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin = paramWebViewPlugin;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramWebViewPlugin.mRuntime.a();
    this.jdField_a_of_type_AndroidAppActivity = paramWebViewPlugin.mRuntime.a();
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("img_url");
    this.c = paramJSONObject.optString("callback");
  }
  
  private void b()
  {
    ThreadManager.post(new TeamWorkForceShare.ImageRequestTask(this, this.jdField_b_of_type_JavaLangString, this), 8, null, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bbms = new bbms(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Bbms.show();
    b();
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new TeamWorkForceShare.1(this, paramBitmap));
  }
  
  protected List<bahx>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    bahx localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131630983);
    localbahx.jdField_b_of_type_Int = 2130838732;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.c = 2;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131630996);
    localbahx.jdField_b_of_type_Int = 2130838733;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.c = 3;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131631003);
    localbahx.jdField_b_of_type_Int = 2130838736;
    localbahx.c = 9;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131630986);
    localbahx.jdField_b_of_type_Int = 2130838730;
    localbahx.c = 10;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.onActivityResult(new Intent(), (byte)17, -1);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "tag == null");
      return;
    }
    if (this.jdField_a_of_type_Bahv.a()) {
      this.jdField_a_of_type_Bahv.b();
    }
    paramAdapterView = ((baia)paramAdapterView).a;
    paramInt = paramAdapterView.c;
    QLog.d(jdField_a_of_type_JavaLangString, 1, "action = " + paramAdapterView.c);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
      paramAdapterView = ((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).b();
      if (paramAdapterView == null)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "fragment == null");
        return;
      }
      paramView = paramAdapterView.a();
      if (paramView == null)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "share == null");
        return;
      }
      paramAdapterView = new Bundle();
      paramAdapterView.putBoolean("key_flag_from_plugin", true);
      paramAdapterView.putString("pluginName", "web_share");
      paramAdapterView.putString("struct_share_key_source_icon", axfs.d);
      paramAdapterView.putString("app_name", paramView.f());
      paramAdapterView.putString("struct_share_key_source_action", "web");
      paramAdapterView.putString("struct_share_key_source_url", axfs.jdField_b_of_type_JavaLangString);
      String str = paramView.b();
      paramAdapterView.putString("detail_url", paramView.a());
      paramAdapterView.putString("title", str);
      paramAdapterView.putString("desc", paramView.c());
      paramAdapterView.putString("struct_share_key_content_action", "web");
      paramAdapterView.putInt("forward_type", 1001);
      paramAdapterView.putString("image_url_remote", paramView.d());
      paramAdapterView.putInt("emoInputType", 2);
      QLog.d(jdField_a_of_type_JavaLangString, 1, "title = " + str + ", desc = " + paramView.c() + ", url = " + paramView.a());
      paramAdapterView.putString("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
      paramAdapterView.putBoolean("k_back", true);
      paramAdapterView.putString("brief_key", this.jdField_a_of_type_AndroidAppActivity.getString(2131630985, new Object[] { str }));
      paramAdapterView.putByteArray("stuctmsg_bytes", awuw.a(paramAdapterView).getBytes());
      paramView = new Intent();
      paramView.putExtras(paramAdapterView);
      aphp.a(this.jdField_a_of_type_AndroidAppActivity, paramView, 34322);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
      paramAdapterView = axoa.d(this.jdField_b_of_type_JavaLangString);
      paramView = bfpy.a();
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
      {
        paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
        paramView.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getDisplayName(0, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), null);
      }
      bfpr.a(this.jdField_a_of_type_AndroidAppActivity, paramView, paramAdapterView, BaseApplication.getContext().getString(2131626640), "", 34356);
      return;
    }
    boolean bool;
    if (paramInt == 9)
    {
      bool = true;
      if (!bool) {
        break label745;
      }
    }
    label745:
    for (paramInt = 3;; paramInt = 4)
    {
      if (WXShareHelper.a().a()) {
        break label750;
      }
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 2131655008, 1).a();
      QLog.d(jdField_a_of_type_JavaLangString, 1, "wx not installed");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Integer.valueOf(1), "wx not installed" }) });
      return;
      bool = false;
      break;
    }
    label750:
    if (!WXShareHelper.a().b())
    {
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 2131655009, 1).a();
      QLog.d(jdField_a_of_type_JavaLangString, 1, "wx version too low");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Integer.valueOf(2), "wx version too low" }) });
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
    ThreadManager.postImmediately(new TeamWorkForceShare.2(this, bool), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare
 * JD-Core Version:    0.7.0.1
 */