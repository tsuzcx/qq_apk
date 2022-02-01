import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class rkq
  extends beyf
{
  rkq(rkp paramrkp) {}
  
  public void handleMessage(Message paramMessage)
  {
    bete localbete = (bete)paramMessage.obj;
    if ((localbete == null) || (localbete.jdField_b_of_type_Int != 24) || (localbete.c != 10)) {}
    while ((localbete.jdField_b_of_type_Long != this.a.a.a) || (localbete.f.equals(rkp.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1002: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mVideoTransProcessorHandler transfer=" + localbete.e + ", total=" + localbete.a);
      rkp.a(this.a, (float)localbete.e * 100.0F / (float)localbete.a);
      return;
    case 1003: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler send finished!");
      rkp.a(this.a, localbete.f);
      rkp.b(this.a, localbete.i);
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler mImageMd5=" + rkp.a(this.a) + ", mImageUrl=" + rkp.b(this.a));
      rkp.a(this.a, 0, rkp.b(this.a), rkp.a(this.a), null, null, null);
      return;
    }
    QLog.d("KingsMomentVideoDeliveControllerr", 1, "upload king moment cover failed");
    rkp.a(this.a, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkq
 * JD-Core Version:    0.7.0.1
 */