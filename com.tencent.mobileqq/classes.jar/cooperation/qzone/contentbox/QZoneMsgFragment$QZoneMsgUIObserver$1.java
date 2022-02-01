package cooperation.qzone.contentbox;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.contentbox.IMQMsg;
import com.tencent.qzonehub.model.QZoneMsgEntityNew;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQPhotoCell;
import cooperation.qzone.provider.LocalPhotoGroupData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class QZoneMsgFragment$QZoneMsgUIObserver$1
  implements Runnable
{
  QZoneMsgFragment$QZoneMsgUIObserver$1(QZoneMsgFragment.QZoneMsgUIObserver paramQZoneMsgUIObserver, QZoneMsgEntityNew paramQZoneMsgEntityNew, boolean paramBoolean) {}
  
  public void run()
  {
    if (QZoneMsgFragment.access$1000(this.this$1.this$0, this.val$rsp.ArkNes_vec))
    {
      this.this$1.this$0.adapter.setMQMsgs(this.val$rsp.ArkNes_vec, 0);
      QZoneMsgFragment.access$900(this.this$1.this$0, this.val$isSuc);
      return;
    }
    Object localObject1 = null;
    MQPhotoCell localMQPhotoCell = null;
    Object localObject2 = localObject1;
    if (this.val$rsp.ArkNes_vec != null)
    {
      localObject2 = localObject1;
      if (this.val$rsp.ArkNes_vec.size() != 0)
      {
        localObject2 = (IMQMsg)this.val$rsp.ArkNes_vec.get(0);
        localObject1 = localMQPhotoCell;
        if (localObject2 != null)
        {
          localObject1 = localMQPhotoCell;
          if ((localObject2 instanceof MQMsg)) {
            localObject1 = (MQMsg)localObject2;
          }
        }
        localObject2 = localObject1;
        if (((MQMsg)localObject1).msgType == 9)
        {
          localObject2 = LocalPhotoGroupData.getLocalPhotoGroupDataFromSp(((MQMsg)localObject1).pushTime);
          if (QZoneMsgFragment.access$1100(this.this$1.this$0) != null)
          {
            if (localObject2 == null) {
              QZoneMsgFragment.access$1100(this.this$1.this$0).saveSp(((MQMsg)localObject1).pushTime);
            } else {
              QZoneMsgFragment.access$1102(this.this$1.this$0, (LocalPhotoGroupData)localObject2);
            }
          }
          else {
            QZoneMsgFragment.access$1102(this.this$1.this$0, (LocalPhotoGroupData)localObject2);
          }
          if (QZoneMsgFragment.access$1100(this.this$1.this$0) != null)
          {
            ((MQMsg)localObject1).uniKey = QZoneMsgFragment.access$1100(this.this$1.this$0).unikey;
            ((MQMsg)localObject1).eventTitle = QZoneMsgFragment.access$1100(this.this$1.this$0).title;
            ((MQMsg)localObject1).capTime = QZoneMsgFragment.access$1100(this.this$1.this$0).capTime;
            if (((MQMsg)localObject1).msgBody == null) {
              ((MQMsg)localObject1).msgBody = new MQMsgBody();
            }
            if (((MQMsg)localObject1).msgBody.photolist == null) {
              ((MQMsg)localObject1).msgBody.photolist = new ArrayList();
            }
            ((MQMsg)localObject1).msgBody.photolist.clear();
            localObject2 = localObject1;
            if (QZoneMsgFragment.access$1100(this.this$1.this$0).pathList != null)
            {
              int i = 0;
              for (;;)
              {
                localObject2 = localObject1;
                if (i >= QZoneMsgFragment.access$1100(this.this$1.this$0).pathList.size()) {
                  break;
                }
                localObject2 = new MQPhotoCell();
                ((MQPhotoCell)localObject2).coverUrl = ((String)QZoneMsgFragment.access$1100(this.this$1.this$0).pathList.get(i));
                ((MQMsg)localObject1).msgBody.photolist.add(localObject2);
                i += 1;
              }
            }
          }
          else
          {
            QLog.e("QZoneMsgFragment.QZoneMsgUIObserver", 2, "mLocalPhotoGroupData == null");
            localObject2 = localObject1;
          }
        }
      }
    }
    if (localObject2 == null)
    {
      QLog.e("QZoneMsgFragment.QZoneMsgUIObserver", 2, "rsp.ArkNes_vec.get(0) == null");
    }
    else if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateMQMsgs: MQMsg{\nmsgType='");
      ((StringBuilder)localObject1).append(((MQMsg)localObject2).msgType);
      ((StringBuilder)localObject1).append('\'');
      ((StringBuilder)localObject1).append('\n');
      ((StringBuilder)localObject1).append(", title=");
      ((StringBuilder)localObject1).append(((MQMsg)localObject2).title);
      ((StringBuilder)localObject1).append('\'');
      ((StringBuilder)localObject1).append('\n');
      ((StringBuilder)localObject1).append(", eventTitle='");
      ((StringBuilder)localObject1).append(((MQMsg)localObject2).eventTitle);
      ((StringBuilder)localObject1).append('\'');
      ((StringBuilder)localObject1).append('\n');
      ((StringBuilder)localObject1).append(", uniKey='");
      ((StringBuilder)localObject1).append(((MQMsg)localObject2).uniKey);
      ((StringBuilder)localObject1).append('\'');
      ((StringBuilder)localObject1).append('\n');
      ((StringBuilder)localObject1).append('}');
      QLog.i("QZoneMsgFragment.QZoneMsgUIObserver", 2, ((StringBuilder)localObject1).toString());
      if ((((MQMsg)localObject2).msgBody != null) && (((MQMsg)localObject2).msgBody.photolist != null)) {
        localObject1 = ((MQMsg)localObject2).msgBody.photolist.iterator();
      }
      while (((Iterator)localObject1).hasNext())
      {
        localMQPhotoCell = (MQPhotoCell)((Iterator)localObject1).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateMQMsg: cell.coverUrl=");
        localStringBuilder.append(localMQPhotoCell.coverUrl);
        QLog.i("QZoneMsgFragment.QZoneMsgUIObserver", 2, localStringBuilder.toString());
        continue;
        QLog.i("QZoneMsgFragment.QZoneMsgUIObserver", 2, "updateMQMsg: mqMsg.msgBody.photolist==null");
      }
    }
    if ((QZoneMsgFragment.access$200(this.this$1.this$0)) && (localObject2 != null))
    {
      if ((((MQMsg)localObject2).msgType == 9) && (QZoneMsgFragment.access$1100(this.this$1.this$0) == null)) {
        this.this$1.this$0.adapter.setMQMsgs(new ArrayList(), 0);
      } else {
        this.this$1.this$0.adapter.setMQMsgs(new ArrayList(Collections.singletonList(localObject2)), 0);
      }
    }
    else {
      this.this$1.this$0.adapter.updateMQMsgs((MQMsg)localObject2);
    }
    QZoneMsgFragment.access$400(this.this$1.this$0).postDelayed(new QZoneMsgFragment.QZoneMsgUIObserver.1.1(this), 500L);
    QZoneMsgFragment.access$900(this.this$1.this$0, this.val$isSuc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.QZoneMsgUIObserver.1
 * JD-Core Version:    0.7.0.1
 */