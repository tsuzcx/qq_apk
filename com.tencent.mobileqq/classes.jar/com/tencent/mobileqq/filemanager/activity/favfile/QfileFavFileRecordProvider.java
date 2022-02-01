package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy;
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
import mqq.app.MobileQQ;

public class QfileFavFileRecordProvider
  extends Observable
  implements IQQFavProxy.QQFavProxyListener
{
  static String jdField_a_of_type_JavaLangString = "QfileFavFileRecordProvider<FileAssistant>";
  static String jdField_b_of_type_JavaLangString = "FavFileS ";
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QfileFavFileRecordProvider.FavFileRecords jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider$FavFileRecords = new QfileFavFileRecordProvider.FavFileRecords(this);
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean = false;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private boolean jdField_b_of_type_Boolean = false;
  private volatile boolean c = false;
  private volatile boolean d = false;
  
  public QfileFavFileRecordProvider(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(List<FavFileInfo> paramList, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider$FavFileRecords.a(paramList, paramInt);
  }
  
  private void b(Bundle paramBundle)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + ">>>syncLastFileRecord...");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().getFileList(0L, false, null, new QfileFavFileRecordProvider.4(this, paramBundle));
  }
  
  private void d()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    this.jdField_a_of_type_JavaLangRunnable = new QfileFavFileRecordProvider.2(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "setGettingFavList timeout:" + 30000L);
  }
  
  private void e()
  {
    this.c = false;
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "unsetGettingFavList");
  }
  
  private void f()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.jdField_b_of_type_JavaLangRunnable = new QfileFavFileRecordProvider.3(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 30000L);
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "setRefreshingFavList timeout:" + 30000L);
  }
  
  private void g()
  {
    this.d = false;
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "unsetRefreshingFavList");
  }
  
  private void h()
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "resetFileRecordInfo.");
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
      QLog.d(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "getMoreFileRecords. is getting...");
      return;
    }
    if (this.d)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "getMoreFileRecords. is refreshing...");
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + ">>>getMoreFileRecords... lastTimestamp:" + this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().getFileList(this.jdField_a_of_type_Long, this.jdField_b_of_type_Boolean, null, new QfileFavFileRecordProvider.1(this));
    d();
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "onFileThumbUpdated. favid:" + paramLong + " type:" + paramInt + " strSavePath:" + paramString);
    FavFileInfo localFavFileInfo = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider$FavFileRecords.a(paramLong);
    if (localFavFileInfo != null)
    {
      if (paramInt != 0) {
        break label114;
      }
      localFavFileInfo.g = paramString;
    }
    for (;;)
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(2), { new Bundle() } });
      return;
      label114:
      if (paramInt == 1) {
        localFavFileInfo.h = paramString;
      } else if (paramInt == 2) {
        localFavFileInfo.i = paramString;
      } else if (paramInt == 3) {
        localFavFileInfo.j = paramString;
      } else if (paramInt == 4) {
        localFavFileInfo.k = paramString;
      }
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "onFileDownloaded. favid:" + paramLong + " strSavePath:" + paramString);
    FavFileInfo localFavFileInfo = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider$FavFileRecords.a(paramLong);
    if (localFavFileInfo != null) {
      localFavFileInfo.e = paramString;
    }
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(2), { new Bundle() } });
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.d) {
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "refreshFileRecords...");
    if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
    {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "refreshFileRecords no network");
      int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299166);
      int j = (int)DisplayUtils.a(BaseApplicationImpl.getContext(), 5.0F);
      QQToast.a(BaseApplicationImpl.getContext(), 0, 2131698227, 0).b(i - j);
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(false), new Bundle() } });
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().refreshList(paramBundle);
    f();
  }
  
  void a(QfileFavFileRecordProvider.FileRecordGroup paramFileRecordGroup)
  {
    if (paramFileRecordGroup == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "addOrUpdateRecords parm err");
    }
    do
    {
      return;
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
    } while (paramFileRecordGroup.e.size() <= 0);
    a(paramFileRecordGroup.e, 5);
  }
  
  void a(List<FavFileInfo> paramList, QfileFavFileRecordProvider.FileRecordGroup paramFileRecordGroup)
  {
    if ((paramFileRecordGroup == null) || (paramList == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "pickFavFileList parm err");
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FavFileInfo localFavFileInfo = (FavFileInfo)paramList.next();
      if (localFavFileInfo != null) {
        paramFileRecordGroup.a(localFavFileInfo.c).add(localFavFileInfo);
      }
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "pickFavFileList. picSize:" + paramFileRecordGroup.a.size() + " docSize:" + paramFileRecordGroup.b.size() + " videoSize:" + paramFileRecordGroup.c.size() + " appSize:" + paramFileRecordGroup.d.size() + " otherSize:" + paramFileRecordGroup.e.size());
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      b(paramBundle);
      return;
    }
    int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299166);
    int j = (int)DisplayUtils.a(BaseApplicationImpl.getContext(), 5.0F);
    QQToast.a(BaseApplicationImpl.getContext(), 0, 2131698226, 0).b(i - j);
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
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "init...");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().addListener(this);
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
  }
  
  public void c()
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, jdField_b_of_type_JavaLangString + "release...");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().cancelGetFileList(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().deleteListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider$FavFileRecords.a();
    e();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider
 * JD-Core Version:    0.7.0.1
 */