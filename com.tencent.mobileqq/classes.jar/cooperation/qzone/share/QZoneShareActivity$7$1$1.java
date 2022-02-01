package cooperation.qzone.share;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;

class QZoneShareActivity$7$1$1
  implements Runnable
{
  QZoneShareActivity$7$1$1(QZoneShareActivity.7.1 param1, ArrayList paramArrayList, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$2.this$1.this$0.app.getAccount();
    String str = ((TicketManager)this.this$2.this$1.this$0.app.getManager(2)).getSkey((String)localObject);
    if (new ArrayList(this.val$shareImageUrls).equals(QZoneShareManager.batchUploadImages(this.val$shareImageUrls, (String)localObject, str, "1"))) {
      QLog.e("QZoneShare", 1, "imageChangeError!");
    }
    try
    {
      l1 = Long.parseLong(QZoneShareActivity.access$300(this.this$2.this$1.this$0).shareUin);
    }
    catch (Exception localException)
    {
      long l1;
      label108:
      long l2;
      break label108;
    }
    l1 = 0L;
    l2 = l1;
    if (l1 <= 0L) {
      l2 = this.this$2.this$1.this$0.app.getLongAccountUin();
    }
    localObject = new NewIntent(this.this$2.this$1.this$0, QzoneShareServlet.class);
    ((NewIntent)localObject).putExtra("reason", this.val$content);
    ((NewIntent)localObject).putExtra("uin", l2);
    ((NewIntent)localObject).putExtra("sharedata", QZoneShareActivity.access$300(this.this$2.this$1.this$0));
    BaseApplicationImpl.getApplication().getRuntime().startServlet((NewIntent)localObject);
    QLog.e("QZoneShare", 1, "startShare()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.7.1.1
 * JD-Core Version:    0.7.0.1
 */