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
  private static final String a = "TeamWorkForceShare";
  private WebViewPlugin b;
  private AppInterface c;
  private Activity d;
  private String e;
  private String f;
  private ShareActionSheet g;
  private QQProgressDialog h;
  private String i = null;
  
  public TeamWorkForceShare(WebViewPlugin paramWebViewPlugin, JSONObject paramJSONObject)
  {
    this.b = paramWebViewPlugin;
    this.c = paramWebViewPlugin.mRuntime.b();
    this.d = paramWebViewPlugin.mRuntime.d();
    this.e = paramJSONObject.optString("img_url");
    this.f = paramJSONObject.optString("callback");
  }
  
  private void e()
  {
    ThreadManager.post(new TeamWorkForceShare.ImageRequestTask(this, this.e, this), 8, null, true);
  }
  
  public void a()
  {
    this.h = new QQProgressDialog(this.d);
    this.h.show();
    e();
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.d.runOnUiThread(new TeamWorkForceShare.1(this, paramBitmap));
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    return localArrayList;
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem> c()
  {
    return new ArrayList();
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.b.onActivityResult(new Intent(), (byte)17, -1);
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (this.g.isShowing()) {
      this.g.dismiss();
    }
    int j = paramActionSheetItem.action;
    paramShareActionSheet = a;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("action = ");
    ((StringBuilder)localObject1).append(paramActionSheetItem.action);
    QLog.d(paramShareActionSheet, 1, ((StringBuilder)localObject1).toString());
    if (j != 2)
    {
      if (j != 3)
      {
        if ((j != 9) && (j != 10))
        {
          if (j != 72) {
            return;
          }
          paramShareActionSheet = new Bundle();
          paramShareActionSheet.putInt("key_req", 1);
          paramShareActionSheet.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
          paramShareActionSheet.putString("key_direct_show_uin", paramActionSheetItem.uin);
          this.b.callJs(this.f, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
          paramActionSheetItem = ((QQBrowserActivity)this.d).getCurrentWebViewFragment();
          if (paramActionSheetItem == null)
          {
            QLog.d(a, 1, "fragment == null");
            return;
          }
          localObject1 = (Share)paramActionSheetItem.getShare();
          if (localObject1 == null)
          {
            QLog.d(a, 1, "share == null");
            return;
          }
          paramActionSheetItem = new Bundle();
          paramActionSheetItem.putBoolean("key_flag_from_plugin", true);
          paramActionSheetItem.putString("pluginName", "web_share");
          paramActionSheetItem.putString("struct_share_key_source_icon", "https://docs.qq.com/desktop/favicon.ico");
          paramActionSheetItem.putString("app_name", ((Share)localObject1).h());
          paramActionSheetItem.putString("struct_share_key_source_action", "web");
          paramActionSheetItem.putString("struct_share_key_source_url", "https://docs.qq.com/desktop/m/index.html?_wv=2");
          str = ((Share)localObject1).d();
          paramActionSheetItem.putString("detail_url", ((Share)localObject1).getShareUrl());
          paramActionSheetItem.putString("title", str);
          paramActionSheetItem.putString("desc", ((Share)localObject1).e());
          paramActionSheetItem.putString("struct_share_key_content_action", "web");
          paramActionSheetItem.putInt("forward_type", 1001);
          paramActionSheetItem.putString("image_url_remote", ((Share)localObject1).f());
          paramActionSheetItem.putInt("emoInputType", 2);
          localObject2 = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("title = ");
          localStringBuilder.append(str);
          localStringBuilder.append(", desc = ");
          localStringBuilder.append(((Share)localObject1).e());
          localStringBuilder.append(", url = ");
          localStringBuilder.append(((Share)localObject1).getShareUrl());
          QLog.d((String)localObject2, 1, localStringBuilder.toString());
          paramActionSheetItem.putString("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
          paramActionSheetItem.putBoolean("k_back", true);
          paramActionSheetItem.putString("brief_key", this.d.getString(2131894173, new Object[] { str }));
          paramActionSheetItem.putByteArray("stuctmsg_bytes", StructMsgFactory.a(paramActionSheetItem).getBytes());
          localObject1 = new Intent();
          ((Intent)localObject1).putExtras(paramActionSheetItem);
          ((Intent)localObject1).putExtras(paramShareActionSheet);
          ForwardBaseOption.a(this.d, (Intent)localObject1, ForwardRecentTranslucentActivity.class, WebViewUtil.a("docx") << 8 | 0x12, -1, "");
          return;
        }
        boolean bool;
        if (j == 9) {
          bool = true;
        } else {
          bool = false;
        }
        if (bool) {
          j = 3;
        } else {
          j = 4;
        }
        if (!WXShareHelper.a().b())
        {
          QQToast.makeText(this.d, 2131918154, 1).show();
          QLog.d(a, 1, "wx not installed");
          this.b.callJs(this.f, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(1), "wx not installed" }) });
          return;
        }
        if (!WXShareHelper.a().c())
        {
          QQToast.makeText(this.d, 2131918155, 1).show();
          QLog.d(a, 1, "wx version too low");
          this.b.callJs(this.f, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(2), "wx version too low" }) });
          return;
        }
        this.b.callJs(this.f, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
        ThreadManager.postImmediately(new TeamWorkForceShare.2(this, bool), null, true);
        return;
      }
      this.b.callJs(this.f, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
      paramActionSheetItem = AbsDownloader.getFilePath(this.e);
      paramShareActionSheet = QZoneHelper.UserInfo.getInstance();
      localObject1 = this.c;
      if (localObject1 != null)
      {
        paramShareActionSheet.qzone_uin = ((AppInterface)localObject1).getAccount();
        localObject1 = this.c;
        if ((localObject1 instanceof VideoAppInterface)) {
          paramShareActionSheet.nickname = ((VideoAppInterface)localObject1).a(0, ((AppInterface)localObject1).getCurrentAccountUin(), null);
        } else {
          paramShareActionSheet.nickname = null;
        }
      }
      QZoneHelper.forwardToPublishMood(this.d, paramShareActionSheet, paramActionSheetItem, BaseApplication.getContext().getString(2131889086), "", WebViewUtil.a("docx") << 8 | 0x34);
      return;
    }
    this.b.callJs(this.f, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
    paramActionSheetItem = ((QQBrowserActivity)this.d).getCurrentWebViewFragment();
    if (paramActionSheetItem == null)
    {
      QLog.d(a, 1, "fragment == null");
      return;
    }
    paramShareActionSheet = (Share)paramActionSheetItem.getShare();
    if (paramShareActionSheet == null)
    {
      QLog.d(a, 1, "share == null");
      return;
    }
    paramActionSheetItem = new Bundle();
    paramActionSheetItem.putBoolean("key_flag_from_plugin", true);
    paramActionSheetItem.putString("pluginName", "web_share");
    paramActionSheetItem.putString("struct_share_key_source_icon", "https://docs.qq.com/desktop/favicon.ico");
    paramActionSheetItem.putString("app_name", paramShareActionSheet.h());
    paramActionSheetItem.putString("struct_share_key_source_action", "web");
    paramActionSheetItem.putString("struct_share_key_source_url", "https://docs.qq.com/desktop/m/index.html?_wv=2");
    localObject1 = paramShareActionSheet.d();
    paramActionSheetItem.putString("detail_url", paramShareActionSheet.getShareUrl());
    paramActionSheetItem.putString("title", (String)localObject1);
    paramActionSheetItem.putString("desc", paramShareActionSheet.e());
    paramActionSheetItem.putString("struct_share_key_content_action", "web");
    paramActionSheetItem.putInt("forward_type", 1001);
    paramActionSheetItem.putString("image_url_remote", paramShareActionSheet.f());
    paramActionSheetItem.putInt("emoInputType", 2);
    String str = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("title = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(", desc = ");
    ((StringBuilder)localObject2).append(paramShareActionSheet.e());
    ((StringBuilder)localObject2).append(", url = ");
    ((StringBuilder)localObject2).append(paramShareActionSheet.getShareUrl());
    QLog.d(str, 1, ((StringBuilder)localObject2).toString());
    paramActionSheetItem.putString("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    paramActionSheetItem.putBoolean("k_back", true);
    paramActionSheetItem.putString("brief_key", this.d.getString(2131894173, new Object[] { localObject1 }));
    paramActionSheetItem.putByteArray("stuctmsg_bytes", StructMsgFactory.a(paramActionSheetItem).getBytes());
    paramShareActionSheet = new Intent();
    paramShareActionSheet.putExtras(paramActionSheetItem);
    ForwardBaseOption.a(this.d, paramShareActionSheet, WebViewUtil.a("docx") << 8 | 0x12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare
 * JD-Core Version:    0.7.0.1
 */