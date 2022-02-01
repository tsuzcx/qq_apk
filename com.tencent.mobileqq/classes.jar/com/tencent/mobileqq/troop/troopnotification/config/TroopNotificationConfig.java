package com.tencent.mobileqq.troop.troopnotification.config;

public class TroopNotificationConfig
{
  public boolean a;
  public int b;
  public long c;
  public int d;
  public int e;
  public long f;
  public int g;
  public int h;
  
  public TroopNotificationConfig()
  {
    a();
  }
  
  /* Error */
  public static TroopNotificationConfig a(String paramString)
  {
    // Byte code:
    //   0: new 27	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   7: astore 14
    //   9: aload 14
    //   11: ldc 30
    //   13: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 14
    //   19: aload_0
    //   20: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: ldc 36
    //   26: iconst_1
    //   27: aload 14
    //   29: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 45	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifeq +5 -> 44
    //   42: aconst_null
    //   43: areturn
    //   44: lconst_0
    //   45: lstore 9
    //   47: iconst_0
    //   48: istore 13
    //   50: new 53	org/json/JSONObject
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 56	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   58: astore_0
    //   59: aload_0
    //   60: ldc 58
    //   62: iconst_0
    //   63: invokevirtual 62	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   66: istore_1
    //   67: aload_0
    //   68: ldc 64
    //   70: iconst_0
    //   71: invokevirtual 62	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   74: istore_2
    //   75: aload_0
    //   76: ldc 66
    //   78: lconst_0
    //   79: invokevirtual 70	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   82: lstore 7
    //   84: aload_0
    //   85: ldc 72
    //   87: invokevirtual 75	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   90: istore_3
    //   91: aload_0
    //   92: ldc 77
    //   94: iconst_0
    //   95: invokevirtual 62	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   98: istore 4
    //   100: lload 9
    //   102: lstore 11
    //   104: aload_0
    //   105: ldc 79
    //   107: lconst_0
    //   108: invokevirtual 70	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   111: lstore 9
    //   113: lload 9
    //   115: lstore 11
    //   117: aload_0
    //   118: ldc 81
    //   120: sipush 300
    //   123: invokevirtual 62	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   126: istore 5
    //   128: aload_0
    //   129: ldc 83
    //   131: iconst_0
    //   132: invokevirtual 62	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   135: istore 6
    //   137: goto +57 -> 194
    //   140: astore_0
    //   141: goto +46 -> 187
    //   144: astore_0
    //   145: lload 11
    //   147: lstore 9
    //   149: goto +35 -> 184
    //   152: astore_0
    //   153: goto +28 -> 181
    //   156: astore_0
    //   157: goto +22 -> 179
    //   160: astore_0
    //   161: lconst_0
    //   162: lstore 7
    //   164: goto +15 -> 179
    //   167: astore_0
    //   168: goto +6 -> 174
    //   171: astore_0
    //   172: iconst_0
    //   173: istore_1
    //   174: lconst_0
    //   175: lstore 7
    //   177: iconst_0
    //   178: istore_2
    //   179: iconst_0
    //   180: istore_3
    //   181: iconst_0
    //   182: istore 4
    //   184: iconst_0
    //   185: istore 5
    //   187: aload_0
    //   188: invokevirtual 86	org/json/JSONException:printStackTrace	()V
    //   191: iconst_0
    //   192: istore 6
    //   194: new 2	com/tencent/mobileqq/troop/troopnotification/config/TroopNotificationConfig
    //   197: dup
    //   198: invokespecial 87	com/tencent/mobileqq/troop/troopnotification/config/TroopNotificationConfig:<init>	()V
    //   201: astore_0
    //   202: iload_1
    //   203: iconst_1
    //   204: if_icmpne +6 -> 210
    //   207: iconst_1
    //   208: istore 13
    //   210: aload_0
    //   211: iload 13
    //   213: putfield 89	com/tencent/mobileqq/troop/troopnotification/config/TroopNotificationConfig:a	Z
    //   216: aload_0
    //   217: iload_2
    //   218: putfield 91	com/tencent/mobileqq/troop/troopnotification/config/TroopNotificationConfig:b	I
    //   221: aload_0
    //   222: lload 7
    //   224: putfield 93	com/tencent/mobileqq/troop/troopnotification/config/TroopNotificationConfig:c	J
    //   227: aload_0
    //   228: iload_3
    //   229: putfield 95	com/tencent/mobileqq/troop/troopnotification/config/TroopNotificationConfig:d	I
    //   232: aload_0
    //   233: iload 4
    //   235: putfield 97	com/tencent/mobileqq/troop/troopnotification/config/TroopNotificationConfig:e	I
    //   238: aload_0
    //   239: lload 9
    //   241: putfield 99	com/tencent/mobileqq/troop/troopnotification/config/TroopNotificationConfig:f	J
    //   244: aload_0
    //   245: iload 5
    //   247: putfield 101	com/tencent/mobileqq/troop/troopnotification/config/TroopNotificationConfig:g	I
    //   250: aload_0
    //   251: iload 6
    //   253: putfield 103	com/tencent/mobileqq/troop/troopnotification/config/TroopNotificationConfig:h	I
    //   256: aload_0
    //   257: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	paramString	String
    //   66	139	1	i	int
    //   74	144	2	j	int
    //   90	139	3	k	int
    //   98	136	4	m	int
    //   126	120	5	n	int
    //   135	117	6	i1	int
    //   82	141	7	l1	long
    //   45	195	9	l2	long
    //   102	44	11	l3	long
    //   48	164	13	bool	boolean
    //   7	21	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   128	137	140	org/json/JSONException
    //   104	113	144	org/json/JSONException
    //   117	128	144	org/json/JSONException
    //   91	100	152	org/json/JSONException
    //   84	91	156	org/json/JSONException
    //   75	84	160	org/json/JSONException
    //   67	75	167	org/json/JSONException
    //   50	67	171	org/json/JSONException
  }
  
  private void a()
  {
    this.a = true;
    this.b = 100;
    this.c = 60L;
    this.d = 100;
    this.e = 10;
    this.f = 1209600L;
    this.g = 300;
    this.h = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopNotificationConfig{isGlobalOpen=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", totalRemindCntOfOneWeak=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", intervelShowTime=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", totalRemindCntOfOneDay=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", todoGroupVerifyMsgLevel=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", cleanExpiredTime=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", maxFetchMsgCnt=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", showUnreadBk=");
    localStringBuilder.append(this.h);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationConfig
 * JD-Core Version:    0.7.0.1
 */