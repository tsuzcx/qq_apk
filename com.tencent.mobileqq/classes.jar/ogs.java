import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ogs
  extends amwl
{
  ogs(ogr paramogr) {}
  
  public void onMessageRecordAdded(List<MessageRecord> paramList)
  {
    super.onMessageRecordAdded(paramList);
    ogr localogr = (ogr)this.a.mApp.getBusinessHandler(88);
    ofx localofx = (ofx)this.a.mApp.getManager(88);
    if ((localogr == null) || (localofx == null)) {
      return;
    }
    paramList = new ArrayList(paramList).iterator();
    label164:
    label167:
    for (;;)
    {
      label62:
      MessageRecord localMessageRecord;
      if (paramList.hasNext())
      {
        localMessageRecord = (MessageRecord)paramList.next();
        if ((!"2".equals(localMessageRecord.getExtInfoFromExtStr("inter_num"))) && ((localMessageRecord.istroop != 1008) || (!uaw.e(this.a.app, localMessageRecord.senderuin)))) {
          break label164;
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (!localofx.a(localMessageRecord.senderuin))) {
          break label167;
        }
        if (i != 0) {
          localogr.a(localMessageRecord);
        }
        localogr.b(localMessageRecord);
        break label62;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ogs
 * JD-Core Version:    0.7.0.1
 */