package com.tencent.mobileqq.profile.like;

import aguu;
import aguv;
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
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
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
  public QQLruCache a;
  public QQAppInterface a;
  public final List a;
  public final Vector a;
  public final List b;
  
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
      ThreadManager.executeOnFileThread(new aguu(this, paramInt, paramBoolean, paramString));
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
    VasQuickUpdateManager localVasQuickUpdateManager;
    do
    {
      return;
      str = "praise.android." + paramInt + "." + "config.zip";
      localVasQuickUpdateManager = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(183);
    } while (localVasQuickUpdateManager == null);
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
    localVasQuickUpdateManager.a(20L, str, paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean, String paramString)
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
    //   0: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +31 -> 34
    //   6: ldc 141
    //   8: iconst_2
    //   9: ldc_w 326
    //   12: iconst_2
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload_1
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: iload 4
    //   24: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: invokestatic 330	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   31: invokestatic 333	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_1
    //   35: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifne +322 -> 360
    //   41: aload_1
    //   42: ldc 215
    //   44: invokevirtual 337	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   47: ifne +4 -> 51
    //   50: return
    //   51: aload_0
    //   52: aload_1
    //   53: invokevirtual 339	com/tencent/mobileqq/profile/like/PraiseManager:a	(Ljava/lang/String;)I
    //   56: istore 5
    //   58: aload_0
    //   59: getfield 57	com/tencent/mobileqq/profile/like/PraiseManager:b	Ljava/util/List;
    //   62: astore_2
    //   63: aload_2
    //   64: monitorenter
    //   65: aload_0
    //   66: getfield 57	com/tencent/mobileqq/profile/like/PraiseManager:b	Ljava/util/List;
    //   69: aload_1
    //   70: invokeinterface 228 2 0
    //   75: ifeq +46 -> 121
    //   78: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +29 -> 110
    //   84: ldc 141
    //   86: iconst_2
    //   87: new 75	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   94: aload_1
    //   95: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc_w 341
    //   101: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_0
    //   111: getfield 57	com/tencent/mobileqq/profile/like/PraiseManager:b	Ljava/util/List;
    //   114: aload_1
    //   115: invokeinterface 344 2 0
    //   120: pop
    //   121: aload_2
    //   122: monitorexit
    //   123: iload 4
    //   125: ifne +185 -> 310
    //   128: aload_0
    //   129: iload 5
    //   131: invokevirtual 241	com/tencent/mobileqq/profile/like/PraiseManager:a	(I)Ljava/io/File;
    //   134: invokevirtual 244	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   137: astore_1
    //   138: iload 5
    //   140: invokestatic 249	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: getstatic 253	java/io/File:separator	Ljava/lang/String;
    //   150: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc 255
    //   155: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 258	com/tencent/mobileqq/profile/like/PraiseInfo:a	(ILjava/lang/String;)Lcom/tencent/mobileqq/profile/like/PraiseInfo;
    //   164: astore_2
    //   165: aload_2
    //   166: ifnull +144 -> 310
    //   169: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +30 -> 202
    //   175: ldc 141
    //   177: iconst_2
    //   178: new 75	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 346
    //   188: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: iload 5
    //   193: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: aload_2
    //   203: invokestatic 249	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   206: aload_1
    //   207: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: getstatic 253	java/io/File:separator	Ljava/lang/String;
    //   213: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc_w 262
    //   219: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: putfield 265	com/tencent/mobileqq/profile/like/PraiseInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   228: aload_2
    //   229: invokestatic 249	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   232: aload_1
    //   233: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: getstatic 253	java/io/File:separator	Ljava/lang/String;
    //   239: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc_w 267
    //   245: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: putfield 269	com/tencent/mobileqq/profile/like/PraiseInfo:d	Ljava/lang/String;
    //   254: aload_2
    //   255: invokestatic 249	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   258: aload_1
    //   259: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: getstatic 253	java/io/File:separator	Ljava/lang/String;
    //   265: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc_w 271
    //   271: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: putfield 273	com/tencent/mobileqq/profile/like/PraiseInfo:e	Ljava/lang/String;
    //   280: aload_0
    //   281: aload_2
    //   282: invokevirtual 276	com/tencent/mobileqq/profile/like/PraiseManager:b	(Lcom/tencent/mobileqq/profile/like/PraiseInfo;)Z
    //   285: ifeq +25 -> 310
    //   288: aload_0
    //   289: aload_2
    //   290: invokevirtual 296	com/tencent/mobileqq/profile/like/PraiseManager:a	(Lcom/tencent/mobileqq/profile/like/PraiseInfo;)Z
    //   293: ifeq +17 -> 310
    //   296: aload_0
    //   297: getfield 42	com/tencent/mobileqq/profile/like/PraiseManager:jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   300: iload 5
    //   302: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   305: aload_2
    //   306: invokevirtual 300	com/tencent/commonsdk/cache/QQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   309: pop
    //   310: aload_0
    //   311: getfield 20	com/tencent/mobileqq/profile/like/PraiseManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   314: new 280	com/tencent/mobileqq/profile/like/PraiseManager$LoadCallback
    //   317: dup
    //   318: aload_0
    //   319: iload 5
    //   321: iconst_1
    //   322: aload_3
    //   323: invokespecial 283	com/tencent/mobileqq/profile/like/PraiseManager$LoadCallback:<init>	(Lcom/tencent/mobileqq/profile/like/PraiseManager;IILjava/lang/String;)V
    //   326: invokevirtual 286	com/tencent/mobileqq/app/QQAppInterface:runOnUiThread	(Ljava/lang/Runnable;)V
    //   329: aload_0
    //   330: getfield 47	com/tencent/mobileqq/profile/like/PraiseManager:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   333: iload 5
    //   335: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   338: invokevirtual 289	java/util/Vector:removeElement	(Ljava/lang/Object;)Z
    //   341: pop
    //   342: return
    //   343: astore_1
    //   344: ldc 141
    //   346: iconst_1
    //   347: ldc_w 348
    //   350: aload_1
    //   351: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   354: return
    //   355: astore_1
    //   356: aload_2
    //   357: monitorexit
    //   358: aload_1
    //   359: athrow
    //   360: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	PraiseManager
    //   0	361	1	paramString1	String
    //   0	361	3	paramString3	String
    //   0	361	4	paramInt1	int
    //   0	361	5	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   0	34	343	java/lang/Exception
    //   34	50	343	java/lang/Exception
    //   51	65	343	java/lang/Exception
    //   128	165	343	java/lang/Exception
    //   169	202	343	java/lang/Exception
    //   202	310	343	java/lang/Exception
    //   310	342	343	java/lang/Exception
    //   358	360	343	java/lang/Exception
    //   65	110	355	finally
    //   110	121	355	finally
    //   121	123	355	finally
    //   356	358	355	finally
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
  
  public boolean a(Set paramSet, PraiseManager.OnPraiseLoadListener paramOnPraiseLoadListener)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return true;
    }
    aguv localaguv = new aguv(this);
    localaguv.b = paramSet.size();
    localaguv.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager$OnPraiseLoadListener = paramOnPraiseLoadListener;
    paramOnPraiseLoadListener = paramSet.iterator();
    while (paramOnPraiseLoadListener.hasNext())
    {
      int i = ((Integer)paramOnPraiseLoadListener.next()).intValue();
      if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(Integer.valueOf(i)) == null)
      {
        a(localaguv);
        a(i, true, "from_load_all");
      }
      else
      {
        localaguv.jdField_a_of_type_Int += 1;
      }
    }
    return localaguv.jdField_a_of_type_Int == paramSet.size();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.like.PraiseManager
 * JD-Core Version:    0.7.0.1
 */