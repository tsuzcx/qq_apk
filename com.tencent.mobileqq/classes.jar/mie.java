import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class mie
  implements axrs
{
  public void a(axsp paramaxsp, axsq paramaxsq)
  {
    if ((paramaxsp == null) || (paramaxsq == null)) {}
    axro localaxro;
    do
    {
      do
      {
        return;
      } while (!(paramaxsp instanceof axro));
      localaxro = (axro)paramaxsp;
      localaxro.jdField_a_of_type_Long += paramaxsq.c;
      paramaxsq.c = 0L;
      paramaxsq = "bytes=" + localaxro.jdField_a_of_type_Long + "-";
      localaxro.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaxsq);
      paramaxsq = localaxro.jdField_a_of_type_JavaLangString;
      if (paramaxsq.contains("range="))
      {
        paramaxsq = paramaxsq.substring(0, paramaxsq.lastIndexOf("range="));
        localaxro.jdField_a_of_type_JavaLangString = (paramaxsq + "range=" + localaxro.jdField_a_of_type_Long);
      }
    } while (!QLog.isColorLevel());
    QLog.i("ScoreManager", 1, "IBreakDownFix. url = " + ((axro)paramaxsp).jdField_a_of_type_JavaLangString + ", offset=" + localaxro.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mie
 * JD-Core Version:    0.7.0.1
 */