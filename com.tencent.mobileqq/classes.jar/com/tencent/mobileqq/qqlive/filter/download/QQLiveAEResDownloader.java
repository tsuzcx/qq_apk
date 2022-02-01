package com.tencent.mobileqq.qqlive.filter.download;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.qqlive.filter.QQLiveAEKitConst;
import com.tencent.mobileqq.qqlive.filter.data.MetaMaterial;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.light.utils.GsonUtils;

public abstract class QQLiveAEResDownloader
{
  @NonNull
  protected final String a;
  protected final int b = 4;
  @NonNull
  protected final Map<String, MetaMaterial> c = new LinkedHashMap();
  protected volatile boolean d = false;
  protected volatile boolean e = false;
  @NonNull
  protected final Map<String, AtomicBoolean> f = new HashMap();
  @NonNull
  protected final Map<String, List<ResDownLoadListener>> g = new HashMap();
  
  public QQLiveAEResDownloader(@NonNull String paramString)
  {
    this.a = paramString;
  }
  
  private void a(String paramString1, NetResp paramNetResp, String paramString2, String paramString3, @NonNull MetaMaterial paramMetaMaterial, ResDownLoadListener paramResDownLoadListener)
  {
    if (paramNetResp == null)
    {
      if (paramResDownLoadListener != null) {
        paramResDownLoadListener.a(false);
      }
      a(paramString1, false);
      return;
    }
    boolean bool1;
    if (paramNetResp.mResult == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[downLoadOneResInternal] onDownloadFinish isSuccess=");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(", id=");
    ((StringBuilder)localObject).append(paramMetaMaterial.b);
    QLog.d("QQLiveAEResDownloader", 4, ((StringBuilder)localObject).toString());
    if (bool1)
    {
      localObject = FileUtils.calcMd5(paramString2);
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(paramString1)))
      {
        try
        {
          localObject = paramMetaMaterial.b;
          try
          {
            bool2 = a(paramString2, paramString3, (String)localObject, paramString1);
          }
          catch (Exception localException1) {}
          localStringBuilder2 = new StringBuilder();
        }
        catch (Exception localException2) {}
        StringBuilder localStringBuilder2;
        localStringBuilder2.append("[downLoadOneResInternal] onDownloadFinish unZipFile failed, id=");
        localStringBuilder2.append(paramMetaMaterial.b);
        QLog.e("QQLiveAEResDownloader", 4, localStringBuilder2.toString(), localException2);
        localException2.printStackTrace();
      }
      else
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("[downLoadOneResInternal] onDownloadFinish MD5 check failed, id=");
        localStringBuilder1.append(paramMetaMaterial.b);
        QLog.e("QQLiveAEResDownloader", 4, localStringBuilder1.toString());
      }
    }
    boolean bool2 = false;
    a(bool1, paramNetResp.mErrCode, paramNetResp.reqCost, paramMetaMaterial.b);
    if (!bool2) {
      FileUtils.deleteDirectory(paramString3);
    }
    FileUtils.deleteFile(paramString2);
    paramNetResp = new StringBuilder();
    paramNetResp.append("[downLoadOneResInternal] onDownloadFinish result=");
    paramNetResp.append(bool2);
    paramNetResp.append(", id=");
    paramNetResp.append(paramMetaMaterial.b);
    QLog.d("QQLiveAEResDownloader", 4, paramNetResp.toString());
    if (paramResDownLoadListener != null) {
      paramResDownLoadListener.a(bool2);
    }
    a(paramString1, bool2);
  }
  
  private boolean a(String paramString, @NonNull MetaMaterial paramMetaMaterial, ResDownLoadListener paramResDownLoadListener)
  {
    if (a(paramMetaMaterial))
    {
      if (paramResDownLoadListener != null) {
        paramResDownLoadListener.a(true);
      }
      a(paramString, true);
      paramString = new StringBuilder();
      paramString.append("[downLoadOneResInternal] res exist, resource id=");
      paramString.append(paramMetaMaterial.b);
      QLog.d("QQLiveAEResDownloader", 4, paramString.toString());
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new File(paramString1);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      File[] arrayOfFile = ((File)localObject).listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          localObject = arrayOfFile[i];
          if (((File)localObject).getName().replaceAll("\\p{C}", "").equals(paramString2))
          {
            paramString2 = new StringBuilder();
            paramString2.append("begin rename zip folder---from: ");
            paramString2.append(((File)localObject).getName());
            paramString2.append(", to: ");
            paramString2.append(paramString3);
            QLog.d("QQLiveAEResDownloader", 4, paramString2.toString());
            paramString2 = new StringBuilder();
            paramString2.append(paramString1);
            paramString2.append(((File)localObject).getName());
            paramString2 = paramString2.toString();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString1);
            ((StringBuilder)localObject).append(paramString3);
            return FileUtils.rename(paramString2, ((StringBuilder)localObject).toString());
          }
          i += 1;
        }
        paramString1 = new StringBuilder();
        paramString1.append("reNameFile--NOT found folder named ");
        paramString1.append(paramString2);
        QLog.e("QQLiveAEResDownloader", 4, paramString1.toString());
        return false;
      }
    }
    else
    {
      paramString1 = new StringBuilder();
      paramString1.append("reNameFile--toDir not exists or not a directory: ");
      paramString1.append(localObject);
      QLog.e("QQLiveAEResDownloader", 4, paramString1.toString());
    }
    return false;
  }
  
  private boolean a(AtomicBoolean paramAtomicBoolean, String paramString, @NonNull MetaMaterial paramMetaMaterial, ResDownLoadListener paramResDownLoadListener)
  {
    try
    {
      if (paramAtomicBoolean.get())
      {
        List localList = (List)this.g.get(paramString);
        Object localObject = localList;
        if (localList == null)
        {
          localObject = new ArrayList();
          this.g.put(paramString, localObject);
        }
        if (paramResDownLoadListener != null) {
          ((List)localObject).add(paramResDownLoadListener);
        }
        paramString = new StringBuilder();
        paramString.append("[downLoadOneResInternal] is downloading, resource id=");
        paramString.append(paramMetaMaterial.b);
        QLog.d("QQLiveAEResDownloader", 4, paramString.toString());
        return true;
      }
      paramAtomicBoolean.compareAndSet(false, true);
      return false;
    }
    finally {}
  }
  
  private boolean c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      ZipUtils.unZipFile(new File(paramString1), paramString2);
      boolean bool = a(paramString2, paramString3, paramString4);
      return bool;
    }
    catch (Exception paramString1)
    {
      QLog.e("QQLiveAEResDownloader", 4, "[unZipHasPackage] unZipFile throw exception ", paramString1);
    }
    return false;
  }
  
  /* Error */
  @WorkerThread
  protected String a(int paramInt)
  {
    // Byte code:
    //   0: ldc 168
    //   2: astore 4
    //   4: aload 4
    //   6: astore_2
    //   7: invokestatic 240	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: invokevirtual 246	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   13: iload_1
    //   14: invokevirtual 252	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   17: astore 5
    //   19: aconst_null
    //   20: astore_2
    //   21: aload 5
    //   23: invokestatic 257	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   26: astore_3
    //   27: aload_3
    //   28: astore_2
    //   29: aload 5
    //   31: ifnull +102 -> 133
    //   34: aload_3
    //   35: astore_2
    //   36: aload 5
    //   38: invokevirtual 262	java/io/InputStream:close	()V
    //   41: aload_3
    //   42: areturn
    //   43: astore_3
    //   44: goto +8 -> 52
    //   47: astore_3
    //   48: aload_3
    //   49: astore_2
    //   50: aload_3
    //   51: athrow
    //   52: aload 5
    //   54: ifnull +23 -> 77
    //   57: aload_2
    //   58: ifnull +11 -> 69
    //   61: aload 5
    //   63: invokevirtual 262	java/io/InputStream:close	()V
    //   66: goto +11 -> 77
    //   69: aload 4
    //   71: astore_2
    //   72: aload 5
    //   74: invokevirtual 262	java/io/InputStream:close	()V
    //   77: aload 4
    //   79: astore_2
    //   80: aload_3
    //   81: athrow
    //   82: astore_3
    //   83: new 67	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   90: astore 4
    //   92: aload 4
    //   94: ldc_w 264
    //   97: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 4
    //   103: iload_1
    //   104: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: ldc 85
    //   110: iconst_4
    //   111: iconst_2
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload 4
    //   119: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: aload_3
    //   126: invokevirtual 270	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   129: aastore
    //   130: invokestatic 273	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   133: aload_2
    //   134: areturn
    //   135: astore_2
    //   136: goto -59 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	QQLiveAEResDownloader
    //   0	139	1	paramInt	int
    //   6	128	2	localObject1	Object
    //   135	1	2	localThrowable1	java.lang.Throwable
    //   26	16	3	str	String
    //   43	1	3	localObject2	Object
    //   47	34	3	localThrowable2	java.lang.Throwable
    //   82	44	3	localThrowable3	java.lang.Throwable
    //   2	116	4	localObject3	Object
    //   17	56	5	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   21	27	43	finally
    //   50	52	43	finally
    //   21	27	47	java/lang/Throwable
    //   7	19	82	java/lang/Throwable
    //   36	41	82	java/lang/Throwable
    //   72	77	82	java/lang/Throwable
    //   80	82	82	java/lang/Throwable
    //   61	66	135	java/lang/Throwable
  }
  
  /* Error */
  @WorkerThread
  protected String a(String paramString)
  {
    // Byte code:
    //   0: ldc 168
    //   2: astore 4
    //   4: aload 4
    //   6: astore_2
    //   7: invokestatic 240	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: invokevirtual 278	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   13: aload_1
    //   14: invokevirtual 284	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: astore 5
    //   19: aconst_null
    //   20: astore_2
    //   21: aload 5
    //   23: invokestatic 257	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   26: astore_3
    //   27: aload_3
    //   28: astore_2
    //   29: aload 5
    //   31: ifnull +102 -> 133
    //   34: aload_3
    //   35: astore_2
    //   36: aload 5
    //   38: invokevirtual 262	java/io/InputStream:close	()V
    //   41: aload_3
    //   42: areturn
    //   43: astore_3
    //   44: goto +8 -> 52
    //   47: astore_3
    //   48: aload_3
    //   49: astore_2
    //   50: aload_3
    //   51: athrow
    //   52: aload 5
    //   54: ifnull +23 -> 77
    //   57: aload_2
    //   58: ifnull +11 -> 69
    //   61: aload 5
    //   63: invokevirtual 262	java/io/InputStream:close	()V
    //   66: goto +11 -> 77
    //   69: aload 4
    //   71: astore_2
    //   72: aload 5
    //   74: invokevirtual 262	java/io/InputStream:close	()V
    //   77: aload 4
    //   79: astore_2
    //   80: aload_3
    //   81: athrow
    //   82: astore_3
    //   83: new 67	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   90: astore 4
    //   92: aload 4
    //   94: ldc_w 286
    //   97: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 4
    //   103: aload_1
    //   104: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: ldc 85
    //   110: iconst_4
    //   111: iconst_2
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload 4
    //   119: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: aload_3
    //   126: invokevirtual 270	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   129: aastore
    //   130: invokestatic 273	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   133: aload_2
    //   134: areturn
    //   135: astore_2
    //   136: goto -59 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	QQLiveAEResDownloader
    //   0	139	1	paramString	String
    //   6	128	2	localObject1	Object
    //   135	1	2	localThrowable1	java.lang.Throwable
    //   26	16	3	str	String
    //   43	1	3	localObject2	Object
    //   47	34	3	localThrowable2	java.lang.Throwable
    //   82	44	3	localThrowable3	java.lang.Throwable
    //   2	116	4	localObject3	Object
    //   17	56	5	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   21	27	43	finally
    //   50	52	43	finally
    //   21	27	47	java/lang/Throwable
    //   7	19	82	java/lang/Throwable
    //   36	41	82	java/lang/Throwable
    //   72	77	82	java/lang/Throwable
    //   80	82	82	java/lang/Throwable
    //   61	66	135	java/lang/Throwable
  }
  
  public void a(@NonNull MetaMaterial paramMetaMaterial, ResDownLoadListener paramResDownLoadListener)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[downLoadOneResInternal] begin: resource id=");
    ((StringBuilder)localObject1).append(paramMetaMaterial.b);
    QLog.d("QQLiveAEResDownloader", 4, ((StringBuilder)localObject1).toString());
    localObject1 = paramMetaMaterial.a();
    synchronized (this.f)
    {
      if ((AtomicBoolean)this.f.get(localObject1) == null) {
        this.f.put(localObject1, new AtomicBoolean(false));
      }
      Object localObject3 = (AtomicBoolean)this.f.get(localObject1);
      if (a((AtomicBoolean)localObject3, (String)localObject1, paramMetaMaterial, paramResDownLoadListener)) {
        return;
      }
      if (a((String)localObject1, paramMetaMaterial, paramResDownLoadListener)) {
        return;
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append(QQLiveAEKitConst.a);
      ((StringBuilder)???).append(File.separator);
      ((StringBuilder)???).append(paramMetaMaterial.b);
      ((StringBuilder)???).append(File.separator);
      ??? = ((StringBuilder)???).toString();
      FileUtils.deleteDirectory((String)???);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)???);
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(".zip");
      localObject3 = ((StringBuilder)localObject3).toString();
      if (paramResDownLoadListener != null) {
        paramResDownLoadListener.a(0);
      }
      QQLiveBaseDownloader.a().a(paramMetaMaterial.b(), (String)localObject3, new QQLiveAEResDownloader.3(this, (String)localObject1, (String)localObject3, (String)???, paramMetaMaterial, paramResDownLoadListener));
      return;
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    AtomicBoolean localAtomicBoolean = (AtomicBoolean)this.f.get(paramString);
    if (localAtomicBoolean == null) {
      return;
    }
    try
    {
      localAtomicBoolean.compareAndSet(true, false);
      paramString = (List)this.g.get(paramString);
      if (paramString != null)
      {
        Iterator localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          ResDownLoadListener localResDownLoadListener = (ResDownLoadListener)localIterator.next();
          if (localResDownLoadListener != null) {
            localResDownLoadListener.a(paramBoolean);
          }
        }
        paramString.clear();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  protected abstract void a(boolean paramBoolean, int paramInt, long paramLong, String paramString);
  
  public boolean a(@NonNull MetaMaterial paramMetaMaterial)
  {
    return new File(b(paramMetaMaterial)).exists();
  }
  
  protected boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (c(paramString1, paramString2, paramString3, paramString4)) {
      return true;
    }
    return b(paramString1, paramString2, paramString3, paramString4);
  }
  
  @NonNull
  public String b(MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QQLiveAEKitConst.a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramMetaMaterial.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramMetaMaterial.a());
    return localStringBuilder.toString();
  }
  
  public String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return a(paramString);
    }
    return a(2131230735);
  }
  
  protected boolean b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(paramString3);
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists())
    {
      if (((File)localObject).mkdirs())
      {
        try
        {
          paramString1 = new File(paramString1);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString2);
          ((StringBuilder)localObject).append(paramString3);
          ((StringBuilder)localObject).append("/");
          ZipUtils.unZipFile(paramString1, ((StringBuilder)localObject).toString());
        }
        catch (IOException paramString1)
        {
          QLog.e("QQLiveAEResDownloader", 4, "[unZipNoPackage] unZipFile throw exception ", paramString1);
        }
        paramString1 = new StringBuilder();
        paramString1.append("[unZipNoPackage] zipPath: ");
        paramString1.append(paramString2);
        paramString1.append(paramString3);
        QLog.d("QQLiveAEResDownloader", 4, paramString1.toString());
        return a(paramString2, paramString3, paramString4);
      }
      QLog.e("QQLiveAEResDownloader", 4, "[unZipNoPackage] mkdir failed");
    }
    return false;
  }
  
  @WorkerThread
  protected void d()
  {
    synchronized (this.a)
    {
      if (this.d) {
        return;
      }
      this.d = true;
      QLog.d("QQLiveAEResDownloader", 4, "[ensureSetupDownloadConfig] begin");
      Object localObject1 = b(this.a);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.d("QQLiveAEResDownloader", 4, "[ensureSetupDownloadConfig] read assets json content empty");
        return;
      }
      localObject1 = (List)GsonUtils.json2Obj((String)localObject1, new QQLiveAEResDownloader.1(this).getType());
      if (localObject1 != null)
      {
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[ensureSetupDownloadConfig] res list size:");
        ((StringBuilder)localObject3).append(((List)localObject1).size());
        QLog.d("QQLiveAEResDownloader", 4, ((StringBuilder)localObject3).toString());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (MetaMaterial)((Iterator)localObject1).next();
          this.c.put(((MetaMaterial)localObject3).b, localObject3);
        }
      }
      QLog.e("QQLiveAEResDownloader", 4, "[ensureSetupDownloadConfig] res list is null");
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.filter.download.QQLiveAEResDownloader
 * JD-Core Version:    0.7.0.1
 */