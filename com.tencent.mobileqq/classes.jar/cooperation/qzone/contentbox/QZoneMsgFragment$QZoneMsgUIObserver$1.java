package cooperation.qzone.contentbox;

import bfua;
import bfuf;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQPhotoCell;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.provider.LocalPhotoGroupData;
import java.util.ArrayList;
import java.util.Iterator;

public class QZoneMsgFragment$QZoneMsgUIObserver$1
  implements Runnable
{
  public QZoneMsgFragment$QZoneMsgUIObserver$1(bfuf parambfuf, QZoneMsgEntityNew paramQZoneMsgEntityNew) {}
  
  public void run()
  {
    MQMsg localMQMsg;
    Object localObject;
    if ((this.jdField_a_of_type_CooperationQzoneContentboxModelQZoneMsgEntityNew.ArkNes_vec != null) && (this.jdField_a_of_type_CooperationQzoneContentboxModelQZoneMsgEntityNew.ArkNes_vec.size() != 0))
    {
      localMQMsg = (MQMsg)this.jdField_a_of_type_CooperationQzoneContentboxModelQZoneMsgEntityNew.ArkNes_vec.get(0);
      if ((localMQMsg.msgType == 9) && (QZoneMsgFragment.a(this.jdField_a_of_type_Bfuf.a) != null))
      {
        localMQMsg.uniKey = QZoneMsgFragment.a(this.jdField_a_of_type_Bfuf.a).unikey;
        localMQMsg.eventTitle = QZoneMsgFragment.a(this.jdField_a_of_type_Bfuf.a).title;
        localMQMsg.capTime = QZoneMsgFragment.a(this.jdField_a_of_type_Bfuf.a).capTime;
        if (localMQMsg.msgBody.photolist == null) {
          localMQMsg.msgBody.photolist = new ArrayList();
        }
        if (localMQMsg.msgBody == null)
        {
          localMQMsg.msgBody = new MQMsgBody();
          localMQMsg.msgBody.photolist.clear();
        }
        if (QZoneMsgFragment.a(this.jdField_a_of_type_Bfuf.a).pathList != null)
        {
          int i = 0;
          while ((i < QZoneMsgFragment.a(this.jdField_a_of_type_Bfuf.a).pathList.size()) && (i < 3))
          {
            localObject = new MQPhotoCell();
            ((MQPhotoCell)localObject).coverUrl = ((String)QZoneMsgFragment.a(this.jdField_a_of_type_Bfuf.a).pathList.get(i));
            localMQMsg.msgBody.photolist.add(localObject);
            i += 1;
          }
        }
      }
    }
    for (;;)
    {
      if (localMQMsg == null) {
        QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "rsp.ArkNes_vec.get(0) == null");
      }
      for (;;)
      {
        this.jdField_a_of_type_Bfuf.a.a.a(localMQMsg);
        QZoneMsgFragment.a(this.jdField_a_of_type_Bfuf.a);
        return;
        if (QLog.isColorLevel())
        {
          QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "updateMQMsgs: MQMsg{\nmsgType='" + localMQMsg.msgType + '\'' + '\n' + ", msgBody.photolist.size()='" + localMQMsg.msgBody.photolist.size() + '\'' + '\n' + ", title=" + localMQMsg.title + '\'' + '\n' + ", eventTitle='" + localMQMsg.eventTitle + '\'' + '\n' + ", uniKey='" + localMQMsg.uniKey + '\'' + '\n' + '}');
          localObject = localMQMsg.msgBody.photolist.iterator();
          while (((Iterator)localObject).hasNext())
          {
            MQPhotoCell localMQPhotoCell = (MQPhotoCell)((Iterator)localObject).next();
            QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "updateMQMsg: cell.coverUrl=" + localMQPhotoCell.coverUrl);
          }
        }
      }
      localMQMsg = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.QZoneMsgUIObserver.1
 * JD-Core Version:    0.7.0.1
 */