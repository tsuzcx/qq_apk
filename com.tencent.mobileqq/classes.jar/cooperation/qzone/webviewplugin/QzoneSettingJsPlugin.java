package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebViewProviderInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneSettingJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final int ALWAYS_BIG = 1;
  public static final int ALWAYS_SMALL = 2;
  public static final int AUTO = 0;
  public static final String NAMESPACE = "Qzone";
  public static final String TAG = "QzoneSettingJsPlugin";
  private static boolean gIsInitSupportPerformance = false;
  private static boolean gIsSupportPerformanceDevice = false;
  private SharedPreferences sp = BaseApplicationImpl.sApplication.getSharedPreferences("qzone_detail_sp", 4);
  
  private boolean handleCustomBrowseInfoSwitchSetting(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool = false;
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
      if (paramWebViewPlugin != null)
      {
        if (paramWebViewPlugin.isFinishing()) {
          return false;
        }
        try
        {
          int i = new JSONObject(paramArrayOfString[0]).getInt("enable");
          if (i != 0) {}
          RemoteHandleManager.getInstance().getSender().notifyCustomBrowserChanged(bool);
        }
        catch (JSONException paramWebViewPlugin)
        {
          paramWebViewPlugin.printStackTrace();
          bool = true;
        }
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("---notifyCustomBrowserChanged-:");
        paramWebViewPlugin.append(bool);
        QLog.i("QzoneSettingJsPlugin", 4, paramWebViewPlugin.toString());
        return true;
      }
    }
    return false;
  }
  
  private boolean handleFeedSkinGet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean handleFeedSkinSet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool = false;
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
      if (paramWebViewPlugin != null)
      {
        if (paramWebViewPlugin.isFinishing()) {
          return false;
        }
        try
        {
          int i = new JSONObject(paramArrayOfString[0]).getInt("value");
          if (i != 0) {}
          LocalMultiProcConfig.putBool("qzone_feed_skin_enable", bool);
        }
        catch (JSONException paramWebViewPlugin)
        {
          paramWebViewPlugin.printStackTrace();
          bool = true;
        }
        RemoteHandleManager.getInstance().getSender().notifyFeedSkinSwitchChagned();
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("---handlefeedSkinEnable-:");
        paramWebViewPlugin.append(bool);
        QLog.i("QzoneSettingJsPlugin", 4, paramWebViewPlugin.toString());
        return true;
      }
    }
    return false;
  }
  
  private boolean handleGetCustomBrowseInfoSwitch(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void handleGetInteractSoundMode(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void handleGetWaterMark(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return;
      }
      Object localObject = paramWebViewPlugin.mRuntime.a();
      if (localObject != null)
      {
        if (((Activity)localObject).isFinishing()) {
          return;
        }
        localObject = null;
        int i = 0;
        try
        {
          String str = new JSONObject(paramArrayOfString[0]).getString("callback");
          paramArrayOfString = str;
        }
        catch (JSONException localJSONException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleGetWaterMark: json error ");
          localStringBuilder.append(paramArrayOfString[0]);
          QZLog.w("QzoneSettingJsPlugin", 4, new Object[] { localStringBuilder.toString(), localJSONException });
          paramArrayOfString = (String[])localObject;
        }
        if (paramArrayOfString == null) {
          return;
        }
        long l = paramWebViewPlugin.mRuntime.a().getLongAccountUin();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("WaterMark_");
        ((StringBuilder)localObject).append(l);
        boolean bool;
        if (LocalMultiProcConfig.containKey("Qzone_multi_setting", ((StringBuilder)localObject).toString()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("WaterMark_");
          ((StringBuilder)localObject).append(l);
          bool = LocalMultiProcConfig.getBool("Qzone_multi_setting", ((StringBuilder)localObject).toString(), false);
          QLog.i("QzoneSettingJsPlugin", 1, "use new key");
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("WaterMark_");
          ((StringBuilder)localObject).append(l);
          bool = LocalMultiProcConfig.getBool("QZ_setting", ((StringBuilder)localObject).toString(), false);
        }
        if (bool) {
          i = 1;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("window.");
        ((StringBuilder)localObject).append(paramArrayOfString);
        ((StringBuilder)localObject).append("({value:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("})");
        paramWebViewPlugin.callJs(((StringBuilder)localObject).toString());
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("handleGetWaterMark: ");
        paramWebViewPlugin.append(bool);
        paramWebViewPlugin.append(" uin:");
        paramWebViewPlugin.append(l);
        QLog.i("QzoneSettingJsPlugin", 1, paramWebViewPlugin.toString());
      }
    }
  }
  
  private boolean handleGifPlayModeGet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @Deprecated
  private boolean handleGifPlayModeSetting(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool = false;
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
      if (paramWebViewPlugin != null)
      {
        if (paramWebViewPlugin.isFinishing()) {
          return false;
        }
        try
        {
          int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
          if (i != 0) {}
          paramArrayOfString = new StringBuilder();
        }
        catch (JSONException paramArrayOfString)
        {
          paramArrayOfString.printStackTrace();
          bool = true;
        }
        paramArrayOfString.append("---handleGifPlayModeSetting-:");
        paramArrayOfString.append(bool);
        QLog.i("QzoneSettingJsPlugin", 4, paramArrayOfString.toString());
        LocalMultiProcConfig.putBool("QZ_setting", "Qzone_playMode", bool);
        paramWebViewPlugin.sendBroadcast(new Intent("com.tencent.qq.GifPlaySetting"));
        return true;
      }
    }
    return false;
  }
  
  private boolean handleIsSupportParticleEffect(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean handlePassivePraiseGet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean handlePassivePraiseSet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool = false;
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
      if (paramWebViewPlugin != null)
      {
        if (paramWebViewPlugin.isFinishing()) {
          return false;
        }
        try
        {
          int i = new JSONObject(paramArrayOfString[0]).getInt("value");
          if (i != 0) {}
          LocalMultiProcConfig.putBool("qzone_passive_praise_enabled", bool);
        }
        catch (JSONException paramWebViewPlugin)
        {
          paramWebViewPlugin.printStackTrace();
          bool = true;
        }
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("---handleShowSparkleFontSetting-:");
        paramWebViewPlugin.append(bool);
        QLog.i("QzoneSettingJsPlugin", 4, paramWebViewPlugin.toString());
        return true;
      }
    }
    return false;
  }
  
  private boolean handlePictureModeGet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      Object localObject = paramWebViewPlugin.mRuntime.a();
      if (localObject != null)
      {
        if (((Activity)localObject).isFinishing()) {
          return false;
        }
        try
        {
          paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
        }
        catch (JSONException paramArrayOfString)
        {
          paramArrayOfString.printStackTrace();
          paramArrayOfString = "";
        }
        int i = LocalMultiProcConfig.getInt(((Activity)localObject).getResources().getString(2131718401), 0);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("window.");
        ((StringBuilder)localObject).append(paramArrayOfString);
        ((StringBuilder)localObject).append("({new_value:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("})");
        paramWebViewPlugin.callJs(((StringBuilder)localObject).toString());
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("---handlePictureModeGet-:");
        paramWebViewPlugin.append(i);
        QLog.i("QzoneSettingJsPlugin", 4, paramWebViewPlugin.toString());
        return true;
      }
    }
    return false;
  }
  
  private boolean handlePictureModeSetting(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
      if (paramWebViewPlugin != null)
      {
        if (paramWebViewPlugin.isFinishing()) {
          return false;
        }
        try
        {
          int j = new JSONObject(paramArrayOfString[0]).getInt("new_value");
          i = j;
        }
        catch (JSONException paramArrayOfString)
        {
          paramArrayOfString.printStackTrace();
        }
        paramWebViewPlugin.sendBroadcast(new Intent("com.tencent.qq.syncNoPhotoSetting"));
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("---handlePictureModeSetting-:");
        paramArrayOfString.append(i);
        QLog.i("QzoneSettingJsPlugin", 4, paramArrayOfString.toString());
        LocalMultiProcConfig.putInt(paramWebViewPlugin.getResources().getString(2131718401), i);
        return true;
      }
    }
    return false;
  }
  
  private void handleSetInteractSoundMode(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return;
      }
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
      if (paramWebViewPlugin != null)
      {
        if (paramWebViewPlugin.isFinishing()) {
          return;
        }
        boolean bool = true;
        try
        {
          int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
          if (i == 0) {
            bool = false;
          }
        }
        catch (JSONException paramWebViewPlugin)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleSetInteractSoundMode: json error ");
          localStringBuilder.append(paramArrayOfString[0]);
          QZLog.w("QzoneSettingJsPlugin", 4, new Object[] { localStringBuilder.toString(), paramWebViewPlugin });
        }
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("handleSetInteractSoundMode: ");
        paramWebViewPlugin.append(bool);
        QLog.i("QzoneSettingJsPlugin", 4, paramWebViewPlugin.toString());
        this.sp.edit().putBoolean("qzone_sound_effect_enabled", bool).apply();
      }
    }
  }
  
  private boolean handleSetRightButton(JsBridgeListener paramJsBridgeListener, WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      paramJsBridgeListener = paramWebViewPlugin.mRuntime.a();
      bool1 = bool2;
      if (paramJsBridgeListener != null) {
        if (paramJsBridgeListener.isFinishing()) {
          return false;
        }
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfString[0]);
      int i = localJSONObject.optInt("iconID");
      paramJsBridgeListener = localJSONObject.optString("title");
      paramArrayOfString = localJSONObject.optString("callback");
      bool1 = localJSONObject.optBoolean("hidden");
      localJSONObject.optBoolean("disable");
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
      if ((paramWebViewPlugin != null) && (paramWebViewPlugin.getWebTitleBarInterface() != null)) {
        paramWebViewPlugin.getWebTitleBarInterface().a(paramArrayOfString, paramJsBridgeListener, null, bool1, i + 1000, 0, null, null);
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      label147:
      break label147;
    }
    bool1 = true;
    return bool1;
  }
  
  private void handleSetWaterMark(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return;
      }
      Activity localActivity = paramWebViewPlugin.mRuntime.a();
      if (localActivity != null)
      {
        if (localActivity.isFinishing()) {
          return;
        }
        boolean bool = false;
        try
        {
          int i = new JSONObject(paramArrayOfString[0]).getInt("value");
          if (i == 0) {
            break label114;
          }
        }
        catch (JSONException localJSONException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleSetWaterMark: json error ");
          localStringBuilder.append(paramArrayOfString[0]);
          QZLog.w("QzoneSettingJsPlugin", 4, new Object[] { localStringBuilder.toString(), localJSONException });
        }
        bool = true;
        label114:
        long l = paramWebViewPlugin.mRuntime.a().getLongAccountUin();
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("handleSetWaterMark: ");
        paramWebViewPlugin.append(bool);
        paramWebViewPlugin.append(" uin:");
        paramWebViewPlugin.append(l);
        QLog.i("QzoneSettingJsPlugin", 1, paramWebViewPlugin.toString());
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("WaterMark_");
        paramWebViewPlugin.append(l);
        LocalMultiProcConfig.putBool("Qzone_multi_setting", paramWebViewPlugin.toString(), bool);
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("WaterMark_");
        paramWebViewPlugin.append(l);
        LocalMultiProcConfig.putBool("QZ_setting", paramWebViewPlugin.toString(), bool);
      }
    }
  }
  
  private boolean handleShowCommentBubbleGet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean handleShowCommentBubbleSetting(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool = false;
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
      if (paramWebViewPlugin != null)
      {
        if (paramWebViewPlugin.isFinishing()) {
          return false;
        }
        try
        {
          int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
          if (i != 0) {}
          RemoteHandleManager.getInstance().getSender().notifyBarrageEffectChanged(bool);
        }
        catch (JSONException paramWebViewPlugin)
        {
          paramWebViewPlugin.printStackTrace();
          bool = true;
        }
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("---handleShowCommentBubbleSetting-:");
        paramWebViewPlugin.append(bool);
        QLog.i("QzoneSettingJsPlugin", 4, paramWebViewPlugin.toString());
        return true;
      }
    }
    return false;
  }
  
  private boolean handleShowFontGet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean handleShowFontSetting(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool = false;
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
      if (paramWebViewPlugin != null)
      {
        if (paramWebViewPlugin.isFinishing()) {
          return false;
        }
        try
        {
          int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
          if (i != 0) {}
          RemoteHandleManager.getInstance().getSender().notifyFontChanged(bool);
        }
        catch (JSONException paramWebViewPlugin)
        {
          paramWebViewPlugin.printStackTrace();
          bool = true;
        }
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("---handleShowFontSetting-:");
        paramWebViewPlugin.append(bool);
        QLog.i("QzoneSettingJsPlugin", 4, paramWebViewPlugin.toString());
        return true;
      }
    }
    return false;
  }
  
  private boolean handleShowQzoneRemindfeedGet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean handleShowQzoneRemindfeedSetting(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool = false;
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      Activity localActivity = paramWebViewPlugin.mRuntime.a();
      if (localActivity != null)
      {
        if (localActivity.isFinishing()) {
          return false;
        }
        long l = paramWebViewPlugin.mRuntime.a().getLongAccountUin();
        try
        {
          int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
          if (i != 0) {
            bool = true;
          }
        }
        catch (JSONException paramWebViewPlugin)
        {
          paramWebViewPlugin.printStackTrace();
        }
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("---handleShowQzoneRemindfeedSetting-:");
        paramWebViewPlugin.append(bool);
        QLog.i("QzoneSettingJsPlugin", 4, paramWebViewPlugin.toString());
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append(localActivity.getString(2131718396));
        paramWebViewPlugin.append(l);
        LocalMultiProcConfig.putBooleanAsync(paramWebViewPlugin.toString(), bool);
        return true;
      }
    }
    return false;
  }
  
  private boolean handleShowSparkleFontGet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean handleShowSparkleFontSetting(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool = false;
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
      if (paramWebViewPlugin != null)
      {
        if (paramWebViewPlugin.isFinishing()) {
          return false;
        }
        try
        {
          int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
          if (i != 0) {}
          RemoteHandleManager.getInstance().getSender().notifySuperFontChanged(bool);
        }
        catch (JSONException paramWebViewPlugin)
        {
          paramWebViewPlugin.printStackTrace();
          bool = true;
        }
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("---handleShowSparkleFontSetting-:");
        paramWebViewPlugin.append(bool);
        QLog.i("QzoneSettingJsPlugin", 4, paramWebViewPlugin.toString());
        return true;
      }
    }
    return false;
  }
  
  private boolean handleUpdateCustomPraise(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
      if (paramWebViewPlugin != null)
      {
        if (paramWebViewPlugin.isFinishing()) {
          return false;
        }
        RemoteHandleManager.getInstance().getSender().updateCustomPraise(paramArrayOfString[0]);
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("---handleUpdateCustomPraise-:");
        paramWebViewPlugin.append(paramArrayOfString[0]);
        QLog.i("QzoneSettingJsPlugin", 4, paramWebViewPlugin.toString());
        return true;
      }
    }
    return false;
  }
  
  private boolean handleUpdateFontList(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    if ((paramWebViewPlugin != null) && (!paramWebViewPlugin.isFinishing()))
    {
      RemoteHandleManager.getInstance().getSender().handleUpdateFontList();
      QLog.i("QzoneSettingJsPlugin", 4, "---handleUpdateFontList-:");
      return true;
    }
    return false;
  }
  
  private boolean handleUpdatePloymorphicPraise(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
      if (paramWebViewPlugin != null)
      {
        if (paramWebViewPlugin.isFinishing()) {
          return false;
        }
        RemoteHandleManager.getInstance().getSender().UpdatePloymorphicPraise(paramArrayOfString[0]);
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("---handleUpdatePloymorphicPraise-:");
        paramWebViewPlugin.append(paramArrayOfString[0]);
        QLog.i("QzoneSettingJsPlugin", 4, paramWebViewPlugin.toString());
        return true;
      }
    }
    return false;
  }
  
  private boolean handleVideoPlayModeGet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      Object localObject = paramWebViewPlugin.mRuntime.a();
      if (localObject != null)
      {
        if (((Activity)localObject).isFinishing()) {
          return false;
        }
        try
        {
          paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
        }
        catch (JSONException paramArrayOfString)
        {
          paramArrayOfString.printStackTrace();
          paramArrayOfString = "";
        }
        int i;
        if (!LocalMultiProcConfig.getBool("QZ_setting", "Qzone_setVideoplay", true))
        {
          i = 2;
          LocalMultiProcConfig.putBool("QZ_setting", "Qzone_setVideoplay", true);
        }
        else
        {
          i = LocalMultiProcConfig.getInt("QZ_setting", "Qzone_playMode", 0);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("window.");
        ((StringBuilder)localObject).append(paramArrayOfString);
        ((StringBuilder)localObject).append("({new_value:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("})");
        paramWebViewPlugin.callJs(((StringBuilder)localObject).toString());
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("---handleVideoPlayModeGet-:");
        paramWebViewPlugin.append(i);
        QLog.i("QzoneSettingJsPlugin", 4, paramWebViewPlugin.toString());
        return true;
      }
    }
    return false;
  }
  
  private boolean handleVideoPlayModeSetting(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
      if (paramWebViewPlugin != null)
      {
        if (paramWebViewPlugin.isFinishing()) {
          return false;
        }
        try
        {
          int j = new JSONObject(paramArrayOfString[0]).getInt("new_value");
          i = j;
          reportConfigInfo(j);
          i = j;
        }
        catch (JSONException paramArrayOfString)
        {
          paramArrayOfString.printStackTrace();
        }
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("---handleVideoPlayModeSetting-:");
        paramArrayOfString.append(i);
        QLog.i("QzoneSettingJsPlugin", 4, paramArrayOfString.toString());
        LocalMultiProcConfig.putInt("QZ_setting", "Qzone_playMode", i);
        paramWebViewPlugin.sendBroadcast(new Intent("com.tencent.qq.VideoPlaySetting"));
        return true;
      }
    }
    return false;
  }
  
  public static boolean isSupportPerformanceDevice()
  {
    if (!gIsSupportPerformanceDevice)
    {
      gIsInitSupportPerformance = ((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(1, 1);
      gIsSupportPerformanceDevice = true;
    }
    return gIsInitSupportPerformance;
  }
  
  private void reportConfigInfo(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          paramInt = -1;
        } else {
          paramInt = 9;
        }
      }
      else {
        paramInt = 7;
      }
    }
    else {
      paramInt = 8;
    }
    if (paramInt != -1) {
      LpReportInfo_pf00064.allReport(593, 2, paramInt);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2.equals("Qzone")) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if (paramString3.equalsIgnoreCase("setShowRemindfeed"))
      {
        handleShowQzoneRemindfeedSetting(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("setVideoPlayMode"))
      {
        handleVideoPlayModeSetting(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("setGifPlayMode"))
      {
        handleGifPlayModeSetting(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("setPictureMode"))
      {
        handlePictureModeSetting(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("setShowFont"))
      {
        handleShowFontSetting(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("getPictureMode"))
      {
        handlePictureModeGet(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("getShowRemindfeed"))
      {
        handleShowQzoneRemindfeedGet(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("getVideoPlayMode"))
      {
        handleVideoPlayModeGet(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("getGifPlayMode"))
      {
        handleGifPlayModeGet(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("getShowFont"))
      {
        handleShowFontGet(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("setShowSparkleFont"))
      {
        handleShowSparkleFontSetting(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("getShowSparkleFont"))
      {
        handleShowSparkleFontGet(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("setShowCommentBubble"))
      {
        handleShowCommentBubbleSetting(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("getShowCommentBubble"))
      {
        handleShowCommentBubbleGet(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("setPassivePraiseSwitch"))
      {
        handlePassivePraiseSet(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("getPassivePraiseSwitch"))
      {
        handlePassivePraiseGet(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("isSupportParticleEffect"))
      {
        handleIsSupportParticleEffect(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("updateCustomPraise"))
      {
        handleUpdateCustomPraise(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("setRightButton"))
      {
        handleSetRightButton(paramJsBridgeListener, this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("setFeedSkinSwitch"))
      {
        handleFeedSkinSet(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("getFeedSkinSwitch"))
      {
        handleFeedSkinGet(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("updatePloymorphicPraise"))
      {
        handleUpdatePloymorphicPraise(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("updateFontList"))
      {
        handleUpdateFontList(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("getCustomBrowseInfoSwitch"))
      {
        handleGetCustomBrowseInfoSwitch(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("enableCustomBrowseInfo"))
      {
        handleCustomBrowseInfoSwitchSetting(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("setInteractSoundMode"))
      {
        handleSetInteractSoundMode(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("getInteractSoundMode"))
      {
        handleGetInteractSoundMode(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("getWaterMark"))
      {
        handleGetWaterMark(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (paramString3.equalsIgnoreCase("setWaterMark"))
      {
        handleSetWaterMark(this.parentPlugin, paramVarArgs);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneSettingJsPlugin
 * JD-Core Version:    0.7.0.1
 */