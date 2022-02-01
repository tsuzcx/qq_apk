package com.tencent.mobileqq.testassister;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.format.Time;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class ShareAppLogHelper
{
  private Handler jdField_a_of_type_AndroidOsHandler = new ShareAppLogHelper.1(this, Looper.getMainLooper());
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private ShareAppLogHelper.OnGetLocalLogListener jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper$OnGetLocalLogListener;
  volatile Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<ShareAppLogHelper.LogFile> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("\\d{2}.\\d{2}.\\d{2}.\\d{2}");
  private boolean jdField_a_of_type_Boolean;
  private Time jdField_b_of_type_AndroidTextFormatTime;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  private String d;
  
  public ShareAppLogHelper(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.getLogExternalPath(MobileQQ.sMobileQQ));
    localStringBuilder.append("/tencent/msflogs/com/tencent/mobileqq/");
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    paramContext = paramContext.getExternalFilesDir(null);
    if ((paramContext != null) && (paramContext.exists()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getAbsolutePath());
      localStringBuilder.append("/tencent/msflogs/com/tencent/mobileqq/");
      this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    }
    paramContext = new StringBuilder();
    paramContext.append(Environment.getExternalStorageDirectory().getPath());
    paramContext.append("/tencent/com/tencent/mobileqq/");
    this.c = paramContext.toString();
  }
  
  private int a()
  {
    Object localObject = new File(this.jdField_a_of_type_JavaLangString);
    if (!((File)localObject).exists()) {
      return -1;
    }
    a();
    a((File)localObject, false);
    localObject = new File(this.jdField_b_of_type_JavaLangString);
    if (((File)localObject).exists()) {
      a((File)localObject, true);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new ShareAppLogHelper.LogFile("/data/anr/traces.txt");
      long l = ((ShareAppLogHelper.LogFile)localObject).length();
      if ((((ShareAppLogHelper.LogFile)localObject).exists()) && (((ShareAppLogHelper.LogFile)localObject).canRead()) && (l != 0L)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      } else if (QLog.isColorLevel()) {
        QLog.d("LOGFILE", 2, "traces.txt can not read or not exist");
      }
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      return 0;
    }
    return -2;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("logs_zip_");
    localStringBuilder.append(a(paramTime1));
    localStringBuilder.append("-");
    localStringBuilder.append(a(paramTime2));
    localStringBuilder.append(".zip");
    return localStringBuilder.toString();
  }
  
  private String a(String paramString)
  {
    int i = paramString.lastIndexOf("/");
    if (i == -1) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.substring(0, i));
    localStringBuilder.append("/private-");
    localStringBuilder.append(paramString.substring(i + 1));
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    Object localObject = new File(this.c);
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).listFiles(new ShareAppLogHelper.4(this));
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
  
  private void a(File paramFile, boolean paramBoolean)
  {
    paramFile = paramFile.listFiles(new ShareAppLogHelper.3(this));
    if ((paramFile != null) && (paramFile.length > 0))
    {
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        ShareAppLogHelper.LogFile localLogFile1 = new ShareAppLogHelper.LogFile(paramFile[i].getPath());
        if (paramBoolean)
        {
          ShareAppLogHelper.LogFile localLogFile2 = new ShareAppLogHelper.LogFile(a(localLogFile1.getAbsolutePath()));
          FileUtils.copyFile(localLogFile1, localLogFile2);
          this.jdField_a_of_type_JavaUtilArrayList.add(localLogFile2);
        }
        else
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localLogFile1);
        }
        i += 1;
      }
    }
  }
  
  private void a(String paramString)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1000;
    if (paramString == null) {
      localMessage.obj = "";
    } else {
      localMessage.obj = paramString;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  /* Error */
  private int b()
  {
    // Byte code:
    //   0: new 62	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: aload_0
    //   12: getfield 85	com/tencent/mobileqq/testassister/ShareAppLogHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload 5
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 165	com/tencent/mobileqq/testassister/ShareAppLogHelper:jdField_a_of_type_AndroidTextFormatTime	Landroid/text/format/Time;
    //   26: aload_0
    //   27: getfield 322	com/tencent/mobileqq/testassister/ShareAppLogHelper:jdField_b_of_type_AndroidTextFormatTime	Landroid/text/format/Time;
    //   30: invokespecial 324	com/tencent/mobileqq/testassister/ShareAppLogHelper:a	(Landroid/text/format/Time;Landroid/text/format/Time;)Ljava/lang/String;
    //   33: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_0
    //   38: aload 5
    //   40: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: putfield 245	com/tencent/mobileqq/testassister/ShareAppLogHelper:d	Ljava/lang/String;
    //   46: new 93	java/io/File
    //   49: dup
    //   50: aload_0
    //   51: getfield 245	com/tencent/mobileqq/testassister/ShareAppLogHelper:d	Ljava/lang/String;
    //   54: invokespecial 120	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore 10
    //   59: aconst_null
    //   60: astore 7
    //   62: aconst_null
    //   63: astore 9
    //   65: new 326	java/io/BufferedOutputStream
    //   68: dup
    //   69: new 328	java/io/FileOutputStream
    //   72: dup
    //   73: aload 10
    //   75: invokespecial 331	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   78: invokespecial 334	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   81: astore 5
    //   83: aload 5
    //   85: astore 6
    //   87: new 336	java/util/zip/ZipOutputStream
    //   90: dup
    //   91: aload 5
    //   93: invokespecial 337	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   96: astore 8
    //   98: sipush 8192
    //   101: newarray byte
    //   103: astore 6
    //   105: lconst_0
    //   106: lstore_2
    //   107: aload_0
    //   108: getfield 38	com/tencent/mobileqq/testassister/ShareAppLogHelper:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   111: invokevirtual 341	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   114: astore 7
    //   116: aload 7
    //   118: invokeinterface 346 1 0
    //   123: istore 4
    //   125: iload 4
    //   127: ifeq +278 -> 405
    //   130: aload 7
    //   132: invokeinterface 350 1 0
    //   137: checkcast 129	com/tencent/mobileqq/testassister/ShareAppLogHelper$LogFile
    //   140: astore 9
    //   142: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +49 -> 194
    //   148: ldc_w 352
    //   151: iconst_4
    //   152: iconst_4
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: ldc_w 354
    //   161: aastore
    //   162: dup
    //   163: iconst_1
    //   164: aload 9
    //   166: invokevirtual 355	com/tencent/mobileqq/testassister/ShareAppLogHelper$LogFile:getPath	()Ljava/lang/String;
    //   169: aastore
    //   170: dup
    //   171: iconst_2
    //   172: ldc_w 357
    //   175: aastore
    //   176: dup
    //   177: iconst_3
    //   178: aload 9
    //   180: invokevirtual 136	com/tencent/mobileqq/testassister/ShareAppLogHelper$LogFile:length	()J
    //   183: ldc2_w 358
    //   186: ldiv
    //   187: invokestatic 364	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   190: aastore
    //   191: invokestatic 367	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   194: lload_2
    //   195: aload 9
    //   197: invokevirtual 136	com/tencent/mobileqq/testassister/ShareAppLogHelper$LogFile:length	()J
    //   200: ladd
    //   201: lstore_2
    //   202: new 369	com/tencent/mobileqq/testassister/ShareAppLogHelper$TimeLogger
    //   205: dup
    //   206: aload 9
    //   208: invokevirtual 372	com/tencent/mobileqq/testassister/ShareAppLogHelper$LogFile:getName	()Ljava/lang/String;
    //   211: invokespecial 373	com/tencent/mobileqq/testassister/ShareAppLogHelper$TimeLogger:<init>	(Ljava/lang/String;)V
    //   214: astore 11
    //   216: aload 11
    //   218: iconst_0
    //   219: invokevirtual 374	com/tencent/mobileqq/testassister/ShareAppLogHelper$TimeLogger:a	(I)V
    //   222: new 62	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   229: astore 12
    //   231: aload 12
    //   233: aload 9
    //   235: invokevirtual 372	com/tencent/mobileqq/testassister/ShareAppLogHelper$LogFile:getName	()Ljava/lang/String;
    //   238: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 12
    //   244: aload 9
    //   246: getfield 274	com/tencent/mobileqq/testassister/ShareAppLogHelper$LogFile:stuffix	Ljava/lang/String;
    //   249: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: new 376	java/util/zip/ZipEntry
    //   256: dup
    //   257: aload 12
    //   259: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokespecial 377	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   265: astore 12
    //   267: aload 12
    //   269: aload 9
    //   271: invokevirtual 136	com/tencent/mobileqq/testassister/ShareAppLogHelper$LogFile:length	()J
    //   274: invokevirtual 381	java/util/zip/ZipEntry:setSize	(J)V
    //   277: aload 12
    //   279: aload 9
    //   281: invokevirtual 384	com/tencent/mobileqq/testassister/ShareAppLogHelper$LogFile:lastModified	()J
    //   284: invokevirtual 387	java/util/zip/ZipEntry:setTime	(J)V
    //   287: aload 8
    //   289: aload 12
    //   291: invokevirtual 391	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   294: new 393	java/io/BufferedInputStream
    //   297: dup
    //   298: new 395	java/io/FileInputStream
    //   301: dup
    //   302: aload 9
    //   304: invokespecial 396	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   307: invokespecial 399	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   310: astore 12
    //   312: aload 12
    //   314: aload 6
    //   316: iconst_0
    //   317: sipush 8192
    //   320: invokevirtual 405	java/io/InputStream:read	([BII)I
    //   323: istore_1
    //   324: iload_1
    //   325: iconst_m1
    //   326: if_icmpeq +15 -> 341
    //   329: aload 8
    //   331: aload 6
    //   333: iconst_0
    //   334: iload_1
    //   335: invokevirtual 409	java/util/zip/ZipOutputStream:write	([BII)V
    //   338: goto -26 -> 312
    //   341: aload 12
    //   343: invokevirtual 412	java/io/InputStream:close	()V
    //   346: aload 8
    //   348: invokevirtual 415	java/util/zip/ZipOutputStream:flush	()V
    //   351: aload 8
    //   353: invokevirtual 418	java/util/zip/ZipOutputStream:closeEntry	()V
    //   356: aload 9
    //   358: invokevirtual 372	com/tencent/mobileqq/testassister/ShareAppLogHelper$LogFile:getName	()Ljava/lang/String;
    //   361: ldc_w 420
    //   364: invokevirtual 424	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   367: ifeq +9 -> 376
    //   370: aload 9
    //   372: invokevirtual 427	com/tencent/mobileqq/testassister/ShareAppLogHelper$LogFile:delete	()Z
    //   375: pop
    //   376: aload 11
    //   378: iconst_1
    //   379: invokevirtual 374	com/tencent/mobileqq/testassister/ShareAppLogHelper$TimeLogger:a	(I)V
    //   382: goto -266 -> 116
    //   385: astore 6
    //   387: aload 12
    //   389: invokevirtual 412	java/io/InputStream:close	()V
    //   392: aload 8
    //   394: invokevirtual 415	java/util/zip/ZipOutputStream:flush	()V
    //   397: aload 8
    //   399: invokevirtual 418	java/util/zip/ZipOutputStream:closeEntry	()V
    //   402: aload 6
    //   404: athrow
    //   405: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +31 -> 439
    //   411: ldc_w 352
    //   414: iconst_4
    //   415: iconst_2
    //   416: anewarray 4	java/lang/Object
    //   419: dup
    //   420: iconst_0
    //   421: ldc_w 429
    //   424: aastore
    //   425: dup
    //   426: iconst_1
    //   427: lload_2
    //   428: ldc2_w 358
    //   431: ldiv
    //   432: invokestatic 364	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   435: aastore
    //   436: invokestatic 367	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   439: aload 8
    //   441: invokevirtual 430	java/util/zip/ZipOutputStream:close	()V
    //   444: goto +10 -> 454
    //   447: astore 6
    //   449: aload 6
    //   451: invokevirtual 431	java/io/IOException:printStackTrace	()V
    //   454: aload 5
    //   456: invokevirtual 432	java/io/BufferedOutputStream:close	()V
    //   459: goto +10 -> 469
    //   462: astore 5
    //   464: aload 5
    //   466: invokevirtual 431	java/io/IOException:printStackTrace	()V
    //   469: aload 10
    //   471: invokevirtual 433	java/io/File:length	()J
    //   474: ldc2_w 434
    //   477: lcmp
    //   478: iflt +5 -> 483
    //   481: iconst_1
    //   482: ireturn
    //   483: iconst_0
    //   484: ireturn
    //   485: astore 6
    //   487: aload 8
    //   489: astore 7
    //   491: goto +104 -> 595
    //   494: astore 6
    //   496: aload 8
    //   498: astore 9
    //   500: aload 6
    //   502: astore 8
    //   504: goto +25 -> 529
    //   507: astore 8
    //   509: goto +20 -> 529
    //   512: astore 6
    //   514: aconst_null
    //   515: astore 5
    //   517: aload 5
    //   519: astore 7
    //   521: goto +74 -> 595
    //   524: astore 8
    //   526: aconst_null
    //   527: astore 5
    //   529: aload 9
    //   531: astore 7
    //   533: aload 5
    //   535: astore 6
    //   537: aload 8
    //   539: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   542: aload 9
    //   544: ifnull +18 -> 562
    //   547: aload 9
    //   549: invokevirtual 430	java/util/zip/ZipOutputStream:close	()V
    //   552: goto +10 -> 562
    //   555: astore 6
    //   557: aload 6
    //   559: invokevirtual 431	java/io/IOException:printStackTrace	()V
    //   562: aload 5
    //   564: ifnull +18 -> 582
    //   567: aload 5
    //   569: invokevirtual 432	java/io/BufferedOutputStream:close	()V
    //   572: bipush 253
    //   574: ireturn
    //   575: astore 5
    //   577: aload 5
    //   579: invokevirtual 431	java/io/IOException:printStackTrace	()V
    //   582: bipush 253
    //   584: ireturn
    //   585: astore 8
    //   587: aload 6
    //   589: astore 5
    //   591: aload 8
    //   593: astore 6
    //   595: aload 7
    //   597: ifnull +18 -> 615
    //   600: aload 7
    //   602: invokevirtual 430	java/util/zip/ZipOutputStream:close	()V
    //   605: goto +10 -> 615
    //   608: astore 7
    //   610: aload 7
    //   612: invokevirtual 431	java/io/IOException:printStackTrace	()V
    //   615: aload 5
    //   617: ifnull +18 -> 635
    //   620: aload 5
    //   622: invokevirtual 432	java/io/BufferedOutputStream:close	()V
    //   625: goto +10 -> 635
    //   628: astore 5
    //   630: aload 5
    //   632: invokevirtual 431	java/io/IOException:printStackTrace	()V
    //   635: goto +6 -> 641
    //   638: aload 6
    //   640: athrow
    //   641: goto -3 -> 638
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	644	0	this	ShareAppLogHelper
    //   323	12	1	i	int
    //   106	322	2	l	long
    //   123	3	4	bool	boolean
    //   7	448	5	localObject1	Object
    //   462	3	5	localIOException1	java.io.IOException
    //   515	53	5	localObject2	Object
    //   575	3	5	localIOException2	java.io.IOException
    //   589	32	5	localObject3	Object
    //   628	3	5	localIOException3	java.io.IOException
    //   85	247	6	localObject4	Object
    //   385	18	6	localObject5	Object
    //   447	3	6	localIOException4	java.io.IOException
    //   485	1	6	localObject6	Object
    //   494	7	6	localException1	Exception
    //   512	1	6	localObject7	Object
    //   535	1	6	localObject8	Object
    //   555	33	6	localIOException5	java.io.IOException
    //   593	46	6	localObject9	Object
    //   60	541	7	localObject10	Object
    //   608	3	7	localIOException6	java.io.IOException
    //   96	407	8	localObject11	Object
    //   507	1	8	localException2	Exception
    //   524	14	8	localException3	Exception
    //   585	7	8	localObject12	Object
    //   63	485	9	localObject13	Object
    //   57	413	10	localFile	File
    //   214	163	11	localTimeLogger	ShareAppLogHelper.TimeLogger
    //   229	159	12	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   312	324	385	finally
    //   329	338	385	finally
    //   439	444	447	java/io/IOException
    //   454	459	462	java/io/IOException
    //   98	105	485	finally
    //   107	116	485	finally
    //   116	125	485	finally
    //   130	194	485	finally
    //   194	312	485	finally
    //   341	376	485	finally
    //   376	382	485	finally
    //   387	405	485	finally
    //   405	439	485	finally
    //   98	105	494	java/lang/Exception
    //   107	116	494	java/lang/Exception
    //   116	125	494	java/lang/Exception
    //   130	194	494	java/lang/Exception
    //   194	312	494	java/lang/Exception
    //   341	376	494	java/lang/Exception
    //   376	382	494	java/lang/Exception
    //   387	405	494	java/lang/Exception
    //   405	439	494	java/lang/Exception
    //   87	98	507	java/lang/Exception
    //   65	83	512	finally
    //   65	83	524	java/lang/Exception
    //   547	552	555	java/io/IOException
    //   567	572	575	java/io/IOException
    //   87	98	585	finally
    //   537	542	585	finally
    //   600	605	608	java/io/IOException
    //   620	625	628	java/io/IOException
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidTextFormatTime = null;
    this.jdField_b_of_type_AndroidTextFormatTime = null;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.d = null;
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
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.wait();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      return;
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
      if (QLog.isColorLevel()) {
        QLog.d("ShareAppLogHelper", 4, "status is size warning, user confirm");
      }
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
    ThreadManager.post(new ShareAppLogHelper.2(this), 10, null, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.testassister.ShareAppLogHelper
 * JD-Core Version:    0.7.0.1
 */