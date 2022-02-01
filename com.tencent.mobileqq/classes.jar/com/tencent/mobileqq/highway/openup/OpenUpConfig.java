package com.tencent.mobileqq.highway.openup;

import android.content.Context;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.OpenUpConf;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class OpenUpConfig
{
  public static boolean isOpenUpEnable = false;
  public static int preSendDots_2g = 2;
  public static int preSendDots_3g = 2;
  public static int preSendDots_4g = 2;
  public static int preSendDots_wifi = 2;
  
  public static int getPreSendDots(Context paramContext)
  {
    try
    {
      int i = preSendDots_2g;
      if (paramContext == null) {
        return i;
      }
      int j = HwNetworkUtil.getSystemNetwork(paramContext);
      if (3 == j) {
        i = preSendDots_3g;
      } else if (4 == j) {
        i = preSendDots_4g;
      } else if (1 == j) {
        i = preSendDots_wifi;
      }
      return i;
    }
    finally {}
  }
  
  public static void updateFromSrv(subcmd0x501.SubCmd0x501Rspbody.OpenUpConf paramOpenUpConf)
  {
    if (paramOpenUpConf == null) {
      return;
    }
    try
    {
      StringBuilder localStringBuilder;
      if (paramOpenUpConf.bool_enable_openup.has())
      {
        isOpenUpEnable = paramOpenUpConf.bool_enable_openup.get();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OpenUpConfig.updateFromSrv: isOpenUpEnable = ");
        localStringBuilder.append(isOpenUpEnable);
        BdhLogUtil.LogEvent("R", localStringBuilder.toString());
      }
      if ((paramOpenUpConf.uint32_pre_send_segnum.has()) && (paramOpenUpConf.uint32_pre_send_segnum.get() >= 0))
      {
        preSendDots_2g = paramOpenUpConf.uint32_pre_send_segnum.get();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OpenUpConfig.updateFromSrv: preSendDots_2g = ");
        localStringBuilder.append(preSendDots_2g);
        BdhLogUtil.LogEvent("R", localStringBuilder.toString());
      }
      if ((paramOpenUpConf.uint32_pre_send_segnum_3g.has()) && (paramOpenUpConf.uint32_pre_send_segnum_3g.get() >= 0))
      {
        preSendDots_3g = paramOpenUpConf.uint32_pre_send_segnum_3g.get();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OpenUpConfig.updateFromSrv: preSendDots_3g = ");
        localStringBuilder.append(preSendDots_3g);
        BdhLogUtil.LogEvent("R", localStringBuilder.toString());
      }
      if ((paramOpenUpConf.uint32_pre_send_segnum_4g.has()) && (paramOpenUpConf.uint32_pre_send_segnum_4g.get() >= 0))
      {
        preSendDots_4g = paramOpenUpConf.uint32_pre_send_segnum_4g.get();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OpenUpConfig.updateFromSrv: preSendDots_4g = ");
        localStringBuilder.append(preSendDots_4g);
        BdhLogUtil.LogEvent("R", localStringBuilder.toString());
      }
      if ((paramOpenUpConf.uint32_pre_send_segnum_wifi.has()) && (paramOpenUpConf.uint32_pre_send_segnum_wifi.get() >= 0))
      {
        preSendDots_wifi = paramOpenUpConf.uint32_pre_send_segnum_wifi.get();
        paramOpenUpConf = new StringBuilder();
        paramOpenUpConf.append("OpenUpConfig.updateFromSrv: preSendDots_wifi = ");
        paramOpenUpConf.append(preSendDots_wifi);
        BdhLogUtil.LogEvent("R", paramOpenUpConf.toString());
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.openup.OpenUpConfig
 * JD-Core Version:    0.7.0.1
 */