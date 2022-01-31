import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class qwa
  extends Handler
{
  qwa(qvx paramqvx, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideofeedsUserGuideController", 2, "mUIHandler handleMessage() msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qwa
 * JD-Core Version:    0.7.0.1
 */