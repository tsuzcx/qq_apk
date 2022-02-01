package com.tencent.open.appcommon.now.download.local;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.open.appcommon.Common;
import com.tencent.open.appcommon.now.download.DownloadCenterImpl;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DownloadNativeApi
{
  private static DownloadNativeApi b;
  private DownloadCallbackNativeImpl a = new DownloadCallbackNativeImpl();
  
  public static DownloadNativeApi a()
  {
    if (b == null) {
      b = new DownloadNativeApi();
    }
    return b;
  }
  
  private DownloadInfo b(DownloadTaskInfo paramDownloadTaskInfo)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo(paramDownloadTaskInfo.a, paramDownloadTaskInfo.b);
    localDownloadInfo.d = paramDownloadTaskInfo.d;
    localDownloadInfo.n = paramDownloadTaskInfo.e;
    localDownloadInfo.x = paramDownloadTaskInfo.i;
    localDownloadInfo.w = paramDownloadTaskInfo.j;
    localDownloadInfo.f = paramDownloadTaskInfo.c;
    localDownloadInfo.j = paramDownloadTaskInfo.m;
    localDownloadInfo.o = paramDownloadTaskInfo.l;
    localDownloadInfo.p = 0;
    localDownloadInfo.A = true;
    return localDownloadInfo;
  }
  
  private boolean b()
  {
    return "com.tencent.mobileqq:tool".equals(Common.x());
  }
  
  public int a(Activity paramActivity, DownloadTaskInfo paramDownloadTaskInfo)
  {
    if (!b()) {
      return 401;
    }
    if (paramDownloadTaskInfo == null) {
      return 400;
    }
    if ((paramDownloadTaskInfo.f) && (!"com.tencent.now".equals(paramDownloadTaskInfo.c))) {
      return 402;
    }
    DownloadInfo localDownloadInfo = b(paramDownloadTaskInfo);
    localDownloadInfo.v = 2;
    localDownloadInfo.A = true;
    if ((HttpUtil.getNetWorkType() != 1) && (paramActivity != null) && (paramDownloadTaskInfo.k))
    {
      a(paramActivity, localDownloadInfo, paramDownloadTaskInfo);
    }
    else
    {
      DownloadCenterImpl.a().a(localDownloadInfo);
      this.a.a(paramDownloadTaskInfo);
    }
    return 200;
  }
  
  public int a(DownloadTaskInfo paramDownloadTaskInfo)
  {
    if (!b()) {
      return 401;
    }
    if (paramDownloadTaskInfo == null) {
      return -1;
    }
    paramDownloadTaskInfo = b(paramDownloadTaskInfo);
    paramDownloadTaskInfo.v = 13;
    paramDownloadTaskInfo.o = 0;
    int i = DownloadCenterImpl.a().b(paramDownloadTaskInfo);
    if (i == 1) {
      return 1;
    }
    if (i == 0) {
      return 0;
    }
    return -1;
  }
  
  public int a(String paramString)
  {
    if (!b()) {
      return 401;
    }
    this.a.a(paramString);
    DownloadCenterImpl.a().a(paramString);
    return 200;
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!b()) {
      return 401;
    }
    DownloadCenterImpl.a().a(paramString1, paramString2);
    return 200;
  }
  
  public int a(List<DownloadTaskInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return 400;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = b((DownloadTaskInfo)paramList.next());
        localDownloadInfo.o = 0;
        localArrayList.add(localDownloadInfo);
      }
      if (DownloadCenterImpl.a().a(localArrayList) != 0) {
        return 400;
      }
      return 200;
    }
    return 400;
  }
  
  public void a(Activity paramActivity, DownloadInfo paramDownloadInfo, DownloadTaskInfo paramDownloadTaskInfo)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadNativeApi.1(this, paramDownloadInfo, paramDownloadTaskInfo, paramActivity));
  }
  
  public void a(DownloadNativeApi.IDownloadObserver paramIDownloadObserver)
  {
    this.a.a(paramIDownloadObserver);
    DownloadCenterImpl.a().a(this.a);
  }
  
  public void b(DownloadNativeApi.IDownloadObserver paramIDownloadObserver)
  {
    this.a.a();
    this.a.b(paramIDownloadObserver);
    DownloadCenterImpl.a().b(this.a);
  }
  
  public boolean b(String paramString)
  {
    return AppUtil.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.local.DownloadNativeApi
 * JD-Core Version:    0.7.0.1
 */