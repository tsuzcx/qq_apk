package com.tencent.mobileqq.filemanager.app;

import android.text.TextUtils;
import aque;
import aquy;
import aqva;
import aqvb;
import arcj;
import arrr;
import azqs;
import bdin;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class QFileMsgForwardManager$1
  implements Runnable
{
  public QFileMsgForwardManager$1(aque paramaque, arcj paramarcj) {}
  
  public void run()
  {
    boolean bool = bdin.g(null);
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "isNetworkAvailable:" + bool);
    }
    String str1 = this.a.a();
    String str2 = this.a.b();
    int i = this.a.a();
    HashMap localHashMap = this.a.a();
    if ((localHashMap == null) || (localHashMap.isEmpty()))
    {
      this.a.a(0, new ArrayList(), new ArrayList());
      return;
    }
    aqvb localaqvb = new aqvb(this.this$0, str1, this.a, localHashMap);
    Iterator localIterator1 = localHashMap.keySet().iterator();
    long l1 = 0L;
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ArrayList)localHashMap.get((String)localIterator1.next())).iterator();
      long l2 = l1;
      for (;;)
      {
        l1 = l2;
        if (!localIterator2.hasNext()) {
          break;
        }
        Object localObject = (MessageRecord)localIterator2.next();
        if ((arrr.a((MessageRecord)localObject)) && (aque.a(this.this$0, (MessageRecord)localObject)))
        {
          aquy localaquy = aque.a(this.this$0, str2, i, str1, (MessageRecord)localObject);
          if (localaquy == null) {
            break label301;
          }
          localaqvb.a(localaquy);
          if (!bool) {
            localaquy.a.a("", true);
          }
          localObject = ((MessageRecord)localObject).getExtInfoFromExtStr("_m_ForwardSize");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            l2 += Long.valueOf((String)localObject).longValue();
          }
        }
      }
      label301:
      QLog.i("FileMultiMsgManager<FileAssistant>", 2, "addMultiRequest : createUploadTask failed. forwardMsgSeq[" + str1 + "] toUin[" + str2 + "] toType[" + i + "] ");
      this.a.a(1, new ArrayList(), new ArrayList());
      return;
    }
    if (localaqvb.a() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 2, "addMultiRequest : forwardMsgSeq[" + str1 + "] toUin[" + str2 + "] toType[" + i + "] uploadCount[" + localaqvb.a() + "]");
      }
      str2 = new DecimalFormat("0.00").format(l1 / 1024.0D / 1024.0D);
      azqs.b(aque.a(this.this$0), "dc00898", "", "", "0X8009ABE", "0X8009ABE", 0, 0, "", "", str2, "");
      aque.a(this.this$0).put(str1, localaqvb);
      localaqvb.a();
      return;
    }
    this.a.a(0, new ArrayList(), new ArrayList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.1
 * JD-Core Version:    0.7.0.1
 */