package com.tencent.mobileqq.weiyun.sdk.download.transferlist;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.weiyun.transmission.db.JobDbWrapper;

public class DownloadTransferListHelper
{
  public static int a(String paramString)
  {
    JobDbWrapper localJobDbWrapper = JobDbManager.getInstance().openJobDb(true);
    if (localJobDbWrapper == null) {
      return 0;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("valid_flag", Integer.valueOf(0));
    int i = localJobDbWrapper.update("download", localContentValues, "uid=? AND state = 4", new String[] { paramString });
    JobDbManager.getInstance().closeJobDb(localJobDbWrapper);
    return i;
  }
  
  private static DownloadBean a(Cursor paramCursor)
  {
    DownloadBean localDownloadBean = new DownloadBean();
    localDownloadBean.jdField_a_of_type_Long = paramCursor.getLong(0);
    localDownloadBean.jdField_a_of_type_JavaLangString = paramCursor.getString(1);
    localDownloadBean.jdField_b_of_type_JavaLangString = paramCursor.getString(2);
    localDownloadBean.jdField_c_of_type_JavaLangString = paramCursor.getString(3);
    localDownloadBean.jdField_d_of_type_JavaLangString = paramCursor.getString(4);
    localDownloadBean.jdField_e_of_type_JavaLangString = paramCursor.getString(5);
    localDownloadBean.jdField_b_of_type_Long = paramCursor.getLong(6);
    localDownloadBean.f = paramCursor.getString(7);
    localDownloadBean.jdField_c_of_type_Long = paramCursor.getLong(8);
    localDownloadBean.g = paramCursor.getString(9);
    localDownloadBean.jdField_a_of_type_Int = paramCursor.getInt(10);
    localDownloadBean.jdField_b_of_type_Int = paramCursor.getInt(11);
    localDownloadBean.h = paramCursor.getString(12);
    localDownloadBean.jdField_d_of_type_Long = paramCursor.getLong(13);
    localDownloadBean.jdField_e_of_type_Long = paramCursor.getLong(14);
    localDownloadBean.i = paramCursor.getString(15);
    localDownloadBean.j = paramCursor.getString(16);
    localDownloadBean.k = paramCursor.getString(17);
    localDownloadBean.l = paramCursor.getString(18);
    return localDownloadBean;
  }
  
  /* Error */
  public static java.util.ArrayList<DownloadBean> a(String paramString)
  {
    // Byte code:
    //   0: new 127	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 128	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: invokestatic 17	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   12: iconst_1
    //   13: invokevirtual 21	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   16: astore 6
    //   18: aload 6
    //   20: ifnonnull +6 -> 26
    //   23: aload 5
    //   25: areturn
    //   26: aconst_null
    //   27: astore 4
    //   29: aconst_null
    //   30: astore_3
    //   31: aload_3
    //   32: astore_2
    //   33: aload 4
    //   35: astore_1
    //   36: new 130	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   43: astore 7
    //   45: aload_3
    //   46: astore_2
    //   47: aload 4
    //   49: astore_1
    //   50: aload 7
    //   52: ldc 133
    //   54: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_3
    //   59: astore_2
    //   60: aload 4
    //   62: astore_1
    //   63: aload 7
    //   65: ldc 139
    //   67: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_3
    //   72: astore_2
    //   73: aload 4
    //   75: astore_1
    //   76: aload 7
    //   78: ldc 26
    //   80: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_3
    //   85: astore_2
    //   86: aload 4
    //   88: astore_1
    //   89: aload 7
    //   91: ldc 141
    //   93: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_3
    //   98: astore_2
    //   99: aload 4
    //   101: astore_1
    //   102: aload 6
    //   104: ldc 38
    //   106: getstatic 146	com/tencent/mobileqq/weiyun/sdk/download/transferlist/DownloadTransferListHelper$TransferQuery:a	[Ljava/lang/String;
    //   109: aload 7
    //   111: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: iconst_1
    //   115: anewarray 42	java/lang/String
    //   118: dup
    //   119: iconst_0
    //   120: aload_0
    //   121: aastore
    //   122: aconst_null
    //   123: aconst_null
    //   124: ldc 152
    //   126: invokevirtual 156	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   129: astore_0
    //   130: aload_0
    //   131: astore_3
    //   132: aload_0
    //   133: ifnull +42 -> 175
    //   136: aload_0
    //   137: astore_2
    //   138: aload_0
    //   139: astore_3
    //   140: aload_0
    //   141: astore_1
    //   142: aload_0
    //   143: invokeinterface 160 1 0
    //   148: ifeq +27 -> 175
    //   151: aload_0
    //   152: astore_2
    //   153: aload_0
    //   154: astore_1
    //   155: aload 5
    //   157: aload_0
    //   158: invokestatic 162	com/tencent/mobileqq/weiyun/sdk/download/transferlist/DownloadTransferListHelper:a	(Landroid/database/Cursor;)Lcom/tencent/mobileqq/weiyun/sdk/download/transferlist/DownloadBean;
    //   161: invokevirtual 166	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   164: pop
    //   165: goto -29 -> 136
    //   168: astore_0
    //   169: aload_2
    //   170: invokestatic 172	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   173: aload_0
    //   174: athrow
    //   175: aload_3
    //   176: invokestatic 172	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   179: invokestatic 17	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   182: aload 6
    //   184: invokevirtual 52	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   187: aload 5
    //   189: areturn
    //   190: astore_0
    //   191: aload_1
    //   192: astore_3
    //   193: goto -18 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	paramString	String
    //   35	157	1	localObject1	Object
    //   32	138	2	localObject2	Object
    //   30	163	3	localObject3	Object
    //   27	73	4	localObject4	Object
    //   7	181	5	localArrayList	java.util.ArrayList
    //   16	167	6	localJobDbWrapper	JobDbWrapper
    //   43	67	7	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   36	45	168	finally
    //   50	58	168	finally
    //   63	71	168	finally
    //   76	84	168	finally
    //   89	97	168	finally
    //   102	130	168	finally
    //   142	151	168	finally
    //   155	165	168	finally
    //   36	45	190	java/lang/Throwable
    //   50	58	190	java/lang/Throwable
    //   63	71	190	java/lang/Throwable
    //   76	84	190	java/lang/Throwable
    //   89	97	190	java/lang/Throwable
    //   102	130	190	java/lang/Throwable
    //   142	151	190	java/lang/Throwable
    //   155	165	190	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.transferlist.DownloadTransferListHelper
 * JD-Core Version:    0.7.0.1
 */