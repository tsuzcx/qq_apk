package cooperation.qzone.contentbox;

import anjy;
import bhdh;
import bhdp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QzoneCommonIntent;

public class QZoneMsgManager$1
  implements Runnable
{
  public QZoneMsgManager$1(bhdh parambhdh, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    bhdp localbhdp = new bhdp(this.a.getLongAccountUin(), "", this.this$0.a(1), 2);
    localbhdp.a(1);
    QzoneCommonIntent localQzoneCommonIntent = new QzoneCommonIntent(this.a.getApplication(), anjy.class);
    localQzoneCommonIntent.setRequest(localbhdp);
    localQzoneCommonIntent.setObserver(this.this$0);
    this.a.startServlet(localQzoneCommonIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager.1
 * JD-Core Version:    0.7.0.1
 */