package cooperation.qwallet.plugin.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.qqpay.ui.R.dimen;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import cooperation.qwallet.plugin.IPropertyUtils;
import cooperation.qwallet.plugin.QWalletPluginProxyActivity;

public class PropertyUtilsImpl
  implements IPropertyUtils
{
  private static String mNetworkType;
  private static int mScreenWidth;
  private static int mTitleBarHeight;
  private static int mToastOffset;
  
  public String getNetworkType(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    if (!TextUtils.isEmpty(mNetworkType)) {
      return mNetworkType;
    }
    int i = NetworkUtil.getSystemNetwork(paramContext.getApplicationContext());
    if (i == 1) {
      mNetworkType = "WIFI";
    } else if (i == 2) {
      mNetworkType = "2G";
    } else if (i == 3) {
      mNetworkType = "3G";
    } else if (i == 4) {
      mNetworkType = "4G";
    } else {
      mNetworkType = "unknown";
    }
    return mNetworkType;
  }
  
  public String getQWalletPluginProxyActivityName()
  {
    return QWalletPluginProxyActivity.class.getName();
  }
  
  public int getScreenWidth(Activity paramActivity)
  {
    int i = mScreenWidth;
    if (i > 0) {
      return i;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    mScreenWidth = localDisplayMetrics.widthPixels;
    return mScreenWidth;
  }
  
  public int getTitleBarHeight(Activity paramActivity)
  {
    int i = mTitleBarHeight;
    if (i > 0) {
      return i;
    }
    mTitleBarHeight = paramActivity.getResources().getDimensionPixelSize(R.dimen.b);
    return mTitleBarHeight;
  }
  
  public int getToastOffset(Context paramContext)
  {
    int i = mToastOffset;
    if (i > 0) {
      return i;
    }
    mToastOffset = paramContext.getResources().getDimensionPixelSize(R.dimen.b) - (int)DisplayUtils.a(paramContext, 5.0F);
    return mToastOffset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.PropertyUtilsImpl
 * JD-Core Version:    0.7.0.1
 */