package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.pluginsdk.ResourceIdMapper;

public class QQResourceIdMapper
  extends ResourceIdMapper
{
  public int getHostResourceId(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 2130772043;
    case 1: 
      return 2130772045;
    case 2: 
      return 2130772314;
    case 7: 
      return 2130772316;
    case 3: 
      return 2130771994;
    case 6: 
      return 2130771991;
    case 5: 
      return 2130771990;
    case 4: 
      return 2130771995;
    }
    return 2131755955;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQResourceIdMapper
 * JD-Core Version:    0.7.0.1
 */