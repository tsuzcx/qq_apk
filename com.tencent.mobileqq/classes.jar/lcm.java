import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;

public class lcm
  extends MessageObserver
{
  public lcm(EcshopReportHandler paramEcshopReportHandler) {}
  
  public void a(List paramList)
  {
    super.a(paramList);
    EcshopReportHandler localEcshopReportHandler = (EcshopReportHandler)this.a.a.getBusinessHandler(88);
    paramList = paramList.iterator();
    label131:
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (("2".equals(localMessageRecord.getExtInfoFromExtStr("inter_num"))) || (ServiceAccountFolderManager.d(this.a.b, localMessageRecord.senderuin))) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && ((EcShopAssistantManager.b == null) || (!EcShopAssistantManager.b.contains(localMessageRecord.senderuin)))) {
          break label131;
        }
        if (i != 0) {
          localEcshopReportHandler.a(localMessageRecord);
        }
        localEcshopReportHandler.b(localMessageRecord);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lcm
 * JD-Core Version:    0.7.0.1
 */