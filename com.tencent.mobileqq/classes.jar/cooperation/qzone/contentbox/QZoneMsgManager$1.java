package cooperation.qzone.contentbox;

import arxx;
import bmyi;
import bmyq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QzoneCommonIntent;

public class QZoneMsgManager$1
  implements Runnable
{
  public QZoneMsgManager$1(bmyi parambmyi, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    bmyq localbmyq = new bmyq(this.a.getLongAccountUin(), "", this.this$0.a(1), 2);
    localbmyq.a(1);
    QzoneCommonIntent localQzoneCommonIntent = new QzoneCommonIntent(this.a.getApplication(), arxx.class);
    localQzoneCommonIntent.setRequest(localbmyq);
    localQzoneCommonIntent.setObserver(this.this$0);
    this.a.startServlet(localQzoneCommonIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager.1
 * JD-Core Version:    0.7.0.1
 */