package com.tencent.mobileqq.selectmember.adapter;

import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;
import java.util.HashMap;

class DiscussionListAdapter2$1
  implements Comparator<Entity>
{
  DiscussionListAdapter2$1(DiscussionListAdapter2 paramDiscussionListAdapter2, HashMap paramHashMap) {}
  
  public int a(Entity paramEntity1, Entity paramEntity2)
  {
    long l1 = ((Long)this.a.get(((DiscussionInfo)paramEntity1).uin)).longValue();
    long l2 = ((Long)this.a.get(((DiscussionInfo)paramEntity2).uin)).longValue();
    if (l1 < l2) {
      return -1;
    }
    if (l1 > l2) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.adapter.DiscussionListAdapter2.1
 * JD-Core Version:    0.7.0.1
 */