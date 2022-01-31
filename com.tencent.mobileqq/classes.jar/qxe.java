import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.qphone.base.util.QLog;

class qxe
  implements Handler.Callback
{
  qxe(qxc paramqxc) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qxc.a(), 2, "mUIHandler handleMessage() msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
    case 0: 
      label175:
      label181:
      do
      {
        return false;
        qxc.a(this.a).sendEmptyMessageDelayed(0, 3000L);
        long l2 = this.a.jdField_a_of_type_Qyg.a();
        long l1;
        if (this.a.jdField_a_of_type_Boolean)
        {
          l1 = qxc.a(this.a).a();
          if (l1 <= l2) {
            break label175;
          }
        }
        for (;;)
        {
          l1 = 3000L - (System.currentTimeMillis() - l1);
          if (l1 <= 0L) {
            break label181;
          }
          qxc.a(this.a).removeMessages(0);
          qxc.a(this.a).sendEmptyMessageDelayed(0, l1);
          return false;
          l1 = this.a.jdField_a_of_type_Qxo.a();
          break;
          l1 = l2;
        }
      } while (this.a.jdField_a_of_type_Qxr.a() == null);
      if (this.a.jdField_a_of_type_Qxr.a().d())
      {
        qxc.a(this.a, false);
        return false;
      }
      qxc.b(this.a, true);
      return false;
    }
    qoi.b(qxc.a(this.a), 0);
    qxc.a(this.a).setAlpha(0.2F);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qxe
 * JD-Core Version:    0.7.0.1
 */