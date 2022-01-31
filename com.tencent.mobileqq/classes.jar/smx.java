import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public class smx
{
  public static Intent a(String paramString1, String paramString2)
  {
    paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.setPackage(paramString2);
    }
    paramString1.setFlags(536870912);
    paramString1.putExtra("big_brother_source_key", "biz_src_jc_gzh_weishi");
    return paramString1;
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (paramActivity == null) {
      snb.d("AppMarketUtils", "tryGoAppMarket:activity = null");
    }
    String str1;
    String str2;
    do
    {
      return false;
      str1 = sjy.a().b();
      str2 = sjy.a().a();
      snb.b("AppMarketUtils", "goAppMarket:\nappStorePackageName = " + str2 + "\nappStoreVendorId =" + sjy.a().d() + "\nappStoreScheme =" + str1);
    } while ((TextUtils.isEmpty(str1)) || (str1.startsWith("http")));
    return a(paramActivity, str1, str2);
  }
  
  private static boolean a(Activity paramActivity, String paramString1, String paramString2)
  {
    snb.b("AppMarketUtils", "goAppMarket :\npackageName = " + paramString2 + "\nurl = " + paramString1);
    try
    {
      paramActivity.startActivity(a(paramString1, paramString2));
      return true;
    }
    catch (Exception paramActivity)
    {
      snb.d("AppMarketUtils", "goAppMarket error messaage = " + paramActivity.getMessage());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     smx
 * JD-Core Version:    0.7.0.1
 */