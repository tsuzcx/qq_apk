package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloader;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class UniformDownloader
{
  public static String a = "UDownloader";
  final long b;
  private final String c;
  private final Bundle d;
  private boolean e = false;
  private boolean f;
  private int g = 0;
  private Bundle h;
  private int i = 0;
  private IUniformDownloader j = null;
  private IUniformDownloaderListener k = null;
  private List<IUniformDownloaderListener> l = new ArrayList();
  private Object m = new Object();
  private Object n = new Object();
  
  public UniformDownloader(long paramLong, String paramString, Bundle paramBundle)
  {
    this.c = paramString;
    this.d = paramBundle;
    this.b = paramLong;
    this.e = false;
    this.f = false;
  }
  
  private void a(int paramInt, String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloader.1(this, paramBundle, paramInt, paramString));
  }
  
  private boolean a(boolean paramBoolean, Bundle paramBundle)
  {
    try
    {
      if (this.j != null)
      {
        this.j.a(null);
        this.j.b();
      }
      if (paramBoolean)
      {
        this.i = 1;
        this.j = new UniformDownloaderAppBaby(this.b);
      }
      else
      {
        this.i = 2;
        this.j = new UniformDownloaderGen(this.b);
      }
      if (this.k == null) {
        this.k = l();
      }
      this.j.a(this.k);
      if (this.j.a(this.c, paramBundle) != 0)
      {
        paramBundle = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[UniformDL][");
        localStringBuilder.append(this.b);
        localStringBuilder.append("]. mDownloadler init error.");
        QLog.e(paramBundle, 1, localStringBuilder.toString());
        return false;
      }
      return true;
    }
    finally {}
  }
  
  private IUniformDownloaderListener l()
  {
    return new UniformDownloader.2(this);
  }
  
  private List<IUniformDownloaderListener> m()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.n)
    {
      int i2 = this.l.size();
      int i1 = 0;
      while (i1 < i2)
      {
        localArrayList.add((IUniformDownloaderListener)this.l.get(i1));
        i1 += 1;
      }
      return localArrayList;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(IUniformDownloaderListener paramIUniformDownloaderListener)
  {
    synchronized (this.n)
    {
      if (this.l.contains(paramIUniformDownloaderListener)) {
        this.l.remove(paramIUniformDownloaderListener);
      }
      return;
    }
  }
  
  public void a(IUniformDownloaderListener paramIUniformDownloaderListener, boolean paramBoolean)
  {
    localObject1 = this.n;
    int i3 = -1;
    try
    {
      i4 = this.l.size();
      i1 = 0;
    }
    finally
    {
      for (;;)
      {
        int i4;
        int i1;
        int i2;
        Object localObject2;
        for (;;)
        {
          throw paramIUniformDownloaderListener;
        }
        i1 += 1;
      }
    }
    i2 = i3;
    if (i1 < i4)
    {
      if ((IUniformDownloaderListener)this.l.get(i1) != paramIUniformDownloaderListener) {
        break label275;
      }
      if (paramBoolean == true) {
        i2 = i1;
      } else {
        return;
      }
    }
    if ((paramBoolean) && (i2 >= 0))
    {
      paramIUniformDownloaderListener = (IUniformDownloaderListener)this.l.remove(i2);
      this.l.add(paramIUniformDownloaderListener);
      this.e = true;
      return;
    }
    if (paramIUniformDownloaderListener != null)
    {
      if (this.e)
      {
        i1 = this.l.size();
        localObject2 = (IUniformDownloaderListener)this.l.remove(i1 - 1);
        this.l.add(paramIUniformDownloaderListener);
        this.l.add(localObject2);
      }
      else
      {
        this.l.add(paramIUniformDownloaderListener);
      }
      paramIUniformDownloaderListener = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append("]. addListenser. size=");
      ((StringBuilder)localObject2).append(this.l.size());
      QLog.i(paramIUniformDownloaderListener, 1, ((StringBuilder)localObject2).toString());
    }
    if (paramBoolean) {
      this.e = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    synchronized (this.m)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]. setNotifyUserStarted.");
      localStringBuilder.append(this.f);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      QLog.i(str, 1, localStringBuilder.toString());
      this.f = paramBoolean;
      return;
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[UniformDL][");
    ((StringBuilder)localObject2).append(this.b);
    ((StringBuilder)localObject2).append("]. >>>init UniformDownloader");
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject2 = paramBundle.getString("_PARAM_FILENAME");
    long l1 = paramBundle.getLong("_PARAM_FILESIZE");
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append("]. init err. filename=null");
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      localObject1 = "unnamefile";
    }
    if (0L == l1)
    {
      paramBundle = a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[UniformDL][");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append("]. init err. filesize=0");
      QLog.e(paramBundle, 1, ((StringBuilder)localObject1).toString());
      return false;
    }
    localObject2 = new Bundle();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(AppConstants.SDCARD_FILE_SAVE_TMP_PATH);
    ((StringBuilder)localObject3).append((String)localObject1);
    localObject3 = QQFileManagerUtil.t(((StringBuilder)localObject3).toString());
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(AppConstants.SDCARD_FILE_SAVE_PATH);
    ((StringBuilder)localObject4).append((String)localObject1);
    localObject4 = ((StringBuilder)localObject4).toString();
    ((Bundle)localObject2).putString("_PARAM_FILENAME", (String)localObject1);
    ((Bundle)localObject2).putString("_PARAM_TMP_FILEPATH", (String)localObject3);
    ((Bundle)localObject2).putString("_PARAM_FILEPATH", (String)localObject4);
    ((Bundle)localObject2).putLong("_PARAM_FILESIZE", l1);
    ((Bundle)localObject2).putLong("_PARAM_POS", 0L);
    paramBundle = paramBundle.getBundle("_PARAM_USER_DATA");
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("COOKIE");
      if (!TextUtils.isEmpty(paramBundle)) {
        ((Bundle)localObject2).putString("_PARAM_COOKIE", paramBundle);
      }
    }
    this.h = ((Bundle)localObject2);
    paramBundle = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]. >>>init UniformDownload info :: filename:[");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("] fileSize:[");
    localStringBuilder.append(l1);
    localStringBuilder.append("] tmpPath(maybe change):[");
    localStringBuilder.append((String)localObject3);
    localStringBuilder.append("] savePath(maybe change):[");
    localStringBuilder.append((String)localObject4);
    localStringBuilder.append("] url:[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    QLog.i(paramBundle, 1, localStringBuilder.toString());
    return a(UniformDownloadUtil.f((String)localObject1), (Bundle)localObject2);
  }
  
  public int b()
  {
    return this.i;
  }
  
  public boolean c()
  {
    synchronized (this.m)
    {
      boolean bool = this.f;
      return bool;
    }
  }
  
  public int d()
  {
    if (this.j != null)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]. start. ");
      QLog.i(str, 1, localStringBuilder.toString());
      return this.j.a();
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]. start. mDownloadler = null.");
    QLog.e(str, 1, localStringBuilder.toString());
    return -1;
  }
  
  public int e()
  {
    if (this.j != null)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]. pause. ");
      QLog.i(str, 1, localStringBuilder.toString());
      return this.j.c();
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]. pause. mDownloadler = null.");
    QLog.e(str, 1, localStringBuilder.toString());
    return -1;
  }
  
  public int f()
  {
    if (this.j != null)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]. resume. ");
      QLog.i(str, 1, localStringBuilder.toString());
      return this.j.d();
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]. resume. mDownloadler = null.");
    QLog.e(str, 1, localStringBuilder.toString());
    return -1;
  }
  
  public int g()
  {
    if (this.j != null)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]. stop. ");
      QLog.i(str, 1, localStringBuilder.toString());
      return this.j.b();
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]. stop. mDownloadler = null.");
    QLog.e(str, 1, localStringBuilder.toString());
    return -1;
  }
  
  public int h()
  {
    if (this.j != null)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]. pauseSlience. ");
      QLog.i(str, 1, localStringBuilder.toString());
      return this.j.f();
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]. pauseSlience. mDownloadler = null.");
    QLog.e(str, 1, localStringBuilder.toString());
    return -1;
  }
  
  public int i()
  {
    Object localObject = this.j;
    if (localObject != null) {
      return ((IUniformDownloader)localObject).e();
    }
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]. getStatus. mDownloadler = null.");
    QLog.e((String)localObject, 1, localStringBuilder.toString());
    return 0;
  }
  
  public boolean j()
  {
    return 2 == i();
  }
  
  public boolean k()
  {
    int i1 = i();
    if (1 != i1)
    {
      if (6 == i1) {
        return true;
      }
      return (2 == this.i) && (8 == i1);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloader
 * JD-Core Version:    0.7.0.1
 */