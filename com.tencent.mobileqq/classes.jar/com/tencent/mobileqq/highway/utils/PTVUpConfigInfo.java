package com.tencent.mobileqq.highway.utils;

public class PTVUpConfigInfo
{
  public static volatile boolean sIsHardCodeEnable = true;
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
    //   3: getstatic 13	com/tencent/mobileqq/highway/utils/PTVUpConfigInfo:sSwitch	I
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
  public static void updateFromSrc(com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.PTVConf paramPTVConf)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_1
    //   4: putstatic 15	com/tencent/mobileqq/highway/utils/PTVUpConfigInfo:sIsUpdated	Z
    //   7: aload_0
    //   8: ifnonnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: getfield 33	com/tencent/mobileqq/highway/protocol/subcmd0x501$SubCmd0x501Rspbody$PTVConf:uint32_channel_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   19: invokevirtual 38	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   22: ifeq +39 -> 61
    //   25: aload_0
    //   26: getfield 33	com/tencent/mobileqq/highway/protocol/subcmd0x501$SubCmd0x501Rspbody$PTVConf:uint32_channel_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   29: invokevirtual 42	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   32: putstatic 13	com/tencent/mobileqq/highway/utils/PTVUpConfigInfo:sSwitch	I
    //   35: ldc 44
    //   37: new 46	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   44: ldc 49
    //   46: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: getstatic 13	com/tencent/mobileqq/highway/utils/PTVUpConfigInfo:sSwitch	I
    //   52: invokevirtual 56	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 66	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_0
    //   62: getfield 70	com/tencent/mobileqq/highway/protocol/subcmd0x501$SubCmd0x501Rspbody$PTVConf:bool_open_hardware_codec	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   65: invokevirtual 73	com/tencent/mobileqq/pb/PBBoolField:has	()Z
    //   68: ifeq -57 -> 11
    //   71: aload_0
    //   72: getfield 70	com/tencent/mobileqq/highway/protocol/subcmd0x501$SubCmd0x501Rspbody$PTVConf:bool_open_hardware_codec	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   75: invokevirtual 75	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   78: putstatic 17	com/tencent/mobileqq/highway/utils/PTVUpConfigInfo:sIsHardCodeEnable	Z
    //   81: ldc 44
    //   83: new 46	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   90: ldc 77
    //   92: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: getstatic 17	com/tencent/mobileqq/highway/utils/PTVUpConfigInfo:sIsHardCodeEnable	Z
    //   98: invokevirtual 80	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   101: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 66	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: goto -96 -> 11
    //   110: astore_0
    //   111: ldc 2
    //   113: monitorexit
    //   114: aload_0
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramPTVConf	com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.PTVConf
    // Exception table:
    //   from	to	target	type
    //   3	7	110	finally
    //   15	61	110	finally
    //   61	107	110	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.PTVUpConfigInfo
 * JD-Core Version:    0.7.0.1
 */