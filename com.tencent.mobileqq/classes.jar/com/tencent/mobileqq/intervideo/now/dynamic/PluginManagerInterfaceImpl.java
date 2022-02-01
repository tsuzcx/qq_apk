package com.tencent.mobileqq.intervideo.now.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.now.NowRecordInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.INowDownloadManager;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.impl.NowDownloadTaskInfo;
import com.tencent.mobileqq.intervideo.now.NowDataReporter;
import com.tencent.mobileqq.intervideo.now.dynamic.channelImpl.NowChannerHandlerV2;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJDeliverUGCUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.CommonCallback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class PluginManagerInterfaceImpl
  implements IPluginManagerInterfaceImpl
{
  private static volatile PluginManagerInterfaceImpl c;
  public NowDataReporter a;
  boolean b = false;
  private INowDownloadManager d;
  
  public static PluginManagerInterfaceImpl a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new PluginManagerInterfaceImpl();
        }
      }
      finally {}
    }
    return c;
  }
  
  public static void b()
  {
    if (c != null) {
      c.c();
    }
  }
  
  private static QQAppInterface g()
  {
    return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public String a(String paramString)
  {
    return InnerDns.getInstance().reqDns(paramString, 1017);
  }
  
  public Future<Bundle> a(String paramString1, String paramString2)
  {
    return ThreadManagerExecutor.getExecutorService(128).submit(new PluginManagerInterfaceImpl.GetAccessTokenBundle(this, paramString2, paramString1));
  }
  
  public Future<Bundle> a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return ThreadManagerExecutor.getExecutorService(128).submit(new PluginManagerInterfaceImpl.4(this, paramString1, paramString2, paramString3, paramString4, paramString5));
  }
  
  public void a(Bundle paramBundle)
  {
    QLog.i(paramBundle.getString("tag", "nowplugin_dynamic"), 1, paramBundle.getString("msg", ""));
  }
  
  public void a(Bundle paramBundle, Object paramObject)
  {
    try
    {
      paramObject = (DownloadCallback)paramObject;
      String str = paramBundle.getString("url", "");
      paramBundle = paramBundle.getString("path", "");
      this.d = ((INowDownloadManager)QRoute.api(INowDownloadManager.class)).createObject(true);
      this.d.init(BaseApplicationImpl.getContext());
      this.d.addDownloadListener(str, new PluginManagerInterfaceImpl.2(this, paramObject, str));
      this.d.addNowDownloadTask(NowDownloadTaskInfo.a(str, "com.tencent.now", paramBundle));
      return;
    }
    finally
    {
      paramBundle = finally;
      throw paramBundle;
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    paramAppInterface = (QQAppInterface)paramAppInterface;
    if (this.b) {
      return;
    }
    if (this.a == null) {
      this.a = new NowDataReporter(paramAppInterface);
    }
    NowLive.setCustomizedTicket(new PluginManagerInterfaceImpl.1(this));
    this.b = true;
  }
  
  public void b(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("url", "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("跳转web页面 URL = ");
    localStringBuilder.append((String)localObject);
    QLog.i("PluginManagerInterfaceImpl", 1, localStringBuilder.toString());
    localObject = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
    ((Intent)localObject).putExtras(paramBundle);
    ((Intent)localObject).addFlags(268435456);
    BaseApplicationImpl.getContext().startActivity((Intent)localObject);
  }
  
  public void b(Bundle paramBundle, Object paramObject)
  {
    paramObject = (CommonCallback)paramObject;
    QQAppInterface localQQAppInterface = g();
    if (localQQAppInterface == null)
    {
      QLog.i("PluginManagerInterfaceImpl", 1, "sendCsTask(): mApp is null, PluginManagerInterfaceImpl had unInit.");
      return;
    }
    String str1 = paramBundle.getString("serviceName");
    String str2 = paramBundle.getString("serviceCmd");
    paramBundle = paramBundle.getByteArray("buffer");
    ((NowChannerHandlerV2)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NOW_CHANNEL_HANDLER_V2)).a(str1, str2, paramBundle, paramObject);
  }
  
  public void c()
  {
    c = null;
    this.a = null;
    INowDownloadManager localINowDownloadManager = this.d;
    if (localINowDownloadManager != null)
    {
      localINowDownloadManager.unInit();
      this.d = null;
    }
  }
  
  public void c(Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    if (g() == null) {
      paramBundle = null;
    } else {
      paramBundle = g().getCurrentUin();
    }
    localIntent.putExtra("uin", paramBundle);
    RouteUtils.a(BaseApplicationImpl.getContext(), localIntent, "/share/toqq/activity");
  }
  
  public void c(Bundle paramBundle, Object paramObject)
  {
    CommonCallback localCommonCallback = (CommonCallback)paramObject;
    paramObject = g();
    if (paramObject == null) {
      return;
    }
    NowRecordInfo localNowRecordInfo = (NowRecordInfo)paramObject.getBusinessHandler(BusinessHandlerFactory.NOW_PROXY_HANDLER);
    String str = paramBundle.getString("fromId");
    long l = paramBundle.getLong("roomId");
    paramObject = e();
    paramBundle = paramObject;
    if (TextUtils.isEmpty(paramObject))
    {
      QLog.i("PluginManagerInterfaceImpl", 1, "getRecordInfo(): uin is null, PluginManagerInterfaceImpl had unInit.");
      paramBundle = "";
    }
    localNowRecordInfo.a(str, l, paramBundle, new PluginManagerInterfaceImpl.3(this, localNowRecordInfo, localCommonCallback));
  }
  
  public NowDataReporter d()
  {
    return this.a;
  }
  
  public void d(Bundle paramBundle)
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), ((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).getReadInJoyDeliverBiuActivityClazz());
    localIntent.putExtra("arg_title", paramBundle.getString("title"));
    localIntent.putExtra("arg_src", paramBundle.getString("anchor_name"));
    localIntent.putExtra("arg_cover", paramBundle.getString("cover_url"));
    localIntent.putExtra("arg_source_url", paramBundle.getString("room_url"));
    localIntent.putExtra("biu_src", 24);
    localIntent.putExtra("arg_now_live_vid", paramBundle.getString("vid"));
    localIntent.putExtra("arg_now_anchor_uin", paramBundle.getLong("qq_number"));
    localIntent.setFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public String e()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      return null;
    }
    return localQQAppInterface.getCurrentAccountUin();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */