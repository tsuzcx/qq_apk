package cooperation.qqcircle.hybird;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class QCircleHybirdStyleFactory
{
  public static final String JS_PLUGIN_STYLE_TITLE_TEXT_COLOR = "titleTextColor";
  public static final String PARAM_KEY_SHOW_RIGHT_CANCEL = "show_right_cancel";
  public static final String PARAM_KEY_WEB_VIEW_MOVE_TIP = "move_web_view_top";
  public static final String PARAM_KEY_WV = "_wv";
  private static final String TAG = "QCircleHybirdStyleFactory";
  private static volatile QCircleHybirdStyleFactory sInstance;
  
  public static QCircleHybirdStyleFactory getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QCircleHybirdStyleFactory();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static void getIntentByParseUrl(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      QLog.e("QCircleHybirdStyleFactory", 1, "getIntentByParseUrl intent is null");
    }
    for (;;)
    {
      return;
      try
      {
        paramString = Uri.parse(paramString);
        if (paramString != null)
        {
          if ("1".equals(paramString.getQueryParameter("show_right_cancel"))) {
            paramIntent.putExtra("rightTopCancel", true);
          }
          if ("1".equals(paramString.getQueryParameter("move_web_view_top")))
          {
            paramIntent.putExtra("webViewMoveTop", true);
            return;
          }
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e("QCircleHybirdStyleFactory", 1, "getStyleFromUrl error " + paramIntent.getMessage());
        paramIntent.printStackTrace();
      }
    }
  }
  
  public static boolean isActivityTranslucentBrowserActivity(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getQueryParameter("_wv");
        if (!TextUtils.isEmpty(paramString))
        {
          long l = Long.parseLong(paramString);
          if ((l & 0x80000) != 0L) {
            return true;
          }
        }
        return false;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("QCircleHybirdStyleFactory", 1, "getStyleFromUrl error " + paramString.getMessage());
      paramString.printStackTrace();
    }
    return false;
  }
  
  public QCircleWebViewTitleStyle getDefaultStyle(Context paramContext)
  {
    QCircleWebViewTitleStyle localQCircleWebViewTitleStyle = new QCircleWebViewTitleStyle();
    if (paramContext == null)
    {
      QLog.d("QCircleHybirdStyleFactory", 1, "context is null return default");
      return localQCircleWebViewTitleStyle;
    }
    localQCircleWebViewTitleStyle.statusBarColor = paramContext.getResources().getColor(2131166253);
    localQCircleWebViewTitleStyle.titleBgColor = paramContext.getResources().getColor(2131166253);
    localQCircleWebViewTitleStyle.titleColor = paramContext.getResources().getColor(2131165351);
    localQCircleWebViewTitleStyle.leftAndRightBtnColor = paramContext.getResources().getColor(2131165351);
    return localQCircleWebViewTitleStyle;
  }
  
  public QCircleWebViewTitleStyle getStyleFromUrl(Context paramContext, String paramString)
  {
    paramContext = getDefaultStyle(paramContext);
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getQueryParameter("left_back_icon");
        if (!TextUtils.isEmpty(paramString)) {
          paramContext.mLeftBackIcon = Integer.parseInt(paramString);
        }
      }
      return paramContext;
    }
    catch (Exception paramString)
    {
      QLog.e("QCircleHybirdStyleFactory", 1, "getStyleFromUrl error " + paramString.getMessage());
      paramString.printStackTrace();
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.hybird.QCircleHybirdStyleFactory
 * JD-Core Version:    0.7.0.1
 */