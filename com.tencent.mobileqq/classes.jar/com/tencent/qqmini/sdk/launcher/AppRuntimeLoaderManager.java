package com.tencent.qqmini.sdk.launcher;

import android.content.Context;
import android.os.Bundle;
import bglq;
import bguf;
import bgug;
import bguh;
import bgui;
import bgun;
import bguo;
import bgup;
import bguz;
import bgva;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@bglq(a={@com.tencent.qqmini.sdk.annotation.RuntimeLoaderInfo(className="com.tencent.qqmini.sdk.runtime.flutter.FlutterRuntimeLoader", type=2), @com.tencent.qqmini.sdk.annotation.RuntimeLoaderInfo(className="com.tencent.qqmini.sdk.runtime.app.AppRuntimeLoader", type=1), @com.tencent.qqmini.sdk.annotation.RuntimeLoaderInfo(className="com.tencent.qqmini.sdk.minigame.GameRuntimeLoader", type=4)})
public class AppRuntimeLoaderManager
{
  private static final String TAG = "minisdk-start_AppRuntimeLoaderManager";
  private static volatile AppRuntimeLoaderManager instance;
  private static volatile byte[] lock = new byte[0];
  private final LinkedList<bgun> loadedRuntimeLinkedList = new LinkedList();
  private final HashMap<Class<bgun>, bgun> mEmptyRuntimeLoaderList = new HashMap();
  private final Vector<bgug> mObservers = new Vector();
  private int mProcessType = -1;
  private bguz mRuntimeConfiguration = new bguz(this);
  private bgug mRuntimeObserver = new bguh(this);
  
  public AppRuntimeLoaderManager()
  {
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", "RuntimeLoaderConfig:" + this.mRuntimeConfiguration.toString());
  }
  
  private void addRuntimeLoader(bgun parambgun)
  {
    if (parambgun != null) {}
    try
    {
      if (parambgun.getMiniAppInfo() != null) {
        this.loadedRuntimeLinkedList.addFirst(parambgun);
      }
      return;
    }
    finally
    {
      parambgun = finally;
      throw parambgun;
    }
  }
  
