package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.uniformdownload.filemanager.FMSettings;
import com.tencent.mobileqq.uniformdownload.filemanager.FileManagerUtil;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloader;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class UniformDownloader
{
  public static String a;
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
  
  static
  {
    jdField_a_of_type_JavaLangString = "UDownloader";
  }
  
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
  }
  
  private void a(int paramInt, String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloader.1(this, paramBundle, paramInt, paramString));
  }
  
  /* Error */
  private boolean a(boolean paramBoolean, Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 35	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloader:jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader	Lcom/tencent/mobileqq/uniformdownload/util/IUniformDownloader;
    //   8: ifnull +24 -> 32
    //   11: aload_0
    //   12: getfield 35	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloader:jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader	Lcom/tencent/mobileqq/uniformdownload/util/IUniformDownloader;
    //   15: aconst_null
    //   16: invokeinterface 117 2 0
    //   21: pop
    //   22: aload_0
    //   23: getfield 35	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloader:jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader	Lcom/tencent/mobileqq/uniformdownload/util/IUniformDownloader;
    //   26: invokeinterface 119 1 0
    //   31: pop
    //   32: iload_1
    //   33: ifeq +111 -> 144
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 33	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloader:jdField_b_of_type_Int	I
    //   41: aload_0
    //   42: new 121	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderAppBaby
    //   45: dup
    //   46: aload_0
    //   47: getfield 52	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloader:jdField_a_of_type_Long	J
    //   50: invokespecial 124	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderAppBaby:<init>	(J)V
    //   53: putfield 35	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloader:jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader	Lcom/tencent/mobileqq/uniformdownload/util/IUniformDownloader;
    //   56: aload_0
    //   57: getfield 37	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloader:jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener	Lcom/tencent/mobileqq/uniformdownload/util/IUniformDownloaderListener;
    //   60: ifnonnull +11 -> 71
    //   63: aload_0
    //   64: aload_0
    //   65: invokespecial 126	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloader:a	()Lcom/tencent/mobileqq/uniformdownload/util/IUniformDownloaderListener;
    //   68: putfield 37	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloader:jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener	Lcom/tencent/mobileqq/uniformdownload/util/IUniformDownloaderListener;
    //   71: aload_0
    //   72: getfield 35	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloader:jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader	Lcom/tencent/mobileqq/uniformdownload/util/IUniformDownloader;
    //   75: aload_0
    //   76: getfield 37	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloader:jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener	Lcom/tencent/mobileqq/uniformdownload/util/IUniformDownloaderListener;
    //   79: invokeinterface 117 2 0
    //   84: pop
    //   85: iload_3
    //   86: istore_1
    //   87: aload_0
    //   88: getfield 35	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloader:jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader	Lcom/tencent/mobileqq/uniformdownload/util/IUniformDownloader;
    //   91: aload_0
    //   92: getfield 48	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloader:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   95: aload_2
    //   96: invokeinterface 129 3 0
    //   101: ifeq +39 -> 140
    //   104: getstatic 22	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   107: iconst_1
    //   108: new 131	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   115: ldc 134
    //   117: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_0
    //   121: getfield 52	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloader:jdField_a_of_type_Long	J
    //   124: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   127: ldc 143
    //   129: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: iconst_0
    //   139: istore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: iload_1
    //   143: ireturn
    //   144: aload_0
    //   145: iconst_2
    //   146: putfield 33	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloader:jdField_b_of_type_Int	I
    //   149: aload_0
    //   150: new 155	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderGen
    //   153: dup
    //   154: aload_0
    //   155: getfield 52	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloader:jdField_a_of_type_Long	J
    //   158: invokespecial 156	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderGen:<init>	(J)V
    //   161: putfield 35	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloader:jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader	Lcom/tencent/mobileqq/uniformdownload/util/IUniformDownloader;
    //   164: goto -108 -> 56
    //   167: astore_2
    //   168: aload_0
    //   169: monitorexit
    //   170: aload_2
    //   171: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	UniformDownloader
    //   0	172	1	paramBoolean	boolean
    //   0	172	2	paramBundle	Bundle
    //   1	85	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	32	167	finally
    //   36	56	167	finally
    //   56	71	167	finally
    //   71	85	167	finally
    //   87	138	167	finally
    //   144	164	167	finally
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
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        int j = this.jdField_a_of_type_JavaUtilList.size();
        i = 0;
        if (i >= j) {
          break label243;
        }
        if ((IUniformDownloaderListener)this.jdField_a_of_type_JavaUtilList.get(i) == paramIUniformDownloaderListener)
        {
          if (paramBoolean == true)
          {
            if ((!paramBoolean) || (i < 0)) {
              break label109;
            }
            paramIUniformDownloaderListener = (IUniformDownloaderListener)this.jdField_a_of_type_JavaUtilList.remove(i);
            this.jdField_a_of_type_JavaUtilList.add(paramIUniformDownloaderListener);
            this.jdField_a_of_type_Boolean = true;
            return;
          }
          return;
        }
      }
      i += 1;
      continue;
      label109:
      if (paramIUniformDownloaderListener != null)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label229;
        }
        i = this.jdField_a_of_type_JavaUtilList.size();
        IUniformDownloaderListener localIUniformDownloaderListener = (IUniformDownloaderListener)this.jdField_a_of_type_JavaUtilList.remove(i - 1);
        this.jdField_a_of_type_JavaUtilList.add(paramIUniformDownloaderListener);
        this.jdField_a_of_type_JavaUtilList.add(localIUniformDownloaderListener);
      }
      for (;;)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. addListenser. size=" + this.jdField_a_of_type_JavaUtilList.size());
        if (paramBoolean) {
          this.jdField_a_of_type_Boolean = true;
        }
        return;
        label229:
        this.jdField_a_of_type_JavaUtilList.add(paramIUniformDownloaderListener);
      }
      label243:
      int i = -1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. setNotifyUserStarted." + this.jdField_b_of_type_Boolean + "->" + paramBoolean);
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
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. >>>init UniformDownloader");
    Object localObject2 = paramBundle.getString("_PARAM_FILENAME");
    long l = paramBundle.getLong("_PARAM_FILESIZE");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. init err. filename=null");
      localObject1 = "unnamefile";
    }
    if (0L == l)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. init err. filesize=0");
      return false;
    }
    localObject2 = new Bundle();
    String str1 = FileManagerUtil.a(FMSettings.a().b() + (String)localObject1);
    String str2 = FMSettings.a().a() + (String)localObject1;
    ((Bundle)localObject2).putString("_PARAM_FILENAME", (String)localObject1);
    ((Bundle)localObject2).putString("_PARAM_TMP_FILEPATH", str1);
    ((Bundle)localObject2).putString("_PARAM_FILEPATH", str2);
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
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. >>>init UniformDownload info :: filename:[" + (String)localObject1 + "] fileSize:[" + l + "] tmpPath(maybe change):[" + str1 + "] savePath(maybe change):[" + str2 + "] url:[" + this.jdField_b_of_type_JavaLangString + "]");
    return a(UniformDownloadUtil.a((String)localObject1), (Bundle)localObject2);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. start. ");
      return this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader.a();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. start. mDownloadler = null.");
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
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. pause. ");
      return this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader.c();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. pause. mDownloadler = null.");
    return -1;
  }
  
  public boolean c()
  {
    int i = g();
    if ((1 == i) || (6 == i)) {}
    while ((2 == this.jdField_b_of_type_Int) && (8 == i)) {
      return true;
    }
    return false;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. resume. ");
      return this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader.d();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. resume. mDownloadler = null.");
    return -1;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. stop. ");
      return this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader.b();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. stop. mDownloadler = null.");
    return -1;
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. pauseSlience. ");
      return this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader.f();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. pauseSlience. mDownloadler = null.");
    return -1;
  }
  
  public int g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader != null) {
      return this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloader.e();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. getStatus. mDownloadler = null.");
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloader
 * JD-Core Version:    0.7.0.1
 */