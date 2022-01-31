package cooperation.qzone.contentbox;

import apbf;
import bjer;
import bjez;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QzoneCommonIntent;

public class QZoneMsgManager$1
  implements Runnable
{
  public QZoneMsgManager$1(bjer parambjer, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    bjez localbjez = new bjez(this.a.getLongAccountUin(), "", this.this$0.a(1), 2);
    localbjez.a(1);
    QzoneCommonIntent localQzoneCommonIntent = new QzoneCommonIntent(this.a.getApplication(), apbf.class);
    localQzoneCommonIntent.setRequest(localbjez);
    localQzoneCommonIntent.setObserver(this.this$0);
    this.a.startServlet(localQzoneCommonIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager.1
 * JD-Core Version:    0.7.0.1
 */