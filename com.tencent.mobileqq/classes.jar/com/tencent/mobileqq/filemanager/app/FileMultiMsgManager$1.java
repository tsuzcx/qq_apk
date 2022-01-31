package com.tencent.mobileqq.filemanager.app;

import android.text.TextUtils;
import aqsf;
import aqsz;
import aqtb;
import aqtc;
import arrr;
import auoz;
import aupm;
import azqs;
import bdin;
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
    long l2 = this.jdField_a_of_type_Aupm.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq;
    String str = this.jdField_a_of_type_Aupm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Aupm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    boolean bool = bdin.g(null);
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "isNetworkAvailable:" + bool);
    }
    aqtb localaqtb = new aqtb(this.this$0, l2, this.jdField_a_of_type_Aupm, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Auoz);
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
        if ((!arrr.a((MessageRecord)localObject2)) || (!aqsf.a(this.this$0, (MessageRecord)localObject2))) {
          continue;
        }
        aqsz localaqsz = aqsf.a(this.this$0, str, i, l2, (MessageRecord)localObject2);
        if (localaqsz == null) {
          continue;
        }
        localaqtb.a(localaqsz);
        if (!bool) {
          localaqsz.a.a("", true);
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
      if (localaqtb.a() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileMultiMsgManager<FileAssistant>", 2, "addMultiRequest : multiUniseq[" + l2 + "] toUin[" + str + "] toType[" + i + "] uploadCount[" + localaqtb.a() + "]");
        }
        str = new DecimalFormat("0.00").format(l1 / 1024.0D / 1024.0D);
        azqs.b(aqsf.a(this.this$0), "dc00898", "", "", "0X8009ABE", "0X8009ABE", 0, 0, "", "", str, "");
        aqsf.a(this.this$0).put(Long.valueOf(l2), localaqtb);
        localaqtb.a();
        return;
      }
      this.jdField_a_of_type_Auoz.a(0, 2, this.jdField_a_of_type_Aupm);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileMultiMsgManager.1
 * JD-Core Version:    0.7.0.1
 */