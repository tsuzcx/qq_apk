package cooperation.qzone.webviewplugin.personalize;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
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
    if ((paramPluginRuntime != null) && (paramPluginRuntime.a() != null))
    {
      if (paramPluginRuntime.a() == null) {
        return;
      }
      FrameLayout localFrameLayout = (FrameLayout)paramPluginRuntime.a().findViewById(2131381075);
      SurfaceView localSurfaceView = view;
      if ((localSurfaceView != null) && (localSurfaceView.getParent() == localFrameLayout))
      {
        QZoneHelper.resumeQZoneFloatObjectView(paramPluginRuntime.a(), view);
        return;
      }
      url = paramPluginRuntime.a().getUrl();
      if (paramVarArgs != null) {
        data = paramVarArgs[0];
      }
      if (TextUtils.isEmpty(data)) {
        return;
      }
      view = QZoneHelper.createQZoneFloatObjectView(paramPluginRuntime.a(), data);
      paramPluginRuntime = view;
      if (paramPluginRuntime != null) {
        localFrameLayout.addView(paramPluginRuntime, new FrameLayout.LayoutParams(-1, -1));
      }
    }
  }
  
  public static void handleSetFloatFinish(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if (paramPluginRuntime == null) {
      return;
    }
    paramPluginRuntime = paramPluginRuntime.a();
    if (paramPluginRuntime == null) {
      return;
    }
    paramVarArgs = (FrameLayout)paramPluginRuntime.findViewById(2131381075);
    if (paramVarArgs != null)
    {
      localObject = view;
      if (localObject != null) {
        paramVarArgs.removeView((View)localObject);
      }
    }
    QZoneHelper.stopQZoneFloatObjectView(paramPluginRuntime, view);
    view = null;
    paramVarArgs = new Intent("action_js2qzone");
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("cmd", "setFloat");
    paramVarArgs.putExtras((Bundle)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("actionString: ");
      ((StringBuilder)localObject).append(paramVarArgs.getAction());
      QLog.d("QZoneFloatJsHandleLogic", 2, ((StringBuilder)localObject).toString());
    }
    QZoneHelper.forwardToQzoneTransluentActivity(paramPluginRuntime, QZoneHelper.UserInfo.getInstance(), paramVarArgs);
    QZoneWebViewJsHandleLogic.doRefreshFeed(paramPluginRuntime);
    paramPluginRuntime.finish();
    if (QZoneHelper.isInFloatItemBlacklist()) {
      ToastUtil.a().a(QZoneHelper.STR_TIPS_FLOAT_ITEM_NOT_ALLOW_TO_SHOW, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneFloatJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */