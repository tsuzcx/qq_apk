import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class mta
  implements aysb
{
  public void a(aysy paramaysy, aysz paramaysz)
  {
    if ((paramaysy == null) || (paramaysz == null)) {}
    ayrx localayrx;
    do
    {
      do
      {
        return;
      } while (!(paramaysy instanceof ayrx));
      localayrx = (ayrx)paramaysy;
      localayrx.jdField_a_of_type_Long += paramaysz.c;
      paramaysz.c = 0L;
      paramaysz = "bytes=" + localayrx.jdField_a_of_type_Long + "-";
      localayrx.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysz);
      paramaysz = localayrx.jdField_a_of_type_JavaLangString;
      if (paramaysz.contains("range="))
      {
        paramaysz = paramaysz.substring(0, paramaysz.lastIndexOf("range="));
        localayrx.jdField_a_of_type_JavaLangString = (paramaysz + "range=" + localayrx.jdField_a_of_type_Long);
      }
    } while (!QLog.isColorLevel());
    QLog.i("ScoreManager", 1, "IBreakDownFix. url = " + ((ayrx)paramaysy).jdField_a_of_type_JavaLangString + ", offset=" + localayrx.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mta
 * JD-Core Version:    0.7.0.1
 */