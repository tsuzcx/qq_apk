package com.tencent.thumbplayer.datatransport;

public class TPProxyEnumUtils
{
  private static final String TAG = "TPThumbPlayer[TPProxyEnumUtils.java]";
  
  public static int dlType2Inner(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("event is invalid: ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 12: 
      return 16;
    case 11: 
      return 11;
    case 10: 
      return 10;
    case 9: 
      return 9;
    case 8: 
      return 8;
    case 7: 
      return 7;
    case 6: 
      return 6;
    case 5: 
      return 5;
    case 4: 
      return 4;
    case 3: 
      return 3;
    case 2: 
      return 2;
    case 1: 
      return 1;
    }
    return 0;
  }
  
  public static int eventID2Inner(int paramInt)
  {
    int i = 3;
    if (paramInt != 3)
    {
      i = 4;
      if (paramInt != 4)
      {
        i = 5;
        if (paramInt != 5)
        {
          i = 6;
          if (paramInt != 6)
          {
            switch (paramInt)
            {
            default: 
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("event is invalid : ");
              localStringBuilder.append(paramInt);
              throw new IllegalArgumentException(localStringBuilder.toString());
            case 21: 
              return 21;
            case 20: 
              return 20;
            case 19: 
              return 19;
            case 18: 
              return 18;
            case 17: 
              return 17;
            case 16: 
              return 16;
            case 15: 
              return 15;
            case 14: 
              return 14;
            }
            return 13;
          }
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPProxyEnumUtils
 * JD-Core Version:    0.7.0.1
 */