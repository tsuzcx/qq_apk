package cooperation.qqreader.utils;

import android.content.Context;
import android.text.TextUtils;
import bgvn;

public final class QRDebugEnvUrlUtils
{
  private static String jdField_a_of_type_JavaLangString;
  private static boolean jdField_a_of_type_Boolean;
  
  public static String getTestEnv()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static boolean getTestMode()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static String getTestUrl(String paramString)
  {
    if ((!jdField_a_of_type_Boolean) || (TextUtils.isEmpty(paramString))) {}
    while ((!paramString.contains("cdn.vip.qq.com")) || (paramString.contains("h5.books.qq.com"))) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("h5.books.qq.com/proxy/domain/cdn.vip.qq.com");
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {}
    for (String str = "";; str = "/" + jdField_a_of_type_JavaLangString) {
      return paramString.replace("cdn.vip.qq.com", str);
    }
  }
  
  public static void initTestEnv(Context paramContext)
  {
    jdField_a_of_type_Boolean = bgvn.a(paramContext);
    jdField_a_of_type_JavaLangString = bgvn.a(paramContext);
  }
  
  public static boolean isDebugEnv()
  {
    return false;
  }
  
  public static void setTestEnv(Context paramContext, boolean paramBoolean, String paramString)
  {
    bgvn.a(paramContext, paramBoolean, paramString);
    jdField_a_of_type_Boolean = paramBoolean;
    jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.utils.QRDebugEnvUrlUtils
 * JD-Core Version:    0.7.0.1
 */