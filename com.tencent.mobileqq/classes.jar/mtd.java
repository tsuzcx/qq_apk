import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class mtd
  implements ayrz
{
  public void a(aysw paramaysw, aysx paramaysx)
  {
    if ((paramaysw == null) || (paramaysx == null)) {}
    ayrv localayrv;
    do
    {
      do
      {
        return;
      } while (!(paramaysw instanceof ayrv));
      localayrv = (ayrv)paramaysw;
      localayrv.jdField_a_of_type_Long += paramaysx.c;
      paramaysx.c = 0L;
      paramaysx = "bytes=" + localayrv.jdField_a_of_type_Long + "-";
      localayrv.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysx);
      paramaysx = localayrv.jdField_a_of_type_JavaLangString;
      if (paramaysx.contains("range="))
      {
        paramaysx = paramaysx.substring(0, paramaysx.lastIndexOf("range="));
        localayrv.jdField_a_of_type_JavaLangString = (paramaysx + "range=" + localayrv.jdField_a_of_type_Long);
      }
    } while (!QLog.isColorLevel());
    QLog.i("ScoreManager", 1, "IBreakDownFix. url = " + ((ayrv)paramaysw).jdField_a_of_type_JavaLangString + ", offset=" + localayrv.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mtd
 * JD-Core Version:    0.7.0.1
 */