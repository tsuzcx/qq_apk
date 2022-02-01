package cooperation.weiyun.sdk.download.processor;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.weiyun.transmission.db.JobDbWrapper;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import cooperation.weiyun.sdk.download.DownloadFile;
import cooperation.weiyun.sdk.download.DownloadJobContext;
import cooperation.weiyun.sdk.download.DownloadJobContext.StatusInfo;

public class InfoRecorder
  implements Handler.Callback
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "_id", "cloud_sha", "local_path" };
  private static final String[] b = { "_id", "uid", "cmd_type", "file_name", "p_dir_uid", "p_dir_key", "file_id", "cloud_sha", "file_size", "file_type", "file_version", "group_root_dir_key", "state", "error_code", "error_msg", "total_size", "cur_size", "local_path", "local_dir" };
  private final ReleaseLooperHandler jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler;
  private final InfoRecorder.InfoRecorderCallback jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder$InfoRecorderCallback;
  
  public InfoRecorder(InfoRecorder.InfoRecorderCallback paramInfoRecorderCallback, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder$InfoRecorderCallback = paramInfoRecorderCallback;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler = paramReleaseLooperHandler;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.addCallback(this);
  }
  
  private DownloadJobContext a(Cursor paramCursor)
  {
    Object localObject = DownloadFile.a(paramCursor.getInt(2), paramCursor.getString(6), paramCursor.getString(3), paramCursor.getString(7), paramCursor.getLong(8), paramCursor.getInt(9), paramCursor.getString(4), paramCursor.getString(5), null);
    ((DownloadFile)localObject).f = paramCursor.getString(11);
    DownloadJobContext.StatusInfo localStatusInfo = new DownloadJobContext.StatusInfo();
    localStatusInfo.jdField_a_of_type_Int = paramCursor.getInt(12);
    localStatusInfo.jdField_b_of_type_Int = paramCursor.getInt(13);
    localStatusInfo.jdField_a_of_type_JavaLangString = paramCursor.getString(14);
    localStatusInfo.jdField_a_of_type_Long = paramCursor.getLong(15);
    localStatusInfo.jdField_b_of_type_Long = paramCursor.getLong(16);
    localStatusInfo.jdField_b_of_type_JavaLangString = paramCursor.getString(17);
    localStatusInfo.c = ((DownloadFile)localObject).jdField_a_of_type_JavaLangString;
    localStatusInfo.d = paramCursor.getString(10);
    localObject = DownloadJobContext.a(paramCursor.getString(1), (DownloadFile)localObject, paramCursor.getString(18), localStatusInfo);
    ((DownloadJobContext)localObject).a(paramCursor.getLong(0));
    return localObject;
  }
  
  private void a(ContentValues paramContentValues, DownloadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean)
  {
    boolean bool = false;
    if ((paramContentValues == null) || (paramContentValues.size() <= 0)) {
      return;
    }
    long l = paramContentValues.getAsLong("_id").longValue();
    JobDbWrapper localJobDbWrapper = JobDbManager.getInstance().openJobDb(true);
    if (localJobDbWrapper == null)
    {
      i = 0;
      paramContentValues = this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder$InfoRecorderCallback;
      if (i > 0) {
        bool = true;
      }
      paramContentValues.a(l, bool, paramStatusInfo, paramBoolean);
      return;
    }
    if (l >= 0L) {}
    for (int i = localJobDbWrapper.update("download", paramContentValues, "_id=?", new String[] { Long.toString(l) });; i = 0)
    {
      JobDbManager.getInstance().closeJobDb(localJobDbWrapper);
      break;
    }
  }
  
  /* Error */
  private void b(int paramInt, DownloadJobContext paramDownloadJobContext)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: invokevirtual 184	cooperation/weiyun/sdk/download/DownloadJobContext:a	()Lcooperation/weiyun/sdk/download/DownloadFile;
    //   9: astore 12
    //   11: aload_2
    //   12: invokevirtual 187	cooperation/weiyun/sdk/download/DownloadJobContext:a	()Lcooperation/weiyun/sdk/download/DownloadJobContext$StatusInfo;
    //   15: astore 13
    //   17: invokestatic 151	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   20: iconst_1
    //   21: invokevirtual 155	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   24: astore 11
    //   26: aload 11
    //   28: ifnull -24 -> 4
    //   31: aload_2
    //   32: invokevirtual 190	cooperation/weiyun/sdk/download/DownloadJobContext:a	()Ljava/lang/String;
    //   35: astore 8
    //   37: aload 12
    //   39: getfield 114	cooperation/weiyun/sdk/download/DownloadFile:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: astore 10
    //   44: aload_2
    //   45: invokevirtual 192	cooperation/weiyun/sdk/download/DownloadJobContext:b	()Ljava/lang/String;
    //   48: astore 14
    //   50: new 194	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   57: ldc 25
    //   59: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 201
    //   64: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 35
    //   69: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 201
    //   74: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 55
    //   79: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 203
    //   84: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: astore 15
    //   89: aconst_null
    //   90: astore 9
    //   92: aload 11
    //   94: ldc 162
    //   96: getstatic 23	cooperation/weiyun/sdk/download/processor/InfoRecorder:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   99: aload 15
    //   101: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: iconst_3
    //   105: anewarray 15	java/lang/String
    //   108: dup
    //   109: iconst_0
    //   110: aload 8
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: aload 10
    //   117: aastore
    //   118: dup
    //   119: iconst_2
    //   120: aload 14
    //   122: aastore
    //   123: aconst_null
    //   124: aconst_null
    //   125: ldc 207
    //   127: invokevirtual 211	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   130: astore 8
    //   132: aload 8
    //   134: ifnull +549 -> 683
    //   137: aload 8
    //   139: invokeinterface 215 1 0
    //   144: ifeq +539 -> 683
    //   147: aload 8
    //   149: iconst_0
    //   150: invokeinterface 79 2 0
    //   155: istore_3
    //   156: iload_3
    //   157: i2l
    //   158: lstore 4
    //   160: aload 8
    //   162: iconst_1
    //   163: invokeinterface 83 2 0
    //   168: astore 9
    //   170: aload 8
    //   172: iconst_2
    //   173: invokeinterface 83 2 0
    //   178: astore 10
    //   180: aload 8
    //   182: invokestatic 221	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   185: aload 10
    //   187: astore 8
    //   189: aload 12
    //   191: getfield 222	cooperation/weiyun/sdk/download/DownloadFile:c	Ljava/lang/String;
    //   194: astore 10
    //   196: new 131	android/content/ContentValues
    //   199: dup
    //   200: invokespecial 223	android/content/ContentValues:<init>	()V
    //   203: astore 14
    //   205: aload 14
    //   207: ldc 25
    //   209: aload_2
    //   210: invokevirtual 190	cooperation/weiyun/sdk/download/DownloadJobContext:a	()Ljava/lang/String;
    //   213: invokevirtual 227	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload 14
    //   218: ldc 27
    //   220: aload 12
    //   222: getfield 228	cooperation/weiyun/sdk/download/DownloadFile:jdField_a_of_type_Int	I
    //   225: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   228: invokevirtual 237	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   231: aload 14
    //   233: ldc 29
    //   235: aload 12
    //   237: getfield 238	cooperation/weiyun/sdk/download/DownloadFile:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   240: invokevirtual 227	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload 14
    //   245: ldc 31
    //   247: aload 12
    //   249: getfield 239	cooperation/weiyun/sdk/download/DownloadFile:d	Ljava/lang/String;
    //   252: invokevirtual 227	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload 14
    //   257: ldc 33
    //   259: aload 12
    //   261: getfield 242	cooperation/weiyun/sdk/download/DownloadFile:e	Ljava/lang/String;
    //   264: invokevirtual 227	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload 14
    //   269: ldc 35
    //   271: aload 12
    //   273: getfield 114	cooperation/weiyun/sdk/download/DownloadFile:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   276: invokevirtual 227	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: aload 14
    //   281: ldc 19
    //   283: aload 10
    //   285: invokevirtual 227	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload 14
    //   290: ldc 37
    //   292: aload 12
    //   294: getfield 243	cooperation/weiyun/sdk/download/DownloadFile:jdField_a_of_type_Long	J
    //   297: invokestatic 246	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   300: invokevirtual 249	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   303: aload 14
    //   305: ldc 39
    //   307: aload 12
    //   309: getfield 250	cooperation/weiyun/sdk/download/DownloadFile:jdField_b_of_type_Int	I
    //   312: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   315: invokevirtual 237	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   318: aload 14
    //   320: ldc 55
    //   322: aload_2
    //   323: invokevirtual 192	cooperation/weiyun/sdk/download/DownloadJobContext:b	()Ljava/lang/String;
    //   326: invokevirtual 227	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   329: aload 14
    //   331: ldc 252
    //   333: invokestatic 257	java/lang/System:currentTimeMillis	()J
    //   336: invokestatic 246	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   339: invokevirtual 249	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   342: aload 14
    //   344: ldc_w 259
    //   347: aload 12
    //   349: getfield 262	cooperation/weiyun/sdk/download/DownloadFile:g	Ljava/lang/String;
    //   352: invokevirtual 227	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: aload 14
    //   357: ldc 43
    //   359: aload 12
    //   361: getfield 96	cooperation/weiyun/sdk/download/DownloadFile:f	Ljava/lang/String;
    //   364: invokevirtual 227	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: aload 14
    //   369: ldc_w 264
    //   372: iconst_1
    //   373: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   376: invokevirtual 237	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   379: aload 13
    //   381: getfield 113	cooperation/weiyun/sdk/download/DownloadJobContext$StatusInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   384: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   387: ifne +15 -> 402
    //   390: aload 14
    //   392: ldc 21
    //   394: aload 13
    //   396: getfield 113	cooperation/weiyun/sdk/download/DownloadJobContext$StatusInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   399: invokevirtual 227	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: lload 4
    //   404: lconst_0
    //   405: lcmp
    //   406: iflt +140 -> 546
    //   409: aload 11
    //   411: ldc 162
    //   413: aload 14
    //   415: ldc 164
    //   417: iconst_1
    //   418: anewarray 15	java/lang/String
    //   421: dup
    //   422: iconst_0
    //   423: lload 4
    //   425: invokestatic 168	java/lang/Long:toString	(J)Ljava/lang/String;
    //   428: aastore
    //   429: invokevirtual 174	com/tencent/weiyun/transmission/db/JobDbWrapper:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   432: pop
    //   433: ldc_w 272
    //   436: aload 10
    //   438: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   441: ifne +17 -> 458
    //   444: lload 4
    //   446: lstore 6
    //   448: aload 9
    //   450: aload 10
    //   452: invokestatic 279	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   455: ifne +12 -> 467
    //   458: ldc_w 281
    //   461: astore 8
    //   463: lload 4
    //   465: lstore 6
    //   467: invokestatic 151	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   470: aload 11
    //   472: invokevirtual 178	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   475: lload 6
    //   477: lconst_0
    //   478: lcmp
    //   479: iflt -475 -> 4
    //   482: aload_2
    //   483: lload 6
    //   485: invokevirtual 128	cooperation/weiyun/sdk/download/DownloadJobContext:a	(J)V
    //   488: aload_0
    //   489: getfield 64	cooperation/weiyun/sdk/download/processor/InfoRecorder:jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder$InfoRecorderCallback	Lcooperation/weiyun/sdk/download/processor/InfoRecorder$InfoRecorderCallback;
    //   492: iload_1
    //   493: aload_2
    //   494: aload 8
    //   496: invokeinterface 284 4 0
    //   501: return
    //   502: astore 8
    //   504: aconst_null
    //   505: astore 9
    //   507: aconst_null
    //   508: astore 8
    //   510: ldc2_w 285
    //   513: lstore 4
    //   515: aload 9
    //   517: invokestatic 221	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   520: aconst_null
    //   521: astore 10
    //   523: aload 8
    //   525: astore 9
    //   527: aload 10
    //   529: astore 8
    //   531: goto -342 -> 189
    //   534: astore_2
    //   535: aload 9
    //   537: astore 8
    //   539: aload 8
    //   541: invokestatic 221	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   544: aload_2
    //   545: athrow
    //   546: aload 14
    //   548: ldc 45
    //   550: aload 13
    //   552: getfield 102	cooperation/weiyun/sdk/download/DownloadJobContext$StatusInfo:jdField_a_of_type_Int	I
    //   555: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   558: invokevirtual 237	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   561: aload 14
    //   563: ldc 47
    //   565: aload 13
    //   567: getfield 104	cooperation/weiyun/sdk/download/DownloadJobContext$StatusInfo:jdField_b_of_type_Int	I
    //   570: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   573: invokevirtual 237	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   576: aload 14
    //   578: ldc 49
    //   580: aload 13
    //   582: getfield 106	cooperation/weiyun/sdk/download/DownloadJobContext$StatusInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   585: invokevirtual 227	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   588: aload 14
    //   590: ldc 51
    //   592: aload 13
    //   594: getfield 109	cooperation/weiyun/sdk/download/DownloadJobContext$StatusInfo:jdField_a_of_type_Long	J
    //   597: invokestatic 246	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   600: invokevirtual 249	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   603: aload 14
    //   605: ldc 53
    //   607: aload 13
    //   609: getfield 111	cooperation/weiyun/sdk/download/DownloadJobContext$StatusInfo:jdField_b_of_type_Long	J
    //   612: invokestatic 246	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   615: invokevirtual 249	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   618: aload 11
    //   620: ldc 162
    //   622: aconst_null
    //   623: aload 14
    //   625: invokevirtual 290	com/tencent/weiyun/transmission/db/JobDbWrapper:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   628: lstore 6
    //   630: goto -163 -> 467
    //   633: astore_2
    //   634: goto -95 -> 539
    //   637: astore 9
    //   639: aload 8
    //   641: astore 9
    //   643: aconst_null
    //   644: astore 8
    //   646: ldc2_w 285
    //   649: lstore 4
    //   651: goto -136 -> 515
    //   654: astore 9
    //   656: aload 8
    //   658: astore 9
    //   660: aconst_null
    //   661: astore 8
    //   663: goto -148 -> 515
    //   666: astore 10
    //   668: aload 8
    //   670: astore 10
    //   672: aload 9
    //   674: astore 8
    //   676: aload 10
    //   678: astore 9
    //   680: goto -165 -> 515
    //   683: aconst_null
    //   684: astore 9
    //   686: aconst_null
    //   687: astore 10
    //   689: ldc2_w 285
    //   692: lstore 4
    //   694: goto -514 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	697	0	this	InfoRecorder
    //   0	697	1	paramInt	int
    //   0	697	2	paramDownloadJobContext	DownloadJobContext
    //   155	2	3	i	int
    //   158	535	4	l1	long
    //   446	183	6	l2	long
    //   35	460	8	localObject1	Object
    //   502	1	8	localThrowable1	java.lang.Throwable
    //   508	167	8	localObject2	Object
    //   90	446	9	localObject3	Object
    //   637	1	9	localThrowable2	java.lang.Throwable
    //   641	1	9	localObject4	Object
    //   654	1	9	localThrowable3	java.lang.Throwable
    //   658	27	9	localObject5	Object
    //   42	486	10	str	String
    //   666	1	10	localThrowable4	java.lang.Throwable
    //   670	18	10	localObject6	Object
    //   24	595	11	localJobDbWrapper	JobDbWrapper
    //   9	351	12	localDownloadFile	DownloadFile
    //   15	593	13	localStatusInfo	DownloadJobContext.StatusInfo
    //   48	576	14	localObject7	Object
    //   87	13	15	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   92	132	502	java/lang/Throwable
    //   92	132	534	finally
    //   137	156	633	finally
    //   160	170	633	finally
    //   170	180	633	finally
    //   137	156	637	java/lang/Throwable
    //   160	170	654	java/lang/Throwable
    //   170	180	666	java/lang/Throwable
  }
  
  /* Error */
  private void b(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 7
    //   12: iconst_0
    //   13: istore 5
    //   15: invokestatic 151	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   18: iconst_1
    //   19: invokevirtual 155	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   22: astore 10
    //   24: aload 10
    //   26: ifnonnull +38 -> 64
    //   29: iconst_0
    //   30: istore 4
    //   32: aload 7
    //   34: astore 6
    //   36: aload_0
    //   37: getfield 64	cooperation/weiyun/sdk/download/processor/InfoRecorder:jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder$InfoRecorderCallback	Lcooperation/weiyun/sdk/download/processor/InfoRecorder$InfoRecorderCallback;
    //   40: astore 7
    //   42: iload 5
    //   44: istore_3
    //   45: iload 4
    //   47: ifle +5 -> 52
    //   50: iconst_1
    //   51: istore_3
    //   52: aload 7
    //   54: lload_1
    //   55: iload_3
    //   56: aload 6
    //   58: invokeinterface 294 5 0
    //   63: return
    //   64: lload_1
    //   65: lconst_0
    //   66: lcmp
    //   67: iflt +199 -> 266
    //   70: aload 10
    //   72: ldc 162
    //   74: getstatic 57	cooperation/weiyun/sdk/download/processor/InfoRecorder:b	[Ljava/lang/String;
    //   77: ldc 164
    //   79: iconst_1
    //   80: anewarray 15	java/lang/String
    //   83: dup
    //   84: iconst_0
    //   85: lload_1
    //   86: invokestatic 168	java/lang/Long:toString	(J)Ljava/lang/String;
    //   89: aastore
    //   90: aconst_null
    //   91: aconst_null
    //   92: aconst_null
    //   93: invokevirtual 211	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   96: astore 7
    //   98: aload 7
    //   100: ifnull +160 -> 260
    //   103: aload 7
    //   105: invokeinterface 215 1 0
    //   110: ifeq +150 -> 260
    //   113: aload_0
    //   114: aload 7
    //   116: invokespecial 296	cooperation/weiyun/sdk/download/processor/InfoRecorder:a	(Landroid/database/Cursor;)Lcooperation/weiyun/sdk/download/DownloadJobContext;
    //   119: astore 6
    //   121: aload 7
    //   123: invokestatic 221	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   126: iload_3
    //   127: ifeq +94 -> 221
    //   130: new 131	android/content/ContentValues
    //   133: dup
    //   134: invokespecial 223	android/content/ContentValues:<init>	()V
    //   137: astore 7
    //   139: aload 7
    //   141: ldc_w 264
    //   144: iconst_0
    //   145: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: invokevirtual 237	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   151: aload 10
    //   153: ldc 162
    //   155: aload 7
    //   157: ldc 164
    //   159: iconst_1
    //   160: anewarray 15	java/lang/String
    //   163: dup
    //   164: iconst_0
    //   165: lload_1
    //   166: invokestatic 168	java/lang/Long:toString	(J)Ljava/lang/String;
    //   169: aastore
    //   170: invokevirtual 174	com/tencent/weiyun/transmission/db/JobDbWrapper:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   173: istore 4
    //   175: invokestatic 151	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   178: aload 10
    //   180: invokevirtual 178	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   183: goto -147 -> 36
    //   186: astore 6
    //   188: aconst_null
    //   189: astore 6
    //   191: aload 6
    //   193: invokestatic 221	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   196: aload 8
    //   198: astore 6
    //   200: goto -74 -> 126
    //   203: astore 8
    //   205: aload 6
    //   207: astore 7
    //   209: aload 8
    //   211: astore 6
    //   213: aload 7
    //   215: invokestatic 221	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   218: aload 6
    //   220: athrow
    //   221: aload 10
    //   223: ldc 162
    //   225: ldc 164
    //   227: iconst_1
    //   228: anewarray 15	java/lang/String
    //   231: dup
    //   232: iconst_0
    //   233: lload_1
    //   234: invokestatic 168	java/lang/Long:toString	(J)Ljava/lang/String;
    //   237: aastore
    //   238: invokevirtual 300	com/tencent/weiyun/transmission/db/JobDbWrapper:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   241: istore 4
    //   243: goto -68 -> 175
    //   246: astore 6
    //   248: goto -35 -> 213
    //   251: astore 6
    //   253: aload 7
    //   255: astore 6
    //   257: goto -66 -> 191
    //   260: aconst_null
    //   261: astore 6
    //   263: goto -142 -> 121
    //   266: iconst_0
    //   267: istore 4
    //   269: aload 9
    //   271: astore 6
    //   273: goto -98 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	this	InfoRecorder
    //   0	276	1	paramLong	long
    //   0	276	3	paramBoolean	boolean
    //   30	238	4	i	int
    //   13	30	5	bool	boolean
    //   7	113	6	localObject1	Object
    //   186	1	6	localThrowable1	java.lang.Throwable
    //   189	30	6	localObject2	Object
    //   246	1	6	localObject3	Object
    //   251	1	6	localThrowable2	java.lang.Throwable
    //   255	17	6	localObject4	Object
    //   10	244	7	localObject5	Object
    //   1	196	8	localObject6	Object
    //   203	7	8	localObject7	Object
    //   4	266	9	localObject8	Object
    //   22	200	10	localJobDbWrapper	JobDbWrapper
    // Exception table:
    //   from	to	target	type
    //   70	98	186	java/lang/Throwable
    //   70	98	203	finally
    //   103	121	246	finally
    //   103	121	251	java/lang/Throwable
  }
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: invokestatic 151	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   7: iconst_0
    //   8: invokevirtual 155	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   11: astore 5
    //   13: aload 5
    //   15: ifnonnull +15 -> 30
    //   18: aload_0
    //   19: getfield 64	cooperation/weiyun/sdk/download/processor/InfoRecorder:jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder$InfoRecorderCallback	Lcooperation/weiyun/sdk/download/processor/InfoRecorder$InfoRecorderCallback;
    //   22: aload_1
    //   23: aload_2
    //   24: invokeinterface 304 3 0
    //   29: return
    //   30: iconst_4
    //   31: invokestatic 306	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   34: astore_2
    //   35: new 194	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   42: ldc 25
    //   44: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 201
    //   49: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 264
    //   55: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 308
    //   61: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 45
    //   66: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc_w 310
    //   72: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: astore 4
    //   77: aload 5
    //   79: ldc 162
    //   81: getstatic 57	cooperation/weiyun/sdk/download/processor/InfoRecorder:b	[Ljava/lang/String;
    //   84: aload 4
    //   86: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: iconst_2
    //   90: anewarray 15	java/lang/String
    //   93: dup
    //   94: iconst_0
    //   95: aload_1
    //   96: aastore
    //   97: dup
    //   98: iconst_1
    //   99: aload_2
    //   100: aastore
    //   101: aconst_null
    //   102: aconst_null
    //   103: ldc_w 312
    //   106: invokevirtual 211	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   109: astore_2
    //   110: aload_2
    //   111: ifnull +67 -> 178
    //   114: new 314	java/util/ArrayList
    //   117: dup
    //   118: aload_2
    //   119: invokeinterface 317 1 0
    //   124: invokespecial 320	java/util/ArrayList:<init>	(I)V
    //   127: astore 4
    //   129: aload 4
    //   131: astore_3
    //   132: aload_2
    //   133: invokeinterface 215 1 0
    //   138: ifeq +42 -> 180
    //   141: aload 4
    //   143: aload_0
    //   144: aload_2
    //   145: invokespecial 296	cooperation/weiyun/sdk/download/processor/InfoRecorder:a	(Landroid/database/Cursor;)Lcooperation/weiyun/sdk/download/DownloadJobContext;
    //   148: invokeinterface 325 2 0
    //   153: pop
    //   154: goto -25 -> 129
    //   157: astore_3
    //   158: aload_2
    //   159: astore_3
    //   160: aload 4
    //   162: astore_2
    //   163: aload_3
    //   164: invokestatic 221	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   167: invokestatic 151	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   170: aload 5
    //   172: invokevirtual 178	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   175: goto -157 -> 18
    //   178: aconst_null
    //   179: astore_3
    //   180: aload_2
    //   181: invokestatic 221	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   184: aload_3
    //   185: astore_2
    //   186: goto -19 -> 167
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_2
    //   192: aload_2
    //   193: invokestatic 221	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   196: aload_1
    //   197: athrow
    //   198: astore_1
    //   199: goto -7 -> 192
    //   202: astore_2
    //   203: aconst_null
    //   204: astore_2
    //   205: goto -42 -> 163
    //   208: astore_3
    //   209: aconst_null
    //   210: astore 4
    //   212: aload_2
    //   213: astore_3
    //   214: aload 4
    //   216: astore_2
    //   217: goto -54 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	InfoRecorder
    //   0	220	1	paramString	String
    //   3	190	2	localObject1	Object
    //   202	1	2	localThrowable1	java.lang.Throwable
    //   204	13	2	localObject2	Object
    //   1	131	3	localObject3	Object
    //   157	1	3	localThrowable2	java.lang.Throwable
    //   159	26	3	localObject4	Object
    //   208	1	3	localThrowable3	java.lang.Throwable
    //   213	1	3	localObject5	Object
    //   75	140	4	localObject6	Object
    //   11	160	5	localJobDbWrapper	JobDbWrapper
    // Exception table:
    //   from	to	target	type
    //   132	154	157	java/lang/Throwable
    //   77	110	189	finally
    //   114	129	198	finally
    //   132	154	198	finally
    //   77	110	202	java/lang/Throwable
    //   114	129	208	java/lang/Throwable
  }
  
  public void a(int paramInt, DownloadJobContext paramDownloadJobContext)
  {
    if (paramDownloadJobContext == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.sendMessage(Message.obtain(null, 1, paramInt, 0, paramDownloadJobContext));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (paramLong < 0L) {
      return;
    }
    ReleaseLooperHandler localReleaseLooperHandler = this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localReleaseLooperHandler.sendMessage(Message.obtain(null, 3, i, 0, Long.valueOf(paramLong)));
      return;
    }
  }
  
  public void a(DownloadJobContext paramDownloadJobContext, boolean paramBoolean)
  {
    if (paramDownloadJobContext == null) {
      return;
    }
    DownloadJobContext.StatusInfo localStatusInfo = paramDownloadJobContext.b();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("_id", Long.valueOf(paramDownloadJobContext.a()));
    localContentValues.put("state", Integer.valueOf(localStatusInfo.jdField_a_of_type_Int));
    localContentValues.put("error_code", Integer.valueOf(localStatusInfo.jdField_b_of_type_Int));
    localContentValues.put("error_msg", localStatusInfo.jdField_a_of_type_JavaLangString);
    localContentValues.put("total_size", Long.valueOf(localStatusInfo.jdField_a_of_type_Long));
    localContentValues.put("cur_size", Long.valueOf(localStatusInfo.jdField_b_of_type_Long));
    if (!TextUtils.isEmpty(localStatusInfo.jdField_b_of_type_JavaLangString)) {
      localContentValues.put("local_path", localStatusInfo.jdField_b_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(paramDownloadJobContext.c())) {
      localContentValues.put("file_version", paramDownloadJobContext.c());
    }
    paramDownloadJobContext = this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramDownloadJobContext.sendMessage(Message.obtain(null, 2, i, 0, new Object[] { localContentValues, localStatusInfo }));
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.sendMessage(Message.obtain(null, 4, paramString));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      b(paramMessage.arg1, (DownloadJobContext)paramMessage.obj);
      return true;
    case 2: 
      ContentValues localContentValues = (ContentValues)((Object[])(Object[])paramMessage.obj)[0];
      DownloadJobContext.StatusInfo localStatusInfo = (DownloadJobContext.StatusInfo)((Object[])(Object[])paramMessage.obj)[1];
      if (paramMessage.arg1 == 1) {
        bool1 = true;
      }
      a(localContentValues, localStatusInfo, bool1);
      return true;
    case 3: 
      long l = ((Long)paramMessage.obj).longValue();
      bool1 = bool2;
      if (paramMessage.arg1 == 1) {
        bool1 = true;
      }
      b(l, bool1);
      return true;
    }
    b((String)paramMessage.obj);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.sdk.download.processor.InfoRecorder
 * JD-Core Version:    0.7.0.1
 */