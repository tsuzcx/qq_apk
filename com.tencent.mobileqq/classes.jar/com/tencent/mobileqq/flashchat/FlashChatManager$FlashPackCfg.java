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
    //   7: astore_3
    //   8: new 18	org/json/JSONObject
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 21	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16: astore_0
    //   17: aload_0
    //   18: ldc 23
    //   20: invokevirtual 27	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   23: astore 4
    //   25: aload_3
    //   26: aload_0
    //   27: ldc 29
    //   29: invokevirtual 33	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: putfield 35	com/tencent/mobileqq/flashchat/FlashChatManager$FlashPackCfg:a	Ljava/lang/String;
    //   35: aload 4
    //   37: ldc 37
    //   39: invokevirtual 41	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   42: astore_0
    //   43: iconst_0
    //   44: istore_1
    //   45: iload_1
    //   46: aload_0
    //   47: invokevirtual 47	org/json/JSONArray:length	()I
    //   50: if_icmpge +61 -> 111
    //   53: aload_0
    //   54: iload_1
    //   55: invokevirtual 50	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   58: astore 4
    //   60: aload_3
    //   61: aload 4
    //   63: ldc 52
    //   65: invokevirtual 33	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   68: putfield 54	com/tencent/mobileqq/flashchat/FlashChatManager$FlashPackCfg:b	Ljava/lang/String;
    //   71: aload 4
    //   73: ldc 56
    //   75: invokevirtual 59	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   78: astore 4
    //   80: aload 4
    //   82: ifnull +22 -> 104
    //   85: ldc 61
    //   87: aload 4
    //   89: ldc 63
    //   91: invokevirtual 66	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: istore_2
    //   98: iload_2
    //   99: ifeq +5 -> 104
    //   102: aload_3
    //   103: areturn
    //   104: iload_1
    //   105: iconst_1
    //   106: iadd
    //   107: istore_1
    //   108: goto -63 -> 45
    //   111: aload_3
    //   112: areturn
    //   113: astore_0
    //   114: aload_0
    //   115: athrow
    //   116: aconst_null
    //   117: areturn
    //   118: astore_0
    //   119: goto -3 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramString	String
    //   44	64	1	i	int
    //   97	2	2	bool	boolean
    //   7	105	3	localFlashPackCfg	FlashPackCfg
    //   23	65	4	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	43	113	finally
    //   45	80	113	finally
    //   85	98	113	finally
    //   0	43	118	java/lang/Exception
    //   45	80	118	java/lang/Exception
    //   85	98	118	java/lang/Exception
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FlashPackCfg{version='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", zipScid='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatManager.FlashPackCfg
 * JD-Core Version:    0.7.0.1
 */