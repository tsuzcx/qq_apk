package cooperation.weiyun.utils;

import android.os.Environment;
import java.io.File;

public class WeiyunPathUtil
{
  private static String a;
  private static String b;
  
  public static String a()
  {
    if (a != null) {
      return a;
    }
    String str2 = Environment.getExternalStorageDirectory().getAbsolutePath();
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    a = str1;
    return str1;
  }
  
  public static String a(long paramLong)
  {
    return b() + paramLong + "/";
  }
  
  public static String b()
  {
    if (b != null) {
      return b;
    }
    String str = a();
    str = str + "Tencent" + "/" + "weiyun" + "/";
    b = str;
    return str;
  }
  
  public static String b(long paramLong)
  {
    return a(paramLong) + "disk_file_cache" + "/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.utils.WeiyunPathUtil
 * JD-Core Version:    0.7.0.1
 */