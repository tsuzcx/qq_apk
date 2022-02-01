package okhttp3.internal;

import java.util.concurrent.ThreadFactory;

class Util$2
  implements ThreadFactory
{
  Util$2(String paramString, boolean paramBoolean) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable, this.val$name);
    paramRunnable.setDaemon(this.val$daemon);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.Util.2
 * JD-Core Version:    0.7.0.1
 */