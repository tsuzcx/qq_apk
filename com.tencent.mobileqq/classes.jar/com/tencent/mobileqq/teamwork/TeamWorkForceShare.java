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
  private static final String jdField_a_of_type_JavaLangString = "TeamWorkForceShare";
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
    paramShareActionSheet = jdField_a_of_type_JavaLangString;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("action = ");
    ((StringBuilder)localObject1).append(paramActionSheetItem.action);
    QLog.d(paramShareActionSheet, 1, ((StringBuilder)localObject1).toString());
    if (i != 2)
    {
      if (i != 3)
      {
        if ((i != 9) && (i != 10))
        {
          if (i != 72) {
            return;
          }
          paramShareActionSheet = new Bundle();
          paramShareActionSheet.putInt("key_req", 1);
          paramShareActionSheet.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
          paramShareActionSheet.putString("key_direct_show_uin", paramActionSheetItem.uin);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
          paramActionSheetItem = ((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).getCurrentWebViewFragment();
          if (paramActionSheetItem == null)
          {
            QLog.d(jdField_a_of_type_JavaLangString, 1, "fragment == null");
            return;
          }
          localObject1 = (Share)paramActionSheetItem.getShare();
          if (localObject1 == null)
          {
            QLog.d(jdField_a_of_type_JavaLangString, 1, "share == null");
            return;
          }
          paramActionSheetItem = new Bundle();
          paramActionSheetItem.putBoolean("key_flag_from_plugin", true);
          paramActionSheetItem.putString("pluginName", "web_share");
          paramActionSheetItem.putString("struct_share_key_source_icon", "https://docs.qq.com/desktop/favicon.ico");
          paramActionSheetItem.putString("app_name", ((Share)localObject1).e());
          paramActionSheetItem.putString("struct_share_key_source_action", "web");
          paramActionSheetItem.putString("struct_share_key_source_url", "https://docs.qq.com/desktop/m/index.html?_wv=2");
          str = ((Share)localObject1).a();
          paramActionSheetItem.putString("detail_url", ((Share)localObject1).getShareUrl());
          paramActionSheetItem.putString("title", str);
          paramActionSheetItem.putString("desc", ((Share)localObject1).b());
          paramActionSheetItem.putString("struct_share_key_content_action", "web");
          paramActionSheetItem.putInt("forward_type", 1001);
          paramActionSheetItem.putString("image_url_remote", ((Share)localObject1).c());
          paramActionSheetItem.putInt("emoInputType", 2);
          localObject2 = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("title = ");
          localStringBuilder.append(str);
          localStringBuilder.append(", desc = ");
          localStringBuilder.append(((Share)localObject1).b());
          localStringBuilder.append(", url = ");
          localStringBuilder.append(((Share)localObject1).getShareUrl());
          QLog.d((String)localObject2, 1, localStringBuilder.toString());
          paramActionSheetItem.putString("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
          paramActionSheetItem.putBoolean("k_back", true);
          paramActionSheetItem.putString("brief_key", this.jdField_a_of_type_AndroidAppActivity.getString(2131696401, new Object[] { str }));
          paramActionSheetItem.putByteArray("stuctmsg_bytes", StructMsgFactory.a(paramActionSheetItem).getBytes());
          localObject1 = new Intent();
          ((Intent)localObject1).putExtras(paramActionSheetItem);
          ((Intent)localObject1).putExtras(paramShareActionSheet);
          ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject1, ForwardRecentTranslucentActivity.class, WebViewUtil.a("docx") << 8 | 0x12, -1, "");
          return;
        }
        boolean bool;
        if (i == 9) {
          bool = true;
        } else {
          bool = false;
        }
        if (bool) {
          i = 3;
        } else {
          i = 4;
        }
        if (!WXShareHelper.a().a())
        {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131720478, 1).a();
          QLog.d(jdField_a_of_type_JavaLangString, 1, "wx not installed");
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1), "wx not installed" }) });
          return;
        }
        if (!WXShareHelper.a().b())
        {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131720479, 1).a();
          QLog.d(jdField_a_of_type_JavaLangString, 1, "wx version too low");
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(2), "wx version too low" }) });
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
        ThreadManager.postImmediately(new TeamWorkForceShare.2(this, bool), null, true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
      paramActionSheetItem = AbsDownloader.getFilePath(this.b);
      paramShareActionSheet = QZoneHelper.UserInfo.getInstance();
      localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      if (localObject1 != null)
      {
        paramShareActionSheet.qzone_uin = ((AppInterface)localObject1).getAccount();
        localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
        if ((localObject1 instanceof VideoAppInterface)) {
          paramShareActionSheet.nickname = ((VideoAppInterface)localObject1).a(0, ((AppInterface)localObject1).getCurrentAccountUin(), null);
        } else {
          paramShareActionSheet.nickname = null;
        }
      }
      QZoneHelper.forwardToPublishMood(this.jdField_a_of_type_AndroidAppActivity, paramShareActionSheet, paramActionSheetItem, BaseApplication.getContext().getString(2131692105), "", WebViewUtil.a("docx") << 8 | 0x34);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
    paramActionSheetItem = ((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).getCurrentWebViewFragment();
    if (paramActionSheetItem == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "fragment == null");
      return;
    }
    paramShareActionSheet = (Share)paramActionSheetItem.getShare();
    if (paramShareActionSheet == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "share == null");
      return;
    }
    paramActionSheetItem = new Bundle();
    paramActionSheetItem.putBoolean("key_flag_from_plugin", true);
    paramActionSheetItem.putString("pluginName", "web_share");
    paramActionSheetItem.putString("struct_share_key_source_icon", "https://docs.qq.com/desktop/favicon.ico");
    paramActionSheetItem.putString("app_name", paramShareActionSheet.e());
    paramActionSheetItem.putString("struct_share_key_source_action", "web");
    paramActionSheetItem.putString("struct_share_key_source_url", "https://docs.qq.com/desktop/m/index.html?_wv=2");
    localObject1 = paramShareActionSheet.a();
    paramActionSheetItem.putString("detail_url", paramShareActionSheet.getShareUrl());
    paramActionSheetItem.putString("title", (String)localObject1);
    paramActionSheetItem.putString("desc", paramShareActionSheet.b());
    paramActionSheetItem.putString("struct_share_key_content_action", "web");
    paramActionSheetItem.putInt("forward_type", 1001);
    paramActionSheetItem.putString("image_url_remote", paramShareActionSheet.c());
    paramActionSheetItem.putInt("emoInputType", 2);
    String str = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("title = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(", desc = ");
    ((StringBuilder)localObject2).append(paramShareActionSheet.b());
    ((StringBuilder)localObject2).append(", url = ");
    ((StringBuilder)localObject2).append(paramShareActionSheet.getShareUrl());
    QLog.d(str, 1, ((StringBuilder)localObject2).toString());
    paramActionSheetItem.putString("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    paramActionSheetItem.putBoolean("k_back", true);
    paramActionSheetItem.putString("brief_key", this.jdField_a_of_type_AndroidAppActivity.getString(2131696401, new Object[] { localObject1 }));
    paramActionSheetItem.putByteArray("stuctmsg_bytes", StructMsgFactory.a(paramActionSheetItem).getBytes());
    paramShareActionSheet = new Intent();
    paramShareActionSheet.putExtras(paramActionSheetItem);
    ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, paramShareActionSheet, WebViewUtil.a("docx") << 8 | 0x12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare
 * JD-Core Version:    0.7.0.1
 */