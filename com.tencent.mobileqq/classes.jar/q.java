import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;

public final class q
  implements bs
{
  public q(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void a(String paramString)
  {
    new Handler(Looper.getMainLooper()).post(new r(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     q
 * JD-Core Version:    0.7.0.1
 */