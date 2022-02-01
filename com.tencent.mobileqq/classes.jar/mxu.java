import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class mxu
  extends ampv
{
  mxu(mxt parammxt) {}
  
  protected void onGetRealNameStatusForAV(boolean paramBoolean)
  {
    Activity localActivity;
    if (paramBoolean)
    {
      localActivity = (Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localActivity != null) && (!localActivity.isFinishing()))
      {
        bcef.b(null, "dc00898", "", "", "0X800B079", "0X800B079", this.a.jdField_a_of_type_Int, 0, "", "", "", "");
        if (!this.a.jdField_a_of_type_JavaLangString.isEmpty()) {
          break label206;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AvGameManager", 2, "onGetRealNameStatusForAV createAvGameRoom");
        }
        if (this.a.jdField_b_of_type_Int != 9) {
          break label171;
        }
        this.a.jdField_a_of_type_Mxn.a(localActivity, 9);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RealName", 2, "onGetRealNameStatusForAV authed: " + paramBoolean + ". Remove observer.");
      }
      mxn.a(this.a.jdField_a_of_type_Mxn).removeObserver(mxn.a(this.a.jdField_a_of_type_Mxn));
      return;
      label171:
      this.a.jdField_a_of_type_Mxn.a(localActivity, this.a.jdField_b_of_type_Int, this.a.jdField_b_of_type_JavaLangString, this.a.c);
      continue;
      label206:
      if (QLog.isColorLevel()) {
        QLog.i("AvGameManager", 2, "onGetRealNameStatusForAV joinAvGameRoom. roomId: " + this.a.jdField_a_of_type_JavaLangString);
      }
      if (this.a.jdField_b_of_type_Int == 6) {
        this.a.jdField_a_of_type_Mxn.a(localActivity, 9);
      } else {
        this.a.jdField_a_of_type_Mxn.a(localActivity, this.a.jdField_b_of_type_Int, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxu
 * JD-Core Version:    0.7.0.1
 */