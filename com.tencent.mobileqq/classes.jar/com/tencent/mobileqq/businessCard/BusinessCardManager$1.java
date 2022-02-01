package com.tencent.mobileqq.businessCard;

import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class BusinessCardManager$1
  implements Runnable
{
  BusinessCardManager$1(BusinessCardManager paramBusinessCardManager) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.a();
    int i;
    if (localObject1 != null) {
      i = ((List)localObject1).size();
    } else {
      i = 0;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Init cache from DB,count=");
      ((StringBuilder)localObject2).append(i);
      QLog.d("BusinessCard_Manager", 2, ((StringBuilder)localObject2).toString());
    }
    this.this$0.a.clear();
    if (i > 0)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BusinessCard)((Iterator)localObject1).next();
        this.this$0.a.put(((BusinessCard)localObject2).cardId, localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.BusinessCardManager.1
 * JD-Core Version:    0.7.0.1
 */