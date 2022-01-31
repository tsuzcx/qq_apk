import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.util.SwipeBackLayout;
import com.tencent.qphone.base.util.QLog;

public class rvy
  extends Handler
{
  public rvy(SwipeBackLayout paramSwipeBackLayout) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
    }
    do
    {
      do
      {
        return;
      } while (SwipeBackLayout.a(this.a));
      SwipeBackLayout.a(this.a, true);
    } while (!(this.a.a instanceof Activity));
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_SwipeBackLayout", 2, "SwipeBackLayout finish()");
    }
    this.a.c = true;
    ((Activity)this.a.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rvy
 * JD-Core Version:    0.7.0.1
 */