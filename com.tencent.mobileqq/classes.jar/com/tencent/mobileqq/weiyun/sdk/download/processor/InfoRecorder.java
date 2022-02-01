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
  private static final String[] a = { "_id", "cloud_sha", "local_path" };
  private static final String[] b = { "_id", "uid", "cmd_type", "file_name", "p_dir_uid", "p_dir_key", "file_id", "cloud_sha", "file_size", "file_type", "file_version", "group_root_dir_key", "state", "error_code", "error_msg", "total_size", "cur_size", "local_path", "local_dir" };
  private final InfoRecorder.InfoRecorderCallback c;
  private final ReleaseLooperHandler d;
  
  public InfoRecorder(InfoRecorder.InfoRecorderCallback paramInfoRecorderCallback, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.c = paramInfoRecorderCallback;
    this.d = paramReleaseLooperHandler;
    this.d.addCallback(this);
  }
  
  private DownloadJobContext a(Cursor paramCursor)
  {
    Object localObject = DownloadFile.a(paramCursor.getInt(2), paramCursor.getString(6), paramCursor.getString(3), paramCursor.getString(7), paramCursor.getLong(8), paramCursor.getInt(9), paramCursor.getString(4), paramCursor.getString(5), null);
    ((DownloadFile)localObject).i = paramCursor.getString(11);
    WeiyunDownloadStatusInfo localWeiyunDownloadStatusInfo = new WeiyunDownloadStatusInfo();
    localWeiyunDownloadStatusInfo.a = paramCursor.getInt(12);
    localWeiyunDownloadStatusInfo.b = paramCursor.getInt(13);
    localWeiyunDownloadStatusInfo.c = paramCursor.getString(14);
    localWeiyunDownloadStatusInfo.d = paramCursor.getLong(15);
    localWeiyunDownloadStatusInfo.e = paramCursor.getLong(16);
    localWeiyunDownloadStatusInfo.f = paramCursor.getString(17);
    localWeiyunDownloadStatusInfo.g = ((DownloadFile)localObject).b;
    localWeiyunDownloadStatusInfo.h = paramCursor.getString(10);
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
      paramContentValues = this.c;
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
    //   6: invokevirtual 189	com/tencent/mobileqq/weiyun/model/DownloadJobContext:c	()Lcom/tencent/mobileqq/weiyun/model/DownloadFile;
    //   9: astore 12
    //   11: aload_2
    //   12: invokevirtual 193	com/tencent/mobileqq/weiyun/model/DownloadJobContext:m	()Lcom/tencent/mobileqq/weiyun/model/WeiyunDownloadStatusInfo;
    //   15: astore 13
    //   17: invokestatic 156	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   20: iconst_1
    //   21: invokevirtual 160	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   24: astore 11
    //   26: aload 11
    //   28: ifnonnull +4 -> 32
    //   31: return
    //   32: aload_2
    //   33: invokevirtual 196	com/tencent/mobileqq/weiyun/model/DownloadJobContext:b	()Ljava/lang/String;
    //   36: astore 8
    //   38: aload 12
    //   40: getfield 119	com/tencent/mobileqq/weiyun/model/DownloadFile:b	Ljava/lang/String;
    //   43: astore 9
    //   45: aload_2
    //   46: invokevirtual 198	com/tencent/mobileqq/weiyun/model/DownloadJobContext:d	()Ljava/lang/String;
    //   49: astore 10
    //   51: new 200	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   58: astore 15
    //   60: aload 15
    //   62: ldc 27
    //   64: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 15
    //   70: ldc 207
    //   72: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 15
    //   78: ldc 37
    //   80: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 15
    //   86: ldc 207
    //   88: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 15
    //   94: ldc 57
    //   96: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 15
    //   102: ldc 209
    //   104: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: getstatic 25	com/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder:a	[Ljava/lang/String;
    //   111: astore 14
    //   113: aload 15
    //   115: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore 15
    //   120: aload 11
    //   122: ldc 162
    //   124: aload 14
    //   126: aload 15
    //   128: iconst_3
    //   129: anewarray 17	java/lang/String
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
    //   149: ldc 213
    //   151: invokevirtual 217	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   154: astore 8
    //   156: aload 8
    //   158: ifnull +78 -> 236
    //   161: aload 8
    //   163: invokeinterface 221 1 0
    //   168: ifeq +68 -> 236
    //   171: aload 8
    //   173: iconst_0
    //   174: invokeinterface 81 2 0
    //   179: istore_3
    //   180: iload_3
    //   181: i2l
    //   182: lstore 4
    //   184: aload 8
    //   186: iconst_1
    //   187: invokeinterface 85 2 0
    //   192: astore 10
    //   194: aload 8
    //   196: iconst_2
    //   197: invokeinterface 85 2 0
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
    //   242: ldc2_w 222
    //   245: lstore 4
    //   247: aload 8
    //   249: invokestatic 229	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   252: aload 10
    //   254: astore 8
    //   256: goto +33 -> 289
    //   259: astore_2
    //   260: aconst_null
    //   261: astore 8
    //   263: aload 8
    //   265: invokestatic 229	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   268: aload_2
    //   269: athrow
    //   270: aconst_null
    //   271: astore 9
    //   273: aconst_null
    //   274: astore 8
    //   276: ldc2_w 222
    //   279: lstore 4
    //   281: aload 9
    //   283: invokestatic 229	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   286: aconst_null
    //   287: astore 9
    //   289: aload 12
    //   291: getfield 231	com/tencent/mobileqq/weiyun/model/DownloadFile:d	Ljava/lang/String;
    //   294: astore 10
    //   296: new 136	android/content/ContentValues
    //   299: dup
    //   300: invokespecial 232	android/content/ContentValues:<init>	()V
    //   303: astore 14
    //   305: aload 14
    //   307: ldc 27
    //   309: aload_2
    //   310: invokevirtual 196	com/tencent/mobileqq/weiyun/model/DownloadJobContext:b	()Ljava/lang/String;
    //   313: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload 14
    //   318: ldc 29
    //   320: aload 12
    //   322: getfield 237	com/tencent/mobileqq/weiyun/model/DownloadFile:a	I
    //   325: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   328: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   331: aload 14
    //   333: ldc 31
    //   335: aload 12
    //   337: getfield 247	com/tencent/mobileqq/weiyun/model/DownloadFile:c	Ljava/lang/String;
    //   340: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: aload 14
    //   345: ldc 33
    //   347: aload 12
    //   349: getfield 248	com/tencent/mobileqq/weiyun/model/DownloadFile:g	Ljava/lang/String;
    //   352: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: aload 14
    //   357: ldc 35
    //   359: aload 12
    //   361: getfield 249	com/tencent/mobileqq/weiyun/model/DownloadFile:h	Ljava/lang/String;
    //   364: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: aload 14
    //   369: ldc 37
    //   371: aload 12
    //   373: getfield 119	com/tencent/mobileqq/weiyun/model/DownloadFile:b	Ljava/lang/String;
    //   376: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: aload 14
    //   381: ldc 21
    //   383: aload 10
    //   385: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   388: aload 14
    //   390: ldc 39
    //   392: aload 12
    //   394: getfield 250	com/tencent/mobileqq/weiyun/model/DownloadFile:e	J
    //   397: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   400: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   403: aload 14
    //   405: ldc 41
    //   407: aload 12
    //   409: getfield 258	com/tencent/mobileqq/weiyun/model/DownloadFile:f	I
    //   412: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   415: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   418: aload 14
    //   420: ldc 57
    //   422: aload_2
    //   423: invokevirtual 198	com/tencent/mobileqq/weiyun/model/DownloadJobContext:d	()Ljava/lang/String;
    //   426: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: aload 14
    //   431: ldc_w 260
    //   434: invokestatic 265	java/lang/System:currentTimeMillis	()J
    //   437: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   440: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   443: aload 14
    //   445: ldc_w 267
    //   448: aload 12
    //   450: getfield 270	com/tencent/mobileqq/weiyun/model/DownloadFile:j	Ljava/lang/String;
    //   453: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: aload 14
    //   458: ldc 45
    //   460: aload 12
    //   462: getfield 98	com/tencent/mobileqq/weiyun/model/DownloadFile:i	Ljava/lang/String;
    //   465: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: aload 14
    //   470: ldc_w 272
    //   473: iconst_1
    //   474: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   477: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   480: aload 13
    //   482: getfield 117	com/tencent/mobileqq/weiyun/model/WeiyunDownloadStatusInfo:f	Ljava/lang/String;
    //   485: invokestatic 278	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   488: ifne +15 -> 503
    //   491: aload 14
    //   493: ldc 23
    //   495: aload 13
    //   497: getfield 117	com/tencent/mobileqq/weiyun/model/WeiyunDownloadStatusInfo:f	Ljava/lang/String;
    //   500: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   503: lload 4
    //   505: lconst_0
    //   506: lcmp
    //   507: iflt +64 -> 571
    //   510: aload 11
    //   512: ldc 162
    //   514: aload 14
    //   516: ldc 164
    //   518: iconst_1
    //   519: anewarray 17	java/lang/String
    //   522: dup
    //   523: iconst_0
    //   524: lload 4
    //   526: invokestatic 168	java/lang/Long:toString	(J)Ljava/lang/String;
    //   529: aastore
    //   530: invokevirtual 174	com/tencent/weiyun/transmission/db/JobDbWrapper:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   533: pop
    //   534: ldc_w 280
    //   537: aload 10
    //   539: invokevirtual 284	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   542: ifne +17 -> 559
    //   545: lload 4
    //   547: lstore 6
    //   549: aload 8
    //   551: aload 10
    //   553: invokestatic 287	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   556: ifne +99 -> 655
    //   559: ldc_w 289
    //   562: astore 9
    //   564: lload 4
    //   566: lstore 6
    //   568: goto +87 -> 655
    //   571: aload 14
    //   573: ldc 47
    //   575: aload 13
    //   577: getfield 104	com/tencent/mobileqq/weiyun/model/WeiyunDownloadStatusInfo:a	I
    //   580: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   583: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   586: aload 14
    //   588: ldc 49
    //   590: aload 13
    //   592: getfield 106	com/tencent/mobileqq/weiyun/model/WeiyunDownloadStatusInfo:b	I
    //   595: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   598: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   601: aload 14
    //   603: ldc 51
    //   605: aload 13
    //   607: getfield 108	com/tencent/mobileqq/weiyun/model/WeiyunDownloadStatusInfo:c	Ljava/lang/String;
    //   610: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: aload 14
    //   615: ldc 53
    //   617: aload 13
    //   619: getfield 111	com/tencent/mobileqq/weiyun/model/WeiyunDownloadStatusInfo:d	J
    //   622: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   625: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   628: aload 14
    //   630: ldc 55
    //   632: aload 13
    //   634: getfield 114	com/tencent/mobileqq/weiyun/model/WeiyunDownloadStatusInfo:e	J
    //   637: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   640: invokevirtual 256	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   643: aload 11
    //   645: ldc 162
    //   647: aconst_null
    //   648: aload 14
    //   650: invokevirtual 293	com/tencent/weiyun/transmission/db/JobDbWrapper:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   653: lstore 6
    //   655: invokestatic 156	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   658: aload 11
    //   660: invokevirtual 178	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   663: lload 6
    //   665: lconst_0
    //   666: lcmp
    //   667: iflt +23 -> 690
    //   670: aload_2
    //   671: lload 6
    //   673: invokevirtual 133	com/tencent/mobileqq/weiyun/model/DownloadJobContext:a	(J)V
    //   676: aload_0
    //   677: getfield 66	com/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder:c	Lcom/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder$InfoRecorderCallback;
    //   680: iload_1
    //   681: aload_2
    //   682: aload 9
    //   684: invokeinterface 296 4 0
    //   689: return
    //   690: return
    //   691: astore 8
    //   693: goto -423 -> 270
    //   696: astore 8
    //   698: goto -428 -> 270
    //   701: astore 9
    //   703: aload 8
    //   705: astore 9
    //   707: goto -434 -> 273
    //   710: astore 9
    //   712: goto -494 -> 218
    //   715: astore 9
    //   717: goto -510 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	720	0	this	InfoRecorder
    //   0	720	1	paramInt	int
    //   0	720	2	paramDownloadJobContext	DownloadJobContext
    //   179	2	3	i	int
    //   182	383	4	l1	long
    //   547	125	6	l2	long
    //   36	514	8	localObject1	Object
    //   691	1	8	localThrowable1	java.lang.Throwable
    //   696	8	8	localThrowable2	java.lang.Throwable
    //   43	640	9	localObject2	Object
    //   701	1	9	localThrowable3	java.lang.Throwable
    //   705	1	9	localThrowable4	java.lang.Throwable
    //   710	1	9	localThrowable5	java.lang.Throwable
    //   715	1	9	localThrowable6	java.lang.Throwable
    //   49	503	10	str	String
    //   24	635	11	localJobDbWrapper	JobDbWrapper
    //   9	452	12	localDownloadFile	DownloadFile
    //   15	618	13	localWeiyunDownloadStatusInfo	WeiyunDownloadStatusInfo
    //   111	538	14	localObject3	Object
    //   58	69	15	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   161	180	232	finally
    //   184	194	232	finally
    //   194	204	232	finally
    //   108	120	259	finally
    //   120	156	259	finally
    //   108	120	691	java/lang/Throwable
    //   120	156	696	java/lang/Throwable
    //   161	180	701	java/lang/Throwable
    //   184	194	710	java/lang/Throwable
    //   194	204	715	java/lang/Throwable
  }
  
  /* Error */
  private void b(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 156	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   3: astore 6
    //   5: iconst_1
    //   6: istore 5
    //   8: aload 6
    //   10: iconst_1
    //   11: invokevirtual 160	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
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
    //   51: ldc 162
    //   53: getstatic 59	com/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder:b	[Ljava/lang/String;
    //   56: ldc 164
    //   58: iconst_1
    //   59: anewarray 17	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: lload_1
    //   65: invokestatic 168	java/lang/Long:toString	(J)Ljava/lang/String;
    //   68: aastore
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: invokevirtual 217	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
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
    //   100: invokeinterface 221 1 0
    //   105: ifeq +48 -> 153
    //   108: aload_0
    //   109: aload 7
    //   111: invokespecial 299	com/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder:a	(Landroid/database/Cursor;)Lcom/tencent/mobileqq/weiyun/model/DownloadJobContext;
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
    //   140: invokestatic 229	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   143: aload 7
    //   145: athrow
    //   146: aconst_null
    //   147: astore 8
    //   149: aload 9
    //   151: astore 6
    //   153: aload 8
    //   155: invokestatic 229	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   158: iload_3
    //   159: ifeq +51 -> 210
    //   162: new 136	android/content/ContentValues
    //   165: dup
    //   166: invokespecial 232	android/content/ContentValues:<init>	()V
    //   169: astore 7
    //   171: aload 7
    //   173: ldc_w 272
    //   176: iconst_0
    //   177: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   183: aload 10
    //   185: ldc 162
    //   187: aload 7
    //   189: ldc 164
    //   191: iconst_1
    //   192: anewarray 17	java/lang/String
    //   195: dup
    //   196: iconst_0
    //   197: lload_1
    //   198: invokestatic 168	java/lang/Long:toString	(J)Ljava/lang/String;
    //   201: aastore
    //   202: invokevirtual 174	com/tencent/weiyun/transmission/db/JobDbWrapper:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   205: istore 4
    //   207: goto +35 -> 242
    //   210: aload 10
    //   212: ldc 162
    //   214: ldc 164
    //   216: iconst_1
    //   217: anewarray 17	java/lang/String
    //   220: dup
    //   221: iconst_0
    //   222: lload_1
    //   223: invokestatic 168	java/lang/Long:toString	(J)Ljava/lang/String;
    //   226: aastore
    //   227: invokevirtual 303	com/tencent/weiyun/transmission/db/JobDbWrapper:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   230: istore 4
    //   232: goto +10 -> 242
    //   235: iconst_0
    //   236: istore 4
    //   238: aload 7
    //   240: astore 6
    //   242: invokestatic 156	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   245: aload 10
    //   247: invokevirtual 178	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   250: aload_0
    //   251: getfield 66	com/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder:c	Lcom/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder$InfoRecorderCallback;
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
    //   275: invokeinterface 306 5 0
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
    //   0: invokestatic 156	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   3: iconst_0
    //   4: invokevirtual 160	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
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
    //   24: invokestatic 309	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   27: astore_3
    //   28: new 200	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   35: astore 4
    //   37: aload 4
    //   39: ldc 27
    //   41: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 4
    //   47: ldc 207
    //   49: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 4
    //   55: ldc_w 272
    //   58: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 4
    //   64: ldc_w 311
    //   67: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 4
    //   73: ldc 47
    //   75: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 4
    //   81: ldc_w 313
    //   84: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 5
    //   90: ldc 162
    //   92: getstatic 59	com/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder:b	[Ljava/lang/String;
    //   95: aload 4
    //   97: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: iconst_2
    //   101: anewarray 17	java/lang/String
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
    //   114: ldc_w 315
    //   117: invokevirtual 217	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   120: astore_3
    //   121: aload_3
    //   122: ifnull +56 -> 178
    //   125: new 317	java/util/ArrayList
    //   128: dup
    //   129: aload_3
    //   130: invokeinterface 320 1 0
    //   135: invokespecial 323	java/util/ArrayList:<init>	(I)V
    //   138: astore 4
    //   140: aload 4
    //   142: astore_2
    //   143: aload_3
    //   144: invokeinterface 221 1 0
    //   149: ifeq +31 -> 180
    //   152: aload 4
    //   154: aload_0
    //   155: aload_3
    //   156: invokespecial 299	com/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder:a	(Landroid/database/Cursor;)Lcom/tencent/mobileqq/weiyun/model/DownloadJobContext;
    //   159: invokeinterface 328 2 0
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
    //   181: invokestatic 229	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   184: goto +18 -> 202
    //   187: astore_1
    //   188: aconst_null
    //   189: astore_3
    //   190: aload_3
    //   191: invokestatic 229	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   194: aload_1
    //   195: athrow
    //   196: aconst_null
    //   197: astore_3
    //   198: aload_3
    //   199: invokestatic 229	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   202: invokestatic 156	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   205: aload 5
    //   207: invokevirtual 178	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   210: aload_0
    //   211: getfield 66	com/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder:c	Lcom/tencent/mobileqq/weiyun/sdk/download/processor/InfoRecorder$InfoRecorderCallback;
    //   214: aload_1
    //   215: aload_2
    //   216: invokeinterface 331 3 0
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
    this.d.sendMessage(Message.obtain(null, 1, paramInt, 0, paramDownloadJobContext));
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
    this.d.sendMessage(Message.obtain(null, 4, paramString));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.processor.InfoRecorder
 * JD-Core Version:    0.7.0.1
 */