package cooperation.qqreader.host;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.text.TextUtils;
import axpy;
import axqy;
import axva;
import bbeg;
import bbex;
import bbvj;
import bcuc;
import bdes;
import bfnn;
import bfnt;
import bgtm;
import bgtw;
import bguu;
import bgvn;
import bgwf;
import bgwg;
import bgyp;
import bgyw;
import bgzl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import cooperation.qqreader.QRBridgeUtil;
import cooperation.qqreader.host.toast.QQToastWrapper;
import cooperation.qqreader.host.toast.Toast;
import cooperation.qqreader.proxy.ReaderInterfacePluginBuilder;
import cooperation.qqreader.proxy.ReaderJsPluginBuilder;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.util.NetworkState;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ReaderHost
{
  public static final String TAG_898 = "dc00898";
  private String a;
  
  public String decode(String paramString1, String paramString2)
  {
    return bfnt.b(paramString1, paramString2);
  }
  
  public String getAccount()
  {
    if (!TextUtils.isEmpty(this.a)) {
      return this.a;
    }
    str3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str1 = str3;
    if (TextUtils.isEmpty(str3)) {}
    try
    {
      bgwf.e("ReaderHost", "[getAccount] runtime getAccount is null!");
      EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("ReaderIPCModule", "action_get_account", new Bundle());
      str1 = str3;
      if (localEIPCResult != null)
      {
        str1 = str3;
        if (localEIPCResult.isSuccess()) {
          str1 = localEIPCResult.data.getString("key_get_account");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bgwf.a("ReaderHost", "[getAccount IPC error ]", localException);
        String str2 = str3;
      }
    }
    this.a = str1;
    return this.a;
  }
  
  public String getIMEI(String paramString)
  {
    return bfnn.a(paramString);
  }
  
  public String getIPV4AddressCache()
  {
    return "UnKnow";
  }
  
  public int getMobileInfo()
  {
    return AppNetConnInfo.getMobileInfo();
  }
  
  public String getPSKey(String paramString)
  {
    return QRBridgeUtil.getPSkey(getAccount(), paramString);
  }
  
  public NetworkInfo getRecentNetworkInfo()
  {
    return AppNetConnInfo.getRecentNetworkInfo();
  }
  
  public String getSDKPrivatePath(String paramString)
  {
    return bbvj.a(paramString);
  }
  
  public String getSKey(String paramString)
  {
    paramString = QRBridgeUtil.getSKey(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      bgwf.a("ReaderHost", "skey is null");
      return paramString;
    }
    bgwf.e("ReaderHost", "success get skey");
    return paramString;
  }
  
  public String getSecurityBusinessRootFilePath()
  {
    bgtm localbgtm = new bgtm();
    File localFile = BaseApplicationImpl.getApplication().getRuntime().getSecurityBusinessRootFile(localbgtm);
    if (localFile != null) {
      return localFile.getAbsolutePath();
    }
    return localbgtm.oldBusinessDir(getAccount()).getAbsolutePath();
  }
  
  public long getServerTimeMillis()
  {
    return NetConnInfoCenter.getServerTimeMillis();
  }
  
  public Map<String, String> getUrlConfigData()
  {
    return bguu.a;
  }
  
  public boolean isMobileConn()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public boolean isNetworkAvailable()
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public boolean isNowThemeIsNight()
  {
    return ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
  }
  
  public boolean isWXinstalled()
  {
    return WXShareHelper.a().a();
  }
  
  public boolean isWXsupportApi()
  {
    return WXShareHelper.a().b();
  }
  
  public boolean isWifiConnected()
  {
    return NetworkState.isWifiConn();
  }
  
  public boolean jumpParserAndDoAction(Context paramContext, String paramString)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      paramContext = bbex.a((QQAppInterface)localAppRuntime, paramContext, paramString);
      if (paramContext != null)
      {
        paramContext.c();
        return true;
      }
    }
    return false;
  }
  
  public void jumpToPlugin(Context paramContext, Intent paramIntent, String paramString)
  {
    if (bgwg.a(paramContext) == null)
    {
      bgwf.a("ReaderHost", "jumpToPlugin: 传入了错误的context，context=" + paramContext);
      return;
    }
    bgvn.a(paramContext, paramIntent, paramString);
  }
  
  public Toast makeText(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return QQToastWrapper.makeText(paramContext, paramCharSequence, paramInt1, paramInt2);
  }
  
  public boolean recreateTicket(String paramString, Handler.Callback paramCallback)
  {
    return QRBridgeUtil.recreateTicket(paramString, paramCallback);
  }
  
  public void reportCgi(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    String str = getAccount();
    if (TextUtils.isEmpty(str)) {}
    for (long l = 0L;; l = Long.parseLong(str))
    {
      bdes.a().a(paramString1, paramLong1, paramLong2, paramLong3, paramInt, l, paramString2, paramString3, paramBoolean);
      return;
    }
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    axqy.b(null, "P_CliOper", paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramString5, paramString6, paramString7, paramString8);
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    axqy.b(null, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void reportDCEvent(String paramString1, String paramString2, boolean paramBoolean)
  {
    axpy.a(null, paramString1, paramString2, paramBoolean);
  }
  
  public void sendWindowClosedBroadcast(Context paramContext)
  {
    bcuc.a(paramContext, 11);
  }
  
  public void setBuilderInterfaceImpl(ReaderJsPluginBuilder paramReaderJsPluginBuilder, ReaderInterfacePluginBuilder paramReaderInterfacePluginBuilder)
  {
    bgtw.a().a(paramReaderJsPluginBuilder, paramReaderInterfacePluginBuilder);
    bgtw.a().a(true);
  }
  
  public void shareBookToQQ(ContextWrapper paramContextWrapper, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    paramContextWrapper = bgwg.a(paramContextWrapper);
    if (paramContextWrapper == null) {
      return;
    }
    Intent localIntent = new Intent(paramContextWrapper, ForwardRecentActivity.class);
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("req_type", 134);
    if (!TextUtils.isEmpty(paramString3)) {
      localIntent.putExtra("image_url_remote", paramString3);
    }
    localIntent.putExtra("title", paramString1);
    localIntent.putExtra("desc", paramString2);
    localIntent.putExtra("detail_url", paramString5);
    localIntent.putExtra("req_share_id", 100492717L);
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("k_back", true);
    localIntent.putExtra("struct_share_key_source_action", "plugin");
    localIntent.putExtra("struct_share_key_source_action_data", paramString6);
    localIntent.putExtra("struct_share_key_source_icon", "http://dwz.cn/3UWeuX");
    localIntent.putExtra("app_name", "手Q阅读");
    localIntent.putExtra("brief_key", paramString4);
    paramString1 = axva.a(localIntent.getExtras());
    if (paramString1 != null) {
      localIntent.putExtra("stuctmsg_bytes", paramString1.getBytes());
    }
    paramContextWrapper.startActivityForResult(localIntent, paramInt);
  }
  
  public void shareImageToWX(String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localWXShareHelper.a(paramString, paramBitmap, i);
      return;
    }
  }
  
  public void shareLocalFileToQQ(ContextWrapper paramContextWrapper, String paramString, int paramInt) {}
  
  public void shareLocalFileToQZone(ContextWrapper paramContextWrapper, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramContextWrapper = bgwg.a(paramContextWrapper);
    if (paramContextWrapper == null) {
      return;
    }
    bgyw localbgyw = bgyw.a();
    localbgyw.a = getAccount();
    bgyp.a(paramContextWrapper, localbgyw, paramString3, paramString1, paramString2, paramInt);
  }
  
  public void shareSummaryPosterToQQ(ContextWrapper paramContextWrapper, String paramString1, String paramString2, int paramInt)
  {
    paramContextWrapper = bgwg.a(paramContextWrapper);
    if (paramContextWrapper == null) {
      return;
    }
    Intent localIntent = new Intent(paramContextWrapper, ForwardRecentActivity.class);
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("image_url", paramString1);
    localIntent.putExtra("forward_type", -3);
    localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
    localIntent.putExtra("req_type", 5);
    localIntent.putExtra("k_back", true);
    localIntent.putExtra("brief_key", "[图片]");
    localIntent.putExtra("struct_share_key_source_action", "plugin");
    localIntent.putExtra("app_name", "手Q阅读");
    localIntent.putExtra("struct_share_key_source_icon", "http://dwz.cn/3UWeuX");
    localIntent.putExtra("struct_share_key_source_action_data", paramString2);
    paramString1 = axva.a(localIntent.getExtras());
    if (paramString1 != null) {
      localIntent.putExtra("stuctmsg_bytes", paramString1.getBytes());
    }
    paramContextWrapper.startActivityForResult(localIntent, paramInt);
  }
  
  public void shareToQZone(ContextWrapper paramContextWrapper, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, int paramInt)
  {
    paramContextWrapper = bgwg.a(paramContextWrapper);
    if (paramContextWrapper == null) {
      return;
    }
    QZoneShareData localQZoneShareData = new QZoneShareData();
    localQZoneShareData.b = paramString1;
    localQZoneShareData.c = paramString2;
    localQZoneShareData.d = paramString3;
    localQZoneShareData.a = paramArrayList;
    bgzl.a(paramContextWrapper, getAccount(), localQZoneShareData, null, paramInt);
  }
  
  public void startToFMActivity(Context paramContext)
  {
    paramContext = bgwg.a(paramContext);
    if (paramContext == null)
    {
      bgwf.a("ReaderHost", "[startToFMActivity] activity null !");
      return;
    }
    Intent localIntent = new Intent(paramContext, FMActivity.class);
    localIntent.putExtra("category", 6);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("busiType", 7);
    localIntent.putExtra("max_select_count", 1);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("smart_device_switch_tab_flag", 14);
    paramContext.startActivityForResult(localIntent, 10001);
    paramContext.overridePendingTransition(2130771979, 2130771980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.host.ReaderHost
 * JD-Core Version:    0.7.0.1
 */