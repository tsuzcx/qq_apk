package com.tencent.mobileqq.data;

import atmo;

public class TroopMessageNavigateInfo
  extends atmo
{
  public static int STATUS_ADD = 1;
  public static int STATUS_DELETE = 3;
  public static int STATUS_MODIFY = 2;
  public static int STATUS_NORMAL;
  public long msgseq;
  public int receivedFlowserCount;
  public int status = STATUS_NORMAL;
  public String summary;
  public String troopCode;
  public int type;
  
  public int getMsgBizType()
  {
    int i = 26;
    switch (this.type)
    {
    default: 
      if (this.type > 26) {}
      i = this.type;
    case 26: 
      return i;
    case 6: 
      return 5;
    case 13: 
      return 12;
    case 14: 
      return 13;
    case 16: 
      return 15;
    case 17: 
      return 17;
    case 11: 
      return 10;
    case 18: 
      return 18;
    case 19: 
      return 19;
    case 21: 
      return 21;
    case 22: 
      return 22;
    case 23: 
      return 23;
    case 24: 
      return 24;
    case 5: 
      return 4;
    case 4: 
      return 3;
    case 3: 
      return 2;
    case 10: 
      return 9;
    case 7: 
      return 6;
    case 20: 
      return 20;
    }
    return 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopMessageNavigateInfo
 * JD-Core Version:    0.7.0.1
 */