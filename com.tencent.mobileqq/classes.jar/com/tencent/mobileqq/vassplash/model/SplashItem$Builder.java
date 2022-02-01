package com.tencent.mobileqq.vassplash.model;

public class SplashItem$Builder
{
  public int a;
  public String b;
  public String c;
  private String d = "";
  private String e = "";
  private String f = "";
  private int g = -1;
  private String h = "";
  private int i = -1;
  private String j = "";
  private int k = 0;
  private String l = "";
  private boolean m = false;
  private int n = 0;
  private String o = "";
  private String p = "";
  private int q;
  private boolean r;
  private String s;
  private boolean t = false;
  private String u = "-1";
  private String v;
  private String w;
  private String x;
  private String y;
  
  public Builder a(int paramInt)
  {
    this.q = paramInt;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.u = paramString;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.r = paramBoolean;
    return this;
  }
  
  /* Error */
  public SplashItem a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:g	I
    //   4: istore_1
    //   5: iload_1
    //   6: ifeq +121 -> 127
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmpeq +11 -> 22
    //   14: iload_1
    //   15: iconst_2
    //   16: if_icmpeq +57 -> 73
    //   19: goto +159 -> 178
    //   22: new 83	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   29: astore 7
    //   31: aload 7
    //   33: getstatic 88	com/tencent/mobileqq/vassplash/common/VasSplashUtil:a	Ljava/lang/String;
    //   36: invokestatic 94	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 7
    //   45: ldc 100
    //   47: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 7
    //   53: aload_0
    //   54: getfield 48	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:h	Ljava/lang/String;
    //   57: invokevirtual 106	java/lang/String:hashCode	()I
    //   60: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_0
    //   65: aload 7
    //   67: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: putfield 115	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:s	Ljava/lang/String;
    //   73: new 83	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   80: astore 7
    //   82: aload 7
    //   84: getstatic 88	com/tencent/mobileqq/vassplash/common/VasSplashUtil:a	Ljava/lang/String;
    //   87: invokestatic 94	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   90: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 7
    //   96: ldc 117
    //   98: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 7
    //   104: aload_0
    //   105: getfield 48	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:h	Ljava/lang/String;
    //   108: invokevirtual 106	java/lang/String:hashCode	()I
    //   111: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_0
    //   116: aload 7
    //   118: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: putfield 115	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:s	Ljava/lang/String;
    //   124: goto +54 -> 178
    //   127: new 83	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   134: astore 7
    //   136: aload 7
    //   138: getstatic 88	com/tencent/mobileqq/vassplash/common/VasSplashUtil:a	Ljava/lang/String;
    //   141: invokestatic 94	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   144: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 7
    //   150: ldc 119
    //   152: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 7
    //   158: aload_0
    //   159: getfield 48	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:h	Ljava/lang/String;
    //   162: invokevirtual 106	java/lang/String:hashCode	()I
    //   165: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_0
    //   170: aload 7
    //   172: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: putfield 115	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:s	Ljava/lang/String;
    //   178: aload_0
    //   179: getfield 121	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:a	I
    //   182: iconst_1
    //   183: if_icmpeq +11 -> 194
    //   186: aload_0
    //   187: getfield 121	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:a	I
    //   190: iconst_2
    //   191: if_icmpne +54 -> 245
    //   194: new 83	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   201: astore 7
    //   203: aload 7
    //   205: getstatic 88	com/tencent/mobileqq/vassplash/common/VasSplashUtil:a	Ljava/lang/String;
    //   208: invokestatic 94	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   211: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 7
    //   217: ldc 119
    //   219: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 7
    //   225: aload_0
    //   226: getfield 123	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:b	Ljava/lang/String;
    //   229: invokevirtual 106	java/lang/String:hashCode	()I
    //   232: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_0
    //   237: aload 7
    //   239: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: putfield 125	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:c	Ljava/lang/String;
    //   245: aload_0
    //   246: getfield 58	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:m	Z
    //   249: ifeq +8 -> 257
    //   252: aload_0
    //   253: iconst_0
    //   254: putfield 78	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:r	Z
    //   257: aload_0
    //   258: getfield 127	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:y	Ljava/lang/String;
    //   261: astore 7
    //   263: aload_0
    //   264: getfield 40	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:d	Ljava/lang/String;
    //   267: astore 8
    //   269: aload_0
    //   270: getfield 42	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:e	Ljava/lang/String;
    //   273: astore 9
    //   275: aload_0
    //   276: getfield 44	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:f	Ljava/lang/String;
    //   279: astore 10
    //   281: aload_0
    //   282: getfield 46	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:g	I
    //   285: istore_1
    //   286: aload_0
    //   287: getfield 48	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:h	Ljava/lang/String;
    //   290: astore 11
    //   292: aload_0
    //   293: getfield 50	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:i	I
    //   296: istore_2
    //   297: aload_0
    //   298: getfield 52	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:j	Ljava/lang/String;
    //   301: astore 12
    //   303: aload_0
    //   304: getfield 54	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:k	I
    //   307: istore_3
    //   308: aload_0
    //   309: getfield 56	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:l	Ljava/lang/String;
    //   312: astore 13
    //   314: aload_0
    //   315: getfield 58	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:m	Z
    //   318: istore 4
    //   320: aload_0
    //   321: getfield 66	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:t	Z
    //   324: istore 5
    //   326: aload_0
    //   327: getfield 78	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:r	Z
    //   330: istore 6
    //   332: new 129	com/tencent/mobileqq/vassplash/model/SplashItem
    //   335: dup
    //   336: aload 7
    //   338: aload 8
    //   340: aload 9
    //   342: aload 10
    //   344: iload_1
    //   345: aload 11
    //   347: iload_2
    //   348: aload 12
    //   350: iload_3
    //   351: aload 13
    //   353: iload 4
    //   355: iload 5
    //   357: iload 6
    //   359: aload_0
    //   360: getfield 115	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:s	Ljava/lang/String;
    //   363: aload_0
    //   364: getfield 60	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:n	I
    //   367: aload_0
    //   368: getfield 62	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:o	Ljava/lang/String;
    //   371: aload_0
    //   372: getfield 64	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:p	Ljava/lang/String;
    //   375: aload_0
    //   376: getfield 74	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:q	I
    //   379: aload_0
    //   380: getfield 70	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:u	Ljava/lang/String;
    //   383: invokespecial 132	com/tencent/mobileqq/vassplash/model/SplashItem:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;ZZZLjava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   386: astore 8
    //   388: aload_0
    //   389: getfield 134	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:v	Ljava/lang/String;
    //   392: astore 9
    //   394: aload 8
    //   396: astore 7
    //   398: aload 7
    //   400: aload 9
    //   402: putfield 136	com/tencent/mobileqq/vassplash/model/SplashItem:t	Ljava/lang/String;
    //   405: aload 7
    //   407: aload_0
    //   408: getfield 138	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:w	Ljava/lang/String;
    //   411: putfield 139	com/tencent/mobileqq/vassplash/model/SplashItem:u	Ljava/lang/String;
    //   414: aload 7
    //   416: aload_0
    //   417: getfield 141	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:x	Ljava/lang/String;
    //   420: putfield 142	com/tencent/mobileqq/vassplash/model/SplashItem:v	Ljava/lang/String;
    //   423: aload 7
    //   425: aload_0
    //   426: getfield 121	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:a	I
    //   429: putfield 144	com/tencent/mobileqq/vassplash/model/SplashItem:w	I
    //   432: aload 7
    //   434: aload_0
    //   435: getfield 123	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:b	Ljava/lang/String;
    //   438: putfield 145	com/tencent/mobileqq/vassplash/model/SplashItem:x	Ljava/lang/String;
    //   441: aload 7
    //   443: aload_0
    //   444: getfield 125	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:c	Ljava/lang/String;
    //   447: putfield 146	com/tencent/mobileqq/vassplash/model/SplashItem:y	Ljava/lang/String;
    //   450: aload 7
    //   452: areturn
    //   453: astore 7
    //   455: goto +5 -> 460
    //   458: astore 7
    //   460: goto +13 -> 473
    //   463: astore 7
    //   465: goto +5 -> 470
    //   468: astore 7
    //   470: aconst_null
    //   471: astore 8
    //   473: ldc 148
    //   475: iconst_1
    //   476: aload 7
    //   478: iconst_0
    //   479: anewarray 4	java/lang/Object
    //   482: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   485: aload 8
    //   487: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	this	Builder
    //   4	341	1	i1	int
    //   296	52	2	i2	int
    //   307	44	3	i3	int
    //   318	36	4	bool1	boolean
    //   324	32	5	bool2	boolean
    //   330	28	6	bool3	boolean
    //   29	422	7	localObject1	Object
    //   453	1	7	localException1	java.lang.Exception
    //   458	1	7	localException2	java.lang.Exception
    //   463	1	7	localException3	java.lang.Exception
    //   468	9	7	localException4	java.lang.Exception
    //   267	219	8	localObject2	Object
    //   273	128	9	str1	String
    //   279	64	10	str2	String
    //   290	56	11	str3	String
    //   301	48	12	str4	String
    //   312	40	13	str5	String
    // Exception table:
    //   from	to	target	type
    //   398	450	453	java/lang/Exception
    //   388	394	458	java/lang/Exception
    //   332	388	463	java/lang/Exception
    //   0	5	468	java/lang/Exception
    //   22	73	468	java/lang/Exception
    //   73	124	468	java/lang/Exception
    //   127	178	468	java/lang/Exception
    //   178	194	468	java/lang/Exception
    //   194	245	468	java/lang/Exception
    //   245	257	468	java/lang/Exception
    //   257	332	468	java/lang/Exception
  }
  
  public Builder b(int paramInt)
  {
    this.n = paramInt;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public Builder b(boolean paramBoolean)
  {
    this.m = paramBoolean;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public Builder d(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
  
  public Builder d(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public Builder e(int paramInt)
  {
    this.k = paramInt;
    return this;
  }
  
  public Builder e(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public Builder f(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public Builder f(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public Builder g(String paramString)
  {
    this.l = paramString;
    return this;
  }
  
  public Builder h(String paramString)
  {
    this.y = paramString;
    return this;
  }
  
  public Builder i(String paramString)
  {
    this.o = paramString;
    return this;
  }
  
  public Builder j(String paramString)
  {
    this.p = paramString;
    return this;
  }
  
  public Builder k(String paramString)
  {
    this.v = paramString;
    return this;
  }
  
  public Builder l(String paramString)
  {
    this.w = paramString;
    return this;
  }
  
  public Builder m(String paramString)
  {
    this.x = paramString;
    return this;
  }
  
  public Builder n(String paramString)
  {
    this.b = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vassplash.model.SplashItem.Builder
 * JD-Core Version:    0.7.0.1
 */