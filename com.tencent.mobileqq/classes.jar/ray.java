import android.app.Activity;
import android.view.Choreographer;
import com.tencent.mfsdk.LeakInspector.ActivityLeakSolution;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public final class ray
  implements Runnable
{
  public ray(Activity paramActivity) {}
  
  public void run()
  {
    try
    {
      Choreographer localChoreographer = Choreographer.getInstance();
      ActivityLeakSolution.a.set(localChoreographer, this.a.getApplicationContext());
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("LeakInspector", 2, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ray
 * JD-Core Version:    0.7.0.1
 */