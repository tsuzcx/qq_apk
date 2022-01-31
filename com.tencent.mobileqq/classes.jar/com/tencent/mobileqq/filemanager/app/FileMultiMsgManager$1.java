package com.tencent.mobileqq.filemanager.app;

import android.text.TextUtils;
import aqnw;
import aqoq;
import aqos;
import aqot;
import arni;
import aukq;
import auld;
import azmj;
import bdee;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FileMultiMsgManager$1
  implements Runnable
{
  public void run()
  {
    long l2 = this.jdField_a_of_type_Auld.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq;
    String str = this.jdField_a_of_type_Auld.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Auld.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    boolean bool = bdee.g(null);
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "isNetworkAvailable:" + bool);
    }
    aqos localaqos = new aqos(this.this$0, l2, this.jdField_a_of_type_Auld, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Aukq);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    long l1 = 0L;
    Object localObject1;
    if (localIterator.hasNext())
    {
      localObject1 = (String)localIterator.next();
      localObject1 = ((ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1)).iterator();
    }
    for (;;)
    {
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((!arni.a((MessageRecord)localObject2)) || (!aqnw.a(this.this$0, (MessageRecord)localObject2))) {
          continue;
        }
        aqoq localaqoq = aqnw.a(this.this$0, str, i, l2, (MessageRecord)localObject2);
        if (localaqoq == null) {
          continue;
        }
        localaqos.a(localaqoq);
        if (!bool) {
          localaqoq.a.a("", true);
        }
      }
      try
      {
        localObject2 = ((MessageRecord)localObject2).getExtInfoFromExtStr("_m_ForwardSize");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        long l3 = Long.valueOf((String)localObject2).longValue();
        l1 += l3;
      }
      catch (NumberFormatException localNumberFormatException) {}
      break;
      if (localaqos.a() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileMultiMsgManager<FileAssistant>", 2, "addMultiRequest : multiUniseq[" + l2 + "] toUin[" + str + "] toType[" + i + "] uploadCount[" + localaqos.a() + "]");
        }
        str = new DecimalFormat("0.00").format(l1 / 1024.0D / 1024.0D);
        azmj.b(aqnw.a(this.this$0), "dc00898", "", "", "0X8009ABE", "0X8009ABE", 0, 0, "", "", str, "");
        aqnw.a(this.this$0).put(Long.valueOf(l2), localaqos);
        localaqos.a();
        return;
      }
      this.jdField_a_of_type_Aukq.a(0, 2, this.jdField_a_of_type_Auld);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileMultiMsgManager.1
 * JD-Core Version:    0.7.0.1
 */