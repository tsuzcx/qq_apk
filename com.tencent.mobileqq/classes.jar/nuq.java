import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class nuq
  extends alwx
{
  nuq(nup paramnup) {}
  
  public void a(List<MessageRecord> paramList)
  {
    super.a(paramList);
    HashSet localHashSet = new HashSet();
    if (ntw.b != null) {
      localHashSet.addAll(ntw.b);
    }
    nup localnup = (nup)this.a.mApp.getBusinessHandler(88);
    paramList = new ArrayList(paramList).iterator();
    label164:
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (("2".equals(localMessageRecord.getExtInfoFromExtStr("inter_num"))) || ((localMessageRecord.istroop == 1008) && (ssp.e(this.a.app, localMessageRecord.senderuin)))) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (!localHashSet.contains(localMessageRecord.senderuin))) {
          break label164;
        }
        if (i != 0) {
          localnup.a(localMessageRecord);
        }
        localnup.b(localMessageRecord);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nuq
 * JD-Core Version:    0.7.0.1
 */