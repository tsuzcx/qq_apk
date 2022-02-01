package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DatalineMsgDbTransformer
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Map<String, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map<String, Boolean> b = new HashMap();
  
  public DatalineMsgDbTransformer(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private int a(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("dataline_msg_transform_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getInt("msg_transform_count_" + paramInt, 0);
    if (QLog.isColorLevel()) {
      QLog.i("DatalineMsgDbTransformer", 1, "getTransformCountIndex: type[" + paramInt + "] startIndex[" + i + "]");
    }
    return i;
  }
  
  private String a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    long l = b(paramInt1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from " + paramString + " ");
    if (l != -1L) {
      localStringBuilder.append("where time <= " + l + " ");
    }
    localStringBuilder.append("order by time desc ");
    localStringBuilder.append("limit " + paramInt2 + "," + paramInt3 + " ");
    return localStringBuilder.toString();
  }
  
  private List<DataLineMsgRecord> a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = a(paramInt3, paramInt1, paramInt2, DataLineMsgRecord.tableName(paramInt3));
    if (QLog.isColorLevel()) {
      QLog.i("DatalineMsgDbTransformer", 1, "loadMessageRecordFromDB: sql[" + (String)localObject2 + "]");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localObject2 = ((EntityManager)localObject1).rawQuery(DataLineMsgRecord.class, (String)localObject2, null);
    ((EntityManager)localObject1).close();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    return localObject1;
  }
  
  private void a(int paramInt1, int paramInt2, List<DataLineMsgRecord> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("dataline_msg_transform_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).edit();
    if (paramInt2 == 0)
    {
      long l = ((DataLineMsgRecord)paramList.get(0)).getId();
      localEditor.putLong("msg_transform_begin_id_" + paramInt1, l);
      if (QLog.isColorLevel()) {
        QLog.i("DatalineMsgDbTransformer", 1, "saveLastTransformInfo:save beginIndex type[" + paramInt1 + "] beginIndex[" + l + "]");
      }
    }
    paramInt2 = paramList.size() + paramInt2;
    localEditor.putInt("msg_transform_count_" + paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i("DatalineMsgDbTransformer", 1, "saveLastTransformInfo:save count type[" + paramInt1 + "] count[" + paramInt2 + "]");
    }
    localEditor.apply();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      this.b.put("msg_transform_finish_" + paramInt, Boolean.valueOf(paramBoolean));
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("dataline_msg_transform_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).edit();
      localEditor.putBoolean("msg_transform_finish_" + paramInt, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.i("DatalineMsgDbTransformer", 1, "saveTransformFinishFlag:save finish flag type[" + paramInt + "] finish[" + paramBoolean + "]");
      }
      localEditor.apply();
      return;
    }
    finally {}
  }
  
  /* Error */
  private boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/tencent/mobileqq/filemanager/fileassistant/util/DatalineMsgDbTransformer:b	Ljava/util/Map;
    //   6: new 34	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   13: ldc 188
    //   15: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload_1
    //   19: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokeinterface 216 2 0
    //   30: ifeq +42 -> 72
    //   33: aload_0
    //   34: getfield 22	com/tencent/mobileqq/filemanager/fileassistant/util/DatalineMsgDbTransformer:b	Ljava/util/Map;
    //   37: new 34	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   44: ldc 188
    //   46: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_1
    //   50: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokeinterface 219 2 0
    //   61: checkcast 190	java/lang/Boolean
    //   64: invokevirtual 222	java/lang/Boolean:booleanValue	()Z
    //   67: istore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: iload_2
    //   71: ireturn
    //   72: aload_0
    //   73: getfield 24	com/tencent/mobileqq/filemanager/fileassistant/util/DatalineMsgDbTransformer:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   76: invokevirtual 32	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   79: new 34	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   86: ldc 37
    //   88: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: getfield 24	com/tencent/mobileqq/filemanager/fileassistant/util/DatalineMsgDbTransformer:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   95: invokevirtual 45	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   98: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: iconst_0
    //   105: invokevirtual 54	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   108: new 34	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   115: ldc 188
    //   117: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: iload_1
    //   121: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   124: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: iconst_0
    //   128: invokeinterface 226 3 0
    //   133: istore_3
    //   134: aload_0
    //   135: getfield 22	com/tencent/mobileqq/filemanager/fileassistant/util/DatalineMsgDbTransformer:b	Ljava/util/Map;
    //   138: new 34	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   145: ldc 188
    //   147: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload_1
    //   151: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: iload_3
    //   158: invokestatic 194	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   161: invokeinterface 200 3 0
    //   166: pop
    //   167: iload_3
    //   168: istore_2
    //   169: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq -104 -> 68
    //   175: ldc 73
    //   177: iconst_1
    //   178: new 34	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   185: ldc 228
    //   187: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload_1
    //   191: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: ldc 230
    //   196: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: iload_3
    //   200: invokevirtual 211	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   203: ldc 79
    //   205: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 83	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: iload_3
    //   215: istore_2
    //   216: goto -148 -> 68
    //   219: astore 4
    //   221: aload_0
    //   222: monitorexit
    //   223: aload 4
    //   225: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	DatalineMsgDbTransformer
    //   0	226	1	paramInt	int
    //   67	149	2	bool1	boolean
    //   133	82	3	bool2	boolean
    //   219	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	68	219	finally
    //   72	167	219	finally
    //   169	214	219	finally
  }
  
  private void b(int paramInt)
  {
    int i = a(paramInt);
    DatalineMsgHelper localDatalineMsgHelper = new DatalineMsgHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    List localList = a(i, 2, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("DatalineMsgDbTransformer", 1, "transformMessages: type[" + paramInt + "] startIndex[" + i + "] count[" + localList.size() + "]");
    }
    ArrayList localArrayList;
    label129:
    ChatMessage localChatMessage;
    int j;
    if (localList.size() > 0)
    {
      localArrayList = new ArrayList();
      DatalineMsgTransformer localDatalineMsgTransformer = new DatalineMsgTransformer(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      Iterator localIterator = localList.iterator();
      if (localIterator.hasNext())
      {
        localDatalineMsgTransformer.a((DataLineMsgRecord)localIterator.next());
        localChatMessage = localDatalineMsgTransformer.a();
        localChatMessage.isread = true;
        if (paramInt == 0) {
          j = 65793;
        }
      }
    }
    for (;;)
    {
      QFileAssistantUtils.a(localChatMessage, j);
      localArrayList.add(localChatMessage);
      break label129;
      if (paramInt == 1)
      {
        j = 68361;
        continue;
        localDatalineMsgHelper.a(localArrayList);
        a(paramInt, i, localList);
        if (localList.size() < 2)
        {
          j = 1;
          label234:
          if (j != 0) {
            break label261;
          }
          i += 2;
        }
        label261:
        for (;;)
        {
          if (j != 0)
          {
            a(paramInt, true);
            return;
            j = 0;
            break label234;
          }
          break;
        }
      }
      else
      {
        j = 65793;
      }
    }
  }
  
  public long a(int paramInt)
  {
    List localList = a(0, 1, paramInt);
    if (localList.size() > 0) {
      return ((DataLineMsgRecord)localList.get(0)).time;
    }
    return -1L;
  }
  
  public void a()
  {
    QLog.e("DatalineMsgDbTransformer", 1, "transform.");
    a(0);
    if (a(0)) {
      QLog.i("DatalineMsgDbTransformer", 1, "transform: handle dataline pc: finish.");
    }
    for (;;)
    {
      a(1);
      if (!a(1)) {
        break;
      }
      QLog.i("DatalineMsgDbTransformer", 1, "transform: handle dataline iPad: finish.");
      return;
      QLog.i("DatalineMsgDbTransformer", 1, "transform: handle dataline pc: start.");
      b(0);
    }
    QLog.i("DatalineMsgDbTransformer", 1, "transform: handle dataline iPad: start.");
    b(1);
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      long l;
      try
      {
        if (a(paramInt))
        {
          QLog.d("DatalineMsgDbTransformer", 2, "checkTransformBeginItemId: finish, do not check.");
          return;
        }
        l = b(paramInt);
        if (l != -1L) {
          break label106;
        }
        l = a(paramInt);
        QLog.d("DatalineMsgDbTransformer", 2, "checkTransformBeginItemId: query beginId[" + l + "]");
        if (l != -1L)
        {
          a(paramInt, l);
          continue;
        }
        a(paramInt, true);
      }
      finally {}
      continue;
      label106:
      QLog.d("DatalineMsgDbTransformer", 2, "checkTransformBeginItemId: save beginId[" + l + "]");
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramLong == 0L) {}
    for (;;)
    {
      return;
      try
      {
        this.jdField_a_of_type_JavaUtilMap.put("msg_transform_begin_id_" + paramInt, Long.valueOf(paramLong));
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("dataline_msg_transform_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).edit();
        localEditor.putLong("msg_transform_begin_id_" + paramInt, paramLong);
        if (QLog.isColorLevel()) {
          QLog.i("DatalineMsgDbTransformer", 1, "saveTransformBeginItemId: type[" + paramInt + "] beginItemId[" + paramLong + "]");
        }
        localEditor.apply();
      }
      finally {}
    }
  }
  
  /* Error */
  public long b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/tencent/mobileqq/filemanager/fileassistant/util/DatalineMsgDbTransformer:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: new 34	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   13: ldc 159
    //   15: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload_1
    //   19: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokeinterface 216 2 0
    //   30: ifeq +42 -> 72
    //   33: aload_0
    //   34: getfield 20	com/tencent/mobileqq/filemanager/fileassistant/util/DatalineMsgDbTransformer:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   37: new 34	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   44: ldc 159
    //   46: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_1
    //   50: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokeinterface 219 2 0
    //   61: checkcast 325	java/lang/Long
    //   64: invokevirtual 335	java/lang/Long:longValue	()J
    //   67: lstore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: lload_2
    //   71: lreturn
    //   72: aload_0
    //   73: getfield 24	com/tencent/mobileqq/filemanager/fileassistant/util/DatalineMsgDbTransformer:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   76: invokevirtual 32	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   79: new 34	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   86: ldc 37
    //   88: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: getfield 24	com/tencent/mobileqq/filemanager/fileassistant/util/DatalineMsgDbTransformer:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   95: invokevirtual 45	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   98: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: iconst_0
    //   105: invokevirtual 54	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   108: new 34	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   115: ldc 159
    //   117: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: iload_1
    //   121: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   124: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: ldc2_w 92
    //   130: invokeinterface 339 4 0
    //   135: lstore 4
    //   137: aload_0
    //   138: getfield 20	com/tencent/mobileqq/filemanager/fileassistant/util/DatalineMsgDbTransformer:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   141: new 34	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   148: ldc 159
    //   150: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: iload_1
    //   154: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   157: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: lload 4
    //   162: invokestatic 328	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   165: invokeinterface 200 3 0
    //   170: pop
    //   171: lload 4
    //   173: lstore_2
    //   174: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq -109 -> 68
    //   180: ldc 73
    //   182: iconst_1
    //   183: new 34	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   190: ldc_w 341
    //   193: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: iload_1
    //   197: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: ldc_w 332
    //   203: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: lload 4
    //   208: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   211: ldc 79
    //   213: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 83	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: lload 4
    //   224: lstore_2
    //   225: goto -157 -> 68
    //   228: astore 6
    //   230: aload_0
    //   231: monitorexit
    //   232: aload 6
    //   234: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	DatalineMsgDbTransformer
    //   0	235	1	paramInt	int
    //   67	158	2	l1	long
    //   135	88	4	l2	long
    //   228	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	68	228	finally
    //   72	171	228	finally
    //   174	222	228	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.DatalineMsgDbTransformer
 * JD-Core Version:    0.7.0.1
 */