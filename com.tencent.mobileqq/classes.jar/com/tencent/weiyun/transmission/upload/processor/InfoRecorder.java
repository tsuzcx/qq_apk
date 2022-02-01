package com.tencent.weiyun.transmission.upload.processor;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
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
    if (paramCursor.getInt(22) == 1)
    {
      bool = true;
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
      if (paramCursor.getInt(27) != 1) {
        break label540;
      }
    }
    label540:
    for (boolean bool = true;; bool = false)
    {
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
      bool = false;
      break;
    }
  }
  
  /* Error */
  private void deleteData(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 6
    //   12: iconst_0
    //   13: istore 5
    //   15: invokestatic 337	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   18: iconst_1
    //   19: invokevirtual 341	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   22: astore 10
    //   24: aload 10
    //   26: ifnonnull +42 -> 68
    //   29: ldc 96
    //   31: ldc_w 343
    //   34: invokestatic 349	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: iconst_0
    //   38: istore 4
    //   40: aload_0
    //   41: getfield 193	com/tencent/weiyun/transmission/upload/processor/InfoRecorder:mCallback	Lcom/tencent/weiyun/transmission/upload/processor/InfoRecorder$InfoRecorderCallback;
    //   44: astore 7
    //   46: iload 5
    //   48: istore_3
    //   49: iload 4
    //   51: ifle +5 -> 56
    //   54: iconst_1
    //   55: istore_3
    //   56: aload 7
    //   58: lload_1
    //   59: iload_3
    //   60: aload 6
    //   62: invokeinterface 355 5 0
    //   67: return
    //   68: lload_1
    //   69: lconst_0
    //   70: lcmp
    //   71: iflt +220 -> 291
    //   74: aload 10
    //   76: ldc_w 357
    //   79: getstatic 186	com/tencent/weiyun/transmission/upload/processor/InfoRecorder:PROJ_RESTORE	[Ljava/lang/String;
    //   82: ldc_w 359
    //   85: iconst_1
    //   86: anewarray 104	java/lang/String
    //   89: dup
    //   90: iconst_0
    //   91: lload_1
    //   92: invokestatic 365	java/lang/Long:toString	(J)Ljava/lang/String;
    //   95: aastore
    //   96: aconst_null
    //   97: aconst_null
    //   98: aconst_null
    //   99: invokevirtual 371	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   102: astore 6
    //   104: aload 6
    //   106: ifnull +179 -> 285
    //   109: aload 6
    //   111: astore 7
    //   113: aload 6
    //   115: invokeinterface 375 1 0
    //   120: ifeq +165 -> 285
    //   123: aload 6
    //   125: astore 7
    //   127: aload_0
    //   128: aload 6
    //   130: invokespecial 377	com/tencent/weiyun/transmission/upload/processor/InfoRecorder:convertData	(Landroid/database/Cursor;)Lcom/tencent/weiyun/transmission/upload/UploadJobContext;
    //   133: astore 8
    //   135: aload 8
    //   137: astore 7
    //   139: aload 6
    //   141: invokestatic 383	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   144: aload 7
    //   146: astore 6
    //   148: iload_3
    //   149: ifeq +99 -> 248
    //   152: new 385	android/content/ContentValues
    //   155: dup
    //   156: invokespecial 386	android/content/ContentValues:<init>	()V
    //   159: astore 7
    //   161: aload 7
    //   163: ldc_w 388
    //   166: iconst_0
    //   167: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: invokevirtual 398	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   173: aload 10
    //   175: ldc_w 357
    //   178: aload 7
    //   180: ldc_w 359
    //   183: iconst_1
    //   184: anewarray 104	java/lang/String
    //   187: dup
    //   188: iconst_0
    //   189: lload_1
    //   190: invokestatic 365	java/lang/Long:toString	(J)Ljava/lang/String;
    //   193: aastore
    //   194: invokevirtual 402	com/tencent/weiyun/transmission/db/JobDbWrapper:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   197: istore 4
    //   199: invokestatic 337	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   202: aload 10
    //   204: invokevirtual 406	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   207: goto -167 -> 40
    //   210: astore 8
    //   212: aconst_null
    //   213: astore 6
    //   215: aload 6
    //   217: astore 7
    //   219: ldc 96
    //   221: aload 8
    //   223: invokestatic 409	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   226: aload 6
    //   228: invokestatic 383	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   231: aload 9
    //   233: astore 6
    //   235: goto -87 -> 148
    //   238: astore 6
    //   240: aload 7
    //   242: invokestatic 383	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   245: aload 6
    //   247: athrow
    //   248: aload 10
    //   250: ldc_w 357
    //   253: ldc_w 359
    //   256: iconst_1
    //   257: anewarray 104	java/lang/String
    //   260: dup
    //   261: iconst_0
    //   262: lload_1
    //   263: invokestatic 365	java/lang/Long:toString	(J)Ljava/lang/String;
    //   266: aastore
    //   267: invokevirtual 413	com/tencent/weiyun/transmission/db/JobDbWrapper:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   270: istore 4
    //   272: goto -73 -> 199
    //   275: astore 6
    //   277: goto -37 -> 240
    //   280: astore 8
    //   282: goto -67 -> 215
    //   285: aconst_null
    //   286: astore 7
    //   288: goto -149 -> 139
    //   291: iconst_0
    //   292: istore 4
    //   294: aload 8
    //   296: astore 6
    //   298: goto -99 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	InfoRecorder
    //   0	301	1	paramLong	long
    //   0	301	3	paramBoolean	boolean
    //   38	255	4	i	int
    //   13	34	5	bool	boolean
    //   10	224	6	localObject1	Object
    //   238	8	6	localObject2	Object
    //   275	1	6	localObject3	Object
    //   296	1	6	localThrowable1	java.lang.Throwable
    //   7	280	7	localObject4	Object
    //   4	132	8	localUploadJobContext	UploadJobContext
    //   210	12	8	localThrowable2	java.lang.Throwable
    //   280	15	8	localThrowable3	java.lang.Throwable
    //   1	231	9	localObject5	Object
    //   22	227	10	localJobDbWrapper	JobDbWrapper
    // Exception table:
    //   from	to	target	type
    //   74	104	210	java/lang/Throwable
    //   74	104	238	finally
    //   113	123	275	finally
    //   127	135	275	finally
    //   219	226	275	finally
    //   113	123	280	java/lang/Throwable
    //   127	135	280	java/lang/Throwable
  }
  
  /* Error */
  private void insertData(int paramInt, UploadJobContext paramUploadJobContext)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: invokevirtual 419	com/tencent/weiyun/transmission/upload/UploadJobContext:file	()Lcom/tencent/weiyun/transmission/upload/UploadFile;
    //   9: astore 10
    //   11: aload_2
    //   12: invokevirtual 423	com/tencent/weiyun/transmission/upload/UploadJobContext:statusInfo	()Lcom/tencent/weiyun/transmission/upload/UploadJobContext$StatusInfo;
    //   15: astore 11
    //   17: invokestatic 337	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   20: iconst_1
    //   21: invokevirtual 341	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   24: astore 12
    //   26: aload 12
    //   28: ifnonnull +12 -> 40
    //   31: ldc 96
    //   33: ldc_w 425
    //   36: invokestatic 349	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: return
    //   40: aload_2
    //   41: invokevirtual 428	com/tencent/weiyun/transmission/upload/UploadJobContext:uid	()Ljava/lang/String;
    //   44: astore 8
    //   46: aload 10
    //   48: getfield 310	com/tencent/weiyun/transmission/upload/UploadFile:localPath	Ljava/lang/String;
    //   51: astore 13
    //   53: aload 10
    //   55: getfield 431	com/tencent/weiyun/transmission/upload/UploadFile:pDirKey	Ljava/lang/String;
    //   58: astore 14
    //   60: new 433	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   67: ldc 110
    //   69: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 440
    //   75: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc 114
    //   80: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 440
    //   86: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 122
    //   91: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc_w 442
    //   97: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: astore 15
    //   102: aconst_null
    //   103: astore 9
    //   105: aload 12
    //   107: ldc_w 357
    //   110: getstatic 108	com/tencent/weiyun/transmission/upload/processor/InfoRecorder:PROJ_ADD	[Ljava/lang/String;
    //   113: aload 15
    //   115: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: iconst_3
    //   119: anewarray 104	java/lang/String
    //   122: dup
    //   123: iconst_0
    //   124: aload 8
    //   126: aastore
    //   127: dup
    //   128: iconst_1
    //   129: aload 13
    //   131: aastore
    //   132: dup
    //   133: iconst_2
    //   134: aload 14
    //   136: aastore
    //   137: aconst_null
    //   138: aconst_null
    //   139: ldc_w 446
    //   142: invokevirtual 371	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   145: astore 8
    //   147: aload 8
    //   149: ifnull +559 -> 708
    //   152: aload 8
    //   154: invokeinterface 375 1 0
    //   159: ifeq +549 -> 708
    //   162: aload 8
    //   164: iconst_0
    //   165: invokeinterface 209 2 0
    //   170: istore_3
    //   171: iload_3
    //   172: i2l
    //   173: lstore 4
    //   175: aload 8
    //   177: invokestatic 383	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   180: invokestatic 452	java/lang/System:currentTimeMillis	()J
    //   183: lstore 6
    //   185: new 385	android/content/ContentValues
    //   188: dup
    //   189: invokespecial 386	android/content/ContentValues:<init>	()V
    //   192: astore 8
    //   194: aload 8
    //   196: ldc 110
    //   198: aload_2
    //   199: invokevirtual 428	com/tencent/weiyun/transmission/upload/UploadJobContext:uid	()Ljava/lang/String;
    //   202: invokevirtual 454	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: aload 8
    //   207: ldc 112
    //   209: aload 10
    //   211: getfield 457	com/tencent/weiyun/transmission/upload/UploadFile:cmdType	I
    //   214: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   217: invokevirtual 398	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   220: aload 8
    //   222: ldc 114
    //   224: aload 10
    //   226: getfield 310	com/tencent/weiyun/transmission/upload/UploadFile:localPath	Ljava/lang/String;
    //   229: invokevirtual 454	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload 8
    //   234: ldc 116
    //   236: aload 10
    //   238: getfield 231	com/tencent/weiyun/transmission/upload/UploadFile:lastModified	J
    //   241: invokestatic 460	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   244: invokevirtual 463	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   247: aload 8
    //   249: ldc 128
    //   251: aload 10
    //   253: getfield 234	com/tencent/weiyun/transmission/upload/UploadFile:fileName	Ljava/lang/String;
    //   256: invokevirtual 454	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 8
    //   261: ldc 118
    //   263: aload 10
    //   265: getfield 466	com/tencent/weiyun/transmission/upload/UploadFile:rootDirUid	Ljava/lang/String;
    //   268: invokevirtual 454	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload 8
    //   273: ldc 120
    //   275: aload 10
    //   277: getfield 469	com/tencent/weiyun/transmission/upload/UploadFile:pDirName	Ljava/lang/String;
    //   280: invokevirtual 454	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload 8
    //   285: ldc 122
    //   287: aload 10
    //   289: getfield 431	com/tencent/weiyun/transmission/upload/UploadFile:pDirKey	Ljava/lang/String;
    //   292: invokevirtual 454	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload 8
    //   297: ldc 124
    //   299: aload 10
    //   301: getfield 472	com/tencent/weiyun/transmission/upload/UploadFile:pPDirKey	Ljava/lang/String;
    //   304: invokevirtual 454	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload 8
    //   309: ldc 126
    //   311: lload 6
    //   313: invokestatic 460	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   316: invokevirtual 463	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   319: aload 8
    //   321: ldc_w 474
    //   324: aload 10
    //   326: getfield 477	com/tencent/weiyun/transmission/upload/UploadFile:thumbUrl	Ljava/lang/String;
    //   329: invokevirtual 454	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: aload 10
    //   334: getfield 480	com/tencent/weiyun/transmission/upload/UploadFile:isCompress	Z
    //   337: ifeq +248 -> 585
    //   340: iconst_1
    //   341: istore_3
    //   342: aload 8
    //   344: ldc 152
    //   346: iload_3
    //   347: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   350: invokevirtual 398	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   353: aload 8
    //   355: ldc 158
    //   357: aload 10
    //   359: getfield 274	com/tencent/weiyun/transmission/upload/UploadFile:coverFileId	Ljava/lang/String;
    //   362: invokevirtual 454	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: aload 8
    //   367: ldc 160
    //   369: aload 10
    //   371: getfield 277	com/tencent/weiyun/transmission/upload/UploadFile:coverFileVersion	Ljava/lang/String;
    //   374: invokevirtual 454	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: aload 10
    //   379: getfield 281	com/tencent/weiyun/transmission/upload/UploadFile:autoBackupFlag	Z
    //   382: ifeq +208 -> 590
    //   385: iconst_1
    //   386: istore_3
    //   387: aload 8
    //   389: ldc 162
    //   391: iload_3
    //   392: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   395: invokevirtual 398	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   398: aload 8
    //   400: ldc 164
    //   402: aload 10
    //   404: getfield 284	com/tencent/weiyun/transmission/upload/UploadFile:groupRootDirKey	Ljava/lang/String;
    //   407: invokevirtual 454	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   410: aload 8
    //   412: ldc 166
    //   414: aload 10
    //   416: getfield 287	com/tencent/weiyun/transmission/upload/UploadFile:batchId	Ljava/lang/String;
    //   419: invokevirtual 454	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: aload 8
    //   424: ldc 168
    //   426: aload 10
    //   428: getfield 483	com/tencent/weiyun/transmission/upload/UploadFile:batchTotal	I
    //   431: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   434: invokevirtual 398	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   437: aload 8
    //   439: ldc 170
    //   441: aload 10
    //   443: getfield 486	com/tencent/weiyun/transmission/upload/UploadFile:batchIndex	I
    //   446: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   449: invokevirtual 398	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   452: aload 8
    //   454: ldc 172
    //   456: aload 10
    //   458: getfield 489	com/tencent/weiyun/transmission/upload/UploadFile:batchDesc	Ljava/lang/String;
    //   461: invokevirtual 454	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   464: aload 8
    //   466: ldc_w 388
    //   469: iconst_1
    //   470: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   473: invokevirtual 398	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   476: aload_2
    //   477: lload 6
    //   479: invokevirtual 327	com/tencent/weiyun/transmission/upload/UploadJobContext:setBirthTime	(J)V
    //   482: lload 4
    //   484: lconst_0
    //   485: lcmp
    //   486: iflt +109 -> 595
    //   489: aload 12
    //   491: ldc_w 357
    //   494: aload 8
    //   496: ldc_w 359
    //   499: iconst_1
    //   500: anewarray 104	java/lang/String
    //   503: dup
    //   504: iconst_0
    //   505: lload 4
    //   507: invokestatic 365	java/lang/Long:toString	(J)Ljava/lang/String;
    //   510: aastore
    //   511: invokevirtual 402	com/tencent/weiyun/transmission/db/JobDbWrapper:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   514: pop
    //   515: invokestatic 337	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   518: aload 12
    //   520: invokevirtual 406	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   523: lload 4
    //   525: lconst_0
    //   526: lcmp
    //   527: iflt -523 -> 4
    //   530: aload_2
    //   531: lload 4
    //   533: invokevirtual 324	com/tencent/weiyun/transmission/upload/UploadJobContext:setDbId	(J)V
    //   536: aload_0
    //   537: getfield 193	com/tencent/weiyun/transmission/upload/processor/InfoRecorder:mCallback	Lcom/tencent/weiyun/transmission/upload/processor/InfoRecorder$InfoRecorderCallback;
    //   540: iload_1
    //   541: aload_2
    //   542: invokeinterface 492 3 0
    //   547: return
    //   548: astore 9
    //   550: aconst_null
    //   551: astore 8
    //   553: ldc 96
    //   555: aload 9
    //   557: invokestatic 409	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   560: aload 8
    //   562: invokestatic 383	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   565: ldc2_w 493
    //   568: lstore 4
    //   570: goto -390 -> 180
    //   573: astore_2
    //   574: aload 9
    //   576: astore 8
    //   578: aload 8
    //   580: invokestatic 383	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   583: aload_2
    //   584: athrow
    //   585: iconst_0
    //   586: istore_3
    //   587: goto -245 -> 342
    //   590: iconst_0
    //   591: istore_3
    //   592: goto -205 -> 387
    //   595: aload 8
    //   597: ldc 174
    //   599: aload 11
    //   601: getfield 292	com/tencent/weiyun/transmission/upload/UploadJobContext$StatusInfo:state	I
    //   604: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   607: invokevirtual 398	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   610: aload 8
    //   612: ldc 176
    //   614: aload 11
    //   616: getfield 295	com/tencent/weiyun/transmission/upload/UploadJobContext$StatusInfo:errorCode	I
    //   619: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   622: invokevirtual 398	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   625: aload 8
    //   627: ldc 178
    //   629: aload 11
    //   631: getfield 298	com/tencent/weiyun/transmission/upload/UploadJobContext$StatusInfo:errorMsg	Ljava/lang/String;
    //   634: invokevirtual 454	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   637: aload 8
    //   639: ldc 180
    //   641: aload 11
    //   643: getfield 301	com/tencent/weiyun/transmission/upload/UploadJobContext$StatusInfo:totalSize	J
    //   646: invokestatic 460	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   649: invokevirtual 463	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   652: aload 8
    //   654: ldc 182
    //   656: aload 11
    //   658: getfield 304	com/tencent/weiyun/transmission/upload/UploadJobContext$StatusInfo:currSize	J
    //   661: invokestatic 460	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   664: invokevirtual 463	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   667: aload 8
    //   669: ldc 184
    //   671: aload 11
    //   673: getfield 307	com/tencent/weiyun/transmission/upload/UploadJobContext$StatusInfo:fileId	Ljava/lang/String;
    //   676: invokevirtual 454	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   679: aload 12
    //   681: ldc_w 357
    //   684: aconst_null
    //   685: aload 8
    //   687: invokevirtual 498	com/tencent/weiyun/transmission/db/JobDbWrapper:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   690: lstore 4
    //   692: goto -177 -> 515
    //   695: astore_2
    //   696: goto -118 -> 578
    //   699: astore_2
    //   700: goto -122 -> 578
    //   703: astore 9
    //   705: goto -152 -> 553
    //   708: ldc2_w 493
    //   711: lstore 4
    //   713: goto -538 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	716	0	this	InfoRecorder
    //   0	716	1	paramInt	int
    //   0	716	2	paramUploadJobContext	UploadJobContext
    //   170	422	3	i	int
    //   173	539	4	l1	long
    //   183	295	6	l2	long
    //   44	642	8	localObject1	Object
    //   103	1	9	localObject2	Object
    //   548	27	9	localThrowable1	java.lang.Throwable
    //   703	1	9	localThrowable2	java.lang.Throwable
    //   9	448	10	localUploadFile	UploadFile
    //   15	657	11	localStatusInfo	UploadJobContext.StatusInfo
    //   24	656	12	localJobDbWrapper	JobDbWrapper
    //   51	79	13	str1	String
    //   58	77	14	str2	String
    //   100	14	15	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   105	147	548	java/lang/Throwable
    //   105	147	573	finally
    //   152	171	695	finally
    //   553	560	699	finally
    //   152	171	703	java/lang/Throwable
  }
  
  /* Error */
  private void restoreData(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 337	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   5: iconst_0
    //   6: invokevirtual 341	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   9: astore 7
    //   11: aload 7
    //   13: ifnonnull +23 -> 36
    //   16: ldc 96
    //   18: ldc_w 502
    //   21: invokestatic 349	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_0
    //   25: getfield 193	com/tencent/weiyun/transmission/upload/processor/InfoRecorder:mCallback	Lcom/tencent/weiyun/transmission/upload/processor/InfoRecorder$InfoRecorderCallback;
    //   28: aload_1
    //   29: aload_2
    //   30: invokeinterface 506 3 0
    //   35: return
    //   36: new 508	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 509	java/util/ArrayList:<init>	()V
    //   43: astore 8
    //   45: iconst_5
    //   46: invokestatic 511	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   49: astore_2
    //   50: new 433	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   57: ldc 110
    //   59: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc_w 440
    //   65: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc_w 388
    //   71: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 513
    //   77: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 174
    //   82: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 515
    //   88: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: astore_3
    //   92: aload 7
    //   94: ldc_w 357
    //   97: getstatic 186	com/tencent/weiyun/transmission/upload/processor/InfoRecorder:PROJ_RESTORE	[Ljava/lang/String;
    //   100: aload_3
    //   101: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: iconst_2
    //   105: anewarray 104	java/lang/String
    //   108: dup
    //   109: iconst_0
    //   110: aload_1
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: aload_2
    //   115: aastore
    //   116: aconst_null
    //   117: aconst_null
    //   118: ldc_w 517
    //   121: invokevirtual 371	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   124: astore_3
    //   125: aload_3
    //   126: ifnull +181 -> 307
    //   129: aload_3
    //   130: astore 4
    //   132: new 508	java/util/ArrayList
    //   135: dup
    //   136: aload_3
    //   137: invokeinterface 521 1 0
    //   142: invokespecial 524	java/util/ArrayList:<init>	(I)V
    //   145: astore 6
    //   147: aload_3
    //   148: astore 4
    //   150: aload 6
    //   152: astore_2
    //   153: aload_3
    //   154: invokeinterface 375 1 0
    //   159: ifeq +150 -> 309
    //   162: aload_3
    //   163: astore 4
    //   165: aload_0
    //   166: aload_3
    //   167: invokespecial 377	com/tencent/weiyun/transmission/upload/processor/InfoRecorder:convertData	(Landroid/database/Cursor;)Lcom/tencent/weiyun/transmission/upload/UploadJobContext;
    //   170: astore_2
    //   171: aload_3
    //   172: astore 4
    //   174: aload_2
    //   175: invokevirtual 419	com/tencent/weiyun/transmission/upload/UploadJobContext:file	()Lcom/tencent/weiyun/transmission/upload/UploadFile;
    //   178: getfield 281	com/tencent/weiyun/transmission/upload/UploadFile:autoBackupFlag	Z
    //   181: ifeq +103 -> 284
    //   184: aload_3
    //   185: astore 4
    //   187: aload 8
    //   189: aload_2
    //   190: invokeinterface 530 2 0
    //   195: pop
    //   196: goto -49 -> 147
    //   199: astore 5
    //   201: aload 6
    //   203: astore_2
    //   204: aload_3
    //   205: astore 4
    //   207: ldc 96
    //   209: aload 5
    //   211: invokestatic 409	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   214: aload_3
    //   215: invokestatic 383	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   218: aload 8
    //   220: invokeinterface 533 1 0
    //   225: ifne +159 -> 384
    //   228: new 433	java/lang/StringBuilder
    //   231: dup
    //   232: ldc_w 535
    //   235: invokespecial 537	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   238: astore_3
    //   239: aload 8
    //   241: invokeinterface 541 1 0
    //   246: astore 4
    //   248: aload 4
    //   250: invokeinterface 546 1 0
    //   255: ifeq +61 -> 316
    //   258: aload_3
    //   259: aload 4
    //   261: invokeinterface 550 1 0
    //   266: checkcast 316	com/tencent/weiyun/transmission/upload/UploadJobContext
    //   269: invokevirtual 553	com/tencent/weiyun/transmission/upload/UploadJobContext:dbId	()J
    //   272: invokevirtual 556	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   275: bipush 44
    //   277: invokevirtual 559	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: goto -33 -> 248
    //   284: aload_3
    //   285: astore 4
    //   287: aload 6
    //   289: aload_2
    //   290: invokeinterface 530 2 0
    //   295: pop
    //   296: goto -149 -> 147
    //   299: astore_1
    //   300: aload 4
    //   302: invokestatic 383	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   305: aload_1
    //   306: athrow
    //   307: aconst_null
    //   308: astore_2
    //   309: aload_3
    //   310: invokestatic 383	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   313: goto -95 -> 218
    //   316: aload_3
    //   317: aload_3
    //   318: invokevirtual 562	java/lang/StringBuilder:length	()I
    //   321: iconst_1
    //   322: isub
    //   323: bipush 41
    //   325: invokevirtual 566	java/lang/StringBuilder:setCharAt	(IC)V
    //   328: new 385	android/content/ContentValues
    //   331: dup
    //   332: iconst_1
    //   333: invokespecial 567	android/content/ContentValues:<init>	(I)V
    //   336: astore 4
    //   338: aload 4
    //   340: ldc_w 388
    //   343: iconst_0
    //   344: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   347: invokevirtual 398	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   350: aload 7
    //   352: ldc_w 357
    //   355: aload 4
    //   357: new 433	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   364: ldc 106
    //   366: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: aload_3
    //   370: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: aconst_null
    //   380: invokevirtual 402	com/tencent/weiyun/transmission/db/JobDbWrapper:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   383: pop
    //   384: invokestatic 337	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   387: aload 7
    //   389: invokevirtual 406	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   392: goto -368 -> 24
    //   395: astore_1
    //   396: aconst_null
    //   397: astore 4
    //   399: goto -99 -> 300
    //   402: astore 5
    //   404: aconst_null
    //   405: astore_3
    //   406: aconst_null
    //   407: astore_2
    //   408: goto -204 -> 204
    //   411: astore 5
    //   413: aconst_null
    //   414: astore_2
    //   415: goto -211 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	this	InfoRecorder
    //   0	418	1	paramString	String
    //   1	414	2	localObject1	Object
    //   91	315	3	localObject2	Object
    //   130	268	4	localObject3	Object
    //   199	11	5	localThrowable1	java.lang.Throwable
    //   402	1	5	localThrowable2	java.lang.Throwable
    //   411	1	5	localThrowable3	java.lang.Throwable
    //   145	143	6	localArrayList1	java.util.ArrayList
    //   9	379	7	localJobDbWrapper	JobDbWrapper
    //   43	197	8	localArrayList2	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   153	162	199	java/lang/Throwable
    //   165	171	199	java/lang/Throwable
    //   174	184	199	java/lang/Throwable
    //   187	196	199	java/lang/Throwable
    //   287	296	199	java/lang/Throwable
    //   132	147	299	finally
    //   153	162	299	finally
    //   165	171	299	finally
    //   174	184	299	finally
    //   187	196	299	finally
    //   207	214	299	finally
    //   287	296	299	finally
    //   92	125	395	finally
    //   92	125	402	java/lang/Throwable
    //   132	147	411	java/lang/Throwable
  }
  
  private void updateData(ContentValues paramContentValues, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean)
  {
    boolean bool = false;
    if ((paramContentValues == null) || (paramContentValues.size() <= 0)) {
      return;
    }
    long l = paramContentValues.getAsLong("_id").longValue();
    JobDbWrapper localJobDbWrapper = JobDbManager.getInstance().openJobDb(true);
    if (localJobDbWrapper == null)
    {
      TsLog.e("UploadInfoRecorder", "updateData: Job db is null.");
      i = 0;
      paramContentValues = this.mCallback;
      if (i > 0) {
        bool = true;
      }
      paramContentValues.onInfoUpdated(l, bool, paramStatusInfo, paramBoolean);
      return;
    }
    if (l >= 0L) {}
    for (int i = localJobDbWrapper.update("upload", paramContentValues, "_id=?", new String[] { Long.toString(l) });; i = 0)
    {
      JobDbManager.getInstance().closeJobDb(localJobDbWrapper);
      break;
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
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      insertData(paramMessage.arg1, (UploadJobContext)paramMessage.obj);
      return true;
    case 2: 
      if (paramMessage.arg1 == 1)
      {
        updateData((ContentValues)((Object[])(Object[])paramMessage.obj)[0], (UploadJobContext.StatusInfo)((Object[])(Object[])paramMessage.obj)[1], true);
        return true;
      }
      updateData((ContentValues)paramMessage.obj, null, false);
      return true;
    case 3: 
      long l = ((Long)paramMessage.obj).longValue();
      if (paramMessage.arg1 == 1) {}
      for (boolean bool = true;; bool = false)
      {
        deleteData(l, bool);
        return true;
      }
    }
    restoreData((String)paramMessage.obj);
    return true;
  }
  
  public void removeInfo(long paramLong, boolean paramBoolean)
  {
    if (paramLong < 0L) {
      return;
    }
    ReleaseLooperHandler localReleaseLooperHandler = this.mHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localReleaseLooperHandler.sendMessage(Message.obtain(null, 3, i, 0, Long.valueOf(paramLong)));
      return;
    }
  }
  
  public void restoreInfo(String paramString)
  {
    this.mHandler.sendMessage(Message.obtain(null, 4, paramString));
  }
  
  public void updateInfo(long paramLong, UploadFile paramUploadFile)
  {
    if ((paramLong < 0L) || (paramUploadFile == null)) {
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
  
  public void updateInfo(UploadJobContext paramUploadJobContext, boolean paramBoolean)
  {
    if (paramUploadJobContext == null) {
      return;
    }
    UploadJobContext.StatusInfo localStatusInfo = paramUploadJobContext.cloneStatusInfo();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("_id", Long.valueOf(paramUploadJobContext.dbId()));
    localContentValues.put("state", Integer.valueOf(localStatusInfo.state));
    localContentValues.put("error_code", Integer.valueOf(localStatusInfo.errorCode));
    localContentValues.put("error_msg", localStatusInfo.errorMsg);
    localContentValues.put("total_size", Long.valueOf(localStatusInfo.totalSize));
    localContentValues.put("cur_size", Long.valueOf(localStatusInfo.currSize));
    localContentValues.put("file_id", localStatusInfo.fileId);
    if (!TextUtils.isEmpty(paramUploadJobContext.fileVersion())) {
      localContentValues.put("file_version", paramUploadJobContext.fileVersion());
    }
    paramUploadJobContext = this.mHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramUploadJobContext.sendMessage(Message.obtain(null, 2, i, 0, new Object[] { localContentValues, localStatusInfo }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.processor.InfoRecorder
 * JD-Core Version:    0.7.0.1
 */