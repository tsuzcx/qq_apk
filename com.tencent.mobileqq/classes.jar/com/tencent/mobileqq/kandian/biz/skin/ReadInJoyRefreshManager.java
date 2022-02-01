package com.tencent.mobileqq.kandian.biz.skin;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ReadInJoyRefreshManager
  implements Manager
{
  public static volatile boolean j = true;
  protected AppInterface a;
  protected DownloaderInterface b;
  protected HashMap<String, String> c = new HashMap();
  protected ArrayList<ReadInJoyRefreshManager.OnRefreshChangedListener> d = new ArrayList();
  protected int e = -1;
  protected String f = "";
  protected long g = -1L;
  protected int h = -1;
  protected boolean i = false;
  private int k = -1;
  
  public ReadInJoyRefreshManager(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
    this.b = ((DownloaderFactory)paramAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
  }
  
  public static RefreshData b(Context paramContext, int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (ReadInJoyRefreshManager)((AppRuntime)localObject).getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
      if (localObject != null) {
        return ((ReadInJoyRefreshManager)localObject).a(paramContext, paramInt);
      }
    }
    return null;
  }
  
  private void b(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramString;
    this.g = paramLong;
    this.h = paramInt2;
    RefreshRes.a(this.f, paramLong);
    paramInt1 = 0;
    while (paramInt1 < this.d.size())
    {
      ((ReadInJoyRefreshManager.OnRefreshChangedListener)this.d.get(paramInt1)).a(this.e, this.f, this.g);
      paramInt1 += 1;
    }
  }
  
  public RefreshData a(Context paramContext, int paramInt)
  {
    paramContext = SharedPreUtils.P(paramContext, this.a.getCurrentAccountUin(), paramInt);
    RefreshData localRefreshData = null;
    if (paramContext != null) {}
    try
    {
      paramContext = new JSONObject(paramContext);
    }
    catch (Exception paramContext)
    {
      label31:
      break label31;
    }
    paramContext = null;
    if (paramContext != null) {
      localRefreshData = new RefreshData(paramContext);
    }
    return localRefreshData;
  }
  
  public void a()
  {
    this.e = -1;
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      b(paramInt1, paramString, paramLong, paramInt2);
      return;
    }
    ThreadManager.getUIHandler().post(new ReadInJoyRefreshManager.1(this, paramInt1, paramString, paramLong, paramInt2));
  }
  
  public void a(ReadInJoyRefreshManager.OnRefreshChangedListener paramOnRefreshChangedListener)
  {
    synchronized (this.d)
    {
      if (!this.d.contains(paramOnRefreshChangedListener)) {
        this.d.add(paramOnRefreshChangedListener);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public boolean a(RefreshData paramRefreshData, int paramInt)
  {
    return a(paramRefreshData, 0, paramInt);
  }
  
  public boolean a(RefreshData paramRefreshData, int paramInt1, int paramInt2)
  {
    Object localObject1 = paramRefreshData.id;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("downloadRefreshRes start id = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ReadInJoyRefreshManager", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = RefreshRes.a((String)localObject1);
    if (RefreshRes.b((String)localObject1)) {
      return true;
    }
    Object localObject3 = this.c;
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("refresh_");
    ((StringBuilder)localObject4).append((String)localObject1);
    if (((HashMap)localObject3).get(((StringBuilder)localObject4).toString()) != null) {
      return false;
    }
    FileUtils.deleteDirectory((String)localObject2);
    localObject3 = this.c;
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("refresh_");
    ((StringBuilder)localObject4).append((String)localObject1);
    ((HashMap)localObject3).put(((StringBuilder)localObject4).toString(), paramRefreshData.url);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(".zip");
    localObject2 = ((StringBuilder)localObject3).toString();
    localObject4 = new File((String)localObject2);
    localObject3 = new Bundle();
    ((Bundle)localObject3).putString("refreshId", (String)localObject1);
    localObject1 = new DownloadTask(paramRefreshData.url, (File)localObject4);
    ((DownloadTask)localObject1).e = paramInt1;
    ((DownloadTask)localObject1).u = 60L;
    ((DownloadTask)localObject1).G = true;
    this.b.startDownload((DownloadTask)localObject1, new ReadInJoyRefreshManager.2(this, (String)localObject2, paramRefreshData, paramInt2), (Bundle)localObject3);
    return false;
  }
  
  public void b(ReadInJoyRefreshManager.OnRefreshChangedListener paramOnRefreshChangedListener)
  {
    synchronized (this.d)
    {
      this.d.remove(paramOnRefreshChangedListener);
      return;
    }
  }
  
  public boolean b()
  {
    return (d() == 1) && (RefreshRes.g() == 1);
  }
  
  public String c()
  {
    return this.f;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public boolean e()
  {
    return this.i;
  }
  
  public void onDestroy()
  {
    this.d.clear();
    this.e = -1;
    j = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager
 * JD-Core Version:    0.7.0.1
 */