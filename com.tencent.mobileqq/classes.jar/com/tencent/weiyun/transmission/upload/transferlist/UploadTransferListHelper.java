package com.tencent.weiyun.transmission.upload.transferlist;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.weiyun.transmission.db.JobDbWrapper;
import com.tencent.weiyun.transmission.utils.TsLog;

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
  
  /* Error */
  public static String getLocalFilePath(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 21	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   3: iconst_1
    //   4: invokevirtual 25	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_3
    //   11: ifnonnull +12 -> 23
    //   14: ldc 8
    //   16: ldc 70
    //   18: invokestatic 33	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aconst_null
    //   22: areturn
    //   23: new 72	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   30: astore 4
    //   32: aload 4
    //   34: ldc 75
    //   36: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 4
    //   42: ldc 81
    //   44: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 4
    //   50: ldc 83
    //   52: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 4
    //   58: ldc 85
    //   60: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 4
    //   66: ldc 81
    //   68: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 4
    //   74: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore 4
    //   79: aload_3
    //   80: ldc 50
    //   82: iconst_1
    //   83: anewarray 54	java/lang/String
    //   86: dup
    //   87: iconst_0
    //   88: ldc 91
    //   90: aastore
    //   91: aload 4
    //   93: iconst_2
    //   94: anewarray 54	java/lang/String
    //   97: dup
    //   98: iconst_0
    //   99: aload_0
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: aload_1
    //   104: aastore
    //   105: aconst_null
    //   106: aconst_null
    //   107: aconst_null
    //   108: invokevirtual 95	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   111: astore_0
    //   112: aload_0
    //   113: astore_2
    //   114: aload_0
    //   115: ifnull +55 -> 170
    //   118: aload_0
    //   119: astore_2
    //   120: aload_0
    //   121: astore_1
    //   122: aload_0
    //   123: invokeinterface 101 1 0
    //   128: ifeq +42 -> 170
    //   131: aload_0
    //   132: astore_1
    //   133: aload_0
    //   134: iconst_0
    //   135: invokeinterface 105 2 0
    //   140: astore_2
    //   141: aload_0
    //   142: invokestatic 111	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   145: aload_2
    //   146: areturn
    //   147: astore_2
    //   148: goto +12 -> 160
    //   151: astore_0
    //   152: aload_2
    //   153: astore_1
    //   154: goto +30 -> 184
    //   157: astore_2
    //   158: aconst_null
    //   159: astore_0
    //   160: aload_0
    //   161: astore_1
    //   162: ldc 8
    //   164: aload_2
    //   165: invokestatic 114	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   168: aload_0
    //   169: astore_2
    //   170: aload_2
    //   171: invokestatic 111	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   174: invokestatic 21	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   177: aload_3
    //   178: invokevirtual 64	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   181: aconst_null
    //   182: areturn
    //   183: astore_0
    //   184: aload_1
    //   185: invokestatic 111	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   188: aload_0
    //   189: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramString1	String
    //   0	190	1	paramString2	String
    //   9	137	2	str1	String
    //   147	6	2	localThrowable1	java.lang.Throwable
    //   157	8	2	localThrowable2	java.lang.Throwable
    //   169	2	2	str2	String
    //   7	171	3	localJobDbWrapper	JobDbWrapper
    //   30	62	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   122	131	147	java/lang/Throwable
    //   133	141	147	java/lang/Throwable
    //   23	112	151	finally
    //   23	112	157	java/lang/Throwable
    //   122	131	183	finally
    //   133	141	183	finally
    //   162	168	183	finally
  }
  
  /* Error */
  public static UploadBean getTransferItemByFileId(String paramString)
  {
    // Byte code:
    //   0: invokestatic 21	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   3: iconst_1
    //   4: invokevirtual 25	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_1
    //   11: aconst_null
    //   12: astore 4
    //   14: aload 5
    //   16: ifnonnull +12 -> 28
    //   19: ldc 8
    //   21: ldc 70
    //   23: invokestatic 33	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aconst_null
    //   27: areturn
    //   28: new 72	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   35: astore_2
    //   36: aload_2
    //   37: ldc 75
    //   39: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_2
    //   44: ldc 81
    //   46: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 5
    //   52: ldc 50
    //   54: getstatic 122	com/tencent/weiyun/transmission/upload/transferlist/UploadTransferListHelper$TransferQuery:PROJECTION	[Ljava/lang/String;
    //   57: aload_2
    //   58: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: iconst_1
    //   62: anewarray 54	java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: aload_0
    //   68: aastore
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: invokevirtual 95	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore_0
    //   76: aload 4
    //   78: astore_2
    //   79: aload_0
    //   80: astore_3
    //   81: aload_0
    //   82: ifnull +55 -> 137
    //   85: aload 4
    //   87: astore_2
    //   88: aload_0
    //   89: astore_3
    //   90: aload_0
    //   91: astore_1
    //   92: aload_0
    //   93: invokeinterface 101 1 0
    //   98: ifeq +39 -> 137
    //   101: aload_0
    //   102: astore_1
    //   103: aload_0
    //   104: invokestatic 126	com/tencent/weiyun/transmission/upload/transferlist/UploadTransferListHelper:readFromCursor	(Landroid/database/Cursor;)Lcom/tencent/weiyun/transmission/upload/transferlist/UploadBean;
    //   107: astore_2
    //   108: aload_0
    //   109: astore_3
    //   110: goto +27 -> 137
    //   113: astore_2
    //   114: goto +10 -> 124
    //   117: astore_0
    //   118: goto +34 -> 152
    //   121: astore_2
    //   122: aconst_null
    //   123: astore_0
    //   124: aload_0
    //   125: astore_1
    //   126: ldc 8
    //   128: aload_2
    //   129: invokestatic 114	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: aload_0
    //   133: astore_3
    //   134: aload 4
    //   136: astore_2
    //   137: aload_3
    //   138: invokestatic 111	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   141: invokestatic 21	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   144: aload 5
    //   146: invokevirtual 64	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   149: aload_2
    //   150: areturn
    //   151: astore_0
    //   152: aload_1
    //   153: invokestatic 111	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   156: aload_0
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramString	String
    //   10	143	1	str1	String
    //   35	73	2	localObject1	Object
    //   113	1	2	localThrowable1	java.lang.Throwable
    //   121	8	2	localThrowable2	java.lang.Throwable
    //   136	14	2	localObject2	Object
    //   80	58	3	str2	String
    //   12	123	4	localObject3	Object
    //   7	138	5	localJobDbWrapper	JobDbWrapper
    // Exception table:
    //   from	to	target	type
    //   92	101	113	java/lang/Throwable
    //   103	108	113	java/lang/Throwable
    //   28	76	117	finally
    //   28	76	121	java/lang/Throwable
    //   92	101	151	finally
    //   103	108	151	finally
    //   126	132	151	finally
  }
  
  /* Error */
  public static java.util.ArrayList<UploadBean> getTransferList(String paramString)
  {
    // Byte code:
    //   0: new 130	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 131	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: invokestatic 21	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   12: iconst_1
    //   13: invokevirtual 25	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   16: astore 6
    //   18: aload 6
    //   20: ifnonnull +13 -> 33
    //   23: ldc 8
    //   25: ldc 133
    //   27: invokestatic 33	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   43: new 72	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   50: astore 7
    //   52: aload_3
    //   53: astore_2
    //   54: aload 4
    //   56: astore_1
    //   57: aload 7
    //   59: ldc 135
    //   61: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_3
    //   66: astore_2
    //   67: aload 4
    //   69: astore_1
    //   70: aload 7
    //   72: ldc 137
    //   74: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_3
    //   79: astore_2
    //   80: aload 4
    //   82: astore_1
    //   83: aload 7
    //   85: ldc 38
    //   87: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_3
    //   92: astore_2
    //   93: aload 4
    //   95: astore_1
    //   96: aload 7
    //   98: ldc 139
    //   100: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_3
    //   105: astore_2
    //   106: aload 4
    //   108: astore_1
    //   109: aload 7
    //   111: ldc 141
    //   113: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload_3
    //   118: astore_2
    //   119: aload 4
    //   121: astore_1
    //   122: aload 7
    //   124: ldc 143
    //   126: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_3
    //   131: astore_2
    //   132: aload 4
    //   134: astore_1
    //   135: aload 6
    //   137: ldc 50
    //   139: getstatic 122	com/tencent/weiyun/transmission/upload/transferlist/UploadTransferListHelper$TransferQuery:PROJECTION	[Ljava/lang/String;
    //   142: aload 7
    //   144: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: iconst_1
    //   148: anewarray 54	java/lang/String
    //   151: dup
    //   152: iconst_0
    //   153: aload_0
    //   154: aastore
    //   155: aconst_null
    //   156: aconst_null
    //   157: ldc 145
    //   159: invokevirtual 95	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   162: astore_0
    //   163: aload_0
    //   164: astore_3
    //   165: aload_0
    //   166: ifnull +50 -> 216
    //   169: aload_0
    //   170: astore_2
    //   171: aload_0
    //   172: astore_1
    //   173: aload_0
    //   174: astore_3
    //   175: aload_0
    //   176: invokeinterface 101 1 0
    //   181: ifeq +35 -> 216
    //   184: aload_0
    //   185: astore_2
    //   186: aload_0
    //   187: astore_1
    //   188: aload 5
    //   190: aload_0
    //   191: invokestatic 126	com/tencent/weiyun/transmission/upload/transferlist/UploadTransferListHelper:readFromCursor	(Landroid/database/Cursor;)Lcom/tencent/weiyun/transmission/upload/transferlist/UploadBean;
    //   194: invokevirtual 149	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   197: pop
    //   198: goto -29 -> 169
    //   201: astore_0
    //   202: goto +29 -> 231
    //   205: astore_0
    //   206: aload_1
    //   207: astore_2
    //   208: ldc 8
    //   210: aload_0
    //   211: invokestatic 114	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   214: aload_1
    //   215: astore_3
    //   216: aload_3
    //   217: invokestatic 111	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   220: invokestatic 21	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   223: aload 6
    //   225: invokevirtual 64	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   228: aload 5
    //   230: areturn
    //   231: aload_2
    //   232: invokestatic 111	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   235: goto +5 -> 240
    //   238: aload_0
    //   239: athrow
    //   240: goto -2 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramString	String
    //   42	173	1	localObject1	Object
    //   39	193	2	localObject2	Object
    //   37	180	3	localObject3	Object
    //   34	99	4	localObject4	Object
    //   7	222	5	localArrayList	java.util.ArrayList
    //   16	208	6	localJobDbWrapper	JobDbWrapper
    //   50	93	7	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   43	52	201	finally
    //   57	65	201	finally
    //   70	78	201	finally
    //   83	91	201	finally
    //   96	104	201	finally
    //   109	117	201	finally
    //   122	130	201	finally
    //   135	163	201	finally
    //   175	184	201	finally
    //   188	198	201	finally
    //   208	214	201	finally
    //   43	52	205	java/lang/Throwable
    //   57	65	205	java/lang/Throwable
    //   70	78	205	java/lang/Throwable
    //   83	91	205	java/lang/Throwable
    //   96	104	205	java/lang/Throwable
    //   109	117	205	java/lang/Throwable
    //   122	130	205	java/lang/Throwable
    //   135	163	205	java/lang/Throwable
    //   175	184	205	java/lang/Throwable
    //   188	198	205	java/lang/Throwable
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.transferlist.UploadTransferListHelper
 * JD-Core Version:    0.7.0.1
 */