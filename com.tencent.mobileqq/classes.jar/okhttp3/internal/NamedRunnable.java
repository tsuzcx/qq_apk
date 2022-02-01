package okhttp3.internal;

public abstract class NamedRunnable
  implements Runnable
{
  protected final String name;
  
  public NamedRunnable(String paramString, Object... paramVarArgs)
  {
    this.name = Util.format(paramString, paramVarArgs);
  }
  
  protected abstract void execute();
  
  public final void run()
  {
    String str = Thread.currentThread().getName();
    Thread.currentThread().setName(this.name);
    try
    {
      execute();
      return;
    }
    finally
    {
      Thread.currentThread().setName(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.NamedRunnable
 * JD-Core Version:    0.7.0.1
 */