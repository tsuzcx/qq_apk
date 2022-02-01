package cooperation.qzone.contentbox;

import com.tencent.qzonehub.api.contentbox.IMQMsg;
import com.tencent.qzonehub.model.QZoneMsgEntityNew;
import cooperation.qzone.contentbox.model.MQMsg;
import java.util.ArrayList;
import java.util.Iterator;

class QZoneMsgFragment$5$1
  implements Runnable
{
  QZoneMsgFragment$5$1(QZoneMsgFragment.5 param5, ArrayList paramArrayList) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = QZoneMsgFragment.access$200(this.this$1.this$0);
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    if (bool)
    {
      Iterator localIterator1 = this.val$qzoneMessageRsp.iterator();
      localObject3 = null;
      while (localIterator1.hasNext())
      {
        Object localObject4 = (QZoneMsgEntityNew)localIterator1.next();
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          if (((QZoneMsgEntityNew)localObject4).pushTime <= ((QZoneMsgEntityNew)localObject3).pushTime) {}
        }
        else
        {
          localObject1 = localObject4;
        }
        localObject3 = localObject1;
        if (localObject4 != null)
        {
          localObject3 = localObject1;
          if (((QZoneMsgEntityNew)localObject4).ArkNes_vec != null)
          {
            localObject3 = localObject1;
            if (((QZoneMsgEntityNew)localObject4).ArkNes_vec.size() > 0)
            {
              Iterator localIterator2 = ((QZoneMsgEntityNew)localObject4).ArkNes_vec.iterator();
              for (localObject4 = localObject2;; localObject4 = (MQMsg)localObject2) {
                do
                {
                  localObject2 = localObject4;
                  localObject3 = localObject1;
                  if (!localIterator2.hasNext()) {
                    break;
                  }
                  localObject2 = (IMQMsg)localIterator2.next();
                } while ((localObject2 == null) || ((localObject4 != null) && (((IMQMsg)localObject2).getPushTime() <= ((MQMsg)localObject4).pushTime)) || (!(localObject2 instanceof MQMsg)));
              }
            }
          }
        }
      }
      if ((localObject2 != null) && (!((MQMsg)localObject2).isNewStyleCard())) {
        localArrayList.add(localObject2);
      } else if ((localObject3 != null) && (((QZoneMsgEntityNew)localObject3).ArkNes_vec != null) && (((QZoneMsgEntityNew)localObject3).ArkNes_vec.size() > 0) && (((IMQMsg)((QZoneMsgEntityNew)localObject3).ArkNes_vec.get(0)).isNewStyleCard())) {
        localArrayList.addAll(((QZoneMsgEntityNew)localObject3).ArkNes_vec);
      }
    }
    else
    {
      localObject3 = this.val$qzoneMessageRsp.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (QZoneMsgEntityNew)((Iterator)localObject3).next();
        if ((localObject1 == null) || (((QZoneMsgEntityNew)localObject2).pushTime > ((QZoneMsgEntityNew)localObject1).pushTime)) {
          localObject1 = localObject2;
        }
      }
      if ((localObject1 != null) && (((QZoneMsgEntityNew)localObject1).ArkNes_vec != null) && (((QZoneMsgEntityNew)localObject1).ArkNes_vec.size() > 0) && (((IMQMsg)((QZoneMsgEntityNew)localObject1).ArkNes_vec.get(0)).isNewStyleCard()))
      {
        localArrayList.addAll(((QZoneMsgEntityNew)localObject1).ArkNes_vec);
      }
      else
      {
        localObject1 = this.val$qzoneMessageRsp.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (QZoneMsgEntityNew)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((QZoneMsgEntityNew)localObject2).ArkNes_vec != null) && (((QZoneMsgEntityNew)localObject2).ArkNes_vec.size() > 0)) {
            localArrayList.addAll(((QZoneMsgEntityNew)localObject2).ArkNes_vec);
          }
        }
      }
    }
    this.this$1.this$0.adapter.setMQMsgs(localArrayList, 2);
    QZoneMsgFragment.access$300(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.5.1
 * JD-Core Version:    0.7.0.1
 */