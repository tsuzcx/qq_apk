package com.tencent.mobileqq.kandian.repo.common;

import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

class ReadInJoyUserInfoModule$1
  implements IFindRemovedEntity<ReadInJoyUserInfo>
{
  ReadInJoyUserInfoModule$1(ReadInJoyUserInfoModule paramReadInJoyUserInfoModule) {}
  
  public Entity a(EntityManager paramEntityManager, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (paramEntityManager.tabbleIsExist(ReadInJoyUserInfo.class.getSimpleName())) {
      return paramEntityManager.find(ReadInJoyUserInfo.class, "uin = ?", new String[] { paramReadInJoyUserInfo.uin });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule.1
 * JD-Core Version:    0.7.0.1
 */