package cooperation.photoplus;

import amlq;
import amlr;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
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
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private List jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aJ + "PhotoPlus/";
  }
  
  public PhotoPlusManager(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPlusManager", 2, "[constructor]");
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    paramAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_JavaUtilList = paramAppInterface.a(Sticker.class, new Sticker().getTableName(), false, null, null, null, null, null, null);
    paramAppInterface.a();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(ThreadManager.getFileThreadLooper(), null);
    a(false);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString2);
    if (localDownloadTask != null)
    {
      if ((localDownloadTask.a() == 2) || (localDownloadTask.a() == 3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPlusManager", 2, "[download] duplicated " + paramString2);
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[download] task status error, cancel it " + paramString2);
      }
      localDownloadTask.a(true);
    }
    localDownloadTask = new DownloadTask(paramString1, new File(paramString2));
    localDownloadTask.l = true;
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(46)).a(1);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPlusManager", 2, "[download] startDownload: " + paramString1 + " path=" + paramString2);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, localDownloadTask);
    localDownloaderInterface.a(localDownloadTask, new amlq(this, paramString2, paramString1, paramString3), null);
  }
  
  private void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPlusManager", 2, "[deleteOldResources] start");
    }
    Object localObject1 = new File(jdField_a_of_type_JavaLangString);
    if (((File)localObject1).exists())
    {
      if (!((File)localObject1).isDirectory()) {
        break label464;
      }
      if (paramList != null) {
        break label53;
      }
      FileUtils.a(jdField_a_of_type_JavaLangString);
    }
    label53:
    do
    {
      return;
      localObject1 = ((File)localObject1).listFiles();
    } while (localObject1 == null);
    int k = localObject1.length;
    int i = 0;
    label72:
    Object localObject2;
    if (i < k)
    {
      localObject2 = localObject1[i];
      if (!localObject2.isDirectory()) {
        break label420;
      }
      String str = localObject2.getName();
      Object localObject3 = paramList.iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          Sticker localSticker = (Sticker)((Iterator)localObject3).next();
          if (str.equals(localSticker.id))
          {
            int m = localSticker.version;
            str = localSticker.version + ".zip";
            localObject3 = localObject2.listFiles();
            if (localObject3 != null)
            {
              int n = localObject3.length;
              j = 0;
              if (j < n)
              {
                localSticker = localObject3[j];
                if (localSticker.isDirectory()) {
                  if (!localSticker.getName().equals(String.valueOf(m)))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete old dir: " + localObject2.getName() + File.separator + localSticker.getName());
                    }
                    FileUtils.a(localSticker.getAbsolutePath());
                  }
                }
                for (;;)
                {
                  j += 1;
                  break;
                  if (!localSticker.getName().equals(str))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete old file: " + localObject2.getName() + File.separator + localSticker.getName());
                    }
                    localSticker.delete();
                  }
                }
              }
            }
          }
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete old dir: " + localObject2.getName());
        }
        FileUtils.a(localObject2.getAbsolutePath());
      }
      for (;;)
      {
        i += 1;
        break label72;
        break;
        label420:
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete error file: " + localObject2.getName());
        }
        localObject2.delete();
      }
      label464:
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete photo plus root directory");
      }
      ((File)localObject1).delete();
      return;
    }
  }
  
  public List a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return new ArrayList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(String paramString)
  {
    String str = paramString.substring(0, paramString.indexOf(".zip")) + File.separator;
    try
    {
      FileUtils.a(paramString, str, false);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[unzip] success: " + paramString);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPlusManager", 2, "[unzip]", localException);
        }
      } while (Utils.b() <= 40960L);
      FileUtils.d(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (VersionUtils.d()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPlusManager", 2, "[updateStickerResource] isDelete=" + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.post(new amlr(this, this.jdField_a_of_type_JavaUtilList, paramBoolean));
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.b)
    {
      this.b = false;
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 54
    //   8: iconst_2
    //   9: new 18	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 298
    //   19: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 300	cooperation/photoplus/PhotoPlusManager:jdField_a_of_type_Boolean	Z
    //   36: ifeq +5 -> 41
    //   39: iconst_0
    //   40: ireturn
    //   41: aload_0
    //   42: aload_1
    //   43: invokestatic 304	cooperation/photoplus/sticker/Sticker:parse	(Ljava/lang/String;)Ljava/util/List;
    //   46: putfield 87	cooperation/photoplus/PhotoPlusManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   49: aload_0
    //   50: getfield 87	cooperation/photoplus/PhotoPlusManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   53: ifnonnull +40 -> 93
    //   56: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +12 -> 71
    //   62: ldc 54
    //   64: iconst_2
    //   65: ldc_w 306
    //   68: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: iconst_1
    //   72: ireturn
    //   73: astore_1
    //   74: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq -28 -> 49
    //   80: ldc 54
    //   82: iconst_2
    //   83: ldc_w 308
    //   86: aload_1
    //   87: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   90: goto -41 -> 49
    //   93: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +61 -> 157
    //   99: aload_0
    //   100: getfield 87	cooperation/photoplus/PhotoPlusManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   103: invokeinterface 190 1 0
    //   108: astore_1
    //   109: aload_1
    //   110: invokeinterface 195 1 0
    //   115: ifeq +42 -> 157
    //   118: aload_1
    //   119: invokeinterface 199 1 0
    //   124: checkcast 76	cooperation/photoplus/sticker/Sticker
    //   127: astore_2
    //   128: ldc 54
    //   130: iconst_2
    //   131: new 18	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 313
    //   141: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_2
    //   145: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: goto -45 -> 109
    //   157: aload_0
    //   158: getfield 62	cooperation/photoplus/PhotoPlusManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   161: invokevirtual 68	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   164: invokevirtual 74	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   167: astore_2
    //   168: aload_2
    //   169: invokevirtual 319	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 322	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   177: aload_2
    //   178: ldc 76
    //   180: invokevirtual 325	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Z
    //   183: pop
    //   184: aload_0
    //   185: getfield 87	cooperation/photoplus/PhotoPlusManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   188: invokeinterface 190 1 0
    //   193: astore_3
    //   194: aload_3
    //   195: invokeinterface 195 1 0
    //   200: ifeq +51 -> 251
    //   203: aload_2
    //   204: aload_3
    //   205: invokeinterface 199 1 0
    //   210: checkcast 76	cooperation/photoplus/sticker/Sticker
    //   213: invokevirtual 328	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   216: goto -22 -> 194
    //   219: astore_3
    //   220: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +13 -> 236
    //   226: ldc 54
    //   228: iconst_2
    //   229: ldc_w 330
    //   232: aload_3
    //   233: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aload_1
    //   237: invokevirtual 332	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   240: aload_2
    //   241: invokevirtual 89	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   244: aload_0
    //   245: iconst_1
    //   246: invokevirtual 105	cooperation/photoplus/PhotoPlusManager:a	(Z)V
    //   249: iconst_1
    //   250: ireturn
    //   251: aload_1
    //   252: invokevirtual 335	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   255: aload_1
    //   256: invokevirtual 332	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   259: goto -19 -> 240
    //   262: astore_2
    //   263: aload_1
    //   264: invokevirtual 332	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   267: aload_2
    //   268: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	PhotoPlusManager
    //   0	269	1	paramString	String
    //   127	114	2	localObject1	Object
    //   262	6	2	localObject2	Object
    //   193	12	3	localIterator	Iterator
    //   219	14	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   41	49	73	org/json/JSONException
    //   173	194	219	java/lang/Exception
    //   194	216	219	java/lang/Exception
    //   251	255	219	java/lang/Exception
    //   173	194	262	finally
    //   194	216	262	finally
    //   220	236	262	finally
    //   251	255	262	finally
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.photoplus.PhotoPlusManager
 * JD-Core Version:    0.7.0.1
 */