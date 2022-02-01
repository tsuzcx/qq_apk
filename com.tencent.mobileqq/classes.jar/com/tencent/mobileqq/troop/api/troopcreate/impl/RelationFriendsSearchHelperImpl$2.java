package com.tencent.mobileqq.troop.api.troopcreate.impl;

import java.util.Comparator;
import java.util.Map.Entry;

class RelationFriendsSearchHelperImpl$2
  implements Comparator<Map.Entry<String, RelationFriendsSearchHelperImpl.MemberScore>>
{
  RelationFriendsSearchHelperImpl$2(RelationFriendsSearchHelperImpl paramRelationFriendsSearchHelperImpl) {}
  
  public int a(Map.Entry<String, RelationFriendsSearchHelperImpl.MemberScore> paramEntry1, Map.Entry<String, RelationFriendsSearchHelperImpl.MemberScore> paramEntry2)
  {
    long l = ((RelationFriendsSearchHelperImpl.MemberScore)paramEntry2.getValue()).d - ((RelationFriendsSearchHelperImpl.MemberScore)paramEntry1.getValue()).d;
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopcreate.impl.RelationFriendsSearchHelperImpl.2
 * JD-Core Version:    0.7.0.1
 */