package com.tencent.mobileqq.filemanager.data;

import android.content.ContentValues;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class FileManagerProxy
  extends BaseProxy
{
  private static Handler jdField_a_of_type_AndroidOsHandler = null;
  private final int jdField_a_of_type_Int = 2000;
  private long jdField_a_of_type_Long = 0L;
  List<FileManagerEntity> jdField_a_of_type_JavaUtilList = null;
  private Map<Long, FileManagerEntity> jdField_a_of_type_JavaUtilMap = null;
  private Set<String> jdField_a_of_type_JavaUtilSet = null;
  List<FileManagerEntity> jdField_b_of_type_JavaUtilList = null;
  private Map<String, FileManagerEntity> jdField_b_of_type_JavaUtilMap = new Hashtable();
  List<FileManagerProxy.DeletedOlSessionInfo> c = new ArrayList();
  private List<FileManagerEntity> d = null;
  private List<Integer> e = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12) });
  
  public FileManagerProxy(QQAppInterface paramQQAppInterface, BaseProxyManager paramBaseProxyManager)
  {
    super(paramQQAppInterface, paramBaseProxyManager);
  }
  
  private ContentValues a(Entity paramEntity)
  {
    ContentValues localContentValues = new ContentValues();
    List localList = TableBuilder.getValidField(paramEntity.getClass());
    int j = localList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject1 = (Field)localList.get(i);
        String str = ((Field)localObject1).getName();
        if (!((Field)localObject1).isAccessible()) {
          ((Field)localObject1).setAccessible(true);
        }
        try
        {
          localObject1 = ((Field)localObject1).get(paramEntity);
          if ((localObject1 instanceof Integer))
          {
            localContentValues.put(str, (Integer)localObject1);
            i += 1;
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            localIllegalArgumentException.printStackTrace();
            Object localObject2 = null;
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            localIllegalAccessException.printStackTrace();
            Object localObject3 = null;
            continue;
            if ((localObject3 instanceof Long)) {
              localContentValues.put(str, (Long)localObject3);
            } else if ((localObject3 instanceof String)) {
              localContentValues.put(str, (String)localObject3);
            } else if ((localObject3 instanceof byte[])) {
              localContentValues.put(str, (byte[])localObject3);
            } else if ((localObject3 instanceof Short)) {
              localContentValues.put(str, (Short)localObject3);
            } else if ((localObject3 instanceof Boolean)) {
              localContentValues.put(str, (Boolean)localObject3);
            } else if ((localObject3 instanceof Double)) {
              localContentValues.put(str, (Double)localObject3);
            } else if ((localObject3 instanceof Float)) {
              localContentValues.put(str, (Float)localObject3);
            } else if ((localObject3 instanceof Byte)) {
              localContentValues.put(str, (Byte)localObject3);
            }
          }
        }
      }
    }
    return localContentValues;
  }
  
  private boolean a(int paramInt)
  {
    for (;;)
    {
      boolean bool;
      FileManagerEntity localFileManagerEntity;
      try
      {
        if (this.d == null) {
          init();
        }
        int i = this.d.size();
        if (i == 0)
        {
          bool = false;
          return bool;
        }
        Object localObject1 = "select * from ( select * from " + FileManagerEntity.tableName() + " where srvTime <= " + String.valueOf(((FileManagerEntity)this.d.get(this.d.size() - 1)).srvTime) + " and  nSessionId != " + String.valueOf(((FileManagerEntity)this.d.get(this.d.size() - 1)).nSessionId) + "  order by srvTime desc limit " + paramInt + ") order by srvTime desc";
        localObject1 = this.app.getEntityManagerFactory().createEntityManager().rawQuery(FileManagerEntity.class, (String)localObject1, null);
        if (localObject1 == null)
        {
          bool = false;
          continue;
        }
        if (((List)localObject1).size() == 0)
        {
          bool = false;
          continue;
        }
        List localList = FileCategoryUtil.a(BaseApplicationImpl.getContext());
        Iterator localIterator1 = ((List)localObject1).iterator();
        if (!localIterator1.hasNext()) {
          break label416;
        }
        localFileManagerEntity = (FileManagerEntity)localIterator1.next();
        if ((localFileManagerEntity.nFileType == 5) && (localFileManagerEntity.getCloudType() == 3) && (!FileUtil.a(localFileManagerEntity.getFilePath())) && (localFileManagerEntity.strApkPackageName != null) && (localFileManagerEntity.strApkPackageName.length() > 0))
        {
          Iterator localIterator2 = localList.iterator();
          if (localIterator2.hasNext())
          {
            PackageInfo localPackageInfo = (PackageInfo)localIterator2.next();
            if (!localFileManagerEntity.strApkPackageName.equalsIgnoreCase(localPackageInfo.packageName)) {
              continue;
            }
            localFileManagerEntity.setFilePath(localPackageInfo.applicationInfo.publicSourceDir);
            continue;
          }
        }
        if (this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localFileManagerEntity.nSessionId)) != null) {
          break label386;
        }
      }
      finally {}
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(localFileManagerEntity.nSessionId), localFileManagerEntity);
      label386:
      this.d.add(this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localFileManagerEntity.nSessionId)));
      continue;
      label416:
      paramInt = localObject2.size();
      if (paramInt < 30) {
        bool = false;
      } else {
        bool = true;
      }
    }
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   6: putfield 50	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_Long	J
    //   9: aload_0
    //   10: getfield 36	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 36	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   27: invokeinterface 324 1 0
    //   32: istore_1
    //   33: iload_1
    //   34: ifeq -14 -> 20
    //   37: aload_0
    //   38: getfield 36	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   41: invokeinterface 328 1 0
    //   46: invokeinterface 331 1 0
    //   51: astore 4
    //   53: aload 4
    //   55: invokeinterface 256 1 0
    //   60: ifeq -40 -> 20
    //   63: aload 4
    //   65: invokeinterface 260 1 0
    //   70: checkcast 333	java/util/Map$Entry
    //   73: astore 5
    //   75: aload 5
    //   77: invokeinterface 336 1 0
    //   82: checkcast 192	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   85: astore 6
    //   87: aload 6
    //   89: getfield 339	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   92: iconst_2
    //   93: if_icmpeq -40 -> 53
    //   96: aload 6
    //   98: getfield 339	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   101: bipush 14
    //   103: if_icmpeq -50 -> 53
    //   106: aload 6
    //   108: getfield 339	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   111: bipush 15
    //   113: if_icmpeq -60 -> 53
    //   116: aload 6
    //   118: getfield 339	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   121: iconst_4
    //   122: if_icmpeq -69 -> 53
    //   125: aload 5
    //   127: invokeinterface 342 1 0
    //   132: checkcast 128	java/lang/Long
    //   135: invokevirtual 345	java/lang/Long:longValue	()J
    //   138: lstore_2
    //   139: aload 4
    //   141: invokeinterface 348 1 0
    //   146: invokestatic 353	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq -96 -> 53
    //   152: ldc_w 355
    //   155: iconst_2
    //   156: new 183	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   163: ldc_w 357
    //   166: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: lload_2
    //   170: invokevirtual 360	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   173: ldc_w 362
    //   176: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: goto -132 -> 53
    //   188: astore 4
    //   190: goto -170 -> 20
    //   193: astore 4
    //   195: aload_0
    //   196: monitorexit
    //   197: aload 4
    //   199: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	FileManagerProxy
    //   32	2	1	i	int
    //   138	32	2	l	long
    //   13	127	4	localObject1	Object
    //   188	1	4	localException	Exception
    //   193	5	4	localObject2	Object
    //   73	53	5	localEntry	Map.Entry
    //   85	32	6	localFileManagerEntity	FileManagerEntity
    // Exception table:
    //   from	to	target	type
    //   37	53	188	java/lang/Exception
    //   53	185	188	java/lang/Exception
    //   2	15	193	finally
    //   23	33	193	finally
    //   37	53	193	finally
    //   53	185	193	finally
  }
  
  public long a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (this.d == null) {
      init();
    }
    Object localObject1 = ((QQAppInterface)this.app).getMessageFacade().b(String.valueOf(paramLong3), paramInt);
    Object localObject2;
    int i;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("------->FileManager findUinSeqForCache :msgIsTroop:").append(paramInt).append(",peerUin:").append(FileManagerUtil.e(String.valueOf(paramLong3))).append(",list size:");
      if (localObject1 == null)
      {
        i = 0;
        QLog.i("FileManagerProxy<FileAssistant>", 2, i);
      }
    }
    else
    {
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label256;
      }
      localObject1 = ((List)localObject1).iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((((MessageRecord)localObject2).msgUid != 0L) && (((MessageRecord)localObject2).msgUid == paramLong4))
        {
          return ((MessageRecord)localObject2).uniseq;
          i = ((List)localObject1).size();
          break;
        }
        if ((Math.abs(((MessageRecord)localObject2).time - paramLong2) < 30L) && (((MessageRecord)localObject2).shmsgseq == paramLong1) && (((MessageRecord)localObject2).senderuin.equals(Long.valueOf(paramLong3))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FileManagerProxy<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
          }
          return ((MessageRecord)localObject2).uniseq;
        }
      }
    }
    label256:
    localObject1 = this.d.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
      if ((((FileManagerEntity)localObject2).peerType == paramInt) && (((FileManagerEntity)localObject2).msgSeq == paramLong1) && (((FileManagerEntity)localObject2).msgUid == paramLong4) && (((FileManagerEntity)localObject2).peerUin != null) && (((FileManagerEntity)localObject2).peerUin.equals(Long.valueOf(paramLong3)))) {
        return ((FileManagerEntity)localObject2).uniseq;
      }
    }
    return -1L;
  }
  
  /* Error */
  public FileManagerEntity a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 181	com/tencent/mobileqq/filemanager/data/FileManagerProxy:init	()V
    //   13: aload_0
    //   14: getfield 34	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   17: invokeinterface 251 1 0
    //   22: astore 6
    //   24: aload 6
    //   26: invokeinterface 256 1 0
    //   31: ifeq +32 -> 63
    //   34: aload 6
    //   36: invokeinterface 260 1 0
    //   41: checkcast 192	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   44: astore 5
    //   46: aload 5
    //   48: getfield 208	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   51: lstore_3
    //   52: lload_3
    //   53: lload_1
    //   54: lcmp
    //   55: ifne -31 -> 24
    //   58: aload_0
    //   59: monitorexit
    //   60: aload 5
    //   62: areturn
    //   63: aload_0
    //   64: getfield 40	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   67: ifnull +49 -> 116
    //   70: aload_0
    //   71: getfield 40	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   74: invokeinterface 251 1 0
    //   79: astore 6
    //   81: aload 6
    //   83: invokeinterface 256 1 0
    //   88: ifeq +28 -> 116
    //   91: aload 6
    //   93: invokeinterface 260 1 0
    //   98: checkcast 192	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   101: astore 5
    //   103: aload 5
    //   105: getfield 208	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   108: lload_1
    //   109: lcmp
    //   110: ifne -29 -> 81
    //   113: goto -55 -> 58
    //   116: aload_0
    //   117: getfield 36	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   120: lload_1
    //   121: invokestatic 305	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   124: invokeinterface 308 2 0
    //   129: checkcast 192	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   132: astore 5
    //   134: goto -76 -> 58
    //   137: astore 5
    //   139: aload_0
    //   140: monitorexit
    //   141: aload 5
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	FileManagerProxy
    //   0	144	1	paramLong	long
    //   51	2	3	l	long
    //   44	89	5	localFileManagerEntity	FileManagerEntity
    //   137	5	5	localObject	Object
    //   22	70	6	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	137	finally
    //   13	24	137	finally
    //   24	52	137	finally
    //   63	81	137	finally
    //   81	113	137	finally
    //   116	134	137	finally
  }
  
  /* Error */
  public FileManagerEntity a(long paramLong, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: invokestatic 442	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +9 -> 19
    //   13: aconst_null
    //   14: astore_3
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_3
    //   18: areturn
    //   19: aload_0
    //   20: getfield 34	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   23: ifnonnull +7 -> 30
    //   26: aload_0
    //   27: invokevirtual 181	com/tencent/mobileqq/filemanager/data/FileManagerProxy:init	()V
    //   30: aload_0
    //   31: getfield 34	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   34: invokeinterface 251 1 0
    //   39: astore 6
    //   41: aload 6
    //   43: invokeinterface 256 1 0
    //   48: ifeq +63 -> 111
    //   51: aload 6
    //   53: invokeinterface 260 1 0
    //   58: checkcast 192	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   61: astore 5
    //   63: aload 5
    //   65: getfield 424	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerType	I
    //   68: iconst_1
    //   69: if_icmpne -28 -> 41
    //   72: aload 5
    //   74: getfield 445	com/tencent/mobileqq/filemanager/data/FileManagerEntity:TroopUin	J
    //   77: lload_1
    //   78: lcmp
    //   79: ifne -38 -> 41
    //   82: aload 5
    //   84: getfield 448	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strTroopFileID	Ljava/lang/String;
    //   87: invokestatic 442	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifne -49 -> 41
    //   93: aload_3
    //   94: aload 5
    //   96: getfield 448	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strTroopFileID	Ljava/lang/String;
    //   99: invokevirtual 419	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifeq -61 -> 41
    //   105: aload 5
    //   107: astore_3
    //   108: goto -93 -> 15
    //   111: aload_0
    //   112: getfield 36	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   115: invokeinterface 452 1 0
    //   120: invokeinterface 455 1 0
    //   125: astore 6
    //   127: aload 6
    //   129: invokeinterface 256 1 0
    //   134: ifeq +67 -> 201
    //   137: aload 6
    //   139: invokeinterface 260 1 0
    //   144: checkcast 192	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   147: astore 5
    //   149: aload 5
    //   151: getfield 424	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerType	I
    //   154: iconst_1
    //   155: if_icmpne -28 -> 127
    //   158: aload 5
    //   160: getfield 445	com/tencent/mobileqq/filemanager/data/FileManagerEntity:TroopUin	J
    //   163: lload_1
    //   164: lcmp
    //   165: ifne -38 -> 127
    //   168: aload 5
    //   170: getfield 448	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strTroopFileID	Ljava/lang/String;
    //   173: invokestatic 442	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne -49 -> 127
    //   179: aload_3
    //   180: aload 5
    //   182: getfield 448	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strTroopFileID	Ljava/lang/String;
    //   185: invokevirtual 419	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   188: istore 4
    //   190: iload 4
    //   192: ifeq -65 -> 127
    //   195: aload 5
    //   197: astore_3
    //   198: goto -183 -> 15
    //   201: aconst_null
    //   202: astore_3
    //   203: goto -188 -> 15
    //   206: astore_3
    //   207: aload_0
    //   208: monitorexit
    //   209: aload_3
    //   210: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	FileManagerProxy
    //   0	211	1	paramLong	long
    //   0	211	3	paramString	String
    //   6	185	4	bool	boolean
    //   61	135	5	localFileManagerEntity	FileManagerEntity
    //   39	99	6	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	8	206	finally
    //   19	30	206	finally
    //   30	41	206	finally
    //   41	105	206	finally
    //   111	127	206	finally
    //   127	190	206	finally
  }
  
  public FileManagerEntity a(long paramLong, String paramString, int paramInt)
  {
    if ((paramLong != -1L) && (paramString != null)) {}
    for (;;)
    {
      FileManagerEntity localFileManagerEntity;
      try
      {
        int i = paramString.length();
        if (i == 0)
        {
          paramString = null;
          return paramString;
        }
        if (this.d == null) {
          init();
        }
        localIterator = this.d.iterator();
        if (localIterator.hasNext())
        {
          localFileManagerEntity = (FileManagerEntity)localIterator.next();
          if ((localFileManagerEntity.peerUin == null) || (localFileManagerEntity.uniseq != paramLong) || (!localFileManagerEntity.peerUin.equals(paramString))) {
            continue;
          }
          paramString = localFileManagerEntity;
          if (localFileManagerEntity.cloudType != 1) {
            continue;
          }
          paramString = localFileManagerEntity;
          if (!FileManagerUtil.b(localFileManagerEntity)) {
            continue;
          }
          localFileManagerEntity.status = 16;
          paramString = localFileManagerEntity;
          continue;
        }
        if (this.jdField_a_of_type_JavaUtilMap == null) {
          break label275;
        }
      }
      finally {}
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localFileManagerEntity = (FileManagerEntity)((Map.Entry)localIterator.next()).getValue();
          if ((localFileManagerEntity.uniseq == paramLong) && (localFileManagerEntity.peerUin != null) && (localFileManagerEntity.peerUin.equals(paramString)) && (paramInt == localFileManagerEntity.peerType))
          {
            paramString = localFileManagerEntity;
            if (localFileManagerEntity.cloudType != 1) {
              break;
            }
            paramString = localFileManagerEntity;
            if (!FileManagerUtil.b(localFileManagerEntity)) {
              break;
            }
            localFileManagerEntity.status = 16;
            paramString = localFileManagerEntity;
            break;
          }
        }
      }
      label275:
      paramString = null;
    }
  }
  
  public FileManagerEntity a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (this.d == null) {
          init();
        }
        Object localObject = "select * from " + FileManagerEntity.tableName() + " where Uuid = ?";
        EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        if (localEntityManager == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("FileManagerProxy<FileAssistant>", 2, "get EntityManager null!");
          }
          paramString = null;
          return paramString;
        }
        long l1 = System.currentTimeMillis();
        paramString = localEntityManager.rawQuery(FileManagerEntity.class, (String)localObject, new String[] { SecurityUtile.encode(paramString) });
        long l2 = System.currentTimeMillis();
        if (paramString == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FileManagerProxy<FileAssistant>", 2, "queryOver, but no data!");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("FileManagerProxy<FileAssistant>", 2, "query over,startTime[" + String.valueOf(l1) + "], overTime[" + String.valueOf(l2) + "]");
          }
          if ((paramString.size() > 1) && (QLog.isColorLevel())) {
            QLog.w("FileManagerProxy", 2, "why size[" + String.valueOf(paramString.size()) + "] over 1?");
          }
          localObject = (FileManagerEntity)paramString.get(0);
          if (localObject == null)
          {
            paramString = null;
            continue;
          }
          this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(((FileManagerEntity)localObject).nSessionId), localObject);
          FileCategoryUtil.a((FileManagerEntity)localObject);
          paramString = (String)localObject;
          if (((FileManagerEntity)localObject).cloudType != 1) {
            continue;
          }
          paramString = (String)localObject;
          if (!FileManagerUtil.b((FileManagerEntity)localObject)) {
            continue;
          }
          ((FileManagerEntity)localObject).status = 16;
          paramString = (String)localObject;
          continue;
        }
        paramString = null;
      }
      finally {}
    }
  }
  
  public FileManagerEntity a(String paramString, long paramLong)
  {
    for (;;)
    {
      Iterator localIterator;
      FileManagerEntity localFileManagerEntity;
      try
      {
        if (this.d == null) {
          init();
        }
        if ((paramString == null) || (paramLong <= 0L))
        {
          localObject = null;
          return localObject;
        }
        localIterator = this.d.iterator();
        if (localIterator.hasNext())
        {
          localFileManagerEntity = (FileManagerEntity)localIterator.next();
          if (localFileManagerEntity.nOLfileSessionId == paramLong)
          {
            localObject = localFileManagerEntity;
            if (paramString.equalsIgnoreCase(localFileManagerEntity.peerUin)) {
              continue;
            }
          }
          if ((0L != localFileManagerEntity.nOLfileSessionId) || (paramLong != localFileManagerEntity.nSessionId) || (!paramString.equalsIgnoreCase(localFileManagerEntity.peerUin))) {
            continue;
          }
          localFileManagerEntity.nOLfileSessionId = paramLong;
          d(localFileManagerEntity);
          localObject = localFileManagerEntity;
          continue;
        }
        localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      }
      finally {}
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localFileManagerEntity = (FileManagerEntity)localIterator.next();
          if (localFileManagerEntity.nOLfileSessionId == paramLong)
          {
            localObject = localFileManagerEntity;
            if (paramString.equalsIgnoreCase(localFileManagerEntity.peerUin)) {
              break;
            }
          }
          if ((0L == localFileManagerEntity.nOLfileSessionId) && (paramLong == localFileManagerEntity.nSessionId) && (paramString.equalsIgnoreCase(localFileManagerEntity.peerUin)))
          {
            localFileManagerEntity.nOLfileSessionId = paramLong;
            d(localFileManagerEntity);
            localObject = localFileManagerEntity;
            break;
          }
        }
      }
      Object localObject = null;
    }
  }
  
  public List<FileManagerEntity> a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList = a(200);
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      List localList = this.jdField_a_of_type_JavaUtilList;
      return localList;
    }
    finally {}
  }
  
  public List<FileManagerEntity> a(int paramInt)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    for (;;)
    {
      long l1;
      try
      {
        if ((this.d == null) || (this.d.isEmpty())) {
          init();
        }
        Object localObject1 = "select * from ( select * from " + FileManagerEntity.tableName() + " order by srvTime desc limit " + paramInt + ") order by srvTime desc";
        localObject3 = this.app.getEntityManagerFactory().createEntityManager();
        l1 = System.currentTimeMillis();
        try
        {
          localObject1 = ((EntityManager)localObject3).rawQuery(FileManagerEntity.class, (String)localObject1, null);
          if (QLog.isDevelopLevel())
          {
            if (localObject1 != null) {
              continue;
            }
            QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[null]");
          }
          localObject3 = localFileManagerEntity1;
          if (localObject1 != null)
          {
            paramInt = ((List)localObject1).size();
            if (paramInt != 0) {
              break label238;
            }
            localObject3 = localFileManagerEntity1;
          }
          return localObject3;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (!QLog.isColorLevel()) {
            break label496;
          }
        }
        QLog.e("FileManagerProxy<FileAssistant>", 2, "load " + paramInt + " data,is oom!");
      }
      finally {}
      QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[" + localOutOfMemoryError.size() + "]");
      continue;
      label238:
      Object localObject3 = new ArrayList();
      Iterator localIterator1 = localObject2.iterator();
      label256:
      label494:
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          localFileManagerEntity1 = (FileManagerEntity)localIterator1.next();
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(localFileManagerEntity1.nSessionId)) == true)
          {
            localFileManagerEntity1 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localFileManagerEntity1.nSessionId));
            FileManagerUtil.a(localFileManagerEntity1);
            ((List)localObject3).add(localFileManagerEntity1);
          }
          else
          {
            Iterator localIterator2 = this.d.iterator();
            while (localIterator2.hasNext())
            {
              FileManagerEntity localFileManagerEntity2 = (FileManagerEntity)localIterator2.next();
              if (localFileManagerEntity2.nSessionId == localFileManagerEntity1.nSessionId)
              {
                FileManagerUtil.a(localFileManagerEntity2);
                ((List)localObject3).add(localFileManagerEntity2);
              }
            }
          }
        }
        else
        {
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt != 0) {
              break label494;
            }
            FileManagerUtil.a(localFileManagerEntity1);
            ((List)localObject3).add(localFileManagerEntity1);
            break label256;
            long l2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d("FileManagerProxy<FileAssistant>", 2, "QueryMoreEntity cost[" + (l2 - l1) + "], size[" + ((List)localObject3).size() + "]");
            }
            break;
          }
        }
      }
      label496:
      localIterator1 = null;
    }
  }
  
  public List<FileManagerEntity> a(int paramInt1, int paramInt2)
  {
    Object localObject5;
    long l1;
    for (;;)
    {
      try
      {
        if ((this.d == null) || (this.d.isEmpty())) {
          init();
        }
        Object localObject1 = "select * from ( select * from " + FileManagerEntity.tableName() + " order by srvTime desc limit " + paramInt1 * paramInt2 + "," + (paramInt2 + 1) * paramInt1 + ") order by srvTime desc";
        localObject5 = this.app.getEntityManagerFactory().createEntityManager();
        localArrayList = null;
        l1 = System.currentTimeMillis();
        try
        {
          localObject1 = ((EntityManager)localObject5).rawQuery(FileManagerEntity.class, (String)localObject1, null);
          if (QLog.isDevelopLevel())
          {
            if (localObject1 == null) {
              QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[null]");
            }
          }
          else
          {
            if (localObject1 != null)
            {
              paramInt1 = ((List)localObject1).size();
              if (paramInt1 != 0) {
                break;
              }
            }
            localObject1 = null;
            return localObject1;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Object localObject2 = localArrayList;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("FileManagerProxy<FileAssistant>", 2, "load " + paramInt1 + " data,is oom!");
          localObject2 = localArrayList;
          continue;
        }
        QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[" + localObject3.size() + "]");
      }
      finally {}
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = localObject3.iterator();
    label275:
    label534:
    for (;;)
    {
      if (((Iterator)localObject4).hasNext())
      {
        localObject5 = (FileManagerEntity)((Iterator)localObject4).next();
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(((FileManagerEntity)localObject5).nSessionId)) == true)
        {
          localObject5 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(((FileManagerEntity)localObject5).nSessionId));
          FileManagerUtil.a((FileManagerEntity)localObject5);
          localArrayList.add(localObject5);
        }
        else
        {
          Iterator localIterator = this.d.iterator();
          while (localIterator.hasNext())
          {
            FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
            if (localFileManagerEntity.nSessionId == ((FileManagerEntity)localObject5).nSessionId)
            {
              FileManagerUtil.a(localFileManagerEntity);
              localArrayList.add(localFileManagerEntity);
            }
          }
        }
      }
      else
      {
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            break label534;
          }
          FileManagerUtil.a((FileManagerEntity)localObject5);
          localArrayList.add(localObject5);
          break label275;
          long l2 = System.currentTimeMillis();
          if (QLog.isDevelopLevel()) {
            QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity cost[" + (l2 - l1) + "]");
          }
          QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity retList size" + localArrayList.size());
          localObject4 = localArrayList;
          break;
        }
      }
    }
  }
  
  /* Error */
  public List<FileManagerEntity> a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 44	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 46	java/util/ArrayList:<init>	()V
    //   9: astore 5
    //   11: aload_0
    //   12: getfield 40	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   15: ifnonnull +14 -> 29
    //   18: aload_0
    //   19: new 44	java/util/ArrayList
    //   22: dup
    //   23: invokespecial 46	java/util/ArrayList:<init>	()V
    //   26: putfield 40	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   29: aload_0
    //   30: getfield 40	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   33: invokeinterface 251 1 0
    //   38: astore 6
    //   40: aload 6
    //   42: invokeinterface 256 1 0
    //   47: ifeq +86 -> 133
    //   50: aload 6
    //   52: invokeinterface 260 1 0
    //   57: checkcast 192	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   60: astore 7
    //   62: aload 7
    //   64: ifnull +51 -> 115
    //   67: aload 7
    //   69: getfield 431	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   72: ifnull +43 -> 115
    //   75: aload 7
    //   77: getfield 431	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   80: aload_2
    //   81: invokevirtual 419	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq +31 -> 115
    //   87: aload 7
    //   89: invokevirtual 266	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getCloudType	()I
    //   92: iconst_2
    //   93: if_icmpne +12 -> 105
    //   96: aload 7
    //   98: getfield 547	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nOpType	I
    //   101: iconst_3
    //   102: if_icmpne +13 -> 115
    //   105: aload 5
    //   107: aload 7
    //   109: invokeinterface 315 2 0
    //   114: pop
    //   115: aload 5
    //   117: invokeinterface 97 1 0
    //   122: istore_3
    //   123: iload_3
    //   124: iload_1
    //   125: if_icmplt -85 -> 40
    //   128: aload_0
    //   129: monitorexit
    //   130: aload 5
    //   132: areturn
    //   133: iconst_0
    //   134: istore_3
    //   135: aload 5
    //   137: invokeinterface 97 1 0
    //   142: ifle +6 -> 148
    //   145: goto -17 -> 128
    //   148: aload_0
    //   149: sipush 200
    //   152: iload_3
    //   153: invokevirtual 549	com/tencent/mobileqq/filemanager/data/FileManagerProxy:a	(II)Ljava/util/List;
    //   156: astore 6
    //   158: aload 6
    //   160: ifnonnull +6 -> 166
    //   163: goto -35 -> 128
    //   166: aload 6
    //   168: invokeinterface 251 1 0
    //   173: astore 6
    //   175: aload 6
    //   177: invokeinterface 256 1 0
    //   182: ifeq +110 -> 292
    //   185: aload 6
    //   187: invokeinterface 260 1 0
    //   192: checkcast 192	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   195: astore 7
    //   197: aload 7
    //   199: ifnull +75 -> 274
    //   202: aload 7
    //   204: getfield 431	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   207: ifnull +67 -> 274
    //   210: aload 5
    //   212: aload 7
    //   214: invokeinterface 552 2 0
    //   219: ifne +55 -> 274
    //   222: aload 7
    //   224: getfield 431	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   227: aload_2
    //   228: invokevirtual 419	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifeq +43 -> 274
    //   234: aload 7
    //   236: invokevirtual 266	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getCloudType	()I
    //   239: iconst_2
    //   240: if_icmpne +12 -> 252
    //   243: aload 7
    //   245: getfield 547	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nOpType	I
    //   248: iconst_3
    //   249: if_icmpne +25 -> 274
    //   252: aload 5
    //   254: aload 7
    //   256: invokeinterface 315 2 0
    //   261: pop
    //   262: aload_0
    //   263: getfield 40	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   266: aload 7
    //   268: invokeinterface 315 2 0
    //   273: pop
    //   274: aload 5
    //   276: invokeinterface 97 1 0
    //   281: istore 4
    //   283: iload 4
    //   285: iload_1
    //   286: if_icmplt -111 -> 175
    //   289: goto -161 -> 128
    //   292: iload_3
    //   293: iconst_1
    //   294: iadd
    //   295: istore_3
    //   296: goto -161 -> 135
    //   299: astore_2
    //   300: aload_0
    //   301: monitorexit
    //   302: aload_2
    //   303: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	FileManagerProxy
    //   0	304	1	paramInt	int
    //   0	304	2	paramString	String
    //   122	174	3	i	int
    //   281	6	4	j	int
    //   9	266	5	localArrayList	ArrayList
    //   38	148	6	localObject	Object
    //   60	207	7	localFileManagerEntity	FileManagerEntity
    // Exception table:
    //   from	to	target	type
    //   2	29	299	finally
    //   29	40	299	finally
    //   40	62	299	finally
    //   67	105	299	finally
    //   105	115	299	finally
    //   115	123	299	finally
    //   135	145	299	finally
    //   148	158	299	finally
    //   166	175	299	finally
    //   175	197	299	finally
    //   202	252	299	finally
    //   252	274	299	finally
    //   274	283	299	finally
  }
  
  /* Error */
  public List<FileManagerEntity> a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   6: ifnull +33 -> 39
    //   9: aload_0
    //   10: getfield 42	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   13: invokeinterface 557 1 0
    //   18: aload_0
    //   19: aload_0
    //   20: sipush 200
    //   23: aload_1
    //   24: invokevirtual 559	com/tencent/mobileqq/filemanager/data/FileManagerProxy:a	(ILjava/lang/String;)Ljava/util/List;
    //   27: putfield 42	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   30: aload_0
    //   31: getfield 42	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: aload_0
    //   40: new 44	java/util/ArrayList
    //   43: dup
    //   44: invokespecial 46	java/util/ArrayList:<init>	()V
    //   47: putfield 42	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   50: goto -32 -> 18
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	FileManagerProxy
    //   0	58	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	18	53	finally
    //   18	35	53	finally
    //   39	50	53	finally
  }
  
  public List<FileManagerEntity> a(String paramString, long paramLong)
  {
    ArrayList localArrayList;
    Iterator localIterator;
    Object localObject;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerProxy<FileAssistant>", 1, "call thread:" + Thread.currentThread().getName());
      }
      if (this.d == null) {
        init();
      }
      localArrayList = new ArrayList();
      localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        localObject = (FileManagerEntity)localIterator.next();
        if ((((FileManagerEntity)localObject).fileSize == paramLong) && (((FileManagerEntity)localObject).fileName.equals(paramString)) && (((FileManagerEntity)localObject).status == 1) && (FileUtil.b(((FileManagerEntity)localObject).getFilePath()))) {
          localArrayList.add(localObject);
        }
      }
      localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    }
    finally {}
    while (localIterator.hasNext())
    {
      localObject = (Long)localIterator.next();
      localObject = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(localObject);
      if ((!localArrayList.contains(localObject)) && (((FileManagerEntity)localObject).fileSize == paramLong) && (((FileManagerEntity)localObject).fileName.equals(paramString)) && (((FileManagerEntity)localObject).status == 1) && (FileUtil.b(((FileManagerEntity)localObject).getFilePath()))) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public List<FileManagerEntity> a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      a();
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!TextUtils.isEmpty(localFileManagerEntity.fileName)) && (!TextUtils.isEmpty(localFileManagerEntity.peerUin)))
      {
        String str = localFileManagerEntity.fileName;
        if (localFileManagerEntity.peerUin.equals(paramString2)) {
          if (str.indexOf(paramString1) >= 0) {
            localArrayList.add(localFileManagerEntity);
          } else if (SearchUtils.b(paramString1, str, IContactSearchable.g) > -9223372036854775808L) {
            localArrayList.add(localFileManagerEntity);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public List<FileManagerEntity> a(List<Integer> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      a();
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!TextUtils.isEmpty(localFileManagerEntity.fileName)) && (!TextUtils.isEmpty(localFileManagerEntity.peerUin)))
      {
        int i = FileManagerUtil.a(localFileManagerEntity.fileName);
        if ((localFileManagerEntity.peerUin.equals(paramString)) && (paramList.contains(Integer.valueOf(i)))) {
          localArrayList.add(localFileManagerEntity);
        }
      }
    }
    return localArrayList;
  }
  
  public Map<String, List<FileManagerEntity>> a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      a();
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    FileManagerEntity localFileManagerEntity;
    while (localIterator.hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!TextUtils.isEmpty(localFileManagerEntity.fileName)) && (localFileManagerEntity.fileName.indexOf(paramString) >= 0))
      {
        if (!localLinkedHashMap.containsKey(localFileManagerEntity.fileName)) {
          localLinkedHashMap.put(localFileManagerEntity.fileName, new ArrayList());
        }
        ((List)localLinkedHashMap.get(localFileManagerEntity.fileName)).add(localFileManagerEntity);
      }
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!TextUtils.isEmpty(localFileManagerEntity.fileName))
      {
        String str = localFileManagerEntity.fileName;
        if (localLinkedHashMap.containsKey(localFileManagerEntity.fileName) != true) {
          if (SearchUtils.b(paramString, str, IContactSearchable.g) > -9223372036854775808L)
          {
            if (!localLinkedHashMap.containsKey(localFileManagerEntity.fileName)) {
              localLinkedHashMap.put(localFileManagerEntity.fileName, new ArrayList());
            }
            ((List)localLinkedHashMap.get(localFileManagerEntity.fileName)).add(localFileManagerEntity);
          }
          else
          {
            str = FileManagerUtil.b(localFileManagerEntity);
            if (TextUtils.isEmpty(str))
            {
              if (QLog.isDevelopLevel()) {
                throw new NullPointerException("get Full String error!!!");
              }
            }
            else if (SearchUtils.b(paramString, str.replace(HardCodeUtil.a(2131704552), "").replace(HardCodeUtil.a(2131704575), "").replace(HardCodeUtil.a(2131704570), "").replace(HardCodeUtil.a(2131704563), "").replace(HardCodeUtil.a(2131704553), "").replace(HardCodeUtil.a(2131704582), "").replace(HardCodeUtil.a(2131704568), "").replace(HardCodeUtil.a(2131704564), "").replace(HardCodeUtil.a(2131704561), "").trim(), IContactSearchable.g) > -9223372036854775808L)
            {
              if (!localLinkedHashMap.containsKey(localFileManagerEntity.fileName)) {
                localLinkedHashMap.put(localFileManagerEntity.fileName, new ArrayList());
              }
              ((List)localLinkedHashMap.get(localFileManagerEntity.fileName)).add(localFileManagerEntity);
            }
          }
        }
      }
    }
    return localLinkedHashMap;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 34	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   18: invokeinterface 97 1 0
    //   23: iconst_1
    //   24: isub
    //   25: istore_1
    //   26: iload_1
    //   27: bipush 30
    //   29: if_icmplt -18 -> 11
    //   32: aload_0
    //   33: getfield 34	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   36: iload_1
    //   37: invokeinterface 649 2 0
    //   42: pop
    //   43: iload_1
    //   44: iconst_1
    //   45: isub
    //   46: istore_1
    //   47: goto -21 -> 26
    //   50: astore_2
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	FileManagerProxy
    //   25	22	1	i	int
    //   6	2	2	localList	List
    //   50	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	50	finally
    //   14	26	50	finally
    //   32	43	50	finally
  }
  
  public void a(long paramLong)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (localIterator.hasNext()) {
          if (paramLong == ((FileManagerEntity)((Map.Entry)localIterator.next()).getValue()).nSessionId) {
            localIterator.remove();
          }
        }
      }
    }
    finally {}
  }
  
  public void a(long paramLong, String paramString)
  {
    if (jdField_a_of_type_AndroidOsHandler == null)
    {
      HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("FileManagerDBThread", 0);
      localHandlerThread.start();
      jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
    }
    jdField_a_of_type_AndroidOsHandler.post(new FileManagerProxy.4(this, paramLong, paramString));
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    if ((paramString == null) || (paramLong1 < 0L) || (paramLong2 <= 0L)) {}
    do
    {
      return;
      if (this.c.size() > 30) {
        this.c.remove(0);
      }
      FileManagerProxy.DeletedOlSessionInfo localDeletedOlSessionInfo = new FileManagerProxy.DeletedOlSessionInfo(this);
      localDeletedOlSessionInfo.jdField_a_of_type_Long = paramLong1;
      localDeletedOlSessionInfo.jdField_a_of_type_JavaLangString = paramString;
      localDeletedOlSessionInfo.b = paramLong2;
      this.c.add(localDeletedOlSessionInfo);
    } while (!QLog.isColorLevel());
    QLog.i("FileManagerProxy<FileAssistant>", 2, "saveDeletedEntity nSessionId=" + paramLong1 + " nOlSessionId=" + paramLong2);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      init();
      FileManagerUtil.a(paramFileManagerEntity);
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramFileManagerEntity.nSessionId));
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramFileManagerEntity.nSessionId), paramFileManagerEntity);
      return;
    }
    finally
    {
      paramFileManagerEntity = finally;
      throw paramFileManagerEntity;
    }
  }
  
  void a(FileManagerEntity paramFileManagerEntity, ProxyListener paramProxyListener)
  {
    for (;;)
    {
      try
      {
        paramProxyListener = this.app.getEntityManagerFactory().createEntityManager();
        if (paramProxyListener == null) {
          return;
        }
        paramProxyListener = new FileManagerEntity();
        if (paramFileManagerEntity.nFileType != 13) {
          paramFileManagerEntity.nFileType = FileManagerUtil.a(paramFileManagerEntity.fileName);
        }
        paramProxyListener.copyFrom(paramFileManagerEntity);
        paramProxyListener.nSessionId = paramFileManagerEntity.nSessionId;
        paramProxyListener.bSend = paramFileManagerEntity.bSend;
        paramProxyListener.bDelInAio = paramFileManagerEntity.bDelInAio;
        paramProxyListener.bDelInFM = paramFileManagerEntity.bDelInFM;
        if ((paramProxyListener.status != 1) && (paramProxyListener.status != -1) && (!paramProxyListener.bSend) && (paramProxyListener.status != 4)) {
          paramProxyListener.status = 0;
        }
        if ((paramProxyListener.status == 2) || (paramProxyListener.status == 18)) {
          paramProxyListener.status = 0;
        }
        if (paramFileManagerEntity.status == 16) {
          paramProxyListener.status = 16;
        }
        if (paramProxyListener.getStatus() == 1000)
        {
          this.proxyManager.addMsgQueue(String.valueOf(0), 0, paramProxyListener.getTableName(), paramProxyListener, 0, null);
          paramFileManagerEntity.setId(paramProxyListener.getId());
          paramFileManagerEntity.setStatus(paramProxyListener.getStatus());
          continue;
        }
        if (paramProxyListener.getStatus() != 1001) {
          break label243;
        }
      }
      finally {}
      this.proxyManager.addMsgQueue(String.valueOf(0), 0, paramProxyListener.getTableName(), paramProxyListener, 1, null);
      continue;
      label243:
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "FileManagerEntity status[" + String.valueOf(paramProxyListener.getStatus()) + "] is wrong");
      }
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "why FileManagerEntity is null!!!");
      }
      return;
    }
    paramFileManagerEntity.setFilePath(paramString);
    paramFileManagerEntity = paramFileManagerEntity.clone();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("strFilePath", paramString);
    a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject2;
    try
    {
      if (this.d == null) {
        init();
      }
      localObject1 = this.d.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        if ((((FileManagerEntity)localObject2).peerUin != null) && (((FileManagerEntity)localObject2).peerUin.equals(paramString)) && (((FileManagerEntity)localObject2).peerType == paramInt))
        {
          ((FileManagerEntity)localObject2).uniseq = -1L;
          ((FileManagerEntity)localObject2).bDelInAio = true;
        }
      }
      localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    }
    finally {}
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      localObject2 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
      if ((((FileManagerEntity)localObject2).peerUin != null) && (((FileManagerEntity)localObject2).peerUin.equals(paramString)) && (((FileManagerEntity)localObject2).peerType == paramInt))
      {
        ((FileManagerEntity)localObject2).uniseq = -1L;
        ((FileManagerEntity)localObject2).bDelInAio = true;
      }
    }
    Object localObject1 = new ContentValues();
    ((ContentValues)localObject1).put("bDelInAio", Boolean.valueOf(true));
    ((ContentValues)localObject1).put("uniseq", Integer.valueOf(-1));
    a(FileManagerEntity.tableName(), (ContentValues)localObject1, " peerUin = ? and peerType = ? ", new String[] { paramString, String.valueOf(paramInt) }, null);
    a(FileManagerEntity.tableName(), " bDelInAio = ? and bDelInFM = ? ", new String[] { String.valueOf(1), String.valueOf(1) }, null);
  }
  
  void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.proxyManager.addMsgQueue(String.valueOf(0), 0, paramString1, paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
  }
  
  protected void a(String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.proxyManager.addMsgQueue(String.valueOf(0), 0, paramString1, paramString2, paramArrayOfString, 2, paramProxyListener);
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      if (((FileManagerProxy.DeletedOlSessionInfo)localIterator.next()).jdField_a_of_type_Long == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramFileManagerEntity == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.e("FileManagerProxy<FileAssistant>", 2, "if item is null, why can choose???!!!");
          bool1 = bool2;
        }
        return bool1;
      }
      finally {}
      bool1 = bool2;
      if (this.app.getEntityManagerFactory().createEntityManager() != null)
      {
        Object localObject = ((QQAppInterface)this.app).getMessageFacade().b(paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.uniseq);
        if ((paramFileManagerEntity.bDelInAio) && (paramFileManagerEntity.bDelInFM) && (localObject == null))
        {
          a(FileManagerEntity.tableName(), "nSessionId = ?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
          this.d.remove(paramFileManagerEntity);
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            localObject = this.jdField_a_of_type_JavaUtilList.iterator();
            if (((Iterator)localObject).hasNext())
            {
              if (((Iterator)localObject).next() != paramFileManagerEntity) {
                continue;
              }
              ((Iterator)localObject).remove();
              continue;
            }
          }
          localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            if (paramFileManagerEntity.nSessionId == ((FileManagerEntity)localEntry.getValue()).nSessionId) {
              ((Iterator)localObject).remove();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerProxy<FileAssistant>", 2, "Delete FileManagerEntity[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] for memory and db:" + FileManagerUtil.a(paramFileManagerEntity));
          }
          a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.nOLfileSessionId);
          bool1 = a(1);
        }
        else
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("bDelInAio", Boolean.valueOf(paramFileManagerEntity.bDelInAio));
          ((ContentValues)localObject).put("bDelInFM", Boolean.valueOf(paramFileManagerEntity.bDelInFM));
          ((ContentValues)localObject).put("uniseq", Long.valueOf(paramFileManagerEntity.uniseq));
          a(FileManagerEntity.tableName(), (ContentValues)localObject, "nSessionId = ?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
          if (paramBoolean) {
            this.proxyManager.transSaveToDatabase();
          }
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerProxy<FileAssistant>", 2, "Update FileManagerEntity[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] for db:" + FileManagerUtil.a(paramFileManagerEntity));
          }
          bool1 = true;
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      return false;
    }
    return this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(String paramString, long paramLong)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      FileManagerProxy.DeletedOlSessionInfo localDeletedOlSessionInfo = (FileManagerProxy.DeletedOlSessionInfo)localIterator.next();
      if ((localDeletedOlSessionInfo.b == paramLong) && (localDeletedOlSessionInfo.jdField_a_of_type_JavaLangString != null) && (localDeletedOlSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public FileManagerEntity b(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = null;
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
        localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      }
      return localFileManagerEntity;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public FileManagerEntity b(long paramLong, String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.d == null) {
          init();
        }
        paramString = "select * from " + FileManagerEntity.tableName() + " where uniseq = ?";
        localObject = this.app.getEntityManagerFactory().createEntityManager();
        if (localObject != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerProxy<FileAssistant>", 2, "get EntityManager null!");
        }
        paramString = null;
      }
      finally
      {
        try
        {
          Object localObject;
          long l;
          this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(((FileManagerEntity)localObject).nSessionId), localObject);
          FileCategoryUtil.a((FileManagerEntity)localObject);
          paramString = (String)localObject;
          if (((FileManagerEntity)localObject).cloudType != 1) {
            continue;
          }
          paramString = (String)localObject;
          if (!FileManagerUtil.b((FileManagerEntity)localObject)) {
            continue;
          }
          ((FileManagerEntity)localObject).status = 16;
          paramString = (String)localObject;
        }
        catch (Exception paramString)
        {
          QLog.e("FileManagerProxy<FileAssistant>", 1, paramString.toString());
          QLog.e("FileManagerProxy<FileAssistant>", 1, new Throwable().getStackTrace());
          paramString = null;
        }
        paramString = finally;
      }
      return paramString;
      l = System.currentTimeMillis();
      paramString = ((EntityManager)localObject).rawQuery(FileManagerEntity.class, paramString, new String[] { String.valueOf(paramLong) });
      paramLong = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerProxy<FileAssistant>", 2, "query over,startTime[" + String.valueOf(l) + "], overTime[" + String.valueOf(paramLong) + "]");
      }
      if ((paramString == null) || (paramString.size() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerProxy<FileAssistant>", 2, "queryOver, but no data!");
        }
      }
      else
      {
        if ((paramString.size() > 1) && (QLog.isColorLevel())) {
          QLog.w("FileManagerProxy", 2, "why size[" + String.valueOf(paramString.size()) + "] over 1?");
        }
        localObject = (FileManagerEntity)paramString.get(0);
        continue;
      }
      paramString = null;
    }
  }
  
  /* Error */
  public FileManagerEntity b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 181	com/tencent/mobileqq/filemanager/data/FileManagerProxy:init	()V
    //   13: aload_0
    //   14: getfield 34	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   17: invokeinterface 251 1 0
    //   22: astore 4
    //   24: aload 4
    //   26: invokeinterface 256 1 0
    //   31: ifeq +40 -> 71
    //   34: aload 4
    //   36: invokeinterface 260 1 0
    //   41: checkcast 192	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   44: astore_3
    //   45: aload_3
    //   46: invokevirtual 269	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   49: ifnull -25 -> 24
    //   52: aload_3
    //   53: invokevirtual 269	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   56: aload_1
    //   57: invokevirtual 289	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: istore_2
    //   61: iload_2
    //   62: ifeq -38 -> 24
    //   65: aload_3
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: areturn
    //   71: aload_0
    //   72: getfield 36	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   75: invokeinterface 582 1 0
    //   80: invokeinterface 331 1 0
    //   85: astore 4
    //   87: aload 4
    //   89: invokeinterface 256 1 0
    //   94: ifeq +53 -> 147
    //   97: aload 4
    //   99: invokeinterface 260 1 0
    //   104: checkcast 128	java/lang/Long
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 36	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   112: aload_3
    //   113: invokeinterface 308 2 0
    //   118: checkcast 192	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   121: astore_3
    //   122: aload_3
    //   123: invokevirtual 269	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   126: ifnull -39 -> 87
    //   129: aload_3
    //   130: invokevirtual 269	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   133: aload_1
    //   134: invokevirtual 289	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   137: istore_2
    //   138: iload_2
    //   139: ifeq -52 -> 87
    //   142: aload_3
    //   143: astore_1
    //   144: goto -77 -> 67
    //   147: aconst_null
    //   148: astore_1
    //   149: goto -82 -> 67
    //   152: astore_1
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_1
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	FileManagerProxy
    //   0	157	1	paramString	String
    //   60	79	2	bool	boolean
    //   44	99	3	localObject	Object
    //   22	76	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	152	finally
    //   13	24	152	finally
    //   24	61	152	finally
    //   71	87	152	finally
    //   87	138	152	finally
  }
  
  public List<FileManagerEntity> b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        a();
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerProxy<FileAssistant>", 2, "queryMaxRecentRecords size[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
      }
      List localList = this.jdField_a_of_type_JavaUtilList;
      return localList;
    }
    finally {}
  }
  
  public List<FileManagerEntity> b(String paramString)
  {
    try
    {
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      paramString = this.jdField_b_of_type_JavaUtilList;
      return paramString;
    }
    finally {}
  }
  
  public List<FileManagerEntity> b(List<Integer> paramList, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      a();
    }
    ArrayList localArrayList = new ArrayList(paramList);
    paramList = new ArrayList(this.e);
    paramList.removeAll(localArrayList);
    localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!TextUtils.isEmpty(localFileManagerEntity.fileName)) && (!TextUtils.isEmpty(localFileManagerEntity.peerUin)))
      {
        int i = FileManagerUtil.a(localFileManagerEntity.fileName);
        if ((localFileManagerEntity.peerUin.equals(paramString)) && (paramList.contains(Integer.valueOf(i)))) {
          localArrayList.add(localFileManagerEntity);
        }
      }
    }
    return localArrayList;
  }
  
  public void b()
  {
    if (this.d == null) {
      init();
    }
    Object localObject2 = this.d.iterator();
    for (Object localObject1 = null; ((Iterator)localObject2).hasNext(); localObject1 = ((FileManagerEntity)localObject1).getTableName())
    {
      localObject1 = (FileManagerEntity)((Iterator)localObject2).next();
      ((FileManagerEntity)localObject1).isReaded = true;
    }
    if (localObject1 != null)
    {
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("isReaded", Boolean.valueOf(true));
      a((String)localObject1, (ContentValues)localObject2, "isReaded=?", new String[] { "0" }, null);
    }
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    for (;;)
    {
      try
      {
        a(paramFileManagerEntity);
        Looper localLooper = Looper.getMainLooper();
        Thread localThread1 = Thread.currentThread();
        Thread localThread2 = localLooper.getThread();
        if (localThread1 == localThread2) {
          try
          {
            a(paramFileManagerEntity, null);
            c(paramFileManagerEntity);
            return;
          }
          catch (Exception paramFileManagerEntity)
          {
            paramFileManagerEntity.printStackTrace();
            continue;
          }
        }
        new Handler(localLooper).post(new FileManagerProxy.1(this, paramFileManagerEntity));
      }
      finally {}
    }
  }
  
  /* Error */
  public FileManagerEntity c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 181	com/tencent/mobileqq/filemanager/data/FileManagerProxy:init	()V
    //   13: aload_0
    //   14: getfield 34	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   17: invokeinterface 251 1 0
    //   22: astore 4
    //   24: aload 4
    //   26: invokeinterface 256 1 0
    //   31: ifeq +40 -> 71
    //   34: aload 4
    //   36: invokeinterface 260 1 0
    //   41: checkcast 192	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   44: astore_3
    //   45: aload_3
    //   46: getfield 861	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strServerPath	Ljava/lang/String;
    //   49: ifnull -25 -> 24
    //   52: aload_3
    //   53: getfield 861	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strServerPath	Ljava/lang/String;
    //   56: aload_1
    //   57: invokevirtual 289	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: istore_2
    //   61: iload_2
    //   62: ifeq -38 -> 24
    //   65: aload_3
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: areturn
    //   71: aload_0
    //   72: getfield 36	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   75: invokeinterface 582 1 0
    //   80: invokeinterface 331 1 0
    //   85: astore 4
    //   87: aload 4
    //   89: invokeinterface 256 1 0
    //   94: ifeq +61 -> 155
    //   97: aload 4
    //   99: invokeinterface 260 1 0
    //   104: checkcast 128	java/lang/Long
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 36	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   112: aload_3
    //   113: invokeinterface 308 2 0
    //   118: checkcast 192	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   121: astore_3
    //   122: aload_3
    //   123: getfield 861	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strServerPath	Ljava/lang/String;
    //   126: ifnull -39 -> 87
    //   129: aload_3
    //   130: getfield 711	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bDelInFM	Z
    //   133: iconst_1
    //   134: if_icmpeq -47 -> 87
    //   137: aload_3
    //   138: getfield 861	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strServerPath	Ljava/lang/String;
    //   141: aload_1
    //   142: invokevirtual 289	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   145: istore_2
    //   146: iload_2
    //   147: ifeq -60 -> 87
    //   150: aload_3
    //   151: astore_1
    //   152: goto -85 -> 67
    //   155: aconst_null
    //   156: astore_1
    //   157: goto -90 -> 67
    //   160: astore_1
    //   161: aload_0
    //   162: monitorexit
    //   163: aload_1
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	FileManagerProxy
    //   0	165	1	paramString	String
    //   60	87	2	bool	boolean
    //   44	107	3	localObject	Object
    //   22	76	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	160	finally
    //   13	24	160	finally
    //   24	61	160	finally
    //   71	87	160	finally
    //   87	146	160	finally
  }
  
  public List<FileManagerEntity> c()
  {
    if ((this.d == null) || (this.d.isEmpty())) {
      init();
    }
    return this.d;
  }
  
  public void c()
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.size() > 0) && (l - this.jdField_a_of_type_Long > 5000L)) {
      ThreadManager.getSubThreadHandler().post(new FileManagerProxy.2(this));
    }
    if (this.jdField_a_of_type_JavaUtilSet != null) {
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    int i;
    try
    {
      if (this.d == null) {
        init();
      }
      if ((!this.d.contains(paramFileManagerEntity)) || (!QLog.isColorLevel())) {
        break label356;
      }
      QLog.e("FileManagerProxy<FileAssistant>", 2, "!!!!!!!!!!!fmList has one!!!!!!!!!!!!");
    }
    catch (Exception paramFileManagerEntity)
    {
      for (;;)
      {
        FileManagerEntity localFileManagerEntity;
        label286:
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerProxy<FileAssistant>", 1, paramFileManagerEntity.toString());
        }
      }
    }
    finally {}
    if (i < this.d.size())
    {
      localFileManagerEntity = (FileManagerEntity)this.d.get(i);
      if (paramFileManagerEntity.srvTime >= localFileManagerEntity.srvTime)
      {
        if (!paramFileManagerEntity.bDelInFM) {
          this.d.add(i, paramFileManagerEntity);
        }
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label361;
        }
        this.jdField_a_of_type_JavaUtilList.add(i, paramFileManagerEntity);
        break label361;
      }
    }
    for (;;)
    {
      if (!bool)
      {
        if (this.d.size() != 0) {
          break label286;
        }
        if (!paramFileManagerEntity.bDelInFM) {
          this.d.add(0, paramFileManagerEntity);
        }
        if (this.jdField_a_of_type_JavaUtilList != null) {
          this.jdField_a_of_type_JavaUtilList.add(0, paramFileManagerEntity);
        }
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("FileManagerProxy<FileAssistant>", 4, "insertToList, is add" + bool + " entityInfo:" + FileManagerUtil.a(paramFileManagerEntity));
        }
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramFileManagerEntity.nSessionId), paramFileManagerEntity);
        if (this.d.size() > 30) {
          this.d.remove(this.d.size() - 1);
        }
        return;
        i += 1;
        break;
        if (!paramFileManagerEntity.bDelInFM) {
          this.d.add(paramFileManagerEntity);
        }
        if (this.jdField_a_of_type_JavaUtilList != null) {
          this.jdField_a_of_type_JavaUtilList.add(paramFileManagerEntity);
        }
      }
      boolean bool = false;
      continue;
      label356:
      i = 0;
      break;
      label361:
      bool = true;
    }
  }
  
  /* Error */
  public FileManagerEntity d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 181	com/tencent/mobileqq/filemanager/data/FileManagerProxy:init	()V
    //   13: aload_0
    //   14: getfield 34	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   17: invokeinterface 251 1 0
    //   22: astore 4
    //   24: aload 4
    //   26: invokeinterface 256 1 0
    //   31: ifeq +62 -> 93
    //   34: aload 4
    //   36: invokeinterface 260 1 0
    //   41: checkcast 192	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   44: astore_3
    //   45: aload_3
    //   46: getfield 889	com/tencent/mobileqq/filemanager/data/FileManagerEntity:WeiYunFileId	Ljava/lang/String;
    //   49: ifnull -25 -> 24
    //   52: aload_3
    //   53: getfield 889	com/tencent/mobileqq/filemanager/data/FileManagerEntity:WeiYunFileId	Ljava/lang/String;
    //   56: aload_1
    //   57: invokevirtual 289	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: ifeq -36 -> 24
    //   63: aload_3
    //   64: getfield 339	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   67: iconst_1
    //   68: if_icmpne -44 -> 24
    //   71: aload_3
    //   72: getfield 892	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   75: ifle -51 -> 24
    //   78: aload_3
    //   79: getfield 895	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   82: istore_2
    //   83: iload_2
    //   84: ifle -60 -> 24
    //   87: aload_3
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: areturn
    //   93: aload_0
    //   94: getfield 36	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   97: invokeinterface 582 1 0
    //   102: invokeinterface 331 1 0
    //   107: astore 4
    //   109: aload 4
    //   111: invokeinterface 256 1 0
    //   116: ifeq +75 -> 191
    //   119: aload 4
    //   121: invokeinterface 260 1 0
    //   126: checkcast 128	java/lang/Long
    //   129: astore_3
    //   130: aload_0
    //   131: getfield 36	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   134: aload_3
    //   135: invokeinterface 308 2 0
    //   140: checkcast 192	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   143: astore_3
    //   144: aload_3
    //   145: getfield 889	com/tencent/mobileqq/filemanager/data/FileManagerEntity:WeiYunFileId	Ljava/lang/String;
    //   148: ifnull -39 -> 109
    //   151: aload_3
    //   152: getfield 889	com/tencent/mobileqq/filemanager/data/FileManagerEntity:WeiYunFileId	Ljava/lang/String;
    //   155: aload_1
    //   156: invokevirtual 289	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   159: ifeq -50 -> 109
    //   162: aload_3
    //   163: getfield 339	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   166: iconst_1
    //   167: if_icmpne -58 -> 109
    //   170: aload_3
    //   171: getfield 892	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   174: ifle -65 -> 109
    //   177: aload_3
    //   178: getfield 895	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   181: istore_2
    //   182: iload_2
    //   183: ifle -74 -> 109
    //   186: aload_3
    //   187: astore_1
    //   188: goto -99 -> 89
    //   191: aconst_null
    //   192: astore_1
    //   193: goto -104 -> 89
    //   196: astore_1
    //   197: aload_0
    //   198: monitorexit
    //   199: aload_1
    //   200: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	FileManagerProxy
    //   0	201	1	paramString	String
    //   82	101	2	i	int
    //   44	143	3	localObject	Object
    //   22	98	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	196	finally
    //   13	24	196	finally
    //   24	83	196	finally
    //   93	109	196	finally
    //   109	182	196	finally
  }
  
  public void d()
  {
    String str = "delete from " + FileManagerEntity.tableName();
    this.app.getEntityManagerFactory().createEntityManager().execSQL(str);
  }
  
  public void d(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "updateFileEntity, Error : entity is null!!!");
      }
      return;
    }
    FileManagerUtil.a(paramFileManagerEntity);
    int i = paramFileManagerEntity.status;
    if (i == 2) {
      paramFileManagerEntity.status = 0;
    }
    ContentValues localContentValues = a(paramFileManagerEntity);
    paramFileManagerEntity.status = i;
    long l = paramFileManagerEntity.nSessionId;
    paramFileManagerEntity = Looper.getMainLooper();
    if (Thread.currentThread() == paramFileManagerEntity.getThread()) {
      try
      {
        a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(l) }, null);
        return;
      }
      catch (Exception paramFileManagerEntity)
      {
        paramFileManagerEntity.printStackTrace();
        return;
      }
    }
    new Handler(paramFileManagerEntity).post(new FileManagerProxy.3(this, localContentValues, l));
  }
  
  public void destroy() {}
  
  /* Error */
  public FileManagerEntity e(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 181	com/tencent/mobileqq/filemanager/data/FileManagerProxy:init	()V
    //   13: aload_0
    //   14: getfield 34	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   17: invokeinterface 251 1 0
    //   22: astore 4
    //   24: aload 4
    //   26: invokeinterface 256 1 0
    //   31: ifeq +40 -> 71
    //   34: aload 4
    //   36: invokeinterface 260 1 0
    //   41: checkcast 192	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   44: astore_3
    //   45: aload_3
    //   46: getfield 913	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   49: ifnull -25 -> 24
    //   52: aload_3
    //   53: getfield 913	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   56: aload_1
    //   57: invokevirtual 289	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: istore_2
    //   61: iload_2
    //   62: ifeq -38 -> 24
    //   65: aload_3
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: areturn
    //   71: aload_0
    //   72: getfield 36	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   75: invokeinterface 582 1 0
    //   80: invokeinterface 331 1 0
    //   85: astore 4
    //   87: aload 4
    //   89: invokeinterface 256 1 0
    //   94: ifeq +60 -> 154
    //   97: aload 4
    //   99: invokeinterface 260 1 0
    //   104: checkcast 128	java/lang/Long
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 36	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   112: aload_3
    //   113: invokeinterface 308 2 0
    //   118: checkcast 192	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   121: astore_3
    //   122: aload_3
    //   123: ifnull -36 -> 87
    //   126: aload_3
    //   127: getfield 913	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   130: invokestatic 442	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   133: ifne -46 -> 87
    //   136: aload_3
    //   137: getfield 913	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   140: aload_1
    //   141: invokevirtual 289	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   144: istore_2
    //   145: iload_2
    //   146: ifeq -59 -> 87
    //   149: aload_3
    //   150: astore_1
    //   151: goto -84 -> 67
    //   154: aconst_null
    //   155: astore_1
    //   156: goto -89 -> 67
    //   159: astore_1
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	FileManagerProxy
    //   0	164	1	paramString	String
    //   60	86	2	bool	boolean
    //   44	106	3	localObject	Object
    //   22	76	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	159	finally
    //   13	24	159	finally
    //   24	61	159	finally
    //   71	87	159	finally
    //   87	122	159	finally
    //   126	145	159	finally
  }
  
  public void e()
  {
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      this.jdField_b_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  public void e(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    for (;;)
    {
      ContentValues localContentValues;
      try
      {
        localContentValues = new ContentValues();
        if (paramFileManagerEntity.bDelInFM)
        {
          localContentValues.put("bDelInFM", Boolean.valueOf(true));
          a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
          break;
        }
      }
      finally {}
      localContentValues.put("bDelInFM", Boolean.valueOf(false));
    }
  }
  
  public FileManagerEntity f(String paramString)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        if (this.d == null) {
          init();
        }
        localArrayList = new ArrayList();
        localObject2 = this.d.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (FileManagerEntity)((Iterator)localObject2).next();
          if ((((FileManagerEntity)localObject1).WeiYunFileId == null) || (!((FileManagerEntity)localObject1).WeiYunFileId.equalsIgnoreCase(paramString))) {
            continue;
          }
          if (((FileManagerEntity)localObject1).status == 1)
          {
            boolean bool = FileUtil.b(((FileManagerEntity)localObject1).getFilePath());
            if (bool) {
              return localObject1;
            }
          }
          localArrayList.add(localObject1);
          continue;
        }
        localIterator = localArrayList.iterator();
      }
      finally {}
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject2 = (FileManagerEntity)localIterator.next();
          localObject1 = localObject2;
          if (((FileManagerEntity)localObject2).nOpType == 5) {
            break;
          }
          localObject1 = localObject2;
          if (((FileManagerEntity)localObject2).nOpType == 50) {
            break;
          }
          if (((FileManagerEntity)localObject2).cloudType == 2)
          {
            localObject1 = localObject2;
            break;
          }
        }
      }
      localArrayList.clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label304;
        }
        localObject1 = (Long)localIterator.next();
        localObject2 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(localObject1);
        if ((((FileManagerEntity)localObject2).WeiYunFileId != null) && (((FileManagerEntity)localObject2).WeiYunFileId.equalsIgnoreCase(paramString)))
        {
          if (((FileManagerEntity)localObject2).status == 1)
          {
            localObject1 = localObject2;
            if (FileUtil.b(((FileManagerEntity)localObject2).getFilePath())) {
              break;
            }
          }
          localArrayList.add(localObject2);
        }
      }
      label304:
      Object localObject2 = localArrayList.iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          paramString = (FileManagerEntity)((Iterator)localObject2).next();
          localObject1 = paramString;
          if (paramString.nOpType == 5) {
            break;
          }
          localObject1 = paramString;
          if (paramString.nOpType == 50) {
            break;
          }
          int i = paramString.cloudType;
          if (i == 2)
          {
            localObject1 = paramString;
            break;
          }
        }
      }
      Object localObject1 = null;
    }
  }
  
  public void f(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    for (;;)
    {
      return;
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("msgSeq", Long.valueOf(paramFileManagerEntity.msgSeq));
        localContentValues.put("msgUid", Long.valueOf(paramFileManagerEntity.msgUid));
        localContentValues.put("msgTime", Long.valueOf(paramFileManagerEntity.msgTime));
        a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
      }
      finally {}
    }
  }
  
  public FileManagerEntity g(String arg1)
  {
    FileManagerEntity localFileManagerEntity;
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      if (this.jdField_b_of_type_JavaUtilMap.size() == 0) {
        return null;
      }
      localFileManagerEntity = (FileManagerEntity)this.jdField_b_of_type_JavaUtilMap.get(???);
      if (localFileManagerEntity == null) {
        return null;
      }
    }
    ??? = b(localFileManagerEntity.nSessionId);
    if (??? != null)
    {
      if (??? == localFileManagerEntity)
      {
        if (!FileUtil.b(localFileManagerEntity.getFilePath())) {
          synchronized (this.jdField_b_of_type_JavaUtilMap)
          {
            this.jdField_b_of_type_JavaUtilMap.remove(localFileManagerEntity.zipInnerPath);
            QLog.e("FileManagerProxy<FileAssistant>", 1, "getZipFileListEntity : can find the Entity in cache, but raw file is not exist! [fileName] = " + localFileManagerEntity.fileName + "[sessionId] = " + localFileManagerEntity.nSessionId);
            return null;
          }
        }
      }
      else {
        synchronized (this.jdField_b_of_type_JavaUtilMap)
        {
          this.jdField_b_of_type_JavaUtilMap.put(???, ???);
          return ???;
        }
      }
    }
    else {
      try
      {
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(???.nSessionId), ???);
        return ???;
      }
      finally {}
    }
    return ???;
  }
  
  public void g(FileManagerEntity paramFileManagerEntity)
  {
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      this.jdField_b_of_type_JavaUtilMap.put(paramFileManagerEntity.zipInnerPath, paramFileManagerEntity);
      QLog.e("FileManagerProxy<FileAssistant>", 1, "insertToZipListFile : [fileName] = " + paramFileManagerEntity.fileName + "[sessionId] = " + paramFileManagerEntity.nSessionId);
      return;
    }
  }
  
  public void init()
  {
    if (this.d != null) {
      return;
    }
    Object localObject2 = "select * from ( select * from " + FileManagerEntity.tableName() + " order by srvTime desc limit " + 30 + ") order by srvTime desc";
    Object localObject3 = "update  " + FileManagerEntity.tableName() + " set bDelInFM = ?  where ( srvTime + ?  ) < ? and cloudType = ? ";
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    localEntityManager.update((String)localObject3, new Object[] { Integer.valueOf(1), Long.valueOf(604800000L), Long.valueOf(MessageCache.a() * 1000L), Integer.valueOf(1) });
    this.d = localEntityManager.rawQuery(FileManagerEntity.class, (String)localObject2, null);
    if (this.d == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerProxy<FileAssistant>", 2, "init , buf fmList is null,maybe is not data!,sql[" + (String)localObject2 + "]");
      }
      this.d = new ArrayList();
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap == null)
      {
        this.jdField_a_of_type_JavaUtilMap = new HashMap();
        localObject2 = this.d.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FileManagerEntity)((Iterator)localObject2).next();
          FileManagerUtil.a((FileManagerEntity)localObject3);
          this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(((FileManagerEntity)localObject3).nSessionId), localObject3);
        }
      }
    }
    finally {}
    localObject1.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileManagerProxy
 * JD-Core Version:    0.7.0.1
 */