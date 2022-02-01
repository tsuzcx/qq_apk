package com.tencent.mobileqq.transfile;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StructLongMessageIpSaver
  implements INetInfoHandler
{
  private static final String LONG_MSG_IPLIST;
  private static final String LONG_MSG_IPLIST_TMP;
  public static final String TAG = "StructLongMessageIpSaver";
  private int connectionFlag = 0;
  private String ipCellular = null;
  private String ipWifi = null;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_DATABASE);
    localStringBuilder.append("longMsgList.ini");
    LONG_MSG_IPLIST = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_DATABASE);
    localStringBuilder.append("longMsgList.tmp");
    LONG_MSG_IPLIST_TMP = localStringBuilder.toString();
  }
  
  public StructLongMessageIpSaver()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this);
    initConnectionFlag();
    readFromFile();
  }
  
  private boolean checkLegality(String paramString)
  {
    return Pattern.compile("^http://((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])(:(\\d{1,4}|[1-5]\\d\\d\\d\\d|6[0-4]\\d\\d\\d|65[0-4]\\d\\d|655[0-2]\\d|6553[0-5]))?/$").matcher(paramString).matches();
  }
  
  private void initConnectionFlag()
  {
    try
    {
      int i = NetworkUtil.getNetworkType(BaseApplicationImpl.getContext());
      if (i != 0)
      {
        if (i == 1) {
          this.connectionFlag = 2;
        }
      }
      else {
        this.connectionFlag = 1;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  private void readFromFile()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_2
    //   8: aload_2
    //   9: astore_1
    //   10: getstatic 40	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:LONG_MSG_IPLIST	Ljava/lang/String;
    //   13: invokestatic 112	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   16: astore_3
    //   17: aload_2
    //   18: astore_1
    //   19: aload_3
    //   20: invokevirtual 118	java/io/File:length	()J
    //   23: lconst_0
    //   24: lcmp
    //   25: ifne +22 -> 47
    //   28: aload_2
    //   29: astore_1
    //   30: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +224 -> 257
    //   36: aload_2
    //   37: astore_1
    //   38: ldc 12
    //   40: iconst_2
    //   41: ldc 125
    //   43: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: return
    //   47: aload_2
    //   48: astore_1
    //   49: new 131	java/io/BufferedReader
    //   52: dup
    //   53: new 133	java/io/InputStreamReader
    //   56: dup
    //   57: new 135	java/io/FileInputStream
    //   60: dup
    //   61: aload_3
    //   62: invokespecial 138	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   65: invokespecial 141	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   68: invokespecial 144	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   71: astore_2
    //   72: aload_0
    //   73: aload_2
    //   74: invokevirtual 147	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   77: putfield 50	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:ipWifi	Ljava/lang/String;
    //   80: aload_0
    //   81: aload_2
    //   82: invokevirtual 147	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   85: putfield 52	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:ipCellular	Ljava/lang/String;
    //   88: aload_0
    //   89: getfield 50	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:ipWifi	Ljava/lang/String;
    //   92: ifnull +14 -> 106
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 50	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:ipWifi	Ljava/lang/String;
    //   100: invokespecial 149	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:checkLegality	(Ljava/lang/String;)Z
    //   103: ifne +8 -> 111
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield 50	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:ipWifi	Ljava/lang/String;
    //   111: aload_0
    //   112: getfield 52	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:ipCellular	Ljava/lang/String;
    //   115: ifnull +14 -> 129
    //   118: aload_0
    //   119: aload_0
    //   120: getfield 52	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:ipCellular	Ljava/lang/String;
    //   123: invokespecial 149	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:checkLegality	(Ljava/lang/String;)Z
    //   126: ifne +8 -> 134
    //   129: aload_0
    //   130: aconst_null
    //   131: putfield 52	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:ipCellular	Ljava/lang/String;
    //   134: aload_2
    //   135: invokevirtual 152	java/io/BufferedReader:close	()V
    //   138: return
    //   139: astore_3
    //   140: aload_2
    //   141: astore_1
    //   142: aload_3
    //   143: astore_2
    //   144: goto +95 -> 239
    //   147: astore_3
    //   148: goto +15 -> 163
    //   151: astore_3
    //   152: goto +48 -> 200
    //   155: astore_2
    //   156: goto +83 -> 239
    //   159: astore_3
    //   160: aload 4
    //   162: astore_2
    //   163: aload_2
    //   164: astore_1
    //   165: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +13 -> 181
    //   171: aload_2
    //   172: astore_1
    //   173: ldc 12
    //   175: iconst_2
    //   176: ldc 154
    //   178: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aload_2
    //   182: astore_1
    //   183: aload_3
    //   184: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   187: aload_2
    //   188: ifnull +50 -> 238
    //   191: aload_2
    //   192: invokevirtual 152	java/io/BufferedReader:close	()V
    //   195: return
    //   196: astore_3
    //   197: aload 5
    //   199: astore_2
    //   200: aload_2
    //   201: astore_1
    //   202: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +13 -> 218
    //   208: aload_2
    //   209: astore_1
    //   210: ldc 12
    //   212: iconst_2
    //   213: ldc 159
    //   215: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload_2
    //   219: astore_1
    //   220: aload_3
    //   221: invokevirtual 160	java/io/FileNotFoundException:printStackTrace	()V
    //   224: aload_2
    //   225: ifnull +13 -> 238
    //   228: aload_2
    //   229: invokevirtual 152	java/io/BufferedReader:close	()V
    //   232: return
    //   233: astore_1
    //   234: aload_1
    //   235: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   238: return
    //   239: aload_1
    //   240: ifnull +15 -> 255
    //   243: aload_1
    //   244: invokevirtual 152	java/io/BufferedReader:close	()V
    //   247: goto +8 -> 255
    //   250: astore_1
    //   251: aload_1
    //   252: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   255: aload_2
    //   256: athrow
    //   257: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	StructLongMessageIpSaver
    //   9	211	1	localObject1	Object
    //   233	11	1	localIOException1	java.io.IOException
    //   250	2	1	localIOException2	java.io.IOException
    //   7	137	2	localObject2	Object
    //   155	1	2	localObject3	Object
    //   162	94	2	localObject4	Object
    //   16	46	3	localFile	java.io.File
    //   139	4	3	localObject5	Object
    //   147	1	3	localException1	java.lang.Exception
    //   151	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   159	25	3	localException2	java.lang.Exception
    //   196	25	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	160	4	localObject6	Object
    //   4	194	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   72	106	139	finally
    //   106	111	139	finally
    //   111	129	139	finally
    //   129	134	139	finally
    //   72	106	147	java/lang/Exception
    //   106	111	147	java/lang/Exception
    //   111	129	147	java/lang/Exception
    //   129	134	147	java/lang/Exception
    //   72	106	151	java/io/FileNotFoundException
    //   106	111	151	java/io/FileNotFoundException
    //   111	129	151	java/io/FileNotFoundException
    //   129	134	151	java/io/FileNotFoundException
    //   10	17	155	finally
    //   19	28	155	finally
    //   30	36	155	finally
    //   38	46	155	finally
    //   49	72	155	finally
    //   165	171	155	finally
    //   173	181	155	finally
    //   183	187	155	finally
    //   202	208	155	finally
    //   210	218	155	finally
    //   220	224	155	finally
    //   10	17	159	java/lang/Exception
    //   19	28	159	java/lang/Exception
    //   30	36	159	java/lang/Exception
    //   38	46	159	java/lang/Exception
    //   49	72	159	java/lang/Exception
    //   10	17	196	java/io/FileNotFoundException
    //   19	28	196	java/io/FileNotFoundException
    //   30	36	196	java/io/FileNotFoundException
    //   38	46	196	java/io/FileNotFoundException
    //   49	72	196	java/io/FileNotFoundException
    //   134	138	233	java/io/IOException
    //   191	195	233	java/io/IOException
    //   228	232	233	java/io/IOException
    //   243	247	250	java/io/IOException
  }
  
  /* Error */
  private void writeToFile()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_2
    //   11: astore_1
    //   12: getstatic 40	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:LONG_MSG_IPLIST	Ljava/lang/String;
    //   15: invokestatic 112	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   18: astore_3
    //   19: aload_2
    //   20: astore_1
    //   21: aload_3
    //   22: invokevirtual 165	java/io/File:exists	()Z
    //   25: ifeq +10 -> 35
    //   28: aload_2
    //   29: astore_1
    //   30: aload_3
    //   31: invokevirtual 168	java/io/File:delete	()Z
    //   34: pop
    //   35: aload_2
    //   36: astore_1
    //   37: aload_0
    //   38: getfield 50	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:ipWifi	Ljava/lang/String;
    //   41: ifnonnull +19 -> 60
    //   44: aload_2
    //   45: astore_1
    //   46: aload_0
    //   47: getfield 52	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:ipCellular	Ljava/lang/String;
    //   50: astore 6
    //   52: aload 6
    //   54: ifnonnull +6 -> 60
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: aload_2
    //   61: astore_1
    //   62: getstatic 44	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:LONG_MSG_IPLIST_TMP	Ljava/lang/String;
    //   65: invokestatic 112	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   68: astore 6
    //   70: aload_2
    //   71: astore_1
    //   72: aload 6
    //   74: invokevirtual 165	java/io/File:exists	()Z
    //   77: ifeq +11 -> 88
    //   80: aload_2
    //   81: astore_1
    //   82: aload 6
    //   84: invokevirtual 168	java/io/File:delete	()Z
    //   87: pop
    //   88: aload_2
    //   89: astore_1
    //   90: aload 6
    //   92: invokevirtual 171	java/io/File:createNewFile	()Z
    //   95: pop
    //   96: aload_2
    //   97: astore_1
    //   98: new 173	java/io/BufferedWriter
    //   101: dup
    //   102: new 175	java/io/OutputStreamWriter
    //   105: dup
    //   106: new 177	java/io/FileOutputStream
    //   109: dup
    //   110: aload 6
    //   112: invokespecial 178	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   115: invokespecial 181	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   118: invokespecial 184	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   121: astore_2
    //   122: aload_0
    //   123: getfield 50	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:ipWifi	Ljava/lang/String;
    //   126: ifnull +241 -> 367
    //   129: aload_0
    //   130: getfield 50	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:ipWifi	Ljava/lang/String;
    //   133: astore_1
    //   134: goto +3 -> 137
    //   137: aload_2
    //   138: aload_1
    //   139: invokevirtual 188	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   142: aload_2
    //   143: ldc 190
    //   145: invokevirtual 188	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   148: aload_0
    //   149: getfield 52	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:ipCellular	Ljava/lang/String;
    //   152: ifnull +221 -> 373
    //   155: aload_0
    //   156: getfield 52	com/tencent/mobileqq/transfile/StructLongMessageIpSaver:ipCellular	Ljava/lang/String;
    //   159: astore_1
    //   160: goto +3 -> 163
    //   163: aload_2
    //   164: aload_1
    //   165: invokevirtual 188	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   168: aload_2
    //   169: invokevirtual 193	java/io/BufferedWriter:flush	()V
    //   172: aload_2
    //   173: invokevirtual 194	java/io/BufferedWriter:close	()V
    //   176: aload 6
    //   178: ifnull +146 -> 324
    //   181: aload_3
    //   182: ifnull +142 -> 324
    //   185: aload 6
    //   187: aload_3
    //   188: invokevirtual 198	java/io/File:renameTo	(Ljava/io/File;)Z
    //   191: pop
    //   192: goto +132 -> 324
    //   195: astore_1
    //   196: aload_1
    //   197: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   200: goto +124 -> 324
    //   203: aload_1
    //   204: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   207: goto +117 -> 324
    //   210: astore_3
    //   211: aload_2
    //   212: astore_1
    //   213: aload_3
    //   214: astore_2
    //   215: goto +112 -> 327
    //   218: astore_3
    //   219: goto +15 -> 234
    //   222: astore_3
    //   223: goto +58 -> 281
    //   226: astore_2
    //   227: goto +100 -> 327
    //   230: astore_3
    //   231: aload 4
    //   233: astore_2
    //   234: aload_2
    //   235: astore_1
    //   236: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq +13 -> 252
    //   242: aload_2
    //   243: astore_1
    //   244: ldc 12
    //   246: iconst_2
    //   247: ldc 154
    //   249: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: aload_2
    //   253: astore_1
    //   254: aload_3
    //   255: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   258: aload_2
    //   259: ifnull +65 -> 324
    //   262: aload_2
    //   263: invokevirtual 194	java/io/BufferedWriter:close	()V
    //   266: goto +58 -> 324
    //   269: astore_1
    //   270: goto -74 -> 196
    //   273: astore_1
    //   274: goto -71 -> 203
    //   277: astore_3
    //   278: aload 5
    //   280: astore_2
    //   281: aload_2
    //   282: astore_1
    //   283: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq +13 -> 299
    //   289: aload_2
    //   290: astore_1
    //   291: ldc 12
    //   293: iconst_2
    //   294: ldc 159
    //   296: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload_2
    //   300: astore_1
    //   301: aload_3
    //   302: invokevirtual 160	java/io/FileNotFoundException:printStackTrace	()V
    //   305: aload_2
    //   306: ifnull +18 -> 324
    //   309: aload_2
    //   310: invokevirtual 194	java/io/BufferedWriter:close	()V
    //   313: goto +11 -> 324
    //   316: astore_1
    //   317: goto -121 -> 196
    //   320: astore_1
    //   321: goto -118 -> 203
    //   324: aload_0
    //   325: monitorexit
    //   326: return
    //   327: aload_1
    //   328: ifnull +27 -> 355
    //   331: aload_1
    //   332: invokevirtual 194	java/io/BufferedWriter:close	()V
    //   335: goto +20 -> 355
    //   338: astore_1
    //   339: goto +18 -> 357
    //   342: astore_1
    //   343: aload_1
    //   344: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   347: goto +8 -> 355
    //   350: astore_1
    //   351: aload_1
    //   352: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   355: aload_2
    //   356: athrow
    //   357: aload_0
    //   358: monitorexit
    //   359: goto +5 -> 364
    //   362: aload_1
    //   363: athrow
    //   364: goto -2 -> 362
    //   367: ldc 200
    //   369: astore_1
    //   370: goto -233 -> 137
    //   373: ldc 200
    //   375: astore_1
    //   376: goto -213 -> 163
    //   379: astore_1
    //   380: goto -177 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	this	StructLongMessageIpSaver
    //   11	154	1	localObject1	Object
    //   195	9	1	localException1	java.lang.Exception
    //   212	42	1	localObject2	Object
    //   269	1	1	localException2	java.lang.Exception
    //   273	1	1	localIOException1	java.io.IOException
    //   282	19	1	localObject3	Object
    //   316	1	1	localException3	java.lang.Exception
    //   320	12	1	localIOException2	java.io.IOException
    //   338	1	1	localObject4	Object
    //   342	2	1	localException4	java.lang.Exception
    //   350	13	1	localIOException3	java.io.IOException
    //   369	7	1	str	String
    //   379	1	1	localIOException4	java.io.IOException
    //   9	206	2	localObject5	Object
    //   226	1	2	localObject6	Object
    //   233	123	2	localObject7	Object
    //   18	170	3	localFile	java.io.File
    //   210	4	3	localObject8	Object
    //   218	1	3	localException5	java.lang.Exception
    //   222	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   230	25	3	localException6	java.lang.Exception
    //   277	25	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   3	229	4	localObject9	Object
    //   6	273	5	localObject10	Object
    //   50	136	6	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   172	176	195	java/lang/Exception
    //   185	192	195	java/lang/Exception
    //   122	134	210	finally
    //   137	160	210	finally
    //   163	172	210	finally
    //   122	134	218	java/lang/Exception
    //   137	160	218	java/lang/Exception
    //   163	172	218	java/lang/Exception
    //   122	134	222	java/io/FileNotFoundException
    //   137	160	222	java/io/FileNotFoundException
    //   163	172	222	java/io/FileNotFoundException
    //   12	19	226	finally
    //   21	28	226	finally
    //   30	35	226	finally
    //   37	44	226	finally
    //   46	52	226	finally
    //   62	70	226	finally
    //   72	80	226	finally
    //   82	88	226	finally
    //   90	96	226	finally
    //   98	122	226	finally
    //   236	242	226	finally
    //   244	252	226	finally
    //   254	258	226	finally
    //   283	289	226	finally
    //   291	299	226	finally
    //   301	305	226	finally
    //   12	19	230	java/lang/Exception
    //   21	28	230	java/lang/Exception
    //   30	35	230	java/lang/Exception
    //   37	44	230	java/lang/Exception
    //   46	52	230	java/lang/Exception
    //   62	70	230	java/lang/Exception
    //   72	80	230	java/lang/Exception
    //   82	88	230	java/lang/Exception
    //   90	96	230	java/lang/Exception
    //   98	122	230	java/lang/Exception
    //   262	266	269	java/lang/Exception
    //   262	266	273	java/io/IOException
    //   12	19	277	java/io/FileNotFoundException
    //   21	28	277	java/io/FileNotFoundException
    //   30	35	277	java/io/FileNotFoundException
    //   37	44	277	java/io/FileNotFoundException
    //   46	52	277	java/io/FileNotFoundException
    //   62	70	277	java/io/FileNotFoundException
    //   72	80	277	java/io/FileNotFoundException
    //   82	88	277	java/io/FileNotFoundException
    //   90	96	277	java/io/FileNotFoundException
    //   98	122	277	java/io/FileNotFoundException
    //   309	313	316	java/lang/Exception
    //   309	313	320	java/io/IOException
    //   172	176	338	finally
    //   185	192	338	finally
    //   196	200	338	finally
    //   203	207	338	finally
    //   262	266	338	finally
    //   309	313	338	finally
    //   331	335	338	finally
    //   343	347	338	finally
    //   351	355	338	finally
    //   355	357	338	finally
    //   331	335	342	java/lang/Exception
    //   331	335	350	java/io/IOException
    //   172	176	379	java/io/IOException
    //   185	192	379	java/io/IOException
  }
  
  public void deleteIp(ServerAddr paramServerAddr)
  {
    if (paramServerAddr == null) {
      return;
    }
    int j = 0;
    Object localObject = new StringBuilder(200);
    ((StringBuilder)localObject).append("http://");
    ((StringBuilder)localObject).append(paramServerAddr.mIp);
    if (paramServerAddr.port != 80)
    {
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramServerAddr.port);
    }
    ((StringBuilder)localObject).append("/");
    paramServerAddr = ((StringBuilder)localObject).toString();
    localObject = this.ipWifi;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (((String)localObject).equals(paramServerAddr))
      {
        this.ipWifi = null;
        i = 1;
      }
    }
    localObject = this.ipCellular;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (((String)localObject).equals(paramServerAddr))
      {
        this.ipCellular = null;
        j = 1;
      }
    }
    if (j != 0) {
      writeToFile();
    }
  }
  
  public void destroy()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this);
  }
  
  public int getConnectionFlag()
  {
    try
    {
      int i = this.connectionFlag;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getIp()
  {
    int i = this.connectionFlag;
    if (i != 1)
    {
      if (i != 2) {
        return null;
      }
      return this.ipWifi;
    }
    return this.ipCellular;
  }
  
  public void onNetMobile2None()
  {
    try
    {
      this.connectionFlag = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    try
    {
      this.connectionFlag = 2;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    try
    {
      this.connectionFlag = 1;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    try
    {
      this.connectionFlag = 2;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    try
    {
      this.connectionFlag = 1;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetWifi2None()
  {
    try
    {
      this.connectionFlag = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void saveIp(ServerAddr paramServerAddr)
  {
    if ((paramServerAddr != null) && (this.connectionFlag != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder(200);
      localStringBuilder.append("http://");
      localStringBuilder.append(paramServerAddr.mIp);
      if (paramServerAddr.port != 80)
      {
        localStringBuilder.append(":");
        localStringBuilder.append(paramServerAddr.port);
      }
      localStringBuilder.append("/");
      paramServerAddr = localStringBuilder.toString();
      int i = this.connectionFlag;
      if (i == 1) {
        this.ipCellular = paramServerAddr;
      } else if (i == 2) {
        this.ipWifi = paramServerAddr;
      }
      writeToFile();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.StructLongMessageIpSaver
 * JD-Core Version:    0.7.0.1
 */