import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class lql
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  long b = 0L;
  
  public lql(String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = ("EventCountLog_" + paramString);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  void a()
  {
    if (!AudioHelper.e()) {}
    long l1;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_Int += 1;
    } while (this.b >= l1);
    long l2 = this.jdField_a_of_type_Long;
    long l3 = this.b;
    this.b = (l1 + this.jdField_a_of_type_Long);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "EventCountLog, eventCount[" + this.jdField_a_of_type_Int + "], intervalMS[" + (l2 + l1 - l3) + "]");
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lql
 * JD-Core Version:    0.7.0.1
 */