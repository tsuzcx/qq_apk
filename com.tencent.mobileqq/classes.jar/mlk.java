import android.content.Intent;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.qphone.base.util.QLog;

class mlk
  implements mix
{
  mlk(mlj parammlj, long paramLong) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (mlj.a(this.jdField_a_of_type_Mlj)) {
        return;
      }
      if (this.jdField_a_of_type_Mlj.a.getIntent().getBooleanExtra("isDoubleVideoMeeting", false)) {
        this.jdField_a_of_type_Mlj.a("0X80051FE");
      }
      for (;;)
      {
        QLog.w("VideoInviteUILock", 1, "SlideAcceptListener, seq[" + this.jdField_a_of_type_Long + "]");
        this.jdField_a_of_type_Mlj.a.d = true;
        this.jdField_a_of_type_Mlj.a.c(this.jdField_a_of_type_Long);
        return;
        if (this.jdField_a_of_type_Mlj.a.b) {
          this.jdField_a_of_type_Mlj.a("0X8004201");
        } else {
          this.jdField_a_of_type_Mlj.a("0X8004205");
        }
      }
    }
    if (this.jdField_a_of_type_Mlj.a.b)
    {
      this.jdField_a_of_type_Mlj.a("0X800439E");
      return;
    }
    this.jdField_a_of_type_Mlj.a("0X80043FD");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mlk
 * JD-Core Version:    0.7.0.1
 */