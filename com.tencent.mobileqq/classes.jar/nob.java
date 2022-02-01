import com.tencent.mobileqq.app.ThreadManager;

public class nob
  implements nmy
{
  public void a(Runnable paramRunnable)
  {
    ThreadManager.executeOnNetWorkThread(paramRunnable);
  }
  
  public void b(Runnable paramRunnable)
  {
    ThreadManager.executeOnFileThread(paramRunnable);
  }
  
  public void c(Runnable paramRunnable)
  {
    ThreadManager.post(paramRunnable, 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nob
 * JD-Core Version:    0.7.0.1
 */