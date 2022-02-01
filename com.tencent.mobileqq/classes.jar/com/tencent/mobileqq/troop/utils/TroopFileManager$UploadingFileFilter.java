package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.troop.data.TroopFileInfo;

public class TroopFileManager$UploadingFileFilter
  implements TroopFileManager.Filter
{
  public boolean a(TroopFileInfo paramTroopFileInfo)
  {
    int i = paramTroopFileInfo.e;
    return (i == 0) || (i == 1) || (i == 2) || (i == 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager.UploadingFileFilter
 * JD-Core Version:    0.7.0.1
 */