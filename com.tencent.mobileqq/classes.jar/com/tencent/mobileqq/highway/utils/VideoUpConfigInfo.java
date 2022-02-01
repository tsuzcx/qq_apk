package com.tencent.mobileqq.highway.utils;

public class VideoUpConfigInfo
{
  public static volatile boolean sIsHardCodeEnable = true;
  public static volatile boolean sIsPreSendSignal = false;
  private static volatile boolean sIsUpdated;
  public static int sSwitch = 1;
  
  static
  {
    sIsUpdated = false;
  }
  
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
  
  /* Error */
  public static boolean isPreUpload()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 14	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:sSwitch	I
    //   6: istore_0
    //   7: iload_0
    //   8: iconst_3
    //   9: if_icmpne +10 -> 19
    //   12: iconst_1
    //   13: istore_1
    //   14: ldc 2
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: iconst_0
    //   20: istore_1
    //   21: goto -7 -> 14
    //   24: astore_2
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	4	0	i	int
    //   13	8	1	bool	boolean
    //   24	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	24	finally
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
  
  /* Error */
  public static void updateFromSrc(com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf paramShortVideoConf)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_1
    //   4: putstatic 16	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:sIsUpdated	Z
    //   7: aload_0
    //   8: ifnonnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: getfield 36	com/tencent/mobileqq/highway/protocol/subcmd0x501$SubCmd0x501Rspbody$ShortVideoConf:uint32_channel_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   19: invokevirtual 41	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   22: ifeq +39 -> 61
    //   25: aload_0
    //   26: getfield 36	com/tencent/mobileqq/highway/protocol/subcmd0x501$SubCmd0x501Rspbody$ShortVideoConf:uint32_channel_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   29: invokevirtual 45	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   32: putstatic 14	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:sSwitch	I
    //   35: ldc 47
    //   37: new 49	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   44: ldc 52
    //   46: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: getstatic 14	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:sSwitch	I
    //   52: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 69	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_0
    //   62: getfield 73	com/tencent/mobileqq/highway/protocol/subcmd0x501$SubCmd0x501Rspbody$ShortVideoConf:bool_open_hardware_codec	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   65: invokevirtual 76	com/tencent/mobileqq/pb/PBBoolField:has	()Z
    //   68: ifeq +39 -> 107
    //   71: aload_0
    //   72: getfield 73	com/tencent/mobileqq/highway/protocol/subcmd0x501$SubCmd0x501Rspbody$ShortVideoConf:bool_open_hardware_codec	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   75: invokevirtual 78	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   78: putstatic 18	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:sIsHardCodeEnable	Z
    //   81: ldc 47
    //   83: new 49	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   90: ldc 80
    //   92: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: getstatic 18	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:sIsHardCodeEnable	Z
    //   98: invokevirtual 83	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   101: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 69	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: getfield 86	com/tencent/mobileqq/highway/protocol/subcmd0x501$SubCmd0x501Rspbody$ShortVideoConf:bool_send_ahead_signal	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   111: invokevirtual 76	com/tencent/mobileqq/pb/PBBoolField:has	()Z
    //   114: ifeq -103 -> 11
    //   117: aload_0
    //   118: getfield 86	com/tencent/mobileqq/highway/protocol/subcmd0x501$SubCmd0x501Rspbody$ShortVideoConf:bool_send_ahead_signal	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   121: invokevirtual 78	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   124: putstatic 20	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:sIsPreSendSignal	Z
    //   127: ldc 47
    //   129: new 49	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   136: ldc 88
    //   138: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: getstatic 20	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:sIsPreSendSignal	Z
    //   144: invokevirtual 83	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   147: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 69	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: goto -142 -> 11
    //   156: astore_0
    //   157: ldc 2
    //   159: monitorexit
    //   160: aload_0
    //   161: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramShortVideoConf	com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf
    // Exception table:
    //   from	to	target	type
    //   3	7	156	finally
    //   15	61	156	finally
    //   61	107	156	finally
    //   107	153	156	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.VideoUpConfigInfo
 * JD-Core Version:    0.7.0.1
 */