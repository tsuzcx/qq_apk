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
  static String jdField_a_of_type_JavaLangString = "QfileFavFileRecordProvider<FileAssistant>";
  static String jdField_b_of_type_JavaLangString = "FavFileS ";
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  private QfileFavFileRecordProvider.FavFileRecords jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider$FavFileRecords = new QfileFavFileRecordProvider.FavFileRecords(this);
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean = false;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private boolean jdField_b_of_type_Boolean = false;
  private volatile boolean c = false;
  private volatile boolean d = false;
  
  public QfileFavFileRecordProvider(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = ((BaseQQAppInterface)paramAppRuntime);
  }
  
  private void a(List<FavFileInfo> paramList, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider$FavFileRecords.a(paramList, paramInt);
  }
  
  private void b(Bundle paramBundle)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append(">>>syncLastFileRecord...");
    QLog.i(str, 1, localStringBuilder.toString());
    ((IQQFileEngine)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQQFileEngine.class)).favProxyGetFileList(0L, false, null, new QfileFavFileRecordProvider.4(this, paramBundle));
  }
  
  private void d()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    this.jdField_a_of_type_JavaLangRunnable = new QfileFavFileRecordProvider.2(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append("setGettingFavList timeout:");
    localStringBuilder.append(30000L);
    QLog.i(str, 1, localStringBuilder.toString());
  }
  
  private void e()
  {
    this.c = false;
    Object localObject = this.jdField_a_of_type_JavaLangRunnable;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks((Runnable)localObject);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append("unsetGettingFavList");
    QLog.i((String)localObject, 1, localStringBuilder.toString());
  }
  
  private void f()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.jdField_b_of_type_JavaLangRunnable = new QfileFavFileRecordProvider.3(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 30000L);
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append("setRefreshingFavList timeout:");
    localStringBuilder.append(30000L);
    QLog.i(str, 1, localStringBuilder.toString());
  }
  
  private void g()
  {
    this.d = false;
    Object localObject = this.jdField_b_of_type_JavaLangRunnable;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks((Runnable)localObject);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append("unsetRefreshingFavList");
    QLog.i((String)localObject, 1, localStringBuilder.toString());
  }
  
  private void h()
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append("resetFileRecordInfo.");
    QLog.i(str, 1, localStringBuilder.toString());
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider$FavFileRecords.a();
  }
  
  public List<FavFileInfo> a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider$FavFileRecords.a(paramInt);
  }
  
  public void a()
  {
    if (this.c)
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_b_of_type_JavaLangString);
      localStringBuilder.append("getMoreFileRecords. is getting...");
      QLog.d(str, 1, localStringBuilder.toString());
      return;
    }
    if (this.d)
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_b_of_type_JavaLangString);
      localStringBuilder.append("getMoreFileRecords. is refreshing...");
      QLog.i(str, 1, localStringBuilder.toString());
      return;
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append(">>>getMoreFileRecords... lastTimestamp:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    QLog.i(str, 1, localStringBuilder.toString());
    ((IQQFileEngine)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQQFileEngine.class)).favProxyGetFileList(this.jdField_a_of_type_Long, this.jdField_b_of_type_Boolean, null, new QfileFavFileRecordProvider.1(this));
    d();
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append("onFileThumbUpdated. favid:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" type:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" strSavePath:");
    localStringBuilder.append(paramString);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider$FavFileRecords.a(paramLong);
    if (localObject != null) {
      if (paramInt == 0) {
        ((FavFileInfo)localObject).g = paramString;
      } else if (paramInt == 1) {
        ((FavFileInfo)localObject).h = paramString;
      } else if (paramInt == 2) {
        ((FavFileInfo)localObject).i = paramString;
      } else if (paramInt == 3) {
        ((FavFileInfo)localObject).j = paramString;
      } else if (paramInt == 4) {
        ((FavFileInfo)localObject).k = paramString;
      }
    }
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(2), { new Bundle() } });
  }
  
  public void a(long paramLong, String paramString)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append("onFileDownloaded. favid:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" strSavePath:");
    localStringBuilder.append(paramString);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider$FavFileRecords.a(paramLong);
    if (localObject != null) {
      ((FavFileInfo)localObject).e = paramString;
    }
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(2), { new Bundle() } });
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.d) {
      return;
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append("refreshFileRecords...");
    QLog.i(str, 1, localStringBuilder.toString());
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getApplication().getApplicationContext()))
    {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "refreshFileRecords no network");
      int i = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168);
      int j = (int)DisplayUtils.a(BaseApplication.getContext(), 5.0F);
      QQToast.a(BaseApplication.getContext(), 0, 2131698210, 0).b(i - j);
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(false), new Bundle() } });
      return;
    }
    ((IQQFileEngine)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQQFileEngine.class)).favProxyRefreshList(paramBundle);
    f();
  }
  
  void a(QfileFavFileRecordProvider.FileRecordGroup paramFileRecordGroup)
  {
    if (paramFileRecordGroup == null)
    {
      paramFileRecordGroup = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_b_of_type_JavaLangString);
      localStringBuilder.append("addOrUpdateRecords parm err");
      QLog.e(paramFileRecordGroup, 1, localStringBuilder.toString());
      return;
    }
    if (paramFileRecordGroup.a.size() > 0) {
      a(paramFileRecordGroup.a, 1);
    }
    if (paramFileRecordGroup.b.size() > 0) {
      a(paramFileRecordGroup.b, 2);
    }
    if (paramFileRecordGroup.c.size() > 0) {
      a(paramFileRecordGroup.c, 3);
    }
    if (paramFileRecordGroup.d.size() > 0) {
      a(paramFileRecordGroup.d, 4);
    }
    if (paramFileRecordGroup.e.size() > 0) {
      a(paramFileRecordGroup.e, 5);
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
          paramFileRecordGroup.a(((FavFileInfo)localObject).c).add(localObject);
        }
      }
      paramList = jdField_a_of_type_JavaLangString;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append("pickFavFileList. picSize:");
      ((StringBuilder)localObject).append(paramFileRecordGroup.a.size());
      ((StringBuilder)localObject).append(" docSize:");
      ((StringBuilder)localObject).append(paramFileRecordGroup.b.size());
      ((StringBuilder)localObject).append(" videoSize:");
      ((StringBuilder)localObject).append(paramFileRecordGroup.c.size());
      ((StringBuilder)localObject).append(" appSize:");
      ((StringBuilder)localObject).append(paramFileRecordGroup.d.size());
      ((StringBuilder)localObject).append(" otherSize:");
      ((StringBuilder)localObject).append(paramFileRecordGroup.e.size());
      QLog.i(paramList, 1, ((StringBuilder)localObject).toString());
      return;
    }
    paramList = jdField_a_of_type_JavaLangString;
    paramFileRecordGroup = new StringBuilder();
    paramFileRecordGroup.append(jdField_b_of_type_JavaLangString);
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
    int i = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168);
    int j = (int)DisplayUtils.a(BaseApplication.getContext(), 5.0F);
    QQToast.a(BaseApplication.getContext(), 0, 2131698210, 0).b(i - j);
    g();
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(false), paramBundle } });
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append("init...");
    QLog.i(str, 1, localStringBuilder.toString());
    ((IQQFileEngine)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQQFileEngine.class)).favProxyAddListener(this);
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
  }
  
  public void c()
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append("release...");
    QLog.i(str, 1, localStringBuilder.toString());
    ((IQQFileEngine)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQQFileEngine.class)).favProxyCancelGetFileList(this.jdField_a_of_type_Long);
    ((IQQFileEngine)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQQFileEngine.class)).favProxyDeleteListener(this);
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider$FavFileRecords.a();
    e();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider
 * JD-Core Version:    0.7.0.1
 */