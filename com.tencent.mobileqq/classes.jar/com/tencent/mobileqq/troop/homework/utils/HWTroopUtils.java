package com.tencent.mobileqq.troop.homework.utils;

import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.AppConstants;

public class HWTroopUtils
{
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_HOMEWORK_AUDIO);
    localStringBuilder.append("homeworkTmp/");
    a = localStringBuilder.toString();
  }
  
  public static void a()
  {
    Object localObject = new VFSFile(a);
    boolean bool = ((VFSFile)localObject).exists();
    int j = 0;
    int i;
    if (bool)
    {
      localObject = ((VFSFile)localObject).listFiles();
      i = 0;
      while (i < localObject.length)
      {
        localObject[i].delete();
        i += 1;
      }
    }
    localObject = new VFSFile(AppConstants.SDCARD_HOMEWORK_AUDIO);
    if (((VFSFile)localObject).exists())
    {
      localObject = ((VFSFile)localObject).listFiles();
      i = j;
      while (i < localObject.length)
      {
        localObject[i].delete();
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.utils.HWTroopUtils
 * JD-Core Version:    0.7.0.1
 */