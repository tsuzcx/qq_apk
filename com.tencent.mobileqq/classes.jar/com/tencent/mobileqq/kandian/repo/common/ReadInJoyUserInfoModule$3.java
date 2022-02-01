package com.tencent.mobileqq.kandian.repo.common;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class ReadInJoyUserInfoModule$3
  implements Runnable
{
  ReadInJoyUserInfoModule$3(ReadInJoyUserInfoModule paramReadInJoyUserInfoModule, List paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (TextUtils.isEmpty(str))
      {
        QLog.e("ReadInJoyUserInfoModule", 1, "uin is null or empty");
      }
      else if (ReadInJoyUserInfoModule.a(this.this$0).get(str) != null)
      {
        QLog.d("ReadInJoyUserInfoModule", 2, "getSingleReadInJoyUserInfoWithParams return ahead of time, do not load db or network request, because the userInfo is loading.");
      }
      else
      {
        if (ReadInJoyUserInfoModule.b(this.this$0) != null)
        {
          localObject = ReadInJoyUserInfoModule.b(this.this$0).a(str);
          if (localObject != null)
          {
            QLog.d("ReadInJoyUserInfoModule", 2, "getSingleReadInJoyUserInfoWithParams, hit cache, do not request again.");
            ReadInJoyUserInfoModule.b(this.this$0).a(str, (ReadInJoyUserInfo)localObject);
            continue;
          }
        }
        ReadInJoyUserInfoModule.a(this.this$0).put(str, Boolean.valueOf(true));
        Object localObject = ReadInJoyUserInfoModule.b(this.this$0).b(str);
        if ((localObject == null) || (((List)localObject).size() <= 0)) {
          localArrayList.add(str);
        }
      }
    }
    if (localArrayList.size() > 0) {
      this.this$0.a(localArrayList, this.b, this.c, this.d, this.e, 0, this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule.3
 * JD-Core Version:    0.7.0.1
 */