package com.tencent.tmdownloader.internal.downloadservice;

import android.text.TextUtils;
import com.tencent.hlyyb.HalleyAgent;
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmassistantbase.network.INetworkChangedObserver;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.aa;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.o;
import com.tencent.tmdownloader.internal.storage.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ApkDownloadManager
  implements INetworkChangedObserver
{
  protected static final String TAG = "ApkDownloadManager";
  protected static ApkDownloadManager mApkDownloadManager;
  final ConcurrentHashMap<String, c> mDownloads = new ConcurrentHashMap();
  protected long mLastAutoDownloadTime = 0L;
  protected long mLastAutoPauseTime = 0L;
  protected String mLastNetType = "";
  private boolean mLeaving = false;
  final ConcurrentHashMap<String, String> mPkgURL = new ConcurrentHashMap();
  
  public static ApkDownloadManager getInstance()
  {
    if (mApkDownloadManager == null) {
      mApkDownloadManager = new ApkDownloadManager();
    }
    return mApkDownloadManager;
  }
  
  public void AddDownloadListener(h paramh)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call AddDownloadListener, dl: ");
    localStringBuilder.append(paramh);
    ab.c("ApkDownloadManager", localStringBuilder.toString());
    f.a().a(paramh);
  }
  
  public void RemoveDownloadListener(h paramh)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call RemoveDownloadListener, dl: ");
    localStringBuilder.append(paramh);
    ab.c("ApkDownloadManager", localStringBuilder.toString());
    f.a().b(paramh);
  }
  
  public void cancelDownload(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call cancelDownload, url: ");
    localStringBuilder.append(paramString);
    ab.c("ApkDownloadManager", localStringBuilder.toString());
    paramString = (c)this.mDownloads.remove(paramString);
    if (paramString != null) {
      paramString.e();
    }
  }
  
  public void continueDownload(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call continueDownload, url: ");
    localStringBuilder.append(paramString);
    ab.c("ApkDownloadManager", localStringBuilder.toString());
    paramString = (c)this.mDownloads.get(paramString);
    if (paramString != null) {
      paramString.c();
    }
  }
  
  public void deleteDownload(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call deleteDownload, url: ");
    localStringBuilder.append(paramString);
    ab.c("ApkDownloadManager", localStringBuilder.toString());
    paramString = (c)this.mDownloads.remove(paramString);
    if (paramString != null) {
      paramString.f();
    }
  }
  
  public void init()
  {
    if ((!this.mLeaving) && (GlobalUtil.getInstance().getContext() != null))
    {
      long l = System.currentTimeMillis();
      HalleyAgent.init(GlobalUtil.getInstance().getContext(), "", "");
      localObject1 = GlobalUtil.getInstance().getPhoneGuid();
      HalleyAgent.getDownloader().setPhoneGuid((String)localObject1);
      HalleyAgent.getDownloader().setTaskNumForCategory(DownloaderTaskCategory.Cate_DefaultMass, 3);
      HalleyAgent.getDownloader().setNotNetworkWaitMillis(5000);
      ab.c("ApkDownloadManager", "Start to load DownloadInfo list.");
      this.mDownloads.clear();
      localObject1 = a.a().b();
      if (localObject1 != null)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("The size of downloadinfo_list: ");
        ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
        ab.c("ApkDownloadManager", ((StringBuilder)localObject2).toString());
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (c)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            ab.c("ApkDownloadManager", "---------------load download info---------------");
            ((c)localObject2).a("ApkDownloadManager");
            if (!TextUtils.isEmpty(((c)localObject2).b)) {
              this.mDownloads.put(((c)localObject2).b, localObject2);
            }
            if (!((c)localObject2).b()) {
              ((c)localObject2).a(3);
            }
            if ((!TextUtils.isEmpty(((c)localObject2).b)) && (!TextUtils.isEmpty(((c)localObject2).r))) {
              this.mPkgURL.put(((c)localObject2).r, ((c)localObject2).b);
            }
          }
        }
      }
      ab.c("ApkDownloadManager", "Add NetworkChangedObserver to NetworkMonitorReceiver");
      NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(this);
      this.mLastNetType = b.a();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ApkDownloadManager init end, timeCost = ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      aa.a(((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("init failed: mLeaving = ");
    ((StringBuilder)localObject1).append(this.mLeaving);
    ((StringBuilder)localObject1).append(", context = ");
    ((StringBuilder)localObject1).append(GlobalUtil.getInstance().getContext());
    ab.e("ApkDownloadManager", ((StringBuilder)localObject1).toString());
  }
  
  public Boolean isAllDownloadFinished()
  {
    Iterator localIterator = this.mDownloads.keySet().iterator();
    while (localIterator.hasNext()) {
      if (!((c)this.mDownloads.get(localIterator.next())).b()) {
        return Boolean.valueOf(false);
      }
    }
    return Boolean.valueOf(true);
  }
  
  public void onNetworkChanged()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("halleytest onNetworkChanged and isNetworkConncted=");
      ((StringBuilder)localObject1).append(b.b());
      ((StringBuilder)localObject1).append(",isAutoDownloadOrPause=");
      ((StringBuilder)localObject1).append(g.a().c());
      ab.c("ApkDownloadManager", ((StringBuilder)localObject1).toString());
      o.c();
      if ((b.b()) && (g.a().c()))
      {
        localObject1 = b.a();
        Iterator localIterator = this.mDownloads.keySet().iterator();
        while (localIterator.hasNext())
        {
          c localc = (c)this.mDownloads.get(localIterator.next());
          if ((localc != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("halleytest onNetworkChanged and di.mAppName = ");
            localStringBuilder.append(localc.E);
            localStringBuilder.append(",di.mStatus=");
            localStringBuilder.append(localc.g);
            localStringBuilder.append(",di.mIsPausedByMobl=");
            localStringBuilder.append(localc.G);
            ab.c("ApkDownloadManager", localStringBuilder.toString());
            if (((localc.g == 3) && (localc.G)) || ((localc.g == 5) && (g.a().a(this.mLastNetType, (String)localObject1))))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("halleytest onNetworkChanged di.mAppName = ");
              localStringBuilder.append(localc.E);
              localStringBuilder.append("and startDownloadIfReady");
              ab.c("ApkDownloadManager", localStringBuilder.toString());
              localc.c();
            }
            if (((localc.g == 2) || (localc.g == 1)) && (g.a().b(this.mLastNetType, (String)localObject1)))
            {
              localc.d();
              localc.G = true;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("halleytest onNetworkChanged di.mAppName = ");
              localStringBuilder.append(localc.E);
              localStringBuilder.append("and pauseDownload, di.mIsPausedByMoble=");
              localStringBuilder.append(localc.G);
              ab.c("ApkDownloadManager", localStringBuilder.toString());
            }
          }
        }
        this.mLastNetType = ((String)localObject1);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void pauseDownload(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call pauseDownload, url: ");
    localStringBuilder.append(paramString);
    ab.c("ApkDownloadManager", localStringBuilder.toString());
    paramString = (c)this.mDownloads.get(paramString);
    if (paramString != null) {
      paramString.d();
    }
  }
  
  public c queryDownloadInfo(String paramString)
  {
    Object localObject2 = (c)this.mDownloads.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = a.a().b(paramString);
    }
    boolean bool = false;
    if (localObject1 != null) {
      if (((c)localObject1).a.equals("application/tm.android.apkdiff")) {
        bool = b.b(paramString, ((c)localObject1).a);
      } else {
        bool = b.f(((c)localObject1).j);
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((c)localObject1).a())
      {
        localObject2 = localObject1;
        if (!bool)
        {
          this.mDownloads.remove(paramString);
          a.a().a(paramString);
          localObject2 = null;
        }
      }
    }
    return localObject2;
  }
  
  public c queryDownloadInfoByPkgName(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = (String)this.mPkgURL.get(paramString);
      if (!TextUtils.isEmpty(paramString)) {
        return queryDownloadInfo(paramString);
      }
    }
    return null;
  }
  
  public List<c> queryDownloadInfoByVia(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ApkDownloadManager queryDownloadInfoByVia");
    ((StringBuilder)localObject1).append(paramString);
    ab.b("ApkDownloadManager", ((StringBuilder)localObject1).toString());
    if (paramString == null) {
      return null;
    }
    localObject1 = new ArrayList();
    Iterator localIterator = this.mDownloads.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      localObject2 = (c)this.mDownloads.get(((Map.Entry)localObject2).getKey());
      if ((localObject2 != null) && (!TextUtils.isEmpty(((c)localObject2).x)) && (((c)localObject2).x.contains(paramString)))
      {
        ((c)localObject2).a("jimluo");
        ((List)localObject1).add(localObject2);
      }
    }
    return localObject1;
  }
  
  public void restartDownload(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call restartDownload, url: ");
    localStringBuilder.append(paramString);
    ab.c("ApkDownloadManager", localStringBuilder.toString());
    paramString = (c)this.mDownloads.get(paramString);
    if (paramString != null) {
      paramString.c();
    }
  }
  
  public int startDownload(String paramString1, int paramInt, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("call startDownload, url: ");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("priority: ");
    ((StringBuilder)localObject1).append(paramInt);
    ab.c("ApkDownloadManager", ((StringBuilder)localObject1).toString());
    if (!b.b())
    {
      ab.c("ApkDownloadManager", "call startDownload, return errCode: 1");
      return 1;
    }
    if ((!b.a().equalsIgnoreCase("wifi")) && (g.a().b()))
    {
      ab.c("ApkDownloadManager", "call startDownload, return errCode: 2");
      return 2;
    }
    if (!b.e(paramString1))
    {
      ab.c("ApkDownloadManager", "call startDownload, return errCode: 3");
      return 3;
    }
    if (b.b(paramString1, paramString2))
    {
      ab.c("ApkDownloadManager", "call startDownload, return errCode: 4");
      return 4;
    }
    Object localObject4 = (c)this.mDownloads.get(paramString1);
    if (localObject4 == null)
    {
      localObject4 = a.a().b(paramString1);
      if (localObject4 == null)
      {
        localObject4 = new c(paramString1, paramInt, paramString2);
        if (paramMap != null)
        {
          localObject1 = (String)paramMap.remove(TMAssistantDownloadConst.PARAM_APPID);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            try
            {
              ((c)localObject4).q = Long.parseLong((String)localObject1);
            }
            catch (Exception localException1)
            {
              ab.c("ApkDownloadManager", "call startDownload appid parse Exception: ", localException1);
            }
          }
          ((c)localObject4).r = ((String)paramMap.remove(TMAssistantDownloadConst.PARAM_TASK_PACKNAME));
          ((c)localObject4).s = ((String)paramMap.remove(TMAssistantDownloadConst.PARAM_TASK_VERSION));
          ((c)localObject4).x = ((String)paramMap.remove(TMAssistantDownloadConst.PARAM_VIA));
        }
      }
    }
    try
    {
      ((c)localObject4).I = Long.valueOf((String)paramMap.remove(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE)).longValue();
    }
    catch (Exception localException7)
    {
      label311:
      String str1;
      String str2;
      Object localObject2;
      String str3;
      String str4;
      ApkDownloadManager localApkDownloadManager;
      boolean bool;
      Object localObject3;
      break label311;
    }
    ab.d("ApkDownloadManager", "fileSize未传，不影响下载");
    str1 = (String)paramMap.remove(TMAssistantDownloadConst.PARAM_DOWNLOADTSTYLE);
    if (!TextUtils.isEmpty(str1)) {
      try
      {
        ((c)localObject4).H = Integer.parseInt(str1);
      }
      catch (Exception localException2)
      {
        ab.c("ApkDownloadManager", "call startDownload downloadStyle parseException: ", localException2);
      }
    }
    str2 = (String)paramMap.remove(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE);
    if (!TextUtils.isEmpty(str2)) {
      try
      {
        ((c)localObject4).I = Long.parseLong(str2);
      }
      catch (Exception localException3)
      {
        ab.c("ApkDownloadManager", "call startDownload fileSize parseException: ", localException3);
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("halley startDownload mDownloadStyle=");
    ((StringBuilder)localObject2).append(((c)localObject4).H);
    ((StringBuilder)localObject2).append(",mFileSize=");
    ((StringBuilder)localObject2).append(((c)localObject4).I);
    ab.b("ApkDownloadManager", ((StringBuilder)localObject2).toString());
    localObject2 = (String)paramMap.remove(TMAssistantDownloadConst.PARAM_UIN);
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      try
      {
        ((c)localObject4).v = Long.parseLong((String)localObject2);
      }
      catch (Exception localException4)
      {
        ab.c("ApkDownloadManager", "call startDownload uin parseException: ", localException4);
      }
    }
    ((c)localObject4).w = ((String)paramMap.remove(TMAssistantDownloadConst.PARAM_UIN_TYPE));
    ((c)localObject4).y = ((String)paramMap.remove(TMAssistantDownloadConst.PARAM_CHANNELID));
    ((c)localObject4).z = UUID.randomUUID().toString();
    ((c)localObject4).A = ((String)paramMap.remove(TMAssistantDownloadConst.PARAM_EXTRA_DATA));
    str3 = (String)paramMap.remove(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE);
    if (!TextUtils.isEmpty(str3)) {
      try
      {
        ((c)localObject4).B = Integer.parseInt(str3);
      }
      catch (Exception localException5)
      {
        ab.c("ApkDownloadManager", "call startDownload downloadType parse Exception: ", localException5);
      }
    }
    ((c)localObject4).D = ((String)paramMap.remove(TMAssistantDownloadConst.PARAM_ICON_URL));
    ((c)localObject4).E = ((String)paramMap.remove(TMAssistantDownloadConst.PARAM_APP_NAME));
    str4 = (String)paramMap.remove(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION);
    if (!TextUtils.isEmpty(str4)) {
      try
      {
        ((c)localObject4).K = Integer.parseInt(str4);
      }
      catch (Exception localException6)
      {
        ab.c("ApkDownloadManager", "call startDownload showNotification parse Exception: ", localException6);
      }
    }
    ((c)localObject4).F = Boolean.valueOf((String)paramMap.remove(TMAssistantDownloadConst.PARAM_IS_AUTOINSTALL_BY_SDK)).booleanValue();
    if (((c)localObject4).a.equals("resource/tm.android.unknown")) {
      ((c)localObject4).j = paramString3;
    }
    do
    {
      localApkDownloadManager = this;
      break;
      if (((c)localObject4).a.equals("application/tm.android.apkdiff")) {
        bool = b.b(paramString1, ((c)localObject4).a);
      } else {
        bool = b.f(((c)localObject4).j);
      }
    } while (!bool);
    ab.c("ApkDownloadManager", "call startDownload, return errCode: 4");
    return 4;
    localApkDownloadManager.mDownloads.put(paramString1, localObject4);
    localObject3 = localObject4;
    if (!TextUtils.isEmpty(((c)localObject4).r))
    {
      localApkDownloadManager.mPkgURL.put(((c)localObject4).r, paramString1);
      localObject3 = localObject4;
      break label897;
      localObject3 = localObject4;
      if (b.f(((c)localObject4).j))
      {
        ab.c("ApkDownloadManager", "call startDownload, return errCode: 4");
        return 4;
      }
    }
    label897:
    localApkDownloadManager = this;
    if (localObject3.a.equals("application/tm.android.apkdiff")) {
      bool = b.b(paramString1, localObject3.a);
    } else {
      bool = b.f(localObject3.j);
    }
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("call startDownload, fileExited = ");
    ((StringBuilder)localObject4).append(bool);
    ab.c("ApkDownloadManager", ((StringBuilder)localObject4).toString());
    if (paramMap != null)
    {
      localObject3.L = ((String)paramMap.remove(TMAssistantDownloadConst.PARAM_QQ_SOURCE_ID));
      localObject3.M = ((String)paramMap.remove(TMAssistantDownloadConst.PARAM_CALL_STACK));
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("di.mQQBusinessId = ");
      ((StringBuilder)localObject4).append(localObject3.L);
      ab.c("ApkDownloadManager", ((StringBuilder)localObject4).toString());
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("di.mCallingStack = ");
      ((StringBuilder)localObject4).append(localObject3.M);
      ab.c("ApkDownloadManager", ((StringBuilder)localObject4).toString());
    }
    else
    {
      ab.e("ApkDownloadManager", "headerParams is null");
    }
    localObject4 = localObject3;
    if (localObject3.a())
    {
      localObject4 = localObject3;
      if (!bool)
      {
        localApkDownloadManager.mDownloads.remove(paramString1);
        a.a().a(paramString1);
        localObject4 = new c(paramString1, paramInt, paramString2);
        if (paramMap != null)
        {
          paramString2 = (String)paramMap.remove(TMAssistantDownloadConst.PARAM_APPID);
          if (!TextUtils.isEmpty(paramString2)) {
            try
            {
              ((c)localObject4).q = Long.parseLong(paramString2);
            }
            catch (Exception paramString2)
            {
              ab.c("ApkDownloadManager", "call startDownload appid parse Exception: ", paramString2);
            }
          }
          ((c)localObject4).r = ((String)paramMap.remove(TMAssistantDownloadConst.PARAM_TASK_PACKNAME));
          ((c)localObject4).s = ((String)paramMap.remove(TMAssistantDownloadConst.PARAM_TASK_VERSION));
          ((c)localObject4).x = ((String)paramMap.remove(TMAssistantDownloadConst.PARAM_VIA));
          paramString2 = (String)paramMap.remove(TMAssistantDownloadConst.PARAM_DOWNLOADTSTYLE);
          if (!TextUtils.isEmpty(paramString2)) {
            try
            {
              ((c)localObject4).H = Integer.parseInt(paramString2);
            }
            catch (Exception paramString2)
            {
              ab.c("ApkDownloadManager", "call startDownload downloadStyle parseException: ", paramString2);
            }
          }
          paramString2 = (String)paramMap.remove(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE);
          if (!TextUtils.isEmpty(paramString2)) {
            try
            {
              ((c)localObject4).I = Long.parseLong(paramString2);
            }
            catch (Exception paramString2)
            {
              ab.c("ApkDownloadManager", "call startDownload fileSize parseException: ", paramString2);
            }
          }
          paramString2 = new StringBuilder();
          paramString2.append("halley startDownload mDownloadStyle=");
          paramString2.append(((c)localObject4).H);
          paramString2.append(",mFileSize=");
          paramString2.append(((c)localObject4).I);
          ab.b("ApkDownloadManager", paramString2.toString());
          paramString2 = (String)paramMap.remove(TMAssistantDownloadConst.PARAM_UIN);
          if (!TextUtils.isEmpty(paramString2)) {
            try
            {
              ((c)localObject4).v = Long.parseLong(paramString2);
            }
            catch (Exception paramString2)
            {
              ab.c("ApkDownloadManager", "call startDownload uin parse Exception: ", paramString2);
            }
          }
          ((c)localObject4).w = ((String)paramMap.remove(TMAssistantDownloadConst.PARAM_UIN_TYPE));
          ((c)localObject4).y = ((String)paramMap.remove(TMAssistantDownloadConst.PARAM_CHANNELID));
          ((c)localObject4).z = UUID.randomUUID().toString();
          ((c)localObject4).A = ((String)paramMap.remove(TMAssistantDownloadConst.PARAM_EXTRA_DATA));
          paramString2 = (String)paramMap.remove(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE);
          if (!TextUtils.isEmpty(paramString2)) {
            try
            {
              ((c)localObject4).B = Integer.parseInt(paramString2);
            }
            catch (Exception paramString2)
            {
              ab.c("ApkDownloadManager", "call startDownload downloadType parse Exception: ", paramString2);
            }
          }
          ((c)localObject4).D = ((String)paramMap.remove(TMAssistantDownloadConst.PARAM_ICON_URL));
          ((c)localObject4).E = ((String)paramMap.remove(TMAssistantDownloadConst.PARAM_APP_NAME));
          paramString2 = (String)paramMap.remove(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION);
          if (!TextUtils.isEmpty(paramString2)) {
            try
            {
              ((c)localObject4).K = Integer.parseInt(paramString2);
            }
            catch (Exception paramString2)
            {
              ab.c("ApkDownloadManager", "call startDownload showNotification parse Exception: ", paramString2);
            }
          }
          ((c)localObject4).F = Boolean.valueOf((String)paramMap.remove(TMAssistantDownloadConst.PARAM_IS_AUTOINSTALL_BY_SDK)).booleanValue();
        }
        if (((c)localObject4).a.equals("resource/tm.android.unknown")) {
          ((c)localObject4).j = paramString3;
        }
        ((c)localObject4).a((HashMap)paramMap);
        localApkDownloadManager.mDownloads.put(paramString1, localObject4);
        if (!TextUtils.isEmpty(((c)localObject4).r)) {
          localApkDownloadManager.mPkgURL.put(((c)localObject4).r, paramString1);
        }
      }
    }
    ((c)localObject4).a((HashMap)paramMap);
    paramInt = ((c)localObject4).c();
    paramString1 = new StringBuilder();
    paramString1.append("call startDownload, return errCode: ");
    paramString1.append(paramInt);
    ab.c("ApkDownloadManager", paramString1.toString());
    return paramInt;
  }
  
  public void uninit()
  {
    this.mLeaving = true;
    ArrayList localArrayList = new ArrayList();
    if (!this.mDownloads.isEmpty())
    {
      Iterator localIterator = this.mDownloads.keySet().iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)this.mDownloads.get(localIterator.next());
        if (localc.g == 2) {
          pauseDownload(localc.b);
        }
        localArrayList.add(localc);
      }
    }
    ab.c("ApkDownloadManager", "Start to save DownloadInfo list.");
    a.a().a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager
 * JD-Core Version:    0.7.0.1
 */