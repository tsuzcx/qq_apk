package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.statistics.ReportController;

public class EditActivityEntranceUtil
{
  private static int a(int paramInt)
  {
    int i = 100;
    if (a(paramInt)) {
      i = 1;
    }
    do
    {
      return i;
      if (b(paramInt)) {
        return 2;
      }
      if (paramInt == 140) {
        return 3;
      }
      if (paramInt == 141) {
        return 4;
      }
      if (paramInt == 142) {
        return 5;
      }
    } while (paramInt != 143);
    return 6;
  }
  
  public static void a(String paramString, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, a(paramInt), 0, "", "", "", "");
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt == 11) || (paramInt == 9) || (paramInt == 10) || (paramInt == 100);
  }
  
  private static boolean b(int paramInt)
  {
    return (paramInt == 125) || (paramInt == 126) || (paramInt == 127) || (paramInt == 128) || (paramInt == 129) || (paramInt == 130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.EditActivityEntranceUtil
 * JD-Core Version:    0.7.0.1
 */