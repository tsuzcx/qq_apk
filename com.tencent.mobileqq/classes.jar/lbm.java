import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class lbm
{
  public static String a()
  {
    return bigv.a(antf.ba + "qav" + File.separator);
  }
  
  public static String b()
  {
    return bigv.a(antf.ba + "ptv_template" + File.separator);
  }
  
  public static String c()
  {
    return bigv.a(antf.ba + "new_ptv_template" + File.separator);
  }
  
  public static String d()
  {
    return c() + "new_ptv_template_usable" + File.separator;
  }
  
  public static String e()
  {
    return a() + "effect";
  }
  
  public static String f()
  {
    return bigv.a(antf.ba + "funcall" + File.separator);
  }
  
  public static String g()
  {
    if (bhjr.a()) {}
    for (String str1 = bigv.a(antf.ba);; str1 = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath())
    {
      String str2 = str1;
      if (str1 != null)
      {
        str2 = str1;
        if (!str1.endsWith(File.separator)) {
          str2 = str1 + File.separator;
        }
      }
      return str2 + "pddata/prd/" + "av_redpacket" + File.separator;
    }
  }
  
  public static String h()
  {
    return a() + "beauty" + File.separator;
  }
  
  public static String i()
  {
    return bigv.a(antf.ba + "av_image_data" + File.separator);
  }
  
  public static String j()
  {
    return bigv.a(antf.ba + "av_report_record_dir");
  }
  
  public static String k()
  {
    return BaseApplicationImpl.getLogExternalPath(BaseApplicationImpl.getContext()) + "/tencent/msflogs/com/tencent/mobileqq/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lbm
 * JD-Core Version:    0.7.0.1
 */