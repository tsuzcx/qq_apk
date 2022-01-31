import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class qxv
  extends baua
{
  qxv(qxu paramqxu) {}
  
  public void handleMessage(Message paramMessage)
  {
    baoj localbaoj = (baoj)paramMessage.obj;
    if ((localbaoj == null) || (localbaoj.jdField_b_of_type_Int != 24) || (localbaoj.c != 10)) {}
    while ((localbaoj.jdField_b_of_type_Long != this.a.a.a) || (localbaoj.f.equals(qxu.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1002: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mVideoTransProcessorHandler transfer=" + localbaoj.e + ", total=" + localbaoj.a);
      qxu.a(this.a, (float)localbaoj.e * 100.0F / (float)localbaoj.a);
      return;
    case 1003: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler send finished!");
      qxu.a(this.a, localbaoj.f);
      qxu.b(this.a, localbaoj.i);
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler mImageMd5=" + qxu.a(this.a) + ", mImageUrl=" + qxu.b(this.a));
      qxu.a(this.a, 0, qxu.b(this.a), qxu.a(this.a), null, null, null);
      return;
    }
    QLog.d("KingsMomentVideoDeliveControllerr", 1, "upload king moment cover failed");
    qxu.a(this.a, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qxv
 * JD-Core Version:    0.7.0.1
 */