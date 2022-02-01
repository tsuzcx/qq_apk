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
      return 2131756304;
    case 7: 
      return 2130772344;
    case 6: 
      return 2130772003;
    case 5: 
      return 2130772002;
    case 4: 
      return 2130772007;
    case 3: 
      return 2130772006;
    case 2: 
      return 2130772342;
    case 1: 
      return 2130772067;
    }
    return 2130772065;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQResourceIdMapper
 * JD-Core Version:    0.7.0.1
 */