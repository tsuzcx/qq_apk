package com.tencent.mobileqq.kandian.biz.common;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDataProvider;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyFeedsMsgRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class ReadInJoyManager$1
  implements Runnable
{
  ReadInJoyManager$1(ReadInJoyManager paramReadInJoyManager, List paramList) {}
  
  public void run()
  {
    Object localObject1 = ReadInJoyDataProvider.c.buildUpon();
    ((Uri.Builder)localObject1).appendQueryParameter("uin", ReadInJoyManager.d(this.this$0).getAccount());
    localObject1 = ((Uri.Builder)localObject1).build();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ReadInJoyFeedsMsgRecord localReadInJoyFeedsMsgRecord = (ReadInJoyFeedsMsgRecord)localIterator.next();
      Object localObject2 = new HashSet(ReadInJoyManager.f(this.this$0).keySet()).iterator();
      int i;
      while (((Iterator)localObject2).hasNext())
      {
        i = ((Integer)((Iterator)localObject2).next()).intValue();
        int j = (int)NetConnInfoCenter.getServerTime();
        if ((i < j) && (j - i > 300)) {
          ReadInJoyManager.f(this.this$0).remove(Integer.valueOf(i));
        }
      }
      if (!ReadInJoyManager.f(this.this$0).containsValue(Integer.valueOf(localReadInJoyFeedsMsgRecord.b)))
      {
        ReadInJoyManager.f(this.this$0).put(Integer.valueOf(localReadInJoyFeedsMsgRecord.a), Integer.valueOf(localReadInJoyFeedsMsgRecord.b));
        long l = ReadInJoyManager.g(this.this$0);
        if ((localReadInJoyFeedsMsgRecord.c != 10) && (localReadInJoyFeedsMsgRecord.c != 11) && (localReadInJoyFeedsMsgRecord.c != 12) && (localReadInJoyFeedsMsgRecord.c != 999999))
        {
          ContentValues localContentValues;
          if (localReadInJoyFeedsMsgRecord.c == 14)
          {
            localObject2 = String.format("%s = '%s' and %s = %d", new Object[] { "commentID", localReadInJoyFeedsMsgRecord.h, "notifyType", Integer.valueOf(11) });
            localContentValues = new ContentValues();
            localContentValues.put("isDelete", Integer.valueOf(1));
            ReadInJoyManager.d(this.this$0).getApp().getContentResolver().update((Uri)localObject1, localContentValues, (String)localObject2, null);
            ReadInJoyManager.a(this.this$0, (Uri)localObject1, localReadInJoyFeedsMsgRecord, l);
          }
          else if (localReadInJoyFeedsMsgRecord.c == 13)
          {
            localObject2 = String.format("%s = %s and %s = %d", new Object[] { "feedsID", Long.toString(localReadInJoyFeedsMsgRecord.e), "notifyType", Integer.valueOf(10) });
            localContentValues = new ContentValues();
            localContentValues.put("isDelete", Integer.valueOf(1));
            ReadInJoyManager.d(this.this$0).getApp().getContentResolver().update((Uri)localObject1, localContentValues, (String)localObject2, null);
            ReadInJoyManager.a(this.this$0, (Uri)localObject1, localReadInJoyFeedsMsgRecord, l);
          }
        }
        else if (ReadInJoyManager.a(this.this$0, (Uri)localObject1, localReadInJoyFeedsMsgRecord, l))
        {
          ReadInJoyManager.b(this.this$0);
        }
        i = localReadInJoyFeedsMsgRecord.c;
      }
    }
    ReadInJoyManager.d(this.this$0).getApp().getContentResolver().notifyChange(ReadInJoyDataProvider.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyManager.1
 * JD-Core Version:    0.7.0.1
 */