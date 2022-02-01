import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class mpx
  extends mbx
{
  mpx(mpw parammpw) {}
  
  protected void b(mcb parammcb)
  {
    if (parammcb.jdField_b_of_type_Boolean) {
      return;
    }
    parammcb.jdField_b_of_type_Boolean = this.a.a("onAVActivityPreBackPressed");
    if (parammcb.jdField_b_of_type_Boolean) {
      parammcb.jdField_b_of_type_JavaLangString = "AVRegbagResultUI";
    }
    QLog.w(this.a.i, 1, "onAVActivityPreBackPressed, BlockSystemBack[" + parammcb.jdField_b_of_type_Boolean + "]");
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
 * Qualified Name:     mpx
 * JD-Core Version:    0.7.0.1
 */