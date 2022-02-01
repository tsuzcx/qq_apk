package com.tencent.mobileqq.emoticon;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonTabAdapter;
import com.tencent.mobileqq.emoticonview.ipc.EmoticonMainPanelIpcModule;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;

public class EmojiListenerManager
  implements IEmojiListenerManager
{
  private static EmojiListenerManager d;
  CopyOnWriteArrayList<WeakReference<EmoticonPackageChangedListener>> a = new CopyOnWriteArrayList();
  CopyOnWriteArrayList<WeakReference<EmoticonPackageDownloadListener>> b = new CopyOnWriteArrayList();
  CopyOnWriteArrayList<WeakReference<EmotionJsonDownloadListener>> c = new CopyOnWriteArrayList();
  
  public static EmojiListenerManager a()
  {
    try
    {
      if (d == null) {
        d = new EmojiListenerManager();
      }
      EmojiListenerManager localEmojiListenerManager = d;
      return localEmojiListenerManager;
    }
    finally {}
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    EmoticonTabAdapter.removeTabDrawableCache(paramEmoticonPackage.epId);
    Object localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmoticonPackageChangedListener localEmoticonPackageChangedListener = (EmoticonPackageChangedListener)((WeakReference)((Iterator)localObject).next()).get();
      if (localEmoticonPackageChangedListener != null) {
        localEmoticonPackageChangedListener.onPackageDeleted(paramEmoticonPackage);
      }
    }
    if (EmotionUtils.a())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("module_emoticon_child_mainpanel", "emojilistener_packagedeleted");
      ((Bundle)localObject).putSerializable("paramter_one", paramEmoticonPackage);
      EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)localObject);
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((CopyOnWriteArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackageDownloadListener localEmoticonPackageDownloadListener = (EmoticonPackageDownloadListener)((WeakReference)((Iterator)localObject).next()).get();
        if (localEmoticonPackageDownloadListener != null) {
          localEmoticonPackageDownloadListener.onJsonComplete(paramEmoticonPackage, paramInt);
        }
      }
    }
    if (EmotionUtils.a())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("module_emoticon_child_mainpanel", "emojilistener_emoticonjson");
      ((Bundle)localObject).putSerializable("paramter_one", paramEmoticonPackage);
      ((Bundle)localObject).putInt("paramter_two", paramInt);
      EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)localObject);
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Object localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmoticonPackageChangedListener localEmoticonPackageChangedListener = (EmoticonPackageChangedListener)((WeakReference)((Iterator)localObject).next()).get();
      if (localEmoticonPackageChangedListener != null) {
        localEmoticonPackageChangedListener.onPackageMoved(paramEmoticonPackage, paramInt1, paramInt2);
      }
    }
    if (EmotionUtils.a())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("module_emoticon_child_mainpanel", "emojilistener_packagemoved");
      ((Bundle)localObject).putSerializable("paramter_one", paramEmoticonPackage);
      ((Bundle)localObject).putInt("paramter_two", paramInt1);
      ((Bundle)localObject).putInt("paramter_three", paramInt2);
      EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)localObject);
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((CopyOnWriteArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmotionJsonDownloadListener localEmotionJsonDownloadListener = (EmotionJsonDownloadListener)((WeakReference)((Iterator)localObject).next()).get();
        if (localEmotionJsonDownloadListener != null) {
          localEmotionJsonDownloadListener.onJsonComplete(paramEmoticonPackage, paramInt, paramBundle);
        }
      }
    }
    if (EmotionUtils.a())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("module_emoticon_child_mainpanel", "emojilistener_loadend");
      ((Bundle)localObject).putSerializable("paramter_one", paramEmoticonPackage);
      ((Bundle)localObject).putInt("paramter_two", paramInt);
      ((Bundle)localObject).putBundle("paramter_three", paramBundle);
      EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)localObject);
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, AppInterface paramAppInterface)
  {
    notifyPackageFail(paramEmoticonPackage, -1, paramInt, paramAppInterface);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, AppInterface paramAppInterface)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    b(paramEmoticonPackage);
    paramAppInterface = MobileQQ.getContext().getSharedPreferences("mobileQQ", 0);
    String str = paramAppInterface.getString("LAST_ADD_EMO_PACKAGE", "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("|");
    localStringBuilder.append(paramEmoticonPackage.epId);
    str = localStringBuilder.toString();
    paramAppInterface.edit().putString("LAST_ADD_EMO_PACKAGE", str).commit();
    if (3 == paramEmoticonPackage.jobType) {
      paramAppInterface.edit().putBoolean("LAST_ADD_EMO_PACKAGE_MAGIC", true).commit();
    }
    if (EmotionUtils.a())
    {
      paramAppInterface = new Bundle();
      paramAppInterface.putString("module_emoticon_child_mainpanel", "emojilistener_packageadded");
      paramAppInterface.putSerializable("paramter_one", paramEmoticonPackage);
      EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle(paramAppInterface);
    }
  }
  
  public void a(EmoticonPackageChangedListener paramEmoticonPackageChangedListener)
  {
    if (paramEmoticonPackageChangedListener == null) {
      return;
    }
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramEmoticonPackageChangedListener) {
          return;
        }
      }
      paramEmoticonPackageChangedListener = new WeakReference(paramEmoticonPackageChangedListener);
      this.a.add(paramEmoticonPackageChangedListener);
      return;
    }
    for (;;)
    {
      throw paramEmoticonPackageChangedListener;
    }
  }
  
  public void addEmoticonPackageDownloadListener(EmoticonPackageDownloadListener paramEmoticonPackageDownloadListener)
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
      paramEmoticonPackageDownloadListener = new WeakReference(paramEmoticonPackageDownloadListener);
      this.b.add(paramEmoticonPackageDownloadListener);
      return;
    }
    for (;;)
    {
      throw paramEmoticonPackageDownloadListener;
    }
  }
  
  public void addEmotionJsonDownloadListener(EmotionJsonDownloadListener paramEmotionJsonDownloadListener)
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
      paramEmotionJsonDownloadListener = new WeakReference(paramEmotionJsonDownloadListener);
      this.c.add(paramEmotionJsonDownloadListener);
      return;
    }
    for (;;)
    {
      throw paramEmotionJsonDownloadListener;
    }
  }
  
  public void b()
  {
    synchronized (this.a)
    {
      this.a.clear();
      synchronized (this.b)
      {
        this.b.clear();
        if (EmotionUtils.a())
        {
          ??? = new Bundle();
          ((Bundle)???).putString("module_emoticon_child_mainpanel", "emojilistener_destory");
          EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)???);
        }
        return;
      }
    }
  }
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    if (EmotionUtils.a())
    {
      int i;
      if (paramEmoticonPackage.type == 1) {
        i = 5;
      } else {
        i = 4;
      }
      EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("0", i);
      localObject = new Bundle();
      ((Bundle)localObject).putString("module_emoticon_child_mainpanel", "emojilistener_packageadded_one");
      ((Bundle)localObject).putSerializable("paramter_one", paramEmoticonPackage);
      EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)localObject);
    }
    Object localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmoticonPackageChangedListener localEmoticonPackageChangedListener = (EmoticonPackageChangedListener)((WeakReference)((Iterator)localObject).next()).get();
      if (localEmoticonPackageChangedListener != null) {
        localEmoticonPackageChangedListener.onPackageAdded(paramEmoticonPackage);
      }
    }
  }
  
  public void b(EmoticonPackageChangedListener paramEmoticonPackageChangedListener)
  {
    if (paramEmoticonPackageChangedListener == null) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() == paramEmoticonPackageChangedListener) {
        this.a.remove(localWeakReference);
      }
    }
  }
  
  public void c(EmoticonPackage paramEmoticonPackage)
  {
    if (EmotionUtils.a())
    {
      EmoticonTabAdapter.removeTabDrawableCache(paramEmoticonPackage.epId);
      int i;
      if (paramEmoticonPackage.type == 1) {
        i = 5;
      } else {
        i = 4;
      }
      EmoticonOperateReport.reportEmoticonOperateMonitorGetStatus("0", i);
      ??? = new Bundle();
      ((Bundle)???).putString("module_emoticon_child_mainpanel", "emojilistener_packagesucc");
      ((Bundle)???).putSerializable("paramter_one", paramEmoticonPackage);
      EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)???);
    }
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        EmoticonPackageDownloadListener localEmoticonPackageDownloadListener = (EmoticonPackageDownloadListener)((WeakReference)localIterator.next()).get();
        if (localEmoticonPackageDownloadListener != null) {
          localEmoticonPackageDownloadListener.onPackageEnd(paramEmoticonPackage, 0);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramEmoticonPackage;
    }
  }
  
  public void notifyEmoticonCoverListener(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.b != null)
    {
      int i;
      if (paramInt2 != 0) {
        i = paramInt3;
      } else {
        i = 0;
      }
      synchronized (this.b)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          EmoticonPackageDownloadListener localEmoticonPackageDownloadListener = (EmoticonPackageDownloadListener)((WeakReference)localIterator.next()).get();
          if (localEmoticonPackageDownloadListener != null) {
            localEmoticonPackageDownloadListener.onCoverComplete(paramEmoticonPackage, paramInt1, i);
          }
        }
      }
    }
    if (EmotionUtils.a())
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
  
  public void notifyPackageFail(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2, AppInterface paramAppInterface)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Object localObject1;
    if (EmotionUtils.a())
    {
      if (paramAppInterface == null) {
        return;
      }
      if ((paramEmoticonPackage.status == 2) && (EmoticonPanelUtils.a(paramEmoticonPackage.updateFlag)))
      {
        localObject1 = paramEmoticonPackage.epId;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(paramEmoticonPackage.localVersion);
        localObject2 = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramEmoticonPackage.latestVersion);
        ReportController.b(paramAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_fail", 0, 0, (String)localObject1, (String)localObject2, localStringBuilder.toString(), "");
      }
      else
      {
        paramEmoticonPackage.status = 0;
      }
      if ((paramInt1 != 19) && (paramInt1 != 20))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("notifyPackageFail ep.id=");
        ((StringBuilder)localObject1).append(paramEmoticonPackage.epId);
        ((StringBuilder)localObject1).append(" error: ");
        ((StringBuilder)localObject1).append(paramInt1);
        SLog.e("EmojiListenerManager", ((StringBuilder)localObject1).toString());
        ((IEmoticonManagerService)paramAppInterface.getRuntimeService(IEmoticonManagerService.class, "")).saveEmoticonPackage(paramEmoticonPackage);
      }
      int i;
      if (paramEmoticonPackage.type == 1) {
        i = 5;
      } else {
        i = 4;
      }
      EmoticonOperateReport.reportEmoticonOperateMonitorGetStatus(String.valueOf(paramInt2), i);
      paramAppInterface = new Bundle();
      paramAppInterface.putString("module_emoticon_child_mainpanel", "emojilistener_packagefail");
      paramAppInterface.putSerializable("paramter_one", paramEmoticonPackage);
      paramAppInterface.putInt("paramter_two", paramInt1);
      paramAppInterface.putInt("paramter_three", paramInt2);
      EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle(paramAppInterface);
    }
    paramAppInterface = this.b.iterator();
    while (paramAppInterface.hasNext())
    {
      localObject1 = (EmoticonPackageDownloadListener)((WeakReference)paramAppInterface.next()).get();
      if (localObject1 != null) {
        ((EmoticonPackageDownloadListener)localObject1).onPackageEnd(paramEmoticonPackage, paramInt2);
      }
    }
  }
  
  public void notifyPackageProgress(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
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
          localEmoticonPackageDownloadListener.onPackageProgress(paramEmoticonPackage, paramInt1, paramInt2);
        }
      }
      if (EmotionUtils.a())
      {
        ??? = new Bundle();
        ((Bundle)???).putString("module_emoticon_child_mainpanel", "emojilistener_package_progress");
        ((Bundle)???).putSerializable("paramter_one", paramEmoticonPackage);
        ((Bundle)???).putInt("paramter_two", paramInt1);
        ((Bundle)???).putInt("paramter_three", paramInt2);
        EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)???);
      }
      return;
    }
    for (;;)
    {
      throw paramEmoticonPackage;
    }
  }
  
  public void notifyPackageStart(EmoticonPackage paramEmoticonPackage)
  {
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmoticonPackageDownloadListener localEmoticonPackageDownloadListener = (EmoticonPackageDownloadListener)((WeakReference)((Iterator)localObject).next()).get();
      if (localEmoticonPackageDownloadListener != null) {
        localEmoticonPackageDownloadListener.onPackageStart(paramEmoticonPackage);
      }
    }
    if (EmotionUtils.a())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("module_emoticon_child_mainpanel", "emojilistener_packagestart");
      ((Bundle)localObject).putSerializable("paramter_one", paramEmoticonPackage);
      EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle((Bundle)localObject);
    }
  }
  
  public void removeEmoticonPackageDownloadListener(EmoticonPackageDownloadListener paramEmoticonPackageDownloadListener)
  {
    if (paramEmoticonPackageDownloadListener == null) {
      return;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() == paramEmoticonPackageDownloadListener) {
        this.b.remove(localWeakReference);
      }
    }
  }
  
  public void removeEmotionJsonDownloadListener(EmotionJsonDownloadListener paramEmotionJsonDownloadListener)
  {
    if (paramEmotionJsonDownloadListener == null) {
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiListenerManager
 * JD-Core Version:    0.7.0.1
 */