package cooperation.qzone.UndealCount;

import android.content.ContentValues;
import java.util.ArrayList;

public class QZoneCountInfo
{
  public String actPageAttach = "";
  public long cTime = 0L;
  public int countId;
  public boolean existDL;
  public ArrayList<QZoneCountUserInfo> friendList;
  public String friendMsg;
  public ArrayList<Long> friendUinList;
  public boolean hasShow = false;
  public int iControl = 0;
  public int iShowLevel = 0;
  public String iconUrl;
  public String pushMesssage = "";
  public String reportValue;
  public String schema = "";
  public String strShowMsg;
  public int totalFriendUnread;
  public String trace_info;
  public long uCount = 0L;
  
  public QZoneCountInfo()
  {
    this(0, 0, new ArrayList(), "", "");
  }
  
  public QZoneCountInfo(int paramInt1, int paramInt2, ArrayList<QZoneCountUserInfo> paramArrayList, String paramString1, String paramString2)
  {
    this.uCount = paramInt1;
    this.iControl = paramInt2;
    this.friendList = paramArrayList;
    this.friendMsg = paramString1;
    this.totalFriendUnread = 0;
    this.trace_info = paramString2;
  }
  
  public QZoneCountInfo(QZoneCountInfo paramQZoneCountInfo)
  {
    this.uCount = paramQZoneCountInfo.uCount;
    this.iControl = paramQZoneCountInfo.iControl;
    this.friendList = new ArrayList();
    ArrayList localArrayList = paramQZoneCountInfo.friendList;
    if (localArrayList != null) {
      this.friendList.addAll(localArrayList);
    }
    this.friendMsg = paramQZoneCountInfo.friendMsg;
    this.totalFriendUnread = 0;
    this.pushMesssage = paramQZoneCountInfo.pushMesssage;
    this.schema = paramQZoneCountInfo.schema;
    this.trace_info = paramQZoneCountInfo.trace_info;
    this.iconUrl = paramQZoneCountInfo.iconUrl;
    this.countId = paramQZoneCountInfo.countId;
    this.actPageAttach = paramQZoneCountInfo.actPageAttach;
    this.strShowMsg = paramQZoneCountInfo.strShowMsg;
    this.reportValue = paramQZoneCountInfo.reportValue;
    this.cTime = paramQZoneCountInfo.cTime;
    this.iShowLevel = paramQZoneCountInfo.iShowLevel;
    this.hasShow = paramQZoneCountInfo.hasShow;
  }
  
