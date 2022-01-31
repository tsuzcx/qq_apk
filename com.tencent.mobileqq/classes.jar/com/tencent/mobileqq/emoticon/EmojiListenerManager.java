package com.tencent.mobileqq.emoticon;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonTabAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class EmojiListenerManager
{
  private static EmojiListenerManager jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager;
  CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  CopyOnWriteArrayList b = new CopyOnWriteArrayList();
  CopyOnWriteArrayList c = new CopyOnWriteArrayList();
  
  public static EmojiListenerManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager == null) {
        jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager = new EmojiListenerManager();
      }
      EmojiListenerManager localEmojiListenerManager = jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager;
      return localEmojiListenerManager;
    }
    finally {}
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    synchronized (this.b)
    {
      this.b.clear();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      EmoticonPackageDownloadListener localEmoticonPackageDownloadListener = (EmoticonPackageDownloadListener)((WeakReference)localIterator.next()).get();
      if (localEmoticonPackageDownloadListener != null) {
        localEmoticonPackageDownloadListener.a(paramEmoticonPackage);
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      if (this.b != null)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          EmoticonPackageDownloadListener localEmoticonPackageDownloadListener = (EmoticonPackageDownloadListener)((WeakReference)localIterator.next()).get();
          if (localEmoticonPackageDownloadListener != null) {
            localEmoticonPackageDownloadListener.b(paramEmoticonPackage, paramInt);
          }
        }
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        EmoticonPackageChangedListener localEmoticonPackageChangedListener = (EmoticonPackageChangedListener)((WeakReference)localIterator.next()).get();
        if (localEmoticonPackageChangedListener != null) {
          localEmoticonPackageChangedListener.a(paramEmoticonPackage, paramInt1, paramInt2);
        }
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.b != null)
    {
      if (paramInt2 != 0) {}
      for (;;)
      {
        synchronized (this.b)
        {
          Iterator localIterator = this.b.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          EmoticonPackageDownloadListener localEmoticonPackageDownloadListener = (EmoticonPackageDownloadListener)((WeakReference)localIterator.next()).get();
          if (localEmoticonPackageDownloadListener == null) {
            continue;
          }
          localEmoticonPackageDownloadListener.a(paramEmoticonPackage, paramInt1, paramInt3);
        }
        paramInt3 = 0;
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      if (this.c != null)
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          EmotionJsonDownloadListener localEmotionJsonDownloadListener = (EmotionJsonDownloadListener)((WeakReference)localIterator.next()).get();
          if (localEmotionJsonDownloadListener != null) {
            localEmotionJsonDownloadListener.a(paramEmoticonPackage, paramInt, paramBundle);
          }
        }
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramEmoticonPackage == null) || (paramQQAppInterface == null)) {
      return;
    }
    if ((paramEmoticonPackage.status == 2) && (EmoticonUtils.a(paramEmoticonPackage.updateFlag))) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_fail", 0, 0, paramEmoticonPackage.epId, "" + paramEmoticonPackage.localVersion, "" + paramEmoticonPackage.latestVersion, "");
    }
    for (;;)
    {
      ((EmoticonManager)paramQQAppInterface.getManager(13)).a(paramEmoticonPackage);
      paramQQAppInterface = this.b.iterator();
      while (paramQQAppInterface.hasNext())
      {
        EmoticonPackageDownloadListener localEmoticonPackageDownloadListener = (EmoticonPackageDownloadListener)((WeakReference)paramQQAppInterface.next()).get();
        if (localEmoticonPackageDownloadListener != null) {
          localEmoticonPackageDownloadListener.a(paramEmoticonPackage, paramInt);
        }
      }
      break;
      paramEmoticonPackage.status = 0;
    }
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, QQAppInterface paramQQAppInterface)
  {
    if (paramEmoticonPackage == null) {}
    do
    {
      return;
      c(paramEmoticonPackage);
      paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
      String str = paramQQAppInterface.getString("LAST_ADD_EMO_PACKAGE", "");
      str = str + "|" + paramEmoticonPackage.epId;
      paramQQAppInterface.edit().putString("LAST_ADD_EMO_PACKAGE", str).commit();
    } while (3 != paramEmoticonPackage.jobType);
    paramQQAppInterface.edit().putBoolean("LAST_ADD_EMO_PACKAGE_MAGIC", true).commit();
  }
  
  public void a(EmoticonPackageChangedListener paramEmoticonPackageChangedListener)
  {
    if (paramEmoticonPackageChangedListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramEmoticonPackageChangedListener) {
          return;
        }
      }
    }
    paramEmoticonPackageChangedListener = new WeakReference(paramEmoticonPackageChangedListener);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramEmoticonPackageChangedListener);
  }
  
  public void a(EmoticonPackageDownloadListener paramEmoticonPackageDownloadListener)
  {
    if (paramEmoticonPackageDownloadListener == null) {
      return;
    }
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramEmoticonPackageDownloadListener) {
          return;
        }
      }
    }
    paramEmoticonPackageDownloadListener = new WeakReference(paramEmoticonPackageDownloadListener);
    this.b.add(paramEmoticonPackageDownloadListener);
  }
  
  public void a(EmotionJsonDownloadListener paramEmotionJsonDownloadListener)
  {
    if (paramEmotionJsonDownloadListener == null) {
      return;
    }
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramEmotionJsonDownloadListener) {
          return;
        }
      }
    }
    paramEmotionJsonDownloadListener = new WeakReference(paramEmotionJsonDownloadListener);
    this.c.add(paramEmotionJsonDownloadListener);
  }
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      EmoticonTabAdapter.a(paramEmoticonPackage.epId);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        EmoticonPackageChangedListener localEmoticonPackageChangedListener = (EmoticonPackageChangedListener)((WeakReference)localIterator.next()).get();
        if (localEmoticonPackageChangedListener != null) {
          localEmoticonPackageChangedListener.a(paramEmoticonPackage);
        }
      }
    }
  }
  
  public void b(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        EmoticonPackageDownloadListener localEmoticonPackageDownloadListener = (EmoticonPackageDownloadListener)((WeakReference)localIterator.next()).get();
        if (localEmoticonPackageDownloadListener != null) {
          localEmoticonPackageDownloadListener.b(paramEmoticonPackage, paramInt1, paramInt2);
        }
      }
    }
  }
  
  public void b(EmoticonPackageChangedListener paramEmoticonPackageChangedListener)
  {
    if (paramEmoticonPackageChangedListener == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramEmoticonPackageChangedListener) {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
        }
      }
    }
  }
  
  public void b(EmoticonPackageDownloadListener paramEmoticonPackageDownloadListener)
  {
    if (paramEmoticonPackageDownloadListener == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramEmoticonPackageDownloadListener) {
          this.b.remove(localWeakReference);
        }
      }
    }
  }
  
  public void b(EmotionJsonDownloadListener paramEmotionJsonDownloadListener)
  {
    if (paramEmotionJsonDownloadListener == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramEmotionJsonDownloadListener) {
          this.c.remove(localWeakReference);
        }
      }
    }
  }
  
  protected void c(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        EmoticonPackageChangedListener localEmoticonPackageChangedListener = (EmoticonPackageChangedListener)((WeakReference)localIterator.next()).get();
        if (localEmoticonPackageChangedListener != null) {
          localEmoticonPackageChangedListener.b(paramEmoticonPackage);
        }
      }
    }
  }
  
  protected void d(EmoticonPackage paramEmoticonPackage)
  {
    EmoticonTabAdapter.a(paramEmoticonPackage.epId);
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        EmoticonPackageDownloadListener localEmoticonPackageDownloadListener = (EmoticonPackageDownloadListener)((WeakReference)localIterator.next()).get();
        if (localEmoticonPackageDownloadListener != null) {
          localEmoticonPackageDownloadListener.a(paramEmoticonPackage, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiListenerManager
 * JD-Core Version:    0.7.0.1
 */