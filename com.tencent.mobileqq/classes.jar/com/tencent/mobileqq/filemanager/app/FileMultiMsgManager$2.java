package com.tencent.mobileqq.filemanager.app;

import amlb;
import aqsf;
import aqtb;
import arrr;
import auoz;
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
  public FileMultiMsgManager$2(aqsf paramaqsf, long paramLong) {}
  
  public void run()
  {
    if (aqsf.a(this.this$0).containsKey(Long.valueOf(this.a))) {}
    for (aqtb localaqtb = (aqtb)aqsf.a(this.this$0).remove(Long.valueOf(this.a));; localaqtb = null)
    {
      if ((localaqtb != null) && (localaqtb.jdField_a_of_type_Auoz != null))
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = localaqtb.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          localObject = (ArrayList)localaqtb.jdField_a_of_type_JavaUtilHashMap.get(localObject);
          int i = 0;
          label112:
          MessageRecord localMessageRecord;
          if (i < ((ArrayList)localObject).size())
          {
            localMessageRecord = (MessageRecord)((ArrayList)localObject).get(i);
            if (arrr.a(localMessageRecord))
            {
              if (!String.valueOf(2).equalsIgnoreCase(localMessageRecord.getExtInfoFromExtStr("_m_ForwardFileStatus"))) {
                break label211;
              }
              String str = localMessageRecord.getExtInfoFromExtStr("_m_ForwardFaildReason");
              localMessageRecord = aqsf.a(this.this$0).a().a().a(localMessageRecord, str, true);
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
        aqsf.a(this.this$0).a().a().a(localArrayList, null);
        if (localaqtb.d.size() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileMultiMsgManager<FileAssistant>", 1, "removeMultiRequest : remove upload request uinseq = [" + this.a + "] resultCode[1]");
          }
          localaqtb.jdField_a_of_type_Auoz.a(1, 2, localaqtb.jdField_a_of_type_Aupm);
        }
      }
      else
      {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "removeMultiRequest : remove upload request uinseq = [" + this.a + "] resultCode[0]");
      }
      localaqtb.jdField_a_of_type_Auoz.a(0, 2, localaqtb.jdField_a_of_type_Aupm);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileMultiMsgManager.2
 * JD-Core Version:    0.7.0.1
 */