package cooperation.qzone.contentbox;

import bjel;
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
    Object localObject1;
    MQMsg localMQMsg;
    if (QZoneMsgFragment.b(this.jdField_a_of_type_CooperationQzoneContentboxQZoneMsgFragment$5.this$0))
    {
      localObject2 = null;
      Iterator localIterator1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          localObject1 = (QZoneMsgEntityNew)localIterator1.next();
          if ((localObject1 != null) && (((QZoneMsgEntityNew)localObject1).ArkNes_vec != null) && (((QZoneMsgEntityNew)localObject1).ArkNes_vec.size() > 0))
          {
            Iterator localIterator2 = ((QZoneMsgEntityNew)localObject1).ArkNes_vec.iterator();
            localObject1 = localObject2;
            do
            {
              localObject2 = localObject1;
              if (!localIterator2.hasNext()) {
                break;
              }
              localMQMsg = (MQMsg)localIterator2.next();
            } while (localMQMsg == null);
            localObject2 = localMQMsg;
            if (localObject1 != null) {
              if (localMQMsg.pushTime <= ((MQMsg)localObject1).pushTime) {
                break label236;
              }
            }
          }
        }
      }
    }
    label236:
    for (Object localObject2 = localMQMsg;; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      break;
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
      for (;;)
      {
        this.jdField_a_of_type_CooperationQzoneContentboxQZoneMsgFragment$5.this$0.a.a(localArrayList);
        QZoneMsgFragment.a(this.jdField_a_of_type_CooperationQzoneContentboxQZoneMsgFragment$5.this$0);
        return;
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.5.1
 * JD-Core Version:    0.7.0.1
 */