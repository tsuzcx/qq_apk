package com.tencent.mobileqq.filemanager.app;

import akqb;
import aouu;
import aovq;
import apue;
import astr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FileMultiMsgManager$2
  implements Runnable
{
  public FileMultiMsgManager$2(aouu paramaouu, long paramLong) {}
  
  public void run()
  {
    if (aouu.a(this.this$0).containsKey(Long.valueOf(this.a))) {}
    for (aovq localaovq = (aovq)aouu.a(this.this$0).remove(Long.valueOf(this.a));; localaovq = null)
    {
      if ((localaovq != null) && (localaovq.jdField_a_of_type_Astr != null))
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = localaovq.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          localObject = (ArrayList)localaovq.jdField_a_of_type_JavaUtilHashMap.get(localObject);
          int i = 0;
          label112:
          MessageRecord localMessageRecord;
          if (i < ((ArrayList)localObject).size())
          {
            localMessageRecord = (MessageRecord)((ArrayList)localObject).get(i);
            if (apue.a(localMessageRecord))
            {
              if (!String.valueOf(2).equalsIgnoreCase(localMessageRecord.getExtInfoFromExtStr("_m_ForwardFileStatus"))) {
                break label211;
              }
              String str = localMessageRecord.getExtInfoFromExtStr("_m_ForwardFaildReason");
              localMessageRecord = aouu.a(this.this$0).a().a().a(localMessageRecord, str, true);
              ((ArrayList)localObject).remove(i);
              ((ArrayList)localObject).add(i, localMessageRecord);
            }
          }
          for (;;)
          {
            i += 1;
            break label112;
            break;
            label211:
            localArrayList.add(localMessageRecord);
          }
        }
        aouu.a(this.this$0).a().a().a(localArrayList, null);
        if (localaovq.d.size() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileMultiMsgManager<FileAssistant>", 1, "removeMultiRequest : remove upload request uinseq = [" + this.a + "] resultCode[1]");
          }
          localaovq.jdField_a_of_type_Astr.a(1, 2, localaovq.jdField_a_of_type_Asue);
        }
      }
      else
      {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "removeMultiRequest : remove upload request uinseq = [" + this.a + "] resultCode[0]");
      }
      localaovq.jdField_a_of_type_Astr.a(0, 2, localaovq.jdField_a_of_type_Asue);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileMultiMsgManager.2
 * JD-Core Version:    0.7.0.1
 */