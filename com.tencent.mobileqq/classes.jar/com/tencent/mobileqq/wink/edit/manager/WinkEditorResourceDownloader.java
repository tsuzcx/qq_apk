package com.tencent.mobileqq.wink.edit.manager;

import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.edit.bean.AEEditorDownloadResBean;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import com.tencent.mobileqq.wink.edit.util.AEDownloader;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class WinkEditorResourceDownloader
{
  @NonNull
  protected final String a;
  @NonNull
  protected final String b;
  protected final int c;
  @NonNull
  protected final String d;
  @NonNull
  protected final Map<String, AEEditorDownloadResBean> e = new LinkedHashMap();
  protected volatile boolean f = false;
  protected volatile boolean g = false;
  @NonNull
  protected final Map<String, AtomicBoolean> h = new HashMap();
  @NonNull
  protected final Map<String, List<WinkEditorResourceDownloader.ResDownLoadListener>> i = new HashMap();
  
  protected WinkEditorResourceDownloader(@NonNull String paramString1, @NonNull String paramString2, int paramInt, @NonNull String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt;
    paramString1 = new StringBuilder();
    paramString1.append("[AEEditor2]");
    paramString1.append(paramString3);
    this.d = paramString1.toString();
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = new File(paramString1);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      Object localObject2 = ((File)localObject1).listFiles();
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        int k = localObject2.length;
        int j = 0;
        while (j < k)
        {
          localObject1 = localObject2[j];
          if (((File)localObject1).getName().replaceAll("\\p{C}", "").equals(paramString2))
          {
            paramString2 = this.d;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("begin rename zip folder---from: ");
            ((StringBuilder)localObject2).append(((File)localObject1).getName());
            ((StringBuilder)localObject2).append(", to: ");
            ((StringBuilder)localObject2).append(paramString3);
            WinkQLog.b(paramString2, ((StringBuilder)localObject2).toString());
            paramString2 = new StringBuilder();
            paramString2.append(paramString1);
            paramString2.append(((File)localObject1).getName());
            paramString2 = paramString2.toString();
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString1);
            ((StringBuilder)localObject1).append(paramString3);
            return FileUtils.rename(paramString2, ((StringBuilder)localObject1).toString());
          }
          j += 1;
        }
        paramString1 = this.d;
        paramString3 = new StringBuilder();
        paramString3.append("reNameFile--NOT found folder named ");
        paramString3.append(paramString2);
        WinkQLog.d(paramString1, paramString3.toString());
        return false;
      }
    }
    else
    {
      paramString1 = this.d;
      paramString2 = new StringBuilder();
      paramString2.append("reNameFile--toDir not exists or not a directory: ");
      paramString2.append(localObject1);
      WinkQLog.d(paramString1, paramString2.toString());
    }
    return false;
  }
  
  /* Error */
  @WorkerThread
  public static String b(@NonNull String paramString)
  {
    // Byte code:
    //   0: new 68	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual 75	java/io/File:exists	()Z
    //   13: istore_1
    //   14: ldc 89
    //   16: astore 5
    //   18: iload_1
    //   19: ifne +6 -> 25
    //   22: ldc 89
    //   24: areturn
    //   25: aconst_null
    //   26: astore 4
    //   28: aconst_null
    //   29: astore_2
    //   30: new 131	java/io/FileInputStream
    //   33: dup
    //   34: aload_3
    //   35: invokespecial 134	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: astore_3
    //   39: aload_3
    //   40: invokestatic 139	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   43: astore_2
    //   44: aload_2
    //   45: astore_0
    //   46: aload_3
    //   47: invokevirtual 144	java/io/InputStream:close	()V
    //   50: aload_2
    //   51: areturn
    //   52: astore_2
    //   53: aload_2
    //   54: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   57: aload_0
    //   58: areturn
    //   59: astore_0
    //   60: aload_3
    //   61: astore_2
    //   62: goto +84 -> 146
    //   65: astore 4
    //   67: goto +14 -> 81
    //   70: astore_0
    //   71: goto +75 -> 146
    //   74: astore_2
    //   75: aload 4
    //   77: astore_3
    //   78: aload_2
    //   79: astore 4
    //   81: aload_3
    //   82: astore_2
    //   83: new 50	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   90: astore 6
    //   92: aload_3
    //   93: astore_2
    //   94: aload 6
    //   96: ldc 149
    //   98: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_3
    //   103: astore_2
    //   104: aload 6
    //   106: aload_0
    //   107: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_3
    //   112: astore_2
    //   113: ldc 151
    //   115: aload 6
    //   117: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: aload 4
    //   122: invokestatic 154	com/tencent/mobileqq/wink/edit/log/WinkQLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   125: aload_3
    //   126: astore_2
    //   127: aload 4
    //   129: invokevirtual 155	java/lang/Throwable:printStackTrace	()V
    //   132: aload_3
    //   133: ifnull +10 -> 143
    //   136: aload 5
    //   138: astore_0
    //   139: aload_3
    //   140: invokevirtual 144	java/io/InputStream:close	()V
    //   143: ldc 89
    //   145: areturn
    //   146: aload_2
    //   147: ifnull +15 -> 162
    //   150: aload_2
    //   151: invokevirtual 144	java/io/InputStream:close	()V
    //   154: goto +8 -> 162
    //   157: astore_2
    //   158: aload_2
    //   159: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   162: aload_0
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramString	String
    //   13	6	1	bool	boolean
    //   29	22	2	str1	String
    //   52	2	2	localIOException1	IOException
    //   61	1	2	localObject1	Object
    //   74	5	2	localThrowable1	java.lang.Throwable
    //   82	69	2	localObject2	Object
    //   157	2	2	localIOException2	IOException
    //   8	132	3	localObject3	Object
    //   26	1	4	localObject4	Object
    //   65	11	4	localThrowable2	java.lang.Throwable
    //   79	49	4	localObject5	Object
    //   16	121	5	str2	String
    //   90	26	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   46	50	52	java/io/IOException
    //   139	143	52	java/io/IOException
    //   39	44	59	finally
    //   39	44	65	java/lang/Throwable
    //   30	39	70	finally
    //   83	92	70	finally
    //   94	102	70	finally
    //   104	111	70	finally
    //   113	125	70	finally
    //   127	132	70	finally
    //   30	39	74	java/lang/Throwable
    //   150	154	157	java/io/IOException
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
      WinkQLog.a(this.d, "unZipHasPackage--exception ", paramString1);
    }
    return false;
  }
  
  @NonNull
  public String a(MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramMetaMaterial.id);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramMetaMaterial.packageMd5);
    return localStringBuilder.toString();
  }
  
  @NonNull
  public String a(AEEditorDownloadResBean paramAEEditorDownloadResBean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramAEEditorDownloadResBean.getId());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramAEEditorDownloadResBean.getMd5());
    return localStringBuilder.toString();
  }
  
  /* Error */
  @WorkerThread
  protected String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: invokestatic 195	com/tencent/mobileqq/wink/QQWinkEnvironment:a	()Landroid/content/Context;
    //   7: invokevirtual 201	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   10: aload_1
    //   11: invokevirtual 207	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore 4
    //   16: aload 4
    //   18: astore_2
    //   19: aload 4
    //   21: astore_3
    //   22: aload 4
    //   24: invokestatic 139	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   27: astore 5
    //   29: aload 5
    //   31: astore_1
    //   32: aload 4
    //   34: ifnull +103 -> 137
    //   37: aload 4
    //   39: invokevirtual 144	java/io/InputStream:close	()V
    //   42: aload 5
    //   44: areturn
    //   45: astore_1
    //   46: aload_1
    //   47: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   50: aload 5
    //   52: areturn
    //   53: astore_1
    //   54: goto +85 -> 139
    //   57: astore 4
    //   59: aload_3
    //   60: astore_2
    //   61: aload_0
    //   62: getfield 63	com/tencent/mobileqq/wink/edit/manager/WinkEditorResourceDownloader:d	Ljava/lang/String;
    //   65: astore 5
    //   67: aload_3
    //   68: astore_2
    //   69: new 50	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   76: astore 6
    //   78: aload_3
    //   79: astore_2
    //   80: aload 6
    //   82: ldc 209
    //   84: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_3
    //   89: astore_2
    //   90: aload 6
    //   92: aload_1
    //   93: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_3
    //   98: astore_2
    //   99: aload 5
    //   101: aload 6
    //   103: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: aload 4
    //   108: invokestatic 154	com/tencent/mobileqq/wink/edit/log/WinkQLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_3
    //   112: astore_2
    //   113: aload 4
    //   115: invokevirtual 155	java/lang/Throwable:printStackTrace	()V
    //   118: aload_3
    //   119: ifnull +15 -> 134
    //   122: aload_3
    //   123: invokevirtual 144	java/io/InputStream:close	()V
    //   126: goto +8 -> 134
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   134: ldc 89
    //   136: astore_1
    //   137: aload_1
    //   138: areturn
    //   139: aload_2
    //   140: ifnull +15 -> 155
    //   143: aload_2
    //   144: invokevirtual 144	java/io/InputStream:close	()V
    //   147: goto +8 -> 155
    //   150: astore_2
    //   151: aload_2
    //   152: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   155: aload_1
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	WinkEditorResourceDownloader
    //   0	157	1	paramString	String
    //   3	141	2	localObject1	Object
    //   150	2	2	localIOException	IOException
    //   1	122	3	localObject2	Object
    //   14	24	4	localInputStream	java.io.InputStream
    //   57	57	4	localThrowable	java.lang.Throwable
    //   27	73	5	str	String
    //   76	26	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   37	42	45	java/io/IOException
    //   4	16	53	finally
    //   22	29	53	finally
    //   61	67	53	finally
    //   69	78	53	finally
    //   80	88	53	finally
    //   90	97	53	finally
    //   99	111	53	finally
    //   113	118	53	finally
    //   4	16	57	java/lang/Throwable
    //   22	29	57	java/lang/Throwable
    //   122	126	129	java/io/IOException
    //   143	147	150	java/io/IOException
  }
  
  @WorkerThread
  protected void a()
  {
    synchronized (this.e)
    {
      if (this.f) {
        return;
      }
      this.f = true;
      WinkQLog.b(this.d, "ensureSetupDownloadConfig--BEGIN");
      Object localObject1 = a(this.a);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        WinkQLog.d(this.d, "ensureSetupDownloadConfig---read assets json content empty");
        return;
      }
      Object localObject3 = (List)GsonUtils.json2Obj((String)localObject1, new WinkEditorResourceDownloader.1(this).getType());
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ensureSetupDownloadConfig---size = ");
      if (localObject3 == null) {
        localObject1 = "null";
      } else {
        localObject1 = Integer.valueOf(((List)localObject3).size());
      }
      localStringBuilder.append(localObject1);
      WinkQLog.b(str, localStringBuilder.toString());
      if (localObject3 != null)
      {
        localObject1 = ((List)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (AEEditorDownloadResBean)((Iterator)localObject1).next();
          this.e.put(((AEEditorDownloadResBean)localObject3).getId(), localObject3);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(@NonNull MetaMaterial paramMetaMaterial, WinkEditorResourceDownloader.ResDownLoadListener paramResDownLoadListener)
  {
    ??? = this.d;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("downLoadOneResInternal---BEGIN: id=");
    ((StringBuilder)localObject2).append(paramMetaMaterial.id);
    WinkQLog.b((String)???, ((StringBuilder)localObject2).toString());
    String str = paramMetaMaterial.packageMd5;
    synchronized (this.h)
    {
      if ((AtomicBoolean)this.h.get(str) == null) {
        this.h.put(str, new AtomicBoolean(false));
      }
      AtomicBoolean localAtomicBoolean = (AtomicBoolean)this.h.get(str);
      try
      {
        if (localAtomicBoolean.get())
        {
          localObject2 = (List)this.i.get(str);
          ??? = localObject2;
          if (localObject2 == null)
          {
            ??? = new ArrayList();
            this.i.put(str, ???);
          }
          if (paramResDownLoadListener != null) {
            ((List)???).add(paramResDownLoadListener);
          }
          paramResDownLoadListener = this.d;
          ??? = new StringBuilder();
          ((StringBuilder)???).append("downLoadOneResInternal---is DOWNLOADING: id=");
          ((StringBuilder)???).append(paramMetaMaterial.id);
          WinkQLog.b(paramResDownLoadListener, ((StringBuilder)???).toString());
          return;
        }
        localAtomicBoolean.compareAndSet(false, true);
        if (b(paramMetaMaterial))
        {
          if (paramResDownLoadListener != null) {
            paramResDownLoadListener.a(true);
          }
          a(str, true);
          paramResDownLoadListener = this.d;
          ??? = new StringBuilder();
          ((StringBuilder)???).append("downLoadOneResInternal---is DOWNLOADED by other: id=");
          ((StringBuilder)???).append(paramMetaMaterial.id);
          WinkQLog.b(paramResDownLoadListener, ((StringBuilder)???).toString());
          return;
        }
        ??? = new StringBuilder();
        ((StringBuilder)???).append(this.b);
        ((StringBuilder)???).append(File.separator);
        ((StringBuilder)???).append(paramMetaMaterial.id);
        ((StringBuilder)???).append(File.separator);
        ??? = ((StringBuilder)???).toString();
        FileUtils.deleteDirectory((String)???);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)???);
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(".zip");
        localObject2 = ((StringBuilder)localObject2).toString();
        if (paramResDownLoadListener != null) {
          paramResDownLoadListener.a(0);
        }
        AEDownloader.a().a(paramMetaMaterial.packageUrl, (String)localObject2, new WinkEditorResourceDownloader.5(this, paramResDownLoadListener, str, paramMetaMaterial, (String)localObject2, (String)???));
        return;
      }
      finally {}
    }
  }
  
  public void a(@NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean, WinkEditorResourceDownloader.ResDownLoadListener paramResDownLoadListener)
  {
    ??? = this.d;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("downLoadOneResInternal---BEGIN: id=");
    ((StringBuilder)localObject2).append(paramAEEditorDownloadResBean.getId());
    WinkQLog.b((String)???, ((StringBuilder)localObject2).toString());
    String str = paramAEEditorDownloadResBean.getMd5();
    synchronized (this.h)
    {
      if ((AtomicBoolean)this.h.get(str) == null) {
        this.h.put(str, new AtomicBoolean(false));
      }
      AtomicBoolean localAtomicBoolean = (AtomicBoolean)this.h.get(str);
      try
      {
        if (localAtomicBoolean.get())
        {
          localObject2 = (List)this.i.get(str);
          ??? = localObject2;
          if (localObject2 == null)
          {
            ??? = new ArrayList();
            this.i.put(str, ???);
          }
          if (paramResDownLoadListener != null) {
            ((List)???).add(paramResDownLoadListener);
          }
          paramResDownLoadListener = this.d;
          ??? = new StringBuilder();
          ((StringBuilder)???).append("downLoadOneResInternal---is DOWNLOADING: id=");
          ((StringBuilder)???).append(paramAEEditorDownloadResBean.getId());
          WinkQLog.b(paramResDownLoadListener, ((StringBuilder)???).toString());
          return;
        }
        localAtomicBoolean.compareAndSet(false, true);
        if (b(paramAEEditorDownloadResBean))
        {
          if (paramResDownLoadListener != null) {
            paramResDownLoadListener.a(true);
          }
          a(str, true);
          paramResDownLoadListener = this.d;
          ??? = new StringBuilder();
          ((StringBuilder)???).append("downLoadOneResInternal---is DOWNLOADED by other: id=");
          ((StringBuilder)???).append(paramAEEditorDownloadResBean.getId());
          WinkQLog.b(paramResDownLoadListener, ((StringBuilder)???).toString());
          return;
        }
        ??? = new StringBuilder();
        ((StringBuilder)???).append(this.b);
        ((StringBuilder)???).append(File.separator);
        ((StringBuilder)???).append(paramAEEditorDownloadResBean.getId());
        ((StringBuilder)???).append(File.separator);
        ??? = ((StringBuilder)???).toString();
        FileUtils.deleteDirectory((String)???);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)???);
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(".zip");
        localObject2 = ((StringBuilder)localObject2).toString();
        if (paramResDownLoadListener != null) {
          paramResDownLoadListener.a(0);
        }
        AEDownloader.a().a(paramAEEditorDownloadResBean.getUrl(), (String)localObject2, new WinkEditorResourceDownloader.4(this, paramResDownLoadListener, str, paramAEEditorDownloadResBean, (String)localObject2, (String)???));
        return;
      }
      finally {}
    }
  }
  
  public void a(String paramString, WinkEditorResourceDownloader.ResDownLoadListener paramResDownLoadListener)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramResDownLoadListener != null) {
        paramResDownLoadListener.a(false);
      }
      return;
    }
    ThreadManager.excute(new WinkEditorResourceDownloader.3(this, paramString, paramResDownLoadListener), 128, null, false);
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    AtomicBoolean localAtomicBoolean = (AtomicBoolean)this.h.get(paramString);
    if (localAtomicBoolean == null) {
      return;
    }
    try
    {
      localAtomicBoolean.compareAndSet(true, false);
      paramString = (List)this.i.get(paramString);
      if (paramString != null)
      {
        Iterator localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          WinkEditorResourceDownloader.ResDownLoadListener localResDownLoadListener = (WinkEditorResourceDownloader.ResDownLoadListener)localIterator.next();
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
  
  protected abstract void a(@NonNull List<AEEditorDownloadResBean> paramList);
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  protected boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (c(paramString1, paramString2, paramString3, paramString4)) {
      return true;
    }
    return b(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void b()
  {
    if (this.g) {
      return;
    }
    this.g = true;
    ThreadManager.excute(new WinkEditorResourceDownloader.2(this), 128, null, false);
  }
  
  protected abstract void b(@NonNull List<AEEditorDownloadResBean> paramList);
  
  public boolean b(@NonNull MetaMaterial paramMetaMaterial)
  {
    return new File(a(paramMetaMaterial)).exists();
  }
  
  public boolean b(@NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean)
  {
    return new File(a(paramAEEditorDownloadResBean)).exists();
  }
  
  protected boolean b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(paramString3);
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
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
      WinkQLog.a(this.d, "unZipNoPackage-- exception ", paramString1);
    }
    paramString1 = this.d;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unZipNoPackage-- zipPath: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(paramString3);
    WinkQLog.d(paramString1, ((StringBuilder)localObject).toString());
    return a(paramString2, paramString3, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader
 * JD-Core Version:    0.7.0.1
 */