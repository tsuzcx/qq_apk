package cooperation.qzone.webviewplugin.personalize;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import bifw;
import bjkv;
import com.tencent.biz.pubaccount.CustomWebView;
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
  
  public static void handleDownLoadFloatFinish(bifw parambifw, String... paramVarArgs)
  {
    if ((parambifw == null) || (parambifw.a() == null) || (parambifw.a() == null)) {}
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
        localFrameLayout = (FrameLayout)parambifw.a().findViewById(2131381402);
        if ((view != null) && (view.getParent() == localFrameLayout))
        {
          QZoneHelper.resumeQZoneFloatObjectView(parambifw.a(), view);
          return;
        }
        url = parambifw.a().getUrl();
        if (paramVarArgs != null) {
          data = paramVarArgs[0];
        }
      } while (TextUtils.isEmpty(data));
      view = QZoneHelper.createQZoneFloatObjectView(parambifw.a(), data);
    } while (view == null);
    localFrameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public static void handleSetFloatFinish(bifw parambifw, String... paramVarArgs)
  {
    if (parambifw == null) {}
    do
    {
      do
      {
        return;
        parambifw = parambifw.a();
      } while (parambifw == null);
      paramVarArgs = (FrameLayout)parambifw.findViewById(2131381402);
      if ((paramVarArgs != null) && (view != null)) {
        paramVarArgs.removeView(view);
      }
      QZoneHelper.stopQZoneFloatObjectView(parambifw, view);
      view = null;
      paramVarArgs = new Intent("action_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "setFloat");
      paramVarArgs.putExtras(localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneFloatJsHandleLogic", 2, "actionString: " + paramVarArgs.getAction());
      }
      QZoneHelper.forwardToQzoneTransluentActivity(parambifw, QZoneHelper.UserInfo.getInstance(), paramVarArgs);
      QZoneWebViewJsHandleLogic.doRefreshFeed(parambifw);
      parambifw.finish();
    } while (!QZoneHelper.isInFloatItemBlacklist());
    bjkv.a().a(QZoneHelper.STR_TIPS_FLOAT_ITEM_NOT_ALLOW_TO_SHOW, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneFloatJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */