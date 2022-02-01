package com.tencent.mobileqq.weiyun.sdk.download.processor;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.weiyun.model.DownloadFile;
import com.tencent.mobileqq.weiyun.model.DownloadJobContext;
import com.tencent.mobileqq.weiyun.model.WeiyunDownloadStatusInfo;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.weiyun.transmission.db.JobDbWrapper;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

public class InfoRecorder
  implements Handler.Callback
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "_id", "cloud_sha", "local_path" };
  private static final String[] b = { "_id", "uid", "cmd_type", "file_name", "p_dir_uid", "p_dir_key", "file_id", "cloud_sha", "file_size", "file_type", "file_version", "group_root_dir_key", "state", "error_code", "error_msg", "total_size", "cur_size", "local_path", "local_dir" };
  private final InfoRecorder.InfoRecorderCallback jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorInfoRecorder$InfoRecorderCallback;
  private final ReleaseLooperHandler jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler;
  
  public InfoRecorder(InfoRecorder.InfoRecorderCallback paramInfoRecorderCallback, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorInfoRecorder$InfoRecorderCallback = paramInfoRecorderCallback;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler = paramReleaseLooperHandler;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.addCallback(this);
  }
  
  private DownloadJobContext a(Cursor paramCursor)
  {
    Object localObject = DownloadFile.a(paramCursor.getInt(2), paramCursor.getString(6), paramCursor.getString(3), paramCursor.getString(7), paramCursor.getLong(8), paramCursor.getInt(9), paramCursor.getString(4), paramCursor.getString(5), null);
    ((DownloadFile)localObject).f = paramCursor.getString(11);
    WeiyunDownloadStatusInfo localWeiyunDownloadStatusInfo = new WeiyunDownloadStatusInfo();
    localWeiyunDownloadStatusInfo.jdField_a_of_type_Int = paramCursor.getInt(12);
    localWeiyunDownloadStatusInfo.jdField_b_of_type_Int = paramCursor.getInt(13);
    localWeiyunDownloadStatusInfo.jdField_a_of_type_JavaLangString = paramCursor.getString(14);
    localWeiyunDownloadStatusInfo.jdField_a_of_type_Long = paramCursor.getLong(15);
    localWeiyunDownloadStatusInfo.jdField_b_of_type_Long = paramCursor.getLong(16);
    localWeiyunDownloadStatusInfo.jdField_b_of_type_JavaLangString = paramCursor.getString(17);
    localWeiyunDownloadStatusInfo.c = ((DownloadFile)localObject).jdField_a_of_type_JavaLangString;
    localWeiyunDownloadStatusInfo.d = paramCursor.getString(10);
    localObject = DownloadJobContext.a(paramCursor.getString(1), (DownloadFile)localObject, paramCursor.getString(18), localWeiyunDownloadStatusInfo);
    ((DownloadJobContext)localObject).a(paramCursor.getLong(0));
    return localObject;
  }
  
  private void a(ContentValues paramContentValues, WeiyunDownloadStatusInfo paramWeiyunDownloadStatusInfo, boolean paramBoolean)
  {
    if (paramContentValues != null)
    {
      if (paramContentValues.size() <= 0) {
        return;
      }
      long l = paramContentValues.getAsLong("_id").longValue();
      JobDbWrapper localJobDbWrapper = JobDbManager.getInstance().openJobDb(true);
      boolean bool = false;
      int i;
      if (localJobDbWrapper == null)
      {
        i = 0;
      }
      else
      {
        if (l >= 0L) {
          i = localJobDbWrapper.update("download", paramContentValues, "_id=?", new String[] { Long.toString(l) });
        } else {
          i = 0;
        }
        JobDbManager.getInstance().closeJobDb(localJobDbWrapper);
      }
      paramContentValues = this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorInfoRecorder$InfoRecorderCallback;
      if (i > 0) {
        bool = true;
      }
      paramContentValues.a(l, bool, paramWeiyunDownloadStatusInfo, paramBoolean);
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
    //   6: invokevirtual 184	com/tencent/mobileqq/weiyun/model/DownloadJobContext:a	()Lcom/tencent/mobileqq/weiyun/model/DownloadFile;
    //   9: astore 12
    //   11: aload_2
    //   12: invokevirtual 187	com/tencent/mobileqq/weiyun/model/DownloadJobContext:a	()Lcom/tencent/mobileqq/weiyun/model/WeiyunDownloadStatusInfo;
    //   15: astore 13
    //   17: invokestatic 151	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   20: iconst_1
    //   21: invokevirtual 155	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   24: astore 11
    //   26: aload 11
    //   28: ifnonnull +4 -> 32
    //   31: return
    //   32: aload_2
    //   33: invokevirtual 190	com/tencent/mobileqq/weiyun/model/DownloadJobContext:a	()Ljava/lang/String;
    //   36: astore 8
    //   38: aload 12
    //   40: getfield 114	com/tencent/mobileqq/weiyun/model/DownloadFile:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   43: astore 9
    //   45: aload_2
    //   46: invokevirtual 192	com/tencent/mobileqq/weiyun/model/DownloadJobContext:b	()Ljava/lang/String;
    //   49: astore 10
    //   51: new 194	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   58: astore 15
    //   60: aload 15
    //   62: ldc 25
    //   64: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 15
    //   70: ldc 201
    //   72: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 15
    //   78: ldc 35
    //   80: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 15
    //   86: ldc 201
    //   88: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 15
    //   94: ldc 55
    //   96: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 15
    //   102: ldc 203
    //   104: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: getstatic 23	com/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   111: astore 14
    //   113: aload 15
    //   115: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore 15
    //   120: aload 11
    //   122: ldc 157
    //   124: aload 14
    //   126: aload 15
    //   128: iconst_3
    //   129: anewarray 15	java/lang/String
    //   132: dup
    //   133: iconst_0
    //   134: aload 8
    //   136: aastore
    //   137: dup
    //   138: iconst_1
    //   139: aload 9
    //   141: aastore
    //   142: dup
    //   143: iconst_2
    //   144: aload 10
    //   146: aastore
    //   147: aconst_null
    //   148: aconst_null
    //   149: ldc 207
    //   151: invokevirtual 211	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   154: astore 8
    //   156: aload 8
    //   158: ifnull +78 -> 236
    //   161: aload 8
    //   163: invokeinterface 215 1 0
    //   168: ifeq +68 -> 236
    //   171: aload 8
    //   173: iconst_0
    //   174: invokeinterface 79 2 0
    //   179: istore_3
    //   180: iload_3
    //   181: i2l
    //   182: lstore 4
    //   184: aload 8
    //   186: iconst_1
    //   187: invokeinterface 83 2 0
    //   192: astore 10
    //   194: aload 8
    //   196: iconst_2
    //   197: invokeinterface 83 2 0
    //   202: astore 9
    //   204: goto +43 -> 247
    //   207: aload 8
    //   209: astore 9
    //   211: aload 10
    //   213: astore 8
    //   215: goto +66 -> 281
    //   218: aconst_null
    //   219: astore 10
    //   221: aload 8
    //   223: astore 9
    //   225: aload 10
    //   227: astore 8
    //   229: goto +52 -> 281
    //   232: astore_2
    //   233: goto +30 -> 263
    //   236: aconst_null
    //   237: astore 10
    //   239: aconst_null
    //   240: astore 9
    //   242: ldc2_w 216
    //   245: lstore 4
    //   247: aload 8
    //   249: invokestatic 223	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   252: aload 10
    //   254: astore 8
    //   256: goto +33 -> 289
    //   259: astore_2
    //   260: aconst_null
    //   261: astore 8
    //   263: aload 8
    //   265: invokestatic 223	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   268: aload_2
    //   269: athrow
    //   270: aconst_null
    //   271: astore 9
    //   273: aconst_null
    //   274: astore 8
    //   276: ldc2_w 216
    //   279: lstore 4
    //   281: aload 9
    //   283: invokestatic 223	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   286: aconst_null
    //   287: astore 9
    //   289: aload 12
    //   291: getfield 224	com/tencent/mobileqq/weiyun/model/DownloadFile:c	Ljava/lang/String;
    //   294: astore 10
    //   296: new 131	android/content/ContentValues
    //   299: dup
    //   300: invokespecial 225	android/content/ContentValues:<init>	()V
    //   303: astore 14
    //   305: aload 14
    //   307: ldc 25
    //   309: aload_2
    //   310: invokevirtual 190	com/tencent/mobileqq/weiyun/model/DownloadJobContext:a	()Ljava/lang/String;
    //   313: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload 14
    //   318: ldc 27
    //   320: aload 12
    //   322: getfield 230	com/tencent/mobileqq/weiyun/model/DownloadFile:jdField_a_of_type_Int	I
    //   325: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   328: invokevirtual 239	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   331: aload 14
    //   333: ldc 29
    //   335: aload 12
    //   337: getfield 240	com/tencent/mobileqq/weiyun/model/DownloadFile:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   340: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: aload 14
    //   345: ldc 31
    //   347: aload 12
    //   349: getfield 241	com/tencent/mobileqq/weiyun/model/DownloadFile:d	Ljava/lang/String;
    //   352: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: aload 14
    //   357: ldc 33
    //   359: aload 12
    //   361: getfield 244	com/tencent/mobileqq/weiyun/model/DownloadFile:e	Ljava/lang/String;
    //   364: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: aload 14
    //   369: ldc 35
    //   371: aload 12
    //   373: getfield 114	com/tencent/mobileqq/weiyun/model/DownloadFile:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   376: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: aload 14
    //   381: ldc 19
    //   383: aload 10
    //   385: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   388: aload 14
    //   390: ldc 37
    //   392: aload 12
    //   394: getfield 245	com/tencent/mobileqq/weiyun/model/DownloadFile:jdField_a_of_type_Long	J
    //   397: invokestatic 248	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   400: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   403: aload 14
    //   405: ldc 39
    //   407: aload 12
    //   409: getfield 252	com/tencent/mobileqq/weiyun/model/DownloadFile:jdField_b_of_type_Int	I
    //   412: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   415: invokevirtual 239	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   418: aload 14
    //   420: ldc 55
    //   422: aload_2
    //   423: invokevirtual 192	com/tencent/mobileqq/weiyun/model/DownloadJobContext:b	()Ljava/lang/String;
    //   426: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: aload 14
    //   431: ldc 254
    //   433: invokestatic 259	java/lang/System:currentTimeMillis	()J
    //   436: invokestatic 248	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   439: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   442: aload 14
    //   444: ldc_w 261
    //   447: aload 12
    //   449: getfield 264	com/tencent/mobileqq/weiyun/model/DownloadFile:g	Ljava/lang/String;
    //   452: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: aload 14
    //   457: ldc 43
    //   459: aload 12
    //   461: getfield 96	com/tencent/mobileqq/weiyun/model/DownloadFile:f	Ljava/lang/String;
    //   464: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   467: aload 14
    //   469: ldc_w 266
    //   472: iconst_1
    //   473: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   476: invokevirtual 239	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   479: aload 13
    //   481: getfield 113	com/tencent/mobileqq/weiyun/model/WeiyunDownloadStatusInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   484: invokestatic 272	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   487: ifne +15 -> 502
    //   490: aload 14
    //   492: ldc 21
    //   494: aload 13
    //   496: getfield 113	com/tencent/mobileqq/weiyun/model/WeiyunDownloadStatusInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   499: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   502: lload 4
    //   504: lconst_0
    //   505: lcmp
    //   506: iflt +64 -> 570
    //   509: aload 11
    //   511: ldc 157
    //   513: aload 14
    //   515: ldc 159
    //   517: iconst_1
    //   518: anewarray 15	java/lang/String
    //   521: dup
    //   522: iconst_0
    //   523: lload 4
    //   525: invokestatic 163	java/lang/Long:toString	(J)Ljava/lang/String;
    //   528: aastore
    //   529: invokevirtual 169	com/tencent/weiyun/transmission/db/JobDbWrapper:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   532: pop
    //   533: ldc_w 274
    //   536: aload 10
    //   538: invokevirtual 278	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   541: ifne +17 -> 558
    //   544: lload 4
    //   546: lstore 6
    //   548: aload 8
    //   550: aload 10
    //   552: invokestatic 281	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   555: ifne +99 -> 654
    //   558: ldc_w 283
    //   561: astore 9
    //   563: lload 4
    //   565: lstore 6
    //   567: goto +87 -> 654
    //   570: aload 14
    //   572: ldc 45
    //   574: aload 13
    //   576: getfield 102	com/tencent/mobileqq/weiyun/model/WeiyunDownloadStatusInfo:jdField_a_of_type_Int	I
    //   579: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   582: invokevirtual 239	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   585: aload 14
    //   587: ldc 47
    //   589: aload 13
    //   591: getfield 104	com/tencent/mobileqq/weiyun/model/WeiyunDownloadStatusInfo:jdField_b_of_type_Int	I
    //   594: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   597: invokevirtual 239	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   600: aload 14
    //   602: ldc 49
    //   604: aload 13
    //   606: getfield 106	com/tencent/mobileqq/weiyun/model/WeiyunDownloadStatusInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   609: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   612: aload 14
    //   614: ldc 51
    //   616: aload 13
    //   618: getfield 109	com/tencent/mobileqq/weiyun/model/WeiyunDownloadStatusInfo:jdField_a_of_type_Long	J
    //   621: invokestatic 248	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   624: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   627: aload 14
    //   629: ldc 53
    //   631: aload 13
    //   633: getfield 111	com/tencent/mobileqq/weiyun/model/WeiyunDownloadStatusInfo:jdField_b_of_type_Long	J
    //   636: invokestatic 248	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   639: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   642: aload 11
    //   644: ldc 157
    //   646: aconst_null
    //   647: aload 14
    //   649: invokevirtual 287	com/tencent/weiyun/transmission/db/JobDbWrapper:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   652: lstore 6
    //   654: invokestatic 151	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   657: aload 11
    //   659: invokevirtual 173	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   662: lload 6
    //   664: lconst_0
    //   665: lcmp
    //   666: iflt +23 -> 689
    //   669: aload_2
    //   670: lload 6
    //   672: invokevirtual 128	com/tencent/mobileqq/weiyun/model/DownloadJobContext:a	(J)V
    //   675: aload_0
    //   676: getfield 64	com/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder:jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorInfoRecorder$InfoRecorderCallback	Lcom/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder$InfoRecorderCallback;
    //   679: iload_1
    //   680: aload_2
    //   681: aload 9
    //   683: invokeinterface 290 4 0
    //   688: return
    //   689: return
    //   690: astore 8
    //   692: goto -422 -> 270
    //   695: astore 8
    //   697: goto -427 -> 270
    //   700: astore 9
    //   702: aload 8
    //   704: astore 9
    //   706: goto -433 -> 273
    //   709: astore 9
    //   711: goto -493 -> 218
    //   714: astore 9
    //   716: goto -509 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	719	0	this	InfoRecorder
    //   0	719	1	paramInt	int
    //   0	719	2	paramDownloadJobContext	DownloadJobContext
    //   179	2	3	i	int
    //   182	382	4	l1	long
    //   546	125	6	l2	long
    //   36	513	8	localObject1	Object
    //   690	1	8	localThrowable1	java.lang.Throwable
    //   695	8	8	localThrowable2	java.lang.Throwable
    //   43	639	9	localObject2	Object
    //   700	1	9	localThrowable3	java.lang.Throwable
    //   704	1	9	localThrowable4	java.lang.Throwable
    //   709	1	9	localThrowable5	java.lang.Throwable
    //   714	1	9	localThrowable6	java.lang.Throwable
    //   49	502	10	str	String
    //   24	634	11	localJobDbWrapper	JobDbWrapper
    //   9	451	12	localDownloadFile	DownloadFile
    //   15	617	13	localWeiyunDownloadStatusInfo	WeiyunDownloadStatusInfo
    //   111	537	14	localObject3	Object
    //   58	69	15	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   161	180	232	finally
    //   184	194	232	finally
    //   194	204	232	finally
    //   108	120	259	finally
    //   120	156	259	finally
    //   108	120	690	java/lang/Throwable
    //   120	156	695	java/lang/Throwable
    //   161	180	700	java/lang/Throwable
    //   184	194	709	java/lang/Throwable
    //   194	204	714	java/lang/Throwable
  }
  
  /* Error */
  private void b(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 151	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   3: astore 6
    //   5: iconst_1
    //   6: istore 5
    //   8: aload 6
    //   10: iconst_1
    //   11: invokevirtual 155	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   14: astore 10
    //   16: aconst_null
    //   17: astore 9
    //   19: aconst_null
    //   20: astore 7
    //   22: aconst_null
    //   23: astore 8
    //   25: aconst_null
    //   26: astore 6
    //   28: aload 10
    //   30: ifnonnull +13 -> 43
    //   33: iconst_0
    //   34: istore 4
    //   36: aload 8
    //   38: astore 6
    //   40: goto +210 -> 250
    //   43: lload_1
    //   44: lconst_0
    //   45: lcmp
    //   46: iflt +189 -> 235
    //   49: aload 10
    //   51: ldc 157
    //   53: getstatic 57	com/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder:b	[Ljava/lang/String;
    //   56: ldc 159
    //   58: iconst_1
    //   59: anewarray 15	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: lload_1
    //   65: invokestatic 163	java/lang/Long:toString	(J)Ljava/lang/String;
    //   68: aastore
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: invokevirtual 211	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore 7
    //   77: aload 7
    //   79: astore 8
    //   81: aload 9
    //   83: astore 6
    //   85: aload 7
    //   87: ifnull +66 -> 153
    //   90: aload 7
    //   92: astore 8
    //   94: aload 9
    //   96: astore 6
    //   98: aload 7
    //   100: invokeinterface 215 1 0
    //   105: ifeq +48 -> 153
    //   108: aload_0
    //   109: aload 7
    //   111: invokespecial 293	com/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder:a	(Landroid/database/Cursor;)Lcom/tencent/mobileqq/weiyun/model/DownloadJobContext;
    //   114: astore 6
    //   116: aload 7
    //   118: astore 8
    //   120: goto +33 -> 153
    //   123: astore 8
    //   125: aload 7
    //   127: astore 6
    //   129: aload 8
    //   131: astore 7
    //   133: goto +5 -> 138
    //   136: astore 7
    //   138: aload 6
    //   140: invokestatic 223	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   143: aload 7
    //   145: athrow
    //   146: aconst_null
    //   147: astore 8
    //   149: aload 9
    //   151: astore 6
    //   153: aload 8
    //   155: invokestatic 223	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   158: iload_3
    //   159: ifeq +51 -> 210
    //   162: new 131	android/content/ContentValues
    //   165: dup
    //   166: invokespecial 225	android/content/ContentValues:<init>	()V
    //   169: astore 7
    //   171: aload 7
    //   173: ldc_w 266
    //   176: iconst_0
    //   177: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: invokevirtual 239	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   183: aload 10
    //   185: ldc 157
    //   187: aload 7
    //   189: ldc 159
    //   191: iconst_1
    //   192: anewarray 15	java/lang/String
    //   195: dup
    //   196: iconst_0
    //   197: lload_1
    //   198: invokestatic 163	java/lang/Long:toString	(J)Ljava/lang/String;
    //   201: aastore
    //   202: invokevirtual 169	com/tencent/weiyun/transmission/db/JobDbWrapper:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   205: istore 4
    //   207: goto +35 -> 242
    //   210: aload 10
    //   212: ldc 157
    //   214: ldc 159
    //   216: iconst_1
    //   217: anewarray 15	java/lang/String
    //   220: dup
    //   221: iconst_0
    //   222: lload_1
    //   223: invokestatic 163	java/lang/Long:toString	(J)Ljava/lang/String;
    //   226: aastore
    //   227: invokevirtual 297	com/tencent/weiyun/transmission/db/JobDbWrapper:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   230: istore 4
    //   232: goto +10 -> 242
    //   235: iconst_0
    //   236: istore 4
    //   238: aload 7
    //   240: astore 6
    //   242: invokestatic 151	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   245: aload 10
    //   247: invokevirtual 173	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   250: aload_0
    //   251: getfield 64	com/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder:jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorInfoRecorder$InfoRecorderCallback	Lcom/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder$InfoRecorderCallback;
    //   254: astore 7
    //   256: iload 4
    //   258: ifle +9 -> 267
    //   261: iload 5
    //   263: istore_3
    //   264: goto +5 -> 269
    //   267: iconst_0
    //   268: istore_3
    //   269: aload 7
    //   271: lload_1
    //   272: iload_3
    //   273: aload 6
    //   275: invokeinterface 300 5 0
    //   280: return
    //   281: astore 6
    //   283: goto -137 -> 146
    //   286: astore 6
    //   288: aload 7
    //   290: astore 8
    //   292: aload 9
    //   294: astore 6
    //   296: goto -143 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	InfoRecorder
    //   0	299	1	paramLong	long
    //   0	299	3	paramBoolean	boolean
    //   34	223	4	i	int
    //   6	256	5	bool	boolean
    //   3	271	6	localObject1	Object
    //   281	1	6	localThrowable1	java.lang.Throwable
    //   286	1	6	localThrowable2	java.lang.Throwable
    //   294	1	6	localObject2	Object
    //   20	112	7	localObject3	Object
    //   136	8	7	localObject4	Object
    //   169	120	7	localObject5	Object
    //   23	96	8	localObject6	Object
    //   123	7	8	localObject7	Object
    //   147	144	8	localObject8	Object
    //   17	276	9	localObject9	Object
    //   14	232	10	localJobDbWrapper	JobDbWrapper
    // Exception table:
    //   from	to	target	type
    //   98	116	123	finally
    //   49	77	136	finally
    //   49	77	281	java/lang/Throwable
    //   98	116	286	java/lang/Throwable
  }
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 151	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   3: iconst_0
    //   4: invokevirtual 155	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_2
    //   13: aload 5
    //   15: ifnonnull +8 -> 23
    //   18: aload_3
    //   19: astore_2
    //   20: goto +190 -> 210
    //   23: iconst_4
    //   24: invokestatic 303	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   27: astore_3
    //   28: new 194	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   35: astore 4
    //   37: aload 4
    //   39: ldc 25
    //   41: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 4
    //   47: ldc 201
    //   49: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 4
    //   55: ldc_w 266
    //   58: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 4
    //   64: ldc_w 305
    //   67: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 4
    //   73: ldc 45
    //   75: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 4
    //   81: ldc_w 307
    //   84: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 5
    //   90: ldc 157
    //   92: getstatic 57	com/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder:b	[Ljava/lang/String;
    //   95: aload 4
    //   97: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: iconst_2
    //   101: anewarray 15	java/lang/String
    //   104: dup
    //   105: iconst_0
    //   106: aload_1
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: aload_3
    //   111: aastore
    //   112: aconst_null
    //   113: aconst_null
    //   114: ldc_w 309
    //   117: invokevirtual 211	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   120: astore_3
    //   121: aload_3
    //   122: ifnull +56 -> 178
    //   125: new 311	java/util/ArrayList
    //   128: dup
    //   129: aload_3
    //   130: invokeinterface 314 1 0
    //   135: invokespecial 317	java/util/ArrayList:<init>	(I)V
    //   138: astore 4
    //   140: aload 4
    //   142: astore_2
    //   143: aload_3
    //   144: invokeinterface 215 1 0
    //   149: ifeq +31 -> 180
    //   152: aload 4
    //   154: aload_0
    //   155: aload_3
    //   156: invokespecial 293	com/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder:a	(Landroid/database/Cursor;)Lcom/tencent/mobileqq/weiyun/model/DownloadJobContext;
    //   159: invokeinterface 322 2 0
    //   164: pop
    //   165: goto -25 -> 140
    //   168: aload 4
    //   170: astore_2
    //   171: goto +27 -> 198
    //   174: astore_1
    //   175: goto +15 -> 190
    //   178: aconst_null
    //   179: astore_2
    //   180: aload_3
    //   181: invokestatic 223	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   184: goto +18 -> 202
    //   187: astore_1
    //   188: aconst_null
    //   189: astore_3
    //   190: aload_3
    //   191: invokestatic 223	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   194: aload_1
    //   195: athrow
    //   196: aconst_null
    //   197: astore_3
    //   198: aload_3
    //   199: invokestatic 223	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   202: invokestatic 151	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   205: aload 5
    //   207: invokevirtual 173	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   210: aload_0
    //   211: getfield 64	com/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder:jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorInfoRecorder$InfoRecorderCallback	Lcom/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder$InfoRecorderCallback;
    //   214: aload_1
    //   215: aload_2
    //   216: invokeinterface 325 3 0
    //   221: return
    //   222: astore_3
    //   223: goto -27 -> 196
    //   226: astore 4
    //   228: goto -30 -> 198
    //   231: astore_2
    //   232: goto -64 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	InfoRecorder
    //   0	235	1	paramString	String
    //   12	204	2	localObject1	Object
    //   231	1	2	localThrowable1	java.lang.Throwable
    //   10	189	3	localObject2	Object
    //   222	1	3	localThrowable2	java.lang.Throwable
    //   35	134	4	localObject3	Object
    //   226	1	4	localThrowable3	java.lang.Throwable
    //   7	199	5	localJobDbWrapper	JobDbWrapper
    // Exception table:
    //   from	to	target	type
    //   125	140	174	finally
    //   143	165	174	finally
    //   88	121	187	finally
    //   88	121	222	java/lang/Throwable
    //   125	140	226	java/lang/Throwable
    //   143	165	231	java/lang/Throwable
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(DownloadJobContext paramDownloadJobContext, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.sendMessage(Message.obtain(null, 4, paramString));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      boolean bool2 = false;
      boolean bool1 = false;
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return false;
          }
          b((String)paramMessage.obj);
          return true;
        }
        long l = ((Long)paramMessage.obj).longValue();
        if (paramMessage.arg1 == 1) {
          bool1 = true;
        }
        b(l, bool1);
        return true;
      }
      ContentValues localContentValues = (ContentValues)((Object[])(Object[])paramMessage.obj)[0];
      WeiyunDownloadStatusInfo localWeiyunDownloadStatusInfo = (WeiyunDownloadStatusInfo)((Object[])(Object[])paramMessage.obj)[1];
      bool1 = bool2;
      if (paramMessage.arg1 == 1) {
        bool1 = true;
      }
      a(localContentValues, localWeiyunDownloadStatusInfo, bool1);
      return true;
    }
    b(paramMessage.arg1, (DownloadJobContext)paramMessage.obj);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.processor.InfoRecorder
 * JD-Core Version:    0.7.0.1
 */