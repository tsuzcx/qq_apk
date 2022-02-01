package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.ResInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.InvalidClassException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class PreloadConfig
  implements Serializable
{
  private static final long serialVersionUID = 2L;
  public transient List<PreloadModuleImpl> mLastModules;
  private CopyOnWriteArrayList<PreloadModuleImpl> mPreloadModules = new CopyOnWriteArrayList();
  public transient byte[] mSaveLock;
  public transient String mSavePath;
  public long moggyConfigVersion = 0L;
  
  public static ArrayList<ResInfo> modulesToResInfos(List<PreloadModuleImpl> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PreloadModuleImpl localPreloadModuleImpl = (PreloadModuleImpl)paramList.next();
      try
      {
        ResInfo localResInfo = new ResInfo();
        localResInfo.sResId = localPreloadModuleImpl.mid;
        localResInfo.iSize = localPreloadModuleImpl.getModuleResSize();
        localArrayList.add(localResInfo);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    return localArrayList;
  }
  
  public static List<PreloadModuleImpl> parseConfig(JSONArray paramJSONArray, boolean paramBoolean, int paramInt)
  {
    localArrayList = new ArrayList();
    int i = 0;
    try
    {
      while (i < paramJSONArray.length())
      {
        localArrayList.add(PreloadModuleImpl.parsePreloadModule(paramJSONArray.getJSONObject(i), paramBoolean, paramInt));
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
  
  public static PreloadConfig readConfig(String paramString, AppRuntime paramAppRuntime)
  {
    paramAppRuntime = PreloadStaticApi.a(paramAppRuntime, paramString);
    try
    {
      try
      {
        paramString = (PreloadConfig)QWalletTools.a(paramAppRuntime);
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          break label97;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readPreloadConfig exception:");
      localStringBuilder.append(paramAppRuntime);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString.toString());
      QLog.w("PreloadService", 2, localStringBuilder.toString());
    }
    catch (InvalidClassException paramString)
    {
      label74:
      break label74;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "preload config update should delete local config");
    }
    QConfigManager.a().a(68, 0);
    label97:
    paramString = null;
    if (paramString == null) {
      paramString = new PreloadConfig();
    } else {
      paramString.checkModules();
    }
    paramString.mSavePath = paramAppRuntime;
    paramString.mSaveLock = new byte[0];
    paramString.mLastModules = paramString.getCloneModules();
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("readPreloadConfig:");
      paramAppRuntime.append(paramString);
      QLog.d("PreloadService", 2, paramAppRuntime.toString());
    }
    return paramString;
  }
  
  public static void splitModulesByBackControl(List<PreloadModuleImpl> paramList1, List<PreloadModuleImpl> paramList2, List<PreloadModuleImpl> paramList3)
  {
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      PreloadModuleImpl localPreloadModuleImpl = (PreloadModuleImpl)paramList1.next();
      if (localPreloadModuleImpl.mBackControl) {
        paramList2.add(localPreloadModuleImpl);
      } else {
        paramList3.add(localPreloadModuleImpl);
      }
    }
  }
  
  public static void splitModulesBySize(int paramInt, List<PreloadModuleImpl> paramList1, List<PreloadModuleImpl> paramList2, List<PreloadModuleImpl> paramList3)
  {
    if ((paramList1 != null) && (paramList2 != null))
    {
      if (paramList3 == null) {
        return;
      }
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        PreloadModuleImpl localPreloadModuleImpl = (PreloadModuleImpl)paramList1.next();
        if (localPreloadModuleImpl.getModuleResSize() <= paramInt) {
          paramList2.add(localPreloadModuleImpl);
        } else {
          paramList3.add(localPreloadModuleImpl);
        }
      }
    }
  }
  
  public void addOrMerge(JSONObject paramJSONObject, PreloadServiceImpl paramPreloadServiceImpl)
  {
    paramJSONObject = PreloadModuleImpl.parsePreloadModule(paramJSONObject, true, 0);
    PreloadModuleImpl localPreloadModuleImpl = getModuleByID(paramJSONObject.mid);
    if (localPreloadModuleImpl != null)
    {
      localPreloadModuleImpl.updatePreloadModule(paramJSONObject, paramPreloadServiceImpl);
      return;
    }
    this.mPreloadModules.add(paramJSONObject);
  }
  
  public void checkModules()
  {
    if (this.mPreloadModules == null) {
      this.mPreloadModules = new CopyOnWriteArrayList();
    }
    Iterator localIterator1 = this.mPreloadModules.iterator();
    while (localIterator1.hasNext())
    {
      PreloadModuleImpl localPreloadModuleImpl = (PreloadModuleImpl)localIterator1.next();
      localPreloadModuleImpl.check();
      Iterator localIterator2 = localPreloadModuleImpl.getResList().iterator();
      while (localIterator2.hasNext())
      {
        PreloadResourceImpl localPreloadResourceImpl = (PreloadResourceImpl)localIterator2.next();
        if (TextUtils.isEmpty(localPreloadResourceImpl.mResId)) {
          localPreloadResourceImpl.mResId = localPreloadResourceImpl.getResDownloadUrl(localPreloadModuleImpl);
        }
      }
    }
  }
  
  public void filterInvalidModules(PreloadServiceImpl paramPreloadServiceImpl)
  {
    Iterator localIterator = this.mPreloadModules.iterator();
    while (localIterator.hasNext())
    {
      PreloadModuleImpl localPreloadModuleImpl = (PreloadModuleImpl)localIterator.next();
      localPreloadModuleImpl.filterInvalidRes(paramPreloadServiceImpl);
      if (localPreloadModuleImpl.getResNum() <= 0) {
        this.mPreloadModules.remove(localPreloadModuleImpl);
      }
    }
  }
  
  public List<PreloadModuleImpl> getCloneModules()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mPreloadModules.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new PreloadModuleImpl((PreloadModuleImpl)localIterator.next()));
    }
    return localArrayList;
  }
  
  public PreloadModuleImpl getModuleByID(String paramString)
  {
    if (paramString != null)
    {
      Iterator localIterator = this.mPreloadModules.iterator();
      while (localIterator.hasNext())
      {
        PreloadModuleImpl localPreloadModuleImpl = (PreloadModuleImpl)localIterator.next();
        if (localPreloadModuleImpl.mid.equals(paramString)) {
          return localPreloadModuleImpl;
        }
      }
    }
    return null;
  }
  
  public PreloadModuleImpl getModuleByName(String paramString)
  {
    Iterator localIterator = this.mPreloadModules.iterator();
    while (localIterator.hasNext())
    {
      PreloadModuleImpl localPreloadModuleImpl = (PreloadModuleImpl)localIterator.next();
      if (localPreloadModuleImpl.name.equals(paramString)) {
        return localPreloadModuleImpl;
      }
    }
    return null;
  }
  
  public int getModuleNum()
  {
    return this.mPreloadModules.size();
  }
  
  public List<PreloadModuleImpl> getModules()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mPreloadModules.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((PreloadModuleImpl)localIterator.next());
    }
    return localArrayList;
  }
  
  public String getResIdByUrl(String paramString)
  {
    PreloadModuleImpl localPreloadModuleImpl;
    PreloadResourceImpl localPreloadResourceImpl;
    do
    {
      Iterator localIterator1 = this.mPreloadModules.iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localPreloadModuleImpl = (PreloadModuleImpl)localIterator1.next();
        localIterator2 = localPreloadModuleImpl.getResList().iterator();
      }
      localPreloadResourceImpl = (PreloadResourceImpl)localIterator2.next();
    } while (!QWalletTools.c(localPreloadResourceImpl.getResDownloadUrl(localPreloadModuleImpl), paramString));
    return localPreloadResourceImpl.mResId;
    return "";
  }
  
  public ResourceInfo getResInfoByResId(String paramString)
  {
    PreloadModuleImpl localPreloadModuleImpl;
    PreloadResourceImpl localPreloadResourceImpl;
    do
    {
      Iterator localIterator1 = this.mPreloadModules.iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localPreloadModuleImpl = (PreloadModuleImpl)localIterator1.next();
        localIterator2 = localPreloadModuleImpl.getResList().iterator();
      }
      localPreloadResourceImpl = (PreloadResourceImpl)localIterator2.next();
    } while (!QWalletTools.c(localPreloadResourceImpl.mResId, paramString));
    return localPreloadResourceImpl.getResInfo(localPreloadModuleImpl);
    return null;
  }
  
  public void innerReplaceConfig(JSONArray paramJSONArray, PreloadServiceImpl paramPreloadServiceImpl, int paramInt)
  {
    paramJSONArray = parseConfig(paramJSONArray, false, paramInt);
    Iterator localIterator = this.mPreloadModules.iterator();
    while (localIterator.hasNext())
    {
      PreloadModuleImpl localPreloadModuleImpl = (PreloadModuleImpl)localIterator.next();
      int i = paramJSONArray.indexOf(localPreloadModuleImpl);
      if (i != -1)
      {
        localPreloadModuleImpl.updateNewModuleWhenReplace((PreloadModuleImpl)paramJSONArray.get(i), paramPreloadServiceImpl, paramInt);
      }
      else
      {
        localPreloadModuleImpl.deleteResFromServer(paramPreloadServiceImpl, paramInt);
        if (localPreloadModuleImpl.getResNum() > 0) {
          paramJSONArray.add(localPreloadModuleImpl);
        }
      }
    }
    this.mPreloadModules = new CopyOnWriteArrayList(paramJSONArray);
  }
  
  public boolean isModulesChange(List<PreloadModuleImpl> paramList)
  {
    List localList = getModules();
    if (localList.size() != paramList.size()) {
      return true;
    }
    int i = 0;
    while (i < localList.size())
    {
      if (((PreloadModuleImpl)localList.get(i)).isModuleChange((PreloadModuleImpl)paramList.get(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isResInConfig(PreloadResourceImpl paramPreloadResourceImpl)
  {
    Iterator localIterator2;
    do
    {
      Iterator localIterator1 = this.mPreloadModules.iterator();
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((PreloadModuleImpl)localIterator1.next()).getResList().iterator();
      }
    } while (!QWalletTools.c(((PreloadResourceImpl)localIterator2.next()).mResId, paramPreloadResourceImpl.mResId));
    return true;
    return false;
  }
  
  public boolean isUrlInConfig(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    PreloadModuleImpl localPreloadModuleImpl;
    Iterator localIterator2;
    do
    {
      Iterator localIterator1 = this.mPreloadModules.iterator();
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localPreloadModuleImpl = (PreloadModuleImpl)localIterator1.next();
        localIterator2 = localPreloadModuleImpl.getResList().iterator();
      }
    } while (!paramString.equals(((PreloadResourceImpl)localIterator2.next()).getResDownloadUrl(localPreloadModuleImpl)));
    return true;
    return false;
  }
  
  public void mergeConfig(String paramString, PreloadServiceImpl paramPreloadServiceImpl)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("module_config");
      int i = 0;
      while (i < paramString.length())
      {
        addOrMerge(paramString.getJSONObject(i), paramPreloadServiceImpl);
        i += 1;
      }
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void removeModule(PreloadModuleImpl paramPreloadModuleImpl)
  {
    this.mPreloadModules.remove(paramPreloadModuleImpl);
  }
  
  public List<PreloadModuleImpl> resInfosToModules(ArrayList<ResInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList == null) {
      return localArrayList;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      PreloadModuleImpl localPreloadModuleImpl = getModuleByID(((ResInfo)paramArrayList.next()).sResId);
      if (localPreloadModuleImpl != null) {
        localArrayList.add(localPreloadModuleImpl);
      }
    }
    return localArrayList;
  }
  
  public void savePreloadConfig()
  {
    ThreadManager.getFileThreadHandler().post(new PreloadConfig.1(this));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Config [mModules=");
    localStringBuilder.append(this.mPreloadModules);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadConfig
 * JD-Core Version:    0.7.0.1
 */