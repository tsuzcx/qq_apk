package dov.com.qq.im.ae.data;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.AEPath.CAMERA.FILES;
import dov.com.qq.im.ae.AEPath.Watermark;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class AEWatermarkMaterialManager
{
  private final ArrayList<AEWatermarkMaterialManager.IWatermarkMgrListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final CopyOnWriteArrayList<AEMaterialCategory> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public static AEWatermarkMaterialManager a()
  {
    return AEWatermarkMaterialManager.Holder.a();
  }
  
  private List<AEMaterialCategory> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = QIMPtvTemplateManager.a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {}
    do
    {
      return localArrayList;
      paramFile = AEMaterialConfigParser.a(paramFile);
    } while ((paramFile == null) || (paramFile.isEmpty()));
    return paramFile;
  }
  
  private List<AEMaterialCategory> a(File paramFile1, File paramFile2)
  {
    paramFile1 = a(paramFile1);
    List localList = a(paramFile2);
    if ((localList == null) || (localList.isEmpty())) {
      return paramFile1;
    }
    Iterator localIterator1 = paramFile1.iterator();
    Iterator localIterator2;
    if (localIterator1.hasNext())
    {
      paramFile2 = (AEMaterialCategory)localIterator1.next();
      localIterator2 = localList.iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
        paramFile1 = (AEMaterialCategory)localIterator2.next();
      } while (!paramFile1.b.equals(paramFile2.b));
    }
    for (;;)
    {
      if (paramFile1 == null)
      {
        paramFile1 = paramFile2.a.iterator();
        while (paramFile1.hasNext()) {
          a((AEMaterialMetaData)paramFile1.next());
        }
        break;
      }
      localIterator2 = paramFile2.a.iterator();
      label149:
      AEMaterialMetaData localAEMaterialMetaData;
      if (localIterator2.hasNext())
      {
        localAEMaterialMetaData = (AEMaterialMetaData)localIterator2.next();
        Iterator localIterator3 = paramFile1.a.iterator();
        do
        {
          if (!localIterator3.hasNext()) {
            break;
          }
          paramFile2 = (AEMaterialMetaData)localIterator3.next();
        } while (!localAEMaterialMetaData.a.equals(paramFile2.a));
      }
      for (;;)
      {
        if (paramFile2 == null)
        {
          a(localAEMaterialMetaData);
          break label149;
        }
        if (localAEMaterialMetaData.jdField_e_of_type_JavaLangString.equals(paramFile2.jdField_e_of_type_JavaLangString)) {
          break label149;
        }
        a(localAEMaterialMetaData);
        break label149;
        break;
        return localList;
        paramFile2 = null;
      }
      paramFile1 = null;
    }
  }
  
  private void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEWatermarkMaterialManager", 2, "deleteMaterialFolder: " + paramAEMaterialMetaData.a);
    }
    File localFile = new File(AEPath.CAMERA.FILES.i, paramAEMaterialMetaData.a);
    if (localFile.exists()) {
      FileUtils.a(localFile.getPath());
    }
    paramAEMaterialMetaData = new File(AEPath.CAMERA.FILES.h, paramAEMaterialMetaData.a);
    if (paramAEMaterialMetaData.exists()) {
      FileUtils.a(paramAEMaterialMetaData.getPath());
    }
  }
  
  private void a(List<AEMaterialCategory> paramList)
  {
    if (paramList == null) {
      label4:
      return;
    } else {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label4;
      }
      Object localObject = (AEMaterialCategory)paramList.next();
      if ((localObject == null) || (((AEMaterialCategory)localObject).a == null)) {
        break;
      }
      localObject = ((AEMaterialCategory)localObject).a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)((Iterator)localObject).next();
        if (localAEMaterialMetaData != null) {
          localAEMaterialMetaData.jdField_e_of_type_Boolean = AEMaterialManager.a(localAEMaterialMetaData);
        }
      }
    }
  }
  
  private List<AEMaterialCategory> b()
  {
    Object localObject2 = new File(AEPath.Watermark.b);
    Object localObject1 = new File(AEPath.Watermark.a);
    if (!((File)localObject2).exists())
    {
      if (!((File)localObject1).exists())
      {
        localObject1 = new ArrayList();
        AEQLog.a("AEWatermarkMaterialManager", "readAndParseConfigFile -> oldJson not exist, newJson not exist, use Json from assets ");
        b();
        return localObject1;
      }
      try
      {
        localObject2 = a((File)localObject1);
        AEQLog.a("AEWatermarkMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, use oldJson");
        return localObject2;
      }
      catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException3)
      {
        FileUtils.e(((File)localObject1).getPath());
        localObject1 = new ArrayList();
        AEQLog.d("AEWatermarkMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, exception:" + localAEMaterialConfigParseException3.toString());
        b();
        return localObject1;
      }
    }
    List localList;
    ArrayList localArrayList;
    if (!((File)localObject1).exists()) {
      try
      {
        localList = a(localAEMaterialConfigParseException3);
        FileUtils.b(localAEMaterialConfigParseException3.getPath(), ((File)localObject1).getPath());
        AEQLog.a("AEWatermarkMaterialManager", "readAndParseConfigFile -> oldJson not exist, use newJson ");
        return localList;
      }
      catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException1)
      {
        FileUtils.e(localAEMaterialConfigParseException3.getPath());
        localArrayList = new ArrayList();
        AEQLog.d("AEWatermarkMaterialManager", "readAndParseConfigFile -> oldJson not exists: exception:" + localAEMaterialConfigParseException1.toString());
        b();
        return localArrayList;
      }
    }
    try
    {
      localList = a(localAEMaterialConfigParseException1, localArrayList);
      FileUtils.e(localAEMaterialConfigParseException1.getPath());
      FileUtils.b(localArrayList.getPath(), localAEMaterialConfigParseException1.getPath());
      AEQLog.a("AEWatermarkMaterialManager", "readAndParseConfigFile -> try check update ");
      return localList;
    }
    catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException2)
    {
      localArrayList = new ArrayList();
      AEQLog.d("AEWatermarkMaterialManager", "loadMaterialListFromAssets  -> oldJson exists: exception:" + localAEMaterialConfigParseException2.toString());
      b();
    }
    return localArrayList;
  }
  
  private void b()
  {
    AECameraPrefsUtil.a().a("CameraModuleSvc.GetCompressedCategoryMaterialV2MqCircleWatermark", 4);
    try
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  /* Error */
  @android.support.annotation.WorkerThread
  public List<AEMaterialCategory> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 108
    //   4: new 110	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   11: ldc 212
    //   13: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: getfield 21	dov/com/qq/im/ae/data/AEWatermarkMaterialManager:jdField_a_of_type_Boolean	Z
    //   20: invokevirtual 215	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   23: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 217	dov/com/qq/im/ae/util/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 21	dov/com/qq/im/ae/data/AEWatermarkMaterialManager:jdField_a_of_type_Boolean	Z
    //   33: ifeq +19 -> 52
    //   36: new 23	java/util/ArrayList
    //   39: dup
    //   40: aload_0
    //   41: getfield 19	dov/com/qq/im/ae/data/AEWatermarkMaterialManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   44: invokespecial 220	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: areturn
    //   52: aload_0
    //   53: invokespecial 222	dov/com/qq/im/ae/data/AEWatermarkMaterialManager:b	()Ljava/util/List;
    //   56: astore_1
    //   57: aload_0
    //   58: aload_1
    //   59: invokespecial 224	dov/com/qq/im/ae/data/AEWatermarkMaterialManager:a	(Ljava/util/List;)V
    //   62: aload_0
    //   63: getfield 19	dov/com/qq/im/ae/data/AEWatermarkMaterialManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   66: invokevirtual 227	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   69: aload_0
    //   70: getfield 19	dov/com/qq/im/ae/data/AEWatermarkMaterialManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   73: aload_1
    //   74: invokevirtual 231	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   77: pop
    //   78: aload_0
    //   79: iconst_1
    //   80: putfield 21	dov/com/qq/im/ae/data/AEWatermarkMaterialManager:jdField_a_of_type_Boolean	Z
    //   83: new 23	java/util/ArrayList
    //   86: dup
    //   87: aload_0
    //   88: getfield 19	dov/com/qq/im/ae/data/AEWatermarkMaterialManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   91: invokespecial 220	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   94: astore_1
    //   95: goto -47 -> 48
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	AEWatermarkMaterialManager
    //   47	48	1	localObject1	Object
    //   98	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	48	98	finally
    //   52	95	98	finally
  }
  
  public void a()
  {
    try
    {
      AEQLog.b("AEWatermarkMaterialManager", "onConfigUpdated---");
      this.jdField_a_of_type_Boolean = false;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((AEWatermarkMaterialManager.IWatermarkMgrListener)localIterator.next()).a();
      }
    }
    finally {}
  }
  
  public void a(AEWatermarkMaterialManager.IWatermarkMgrListener paramIWatermarkMgrListener)
  {
    if (paramIWatermarkMgrListener == null) {
      AEQLog.d("AEWatermarkMaterialManager", "registerListener---the listener param is null");
    }
    while (this.jdField_a_of_type_JavaUtilArrayList.contains(paramIWatermarkMgrListener)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramIWatermarkMgrListener);
  }
  
  public void b(AEWatermarkMaterialManager.IWatermarkMgrListener paramIWatermarkMgrListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramIWatermarkMgrListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.data.AEWatermarkMaterialManager
 * JD-Core Version:    0.7.0.1
 */