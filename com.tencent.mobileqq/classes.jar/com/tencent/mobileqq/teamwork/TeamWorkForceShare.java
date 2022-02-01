package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class TeamWorkForceShare
  implements DialogInterface.OnCancelListener, BitmapDecodedListener, ShareActionSheet.OnItemClickListener
{
  private static final String jdField_a_of_type_JavaLangString = TeamWorkForceShare.class.getSimpleName();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private WebViewPlugin jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  private String b;
  private String c;
  private String d = null;
  
  public TeamWorkForceShare(WebViewPlugin paramWebViewPlugin, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin = paramWebViewPlugin;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramWebViewPlugin.mRuntime.a();
    this.jdField_a_of_type_AndroidAppActivity = paramWebViewPlugin.mRuntime.a();
    this.b = paramJSONObject.optString("img_url");
    this.c = paramJSONObject.optString("callback");
  }
  
  private void b()
  {
    ThreadManager.post(new TeamWorkForceShare.ImageRequestTask(this, this.b, this), 8, null, true);
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    b();
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new TeamWorkForceShare.1(this, paramBitmap));
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem> b()
  {
    return new ArrayList();
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.onActivityResult(new Intent(), (byte)17, -1);
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
    int i = paramActionSheetItem.action;
    QLog.d(jdField_a_of_type_JavaLangString, 1, "action = " + paramActionSheetItem.action);
    Object localObject;
    switch (i)
    {
    default: 
      return;
    case 72: 
      paramShareActionSheet = new Bundle();
      paramShareActionSheet.putInt("key_req", ForwardRecentActivity.f);
      paramShareActionSheet.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
      paramShareActionSheet.putString("key_direct_show_uin", paramActionSheetItem.uin);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
      paramActionSheetItem = ((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).getCurrentWebViewFragment();
      if (paramActionSheetItem == null)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "fragment == null");
        return;
      }
      localObject = paramActionSheetItem.getShare();
      if (localObject == null)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "share == null");
        return;
      }
      paramActionSheetItem = new Bundle();
      paramActionSheetItem.putBoolean("key_flag_from_plugin", true);
      paramActionSheetItem.putString("pluginName", "web_share");
      paramActionSheetItem.putString("struct_share_key_source_icon", TeamWorkUtils.d);
      paramActionSheetItem.putString("app_name", ((Share)localObject).f());
      paramActionSheetItem.putString("struct_share_key_source_action", "web");
      paramActionSheetItem.putString("struct_share_key_source_url", TeamWorkUtils.b);
      String str = ((Share)localObject).b();
      paramActionSheetItem.putString("detail_url", ((Share)localObject).a());
      paramActionSheetItem.putString("title", str);
      paramActionSheetItem.putString("desc", ((Share)localObject).c());
      paramActionSheetItem.putString("struct_share_key_content_action", "web");
      paramActionSheetItem.putInt("forward_type", 1001);
      paramActionSheetItem.putString("image_url_remote", ((Share)localObject).d());
      paramActionSheetItem.putInt("emoInputType", 2);
      QLog.d(jdField_a_of_type_JavaLangString, 1, "title = " + str + ", desc = " + ((Share)localObject).c() + ", url = " + ((Share)localObject).a());
      paramActionSheetItem.putString("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
      paramActionSheetItem.putBoolean("k_back", true);
      paramActionSheetItem.putString("brief_key", this.jdField_a_of_type_AndroidAppActivity.getString(2131696382, new Object[] { str }));
      paramActionSheetItem.putByteArray("stuctmsg_bytes", StructMsgFactory.a(paramActionSheetItem).getBytes());
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramActionSheetItem);
      ((Intent)localObject).putExtras(paramShareActionSheet);
      ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject, ForwardRecentTranslucentActivity.class, WebViewUtil.a("docx") << 8 | 0x12, -1, "");
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
      paramActionSheetItem = ((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).getCurrentWebViewFragment();
      if (paramActionSheetItem == null)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "fragment == null");
        return;
      }
      paramShareActionSheet = paramActionSheetItem.getShare();
      if (paramShareActionSheet == null)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "share == null");
        return;
      }
      paramActionSheetItem = new Bundle();
      paramActionSheetItem.putBoolean("key_flag_from_plugin", true);
      paramActionSheetItem.putString("pluginName", "web_share");
      paramActionSheetItem.putString("struct_share_key_source_icon", TeamWorkUtils.d);
      paramActionSheetItem.putString("app_name", paramShareActionSheet.f());
      paramActionSheetItem.putString("struct_share_key_source_action", "web");
      paramActionSheetItem.putString("struct_share_key_source_url", TeamWorkUtils.b);
      localObject = paramShareActionSheet.b();
      paramActionSheetItem.putString("detail_url", paramShareActionSheet.a());
      paramActionSheetItem.putString("title", (String)localObject);
      paramActionSheetItem.putString("desc", paramShareActionSheet.c());
      paramActionSheetItem.putString("struct_share_key_content_action", "web");
      paramActionSheetItem.putInt("forward_type", 1001);
      paramActionSheetItem.putString("image_url_remote", paramShareActionSheet.d());
      paramActionSheetItem.putInt("emoInputType", 2);
      QLog.d(jdField_a_of_type_JavaLangString, 1, "title = " + (String)localObject + ", desc = " + paramShareActionSheet.c() + ", url = " + paramShareActionSheet.a());
      paramActionSheetItem.putString("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
      paramActionSheetItem.putBoolean("k_back", true);
      paramActionSheetItem.putString("brief_key", this.jdField_a_of_type_AndroidAppActivity.getString(2131696382, new Object[] { localObject }));
      paramActionSheetItem.putByteArray("stuctmsg_bytes", StructMsgFactory.a(paramActionSheetItem).getBytes());
      paramShareActionSheet = new Intent();
      paramShareActionSheet.putExtras(paramActionSheetItem);
      ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, paramShareActionSheet, WebViewUtil.a("docx") << 8 | 0x12);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
      paramActionSheetItem = AbsDownloader.getFilePath(this.b);
      paramShareActionSheet = QZoneHelper.UserInfo.getInstance();
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
      {
        paramShareActionSheet.qzone_uin = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
        if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof VideoAppInterface)) {
          break label1094;
        }
      }
      label1094:
      for (paramShareActionSheet.nickname = ((VideoAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(0, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), null);; paramShareActionSheet.nickname = null)
      {
        QZoneHelper.forwardToPublishMood(this.jdField_a_of_type_AndroidAppActivity, paramShareActionSheet, paramActionSheetItem, BaseApplication.getContext().getString(2131692179), "", WebViewUtil.a("docx") << 8 | 0x34);
        return;
      }
    }
    boolean bool;
    if (i == 9)
    {
      bool = true;
      if (!bool) {
        break label1213;
      }
    }
    label1213:
    for (i = 3;; i = 4)
    {
      if (WXShareHelper.a().a()) {
        break label1218;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131720753, 1).a();
      QLog.d(jdField_a_of_type_JavaLangString, 1, "wx not installed");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1), "wx not installed" }) });
      return;
      bool = false;
      break;
    }
    label1218:
    if (!WXShareHelper.a().b())
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131720754, 1).a();
      QLog.d(jdField_a_of_type_JavaLangString, 1, "wx version too low");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(2), "wx version too low" }) });
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
    ThreadManager.postImmediately(new TeamWorkForceShare.2(this, bool), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare
 * JD-Core Version:    0.7.0.1
 */