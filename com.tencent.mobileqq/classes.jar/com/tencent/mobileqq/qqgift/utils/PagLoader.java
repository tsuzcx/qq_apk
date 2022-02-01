package com.tencent.mobileqq.qqgift.utils;

import android.content.Context;
import android.os.Bundle;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.vas.api.IVasTempApi.Companion;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class PagLoader
{
  final Object a = new Object();
  private int b = 0;
  private List<PagLoader.PagLoadListener> c = new ArrayList();
  private PagSoLoaderBroadcastReceiver d = null;
  private Context e;
  
  private void a(Context paramContext)
  {
    ??? = IVasTempApi.Companion.a();
    if (MobileQQ.sProcessId != 1) {
      try
      {
        if (((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BASE_PACKAGE))
        {
          QLog.i("PagLoader", 1, "already download");
          a(((IVasTempApi)???).initPagSo());
          return;
        }
        if (this.d != null)
        {
          QLog.i("PagLoader", 1, "loadPagWithIPC loadPagWithIPC is not null! return.");
          return;
        }
        synchronized (this.a)
        {
          this.e = paramContext;
          this.d = new PagSoLoaderBroadcastReceiver();
          if (paramContext != null) {
            paramContext.registerReceiver(this.d, this.d.a());
          }
          paramContext = new Bundle();
          paramContext.putString("KEY_RES_PREFIX", AEResInfo.LIGHT_RES_BASE_PACKAGE.resPrefix);
          QIPCClientHelper.getInstance().getClient().callServer("AECameraGetInfoServer", "ACTION_DOWNLOAD_AE_RES", paramContext);
          return;
        }
        ((IVasTempApi)???).requestPagDownload(new PagLoader.1(this, (IVasTempApi)???));
      }
      catch (Throwable paramContext)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("loadPagWithIPC throw e:");
        ((StringBuilder)???).append(paramContext.getMessage());
        QLog.e("PagLoader", 1, ((StringBuilder)???).toString());
        return;
      }
    }
  }
  
  public void a(Context paramContext, PagLoader.PagLoadListener paramPagLoadListener)
  {
    if (a())
    {
      if (paramPagLoadListener != null) {
        paramPagLoadListener.a(true);
      }
      return;
    }
    if (paramPagLoadListener != null) {
      this.c.add(paramPagLoadListener);
    }
    if (this.b == 1) {
      return;
    }
    this.b = 1;
    a(paramContext);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b = 2;
    } else {
      this.b = 0;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((PagLoader.PagLoadListener)localIterator.next()).a(paramBoolean);
    }
    this.c.clear();
  }
  
  public boolean a()
  {
    return this.b == 2;
  }
  
  public void b()
  {
    try
    {
      synchronized (this.a)
      {
        if ((this.e != null) && (this.d != null))
        {
          this.e.unregisterReceiver(this.d);
          this.e = null;
          this.d = null;
        }
        return;
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Throwable localThrowable)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("unRegisterPagSoLoaderReceiver throw e:");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.e("PagLoader", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.utils.PagLoader
 * JD-Core Version:    0.7.0.1
 */