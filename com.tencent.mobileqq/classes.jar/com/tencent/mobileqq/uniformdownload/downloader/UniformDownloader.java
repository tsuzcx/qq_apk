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
  private int jdField_a_of_type_Int = 0;
  final long jdField_a_of_type_Long;
  private final Bundle jdField_a_of_type_AndroidOsBundle;
  private IUniformDownloader jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader = null;
  private IUniformDownloaderListener jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List<IUniformDownloaderListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private Bundle jdField_b_of_type_AndroidOsBundle;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private final String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  public UniformDownloader(long paramLong, String paramString, Bundle paramBundle)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private IUniformDownloaderListener a()
  {
    return new UniformDownloader.2(this);
  }
  
  private List<IUniformDownloaderListener> a()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        localArrayList.add((IUniformDownloaderListener)this.jdField_a_of_type_JavaUtilList.get(i));
        i += 1;
      }
      return localArrayList;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void a(int paramInt, String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloader.1(this, paramBundle, paramInt, paramString));
  }
  
  private boolean a(boolean paramBoolean, Bundle paramBundle)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader.a(null);
        this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader.b();
      }
      if (paramBoolean)
      {
        this.jdField_b_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader = new UniformDownloaderAppBaby(this.jdField_a_of_type_Long);
      }
      else
      {
        this.jdField_b_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader = new UniformDownloaderGen(this.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener == null) {
        this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener = a();
      }
      this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader.a(this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener);
      if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader.a(this.jdField_b_of_type_JavaLangString, paramBundle) != 0)
      {
        paramBundle = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[UniformDL][");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        localStringBuilder.append("]. mDownloadler init error.");
        QLog.e(paramBundle, 1, localStringBuilder.toString());
        return false;
      }
      return true;
    }
    finally {}
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(IUniformDownloaderListener paramIUniformDownloaderListener)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramIUniformDownloaderListener)) {
        this.jdField_a_of_type_JavaUtilList.remove(paramIUniformDownloaderListener);
      }
      return;
    }
  }
  
  public void a(IUniformDownloaderListener paramIUniformDownloaderListener, boolean paramBoolean)
  {
    localObject1 = this.jdField_b_of_type_JavaLangObject;
    int k = -1;
    try
    {
      m = this.jdField_a_of_type_JavaUtilList.size();
      i = 0;
    }
    finally
    {
      for (;;)
      {
        int m;
        int i;
        int j;
        Object localObject2;
        for (;;)
        {
          throw paramIUniformDownloaderListener;
        }
        i += 1;
      }
    }
    j = k;
    if (i < m)
    {
      if ((IUniformDownloaderListener)this.jdField_a_of_type_JavaUtilList.get(i) != paramIUniformDownloaderListener) {
        break label275;
      }
      if (paramBoolean == true) {
        j = i;
      } else {
        return;
      }
    }
    if ((paramBoolean) && (j >= 0))
    {
      paramIUniformDownloaderListener = (IUniformDownloaderListener)this.jdField_a_of_type_JavaUtilList.remove(j);
      this.jdField_a_of_type_JavaUtilList.add(paramIUniformDownloaderListener);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (paramIUniformDownloaderListener != null)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        i = this.jdField_a_of_type_JavaUtilList.size();
        localObject2 = (IUniformDownloaderListener)this.jdField_a_of_type_JavaUtilList.remove(i - 1);
        this.jdField_a_of_type_JavaUtilList.add(paramIUniformDownloaderListener);
        this.jdField_a_of_type_JavaUtilList.add(localObject2);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilList.add(paramIUniformDownloaderListener);
      }
      paramIUniformDownloaderListener = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject2).append("]. addListenser. size=");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.i(paramIUniformDownloaderListener, 1, ((StringBuilder)localObject2).toString());
    }
    if (paramBoolean) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("]. setNotifyUserStarted.");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      QLog.i(str, 1, localStringBuilder.toString());
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public boolean a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      boolean bool = this.jdField_b_of_type_Boolean;
      return bool;
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[UniformDL][");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject2).append("]. >>>init UniformDownloader");
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject2 = paramBundle.getString("_PARAM_FILENAME");
    long l = paramBundle.getLong("_PARAM_FILESIZE");
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject2).append("]. init err. filename=null");
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      localObject1 = "unnamefile";
    }
    if (0L == l)
    {
      paramBundle = jdField_a_of_type_JavaLangString;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[UniformDL][");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject1).append("]. init err. filesize=0");
      QLog.e(paramBundle, 1, ((StringBuilder)localObject1).toString());
      return false;
    }
    localObject2 = new Bundle();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(AppConstants.SDCARD_FILE_SAVE_TMP_PATH);
    ((StringBuilder)localObject3).append((String)localObject1);
    localObject3 = QQFileManagerUtil.f(((StringBuilder)localObject3).toString());
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(AppConstants.SDCARD_FILE_SAVE_PATH);
    ((StringBuilder)localObject4).append((String)localObject1);
    localObject4 = ((StringBuilder)localObject4).toString();
    ((Bundle)localObject2).putString("_PARAM_FILENAME", (String)localObject1);
    ((Bundle)localObject2).putString("_PARAM_TMP_FILEPATH", (String)localObject3);
    ((Bundle)localObject2).putString("_PARAM_FILEPATH", (String)localObject4);
    ((Bundle)localObject2).putLong("_PARAM_FILESIZE", l);
    ((Bundle)localObject2).putLong("_PARAM_POS", 0L);
    paramBundle = paramBundle.getBundle("_PARAM_USER_DATA");
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("COOKIE");
      if (!TextUtils.isEmpty(paramBundle)) {
        ((Bundle)localObject2).putString("_PARAM_COOKIE", paramBundle);
      }
    }
    this.jdField_b_of_type_AndroidOsBundle = ((Bundle)localObject2);
    paramBundle = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]. >>>init UniformDownload info :: filename:[");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("] fileSize:[");
    localStringBuilder.append(l);
    localStringBuilder.append("] tmpPath(maybe change):[");
    localStringBuilder.append((String)localObject3);
    localStringBuilder.append("] savePath(maybe change):[");
    localStringBuilder.append((String)localObject4);
    localStringBuilder.append("] url:[");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("]");
    QLog.i(paramBundle, 1, localStringBuilder.toString());
    return a(UniformDownloadUtil.a((String)localObject1), (Bundle)localObject2);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader != null)
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("]. start. ");
      QLog.i(str, 1, localStringBuilder.toString());
      return this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader.a();
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]. start. mDownloadler = null.");
    QLog.e(str, 1, localStringBuilder.toString());
    return -1;
  }
  
  public boolean b()
  {
    return 2 == g();
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader != null)
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("]. pause. ");
      QLog.i(str, 1, localStringBuilder.toString());
      return this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader.c();
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]. pause. mDownloadler = null.");
    QLog.e(str, 1, localStringBuilder.toString());
    return -1;
  }
  
  public boolean c()
  {
    int i = g();
    if (1 != i)
    {
      if (6 == i) {
        return true;
      }
      return (2 == this.jdField_b_of_type_Int) && (8 == i);
    }
    return true;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader != null)
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("]. resume. ");
      QLog.i(str, 1, localStringBuilder.toString());
      return this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader.d();
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]. resume. mDownloadler = null.");
    QLog.e(str, 1, localStringBuilder.toString());
    return -1;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader != null)
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("]. stop. ");
      QLog.i(str, 1, localStringBuilder.toString());
      return this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader.b();
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]. stop. mDownloadler = null.");
    QLog.e(str, 1, localStringBuilder.toString());
    return -1;
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader != null)
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("]. pauseSlience. ");
      QLog.i(str, 1, localStringBuilder.toString());
      return this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader.f();
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]. pauseSlience. mDownloadler = null.");
    QLog.e(str, 1, localStringBuilder.toString());
    return -1;
  }
  
  public int g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader;
    if (localObject != null) {
      return ((IUniformDownloader)localObject).e();
    }
    localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]. getStatus. mDownloadler = null.");
    QLog.e((String)localObject, 1, localStringBuilder.toString());
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloader
 * JD-Core Version:    0.7.0.1
 */