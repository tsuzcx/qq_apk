package cooperation.qqreader.net;

import android.support.annotation.NonNull;

public abstract interface ReaderCgiListener
{
  public abstract void a(BaseCgiTask paramBaseCgiTask, String paramString);
  
  public abstract void a(@NonNull ReaderCgiResponse paramReaderCgiResponse);
  
  public abstract void b(@NonNull ReaderCgiResponse paramReaderCgiResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.net.ReaderCgiListener
 * JD-Core Version:    0.7.0.1
 */