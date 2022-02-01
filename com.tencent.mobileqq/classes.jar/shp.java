import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class shp
  extends Handler
{
  shp(shl paramshl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "mUIHandler handleMessage() msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      shl.a(this.a);
      return;
      shl.b(this.a);
      return;
      shl.c(this.a);
      return;
      shl.d(this.a);
      return;
      shl.e(this.a);
      return;
      shl.f(this.a);
      return;
      shl.a(this.a, paramMessage);
      return;
      shl.g(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     shp
 * JD-Core Version:    0.7.0.1
 */