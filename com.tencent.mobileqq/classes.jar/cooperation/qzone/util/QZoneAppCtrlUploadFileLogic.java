package cooperation.qzone.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.testassister.ShareAppLogHelper.LogFile;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import common.qzone.component.util.SecurityUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class QZoneAppCtrlUploadFileLogic
{
  public static final String ANR_LOG_DIRECTORY = "anr";
  public static final String ANR_LOG_PATH;
  public static final String ANR_PATH = "ANR";
  public static final String AVSDK_LOG_DIRECTORY = "avsdk";
  private static final String CHARSET = "utf-8";
  public static final int CODE_LOG_SIZE_WARNING = 1;
  public static final int CODE_LOG_ZIP_FAILED = -3;
  public static final int CODE_SUCC = 0;
  static final String CONTENT_TYPE = "multipart/form-data";
  public static final String DATABASE_PATH = "databases";
  public static final String DB_PATH = "DB";
  public static final long ERROR_TIME = -1L;
  static final String LINE_END = "\r\n";
  public static final String LOGCAT_PATH = "LOGCAT";
  static final String PREFIX = "--";
  static final String REQUESTURL = "http://zhizi.qq.com/uploadfile.php";
  public static final String TAG = "QZoneAppCtrlUploadFileLogic";
  private static final int TIME_OUT = 100000000;
  public static final String TRACE_PATH = "TRACE";
  static final int UPLOAD_PID = 3;
  public static final int WARNING_SIZE_LEVLE = 26214400;
  public static final String ZIP_DIR;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("anr");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("traces.txt");
    ANR_LOG_PATH = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("tencent");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("zip");
    ZIP_DIR = localStringBuilder.toString();
  }
  
  public static long getAvsdkTimeFromServer(String paramString)
  {
    long l = -1L;
    if (paramString != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return -1L;
      }
      if (paramString.length() != 10) {
        return -1L;
      }
    }
    try
    {
      Date localDate = new SimpleDateFormat("yyyyMMddHH").parse(paramString.trim());
      if (localDate != null) {
        l = localDate.getTime();
      }
      return l;
    }
    catch (Exception localException)
    {
      localException = localException;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error time = ");
      localStringBuilder.append(paramString);
      QLog.e("QZoneAppCtrlUploadFileLogic", 1, localStringBuilder.toString());
      localException.printStackTrace();
      return -1L;
    }
    finally {}
    return -1L;
  }
  
  /* Error */
  public static void saveLogcatToFileV2(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: invokestatic 152	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: ldc 154
    //   5: invokevirtual 158	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   8: invokevirtual 164	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   11: astore 13
    //   13: invokestatic 169	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   16: ldc 171
    //   18: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   21: istore 4
    //   23: aconst_null
    //   24: astore 11
    //   26: iload 4
    //   28: ifeq +577 -> 605
    //   31: new 67	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   38: astore 11
    //   40: aload 11
    //   42: invokestatic 179	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   45: invokevirtual 182	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   48: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload 11
    //   54: getstatic 79	java/io/File:separator	Ljava/lang/String;
    //   57: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 11
    //   63: getstatic 93	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:ZIP_DIR	Ljava/lang/String;
    //   66: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 11
    //   72: getstatic 79	java/io/File:separator	Ljava/lang/String;
    //   75: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 11
    //   81: ldc 44
    //   83: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: new 76	java/io/File
    //   90: dup
    //   91: aload 11
    //   93: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 188	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   99: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   102: astore 11
    //   104: aload 11
    //   106: invokevirtual 193	java/io/File:exists	()Z
    //   109: ifne +54 -> 163
    //   112: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   115: ifeq +42 -> 157
    //   118: new 67	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   125: astore 12
    //   127: aload 12
    //   129: ldc 198
    //   131: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 12
    //   137: aload 11
    //   139: invokevirtual 182	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   142: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: ldc 53
    //   148: iconst_4
    //   149: aload 12
    //   151: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: aload 11
    //   159: invokevirtual 204	java/io/File:mkdirs	()Z
    //   162: pop
    //   163: new 67	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   170: astore 11
    //   172: aload 11
    //   174: invokestatic 179	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   177: invokevirtual 182	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   180: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 11
    //   186: getstatic 79	java/io/File:separator	Ljava/lang/String;
    //   189: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 11
    //   195: getstatic 93	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:ZIP_DIR	Ljava/lang/String;
    //   198: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 11
    //   204: getstatic 79	java/io/File:separator	Ljava/lang/String;
    //   207: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 11
    //   213: ldc 44
    //   215: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 11
    //   221: getstatic 79	java/io/File:separator	Ljava/lang/String;
    //   224: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload 11
    //   230: aload_1
    //   231: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 11
    //   237: ldc 206
    //   239: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: new 76	java/io/File
    //   246: dup
    //   247: aload 11
    //   249: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 188	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   255: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   258: astore 12
    //   260: aload 12
    //   262: astore 11
    //   264: aload 12
    //   266: invokevirtual 193	java/io/File:exists	()Z
    //   269: ifne +61 -> 330
    //   272: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   275: ifeq +42 -> 317
    //   278: new 67	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   285: astore 11
    //   287: aload 11
    //   289: ldc 208
    //   291: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 11
    //   297: aload 12
    //   299: invokevirtual 182	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   302: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: ldc 53
    //   308: iconst_4
    //   309: aload 11
    //   311: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: aload 12
    //   319: invokevirtual 211	java/io/File:createNewFile	()Z
    //   322: pop
    //   323: aload 12
    //   325: astore 11
    //   327: goto +3 -> 330
    //   330: sipush 1024
    //   333: newarray byte
    //   335: astore 12
    //   337: ldc 212
    //   339: istore_2
    //   340: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   343: ifeq +11 -> 354
    //   346: ldc 53
    //   348: iconst_4
    //   349: ldc 214
    //   351: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: new 216	java/io/FileOutputStream
    //   357: dup
    //   358: aload 11
    //   360: invokespecial 219	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   363: astore 11
    //   365: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   368: lstore 5
    //   370: iload_2
    //   371: ifle +148 -> 519
    //   374: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   377: lstore 7
    //   379: lload 7
    //   381: lload 5
    //   383: lsub
    //   384: lstore 9
    //   386: lload 9
    //   388: ldc2_w 225
    //   391: lcmp
    //   392: ifle +80 -> 472
    //   395: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   398: ifeq +121 -> 519
    //   401: new 67	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   408: astore 12
    //   410: aload 12
    //   412: ldc 228
    //   414: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 12
    //   420: lload 7
    //   422: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload 12
    //   428: ldc 233
    //   430: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload 12
    //   436: lload 5
    //   438: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload 12
    //   444: ldc 235
    //   446: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload 12
    //   452: lload 9
    //   454: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: ldc 53
    //   460: iconst_4
    //   461: aload 12
    //   463: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: goto +50 -> 519
    //   472: aload 13
    //   474: aload 12
    //   476: iconst_0
    //   477: iload_2
    //   478: aload 12
    //   480: arraylength
    //   481: invokestatic 241	java/lang/Math:min	(II)I
    //   484: invokevirtual 247	java/io/InputStream:read	([BII)I
    //   487: istore_3
    //   488: iload_3
    //   489: iconst_m1
    //   490: if_icmpeq +19 -> 509
    //   493: aload 11
    //   495: aload 12
    //   497: iconst_0
    //   498: iload_3
    //   499: invokevirtual 251	java/io/FileOutputStream:write	([BII)V
    //   502: iload_2
    //   503: iload_3
    //   504: isub
    //   505: istore_2
    //   506: goto -136 -> 370
    //   509: new 253	java/io/EOFException
    //   512: dup
    //   513: ldc 255
    //   515: invokespecial 256	java/io/EOFException:<init>	(Ljava/lang/String;)V
    //   518: athrow
    //   519: aload 11
    //   521: invokevirtual 259	java/io/FileOutputStream:close	()V
    //   524: aload_0
    //   525: aload_1
    //   526: invokestatic 262	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:uploadLogcat	(Landroid/content/Context;Ljava/lang/String;)V
    //   529: aload 13
    //   531: invokevirtual 263	java/io/InputStream:close	()V
    //   534: return
    //   535: astore 12
    //   537: aload 11
    //   539: invokevirtual 259	java/io/FileOutputStream:close	()V
    //   542: aload_0
    //   543: aload_1
    //   544: invokestatic 262	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:uploadLogcat	(Landroid/content/Context;Ljava/lang/String;)V
    //   547: aload 12
    //   549: athrow
    //   550: astore_0
    //   551: aload 13
    //   553: invokevirtual 263	java/io/InputStream:close	()V
    //   556: aload_0
    //   557: athrow
    //   558: astore_0
    //   559: aload_0
    //   560: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   563: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   566: ifeq +38 -> 604
    //   569: new 67	java/lang/StringBuilder
    //   572: dup
    //   573: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   576: astore_1
    //   577: aload_1
    //   578: ldc_w 266
    //   581: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: aload_1
    //   586: aload_0
    //   587: invokevirtual 267	java/io/IOException:toString	()Ljava/lang/String;
    //   590: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: ldc 53
    //   596: iconst_4
    //   597: aload_1
    //   598: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: return
    //   605: goto -275 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	608	0	paramContext	Context
    //   0	608	1	paramString	String
    //   339	167	2	i	int
    //   487	18	3	j	int
    //   21	6	4	bool	boolean
    //   368	69	5	l1	long
    //   377	44	7	l2	long
    //   384	69	9	l3	long
    //   24	514	11	localObject1	Object
    //   125	371	12	localObject2	Object
    //   535	13	12	localObject3	Object
    //   11	541	13	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   365	370	535	finally
    //   374	379	535	finally
    //   395	469	535	finally
    //   472	488	535	finally
    //   493	502	535	finally
    //   509	519	535	finally
    //   354	365	550	finally
    //   519	529	550	finally
    //   537	550	550	finally
    //   0	23	558	java/io/IOException
    //   31	157	558	java/io/IOException
    //   157	163	558	java/io/IOException
    //   163	260	558	java/io/IOException
    //   264	317	558	java/io/IOException
    //   317	323	558	java/io/IOException
    //   330	337	558	java/io/IOException
    //   340	354	558	java/io/IOException
    //   529	534	558	java/io/IOException
    //   551	558	558	java/io/IOException
  }
  
  public static void showDirFileList(Context paramContext, String paramString)
  {
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      paramContext = new StringBuilder();
      paramContext.append(Environment.getExternalStorageDirectory().getAbsolutePath());
      paramContext.append(File.separator);
      paramContext.append("tencent");
      paramContext = VFSAssistantUtils.getSDKPrivatePath(paramContext.toString());
    }
    for (;;)
    {
      int i;
      try
      {
        paramContext = new File(paramContext);
        boolean bool = paramContext.isDirectory();
        if (bool)
        {
          paramString = new StringBuilder();
          paramString.append("showDirFileList dirPath:");
          paramString.append(paramContext.getAbsolutePath());
          QLog.e("QZoneAppCtrlUploadFileLogic", 1, paramString.toString());
          paramContext = paramContext.listFiles();
          if (paramContext != null)
          {
            i = 0;
            if (i < paramContext.length)
            {
              if (paramContext[i].isDirectory())
              {
                paramString = new StringBuilder();
                paramString.append("dir:");
                paramString.append(paramContext[i].getAbsolutePath());
                QLog.e("QZoneAppCtrlUploadFileLogic", 1, paramString.toString());
              }
              if (!paramContext[i].isFile()) {
                break label284;
              }
              paramString = new StringBuilder();
              paramString.append("file:");
              paramString.append(paramContext[i].getAbsolutePath());
              paramString.append(",size:");
              paramString.append(paramContext[i].length());
              QLog.e("QZoneAppCtrlUploadFileLogic", 1, paramString.toString());
              break label284;
            }
          }
        }
        else if (paramContext.isFile())
        {
          paramString = new StringBuilder();
          paramString.append("showDirFileList filePath:");
          paramString.append(paramContext.getAbsolutePath());
          QLog.e("QZoneAppCtrlUploadFileLogic", 1, paramString.toString());
          return;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      return;
      label284:
      i += 1;
    }
  }
  
  private static int stepZipLogFile(String paramString, File paramFile)
  {
    try
    {
      paramString = new File(paramString);
      Object localObject = null;
      ZipOutputStream localZipOutputStream;
      byte[] arrayOfByte;
      ZipEntry localZipEntry;
      int i;
      return -3;
    }
    catch (Exception paramFile)
    {
      try
      {
        localZipOutputStream = new ZipOutputStream(new FileOutputStream(paramString));
        try
        {
          arrayOfByte = new byte[1024];
          localZipEntry = new ZipEntry(paramFile.getName());
          localZipEntry.setSize(paramFile.length());
          localZipEntry.setTime(paramFile.lastModified());
          localZipOutputStream.putNextEntry(localZipEntry);
          paramString = null;
        }
        finally
        {
          try
          {
            paramFile = new BufferedInputStream(new FileInputStream(paramFile));
            try
            {
              for (;;)
              {
                i = paramFile.read(arrayOfByte, 0, 1024);
                if (i == -1) {
                  break;
                }
                localZipOutputStream.write(arrayOfByte, 0, i);
              }
              paramFile.close();
              localZipOutputStream.close();
              if (paramString.length() >= 26214400L)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.d("QZoneAppCtrlUploadFileLogic", 4, "stepZipLogFile result: 26214400");
                }
                localZipOutputStream.close();
                return 1;
              }
              if (QLog.isDevelopLevel()) {
                QLog.d("QZoneAppCtrlUploadFileLogic", 4, "stepZipLogFile result: 0");
              }
              localZipOutputStream.close();
              return 0;
            }
            finally {}
            paramFile = finally;
          }
          finally
          {
            paramFile = localObject;
            if (paramFile != null) {
              paramFile.close();
            }
          }
        }
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, "stepZipLogFile result: -3");
      }
      finally
      {
        if (paramString != null) {
          paramString.close();
        }
        throw paramFile;
        paramString = paramString;
        paramString.printStackTrace();
        if (!QLog.isDevelopLevel()) {}
      }
    }
  }
  
  /* Error */
  private static int stepZipLogFiles(String paramString, ArrayList<File> paramArrayList)
  {
    // Byte code:
    //   0: new 76	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 7
    //   10: aconst_null
    //   11: astore_0
    //   12: new 294	java/util/zip/ZipOutputStream
    //   15: dup
    //   16: new 216	java/io/FileOutputStream
    //   19: dup
    //   20: aload 7
    //   22: invokespecial 219	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   25: invokespecial 297	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore 5
    //   30: sipush 1024
    //   33: newarray byte
    //   35: astore 8
    //   37: aload_1
    //   38: invokevirtual 343	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   41: astore_1
    //   42: aload_1
    //   43: invokeinterface 348 1 0
    //   48: ifeq +120 -> 168
    //   51: aload_1
    //   52: invokeinterface 352 1 0
    //   57: checkcast 76	java/io/File
    //   60: astore 6
    //   62: new 299	java/util/zip/ZipEntry
    //   65: dup
    //   66: aload 6
    //   68: invokevirtual 302	java/io/File:getName	()Ljava/lang/String;
    //   71: invokespecial 303	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   74: astore 9
    //   76: aload 9
    //   78: aload 6
    //   80: invokevirtual 288	java/io/File:length	()J
    //   83: invokevirtual 307	java/util/zip/ZipEntry:setSize	(J)V
    //   86: aload 9
    //   88: aload 6
    //   90: invokevirtual 310	java/io/File:lastModified	()J
    //   93: invokevirtual 313	java/util/zip/ZipEntry:setTime	(J)V
    //   96: aload 5
    //   98: aload 9
    //   100: invokevirtual 317	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   103: new 319	java/io/BufferedInputStream
    //   106: dup
    //   107: new 321	java/io/FileInputStream
    //   110: dup
    //   111: aload 6
    //   113: invokespecial 322	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   116: invokespecial 325	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   119: astore 6
    //   121: aload 6
    //   123: aload 8
    //   125: iconst_0
    //   126: sipush 1024
    //   129: invokevirtual 247	java/io/InputStream:read	([BII)I
    //   132: istore_2
    //   133: iload_2
    //   134: iconst_m1
    //   135: if_icmpeq +15 -> 150
    //   138: aload 5
    //   140: aload 8
    //   142: iconst_0
    //   143: iload_2
    //   144: invokevirtual 326	java/util/zip/ZipOutputStream:write	([BII)V
    //   147: goto -26 -> 121
    //   150: aload 6
    //   152: invokevirtual 263	java/io/InputStream:close	()V
    //   155: goto -113 -> 42
    //   158: aload_0
    //   159: ifnull +7 -> 166
    //   162: aload_0
    //   163: invokevirtual 263	java/io/InputStream:close	()V
    //   166: aload_1
    //   167: athrow
    //   168: aload 5
    //   170: invokevirtual 327	java/util/zip/ZipOutputStream:close	()V
    //   173: aload 7
    //   175: invokevirtual 288	java/io/File:length	()J
    //   178: lstore_3
    //   179: lload_3
    //   180: ldc2_w 328
    //   183: lcmp
    //   184: iflt +10 -> 194
    //   187: aload 5
    //   189: invokevirtual 327	java/util/zip/ZipOutputStream:close	()V
    //   192: iconst_1
    //   193: ireturn
    //   194: aload 5
    //   196: invokevirtual 327	java/util/zip/ZipOutputStream:close	()V
    //   199: iconst_0
    //   200: ireturn
    //   201: aload_0
    //   202: ifnull +7 -> 209
    //   205: aload_0
    //   206: invokevirtual 327	java/util/zip/ZipOutputStream:close	()V
    //   209: aload_1
    //   210: athrow
    //   211: astore_0
    //   212: aload_0
    //   213: invokevirtual 142	java/lang/Exception:printStackTrace	()V
    //   216: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   219: ifeq +12 -> 231
    //   222: ldc 53
    //   224: iconst_4
    //   225: ldc_w 354
    //   228: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: bipush 253
    //   233: ireturn
    //   234: astore_1
    //   235: aload 6
    //   237: astore_0
    //   238: goto -80 -> 158
    //   241: astore_1
    //   242: goto -84 -> 158
    //   245: astore_1
    //   246: aload 5
    //   248: astore_0
    //   249: goto -48 -> 201
    //   252: astore_1
    //   253: aconst_null
    //   254: astore_0
    //   255: goto -54 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	paramString	String
    //   0	258	1	paramArrayList	ArrayList<File>
    //   132	12	2	i	int
    //   178	2	3	l	long
    //   28	219	5	localZipOutputStream	ZipOutputStream
    //   60	176	6	localObject	Object
    //   8	166	7	localFile	File
    //   35	106	8	arrayOfByte	byte[]
    //   74	25	9	localZipEntry	ZipEntry
    // Exception table:
    //   from	to	target	type
    //   0	10	211	java/lang/Exception
    //   187	192	211	java/lang/Exception
    //   194	199	211	java/lang/Exception
    //   205	209	211	java/lang/Exception
    //   209	211	211	java/lang/Exception
    //   121	133	234	finally
    //   138	147	234	finally
    //   103	121	241	finally
    //   30	42	245	finally
    //   42	103	245	finally
    //   150	155	245	finally
    //   162	166	245	finally
    //   166	168	245	finally
    //   168	179	245	finally
    //   12	30	252	finally
  }
  
  public static void uploadANR(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append(Environment.getDataDirectory().getAbsolutePath());
    paramContext.append(File.separator);
    paramContext.append("anr");
    paramContext = new File(VFSAssistantUtils.getSDKPrivatePath(paramContext.toString()));
    if ((paramContext.isDirectory()) && (paramContext.listFiles() != null))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getAbsolutePath());
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(ZIP_DIR);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("ANR");
      localObject1 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString());
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("upload.log.zip");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = new File((String)localObject1);
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      uploadFile(paramContext, (String)localObject2, paramString);
    }
  }
  
  public static void uploadAvsdk(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    paramContext.append(File.separator);
    paramContext.append("tencent");
    paramContext.append(File.separator);
    paramContext.append("mobileqq");
    paramContext.append(File.separator);
    paramContext.append("log");
    paramContext.append(File.separator);
    paramContext.append("avsdk");
    paramContext = new File(VFSAssistantUtils.getSDKPrivatePath(paramContext.toString()));
    QZoneAppCtrlUploadFileLogic.3 local3 = new QZoneAppCtrlUploadFileLogic.3(paramLong1, paramLong2);
    if ((paramContext.isDirectory()) && (paramContext.listFiles() != null))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getAbsolutePath());
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(ZIP_DIR);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("avsdk");
      localObject1 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString());
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("upload.log.zip");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = new File((String)localObject1);
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      uploadFile(paramContext, local3, (String)localObject2, paramString);
    }
  }
  
  public static void uploadByCustom(Context paramContext, String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      if (paramContext == null) {
        return;
      }
      String str = null;
      if (paramBoolean)
      {
        if (paramContext.getFilesDir() != null) {
          str = paramContext.getFilesDir().getParent();
        }
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        paramContext.append(File.separator);
        paramContext.append("tencent");
        str = VFSAssistantUtils.getSDKPrivatePath(paramContext.toString());
      }
      if (TextUtils.isEmpty(str)) {
        return;
      }
      paramContext = new StringBuilder();
      paramContext.append(Environment.getExternalStorageDirectory().getAbsolutePath());
      paramContext.append(File.separator);
      paramContext.append(ZIP_DIR);
      paramContext.append(File.separator);
      paramContext.append("custom");
      paramContext = VFSAssistantUtils.getSDKPrivatePath(paramContext.toString());
      Object localObject = new File(paramContext);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("upload.log.zip");
      paramContext = ((StringBuilder)localObject).toString();
      paramString1 = new File(str, paramString1);
      if ((paramString1.isFile()) && (paramString1.length() < paramLong))
      {
        uploadFile(paramString1, paramContext, paramString2);
        if (QLog.isDevelopLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("uploadByCustom filename: ");
          paramString1.append(paramContext);
          QLog.d("QZoneAppCtrlUploadFileLogic", 4, paramString1.toString());
        }
      }
    }
  }
  
  public static void uploadDB(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      localObject = SecurityUtil.a(paramString1);
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramContext.getFilesDir().getParent());
    paramString2.append(File.separator);
    paramString2.append("databases");
    paramString2.append(File.separator);
    paramString2.append((String)localObject);
    paramContext = paramString2.toString();
    paramString2 = new StringBuilder();
    paramString2.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    paramString2.append(File.separator);
    paramString2.append(ZIP_DIR);
    paramString2.append(File.separator);
    paramString2.append("DB");
    paramString2 = paramString2.toString();
    localObject = new File(VFSAssistantUtils.getSDKPrivatePath(paramString2));
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("upload.log.zip");
    paramString2 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString());
    uploadFile(new File(paramContext), paramString2, paramString1);
  }
  
  public static boolean uploadFile(File paramFile, FilenameFilter paramFilenameFilter, String paramString1, String paramString2)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return false;
      }
      if (paramFile.exists())
      {
        int j = -3;
        int i = j;
        if (paramFile.getName().contains("avsdk"))
        {
          i = j;
          if (paramFile.isDirectory())
          {
            ArrayList localArrayList = new ArrayList();
            paramFilenameFilter = paramFile.listFiles(paramFilenameFilter);
            if ((paramFilenameFilter != null) && (paramFilenameFilter.length != 0))
            {
              j = paramFilenameFilter.length;
              i = 0;
              while (i < j)
              {
                localArrayList.add(paramFilenameFilter[i]);
                i += 1;
              }
              i = stepZipLogFiles(paramString1, localArrayList);
            }
            else
            {
              QLog.w("QZoneAppCtrlUploadFileLogic", 2, "files is empty");
              return false;
            }
          }
        }
        if (i != 0)
        {
          if (QLog.isColorLevel())
          {
            paramFile = new StringBuilder();
            paramFile.append("uploadFile zip file error code");
            paramFile.append(i);
            QLog.w("QZoneAppCtrlUploadFileLogic", 2, paramFile.toString());
          }
          FileUtils.deleteFile(paramString1);
          return false;
        }
      }
      return uploadFileToServer(paramFile, paramString1, paramString2);
    }
    return false;
  }
  
  public static boolean uploadFile(File paramFile, String paramString1, String paramString2)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return false;
      }
      if (paramFile.exists())
      {
        int i;
        if ((paramFile.getName().contains("anr")) && (paramFile.isDirectory()))
        {
          ArrayList localArrayList = new ArrayList();
          File[] arrayOfFile = paramFile.listFiles();
          int j = arrayOfFile.length;
          i = 0;
          while (i < j)
          {
            localArrayList.add(arrayOfFile[i]);
            i += 1;
          }
          i = stepZipLogFiles(paramString1, localArrayList);
        }
        else
        {
          if (!paramFile.isFile()) {
            return false;
          }
          i = stepZipLogFile(paramString1, paramFile);
        }
        if (i != 0)
        {
          if (QLog.isColorLevel())
          {
            paramFile = new StringBuilder();
            paramFile.append("uploadFile zip file error code");
            paramFile.append(i);
            QLog.w("QZoneAppCtrlUploadFileLogic", 2, paramFile.toString());
          }
          FileUtils.deleteFile(paramString1);
          return false;
        }
      }
      return uploadFileToServer(paramFile, paramString1, paramString2);
    }
    return false;
  }
  
  /* Error */
  public static boolean uploadFileToServer(File paramFile, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 76	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 6
    //   10: aload 6
    //   12: invokevirtual 193	java/io/File:exists	()Z
    //   15: ifne +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   23: ifeq +74 -> 97
    //   26: new 67	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   33: astore 4
    //   35: aload 4
    //   37: ldc_w 444
    //   40: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 4
    //   46: aload_1
    //   47: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: ldc 53
    //   53: iconst_4
    //   54: aload 4
    //   56: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: new 67	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   69: astore_1
    //   70: aload_1
    //   71: ldc_w 446
    //   74: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_1
    //   79: aload_0
    //   80: invokevirtual 182	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   83: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: ldc 53
    //   89: iconst_4
    //   90: aload_1
    //   91: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: invokestatic 452	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   100: invokevirtual 453	java/util/UUID:toString	()Ljava/lang/String;
    //   103: astore_1
    //   104: new 455	java/net/URL
    //   107: dup
    //   108: ldc 50
    //   110: invokespecial 456	java/net/URL:<init>	(Ljava/lang/String;)V
    //   113: invokevirtual 460	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   116: checkcast 462	java/net/HttpURLConnection
    //   119: astore 5
    //   121: aload 5
    //   123: ldc 55
    //   125: invokevirtual 466	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   128: aload 5
    //   130: ldc 55
    //   132: invokevirtual 469	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   135: aload 5
    //   137: iconst_1
    //   138: invokevirtual 473	java/net/HttpURLConnection:setDoInput	(Z)V
    //   141: aload 5
    //   143: iconst_1
    //   144: invokevirtual 476	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   147: aload 5
    //   149: iconst_0
    //   150: invokevirtual 479	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   153: aload 5
    //   155: ldc_w 481
    //   158: invokevirtual 484	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   161: aload 5
    //   163: ldc_w 486
    //   166: ldc 18
    //   168: invokevirtual 489	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload 5
    //   173: ldc_w 491
    //   176: ldc_w 493
    //   179: invokevirtual 489	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: new 67	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   189: astore_0
    //   190: aload_0
    //   191: ldc_w 495
    //   194: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_0
    //   199: aload_1
    //   200: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 5
    //   206: ldc_w 497
    //   209: aload_0
    //   210: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokevirtual 489	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload 5
    //   218: invokevirtual 501	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   221: astore_0
    //   222: new 503	java/io/DataOutputStream
    //   225: dup
    //   226: aload_0
    //   227: invokespecial 504	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   230: astore 4
    //   232: new 506	java/lang/StringBuffer
    //   235: dup
    //   236: invokespecial 507	java/lang/StringBuffer:<init>	()V
    //   239: astore_0
    //   240: aload_0
    //   241: ldc 47
    //   243: invokevirtual 510	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   246: pop
    //   247: aload_0
    //   248: aload_1
    //   249: invokevirtual 510	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   252: pop
    //   253: aload_0
    //   254: ldc 41
    //   256: invokevirtual 510	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   259: pop
    //   260: new 67	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   267: astore 7
    //   269: aload 7
    //   271: ldc_w 512
    //   274: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload 7
    //   280: aload 6
    //   282: invokevirtual 302	java/io/File:getName	()Ljava/lang/String;
    //   285: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload 7
    //   291: ldc_w 514
    //   294: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 7
    //   300: ldc 41
    //   302: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload_0
    //   307: aload 7
    //   309: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokevirtual 510	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   315: pop
    //   316: aload_0
    //   317: ldc_w 516
    //   320: invokevirtual 510	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   323: pop
    //   324: aload_0
    //   325: ldc 41
    //   327: invokevirtual 510	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   330: pop
    //   331: aload 4
    //   333: aload_0
    //   334: invokevirtual 517	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   337: invokevirtual 521	java/lang/String:getBytes	()[B
    //   340: invokevirtual 524	java/io/DataOutputStream:write	([B)V
    //   343: new 321	java/io/FileInputStream
    //   346: dup
    //   347: aload 6
    //   349: invokespecial 322	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   352: astore_0
    //   353: sipush 1024
    //   356: newarray byte
    //   358: astore 6
    //   360: aload_0
    //   361: aload 6
    //   363: invokevirtual 527	java/io/InputStream:read	([B)I
    //   366: istore_3
    //   367: iload_3
    //   368: iconst_m1
    //   369: if_icmpeq +15 -> 384
    //   372: aload 4
    //   374: aload 6
    //   376: iconst_0
    //   377: iload_3
    //   378: invokevirtual 528	java/io/DataOutputStream:write	([BII)V
    //   381: goto -21 -> 360
    //   384: aload_0
    //   385: invokevirtual 263	java/io/InputStream:close	()V
    //   388: aload 4
    //   390: ldc 41
    //   392: invokevirtual 521	java/lang/String:getBytes	()[B
    //   395: invokevirtual 524	java/io/DataOutputStream:write	([B)V
    //   398: new 67	java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   405: astore_0
    //   406: aload_0
    //   407: ldc 47
    //   409: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload_0
    //   414: aload_1
    //   415: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload_0
    //   420: ldc 41
    //   422: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload 4
    //   428: aload_0
    //   429: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: invokevirtual 521	java/lang/String:getBytes	()[B
    //   435: invokevirtual 524	java/io/DataOutputStream:write	([B)V
    //   438: new 67	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   445: astore_0
    //   446: aload_0
    //   447: ldc_w 530
    //   450: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload_0
    //   455: ldc 41
    //   457: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: new 67	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   468: astore 6
    //   470: aload 6
    //   472: aload_2
    //   473: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 6
    //   479: ldc 41
    //   481: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload_0
    //   486: aload 6
    //   488: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: new 67	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   502: astore_2
    //   503: aload_2
    //   504: ldc 47
    //   506: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload_2
    //   511: aload_1
    //   512: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload_2
    //   517: ldc 41
    //   519: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload_0
    //   524: aload_2
    //   525: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload_0
    //   533: ldc_w 532
    //   536: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: aload_0
    //   541: ldc 41
    //   543: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload_0
    //   548: ldc_w 534
    //   551: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: new 67	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   562: astore_2
    //   563: aload_2
    //   564: ldc 47
    //   566: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload_2
    //   571: aload_1
    //   572: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: pop
    //   576: aload_2
    //   577: ldc 41
    //   579: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: aload_0
    //   584: aload_2
    //   585: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload 4
    //   594: aload_0
    //   595: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokevirtual 521	java/lang/String:getBytes	()[B
    //   601: invokevirtual 524	java/io/DataOutputStream:write	([B)V
    //   604: aload 4
    //   606: invokevirtual 537	java/io/DataOutputStream:flush	()V
    //   609: aload 4
    //   611: invokevirtual 538	java/io/DataOutputStream:close	()V
    //   614: aload 5
    //   616: invokevirtual 541	java/net/HttpURLConnection:getResponseCode	()I
    //   619: istore_3
    //   620: new 543	java/io/BufferedReader
    //   623: dup
    //   624: new 545	java/io/InputStreamReader
    //   627: dup
    //   628: aload 5
    //   630: invokevirtual 546	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   633: ldc_w 548
    //   636: invokespecial 551	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   639: invokespecial 554	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   642: astore_0
    //   643: aload_0
    //   644: invokevirtual 557	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   647: astore_1
    //   648: aload_1
    //   649: ifnull +19 -> 668
    //   652: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   655: ifeq -12 -> 643
    //   658: ldc 53
    //   660: iconst_4
    //   661: aload_1
    //   662: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   665: goto -22 -> 643
    //   668: iload_3
    //   669: sipush 200
    //   672: if_icmpne +69 -> 741
    //   675: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   678: ifeq +12 -> 690
    //   681: ldc 53
    //   683: iconst_4
    //   684: ldc_w 559
    //   687: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   690: iconst_1
    //   691: ireturn
    //   692: astore_1
    //   693: goto +6 -> 699
    //   696: astore_1
    //   697: aconst_null
    //   698: astore_0
    //   699: aload_0
    //   700: ifnull +7 -> 707
    //   703: aload_0
    //   704: invokevirtual 263	java/io/InputStream:close	()V
    //   707: aload_1
    //   708: athrow
    //   709: astore_1
    //   710: aload 4
    //   712: astore_0
    //   713: goto +6 -> 719
    //   716: astore_1
    //   717: aconst_null
    //   718: astore_0
    //   719: aload_0
    //   720: ifnull +7 -> 727
    //   723: aload_0
    //   724: invokevirtual 538	java/io/DataOutputStream:close	()V
    //   727: aload_1
    //   728: athrow
    //   729: astore_0
    //   730: aload_0
    //   731: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   734: iconst_0
    //   735: ireturn
    //   736: astore_0
    //   737: aload_0
    //   738: invokevirtual 560	java/net/MalformedURLException:printStackTrace	()V
    //   741: iconst_0
    //   742: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	743	0	paramFile	File
    //   0	743	1	paramString1	String
    //   0	743	2	paramString2	String
    //   366	307	3	i	int
    //   33	678	4	localObject1	Object
    //   119	510	5	localHttpURLConnection	java.net.HttpURLConnection
    //   8	479	6	localObject2	Object
    //   267	41	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   353	360	692	finally
    //   360	367	692	finally
    //   372	381	692	finally
    //   343	353	696	finally
    //   232	343	709	finally
    //   384	609	709	finally
    //   703	707	709	finally
    //   707	709	709	finally
    //   222	232	716	finally
    //   104	222	729	java/io/IOException
    //   609	643	729	java/io/IOException
    //   643	648	729	java/io/IOException
    //   652	665	729	java/io/IOException
    //   675	690	729	java/io/IOException
    //   723	727	729	java/io/IOException
    //   727	729	729	java/io/IOException
    //   104	222	736	java/net/MalformedURLException
    //   609	643	736	java/net/MalformedURLException
    //   643	648	736	java/net/MalformedURLException
    //   652	665	736	java/net/MalformedURLException
    //   675	690	736	java/net/MalformedURLException
    //   723	727	736	java/net/MalformedURLException
    //   727	729	736	java/net/MalformedURLException
  }
  
  public static void uploadLogcat(Context paramContext, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneAppCtrlUploadFileLogic", 4, "uploadLogcat start zip");
    }
    paramContext = new StringBuilder();
    paramContext.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    paramContext.append(File.separator);
    paramContext.append(ZIP_DIR);
    paramContext.append(File.separator);
    paramContext.append("LOGCAT");
    paramContext.append(File.separator);
    paramContext.append(paramString);
    paramContext.append("logcatwyx.txt");
    paramContext = new File(VFSAssistantUtils.getSDKPrivatePath(paramContext.toString()));
    if (!paramContext.exists()) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getAbsolutePath());
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append(ZIP_DIR);
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("LOGCAT");
    localObject1 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("upload.log.zip");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = new File((String)localObject1);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    uploadFile(paramContext, (String)localObject2, paramString);
  }
  
  public static void uploadTrace(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramLong1 > 0L)
    {
      if (paramLong2 <= paramLong1) {
        return;
      }
      paramContext = new StringBuilder();
      paramContext.append(Environment.getExternalStorageDirectory().getAbsolutePath());
      paramContext.append(File.separator);
      paramContext.append("tencent");
      paramContext.append(File.separator);
      paramContext.append("MobileQQ");
      paramContext.append(File.separator);
      paramContext.append("trace");
      Object localObject1 = new File(VFSAssistantUtils.getSDKPrivatePath(paramContext.toString())).listFiles(new QZoneAppCtrlUploadFileLogic.1(paramLong1, paramLong2));
      Object localObject2 = new QZoneAppCtrlUploadFileLogic.2();
      paramContext = new ArrayList();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("logFiles length");
          localStringBuilder.append(localObject1.length);
          QLog.d("QZoneAppCtrlUploadFileLogic", 4, localStringBuilder.toString());
        }
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          paramContext.add(new ShareAppLogHelper.LogFile(localObject1[i].getPath()));
          Collections.sort(paramContext, (Comparator)localObject2);
          i += 1;
        }
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("find file: ");
        ((StringBuilder)localObject1).append(paramContext.size());
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, ((StringBuilder)localObject1).toString());
      }
      if (paramContext.size() == 0) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getAbsolutePath());
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(ZIP_DIR);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("TRACE");
      localObject1 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("upload.log.zip");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = new File((String)localObject1);
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      uploadFile((File)paramContext.get(paramContext.size() - 1), (String)localObject2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.util.QZoneAppCtrlUploadFileLogic
 * JD-Core Version:    0.7.0.1
 */