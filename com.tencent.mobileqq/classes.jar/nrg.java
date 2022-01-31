import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class nrg
  extends akat
{
  nrg(nrf paramnrf) {}
  
  public void a(List<MessageRecord> paramList)
  {
    super.a(paramList);
    HashSet localHashSet = new HashSet();
    if (nqn.b != null) {
      localHashSet.addAll(nqn.b);
    }
    nrf localnrf = (nrf)this.a.mApp.getBusinessHandler(88);
    paramList = new ArrayList(paramList).iterator();
    label164:
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (("2".equals(localMessageRecord.getExtInfoFromExtStr("inter_num"))) || ((localMessageRecord.istroop == 1008) && (saz.e(this.a.app, localMessageRecord.senderuin)))) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (!localHashSet.contains(localMessageRecord.senderuin))) {
          break label164;
        }
        if (i != 0) {
          localnrf.a(localMessageRecord);
        }
        localnrf.b(localMessageRecord);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrg
 * JD-Core Version:    0.7.0.1
 */