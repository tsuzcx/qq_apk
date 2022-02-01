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
import atvo;
import bcrt;
import bcst;
import bcwd;
import bgmp;
import bgng;
import bgsi;
import bhgg;
import bies;
import bipi;
import bkfy;
import bkgf;
import blnd;
import blnn;
import blol;
import blpe;
import blpu;
import blpv;
import blsb;
import blsi;
import bltb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
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
  private static String a;
  
  public static void setAccount(String paramString)
  {
    blpu.c("ReaderHost", "setAccount: account=" + paramString);
    a = paramString;
  }
  
  public String decode(String paramString1, String paramString2)
  {
    return bkgf.b(paramString1, paramString2);
  }
  
  public String getAccount()
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    str3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str1 = str3;
    if (TextUtils.isEmpty(str3)) {}
    try
    {
      blpu.e("ReaderHost", "[getAccount] runtime getAccount is null!");
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
        blpu.a("ReaderHost", "[getAccount IPC error ]", localException);
        String str2 = str3;
      }
    }
    a = str1;
    return a;
  }
  
  public String getIMEI(String paramString)
  {
    return bkfy.a(paramString);
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
    return bhgg.a(paramString);
  }
  
  public String getSKey(String paramString)
  {
    paramString = QRBridgeUtil.getSKey(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      blpu.a("ReaderHost", "skey is null");
      return paramString;
    }
    blpu.e("ReaderHost", "success get skey");
    return paramString;
  }
  
  public String getSecurityBusinessRootFilePath()
  {
    blnd localblnd = new blnd();
    File localFile = BaseApplicationImpl.getApplication().getRuntime().getSecurityBusinessRootFile(localblnd);
    if (localFile != null) {
      return localFile.getAbsolutePath();
    }
    return localblnd.oldBusinessDir(getAccount()).getAbsolutePath();
  }
  
  public long getServerTimeMillis()
  {
    return NetConnInfoCenter.getServerTimeMillis();
  }
  
  public Map<String, String> getUrlConfigData()
  {
    return blol.a;
  }
  
  public boolean hasShortCut(Context paramContext, String[] paramArrayOfString)
  {
    return bgsi.a(paramContext, paramArrayOfString);
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
      paramContext = bgng.a((QQAppInterface)localAppRuntime, paramContext, paramString);
      if (paramContext != null)
      {
        paramContext.a();
        return true;
      }
    }
    return false;
  }
  
  public void jumpToPlugin(Context paramContext, Intent paramIntent, String paramString)
  {
    if (blpv.a(paramContext) == null)
    {
      blpu.a("ReaderHost", "jumpToPlugin: 传入了错误的context，context=" + paramContext);
      return;
    }
    blpe.a(paramContext, paramIntent, paramString);
  }
  
  public Toast makeText(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return QQToastWrapper.makeText(paramContext, paramCharSequence, paramInt1, paramInt2);
  }
  
  public void openFileWithOtherApp(Context paramContext, String paramString)
  {
    atvo.a(blpv.a(paramContext), paramString);
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
      bipi.a().a(paramString1, paramLong1, paramLong2, paramLong3, paramInt, l, paramString2, paramString3, paramBoolean);
      return;
    }
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    bcst.b(null, "P_CliOper", paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramString5, paramString6, paramString7, paramString8);
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    bcst.b(null, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void reportDCEvent(String paramString1, String paramString2, boolean paramBoolean)
  {
    bcrt.a(null, paramString1, paramString2, paramBoolean);
  }
  
  public void sendWindowClosedBroadcast(Context paramContext)
  {
    bies.a(paramContext, 11);
  }
  
  public void setBuilderInterfaceImpl(ReaderJsPluginBuilder paramReaderJsPluginBuilder, ReaderInterfacePluginBuilder paramReaderInterfacePluginBuilder)
  {
    blnn.a().a(paramReaderJsPluginBuilder, paramReaderInterfacePluginBuilder);
    blnn.a().a(true);
  }
  
  public void shareBookToQQ(ContextWrapper paramContextWrapper, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, String paramString7, int paramInt2, String paramString8)
  {
    Activity localActivity = blpv.a(paramContextWrapper);
    if (localActivity == null) {
      return;
    }
    if ((!TextUtils.isEmpty(paramString7)) && (paramString7.length() > 5))
    {
      paramContextWrapper = new Intent(localActivity, DirectForwardActivity.class);
      paramContextWrapper.putExtra("toUin", paramString7);
      paramContextWrapper.putExtra("uinType", paramInt2);
      paramContextWrapper.putExtra("nickName", paramString8);
    }
    for (;;)
    {
      paramContextWrapper.putExtra("forward_type", 1001);
      paramContextWrapper.putExtra("req_type", 134);
      if (!TextUtils.isEmpty(paramString3)) {
        paramContextWrapper.putExtra("image_url_remote", paramString3);
      }
      paramContextWrapper.putExtra("title", paramString1);
      paramContextWrapper.putExtra("desc", paramString2);
      paramContextWrapper.putExtra("detail_url", paramString5);
      paramContextWrapper.putExtra("req_share_id", 100492717L);
      paramContextWrapper.putExtra("key_flag_from_plugin", true);
      paramContextWrapper.putExtra("pluginName", "web_share");
      paramContextWrapper.putExtra("k_back", true);
      paramContextWrapper.putExtra("struct_share_key_source_action", "plugin");
      paramContextWrapper.putExtra("struct_share_key_source_action_data", paramString6);
      paramContextWrapper.putExtra("struct_share_key_source_icon", "https://dwz.cn/3UWeuX");
      paramContextWrapper.putExtra("app_name", "手Q阅读");
      paramContextWrapper.putExtra("brief_key", paramString4);
      paramString1 = bcwd.a(paramContextWrapper.getExtras());
      if (paramString1 != null) {
        paramContextWrapper.putExtra("stuctmsg_bytes", paramString1.getBytes());
      }
      localActivity.startActivityForResult(paramContextWrapper, paramInt1);
      return;
      paramContextWrapper = new Intent(localActivity, ForwardRecentActivity.class);
    }
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
    paramContextWrapper = blpv.a(paramContextWrapper);
    if (paramContextWrapper == null) {
      return;
    }
    blsi localblsi = blsi.a();
    localblsi.a = getAccount();
    blsb.a(paramContextWrapper, localblsi, paramString3, paramString1, paramString2, paramInt);
  }
  
  public void shareSummaryPosterToQQ(ContextWrapper paramContextWrapper, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4)
  {
    Activity localActivity = blpv.a(paramContextWrapper);
    if (localActivity == null) {
      return;
    }
    if ((!TextUtils.isEmpty(paramString3)) && (paramString3.length() > 5))
    {
      paramContextWrapper = new Intent(localActivity, DirectForwardActivity.class);
      paramContextWrapper.putExtra("toUin", paramString3);
      paramContextWrapper.putExtra("uinType", paramInt2);
      paramContextWrapper.putExtra("nickName", paramString4);
    }
    for (;;)
    {
      paramContextWrapper.putExtra("key_flag_from_plugin", true);
      paramContextWrapper.putExtra("image_url", paramString1);
      paramContextWrapper.putExtra("forward_type", -3);
      paramContextWrapper.putExtra("pkg_name", "com.tencent.mobileqq");
      paramContextWrapper.putExtra("req_type", 5);
      paramContextWrapper.putExtra("k_back", true);
      paramContextWrapper.putExtra("brief_key", "[图片]");
      paramContextWrapper.putExtra("struct_share_key_source_action", "plugin");
      paramContextWrapper.putExtra("app_name", "手Q阅读");
      paramContextWrapper.putExtra("struct_share_key_source_icon", "https://dwz.cn/3UWeuX");
      paramContextWrapper.putExtra("struct_share_key_source_action_data", paramString2);
      paramString1 = bcwd.a(paramContextWrapper.getExtras());
      if (paramString1 != null) {
        paramContextWrapper.putExtra("stuctmsg_bytes", paramString1.getBytes());
      }
      localActivity.startActivityForResult(paramContextWrapper, paramInt1);
      return;
      paramContextWrapper = new Intent(localActivity, ForwardRecentActivity.class);
    }
  }
  
  public void shareToQZone(ContextWrapper paramContextWrapper, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, int paramInt)
  {
    paramContextWrapper = blpv.a(paramContextWrapper);
    if (paramContextWrapper == null) {
      return;
    }
    QZoneShareData localQZoneShareData = new QZoneShareData();
    localQZoneShareData.b = paramString1;
    localQZoneShareData.c = paramString2;
    localQZoneShareData.d = paramString3;
    localQZoneShareData.a = paramArrayList;
    bltb.a(paramContextWrapper, getAccount(), localQZoneShareData, null, paramInt);
  }
  
  public void startToFMActivity(Context paramContext)
  {
    paramContext = blpv.a(paramContext);
    if (paramContext == null)
    {
      blpu.a("ReaderHost", "[startToFMActivity] activity null !");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.host.ReaderHost
 * JD-Core Version:    0.7.0.1
 */