package cooperation.qzone.contentbox;

import com.tencent.mobileqq.data.QZoneCommonServlet;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import cooperation.qzone.contentbox.model.QZoneMsgReq;
import mqq.app.AppRuntime;

class QZoneMsgManager$1
  implements Runnable
{
  QZoneMsgManager$1(QZoneMsgManager paramQZoneMsgManager, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    QZoneMsgReq localQZoneMsgReq = new QZoneMsgReq(this.val$app.getLongAccountUin(), "", this.this$0.getLoadNum(1), 2);
    localQZoneMsgReq.setType(1);
    QzoneCommonIntent localQzoneCommonIntent = new QzoneCommonIntent(this.val$app.getApplication(), QZoneCommonServlet.class);
    localQzoneCommonIntent.setRequest(localQZoneMsgReq);
    localQzoneCommonIntent.setObserver(this.this$0);
    this.val$app.startServlet(localQzoneCommonIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager.1
 * JD-Core Version:    0.7.0.1
 */