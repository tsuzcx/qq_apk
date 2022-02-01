import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class mqu
  extends mct
{
  mqu(mqt parammqt) {}
  
  protected void b(mcx parammcx)
  {
    if (parammcx.jdField_b_of_type_Boolean) {
      return;
    }
    parammcx.jdField_b_of_type_Boolean = this.a.a("onAVActivityPreBackPressed");
    if (parammcx.jdField_b_of_type_Boolean) {
      parammcx.jdField_b_of_type_JavaLangString = "AVRegbagResultUI";
    }
    QLog.w(this.a.i, 1, "onAVActivityPreBackPressed, BlockSystemBack[" + parammcx.jdField_b_of_type_Boolean + "]");
  }
  
  protected void e(String paramString)
  {
    if (this.a.a() != null)
    {
      QLog.w(this.a.i, 1, "onActivityOnResume, peerUin[" + paramString + "], mStarter[" + this.a.a.jdField_b_of_type_Boolean + "], mPlayUin[" + this.a.a.jdField_b_of_type_JavaLangString + "], mStartUin[" + this.a.a.a + "]");
      if (((this.a.a.jdField_b_of_type_Boolean) && (TextUtils.equals(this.a.a.jdField_b_of_type_JavaLangString, paramString))) || ((!this.a.a.jdField_b_of_type_Boolean) && (TextUtils.equals(this.a.a.a, paramString)))) {
        this.a.c();
      }
    }
    else
    {
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqu
 * JD-Core Version:    0.7.0.1
 */