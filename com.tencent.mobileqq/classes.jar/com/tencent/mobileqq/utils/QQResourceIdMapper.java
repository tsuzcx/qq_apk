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
    case 8: 
      return 2131953462;
    case 7: 
      return 2130772436;
    case 6: 
      return 2130772006;
    case 5: 
      return 2130772005;
    case 4: 
      return 2130772010;
    case 3: 
      return 2130772009;
    case 2: 
      return 2130772434;
    case 1: 
      return 2130772092;
    }
    return 2130772090;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQResourceIdMapper
 * JD-Core Version:    0.7.0.1
 */