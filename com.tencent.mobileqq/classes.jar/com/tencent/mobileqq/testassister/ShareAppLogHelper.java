package com.tencent.mobileqq.testassister;

import aink;
import ainl;
import ainm;
import ainn;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.format.Time;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShareAppLogHelper
{
  private Handler jdField_a_of_type_AndroidOsHandler = new aink(this, Looper.getMainLooper());
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private ShareAppLogHelper.OnGetLocalLogListener jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper$OnGetLocalLogListener;
  volatile Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/com/tencent/mobileqq/";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("\\d{2}.\\d{2}.\\d{2}.\\d{2}");
  private boolean jdField_a_of_type_Boolean;
  private Time jdField_b_of_type_AndroidTextFormatTime;
  private String jdField_b_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/tencent/com/tencent/mobileqq/";
  private boolean jdField_b_of_type_Boolean;
  private String c;
  
  public ShareAppLogHelper(Context paramContext) {}
  
  private int a()
  {
    int j = 0;
    Object localObject = new File(this.jdField_a_of_type_JavaLangString);
    int i;
    if (!((File)localObject).exists())
    {
      i = -1;
      return i;
    }
    a();
    localObject = ((File)localObject).listFiles(new ainm(this));
    if ((localObject != null) && (localObject.length > 0))
    {
      int k = localObject.length;
      i = 0;
      while (i < k)
      {
        ShareAppLogHelper.LogFile localLogFile = new ShareAppLogHelper.LogFile(localObject[i].getPath());
        this.jdField_a_of_type_JavaUtilArrayList.add(localLogFile);
        i += 1;
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new ShareAppLogHelper.LogFile("/data/anr/traces.txt");
      long l = ((ShareAppLogHelper.LogFile)localObject).length();
      if ((((ShareAppLogHelper.LogFile)localObject).exists()) && (((ShareAppLogHelper.LogFile)localObject).canRead()) && (l != 0L)) {
        break label185;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LOGFILE", 2, "traces.txt can not read or not exist");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        i = j;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          break;
        }
      }
      return -2;
      label185:
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    }
  }
  
  private Time a(String paramString)
  {
    paramString = this.jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    if (paramString.find())
    {
      paramString = a(paramString.group(), "\\.");
      if (paramString != null)
      {
        if (paramString.year < 100) {
          paramString.year += 2000;
        }
        return paramString;
      }
    }
    return null;
  }
  
  public static Time a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramString1.split(paramString2);
      if (paramString1.length == 4)
      {
        paramString2 = new Time();
        paramString2.year = Integer.parseInt(paramString1[0]);
        paramString2.month = (Integer.parseInt(paramString1[1]) - 1);
        paramString2.monthDay = Integer.parseInt(paramString1[2]);
        paramString2.hour = Integer.parseInt(paramString1[3]);
        return paramString2;
      }
      if (paramString1.length == 3)
      {
        paramString2 = new Time();
        paramString2.year = Integer.parseInt(paramString1[0]);
        paramString2.month = (Integer.parseInt(paramString1[1]) - 1);
        paramString2.monthDay = Integer.parseInt(paramString1[2]);
        return paramString2;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  private String a(Time paramTime)
  {
    return String.format("%4d_%2d_%2d_%2d", new Object[] { Integer.valueOf(paramTime.year), Integer.valueOf(paramTime.month + 1), Integer.valueOf(paramTime.monthDay), Integer.valueOf(paramTime.hour) });
  }
  
  private String a(Time paramTime1, Time paramTime2)
  {
    return "logs_zip_" + a(paramTime1) + "-" + a(paramTime2) + ".zip";
  }
  
  private void a()
  {
    Object localObject = new File(this.jdField_b_of_type_JavaLangString);
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).listFiles(new ainn(this));
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          ShareAppLogHelper.LogFile localLogFile = new ShareAppLogHelper.LogFile(localObject[i].getPath());
          localLogFile.stuffix = ".old";
          this.jdField_a_of_type_JavaUtilArrayList.add(localLogFile);
          i += 1;
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1001;
    localMessage.obj = Integer.valueOf(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void a(String paramString)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1000;
    if (paramString == null) {}
    for (localMessage.obj = "";; localMessage.obj = paramString)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
    }
  }
  
  /* Error */
  private int b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: new 60	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   10: aload_0
    //   11: getfield 84	com/tencent/mobileqq/testassister/ShareAppLogHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 149	com/tencent/mobileqq/testassister/ShareAppLogHelper:jdField_a_of_type_AndroidTextFormatTime	Landroid/text/format/Time;
    //   22: aload_0
    //   23: getfield 273	com/tencent/mobileqq/testassister/ShareAppLogHelper:jdField_b_of_type_AndroidTextFormatTime	Landroid/text/format/Time;
    //   26: invokespecial 275	com/tencent/mobileqq/testassister/ShareAppLogHelper:a	(Landroid/text/format/Time;Landroid/text/format/Time;)Ljava/lang/String;
    //   29: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: putfield 229	com/tencent/mobileqq/testassister/ShareAppLogHelper:c	Ljava/lang/String;
    //   38: new 69	java/io/File
    //   41: dup
    //   42: aload_0
    //   43: getfield 229	com/tencent/mobileqq/testassister/ShareAppLogHelper:c	Ljava/lang/String;
    //   46: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore 5
    //   51: new 277	java/io/BufferedOutputStream
    //   54: dup
    //   55: new 279	java/io/FileOutputStream
    //   58: dup
    //   59: aload 5
    //   61: invokespecial 282	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   64: invokespecial 285	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   67: astore 4
    //   69: new 287	java/util/zip/ZipOutputStream
    //   72: dup
    //   73: aload 4
    //   75: invokespecial 288	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   78: astore_3
    //   79: sipush 8192
    //   82: newarray byte
    //   84: astore_2
    //   85: aload_0
    //   86: getfield 36	com/tencent/mobileqq/testassister/ShareAppLogHelper:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   89: invokevirtual 292	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   92: astore 6
    //   94: aload 6
    //   96: invokeinterface 297 1 0
    //   101: ifeq +216 -> 317
    //   104: aload 6
    //   106: invokeinterface 301 1 0
    //   111: checkcast 110	com/tencent/mobileqq/testassister/ShareAppLogHelper$LogFile
    //   114: astore 7
    //   116: new 303	java/util/zip/ZipEntry
    //   119: dup
    //   120: new 60	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   127: aload 7
    //   129: invokevirtual 306	com/tencent/mobileqq/testassister/ShareAppLogHelper$LogFile:getName	()Ljava/lang/String;
    //   132: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload 7
    //   137: getfield 237	com/tencent/mobileqq/testassister/ShareAppLogHelper$LogFile:stuffix	Ljava/lang/String;
    //   140: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokespecial 307	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   149: astore 8
    //   151: aload 8
    //   153: aload 7
    //   155: invokevirtual 123	com/tencent/mobileqq/testassister/ShareAppLogHelper$LogFile:length	()J
    //   158: invokevirtual 311	java/util/zip/ZipEntry:setSize	(J)V
    //   161: aload 8
    //   163: aload 7
    //   165: invokevirtual 314	com/tencent/mobileqq/testassister/ShareAppLogHelper$LogFile:lastModified	()J
    //   168: invokevirtual 317	java/util/zip/ZipEntry:setTime	(J)V
    //   171: aload_3
    //   172: aload 8
    //   174: invokevirtual 321	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   177: new 323	java/io/BufferedInputStream
    //   180: dup
    //   181: new 325	java/io/FileInputStream
    //   184: dup
    //   185: aload 7
    //   187: invokespecial 326	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   190: invokespecial 329	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   193: astore 7
    //   195: aload 7
    //   197: aload_2
    //   198: iconst_0
    //   199: sipush 8192
    //   202: invokevirtual 335	java/io/InputStream:read	([BII)I
    //   205: istore_1
    //   206: iload_1
    //   207: iconst_m1
    //   208: if_icmpeq +67 -> 275
    //   211: aload_3
    //   212: aload_2
    //   213: iconst_0
    //   214: iload_1
    //   215: invokevirtual 339	java/util/zip/ZipOutputStream:write	([BII)V
    //   218: goto -23 -> 195
    //   221: astore_2
    //   222: aload 7
    //   224: ifnull +8 -> 232
    //   227: aload 7
    //   229: invokevirtual 342	java/io/InputStream:close	()V
    //   232: aload_3
    //   233: invokevirtual 345	java/util/zip/ZipOutputStream:flush	()V
    //   236: aload_3
    //   237: invokevirtual 348	java/util/zip/ZipOutputStream:closeEntry	()V
    //   240: aload_2
    //   241: athrow
    //   242: astore 5
    //   244: aload 4
    //   246: astore_2
    //   247: aload 5
    //   249: astore 4
    //   251: aload 4
    //   253: invokevirtual 203	java/lang/Exception:printStackTrace	()V
    //   256: aload_3
    //   257: ifnull +7 -> 264
    //   260: aload_3
    //   261: invokevirtual 349	java/util/zip/ZipOutputStream:close	()V
    //   264: aload_2
    //   265: ifnull +7 -> 272
    //   268: aload_2
    //   269: invokevirtual 350	java/io/BufferedOutputStream:close	()V
    //   272: bipush 253
    //   274: ireturn
    //   275: aload 7
    //   277: ifnull +8 -> 285
    //   280: aload 7
    //   282: invokevirtual 342	java/io/InputStream:close	()V
    //   285: aload_3
    //   286: invokevirtual 345	java/util/zip/ZipOutputStream:flush	()V
    //   289: aload_3
    //   290: invokevirtual 348	java/util/zip/ZipOutputStream:closeEntry	()V
    //   293: goto -199 -> 94
    //   296: astore_2
    //   297: aload_3
    //   298: ifnull +7 -> 305
    //   301: aload_3
    //   302: invokevirtual 349	java/util/zip/ZipOutputStream:close	()V
    //   305: aload 4
    //   307: ifnull +8 -> 315
    //   310: aload 4
    //   312: invokevirtual 350	java/io/BufferedOutputStream:close	()V
    //   315: aload_2
    //   316: athrow
    //   317: aload_3
    //   318: ifnull +7 -> 325
    //   321: aload_3
    //   322: invokevirtual 349	java/util/zip/ZipOutputStream:close	()V
    //   325: aload 4
    //   327: ifnull +8 -> 335
    //   330: aload 4
    //   332: invokevirtual 350	java/io/BufferedOutputStream:close	()V
    //   335: aload 5
    //   337: invokevirtual 351	java/io/File:length	()J
    //   340: ldc2_w 352
    //   343: lcmp
    //   344: iflt +53 -> 397
    //   347: iconst_1
    //   348: ireturn
    //   349: astore_2
    //   350: aload_2
    //   351: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   354: goto -29 -> 325
    //   357: astore_2
    //   358: aload_2
    //   359: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   362: goto -27 -> 335
    //   365: astore_3
    //   366: aload_3
    //   367: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   370: goto -106 -> 264
    //   373: astore_2
    //   374: aload_2
    //   375: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   378: bipush 253
    //   380: ireturn
    //   381: astore_3
    //   382: aload_3
    //   383: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   386: goto -81 -> 305
    //   389: astore_3
    //   390: aload_3
    //   391: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   394: goto -79 -> 315
    //   397: iconst_0
    //   398: ireturn
    //   399: astore_2
    //   400: aconst_null
    //   401: astore_3
    //   402: aconst_null
    //   403: astore 4
    //   405: goto -108 -> 297
    //   408: astore_2
    //   409: aconst_null
    //   410: astore_3
    //   411: goto -114 -> 297
    //   414: astore 5
    //   416: aload_2
    //   417: astore 4
    //   419: aload 5
    //   421: astore_2
    //   422: goto -125 -> 297
    //   425: astore 4
    //   427: aconst_null
    //   428: astore_3
    //   429: goto -178 -> 251
    //   432: astore 5
    //   434: aconst_null
    //   435: astore_3
    //   436: aload 4
    //   438: astore_2
    //   439: aload 5
    //   441: astore 4
    //   443: goto -192 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	446	0	this	ShareAppLogHelper
    //   205	10	1	i	int
    //   1	212	2	arrayOfByte	byte[]
    //   221	20	2	localObject1	Object
    //   246	23	2	localObject2	Object
    //   296	20	2	localObject3	Object
    //   349	2	2	localIOException1	java.io.IOException
    //   357	2	2	localIOException2	java.io.IOException
    //   373	2	2	localIOException3	java.io.IOException
    //   399	1	2	localObject4	Object
    //   408	9	2	localObject5	Object
    //   421	18	2	localObject6	Object
    //   78	244	3	localZipOutputStream	java.util.zip.ZipOutputStream
    //   365	2	3	localIOException4	java.io.IOException
    //   381	2	3	localIOException5	java.io.IOException
    //   389	2	3	localIOException6	java.io.IOException
    //   401	35	3	localObject7	Object
    //   67	351	4	localObject8	Object
    //   425	12	4	localException1	Exception
    //   441	1	4	localException2	Exception
    //   49	11	5	localFile	File
    //   242	94	5	localException3	Exception
    //   414	6	5	localObject9	Object
    //   432	8	5	localException4	Exception
    //   92	13	6	localIterator	java.util.Iterator
    //   114	167	7	localObject10	Object
    //   149	24	8	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   195	206	221	finally
    //   211	218	221	finally
    //   79	94	242	java/lang/Exception
    //   94	195	242	java/lang/Exception
    //   227	232	242	java/lang/Exception
    //   232	242	242	java/lang/Exception
    //   280	285	242	java/lang/Exception
    //   285	293	242	java/lang/Exception
    //   79	94	296	finally
    //   94	195	296	finally
    //   227	232	296	finally
    //   232	242	296	finally
    //   280	285	296	finally
    //   285	293	296	finally
    //   321	325	349	java/io/IOException
    //   330	335	357	java/io/IOException
    //   260	264	365	java/io/IOException
    //   268	272	373	java/io/IOException
    //   301	305	381	java/io/IOException
    //   310	315	389	java/io/IOException
    //   51	69	399	finally
    //   69	79	408	finally
    //   251	256	414	finally
    //   51	69	425	java/lang/Exception
    //   69	79	432	java/lang/Exception
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidTextFormatTime = null;
    this.jdField_b_of_type_AndroidTextFormatTime = null;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.c = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  private void b(int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1002;
    localMessage.obj = Integer.valueOf(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  public void a(ShareAppLogHelper.OnGetLocalLogListener paramOnGetLocalLogListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper$OnGetLocalLogListener = paramOnGetLocalLogListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public boolean a(Time paramTime1, Time paramTime2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_AndroidTextFormatTime = paramTime1;
    this.jdField_b_of_type_AndroidTextFormatTime = paramTime2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    ThreadManager.post(new ainl(this), 10, null, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.testassister.ShareAppLogHelper
 * JD-Core Version:    0.7.0.1
 */