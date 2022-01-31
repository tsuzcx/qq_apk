package com.tencent.mobileqq.filemanager.util;

import adqm;
import adqn;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class UniformDownloader
{
  public static String a;
  private int jdField_a_of_type_Int = 0;
  public final long a;
  private final Bundle jdField_a_of_type_AndroidOsBundle;
  private UniformDownloader.IUniformDownloader jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader;
  private UniformDownloader.IUniformDownloaderListener jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener = new adqm(this);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Bundle jdField_b_of_type_AndroidOsBundle;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private final String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniformDownloader<FileAssistant>";
  }
  
  public UniformDownloader(long paramLong, String paramString, Bundle paramBundle)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "下载失败" + "[" + String.valueOf(paramInt) + "]";
    case 0: 
      return "";
    case 1: 
      return "下载失败" + "[" + String.valueOf(paramInt) + "]";
    case 2: 
      return "网络异常";
    case 3: 
      return "文件写入异常";
    case 4: 
      return "临时文件关闭异常";
    case 5: 
      return "未知异常";
    case 6: 
      return "下载器异常";
    case 7: 
      return "重命名文件异常";
    case 8: 
      return "文件打开异常";
    case 9: 
      return "存储空间已满";
    case 10: 
      return "SDK下载服务错误";
    case 11: 
      return "下载努力尝试失败";
    case 12: 
      return "下载器DC失败";
    case 13: 
      return "下载器启动错误";
    }
    return "下载结束错误";
  }
  
  private List a()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        localArrayList.add((UniformDownloader.IUniformDownloaderListener)this.jdField_a_of_type_JavaUtilList.get(i));
        i += 1;
      }
      return localArrayList;
    }
  }
  
  private void a(int paramInt, String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new adqn(this, paramBundle, paramInt, paramString));
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
    //   5: getfield 155	com/tencent/mobileqq/filemanager/util/UniformDownloader:jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader	Lcom/tencent/mobileqq/filemanager/util/UniformDownloader$IUniformDownloader;
    //   8: ifnull +24 -> 32
    //   11: aload_0
    //   12: getfield 155	com/tencent/mobileqq/filemanager/util/UniformDownloader:jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader	Lcom/tencent/mobileqq/filemanager/util/UniformDownloader$IUniformDownloader;
    //   15: aconst_null
    //   16: invokeinterface 160 2 0
    //   21: pop
    //   22: aload_0
    //   23: getfield 155	com/tencent/mobileqq/filemanager/util/UniformDownloader:jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader	Lcom/tencent/mobileqq/filemanager/util/UniformDownloader$IUniformDownloader;
    //   26: invokeinterface 162 1 0
    //   31: pop
    //   32: iload_1
    //   33: ifeq +96 -> 129
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 28	com/tencent/mobileqq/filemanager/util/UniformDownloader:jdField_a_of_type_Int	I
    //   41: aload_0
    //   42: new 164	com/tencent/mobileqq/filemanager/util/UniformDownloaderAppBaby
    //   45: dup
    //   46: aload_0
    //   47: getfield 50	com/tencent/mobileqq/filemanager/util/UniformDownloader:jdField_a_of_type_Long	J
    //   50: invokespecial 167	com/tencent/mobileqq/filemanager/util/UniformDownloaderAppBaby:<init>	(J)V
    //   53: putfield 155	com/tencent/mobileqq/filemanager/util/UniformDownloader:jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader	Lcom/tencent/mobileqq/filemanager/util/UniformDownloader$IUniformDownloader;
    //   56: aload_0
    //   57: getfield 155	com/tencent/mobileqq/filemanager/util/UniformDownloader:jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader	Lcom/tencent/mobileqq/filemanager/util/UniformDownloader$IUniformDownloader;
    //   60: aload_0
    //   61: getfield 44	com/tencent/mobileqq/filemanager/util/UniformDownloader:jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener	Lcom/tencent/mobileqq/filemanager/util/UniformDownloader$IUniformDownloaderListener;
    //   64: invokeinterface 160 2 0
    //   69: pop
    //   70: iload_3
    //   71: istore_1
    //   72: aload_0
    //   73: getfield 155	com/tencent/mobileqq/filemanager/util/UniformDownloader:jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader	Lcom/tencent/mobileqq/filemanager/util/UniformDownloader$IUniformDownloader;
    //   76: aload_0
    //   77: getfield 46	com/tencent/mobileqq/filemanager/util/UniformDownloader:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   80: aload_2
    //   81: invokeinterface 170 3 0
    //   86: ifeq +39 -> 125
    //   89: getstatic 21	com/tencent/mobileqq/filemanager/util/UniformDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   92: iconst_1
    //   93: new 59	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   100: ldc 172
    //   102: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 50	com/tencent/mobileqq/filemanager/util/UniformDownloader:jdField_a_of_type_Long	J
    //   109: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   112: ldc 177
    //   114: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 183	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: iconst_0
    //   124: istore_1
    //   125: aload_0
    //   126: monitorexit
    //   127: iload_1
    //   128: ireturn
    //   129: aload_0
    //   130: iconst_2
    //   131: putfield 28	com/tencent/mobileqq/filemanager/util/UniformDownloader:jdField_a_of_type_Int	I
    //   134: aload_0
    //   135: new 185	com/tencent/mobileqq/filemanager/util/UniformDownloaderGen
    //   138: dup
    //   139: aload_0
    //   140: getfield 50	com/tencent/mobileqq/filemanager/util/UniformDownloader:jdField_a_of_type_Long	J
    //   143: invokespecial 186	com/tencent/mobileqq/filemanager/util/UniformDownloaderGen:<init>	(J)V
    //   146: putfield 155	com/tencent/mobileqq/filemanager/util/UniformDownloader:jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader	Lcom/tencent/mobileqq/filemanager/util/UniformDownloader$IUniformDownloader;
    //   149: goto -93 -> 56
    //   152: astore_2
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_2
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	UniformDownloader
    //   0	157	1	paramBoolean	boolean
    //   0	157	2	paramBundle	Bundle
    //   1	70	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	32	152	finally
    //   36	56	152	finally
    //   56	70	152	finally
    //   72	123	152	finally
    //   129	149	152	finally
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. start. ");
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader.a();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. start. mDownloadler = null.");
    return -1;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(UniformDownloader.IUniformDownloaderListener paramIUniformDownloaderListener)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramIUniformDownloaderListener)) {
        this.jdField_a_of_type_JavaUtilList.remove(paramIUniformDownloaderListener);
      }
      return;
    }
  }
  
  public void a(UniformDownloader.IUniformDownloaderListener paramIUniformDownloaderListener, boolean paramBoolean)
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
        if ((UniformDownloader.IUniformDownloaderListener)this.jdField_a_of_type_JavaUtilList.get(i) == paramIUniformDownloaderListener)
        {
          if (paramBoolean == true)
          {
            if ((!paramBoolean) || (i < 0)) {
              break label109;
            }
            paramIUniformDownloaderListener = (UniformDownloader.IUniformDownloaderListener)this.jdField_a_of_type_JavaUtilList.remove(i);
            this.jdField_a_of_type_JavaUtilList.add(paramIUniformDownloaderListener);
            this.jdField_b_of_type_Boolean = true;
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
        if (!this.jdField_b_of_type_Boolean) {
          break label229;
        }
        i = this.jdField_a_of_type_JavaUtilList.size();
        UniformDownloader.IUniformDownloaderListener localIUniformDownloaderListener = (UniformDownloader.IUniformDownloaderListener)this.jdField_a_of_type_JavaUtilList.remove(i - 1);
        this.jdField_a_of_type_JavaUtilList.add(paramIUniformDownloaderListener);
        this.jdField_a_of_type_JavaUtilList.add(localIUniformDownloaderListener);
      }
      for (;;)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. addListenser. size=" + this.jdField_a_of_type_JavaUtilList.size());
        if (paramBoolean) {
          this.jdField_b_of_type_Boolean = true;
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
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. setNotifyUserStarted." + this.jdField_a_of_type_Boolean + "->" + paramBoolean);
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public boolean a()
  {
    int i = f();
    if ((1 == i) || (6 == i)) {}
    while ((2 == this.jdField_a_of_type_Int) && (8 == i)) {
      return true;
    }
    return false;
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
    String str1 = FileManagerUtil.b(FMSettings.a().c() + (String)localObject1);
    String str2 = FMSettings.a().b() + (String)localObject1;
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
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. pause. ");
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader.c();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. pause. mDownloadler = null.");
    return -1;
  }
  
  public boolean b()
  {
    return 2 == f();
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. resume. ");
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader.d();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. resume. mDownloadler = null.");
    return -1;
  }
  
  public boolean c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. stop. ");
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader.b();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. stop. mDownloadler = null.");
    return -1;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. pauseSlience. ");
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader.f();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. pauseSlience. mDownloadler = null.");
    return -1;
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloader.e();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. getStatus. mDownloadler = null.");
    return 0;
  }
  
  public int g()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.UniformDownloader
 * JD-Core Version:    0.7.0.1
 */