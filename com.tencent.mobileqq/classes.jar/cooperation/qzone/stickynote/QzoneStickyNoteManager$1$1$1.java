package cooperation.qzone.stickynote;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy;

class QzoneStickyNoteManager$1$1$1
  implements Runnable
{
  QzoneStickyNoteManager$1$1$1(QzoneStickyNoteManager.1.1 param1) {}
  
  public void run()
  {
    try
    {
      QzonePluginProxyActivity.getQZonePluginClassLoader(this.this$2.this$1.val$app.getApp());
      boolean bool = QZoneApiProxy.initServlet(this.this$2.this$1.val$app.getApp(), this.this$2.this$1.val$app);
      if ((QZoneApiProxy.initEnv(this.this$2.this$1.val$app.getApp(), this.this$2.this$1.val$app)) && (bool)) {
        QzoneStickyNoteManager.access$000(this.this$2.this$1.this$0).post(new QzoneStickyNoteManager.1.1.1.1(this));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("QzoneStickyNoteManager", 1, "tryLoadQzonePlugin: failed to load qzone plugin");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.stickynote.QzoneStickyNoteManager.1.1.1
 * JD-Core Version:    0.7.0.1
 */