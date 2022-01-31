import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class syh
{
  public static WeakReference<QQAppInterface> a = new WeakReference(null);
  
  public static boolean a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)a.get();
    if (localQQAppInterface == null) {
      throw new IllegalStateException(ajyc.a(2131714401));
    }
    return localQQAppInterface.a().a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     syh
 * JD-Core Version:    0.7.0.1
 */