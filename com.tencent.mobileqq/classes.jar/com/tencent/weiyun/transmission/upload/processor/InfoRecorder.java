package com.tencent.weiyun.transmission.upload.processor;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.weiyun.transmission.db.JobDbWrapper;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadFile.UploadBatch;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.utils.IOUtils;
import java.util.List;

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
  private final InfoRecorderCallback mCallback;
  private final Handler mHandler;
  
  public InfoRecorder(InfoRecorderCallback paramInfoRecorderCallback)
  {
    this.mCallback = paramInfoRecorderCallback;
    paramInfoRecorderCallback = new HandlerThread("upload-info-recorder");
    paramInfoRecorderCallback.start();
    this.mHandler = new Handler(paramInfoRecorderCallback.getLooper(), this);
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
  
  private void deleteData(long paramLong, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    JobDbWrapper localJobDbWrapper = JobDbManager.getInstance().openJobDb(true);
    if (localJobDbWrapper == null)
    {
      TsLog.e("UploadInfoRecorder", "deleteData: Job db is null.");
      localObject3 = this.mCallback;
      if (i <= 0) {
        break label295;
      }
    }
    label295:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((InfoRecorderCallback)localObject3).onInfoRemoved(paramLong, paramBoolean, (UploadJobContext)localObject1);
      return;
      localObject1 = localObject3;
      i = j;
      if (paramLong >= 0L)
      {
        localObject3 = null;
        localObject1 = null;
      }
      try
      {
        Cursor localCursor = localJobDbWrapper.query("upload", PROJ_RESTORE, "_id=?", new String[] { Long.toString(paramLong) }, null, null, null);
        Object localObject4 = localObject6;
        if (localCursor != null)
        {
          localObject4 = localObject6;
          localObject1 = localCursor;
          localObject3 = localCursor;
          if (localCursor.moveToNext())
          {
            localObject1 = localCursor;
            localObject3 = localCursor;
            localObject4 = convertData(localCursor);
          }
        }
        IOUtils.closeSilently(localCursor);
        localObject1 = localObject4;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localObject3 = localObject1;
          TsLog.e("UploadInfoRecorder", localThrowable);
          IOUtils.closeSilently((Cursor)localObject1);
          localObject1 = localObject5;
        }
      }
      finally
      {
        IOUtils.closeSilently((Cursor)localObject3);
      }
      if (paramBoolean)
      {
        localObject3 = new ContentValues();
        ((ContentValues)localObject3).put("valid_flag", Integer.valueOf(0));
      }
      for (i = localJobDbWrapper.update("upload", (ContentValues)localObject3, "_id=?", new String[] { Long.toString(paramLong) });; i = localJobDbWrapper.delete("upload", "_id=?", new String[] { Long.toString(paramLong) }))
      {
        JobDbManager.getInstance().closeJobDb(localJobDbWrapper);
        break;
      }
    }
  }
  
  private void insertData(int paramInt, UploadJobContext paramUploadJobContext)
  {
    if (paramUploadJobContext == null) {
      return;
    }
    UploadFile localUploadFile = paramUploadJobContext.file();
    UploadJobContext.StatusInfo localStatusInfo = paramUploadJobContext.statusInfo();
    JobDbWrapper localJobDbWrapper = JobDbManager.getInstance().openJobDb(true);
    if (localJobDbWrapper == null)
    {
      TsLog.e("UploadInfoRecorder", "insertData: Job db is null.");
      return;
    }
    long l2 = -1L;
    Object localObject3 = paramUploadJobContext.uid();
    String str1 = localUploadFile.localPath;
    String str2 = localUploadFile.pDirKey;
    StringBuilder localStringBuilder = new StringBuilder().append("uid").append("=? AND ").append("local_path").append("=? AND ").append("p_dir_key").append("=? ");
    Object localObject2 = null;
    Object localObject1 = null;
    long l1;
    int i;
    try
    {
      localObject3 = localJobDbWrapper.query("upload", PROJ_ADD, localStringBuilder.toString(), new String[] { localObject3, str1, str2 }, null, null, "insert_time DESC limit 1");
      l1 = l2;
      if (localObject3 != null)
      {
        l1 = l2;
        localObject1 = localObject3;
        localObject2 = localObject3;
        if (((Cursor)localObject3).moveToNext())
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          i = ((Cursor)localObject3).getInt(0);
          l1 = i;
        }
      }
      IOUtils.closeSilently((Cursor)localObject3);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        label374:
        localObject2 = localObject1;
        label419:
        TsLog.e("UploadInfoRecorder", localThrowable);
        IOUtils.closeSilently((Cursor)localObject1);
        l1 = l2;
      }
    }
    finally
    {
      IOUtils.closeSilently(localObject2);
    }
    l2 = System.currentTimeMillis();
    localObject1 = new ContentValues();
    ((ContentValues)localObject1).put("uid", paramUploadJobContext.uid());
    ((ContentValues)localObject1).put("cmd_type", Integer.valueOf(localUploadFile.cmdType));
    ((ContentValues)localObject1).put("local_path", localUploadFile.localPath);
    ((ContentValues)localObject1).put("local_modified", Long.valueOf(localUploadFile.lastModified));
    ((ContentValues)localObject1).put("file_name", localUploadFile.fileName);
    ((ContentValues)localObject1).put("p_dir_uid", localUploadFile.rootDirUid);
    ((ContentValues)localObject1).put("p_dir_name", localUploadFile.pDirName);
    ((ContentValues)localObject1).put("p_dir_key", localUploadFile.pDirKey);
    ((ContentValues)localObject1).put("pp_dir_key", localUploadFile.pPDirKey);
    ((ContentValues)localObject1).put("insert_time", Long.valueOf(l2));
    ((ContentValues)localObject1).put("thumb_uri", localUploadFile.thumbUrl);
    if (localUploadFile.isCompress)
    {
      i = 1;
      ((ContentValues)localObject1).put("compress_flag", Integer.valueOf(i));
      ((ContentValues)localObject1).put("cover_file_id", localUploadFile.coverFileId);
      ((ContentValues)localObject1).put("cover_file_version", localUploadFile.coverFileVersion);
      if (!localUploadFile.autoBackupFlag) {
        break label618;
      }
      i = 1;
      ((ContentValues)localObject1).put("auto_backup_flag", Integer.valueOf(i));
      ((ContentValues)localObject1).put("group_root_dir_key", localUploadFile.groupRootDirKey);
      ((ContentValues)localObject1).put("batch_id", localUploadFile.batchId);
      ((ContentValues)localObject1).put("batch_total", Integer.valueOf(localUploadFile.batchTotal));
      ((ContentValues)localObject1).put("batch_index", Integer.valueOf(localUploadFile.batchIndex));
      ((ContentValues)localObject1).put("batch_desc", localUploadFile.batchDesc);
      ((ContentValues)localObject1).put("valid_flag", Integer.valueOf(1));
      paramUploadJobContext.setBirthTime(l2);
      if (l1 < 0L) {
        break label623;
      }
      localJobDbWrapper.update("upload", (ContentValues)localObject1, "_id=?", new String[] { Long.toString(l1) });
    }
    for (;;)
    {
      JobDbManager.getInstance().closeJobDb(localJobDbWrapper);
      if (l1 < 0L) {
        break;
      }
      paramUploadJobContext.setDbId(l1);
      this.mCallback.onInfoAdded(paramInt, paramUploadJobContext);
      return;
      i = 0;
      break label374;
      label618:
      i = 0;
      break label419;
      label623:
      ((ContentValues)localObject1).put("state", Integer.valueOf(localStatusInfo.state));
      ((ContentValues)localObject1).put("error_code", Integer.valueOf(localStatusInfo.errorCode));
      ((ContentValues)localObject1).put("error_msg", localStatusInfo.errorMsg);
      ((ContentValues)localObject1).put("total_size", Long.valueOf(localStatusInfo.totalSize));
      ((ContentValues)localObject1).put("cur_size", Long.valueOf(localStatusInfo.currSize));
      ((ContentValues)localObject1).put("file_id", localStatusInfo.fileId);
      l1 = localJobDbWrapper.insert("upload", null, (ContentValues)localObject1);
    }
  }
  
  /* Error */
  private void restoreData(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: invokestatic 353	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   12: iconst_0
    //   13: invokevirtual 357	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   16: astore 7
    //   18: aload 7
    //   20: ifnonnull +24 -> 44
    //   23: ldc 99
    //   25: ldc_w 515
    //   28: invokestatic 365	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 196	com/tencent/weiyun/transmission/upload/processor/InfoRecorder:mCallback	Lcom/tencent/weiyun/transmission/upload/processor/InfoRecorder$InfoRecorderCallback;
    //   35: aload_1
    //   36: aload 4
    //   38: invokeinterface 519 3 0
    //   43: return
    //   44: new 521	java/util/ArrayList
    //   47: dup
    //   48: invokespecial 522	java/util/ArrayList:<init>	()V
    //   51: astore 8
    //   53: aconst_null
    //   54: astore 4
    //   56: aconst_null
    //   57: astore_3
    //   58: iconst_5
    //   59: invokestatic 524	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   62: astore_2
    //   63: new 449	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 450	java/lang/StringBuilder:<init>	()V
    //   70: ldc 113
    //   72: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc_w 456
    //   78: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc_w 402
    //   84: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 526
    //   90: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc 177
    //   95: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc_w 528
    //   101: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: astore 9
    //   106: aload 7
    //   108: ldc_w 371
    //   111: getstatic 189	com/tencent/weiyun/transmission/upload/processor/InfoRecorder:PROJ_RESTORE	[Ljava/lang/String;
    //   114: aload 9
    //   116: invokevirtual 460	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: iconst_2
    //   120: anewarray 107	java/lang/String
    //   123: dup
    //   124: iconst_0
    //   125: aload_1
    //   126: aastore
    //   127: dup
    //   128: iconst_1
    //   129: aload_2
    //   130: aastore
    //   131: aconst_null
    //   132: aconst_null
    //   133: ldc_w 530
    //   136: invokevirtual 385	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   139: astore_2
    //   140: aload 5
    //   142: astore 4
    //   144: aload_2
    //   145: ifnull +167 -> 312
    //   148: aload_2
    //   149: astore_3
    //   150: aload_2
    //   151: astore 4
    //   153: new 521	java/util/ArrayList
    //   156: dup
    //   157: aload_2
    //   158: invokeinterface 534 1 0
    //   163: invokespecial 537	java/util/ArrayList:<init>	(I)V
    //   166: astore 5
    //   168: aload_2
    //   169: invokeinterface 389 1 0
    //   174: ifeq +134 -> 308
    //   177: aload_0
    //   178: aload_2
    //   179: invokespecial 391	com/tencent/weiyun/transmission/upload/processor/InfoRecorder:convertData	(Landroid/database/Cursor;)Lcom/tencent/weiyun/transmission/upload/UploadJobContext;
    //   182: astore_3
    //   183: aload_3
    //   184: invokevirtual 433	com/tencent/weiyun/transmission/upload/UploadJobContext:file	()Lcom/tencent/weiyun/transmission/upload/UploadFile;
    //   187: getfield 297	com/tencent/weiyun/transmission/upload/UploadFile:autoBackupFlag	Z
    //   190: ifeq +99 -> 289
    //   193: aload 8
    //   195: aload_3
    //   196: invokeinterface 543 2 0
    //   201: pop
    //   202: goto -34 -> 168
    //   205: astore_3
    //   206: aload 5
    //   208: astore 4
    //   210: aload_3
    //   211: astore 5
    //   213: aload_2
    //   214: astore_3
    //   215: ldc 99
    //   217: aload 5
    //   219: invokestatic 423	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   222: aload_2
    //   223: invokestatic 397	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   226: aload 8
    //   228: invokeinterface 546 1 0
    //   233: ifne +151 -> 384
    //   236: new 449	java/lang/StringBuilder
    //   239: dup
    //   240: ldc_w 548
    //   243: invokespecial 549	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   246: astore_2
    //   247: aload 8
    //   249: invokeinterface 553 1 0
    //   254: astore_3
    //   255: aload_3
    //   256: invokeinterface 558 1 0
    //   261: ifeq +58 -> 319
    //   264: aload_2
    //   265: aload_3
    //   266: invokeinterface 562 1 0
    //   271: checkcast 332	com/tencent/weiyun/transmission/upload/UploadJobContext
    //   274: invokevirtual 565	com/tencent/weiyun/transmission/upload/UploadJobContext:dbId	()J
    //   277: invokevirtual 568	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   280: bipush 44
    //   282: invokevirtual 571	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: goto -31 -> 255
    //   289: aload 5
    //   291: aload_3
    //   292: invokeinterface 543 2 0
    //   297: pop
    //   298: goto -130 -> 168
    //   301: astore_1
    //   302: aload_2
    //   303: invokestatic 397	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   306: aload_1
    //   307: athrow
    //   308: aload 5
    //   310: astore 4
    //   312: aload_2
    //   313: invokestatic 397	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   316: goto -90 -> 226
    //   319: aload_2
    //   320: aload_2
    //   321: invokevirtual 574	java/lang/StringBuilder:length	()I
    //   324: iconst_1
    //   325: isub
    //   326: bipush 41
    //   328: invokevirtual 578	java/lang/StringBuilder:setCharAt	(IC)V
    //   331: new 399	android/content/ContentValues
    //   334: dup
    //   335: iconst_1
    //   336: invokespecial 579	android/content/ContentValues:<init>	(I)V
    //   339: astore_3
    //   340: aload_3
    //   341: ldc_w 402
    //   344: iconst_0
    //   345: invokestatic 408	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: invokevirtual 412	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   351: aload 7
    //   353: ldc_w 371
    //   356: aload_3
    //   357: new 449	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 450	java/lang/StringBuilder:<init>	()V
    //   364: ldc 109
    //   366: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: aload_2
    //   370: invokevirtual 460	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 460	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: aconst_null
    //   380: invokevirtual 416	com/tencent/weiyun/transmission/db/JobDbWrapper:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   383: pop
    //   384: invokestatic 353	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   387: aload 7
    //   389: invokevirtual 420	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   392: goto -361 -> 31
    //   395: astore_1
    //   396: aload_3
    //   397: astore_2
    //   398: goto -96 -> 302
    //   401: astore 5
    //   403: aload 4
    //   405: astore_2
    //   406: aload 6
    //   408: astore 4
    //   410: goto -197 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	InfoRecorder
    //   0	413	1	paramString	String
    //   62	344	2	localObject1	Object
    //   57	139	3	localObject2	Object
    //   205	6	3	localThrowable1	Throwable
    //   214	183	3	localObject3	Object
    //   7	402	4	localObject4	Object
    //   4	305	5	localObject5	Object
    //   401	1	5	localThrowable2	Throwable
    //   1	406	6	localObject6	Object
    //   16	372	7	localJobDbWrapper	JobDbWrapper
    //   51	197	8	localArrayList	java.util.ArrayList
    //   104	11	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   168	202	205	java/lang/Throwable
    //   289	298	205	java/lang/Throwable
    //   168	202	301	finally
    //   289	298	301	finally
    //   106	140	395	finally
    //   153	168	395	finally
    //   215	222	395	finally
    //   106	140	401	java/lang/Throwable
    //   153	168	401	java/lang/Throwable
  }
  
  private void updateData(ContentValues paramContentValues, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramContentValues == null) || (paramContentValues.size() <= 0)) {
      return;
    }
    long l = paramContentValues.getAsLong("_id").longValue();
    int j = 0;
    int i = 0;
    JobDbWrapper localJobDbWrapper = JobDbManager.getInstance().openJobDb(true);
    if (localJobDbWrapper == null)
    {
      TsLog.e("UploadInfoRecorder", "updateData: Job db is null.");
      paramContentValues = this.mCallback;
      if (i <= 0) {
        break label125;
      }
    }
    for (;;)
    {
      paramContentValues.onInfoUpdated(l, bool, paramStatusInfo, paramBoolean);
      return;
      i = j;
      if (l >= 0L) {
        i = localJobDbWrapper.update("upload", paramContentValues, "_id=?", new String[] { Long.toString(l) });
      }
      JobDbManager.getInstance().closeJobDb(localJobDbWrapper);
      break;
      label125:
      bool = false;
    }
  }
  
  public void addInfo(int paramInt, UploadJobContext paramUploadJobContext)
  {
    if (paramUploadJobContext == null) {
      return;
    }
    Message.obtain(this.mHandler, 1, paramInt, 0, paramUploadJobContext).sendToTarget();
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
    Handler localHandler = this.mHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Message.obtain(localHandler, 3, i, 0, Long.valueOf(paramLong)).sendToTarget();
      return;
    }
  }
  
  public void restoreInfo(String paramString)
  {
    Message.obtain(this.mHandler, 4, paramString).sendToTarget();
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
    Message.obtain(this.mHandler, 2, localContentValues).sendToTarget();
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
      Message.obtain(paramUploadJobContext, 2, i, 0, new Object[] { localContentValues, localStatusInfo }).sendToTarget();
      return;
    }
  }
  
  public static abstract interface InfoRecorderCallback
  {
    public abstract void onInfoAdded(int paramInt, UploadJobContext paramUploadJobContext);
    
    public abstract void onInfoRemoved(long paramLong, boolean paramBoolean, UploadJobContext paramUploadJobContext);
    
    public abstract void onInfoRestored(String paramString, List<UploadJobContext> paramList);
    
    public abstract void onInfoUpdated(long paramLong, boolean paramBoolean1, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.processor.InfoRecorder
 * JD-Core Version:    0.7.0.1
 */