package cooperation.qqpim;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class QQPimJumpHelper
{
  public static Intent a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpim");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      int i = localPackageManager.getPackageInfo("com.tencent.qqpim", 1).versionCode;
      if (i < 1171)
      {
        paramContext = a(paramContext);
        paramContext.putExtra("big_brother_source_key", "biz_src_qqpim");
        return paramContext;
      }
      paramContext = new Intent();
      paramContext.setPackage("com.tencent.qqpim");
      paramContext.setAction("com.tencent.qqpim.action_open_qqpim");
      paramContext.putExtra("product_package", "com.tencent.mobileqq");
      paramContext.putExtra("model_name", paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        paramContext.putExtra("account_name", paramString2);
      }
      paramContext.setFlags(67108864);
      paramContext.setFlags(268435456);
      paramContext.putExtra("big_brother_source_key", "biz_src_qqpim");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo("com.tencent.qqpim", 1);
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      paramContext = null;
    }
    return paramContext != null;
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, QQPimBridgeActivity.class);
    localIntent.putExtras(paramBundle);
    paramActivity.startActivity(localIntent);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Bundle paramBundle)
  {
    if (a(paramActivity))
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006711", "0X8006711", 0, 0, "", "", "", "");
      paramActivity.startActivity(a(paramActivity, QQPimDefineList.s, null));
      return;
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006712", "0X8006712", 0, 0, "", "", "", "");
    paramQQAppInterface = new Intent();
    paramQQAppInterface.setClass(paramActivity, QQPimBridgeActivity.class);
    paramQQAppInterface.putExtras(paramBundle);
    paramActivity.startActivity(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqpim.QQPimJumpHelper
 * JD-Core Version:    0.7.0.1
 */