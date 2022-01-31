package com.tencent.mobileqq.filemanager.app;

import aowx;
import aoxu;
import apfc;
import apug;
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
  public QFileMsgForwardManager$2(aowx paramaowx, String paramString) {}
  
  public void run()
  {
    if (aowx.a(this.this$0).containsKey(this.a)) {}
    for (aoxu localaoxu = (aoxu)aowx.a(this.this$0).remove(this.a);; localaoxu = null)
    {
      if (localaoxu == null) {
        return;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = localaoxu.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ArrayList localArrayList3 = (ArrayList)localaoxu.jdField_a_of_type_JavaUtilHashMap.get(str);
        int i = 0;
        label109:
        MessageRecord localMessageRecord;
        if (i < localArrayList3.size())
        {
          localMessageRecord = (MessageRecord)localArrayList3.get(i);
          if (apug.a(localMessageRecord)) {
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
            localaoxu.jdField_a_of_type_Apfc.a(str, localArrayList3, localMessageRecord, i);
            localArrayList2.add(localMessageRecord);
          }
          else
          {
            localArrayList1.add(localMessageRecord);
          }
        }
      }
      if (localaoxu.d.size() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileMultiMsgManager<FileAssistant>", 1, "removeForwardRequest : remove upload request forwardSeq = [" + this.a + "] resultCode[1]");
        }
        localaoxu.jdField_a_of_type_Apfc.a(1, localArrayList1, localArrayList2);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "removeForwardRequest : remove upload request forwardSeq = [" + this.a + "] resultCode[0]");
      }
      localaoxu.jdField_a_of_type_Apfc.a(0, localArrayList1, localArrayList2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.2
 * JD-Core Version:    0.7.0.1
 */