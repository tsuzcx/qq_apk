package com.tencent.mobileqq.flashchat;

public final class FlashChatManager$FlashPackCfg
{
  public String a;
  public String b;
  
  /* Error */
  public static FlashPackCfg a(String paramString)
  {
    // Byte code:
    //   0: new 2	com/tencent/mobileqq/flashchat/FlashChatManager$FlashPackCfg
    //   3: dup
    //   4: invokespecial 16	com/tencent/mobileqq/flashchat/FlashChatManager$FlashPackCfg:<init>	()V
    //   7: astore_2
    //   8: new 18	org/json/JSONObject
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 21	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16: astore_0
    //   17: aload_0
    //   18: ldc 23
    //   20: invokevirtual 27	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   23: astore_3
    //   24: aload_2
    //   25: aload_0
    //   26: ldc 29
    //   28: invokevirtual 33	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   31: putfield 35	com/tencent/mobileqq/flashchat/FlashChatManager$FlashPackCfg:a	Ljava/lang/String;
    //   34: aload_3
    //   35: ldc 37
    //   37: invokevirtual 41	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   40: astore_3
    //   41: iconst_0
    //   42: istore_1
    //   43: aload_2
    //   44: astore_0
    //   45: iload_1
    //   46: aload_3
    //   47: invokevirtual 47	org/json/JSONArray:length	()I
    //   50: if_icmpge +30 -> 80
    //   53: aload_2
    //   54: aload_3
    //   55: iload_1
    //   56: invokevirtual 50	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   59: ldc 52
    //   61: invokevirtual 33	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   64: putfield 54	com/tencent/mobileqq/flashchat/FlashChatManager$FlashPackCfg:b	Ljava/lang/String;
    //   67: iload_1
    //   68: iconst_1
    //   69: iadd
    //   70: istore_1
    //   71: goto -28 -> 43
    //   74: astore_0
    //   75: aload_0
    //   76: athrow
    //   77: astore_0
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_0
    //   81: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramString	String
    //   42	29	1	i	int
    //   7	47	2	localFlashPackCfg	FlashPackCfg
    //   23	32	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	41	74	finally
    //   45	67	74	finally
    //   0	41	77	java/lang/Exception
    //   45	67	77	java/lang/Exception
  }
  
  public String toString()
  {
    return "FlashPackCfg{version='" + this.a + '\'' + ", zipScid='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatManager.FlashPackCfg
 * JD-Core Version:    0.7.0.1
 */