import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.qphone.base.util.QLog;

public class mki
  extends Handler
{
  public mki(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, Looper paramLooper)
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
      return;
      if (!this.a.f) {
        break;
      }
      if (this.a.e)
      {
        ReadInJoyBaseAdapter.a(this.a, this.a.a);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.w("ReadInJoyBaseAdapter", 2, "MSG_FOR_CHECK_PLAYAREA, 平移转场动画未做完，不触发自动播放");
    return;
    ReadInJoyBaseAdapter.a(this.a, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mki
 * JD-Core Version:    0.7.0.1
 */