  /* Error */
  public static java.util.HashMap<java.lang.Integer, QZoneCountInfo> createFromCursor(android.database.Cursor paramCursor)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +553 -> 554
    //   4: aload_0
    //   5: invokeinterface 91 1 0
    //   10: ifeq +6 -> 16
    //   13: goto +541 -> 554
    //   16: new 93	java/util/HashMap
    //   19: dup
    //   20: invokespecial 94	java/util/HashMap:<init>	()V
    //   23: astore 7
    //   25: aload_0
    //   26: invokeinterface 97 1 0
    //   31: ifeq +520 -> 551
    //   34: new 2	cooperation/qzone/UndealCount/QZoneCountInfo
    //   37: dup
    //   38: invokespecial 98	cooperation/qzone/UndealCount/QZoneCountInfo:<init>	()V
    //   41: astore 8
    //   43: aload_0
    //   44: aload_0
    //   45: ldc 100
    //   47: invokeinterface 104 2 0
    //   52: invokeinterface 108 2 0
    //   57: istore_2
    //   58: aload 8
    //   60: aload_0
    //   61: aload_0
    //   62: ldc 110
    //   64: invokeinterface 104 2 0
    //   69: invokeinterface 108 2 0
    //   74: putfield 46	cooperation/qzone/UndealCount/QZoneCountInfo:iControl	I
    //   77: aload 8
    //   79: aload_0
    //   80: aload_0
    //   81: ldc 111
    //   83: invokeinterface 104 2 0
    //   88: invokeinterface 115 2 0
    //   93: putfield 62	cooperation/qzone/UndealCount/QZoneCountInfo:friendMsg	Ljava/lang/String;
    //   96: aload 8
    //   98: aload_0
    //   99: aload_0
    //   100: ldc 117
    //   102: invokeinterface 104 2 0
    //   107: invokeinterface 108 2 0
    //   112: i2l
    //   113: putfield 44	cooperation/qzone/UndealCount/QZoneCountInfo:uCount	J
    //   116: aload 8
    //   118: aload_0
    //   119: aload_0
    //   120: ldc 118
    //   122: invokeinterface 104 2 0
    //   127: invokeinterface 115 2 0
    //   132: putfield 66	cooperation/qzone/UndealCount/QZoneCountInfo:trace_info	Ljava/lang/String;
    //   135: aload 8
    //   137: aload_0
    //   138: aload_0
    //   139: ldc 120
    //   141: invokeinterface 104 2 0
    //   146: invokeinterface 108 2 0
    //   151: putfield 64	cooperation/qzone/UndealCount/QZoneCountInfo:totalFriendUnread	I
    //   154: aload 8
    //   156: new 33	java/util/ArrayList
    //   159: dup
    //   160: invokespecial 35	java/util/ArrayList:<init>	()V
    //   163: putfield 60	cooperation/qzone/UndealCount/QZoneCountInfo:friendList	Ljava/util/ArrayList;
    //   166: aload_0
    //   167: aload_0
    //   168: ldc 122
    //   170: invokeinterface 104 2 0
    //   175: invokeinterface 126 2 0
    //   180: astore 9
    //   182: iconst_0
    //   183: istore 5
    //   185: aload 9
    //   187: ifnull +112 -> 299
    //   190: aload 9
    //   192: arraylength
    //   193: ifeq +106 -> 299
    //   196: invokestatic 132	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   199: astore 6
    //   201: aload 6
    //   203: aload 9
    //   205: iconst_0
    //   206: aload 9
    //   208: arraylength
    //   209: invokevirtual 136	android/os/Parcel:unmarshall	([BII)V
    //   212: aload 6
    //   214: iconst_0
    //   215: invokevirtual 140	android/os/Parcel:setDataPosition	(I)V
    //   218: aload 6
    //   220: ldc 142
    //   222: invokevirtual 148	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   225: invokevirtual 152	android/os/Parcel:readParcelableArray	(Ljava/lang/ClassLoader;)[Landroid/os/Parcelable;
    //   228: astore 9
    //   230: aload 9
    //   232: ifnull +52 -> 284
    //   235: aload 9
    //   237: arraylength
    //   238: istore_3
    //   239: iconst_0
    //   240: istore_1
    //   241: iload_1
    //   242: iload_3
    //   243: if_icmpge +41 -> 284
    //   246: aload 9
    //   248: iload_1
    //   249: aaload
    //   250: astore 10
    //   252: aload 8
    //   254: getfield 60	cooperation/qzone/UndealCount/QZoneCountInfo:friendList	Ljava/util/ArrayList;
    //   257: aload 10
    //   259: checkcast 142	cooperation/qzone/UndealCount/QZoneCountUserInfo
    //   262: invokevirtual 156	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   265: pop
    //   266: iload_1
    //   267: iconst_1
    //   268: iadd
    //   269: istore_1
    //   270: goto -29 -> 241
    //   273: astore_0
    //   274: goto +18 -> 292
    //   277: astore 9
    //   279: aload 9
    //   281: invokevirtual 159	java/lang/Throwable:printStackTrace	()V
    //   284: aload 6
    //   286: invokevirtual 162	android/os/Parcel:recycle	()V
    //   289: goto +10 -> 299
    //   292: aload 6
    //   294: invokevirtual 162	android/os/Parcel:recycle	()V
    //   297: aload_0
    //   298: athrow
    //   299: aload_0
    //   300: aload_0
    //   301: ldc 163
    //   303: invokeinterface 104 2 0
    //   308: invokeinterface 108 2 0
    //   313: iconst_1
    //   314: if_icmpne +9 -> 323
    //   317: iconst_1
    //   318: istore 4
    //   320: goto +6 -> 326
    //   323: iconst_0
    //   324: istore 4
    //   326: aload 8
    //   328: iload 4
    //   330: putfield 165	cooperation/qzone/UndealCount/QZoneCountInfo:existDL	Z
    //   333: aload 8
    //   335: aload_0
    //   336: aload_0
    //   337: ldc 167
    //   339: invokeinterface 104 2 0
    //   344: invokeinterface 115 2 0
    //   349: putfield 50	cooperation/qzone/UndealCount/QZoneCountInfo:pushMesssage	Ljava/lang/String;
    //   352: aload 8
    //   354: aload_0
    //   355: aload_0
    //   356: ldc 168
    //   358: invokeinterface 104 2 0
    //   363: invokeinterface 115 2 0
    //   368: putfield 48	cooperation/qzone/UndealCount/QZoneCountInfo:schema	Ljava/lang/String;
    //   371: aload 8
    //   373: aload_0
    //   374: aload_0
    //   375: ldc 169
    //   377: invokeinterface 104 2 0
    //   382: invokeinterface 115 2 0
    //   387: putfield 75	cooperation/qzone/UndealCount/QZoneCountInfo:iconUrl	Ljava/lang/String;
    //   390: aload 8
    //   392: aload_0
    //   393: aload_0
    //   394: ldc 170
    //   396: invokeinterface 104 2 0
    //   401: invokeinterface 115 2 0
    //   406: putfield 81	cooperation/qzone/UndealCount/QZoneCountInfo:reportValue	Ljava/lang/String;
    //   409: aload 8
    //   411: aload_0
    //   412: aload_0
    //   413: ldc 172
    //   415: invokeinterface 104 2 0
    //   420: invokeinterface 115 2 0
    //   425: putfield 79	cooperation/qzone/UndealCount/QZoneCountInfo:strShowMsg	Ljava/lang/String;
    //   428: aload 8
    //   430: aload_0
    //   431: aload_0
    //   432: ldc 174
    //   434: invokeinterface 104 2 0
    //   439: invokeinterface 108 2 0
    //   444: putfield 77	cooperation/qzone/UndealCount/QZoneCountInfo:countId	I
    //   447: aload 8
    //   449: aload_0
    //   450: aload_0
    //   451: ldc 175
    //   453: invokeinterface 104 2 0
    //   458: invokeinterface 179 2 0
    //   463: putfield 52	cooperation/qzone/UndealCount/QZoneCountInfo:cTime	J
    //   466: aload 8
    //   468: aload_0
    //   469: aload_0
    //   470: ldc 180
    //   472: invokeinterface 104 2 0
    //   477: invokeinterface 108 2 0
    //   482: putfield 54	cooperation/qzone/UndealCount/QZoneCountInfo:iShowLevel	I
    //   485: iload 5
    //   487: istore 4
    //   489: aload_0
    //   490: aload_0
    //   491: ldc 181
    //   493: invokeinterface 104 2 0
    //   498: invokeinterface 108 2 0
    //   503: iconst_1
    //   504: if_icmpne +6 -> 510
    //   507: iconst_1
    //   508: istore 4
    //   510: aload 8
    //   512: iload 4
    //   514: putfield 56	cooperation/qzone/UndealCount/QZoneCountInfo:hasShow	Z
    //   517: aload 8
    //   519: aload_0
    //   520: aload_0
    //   521: ldc 182
    //   523: invokeinterface 104 2 0
    //   528: invokeinterface 115 2 0
    //   533: putfield 58	cooperation/qzone/UndealCount/QZoneCountInfo:actPageAttach	Ljava/lang/String;
    //   536: aload 7
    //   538: iload_2
    //   539: invokestatic 188	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   542: aload 8
    //   544: invokevirtual 192	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   547: pop
    //   548: goto -523 -> 25
    //   551: aload 7
    //   553: areturn
    //   554: aconst_null
    //   555: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	556	0	paramCursor	android.database.Cursor
    //   240	30	1	i	int
    //   57	482	2	j	int
    //   238	6	3	k	int
    //   318	195	4	bool1	boolean
    //   183	303	5	bool2	boolean
    //   199	94	6	localParcel	android.os.Parcel
    //   23	529	7	localHashMap	java.util.HashMap
    //   41	502	8	localQZoneCountInfo	QZoneCountInfo
    //   180	67	9	localObject1	Object
    //   277	3	9	localThrowable	java.lang.Throwable
    //   250	8	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   201	230	273	finally
    //   235	239	273	finally
    //   252	266	273	finally
    //   279	284	273	finally
    //   201	230	277	java/lang/Throwable
    //   235	239	277	java/lang/Throwable
    //   252	266	277	java/lang/Throwable
  }
  
  public ContentValues convertToContentValues()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean equals(QZoneCountInfo paramQZoneCountInfo)
  {
    boolean bool2 = false;
    if (paramQZoneCountInfo == null) {
      return false;
    }
    String str = this.trace_info;
    if ((str != null) && (!str.equals(paramQZoneCountInfo.trace_info))) {
      return false;
    }
    str = paramQZoneCountInfo.trace_info;
    if ((str != null) && (!str.equals(this.trace_info))) {
      return false;
    }
    str = this.pushMesssage;
    if ((str != null) && (!str.equals(paramQZoneCountInfo.pushMesssage))) {
      return false;
    }
    if ((this.pushMesssage == null) && (paramQZoneCountInfo.pushMesssage != null)) {
      return false;
    }
    str = this.schema;
    if ((str != null) && (!str.equals(paramQZoneCountInfo.schema))) {
      return false;
    }
    if ((this.schema == null) && (paramQZoneCountInfo.schema != null)) {
      return false;
    }
    if (this.countId != paramQZoneCountInfo.countId) {
      return false;
    }
    if (!String.valueOf(this.actPageAttach).equals(String.valueOf(paramQZoneCountInfo.actPageAttach))) {
      return false;
    }
    if (!String.valueOf(this.iconUrl).equals(String.valueOf(paramQZoneCountInfo.iconUrl))) {
      return false;
    }
    if (!String.valueOf(this.strShowMsg).equals(String.valueOf(paramQZoneCountInfo.strShowMsg))) {
      return false;
    }
    if (!String.valueOf(this.reportValue).equals(String.valueOf(this.reportValue))) {
      return false;
    }
    if (this.cTime != paramQZoneCountInfo.cTime) {
      return false;
    }
    boolean bool1 = bool2;
    if (this.uCount == paramQZoneCountInfo.uCount)
    {
      bool1 = bool2;
      if (this.friendList.equals(paramQZoneCountInfo.friendList)) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.UndealCount.QZoneCountInfo
 * JD-Core Version:    0.7.0.1
 */