package com.tencent.mobileqq.profile.like;

import agcf;
import agcg;
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
    if (paramInt <= 0) {
      paramString = null;
    }
    PraiseInfo localPraiseInfo;
    do
    {
      return paramString;
      localPraiseInfo = (PraiseInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(Integer.valueOf(paramInt));
      if (localPraiseInfo == null) {
        break;
      }
      paramString = localPraiseInfo;
    } while (!QLog.isColorLevel());
    QLog.d("PraiseManager", 2, "get praise info from cache, id=" + paramInt);
    return localPraiseInfo;
    if (!this.jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PraiseManager", 2, "start create praise info, id=" + paramInt);
      }
      this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(paramInt));
      ThreadManager.executeOnFileThread(new agcf(this, paramInt, paramBoolean, paramString));
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
        QLog.d("PraiseManager", 2, "createPraiseInfo from local, id=" + paramInt);
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
  
  public void a(String paramString1, String arg2, String paramString3, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PraiseManager", 2, String.format("onDownloadComplete, scid %s, errorcode %d", new Object[] { paramString1, Integer.valueOf(paramInt1) }));
    }
    if ((TextUtils.isEmpty(paramString1)) || (!paramString1.startsWith("praise.android."))) {
      return;
    }
    paramInt2 = a(paramString1);
    synchronized (this.b)
    {
      if (this.b.contains(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PraiseManager", 2, paramString1 + " download completed, remove from download queue.");
        }
        this.b.remove(paramString1);
      }
      if (paramInt1 == 0)
      {
        paramString1 = a(paramInt2).getAbsolutePath();
        ??? = PraiseInfo.a(paramInt2, paramString1 + File.separator + "config.json");
        if (??? != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PraiseManager", 2, "createPraiseInfo after download complete, id=" + paramInt2);
          }
          ???.jdField_c_of_type_JavaLangString = (paramString1 + File.separator + "whiteBlackImg.png");
          ???.d = (paramString1 + File.separator + "colorImg.png");
          ???.e = (paramString1 + File.separator + "goldImg.png");
          if ((b(???)) && (a(???))) {
            this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(Integer.valueOf(paramInt2), ???);
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new PraiseManager.LoadCallback(this, paramInt2, 1, paramString3));
      this.jdField_a_of_type_JavaUtilVector.removeElement(Integer.valueOf(paramInt2));
      return;
    }
  }
  
  boolean a(PraiseInfo paramPraiseInfo)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = 320;
    localOptions.inTargetDensity = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
    Bitmap localBitmap = BubbleManager.a(paramPraiseInfo.jdField_c_of_type_JavaLangString, localOptions);
    if (localBitmap == null) {}
    do
    {
      return false;
      paramPraiseInfo.a = localBitmap;
      localBitmap = BubbleManager.a(paramPraiseInfo.d, localOptions);
    } while (localBitmap == null);
    paramPraiseInfo.b = localBitmap;
    paramPraiseInfo.jdField_c_of_type_AndroidGraphicsBitmap = BubbleManager.a(paramPraiseInfo.e, localOptions);
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
    agcg localagcg = new agcg(this);
    localagcg.b = paramSet.size();
    localagcg.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager$OnPraiseLoadListener = paramOnPraiseLoadListener;
    paramOnPraiseLoadListener = paramSet.iterator();
    while (paramOnPraiseLoadListener.hasNext())
    {
      int i = ((Integer)paramOnPraiseLoadListener.next()).intValue();
      if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(Integer.valueOf(i)) == null)
      {
        a(localagcg);
        a(i, true, "from_load_all");
      }
      else
      {
        localagcg.jdField_a_of_type_Int += 1;
      }
    }
    return localagcg.jdField_a_of_type_Int == paramSet.size();
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