  public static AppRuntimeLoaderManager g()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new AppRuntimeLoaderManager();
      }
      return instance;
    }
  }
  
  private void notifyAppStateMessage(bguf parambguf)
  {
    try
    {
      Iterator localIterator = this.mObservers.iterator();
      while (localIterator.hasNext()) {
        ((bgug)localIterator.next()).a(parambguf);
      }
    }
    finally {}
  }
  
  private bgun obtainEmptyRuntimeLoader(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Iterator localIterator = this.mRuntimeConfiguration.a().iterator();
    while (localIterator.hasNext())
    {
      bgva localbgva = (bgva)localIterator.next();
      if ((localbgva.jdField_a_of_type_Bguo.a(paramBundle)) && (localbgva.jdField_a_of_type_Bguo.a(paramMiniAppInfo)))
      {
        if (this.mProcessType < 0) {
          this.mProcessType = localbgva.jdField_a_of_type_Int;
        }
        if (this.mEmptyRuntimeLoaderList.containsKey(localbgva.jdField_a_of_type_JavaLangClass)) {}
        for (paramMiniAppInfo = (bgun)this.mEmptyRuntimeLoaderList.remove(localbgva.jdField_a_of_type_JavaLangClass);; paramMiniAppInfo = (bgun)localbgva.jdField_a_of_type_Bguo.a(AppLoaderFactory.g().getMiniAppEnv().getContext(), paramBundle))
        {
          paramMiniAppInfo.addRuntimeStateObserver(this.mRuntimeObserver);
          return paramMiniAppInfo;
        }
      }
    }
    return null;
  }
  
  public void addAppEventObserver(bgug parambgug)
  {
    if (parambgug != null) {}
    try
    {
      if (!this.mObservers.contains(parambgug)) {
        this.mObservers.addElement(parambgug);
      }
      return;
    }
    finally
    {
      parambgug = finally;
      throw parambgug;
    }
  }
  
  public void bringToFront(bgun parambgun)
  {
    try
    {
      this.loadedRuntimeLinkedList.remove(parambgun);
      this.loadedRuntimeLinkedList.addFirst(parambgun);
      return;
    }
    catch (Throwable parambgun)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "bringToFront exception!", parambgun);
    }
  }
  
  public bgun createAppRuntimeLoader(MiniAppInfo paramMiniAppInfo, bgup parambgup, Bundle paramBundle)
  {
    if (paramMiniAppInfo == null)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "Failed to createAppRuntimeLoader, appInfo is null");
      return null;
    }
    try
    {
      paramBundle = obtainEmptyRuntimeLoader(paramMiniAppInfo, paramBundle);
      QMLog.i("minisdk-start_AppRuntimeLoaderManager", "createAppRuntimeLoader appId=" + paramMiniAppInfo.appId + " name=" + paramMiniAppInfo.name + " versionType=" + paramMiniAppInfo.verType + " version=" + paramMiniAppInfo.version + " obtainRuntimeLoader:" + paramBundle);
      paramBundle.setRuntimeLoadListener(new bgui(this, parambgup));
      paramBundle.loadMiniAppInfo(paramMiniAppInfo);
      addRuntimeLoader(paramBundle);
      return paramBundle;
    }
    catch (Throwable paramMiniAppInfo)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "getAppBrandRunTime exception!", paramMiniAppInfo);
    }
    return null;
  }
  
  public void deleteAppEventObserver(bgug parambgug)
  {
    if (parambgug != null) {}
    try
    {
      this.mObservers.removeElement(parambgug);
      return;
    }
    finally
    {
      parambgug = finally;
      throw parambgug;
    }
  }
  
  public bgun getCurrentRunTimeLoader()
  {
    try
    {
      Object localObject = new LinkedList(this.loadedRuntimeLinkedList);
      if (((LinkedList)localObject).size() > 0)
      {
        localObject = (bgun)((LinkedList)localObject).peekFirst();
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "getCurrentRunTimeLoader exception!", localThrowable);
    }
    return null;
  }
  
  public void notifyRuntimeEvent(int paramInt, Object... paramVarArgs)
  {
    if (getCurrentRunTimeLoader() != null) {
      getCurrentRunTimeLoader().notifyRuntimeEvent(paramInt, paramVarArgs);
    }
  }
  
  public void preloadRuntime()
  {
    preloadRuntime(null);
  }
  
  public void preloadRuntime(Bundle paramBundle)
  {
    if ((this.mProcessType < 0) && (paramBundle != null) && (paramBundle.containsKey("mini_key_preload_type")))
    {
      localObject = paramBundle.getString("mini_key_preload_type");
      if (!"preload_app".equals(localObject)) {
        break label98;
      }
      if (!paramBundle.containsKey("isFlutterRuntimeProcess")) {
        break label90;
      }
      this.mProcessType = 2;
    }
    for (;;)
    {
      QMLog.w("minisdk-start_AppRuntimeLoaderManager", "preloadRuntime with ProcessType=" + this.mProcessType);
      if (this.mProcessType >= 0) {
        break;
      }
      return;
      label90:
      this.mProcessType = 1;
      continue;
      label98:
      if ("preload_game".equals(localObject)) {
        this.mProcessType = 4;
      }
    }
    Iterator localIterator = this.mRuntimeConfiguration.a().iterator();
    label129:
    bgva localbgva;
    bguo localbguo;
    Context localContext;
    while (localIterator.hasNext())
    {
      localbgva = (bgva)localIterator.next();
      if ((this.mProcessType & localbgva.jdField_a_of_type_Int) != 0) {
        if (!localbgva.jdField_a_of_type_Bguo.a(paramBundle))
        {
          localbgva.jdField_a_of_type_Bguo.a(paramBundle);
        }
        else if (!this.mEmptyRuntimeLoaderList.containsKey(localbgva.jdField_a_of_type_JavaLangClass))
        {
          localbguo = localbgva.jdField_a_of_type_Bguo;
          localContext = AppLoaderFactory.g().getMiniAppEnv().getContext();
          if (paramBundle == null) {
            break label282;
          }
        }
      }
    }
    label282:
    for (Object localObject = paramBundle;; localObject = new Bundle())
    {
      localObject = (bgun)localbguo.a(localContext, (Bundle)localObject);
      ((bgun)localObject).addRuntimeStateObserver(this.mRuntimeObserver);
      ((bgun)localObject).getAppStateManager().a = true;
      ((bgun)localObject).start();
      this.mEmptyRuntimeLoaderList.put(localbgva.jdField_a_of_type_JavaLangClass, localObject);
      break label129;
      break;
    }
  }
  
  public bgun queryAppRunTimeLoader(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", "queryAppRunTimeLoader appId=" + paramMiniAppInfo.appId + " name=" + paramMiniAppInfo.name + " versionType=" + paramMiniAppInfo.verType + " version=" + paramMiniAppInfo.version);
    try
    {
      Iterator localIterator = new ArrayList(this.loadedRuntimeLinkedList).iterator();
      while (localIterator.hasNext())
      {
        bgun localbgun = (bgun)localIterator.next();
        if (localbgun.getMiniAppInfo() != null)
        {
          boolean bool = localbgun.getMiniAppInfo().equals(paramMiniAppInfo);
          if (bool) {
            return localbgun;
          }
        }
      }
    }
    catch (Throwable paramMiniAppInfo)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "getAppBrandRunTime exception!", paramMiniAppInfo);
    }
    return null;
  }
  
  public void removeRuntimeLoader(bgun parambgun)
  {
    if (parambgun != null) {}
    try
    {
      this.loadedRuntimeLinkedList.remove(parambgun);
      return;
    }
    finally
    {
      parambgun = finally;
      throw parambgun;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager
 * JD-Core Version:    0.7.0.1
 */