package cooperation.comic.webbundle;

import android.os.Build;
import android.os.Build.VERSION;
import awpy;
import mpl;

public final class WebBundleReportUtils$1
  implements Runnable
{
  public WebBundleReportUtils$1(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    String str2;
    String str3;
    label18:
    String str4;
    label28:
    String str1;
    if (Build.BRAND == null)
    {
      str2 = "";
      if (Build.MODEL != null) {
        break label294;
      }
      str3 = "";
      if (Build.VERSION.RELEASE != null) {
        break label301;
      }
      str4 = "";
      switch (mpl.a())
      {
      case 0: 
      default: 
        str1 = "";
      }
    }
    for (;;)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(str2).append('|');
      localStringBuffer.append(str3).append('|');
      localStringBuffer.append(str4).append('|');
      localStringBuffer.append(str1).append('|');
      localStringBuffer.append(this.jdField_a_of_type_JavaLangString).append('|');
      localStringBuffer.append(this.jdField_b_of_type_JavaLangString).append('|');
      localStringBuffer.append(this.jdField_a_of_type_Int).append('|');
      localStringBuffer.append(this.jdField_b_of_type_Int).append('|');
      localStringBuffer.append(this.jdField_c_of_type_Int).append('|');
      localStringBuffer.append(this.jdField_d_of_type_Int).append('|');
      localStringBuffer.append(this.jdField_c_of_type_JavaLangString).append('|');
      localStringBuffer.append(this.jdField_d_of_type_JavaLangString).append('|');
      localStringBuffer.append(this.e).append('|');
      localStringBuffer.append(this.f);
      awpy.a(null, "sendtdbank|b_sng_qqvip_sng_qq_comic|sng_mobileqq_times_statistics", localStringBuffer.toString(), true);
      return;
      str2 = Build.BRAND;
      break;
      label294:
      str3 = Build.BOARD;
      break label18;
      label301:
      str4 = Build.VERSION.RELEASE;
      break label28;
      str1 = " UNKNOWN";
      continue;
      str1 = "WIFI";
      continue;
      str1 = "2G";
      continue;
      str1 = "3G";
      continue;
      str1 = "4G";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.comic.webbundle.WebBundleReportUtils.1
 * JD-Core Version:    0.7.0.1
 */