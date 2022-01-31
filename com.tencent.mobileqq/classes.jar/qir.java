import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class qir
  extends ayvz
{
  qir(qiq paramqiq) {}
  
  public void handleMessage(Message paramMessage)
  {
    ayqm localayqm = (ayqm)paramMessage.obj;
    if ((localayqm == null) || (localayqm.jdField_b_of_type_Int != 24) || (localayqm.c != 10)) {}
    while ((localayqm.jdField_b_of_type_Long != this.a.a.a) || (localayqm.f.equals(qiq.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1002: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mVideoTransProcessorHandler transfer=" + localayqm.e + ", total=" + localayqm.a);
      qiq.a(this.a, (float)localayqm.e * 100.0F / (float)localayqm.a);
      return;
    case 1003: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler send finished!");
      qiq.a(this.a, localayqm.f);
      qiq.b(this.a, localayqm.i);
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler mImageMd5=" + qiq.a(this.a) + ", mImageUrl=" + qiq.b(this.a));
      qiq.a(this.a, 0, qiq.b(this.a), qiq.a(this.a), null, null, null);
      return;
    }
    QLog.d("KingsMomentVideoDeliveControllerr", 1, "upload king moment cover failed");
    qiq.a(this.a, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qir
 * JD-Core Version:    0.7.0.1
 */