package com.tencent.mobileqq.kandian.repo.common;

import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class ReadInJoyUserInfoRepository$2
  implements Runnable
{
  public void run()
  {
    Object localObject = ReadInJoyUserInfoRepository.a(this.this$0);
    int i = 0;
    int j = this.a;
    localObject = ((EntityManager)localObject).query(ReadInJoyUserInfo.class, true, "uin IS NOT NULL AND uin != ?", new String[] { "" }, null, null, null, String.valueOf(j));
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        ReadInJoyUserInfo localReadInJoyUserInfo = (ReadInJoyUserInfo)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "loadReadInJoyUserInfoFromDB, userInfo = ", localReadInJoyUserInfo, Character.valueOf('\n') });
        }
        this.this$0.a(localReadInJoyUserInfo.uin, localReadInJoyUserInfo, false, false);
      }
    }
    if (QLog.isColorLevel())
    {
      if (localObject != null) {
        i = ((List)localObject).size();
      }
      QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "loadReadInJoyUserInfoFromDB size = ", Integer.valueOf(i) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoRepository.2
 * JD-Core Version:    0.7.0.1
 */