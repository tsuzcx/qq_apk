package cooperation.qzone.contentbox;

import apfo;
import bjiy;
import bjjg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QzoneCommonIntent;

public class QZoneMsgManager$1
  implements Runnable
{
  public QZoneMsgManager$1(bjiy parambjiy, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    bjjg localbjjg = new bjjg(this.a.getLongAccountUin(), "", this.this$0.a(1), 2);
    localbjjg.a(1);
    QzoneCommonIntent localQzoneCommonIntent = new QzoneCommonIntent(this.a.getApplication(), apfo.class);
    localQzoneCommonIntent.setRequest(localbjjg);
    localQzoneCommonIntent.setObserver(this.this$0);
    this.a.startServlet(localQzoneCommonIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager.1
 * JD-Core Version:    0.7.0.1
 */