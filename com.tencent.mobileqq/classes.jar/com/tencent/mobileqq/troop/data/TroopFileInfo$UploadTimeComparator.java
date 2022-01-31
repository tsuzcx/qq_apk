package com.tencent.mobileqq.troop.data;

import java.util.Comparator;

public class TroopFileInfo$UploadTimeComparator
  implements Comparator
{
  public int a(TroopFileInfo paramTroopFileInfo1, TroopFileInfo paramTroopFileInfo2)
  {
    if (paramTroopFileInfo1.b < paramTroopFileInfo2.b) {
      return 1;
    }
    if (paramTroopFileInfo1.b == paramTroopFileInfo2.b) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileInfo.UploadTimeComparator
 * JD-Core Version:    0.7.0.1
 */