package com.tencent.weiyun.transmission.upload.processor;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.weiyun.transmission.db.JobDbWrapper;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadFile.UploadBatch;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

public class InfoRecorder
  implements Handler.Callback
{
  private static final int COL_UP_ALBUM = 20;
  private static final int COL_UP_ARTIST = 21;
  private static final int COL_UP_AUTO_BACKUP_FLAG = 27;
  private static final int COL_UP_BATCH_DESC = 32;
  private static final int COL_UP_BATCH_ID = 29;
  private static final int COL_UP_BATCH_INDEX = 31;
  private static final int COL_UP_BATCH_TOTAL = 30;
  private static final int COL_UP_CMD_TYPE = 2;
  private static final int COL_UP_COMPRESS_FLAG = 22;
  private static final int COL_UP_COMPRESS_PATH = 23;
  private static final int COL_UP_COMPRESS_SHA = 24;
  private static final int COL_UP_COVER_FILE_ID = 25;
  private static final int COL_UP_COVER_FILE_VERSION = 26;
  private static final int COL_UP_CUR_SIZE = 37;
  private static final int COL_UP_DURATION = 19;
  private static final int COL_UP_ERROR_CODE = 34;
  private static final int COL_UP_ERROR_MSG = 35;
  private static final int COL_UP_FILE_ID = 38;
  private static final int COL_UP_FILE_NAME = 10;
  private static final int COL_UP_FILE_SIZE = 11;
  private static final int COL_UP_GROUP_ROOT_DIR_KEY = 28;
  private static final int COL_UP_HEIGHT = 18;
  private static final int COL_UP_ID = 0;
  private static final int COL_UP_INSERT_TIME = 9;
  private static final int COL_UP_LATITUDE = 15;
  private static final int COL_UP_LOCAL_MODIFIED = 4;
  private static final int COL_UP_LOCAL_PATH = 3;
  private static final int COL_UP_LOCAL_SHA = 12;
  private static final int COL_UP_LONGITUDE = 14;
  private static final int COL_UP_MIME_TYPE = 13;
  private static final int COL_UP_PP_DIR_KEY = 8;
  private static final int COL_UP_P_DIR_KEY = 7;
  private static final int COL_UP_P_DIR_NAME = 6;
  private static final int COL_UP_P_DIR_UID = 5;
  private static final int COL_UP_STATE = 33;
  private static final int COL_UP_TAKEN_TIME = 16;
  private static final int COL_UP_TOTAL_SIZE = 36;
  private static final int COL_UP_UID = 1;
  private static final int COL_UP_WIDTH = 17;
  private static final int MSG_ADD = 1;
  private static final int MSG_REMOVE = 3;
  private static final int MSG_RESTORE = 4;
  private static final int MSG_UPDATE = 2;
  private static final String[] PROJ_ADD = { "_id" };
  private static final String[] PROJ_RESTORE = { "_id", "uid", "cmd_type", "local_path", "local_modified", "p_dir_uid", "p_dir_name", "p_dir_key", "pp_dir_key", "insert_time", "file_name", "file_size", "local_sha", "mime_type", "longitude", "latitude", "taken_time", "width", "height", "duration", "album", "artist", "compress_flag", "compress_path", "compress_sha", "cover_file_id", "cover_file_version", "auto_backup_flag", "group_root_dir_key", "batch_id", "batch_total", "batch_index", "batch_desc", "state", "error_code", "error_msg", "total_size", "cur_size", "file_id" };
  private static final String TAG = "UploadInfoRecorder";
  private final InfoRecorder.InfoRecorderCallback mCallback;
  private final ReleaseLooperHandler mHandler;
  
  public InfoRecorder(InfoRecorder.InfoRecorderCallback paramInfoRecorderCallback, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.mCallback = paramInfoRecorderCallback;
    this.mHandler = paramReleaseLooperHandler;
    this.mHandler.addCallback(this);
  }
  
  private UploadJobContext convertData(Cursor paramCursor)
  {
    Object localObject1 = UploadFile.createUploadBatch(paramCursor.getInt(30), paramCursor.getString(32));
    int i = paramCursor.getInt(2);
    Object localObject2 = paramCursor.getString(5);
    String str1 = paramCursor.getString(6);
    String str2 = paramCursor.getString(7);
    String str3 = paramCursor.getString(8);
    String str4 = paramCursor.getString(3);
    boolean bool;
    if (paramCursor.getInt(22) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localObject1 = UploadFile.createUploadFile(i, (String)localObject2, str1, str2, str3, str4, bool, (UploadFile.UploadBatch)localObject1, paramCursor.getInt(31));
    ((UploadFile)localObject1).lastModified = paramCursor.getLong(4);
    ((UploadFile)localObject1).fileName = paramCursor.getString(10);
    ((UploadFile)localObject1).fileSize = paramCursor.getLong(11);
    ((UploadFile)localObject1).sha = paramCursor.getString(12);
    ((UploadFile)localObject1).mimeType = paramCursor.getString(13);
    ((UploadFile)localObject1).longitude = paramCursor.getDouble(14);
    ((UploadFile)localObject1).latitude = paramCursor.getDouble(15);
    ((UploadFile)localObject1).takenTime = paramCursor.getLong(16);
    ((UploadFile)localObject1).width = paramCursor.getInt(17);
    ((UploadFile)localObject1).height = paramCursor.getInt(18);
    ((UploadFile)localObject1).duration = paramCursor.getLong(19);
    ((UploadFile)localObject1).album = paramCursor.getString(20);
    ((UploadFile)localObject1).artist = paramCursor.getString(21);
    ((UploadFile)localObject1).compressedPath = paramCursor.getString(23);
    ((UploadFile)localObject1).compressedSha = paramCursor.getString(24);
    ((UploadFile)localObject1).coverFileId = paramCursor.getString(25);
    ((UploadFile)localObject1).coverFileVersion = paramCursor.getString(26);
    if (paramCursor.getInt(27) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((UploadFile)localObject1).autoBackupFlag = bool;
    ((UploadFile)localObject1).groupRootDirKey = paramCursor.getString(28);
    ((UploadFile)localObject1).batchId = paramCursor.getString(29);
    localObject2 = new UploadJobContext.StatusInfo();
    ((UploadJobContext.StatusInfo)localObject2).state = paramCursor.getInt(33);
    ((UploadJobContext.StatusInfo)localObject2).errorCode = paramCursor.getInt(34);
    ((UploadJobContext.StatusInfo)localObject2).errorMsg = paramCursor.getString(35);
    ((UploadJobContext.StatusInfo)localObject2).totalSize = paramCursor.getLong(36);
    ((UploadJobContext.StatusInfo)localObject2).currSize = paramCursor.getLong(37);
    ((UploadJobContext.StatusInfo)localObject2).fileId = paramCursor.getString(38);
    ((UploadJobContext.StatusInfo)localObject2).filePath = ((UploadFile)localObject1).localPath;
    ((UploadJobContext.StatusInfo)localObject2).autoBackupFlag = ((UploadFile)localObject1).autoBackupFlag;
    localObject1 = UploadJobContext.createInstance(paramCursor.getString(1), (UploadFile)localObject1, (UploadJobContext.StatusInfo)localObject2);
    ((UploadJobContext)localObject1).setDbId(paramCursor.getLong(0));
    ((UploadJobContext)localObject1).setBirthTime(paramCursor.getLong(9));
    return localObject1;
  }
  
  /* Error */
  private void deleteData(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 337	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   3: astore 6
    //   5: iconst_1
    //   6: istore 5
    //   8: aload 6
    //   10: iconst_1
    //   11: invokevirtual 341	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   14: astore 11
    //   16: aconst_null
    //   17: astore 7
    //   19: aconst_null
    //   20: astore 8
    //   22: aconst_null
    //   23: astore 6
    //   25: aconst_null
    //   26: astore 10
    //   28: aload 11
    //   30: ifnonnull +21 -> 51
    //   33: ldc 96
    //   35: ldc_w 343
    //   38: invokestatic 349	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: iconst_0
    //   42: istore 4
    //   44: aload 6
    //   46: astore 8
    //   48: goto +234 -> 282
    //   51: lload_1
    //   52: lconst_0
    //   53: lcmp
    //   54: iflt +217 -> 271
    //   57: aload 11
    //   59: ldc_w 351
    //   62: getstatic 186	com/tencent/weiyun/transmission/upload/processor/InfoRecorder:PROJ_RESTORE	[Ljava/lang/String;
    //   65: ldc_w 353
    //   68: iconst_1
    //   69: anewarray 104	java/lang/String
    //   72: dup
    //   73: iconst_0
    //   74: lload_1
    //   75: invokestatic 359	java/lang/Long:toString	(J)Ljava/lang/String;
    //   78: aastore
    //   79: aconst_null
    //   80: aconst_null
    //   81: aconst_null
    //   82: invokevirtual 365	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   85: astore 6
    //   87: aload 6
    //   89: astore 9
    //   91: aload 10
    //   93: astore 8
    //   95: aload 6
    //   97: ifnull +78 -> 175
    //   100: aload 6
    //   102: astore 9
    //   104: aload 10
    //   106: astore 8
    //   108: aload 6
    //   110: astore 7
    //   112: aload 6
    //   114: invokeinterface 369 1 0
    //   119: ifeq +56 -> 175
    //   122: aload 6
    //   124: astore 7
    //   126: aload_0
    //   127: aload 6
    //   129: invokespecial 371	com/tencent/weiyun/transmission/upload/processor/InfoRecorder:convertData	(Landroid/database/Cursor;)Lcom/tencent/weiyun/transmission/upload/UploadJobContext;
    //   132: astore 8
    //   134: aload 6
    //   136: astore 9
    //   138: goto +37 -> 175
    //   141: astore 8
    //   143: goto +13 -> 156
    //   146: astore 6
    //   148: goto +115 -> 263
    //   151: astore 8
    //   153: aconst_null
    //   154: astore 6
    //   156: aload 6
    //   158: astore 7
    //   160: ldc 96
    //   162: aload 8
    //   164: invokestatic 374	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   167: aload 10
    //   169: astore 8
    //   171: aload 6
    //   173: astore 9
    //   175: aload 9
    //   177: invokestatic 380	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   180: iload_3
    //   181: ifeq +53 -> 234
    //   184: new 382	android/content/ContentValues
    //   187: dup
    //   188: invokespecial 383	android/content/ContentValues:<init>	()V
    //   191: astore 6
    //   193: aload 6
    //   195: ldc_w 385
    //   198: iconst_0
    //   199: invokestatic 391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   202: invokevirtual 395	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   205: aload 11
    //   207: ldc_w 351
    //   210: aload 6
    //   212: ldc_w 353
    //   215: iconst_1
    //   216: anewarray 104	java/lang/String
    //   219: dup
    //   220: iconst_0
    //   221: lload_1
    //   222: invokestatic 359	java/lang/Long:toString	(J)Ljava/lang/String;
    //   225: aastore
    //   226: invokevirtual 399	com/tencent/weiyun/transmission/db/JobDbWrapper:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   229: istore 4
    //   231: goto +43 -> 274
    //   234: aload 11
    //   236: ldc_w 351
    //   239: ldc_w 353
    //   242: iconst_1
    //   243: anewarray 104	java/lang/String
    //   246: dup
    //   247: iconst_0
    //   248: lload_1
    //   249: invokestatic 359	java/lang/Long:toString	(J)Ljava/lang/String;
    //   252: aastore
    //   253: invokevirtual 403	com/tencent/weiyun/transmission/db/JobDbWrapper:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   256: istore 4
    //   258: goto +16 -> 274
    //   261: astore 6
    //   263: aload 7
    //   265: invokestatic 380	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   268: aload 6
    //   270: athrow
    //   271: iconst_0
    //   272: istore 4
    //   274: invokestatic 337	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   277: aload 11
    //   279: invokevirtual 407	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   282: aload_0
    //   283: getfield 193	com/tencent/weiyun/transmission/upload/processor/InfoRecorder:mCallback	Lcom/tencent/weiyun/transmission/upload/processor/InfoRecorder$InfoRecorderCallback;
    //   286: astore 6
    //   288: iload 4
    //   290: ifle +9 -> 299
    //   293: iload 5
    //   295: istore_3
    //   296: goto +5 -> 301
    //   299: iconst_0
    //   300: istore_3
    //   301: aload 6
    //   303: lload_1
    //   304: iload_3
    //   305: aload 8
    //   307: invokeinterface 413 5 0
    //   312: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	InfoRecorder
    //   0	313	1	paramLong	long
    //   0	313	3	paramBoolean	boolean
    //   42	247	4	i	int
    //   6	288	5	bool	boolean
    //   3	132	6	localObject1	Object
    //   146	1	6	localObject2	Object
    //   154	57	6	localContentValues	ContentValues
    //   261	8	6	localObject3	Object
    //   286	16	6	localInfoRecorderCallback	InfoRecorder.InfoRecorderCallback
    //   17	247	7	localObject4	Object
    //   20	113	8	localObject5	Object
    //   141	1	8	localThrowable1	java.lang.Throwable
    //   151	12	8	localThrowable2	java.lang.Throwable
    //   169	137	8	localObject6	Object
    //   89	87	9	localObject7	Object
    //   26	142	10	localObject8	Object
    //   14	264	11	localJobDbWrapper	JobDbWrapper
    // Exception table:
    //   from	to	target	type
    //   112	122	141	java/lang/Throwable
    //   126	134	141	java/lang/Throwable
    //   57	87	146	finally
    //   57	87	151	java/lang/Throwable
    //   112	122	261	finally
    //   126	134	261	finally
    //   160	167	261	finally
  }
  
  private void insertData(int paramInt, UploadJobContext paramUploadJobContext)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  /* Error */
  private void restoreData(String paramString)
  {
    // Byte code:
    //   0: invokestatic 337	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   3: iconst_0
    //   4: invokevirtual 341	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   7: astore 7
    //   9: aload 7
    //   11: ifnonnull +16 -> 27
    //   14: ldc 96
    //   16: ldc_w 427
    //   19: invokestatic 349	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aconst_null
    //   23: astore_3
    //   24: goto +417 -> 441
    //   27: new 429	java/util/ArrayList
    //   30: dup
    //   31: invokespecial 430	java/util/ArrayList:<init>	()V
    //   34: astore 8
    //   36: iconst_5
    //   37: invokestatic 432	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   40: astore_2
    //   41: new 434	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 435	java/lang/StringBuilder:<init>	()V
    //   48: astore 4
    //   50: aload 4
    //   52: ldc 110
    //   54: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 4
    //   60: ldc_w 441
    //   63: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 4
    //   69: ldc_w 385
    //   72: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 4
    //   78: ldc_w 443
    //   81: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 4
    //   87: ldc 174
    //   89: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 4
    //   95: ldc_w 445
    //   98: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: getstatic 186	com/tencent/weiyun/transmission/upload/processor/InfoRecorder:PROJ_RESTORE	[Ljava/lang/String;
    //   105: astore_3
    //   106: aload 4
    //   108: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: astore 4
    //   113: aload 7
    //   115: ldc_w 351
    //   118: aload_3
    //   119: aload 4
    //   121: iconst_2
    //   122: anewarray 104	java/lang/String
    //   125: dup
    //   126: iconst_0
    //   127: aload_1
    //   128: aastore
    //   129: dup
    //   130: iconst_1
    //   131: aload_2
    //   132: aastore
    //   133: aconst_null
    //   134: aconst_null
    //   135: ldc_w 450
    //   138: invokevirtual 365	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   141: astore_2
    //   142: aload_2
    //   143: ifnull +99 -> 242
    //   146: aload_2
    //   147: astore 4
    //   149: new 429	java/util/ArrayList
    //   152: dup
    //   153: aload_2
    //   154: invokeinterface 454 1 0
    //   159: invokespecial 457	java/util/ArrayList:<init>	(I)V
    //   162: astore 5
    //   164: aload_2
    //   165: astore 6
    //   167: aload 5
    //   169: astore_3
    //   170: aload_2
    //   171: astore 4
    //   173: aload_2
    //   174: invokeinterface 369 1 0
    //   179: ifeq +103 -> 282
    //   182: aload_2
    //   183: astore 4
    //   185: aload_0
    //   186: aload_2
    //   187: invokespecial 371	com/tencent/weiyun/transmission/upload/processor/InfoRecorder:convertData	(Landroid/database/Cursor;)Lcom/tencent/weiyun/transmission/upload/UploadJobContext;
    //   190: astore_3
    //   191: aload_2
    //   192: astore 4
    //   194: aload_3
    //   195: invokevirtual 461	com/tencent/weiyun/transmission/upload/UploadJobContext:file	()Lcom/tencent/weiyun/transmission/upload/UploadFile;
    //   198: getfield 281	com/tencent/weiyun/transmission/upload/UploadFile:autoBackupFlag	Z
    //   201: ifeq +18 -> 219
    //   204: aload_2
    //   205: astore 4
    //   207: aload 8
    //   209: aload_3
    //   210: invokeinterface 467 2 0
    //   215: pop
    //   216: goto -52 -> 164
    //   219: aload_2
    //   220: astore 4
    //   222: aload 5
    //   224: aload_3
    //   225: invokeinterface 467 2 0
    //   230: pop
    //   231: goto -67 -> 164
    //   234: astore_3
    //   235: goto +32 -> 267
    //   238: astore_3
    //   239: goto +25 -> 264
    //   242: aconst_null
    //   243: astore_3
    //   244: aload_2
    //   245: astore 6
    //   247: goto +35 -> 282
    //   250: astore_3
    //   251: goto +11 -> 262
    //   254: astore_1
    //   255: aconst_null
    //   256: astore 4
    //   258: goto +196 -> 454
    //   261: astore_3
    //   262: aconst_null
    //   263: astore_2
    //   264: aconst_null
    //   265: astore 5
    //   267: aload_2
    //   268: astore 4
    //   270: ldc 96
    //   272: aload_3
    //   273: invokestatic 374	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   276: aload 5
    //   278: astore_3
    //   279: aload_2
    //   280: astore 6
    //   282: aload 6
    //   284: invokestatic 380	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   287: aload 8
    //   289: invokeinterface 470 1 0
    //   294: ifne +139 -> 433
    //   297: new 434	java/lang/StringBuilder
    //   300: dup
    //   301: ldc_w 472
    //   304: invokespecial 473	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   307: astore_2
    //   308: aload 8
    //   310: invokeinterface 477 1 0
    //   315: astore 4
    //   317: aload 4
    //   319: invokeinterface 482 1 0
    //   324: ifeq +31 -> 355
    //   327: aload_2
    //   328: aload 4
    //   330: invokeinterface 486 1 0
    //   335: checkcast 316	com/tencent/weiyun/transmission/upload/UploadJobContext
    //   338: invokevirtual 490	com/tencent/weiyun/transmission/upload/UploadJobContext:dbId	()J
    //   341: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload_2
    //   346: bipush 44
    //   348: invokevirtual 496	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: goto -35 -> 317
    //   355: aload_2
    //   356: aload_2
    //   357: invokevirtual 499	java/lang/StringBuilder:length	()I
    //   360: iconst_1
    //   361: isub
    //   362: bipush 41
    //   364: invokevirtual 503	java/lang/StringBuilder:setCharAt	(IC)V
    //   367: new 382	android/content/ContentValues
    //   370: dup
    //   371: iconst_1
    //   372: invokespecial 504	android/content/ContentValues:<init>	(I)V
    //   375: astore 4
    //   377: aload 4
    //   379: ldc_w 385
    //   382: iconst_0
    //   383: invokestatic 391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   386: invokevirtual 395	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   389: new 434	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 435	java/lang/StringBuilder:<init>	()V
    //   396: astore 5
    //   398: aload 5
    //   400: ldc 106
    //   402: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload 5
    //   408: aload_2
    //   409: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload 7
    //   418: ldc_w 351
    //   421: aload 4
    //   423: aload 5
    //   425: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: aconst_null
    //   429: invokevirtual 399	com/tencent/weiyun/transmission/db/JobDbWrapper:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   432: pop
    //   433: invokestatic 337	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   436: aload 7
    //   438: invokevirtual 407	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   441: aload_0
    //   442: getfield 193	com/tencent/weiyun/transmission/upload/processor/InfoRecorder:mCallback	Lcom/tencent/weiyun/transmission/upload/processor/InfoRecorder$InfoRecorderCallback;
    //   445: aload_1
    //   446: aload_3
    //   447: invokeinterface 508 3 0
    //   452: return
    //   453: astore_1
    //   454: aload 4
    //   456: invokestatic 380	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   459: goto +5 -> 464
    //   462: aload_1
    //   463: athrow
    //   464: goto -2 -> 462
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	InfoRecorder
    //   0	467	1	paramString	String
    //   40	369	2	localObject1	Object
    //   23	202	3	localObject2	Object
    //   234	1	3	localThrowable1	java.lang.Throwable
    //   238	1	3	localThrowable2	java.lang.Throwable
    //   243	1	3	localObject3	Object
    //   250	1	3	localThrowable3	java.lang.Throwable
    //   261	12	3	localThrowable4	java.lang.Throwable
    //   278	169	3	localObject4	Object
    //   48	407	4	localObject5	Object
    //   162	262	5	localObject6	Object
    //   165	118	6	localObject7	Object
    //   7	430	7	localJobDbWrapper	JobDbWrapper
    //   34	275	8	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   173	182	234	java/lang/Throwable
    //   185	191	234	java/lang/Throwable
    //   194	204	234	java/lang/Throwable
    //   207	216	234	java/lang/Throwable
    //   222	231	234	java/lang/Throwable
    //   149	164	238	java/lang/Throwable
    //   113	142	250	java/lang/Throwable
    //   102	113	254	finally
    //   113	142	254	finally
    //   102	113	261	java/lang/Throwable
    //   149	164	453	finally
    //   173	182	453	finally
    //   185	191	453	finally
    //   194	204	453	finally
    //   207	216	453	finally
    //   222	231	453	finally
    //   270	276	453	finally
  }
  
  private void updateData(ContentValues paramContentValues, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean)
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
        TsLog.e("UploadInfoRecorder", "updateData: Job db is null.");
        i = 0;
      }
      else
      {
        if (l >= 0L) {
          i = localJobDbWrapper.update("upload", paramContentValues, "_id=?", new String[] { Long.toString(l) });
        } else {
          i = 0;
        }
        JobDbManager.getInstance().closeJobDb(localJobDbWrapper);
      }
      paramContentValues = this.mCallback;
      if (i > 0) {
        bool = true;
      }
      paramContentValues.onInfoUpdated(l, bool, paramStatusInfo, paramBoolean);
    }
  }
  
  public void addInfo(int paramInt, UploadJobContext paramUploadJobContext)
  {
    if (paramUploadJobContext == null) {
      return;
    }
    this.mHandler.sendMessage(Message.obtain(null, 1, paramInt, 0, paramUploadJobContext));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    boolean bool = false;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return false;
          }
          restoreData((String)paramMessage.obj);
        }
        else
        {
          long l = ((Long)paramMessage.obj).longValue();
          if (paramMessage.arg1 == 1) {
            bool = true;
          }
          deleteData(l, bool);
        }
      }
      else if (paramMessage.arg1 == 1) {
        updateData((ContentValues)((Object[])(Object[])paramMessage.obj)[0], (UploadJobContext.StatusInfo)((Object[])(Object[])paramMessage.obj)[1], true);
      } else {
        updateData((ContentValues)paramMessage.obj, null, false);
      }
    }
    else {
      insertData(paramMessage.arg1, (UploadJobContext)paramMessage.obj);
    }
    return true;
  }
  
  public void removeInfo(long paramLong, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void restoreInfo(String paramString)
  {
    this.mHandler.sendMessage(Message.obtain(null, 4, paramString));
  }
  
  public void updateInfo(long paramLong, UploadFile paramUploadFile)
  {
    if (paramLong >= 0L)
    {
      if (paramUploadFile == null) {
        return;
      }
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("_id", Long.valueOf(paramLong));
      localContentValues.put("p_dir_name", paramUploadFile.pDirName);
      localContentValues.put("p_dir_key", paramUploadFile.pDirKey);
      localContentValues.put("pp_dir_key", paramUploadFile.pPDirKey);
      localContentValues.put("local_path", paramUploadFile.localPath);
      localContentValues.put("local_modified", Long.valueOf(paramUploadFile.lastModified));
      localContentValues.put("file_size", Long.valueOf(paramUploadFile.fileSize));
      localContentValues.put("local_sha", paramUploadFile.sha);
      localContentValues.put("mime_type", paramUploadFile.mimeType);
      localContentValues.put("longitude", Double.valueOf(paramUploadFile.longitude));
      localContentValues.put("latitude", Double.valueOf(paramUploadFile.latitude));
      localContentValues.put("taken_time", Long.valueOf(paramUploadFile.takenTime));
      localContentValues.put("width", Integer.valueOf(paramUploadFile.width));
      localContentValues.put("height", Integer.valueOf(paramUploadFile.height));
      localContentValues.put("duration", Long.valueOf(paramUploadFile.duration));
      localContentValues.put("album", paramUploadFile.album);
      localContentValues.put("artist", paramUploadFile.artist);
      localContentValues.put("compress_path", paramUploadFile.compressedPath);
      localContentValues.put("compress_sha", paramUploadFile.compressedSha);
      this.mHandler.sendMessage(Message.obtain(null, 2, localContentValues));
    }
  }
  
  public void updateInfo(UploadJobContext paramUploadJobContext, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.processor.InfoRecorder
 * JD-Core Version:    0.7.0.1
 */