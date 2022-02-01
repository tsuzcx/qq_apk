package cooperation.photoplus;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.VersionUtils;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class PhotoPlusManager
  implements Manager
{
  public static final String a;
  private AppInterface b;
  private List<Sticker> c;
  private ConcurrentHashMap<String, DownloadTask> d = new ConcurrentHashMap();
  private volatile boolean e = false;
  private volatile boolean f = false;
  private MqqWeakReferenceHandler g;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("PhotoPlus/");
    a = localStringBuilder.toString();
  }
  
  public PhotoPlusManager(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPlusManager", 2, "[constructor]");
    }
    this.b = paramAppInterface;
    paramAppInterface = this.b.getEntityManagerFactory().createEntityManager();
    this.c = paramAppInterface.query(Sticker.class, new Sticker().getTableName(), false, null, null, null, null, null, null);
    paramAppInterface.close();
    this.g = new MqqWeakReferenceHandler(ThreadManager.getFileThreadLooper(), null);
    a(false);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    DownloadTask localDownloadTask = (DownloadTask)this.d.get(paramString2);
    if (localDownloadTask != null) {
      if ((localDownloadTask.e() != 2) && (localDownloadTask.e() != 3))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[download] task status error, cancel it ");
          ((StringBuilder)localObject).append(paramString2);
          QLog.d("PhotoPlusManager", 2, ((StringBuilder)localObject).toString());
        }
        localDownloadTask.a(true);
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("[download] duplicated ");
          paramString1.append(paramString2);
          QLog.d("PhotoPlusManager", 2, paramString1.toString());
        }
        return;
      }
    }
    localDownloadTask = new DownloadTask(paramString1, new File(paramString2));
    localDownloadTask.J = true;
    Object localObject = ((DownloaderFactory)this.b.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[download] startDownload: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" path=");
      localStringBuilder.append(paramString2);
      QLog.d("PhotoPlusManager", 2, localStringBuilder.toString());
    }
    this.d.put(paramString2, localDownloadTask);
    ((DownloaderInterface)localObject).startDownload(localDownloadTask, new PhotoPlusManager.1(this, paramString2, paramString1, paramString3), null);
  }
  
  private void a(List<Sticker> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPlusManager", 2, "[deleteOldResources] start");
    }
    Object localObject1 = new File(a);
    if (((File)localObject1).exists()) {
      if (((File)localObject1).isDirectory())
      {
        if (paramList == null)
        {
          FileUtils.deleteDirectory(a);
          return;
        }
        localObject1 = ((File)localObject1).listFiles();
        if (localObject1 != null)
        {
          int k = localObject1.length;
          int i = 0;
          while (i < k)
          {
            Object localObject2 = localObject1[i];
            Object localObject3;
            if (localObject2.isDirectory())
            {
              Object localObject4 = localObject2.getName();
              Iterator localIterator = paramList.iterator();
              while (localIterator.hasNext())
              {
                localObject3 = (Sticker)localIterator.next();
                if (((String)localObject4).equals(((Sticker)localObject3).id))
                {
                  int m = ((Sticker)localObject3).version;
                  localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append(((Sticker)localObject3).version);
                  ((StringBuilder)localObject4).append(".zip");
                  localObject3 = ((StringBuilder)localObject4).toString();
                  localObject4 = localObject2.listFiles();
                  if (localObject4 != null)
                  {
                    int n = localObject4.length;
                    j = 0;
                    while (j < n)
                    {
                      localIterator = localObject4[j];
                      StringBuilder localStringBuilder;
                      if (localIterator.isDirectory())
                      {
                        if (!localIterator.getName().equals(String.valueOf(m)))
                        {
                          if (QLog.isColorLevel())
                          {
                            localStringBuilder = new StringBuilder();
                            localStringBuilder.append("[updateStickerResource] delete old dir: ");
                            localStringBuilder.append(localObject2.getName());
                            localStringBuilder.append(File.separator);
                            localStringBuilder.append(localIterator.getName());
                            QLog.d("PhotoPlusManager", 2, localStringBuilder.toString());
                          }
                          FileUtils.deleteDirectory(localIterator.getAbsolutePath());
                        }
                      }
                      else if (!localIterator.getName().equals(localObject3))
                      {
                        if (QLog.isColorLevel())
                        {
                          localStringBuilder = new StringBuilder();
                          localStringBuilder.append("[updateStickerResource] delete old file: ");
                          localStringBuilder.append(localObject2.getName());
                          localStringBuilder.append(File.separator);
                          localStringBuilder.append(localIterator.getName());
                          QLog.d("PhotoPlusManager", 2, localStringBuilder.toString());
                        }
                        localIterator.delete();
                      }
                      j += 1;
                    }
                  }
                  j = 1;
                  break label413;
                }
              }
              int j = 0;
              label413:
              if (j == 0)
              {
                if (QLog.isColorLevel())
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("[updateStickerResource] delete old dir: ");
                  ((StringBuilder)localObject3).append(localObject2.getName());
                  QLog.d("PhotoPlusManager", 2, ((StringBuilder)localObject3).toString());
                }
                FileUtils.deleteDirectory(localObject2.getAbsolutePath());
              }
            }
            else
            {
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("[updateStickerResource] delete error file: ");
                ((StringBuilder)localObject3).append(localObject2.getName());
                QLog.d("PhotoPlusManager", 2, ((StringBuilder)localObject3).toString());
              }
              localObject2.delete();
            }
            i += 1;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete photo plus root directory");
        }
        ((File)localObject1).delete();
      }
    }
  }
  
  public List<Sticker> a()
  {
    List localList = this.c;
    if (localList == null) {
      return null;
    }
    return new ArrayList(localList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (VersionUtils.d()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[updateStickerResource] isDelete=");
      localStringBuilder.append(paramBoolean);
      QLog.d("PhotoPlusManager", 2, localStringBuilder.toString());
    }
    this.g.post(new PhotoPlusManager.UpdateTask(this, this.c, paramBoolean));
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +35 -> 38
    //   6: new 25	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc_w 291
    //   18: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: aload_1
    //   24: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: ldc 65
    //   30: iconst_2
    //   31: aload_2
    //   32: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload_0
    //   39: getfield 55	cooperation/photoplus/PhotoPlusManager:e	Z
    //   42: ifeq +5 -> 47
    //   45: iconst_0
    //   46: ireturn
    //   47: aload_0
    //   48: aload_1
    //   49: invokestatic 295	cooperation/photoplus/sticker/Sticker:parse	(Ljava/lang/String;)Ljava/util/List;
    //   52: putfield 98	cooperation/photoplus/PhotoPlusManager:c	Ljava/util/List;
    //   55: goto +20 -> 75
    //   58: astore_1
    //   59: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +13 -> 75
    //   65: ldc 65
    //   67: iconst_2
    //   68: ldc_w 297
    //   71: aload_1
    //   72: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   75: aload_0
    //   76: getfield 98	cooperation/photoplus/PhotoPlusManager:c	Ljava/util/List;
    //   79: ifnonnull +20 -> 99
    //   82: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +12 -> 97
    //   88: ldc 65
    //   90: iconst_2
    //   91: ldc_w 302
    //   94: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: iconst_1
    //   98: ireturn
    //   99: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +67 -> 169
    //   105: aload_0
    //   106: getfield 98	cooperation/photoplus/PhotoPlusManager:c	Ljava/util/List;
    //   109: invokeinterface 210 1 0
    //   114: astore_1
    //   115: aload_1
    //   116: invokeinterface 215 1 0
    //   121: ifeq +48 -> 169
    //   124: aload_1
    //   125: invokeinterface 219 1 0
    //   130: checkcast 86	cooperation/photoplus/sticker/Sticker
    //   133: astore_2
    //   134: new 25	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   141: astore_3
    //   142: aload_3
    //   143: ldc_w 304
    //   146: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_3
    //   151: aload_2
    //   152: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: ldc 65
    //   158: iconst_2
    //   159: aload_3
    //   160: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: goto -51 -> 115
    //   169: aload_0
    //   170: getfield 72	cooperation/photoplus/PhotoPlusManager:b	Lcom/tencent/common/app/AppInterface;
    //   173: invokevirtual 78	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   176: invokevirtual 84	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   179: astore_2
    //   180: aload_2
    //   181: invokevirtual 311	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   184: astore_1
    //   185: aload_1
    //   186: invokevirtual 316	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   189: aload_2
    //   190: ldc 86
    //   192: invokevirtual 320	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   195: pop
    //   196: aload_0
    //   197: getfield 98	cooperation/photoplus/PhotoPlusManager:c	Ljava/util/List;
    //   200: invokeinterface 210 1 0
    //   205: astore_3
    //   206: aload_3
    //   207: invokeinterface 215 1 0
    //   212: ifeq +19 -> 231
    //   215: aload_2
    //   216: aload_3
    //   217: invokeinterface 219 1 0
    //   222: checkcast 86	cooperation/photoplus/sticker/Sticker
    //   225: invokevirtual 324	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   228: goto -22 -> 206
    //   231: aload_1
    //   232: invokevirtual 327	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   235: goto +24 -> 259
    //   238: astore_2
    //   239: goto +35 -> 274
    //   242: astore_3
    //   243: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +13 -> 259
    //   249: ldc 65
    //   251: iconst_2
    //   252: ldc_w 329
    //   255: aload_3
    //   256: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   259: aload_1
    //   260: invokevirtual 332	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   263: aload_2
    //   264: invokevirtual 101	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   267: aload_0
    //   268: iconst_1
    //   269: invokevirtual 117	cooperation/photoplus/PhotoPlusManager:a	(Z)V
    //   272: iconst_1
    //   273: ireturn
    //   274: aload_1
    //   275: invokevirtual 332	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   278: goto +5 -> 283
    //   281: aload_2
    //   282: athrow
    //   283: goto -2 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	PhotoPlusManager
    //   0	286	1	paramString	String
    //   13	203	2	localObject1	Object
    //   238	44	2	localObject2	Object
    //   141	76	3	localObject3	Object
    //   242	14	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   47	55	58	org/json/JSONException
    //   185	206	238	finally
    //   206	228	238	finally
    //   231	235	238	finally
    //   243	259	238	finally
    //   185	206	242	java/lang/Exception
    //   206	228	242	java/lang/Exception
    //   231	235	242	java/lang/Exception
  }
  
  void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString.substring(0, paramString.indexOf(".zip")));
    ((StringBuilder)localObject).append(File.separator);
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      FileUtils.uncompressZip(paramString, (String)localObject, false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[unzip] success: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("PhotoPlusManager", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[unzip]", localException);
      }
      if (Utils.c() > 40960L) {
        FileUtils.deleteFile(paramString);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.photoplus.PhotoPlusManager
 * JD-Core Version:    0.7.0.1
 */