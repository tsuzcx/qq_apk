package cooperation.weiyun.sdk.download.processor;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.weiyun.transmission.db.JobDbWrapper;
import cooperation.weiyun.sdk.download.DownloadFile;
import cooperation.weiyun.sdk.download.DownloadJobContext;
import cooperation.weiyun.sdk.download.DownloadJobContext.StatusInfo;

public class InfoRecorder
  implements Handler.Callback
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "_id", "cloud_sha", "local_path" };
  private static final String[] b = { "_id", "uid", "cmd_type", "file_name", "p_dir_uid", "p_dir_key", "file_id", "cloud_sha", "file_size", "file_type", "file_version", "group_root_dir_key", "state", "error_code", "error_msg", "total_size", "cur_size", "local_path", "local_dir" };
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final InfoRecorder.InfoRecorderCallback jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder$InfoRecorderCallback;
  
  public InfoRecorder(InfoRecorder.InfoRecorderCallback paramInfoRecorderCallback)
  {
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder$InfoRecorderCallback = paramInfoRecorderCallback;
    paramInfoRecorderCallback = new HandlerThread("download-info-recorder");
    paramInfoRecorderCallback.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramInfoRecorderCallback.getLooper(), this);
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
    //   6: invokevirtual 197	cooperation/weiyun/sdk/download/DownloadJobContext:a	()Lcooperation/weiyun/sdk/download/DownloadFile;
    //   9: astore 12
    //   11: aload_2
    //   12: invokevirtual 200	cooperation/weiyun/sdk/download/DownloadJobContext:a	()Lcooperation/weiyun/sdk/download/DownloadJobContext$StatusInfo;
    //   15: astore 13
    //   17: invokestatic 164	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   20: iconst_1
    //   21: invokevirtual 168	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   24: astore 11
    //   26: aload 11
    //   28: ifnull -24 -> 4
    //   31: aload_2
    //   32: invokevirtual 203	cooperation/weiyun/sdk/download/DownloadJobContext:a	()Ljava/lang/String;
    //   35: astore 8
    //   37: aload 12
    //   39: getfield 127	cooperation/weiyun/sdk/download/DownloadFile:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: astore 10
    //   44: aload_2
    //   45: invokevirtual 205	cooperation/weiyun/sdk/download/DownloadJobContext:b	()Ljava/lang/String;
    //   48: astore 14
    //   50: new 207	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   57: ldc 25
    //   59: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 214
    //   64: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 35
    //   69: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 214
    //   74: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 55
    //   79: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 216
    //   84: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: astore 15
    //   89: aconst_null
    //   90: astore 9
    //   92: aload 11
    //   94: ldc 175
    //   96: getstatic 23	cooperation/weiyun/sdk/download/processor/InfoRecorder:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   99: aload 15
    //   101: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   125: ldc 220
    //   127: invokevirtual 224	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   130: astore 8
    //   132: aload 8
    //   134: ifnull +550 -> 684
    //   137: aload 8
    //   139: invokeinterface 228 1 0
    //   144: ifeq +540 -> 684
    //   147: aload 8
    //   149: iconst_0
    //   150: invokeinterface 92 2 0
    //   155: istore_3
    //   156: iload_3
    //   157: i2l
    //   158: lstore 4
    //   160: aload 8
    //   162: iconst_1
    //   163: invokeinterface 96 2 0
    //   168: astore 9
    //   170: aload 8
    //   172: iconst_2
    //   173: invokeinterface 96 2 0
    //   178: astore 10
    //   180: aload 8
    //   182: invokestatic 234	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   185: aload 10
    //   187: astore 8
    //   189: aload 12
    //   191: getfield 235	cooperation/weiyun/sdk/download/DownloadFile:c	Ljava/lang/String;
    //   194: astore 10
    //   196: new 144	android/content/ContentValues
    //   199: dup
    //   200: invokespecial 236	android/content/ContentValues:<init>	()V
    //   203: astore 14
    //   205: aload 14
    //   207: ldc 25
    //   209: aload_2
    //   210: invokevirtual 203	cooperation/weiyun/sdk/download/DownloadJobContext:a	()Ljava/lang/String;
    //   213: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload 14
    //   218: ldc 27
    //   220: aload 12
    //   222: getfield 241	cooperation/weiyun/sdk/download/DownloadFile:jdField_a_of_type_Int	I
    //   225: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   228: invokevirtual 250	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   231: aload 14
    //   233: ldc 29
    //   235: aload 12
    //   237: getfield 251	cooperation/weiyun/sdk/download/DownloadFile:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   240: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload 14
    //   245: ldc 31
    //   247: aload 12
    //   249: getfield 252	cooperation/weiyun/sdk/download/DownloadFile:d	Ljava/lang/String;
    //   252: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload 14
    //   257: ldc 33
    //   259: aload 12
    //   261: getfield 255	cooperation/weiyun/sdk/download/DownloadFile:e	Ljava/lang/String;
    //   264: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload 14
    //   269: ldc 35
    //   271: aload 12
    //   273: getfield 127	cooperation/weiyun/sdk/download/DownloadFile:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   276: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: aload 14
    //   281: ldc 19
    //   283: aload 10
    //   285: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload 14
    //   290: ldc 37
    //   292: aload 12
    //   294: getfield 256	cooperation/weiyun/sdk/download/DownloadFile:jdField_a_of_type_Long	J
    //   297: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   300: invokevirtual 262	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   303: aload 14
    //   305: ldc 39
    //   307: aload 12
    //   309: getfield 263	cooperation/weiyun/sdk/download/DownloadFile:jdField_b_of_type_Int	I
    //   312: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   315: invokevirtual 250	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   318: aload 14
    //   320: ldc 55
    //   322: aload_2
    //   323: invokevirtual 205	cooperation/weiyun/sdk/download/DownloadJobContext:b	()Ljava/lang/String;
    //   326: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   329: aload 14
    //   331: ldc_w 265
    //   334: invokestatic 270	java/lang/System:currentTimeMillis	()J
    //   337: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   340: invokevirtual 262	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   343: aload 14
    //   345: ldc_w 272
    //   348: aload 12
    //   350: getfield 275	cooperation/weiyun/sdk/download/DownloadFile:g	Ljava/lang/String;
    //   353: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload 14
    //   358: ldc 43
    //   360: aload 12
    //   362: getfield 109	cooperation/weiyun/sdk/download/DownloadFile:f	Ljava/lang/String;
    //   365: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: aload 14
    //   370: ldc_w 277
    //   373: iconst_1
    //   374: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   377: invokevirtual 250	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   380: aload 13
    //   382: getfield 126	cooperation/weiyun/sdk/download/DownloadJobContext$StatusInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   385: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   388: ifne +15 -> 403
    //   391: aload 14
    //   393: ldc 21
    //   395: aload 13
    //   397: getfield 126	cooperation/weiyun/sdk/download/DownloadJobContext$StatusInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   400: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: lload 4
    //   405: lconst_0
    //   406: lcmp
    //   407: iflt +140 -> 547
    //   410: aload 11
    //   412: ldc 175
    //   414: aload 14
    //   416: ldc 177
    //   418: iconst_1
    //   419: anewarray 15	java/lang/String
    //   422: dup
    //   423: iconst_0
    //   424: lload 4
    //   426: invokestatic 181	java/lang/Long:toString	(J)Ljava/lang/String;
    //   429: aastore
    //   430: invokevirtual 187	com/tencent/weiyun/transmission/db/JobDbWrapper:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   433: pop
    //   434: ldc_w 285
    //   437: aload 10
    //   439: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   442: ifne +17 -> 459
    //   445: lload 4
    //   447: lstore 6
    //   449: aload 9
    //   451: aload 10
    //   453: invokestatic 292	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   456: ifne +12 -> 468
    //   459: ldc_w 294
    //   462: astore 8
    //   464: lload 4
    //   466: lstore 6
    //   468: invokestatic 164	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   471: aload 11
    //   473: invokevirtual 191	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   476: lload 6
    //   478: lconst_0
    //   479: lcmp
    //   480: iflt -476 -> 4
    //   483: aload_2
    //   484: lload 6
    //   486: invokevirtual 141	cooperation/weiyun/sdk/download/DownloadJobContext:a	(J)V
    //   489: aload_0
    //   490: getfield 64	cooperation/weiyun/sdk/download/processor/InfoRecorder:jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder$InfoRecorderCallback	Lcooperation/weiyun/sdk/download/processor/InfoRecorder$InfoRecorderCallback;
    //   493: iload_1
    //   494: aload_2
    //   495: aload 8
    //   497: invokeinterface 297 4 0
    //   502: return
    //   503: astore 8
    //   505: aconst_null
    //   506: astore 9
    //   508: aconst_null
    //   509: astore 8
    //   511: ldc2_w 298
    //   514: lstore 4
    //   516: aload 9
    //   518: invokestatic 234	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   521: aconst_null
    //   522: astore 10
    //   524: aload 8
    //   526: astore 9
    //   528: aload 10
    //   530: astore 8
    //   532: goto -343 -> 189
    //   535: astore_2
    //   536: aload 9
    //   538: astore 8
    //   540: aload 8
    //   542: invokestatic 234	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   545: aload_2
    //   546: athrow
    //   547: aload 14
    //   549: ldc 45
    //   551: aload 13
    //   553: getfield 115	cooperation/weiyun/sdk/download/DownloadJobContext$StatusInfo:jdField_a_of_type_Int	I
    //   556: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   559: invokevirtual 250	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   562: aload 14
    //   564: ldc 47
    //   566: aload 13
    //   568: getfield 117	cooperation/weiyun/sdk/download/DownloadJobContext$StatusInfo:jdField_b_of_type_Int	I
    //   571: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   574: invokevirtual 250	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   577: aload 14
    //   579: ldc 49
    //   581: aload 13
    //   583: getfield 119	cooperation/weiyun/sdk/download/DownloadJobContext$StatusInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   586: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   589: aload 14
    //   591: ldc 51
    //   593: aload 13
    //   595: getfield 122	cooperation/weiyun/sdk/download/DownloadJobContext$StatusInfo:jdField_a_of_type_Long	J
    //   598: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   601: invokevirtual 262	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   604: aload 14
    //   606: ldc 53
    //   608: aload 13
    //   610: getfield 124	cooperation/weiyun/sdk/download/DownloadJobContext$StatusInfo:jdField_b_of_type_Long	J
    //   613: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   616: invokevirtual 262	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   619: aload 11
    //   621: ldc 175
    //   623: aconst_null
    //   624: aload 14
    //   626: invokevirtual 303	com/tencent/weiyun/transmission/db/JobDbWrapper:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   629: lstore 6
    //   631: goto -163 -> 468
    //   634: astore_2
    //   635: goto -95 -> 540
    //   638: astore 9
    //   640: aload 8
    //   642: astore 9
    //   644: aconst_null
    //   645: astore 8
    //   647: ldc2_w 298
    //   650: lstore 4
    //   652: goto -136 -> 516
    //   655: astore 9
    //   657: aload 8
    //   659: astore 9
    //   661: aconst_null
    //   662: astore 8
    //   664: goto -148 -> 516
    //   667: astore 10
    //   669: aload 8
    //   671: astore 10
    //   673: aload 9
    //   675: astore 8
    //   677: aload 10
    //   679: astore 9
    //   681: goto -165 -> 516
    //   684: aconst_null
    //   685: astore 9
    //   687: aconst_null
    //   688: astore 10
    //   690: ldc2_w 298
    //   693: lstore 4
    //   695: goto -515 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	698	0	this	InfoRecorder
    //   0	698	1	paramInt	int
    //   0	698	2	paramDownloadJobContext	DownloadJobContext
    //   155	2	3	i	int
    //   158	536	4	l1	long
    //   447	183	6	l2	long
    //   35	461	8	localObject1	Object
    //   503	1	8	localThrowable1	java.lang.Throwable
    //   509	167	8	localObject2	Object
    //   90	447	9	localObject3	Object
    //   638	1	9	localThrowable2	java.lang.Throwable
    //   642	1	9	localObject4	Object
    //   655	1	9	localThrowable3	java.lang.Throwable
    //   659	27	9	localObject5	Object
    //   42	487	10	str	String
    //   667	1	10	localThrowable4	java.lang.Throwable
    //   671	18	10	localObject6	Object
    //   24	596	11	localJobDbWrapper	JobDbWrapper
    //   9	352	12	localDownloadFile	DownloadFile
    //   15	594	13	localStatusInfo	DownloadJobContext.StatusInfo
    //   48	577	14	localObject7	Object
    //   87	13	15	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   92	132	503	java/lang/Throwable
    //   92	132	535	finally
    //   137	156	634	finally
    //   160	170	634	finally
    //   170	180	634	finally
    //   137	156	638	java/lang/Throwable
    //   160	170	655	java/lang/Throwable
    //   170	180	667	java/lang/Throwable
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
    //   15: invokestatic 164	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   18: iconst_1
    //   19: invokevirtual 168	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
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
    //   58: invokeinterface 307 5 0
    //   63: return
    //   64: lload_1
    //   65: lconst_0
    //   66: lcmp
    //   67: iflt +199 -> 266
    //   70: aload 10
    //   72: ldc 175
    //   74: getstatic 57	cooperation/weiyun/sdk/download/processor/InfoRecorder:b	[Ljava/lang/String;
    //   77: ldc 177
    //   79: iconst_1
    //   80: anewarray 15	java/lang/String
    //   83: dup
    //   84: iconst_0
    //   85: lload_1
    //   86: invokestatic 181	java/lang/Long:toString	(J)Ljava/lang/String;
    //   89: aastore
    //   90: aconst_null
    //   91: aconst_null
    //   92: aconst_null
    //   93: invokevirtual 224	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   96: astore 7
    //   98: aload 7
    //   100: ifnull +160 -> 260
    //   103: aload 7
    //   105: invokeinterface 228 1 0
    //   110: ifeq +150 -> 260
    //   113: aload_0
    //   114: aload 7
    //   116: invokespecial 309	cooperation/weiyun/sdk/download/processor/InfoRecorder:a	(Landroid/database/Cursor;)Lcooperation/weiyun/sdk/download/DownloadJobContext;
    //   119: astore 6
    //   121: aload 7
    //   123: invokestatic 234	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   126: iload_3
    //   127: ifeq +94 -> 221
    //   130: new 144	android/content/ContentValues
    //   133: dup
    //   134: invokespecial 236	android/content/ContentValues:<init>	()V
    //   137: astore 7
    //   139: aload 7
    //   141: ldc_w 277
    //   144: iconst_0
    //   145: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: invokevirtual 250	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   151: aload 10
    //   153: ldc 175
    //   155: aload 7
    //   157: ldc 177
    //   159: iconst_1
    //   160: anewarray 15	java/lang/String
    //   163: dup
    //   164: iconst_0
    //   165: lload_1
    //   166: invokestatic 181	java/lang/Long:toString	(J)Ljava/lang/String;
    //   169: aastore
    //   170: invokevirtual 187	com/tencent/weiyun/transmission/db/JobDbWrapper:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   173: istore 4
    //   175: invokestatic 164	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   178: aload 10
    //   180: invokevirtual 191	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   183: goto -147 -> 36
    //   186: astore 6
    //   188: aconst_null
    //   189: astore 6
    //   191: aload 6
    //   193: invokestatic 234	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   196: aload 8
    //   198: astore 6
    //   200: goto -74 -> 126
    //   203: astore 8
    //   205: aload 6
    //   207: astore 7
    //   209: aload 8
    //   211: astore 6
    //   213: aload 7
    //   215: invokestatic 234	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   218: aload 6
    //   220: athrow
    //   221: aload 10
    //   223: ldc 175
    //   225: ldc 177
    //   227: iconst_1
    //   228: anewarray 15	java/lang/String
    //   231: dup
    //   232: iconst_0
    //   233: lload_1
    //   234: invokestatic 181	java/lang/Long:toString	(J)Ljava/lang/String;
    //   237: aastore
    //   238: invokevirtual 313	com/tencent/weiyun/transmission/db/JobDbWrapper:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
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
    //   4: invokestatic 164	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   7: iconst_0
    //   8: invokevirtual 168	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   11: astore 5
    //   13: aload 5
    //   15: ifnonnull +15 -> 30
    //   18: aload_0
    //   19: getfield 64	cooperation/weiyun/sdk/download/processor/InfoRecorder:jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder$InfoRecorderCallback	Lcooperation/weiyun/sdk/download/processor/InfoRecorder$InfoRecorderCallback;
    //   22: aload_1
    //   23: aload_2
    //   24: invokeinterface 316 3 0
    //   29: return
    //   30: iconst_4
    //   31: invokestatic 318	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   34: astore_2
    //   35: new 207	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   42: ldc 25
    //   44: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 214
    //   49: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 277
    //   55: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 320
    //   61: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 45
    //   66: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc_w 322
    //   72: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: astore 4
    //   77: aload 5
    //   79: ldc 175
    //   81: getstatic 57	cooperation/weiyun/sdk/download/processor/InfoRecorder:b	[Ljava/lang/String;
    //   84: aload 4
    //   86: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   103: ldc_w 324
    //   106: invokevirtual 224	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   109: astore_2
    //   110: aload_2
    //   111: ifnull +67 -> 178
    //   114: new 326	java/util/ArrayList
    //   117: dup
    //   118: aload_2
    //   119: invokeinterface 329 1 0
    //   124: invokespecial 332	java/util/ArrayList:<init>	(I)V
    //   127: astore 4
    //   129: aload 4
    //   131: astore_3
    //   132: aload_2
    //   133: invokeinterface 228 1 0
    //   138: ifeq +42 -> 180
    //   141: aload 4
    //   143: aload_0
    //   144: aload_2
    //   145: invokespecial 309	cooperation/weiyun/sdk/download/processor/InfoRecorder:a	(Landroid/database/Cursor;)Lcooperation/weiyun/sdk/download/DownloadJobContext;
    //   148: invokeinterface 337 2 0
    //   153: pop
    //   154: goto -25 -> 129
    //   157: astore_3
    //   158: aload_2
    //   159: astore_3
    //   160: aload 4
    //   162: astore_2
    //   163: aload_3
    //   164: invokestatic 234	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   167: invokestatic 164	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   170: aload 5
    //   172: invokevirtual 191	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   175: goto -157 -> 18
    //   178: aconst_null
    //   179: astore_3
    //   180: aload_2
    //   181: invokestatic 234	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   184: aload_3
    //   185: astore_2
    //   186: goto -19 -> 167
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_2
    //   192: aload_2
    //   193: invokestatic 234	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
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
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, paramInt, 0, paramDownloadJobContext).sendToTarget();
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (paramLong < 0L) {
      return;
    }
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Message.obtain(localHandler, 3, i, 0, Long.valueOf(paramLong)).sendToTarget();
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
    paramDownloadJobContext = this.jdField_a_of_type_AndroidOsHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Message.obtain(paramDownloadJobContext, 2, i, 0, new Object[] { localContentValues, localStatusInfo }).sendToTarget();
      return;
    }
  }
  
  public void a(String paramString)
  {
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 4, paramString).sendToTarget();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.sdk.download.processor.InfoRecorder
 * JD-Core Version:    0.7.0.1
 */