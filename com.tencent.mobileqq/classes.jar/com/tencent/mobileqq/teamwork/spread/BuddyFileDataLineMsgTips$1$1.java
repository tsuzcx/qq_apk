package com.tencent.mobileqq.teamwork.spread;

import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigProcessor;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

class BuddyFileDataLineMsgTips$1$1
  implements Runnable
{
  BuddyFileDataLineMsgTips$1$1(BuddyFileDataLineMsgTips.1 param1, List paramList) {}
  
  public void run()
  {
    Object localObject3 = new ArrayList();
    ((List)localObject3).addAll(this.a);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sub Thread getWordsList by buddyFile[");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append("]");
      QLog.i("BuddyFileDataLineMsgTips", 1, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new ArrayList();
    Object localObject4 = new StringTokenizer(TencentDocDataLineTipsConfigProcessor.a().c(), "|");
    if (!((StringTokenizer)localObject4).hasMoreTokens())
    {
      if (QLog.isColorLevel()) {
        QLog.i("BuddyFileDataLineMsgTips", 1, "config filetype is null");
      }
      this.b.a.a((List)localObject1);
      return;
    }
    Object localObject2 = new String[((StringTokenizer)localObject4).countTokens()];
    int i = 0;
    while (((StringTokenizer)localObject4).hasMoreTokens())
    {
      localObject2[i] = ((StringTokenizer)localObject4).nextToken();
      i += 1;
    }
    long l = MessageCache.c();
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (FileManagerEntity)((Iterator)localObject3).next();
      if (((FileManagerEntity)localObject4).uniseq != this.b.this$0.d.uniseq)
      {
        if (((FileManagerEntity)localObject4).srvTime - l * 1000L > 86400000L)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("BuddyFileDataLineMsgTips", 1, "file is over 24h");
          break;
        }
        String str = FileUtil.a(((FileManagerEntity)localObject4).fileName);
        int j = localObject2.length;
        i = 0;
        while (i < j)
        {
          if (localObject2[i].equalsIgnoreCase(str))
          {
            i = 1;
            break label313;
          }
          i += 1;
        }
        i = 0;
        label313:
        if (i != 0) {
          ((List)localObject1).add(((FileManagerEntity)localObject4).fileName);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("find file msg count[");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      ((StringBuilder)localObject2).append("]");
      QLog.i("BuddyFileDataLineMsgTips", 1, ((StringBuilder)localObject2).toString());
    }
    this.b.a.a((List)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.BuddyFileDataLineMsgTips.1.1
 * JD-Core Version:    0.7.0.1
 */