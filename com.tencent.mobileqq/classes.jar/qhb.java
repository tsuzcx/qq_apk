import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

class qhb
  implements bdgt
{
  qhb(qha paramqha, String paramString) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    QLog.i("PTSSoLoader", 1, "[onLoadResult], resCode = " + paramInt);
    if (paramInt == 0)
    {
      paramLoadExtResult = bdgf.a(this.jdField_a_of_type_JavaLangString);
      QLog.i("PTSSoLoader", 1, "[onLoadResult], load so succeeded, name = " + this.jdField_a_of_type_JavaLangString + ", currentVersion = " + paramLoadExtResult);
      if (qha.a(this.jdField_a_of_type_Qha, paramLoadExtResult, "1.1.2")) {
        qha.a(this.jdField_a_of_type_Qha, true);
      }
    }
    qha.a(this.jdField_a_of_type_Qha, this.jdField_a_of_type_JavaLangString, paramInt, bdgf.a(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qhb
 * JD-Core Version:    0.7.0.1
 */