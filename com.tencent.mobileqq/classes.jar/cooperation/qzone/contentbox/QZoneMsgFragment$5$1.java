package cooperation.qzone.contentbox;

import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import java.util.ArrayList;
import java.util.Iterator;

class QZoneMsgFragment$5$1
  implements Runnable
{
  QZoneMsgFragment$5$1(QZoneMsgFragment.5 param5, ArrayList paramArrayList) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject4;
    Object localObject1;
    if (QZoneMsgFragment.access$200(this.this$1.this$0))
    {
      Iterator localIterator1 = this.val$qzoneMessageRsp.iterator();
      localObject4 = null;
      localObject2 = null;
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          localObject1 = (QZoneMsgEntityNew)localIterator1.next();
          Object localObject3;
          if (localObject4 != null)
          {
            localObject3 = localObject4;
            if (((QZoneMsgEntityNew)localObject1).pushTime <= ((QZoneMsgEntityNew)localObject4).pushTime) {}
          }
          else
          {
            localObject3 = localObject1;
          }
          localObject4 = localObject3;
          if (localObject1 != null)
          {
            localObject4 = localObject3;
            if (((QZoneMsgEntityNew)localObject1).ArkNes_vec != null)
            {
              localObject4 = localObject3;
              if (((QZoneMsgEntityNew)localObject1).ArkNes_vec.size() > 0)
              {
                Iterator localIterator2 = ((QZoneMsgEntityNew)localObject1).ArkNes_vec.iterator();
                localObject1 = localObject2;
                do
                {
                  localObject2 = localObject1;
                  localObject4 = localObject3;
                  if (!localIterator2.hasNext()) {
                    break;
                  }
                  localObject4 = (MQMsg)localIterator2.next();
                } while (localObject4 == null);
                localObject2 = localObject4;
                if (localObject1 != null) {
                  if (((MQMsg)localObject4).pushTime <= ((MQMsg)localObject1).pushTime) {
                    break label343;
                  }
                }
              }
            }
          }
        }
      }
    }
    label343:
    for (Object localObject2 = localObject4;; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      break;
      if ((localObject2 != null) && (!((MQMsg)localObject2).isNewStyleCard())) {
        localArrayList.add(localObject2);
      }
      for (;;)
      {
        this.this$1.this$0.adapter.setMQMsgs(localArrayList, 2);
        QZoneMsgFragment.access$300(this.this$1.this$0);
        return;
        if ((localObject4 != null) && (((QZoneMsgEntityNew)localObject4).ArkNes_vec != null) && (((QZoneMsgEntityNew)localObject4).ArkNes_vec.size() > 0) && (((MQMsg)((QZoneMsgEntityNew)localObject4).ArkNes_vec.get(0)).isNewStyleCard()))
        {
          localArrayList.addAll(((QZoneMsgEntityNew)localObject4).ArkNes_vec);
          continue;
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.5.1
 * JD-Core Version:    0.7.0.1
 */