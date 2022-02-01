package com.tencent.mobileqq.vassplash.model;

public class SplashItem$Builder
{
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString = "";
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i;
  private String j = "-1";
  private String k;
  private String l;
  private String m;
  private String n;
  
  public Builder a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  /* Error */
  public SplashItem a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_a_of_type_Int	I
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
    //   22: new 72	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   29: astore 7
    //   31: aload 7
    //   33: getstatic 76	com/tencent/mobileqq/vassplash/common/VasSplashUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: invokestatic 82	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 7
    //   45: ldc 88
    //   47: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 7
    //   53: aload_0
    //   54: getfield 37	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   57: invokevirtual 94	java/lang/String:hashCode	()I
    //   60: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_0
    //   65: aload 7
    //   67: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: putfield 103	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:i	Ljava/lang/String;
    //   73: new 72	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   80: astore 7
    //   82: aload 7
    //   84: getstatic 76	com/tencent/mobileqq/vassplash/common/VasSplashUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   87: invokestatic 82	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   90: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 7
    //   96: ldc 105
    //   98: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 7
    //   104: aload_0
    //   105: getfield 37	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   108: invokevirtual 94	java/lang/String:hashCode	()I
    //   111: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_0
    //   116: aload 7
    //   118: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: putfield 103	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:i	Ljava/lang/String;
    //   124: goto +54 -> 178
    //   127: new 72	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   134: astore 7
    //   136: aload 7
    //   138: getstatic 76	com/tencent/mobileqq/vassplash/common/VasSplashUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   141: invokestatic 82	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   144: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 7
    //   150: ldc 107
    //   152: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 7
    //   158: aload_0
    //   159: getfield 37	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   162: invokevirtual 94	java/lang/String:hashCode	()I
    //   165: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_0
    //   170: aload 7
    //   172: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: putfield 103	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:i	Ljava/lang/String;
    //   178: aload_0
    //   179: getfield 47	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_a_of_type_Boolean	Z
    //   182: ifeq +8 -> 190
    //   185: aload_0
    //   186: iconst_0
    //   187: putfield 67	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_b_of_type_Boolean	Z
    //   190: aload_0
    //   191: getfield 109	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:n	Ljava/lang/String;
    //   194: astore 7
    //   196: aload_0
    //   197: getfield 29	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   200: astore 8
    //   202: aload_0
    //   203: getfield 31	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   206: astore 9
    //   208: aload_0
    //   209: getfield 33	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   212: astore 10
    //   214: aload_0
    //   215: getfield 35	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_a_of_type_Int	I
    //   218: istore_1
    //   219: aload_0
    //   220: getfield 37	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   223: astore 11
    //   225: aload_0
    //   226: getfield 39	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_b_of_type_Int	I
    //   229: istore_2
    //   230: aload_0
    //   231: getfield 41	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   234: astore 12
    //   236: aload_0
    //   237: getfield 43	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_c_of_type_Int	I
    //   240: istore_3
    //   241: aload_0
    //   242: getfield 45	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:f	Ljava/lang/String;
    //   245: astore 13
    //   247: aload_0
    //   248: getfield 47	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_a_of_type_Boolean	Z
    //   251: istore 4
    //   253: aload_0
    //   254: getfield 55	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_c_of_type_Boolean	Z
    //   257: istore 5
    //   259: aload_0
    //   260: getfield 67	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_b_of_type_Boolean	Z
    //   263: istore 6
    //   265: new 111	com/tencent/mobileqq/vassplash/model/SplashItem
    //   268: dup
    //   269: aload 7
    //   271: aload 8
    //   273: aload 9
    //   275: aload 10
    //   277: iload_1
    //   278: aload 11
    //   280: iload_2
    //   281: aload 12
    //   283: iload_3
    //   284: aload 13
    //   286: iload 4
    //   288: iload 5
    //   290: iload 6
    //   292: aload_0
    //   293: getfield 103	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:i	Ljava/lang/String;
    //   296: aload_0
    //   297: getfield 49	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_d_of_type_Int	I
    //   300: aload_0
    //   301: getfield 51	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:g	Ljava/lang/String;
    //   304: aload_0
    //   305: getfield 53	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:h	Ljava/lang/String;
    //   308: aload_0
    //   309: getfield 63	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:jdField_e_of_type_Int	I
    //   312: aload_0
    //   313: getfield 59	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:j	Ljava/lang/String;
    //   316: invokespecial 114	com/tencent/mobileqq/vassplash/model/SplashItem:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;ZZZLjava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   319: astore 8
    //   321: aload_0
    //   322: getfield 116	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:k	Ljava/lang/String;
    //   325: astore 9
    //   327: aload 8
    //   329: astore 7
    //   331: aload 7
    //   333: aload 9
    //   335: putfield 118	com/tencent/mobileqq/vassplash/model/SplashItem:m	Ljava/lang/String;
    //   338: aload 7
    //   340: aload_0
    //   341: getfield 120	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:l	Ljava/lang/String;
    //   344: putfield 121	com/tencent/mobileqq/vassplash/model/SplashItem:n	Ljava/lang/String;
    //   347: aload 7
    //   349: aload_0
    //   350: getfield 122	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:m	Ljava/lang/String;
    //   353: putfield 125	com/tencent/mobileqq/vassplash/model/SplashItem:o	Ljava/lang/String;
    //   356: aload 7
    //   358: areturn
    //   359: astore 7
    //   361: goto +5 -> 366
    //   364: astore 7
    //   366: goto +13 -> 379
    //   369: astore 7
    //   371: goto +5 -> 376
    //   374: astore 7
    //   376: aconst_null
    //   377: astore 8
    //   379: ldc 127
    //   381: iconst_1
    //   382: aload 7
    //   384: iconst_0
    //   385: anewarray 4	java/lang/Object
    //   388: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   391: aload 8
    //   393: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	Builder
    //   4	274	1	i1	int
    //   229	52	2	i2	int
    //   240	44	3	i3	int
    //   251	36	4	bool1	boolean
    //   257	32	5	bool2	boolean
    //   263	28	6	bool3	boolean
    //   29	328	7	localObject1	Object
    //   359	1	7	localException1	java.lang.Exception
    //   364	1	7	localException2	java.lang.Exception
    //   369	1	7	localException3	java.lang.Exception
    //   374	9	7	localException4	java.lang.Exception
    //   200	192	8	localObject2	Object
    //   206	128	9	str1	String
    //   212	64	10	str2	String
    //   223	56	11	str3	String
    //   234	48	12	str4	String
    //   245	40	13	str5	String
    // Exception table:
    //   from	to	target	type
    //   331	356	359	java/lang/Exception
    //   321	327	364	java/lang/Exception
    //   265	321	369	java/lang/Exception
    //   0	5	374	java/lang/Exception
    //   22	73	374	java/lang/Exception
    //   73	124	374	java/lang/Exception
    //   127	178	374	java/lang/Exception
    //   178	190	374	java/lang/Exception
    //   190	265	374	java/lang/Exception
  }
  
  public Builder b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder d(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public Builder d(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder e(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public Builder e(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder f(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder g(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public Builder h(String paramString)
  {
    this.n = paramString;
    return this;
  }
  
  public Builder i(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public Builder j(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public Builder k(String paramString)
  {
    this.k = paramString;
    return this;
  }
  
  public Builder l(String paramString)
  {
    this.l = paramString;
    return this;
  }
  
  public Builder m(String paramString)
  {
    this.m = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vassplash.model.SplashItem.Builder
 * JD-Core Version:    0.7.0.1
 */