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
  protected static GroupCatalogTool a;
  protected static Object a;
  protected GroupCatalogBean a;
  protected File a;
  protected ArrayList<GroupCatalogBean> a;
  protected File b = null;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private GroupCatalogTool(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramContext));
    localStringBuilder.append("group_catalog_new.xml");
    this.jdField_a_of_type_JavaIoFile = new File(localStringBuilder.toString());
  }
  
  private GroupCatalogBean a(GroupCatalogBean paramGroupCatalogBean, String paramString)
  {
    boolean bool = paramGroupCatalogBean.b.equals(paramString);
    Iterator localIterator = null;
    Object localObject2 = null;
    if (bool) {
      return paramGroupCatalogBean;
    }
    Object localObject1 = localIterator;
    if (paramGroupCatalogBean.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = localIterator;
      if (!paramGroupCatalogBean.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        localIterator = paramGroupCatalogBean.jdField_a_of_type_JavaUtilArrayList.iterator();
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
  
  private GroupCatalogBean a(String paramString)
  {
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
    Object localObject1 = null;
    if (localObject2 != null)
    {
      if (((ArrayList)localObject2).isEmpty()) {
        return null;
      }
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
  
  public static GroupCatalogTool a(Context paramContext)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogTool == null) {
        jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogTool = new GroupCatalogTool(paramContext);
      }
      return jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogTool;
    }
  }
  
  private String a(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("group_catalog");
    ((StringBuilder)localObject).append(File.separator);
    paramContext = ((StringBuilder)localObject).toString();
    localObject = this.b;
    if ((localObject != null) && (((File)localObject).exists()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b.getPath());
      ((StringBuilder)localObject).append(File.separator);
      if (paramContext.equals(((StringBuilder)localObject).toString()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GroupCatalogTool", 2, "mCatalogXmlDirFile != null && path.equals(mCatalogXmlDirFile.getPath()");
        }
        return paramContext;
      }
    }
    this.b = new File(paramContext);
    if (!this.b.exists()) {
      this.b.mkdirs();
    }
    return paramContext;
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
          if ((((GroupCatalogBean)localObject1).jdField_a_of_type_JavaUtilArrayList == null) || (((GroupCatalogBean)localObject1).jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
            break;
          }
          if (((GroupCatalogBean)localObject1).b.equals(paramString)) {
            return ((GroupCatalogBean)localObject1).jdField_a_of_type_JavaUtilArrayList;
          }
          localObject1 = a(((GroupCatalogBean)localObject1).jdField_a_of_type_JavaUtilArrayList, paramString);
          paramArrayList = (ArrayList<GroupCatalogBean>)localObject1;
        } while (localObject1 == null);
        return localObject1;
      } while (((GroupCatalogBean)localObject1).jdField_a_of_type_Int != 4);
      localObject1 = paramArrayList;
    }
    return localObject1;
  }
  
  /* Error */
  private GroupCatalogBean b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 148	com/tencent/mobileqq/troop/troopcatalog/GroupCatalogTool:a	()Z
    //   4: ifne +14 -> 18
    //   7: aload_1
    //   8: ldc 150
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 36	com/tencent/mobileqq/troop/troopcatalog/GroupCatalogTool:a	(Landroid/content/Context;)Ljava/lang/String;
    //   15: invokestatic 155	com/tencent/util/ZipUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   18: new 157	com/tencent/mobileqq/troop/troopcatalog/GroupCatalogXmlHandler
    //   21: dup
    //   22: aload_2
    //   23: invokespecial 158	com/tencent/mobileqq/troop/troopcatalog/GroupCatalogXmlHandler:<init>	(Ljava/lang/String;)V
    //   26: astore_3
    //   27: aconst_null
    //   28: astore 4
    //   30: invokestatic 164	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   33: invokevirtual 168	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   36: astore 5
    //   38: new 170	java/io/BufferedInputStream
    //   41: dup
    //   42: new 172	java/io/FileInputStream
    //   45: dup
    //   46: aload_0
    //   47: getfield 53	com/tencent/mobileqq/troop/troopcatalog/GroupCatalogTool:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   50: invokespecial 175	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: invokespecial 178	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: astore_2
    //   57: aload_2
    //   58: astore_1
    //   59: aload 5
    //   61: new 180	org/xml/sax/InputSource
    //   64: dup
    //   65: new 182	java/io/InputStreamReader
    //   68: dup
    //   69: aload_2
    //   70: ldc 184
    //   72: invokespecial 187	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   75: invokespecial 190	org/xml/sax/InputSource:<init>	(Ljava/io/Reader;)V
    //   78: aload_3
    //   79: invokevirtual 196	javax/xml/parsers/SAXParser:parse	(Lorg/xml/sax/InputSource;Lorg/xml/sax/helpers/DefaultHandler;)V
    //   82: aload_2
    //   83: astore_1
    //   84: aload_0
    //   85: aload_3
    //   86: invokevirtual 199	com/tencent/mobileqq/troop/troopcatalog/GroupCatalogXmlHandler:a	()Ljava/util/ArrayList;
    //   89: putfield 28	com/tencent/mobileqq/troop/troopcatalog/GroupCatalogTool:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   92: aload_2
    //   93: astore_1
    //   94: aload_3
    //   95: invokevirtual 202	com/tencent/mobileqq/troop/troopcatalog/GroupCatalogXmlHandler:a	()Lcom/tencent/mobileqq/troop/troopcatalog/GroupCatalogBean;
    //   98: astore_3
    //   99: aload_3
    //   100: astore_1
    //   101: aload_2
    //   102: invokevirtual 207	java/io/InputStream:close	()V
    //   105: aload_3
    //   106: areturn
    //   107: astore_2
    //   108: aload_2
    //   109: invokevirtual 210	java/io/IOException:printStackTrace	()V
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
    //   133: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +14 -> 150
    //   139: aload_2
    //   140: astore_1
    //   141: ldc 118
    //   143: iconst_2
    //   144: ldc 212
    //   146: aload_3
    //   147: invokestatic 216	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   150: aload_2
    //   151: ifnull +45 -> 196
    //   154: aload 4
    //   156: astore_1
    //   157: aload_2
    //   158: invokevirtual 207	java/io/InputStream:close	()V
    //   161: aconst_null
    //   162: areturn
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_2
    //   166: aload_2
    //   167: astore_1
    //   168: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +14 -> 185
    //   174: aload_2
    //   175: astore_1
    //   176: ldc 118
    //   178: iconst_2
    //   179: ldc 218
    //   181: aload_3
    //   182: invokestatic 216	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   185: aload_2
    //   186: ifnull +10 -> 196
    //   189: aload 4
    //   191: astore_1
    //   192: aload_2
    //   193: invokevirtual 207	java/io/InputStream:close	()V
    //   196: aconst_null
    //   197: areturn
    //   198: astore_2
    //   199: aload_1
    //   200: ifnull +15 -> 215
    //   203: aload_1
    //   204: invokevirtual 207	java/io/InputStream:close	()V
    //   207: goto +8 -> 215
    //   210: astore_1
    //   211: aload_1
    //   212: invokevirtual 210	java/io/IOException:printStackTrace	()V
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
  
  private String b(Context paramContext)
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
  
  protected long a(Context paramContext)
  {
    return paramContext.getSharedPreferences("LAST_GET_CLASS_CHOICE_URL_TIME", 0).getLong("GroupCatalogTool", 0L);
  }
  
  public GroupCatalogBean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean;
  }
  
  public GroupCatalogBean a(Context paramContext, String paramString)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      paramContext = a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean = paramContext;
      return paramContext;
    }
    paramContext = b(paramContext, paramString);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean = paramContext;
    return paramContext;
  }
  
  public ArrayList<GroupCatalogBean> a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList(Arrays.asList(new GroupCatalogBean[this.jdField_a_of_type_JavaUtilArrayList.size()]));
      Collections.copy(localArrayList, this.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList;
    }
  }
  
  public ArrayList<GroupCatalogBean> a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramString = a(this.jdField_a_of_type_JavaUtilArrayList, paramString);
      return paramString;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean = null;
  }
  
  public void a(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("LAST_GET_CLASS_CHOICE_URL_TIME", 0).edit();
    paramContext.putLong("GroupCatalogTool", paramLong);
    paramContext.commit();
  }
  
  public void a(GroupCatalogBean paramGroupCatalogBean)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean = paramGroupCatalogBean;
  }
  
  public void a(String paramString, GroupCatalogTool.GetChoiceListCallback paramGetChoiceListCallback)
  {
    long l = a(MobileQQ.sMobileQQ.getApplicationContext());
    boolean bool = this.jdField_a_of_type_JavaIoFile.exists();
    if ((System.currentTimeMillis() - l > 86400000L) || (!bool))
    {
      paramString = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(1);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("https://pub.idqqimg.com/pc/group/layer_new.zip");
      HashMap localHashMap = new HashMap();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(b(MobileQQ.getContext()));
      ((StringBuilder)localObject).append("layer_new.zip");
      localObject = new File(((StringBuilder)localObject).toString());
      localHashMap.put("https://pub.idqqimg.com/pc/group/layer_new.zip", localObject);
      paramString.startDownload(new DownloadTask(localArrayList, localHashMap, "https://pub.idqqimg.com/pc/group/layer_new.zip"), new GroupCatalogTool.1(this, (File)localObject, paramGetChoiceListCallback), new Bundle());
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_JavaIoFile.length() > 0L);
  }
  
  public boolean a(Context paramContext)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b(paramContext));
      localStringBuilder.append("layer_new.zip");
      ZipUtils.unZipFile(new File(localStringBuilder.toString()), b(paramContext));
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
  
  public boolean b(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(b(paramContext));
    ((StringBuilder)localObject).append("group_catalog_new.xml");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramContext));
    localStringBuilder.append("group_catalog_new.xml");
    return FileUtils.moveFile((String)localObject, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool
 * JD-Core Version:    0.7.0.1
 */