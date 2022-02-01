import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ool
  extends anyz
{
  ool(ook paramook) {}
  
  public void onMessageRecordAdded(List<MessageRecord> paramList)
  {
    super.onMessageRecordAdded(paramList);
    ook localook = (ook)this.a.mApp.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
    onq localonq = (onq)this.a.mApp.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if ((localook == null) || (localonq == null)) {
      return;
    }
    paramList = new ArrayList(paramList).iterator();
    label166:
    label169:
    for (;;)
    {
      label64:
      MessageRecord localMessageRecord;
      if (paramList.hasNext())
      {
        localMessageRecord = (MessageRecord)paramList.next();
        if ((!"2".equals(localMessageRecord.getExtInfoFromExtStr("inter_num"))) && ((localMessageRecord.istroop != 1008) || (!uot.e(this.a.app, localMessageRecord.senderuin)))) {
          break label166;
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (!localonq.a(localMessageRecord.senderuin))) {
          break label169;
        }
        if (i != 0) {
          localook.a(localMessageRecord);
        }
        localook.b(localMessageRecord);
        break label64;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ool
 * JD-Core Version:    0.7.0.1
 */