package com.tencent.mobileqq.filemanager.app;

import android.text.TextUtils;
import aoea;
import aoeu;
import aoew;
import aoex;
import apck;
import arxn;
import arya;
import awqx;
import badq;
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
    long l2 = this.jdField_a_of_type_Arya.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq;
    String str = this.jdField_a_of_type_Arya.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Arya.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    boolean bool = badq.g(null);
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "isNetworkAvailable:" + bool);
    }
    aoew localaoew = new aoew(this.this$0, l2, this.jdField_a_of_type_Arya, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Arxn);
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
        if ((!apck.a((MessageRecord)localObject2)) || (!aoea.a(this.this$0, (MessageRecord)localObject2))) {
          continue;
        }
        aoeu localaoeu = aoea.a(this.this$0, str, i, l2, (MessageRecord)localObject2);
        if (localaoeu == null) {
          continue;
        }
        localaoew.a(localaoeu);
        if (!bool) {
          localaoeu.a.a("", true);
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
      if (localaoew.a() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileMultiMsgManager<FileAssistant>", 2, "addMultiRequest : multiUniseq[" + l2 + "] toUin[" + str + "] toType[" + i + "] uploadCount[" + localaoew.a() + "]");
        }
        str = new DecimalFormat("0.00").format(l1 / 1024.0D / 1024.0D);
        awqx.b(aoea.a(this.this$0), "dc00898", "", "", "0X8009ABE", "0X8009ABE", 0, 0, "", "", str, "");
        aoea.a(this.this$0).put(Long.valueOf(l2), localaoew);
        localaoew.a();
        return;
      }
      this.jdField_a_of_type_Arxn.a(0, 2, this.jdField_a_of_type_Arya);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileMultiMsgManager.1
 * JD-Core Version:    0.7.0.1
 */