package org.xwalk.core;

import android.os.AsyncTask;
import java.io.File;

public class XWalkLibraryLoader$HttpDownloadTask
  extends AsyncTask<Void, Integer, Integer>
{
  private static final int DOWNLOAD_FAILED = -1;
  private static final int DOWNLOAD_SUCCESS = 0;
  private static final int UPDATE_INTERVAL_MS = 500;
  private static final String XWALK_DOWNLOAD_DIR = "xwalk_download";
  private XWalkLibraryLoader.DownloadInfo mDownloadInfo;
  private File mDownloadedFile;
  private XWalkLibraryLoader.DownloadListener mListener;
  private long mProgressUpdateTime;
  
  public XWalkLibraryLoader$HttpDownloadTask(boolean paramBoolean, XWalkLibraryLoader.DownloadListener paramDownloadListener, String paramString1, String paramString2)
  {
    this.mListener = paramDownloadListener;
    this.mDownloadInfo = new XWalkLibraryLoader.DownloadInfo();
    paramDownloadListener = this.mDownloadInfo;
    paramDownloadListener.mErrorType = 0;
    paramDownloadListener.mErrorCode = 0;
    paramDownloadListener.mDownloadType = 1;
    paramDownloadListener.mUrl = paramString1;
    paramDownloadListener.mSavePath = paramString2;
    paramDownloadListener.mIsRuntime = paramBoolean;
  }
  
  /* Error */
  protected Integer doInBackground(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mListener	Lorg/xwalk/core/XWalkLibraryLoader$DownloadListener;
    //   4: aload_0
    //   5: getfield 36	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWalkLibraryLoader$DownloadInfo;
    //   8: getfield 45	org/xwalk/core/XWalkLibraryLoader$DownloadInfo:mDownloadType	I
    //   11: invokeinterface 68 2 0
    //   16: aload_0
    //   17: getfield 36	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWalkLibraryLoader$DownloadInfo;
    //   20: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   23: putfield 77	org/xwalk/core/XWalkLibraryLoader$DownloadInfo:mStartTimestamp	J
    //   26: invokestatic 83	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 36	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWalkLibraryLoader$DownloadInfo;
    //   34: aload_1
    //   35: invokestatic 89	org/xwalk/core/NetworkUtil:getCurrentNetWorkStatus	(Landroid/content/Context;)I
    //   38: putfield 92	org/xwalk/core/XWalkLibraryLoader$DownloadInfo:mNetWorkType	I
    //   41: new 94	java/net/URL
    //   44: dup
    //   45: aload_0
    //   46: getfield 36	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWalkLibraryLoader$DownloadInfo;
    //   49: getfield 48	org/xwalk/core/XWalkLibraryLoader$DownloadInfo:mUrl	Ljava/lang/String;
    //   52: invokespecial 97	java/net/URL:<init>	(Ljava/lang/String;)V
    //   55: astore_1
    //   56: aload_1
    //   57: invokevirtual 101	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   60: checkcast 103	java/net/HttpURLConnection
    //   63: astore 11
    //   65: aload 11
    //   67: sipush 30000
    //   70: invokevirtual 106	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   73: aload 11
    //   75: sipush 30000
    //   78: invokevirtual 109	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   81: aload 11
    //   83: invokevirtual 112	java/net/HttpURLConnection:connect	()V
    //   86: aload 11
    //   88: invokevirtual 116	java/net/HttpURLConnection:getResponseCode	()I
    //   91: istore_2
    //   92: iload_2
    //   93: sipush 200
    //   96: if_icmpeq +80 -> 176
    //   99: aload 11
    //   101: invokevirtual 116	java/net/HttpURLConnection:getResponseCode	()I
    //   104: sipush 206
    //   107: if_icmpeq +69 -> 176
    //   110: new 118	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   117: astore_1
    //   118: aload_1
    //   119: ldc 121
    //   121: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_1
    //   126: aload 11
    //   128: invokevirtual 116	java/net/HttpURLConnection:getResponseCode	()I
    //   131: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_1
    //   136: ldc 130
    //   138: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_1
    //   143: aload 11
    //   145: invokevirtual 134	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   148: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: ldc 136
    //   154: aload_1
    //   155: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 145	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload 11
    //   163: ifnull +8 -> 171
    //   166: aload 11
    //   168: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   171: iconst_m1
    //   172: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: areturn
    //   176: aload 11
    //   178: invokevirtual 157	java/net/HttpURLConnection:getContentLength	()I
    //   181: istore_2
    //   182: aload_0
    //   183: getfield 159	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
    //   186: invokevirtual 165	java/io/File:exists	()Z
    //   189: istore 4
    //   191: lconst_0
    //   192: lstore 7
    //   194: iload 4
    //   196: ifeq +275 -> 471
    //   199: aload_0
    //   200: getfield 159	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
    //   203: invokevirtual 168	java/io/File:length	()J
    //   206: lstore 5
    //   208: iload_2
    //   209: i2l
    //   210: lload 5
    //   212: lcmp
    //   213: ifne +25 -> 238
    //   216: ldc 136
    //   218: ldc 170
    //   220: invokestatic 173	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload 11
    //   225: ifnull +8 -> 233
    //   228: aload 11
    //   230: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   233: iconst_0
    //   234: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: areturn
    //   238: lload 5
    //   240: lconst_0
    //   241: lcmp
    //   242: ifle +18 -> 260
    //   245: aload_0
    //   246: getfield 36	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWalkLibraryLoader$DownloadInfo;
    //   249: iconst_1
    //   250: putfield 176	org/xwalk/core/XWalkLibraryLoader$DownloadInfo:mIsDownloadResume	Z
    //   253: ldc 136
    //   255: ldc 178
    //   257: invokestatic 173	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: aload 11
    //   262: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   265: aload_1
    //   266: invokevirtual 101	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   269: checkcast 103	java/net/HttpURLConnection
    //   272: astore_1
    //   273: aload_1
    //   274: sipush 30000
    //   277: invokevirtual 106	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   280: aload_1
    //   281: sipush 30000
    //   284: invokevirtual 109	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   287: new 118	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   294: astore 11
    //   296: aload 11
    //   298: ldc 180
    //   300: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload 11
    //   306: lload 5
    //   308: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 11
    //   314: ldc 185
    //   316: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload_1
    //   321: ldc 187
    //   323: aload 11
    //   325: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokevirtual 190	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: new 118	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   338: astore 11
    //   340: aload 11
    //   342: ldc 192
    //   344: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload 11
    //   350: lload 5
    //   352: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: ldc 136
    //   358: aload 11
    //   360: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 173	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload_1
    //   367: invokevirtual 112	java/net/HttpURLConnection:connect	()V
    //   370: aload_1
    //   371: invokevirtual 116	java/net/HttpURLConnection:getResponseCode	()I
    //   374: sipush 200
    //   377: if_icmpeq +81 -> 458
    //   380: aload_1
    //   381: invokevirtual 116	java/net/HttpURLConnection:getResponseCode	()I
    //   384: sipush 206
    //   387: if_icmpeq +71 -> 458
    //   390: new 118	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   397: astore 11
    //   399: aload 11
    //   401: ldc 121
    //   403: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 11
    //   409: aload_1
    //   410: invokevirtual 116	java/net/HttpURLConnection:getResponseCode	()I
    //   413: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload 11
    //   419: ldc 130
    //   421: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload 11
    //   427: aload_1
    //   428: invokevirtual 134	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   431: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: ldc 136
    //   437: aload 11
    //   439: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 145	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: aload_1
    //   446: ifnull +7 -> 453
    //   449: aload_1
    //   450: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   453: iconst_m1
    //   454: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   457: areturn
    //   458: aload_1
    //   459: invokevirtual 157	java/net/HttpURLConnection:getContentLength	()I
    //   462: istore_2
    //   463: goto +14 -> 477
    //   466: astore 11
    //   468: goto +318 -> 786
    //   471: aload 11
    //   473: astore_1
    //   474: lconst_0
    //   475: lstore 5
    //   477: aload_1
    //   478: invokevirtual 196	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   481: astore 12
    //   483: new 198	java/io/FileOutputStream
    //   486: dup
    //   487: aload_0
    //   488: getfield 159	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
    //   491: iconst_1
    //   492: invokespecial 201	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   495: astore 11
    //   497: aload_1
    //   498: astore 13
    //   500: aload_1
    //   501: astore 14
    //   503: sipush 4096
    //   506: newarray byte
    //   508: astore 15
    //   510: aload_1
    //   511: astore 13
    //   513: aload_1
    //   514: astore 14
    //   516: aload 12
    //   518: aload 15
    //   520: invokevirtual 207	java/io/InputStream:read	([B)I
    //   523: istore_3
    //   524: iload_3
    //   525: iconst_m1
    //   526: if_icmpeq +140 -> 666
    //   529: aload_1
    //   530: astore 13
    //   532: aload_1
    //   533: astore 14
    //   535: aload_0
    //   536: invokevirtual 210	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:isCancelled	()Z
    //   539: istore 4
    //   541: iload 4
    //   543: ifeq +35 -> 578
    //   546: aload 11
    //   548: invokevirtual 215	java/io/OutputStream:close	()V
    //   551: aload 12
    //   553: ifnull +8 -> 561
    //   556: aload 12
    //   558: invokevirtual 216	java/io/InputStream:close	()V
    //   561: aload_1
    //   562: ifnull +7 -> 569
    //   565: aload_1
    //   566: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   569: iconst_m1
    //   570: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   573: areturn
    //   574: astore_1
    //   575: goto +276 -> 851
    //   578: lload 7
    //   580: iload_3
    //   581: i2l
    //   582: ladd
    //   583: lstore 7
    //   585: aload_1
    //   586: astore 13
    //   588: aload_1
    //   589: astore 14
    //   591: aload 11
    //   593: aload 15
    //   595: iconst_0
    //   596: iload_3
    //   597: invokevirtual 220	java/io/OutputStream:write	([BII)V
    //   600: aload_1
    //   601: astore 13
    //   603: aload_1
    //   604: astore 14
    //   606: invokestatic 225	android/os/SystemClock:uptimeMillis	()J
    //   609: lstore 9
    //   611: lload 9
    //   613: aload_0
    //   614: getfield 227	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mProgressUpdateTime	J
    //   617: lsub
    //   618: ldc2_w 228
    //   621: lcmp
    //   622: ifle +322 -> 944
    //   625: aload_0
    //   626: lload 9
    //   628: putfield 227	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mProgressUpdateTime	J
    //   631: aload_0
    //   632: iconst_2
    //   633: anewarray 150	java/lang/Integer
    //   636: dup
    //   637: iconst_0
    //   638: lload 7
    //   640: lload 5
    //   642: ladd
    //   643: l2i
    //   644: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   647: aastore
    //   648: dup
    //   649: iconst_1
    //   650: iload_2
    //   651: i2l
    //   652: lload 5
    //   654: ladd
    //   655: l2i
    //   656: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   659: aastore
    //   660: invokevirtual 233	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:publishProgress	([Ljava/lang/Object;)V
    //   663: goto +281 -> 944
    //   666: aload_1
    //   667: astore 13
    //   669: aload 11
    //   671: invokevirtual 236	java/io/OutputStream:flush	()V
    //   674: aload 11
    //   676: invokevirtual 215	java/io/OutputStream:close	()V
    //   679: aload 12
    //   681: ifnull +8 -> 689
    //   684: aload 12
    //   686: invokevirtual 216	java/io/InputStream:close	()V
    //   689: aload 13
    //   691: ifnull +8 -> 699
    //   694: aload 13
    //   696: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   699: aload_0
    //   700: getfield 36	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWalkLibraryLoader$DownloadInfo;
    //   703: aload_0
    //   704: getfield 159	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
    //   707: invokevirtual 168	java/io/File:length	()J
    //   710: putfield 239	org/xwalk/core/XWalkLibraryLoader$DownloadInfo:mFileTotalSize	J
    //   713: iconst_0
    //   714: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   717: areturn
    //   718: astore 14
    //   720: aload_1
    //   721: astore 13
    //   723: aload 14
    //   725: astore_1
    //   726: goto +125 -> 851
    //   729: goto +84 -> 813
    //   732: astore_1
    //   733: goto +118 -> 851
    //   736: aload 14
    //   738: astore_1
    //   739: goto +74 -> 813
    //   742: astore 11
    //   744: aload_1
    //   745: astore 13
    //   747: goto +45 -> 792
    //   750: aconst_null
    //   751: astore 11
    //   753: goto +60 -> 813
    //   756: astore 11
    //   758: goto +28 -> 786
    //   761: goto +18 -> 779
    //   764: astore 12
    //   766: aload 11
    //   768: astore_1
    //   769: aload 12
    //   771: astore 11
    //   773: goto +13 -> 786
    //   776: aload 11
    //   778: astore_1
    //   779: goto +28 -> 807
    //   782: astore 11
    //   784: aconst_null
    //   785: astore_1
    //   786: aconst_null
    //   787: astore 12
    //   789: aload_1
    //   790: astore 13
    //   792: aconst_null
    //   793: astore 14
    //   795: aload 11
    //   797: astore_1
    //   798: aload 14
    //   800: astore 11
    //   802: goto +49 -> 851
    //   805: aconst_null
    //   806: astore_1
    //   807: aconst_null
    //   808: astore 11
    //   810: aconst_null
    //   811: astore 12
    //   813: aload 11
    //   815: ifnull +8 -> 823
    //   818: aload 11
    //   820: invokevirtual 215	java/io/OutputStream:close	()V
    //   823: aload 12
    //   825: ifnull +8 -> 833
    //   828: aload 12
    //   830: invokevirtual 216	java/io/InputStream:close	()V
    //   833: aload_1
    //   834: ifnull +7 -> 841
    //   837: aload_1
    //   838: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   841: iconst_m1
    //   842: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   845: areturn
    //   846: astore_1
    //   847: aload 11
    //   849: astore 14
    //   851: aload 11
    //   853: ifnull +8 -> 861
    //   856: aload 11
    //   858: invokevirtual 215	java/io/OutputStream:close	()V
    //   861: aload 12
    //   863: ifnull +8 -> 871
    //   866: aload 12
    //   868: invokevirtual 216	java/io/InputStream:close	()V
    //   871: aload 13
    //   873: ifnull +8 -> 881
    //   876: aload 13
    //   878: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   881: goto +5 -> 886
    //   884: aload_1
    //   885: athrow
    //   886: goto -2 -> 884
    //   889: astore_1
    //   890: goto -85 -> 805
    //   893: astore_1
    //   894: goto -118 -> 776
    //   897: astore 11
    //   899: goto -120 -> 779
    //   902: astore 11
    //   904: goto -143 -> 761
    //   907: astore 11
    //   909: goto -159 -> 750
    //   912: astore_1
    //   913: goto -177 -> 736
    //   916: astore_1
    //   917: goto -178 -> 739
    //   920: astore 11
    //   922: goto -361 -> 561
    //   925: astore 13
    //   927: goto -198 -> 729
    //   930: astore_1
    //   931: goto -242 -> 689
    //   934: astore 11
    //   936: goto -103 -> 833
    //   939: astore 11
    //   941: goto -70 -> 871
    //   944: goto -434 -> 510
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	947	0	this	HttpDownloadTask
    //   0	947	1	paramVarArgs	Void[]
    //   91	372	2	i	int
    //   523	4	3	j	int
    //   189	353	4	bool	boolean
    //   206	270	5	l1	long
    //   192	1	7	l2	long
    //   63	375	11	localObject1	java.lang.Object
    //   466	6	11	localObject2	java.lang.Object
    //   495	52	11	localFileOutputStream	java.io.FileOutputStream
    //   481	76	12	localInputStream	java.io.InputStream
    //   498	33	13	arrayOfVoid1	Void[]
    //   501	33	14	arrayOfVoid2	Void[]
    //   508	11	15	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   273	445	466	finally
    //   458	463	466	finally
    //   611	663	718	finally
    //   669	674	718	finally
    //   503	510	732	finally
    //   516	524	732	finally
    //   535	541	732	finally
    //   591	600	732	finally
    //   606	611	732	finally
    //   483	497	742	finally
    //   477	483	756	finally
    //   65	92	764	finally
    //   99	161	764	finally
    //   176	191	764	finally
    //   199	208	764	finally
    //   216	223	764	finally
    //   245	260	764	finally
    //   260	273	764	finally
    //   41	65	782	finally
    //   41	65	889	java/lang/Exception
    //   65	92	893	java/lang/Exception
    //   99	161	893	java/lang/Exception
    //   176	191	893	java/lang/Exception
    //   199	208	893	java/lang/Exception
    //   216	223	893	java/lang/Exception
    //   245	260	893	java/lang/Exception
    //   260	273	893	java/lang/Exception
    //   273	445	897	java/lang/Exception
    //   458	463	897	java/lang/Exception
    //   477	483	902	java/lang/Exception
    //   483	497	907	java/lang/Exception
    //   503	510	912	java/lang/Exception
    //   516	524	912	java/lang/Exception
    //   535	541	912	java/lang/Exception
    //   591	600	912	java/lang/Exception
    //   606	611	912	java/lang/Exception
    //   546	551	920	java/io/IOException
    //   556	561	920	java/io/IOException
    //   611	663	925	java/lang/Exception
    //   669	674	925	java/lang/Exception
    //   674	679	930	java/io/IOException
    //   684	689	930	java/io/IOException
    //   818	823	934	java/io/IOException
    //   828	833	934	java/io/IOException
    //   856	861	939	java/io/IOException
    //   866	871	939	java/io/IOException
  }
  
  protected void onCancelled(Integer paramInteger)
  {
    if (this.mDownloadInfo.mIsRuntime)
    {
      XWalkLibraryLoader.access$002(null);
      paramInteger = new StringBuilder();
      paramInteger.append("HttpDownloadTask runtime onCancelled: ");
      paramInteger.append(this.mDownloadInfo.mSavePath);
      Log.i("XWalkLib", paramInteger.toString());
    }
    else
    {
      paramInteger = new StringBuilder();
      paramInteger.append("HttpDownloadTask other onCancelled: ");
      paramInteger.append(this.mDownloadInfo.mSavePath);
      Log.i("XWalkLib", paramInteger.toString());
    }
    this.mListener.onDownloadCancelled();
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    StringBuilder localStringBuilder;
    if (this.mDownloadInfo.mIsRuntime)
    {
      XWalkLibraryLoader.access$002(null);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("HttpDownloadTask runtime onPostExecute result ");
      localStringBuilder.append(paramInteger);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.mDownloadInfo.mSavePath);
      Log.i("XWalkLib", localStringBuilder.toString());
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("HttpDownloadTask other onPostExecute result ");
      localStringBuilder.append(paramInteger);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.mDownloadInfo.mSavePath);
      Log.i("XWalkLib", localStringBuilder.toString());
    }
    if (paramInteger.intValue() == 0)
    {
      paramInteger = this.mDownloadInfo;
      paramInteger.mErrorCode = 0;
      this.mListener.onDownloadCompleted(paramInteger);
      return;
    }
    paramInteger = this.mDownloadInfo;
    paramInteger.mErrorCode = -1;
    this.mListener.onDownloadFailed(paramInteger);
  }
  
  protected void onPreExecute()
  {
    StringBuilder localStringBuilder;
    if (this.mDownloadInfo.mIsRuntime)
    {
      XWalkLibraryLoader.access$002(this);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("HttpDownloadTask runtime onPreExecute: ");
      localStringBuilder.append(this.mDownloadInfo.mSavePath);
      Log.i("XWalkLib", localStringBuilder.toString());
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("HttpDownloadTask other onPreExecute: ");
      localStringBuilder.append(this.mDownloadInfo.mSavePath);
      Log.i("XWalkLib", localStringBuilder.toString());
    }
    this.mDownloadedFile = new File(this.mDownloadInfo.mSavePath);
  }
  
  protected void onProgressUpdate(Integer... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HttpDownloadTask updated: ");
    int i = 0;
    localStringBuilder.append(paramVarArgs[0]);
    localStringBuilder.append("/");
    localStringBuilder.append(paramVarArgs[1]);
    Log.d("XWalkLib", localStringBuilder.toString());
    if (paramVarArgs[1].intValue() > 0)
    {
      double d1 = paramVarArgs[0].intValue();
      Double.isNaN(d1);
      double d2 = paramVarArgs[1].intValue();
      Double.isNaN(d2);
      i = (int)(d1 * 100.0D / d2);
    }
    this.mListener.onDownloadUpdated(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkLibraryLoader.HttpDownloadTask
 * JD-Core Version:    0.7.0.1
 */