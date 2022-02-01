package cooperation.qzone;

public final class CloseGuard
{
  private static volatile boolean ENABLED = true;
  private static final CloseGuard NOOP = new CloseGuard();
  private static volatile CloseGuard.Reporter REPORTER = new CloseGuard.DefaultReporter(null);
  private Throwable allocationSite;
  
  public static CloseGuard get()
  {
    if (!ENABLED) {
      return NOOP;
    }
    return new CloseGuard();
  }
  
  public static CloseGuard.Reporter getReporter()
  {
    return REPORTER;
  }
  
  public static void setEnabled(boolean paramBoolean)
  {
    ENABLED = paramBoolean;
  }
  
  public static void setReporter(CloseGuard.Reporter paramReporter)
  {
    if (paramReporter != null)
    {
      REPORTER = paramReporter;
      return;
    }
    throw new NullPointerException("reporter == null");
  }
  
  public void close()
  {
    this.allocationSite = null;
  }
  
  public void open(String paramString)
  {
    if (paramString != null)
    {
      if (this != NOOP)
      {
        if (!ENABLED) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Explicit termination method '");
        localStringBuilder.append(paramString);
        localStringBuilder.append("' not called");
        this.allocationSite = new Throwable(localStringBuilder.toString());
      }
      return;
    }
    throw new NullPointerException("closer == null");
  }
  
  public void warnIfOpen()
  {
    if (this.allocationSite != null)
    {
      if (!ENABLED) {
        return;
      }
      REPORTER.report("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", this.allocationSite);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.CloseGuard
 * JD-Core Version:    0.7.0.1
 */