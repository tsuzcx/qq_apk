import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;

class rqk
  extends Handler
{
  rqk(rqj paramrqj, Looper paramLooper)
  {
    super(paramLooper);
  }
  
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
        this.a.a.getGlobalVisibleRect(rqj.a(this.a));
      } while (!oee.a(rqj.a(this.a)));
      if (!this.a.g) {
        break;
      }
      if (this.a.f)
      {
        rqj.a(this.a, this.a.a);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.w("ReadInJoyBaseAdapter", 2, "MSG_FOR_CHECK_PLAYAREA, 平移转场动画未做完，不触发自动播放");
    return;
    rqj.a(this.a, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rqk
 * JD-Core Version:    0.7.0.1
 */