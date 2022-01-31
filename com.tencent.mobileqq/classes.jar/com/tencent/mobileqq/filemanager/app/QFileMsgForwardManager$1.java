package com.tencent.mobileqq.filemanager.app;

import android.text.TextUtils;
import aofz;
import aogt;
import aogv;
import aogw;
import aood;
import apck;
import awqx;
import badq;
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
  public QFileMsgForwardManager$1(aofz paramaofz, aood paramaood) {}
  
  public void run()
  {
    boolean bool = badq.g(null);
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
    aogw localaogw = new aogw(this.this$0, str1, this.a, localHashMap);
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
        if ((apck.a((MessageRecord)localObject)) && (aofz.a(this.this$0, (MessageRecord)localObject)))
        {
          aogt localaogt = aofz.a(this.this$0, str2, i, str1, (MessageRecord)localObject);
          if (localaogt == null) {
            break label301;
          }
          localaogw.a(localaogt);
          if (!bool) {
            localaogt.a.a("", true);
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
    if (localaogw.a() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 2, "addMultiRequest : forwardMsgSeq[" + str1 + "] toUin[" + str2 + "] toType[" + i + "] uploadCount[" + localaogw.a() + "]");
      }
      str2 = new DecimalFormat("0.00").format(l1 / 1024.0D / 1024.0D);
      awqx.b(aofz.a(this.this$0), "dc00898", "", "", "0X8009ABE", "0X8009ABE", 0, 0, "", "", str2, "");
      aofz.a(this.this$0).put(str1, localaogw);
      localaogw.a();
      return;
    }
    this.a.a(0, new ArrayList(), new ArrayList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.1
 * JD-Core Version:    0.7.0.1
 */