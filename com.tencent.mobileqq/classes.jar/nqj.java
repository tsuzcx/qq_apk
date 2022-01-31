import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class nqj
  extends qhx
{
  nqj(nqi paramnqi) {}
  
  public void a(qhw paramqhw)
  {
    super.a(paramqhw);
    QLog.d("KandianAdPandent", 2, "onCompletion");
    nqi.a(this.a).sendEmptyMessage(2);
  }
  
  public void a(qhw paramqhw, Object paramObject)
  {
    QLog.d("KandianAdPandent", 2, "onVideoPrepared");
    nqi.a(this.a).f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqj
 * JD-Core Version:    0.7.0.1
 */