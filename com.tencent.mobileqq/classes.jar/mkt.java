import android.content.Intent;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.qphone.base.util.QLog;

class mkt
  implements mig
{
  mkt(mks parammks, long paramLong) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (mks.a(this.jdField_a_of_type_Mks)) {
        return;
      }
      if (this.jdField_a_of_type_Mks.a.getIntent().getBooleanExtra("isDoubleVideoMeeting", false)) {
        this.jdField_a_of_type_Mks.a("0X80051FE");
      }
      for (;;)
      {
        QLog.w("VideoInviteUILock", 1, "SlideAcceptListener, seq[" + this.jdField_a_of_type_Long + "]");
        this.jdField_a_of_type_Mks.a.d = true;
        this.jdField_a_of_type_Mks.a.c(this.jdField_a_of_type_Long);
        return;
        if (this.jdField_a_of_type_Mks.a.b) {
          this.jdField_a_of_type_Mks.a("0X8004201");
        } else {
          this.jdField_a_of_type_Mks.a("0X8004205");
        }
      }
    }
    if (this.jdField_a_of_type_Mks.a.b)
    {
      this.jdField_a_of_type_Mks.a("0X800439E");
      return;
    }
    this.jdField_a_of_type_Mks.a("0X80043FD");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mkt
 * JD-Core Version:    0.7.0.1
 */