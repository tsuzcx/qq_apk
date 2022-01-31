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
  private static SurfaceView a;
  public static String a;
  private static String b = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static void a(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramPluginRuntime == null) || (paramPluginRuntime.a() == null) || (paramPluginRuntime.a() == null)) {}
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
        localFrameLayout = (FrameLayout)paramPluginRuntime.a().findViewById(2131362573);
        if ((jdField_a_of_type_AndroidViewSurfaceView != null) && (jdField_a_of_type_AndroidViewSurfaceView.getParent() == localFrameLayout))
        {
          QZoneHelper.b(paramPluginRuntime.a(), jdField_a_of_type_AndroidViewSurfaceView);
          return;
        }
        jdField_a_of_type_JavaLangString = paramPluginRuntime.a().getUrl();
        if (paramVarArgs != null) {
          b = paramVarArgs[0];
        }
      } while (TextUtils.isEmpty(b));
      jdField_a_of_type_AndroidViewSurfaceView = QZoneHelper.a(paramPluginRuntime.a(), b);
    } while (jdField_a_of_type_AndroidViewSurfaceView == null);
    localFrameLayout.addView(jdField_a_of_type_AndroidViewSurfaceView, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public static void b(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if (paramPluginRuntime == null) {}
    do
    {
      do
      {
        return;
        paramPluginRuntime = paramPluginRuntime.a();
      } while (paramPluginRuntime == null);
      paramVarArgs = (FrameLayout)paramPluginRuntime.findViewById(2131362573);
      if ((paramVarArgs != null) && (jdField_a_of_type_AndroidViewSurfaceView != null)) {
        paramVarArgs.removeView(jdField_a_of_type_AndroidViewSurfaceView);
      }
      QZoneHelper.a(paramPluginRuntime, jdField_a_of_type_AndroidViewSurfaceView);
      jdField_a_of_type_AndroidViewSurfaceView = null;
      paramVarArgs = new Intent("action_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "setFloat");
      paramVarArgs.putExtras(localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneFloatJsHandleLogic", 2, "actionString: " + paramVarArgs.getAction());
      }
      QZoneHelper.a(paramPluginRuntime, QZoneHelper.UserInfo.a(), paramVarArgs);
      QZoneWebViewJsHandleLogic.a(paramPluginRuntime);
      paramPluginRuntime.finish();
    } while (!QZoneHelper.f());
    ToastUtil.a().a("主人~~你的手机系统不太适应漂浮装扮，请升级后再体验", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneFloatJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */