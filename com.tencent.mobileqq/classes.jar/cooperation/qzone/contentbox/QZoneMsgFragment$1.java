package cooperation.qzone.contentbox;

import android.app.Activity;
import bmww;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;

class QZoneMsgFragment$1
  implements Runnable
{
  QZoneMsgFragment$1(QZoneMsgFragment paramQZoneMsgFragment, Activity paramActivity) {}
  
  public void run()
  {
    QLog.i("QZoneMsgManager.QZoneMsgFragment", 1, "onAttach: start to load qzone plugin");
    try
    {
      QzonePluginProxyActivity.a(this.a);
      bmww.b(this.a, this.this$0.a);
      bmww.a(this.a, this.this$0.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("QZoneMsgManager.QZoneMsgFragment", 1, "onAttach: failed to load qzone plugin", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.1
 * JD-Core Version:    0.7.0.1
 */