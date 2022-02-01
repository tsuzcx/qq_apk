package com.tencent.mobileqq.troop.api.troopcreate.impl;

import java.util.Comparator;
import java.util.Map.Entry;

class RelationFriendsSearchHelperImpl$1
  implements Comparator<Map.Entry<String, RelationFriendsSearchHelperImpl.MemberScore>>
{
  RelationFriendsSearchHelperImpl$1(RelationFriendsSearchHelperImpl paramRelationFriendsSearchHelperImpl) {}
  
  public int a(Map.Entry<String, RelationFriendsSearchHelperImpl.MemberScore> paramEntry1, Map.Entry<String, RelationFriendsSearchHelperImpl.MemberScore> paramEntry2)
  {
    float f = ((RelationFriendsSearchHelperImpl.MemberScore)paramEntry2.getValue()).a() - ((RelationFriendsSearchHelperImpl.MemberScore)paramEntry1.getValue()).a();
    if (f > 0.0F) {
      return 1;
    }
    if (f < 0.0F) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopcreate.impl.RelationFriendsSearchHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */