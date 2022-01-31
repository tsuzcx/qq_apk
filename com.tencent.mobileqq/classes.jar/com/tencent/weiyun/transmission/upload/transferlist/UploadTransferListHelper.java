package com.tencent.weiyun.transmission.upload.transferlist;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.weiyun.transmission.db.JobDbWrapper;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.utils.IOUtils;

public class UploadTransferListHelper
{
  private static final String TAG = "UploadTransferListHelper";
  
  public static int deleteAllSuccessTask(String paramString)
  {
    JobDbWrapper localJobDbWrapper = JobDbManager.getInstance().openJobDb(true);
    if (localJobDbWrapper == null)
    {
      TsLog.e("UploadTransferListHelper", "deleteAllSuccessTask: Job db is null.");
      return 0;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("valid_flag", Integer.valueOf(0));
    int i = localJobDbWrapper.update("upload", localContentValues, "uid=? AND state = 5", new String[] { paramString });
    JobDbManager.getInstance().closeJobDb(localJobDbWrapper);
    return i;
  }
  
  public static String getLocalFilePath(String paramString1, String paramString2)
  {
    JobDbWrapper localJobDbWrapper = JobDbManager.getInstance().openJobDb(true);
    if (localJobDbWrapper == null) {
      TsLog.e("UploadTransferListHelper", "findLocalInfo: Job db is null.");
    }
    for (;;)
    {
      return null;
      Object localObject4 = null;
      Object localObject3 = null;
      localObject2 = localObject3;
      localObject1 = localObject4;
      try
      {
        String str = "file_id" + "=? " + " AND " + "cloud_sha" + "=? ";
        localObject2 = localObject3;
        localObject1 = localObject4;
        paramString1 = localJobDbWrapper.query("upload", new String[] { "local_path" }, str, new String[] { paramString1, paramString2 }, null, null, null);
        if (paramString1 != null)
        {
          localObject2 = paramString1;
          localObject1 = paramString1;
          if (paramString1.moveToNext())
          {
            localObject2 = paramString1;
            localObject1 = paramString1;
            paramString2 = paramString1.getString(0);
            IOUtils.closeSilently(paramString1);
            return paramString2;
          }
        }
        IOUtils.closeSilently(paramString1);
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          localObject1 = localObject2;
          TsLog.e("UploadTransferListHelper", paramString1);
          IOUtils.closeSilently((Cursor)localObject2);
        }
      }
      finally
      {
        IOUtils.closeSilently((Cursor)localObject1);
      }
      JobDbManager.getInstance().closeJobDb(localJobDbWrapper);
    }
  }
  
