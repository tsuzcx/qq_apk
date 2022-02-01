package cooperation.qqreader.js;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ReaderJsPluginHelper$2
  extends Handler
{
  ReaderJsPluginHelper$2(ReaderJsPluginHelper paramReaderJsPluginHelper, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100001)
    {
      ReaderJsPluginHelper.b(this.a);
      ReaderJsPluginHelper.a(this.a).sendEmptyMessageDelayed(100001, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.js.ReaderJsPluginHelper.2
 * JD-Core Version:    0.7.0.1
 */