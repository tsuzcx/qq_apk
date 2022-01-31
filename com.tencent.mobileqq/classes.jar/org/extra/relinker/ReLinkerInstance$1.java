package org.extra.relinker;

import android.content.Context;

class ReLinkerInstance$1
  implements Runnable
{
  ReLinkerInstance$1(ReLinkerInstance paramReLinkerInstance, Context paramContext, String paramString1, String paramString2, ReLinker.LoadListener paramLoadListener) {}
  
  public void run()
  {
    try
    {
      ReLinkerInstance.access$000(this.this$0, this.val$context, this.val$library, this.val$version);
      this.val$listener.success();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      this.val$listener.failure(localUnsatisfiedLinkError);
      return;
    }
    catch (MissingLibraryException localMissingLibraryException)
    {
      this.val$listener.failure(localMissingLibraryException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     org.extra.relinker.ReLinkerInstance.1
 * JD-Core Version:    0.7.0.1
 */