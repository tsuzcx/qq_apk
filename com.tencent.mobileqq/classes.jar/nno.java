import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;

public class nno
  extends absu
{
  public nno(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  public ArrayList<MessageRecord> a(long paramLong, List<msg_comm.Msg> paramList)
  {
    paramList = b(paramLong, paramList);
    ArrayList localArrayList = new ArrayList();
    a(paramList, localArrayList, true);
    paramList.clear();
    return localArrayList;
  }
  
  public void a(long paramLong, List<msg_comm.Msg> paramList)
  {
    paramList = a(paramLong, paramList);
    nrc localnrc;
    long l2;
    long l1;
    String str;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localnrc = nrc.a();
      l2 = localnrc.a(this.a, String.valueOf(paramLong));
      l1 = l2;
      if (l2 == 0L) {
        l1 = 9223372036854775807L;
      }
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        str = ((MessageRecord)localIterator.next()).getExtInfoFromExtStr("pa_msgId");
        if (TextUtils.isEmpty(str)) {
          break label176;
        }
      }
    }
    label176:
    for (;;)
    {
      try
      {
        long l3 = Long.parseLong(str);
        l2 = l1;
        if (l3 < l1)
        {
          l2 = l1;
          if (l3 != 0L)
          {
            localnrc.a(this.a, String.valueOf(paramLong), l3);
            l2 = l3;
          }
        }
        l1 = l2;
      }
      catch (Exception localException)
      {
        continue;
      }
      this.a.a().a(paramList, this.a.getCurrentAccountUin(), true);
      return;
    }
  }
  
  public ArrayList<MessageRecord> b(long paramLong, List<msg_comm.Msg> paramList)
  {
    Object localObject1 = new ArrayList();
    a(paramList, (List)localObject1);
    paramList = new ArrayList();
    ayzj localayzj = new ayzj(this.a.getLongAccountUin(), paramLong, true, true, false, false);
    localayzj.h = true;
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (msg_comm.Msg)((Iterator)localObject1).next();
      try
      {
        localObject2 = a((msg_comm.Msg)localObject2, localayzj);
        if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
          continue;
        }
        paramList.addAll((Collection)localObject2);
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.w("DynamicMsgProcessor", 2, "decodeSinglePBMsg_C2C error,", localException);
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nno
 * JD-Core Version:    0.7.0.1
 */