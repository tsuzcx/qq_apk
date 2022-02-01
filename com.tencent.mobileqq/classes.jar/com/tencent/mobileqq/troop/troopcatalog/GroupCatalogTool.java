package com.tencent.mobileqq.troop.troopcatalog;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.troop.troopcatalog.GroupCatalogBean;>;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipException;
import mqq.app.MobileQQ;

public class GroupCatalogTool
{
  protected static Object a = new Object();
  protected static GroupCatalogTool b;
  protected File c;
  protected ArrayList<GroupCatalogBean> d = new ArrayList(0);
  protected GroupCatalogBean e;
  protected File f = null;
  
  private GroupCatalogTool(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e(paramContext));
    localStringBuilder.append("group_catalog_new.xml");
    this.c = new File(localStringBuilder.toString());
  }
  
  private GroupCatalogBean a(GroupCatalogBean paramGroupCatalogBean, String paramString)
  {
    boolean bool = paramGroupCatalogBean.c.equals(paramString);
    Iterator localIterator = null;
    Object localObject2 = null;
    if (bool) {
      return paramGroupCatalogBean;
    }
    Object localObject1 = localIterator;
    if (paramGroupCatalogBean.d != null)
    {
      localObject1 = localIterator;
      if (!paramGroupCatalogBean.d.isEmpty())
      {
        localIterator = paramGroupCatalogBean.d.iterator();
        localObject1 = localObject2;
        while (localIterator.hasNext())
        {
          paramGroupCatalogBean = a((GroupCatalogBean)localIterator.next(), paramString);
          localObject1 = paramGroupCatalogBean;
          if (paramGroupCatalogBean != null) {
            localObject1 = paramGroupCatalogBean;
          }
        }
      }
    }
    return localObject1;
  }
  
  public static GroupCatalogTool a(Context paramContext)
  {
    synchronized (a)
    {
      if (b == null) {
        b = new GroupCatalogTool(paramContext);
      }
      return b;
    }
  }
  
  private ArrayList<GroupCatalogBean> a(ArrayList<GroupCatalogBean> paramArrayList, String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramArrayList != null)
    {
      Iterator localIterator = paramArrayList.iterator();
      paramArrayList = localObject2;
      do
      {
        do
        {
          localObject1 = paramArrayList;
          if (!localIterator.hasNext()) {
            return localObject1;
          }
          localObject1 = (GroupCatalogBean)localIterator.next();
          if ((((GroupCatalogBean)localObject1).d == null) || (((GroupCatalogBean)localObject1).d.size() <= 0)) {
            break;
          }
          if (((GroupCatalogBean)localObject1).c.equals(paramString)) {
            return ((GroupCatalogBean)localObject1).d;
          }
          localObject1 = a(((GroupCatalogBean)localObject1).d, paramString);
          paramArrayList = (ArrayList<GroupCatalogBean>)localObject1;
        } while (localObject1 == null);
        return localObject1;
      } while (((GroupCatalogBean)localObject1).a != 4);
      localObject1 = paramArrayList;
    }
    return localObject1;
  }
  
  /* Error */
  private GroupCatalogBean b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 115	com/tencent/mobileqq/troop/troopcatalog/GroupCatalogTool:a	()Z
    //   4: ifne +14 -> 18
    //   7: aload_1
    //   8: ldc 117
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 40	com/tencent/mobileqq/troop/troopcatalog/GroupCatalogTool:e	(Landroid/content/Context;)Ljava/lang/String;
    //   15: invokestatic 122	com/tencent/util/ZipUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   18: new 124	com/tencent/mobileqq/troop/troopcatalog/GroupCatalogXmlHandler
    //   21: dup
    //   22: aload_2
    //   23: invokespecial 125	com/tencent/mobileqq/troop/troopcatalog/GroupCatalogXmlHandler:<init>	(Ljava/lang/String;)V
    //   26: astore_3
    //   27: aconst_null
    //   28: astore 4
    //   30: invokestatic 131	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   33: invokevirtual 135	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   36: astore 5
    //   38: new 137	java/io/BufferedInputStream
    //   41: dup
    //   42: new 139	java/io/FileInputStream
    //   45: dup
    //   46: aload_0
    //   47: getfield 57	com/tencent/mobileqq/troop/troopcatalog/GroupCatalogTool:c	Ljava/io/File;
    //   50: invokespecial 142	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: invokespecial 145	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: astore_2
    //   57: aload_2
    //   58: astore_1
    //   59: aload 5
    //   61: new 147	org/xml/sax/InputSource
    //   64: dup
    //   65: new 149	java/io/InputStreamReader
    //   68: dup
    //   69: aload_2
    //   70: ldc 151
    //   72: invokespecial 154	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   75: invokespecial 157	org/xml/sax/InputSource:<init>	(Ljava/io/Reader;)V
    //   78: aload_3
    //   79: invokevirtual 163	javax/xml/parsers/SAXParser:parse	(Lorg/xml/sax/InputSource;Lorg/xml/sax/helpers/DefaultHandler;)V
    //   82: aload_2
    //   83: astore_1
    //   84: aload_0
    //   85: aload_3
    //   86: invokevirtual 166	com/tencent/mobileqq/troop/troopcatalog/GroupCatalogXmlHandler:b	()Ljava/util/ArrayList;
    //   89: putfield 32	com/tencent/mobileqq/troop/troopcatalog/GroupCatalogTool:d	Ljava/util/ArrayList;
    //   92: aload_2
    //   93: astore_1
    //   94: aload_3
    //   95: invokevirtual 169	com/tencent/mobileqq/troop/troopcatalog/GroupCatalogXmlHandler:a	()Lcom/tencent/mobileqq/troop/troopcatalog/GroupCatalogBean;
    //   98: astore_3
    //   99: aload_3
    //   100: astore_1
    //   101: aload_2
    //   102: invokevirtual 174	java/io/InputStream:close	()V
    //   105: aload_3
    //   106: areturn
    //   107: astore_2
    //   108: aload_2
    //   109: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   112: aload_1
    //   113: areturn
    //   114: astore_3
    //   115: goto +16 -> 131
    //   118: astore_3
    //   119: goto +47 -> 166
    //   122: astore_2
    //   123: aconst_null
    //   124: astore_1
    //   125: goto +74 -> 199
    //   128: astore_3
    //   129: aconst_null
    //   130: astore_2
    //   131: aload_2
    //   132: astore_1
    //   133: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +14 -> 150
    //   139: aload_2
    //   140: astore_1
    //   141: ldc 184
    //   143: iconst_2
    //   144: ldc 186
    //   146: aload_3
    //   147: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   150: aload_2
    //   151: ifnull +45 -> 196
    //   154: aload 4
    //   156: astore_1
    //   157: aload_2
    //   158: invokevirtual 174	java/io/InputStream:close	()V
    //   161: aconst_null
    //   162: areturn
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_2
    //   166: aload_2
    //   167: astore_1
    //   168: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +14 -> 185
    //   174: aload_2
    //   175: astore_1
    //   176: ldc 184
    //   178: iconst_2
    //   179: ldc 191
    //   181: aload_3
    //   182: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   185: aload_2
    //   186: ifnull +10 -> 196
    //   189: aload 4
    //   191: astore_1
    //   192: aload_2
    //   193: invokevirtual 174	java/io/InputStream:close	()V
    //   196: aconst_null
    //   197: areturn
    //   198: astore_2
    //   199: aload_1
    //   200: ifnull +15 -> 215
    //   203: aload_1
    //   204: invokevirtual 174	java/io/InputStream:close	()V
    //   207: goto +8 -> 215
    //   210: astore_1
    //   211: aload_1
    //   212: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   215: aload_2
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	GroupCatalogTool
    //   0	217	1	paramContext	Context
    //   0	217	2	paramString	String
    //   26	80	3	localObject1	Object
    //   114	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   118	1	3	localException1	java.lang.Exception
    //   128	19	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   163	19	3	localException2	java.lang.Exception
    //   28	162	4	localObject2	Object
    //   36	24	5	localSAXParser	javax.xml.parsers.SAXParser
    // Exception table:
    //   from	to	target	type
    //   101	105	107	java/io/IOException
    //   157	161	107	java/io/IOException
    //   192	196	107	java/io/IOException
    //   59	82	114	java/lang/OutOfMemoryError
    //   84	92	114	java/lang/OutOfMemoryError
    //   94	99	114	java/lang/OutOfMemoryError
    //   59	82	118	java/lang/Exception
    //   84	92	118	java/lang/Exception
    //   94	99	118	java/lang/Exception
    //   30	57	122	finally
    //   30	57	128	java/lang/OutOfMemoryError
    //   30	57	163	java/lang/Exception
    //   59	82	198	finally
    //   84	92	198	finally
    //   94	99	198	finally
    //   133	139	198	finally
    //   141	150	198	finally
    //   168	174	198	finally
    //   176	185	198	finally
    //   203	207	210	java/io/IOException
  }
  
  private GroupCatalogBean b(String paramString)
  {
    Object localObject2 = this.d;
    Object localObject1 = null;
    if (localObject2 != null)
    {
      if (((ArrayList)localObject2).isEmpty()) {
        return null;
      }
      synchronized (a)
      {
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = a((GroupCatalogBean)localIterator.next(), paramString);
          localObject1 = localObject2;
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
        }
        return localObject1;
      }
    }
    return null;
  }
  
  private String e(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("group_catalog");
    ((StringBuilder)localObject).append(File.separator);
    paramContext = ((StringBuilder)localObject).toString();
    localObject = this.f;
    if ((localObject != null) && (((File)localObject).exists()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.f.getPath());
      ((StringBuilder)localObject).append(File.separator);
      if (paramContext.equals(((StringBuilder)localObject).toString()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GroupCatalogTool", 2, "mCatalogXmlDirFile != null && path.equals(mCatalogXmlDirFile.getPath()");
        }
        return paramContext;
      }
    }
    this.f = new File(paramContext);
    if (!this.f.exists()) {
      this.f.mkdirs();
    }
    return paramContext;
  }
  
  private String f(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("group_catalog_temp");
    ((StringBuilder)localObject).append(File.separator);
    paramContext = ((StringBuilder)localObject).toString();
    localObject = new File(paramContext);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramContext;
  }
  
  public GroupCatalogBean a(Context paramContext, String paramString)
  {
    ArrayList localArrayList = this.d;
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      paramContext = b(paramString);
      this.e = paramContext;
      return paramContext;
    }
    paramContext = b(paramContext, paramString);
    this.e = paramContext;
    return paramContext;
  }
  
  public ArrayList<GroupCatalogBean> a(String paramString)
  {
    synchronized (a)
    {
      paramString = a(this.d, paramString);
      return paramString;
    }
  }
  
  public void a(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("LAST_GET_CLASS_CHOICE_URL_TIME", 0).edit();
    paramContext.putLong("GroupCatalogTool", paramLong);
    paramContext.commit();
  }
  
  public void a(GroupCatalogBean paramGroupCatalogBean)
  {
    this.e = paramGroupCatalogBean;
  }
  
  public void a(String paramString, GroupCatalogTool.GetChoiceListCallback paramGetChoiceListCallback)
  {
    long l = c(MobileQQ.sMobileQQ.getApplicationContext());
    boolean bool = this.c.exists();
    if ((System.currentTimeMillis() - l > 86400000L) || (!bool))
    {
      paramString = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(1);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("https://pub.idqqimg.com/pc/group/layer_new.zip");
      HashMap localHashMap = new HashMap();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(f(MobileQQ.getContext()));
      ((StringBuilder)localObject).append("layer_new.zip");
      localObject = new File(((StringBuilder)localObject).toString());
      localHashMap.put("https://pub.idqqimg.com/pc/group/layer_new.zip", localObject);
      paramString.startDownload(new DownloadTask(localArrayList, localHashMap, "https://pub.idqqimg.com/pc/group/layer_new.zip"), new GroupCatalogTool.1(this, (File)localObject, paramGetChoiceListCallback), new Bundle());
    }
  }
  
  public boolean a()
  {
    return (this.c.exists()) && (this.c.length() > 0L);
  }
  
  public ArrayList<GroupCatalogBean> b()
  {
    synchronized (a)
    {
      ArrayList localArrayList = new ArrayList(Arrays.asList(new GroupCatalogBean[this.d.size()]));
      Collections.copy(localArrayList, this.d);
      return localArrayList;
    }
  }
  
  public boolean b(Context paramContext)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(f(paramContext));
      localStringBuilder.append("layer_new.zip");
      ZipUtils.unZipFile(new File(localStringBuilder.toString()), f(paramContext));
      return true;
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupCatalogTool", 2, paramContext.getMessage());
      }
    }
    catch (ZipException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupCatalogTool", 2, paramContext.getMessage());
      }
    }
    return false;
  }
  
  protected long c(Context paramContext)
  {
    return paramContext.getSharedPreferences("LAST_GET_CLASS_CHOICE_URL_TIME", 0).getLong("GroupCatalogTool", 0L);
  }
  
  public void c()
  {
    if (this.d != null) {
      synchronized (a)
      {
        this.d.clear();
      }
    }
    this.e = null;
  }
  
  public GroupCatalogBean d()
  {
    return this.e;
  }
  
  public boolean d(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(f(paramContext));
    ((StringBuilder)localObject).append("group_catalog_new.xml");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e(paramContext));
    localStringBuilder.append("group_catalog_new.xml");
    return FileUtils.moveFile((String)localObject, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool
 * JD-Core Version:    0.7.0.1
 */