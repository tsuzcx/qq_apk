package com.tencent.mobileqq.filemanager.app;

import aque;
import aqvb;
import arcj;
import arrr;
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
  public QFileMsgForwardManager$2(aque paramaque, String paramString) {}
  
  public void run()
  {
    if (aque.a(this.this$0).containsKey(this.a)) {}
    for (aqvb localaqvb = (aqvb)aque.a(this.this$0).remove(this.a);; localaqvb = null)
    {
      if (localaqvb == null) {
        return;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = localaqvb.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ArrayList localArrayList3 = (ArrayList)localaqvb.jdField_a_of_type_JavaUtilHashMap.get(str);
        int i = 0;
        label109:
        MessageRecord localMessageRecord;
        if (i < localArrayList3.size())
        {
          localMessageRecord = (MessageRecord)localArrayList3.get(i);
          if (arrr.a(localMessageRecord)) {
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
            localaqvb.jdField_a_of_type_Arcj.a(str, localArrayList3, localMessageRecord, i);
            localArrayList2.add(localMessageRecord);
          }
          else
          {
            localArrayList1.add(localMessageRecord);
          }
        }
      }
      if (localaqvb.d.size() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileMultiMsgManager<FileAssistant>", 1, "removeForwardRequest : remove upload request forwardSeq = [" + this.a + "] resultCode[1]");
        }
        localaqvb.jdField_a_of_type_Arcj.a(1, localArrayList1, localArrayList2);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "removeForwardRequest : remove upload request forwardSeq = [" + this.a + "] resultCode[0]");
      }
      localaqvb.jdField_a_of_type_Arcj.a(0, localArrayList1, localArrayList2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.2
 * JD-Core Version:    0.7.0.1
 */