package cooperation.qqreader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ReaderSplashImpl$StartReaderActCompletedReceiver
  extends BroadcastReceiver
{
  private ReaderSplashImpl$StartReaderActCompletedReceiver(ReaderSplashImpl paramReaderSplashImpl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("cooperation.qqreader.start_reader_act_completed".equals(paramIntent.getAction())) {
      ReaderSplashImpl.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.ReaderSplashImpl.StartReaderActCompletedReceiver
 * JD-Core Version:    0.7.0.1
 */