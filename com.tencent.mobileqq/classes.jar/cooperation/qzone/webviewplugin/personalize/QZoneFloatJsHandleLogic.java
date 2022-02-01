package cooperation.qzone.webviewplugin.personalize;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic;

public class QZoneFloatJsHandleLogic
{
  public static final String TAG = "QZoneFloatJsHandleLogic";
  private static String data = "";
  public static String url = "";
  private static SurfaceView view;
  
  public static void handleDownLoadFloatFinish(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramPluginRuntime == null) || (paramPluginRuntime.a() == null) || (paramPluginRuntime.a() == null)) {}
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
        localFrameLayout = (FrameLayout)paramPluginRuntime.a().findViewById(2131381863);
        if ((view != null) && (view.getParent() == localFrameLayout))
        {
          QZoneHelper.resumeQZoneFloatObjectView(paramPluginRuntime.a(), view);
          return;
        }
        url = paramPluginRuntime.a().getUrl();
        if (paramVarArgs != null) {
          data = paramVarArgs[0];
        }
      } while (TextUtils.isEmpty(data));
      view = QZoneHelper.createQZoneFloatObjectView(paramPluginRuntime.a(), data);
    } while (view == null);
    localFrameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public static void handleSetFloatFinish(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if (paramPluginRuntime == null) {}
    do
    {
      do
      {
        return;
        paramPluginRuntime = paramPluginRuntime.a();
      } while (paramPluginRuntime == null);
      paramVarArgs = (FrameLayout)paramPluginRuntime.findViewById(2131381863);
      if ((paramVarArgs != null) && (view != null)) {
        paramVarArgs.removeView(view);
      }
      QZoneHelper.stopQZoneFloatObjectView(paramPluginRuntime, view);
      view = null;
      paramVarArgs = new Intent("action_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "setFloat");
      paramVarArgs.putExtras(localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneFloatJsHandleLogic", 2, "actionString: " + paramVarArgs.getAction());
      }
      QZoneHelper.forwardToQzoneTransluentActivity(paramPluginRuntime, QZoneHelper.UserInfo.getInstance(), paramVarArgs);
      QZoneWebViewJsHandleLogic.doRefreshFeed(paramPluginRuntime);
      paramPluginRuntime.finish();
    } while (!QZoneHelper.isInFloatItemBlacklist());
    ToastUtil.a().a(QZoneHelper.STR_TIPS_FLOAT_ITEM_NOT_ALLOW_TO_SHOW, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneFloatJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */