import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public class sae
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
      sai.d("AppMarketUtils", "tryGoAppMarket:activity = null");
    }
    String str1;
    String str2;
    do
    {
      return false;
      str1 = rxf.a().b();
      str2 = rxf.a().a();
      sai.b("AppMarketUtils", "goAppMarket:\nappStorePackageName = " + str2 + "\nappStoreVendorId =" + rxf.a().d() + "\nappStoreScheme =" + str1);
    } while ((TextUtils.isEmpty(str1)) || (str1.startsWith("http")));
    return a(paramActivity, str1, str2);
  }
  
  private static boolean a(Activity paramActivity, String paramString1, String paramString2)
  {
    sai.b("AppMarketUtils", "goAppMarket :\npackageName = " + paramString2 + "\nurl = " + paramString1);
    try
    {
      paramActivity.startActivity(a(paramString1, paramString2));
      return true;
    }
    catch (Exception paramActivity)
    {
      sai.d("AppMarketUtils", "goAppMarket error messaage = " + paramActivity.getMessage());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sae
 * JD-Core Version:    0.7.0.1
 */