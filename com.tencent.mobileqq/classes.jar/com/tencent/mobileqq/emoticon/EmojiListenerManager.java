package com.tencent.mobileqq.emoticon;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonTabAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.ipc.EmoticonMainPanelIpcModule;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class EmojiListenerManager
{
  private static EmojiListenerManager jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager;
  CopyOnWriteArrayList<WeakReference<EmoticonPackageChangedListener>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  CopyOnWriteArrayList<WeakReference<EmoticonPackageDownloadListener>> b = new CopyOnWriteArrayList();
  CopyOnWriteArrayList<WeakReference<EmotionJsonDownloadListener>> c = new CopyOnWriteArrayList();
  
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
      if (QQEmoticonMainPanelApp.isMainProcess())
      {
        ??? = new Bundle();
        ((Bundle)???).putString("module_emoticon_child_mainpanel", "emojilistener_destory");
        EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)???);
      }
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmoticonPackageDownloadListener localEmoticonPackageDownloadListener = (EmoticonPackageDownloadListener)((WeakReference)((Iterator)localObject).next()).get();
      if (localEmoticonPackageDownloadListener != null) {
        localEmoticonPackageDownloadListener.onPackageStart(paramEmoticonPackage);
      }
    }
    if (QQEmoticonMainPanelApp.isMainProcess())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("module_emoticon_child_mainpanel", "emojilistener_packagestart");
      ((Bundle)localObject).putSerializable("paramter_one", paramEmoticonPackage);
      EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)localObject);
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (paramEmoticonPackage == null) {}
    do
    {
      return;
      if (this.b != null)
      {
        localObject = this.b.iterator();
        while (((Iterator)localObject).hasNext())
        {
          EmoticonPackageDownloadListener localEmoticonPackageDownloadListener = (EmoticonPackageDownloadListener)((WeakReference)((Iterator)localObject).next()).get();
          if (localEmoticonPackageDownloadListener != null) {
            localEmoticonPackageDownloadListener.onJsonComplete(paramEmoticonPackage, paramInt);
          }
        }
      }
    } while (!QQEmoticonMainPanelApp.isMainProcess());
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("module_emoticon_child_mainpanel", "emojilistener_emoticonjson");
    ((Bundle)localObject).putSerializable("paramter_one", paramEmoticonPackage);
    ((Bundle)localObject).putInt("paramter_two", paramInt);
    EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)localObject);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackageChangedListener localEmoticonPackageChangedListener = (EmoticonPackageChangedListener)((WeakReference)((Iterator)localObject).next()).get();
        if (localEmoticonPackageChangedListener != null) {
          localEmoticonPackageChangedListener.onPackageMoved(paramEmoticonPackage, paramInt1, paramInt2);
        }
      }
    } while (!QQEmoticonMainPanelApp.isMainProcess());
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("module_emoticon_child_mainpanel", "emojilistener_packagemoved");
    ((Bundle)localObject).putSerializable("paramter_one", paramEmoticonPackage);
    ((Bundle)localObject).putInt("paramter_two", paramInt1);
    ((Bundle)localObject).putInt("paramter_three", paramInt2);
    EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)localObject);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.b != null)
    {
      if (paramInt2 != 0) {}
      for (int i = paramInt3;; i = 0) {
        synchronized (this.b)
        {
          Iterator localIterator = this.b.iterator();
          EmoticonPackageDownloadListener localEmoticonPackageDownloadListener;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localEmoticonPackageDownloadListener = (EmoticonPackageDownloadListener)((WeakReference)localIterator.next()).get();
          } while (localEmoticonPackageDownloadListener == null);
          localEmoticonPackageDownloadListener.onCoverComplete(paramEmoticonPackage, paramInt1, i);
        }
      }
    }
    if (QQEmoticonMainPanelApp.isMainProcess())
    {
      ??? = new Bundle();
      ((Bundle)???).putString("module_emoticon_child_mainpanel", "emojilistener_emoticoncover");
      ((Bundle)???).putSerializable("paramter_one", paramEmoticonPackage);
      ((Bundle)???).putInt("paramter_two", paramInt1);
      ((Bundle)???).putInt("paramter_three", paramInt2);
      ((Bundle)???).putInt("paramter_four", paramInt3);
      EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)???);
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface)
  {
    if (paramEmoticonPackage == null) {}
    do
    {
      return;
      if (!QQEmoticonMainPanelApp.isMainProcess()) {
        break;
      }
    } while (paramQQAppInterface == null);
    if ((paramEmoticonPackage.status == 2) && (EmoticonUtils.isEmoticonPkgUpdateBitSet(paramEmoticonPackage.updateFlag)))
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_fail", 0, 0, paramEmoticonPackage.epId, "" + paramEmoticonPackage.localVersion, "" + paramEmoticonPackage.latestVersion, "");
      label101:
      if ((paramInt1 != 19) && (paramInt1 != 20))
      {
        SLog.e("EmojiListenerManager", "notifyPackageFail ep.id=" + paramEmoticonPackage.epId + " error: " + paramInt1);
        ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramEmoticonPackage);
      }
      if (paramEmoticonPackage.type != 1) {
        break label294;
      }
    }
    label294:
    for (int i = 5;; i = 4)
    {
      EmoticonManager.e(String.valueOf(paramInt2), i);
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putString("module_emoticon_child_mainpanel", "emojilistener_packagefail");
      paramQQAppInterface.putSerializable("paramter_one", paramEmoticonPackage);
      paramQQAppInterface.putInt("paramter_two", paramInt1);
      paramQQAppInterface.putInt("paramter_three", paramInt2);
      EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle(paramQQAppInterface);
      paramQQAppInterface = this.b.iterator();
      while (paramQQAppInterface.hasNext())
      {
        EmoticonPackageDownloadListener localEmoticonPackageDownloadListener = (EmoticonPackageDownloadListener)((WeakReference)paramQQAppInterface.next()).get();
        if (localEmoticonPackageDownloadListener != null) {
          localEmoticonPackageDownloadListener.onPackageEnd(paramEmoticonPackage, paramInt2);
        }
      }
      break;
      paramEmoticonPackage.status = 0;
      break label101;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (paramEmoticonPackage == null) {}
    do
    {
      return;
      if (this.c != null)
      {
        localObject = this.c.iterator();
        while (((Iterator)localObject).hasNext())
        {
          EmotionJsonDownloadListener localEmotionJsonDownloadListener = (EmotionJsonDownloadListener)((WeakReference)((Iterator)localObject).next()).get();
          if (localEmotionJsonDownloadListener != null) {
            localEmotionJsonDownloadListener.a(paramEmoticonPackage, paramInt, paramBundle);
          }
        }
      }
    } while (!QQEmoticonMainPanelApp.isMainProcess());
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("module_emoticon_child_mainpanel", "emojilistener_loadend");
    ((Bundle)localObject).putSerializable("paramter_one", paramEmoticonPackage);
    ((Bundle)localObject).putInt("paramter_two", paramInt);
    ((Bundle)localObject).putBundle("paramter_three", paramBundle);
    EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)localObject);
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, int paramInt, QQAppInterface paramQQAppInterface)
  {
    a(paramEmoticonPackage, -1, paramInt, paramQQAppInterface);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, QQAppInterface paramQQAppInterface)
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
      if (3 == paramEmoticonPackage.jobType) {
        paramQQAppInterface.edit().putBoolean("LAST_ADD_EMO_PACKAGE_MAGIC", true).commit();
      }
    } while (!QQEmoticonMainPanelApp.isMainProcess());
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putString("module_emoticon_child_mainpanel", "emojilistener_packageadded");
    paramQQAppInterface.putSerializable("paramter_one", paramEmoticonPackage);
    EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle(paramQQAppInterface);
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
    do
    {
      return;
      EmoticonTabAdapter.removeTabDrawableCache(paramEmoticonPackage.epId);
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackageChangedListener localEmoticonPackageChangedListener = (EmoticonPackageChangedListener)((WeakReference)((Iterator)localObject).next()).get();
        if (localEmoticonPackageChangedListener != null) {
          localEmoticonPackageChangedListener.onPackageDeleted(paramEmoticonPackage);
        }
      }
    } while (!QQEmoticonMainPanelApp.isMainProcess());
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("module_emoticon_child_mainpanel", "emojilistener_packagedeleted");
    ((Bundle)localObject).putSerializable("paramter_one", paramEmoticonPackage);
    EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)localObject);
  }
  
  public void b(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {}
    do
    {
      return;
      synchronized (this.b)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          EmoticonPackageDownloadListener localEmoticonPackageDownloadListener = (EmoticonPackageDownloadListener)((WeakReference)localIterator.next()).get();
          if (localEmoticonPackageDownloadListener != null) {
            localEmoticonPackageDownloadListener.onPackageProgress(paramEmoticonPackage, paramInt1, paramInt2);
          }
        }
      }
    } while (!QQEmoticonMainPanelApp.isMainProcess());
    ??? = new Bundle();
    ((Bundle)???).putString("module_emoticon_child_mainpanel", "emojilistener_package_progress");
    ((Bundle)???).putSerializable("paramter_one", paramEmoticonPackage);
    ((Bundle)???).putInt("paramter_two", paramInt1);
    ((Bundle)???).putInt("paramter_three", paramInt2);
    EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)???);
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
  
  public void c(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    if (QQEmoticonMainPanelApp.isMainProcess()) {
      if (paramEmoticonPackage.type != 1) {
        break label109;
      }
    }
    label109:
    for (int i = 5;; i = 4)
    {
      EmoticonManager.c("0", i);
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("module_emoticon_child_mainpanel", "emojilistener_packageadded_one");
      ((Bundle)localObject).putSerializable("paramter_one", paramEmoticonPackage);
      EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)localObject);
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackageChangedListener localEmoticonPackageChangedListener = (EmoticonPackageChangedListener)((WeakReference)((Iterator)localObject).next()).get();
        if (localEmoticonPackageChangedListener != null) {
          localEmoticonPackageChangedListener.onPackageAdded(paramEmoticonPackage);
        }
      }
      break;
    }
  }
  
  public void d(EmoticonPackage paramEmoticonPackage)
  {
    if (QQEmoticonMainPanelApp.isMainProcess())
    {
      EmoticonTabAdapter.removeTabDrawableCache(paramEmoticonPackage.epId);
      if (paramEmoticonPackage.type != 1) {
        break label125;
      }
    }
    label125:
    for (int i = 5;; i = 4)
    {
      EmoticonManager.e("0", i);
      ??? = new Bundle();
      ((Bundle)???).putString("module_emoticon_child_mainpanel", "emojilistener_packagesucc");
      ((Bundle)???).putSerializable("paramter_one", paramEmoticonPackage);
      EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)???);
      synchronized (this.b)
      {
        Iterator localIterator = this.b.iterator();
        EmoticonPackageDownloadListener localEmoticonPackageDownloadListener;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localEmoticonPackageDownloadListener = (EmoticonPackageDownloadListener)((WeakReference)localIterator.next()).get();
        } while (localEmoticonPackageDownloadListener == null);
        localEmoticonPackageDownloadListener.onPackageEnd(paramEmoticonPackage, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiListenerManager
 * JD-Core Version:    0.7.0.1
 */