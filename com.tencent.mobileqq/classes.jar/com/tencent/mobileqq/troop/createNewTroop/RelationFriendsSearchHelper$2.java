package com.tencent.mobileqq.troop.createNewTroop;

import java.util.Comparator;
import java.util.Map.Entry;

class RelationFriendsSearchHelper$2
  implements Comparator<Map.Entry<String, RelationFriendsSearchHelper.MemberScore>>
{
  RelationFriendsSearchHelper$2(RelationFriendsSearchHelper paramRelationFriendsSearchHelper) {}
  
  public int a(Map.Entry<String, RelationFriendsSearchHelper.MemberScore> paramEntry1, Map.Entry<String, RelationFriendsSearchHelper.MemberScore> paramEntry2)
  {
    long l = ((RelationFriendsSearchHelper.MemberScore)paramEntry2.getValue()).a - ((RelationFriendsSearchHelper.MemberScore)paramEntry1.getValue()).a;
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.RelationFriendsSearchHelper.2
 * JD-Core Version:    0.7.0.1
 */