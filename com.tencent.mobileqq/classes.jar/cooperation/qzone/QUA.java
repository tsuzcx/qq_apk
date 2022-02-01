package cooperation.qzone;

public class QUA
{
  public static final String NOW = "2021-01-15";
  private static final String QUA = "V1_AND_SQ_8.5.5_1630_YYB_D";
  private static String VERSION_FOR_MM;
  private static String VERSION_FOR_P;
  public static final String quaBuildNum = "100084";
  
  private static String getCoreInQua()
  {
    int i = "V1_AND_SQ_8.5.5_1630_YYB_D".indexOf("_");
    int k = "V1_AND_SQ_8.5.5_1630_YYB_D".lastIndexOf("_");
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      int j = k;
      if (k < 0) {
        j = "V1_AND_SQ_8.5.5_1630_YYB_D".length();
      }
      return "V1_AND_SQ_8.5.5_1630_YYB_D".substring(i, j);
      i += 1;
    }
  }
  
  public static String getQUA3()
  {
    return "V1_AND_SQ_8.5.5_1630_YYB_D";
  }
  
  public static String getVersionForHabo()
  {
    if (VERSION_FOR_MM == null) {
      VERSION_FOR_MM = getCoreInQua();
    }
    return VERSION_FOR_MM;
  }
  
  public static String getVersionForPic()
  {
    if (VERSION_FOR_P == null) {
      VERSION_FOR_P = getCoreInQua();
    }
    return VERSION_FOR_P;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qzone.QUA
 * JD-Core Version:    0.7.0.1
 */