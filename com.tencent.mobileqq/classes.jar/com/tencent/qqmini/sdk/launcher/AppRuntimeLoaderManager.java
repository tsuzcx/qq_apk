package com.tencent.qqmini.sdk.launcher;

import android.content.Context;
import android.os.Bundle;
import bghj;
import bgpy;
import bgpz;
import bgqa;
import bgqb;
import bgqg;
import bgqh;
import bgqi;
import bgqs;
import bgqt;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@bghj(a={@com.tencent.qqmini.sdk.annotation.RuntimeLoaderInfo(className="com.tencent.qqmini.sdk.runtime.flutter.FlutterRuntimeLoader", type=2), @com.tencent.qqmini.sdk.annotation.RuntimeLoaderInfo(className="com.tencent.qqmini.sdk.runtime.app.AppRuntimeLoader", type=1), @com.tencent.qqmini.sdk.annotation.RuntimeLoaderInfo(className="com.tencent.qqmini.sdk.minigame.GameRuntimeLoader", type=4)})
public class AppRuntimeLoaderManager
{
  private static final String TAG = "minisdk-start_AppRuntimeLoaderManager";
  private static volatile AppRuntimeLoaderManager instance;
  private static volatile byte[] lock = new byte[0];
  private final LinkedList<bgqg> loadedRuntimeLinkedList = new LinkedList();
  private final HashMap<Class<bgqg>, bgqg> mEmptyRuntimeLoaderList = new HashMap();
  private final Vector<bgpz> mObservers = new Vector();
  private int mProcessType = -1;
  private bgqs mRuntimeConfiguration = new bgqs(this);
  private bgpz mRuntimeObserver = new bgqa(this);
  
  public AppRuntimeLoaderManager()
  {
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", "RuntimeLoaderConfig:" + this.mRuntimeConfiguration.toString());
  }
  
  private void addRuntimeLoader(bgqg parambgqg)
  {
    if (parambgqg != null) {}
    try
    {
      if (parambgqg.getMiniAppInfo() != null) {
        this.loadedRuntimeLinkedList.addFirst(parambgqg);
      }
      return;
    }
    finally
    {
      parambgqg = finally;
      throw parambgqg;
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
  
  private void notifyAppStateMessage(bgpy parambgpy)
  {
    try
    {
      Iterator localIterator = this.mObservers.iterator();
      while (localIterator.hasNext()) {
        ((bgpz)localIterator.next()).a(parambgpy);
      }
    }
    finally {}
  }
  
  private bgqg obtainEmptyRuntimeLoader(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Iterator localIterator = this.mRuntimeConfiguration.a().iterator();
    while (localIterator.hasNext())
    {
      bgqt localbgqt = (bgqt)localIterator.next();
      if ((localbgqt.jdField_a_of_type_Bgqh.a(paramBundle)) && (localbgqt.jdField_a_of_type_Bgqh.a(paramMiniAppInfo)))
      {
        if (this.mProcessType < 0) {
          this.mProcessType = localbgqt.jdField_a_of_type_Int;
        }
        if (this.mEmptyRuntimeLoaderList.containsKey(localbgqt.jdField_a_of_type_JavaLangClass)) {}
        for (paramMiniAppInfo = (bgqg)this.mEmptyRuntimeLoaderList.remove(localbgqt.jdField_a_of_type_JavaLangClass);; paramMiniAppInfo = (bgqg)localbgqt.jdField_a_of_type_Bgqh.a(AppLoaderFactory.g().getMiniAppEnv().getContext(), paramBundle))
        {
          paramMiniAppInfo.addRuntimeStateObserver(this.mRuntimeObserver);
          return paramMiniAppInfo;
        }
      }
    }
    return null;
  }
  
  public void addAppEventObserver(bgpz parambgpz)
  {
    if (parambgpz != null) {}
    try
    {
      if (!this.mObservers.contains(parambgpz)) {
        this.mObservers.addElement(parambgpz);
      }
      return;
    }
    finally
    {
      parambgpz = finally;
      throw parambgpz;
    }
  }
  
  public void bringToFront(bgqg parambgqg)
  {
    try
    {
      this.loadedRuntimeLinkedList.remove(parambgqg);
      this.loadedRuntimeLinkedList.addFirst(parambgqg);
      return;
    }
    catch (Throwable parambgqg)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "bringToFront exception!", parambgqg);
    }
  }
  
  public bgqg createAppRuntimeLoader(MiniAppInfo paramMiniAppInfo, bgqi parambgqi, Bundle paramBundle)
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
      paramBundle.setRuntimeLoadListener(new bgqb(this, parambgqi));
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
  
  public void deleteAppEventObserver(bgpz parambgpz)
  {
    if (parambgpz != null) {}
    try
    {
      this.mObservers.removeElement(parambgpz);
      return;
    }
    finally
    {
      parambgpz = finally;
      throw parambgpz;
    }
  }
  
  public bgqg getCurrentRunTimeLoader()
  {
    try
    {
      Object localObject = new LinkedList(this.loadedRuntimeLinkedList);
      if (((LinkedList)localObject).size() > 0)
      {
        localObject = (bgqg)((LinkedList)localObject).peekFirst();
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
    bgqt localbgqt;
    bgqh localbgqh;
    Context localContext;
    while (localIterator.hasNext())
    {
      localbgqt = (bgqt)localIterator.next();
      if ((this.mProcessType & localbgqt.jdField_a_of_type_Int) != 0) {
        if (!localbgqt.jdField_a_of_type_Bgqh.a(paramBundle))
        {
          localbgqt.jdField_a_of_type_Bgqh.a(paramBundle);
        }
        else if (!this.mEmptyRuntimeLoaderList.containsKey(localbgqt.jdField_a_of_type_JavaLangClass))
        {
          localbgqh = localbgqt.jdField_a_of_type_Bgqh;
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
      localObject = (bgqg)localbgqh.a(localContext, (Bundle)localObject);
      ((bgqg)localObject).addRuntimeStateObserver(this.mRuntimeObserver);
      ((bgqg)localObject).getAppStateManager().a = true;
      ((bgqg)localObject).start();
      this.mEmptyRuntimeLoaderList.put(localbgqt.jdField_a_of_type_JavaLangClass, localObject);
      break label129;
      break;
    }
  }
  
  public bgqg queryAppRunTimeLoader(MiniAppInfo paramMiniAppInfo)
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
        bgqg localbgqg = (bgqg)localIterator.next();
        if (localbgqg.getMiniAppInfo() != null)
        {
          boolean bool = localbgqg.getMiniAppInfo().equals(paramMiniAppInfo);
          if (bool) {
            return localbgqg;
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
  
  public void removeRuntimeLoader(bgqg parambgqg)
  {
    if (parambgqg != null) {}
    try
    {
      this.loadedRuntimeLinkedList.remove(parambgqg);
      return;
    }
    finally
    {
      parambgqg = finally;
      throw parambgqg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager
 * JD-Core Version:    0.7.0.1
 */