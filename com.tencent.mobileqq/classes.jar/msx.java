import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;
import com.tencent.qphone.base.util.QLog;

public class msx
  extends Handler
{
  public msx(FastWebVideoFeedsPlayManager paramFastWebVideoFeedsPlayManager, Looper paramLooper)
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
        QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "mUiHandler.postDelayed() innerChangePlayButton(SHOW_LOADING_BTN) mIsNeedShowLoading = " + FastWebVideoFeedsPlayManager.b(this.a));
      }
    } while (!FastWebVideoFeedsPlayManager.b(this.a));
    this.a.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     msx
 * JD-Core Version:    0.7.0.1
 */