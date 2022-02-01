package com.tencent.mobileqq.kandian.biz.skin;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoySkinUtils;
import com.tencent.mobileqq.kandian.biz.skin.entity.BaseResData;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public abstract class ReadInJoyBaseResManager
  implements Manager
{
  protected HashMap<String, String> a = new HashMap();
  protected ConcurrentHashMap<String, String> b = new ConcurrentHashMap();
  protected AppInterface c;
  protected DownloaderInterface d;
  protected ArrayList<DownloadListener> e = new ArrayList();
  protected EntityManager f;
  
  public ReadInJoyBaseResManager(AppInterface paramAppInterface)
  {
    this.c = paramAppInterface;
    this.d = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(4);
    this.f = this.c.getEntityManagerFactory().createEntityManager();
  }
  
  private DownloadListener a(String paramString1, BaseResData paramBaseResData, String paramString2)
  {
    return new ReadInJoyBaseResManager.1(this, paramString2, paramBaseResData, paramString1);
  }
  
  /* Error */
  private boolean a(String paramString1, String paramString2, BaseResData paramBaseResData, String paramString3, DownloadTask paramDownloadTask)
  {
    // Byte code:
    //   0: new 86	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 93	java/io/File:exists	()Z
    //   13: istore 7
    //   15: iconst_0
    //   16: istore 6
    //   18: iload 7
    //   20: ifeq +104 -> 124
    //   23: aload_1
    //   24: invokevirtual 97	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   27: aload_0
    //   28: aload_2
    //   29: invokevirtual 100	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyBaseResManager:c	(Ljava/lang/String;)Ljava/lang/String;
    //   32: iconst_0
    //   33: invokestatic 106	com/tencent/mobileqq/utils/FileUtils:uncompressZip	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 43	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyBaseResManager:c	Lcom/tencent/common/app/AppInterface;
    //   41: invokevirtual 110	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   44: aload 4
    //   46: aload_3
    //   47: invokevirtual 113	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyBaseResManager:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mobileqq/kandian/biz/skin/entity/BaseResData;)V
    //   50: aload_1
    //   51: invokevirtual 116	java/io/File:delete	()Z
    //   54: pop
    //   55: iload 6
    //   57: ireturn
    //   58: astore_2
    //   59: goto +58 -> 117
    //   62: astore_2
    //   63: new 118	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   70: astore_3
    //   71: aload_3
    //   72: ldc 121
    //   74: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_3
    //   79: aload 4
    //   81: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_3
    //   86: ldc 127
    //   88: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_3
    //   93: aload_2
    //   94: invokestatic 133	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   97: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: ldc 135
    //   103: iconst_2
    //   104: aload_3
    //   105: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: iconst_1
    //   112: istore 6
    //   114: goto -64 -> 50
    //   117: aload_1
    //   118: invokevirtual 116	java/io/File:delete	()Z
    //   121: pop
    //   122: aload_2
    //   123: athrow
    //   124: aload_0
    //   125: aload_2
    //   126: aload 4
    //   128: invokevirtual 144	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyBaseResManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   131: invokestatic 148	com/tencent/mobileqq/utils/FileUtils:createDirectory	(Ljava/lang/String;)Ljava/io/File;
    //   134: pop
    //   135: aload_0
    //   136: getfield 36	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyBaseResManager:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   139: aload 5
    //   141: getfield 153	com/tencent/mobileqq/vip/DownloadTask:b	Ljava/lang/String;
    //   144: invokevirtual 157	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   147: checkcast 159	java/lang/String
    //   150: invokestatic 163	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   153: ifeq +192 -> 345
    //   156: aload_0
    //   157: getfield 36	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyBaseResManager:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   160: aload 5
    //   162: getfield 153	com/tencent/mobileqq/vip/DownloadTask:b	Ljava/lang/String;
    //   165: invokevirtual 157	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   168: checkcast 159	java/lang/String
    //   171: aload_0
    //   172: aload_2
    //   173: aload 4
    //   175: invokevirtual 144	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyBaseResManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   178: iconst_0
    //   179: invokestatic 167	com/tencent/mobileqq/utils/FileUtils:copyDirectory	(Ljava/lang/String;Ljava/lang/String;Z)I
    //   182: pop
    //   183: new 118	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   190: astore_1
    //   191: aload_1
    //   192: ldc 169
    //   194: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_1
    //   199: aload_0
    //   200: getfield 36	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyBaseResManager:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   203: aload 5
    //   205: getfield 153	com/tencent/mobileqq/vip/DownloadTask:b	Ljava/lang/String;
    //   208: invokevirtual 157	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   211: checkcast 159	java/lang/String
    //   214: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload_1
    //   219: ldc 171
    //   221: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_1
    //   226: aload_0
    //   227: aload_2
    //   228: aload 4
    //   230: invokevirtual 144	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyBaseResManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   233: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: ldc 135
    //   239: iconst_2
    //   240: aload_1
    //   241: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: iconst_0
    //   248: ireturn
    //   249: astore_1
    //   250: aload_0
    //   251: getfield 31	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyBaseResManager:a	Ljava/util/HashMap;
    //   254: astore_3
    //   255: new 118	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   262: astore 5
    //   264: aload 5
    //   266: aload_2
    //   267: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 5
    //   273: ldc 173
    //   275: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 5
    //   281: aload 4
    //   283: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_3
    //   288: aload 5
    //   290: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokevirtual 176	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   296: pop
    //   297: new 118	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   304: astore_2
    //   305: aload_2
    //   306: ldc 178
    //   308: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload_2
    //   313: aload 4
    //   315: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_2
    //   320: ldc 127
    //   322: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_2
    //   327: aload_1
    //   328: invokestatic 133	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   331: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: ldc 135
    //   337: iconst_2
    //   338: aload_2
    //   339: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: iconst_0
    //   346: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	ReadInJoyBaseResManager
    //   0	347	1	paramString1	String
    //   0	347	2	paramString2	String
    //   0	347	3	paramBaseResData	BaseResData
    //   0	347	4	paramString3	String
    //   0	347	5	paramDownloadTask	DownloadTask
    //   16	97	6	bool1	boolean
    //   13	6	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   23	50	58	finally
    //   63	111	58	finally
    //   23	50	62	java/lang/Exception
    //   124	247	249	java/lang/Exception
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str = c(paramString1);
    paramString1 = str;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = new StringBuilder();
      paramString1.append(str);
      paramString1.append(paramString2);
      paramString1.append("/");
      paramString1 = paramString1.toString();
    }
    return paramString1;
  }
  
  public void a(Context paramContext, String paramString, BaseResData paramBaseResData) {}
  
  public void a(DownloadListener paramDownloadListener)
  {
    this.e.add(paramDownloadListener);
  }
  
  public void a(String paramString, BaseResData paramBaseResData) {}
  
  public void a(String paramString, DownloadTask paramDownloadTask) {}
  
  public void a(String[] paramArrayOfString) {}
  
  public boolean a(String paramString, BaseResData paramBaseResData, int paramInt)
  {
    Object localObject1 = paramBaseResData.id;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("downloadGuide: id = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.d("ReadInJoyBaseResManager", 2, ((StringBuilder)localObject2).toString());
    localObject2 = a(paramString, (String)localObject1);
    if (ReadInJoySkinUtils.a(new File((String)localObject2)))
    {
      QLog.d("readinjoy", 2, "isAnimationPackageValid");
      return true;
    }
    Object localObject3 = this.a;
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(paramString);
    ((StringBuilder)localObject4).append("_");
    ((StringBuilder)localObject4).append((String)localObject1);
    if (((HashMap)localObject3).get(((StringBuilder)localObject4).toString()) != null)
    {
      QLog.d("readinjoy", 2, "mDownloadingRes _");
      return false;
    }
    localObject3 = this.a;
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(paramString);
    ((StringBuilder)localObject4).append("_");
    ((StringBuilder)localObject4).append((String)localObject1);
    ((HashMap)localObject3).put(((StringBuilder)localObject4).toString(), paramBaseResData.url);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(".zip");
    localObject2 = ((StringBuilder)localObject3).toString();
    localObject4 = new File((String)localObject2);
    localObject3 = new Bundle();
    ((Bundle)localObject3).putString("resId", (String)localObject1);
    ((Bundle)localObject3).putString("prefix", paramString);
    localObject1 = new DownloadTask(paramBaseResData.url, (File)localObject4);
    ((DownloadTask)localObject1).e = paramInt;
    ((DownloadTask)localObject1).u = 60L;
    this.d.startDownload((DownloadTask)localObject1, a(paramString, paramBaseResData, (String)localObject2), (Bundle)localObject3);
    QLog.d("readinjoy", 2, "startDownload");
    return false;
  }
  
  public void b(DownloadListener paramDownloadListener)
  {
    this.e.remove(paramDownloadListener);
  }
  
  public abstract boolean b(String paramString, BaseResData paramBaseResData);
  
  public String c(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append(".readInjoy/resource/");
    String str = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString());
    localObject = str;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("/");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public abstract boolean c(String paramString, BaseResData paramBaseResData);
  
  public abstract void d(String paramString, BaseResData paramBaseResData);
  
  public boolean e(String paramString, BaseResData paramBaseResData)
  {
    return a(paramString, paramBaseResData, 0);
  }
  
  public void i()
  {
    this.e.clear();
  }
  
  public void onDestroy()
  {
    this.f.close();
    this.c = null;
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoyBaseResManager
 * JD-Core Version:    0.7.0.1
 */