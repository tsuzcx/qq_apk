package com.tencent.mobileqq.filemanager.app;

import akqa;
import aouy;
import aovu;
import apug;
import astt;
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
  public FileMultiMsgManager$2(aouy paramaouy, long paramLong) {}
  
  public void run()
  {
    if (aouy.a(this.this$0).containsKey(Long.valueOf(this.a))) {}
    for (aovu localaovu = (aovu)aouy.a(this.this$0).remove(Long.valueOf(this.a));; localaovu = null)
    {
      if ((localaovu != null) && (localaovu.jdField_a_of_type_Astt != null))
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = localaovu.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          localObject = (ArrayList)localaovu.jdField_a_of_type_JavaUtilHashMap.get(localObject);
          int i = 0;
          label112:
          MessageRecord localMessageRecord;
          if (i < ((ArrayList)localObject).size())
          {
            localMessageRecord = (MessageRecord)((ArrayList)localObject).get(i);
            if (apug.a(localMessageRecord))
            {
              if (!String.valueOf(2).equalsIgnoreCase(localMessageRecord.getExtInfoFromExtStr("_m_ForwardFileStatus"))) {
                break label211;
              }
              String str = localMessageRecord.getExtInfoFromExtStr("_m_ForwardFaildReason");
              localMessageRecord = aouy.a(this.this$0).a().a().a(localMessageRecord, str, true);
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
        aouy.a(this.this$0).a().a().a(localArrayList, null);
        if (localaovu.d.size() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileMultiMsgManager<FileAssistant>", 1, "removeMultiRequest : remove upload request uinseq = [" + this.a + "] resultCode[1]");
          }
          localaovu.jdField_a_of_type_Astt.a(1, 2, localaovu.jdField_a_of_type_Asug);
        }
      }
      else
      {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "removeMultiRequest : remove upload request uinseq = [" + this.a + "] resultCode[0]");
      }
      localaovu.jdField_a_of_type_Astt.a(0, 2, localaovu.jdField_a_of_type_Asug);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileMultiMsgManager.2
 * JD-Core Version:    0.7.0.1
 */