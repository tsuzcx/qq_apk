import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.report.VideoConnRateReport.1;
import com.tencent.av.report.VideoConnRateReport.2;
import com.tencent.av.report.VideoSerializeData;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class lyg
{
  private static String jdField_a_of_type_JavaLangString = "";
  static volatile lyg jdField_a_of_type_Lyg;
  final int jdField_a_of_type_Int = 10240;
  long jdField_a_of_type_Long = 0L;
  public Object a;
  ConcurrentHashMap<String, VideoSerializeData> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean a;
  public long b;
  ConcurrentHashMap<String, String> b;
  public boolean b;
  
  private lyg()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private String a(String paramString)
  {
    long l = 0L;
    VideoSerializeData localVideoSerializeData = (VideoSerializeData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + "_" + "eMSFRecvInviteMsg");
    String str;
    if (localVideoSerializeData != null) {
      if (localVideoSerializeData.errCode == 0)
      {
        str = "" + "|STEP1_1_0_0";
        l = localVideoSerializeData.time;
        label79:
        localVideoSerializeData = (VideoSerializeData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + "_" + "eMSFTransferInviteMsg");
        if (localVideoSerializeData == null) {
          break label731;
        }
        if (localVideoSerializeData.errCode != 0) {
          break label683;
        }
        str = str + "|STEP2_1_0_" + (localVideoSerializeData.time - l);
        label160:
        l = localVideoSerializeData.time;
        label166:
        localVideoSerializeData = (VideoSerializeData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + "_" + "eVideoAddMsg");
        if (localVideoSerializeData == null) {
          break label804;
        }
        if (localVideoSerializeData.errCode != 0) {
          break label756;
        }
        str = str + "|STEP3_1_0_" + (localVideoSerializeData.time - l);
        label247:
        l = localVideoSerializeData.time;
        label253:
        localVideoSerializeData = (VideoSerializeData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + "_" + "eVideoMSFReceiverProcess");
        if (localVideoSerializeData == null) {
          break label877;
        }
        if (localVideoSerializeData.errCode != 0) {
          break label829;
        }
        str = str + "|STEP4_1_0_" + (localVideoSerializeData.time - l);
        label334:
        l = localVideoSerializeData.time;
        label340:
        localVideoSerializeData = (VideoSerializeData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + "_" + "eVideoRecvInviteMsg");
        if (localVideoSerializeData == null) {
          break label950;
        }
        if (localVideoSerializeData.errCode != 0) {
          break label902;
        }
        str = str + "|STEP5_1_0_" + (localVideoSerializeData.time - l);
        label421:
        l = localVideoSerializeData.time;
        label427:
        localVideoSerializeData = (VideoSerializeData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + "_" + "eVideoSendACK");
        if (localVideoSerializeData == null) {
          break label1023;
        }
        if (localVideoSerializeData.errCode != 0) {
          break label975;
        }
        str = str + "|STEP6_1_0_" + (localVideoSerializeData.time - l);
        label508:
        l = localVideoSerializeData.time;
        label514:
        localVideoSerializeData = (VideoSerializeData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + "_" + "eMSFSendVideoACK");
        if (localVideoSerializeData == null) {
          break label1095;
        }
        if (localVideoSerializeData.errCode != 0) {
          break label1048;
        }
        paramString = str + "|STEP7_1_0_" + (localVideoSerializeData.time - l);
        label594:
        l = localVideoSerializeData.time;
      }
    }
    for (;;)
    {
      return paramString + "|";
      str = "" + "|STEP1_2_" + localVideoSerializeData.errCode + "_0";
      break;
      str = "" + "|STEP1_0_0_0";
      break label79;
      label683:
      str = str + "|STEP2_2_" + localVideoSerializeData.errCode + "_" + (localVideoSerializeData.time - l);
      break label160;
      label731:
      str = str + "|STEP2_1_0_0";
      break label166;
      label756:
      str = str + "|STEP3_2_" + localVideoSerializeData.errCode + "_" + (localVideoSerializeData.time - l);
      break label247;
      label804:
      str = str + "|STEP3_0_0_0";
      break label253;
      label829:
      str = str + "|STEP4_2_" + localVideoSerializeData.errCode + "_" + (localVideoSerializeData.time - l);
      break label334;
      label877:
      str = str + "|STEP4_0_0_0";
      break label340;
      label902:
      str = str + "|STEP5_2_" + localVideoSerializeData.errCode + "_" + (localVideoSerializeData.time - l);
      break label421;
      label950:
      str = str + "|STEP5_0_0_0";
      break label427;
      label975:
      str = str + "|STEP6_2_" + localVideoSerializeData.errCode + "_" + (localVideoSerializeData.time - l);
      break label508;
      label1023:
      str = str + "|STEP6_0_0_0";
      break label514;
      label1048:
      paramString = str + "|STEP7_2_" + localVideoSerializeData.errCode + "_" + (localVideoSerializeData.time - l);
      break label594;
      label1095:
      paramString = str + "|STEP7_0_0_0";
    }
  }
  
  public static lyg a()
  {
    if (jdField_a_of_type_Lyg == null) {}
    try
    {
      if (jdField_a_of_type_Lyg == null)
      {
        jdField_a_of_type_Lyg = new lyg();
        jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/tencent/audio/";
      }
      return jdField_a_of_type_Lyg;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    a(paramString, "eMSFRecvInviteMsg");
    a(paramString, "eMSFTransferInviteMsg");
    a(paramString, "eVideoAddMsg");
    a(paramString, "eVideoMSFReceiverProcess");
    a(paramString, "eVideoRecvInviteMsg");
    a(paramString, "eVideoSendACK");
    a(paramString, "eMSFSendVideoACK");
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      do
      {
        return;
        paramString1 = (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1 + "_" + paramString2);
      } while (paramString1 == null);
      paramString1 = new File(jdField_a_of_type_JavaLangString + paramString1);
    } while ((paramString1 == null) || (!paramString1.exists()));
    paramString1.delete();
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: new 142	java/io/File
    //   3: dup
    //   4: getstatic 21	lyg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: invokevirtual 185	java/io/File:listFiles	()[Ljava/io/File;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +8 -> 23
    //   18: aload_2
    //   19: arraylength
    //   20: ifgt +4 -> 24
    //   23: return
    //   24: iconst_0
    //   25: istore_1
    //   26: iload_1
    //   27: aload_2
    //   28: arraylength
    //   29: if_icmpge +79 -> 108
    //   32: aload_2
    //   33: iload_1
    //   34: aaload
    //   35: astore_3
    //   36: aload_3
    //   37: ifnull +22 -> 59
    //   40: aload_3
    //   41: invokevirtual 188	java/io/File:isFile	()Z
    //   44: ifeq +10 -> 54
    //   47: aload_3
    //   48: invokevirtual 165	java/io/File:exists	()Z
    //   51: ifne +15 -> 66
    //   54: aload_3
    //   55: invokevirtual 168	java/io/File:delete	()Z
    //   58: pop
    //   59: iload_1
    //   60: iconst_1
    //   61: iadd
    //   62: istore_1
    //   63: goto -37 -> 26
    //   66: aload_3
    //   67: invokevirtual 191	java/io/File:getName	()Ljava/lang/String;
    //   70: astore 4
    //   72: aload 4
    //   74: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   77: ifne -18 -> 59
    //   80: aload 4
    //   82: ldc 193
    //   84: invokevirtual 196	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   87: ifeq -28 -> 59
    //   90: aload_0
    //   91: aload 4
    //   93: iconst_1
    //   94: invokevirtual 199	lyg:a	(Ljava/lang/String;Z)Z
    //   97: ifne -38 -> 59
    //   100: aload_3
    //   101: invokevirtual 168	java/io/File:delete	()Z
    //   104: pop
    //   105: goto -46 -> 59
    //   108: new 201	java/util/ArrayList
    //   111: dup
    //   112: invokespecial 202	java/util/ArrayList:<init>	()V
    //   115: astore_3
    //   116: aload_0
    //   117: getfield 36	lyg:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   120: invokevirtual 206	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   123: invokeinterface 212 1 0
    //   128: astore_2
    //   129: aload_2
    //   130: invokeinterface 217 1 0
    //   135: ifeq +93 -> 228
    //   138: aload_2
    //   139: invokeinterface 221 1 0
    //   144: checkcast 223	java/util/Map$Entry
    //   147: invokeinterface 226 1 0
    //   152: checkcast 159	java/lang/String
    //   155: astore 4
    //   157: aload 4
    //   159: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   162: ifne -33 -> 129
    //   165: aload 4
    //   167: iconst_0
    //   168: aload 4
    //   170: ldc 48
    //   172: invokevirtual 230	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   175: invokevirtual 234	java/lang/String:substring	(II)Ljava/lang/String;
    //   178: astore 4
    //   180: aload 4
    //   182: ifnull -53 -> 129
    //   185: aload_3
    //   186: aload 4
    //   188: invokevirtual 237	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   191: ifne -62 -> 129
    //   194: aload 4
    //   196: aload_0
    //   197: getfield 29	lyg:jdField_a_of_type_Long	J
    //   200: invokestatic 241	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   203: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   206: ifne -77 -> 129
    //   209: aload_3
    //   210: aload 4
    //   212: invokevirtual 247	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   215: pop
    //   216: goto -87 -> 129
    //   219: astore 4
    //   221: iconst_0
    //   222: ifeq -93 -> 129
    //   225: aload 4
    //   227: athrow
    //   228: iconst_0
    //   229: istore_1
    //   230: iload_1
    //   231: aload_3
    //   232: invokevirtual 251	java/util/ArrayList:size	()I
    //   235: if_icmpge -212 -> 23
    //   238: aload_3
    //   239: iload_1
    //   240: invokevirtual 254	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   243: checkcast 159	java/lang/String
    //   246: astore 4
    //   248: aload 4
    //   250: ifnull +75 -> 325
    //   253: aload_0
    //   254: aload 4
    //   256: invokespecial 256	lyg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   259: astore_2
    //   260: aload_0
    //   261: getfield 36	lyg:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   264: new 41	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   271: aload 4
    //   273: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: ldc 48
    //   278: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc 50
    //   283: invokestatic 259	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   286: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokevirtual 58	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   295: checkcast 60	com/tencent/av/report/VideoSerializeData
    //   298: astore 6
    //   300: ldc 19
    //   302: aload_2
    //   303: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   306: ifne +13 -> 319
    //   309: aload_2
    //   310: ldc_w 261
    //   313: invokevirtual 196	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   316: ifne +16 -> 332
    //   319: aload_0
    //   320: aload 4
    //   322: invokespecial 263	lyg:a	(Ljava/lang/String;)V
    //   325: iload_1
    //   326: iconst_1
    //   327: iadd
    //   328: istore_1
    //   329: goto -99 -> 230
    //   332: new 265	java/util/HashMap
    //   335: dup
    //   336: invokespecial 266	java/util/HashMap:<init>	()V
    //   339: astore 5
    //   341: aload 5
    //   343: ldc_w 268
    //   346: aload_2
    //   347: invokevirtual 272	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   350: pop
    //   351: ldc_w 274
    //   354: astore_2
    //   355: aload 6
    //   357: ifnull +46 -> 403
    //   360: aload 5
    //   362: ldc_w 276
    //   365: aload 6
    //   367: getfield 279	com/tencent/av/report/VideoSerializeData:toUin	J
    //   370: invokestatic 241	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   373: invokevirtual 272	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   376: pop
    //   377: aload 5
    //   379: ldc_w 281
    //   382: aload 6
    //   384: getfield 284	com/tencent/av/report/VideoSerializeData:fromUin	J
    //   387: invokestatic 241	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   390: invokevirtual 272	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   393: pop
    //   394: aload 6
    //   396: getfield 284	com/tencent/av/report/VideoSerializeData:fromUin	J
    //   399: invokestatic 241	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   402: astore_2
    //   403: invokestatic 290	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   406: invokestatic 295	azmz:a	(Landroid/content/Context;)Lazmz;
    //   409: aload_2
    //   410: ldc_w 297
    //   413: iconst_1
    //   414: lconst_0
    //   415: lconst_0
    //   416: aload 5
    //   418: ldc 19
    //   420: iconst_1
    //   421: invokevirtual 300	azmz:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   424: aload_0
    //   425: aload 4
    //   427: invokespecial 263	lyg:a	(Ljava/lang/String;)V
    //   430: goto -105 -> 325
    //   433: astore 4
    //   435: goto -306 -> 129
    //   438: astore 4
    //   440: goto -311 -> 129
    //   443: astore 4
    //   445: goto -316 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	lyg
    //   25	304	1	i	int
    //   13	397	2	localObject1	Object
    //   35	204	3	localArrayList	java.util.ArrayList
    //   70	141	4	str1	String
    //   219	7	4	localObject2	Object
    //   246	180	4	str2	String
    //   433	1	4	localException	java.lang.Exception
    //   438	1	4	localNullPointerException	java.lang.NullPointerException
    //   443	1	4	localIndexOutOfBoundsException	java.lang.IndexOutOfBoundsException
    //   339	78	5	localHashMap	java.util.HashMap
    //   298	97	6	localVideoSerializeData	VideoSerializeData
    // Exception table:
    //   from	to	target	type
    //   165	180	219	finally
    //   165	180	433	java/lang/Exception
    //   165	180	438	java/lang/NullPointerException
    //   165	180	443	java/lang/IndexOutOfBoundsException
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: new 142	java/io/File
    //   3: dup
    //   4: getstatic 21	lyg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: invokevirtual 185	java/io/File:listFiles	()[Ljava/io/File;
    //   13: astore 11
    //   15: aload 11
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: iconst_0
    //   22: istore_1
    //   23: iload_1
    //   24: aload 11
    //   26: arraylength
    //   27: if_icmpge -7 -> 20
    //   30: aload 11
    //   32: iload_1
    //   33: aaload
    //   34: astore 12
    //   36: aload 12
    //   38: ifnull +25 -> 63
    //   41: aload 12
    //   43: invokevirtual 188	java/io/File:isFile	()Z
    //   46: ifeq +11 -> 57
    //   49: aload 12
    //   51: invokevirtual 165	java/io/File:exists	()Z
    //   54: ifne +16 -> 70
    //   57: aload 12
    //   59: invokevirtual 168	java/io/File:delete	()Z
    //   62: pop
    //   63: iload_1
    //   64: iconst_1
    //   65: iadd
    //   66: istore_1
    //   67: goto -44 -> 23
    //   70: aload 12
    //   72: invokevirtual 191	java/io/File:getName	()Ljava/lang/String;
    //   75: astore 10
    //   77: aload 10
    //   79: ifnull -16 -> 63
    //   82: aload 10
    //   84: ldc_w 306
    //   87: invokevirtual 196	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   90: ifeq -27 -> 63
    //   93: aload 12
    //   95: invokevirtual 310	java/io/File:length	()J
    //   98: lstore 4
    //   100: lload 4
    //   102: lconst_0
    //   103: lcmp
    //   104: ifle +12 -> 116
    //   107: lload 4
    //   109: ldc2_w 311
    //   112: lcmp
    //   113: ifle +12 -> 125
    //   116: aload 12
    //   118: invokevirtual 168	java/io/File:delete	()Z
    //   121: pop
    //   122: goto -59 -> 63
    //   125: aload 10
    //   127: ifnull -64 -> 63
    //   130: lload 4
    //   132: l2i
    //   133: newarray byte
    //   135: astore 9
    //   137: aload 9
    //   139: ifnonnull +12 -> 151
    //   142: aload 12
    //   144: invokevirtual 168	java/io/File:delete	()Z
    //   147: pop
    //   148: goto -85 -> 63
    //   151: iconst_1
    //   152: istore_3
    //   153: aconst_null
    //   154: astore 8
    //   156: aconst_null
    //   157: astore 7
    //   159: new 314	java/io/FileInputStream
    //   162: dup
    //   163: aload 12
    //   165: invokespecial 317	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   168: astore 6
    //   170: aload 6
    //   172: aload 9
    //   174: invokevirtual 321	java/io/FileInputStream:read	([B)I
    //   177: pop
    //   178: iload_3
    //   179: istore_2
    //   180: aload 6
    //   182: ifnull +10 -> 192
    //   185: aload 6
    //   187: invokevirtual 324	java/io/FileInputStream:close	()V
    //   190: iload_3
    //   191: istore_2
    //   192: iload_2
    //   193: ifeq +9 -> 202
    //   196: aload 9
    //   198: arraylength
    //   199: ifgt +115 -> 314
    //   202: aload 12
    //   204: invokevirtual 168	java/io/File:delete	()Z
    //   207: pop
    //   208: goto -145 -> 63
    //   211: astore 6
    //   213: iconst_0
    //   214: istore_2
    //   215: goto -23 -> 192
    //   218: astore 6
    //   220: aconst_null
    //   221: astore 6
    //   223: aload 6
    //   225: ifnull +8 -> 233
    //   228: aload 6
    //   230: invokevirtual 324	java/io/FileInputStream:close	()V
    //   233: aload 12
    //   235: invokevirtual 168	java/io/File:delete	()Z
    //   238: pop
    //   239: goto -176 -> 63
    //   242: astore 6
    //   244: aload 7
    //   246: astore 6
    //   248: aload 6
    //   250: ifnull +8 -> 258
    //   253: aload 6
    //   255: invokevirtual 324	java/io/FileInputStream:close	()V
    //   258: aload 12
    //   260: invokevirtual 168	java/io/File:delete	()Z
    //   263: pop
    //   264: goto -201 -> 63
    //   267: astore 6
    //   269: aload 8
    //   271: astore 7
    //   273: aload 7
    //   275: ifnull +8 -> 283
    //   278: aload 7
    //   280: invokevirtual 324	java/io/FileInputStream:close	()V
    //   283: iconst_1
    //   284: istore_2
    //   285: iload_2
    //   286: ifeq +9 -> 295
    //   289: aload 9
    //   291: arraylength
    //   292: ifgt +19 -> 311
    //   295: aload 12
    //   297: invokevirtual 168	java/io/File:delete	()Z
    //   300: pop
    //   301: goto -238 -> 63
    //   304: astore 7
    //   306: iconst_0
    //   307: istore_2
    //   308: goto -23 -> 285
    //   311: aload 6
    //   313: athrow
    //   314: aload 9
    //   316: ldc_w 326
    //   319: new 328	SharpSvrPack/SharpVideoMsg
    //   322: dup
    //   323: invokespecial 329	SharpSvrPack/SharpVideoMsg:<init>	()V
    //   326: invokestatic 335	mqq/app/Packet:decodePacket	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   329: checkcast 328	SharpSvrPack/SharpVideoMsg
    //   332: astore 7
    //   334: iconst_1
    //   335: istore_2
    //   336: iload_2
    //   337: ifeq +39 -> 376
    //   340: aload 7
    //   342: ifnull +34 -> 376
    //   345: aload 7
    //   347: getfield 338	SharpSvrPack/SharpVideoMsg:msg_type	J
    //   350: ldc2_w 339
    //   353: lcmp
    //   354: ifne +22 -> 376
    //   357: aload 7
    //   359: getfield 344	SharpSvrPack/SharpVideoMsg:to_uin	Ljava/util/ArrayList;
    //   362: ifnull +14 -> 376
    //   365: aload 7
    //   367: getfield 344	SharpSvrPack/SharpVideoMsg:to_uin	Ljava/util/ArrayList;
    //   370: invokevirtual 251	java/util/ArrayList:size	()I
    //   373: ifgt +22 -> 395
    //   376: aload 12
    //   378: invokevirtual 168	java/io/File:delete	()Z
    //   381: pop
    //   382: goto -319 -> 63
    //   385: astore 6
    //   387: iconst_0
    //   388: istore_2
    //   389: aconst_null
    //   390: astore 7
    //   392: goto -56 -> 336
    //   395: aload 10
    //   397: iconst_0
    //   398: aload 10
    //   400: ldc 48
    //   402: invokevirtual 230	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   405: invokevirtual 234	java/lang/String:substring	(II)Ljava/lang/String;
    //   408: astore 6
    //   410: aload 10
    //   412: aload 10
    //   414: ldc 48
    //   416: invokevirtual 230	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   419: iconst_1
    //   420: iadd
    //   421: aload 10
    //   423: ldc 48
    //   425: invokevirtual 347	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   428: invokevirtual 234	java/lang/String:substring	(II)Ljava/lang/String;
    //   431: astore 9
    //   433: aload 10
    //   435: aload 10
    //   437: ldc 48
    //   439: invokevirtual 347	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   442: iconst_1
    //   443: iadd
    //   444: aload 10
    //   446: ldc_w 349
    //   449: invokevirtual 230	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   452: invokevirtual 234	java/lang/String:substring	(II)Ljava/lang/String;
    //   455: astore 8
    //   457: aload 6
    //   459: ifnull +13 -> 472
    //   462: aload 9
    //   464: ifnull +8 -> 472
    //   467: aload 8
    //   469: ifnonnull +68 -> 537
    //   472: aload 12
    //   474: invokevirtual 168	java/io/File:delete	()Z
    //   477: pop
    //   478: goto -415 -> 63
    //   481: astore 6
    //   483: aload 12
    //   485: invokevirtual 168	java/io/File:delete	()Z
    //   488: pop
    //   489: goto -426 -> 63
    //   492: astore 6
    //   494: aload 12
    //   496: invokevirtual 168	java/io/File:delete	()Z
    //   499: pop
    //   500: goto -437 -> 63
    //   503: astore 6
    //   505: aconst_null
    //   506: astore 8
    //   508: aconst_null
    //   509: astore 7
    //   511: aload 8
    //   513: ifnull +12 -> 525
    //   516: aload 7
    //   518: ifnull +7 -> 525
    //   521: iconst_0
    //   522: ifne +12 -> 534
    //   525: aload 12
    //   527: invokevirtual 168	java/io/File:delete	()Z
    //   530: pop
    //   531: goto -468 -> 63
    //   534: aload 6
    //   536: athrow
    //   537: ldc 50
    //   539: aload 6
    //   541: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   544: ifeq +75 -> 619
    //   547: ldc 50
    //   549: astore 6
    //   551: aload 9
    //   553: invokestatic 354	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   556: invokevirtual 357	java/lang/Long:longValue	()J
    //   559: lstore 4
    //   561: aload 8
    //   563: invokestatic 362	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   566: invokevirtual 365	java/lang/Integer:intValue	()I
    //   569: istore_2
    //   570: aload_0
    //   571: aload 6
    //   573: aload 7
    //   575: getfield 338	SharpSvrPack/SharpVideoMsg:msg_type	J
    //   578: aload 7
    //   580: getfield 368	SharpSvrPack/SharpVideoMsg:msg_seq	J
    //   583: lload 4
    //   585: aload 7
    //   587: getfield 344	SharpSvrPack/SharpVideoMsg:to_uin	Ljava/util/ArrayList;
    //   590: iconst_0
    //   591: invokevirtual 254	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   594: checkcast 351	java/lang/Long
    //   597: invokevirtual 357	java/lang/Long:longValue	()J
    //   600: aload 7
    //   602: getfield 371	SharpSvrPack/SharpVideoMsg:from_uin	J
    //   605: iload_2
    //   606: invokevirtual 374	lyg:a	(Ljava/lang/String;JJJJJI)Z
    //   609: pop
    //   610: aload 12
    //   612: invokevirtual 168	java/io/File:delete	()Z
    //   615: pop
    //   616: goto -553 -> 63
    //   619: ldc 70
    //   621: aload 6
    //   623: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   626: ifeq +10 -> 636
    //   629: ldc 70
    //   631: astore 6
    //   633: goto -82 -> 551
    //   636: ldc 77
    //   638: aload 6
    //   640: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   643: ifeq +10 -> 653
    //   646: ldc 77
    //   648: astore 6
    //   650: goto -99 -> 551
    //   653: ldc 81
    //   655: aload 6
    //   657: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   660: ifeq +10 -> 670
    //   663: ldc 81
    //   665: astore 6
    //   667: goto -116 -> 551
    //   670: ldc 93
    //   672: aload 6
    //   674: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   677: ifeq +10 -> 687
    //   680: ldc 93
    //   682: astore 6
    //   684: goto -133 -> 551
    //   687: aload 12
    //   689: invokevirtual 168	java/io/File:delete	()Z
    //   692: pop
    //   693: goto -630 -> 63
    //   696: astore 6
    //   698: aload 12
    //   700: invokevirtual 168	java/io/File:delete	()Z
    //   703: pop
    //   704: goto -641 -> 63
    //   707: astore 6
    //   709: aload 6
    //   711: athrow
    //   712: astore 6
    //   714: goto -481 -> 233
    //   717: astore 6
    //   719: goto -461 -> 258
    //   722: astore 9
    //   724: aload 6
    //   726: astore 8
    //   728: aconst_null
    //   729: astore 7
    //   731: aload 9
    //   733: astore 6
    //   735: goto -224 -> 511
    //   738: astore 10
    //   740: aload 6
    //   742: astore 8
    //   744: aload 9
    //   746: astore 7
    //   748: aload 10
    //   750: astore 6
    //   752: goto -241 -> 511
    //   755: astore 6
    //   757: goto -263 -> 494
    //   760: astore 6
    //   762: goto -268 -> 494
    //   765: astore 6
    //   767: goto -284 -> 483
    //   770: astore 6
    //   772: goto -289 -> 483
    //   775: astore 8
    //   777: aload 6
    //   779: astore 7
    //   781: aload 8
    //   783: astore 6
    //   785: goto -512 -> 273
    //   788: astore 7
    //   790: goto -542 -> 248
    //   793: astore 7
    //   795: goto -572 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	798	0	this	lyg
    //   22	45	1	i	int
    //   179	427	2	j	int
    //   152	39	3	k	int
    //   98	486	4	l	long
    //   168	18	6	localFileInputStream	java.io.FileInputStream
    //   211	1	6	localIOException1	java.io.IOException
    //   218	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   221	8	6	localObject1	Object
    //   242	1	6	localIOException2	java.io.IOException
    //   246	8	6	localObject2	Object
    //   267	45	6	localObject3	Object
    //   385	1	6	localException1	java.lang.Exception
    //   408	50	6	str1	String
    //   481	1	6	localIndexOutOfBoundsException1	java.lang.IndexOutOfBoundsException
    //   492	1	6	localNullPointerException1	java.lang.NullPointerException
    //   503	37	6	localObject4	Object
    //   549	134	6	str2	String
    //   696	1	6	localException2	java.lang.Exception
    //   707	3	6	localObject5	Object
    //   712	1	6	localIOException3	java.io.IOException
    //   717	8	6	localIOException4	java.io.IOException
    //   733	18	6	localObject6	Object
    //   755	1	6	localNullPointerException2	java.lang.NullPointerException
    //   760	1	6	localNullPointerException3	java.lang.NullPointerException
    //   765	1	6	localIndexOutOfBoundsException2	java.lang.IndexOutOfBoundsException
    //   770	8	6	localIndexOutOfBoundsException3	java.lang.IndexOutOfBoundsException
    //   783	1	6	localObject7	Object
    //   157	122	7	localObject8	Object
    //   304	1	7	localIOException5	java.io.IOException
    //   332	448	7	localObject9	Object
    //   788	1	7	localIOException6	java.io.IOException
    //   793	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   154	589	8	localObject10	Object
    //   775	7	8	localObject11	Object
    //   135	417	9	localObject12	Object
    //   722	23	9	localObject13	Object
    //   75	370	10	str3	String
    //   738	11	10	localObject14	Object
    //   13	18	11	arrayOfFile	File[]
    //   34	665	12	localFile	File
    // Exception table:
    //   from	to	target	type
    //   185	190	211	java/io/IOException
    //   159	170	218	java/io/FileNotFoundException
    //   159	170	242	java/io/IOException
    //   159	170	267	finally
    //   278	283	304	java/io/IOException
    //   314	334	385	java/lang/Exception
    //   395	410	481	java/lang/IndexOutOfBoundsException
    //   395	410	492	java/lang/NullPointerException
    //   395	410	503	finally
    //   551	570	696	java/lang/Exception
    //   551	570	707	finally
    //   228	233	712	java/io/IOException
    //   253	258	717	java/io/IOException
    //   410	433	722	finally
    //   433	457	738	finally
    //   410	433	755	java/lang/NullPointerException
    //   433	457	760	java/lang/NullPointerException
    //   410	433	765	java/lang/IndexOutOfBoundsException
    //   433	457	770	java/lang/IndexOutOfBoundsException
    //   170	178	775	finally
    //   170	178	788	java/io/IOException
    //   170	178	793	java/io/FileNotFoundException
  }
  
  public void a()
  {
    new Thread(new VideoConnRateReport.1(this)).start();
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    File localFile;
    do
    {
      do
      {
        return;
      } while (((!paramString.equals("eVideoRecvInviteMsg")) && (!paramString.equals("eVideoSendACK"))) || (!Environment.getExternalStorageState().equals("mounted")));
      localFile = new File(jdField_a_of_type_JavaLangString);
    } while ((!localFile.exists()) && (!localFile.mkdirs()));
    a(paramString, paramLong1, paramLong2, SystemClock.elapsedRealtime(), paramLong3, paramLong4, paramInt);
  }
  
  /* Error */
  boolean a(String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +9 -> 13
    //   7: iconst_0
    //   8: istore 13
    //   10: iload 13
    //   12: ireturn
    //   13: aconst_null
    //   14: astore 19
    //   16: aconst_null
    //   17: astore 18
    //   19: aload_1
    //   20: ldc 50
    //   22: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifne +57 -> 82
    //   28: aload_1
    //   29: ldc 70
    //   31: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifne +48 -> 82
    //   37: aload_1
    //   38: ldc 77
    //   40: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: ifne +39 -> 82
    //   46: aload_1
    //   47: ldc 81
    //   49: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifne +30 -> 82
    //   55: aload_1
    //   56: ldc 85
    //   58: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   61: ifne +21 -> 82
    //   64: aload_1
    //   65: ldc 89
    //   67: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifne +12 -> 82
    //   73: aload_1
    //   74: ldc 93
    //   76: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifeq +812 -> 891
    //   82: new 41	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   89: aload_1
    //   90: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc 48
    //   95: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokestatic 401	android/os/SystemClock:elapsedRealtime	()J
    //   101: invokestatic 241	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   104: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: iload 12
    //   109: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: ldc 193
    //   114: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: astore 17
    //   122: ldc 19
    //   124: aload 17
    //   126: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   129: ifeq +5 -> 134
    //   132: iconst_0
    //   133: ireturn
    //   134: new 60	com/tencent/av/report/VideoSerializeData
    //   137: dup
    //   138: aload_1
    //   139: lload_2
    //   140: lload 4
    //   142: lload 6
    //   144: lload 8
    //   146: lload 10
    //   148: iload 12
    //   150: invokespecial 404	com/tencent/av/report/VideoSerializeData:<init>	(Ljava/lang/String;JJJJJI)V
    //   153: astore 24
    //   155: aload 24
    //   157: ifnonnull +5 -> 162
    //   160: iconst_0
    //   161: ireturn
    //   162: aconst_null
    //   163: astore 21
    //   165: aconst_null
    //   166: astore 20
    //   168: aconst_null
    //   169: astore 23
    //   171: aconst_null
    //   172: astore 22
    //   174: new 142	java/io/File
    //   177: dup
    //   178: new 41	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   185: getstatic 21	lyg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   188: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload 17
    //   193: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   202: astore 15
    //   204: new 406	java/io/FileOutputStream
    //   207: dup
    //   208: aload 15
    //   210: invokespecial 407	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   213: astore_1
    //   214: aload 15
    //   216: invokevirtual 310	java/io/File:length	()J
    //   219: lstore_2
    //   220: lload_2
    //   221: l2i
    //   222: istore 12
    //   224: iload 12
    //   226: i2l
    //   227: lload_2
    //   228: lcmp
    //   229: ifne +653 -> 882
    //   232: new 409	java/io/ByteArrayOutputStream
    //   235: dup
    //   236: iload 12
    //   238: invokespecial 412	java/io/ByteArrayOutputStream:<init>	(I)V
    //   241: astore 15
    //   243: new 414	java/io/ObjectOutputStream
    //   246: dup
    //   247: aload 15
    //   249: invokespecial 417	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   252: astore 16
    //   254: aload 16
    //   256: aload 24
    //   258: invokevirtual 421	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   261: aload 16
    //   263: invokevirtual 424	java/io/ObjectOutputStream:flush	()V
    //   266: aload 15
    //   268: aload_1
    //   269: invokevirtual 427	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   272: aload 15
    //   274: invokevirtual 428	java/io/ByteArrayOutputStream:flush	()V
    //   277: aload 16
    //   279: ifnull +8 -> 287
    //   282: aload 16
    //   284: invokevirtual 429	java/io/ObjectOutputStream:close	()V
    //   287: iconst_1
    //   288: istore 14
    //   290: iload 14
    //   292: istore 13
    //   294: aload 15
    //   296: ifnull +12 -> 308
    //   299: aload 15
    //   301: invokevirtual 430	java/io/ByteArrayOutputStream:close	()V
    //   304: iload 14
    //   306: istore 13
    //   308: iload 13
    //   310: istore 14
    //   312: aload_1
    //   313: ifnull +11 -> 324
    //   316: aload_1
    //   317: invokevirtual 431	java/io/FileOutputStream:close	()V
    //   320: iload 13
    //   322: istore 14
    //   324: iload 14
    //   326: istore 13
    //   328: iload 14
    //   330: ifne -320 -> 10
    //   333: new 142	java/io/File
    //   336: dup
    //   337: new 41	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   344: getstatic 21	lyg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   347: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload 17
    //   352: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   361: astore_1
    //   362: iload 14
    //   364: istore 13
    //   366: aload_1
    //   367: ifnull -357 -> 10
    //   370: iload 14
    //   372: istore 13
    //   374: aload_1
    //   375: invokevirtual 165	java/io/File:exists	()Z
    //   378: ifeq -368 -> 10
    //   381: aload_1
    //   382: invokevirtual 168	java/io/File:delete	()Z
    //   385: pop
    //   386: iload 14
    //   388: ireturn
    //   389: astore 16
    //   391: iconst_0
    //   392: istore 14
    //   394: goto -104 -> 290
    //   397: astore 15
    //   399: iconst_0
    //   400: istore 13
    //   402: goto -94 -> 308
    //   405: astore_1
    //   406: iconst_0
    //   407: istore 14
    //   409: goto -85 -> 324
    //   412: astore_1
    //   413: aconst_null
    //   414: astore_1
    //   415: aconst_null
    //   416: astore 15
    //   418: aconst_null
    //   419: astore 16
    //   421: aload 16
    //   423: ifnull +8 -> 431
    //   426: aload 16
    //   428: invokevirtual 429	java/io/ObjectOutputStream:close	()V
    //   431: aload 15
    //   433: ifnull +443 -> 876
    //   436: aload 15
    //   438: invokevirtual 430	java/io/ByteArrayOutputStream:close	()V
    //   441: iconst_0
    //   442: istore 13
    //   444: aload_1
    //   445: ifnull +424 -> 869
    //   448: aload_1
    //   449: invokevirtual 431	java/io/FileOutputStream:close	()V
    //   452: iload 13
    //   454: istore 14
    //   456: new 142	java/io/File
    //   459: dup
    //   460: new 41	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   467: getstatic 21	lyg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   470: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload 17
    //   475: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   484: astore_1
    //   485: iload 14
    //   487: istore 13
    //   489: aload_1
    //   490: ifnull -480 -> 10
    //   493: iload 14
    //   495: istore 13
    //   497: aload_1
    //   498: invokevirtual 165	java/io/File:exists	()Z
    //   501: ifeq -491 -> 10
    //   504: aload_1
    //   505: invokevirtual 168	java/io/File:delete	()Z
    //   508: pop
    //   509: iload 14
    //   511: ireturn
    //   512: astore 16
    //   514: goto -83 -> 431
    //   517: astore 15
    //   519: iconst_0
    //   520: istore 13
    //   522: goto -78 -> 444
    //   525: astore_1
    //   526: iconst_0
    //   527: istore 14
    //   529: goto -73 -> 456
    //   532: astore_1
    //   533: aload 18
    //   535: astore 16
    //   537: aload 20
    //   539: astore 15
    //   541: aload 22
    //   543: astore_1
    //   544: aload 16
    //   546: ifnull +8 -> 554
    //   549: aload 16
    //   551: invokevirtual 429	java/io/ObjectOutputStream:close	()V
    //   554: aload 15
    //   556: ifnull +8 -> 564
    //   559: aload 15
    //   561: invokevirtual 430	java/io/ByteArrayOutputStream:close	()V
    //   564: aload_1
    //   565: ifnull +7 -> 572
    //   568: aload_1
    //   569: invokevirtual 431	java/io/FileOutputStream:close	()V
    //   572: iconst_0
    //   573: istore 14
    //   575: new 142	java/io/File
    //   578: dup
    //   579: new 41	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   586: getstatic 21	lyg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   589: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: aload 17
    //   594: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   603: astore_1
    //   604: iload 14
    //   606: istore 13
    //   608: aload_1
    //   609: ifnull -599 -> 10
    //   612: iload 14
    //   614: istore 13
    //   616: aload_1
    //   617: invokevirtual 165	java/io/File:exists	()Z
    //   620: ifeq -610 -> 10
    //   623: aload_1
    //   624: invokevirtual 168	java/io/File:delete	()Z
    //   627: pop
    //   628: iconst_0
    //   629: ireturn
    //   630: astore 16
    //   632: goto -78 -> 554
    //   635: astore 15
    //   637: goto -73 -> 564
    //   640: astore_1
    //   641: goto -69 -> 572
    //   644: astore_1
    //   645: aload 19
    //   647: astore 16
    //   649: aload 21
    //   651: astore 15
    //   653: aload 23
    //   655: astore_1
    //   656: aload 16
    //   658: ifnull +8 -> 666
    //   661: aload 16
    //   663: invokevirtual 429	java/io/ObjectOutputStream:close	()V
    //   666: iconst_1
    //   667: istore 14
    //   669: iload 14
    //   671: istore 13
    //   673: aload 15
    //   675: ifnull +12 -> 687
    //   678: aload 15
    //   680: invokevirtual 430	java/io/ByteArrayOutputStream:close	()V
    //   683: iload 14
    //   685: istore 13
    //   687: iload 13
    //   689: istore 14
    //   691: aload_1
    //   692: ifnull +11 -> 703
    //   695: aload_1
    //   696: invokevirtual 431	java/io/FileOutputStream:close	()V
    //   699: iload 13
    //   701: istore 14
    //   703: iload 14
    //   705: istore 13
    //   707: iload 14
    //   709: ifne -699 -> 10
    //   712: new 142	java/io/File
    //   715: dup
    //   716: new 41	java/lang/StringBuilder
    //   719: dup
    //   720: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   723: getstatic 21	lyg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   726: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: aload 17
    //   731: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   740: astore_1
    //   741: iload 14
    //   743: istore 13
    //   745: aload_1
    //   746: ifnull -736 -> 10
    //   749: iload 14
    //   751: istore 13
    //   753: aload_1
    //   754: invokevirtual 165	java/io/File:exists	()Z
    //   757: ifeq -747 -> 10
    //   760: aload_1
    //   761: invokevirtual 168	java/io/File:delete	()Z
    //   764: pop
    //   765: iload 14
    //   767: ireturn
    //   768: astore 16
    //   770: iconst_0
    //   771: istore 14
    //   773: goto -104 -> 669
    //   776: astore 15
    //   778: iconst_0
    //   779: istore 13
    //   781: goto -94 -> 687
    //   784: astore_1
    //   785: iconst_0
    //   786: istore 14
    //   788: goto -85 -> 703
    //   791: astore 15
    //   793: aload 21
    //   795: astore 15
    //   797: aload 19
    //   799: astore 16
    //   801: goto -145 -> 656
    //   804: astore 16
    //   806: aload 19
    //   808: astore 16
    //   810: goto -154 -> 656
    //   813: astore 18
    //   815: goto -159 -> 656
    //   818: astore 15
    //   820: aload 20
    //   822: astore 15
    //   824: aload 18
    //   826: astore 16
    //   828: goto -284 -> 544
    //   831: astore 16
    //   833: aload 18
    //   835: astore 16
    //   837: goto -293 -> 544
    //   840: astore 18
    //   842: goto -298 -> 544
    //   845: astore 15
    //   847: aconst_null
    //   848: astore 16
    //   850: aconst_null
    //   851: astore 15
    //   853: goto -432 -> 421
    //   856: astore 16
    //   858: aconst_null
    //   859: astore 16
    //   861: goto -440 -> 421
    //   864: astore 18
    //   866: goto -445 -> 421
    //   869: iload 13
    //   871: istore 14
    //   873: goto -417 -> 456
    //   876: iconst_0
    //   877: istore 13
    //   879: goto -435 -> 444
    //   882: aconst_null
    //   883: astore 15
    //   885: aconst_null
    //   886: astore 16
    //   888: goto -611 -> 277
    //   891: ldc 19
    //   893: astore 17
    //   895: goto -773 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	898	0	this	lyg
    //   0	898	1	paramString	String
    //   0	898	2	paramLong1	long
    //   0	898	4	paramLong2	long
    //   0	898	6	paramLong3	long
    //   0	898	8	paramLong4	long
    //   0	898	10	paramLong5	long
    //   0	898	12	paramInt	int
    //   8	870	13	bool1	boolean
    //   288	584	14	bool2	boolean
    //   202	98	15	localObject1	Object
    //   397	1	15	localIOException1	java.io.IOException
    //   416	21	15	localObject2	Object
    //   517	1	15	localIOException2	java.io.IOException
    //   539	21	15	localObject3	Object
    //   635	1	15	localIOException3	java.io.IOException
    //   651	28	15	localObject4	Object
    //   776	1	15	localIOException4	java.io.IOException
    //   791	1	15	localObject5	Object
    //   795	1	15	localObject6	Object
    //   818	1	15	localIOException5	java.io.IOException
    //   822	1	15	localObject7	Object
    //   845	1	15	localFileNotFoundException1	java.io.FileNotFoundException
    //   851	33	15	localObject8	Object
    //   252	31	16	localObjectOutputStream	java.io.ObjectOutputStream
    //   389	1	16	localException1	java.lang.Exception
    //   419	8	16	localObject9	Object
    //   512	1	16	localException2	java.lang.Exception
    //   535	15	16	localObject10	Object
    //   630	1	16	localException3	java.lang.Exception
    //   647	15	16	localObject11	Object
    //   768	1	16	localException4	java.lang.Exception
    //   799	1	16	localObject12	Object
    //   804	1	16	localObject13	Object
    //   808	19	16	localObject14	Object
    //   831	1	16	localIOException6	java.io.IOException
    //   835	14	16	localObject15	Object
    //   856	1	16	localFileNotFoundException2	java.io.FileNotFoundException
    //   859	28	16	localObject16	Object
    //   120	774	17	str	String
    //   17	517	18	localObject17	Object
    //   813	21	18	localObject18	Object
    //   840	1	18	localIOException7	java.io.IOException
    //   864	1	18	localFileNotFoundException3	java.io.FileNotFoundException
    //   14	793	19	localObject19	Object
    //   166	655	20	localObject20	Object
    //   163	631	21	localObject21	Object
    //   172	370	22	localObject22	Object
    //   169	485	23	localObject23	Object
    //   153	104	24	localVideoSerializeData	VideoSerializeData
    // Exception table:
    //   from	to	target	type
    //   282	287	389	java/lang/Exception
    //   299	304	397	java/io/IOException
    //   316	320	405	java/io/IOException
    //   174	214	412	java/io/FileNotFoundException
    //   426	431	512	java/lang/Exception
    //   436	441	517	java/io/IOException
    //   448	452	525	java/io/IOException
    //   174	214	532	java/io/IOException
    //   549	554	630	java/lang/Exception
    //   559	564	635	java/io/IOException
    //   568	572	640	java/io/IOException
    //   174	214	644	finally
    //   661	666	768	java/lang/Exception
    //   678	683	776	java/io/IOException
    //   695	699	784	java/io/IOException
    //   214	220	791	finally
    //   232	243	791	finally
    //   243	254	804	finally
    //   254	277	813	finally
    //   214	220	818	java/io/IOException
    //   232	243	818	java/io/IOException
    //   243	254	831	java/io/IOException
    //   254	277	840	java/io/IOException
    //   214	220	845	java/io/FileNotFoundException
    //   232	243	845	java/io/FileNotFoundException
    //   243	254	856	java/io/FileNotFoundException
    //   254	277	864	java/io/FileNotFoundException
  }
  
  /* Error */
  boolean a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_1
    //   4: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +5 -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: new 437	java/io/ByteArrayInputStream
    //   15: dup
    //   16: new 142	java/io/File
    //   19: dup
    //   20: new 41	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   27: getstatic 21	lyg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   30: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: invokestatic 442	xmx:b	(Ljava/io/File;)[B
    //   46: invokespecial 445	java/io/ByteArrayInputStream:<init>	([B)V
    //   49: astore 5
    //   51: new 447	java/io/ObjectInputStream
    //   54: dup
    //   55: aload 5
    //   57: invokespecial 450	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: astore 6
    //   62: aload 6
    //   64: ifnull +13 -> 77
    //   67: aload 6
    //   69: invokevirtual 453	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   72: checkcast 60	com/tencent/av/report/VideoSerializeData
    //   75: astore 7
    //   77: aload 5
    //   79: ifnull +456 -> 535
    //   82: aload 5
    //   84: invokevirtual 454	java/io/ByteArrayInputStream:close	()V
    //   87: iconst_1
    //   88: istore_3
    //   89: aload 6
    //   91: ifnull +8 -> 99
    //   94: aload 6
    //   96: invokevirtual 455	java/io/ObjectInputStream:close	()V
    //   99: aload 7
    //   101: ifnonnull +16 -> 117
    //   104: iconst_0
    //   105: istore 4
    //   107: iload 4
    //   109: ireturn
    //   110: astore 5
    //   112: iconst_0
    //   113: istore_3
    //   114: goto -25 -> 89
    //   117: aload 7
    //   119: getfield 458	com/tencent/av/report/VideoSerializeData:msgType	J
    //   122: ldc2_w 339
    //   125: lcmp
    //   126: ifeq +40 -> 166
    //   129: new 142	java/io/File
    //   132: dup
    //   133: aload_1
    //   134: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   137: astore_1
    //   138: iload_3
    //   139: istore 4
    //   141: aload_1
    //   142: ifnull -35 -> 107
    //   145: iload_3
    //   146: istore 4
    //   148: aload_1
    //   149: invokevirtual 165	java/io/File:exists	()Z
    //   152: ifeq -45 -> 107
    //   155: aload_1
    //   156: invokevirtual 168	java/io/File:delete	()Z
    //   159: pop
    //   160: iload_3
    //   161: istore 4
    //   163: goto -56 -> 107
    //   166: iload_3
    //   167: istore 4
    //   169: iload_2
    //   170: ifeq -63 -> 107
    //   173: new 41	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   180: aload 7
    //   182: getfield 461	com/tencent/av/report/VideoSerializeData:msgSeq	J
    //   185: invokestatic 241	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   188: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc 48
    //   193: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload 7
    //   198: getfield 464	com/tencent/av/report/VideoSerializeData:type	Ljava/lang/String;
    //   201: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: astore 5
    //   209: aload_0
    //   210: getfield 36	lyg:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   213: aload 5
    //   215: aload 7
    //   217: invokevirtual 465	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   220: pop
    //   221: aload_0
    //   222: getfield 38	lyg:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   225: aload 5
    //   227: aload_1
    //   228: invokevirtual 465	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   231: pop
    //   232: iload_3
    //   233: istore 4
    //   235: goto -128 -> 107
    //   238: astore_1
    //   239: aconst_null
    //   240: astore 5
    //   242: aconst_null
    //   243: astore_1
    //   244: aload 5
    //   246: ifnull +8 -> 254
    //   249: aload 5
    //   251: invokevirtual 454	java/io/ByteArrayInputStream:close	()V
    //   254: aload_1
    //   255: ifnull +7 -> 262
    //   258: aload_1
    //   259: invokevirtual 455	java/io/ObjectInputStream:close	()V
    //   262: iconst_0
    //   263: ifeq -253 -> 10
    //   266: new 179	java/lang/NullPointerException
    //   269: dup
    //   270: invokespecial 466	java/lang/NullPointerException:<init>	()V
    //   273: athrow
    //   274: astore_1
    //   275: aconst_null
    //   276: astore 5
    //   278: aconst_null
    //   279: astore 6
    //   281: aload 5
    //   283: ifnull +8 -> 291
    //   286: aload 5
    //   288: invokevirtual 454	java/io/ByteArrayInputStream:close	()V
    //   291: aload 6
    //   293: ifnull +8 -> 301
    //   296: aload 6
    //   298: invokevirtual 455	java/io/ObjectInputStream:close	()V
    //   301: iconst_0
    //   302: ifeq -292 -> 10
    //   305: new 179	java/lang/NullPointerException
    //   308: dup
    //   309: invokespecial 466	java/lang/NullPointerException:<init>	()V
    //   312: athrow
    //   313: astore_1
    //   314: aconst_null
    //   315: astore 5
    //   317: aconst_null
    //   318: astore 6
    //   320: aload 5
    //   322: ifnull +8 -> 330
    //   325: aload 5
    //   327: invokevirtual 454	java/io/ByteArrayInputStream:close	()V
    //   330: aload 6
    //   332: ifnull +8 -> 340
    //   335: aload 6
    //   337: invokevirtual 455	java/io/ObjectInputStream:close	()V
    //   340: iconst_0
    //   341: ifeq -331 -> 10
    //   344: new 179	java/lang/NullPointerException
    //   347: dup
    //   348: invokespecial 466	java/lang/NullPointerException:<init>	()V
    //   351: athrow
    //   352: astore_1
    //   353: aconst_null
    //   354: astore 5
    //   356: aconst_null
    //   357: astore 6
    //   359: aload 5
    //   361: ifnull +8 -> 369
    //   364: aload 5
    //   366: invokevirtual 454	java/io/ByteArrayInputStream:close	()V
    //   369: aload 6
    //   371: ifnull +8 -> 379
    //   374: aload 6
    //   376: invokevirtual 455	java/io/ObjectInputStream:close	()V
    //   379: iconst_0
    //   380: ifeq -370 -> 10
    //   383: new 179	java/lang/NullPointerException
    //   386: dup
    //   387: invokespecial 466	java/lang/NullPointerException:<init>	()V
    //   390: athrow
    //   391: astore_1
    //   392: aconst_null
    //   393: astore 5
    //   395: aconst_null
    //   396: astore 6
    //   398: aload 5
    //   400: ifnull +130 -> 530
    //   403: aload 5
    //   405: invokevirtual 454	java/io/ByteArrayInputStream:close	()V
    //   408: iconst_1
    //   409: istore_2
    //   410: aload 6
    //   412: ifnull +8 -> 420
    //   415: aload 6
    //   417: invokevirtual 455	java/io/ObjectInputStream:close	()V
    //   420: iconst_0
    //   421: ifeq -411 -> 10
    //   424: new 179	java/lang/NullPointerException
    //   427: dup
    //   428: invokespecial 466	java/lang/NullPointerException:<init>	()V
    //   431: athrow
    //   432: astore_1
    //   433: iconst_0
    //   434: istore_2
    //   435: goto -25 -> 410
    //   438: astore_1
    //   439: iconst_0
    //   440: ireturn
    //   441: astore 5
    //   443: goto -189 -> 254
    //   446: astore_1
    //   447: iconst_0
    //   448: ireturn
    //   449: astore_1
    //   450: goto -159 -> 291
    //   453: astore_1
    //   454: iconst_0
    //   455: ireturn
    //   456: astore_1
    //   457: goto -127 -> 330
    //   460: astore_1
    //   461: iconst_0
    //   462: ireturn
    //   463: astore_1
    //   464: goto -95 -> 369
    //   467: astore_1
    //   468: iconst_0
    //   469: ireturn
    //   470: astore_1
    //   471: iconst_0
    //   472: ireturn
    //   473: astore_1
    //   474: aconst_null
    //   475: astore 6
    //   477: goto -79 -> 398
    //   480: astore_1
    //   481: goto -83 -> 398
    //   484: astore_1
    //   485: aconst_null
    //   486: astore 6
    //   488: goto -129 -> 359
    //   491: astore_1
    //   492: goto -133 -> 359
    //   495: astore_1
    //   496: aconst_null
    //   497: astore 6
    //   499: goto -179 -> 320
    //   502: astore_1
    //   503: goto -183 -> 320
    //   506: astore_1
    //   507: aconst_null
    //   508: astore 6
    //   510: goto -229 -> 281
    //   513: astore_1
    //   514: goto -233 -> 281
    //   517: astore_1
    //   518: aconst_null
    //   519: astore_1
    //   520: goto -276 -> 244
    //   523: astore_1
    //   524: aload 6
    //   526: astore_1
    //   527: goto -283 -> 244
    //   530: iconst_1
    //   531: istore_2
    //   532: goto -122 -> 410
    //   535: iconst_1
    //   536: istore_3
    //   537: goto -448 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	540	0	this	lyg
    //   0	540	1	paramString	String
    //   0	540	2	paramBoolean	boolean
    //   88	449	3	bool1	boolean
    //   105	129	4	bool2	boolean
    //   49	34	5	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   110	1	5	localIOException1	java.io.IOException
    //   207	197	5	str	String
    //   441	1	5	localIOException2	java.io.IOException
    //   60	465	6	localObjectInputStream	java.io.ObjectInputStream
    //   1	215	7	localVideoSerializeData	VideoSerializeData
    // Exception table:
    //   from	to	target	type
    //   82	87	110	java/io/IOException
    //   12	51	238	java/io/FileNotFoundException
    //   12	51	274	java/io/OptionalDataException
    //   12	51	313	java/lang/ClassNotFoundException
    //   12	51	352	java/io/IOException
    //   12	51	391	finally
    //   403	408	432	java/io/IOException
    //   94	99	438	java/lang/Exception
    //   249	254	441	java/io/IOException
    //   258	262	446	java/lang/Exception
    //   286	291	449	java/io/IOException
    //   296	301	453	java/lang/Exception
    //   325	330	456	java/io/IOException
    //   335	340	460	java/lang/Exception
    //   364	369	463	java/io/IOException
    //   374	379	467	java/lang/Exception
    //   415	420	470	java/lang/Exception
    //   51	62	473	finally
    //   67	77	480	finally
    //   51	62	484	java/io/IOException
    //   67	77	491	java/io/IOException
    //   51	62	495	java/lang/ClassNotFoundException
    //   67	77	502	java/lang/ClassNotFoundException
    //   51	62	506	java/io/OptionalDataException
    //   67	77	513	java/io/OptionalDataException
    //   51	62	517	java/io/FileNotFoundException
    //   67	77	523	java/io/FileNotFoundException
  }
  
  public void b()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      new Thread(new VideoConnRateReport.2(this)).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lyg
 * JD-Core Version:    0.7.0.1
 */