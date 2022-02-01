package com.tencent.mobileqq.profile.like;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class PraiseManager
  implements Manager
{
  public Context a;
  public QQLruCache<Integer, PraiseInfo> a;
  public QQAppInterface a;
  public final List<WeakReference<PraiseManager.OnPraiseLoadListener>> a;
  public final Vector<Integer> a;
  public final List<String> b;
  
  public PraiseManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramQQAppInterface.getApp().getApplicationContext();
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(2007, 21, 120000);
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_JavaUtilList = new ArrayList(3);
    this.b = new ArrayList();
  }
  
  public static int a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return 0;
    }
    return paramAppInterface.getApplication().getSharedPreferences("VipPersonalLike", 0).getInt("ProfilePersonalLikeCurrentId_" + paramAppInterface.getCurrentAccountUin(), 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.getApplication().getSharedPreferences("VipPersonalLike", 0).edit().putInt("ProfilePersonalLikeCurrentId_" + paramQQAppInterface.getCurrentAccountUin(), paramInt).commit();
  }
  
  public int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("\\.");
      if (paramString.length == 5)
      {
        paramString = paramString[2];
        try
        {
          int i = Integer.parseInt(paramString);
          return i;
        }
        catch (NumberFormatException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PraiseManager", 2, "getBubbleIdFromScid: parse bubbleId error", paramString);
          }
        }
      }
    }
    return 0;
  }
  
  public PraiseInfo a(int paramInt, boolean paramBoolean, String paramString)
  {
    Object localObject;
    if (paramInt <= 0) {
      localObject = null;
    }
    PraiseInfo localPraiseInfo;
    do
    {
      return localObject;
      localPraiseInfo = (PraiseInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(Integer.valueOf(paramInt));
      if (localPraiseInfo == null) {
        break;
      }
      localObject = localPraiseInfo;
    } while (!QLog.isColorLevel());
    QLog.d("PraiseManager", 2, "get praise info from cache, id=" + paramInt + " from:" + paramString);
    return localPraiseInfo;
    if (!this.jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PraiseManager", 2, "start create praise info, id=" + paramInt);
      }
      this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(paramInt));
      ThreadManager.executeOnFileThread(new PraiseManager.1(this, paramInt, paramBoolean, paramString));
    }
    return null;
  }
  
  public File a(int paramInt)
  {
    File localFile = new File(new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "praise_info"), String.valueOf(paramInt));
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {}
    String str;
    IVasQuickUpdateService localIVasQuickUpdateService;
    do
    {
      return;
      str = "praise.android." + paramInt + "." + "config.zip";
      localIVasQuickUpdateService = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    } while (localIVasQuickUpdateService == null);
    synchronized (this.b)
    {
      if (this.b.contains(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PraiseManager", 2, str + " is downloading, remove duplicate download.");
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PraiseManager", 2, str + " is not download, start download.");
    }
    this.b.add(str);
    localIVasQuickUpdateService.downloadItem(20L, str, paramString);
  }
  
  void a(int paramInt, boolean paramBoolean, String paramString)
  {
    String str = a(paramInt).getAbsolutePath();
    PraiseInfo localPraiseInfo = PraiseInfo.a(paramInt, str + File.separator + "config.json");
    Boolean localBoolean = null;
    if (localPraiseInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PraiseManager", 2, "createPraiseInfo from local, id=" + paramInt + " from:" + paramString);
      }
      localPraiseInfo.jdField_c_of_type_JavaLangString = (str + File.separator + "whiteBlackImg.png");
      localPraiseInfo.d = (str + File.separator + "colorImg.png");
      localPraiseInfo.e = (str + File.separator + "goldImg.png");
      if (!b(localPraiseInfo)) {
        if (paramBoolean) {
          a(paramInt, paramString);
        }
      }
    }
    for (;;)
    {
      if (localBoolean != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new PraiseManager.LoadCallback(this, paramInt, 0, paramString));
        this.jdField_a_of_type_JavaUtilVector.removeElement(Integer.valueOf(paramInt));
      }
      return;
      localBoolean = Boolean.valueOf(false);
      continue;
      if (a(localPraiseInfo))
      {
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(Integer.valueOf(paramInt), localPraiseInfo);
        localBoolean = Boolean.valueOf(true);
      }
      else
      {
        localBoolean = Boolean.valueOf(false);
        continue;
        if (paramBoolean) {
          a(paramInt, paramString);
        } else {
          localBoolean = Boolean.valueOf(false);
        }
      }
    }
  }
  
  public void a(PraiseManager.OnPraiseLoadListener paramOnPraiseLoadListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() == paramOnPraiseLoadListener)) {
          return;
        }
      }
      this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramOnPraiseLoadListener));
      return;
    }
  }
  
  /* Error */
  public void a(String paramString1, String arg2, String paramString3, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +31 -> 34
    //   6: ldc 145
    //   8: iconst_2
    //   9: ldc_w 333
    //   12: iconst_2
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload_1
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: iload 4
    //   24: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: invokestatic 337	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   31: invokestatic 340	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_1
    //   35: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifne +323 -> 361
    //   41: aload_1
    //   42: ldc 219
    //   44: invokevirtual 344	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   47: ifne +4 -> 51
    //   50: return
    //   51: aload_0
    //   52: aload_1
    //   53: invokevirtual 346	com/tencent/mobileqq/profile/like/PraiseManager:a	(Ljava/lang/String;)I
    //   56: istore 5
    //   58: aload_0
    //   59: getfield 61	com/tencent/mobileqq/profile/like/PraiseManager:b	Ljava/util/List;
    //   62: astore_2
    //   63: aload_2
    //   64: monitorenter
    //   65: aload_0
    //   66: getfield 61	com/tencent/mobileqq/profile/like/PraiseManager:b	Ljava/util/List;
    //   69: aload_1
    //   70: invokeinterface 234 2 0
    //   75: ifeq +46 -> 121
    //   78: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +29 -> 110
    //   84: ldc 145
    //   86: iconst_2
    //   87: new 79	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   94: aload_1
    //   95: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc_w 348
    //   101: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_0
    //   111: getfield 61	com/tencent/mobileqq/profile/like/PraiseManager:b	Ljava/util/List;
    //   114: aload_1
    //   115: invokeinterface 351 2 0
    //   120: pop
    //   121: aload_2
    //   122: monitorexit
    //   123: iload 4
    //   125: ifne +186 -> 311
    //   128: aload_0
    //   129: iload 5
    //   131: invokevirtual 248	com/tencent/mobileqq/profile/like/PraiseManager:a	(I)Ljava/io/File;
    //   134: invokevirtual 251	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   137: astore_1
    //   138: iload 5
    //   140: invokestatic 256	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: getstatic 260	java/io/File:separator	Ljava/lang/String;
    //   150: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc_w 262
    //   156: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 265	com/tencent/mobileqq/profile/like/PraiseInfo:a	(ILjava/lang/String;)Lcom/tencent/mobileqq/profile/like/PraiseInfo;
    //   165: astore_2
    //   166: aload_2
    //   167: ifnull +144 -> 311
    //   170: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +30 -> 203
    //   176: ldc 145
    //   178: iconst_2
    //   179: new 79	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   186: ldc_w 353
    //   189: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: iload 5
    //   194: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aload_2
    //   204: invokestatic 256	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   207: aload_1
    //   208: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: getstatic 260	java/io/File:separator	Ljava/lang/String;
    //   214: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc_w 269
    //   220: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: putfield 272	com/tencent/mobileqq/profile/like/PraiseInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   229: aload_2
    //   230: invokestatic 256	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   233: aload_1
    //   234: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: getstatic 260	java/io/File:separator	Ljava/lang/String;
    //   240: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc_w 274
    //   246: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: putfield 276	com/tencent/mobileqq/profile/like/PraiseInfo:d	Ljava/lang/String;
    //   255: aload_2
    //   256: invokestatic 256	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   259: aload_1
    //   260: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: getstatic 260	java/io/File:separator	Ljava/lang/String;
    //   266: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc_w 278
    //   272: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: putfield 280	com/tencent/mobileqq/profile/like/PraiseInfo:e	Ljava/lang/String;
    //   281: aload_0
    //   282: aload_2
    //   283: invokevirtual 283	com/tencent/mobileqq/profile/like/PraiseManager:b	(Lcom/tencent/mobileqq/profile/like/PraiseInfo;)Z
    //   286: ifeq +25 -> 311
    //   289: aload_0
    //   290: aload_2
    //   291: invokevirtual 303	com/tencent/mobileqq/profile/like/PraiseManager:a	(Lcom/tencent/mobileqq/profile/like/PraiseInfo;)Z
    //   294: ifeq +17 -> 311
    //   297: aload_0
    //   298: getfield 46	com/tencent/mobileqq/profile/like/PraiseManager:jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   301: iload 5
    //   303: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   306: aload_2
    //   307: invokevirtual 307	com/tencent/commonsdk/cache/QQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   310: pop
    //   311: aload_0
    //   312: getfield 24	com/tencent/mobileqq/profile/like/PraiseManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   315: new 287	com/tencent/mobileqq/profile/like/PraiseManager$LoadCallback
    //   318: dup
    //   319: aload_0
    //   320: iload 5
    //   322: iconst_1
    //   323: aload_3
    //   324: invokespecial 290	com/tencent/mobileqq/profile/like/PraiseManager$LoadCallback:<init>	(Lcom/tencent/mobileqq/profile/like/PraiseManager;IILjava/lang/String;)V
    //   327: invokevirtual 293	com/tencent/mobileqq/app/QQAppInterface:runOnUiThread	(Ljava/lang/Runnable;)V
    //   330: aload_0
    //   331: getfield 51	com/tencent/mobileqq/profile/like/PraiseManager:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   334: iload 5
    //   336: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   339: invokevirtual 296	java/util/Vector:removeElement	(Ljava/lang/Object;)Z
    //   342: pop
    //   343: return
    //   344: astore_1
    //   345: ldc 145
    //   347: iconst_1
    //   348: ldc_w 355
    //   351: aload_1
    //   352: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   355: return
    //   356: astore_1
    //   357: aload_2
    //   358: monitorexit
    //   359: aload_1
    //   360: athrow
    //   361: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	PraiseManager
    //   0	362	1	paramString1	String
    //   0	362	3	paramString3	String
    //   0	362	4	paramInt1	int
    //   0	362	5	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   0	34	344	java/lang/Exception
    //   34	50	344	java/lang/Exception
    //   51	65	344	java/lang/Exception
    //   128	166	344	java/lang/Exception
    //   170	203	344	java/lang/Exception
    //   203	311	344	java/lang/Exception
    //   311	343	344	java/lang/Exception
    //   359	361	344	java/lang/Exception
    //   65	110	356	finally
    //   110	121	356	finally
    //   121	123	356	finally
    //   357	359	356	finally
  }
  
  boolean a(PraiseInfo paramPraiseInfo)
  {
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inDensity = 320;
    ((BitmapFactory.Options)localObject1).inTargetDensity = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
    Object localObject2 = BubbleManager.a(paramPraiseInfo.jdField_c_of_type_JavaLangString, (BitmapFactory.Options)localObject1);
    if (localObject2 == null) {}
    do
    {
      return false;
      paramPraiseInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
      localObject2 = BubbleManager.a(paramPraiseInfo.d, (BitmapFactory.Options)localObject1);
    } while (localObject2 == null);
    paramPraiseInfo.b = ((Bitmap)localObject2);
    paramPraiseInfo.jdField_c_of_type_AndroidGraphicsBitmap = BubbleManager.a(paramPraiseInfo.e, (BitmapFactory.Options)localObject1);
    localObject1 = a(paramPraiseInfo.jdField_a_of_type_Int).getAbsolutePath();
    localObject2 = (String)localObject1 + File.separator + "dynamicImg.png";
    if (new File((String)localObject2).exists()) {
      paramPraiseInfo.f = ((String)localObject2);
    }
    localObject1 = (String)localObject1 + File.separator + "goldDynamicImg.png";
    if (new File((String)localObject1).exists()) {
      paramPraiseInfo.g = ((String)localObject1);
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PraiseManager", 2, "scid isFileExists: " + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("praise.android."))) {}
    do
    {
      int i;
      do
      {
        return false;
        i = a(paramString);
      } while (i <= 0);
      paramString = a(i);
    } while ((!new File(paramString, "config.json").exists()) || (!new File(paramString, "whiteBlackImg.png").exists()) || (!new File(paramString, "colorImg.png").exists()));
    return true;
  }
  
  public boolean a(Set<Integer> paramSet, PraiseManager.OnPraiseLoadListener paramOnPraiseLoadListener)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return true;
    }
    PraiseManager.PraiseLoadListener localPraiseLoadListener = new PraiseManager.PraiseLoadListener(this);
    localPraiseLoadListener.b = paramSet.size();
    localPraiseLoadListener.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager$OnPraiseLoadListener = paramOnPraiseLoadListener;
    paramOnPraiseLoadListener = paramSet.iterator();
    while (paramOnPraiseLoadListener.hasNext())
    {
      int i = ((Integer)paramOnPraiseLoadListener.next()).intValue();
      if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(Integer.valueOf(i)) == null)
      {
        a(localPraiseLoadListener);
        a(i, true, "from_load_all");
      }
      else
      {
        localPraiseLoadListener.jdField_a_of_type_Int += 1;
      }
    }
    return localPraiseLoadListener.jdField_a_of_type_Int == paramSet.size();
  }
  
  public void b(PraiseManager.OnPraiseLoadListener paramOnPraiseLoadListener)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    Object localObject = null;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference != null) && (localWeakReference.get() == paramOnPraiseLoadListener)) {
            localObject = localWeakReference;
          }
        }
        else
        {
          this.jdField_a_of_type_JavaUtilList.remove(localObject);
          return;
        }
      }
      finally {}
    }
  }
  
  boolean b(PraiseInfo paramPraiseInfo)
  {
    return (new File(paramPraiseInfo.jdField_c_of_type_JavaLangString).exists()) && (new File(paramPraiseInfo.d).exists());
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.like.PraiseManager
 * JD-Core Version:    0.7.0.1
 */