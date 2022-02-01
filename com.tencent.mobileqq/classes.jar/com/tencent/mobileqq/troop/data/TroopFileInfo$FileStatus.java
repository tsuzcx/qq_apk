package com.tencent.mobileqq.troop.data;

public class TroopFileInfo$FileStatus
{
  public static int a(String paramString)
  {
    if (paramString.equals("SCANNING")) {
      return 0;
    }
    if (paramString.equals("UPLOADING")) {
      return 1;
    }
    if (paramString.equals("UPLOAD_SUSPEND")) {
      return 2;
    }
    if (paramString.equals("UPLOAD_INTERRUPT")) {
      return 3;
    }
    if (paramString.equals("FORWARDING")) {
      return 4;
    }
    if (paramString.equals("FORWARD_FAILED")) {
      return 5;
    }
    if (paramString.equals("UPLOADED")) {
      return 6;
    }
    if (paramString.equals("NOT_DOWNLOAD")) {
      return 7;
    }
    if (paramString.equals("DOWNLOADING")) {
      return 8;
    }
    if (paramString.equals("DOWNLOAD_SUSPEND")) {
      return 9;
    }
    if (paramString.equals("DOWNLOAD_INTERRUPT")) {
      return 10;
    }
    if (paramString.equals("DOWNLOADED")) {
      return 11;
    }
    if (paramString.equals("DELETED")) {
      return 12;
    }
    if (paramString.equals("OTHER_UPLOADING")) {
      return 13;
    }
    return -1;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 1)
      {
        bool1 = bool2;
        if (paramInt != 2)
        {
          if (paramInt == 3) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 8) || (paramInt == 10) || (paramInt == 9);
  }
  
  public static String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 13: 
      return "OTHER_UPLOADING";
    case 12: 
      return "DELETED";
    case 11: 
      return "DOWNLOADED";
    case 10: 
      return "DOWNLOAD_INTERRUPT";
    case 9: 
      return "DOWNLOAD_SUSPEND";
    case 8: 
      return "DOWNLOADING";
    case 7: 
      return "NOT_DOWNLOAD";
    case 6: 
      return "UPLOADED";
    case 5: 
      return "FORWARD_FAILED";
    case 4: 
      return "FORWARDING";
    case 3: 
      return "UPLOAD_INTERRUPT";
    case 2: 
      return "UPLOAD_SUSPEND";
    case 1: 
      return "UPLOADING";
    }
    return "SCANNING";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileInfo.FileStatus
 * JD-Core Version:    0.7.0.1
 */