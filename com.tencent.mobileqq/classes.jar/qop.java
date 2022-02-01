import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

class qop
  implements bcob
{
  qop(qoo paramqoo, String paramString) {}
  
  public void a(int paramInt, LoadExtResult paramLoadExtResult)
  {
    QLog.i("PTSSoLoader", 1, "[onLoadResult], resCode = " + paramInt);
    if (paramInt == 0)
    {
      paramLoadExtResult = bcnn.a(this.jdField_a_of_type_JavaLangString);
      QLog.i("PTSSoLoader", 1, "[onLoadResult], load so succeeded, name = " + this.jdField_a_of_type_JavaLangString + ", currentVersion = " + paramLoadExtResult);
      if (qoo.a(this.jdField_a_of_type_Qoo, paramLoadExtResult, "1.1.1")) {
        qoo.a(this.jdField_a_of_type_Qoo, true);
      }
    }
    qoo.a(this.jdField_a_of_type_Qoo, this.jdField_a_of_type_JavaLangString, paramInt, bcnn.a(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qop
 * JD-Core Version:    0.7.0.1
 */