import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class rtu
  extends bdzm
{
  rtu(rtt paramrtt) {}
  
  public void handleMessage(Message paramMessage)
  {
    bduk localbduk = (bduk)paramMessage.obj;
    if ((localbduk == null) || (localbduk.jdField_b_of_type_Int != 24) || (localbduk.c != 10)) {}
    while ((localbduk.jdField_b_of_type_Long != this.a.a.a) || (localbduk.f.equals(rtt.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1002: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mVideoTransProcessorHandler transfer=" + localbduk.e + ", total=" + localbduk.a);
      rtt.a(this.a, (float)localbduk.e * 100.0F / (float)localbduk.a);
      return;
    case 1003: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler send finished!");
      rtt.a(this.a, localbduk.f);
      rtt.b(this.a, localbduk.i);
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler mImageMd5=" + rtt.a(this.a) + ", mImageUrl=" + rtt.b(this.a));
      rtt.a(this.a, 0, rtt.b(this.a), rtt.a(this.a), null, null, null);
      return;
    }
    QLog.d("KingsMomentVideoDeliveControllerr", 1, "upload king moment cover failed");
    rtt.a(this.a, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtu
 * JD-Core Version:    0.7.0.1
 */