package com.tencent.mobileqq.filemanager.app;

import amgm;
import aqnw;
import aqos;
import arni;
import aukq;
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
  public FileMultiMsgManager$2(aqnw paramaqnw, long paramLong) {}
  
  public void run()
  {
    if (aqnw.a(this.this$0).containsKey(Long.valueOf(this.a))) {}
    for (aqos localaqos = (aqos)aqnw.a(this.this$0).remove(Long.valueOf(this.a));; localaqos = null)
    {
      if ((localaqos != null) && (localaqos.jdField_a_of_type_Aukq != null))
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = localaqos.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          localObject = (ArrayList)localaqos.jdField_a_of_type_JavaUtilHashMap.get(localObject);
          int i = 0;
          label112:
          MessageRecord localMessageRecord;
          if (i < ((ArrayList)localObject).size())
          {
            localMessageRecord = (MessageRecord)((ArrayList)localObject).get(i);
            if (arni.a(localMessageRecord))
            {
              if (!String.valueOf(2).equalsIgnoreCase(localMessageRecord.getExtInfoFromExtStr("_m_ForwardFileStatus"))) {
                break label211;
              }
              String str = localMessageRecord.getExtInfoFromExtStr("_m_ForwardFaildReason");
              localMessageRecord = aqnw.a(this.this$0).a().a().a(localMessageRecord, str, true);
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
        aqnw.a(this.this$0).a().a().a(localArrayList, null);
        if (localaqos.d.size() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileMultiMsgManager<FileAssistant>", 1, "removeMultiRequest : remove upload request uinseq = [" + this.a + "] resultCode[1]");
          }
          localaqos.jdField_a_of_type_Aukq.a(1, 2, localaqos.jdField_a_of_type_Auld);
        }
      }
      else
      {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "removeMultiRequest : remove upload request uinseq = [" + this.a + "] resultCode[0]");
      }
      localaqos.jdField_a_of_type_Aukq.a(0, 2, localaqos.jdField_a_of_type_Auld);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileMultiMsgManager.2
 * JD-Core Version:    0.7.0.1
 */