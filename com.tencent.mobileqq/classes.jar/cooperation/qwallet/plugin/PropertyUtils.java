package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;

public class PropertyUtils
{
  private static String mNetworkType;
  private static int mScreenWidth = 0;
  private static int mTitleBarHeight = 0;
  private static int mToastOffset = 0;
  
  public static String getNetworkType(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    if (!TextUtils.isEmpty(mNetworkType)) {
      return mNetworkType;
    }
    int i = NetworkUtil.a(paramContext.getApplicationContext());
    if (i == 1) {
      mNetworkType = "WIFI";
    }
    for (;;)
    {
      return mNetworkType;
      if (i == 2) {
        mNetworkType = "2G";
      } else if (i == 3) {
        mNetworkType = "3G";
      } else if (i == 4) {
        mNetworkType = "4G";
      } else {
        mNetworkType = "unknown";
      }
    }
  }
  
  public static int getScreenWidth(Activity paramActivity)
  {
    if (mScreenWidth > 0) {
      return mScreenWidth;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    mScreenWidth = localDisplayMetrics.widthPixels;
    return mScreenWidth;
  }
  
  public static int getTitleBarHeight(Activity paramActivity)
  {
    if (mTitleBarHeight > 0) {
      return mTitleBarHeight;
    }
    mTitleBarHeight = paramActivity.getResources().getDimensionPixelSize(2131299166);
    return mTitleBarHeight;
  }
  
  public static int getToastOffset(Context paramContext)
  {
    if (mToastOffset > 0) {
      return mToastOffset;
    }
    mToastOffset = paramContext.getResources().getDimensionPixelSize(2131299166) - (int)DisplayUtils.a(paramContext, 5.0F);
    return mToastOffset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.PropertyUtils
 * JD-Core Version:    0.7.0.1
 */