  public static UploadBean getTransferItemByFileId(String paramString)
  {
    JobDbWrapper localJobDbWrapper = JobDbManager.getInstance().openJobDb(true);
    localObject2 = null;
    Object localObject3 = null;
    if (localJobDbWrapper == null)
    {
      TsLog.e("UploadTransferListHelper", "findLocalInfo: Job db is null.");
      return null;
    }
    Object localObject4 = null;
    Cursor localCursor2 = null;
    localCursor1 = localCursor2;
    localObject1 = localObject4;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder().append("file_id").append("=? ");
      localCursor1 = localCursor2;
      localObject1 = localObject4;
      localCursor2 = localJobDbWrapper.query("upload", TransferQuery.PROJECTION, localStringBuilder.toString(), new String[] { paramString }, null, null, null);
      paramString = localObject3;
      if (localCursor2 != null)
      {
        paramString = localObject3;
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        if (localCursor2.moveToNext())
        {
          localCursor1 = localCursor2;
          localObject1 = localCursor2;
          paramString = readFromCursor(localCursor2);
        }
      }
      IOUtils.closeSilently(localCursor2);
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        localObject1 = localCursor1;
        TsLog.e("UploadTransferListHelper", paramString);
        IOUtils.closeSilently(localCursor1);
        paramString = localObject2;
      }
    }
    finally
    {
      IOUtils.closeSilently((Cursor)localObject1);
    }
    JobDbManager.getInstance().closeJobDb(localJobDbWrapper);
    return paramString;
  }
  
  /* Error */
  public static java.util.ArrayList<UploadBean> getTransferList(String paramString)
  {
    // Byte code:
    //   0: new 131	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 132	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: invokestatic 24	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   12: iconst_1
    //   13: invokevirtual 28	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   16: astore 6
    //   18: aload 6
    //   20: ifnonnull +13 -> 33
    //   23: ldc 11
    //   25: ldc 134
    //   27: invokestatic 36	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload 5
    //   32: areturn
    //   33: aconst_null
    //   34: astore 4
    //   36: aconst_null
    //   37: astore_3
    //   38: aload_3
    //   39: astore_2
    //   40: aload 4
    //   42: astore_1
    //   43: new 75	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   50: ldc 136
    //   52: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 138
    //   57: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 41
    //   62: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc 140
    //   67: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 142
    //   72: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 144
    //   77: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: astore 7
    //   82: aload_3
    //   83: astore_2
    //   84: aload 4
    //   86: astore_1
    //   87: aload 6
    //   89: ldc 53
    //   91: getstatic 123	com/tencent/weiyun/transmission/upload/transferlist/UploadTransferListHelper$TransferQuery:PROJECTION	[Ljava/lang/String;
    //   94: aload 7
    //   96: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: iconst_1
    //   100: anewarray 57	java/lang/String
    //   103: dup
    //   104: iconst_0
    //   105: aload_0
    //   106: aastore
    //   107: aconst_null
    //   108: aconst_null
    //   109: ldc 146
    //   111: invokevirtual 98	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +57 -> 173
    //   119: aload_0
    //   120: astore_2
    //   121: aload_0
    //   122: astore_1
    //   123: aload_0
    //   124: invokeinterface 104 1 0
    //   129: ifeq +44 -> 173
    //   132: aload_0
    //   133: astore_2
    //   134: aload_0
    //   135: astore_1
    //   136: aload 5
    //   138: aload_0
    //   139: invokestatic 127	com/tencent/weiyun/transmission/upload/transferlist/UploadTransferListHelper:readFromCursor	(Landroid/database/Cursor;)Lcom/tencent/weiyun/transmission/upload/transferlist/UploadBean;
    //   142: invokevirtual 150	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   145: pop
    //   146: goto -27 -> 119
    //   149: astore_0
    //   150: aload_2
    //   151: astore_1
    //   152: ldc 11
    //   154: aload_0
    //   155: invokestatic 117	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: aload_2
    //   159: invokestatic 114	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   162: invokestatic 24	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   165: aload 6
    //   167: invokevirtual 67	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   170: aload 5
    //   172: areturn
    //   173: aload_0
    //   174: invokestatic 114	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   177: goto -15 -> 162
    //   180: astore_0
    //   181: aload_1
    //   182: invokestatic 114	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   185: aload_0
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	paramString	String
    //   42	140	1	localObject1	Object
    //   39	120	2	localObject2	Object
    //   37	46	3	localObject3	Object
    //   34	51	4	localObject4	Object
    //   7	164	5	localArrayList	java.util.ArrayList
    //   16	150	6	localJobDbWrapper	JobDbWrapper
    //   80	15	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   43	82	149	java/lang/Throwable
    //   87	115	149	java/lang/Throwable
    //   123	132	149	java/lang/Throwable
    //   136	146	149	java/lang/Throwable
    //   43	82	180	finally
    //   87	115	180	finally
    //   123	132	180	finally
    //   136	146	180	finally
    //   152	158	180	finally
  }
  
  private static UploadBean readFromCursor(Cursor paramCursor)
  {
    UploadBean localUploadBean = new UploadBean();
    localUploadBean.id = paramCursor.getLong(0);
    localUploadBean.uid = paramCursor.getString(1);
    localUploadBean.localPath = paramCursor.getString(2);
    localUploadBean.localModified = paramCursor.getLong(3);
    localUploadBean.pDirKey = paramCursor.getString(4);
    localUploadBean.insertTime = paramCursor.getLong(5);
    localUploadBean.thumbUri = paramCursor.getString(6);
    localUploadBean.fileName = paramCursor.getString(7);
    localUploadBean.fileSize = paramCursor.getLong(8);
    localUploadBean.sha = paramCursor.getString(9);
    localUploadBean.longitude = paramCursor.getDouble(10);
    localUploadBean.latitude = paramCursor.getDouble(11);
    localUploadBean.takenTime = paramCursor.getLong(12);
    localUploadBean.width = paramCursor.getLong(13);
    localUploadBean.height = paramCursor.getLong(14);
    localUploadBean.duration = paramCursor.getLong(15);
    localUploadBean.batchId = paramCursor.getString(16);
    localUploadBean.batchTotal = paramCursor.getLong(17);
    localUploadBean.batchIndex = paramCursor.getLong(18);
    localUploadBean.batchDesc = paramCursor.getString(19);
    localUploadBean.state = paramCursor.getInt(20);
    localUploadBean.errorCode = paramCursor.getInt(21);
    localUploadBean.errorMsg = paramCursor.getString(22);
    localUploadBean.totalSize = paramCursor.getLong(23);
    localUploadBean.curSize = paramCursor.getLong(24);
    localUploadBean.fileId = paramCursor.getString(25);
    localUploadBean.fileVersion = paramCursor.getString(26);
    localUploadBean.cloudDirName = paramCursor.getString(27);
    localUploadBean.compressFlag = paramCursor.getInt(28);
    localUploadBean.groupUid = paramCursor.getString(29);
    localUploadBean.groupRootDirKey = paramCursor.getString(30);
    return localUploadBean;
  }
  
  private static abstract interface TransferQuery
  {
    public static final int BATCH_DESC = 19;
    public static final int BATCH_ID = 16;
    public static final int BATCH_INDEX = 18;
    public static final int BATCH_TOTAL = 17;
    public static final int COMPRESS_FLAG = 28;
    public static final int CUR_SIZE = 24;
    public static final int DIR_NAME = 27;
    public static final int DURATION = 15;
    public static final int ERROR_CODE = 21;
    public static final int ERROR_MSG = 22;
    public static final int FILE_ID = 25;
    public static final int FILE_NAME = 7;
    public static final int FILE_SIZE = 8;
    public static final int FILE_VERSION = 26;
    public static final int GROUP_ROOT_DIR_KEY = 30;
    public static final int GROUP_UIN = 29;
    public static final int HEIGHT = 14;
    public static final int ID = 0;
    public static final int INSERT_TIME = 5;
    public static final int LATITUDE = 11;
    public static final int LOCAL_MODIFIED = 3;
    public static final int LOCAL_PATH = 2;
    public static final int LOCAL_SHA = 9;
    public static final int LONGITUDE = 10;
    public static final String[] PROJECTION = { "_id", "uid", "local_path", "local_modified", "p_dir_key", "insert_time", "thumb_uri", "file_name", "file_size", "local_sha", "longitude", "latitude", "taken_time", "width", "height", "duration", "batch_id", "batch_total", "batch_index", "batch_desc", "state", "error_code", "error_msg", "total_size", "cur_size", "file_id", "file_version", "p_dir_name", "compress_flag", "p_dir_uid", "group_root_dir_key" };
    public static final int P_DIR_KEY = 4;
    public static final int STATE = 20;
    public static final int TAKEN_TIME = 12;
    public static final int THUMB_URI = 6;
    public static final int TOTAL_SIZE = 23;
    public static final int UID = 1;
    public static final int WIDTH = 13;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.transferlist.UploadTransferListHelper
 * JD-Core Version:    0.7.0.1
 */