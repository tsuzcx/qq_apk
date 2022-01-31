import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class pwt
  extends axvs
{
  pwt(pws parampws) {}
  
  public void handleMessage(Message paramMessage)
  {
    axqf localaxqf = (axqf)paramMessage.obj;
    if ((localaxqf == null) || (localaxqf.jdField_b_of_type_Int != 24) || (localaxqf.c != 10)) {}
    while ((localaxqf.jdField_b_of_type_Long != this.a.a.a) || (localaxqf.f.equals(pws.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1002: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mVideoTransProcessorHandler transfer=" + localaxqf.e + ", total=" + localaxqf.a);
      pws.a(this.a, (float)localaxqf.e * 100.0F / (float)localaxqf.a);
      return;
    case 1003: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler send finished!");
      pws.a(this.a, localaxqf.f);
      pws.b(this.a, localaxqf.i);
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler mImageMd5=" + pws.a(this.a) + ", mImageUrl=" + pws.b(this.a));
      pws.a(this.a, 0, pws.b(this.a), pws.a(this.a), null, null, null);
      return;
    }
    QLog.d("KingsMomentVideoDeliveControllerr", 1, "upload king moment cover failed");
    pws.a(this.a, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pwt
 * JD-Core Version:    0.7.0.1
 */