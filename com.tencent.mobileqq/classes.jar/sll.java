import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class sll
{
  public static WeakReference<QQAppInterface> a = new WeakReference(null);
  
  public static boolean a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)a.get();
    if (localQQAppInterface == null) {
      throw new IllegalStateException(ajjy.a(2131648612));
    }
    return localQQAppInterface.a().a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sll
 * JD-Core Version:    0.7.0.1
 */