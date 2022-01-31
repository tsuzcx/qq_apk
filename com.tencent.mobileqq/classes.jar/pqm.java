import android.os.Process;
import com.tencent.component.network.utils.thread.PriorityThreadFactory;

public class pqm
  extends Thread
{
  public pqm(PriorityThreadFactory paramPriorityThreadFactory, Runnable paramRunnable, String paramString)
  {
    super(paramRunnable, paramString);
  }
  
  public void run()
  {
    Process.setThreadPriority(PriorityThreadFactory.a(this.a));
    super.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pqm
 * JD-Core Version:    0.7.0.1
 */