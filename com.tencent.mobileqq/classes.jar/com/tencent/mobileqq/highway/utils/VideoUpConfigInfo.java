package com.tencent.mobileqq.highway.utils;

import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class VideoUpConfigInfo
{
  public static volatile boolean sIsHardCodeEnable = true;
  public static volatile boolean sIsPreSendSignal = false;
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
  
  public static void updateFromSrc(subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf paramShortVideoConf)
  {
    try
    {
      sIsUpdated = true;
      if (paramShortVideoConf == null) {
        return;
      }
      StringBuilder localStringBuilder;
      if (paramShortVideoConf.uint32_channel_type.has())
      {
        sSwitch = paramShortVideoConf.uint32_channel_type.get();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoUpConfigInfo.updateFromSrv: sSwitch = ");
        localStringBuilder.append(sSwitch);
        BdhLogUtil.LogEvent("R", localStringBuilder.toString());
      }
      if (paramShortVideoConf.bool_open_hardware_codec.has())
      {
        sIsHardCodeEnable = paramShortVideoConf.bool_open_hardware_codec.get();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoUpConfigInfo.updateFromSrv: sIsHardCodeEnable = ");
        localStringBuilder.append(sIsHardCodeEnable);
        BdhLogUtil.LogEvent("R", localStringBuilder.toString());
      }
      if (paramShortVideoConf.bool_send_ahead_signal.has())
      {
        sIsPreSendSignal = paramShortVideoConf.bool_send_ahead_signal.get();
        paramShortVideoConf = new StringBuilder();
        paramShortVideoConf.append("VideoUpConfigInfo.updateFromSrv: sIsPreSendSignal = ");
        paramShortVideoConf.append(sIsPreSendSignal);
        BdhLogUtil.LogEvent("R", paramShortVideoConf.toString());
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.VideoUpConfigInfo
 * JD-Core Version:    0.7.0.1
 */