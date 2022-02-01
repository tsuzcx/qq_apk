package com.tencent.mobileqq.qwallet.preload.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.qwallet.preload.IPreloadModule;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.vip.DownloadListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class PreloadModuleImpl
  implements IPreloadModule, Serializable
{
  public static final int DEFAULT_VALUE_RETRY_COUNT = 5;
  public static final int DEFAULT_VALUE_RETRY_TIME_INTERVAL = 24;
  private static final long serialVersionUID = 1L;
  public boolean isForbidAutoDownload;
  public boolean mBackControl;
  public String mBaseUrl;
  private CopyOnWriteArrayList<PreloadResourceImpl> mPreloadResourceImpls = new CopyOnWriteArrayList();
  public int mRetryCount = 5;
  public int mRetryTimeInterval = 24;
  public String mid;
  public String name;
  public int option;
  
  public PreloadModuleImpl() {}
  
  public PreloadModuleImpl(PreloadModuleImpl paramPreloadModuleImpl)
  {
    this();
    this.mid = paramPreloadModuleImpl.mid;
    this.mBackControl = paramPreloadModuleImpl.mBackControl;
    this.name = paramPreloadModuleImpl.name;
    this.option = paramPreloadModuleImpl.option;
    this.isForbidAutoDownload = paramPreloadModuleImpl.isForbidAutoDownload;
    this.mBaseUrl = paramPreloadModuleImpl.mBaseUrl;
    Iterator localIterator = paramPreloadModuleImpl.mPreloadResourceImpls.iterator();
    while (localIterator.hasNext())
    {
      PreloadResourceImpl localPreloadResourceImpl = (PreloadResourceImpl)localIterator.next();
      this.mPreloadResourceImpls.add(new PreloadResourceImpl(localPreloadResourceImpl));
    }
    this.mRetryTimeInterval = paramPreloadModuleImpl.mRetryTimeInterval;
    this.mRetryCount = paramPreloadModuleImpl.mRetryCount;
  }
  
  private void a(String paramString, AppRuntime paramAppRuntime)
  {
    Object localObject = null;
    try
    {
      Uri localUri = Uri.parse(paramString);
      paramString = localObject;
      if (localUri != null)
      {
        paramString = localObject;
        if (localUri.isHierarchical()) {
          paramString = localUri.getQueryParameter("_bid");
        }
      }
      if (!a(paramString)) {
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    HtmlOffline.b(paramString, paramAppRuntime, true, new PreloadModuleImpl.1(this));
  }
  
  private boolean a(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  public static PreloadModuleImpl parsePreloadModule(JSONObject paramJSONObject, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = true;
    int i = 0;
    PreloadModuleImpl localPreloadModuleImpl = new PreloadModuleImpl();
    for (;;)
    {
      Object localObject;
      try
      {
        if (paramJSONObject.optInt("back_control") != 1) {
          break label264;
        }
        bool1 = true;
        localPreloadModuleImpl.mBackControl = bool1;
        if (paramBoolean) {
          localPreloadModuleImpl.mBackControl = false;
        }
        if (paramInt == 2)
        {
          localPreloadModuleImpl.name = "2021_shuayishua";
          localObject = paramJSONObject.optString("module_id");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break label248;
          }
          localPreloadModuleImpl.mid = localPreloadModuleImpl.name;
          localPreloadModuleImpl.option = paramJSONObject.optInt("option");
          if (paramJSONObject.optInt("forbid_download") != 1) {
            break label258;
          }
          bool1 = bool2;
          localPreloadModuleImpl.isForbidAutoDownload = bool1;
          localPreloadModuleImpl.mBaseUrl = paramJSONObject.optString("url_base");
          localPreloadModuleImpl.mRetryTimeInterval = paramJSONObject.optInt("retry_t_interval", 24);
          localPreloadModuleImpl.mRetryCount = paramJSONObject.optInt("retry_cnt", 5);
          localPreloadModuleImpl.mRetryCount = Math.max(localPreloadModuleImpl.mRetryCount, 5);
          paramJSONObject = paramJSONObject.optJSONArray("resources");
          if (i < paramJSONObject.length())
          {
            localObject = PreloadResourceImpl.parsePreloadResource(paramJSONObject.getJSONObject(i), localPreloadModuleImpl, paramBoolean, paramInt);
            localPreloadModuleImpl.mPreloadResourceImpls.add(localObject);
            i += 1;
            continue;
          }
        }
        else
        {
          if (paramInt != 3) {
            break label234;
          }
          localPreloadModuleImpl.name = "2021_cjavgame";
          continue;
        }
        return localPreloadModuleImpl;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      label234:
      localPreloadModuleImpl.name = paramJSONObject.optString("module_name");
      continue;
      label248:
      localPreloadModuleImpl.mid = ((String)localObject);
      continue;
      label258:
      boolean bool1 = false;
      continue;
      label264:
      bool1 = false;
    }
  }
  
  public void check()
  {
    if (TextUtils.isEmpty(this.mid)) {
      this.mid = this.name;
    }
    if (this.mRetryTimeInterval <= 0)
    {
      i = 24;
      this.mRetryTimeInterval = i;
      if (this.mRetryCount > 0) {
        break label56;
      }
    }
    label56:
    for (int i = 5;; i = this.mRetryCount)
    {
      this.mRetryCount = i;
      return;
      i = this.mRetryTimeInterval;
      break;
    }
  }
  
  public void deleteResFromServer(PreloadServiceImpl paramPreloadServiceImpl, int paramInt)
  {
    paramPreloadServiceImpl = this.mPreloadResourceImpls.iterator();
    while (paramPreloadServiceImpl.hasNext())
    {
      PreloadResourceImpl localPreloadResourceImpl = (PreloadResourceImpl)paramPreloadServiceImpl.next();
      if ((localPreloadResourceImpl.mIsFromLocal) || (localPreloadResourceImpl.mFromType == paramInt)) {
        this.mPreloadResourceImpls.remove(localPreloadResourceImpl);
      }
    }
  }
  
  public void downloadModule(boolean paramBoolean1, DownloadListener paramDownloadListener, PreloadServiceImpl paramPreloadServiceImpl, boolean paramBoolean2)
  {
    if (this.name.equals("wallet_offline")) {
      handleHtmlOffline(paramPreloadServiceImpl.mApp);
    }
    for (;;)
    {
      return;
      if ((paramBoolean1) || (!this.isForbidAutoDownload))
      {
        Iterator localIterator = this.mPreloadResourceImpls.iterator();
        while (localIterator.hasNext())
        {
          PreloadResourceImpl localPreloadResourceImpl = (PreloadResourceImpl)localIterator.next();
          if (!localPreloadResourceImpl.isInValidTime())
          {
            localPreloadResourceImpl.deleteResFile(this, paramPreloadServiceImpl, 6);
            this.mPreloadResourceImpls.remove(localPreloadResourceImpl);
          }
          else if ((localPreloadResourceImpl.isAbiMatch()) && (localPreloadResourceImpl.isTimeToDownload(paramPreloadServiceImpl)))
          {
            localPreloadResourceImpl.startDownload(paramPreloadServiceImpl, this, paramDownloadListener, paramBoolean2);
          }
        }
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof PreloadModuleImpl)))
    {
      paramObject = (PreloadModuleImpl)paramObject;
      if ((this.mid != null) && (this.mid.equals(paramObject.mid))) {
        return true;
      }
    }
    return false;
  }
  
  public void filterInvalidRes(PreloadServiceImpl paramPreloadServiceImpl)
  {
    Iterator localIterator = this.mPreloadResourceImpls.iterator();
    while (localIterator.hasNext())
    {
      PreloadResourceImpl localPreloadResourceImpl = (PreloadResourceImpl)localIterator.next();
      if (!localPreloadResourceImpl.isInValidTime())
      {
        localPreloadResourceImpl.deleteResFile(this, paramPreloadServiceImpl, 6);
        this.mPreloadResourceImpls.remove(localPreloadResourceImpl);
      }
      else if (localPreloadResourceImpl.handleAbnormalRetry(this))
      {
        this.mPreloadResourceImpls.remove(localPreloadResourceImpl);
        localPreloadResourceImpl.deleteResFile(this, paramPreloadServiceImpl, 9);
      }
    }
  }
  
  public String getBaseUrl()
  {
    return this.mBaseUrl;
  }
  
  public int getModuleResSize()
  {
    Iterator localIterator = this.mPreloadResourceImpls.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((PreloadResourceImpl)localIterator.next()).size + i) {}
    return i;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public List<IPreloadResource> getResApiList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mPreloadResourceImpls.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((PreloadResourceImpl)localIterator.next());
    }
    return localArrayList;
  }
  
  public List<PreloadResourceImpl> getResList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mPreloadResourceImpls.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((PreloadResourceImpl)localIterator.next());
    }
    return localArrayList;
  }
  
  public int getResNum()
  {
    return this.mPreloadResourceImpls.size();
  }
  
  public PreloadResourceImpl getResourceByResId(String paramString)
  {
    Iterator localIterator = this.mPreloadResourceImpls.iterator();
    while (localIterator.hasNext())
    {
      PreloadResourceImpl localPreloadResourceImpl = (PreloadResourceImpl)localIterator.next();
      if (QWalletTools.c(localPreloadResourceImpl.mResId, paramString)) {
        return localPreloadResourceImpl;
      }
    }
    return null;
  }
  
  public PreloadResourceImpl getResourceByType(int paramInt)
  {
    Iterator localIterator = this.mPreloadResourceImpls.iterator();
    while (localIterator.hasNext())
    {
      PreloadResourceImpl localPreloadResourceImpl = (PreloadResourceImpl)localIterator.next();
      if (localPreloadResourceImpl.type == paramInt) {
        return localPreloadResourceImpl;
      }
    }
    return null;
  }
  
  public void handleHtmlOffline(AppRuntime paramAppRuntime)
  {
    Iterator localIterator = this.mPreloadResourceImpls.iterator();
    while (localIterator.hasNext()) {
      a(((PreloadResourceImpl)localIterator.next()).url, paramAppRuntime);
    }
  }
  
  public boolean isModuleChange(PreloadModuleImpl paramPreloadModuleImpl)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!QWalletTools.c(this.mid, paramPreloadModuleImpl.mid))
    {
      bool1 = true;
      return bool1;
    }
    if (this.mBackControl != paramPreloadModuleImpl.mBackControl) {
      return true;
    }
    if (!QWalletTools.c(this.name, paramPreloadModuleImpl.name)) {
      return true;
    }
    if (this.option != paramPreloadModuleImpl.option) {
      return true;
    }
    if (this.isForbidAutoDownload != paramPreloadModuleImpl.isForbidAutoDownload) {
      return true;
    }
    if (this.mRetryTimeInterval != paramPreloadModuleImpl.mRetryTimeInterval) {
      return true;
    }
    if (this.mRetryCount != paramPreloadModuleImpl.mRetryCount) {
      return true;
    }
    if (!QWalletTools.c(this.mBaseUrl, paramPreloadModuleImpl.mBaseUrl)) {
      return true;
    }
    List localList = getResList();
    if (localList.size() != paramPreloadModuleImpl.mPreloadResourceImpls.size()) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= localList.size()) {
        break;
      }
      if (((PreloadResourceImpl)localList.get(i)).isResChange((PreloadResourceImpl)paramPreloadModuleImpl.mPreloadResourceImpls.get(i))) {
        return true;
      }
      i += 1;
    }
  }
  
  public boolean isModuleFinish(PreloadServiceImpl paramPreloadServiceImpl)
  {
    paramPreloadServiceImpl = this.mPreloadResourceImpls.iterator();
    while (paramPreloadServiceImpl.hasNext()) {
      if (!((PreloadResourceImpl)paramPreloadServiceImpl.next()).isResFileExist(this)) {
        return false;
      }
    }
    return true;
  }
  
  public void removeResource(PreloadResourceImpl paramPreloadResourceImpl)
  {
    if (paramPreloadResourceImpl == null) {
      return;
    }
    this.mPreloadResourceImpls.remove(paramPreloadResourceImpl);
  }
  
  public String toString()
  {
    return "Module [mid=" + this.mid + ", mBC=" + this.mBackControl + ", mRes=" + this.mPreloadResourceImpls + "]";
  }
  
  public void updateNewModuleWhenReplace(PreloadModuleImpl paramPreloadModuleImpl, PreloadServiceImpl paramPreloadServiceImpl, int paramInt)
  {
    Iterator localIterator = this.mPreloadResourceImpls.iterator();
    while (localIterator.hasNext())
    {
      PreloadResourceImpl localPreloadResourceImpl1 = (PreloadResourceImpl)localIterator.next();
      PreloadResourceImpl localPreloadResourceImpl2 = paramPreloadModuleImpl.getResourceByResId(localPreloadResourceImpl1.mResId);
      if (localPreloadResourceImpl2 == null)
      {
        if ((!localPreloadResourceImpl1.mIsFromLocal) && (paramInt != localPreloadResourceImpl1.mFromType)) {
          paramPreloadModuleImpl.mPreloadResourceImpls.add(localPreloadResourceImpl1);
        }
      }
      else if (localPreloadResourceImpl1.isNeedDeleteOldFileWhenUpdate(this, localPreloadResourceImpl2, paramPreloadServiceImpl)) {
        localPreloadResourceImpl1.deleteResFile(this, paramPreloadServiceImpl, 3);
      }
    }
  }
  
  public void updatePreloadModule(PreloadModuleImpl paramPreloadModuleImpl, PreloadServiceImpl paramPreloadServiceImpl)
  {
    this.mid = paramPreloadModuleImpl.mid;
    this.mBackControl = paramPreloadModuleImpl.mBackControl;
    this.name = paramPreloadModuleImpl.name;
    this.option = paramPreloadModuleImpl.option;
    this.isForbidAutoDownload = paramPreloadModuleImpl.isForbidAutoDownload;
    this.mBaseUrl = paramPreloadModuleImpl.mBaseUrl;
    this.mRetryTimeInterval = paramPreloadModuleImpl.mRetryTimeInterval;
    this.mRetryCount = paramPreloadModuleImpl.mRetryCount;
    paramPreloadModuleImpl = paramPreloadModuleImpl.mPreloadResourceImpls.iterator();
    while (paramPreloadModuleImpl.hasNext())
    {
      PreloadResourceImpl localPreloadResourceImpl1 = (PreloadResourceImpl)paramPreloadModuleImpl.next();
      PreloadResourceImpl localPreloadResourceImpl2 = getResourceByResId(localPreloadResourceImpl1.mResId);
      if (localPreloadResourceImpl2 == null)
      {
        this.mPreloadResourceImpls.add(localPreloadResourceImpl1);
      }
      else
      {
        if (localPreloadResourceImpl2.isNeedDeleteOldFileWhenUpdate(this, localPreloadResourceImpl1, paramPreloadServiceImpl))
        {
          localPreloadResourceImpl2.deleteResFile(this, paramPreloadServiceImpl, 4);
          localPreloadResourceImpl2.mHasUnzip = false;
        }
        localPreloadResourceImpl2.mDownloadTime = localPreloadResourceImpl1.mDownloadTime;
        localPreloadResourceImpl2.mInvalidTime = localPreloadResourceImpl1.mInvalidTime;
        localPreloadResourceImpl2.md5 = localPreloadResourceImpl1.md5;
        localPreloadResourceImpl2.type = localPreloadResourceImpl1.type;
        localPreloadResourceImpl2.size = localPreloadResourceImpl1.size;
        localPreloadResourceImpl2.urlPath = localPreloadResourceImpl1.urlPath;
        localPreloadResourceImpl2.url = localPreloadResourceImpl1.url;
        localPreloadResourceImpl2.mResId = localPreloadResourceImpl1.mResId;
        localPreloadResourceImpl2.mFlowControl = localPreloadResourceImpl1.mFlowControl;
        localPreloadResourceImpl2.mIsFromLocal = localPreloadResourceImpl1.mIsFromLocal;
        localPreloadResourceImpl2.mIsTemp = localPreloadResourceImpl1.mIsTemp;
        localPreloadResourceImpl2.mIsNeedUnzip = localPreloadResourceImpl1.mIsNeedUnzip;
        localPreloadResourceImpl2.mIsUnzipInside = localPreloadResourceImpl1.mIsUnzipInside;
        localPreloadResourceImpl2.mUnzipPrefix = localPreloadResourceImpl1.mUnzipPrefix;
        localPreloadResourceImpl2.mFromType = localPreloadResourceImpl1.mFromType;
        localPreloadResourceImpl2.mFilePos = localPreloadResourceImpl1.mFilePos;
        localPreloadResourceImpl2.mAbi = localPreloadResourceImpl1.mAbi;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadModuleImpl
 * JD-Core Version:    0.7.0.1
 */