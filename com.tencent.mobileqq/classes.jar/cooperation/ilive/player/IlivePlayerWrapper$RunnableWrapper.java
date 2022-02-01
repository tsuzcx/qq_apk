package cooperation.ilive.player;

import com.tencent.qphone.base.util.QLog;

class IlivePlayerWrapper$RunnableWrapper
  implements Runnable
{
  private Runnable a;
  
  public IlivePlayerWrapper$RunnableWrapper(Runnable paramRunnable)
  {
    this.a = paramRunnable;
  }
  
  public void run()
  {
    try
    {
      if (this.a != null)
      {
        this.a.run();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.e("CachePlayer", 1, "runnable exception", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.player.IlivePlayerWrapper.RunnableWrapper
 * JD-Core Version:    0.7.0.1
 */