import com.tencent.mobileqq.app.ThreadManager;

public final class rhg
  implements Runnable
{
  public void run()
  {
    ThreadManager.excute(new rhh(this), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rhg
 * JD-Core Version:    0.7.0.1
 */