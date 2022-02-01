package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy.QQFavProxyListener;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QfileFavFileRecordProvider
  extends Observable
  implements IQQFavProxy.QQFavProxyListener
{
  static String a = "QfileFavFileRecordProvider<FileAssistant>";
  static String b = "FavFileS ";
  private BaseQQAppInterface c;
  private long d = 0L;
  private boolean e = false;
  private QfileFavFileRecordProvider.FavFileRecords f = new QfileFavFileRecordProvider.FavFileRecords(this);
  private boolean g = false;
  private Handler h;
  private volatile boolean i = false;
  private Runnable j;
  private volatile boolean k = false;
  private Runnable l;
  
  public QfileFavFileRecordProvider(AppRuntime paramAppRuntime)
  {
    this.c = ((BaseQQAppInterface)paramAppRuntime);
  }
  
  private void a(List<FavFileInfo> paramList, int paramInt)
  {
    this.f.a(paramList, paramInt);
  }
  
  private void b(Bundle paramBundle)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append(">>>syncLastFileRecord...");
    QLog.i(str, 1, localStringBuilder.toString());
    ((IQQFileEngine)this.c.getRuntimeService(IQQFileEngine.class)).favProxyGetFileList(0L, false, null, new QfileFavFileRecordProvider.4(this, paramBundle));
  }
  
  private void e()
  {
    if (this.i) {
      return;
    }
    this.i = true;
    this.j = new QfileFavFileRecordProvider.2(this);
    this.h.postDelayed(this.j, 30000L);
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("setGettingFavList timeout:");
    localStringBuilder.append(30000L);
    QLog.i(str, 1, localStringBuilder.toString());
  }
  
  private void f()
  {
    this.i = false;
    Object localObject = this.j;
    if (localObject != null)
    {
      this.h.removeCallbacks((Runnable)localObject);
      this.j = null;
    }
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("unsetGettingFavList");
    QLog.i((String)localObject, 1, localStringBuilder.toString());
  }
  
  private void g()
  {
    if (this.k) {
      return;
    }
    this.k = true;
    this.l = new QfileFavFileRecordProvider.3(this);
    this.h.postDelayed(this.l, 30000L);
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("setRefreshingFavList timeout:");
    localStringBuilder.append(30000L);
    QLog.i(str, 1, localStringBuilder.toString());
  }
  
  private void h()
  {
    this.k = false;
    Object localObject = this.l;
    if (localObject != null)
    {
      this.h.removeCallbacks((Runnable)localObject);
      this.l = null;
    }
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("unsetRefreshingFavList");
    QLog.i((String)localObject, 1, localStringBuilder.toString());
  }
  
  private void i()
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("resetFileRecordInfo.");
    QLog.i(str, 1, localStringBuilder.toString());
    this.d = 0L;
    this.g = false;
    this.e = false;
    this.f.a();
  }
  
  public List<FavFileInfo> a(int paramInt)
  {
    return this.f.a(paramInt);
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("onFileThumbUpdated. favid:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" type:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" strSavePath:");
    localStringBuilder.append(paramString);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    localObject = this.f.a(paramLong);
    if (localObject != null) {
      if (paramInt == 0) {
        ((FavFileInfo)localObject).j = paramString;
      } else if (paramInt == 1) {
        ((FavFileInfo)localObject).k = paramString;
      } else if (paramInt == 2) {
        ((FavFileInfo)localObject).l = paramString;
      } else if (paramInt == 3) {
        ((FavFileInfo)localObject).m = paramString;
      } else if (paramInt == 4) {
        ((FavFileInfo)localObject).n = paramString;
      }
    }
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(2), { new Bundle() } });
  }
  
  public void a(long paramLong, String paramString)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("onFileDownloaded. favid:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" strSavePath:");
    localStringBuilder.append(paramString);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    localObject = this.f.a(paramLong);
    if (localObject != null) {
      ((FavFileInfo)localObject).h = paramString;
    }
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(2), { new Bundle() } });
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.k) {
      return;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("refreshFileRecords...");
    QLog.i(str, 1, localStringBuilder.toString());
    if (!NetworkUtil.isNetworkAvailable(this.c.getApplication().getApplicationContext()))
    {
      QLog.i(a, 2, "refreshFileRecords no network");
      int m = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299920);
      int n = (int)DisplayUtils.a(BaseApplication.getContext(), 5.0F);
      QQToast.makeText(BaseApplication.getContext(), 0, 2131896111, 0).show(m - n);
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(false), new Bundle() } });
      return;
    }
    ((IQQFileEngine)this.c.getRuntimeService(IQQFileEngine.class)).favProxyRefreshList(paramBundle);
    g();
  }
  
  void a(QfileFavFileRecordProvider.FileRecordGroup paramFileRecordGroup)
  {
    if (paramFileRecordGroup == null)
    {
      paramFileRecordGroup = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b);
      localStringBuilder.append("addOrUpdateRecords parm err");
      QLog.e(paramFileRecordGroup, 1, localStringBuilder.toString());
      return;
    }
    if (paramFileRecordGroup.d.size() > 0) {
      a(paramFileRecordGroup.d, 1);
    }
    if (paramFileRecordGroup.e.size() > 0) {
      a(paramFileRecordGroup.e, 2);
    }
    if (paramFileRecordGroup.f.size() > 0) {
      a(paramFileRecordGroup.f, 3);
    }
    if (paramFileRecordGroup.g.size() > 0) {
      a(paramFileRecordGroup.g, 4);
    }
    if (paramFileRecordGroup.h.size() > 0) {
      a(paramFileRecordGroup.h, 5);
    }
  }
  
  void a(List<FavFileInfo> paramList, QfileFavFileRecordProvider.FileRecordGroup paramFileRecordGroup)
  {
    if ((paramFileRecordGroup != null) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (FavFileInfo)paramList.next();
        if (localObject != null) {
          paramFileRecordGroup.a(((FavFileInfo)localObject).d).add(localObject);
        }
      }
      paramList = a;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(b);
      ((StringBuilder)localObject).append("pickFavFileList. picSize:");
      ((StringBuilder)localObject).append(paramFileRecordGroup.d.size());
      ((StringBuilder)localObject).append(" docSize:");
      ((StringBuilder)localObject).append(paramFileRecordGroup.e.size());
      ((StringBuilder)localObject).append(" videoSize:");
      ((StringBuilder)localObject).append(paramFileRecordGroup.f.size());
      ((StringBuilder)localObject).append(" appSize:");
      ((StringBuilder)localObject).append(paramFileRecordGroup.g.size());
      ((StringBuilder)localObject).append(" otherSize:");
      ((StringBuilder)localObject).append(paramFileRecordGroup.h.size());
      QLog.i(paramList, 1, ((StringBuilder)localObject).toString());
      return;
    }
    paramList = a;
    paramFileRecordGroup = new StringBuilder();
    paramFileRecordGroup.append(b);
    paramFileRecordGroup.append("pickFavFileList parm err");
    QLog.e(paramList, 1, paramFileRecordGroup.toString());
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      b(paramBundle);
      return;
    }
    int m = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299920);
    int n = (int)DisplayUtils.a(BaseApplication.getContext(), 5.0F);
    QQToast.makeText(BaseApplication.getContext(), 0, 2131896111, 0).show(m - n);
    h();
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(false), paramBundle } });
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public void b()
  {
    if (this.i)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(b);
      localStringBuilder.append("getMoreFileRecords. is getting...");
      QLog.d(str, 1, localStringBuilder.toString());
      return;
    }
    if (this.k)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(b);
      localStringBuilder.append("getMoreFileRecords. is refreshing...");
      QLog.i(str, 1, localStringBuilder.toString());
      return;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append(">>>getMoreFileRecords... lastTimestamp:");
    localStringBuilder.append(this.d);
    QLog.i(str, 1, localStringBuilder.toString());
    ((IQQFileEngine)this.c.getRuntimeService(IQQFileEngine.class)).favProxyGetFileList(this.d, this.g, null, new QfileFavFileRecordProvider.1(this));
    e();
  }
  
  public void c()
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("init...");
    QLog.i(str, 1, localStringBuilder.toString());
    ((IQQFileEngine)this.c.getRuntimeService(IQQFileEngine.class)).favProxyAddListener(this);
    if (this.h == null) {
      this.h = new Handler(Looper.getMainLooper());
    }
  }
  
  public void d()
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("release...");
    QLog.i(str, 1, localStringBuilder.toString());
    ((IQQFileEngine)this.c.getRuntimeService(IQQFileEngine.class)).favProxyCancelGetFileList(this.d);
    ((IQQFileEngine)this.c.getRuntimeService(IQQFileEngine.class)).favProxyDeleteListener(this);
    this.c = null;
    this.f.a();
    f();
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider
 * JD-Core Version:    0.7.0.1
 */