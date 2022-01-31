package com.tencent.mobileqq.filemanager.app;

import aofz;
import aogw;
import aood;
import apck;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class QFileMsgForwardManager$2
  implements Runnable
{
  public QFileMsgForwardManager$2(aofz paramaofz, String paramString) {}
  
  public void run()
  {
    if (aofz.a(this.this$0).containsKey(this.a)) {}
    for (aogw localaogw = (aogw)aofz.a(this.this$0).remove(this.a);; localaogw = null)
    {
      if (localaogw == null) {
        return;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = localaogw.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ArrayList localArrayList3 = (ArrayList)localaogw.jdField_a_of_type_JavaUtilHashMap.get(str);
        int i = 0;
        label109:
        MessageRecord localMessageRecord;
        if (i < localArrayList3.size())
        {
          localMessageRecord = (MessageRecord)localArrayList3.get(i);
          if (apck.a(localMessageRecord)) {
            break label144;
          }
        }
        for (;;)
        {
          i += 1;
          break label109;
          break;
          label144:
          if (String.valueOf(2).equalsIgnoreCase(localMessageRecord.getExtInfoFromExtStr("_m_ForwardFileStatus")))
          {
            localaogw.jdField_a_of_type_Aood.a(str, localArrayList3, localMessageRecord, i);
            localArrayList2.add(localMessageRecord);
          }
          else
          {
            localArrayList1.add(localMessageRecord);
          }
        }
      }
      if (localaogw.d.size() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileMultiMsgManager<FileAssistant>", 1, "removeForwardRequest : remove upload request forwardSeq = [" + this.a + "] resultCode[1]");
        }
        localaogw.jdField_a_of_type_Aood.a(1, localArrayList1, localArrayList2);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "removeForwardRequest : remove upload request forwardSeq = [" + this.a + "] resultCode[0]");
      }
      localaogw.jdField_a_of_type_Aood.a(0, localArrayList1, localArrayList2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.2
 * JD-Core Version:    0.7.0.1
 */