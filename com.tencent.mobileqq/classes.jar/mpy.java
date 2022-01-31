import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class mpy
  extends mcf
{
  mpy(mpx parammpx) {}
  
  protected void b(mcj parammcj)
  {
    if (parammcj.jdField_b_of_type_Boolean) {
      return;
    }
    parammcj.jdField_b_of_type_Boolean = this.a.a("onAVActivityPreBackPressed");
    if (parammcj.jdField_b_of_type_Boolean) {
      parammcj.jdField_b_of_type_JavaLangString = "AVRegbagResultUI";
    }
    QLog.w(this.a.i, 1, "onAVActivityPreBackPressed, BlockSystemBack[" + parammcj.jdField_b_of_type_Boolean + "]");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mpy
 * JD-Core Version:    0.7.0.1
 */