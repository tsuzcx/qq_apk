import android.content.Intent;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.qphone.base.util.QLog;

class mku
  implements mil
{
  mku(mkt parammkt, long paramLong) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (mkt.a(this.jdField_a_of_type_Mkt)) {
        return;
      }
      if (this.jdField_a_of_type_Mkt.a.getIntent().getBooleanExtra("isDoubleVideoMeeting", false)) {
        this.jdField_a_of_type_Mkt.a("0X80051FE");
      }
      for (;;)
      {
        QLog.w("VideoInviteUILock", 1, "SlideAcceptListener, seq[" + this.jdField_a_of_type_Long + "]");
        this.jdField_a_of_type_Mkt.a.d = true;
        this.jdField_a_of_type_Mkt.a.c(this.jdField_a_of_type_Long);
        return;
        if (this.jdField_a_of_type_Mkt.a.b) {
          this.jdField_a_of_type_Mkt.a("0X8004201");
        } else {
          this.jdField_a_of_type_Mkt.a("0X8004205");
        }
      }
    }
    if (this.jdField_a_of_type_Mkt.a.b)
    {
      this.jdField_a_of_type_Mkt.a("0X800439E");
      return;
    }
    this.jdField_a_of_type_Mkt.a("0X80043FD");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mku
 * JD-Core Version:    0.7.0.1
 */