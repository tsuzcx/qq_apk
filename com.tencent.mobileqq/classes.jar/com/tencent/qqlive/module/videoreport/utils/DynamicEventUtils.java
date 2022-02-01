package com.tencent.qqlive.module.videoreport.utils;

public class DynamicEventUtils
{
  public static boolean filterDynamicEvent(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1925548520: 
      if (paramString.equals("imp_end")) {
        i = 1;
      }
      break;
    case 106613239: 
      if (paramString.equals("pgout")) {
        i = 4;
      }
      break;
    case 3438940: 
      if (paramString.equals("pgin")) {
        i = 3;
      }
      break;
    case 3056273: 
      if (paramString.equals("clck")) {
        i = 2;
      }
      break;
    case 104396: 
      if (paramString.equals("imp")) {
        i = 0;
      }
      break;
    }
    int i = -1;
    return (i == 0) || (i == 1) || (i == 2) || (i == 3) || (i == 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.DynamicEventUtils
 * JD-Core Version:    0.7.0.1
 */