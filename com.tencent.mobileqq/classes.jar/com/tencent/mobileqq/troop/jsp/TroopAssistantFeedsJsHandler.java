package com.tencent.mobileqq.troop.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class TroopAssistantFeedsJsHandler
  extends WebViewPlugin
{
  protected TroopMemberApiClient a = null;
  protected AtomicBoolean b = new AtomicBoolean(false);
  
  public TroopAssistantFeedsJsHandler()
  {
    this.mPluginNameSpace = "troopAssistantFeeds";
  }
  
  protected void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("openTroopFeeds:");
        localStringBuilder.append(paramString);
        QLog.d("TroopAssistantFeedsJsHandler", 2, localStringBuilder.toString());
      }
      if (TextUtils.isEmpty(new JSONObject(paramString).getString("url"))) {
        return;
      }
      QQToast.makeText(this.mRuntime.d(), 0, HardCodeUtil.a(2131912482), 0).show();
      return;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("openTroopFeeds:");
        localStringBuilder.append(paramString.toString());
        QLog.d("TroopAssistantFeedsJsHandler", 2, localStringBuilder.toString());
      }
    }
  }
  
  protected void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramString.getString("guin");
      paramString.getString("gcode");
      c(paramString.getString("videourl"));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void c(String paramString)
  {
    Object localObject1 = "?";
    try
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("openVideoInBrowserActivity:");
        ((StringBuilder)localObject2).append(paramString);
        QLog.d("TroopAssistantFeedsJsHandler", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = this.mRuntime.d();
      paramString = paramString.trim();
      String str = this.mRuntime.b().getCurrentAccountUin();
      Intent localIntent = new Intent((Context)localObject2, QQBrowserDelegationActivity.class);
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      int i = paramString.indexOf("?");
      paramString = (String)localObject1;
      if (i > 0) {
        paramString = "";
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append("&from=androidqq");
      localIntent.putExtra("param_force_internal_browser", true);
      localIntent.putExtra("injectrecommend", false);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", localStringBuilder.toString().trim());
      localIntent.putExtra("uin", str);
      localIntent.putExtra("friendUin", "");
      ((Activity)localObject2).startActivity(localIntent);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("openVideoInBrowserActivity:");
        ((StringBuilder)localObject1).append(paramString.toString());
        QLog.d("TroopAssistantFeedsJsHandler", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  protected void d(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openTroopCard:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("TroopAssistantFeedsJsHandler", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("guin");
      localObject = ((JSONObject)localObject).getString("gcode");
      if (!TextUtils.isEmpty(paramString))
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        Activity localActivity = this.mRuntime.d();
        Bundle localBundle = TroopInfoUIUtil.a(String.valueOf(localObject), 6);
        localBundle.putString("troop_code", paramString);
        localBundle.putString("troop_uin", (String)localObject);
        localBundle.putInt("troop_uin", 6);
        TroopUtils.a(localActivity, localBundle, 2);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openTroopCard:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.d("TroopAssistantFeedsJsHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  protected void e(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("openTroopMemberCard:");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("TroopAssistantFeedsJsHandler", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject2 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject2).getString("guin");
      localObject1 = ((JSONObject)localObject2).getString("gcode");
      localObject2 = ((JSONObject)localObject2).getString("muin");
      Object localObject3 = this.mRuntime.b().getCurrentAccountUin();
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          return;
        }
        localObject3 = this.mRuntime.d();
        Intent localIntent = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly((Context)localObject3, null);
        localIntent.putExtra("troopUin", (String)localObject1);
        localIntent.putExtra("troopCode", paramString);
        localIntent.putExtra("memberUin", (String)localObject2);
        localIntent.putExtra("fromFlag", 3);
        ((Activity)localObject3).startActivity(localIntent);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("openTroopMemberCard:");
        ((StringBuilder)localObject1).append(paramString.toString());
        QLog.d("TroopAssistantFeedsJsHandler", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  protected void f(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("openTroopAIO:");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("TroopAssistantFeedsJsHandler", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject2 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject2).getString("guin");
      localObject1 = ((JSONObject)localObject2).getString("gcode");
      localObject2 = ((JSONObject)localObject2).getString("gname");
      if (!TextUtils.isEmpty(paramString))
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        Activity localActivity = this.mRuntime.d();
        Intent localIntent = AIOUtils.a(new Intent(localActivity, SplashActivity.class), null);
        localIntent.putExtra("uin", (String)localObject1);
        localIntent.putExtra("troop_uin", paramString);
        localIntent.putExtra("uintype", 1);
        localIntent.putExtra("uinname", (String)localObject2);
        localActivity.startActivity(localIntent);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("openTroopAIO:");
        ((StringBuilder)localObject1).append(paramString.toString());
        QLog.d("TroopAssistantFeedsJsHandler", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  protected void g(String paramString)
  {
    for (;;)
    {
      long l1;
      try
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("openFile:");
          localStringBuilder.append(paramString);
          QLog.d("TroopAssistantFeedsJsHandler", 2, localStringBuilder.toString());
        }
        localObject3 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject3).getString("uuid");
        l1 = 0L;
        try
        {
          l3 = ((JSONObject)localObject3).getLong("fileSize");
          l2 = ((JSONObject)localObject3).getLong("gcode");
          l1 = l3;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break label371;
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("openFile:");
        ((StringBuilder)localObject2).append(localException.toString());
        QLog.d("TroopAssistantFeedsJsHandler", 2, ((StringBuilder)localObject2).toString());
      }
      catch (Exception paramString) {}
      Object localObject1 = ((JSONObject)localObject3).getString("fileName");
      Object localObject2 = ((JSONObject)localObject3).getString("url");
      int i = ((JSONObject)localObject3).getInt("bisID");
      Object localObject4 = ((JSONObject)localObject3).optString("senderUin");
      long l3 = ((JSONObject)localObject3).optLong("lastTime");
      Object localObject3 = this.mRuntime.d();
      Intent localIntent = new Intent((Context)localObject3, TroopFileDetailBrowserActivity.class);
      try
      {
        localIntent.putExtra("from_webview", true);
        localIntent.putExtra("bisId", i);
        localIntent.putExtra("sender_uin", (String)localObject4);
        localIntent.putExtra("last_time", l3);
        localObject4 = new ForwardFileInfo();
        ((ForwardFileInfo)localObject4).d(4);
        ((ForwardFileInfo)localObject4).b(10006);
        ((ForwardFileInfo)localObject4).d((String)localObject1);
        ((ForwardFileInfo)localObject4).d(l1);
        ((ForwardFileInfo)localObject4).a(l2);
        ((ForwardFileInfo)localObject4).b(paramString);
        ((ForwardFileInfo)localObject4).e((String)localObject2);
        localIntent.putExtra("fileinfo", (Parcelable)localObject4);
        ((Activity)localObject3).startActivity(localIntent);
        return;
      }
      catch (Exception paramString) {}
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("openFile:");
        ((StringBuilder)localObject1).append(paramString.toString());
        QLog.d("TroopAssistantFeedsJsHandler", 2, ((StringBuilder)localObject1).toString());
      }
      return;
      label371:
      long l2 = 0L;
    }
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 3L;
  }
  
  protected void h(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openQZoneAlbumDetail:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("TroopAssistantFeedsJsHandler", 2, ((StringBuilder)localObject).toString());
      }
      paramString = new JSONObject(paramString).getString("url");
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject = this.mRuntime.b();
      Activity localActivity = this.mRuntime.d();
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = ((AppInterface)localObject).getCurrentAccountUin();
      localUserInfo.nickname = "";
      QZoneHelper.forwardToQunAlbumDetail(localActivity, localUserInfo, paramString, "mqqChat.QzoneCard", -1);
      return;
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openQZoneAlbumDetail:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.d("TroopAssistantFeedsJsHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("troopAssistantFeeds".equals(paramString2))
    {
      if (("openGroupCard".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        d(paramVarArgs[0]);
        return true;
      }
      if (("openGroupMemCard".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        e(paramVarArgs[0]);
        return true;
      }
      if (("openGroupAIO".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        f(paramVarArgs[0]);
        return true;
      }
      if (("openGroupFileDetail".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        g(paramVarArgs[0]);
        return true;
      }
      if (("openGroupPhotoDetail".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        h(paramVarArgs[0]);
        return true;
      }
      if (("openVideo".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        b(paramVarArgs[0]);
        return true;
      }
      if (("openGroupFeedsDetail".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        a(paramVarArgs[0]);
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  protected void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 365	com/tencent/mobileqq/webview/swift/WebViewPlugin:onDestroy	()V
    //   4: aload_0
    //   5: getfield 14	com/tencent/mobileqq/troop/jsp/TroopAssistantFeedsJsHandler:a	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   8: ifnull +24 -> 32
    //   11: aload_0
    //   12: getfield 14	com/tencent/mobileqq/troop/jsp/TroopAssistantFeedsJsHandler:a	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   15: invokevirtual 369	com/tencent/biz/troop/TroopMemberApiClient:f	()V
    //   18: goto +14 -> 32
    //   21: astore_1
    //   22: aload_0
    //   23: getfield 21	com/tencent/mobileqq/troop/jsp/TroopAssistantFeedsJsHandler:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   26: iconst_0
    //   27: invokevirtual 372	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   30: aload_1
    //   31: athrow
    //   32: aload_0
    //   33: getfield 21	com/tencent/mobileqq/troop/jsp/TroopAssistantFeedsJsHandler:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   36: iconst_0
    //   37: invokevirtual 372	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   40: return
    //   41: astore_1
    //   42: goto -10 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	TroopAssistantFeedsJsHandler
    //   21	10	1	localObject	Object
    //   41	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   4	18	21	finally
    //   4	18	41	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jsp.TroopAssistantFeedsJsHandler
 * JD-Core Version:    0.7.0.1
 */