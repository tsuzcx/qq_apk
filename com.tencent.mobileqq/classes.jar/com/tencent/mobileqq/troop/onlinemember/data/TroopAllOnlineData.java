package com.tencent.mobileqq.troop.onlinemember.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.util.List;

public class TroopAllOnlineData
  extends Entity
{
  public static final String TAG = "TroopAllOnlineData";
  public List<String> memberUinList;
  public long nextReqTime;
  @unique
  public String troopUin;
  public byte[] uinData;
  
  /* Error */
  protected void postRead()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 29	com/tencent/mobileqq/persistence/Entity:postRead	()V
    //   4: aload_0
    //   5: getfield 31	com/tencent/mobileqq/troop/onlinemember/data/TroopAllOnlineData:uinData	[B
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +253 -> 263
    //   13: aload_2
    //   14: arraylength
    //   15: ifne +4 -> 19
    //   18: return
    //   19: aconst_null
    //   20: astore_3
    //   21: aconst_null
    //   22: astore_1
    //   23: new 33	java/io/ObjectInputStream
    //   26: dup
    //   27: new 35	java/io/ByteArrayInputStream
    //   30: dup
    //   31: aload_2
    //   32: invokespecial 38	java/io/ByteArrayInputStream:<init>	([B)V
    //   35: invokespecial 41	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore_2
    //   39: aload_2
    //   40: invokevirtual 45	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   43: astore_1
    //   44: aload_1
    //   45: instanceof 47
    //   48: ifeq +11 -> 59
    //   51: aload_0
    //   52: aload_1
    //   53: checkcast 47	java/util/List
    //   56: putfield 49	com/tencent/mobileqq/troop/onlinemember/data/TroopAllOnlineData:memberUinList	Ljava/util/List;
    //   59: aload_2
    //   60: invokevirtual 52	java/io/ObjectInputStream:close	()V
    //   63: return
    //   64: astore_1
    //   65: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +140 -> 208
    //   71: new 60	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   78: astore_2
    //   79: aload_2
    //   80: ldc 63
    //   82: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_2
    //   87: aload_1
    //   88: invokevirtual 71	java/io/IOException:toString	()Ljava/lang/String;
    //   91: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: ldc 8
    //   97: iconst_2
    //   98: aload_2
    //   99: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: return
    //   106: astore_3
    //   107: aload_2
    //   108: astore_1
    //   109: aload_3
    //   110: astore_2
    //   111: goto +98 -> 209
    //   114: astore_3
    //   115: goto +12 -> 127
    //   118: astore_2
    //   119: goto +90 -> 209
    //   122: astore_1
    //   123: aload_3
    //   124: astore_2
    //   125: aload_1
    //   126: astore_3
    //   127: aload_2
    //   128: astore_1
    //   129: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +49 -> 181
    //   135: aload_2
    //   136: astore_1
    //   137: new 60	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   144: astore 4
    //   146: aload_2
    //   147: astore_1
    //   148: aload 4
    //   150: ldc 63
    //   152: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_2
    //   157: astore_1
    //   158: aload 4
    //   160: aload_3
    //   161: invokevirtual 77	java/lang/Exception:toString	()Ljava/lang/String;
    //   164: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_2
    //   169: astore_1
    //   170: ldc 8
    //   172: iconst_2
    //   173: aload 4
    //   175: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aload_2
    //   182: ifnull +26 -> 208
    //   185: aload_2
    //   186: invokevirtual 52	java/io/ObjectInputStream:close	()V
    //   189: return
    //   190: astore_1
    //   191: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +14 -> 208
    //   197: new 60	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   204: astore_2
    //   205: goto -126 -> 79
    //   208: return
    //   209: aload_1
    //   210: ifnull +51 -> 261
    //   213: aload_1
    //   214: invokevirtual 52	java/io/ObjectInputStream:close	()V
    //   217: goto +44 -> 261
    //   220: astore_1
    //   221: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq +37 -> 261
    //   227: new 60	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   234: astore_3
    //   235: aload_3
    //   236: ldc 63
    //   238: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_3
    //   243: aload_1
    //   244: invokevirtual 71	java/io/IOException:toString	()Ljava/lang/String;
    //   247: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: ldc 8
    //   253: iconst_2
    //   254: aload_3
    //   255: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload_2
    //   262: athrow
    //   263: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	TroopAllOnlineData
    //   22	31	1	localObject1	java.lang.Object
    //   64	24	1	localIOException1	java.io.IOException
    //   108	1	1	localObject2	java.lang.Object
    //   122	4	1	localException1	java.lang.Exception
    //   128	42	1	localObject3	java.lang.Object
    //   190	24	1	localIOException2	java.io.IOException
    //   220	24	1	localIOException3	java.io.IOException
    //   8	103	2	localObject4	java.lang.Object
    //   118	1	2	localObject5	java.lang.Object
    //   124	138	2	localObject6	java.lang.Object
    //   20	1	3	localObject7	java.lang.Object
    //   106	4	3	localObject8	java.lang.Object
    //   114	10	3	localException2	java.lang.Exception
    //   126	129	3	localObject9	java.lang.Object
    //   144	30	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   59	63	64	java/io/IOException
    //   39	59	106	finally
    //   39	59	114	java/lang/Exception
    //   23	39	118	finally
    //   129	135	118	finally
    //   137	146	118	finally
    //   148	156	118	finally
    //   158	168	118	finally
    //   170	181	118	finally
    //   23	39	122	java/lang/Exception
    //   185	189	190	java/io/IOException
    //   213	217	220	java/io/IOException
  }
  
  /* Error */
  protected void prewrite()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 80	com/tencent/mobileqq/persistence/Entity:prewrite	()V
    //   4: aload_0
    //   5: getfield 49	com/tencent/mobileqq/troop/onlinemember/data/TroopAllOnlineData:memberUinList	Ljava/util/List;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +257 -> 267
    //   13: aload_1
    //   14: invokeinterface 84 1 0
    //   19: ifne +4 -> 23
    //   22: return
    //   23: new 86	java/io/ByteArrayOutputStream
    //   26: dup
    //   27: invokespecial 87	java/io/ByteArrayOutputStream:<init>	()V
    //   30: astore_3
    //   31: new 89	java/io/ObjectOutputStream
    //   34: dup
    //   35: aload_3
    //   36: invokespecial 92	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   39: astore_2
    //   40: aload_2
    //   41: astore_1
    //   42: aload_2
    //   43: aload_0
    //   44: getfield 49	com/tencent/mobileqq/troop/onlinemember/data/TroopAllOnlineData:memberUinList	Ljava/util/List;
    //   47: invokevirtual 96	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   50: aload_2
    //   51: astore_1
    //   52: aload_2
    //   53: invokevirtual 99	java/io/ObjectOutputStream:flush	()V
    //   56: aload_2
    //   57: astore_1
    //   58: aload_0
    //   59: aload_3
    //   60: invokevirtual 103	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   63: putfield 31	com/tencent/mobileqq/troop/onlinemember/data/TroopAllOnlineData:uinData	[B
    //   66: aload_2
    //   67: invokevirtual 104	java/io/ObjectOutputStream:close	()V
    //   70: return
    //   71: astore_1
    //   72: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +132 -> 207
    //   78: new 60	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   85: astore_2
    //   86: aload_2
    //   87: ldc 106
    //   89: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_2
    //   94: aload_1
    //   95: invokevirtual 71	java/io/IOException:toString	()Ljava/lang/String;
    //   98: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: ldc 8
    //   104: iconst_2
    //   105: aload_2
    //   106: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: return
    //   113: astore_3
    //   114: goto +12 -> 126
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_2
    //   120: goto +93 -> 213
    //   123: astore_3
    //   124: aconst_null
    //   125: astore_2
    //   126: aload_2
    //   127: astore_1
    //   128: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +49 -> 180
    //   134: aload_2
    //   135: astore_1
    //   136: new 60	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   143: astore 4
    //   145: aload_2
    //   146: astore_1
    //   147: aload 4
    //   149: ldc 106
    //   151: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_2
    //   156: astore_1
    //   157: aload 4
    //   159: aload_3
    //   160: invokevirtual 71	java/io/IOException:toString	()Ljava/lang/String;
    //   163: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_2
    //   168: astore_1
    //   169: ldc 8
    //   171: iconst_2
    //   172: aload 4
    //   174: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aload_2
    //   181: ifnull +26 -> 207
    //   184: aload_2
    //   185: invokevirtual 104	java/io/ObjectOutputStream:close	()V
    //   188: return
    //   189: astore_1
    //   190: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +14 -> 207
    //   196: new 60	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   203: astore_2
    //   204: goto -118 -> 86
    //   207: return
    //   208: astore_3
    //   209: aload_1
    //   210: astore_2
    //   211: aload_3
    //   212: astore_1
    //   213: aload_2
    //   214: ifnull +51 -> 265
    //   217: aload_2
    //   218: invokevirtual 104	java/io/ObjectOutputStream:close	()V
    //   221: goto +44 -> 265
    //   224: astore_2
    //   225: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   228: ifeq +37 -> 265
    //   231: new 60	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   238: astore_3
    //   239: aload_3
    //   240: ldc 106
    //   242: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_3
    //   247: aload_2
    //   248: invokevirtual 71	java/io/IOException:toString	()Ljava/lang/String;
    //   251: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: ldc 8
    //   257: iconst_2
    //   258: aload_3
    //   259: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: aload_1
    //   266: athrow
    //   267: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	TroopAllOnlineData
    //   8	50	1	localObject1	java.lang.Object
    //   71	24	1	localIOException1	java.io.IOException
    //   117	1	1	localObject2	java.lang.Object
    //   127	42	1	localObject3	java.lang.Object
    //   189	21	1	localIOException2	java.io.IOException
    //   212	54	1	localObject4	java.lang.Object
    //   39	179	2	localObject5	java.lang.Object
    //   224	24	2	localIOException3	java.io.IOException
    //   30	30	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   113	1	3	localIOException4	java.io.IOException
    //   123	37	3	localIOException5	java.io.IOException
    //   208	4	3	localObject6	java.lang.Object
    //   238	21	3	localStringBuilder1	java.lang.StringBuilder
    //   143	30	4	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   66	70	71	java/io/IOException
    //   42	50	113	java/io/IOException
    //   52	56	113	java/io/IOException
    //   58	66	113	java/io/IOException
    //   23	40	117	finally
    //   23	40	123	java/io/IOException
    //   184	188	189	java/io/IOException
    //   42	50	208	finally
    //   52	56	208	finally
    //   58	66	208	finally
    //   128	134	208	finally
    //   136	145	208	finally
    //   147	155	208	finally
    //   157	167	208	finally
    //   169	180	208	finally
    //   217	221	224	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.onlinemember.data.TroopAllOnlineData
 * JD-Core Version:    0.7.0.1
 */