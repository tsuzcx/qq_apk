package com.tencent.open.appcommon.now.download;

import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.now.api.INowUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class DownloadCenterImpl
{
  private static DownloadCenterImpl a;
  private ArrayList<IDownloadCallback> b = new ArrayList();
  private INetEventHandler c = new DownloadCenterImpl.1(this);
  private DownloadListener d = new DownloadCenterImpl.2(this);
  
  public DownloadCenterImpl()
  {
    DownloadManager.b().a(this.d);
    AppNetConnInfo.registerNetChangeReceiver(CommonDataAdapter.a().b(), this.c);
  }
  
  public static DownloadCenterImpl a()
  {
    if (a == null) {
      a = new DownloadCenterImpl();
    }
    return a;
  }
  
  public int a(ArrayList<DownloadInfo> paramArrayList)
  {
    if (paramArrayList == null)
    {
      LogUtility.a("DownloadCenterImpl", "getDownloadProgressById infos == null");
      return -1;
    }
    ThreadManager.getSubThreadHandler().post(new DownloadCenterImpl.3(this, paramArrayList));
    return 0;
  }
  
  public void a(IDownloadCallback paramIDownloadCallback)
  {
    if (paramIDownloadCallback != null)
    {
      ArrayList localArrayList = this.b;
      if ((localArrayList != null) && (!localArrayList.contains(paramIDownloadCallback))) {
        this.b.add(paramIDownloadCallback);
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    if (((INowUtil)QRoute.api(INowUtil.class)).checkNowApkExist(paramDownloadInfo.c, paramDownloadInfo.e))
    {
      paramDownloadInfo.a(4);
      paramDownloadInfo.q = ((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath();
      DownloadManager.b().f(paramDownloadInfo);
      this.d.onDownloadFinish(paramDownloadInfo);
      return;
    }
    DownloadManager.b().a(paramDownloadInfo);
  }
  
  public void a(DownloadInfo paramDownloadInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    DownloadManager.b().a(paramDownloadInfo, paramApkUpdateDetail);
  }
  
  public void a(String paramString)
  {
    DownloadManager.b().g(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    DownloadInfo localDownloadInfo = DownloadManager.b().d(paramString1);
    paramString1 = localDownloadInfo;
    if (localDownloadInfo == null) {
      paramString1 = DownloadManager.b().f(paramString2);
    }
    if (paramString1 != null)
    {
      paramString1.v = 5;
      paramString1.o = 0;
      paramString1.p = 0;
      DownloadManager.b().d(paramString1);
    }
  }
  
  public int b(DownloadInfo paramDownloadInfo)
  {
    boolean bool = AppUtil.a(paramDownloadInfo.e);
    int j = 1;
    int m = 1;
    int k = 0;
    int i;
    if (bool)
    {
      i = m;
      if (paramDownloadInfo.n != 0)
      {
        i = m;
        if (paramDownloadInfo.n > AppUtil.d("com.tencent.now")) {
          i = 0;
        }
      }
      paramDownloadInfo.a(13);
      localObject1 = this.b.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((IDownloadCallback)((Iterator)localObject1).next()).a(paramDownloadInfo, i);
      }
      return i;
    }
    DownloadInfo localDownloadInfo = DownloadManager.b().d(paramDownloadInfo.c);
    if ("com.tencent.now".equals(paramDownloadInfo.e))
    {
      bool = ((INowUtil)QRoute.api(INowUtil.class)).checkNowApkExist(paramDownloadInfo.c, paramDownloadInfo.e);
      if (localDownloadInfo == null)
      {
        i = k;
        if (!bool) {
          break label904;
        }
        i = AppUtil.e(((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath());
        if ((paramDownloadInfo.n != 0) && (paramDownloadInfo.n > i))
        {
          ((INowUtil)QRoute.api(INowUtil.class)).delete(((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath());
          i = 0;
        }
        else
        {
          localObject1 = new DownloadInfo(paramDownloadInfo.c, paramDownloadInfo.d, paramDownloadInfo.e, paramDownloadInfo.f, paramDownloadInfo.h, null, paramDownloadInfo.r, paramDownloadInfo.A);
          ((DownloadInfo)localObject1).a(4);
          ((DownloadInfo)localObject1).q = ((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath();
          ((DownloadInfo)localObject1).x = paramDownloadInfo.x;
          DownloadManager.b().f((DownloadInfo)localObject1);
        }
      }
      for (i = j;; i = j)
      {
        break label904;
        localObject1 = localDownloadInfo.q;
        if ((!((INowUtil)QRoute.api(INowUtil.class)).isExists((String)localObject1)) && (!bool))
        {
          i = k;
          if (localDownloadInfo.a() != 4) {
            break label904;
          }
          DownloadManager.b().a(localDownloadInfo.c, true);
          i = k;
          break label904;
        }
        if (bool) {
          i = AppUtil.e(((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath());
        } else {
          i = AppUtil.e((String)localObject1);
        }
        if ((paramDownloadInfo.n != 0) && (paramDownloadInfo.n > i))
        {
          DownloadManager.b().a(localDownloadInfo.c, true);
          ((INowUtil)QRoute.api(INowUtil.class)).delete(((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath());
          ((INowUtil)QRoute.api(INowUtil.class)).delete((String)localObject1);
          break;
        }
        if (!bool)
        {
          if (((INowUtil)QRoute.api(INowUtil.class)).copyNowApkToCommonDir((String)localObject1, paramDownloadInfo.c, paramDownloadInfo.e))
          {
            ((INowUtil)QRoute.api(INowUtil.class)).delete((String)localObject1);
            localDownloadInfo.q = ((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath();
          }
        }
        else if (!((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath().equals(localObject1))
        {
          ((INowUtil)QRoute.api(INowUtil.class)).delete((String)localObject1);
          localDownloadInfo.q = ((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath();
        }
        localDownloadInfo.a(4);
        DownloadManager.b().f(localDownloadInfo);
      }
    }
    else
    {
      i = k;
      if (localDownloadInfo != null)
      {
        Object localObject2 = "";
        if (TextUtils.isEmpty(localDownloadInfo.q))
        {
          i = localDownloadInfo.o;
          TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
          TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
          if (i == 0)
          {
            localTMAssistantDownloadTaskInfo2 = DownloadManager.b().h(localDownloadInfo.d);
            localObject1 = localObject2;
            if (localTMAssistantDownloadTaskInfo2 != null)
            {
              localObject1 = localObject2;
              if (localTMAssistantDownloadTaskInfo2.mState == 4) {
                localObject1 = localTMAssistantDownloadTaskInfo2.mSavePath;
              }
            }
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localTMAssistantDownloadTaskInfo1 = DownloadManager.b().c(localDownloadInfo);
              localObject2 = localObject1;
            }
          }
          else
          {
            localTMAssistantDownloadTaskInfo2 = DownloadManager.b().c(localDownloadInfo);
            localObject1 = localObject2;
            if (localTMAssistantDownloadTaskInfo2 != null)
            {
              localObject1 = localObject2;
              if (localTMAssistantDownloadTaskInfo2.mState == 4) {
                localObject1 = localTMAssistantDownloadTaskInfo2.mSavePath;
              }
            }
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localTMAssistantDownloadTaskInfo1 = DownloadManager.b().h(localDownloadInfo.d);
              localObject2 = localObject1;
            }
          }
          localObject1 = localObject2;
          if (localTMAssistantDownloadTaskInfo1 != null)
          {
            localObject1 = localObject2;
            if (localTMAssistantDownloadTaskInfo1.mState == 4) {
              localObject1 = localTMAssistantDownloadTaskInfo1.mSavePath;
            }
          }
          localObject2 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localDownloadInfo.q = ((String)localObject1);
            localDownloadInfo.a(4);
            DownloadManager.b().f(localDownloadInfo);
            localObject2 = localObject1;
          }
        }
        else
        {
          localObject2 = localDownloadInfo.q;
        }
        i = k;
        if (!StringUtil.isEmpty((String)localObject2))
        {
          i = k;
          if (((INowUtil)QRoute.api(INowUtil.class)).isExists((String)localObject2)) {
            i = 1;
          }
        }
      }
    }
    label904:
    paramDownloadInfo.a(13);
    Object localObject1 = this.b.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((IDownloadCallback)((Iterator)localObject1).next()).a(paramDownloadInfo, i);
    }
    return i;
  }
  
  public void b(IDownloadCallback paramIDownloadCallback)
  {
    ArrayList localArrayList = this.b;
    if (localArrayList != null) {
      localArrayList.remove(paramIDownloadCallback);
    }
  }
  
  public void b(String paramString)
  {
    DownloadInfo localDownloadInfo = DownloadManager.b().d(paramString);
    DownloadManager.b().a(paramString, true);
    DownloadManager.b().a(10, localDownloadInfo);
  }
  
  public DownloadInfo c(String paramString)
  {
    return DownloadManager.b().d(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.DownloadCenterImpl
 * JD-Core Version:    0.7.0.1
 */