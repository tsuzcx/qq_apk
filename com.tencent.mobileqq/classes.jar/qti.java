import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class qti
  extends Handler
{
  qti(qth paramqth, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsVideoUIDelegate", 2, "mUiHandler.postDelayed() innerChangePlayButton(SHOW_LOADING_BTN) mIsNeedShowLoading = " + qth.a(this.a));
      }
    } while (!qth.a(this.a));
    this.a.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qti
 * JD-Core Version:    0.7.0.1
 */