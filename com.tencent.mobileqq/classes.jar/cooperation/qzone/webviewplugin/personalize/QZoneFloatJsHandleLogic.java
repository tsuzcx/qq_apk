package cooperation.qzone.webviewplugin.personalize;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import bgve;
import bhzt;
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
  
  public static void handleDownLoadFloatFinish(bgve parambgve, String... paramVarArgs)
  {
    if ((parambgve == null) || (parambgve.a() == null) || (parambgve.a() == null)) {}
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
        localFrameLayout = (FrameLayout)parambgve.a().findViewById(2131381043);
        if ((view != null) && (view.getParent() == localFrameLayout))
        {
          QZoneHelper.resumeQZoneFloatObjectView(parambgve.a(), view);
          return;
        }
        url = parambgve.a().getUrl();
        if (paramVarArgs != null) {
          data = paramVarArgs[0];
        }
      } while (TextUtils.isEmpty(data));
      view = QZoneHelper.createQZoneFloatObjectView(parambgve.a(), data);
    } while (view == null);
    localFrameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public static void handleSetFloatFinish(bgve parambgve, String... paramVarArgs)
  {
    if (parambgve == null) {}
    do
    {
      do
      {
        return;
        parambgve = parambgve.a();
      } while (parambgve == null);
      paramVarArgs = (FrameLayout)parambgve.findViewById(2131381043);
      if ((paramVarArgs != null) && (view != null)) {
        paramVarArgs.removeView(view);
      }
      QZoneHelper.stopQZoneFloatObjectView(parambgve, view);
      view = null;
      paramVarArgs = new Intent("action_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "setFloat");
      paramVarArgs.putExtras(localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneFloatJsHandleLogic", 2, "actionString: " + paramVarArgs.getAction());
      }
      QZoneHelper.forwardToQzoneTransluentActivity(parambgve, QZoneHelper.UserInfo.getInstance(), paramVarArgs);
      QZoneWebViewJsHandleLogic.doRefreshFeed(parambgve);
      parambgve.finish();
    } while (!QZoneHelper.isInFloatItemBlacklist());
    bhzt.a().a(QZoneHelper.STR_TIPS_FLOAT_ITEM_NOT_ALLOW_TO_SHOW, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneFloatJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */