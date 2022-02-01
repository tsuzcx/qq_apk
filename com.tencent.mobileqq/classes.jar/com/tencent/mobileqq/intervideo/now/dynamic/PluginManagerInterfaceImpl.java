package com.tencent.mobileqq.intervideo.now.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.now.NowRecordInfo;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.NowDownloadManager;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.NowDownloadTaskInfo;
import com.tencent.mobileqq.intervideo.now.NowDataReporter;
import com.tencent.mobileqq.intervideo.now.ShareToQQActivity;
import com.tencent.mobileqq.intervideo.now.dynamic.channelImpl.NowChannerHandlerV2;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.CommonCallback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class PluginManagerInterfaceImpl
{
  private static volatile PluginManagerInterfaceImpl jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicPluginManagerInterfaceImpl;
  private NowDownloadManager jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager;
  public NowDataReporter a;
  boolean jdField_a_of_type_Boolean = false;
  
  public static PluginManagerInterfaceImpl a()
  {
    if (jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicPluginManagerInterfaceImpl == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicPluginManagerInterfaceImpl == null) {
        jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicPluginManagerInterfaceImpl = new PluginManagerInterfaceImpl();
      }
      return jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicPluginManagerInterfaceImpl;
    }
    finally {}
  }
  
  public static void a()
  {
    if (jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicPluginManagerInterfaceImpl != null) {
      jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicPluginManagerInterfaceImpl.b();
    }
  }
  
  private static QQAppInterface b()
  {
    return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public NowDataReporter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter;
  }
  
  public String a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      return null;
    }
    return localQQAppInterface.getCurrentAccountUin();
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
    Object localObject = paramBundle.getString("url", "");
    QLog.i("PluginManagerInterfaceImpl", 1, "跳转web页面 URL = " + (String)localObject);
    localObject = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
    ((Intent)localObject).putExtras(paramBundle);
    ((Intent)localObject).addFlags(268435456);
    BaseApplicationImpl.getContext().startActivity((Intent)localObject);
  }
  
  public void a(Bundle paramBundle, DownloadCallback paramDownloadCallback)
  {
    try
    {
      String str = paramBundle.getString("url", "");
      paramBundle = paramBundle.getString("path", "");
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager = NowDownloadManager.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager;
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager.a(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager.a(str, new PluginManagerInterfaceImpl.2(this, paramDownloadCallback, str));
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager.a(NowDownloadTaskInfo.a(str, "com.tencent.now", paramBundle));
      return;
    }
    finally
    {
      paramBundle = finally;
      throw paramBundle;
    }
  }
  
  public void a(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    QQAppInterface localQQAppInterface = b();
    if (localQQAppInterface == null)
    {
      QLog.i("PluginManagerInterfaceImpl", 1, "sendCsTask(): mApp is null, PluginManagerInterfaceImpl had unInit.");
      return;
    }
    String str1 = paramBundle.getString("serviceName");
    String str2 = paramBundle.getString("serviceCmd");
    paramBundle = paramBundle.getByteArray("buffer");
    ((NowChannerHandlerV2)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NOW_CHANNEL_HANDLER_V2)).a(str1, str2, paramBundle, paramCommonCallback);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter == null) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter = new NowDataReporter(paramQQAppInterface);
    }
    NowLive.setCustomizedTicket(new PluginManagerInterfaceImpl.1(this));
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicPluginManagerInterfaceImpl = null;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter = null;
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager.a();
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDownloadEngineNowDownloadManager = null;
    }
  }
  
  public void b(Bundle paramBundle)
  {
    QLog.i(paramBundle.getString("tag", "nowplugin_dynamic"), 1, paramBundle.getString("msg", ""));
  }
  
  public void b(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    Object localObject = b();
    if (localObject == null) {
      return;
    }
    NowRecordInfo localNowRecordInfo = (NowRecordInfo)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.NOW_PROXY_HANDLER);
    String str = paramBundle.getString("fromId");
    long l = paramBundle.getLong("roomId");
    localObject = a();
    paramBundle = (Bundle)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.i("PluginManagerInterfaceImpl", 1, "getRecordInfo(): uin is null, PluginManagerInterfaceImpl had unInit.");
      paramBundle = "";
    }
    localNowRecordInfo.a(str, l, paramBundle, new PluginManagerInterfaceImpl.3(this, localNowRecordInfo, paramCommonCallback));
  }
  
  public void c(Bundle paramBundle)
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), ShareToQQActivity.class);
    localIntent.addFlags(268435456);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    if (b() == null) {}
    for (paramBundle = null;; paramBundle = b().getCurrentUin())
    {
      localIntent.putExtra("uin", paramBundle);
      BaseApplicationImpl.getContext().startActivity(localIntent);
      return;
    }
  }
  
  public void d(Bundle paramBundle)
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), ReadInJoyDeliverBiuActivity.class);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */