import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class qio
  extends aywb
{
  qio(qin paramqin) {}
  
  public void handleMessage(Message paramMessage)
  {
    ayqo localayqo = (ayqo)paramMessage.obj;
    if ((localayqo == null) || (localayqo.jdField_b_of_type_Int != 24) || (localayqo.c != 10)) {}
    while ((localayqo.jdField_b_of_type_Long != this.a.a.a) || (localayqo.f.equals(qin.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1002: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mVideoTransProcessorHandler transfer=" + localayqo.e + ", total=" + localayqo.a);
      qin.a(this.a, (float)localayqo.e * 100.0F / (float)localayqo.a);
      return;
    case 1003: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler send finished!");
      qin.a(this.a, localayqo.f);
      qin.b(this.a, localayqo.i);
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler mImageMd5=" + qin.a(this.a) + ", mImageUrl=" + qin.b(this.a));
      qin.a(this.a, 0, qin.b(this.a), qin.a(this.a), null, null, null);
      return;
    }
    QLog.d("KingsMomentVideoDeliveControllerr", 1, "upload king moment cover failed");
    qin.a(this.a, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qio
 * JD-Core Version:    0.7.0.1
 */