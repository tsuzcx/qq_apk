package com.tencent.qflutter;

import android.app.Activity;
import android.content.Context;
import com.idlefish.flutterboost.containers.BoostFlutterActivity;
import com.idlefish.flutterboost.containers.BoostFlutterActivity.NewEngineIntentBuilder;
import com.tencent.qflutter.utils.FLog;
import java.util.HashMap;
import java.util.Map;

public class PageRouter
{
  public static final String FLUTTER_COLOR_LIST = "qflutter://color_list";
  public static final String FLUTTER_FRAGMENT_PAGE_URL = "sample://flutterFragmentPage";
  public static final String FLUTTER_HOME = "qflutter://home_page";
  public static final String NATIVE_PAGE_URL = "sample://nativePage";
  public static final Map<String, String> pageName = new HashMap();
  
  static
  {
    pageName.put("qflutter://home_page", "test_homepage");
    pageName.put("qflutter://color_list", "test_color_list");
  }
  
  public static boolean openPageByUrl(Context paramContext, String paramString, Map paramMap)
  {
    return openPageByUrl(paramContext, paramString, paramMap, 0);
  }
  
  public static boolean openPageByUrl(Context paramContext, String paramString, Map paramMap, int paramInt)
  {
    paramString = paramString.split("\\?")[0];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openPageByUrl");
    localStringBuilder.append(paramString);
    FLog.i("QFlutter", localStringBuilder.toString());
    try
    {
      if (pageName.containsKey(paramString))
      {
        FLog.i("QFlutter", "has key");
        paramMap = BoostFlutterActivity.withNewEngine().url((String)pageName.get(paramString)).params(paramMap).build(paramContext);
        if ((paramContext instanceof Activity))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("is activity");
          localStringBuilder.append(paramString);
          FLog.i("QFlutter", localStringBuilder.toString());
          ((Activity)paramContext).startActivityForResult(paramMap, paramInt);
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("not activity");
          localStringBuilder.append(paramString);
          FLog.i("QFlutter", localStringBuilder.toString());
          paramContext.startActivity(paramMap);
        }
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append("no route for path");
        paramContext.append(paramString);
        FLog.i("QFlutter", paramContext.toString());
        return false;
      }
      return true;
    }
    catch (Throwable paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qflutter.PageRouter
 * JD-Core Version:    0.7.0.1
 */