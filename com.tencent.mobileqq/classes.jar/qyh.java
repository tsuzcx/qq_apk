import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class qyh
  extends Handler
{
  qyh(qyg paramqyg, Looper paramLooper)
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
        QLog.d("VideoFeedsVideoUIDelegate", 2, "mUiHandler.postDelayed() innerChangePlayButton(SHOW_LOADING_BTN) mIsNeedShowLoading = " + qyg.a(this.a));
      }
    } while (!qyg.a(this.a));
    this.a.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qyh
 * JD-Core Version:    0.7.0.1
 */