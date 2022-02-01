package com.tencent.mobileqq.filemanager.settings;

import android.app.Activity;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QQFMSettings
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  String jdField_a_of_type_JavaLangString = "";
  Map<String, QQFMSettings.StorageInfo> jdField_a_of_type_JavaUtilMap = null;
  boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString = "";
  boolean jdField_b_of_type_Boolean = false;
  long c = System.currentTimeMillis() / 1000L;
  long d = 0L;
  
  public QQFMSettings()
  {
    a(2, "new FMSetting!");
    a();
  }
  
  private long a(String paramString, List<String> paramList)
  {
    paramString = new File(paramString).listFiles();
    long l1 = 0L;
    long l2 = l1;
    if (paramString != null)
    {
      if (paramString.length == 0) {
        return 0L;
      }
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= paramString.length) {
          break;
        }
        Object localObject = paramString[i];
        if (localObject.isDirectory()) {}
        for (l2 = a(localObject.getPath(), paramList);; l2 = paramString[i].length())
        {
          l1 += l2;
          break;
          if (paramList != null) {
            paramList.add(localObject.getAbsolutePath());
          }
        }
        i += 1;
      }
    }
    return l2;
  }
  
  private String a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("/Tencent/QQfile_recv/");
    paramString = ((StringBuilder)localObject).toString().replace("//", "/");
    localObject = new File(paramString);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramString;
  }
  
  public static void a(int paramInt, String paramString) {}
  
  /* Error */
  private void a(File paramFile1, File paramFile2, FMSettingInterface.MoveFileCallback paramMoveFileCallback)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 7
    //   12: aload_1
    //   13: invokevirtual 121	java/io/File:exists	()Z
    //   16: ifeq +201 -> 217
    //   19: aload_1
    //   20: invokevirtual 90	java/io/File:length	()J
    //   23: lconst_0
    //   24: lcmp
    //   25: ifne +6 -> 31
    //   28: goto +189 -> 217
    //   31: aload_2
    //   32: invokevirtual 121	java/io/File:exists	()Z
    //   35: ifeq +8 -> 43
    //   38: aload_2
    //   39: invokevirtual 144	java/io/File:delete	()Z
    //   42: pop
    //   43: new 146	java/io/FileOutputStream
    //   46: dup
    //   47: aload_2
    //   48: invokespecial 149	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   51: astore 5
    //   53: new 151	java/io/FileInputStream
    //   56: dup
    //   57: aload_1
    //   58: invokespecial 152	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: astore 6
    //   63: invokestatic 158	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   66: sipush 4096
    //   69: invokevirtual 162	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   72: astore 7
    //   74: aload 6
    //   76: aload 7
    //   78: invokevirtual 166	java/io/FileInputStream:read	([B)I
    //   81: istore 4
    //   83: iload 4
    //   85: iconst_m1
    //   86: if_icmpeq +38 -> 124
    //   89: aload_0
    //   90: getfield 29	com/tencent/mobileqq/filemanager/settings/QQFMSettings:jdField_a_of_type_Boolean	Z
    //   93: ifne +31 -> 124
    //   96: aload 5
    //   98: aload 7
    //   100: iconst_0
    //   101: iload 4
    //   103: invokevirtual 170	java/io/FileOutputStream:write	([BII)V
    //   106: aload 5
    //   108: invokevirtual 173	java/io/FileOutputStream:flush	()V
    //   111: aload_3
    //   112: iload 4
    //   114: i2l
    //   115: lconst_0
    //   116: invokeinterface 178 5 0
    //   121: goto -47 -> 74
    //   124: invokestatic 158	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   127: aload 7
    //   129: invokevirtual 182	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   132: aload 5
    //   134: invokevirtual 185	java/io/FileOutputStream:close	()V
    //   137: aload 6
    //   139: invokevirtual 186	java/io/FileInputStream:close	()V
    //   142: aload_3
    //   143: aload_1
    //   144: invokevirtual 81	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   147: aload_2
    //   148: invokevirtual 81	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   151: invokeinterface 189 3 0
    //   156: aload_3
    //   157: invokeinterface 190 1 0
    //   162: return
    //   163: astore 8
    //   165: aload 6
    //   167: astore 7
    //   169: aload 8
    //   171: astore 6
    //   173: goto +76 -> 249
    //   176: aload 6
    //   178: astore_1
    //   179: goto +122 -> 301
    //   182: aload 6
    //   184: astore_1
    //   185: goto +151 -> 336
    //   188: aload 6
    //   190: astore_1
    //   191: goto +180 -> 371
    //   194: astore 6
    //   196: goto +53 -> 249
    //   199: aload 8
    //   201: astore_1
    //   202: goto +99 -> 301
    //   205: aload 9
    //   207: astore_1
    //   208: goto +128 -> 336
    //   211: aload 10
    //   213: astore_1
    //   214: goto +157 -> 371
    //   217: iconst_1
    //   218: ldc 192
    //   220: invokestatic 54	com/tencent/mobileqq/filemanager/settings/QQFMSettings:a	(ILjava/lang/String;)V
    //   223: aload_3
    //   224: aload_1
    //   225: invokevirtual 81	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   228: aload_2
    //   229: invokevirtual 81	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   232: invokeinterface 189 3 0
    //   237: aload_3
    //   238: invokeinterface 190 1 0
    //   243: return
    //   244: astore 6
    //   246: aconst_null
    //   247: astore 5
    //   249: aload 5
    //   251: ifnull +11 -> 262
    //   254: aload 5
    //   256: invokevirtual 185	java/io/FileOutputStream:close	()V
    //   259: goto +3 -> 262
    //   262: aload 7
    //   264: ifnull +8 -> 272
    //   267: aload 7
    //   269: invokevirtual 186	java/io/FileInputStream:close	()V
    //   272: aload_3
    //   273: aload_1
    //   274: invokevirtual 81	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   277: aload_2
    //   278: invokevirtual 81	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   281: invokeinterface 189 3 0
    //   286: aload_3
    //   287: invokeinterface 190 1 0
    //   292: aload 6
    //   294: athrow
    //   295: aconst_null
    //   296: astore 5
    //   298: aload 8
    //   300: astore_1
    //   301: aload 5
    //   303: ifnull +11 -> 314
    //   306: aload 5
    //   308: invokevirtual 185	java/io/FileOutputStream:close	()V
    //   311: goto +3 -> 314
    //   314: aload_1
    //   315: ifnull +7 -> 322
    //   318: aload_1
    //   319: invokevirtual 186	java/io/FileInputStream:close	()V
    //   322: aload_3
    //   323: iconst_m1
    //   324: invokeinterface 195 2 0
    //   329: return
    //   330: aconst_null
    //   331: astore 5
    //   333: aload 9
    //   335: astore_1
    //   336: aload 5
    //   338: ifnull +11 -> 349
    //   341: aload 5
    //   343: invokevirtual 185	java/io/FileOutputStream:close	()V
    //   346: goto +3 -> 349
    //   349: aload_1
    //   350: ifnull +7 -> 357
    //   353: aload_1
    //   354: invokevirtual 186	java/io/FileInputStream:close	()V
    //   357: aload_3
    //   358: iconst_m1
    //   359: invokeinterface 195 2 0
    //   364: return
    //   365: aconst_null
    //   366: astore 5
    //   368: aload 10
    //   370: astore_1
    //   371: aload 5
    //   373: ifnull +11 -> 384
    //   376: aload 5
    //   378: invokevirtual 185	java/io/FileOutputStream:close	()V
    //   381: goto +3 -> 384
    //   384: aload_1
    //   385: ifnull +7 -> 392
    //   388: aload_1
    //   389: invokevirtual 186	java/io/FileInputStream:close	()V
    //   392: aload_3
    //   393: iconst_m1
    //   394: invokeinterface 195 2 0
    //   399: return
    //   400: astore_1
    //   401: goto -36 -> 365
    //   404: astore_1
    //   405: goto -75 -> 330
    //   408: astore_1
    //   409: goto -114 -> 295
    //   412: astore_1
    //   413: goto -202 -> 211
    //   416: astore_1
    //   417: goto -212 -> 205
    //   420: astore_1
    //   421: goto -222 -> 199
    //   424: astore_1
    //   425: goto -237 -> 188
    //   428: astore_1
    //   429: goto -247 -> 182
    //   432: astore_1
    //   433: goto -257 -> 176
    //   436: astore 5
    //   438: goto -301 -> 137
    //   441: astore 5
    //   443: goto -301 -> 142
    //   446: astore 5
    //   448: goto -186 -> 262
    //   451: astore 5
    //   453: goto -181 -> 272
    //   456: astore_2
    //   457: goto -143 -> 314
    //   460: astore_1
    //   461: goto -139 -> 322
    //   464: astore_2
    //   465: goto -116 -> 349
    //   468: astore_1
    //   469: goto -112 -> 357
    //   472: astore_2
    //   473: goto -89 -> 384
    //   476: astore_1
    //   477: goto -85 -> 392
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	480	0	this	QQFMSettings
    //   0	480	1	paramFile1	File
    //   0	480	2	paramFile2	File
    //   0	480	3	paramMoveFileCallback	FMSettingInterface.MoveFileCallback
    //   81	32	4	i	int
    //   51	326	5	localFileOutputStream	java.io.FileOutputStream
    //   436	1	5	localException1	Exception
    //   441	1	5	localException2	Exception
    //   446	1	5	localException3	Exception
    //   451	1	5	localException4	Exception
    //   61	128	6	localObject1	Object
    //   194	1	6	localObject2	Object
    //   244	49	6	localObject3	Object
    //   10	258	7	localObject4	Object
    //   1	1	8	localObject5	Object
    //   163	136	8	localObject6	Object
    //   4	330	9	localObject7	Object
    //   7	362	10	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   63	74	163	finally
    //   74	83	163	finally
    //   89	121	163	finally
    //   124	132	163	finally
    //   53	63	194	finally
    //   12	28	244	finally
    //   31	43	244	finally
    //   43	53	244	finally
    //   217	223	244	finally
    //   12	28	400	java/io/IOException
    //   31	43	400	java/io/IOException
    //   43	53	400	java/io/IOException
    //   217	223	400	java/io/IOException
    //   12	28	404	java/lang/OutOfMemoryError
    //   31	43	404	java/lang/OutOfMemoryError
    //   43	53	404	java/lang/OutOfMemoryError
    //   217	223	404	java/lang/OutOfMemoryError
    //   12	28	408	java/lang/Exception
    //   31	43	408	java/lang/Exception
    //   43	53	408	java/lang/Exception
    //   217	223	408	java/lang/Exception
    //   53	63	412	java/io/IOException
    //   53	63	416	java/lang/OutOfMemoryError
    //   53	63	420	java/lang/Exception
    //   63	74	424	java/io/IOException
    //   74	83	424	java/io/IOException
    //   89	121	424	java/io/IOException
    //   124	132	424	java/io/IOException
    //   63	74	428	java/lang/OutOfMemoryError
    //   74	83	428	java/lang/OutOfMemoryError
    //   89	121	428	java/lang/OutOfMemoryError
    //   124	132	428	java/lang/OutOfMemoryError
    //   63	74	432	java/lang/Exception
    //   74	83	432	java/lang/Exception
    //   89	121	432	java/lang/Exception
    //   124	132	432	java/lang/Exception
    //   132	137	436	java/lang/Exception
    //   137	142	441	java/lang/Exception
    //   254	259	446	java/lang/Exception
    //   267	272	451	java/lang/Exception
    //   306	311	456	java/lang/Exception
    //   318	322	460	java/lang/Exception
    //   341	346	464	java/lang/Exception
    //   353	357	468	java/lang/Exception
    //   376	381	472	java/lang/Exception
    //   388	392	476	java/lang/Exception
  }
  
  private void a(List<String> paramList, FMSettingInterface.MoveFileCallback paramMoveFileCallback)
  {
    a(1, "moveFileToDefaultPath");
    if ((paramList != null) && (paramList.size() != 0))
    {
      this.jdField_a_of_type_Long = 0L;
      try
      {
        this.jdField_a_of_type_Int = 0;
        this.jdField_b_of_type_Long = 0L;
        Object localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          str1 = (String)((Iterator)localObject).next();
          this.jdField_b_of_type_Long += FileUtil.a(str1);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("moveFileToDefaultPath,total size[");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
        ((StringBuilder)localObject).append("]");
        a(1, ((StringBuilder)localObject).toString());
        if (this.jdField_b_of_type_Long == 0L)
        {
          paramMoveFileCallback.a();
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(d().jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject).append(d().c);
        String str1 = ((StringBuilder)localObject).toString();
        int j = paramList.size();
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            String str2 = (String)paramList.get(i);
            if (str2.contains("/.tmp/"))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(b(str1));
              ((StringBuilder)localObject).append(QQFileManagerUtilImpl.b(str2));
              localObject = ((StringBuilder)localObject).toString();
            }
            else if (str2.contains("/.thumbnails/"))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(c(str1));
              ((StringBuilder)localObject).append(QQFileManagerUtilImpl.b(str2));
              localObject = ((StringBuilder)localObject).toString();
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(a(str1));
              ((StringBuilder)localObject).append(QQFileManagerUtilImpl.b(str2));
              localObject = ((StringBuilder)localObject).toString();
            }
            localObject = new File((String)localObject);
            try
            {
              ThreadManager.post(new QQFMSettings.4(this, str2, (File)localObject, j, paramMoveFileCallback), 8, null, false);
              i += 1;
            }
            catch (Exception paramList)
            {
              paramMoveFileCallback = new StringBuilder();
              paramMoveFileCallback.append("copyFile Fail! ");
              paramMoveFileCallback.append(paramList.toString());
              a(1, paramMoveFileCallback.toString());
            }
          }
        }
        return;
      }
      finally {}
    }
    a(1, "moveFileToDefaultPath,lstPath is null or size = 0");
  }
  
  private boolean a(String paramString)
  {
    Object localObject = new File(paramString);
    boolean bool;
    if (!((File)localObject).exists()) {
      bool = ((File)localObject).mkdirs();
    } else {
      bool = false;
    }
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("create [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("] success!");
      a(2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  private QQFMSettings.StorageInfo b()
  {
    return (QQFMSettings.StorageInfo)this.jdField_a_of_type_JavaUtilMap.get("sdCard");
  }
  
  private String b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("/Tencent/QQfile_recv/.tmp/");
    paramString = ((StringBuilder)localObject).toString().replace("//", "/");
    localObject = new File(paramString);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramString;
  }
  
  private QQFMSettings.StorageInfo c()
  {
    if (this.jdField_a_of_type_JavaUtilMap.size() == 1) {
      return null;
    }
    return (QQFMSettings.StorageInfo)this.jdField_a_of_type_JavaUtilMap.get("externalSdCard");
  }
  
  private String c(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("/Tencent/QQfile_recv/.thumbnails/");
    paramString = ((StringBuilder)localObject).toString().replace("//", "/");
    localObject = new File(paramString);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramString;
  }
  
  private void c()
  {
    QQFMSettings.StorageInfo localStorageInfo = a();
    if (localStorageInfo == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localStorageInfo.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(localStorageInfo.c);
    ThreadManager.post(new QQFMSettings.1(this, b(localStringBuilder.toString())), 8, null, false);
  }
  
  private QQFMSettings.StorageInfo d()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getDefaultStorage[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilMap.size());
    ((StringBuilder)localObject1).append("]");
    a(2, ((StringBuilder)localObject1).toString());
    localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (QQFMSettings.StorageInfo)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
      ((QQFMSettings.StorageInfo)localObject2).a();
      if (((QQFMSettings.StorageInfo)localObject2).jdField_a_of_type_Boolean)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getDefaultStorage[");
        ((StringBuilder)localObject1).append(((QQFMSettings.StorageInfo)localObject2).jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append("] + ext[");
        ((StringBuilder)localObject1).append(((QQFMSettings.StorageInfo)localObject2).c);
        ((StringBuilder)localObject1).append("]");
        a(2, ((StringBuilder)localObject1).toString());
        return localObject2;
      }
    }
    a(2, "getDefaultStorage nothing is default refresh!");
    Object localObject2 = (QQFMSettings.StorageInfo)this.jdField_a_of_type_JavaUtilMap.get("sdCard");
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new QQFMSettings.StorageInfo(this, null);
      ((QQFMSettings.StorageInfo)localObject1).jdField_a_of_type_Boolean = true;
      ((QQFMSettings.StorageInfo)localObject1).jdField_a_of_type_JavaLangString = "SD卡";
      ((QQFMSettings.StorageInfo)localObject1).jdField_b_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath();
      ((QQFMSettings.StorageInfo)localObject1).c = "";
    }
    ((QQFMSettings.StorageInfo)localObject1).a(BaseApplication.getContext());
    return localObject1;
  }
  
  public long a()
  {
    Object localObject = d().jdField_b_of_type_JavaLangString;
    try
    {
      localObject = new StatFs((String)localObject);
      long l = ((StatFs)localObject).getAvailableBlocks();
      int i = ((StatFs)localObject).getBlockSize();
      return l * i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 2147483647L;
  }
  
  public QQFMSettings.StorageInfo a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getOtherStorage[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilMap.size());
    ((StringBuilder)localObject1).append("]");
    a(2, ((StringBuilder)localObject1).toString());
    localObject1 = d();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      localObject2 = (QQFMSettings.StorageInfo)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
      if (localObject1 != localObject2) {
        return localObject2;
      }
    }
    a(2, "getOtherStorage nothing is default refresh!");
    return null;
  }
  
  public String a()
  {
    QQFMSettings.StorageInfo localStorageInfo = a();
    if (localStorageInfo == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localStorageInfo.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(localStorageInfo.c);
    return a(localStringBuilder.toString());
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 29	com/tencent/mobileqq/filemanager/settings/QQFMSettings:jdField_a_of_type_Boolean	Z
    //   5: invokestatic 335	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8: astore 7
    //   10: aload 7
    //   12: invokestatic 359	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl:a	(Landroid/content/Context;)Ljava/util/Map;
    //   15: astore 8
    //   17: new 98	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   24: astore 6
    //   26: aload 6
    //   28: ldc_w 361
    //   31: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 6
    //   37: aload 8
    //   39: invokeinterface 288 1 0
    //   44: invokevirtual 304	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 6
    //   50: ldc 226
    //   52: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: iconst_1
    //   57: aload 6
    //   59: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 54	com/tencent/mobileqq/filemanager/settings/QQFMSettings:a	(ILjava/lang/String;)V
    //   65: aload 7
    //   67: ldc_w 363
    //   70: iconst_4
    //   71: invokevirtual 369	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   74: ldc_w 371
    //   77: getstatic 376	com/tencent/mobileqq/app/AppConstants:SDCARD_ROOT	Ljava/lang/String;
    //   80: invokeinterface 382 3 0
    //   85: astore 9
    //   87: new 98	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   94: astore 6
    //   96: aload 6
    //   98: ldc_w 384
    //   101: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 6
    //   107: aload 9
    //   109: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 6
    //   115: ldc 226
    //   117: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: iconst_1
    //   122: aload 6
    //   124: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 54	com/tencent/mobileqq/filemanager/settings/QQFMSettings:a	(ILjava/lang/String;)V
    //   130: aload_0
    //   131: new 386	java/util/HashMap
    //   134: dup
    //   135: invokespecial 387	java/util/HashMap:<init>	()V
    //   138: putfield 21	com/tencent/mobileqq/filemanager/settings/QQFMSettings:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   141: aload 8
    //   143: invokeinterface 308 1 0
    //   148: invokeinterface 311 1 0
    //   153: astore 10
    //   155: aload 10
    //   157: invokeinterface 210 1 0
    //   162: ifeq +426 -> 588
    //   165: aload 10
    //   167: invokeinterface 214 1 0
    //   172: checkcast 114	java/lang/String
    //   175: astore 6
    //   177: aload 8
    //   179: aload 6
    //   181: invokeinterface 285 2 0
    //   186: checkcast 63	java/io/File
    //   189: invokevirtual 78	java/io/File:getPath	()Ljava/lang/String;
    //   192: astore 12
    //   194: new 231	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo
    //   197: dup
    //   198: aload_0
    //   199: aconst_null
    //   200: invokespecial 320	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:<init>	(Lcom/tencent/mobileqq/filemanager/settings/QQFMSettings;Lcom/tencent/mobileqq/filemanager/settings/QQFMSettings$1;)V
    //   203: astore 11
    //   205: aload 11
    //   207: iconst_0
    //   208: putfield 313	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:jdField_a_of_type_Boolean	Z
    //   211: aload 6
    //   213: ldc_w 280
    //   216: invokevirtual 390	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   219: ifeq +28 -> 247
    //   222: aload 11
    //   224: ldc_w 322
    //   227: putfield 323	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   230: aload 11
    //   232: aload 12
    //   234: putfield 232	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   237: aload 11
    //   239: ldc 31
    //   241: putfield 234	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:c	Ljava/lang/String;
    //   244: goto +88 -> 332
    //   247: aload 6
    //   249: ldc_w 290
    //   252: invokevirtual 390	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   255: ifeq +77 -> 332
    //   258: aload 11
    //   260: ldc_w 392
    //   263: putfield 323	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   266: aload 7
    //   268: aconst_null
    //   269: invokevirtual 396	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   272: pop
    //   273: invokestatic 335	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   276: invokevirtual 399	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   279: astore 13
    //   281: aload 11
    //   283: aload 12
    //   285: putfield 232	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   288: new 98	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   295: astore 14
    //   297: aload 14
    //   299: ldc_w 401
    //   302: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 14
    //   308: aload 13
    //   310: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 14
    //   316: ldc 112
    //   318: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 11
    //   324: aload 14
    //   326: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: putfield 234	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:c	Ljava/lang/String;
    //   332: new 98	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   339: astore 13
    //   341: aload 13
    //   343: ldc_w 403
    //   346: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload 13
    //   352: aload 11
    //   354: getfield 232	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   357: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload 13
    //   363: ldc_w 405
    //   366: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload 13
    //   372: aload 11
    //   374: getfield 313	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:jdField_a_of_type_Boolean	Z
    //   377: invokevirtual 408	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload 13
    //   383: ldc 226
    //   385: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: iconst_1
    //   390: aload 13
    //   392: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 54	com/tencent/mobileqq/filemanager/settings/QQFMSettings:a	(ILjava/lang/String;)V
    //   398: new 340	android/os/StatFs
    //   401: dup
    //   402: aload 12
    //   404: invokespecial 341	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   407: astore 12
    //   409: aload 12
    //   411: invokevirtual 344	android/os/StatFs:getAvailableBlocks	()I
    //   414: i2l
    //   415: lstore_2
    //   416: aload 12
    //   418: invokevirtual 347	android/os/StatFs:getBlockSize	()I
    //   421: istore_1
    //   422: iload_1
    //   423: i2l
    //   424: lstore 4
    //   426: aload 11
    //   428: lload_2
    //   429: lload 4
    //   431: lmul
    //   432: putfield 409	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:jdField_a_of_type_Long	J
    //   435: new 98	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   442: astore 12
    //   444: aload 12
    //   446: ldc_w 411
    //   449: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload 12
    //   455: aload 9
    //   457: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload 12
    //   463: ldc_w 413
    //   466: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload 12
    //   472: aload 11
    //   474: getfield 232	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   477: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload 12
    //   483: ldc_w 415
    //   486: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: iconst_4
    //   491: aload 12
    //   493: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 54	com/tencent/mobileqq/filemanager/settings/QQFMSettings:a	(ILjava/lang/String;)V
    //   499: aload 8
    //   501: invokeinterface 288 1 0
    //   506: iconst_1
    //   507: if_icmpeq +19 -> 526
    //   510: aload 9
    //   512: aload 11
    //   514: getfield 232	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   517: invokevirtual 390	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   520: ifeq +69 -> 589
    //   523: goto +3 -> 526
    //   526: iconst_4
    //   527: ldc_w 417
    //   530: invokestatic 54	com/tencent/mobileqq/filemanager/settings/QQFMSettings:a	(ILjava/lang/String;)V
    //   533: aload 11
    //   535: iconst_1
    //   536: putfield 313	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:jdField_a_of_type_Boolean	Z
    //   539: aload 11
    //   541: aload 7
    //   543: invokevirtual 338	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:a	(Landroid/content/Context;)V
    //   546: aload 11
    //   548: invokevirtual 312	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:a	()V
    //   551: aload_0
    //   552: getfield 21	com/tencent/mobileqq/filemanager/settings/QQFMSettings:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   555: aload 6
    //   557: aload 11
    //   559: invokeinterface 421 3 0
    //   564: pop
    //   565: goto +20 -> 585
    //   568: astore 6
    //   570: goto +10 -> 580
    //   573: astore 6
    //   575: goto +5 -> 580
    //   578: astore 6
    //   580: aload 6
    //   582: invokevirtual 350	java/lang/Exception:printStackTrace	()V
    //   585: goto -430 -> 155
    //   588: return
    //   589: goto -43 -> 546
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	592	0	this	QQFMSettings
    //   421	2	1	i	int
    //   415	14	2	l1	long
    //   424	6	4	l2	long
    //   24	532	6	localObject1	Object
    //   568	1	6	localException1	Exception
    //   573	1	6	localException2	Exception
    //   578	3	6	localException3	Exception
    //   8	534	7	localBaseApplication	BaseApplication
    //   15	485	8	localMap	Map
    //   85	426	9	str	String
    //   153	13	10	localIterator	Iterator
    //   203	355	11	localStorageInfo	QQFMSettings.StorageInfo
    //   192	300	12	localObject2	Object
    //   279	112	13	localObject3	Object
    //   295	30	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   539	546	568	java/lang/Exception
    //   546	565	568	java/lang/Exception
    //   426	523	573	java/lang/Exception
    //   526	539	573	java/lang/Exception
    //   177	244	578	java/lang/Exception
    //   247	332	578	java/lang/Exception
    //   332	422	578	java/lang/Exception
  }
  
  public void a(long paramLong, List<String> arg3, Activity paramActivity, FMSettingInterface.MoveFileCallback paramMoveFileCallback)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    synchronized (BaseApplication.getContext())
    {
      this.jdField_b_of_type_Boolean = true;
      long l = b();
      if (!a())
      {
        paramMoveFileCallback.a(12);
        synchronized (BaseApplication.getContext())
        {
          this.jdField_b_of_type_Boolean = false;
          return;
        }
      }
      if (l < paramLong)
      {
        paramMoveFileCallback.a(16);
        synchronized (BaseApplication.getContext())
        {
          this.jdField_b_of_type_Boolean = false;
          return;
        }
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("showChoosePath, callback[");
      ((StringBuilder)???).append(paramMoveFileCallback);
      ((StringBuilder)???).append("]");
      a(1, ((StringBuilder)???).toString());
      ??? = b();
      QQFMSettings.StorageInfo localStorageInfo = c();
      if (((QQFMSettings.StorageInfo)???).jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131704766);
        ??? = new StringBuilder();
        ((StringBuilder)???).append(a().jdField_b_of_type_JavaLangString);
        ((StringBuilder)???).append(a().c);
        ((StringBuilder)???).append("/Tencent/QQfile_recv/");
        this.jdField_b_of_type_JavaLangString = ((StringBuilder)???).toString().replace("//", "/");
      }
      else if ((localStorageInfo != null) && (localStorageInfo.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131704763);
        ??? = new StringBuilder();
        ((StringBuilder)???).append(a().jdField_b_of_type_JavaLangString);
        ((StringBuilder)???).append(a().c);
        ((StringBuilder)???).append("/Tencent/QQfile_recv/");
        this.jdField_b_of_type_JavaLangString = ((StringBuilder)???).toString().replace("//", "/");
      }
      if (paramActivity == null) {
        return;
      }
      paramActivity.runOnUiThread(new QQFMSettings.5(this, paramActivity, ???, paramMoveFileCallback));
      return;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap != null)
      {
        if (this.jdField_a_of_type_JavaUtilMap.size() == 0) {
          return;
        }
        this.jdField_a_of_type_Boolean = true;
        if (paramString != null) {
          this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        }
        if ("externalSdCard".equalsIgnoreCase(paramString)) {
          ((QQFMSettings.StorageInfo)this.jdField_a_of_type_JavaUtilMap.get("sdCard")).a(BaseApplication.getContext());
        }
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilMap.size() == 1) {
      return false;
    }
    return c() != null;
  }
  
  public long b()
  {
    Object localObject = a();
    if (localObject == null) {
      return 0L;
    }
    localObject = ((QQFMSettings.StorageInfo)localObject).jdField_b_of_type_JavaLangString;
    try
    {
      localObject = new StatFs((String)localObject);
      long l = ((StatFs)localObject).getAvailableBlocks();
      int i = ((StatFs)localObject).getBlockSize();
      return l * i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 2147483647L;
  }
  
  public String b()
  {
    return AppConstants.SDCARD_FILE_SAVE_PATH;
  }
  
  public void b()
  {
    try
    {
      a(1, "FMSettings free");
      Field localField = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getClass().getSuperclass().getDeclaredField("mShowing");
      localField.setAccessible(true);
      localField.set(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog, Boolean.valueOf(true));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public String c()
  {
    return AppConstants.SDCARD_FILE_SAVE_TMP_PATH;
  }
  
  public String d()
  {
    return AppConstants.SDCARD_FILE_SAVE_THUMB_PATH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.QQFMSettings
 * JD-Core Version:    0.7.0.1
 */