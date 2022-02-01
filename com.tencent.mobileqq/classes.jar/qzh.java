import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

class qzh
  implements bdgc
{
  qzh(qzg paramqzg, String paramString) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    QLog.i("PTSSoLoader", 1, "[onLoadResult], resCode = " + paramInt);
    if (paramInt == 0)
    {
      paramLoadExtResult = bdfo.a(this.jdField_a_of_type_JavaLangString);
      QLog.i("PTSSoLoader", 1, "[onLoadResult], load so succeeded, name = " + this.jdField_a_of_type_JavaLangString + ", currentVersion = " + paramLoadExtResult);
      if (qzg.a(this.jdField_a_of_type_Qzg, paramLoadExtResult, "1.1.2")) {
        qzg.a(this.jdField_a_of_type_Qzg, true);
      }
    }
    qzg.a(this.jdField_a_of_type_Qzg, this.jdField_a_of_type_JavaLangString, paramInt, bdfo.a(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzh
 * JD-Core Version:    0.7.0.1
 */