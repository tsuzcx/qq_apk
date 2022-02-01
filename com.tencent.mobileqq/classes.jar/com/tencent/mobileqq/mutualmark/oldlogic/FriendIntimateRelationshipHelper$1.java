package com.tencent.mobileqq.mutualmark.oldlogic;

import java.util.Comparator;

final class FriendIntimateRelationshipHelper$1
  implements Comparator<String>
{
  public int a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      if (paramString1.length() <= paramString2.length()) {}
    }
    while (paramString1 != null)
    {
      return -1;
      if (paramString1.length() >= paramString2.length()) {
        break;
      }
      return 1;
    }
    if (paramString2 != null) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper.1
 * JD-Core Version:    0.7.0.1
 */