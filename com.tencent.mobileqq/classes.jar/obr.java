import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class obr
  extends qtz
{
  obr(obq paramobq) {}
  
  public void a(qty paramqty)
  {
    super.a(paramqty);
    QLog.d("KandianAdPandent", 2, "onCompletion");
    obq.a(this.a).sendEmptyMessage(2);
  }
  
  public void a(qty paramqty, Object paramObject)
  {
    QLog.d("KandianAdPandent", 2, "onVideoPrepared");
    obq.a(this.a).f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obr
 * JD-Core Version:    0.7.0.1
 */