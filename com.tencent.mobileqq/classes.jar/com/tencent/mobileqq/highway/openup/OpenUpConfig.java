package com.tencent.mobileqq.highway.openup;

import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.OpenUpConf;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class OpenUpConfig
{
  public static boolean isOpenUpEnable = false;
  public static int preSendDots_2g = 2;
  public static int preSendDots_3g = 2;
  public static int preSendDots_4g = 2;
  public static int preSendDots_wifi = 2;
  
  /* Error */
  public static int getPreSendDots(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 17	com/tencent/mobileqq/highway/openup/OpenUpConfig:preSendDots_2g	I
    //   6: istore_1
    //   7: aload_0
    //   8: ifnonnull +8 -> 16
    //   11: ldc 2
    //   13: monitorexit
    //   14: iload_1
    //   15: ireturn
    //   16: aload_0
    //   17: invokestatic 34	com/tencent/mobileqq/highway/utils/HwNetworkUtil:getSystemNetwork	(Landroid/content/Context;)I
    //   20: istore_2
    //   21: iconst_3
    //   22: iload_2
    //   23: if_icmpne +10 -> 33
    //   26: getstatic 19	com/tencent/mobileqq/highway/openup/OpenUpConfig:preSendDots_3g	I
    //   29: istore_1
    //   30: goto -19 -> 11
    //   33: iconst_4
    //   34: iload_2
    //   35: if_icmpne +10 -> 45
    //   38: getstatic 21	com/tencent/mobileqq/highway/openup/OpenUpConfig:preSendDots_4g	I
    //   41: istore_1
    //   42: goto -31 -> 11
    //   45: iconst_1
    //   46: iload_2
    //   47: if_icmpne -36 -> 11
    //   50: getstatic 23	com/tencent/mobileqq/highway/openup/OpenUpConfig:preSendDots_wifi	I
    //   53: istore_1
    //   54: goto -43 -> 11
    //   57: astore_0
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_0
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramContext	android.content.Context
    //   6	48	1	i	int
    //   20	28	2	j	int
    // Exception table:
    //   from	to	target	type
    //   3	7	57	finally
    //   16	21	57	finally
    //   26	30	57	finally
    //   38	42	57	finally
    //   50	54	57	finally
  }
  
  public static void updateFromSrv(subcmd0x501.SubCmd0x501Rspbody.OpenUpConf paramOpenUpConf)
  {
    if (paramOpenUpConf == null) {}
    for (;;)
    {
      return;
      try
      {
        if (paramOpenUpConf.bool_enable_openup.has())
        {
          isOpenUpEnable = paramOpenUpConf.bool_enable_openup.get();
          BdhLogUtil.LogEvent("R", "OpenUpConfig.updateFromSrv: isOpenUpEnable = " + isOpenUpEnable);
        }
        if ((paramOpenUpConf.uint32_pre_send_segnum.has()) && (paramOpenUpConf.uint32_pre_send_segnum.get() >= 0))
        {
          preSendDots_2g = paramOpenUpConf.uint32_pre_send_segnum.get();
          BdhLogUtil.LogEvent("R", "OpenUpConfig.updateFromSrv: preSendDots_2g = " + preSendDots_2g);
        }
        if ((paramOpenUpConf.uint32_pre_send_segnum_3g.has()) && (paramOpenUpConf.uint32_pre_send_segnum_3g.get() >= 0))
        {
          preSendDots_3g = paramOpenUpConf.uint32_pre_send_segnum_3g.get();
          BdhLogUtil.LogEvent("R", "OpenUpConfig.updateFromSrv: preSendDots_3g = " + preSendDots_3g);
        }
        if ((paramOpenUpConf.uint32_pre_send_segnum_4g.has()) && (paramOpenUpConf.uint32_pre_send_segnum_4g.get() >= 0))
        {
          preSendDots_4g = paramOpenUpConf.uint32_pre_send_segnum_4g.get();
          BdhLogUtil.LogEvent("R", "OpenUpConfig.updateFromSrv: preSendDots_4g = " + preSendDots_4g);
        }
        if ((!paramOpenUpConf.uint32_pre_send_segnum_wifi.has()) || (paramOpenUpConf.uint32_pre_send_segnum_wifi.get() < 0)) {
          continue;
        }
        preSendDots_wifi = paramOpenUpConf.uint32_pre_send_segnum_wifi.get();
        BdhLogUtil.LogEvent("R", "OpenUpConfig.updateFromSrv: preSendDots_wifi = " + preSendDots_wifi);
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.openup.OpenUpConfig
 * JD-Core Version:    0.7.0.1
 */