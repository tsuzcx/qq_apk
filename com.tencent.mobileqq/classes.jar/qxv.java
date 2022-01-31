import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class qxv
  extends bayj
{
  qxv(qxu paramqxu) {}
  
  public void handleMessage(Message paramMessage)
  {
    bass localbass = (bass)paramMessage.obj;
    if ((localbass == null) || (localbass.jdField_b_of_type_Int != 24) || (localbass.c != 10)) {}
    while ((localbass.jdField_b_of_type_Long != this.a.a.a) || (localbass.f.equals(qxu.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1002: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mVideoTransProcessorHandler transfer=" + localbass.e + ", total=" + localbass.a);
      qxu.a(this.a, (float)localbass.e * 100.0F / (float)localbass.a);
      return;
    case 1003: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler send finished!");
      qxu.a(this.a, localbass.f);
      qxu.b(this.a, localbass.i);
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler mImageMd5=" + qxu.a(this.a) + ", mImageUrl=" + qxu.b(this.a));
      qxu.a(this.a, 0, qxu.b(this.a), qxu.a(this.a), null, null, null);
      return;
    }
    QLog.d("KingsMomentVideoDeliveControllerr", 1, "upload king moment cover failed");
    qxu.a(this.a, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qxv
 * JD-Core Version:    0.7.0.1
 */