package com.tencent.mobileqq.emoticon;

public class EmoticonReportUtil
{
  public static final int TYPE_DISCUSSION = 2;
  public static final int TYPE_FRIEND = 0;
  public static final int TYPE_OTHER = 999;
  public static final int TYPE_PUBLIC = 4;
  public static final int TYPE_TEMP = 1;
  public static final int TYPE_TROOP = 3;
  
  public static String getAioMoreFlag(int paramInt)
  {
    int j = 1;
    int i;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        i = j;
        if (paramInt == 1000) {
          break label180;
        }
        i = j;
        if (paramInt == 1001) {
          break label180;
        }
        if (paramInt != 1008)
        {
          i = j;
          if (paramInt == 1009) {
            break label180;
          }
          i = j;
          if (paramInt == 1020) {
            break label180;
          }
          if (paramInt != 3000)
          {
            i = j;
            if (paramInt == 10002) {
              break label180;
            }
            i = j;
            if (paramInt == 10004) {
              break label180;
            }
            i = j;
            if (paramInt == 10008) {
              break label180;
            }
            i = j;
            if (paramInt == 10010) {
              break label180;
            }
            i = j;
          }
        }
      }
    }
    switch (paramInt)
    {
    default: 
      i = j;
      switch (paramInt)
      {
      default: 
        i = 999;
        break label180;
        i = 2;
        break label180;
        i = 4;
        break label180;
        i = 3;
        break label180;
        i = 0;
      }
      break;
    }
    label180:
    return String.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmoticonReportUtil
 * JD-Core Version:    0.7.0.1
 */