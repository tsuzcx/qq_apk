import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

class qnc
  implements bbzh
{
  qnc(qnb paramqnb, String paramString) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    QLog.i("PTSSoLoader", 1, "[onLoadResult], resCode = " + paramInt);
    if (paramInt == 0)
    {
      paramLoadExtResult = bbyt.a(this.jdField_a_of_type_JavaLangString);
      QLog.i("PTSSoLoader", 1, "[onLoadResult], load so succeeded, name = " + this.jdField_a_of_type_JavaLangString + ", currentVersion = " + paramLoadExtResult);
      if (qnb.a(this.jdField_a_of_type_Qnb, paramLoadExtResult, "1.1.2")) {
        qnb.a(this.jdField_a_of_type_Qnb, true);
      }
    }
    qnb.a(this.jdField_a_of_type_Qnb, this.jdField_a_of_type_JavaLangString, paramInt, bbyt.a(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qnc
 * JD-Core Version:    0.7.0.1
 */