import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class lbf
{
  public static String a()
  {
    return bhgg.a(anhk.ba + "qav" + File.separator);
  }
  
  public static String b()
  {
    return bhgg.a(anhk.ba + "ptv_template" + File.separator);
  }
  
  public static String c()
  {
    return bhgg.a(anhk.ba + "new_ptv_template" + File.separator);
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
    return bhgg.a(anhk.ba + "funcall" + File.separator);
  }
  
  public static String g()
  {
    if (bgjq.a()) {}
    for (String str1 = bhgg.a(anhk.ba);; str1 = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath())
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
    return bhgg.a(anhk.ba + "av_image_data" + File.separator);
  }
  
  public static String j()
  {
    return bhgg.a(anhk.ba + "av_report_record_dir");
  }
  
  public static String k()
  {
    return BaseApplicationImpl.getLogExternalPath(BaseApplicationImpl.getContext()) + "/tencent/msflogs/com/tencent/mobileqq/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lbf
 * JD-Core Version:    0.7.0.1
 */