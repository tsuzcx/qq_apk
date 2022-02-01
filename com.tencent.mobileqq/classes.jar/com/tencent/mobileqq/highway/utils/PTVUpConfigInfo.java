package com.tencent.mobileqq.highway.utils;

import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.PTVConf;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class PTVUpConfigInfo
{
  public static volatile boolean sIsHardCodeEnable = true;
  private static volatile boolean sIsUpdated = false;
  public static int sSwitch = 1;
  
  public static boolean getIsUpdated()
  {
    try
    {
      boolean bool = sIsUpdated;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean isPreUpload()
  {
    try
    {
      int i = sSwitch;
      boolean bool;
      if (i == 3) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setIsUpdated()
  {
    try
    {
      sIsUpdated = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void updateFromSrc(subcmd0x501.SubCmd0x501Rspbody.PTVConf paramPTVConf)
  {
    try
    {
      sIsUpdated = true;
      if (paramPTVConf == null) {
        return;
      }
      if (paramPTVConf.uint32_channel_type.has())
      {
        sSwitch = paramPTVConf.uint32_channel_type.get();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PTVUpConfigInfo.updateFromSrv: sSwitch = ");
        localStringBuilder.append(sSwitch);
        BdhLogUtil.LogEvent("R", localStringBuilder.toString());
      }
      if (paramPTVConf.bool_open_hardware_codec.has())
      {
        sIsHardCodeEnable = paramPTVConf.bool_open_hardware_codec.get();
        paramPTVConf = new StringBuilder();
        paramPTVConf.append("PTVUpConfigInfo.updateFromSrv: sIsHardCodeEnable = ");
        paramPTVConf.append(sIsHardCodeEnable);
        BdhLogUtil.LogEvent("R", paramPTVConf.toString());
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.PTVUpConfigInfo
 * JD-Core Version:    0.7.0.1
 */