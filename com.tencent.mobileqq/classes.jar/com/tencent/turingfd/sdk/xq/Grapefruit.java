package com.tencent.turingfd.sdk.xq;

import android.content.Context;

public class Grapefruit
  implements Fig
{
  public void i(Context paramContext) {}
  
  /* Error */
  public Foxnut j(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 23	com/tencent/turingfd/sdk/xq/final:hf	[I
    //   3: invokestatic 27	com/tencent/turingfd/sdk/xq/final:get	([I)Ljava/lang/String;
    //   6: invokestatic 33	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   9: astore 4
    //   11: getstatic 36	com/tencent/turingfd/sdk/xq/final:Od	[I
    //   14: invokestatic 27	com/tencent/turingfd/sdk/xq/final:get	([I)Ljava/lang/String;
    //   17: astore 5
    //   19: getstatic 42	android/os/Build$VERSION:SDK_INT	I
    //   22: istore_2
    //   23: aconst_null
    //   24: astore_3
    //   25: iload_2
    //   26: bipush 17
    //   28: if_icmplt +115 -> 143
    //   31: aload_1
    //   32: invokevirtual 48	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   35: aload 4
    //   37: invokevirtual 54	android/content/ContentResolver:acquireContentProviderClient	(Landroid/net/Uri;)Landroid/content/ContentProviderClient;
    //   40: astore 4
    //   42: aload 4
    //   44: aload 5
    //   46: aconst_null
    //   47: aconst_null
    //   48: invokevirtual 60	android/content/ContentProviderClient:call	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   51: astore_1
    //   52: getstatic 42	android/os/Build$VERSION:SDK_INT	I
    //   55: bipush 24
    //   57: if_icmplt +11 -> 68
    //   60: aload 4
    //   62: invokevirtual 63	android/content/ContentProviderClient:close	()V
    //   65: goto +92 -> 157
    //   68: aload 4
    //   70: invokevirtual 67	android/content/ContentProviderClient:release	()Z
    //   73: pop
    //   74: goto +83 -> 157
    //   77: astore_1
    //   78: aload 4
    //   80: ifnull +25 -> 105
    //   83: getstatic 42	android/os/Build$VERSION:SDK_INT	I
    //   86: bipush 24
    //   88: if_icmplt +11 -> 99
    //   91: aload 4
    //   93: invokevirtual 63	android/content/ContentProviderClient:close	()V
    //   96: goto +9 -> 105
    //   99: aload 4
    //   101: invokevirtual 67	android/content/ContentProviderClient:release	()Z
    //   104: pop
    //   105: aload_1
    //   106: athrow
    //   107: aload_3
    //   108: astore_1
    //   109: aload 4
    //   111: ifnull +46 -> 157
    //   114: getstatic 42	android/os/Build$VERSION:SDK_INT	I
    //   117: bipush 24
    //   119: if_icmplt +13 -> 132
    //   122: aload 4
    //   124: invokevirtual 63	android/content/ContentProviderClient:close	()V
    //   127: aload_3
    //   128: astore_1
    //   129: goto +28 -> 157
    //   132: aload 4
    //   134: invokevirtual 67	android/content/ContentProviderClient:release	()Z
    //   137: pop
    //   138: aload_3
    //   139: astore_1
    //   140: goto +17 -> 157
    //   143: aload_1
    //   144: invokevirtual 48	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   147: aload 4
    //   149: aload 5
    //   151: aconst_null
    //   152: aconst_null
    //   153: invokevirtual 70	android/content/ContentResolver:call	(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   156: astore_1
    //   157: aload_1
    //   158: ifnonnull +8 -> 166
    //   161: iconst_m1
    //   162: invokestatic 76	com/tencent/turingfd/sdk/xq/Foxnut:a	(I)Lcom/tencent/turingfd/sdk/xq/Foxnut;
    //   165: areturn
    //   166: aload_1
    //   167: getstatic 79	com/tencent/turingfd/sdk/xq/final:if	[I
    //   170: invokestatic 27	com/tencent/turingfd/sdk/xq/final:get	([I)Ljava/lang/String;
    //   173: iconst_m1
    //   174: invokevirtual 85	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   177: ifeq +9 -> 186
    //   180: bipush 254
    //   182: invokestatic 76	com/tencent/turingfd/sdk/xq/Foxnut:a	(I)Lcom/tencent/turingfd/sdk/xq/Foxnut;
    //   185: areturn
    //   186: new 72	com/tencent/turingfd/sdk/xq/Foxnut
    //   189: dup
    //   190: aload_1
    //   191: getstatic 88	com/tencent/turingfd/sdk/xq/final:ID	[I
    //   194: invokestatic 27	com/tencent/turingfd/sdk/xq/final:get	([I)Ljava/lang/String;
    //   197: invokevirtual 92	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   200: iconst_0
    //   201: invokespecial 95	com/tencent/turingfd/sdk/xq/Foxnut:<init>	(Ljava/lang/String;I)V
    //   204: areturn
    //   205: astore_1
    //   206: goto -99 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	Grapefruit
    //   0	209	1	paramContext	Context
    //   22	7	2	i	int
    //   24	115	3	localObject1	Object
    //   9	139	4	localObject2	Object
    //   17	133	5	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   42	52	77	finally
    //   42	52	205	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Grapefruit
 * JD-Core Version:    0.7.0.1
 */