package cooperation.qzone.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.testassister.ShareAppLogHelper.LogFile;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import common.qzone.component.util.SecurityUtil;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class QZoneAppCtrlUploadFileLogic
{
  public static final String ANR_LOG_DIRECTORY = "anr";
  public static final String ANR_LOG_PATH = "anr" + File.separator + "traces.txt";
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
  public static final String ZIP_DIR = "tencent" + File.separator + "zip";
  
  public static long getAvsdkTimeFromServer(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return -1L;
      if (paramString.length() == 10) {
        try
        {
          Date localDate = new SimpleDateFormat("yyyyMMddHH").parse(paramString.trim());
          if (localDate != null)
          {
            long l = localDate.getTime();
            return l;
          }
        }
        catch (Exception localException)
        {
          localException = localException;
          QLog.e("QZoneAppCtrlUploadFileLogic", 1, "error time = " + paramString);
          localException.printStackTrace();
          return -1L;
        }
        finally {}
      }
    }
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
    //   11: astore 9
    //   13: invokestatic 169	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   16: ldc 171
    //   18: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   21: ifeq +471 -> 492
    //   24: new 76	java/io/File
    //   27: dup
    //   28: new 67	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   35: invokestatic 179	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   38: invokevirtual 182	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   41: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: getstatic 79	java/io/File:separator	Ljava/lang/String;
    //   47: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: getstatic 93	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:ZIP_DIR	Ljava/lang/String;
    //   53: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: getstatic 79	java/io/File:separator	Ljava/lang/String;
    //   59: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 44
    //   64: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 188	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   73: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   76: astore 8
    //   78: aload 8
    //   80: invokevirtual 193	java/io/File:exists	()Z
    //   83: ifne +44 -> 127
    //   86: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   89: ifeq +32 -> 121
    //   92: ldc 53
    //   94: iconst_4
    //   95: new 67	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   102: ldc 198
    //   104: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 8
    //   109: invokevirtual 182	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   112: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload 8
    //   123: invokevirtual 204	java/io/File:mkdirs	()Z
    //   126: pop
    //   127: new 76	java/io/File
    //   130: dup
    //   131: new 67	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   138: invokestatic 179	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   141: invokevirtual 182	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   144: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: getstatic 79	java/io/File:separator	Ljava/lang/String;
    //   150: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: getstatic 93	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:ZIP_DIR	Ljava/lang/String;
    //   156: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: getstatic 79	java/io/File:separator	Ljava/lang/String;
    //   162: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc 44
    //   167: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: getstatic 79	java/io/File:separator	Ljava/lang/String;
    //   173: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_1
    //   177: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc 206
    //   182: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 188	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   191: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   194: astore 8
    //   196: aload 8
    //   198: invokevirtual 193	java/io/File:exists	()Z
    //   201: ifne +297 -> 498
    //   204: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   207: ifeq +32 -> 239
    //   210: ldc 53
    //   212: iconst_4
    //   213: new 67	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   220: ldc 208
    //   222: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload 8
    //   227: invokevirtual 182	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   230: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: aload 8
    //   241: invokevirtual 211	java/io/File:createNewFile	()Z
    //   244: pop
    //   245: goto +253 -> 498
    //   248: sipush 1024
    //   251: newarray byte
    //   253: astore 10
    //   255: ldc 212
    //   257: istore_2
    //   258: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   261: ifeq +11 -> 272
    //   264: ldc 53
    //   266: iconst_4
    //   267: ldc 214
    //   269: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: new 216	java/io/FileOutputStream
    //   275: dup
    //   276: aload 8
    //   278: invokespecial 219	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   281: astore 8
    //   283: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   286: lstore 4
    //   288: iload_2
    //   289: ifle +75 -> 364
    //   292: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   295: lstore 6
    //   297: lload 6
    //   299: lload 4
    //   301: lsub
    //   302: ldc2_w 225
    //   305: lcmp
    //   306: ifle +74 -> 380
    //   309: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   312: ifeq +52 -> 364
    //   315: ldc 53
    //   317: iconst_4
    //   318: new 67	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   325: ldc 228
    //   327: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: lload 6
    //   332: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   335: ldc 233
    //   337: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: lload 4
    //   342: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   345: ldc 235
    //   347: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: lload 6
    //   352: lload 4
    //   354: lsub
    //   355: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   358: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: aload 8
    //   366: invokevirtual 238	java/io/FileOutputStream:close	()V
    //   369: aload_0
    //   370: aload_1
    //   371: invokestatic 241	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:uploadLogcat	(Landroid/content/Context;Ljava/lang/String;)V
    //   374: aload 9
    //   376: invokevirtual 244	java/io/InputStream:close	()V
    //   379: return
    //   380: aload 9
    //   382: aload 10
    //   384: iconst_0
    //   385: iload_2
    //   386: aload 10
    //   388: arraylength
    //   389: invokestatic 250	java/lang/Math:min	(II)I
    //   392: invokevirtual 254	java/io/InputStream:read	([BII)I
    //   395: istore_3
    //   396: iload_3
    //   397: iconst_m1
    //   398: if_icmpne +78 -> 476
    //   401: new 256	java/io/EOFException
    //   404: dup
    //   405: ldc_w 258
    //   408: invokespecial 259	java/io/EOFException:<init>	(Ljava/lang/String;)V
    //   411: athrow
    //   412: astore 10
    //   414: aload 8
    //   416: invokevirtual 238	java/io/FileOutputStream:close	()V
    //   419: aload_0
    //   420: aload_1
    //   421: invokestatic 241	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:uploadLogcat	(Landroid/content/Context;Ljava/lang/String;)V
    //   424: aload 10
    //   426: athrow
    //   427: astore_0
    //   428: aload 9
    //   430: invokevirtual 244	java/io/InputStream:close	()V
    //   433: aload_0
    //   434: athrow
    //   435: astore_0
    //   436: aload_0
    //   437: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   440: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   443: ifeq -64 -> 379
    //   446: ldc 53
    //   448: iconst_4
    //   449: new 67	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   456: ldc_w 262
    //   459: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload_0
    //   463: invokevirtual 263	java/io/IOException:toString	()Ljava/lang/String;
    //   466: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: return
    //   476: aload 8
    //   478: aload 10
    //   480: iconst_0
    //   481: iload_3
    //   482: invokevirtual 267	java/io/FileOutputStream:write	([BII)V
    //   485: iload_2
    //   486: iload_3
    //   487: isub
    //   488: istore_2
    //   489: goto -201 -> 288
    //   492: aconst_null
    //   493: astore 8
    //   495: goto -247 -> 248
    //   498: goto -250 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	paramContext	Context
    //   0	501	1	paramString	String
    //   257	232	2	i	int
    //   395	93	3	j	int
    //   286	67	4	l1	long
    //   295	56	6	l2	long
    //   76	418	8	localObject	Object
    //   11	418	9	localInputStream	java.io.InputStream
    //   253	134	10	arrayOfByte1	byte[]
    //   412	67	10	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   283	288	412	finally
    //   292	297	412	finally
    //   309	364	412	finally
    //   380	396	412	finally
    //   401	412	412	finally
    //   476	485	412	finally
    //   272	283	427	finally
    //   364	374	427	finally
    //   414	427	427	finally
    //   0	121	435	java/io/IOException
    //   121	127	435	java/io/IOException
    //   127	239	435	java/io/IOException
    //   239	245	435	java/io/IOException
    //   248	255	435	java/io/IOException
    //   258	272	435	java/io/IOException
    //   374	379	435	java/io/IOException
    //   428	435	435	java/io/IOException
  }
  
  public static void showDirFileList(Context paramContext, String paramString)
  {
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent");
    }
    for (;;)
    {
      int i;
      try
      {
        paramContext = new File(paramContext);
        if (paramContext.isDirectory())
        {
          QLog.e("QZoneAppCtrlUploadFileLogic", 1, "showDirFileList dirPath:" + paramContext.getAbsolutePath());
          paramContext = paramContext.listFiles();
          if (paramContext != null)
          {
            i = 0;
            if (i < paramContext.length)
            {
              if (paramContext[i].isDirectory()) {
                QLog.e("QZoneAppCtrlUploadFileLogic", 1, "dir:" + paramContext[i].getAbsolutePath());
              }
              if (!paramContext[i].isFile()) {
                break label246;
              }
              QLog.e("QZoneAppCtrlUploadFileLogic", 1, "file:" + paramContext[i].getAbsolutePath() + ",size:" + paramContext[i].length());
              break label246;
            }
          }
        }
        else if (paramContext.isFile())
        {
          QLog.e("QZoneAppCtrlUploadFileLogic", 1, "showDirFileList filePath:" + paramContext.getAbsolutePath());
        }
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      label246:
      i += 1;
    }
  }
  
  /* Error */
  private static int stepZipLogFile(String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 76	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: new 294	java/util/zip/ZipOutputStream
    //   15: dup
    //   16: new 216	java/io/FileOutputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 219	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   24: invokespecial 297	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore_3
    //   28: aload_3
    //   29: ifnonnull +14 -> 43
    //   32: aload_3
    //   33: ifnull +7 -> 40
    //   36: aload_3
    //   37: invokevirtual 298	java/util/zip/ZipOutputStream:close	()V
    //   40: bipush 253
    //   42: ireturn
    //   43: sipush 1024
    //   46: newarray byte
    //   48: astore 4
    //   50: new 300	java/util/zip/ZipEntry
    //   53: dup
    //   54: aload_1
    //   55: invokevirtual 303	java/io/File:getName	()Ljava/lang/String;
    //   58: invokespecial 304	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   61: astore 5
    //   63: aload 5
    //   65: aload_1
    //   66: invokevirtual 288	java/io/File:length	()J
    //   69: invokevirtual 308	java/util/zip/ZipEntry:setSize	(J)V
    //   72: aload 5
    //   74: aload_1
    //   75: invokevirtual 311	java/io/File:lastModified	()J
    //   78: invokevirtual 314	java/util/zip/ZipEntry:setTime	(J)V
    //   81: aload_3
    //   82: aload 5
    //   84: invokevirtual 318	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   87: new 320	java/io/BufferedInputStream
    //   90: dup
    //   91: new 322	java/io/FileInputStream
    //   94: dup
    //   95: aload_1
    //   96: invokespecial 323	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   99: invokespecial 326	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   102: astore_1
    //   103: aload_1
    //   104: aload 4
    //   106: iconst_0
    //   107: sipush 1024
    //   110: invokevirtual 254	java/io/InputStream:read	([BII)I
    //   113: istore_2
    //   114: iload_2
    //   115: iconst_m1
    //   116: if_icmpeq +61 -> 177
    //   119: aload_3
    //   120: aload 4
    //   122: iconst_0
    //   123: iload_2
    //   124: invokevirtual 327	java/util/zip/ZipOutputStream:write	([BII)V
    //   127: goto -24 -> 103
    //   130: astore_0
    //   131: aload_1
    //   132: ifnull +7 -> 139
    //   135: aload_1
    //   136: invokevirtual 244	java/io/InputStream:close	()V
    //   139: aload_0
    //   140: athrow
    //   141: astore_0
    //   142: aload_3
    //   143: astore_1
    //   144: aload_1
    //   145: ifnull +7 -> 152
    //   148: aload_1
    //   149: invokevirtual 298	java/util/zip/ZipOutputStream:close	()V
    //   152: aload_0
    //   153: athrow
    //   154: astore_0
    //   155: aload_0
    //   156: invokevirtual 142	java/lang/Exception:printStackTrace	()V
    //   159: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   162: ifeq -122 -> 40
    //   165: ldc 53
    //   167: iconst_4
    //   168: ldc_w 329
    //   171: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: bipush 253
    //   176: ireturn
    //   177: aload_1
    //   178: ifnull +7 -> 185
    //   181: aload_1
    //   182: invokevirtual 244	java/io/InputStream:close	()V
    //   185: aload_3
    //   186: invokevirtual 298	java/util/zip/ZipOutputStream:close	()V
    //   189: aload_0
    //   190: invokevirtual 288	java/io/File:length	()J
    //   193: ldc2_w 330
    //   196: lcmp
    //   197: iflt +28 -> 225
    //   200: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   203: ifeq +12 -> 215
    //   206: ldc 53
    //   208: iconst_4
    //   209: ldc_w 333
    //   212: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload_3
    //   216: ifnull +7 -> 223
    //   219: aload_3
    //   220: invokevirtual 298	java/util/zip/ZipOutputStream:close	()V
    //   223: iconst_1
    //   224: ireturn
    //   225: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   228: ifeq +12 -> 240
    //   231: ldc 53
    //   233: iconst_4
    //   234: ldc_w 335
    //   237: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: aload_3
    //   241: ifnull +7 -> 248
    //   244: aload_3
    //   245: invokevirtual 298	java/util/zip/ZipOutputStream:close	()V
    //   248: iconst_0
    //   249: ireturn
    //   250: astore_0
    //   251: aload 4
    //   253: astore_1
    //   254: goto -110 -> 144
    //   257: astore_0
    //   258: aconst_null
    //   259: astore_1
    //   260: goto -129 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramString	String
    //   0	263	1	paramFile	File
    //   113	11	2	i	int
    //   27	218	3	localZipOutputStream	java.util.zip.ZipOutputStream
    //   1	251	4	arrayOfByte	byte[]
    //   61	22	5	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   103	114	130	finally
    //   119	127	130	finally
    //   43	87	141	finally
    //   135	139	141	finally
    //   139	141	141	finally
    //   181	185	141	finally
    //   185	215	141	finally
    //   225	240	141	finally
    //   3	12	154	java/lang/Exception
    //   36	40	154	java/lang/Exception
    //   148	152	154	java/lang/Exception
    //   152	154	154	java/lang/Exception
    //   219	223	154	java/lang/Exception
    //   244	248	154	java/lang/Exception
    //   12	28	250	finally
    //   87	103	257	finally
  }
  
  /* Error */
  private static int stepZipLogFiles(String paramString, ArrayList<File> paramArrayList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 76	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: new 294	java/util/zip/ZipOutputStream
    //   15: dup
    //   16: new 216	java/io/FileOutputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 219	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   24: invokespecial 297	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore 5
    //   29: aload 5
    //   31: ifnonnull +18 -> 49
    //   34: aload 5
    //   36: ifnull +8 -> 44
    //   39: aload 5
    //   41: invokevirtual 298	java/util/zip/ZipOutputStream:close	()V
    //   44: bipush 253
    //   46: istore_2
    //   47: iload_2
    //   48: ireturn
    //   49: sipush 1024
    //   52: newarray byte
    //   54: astore 6
    //   56: aload_1
    //   57: invokevirtual 343	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   60: astore 7
    //   62: aload 7
    //   64: invokeinterface 348 1 0
    //   69: ifeq +155 -> 224
    //   72: aload 7
    //   74: invokeinterface 352 1 0
    //   79: checkcast 76	java/io/File
    //   82: astore_1
    //   83: new 300	java/util/zip/ZipEntry
    //   86: dup
    //   87: aload_1
    //   88: invokevirtual 303	java/io/File:getName	()Ljava/lang/String;
    //   91: invokespecial 304	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   94: astore 8
    //   96: aload 8
    //   98: aload_1
    //   99: invokevirtual 288	java/io/File:length	()J
    //   102: invokevirtual 308	java/util/zip/ZipEntry:setSize	(J)V
    //   105: aload 8
    //   107: aload_1
    //   108: invokevirtual 311	java/io/File:lastModified	()J
    //   111: invokevirtual 314	java/util/zip/ZipEntry:setTime	(J)V
    //   114: aload 5
    //   116: aload 8
    //   118: invokevirtual 318	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   121: new 320	java/io/BufferedInputStream
    //   124: dup
    //   125: new 322	java/io/FileInputStream
    //   128: dup
    //   129: aload_1
    //   130: invokespecial 323	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   133: invokespecial 326	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   136: astore_1
    //   137: aload_1
    //   138: aload 6
    //   140: iconst_0
    //   141: sipush 1024
    //   144: invokevirtual 254	java/io/InputStream:read	([BII)I
    //   147: istore_2
    //   148: iload_2
    //   149: iconst_m1
    //   150: if_icmpeq +63 -> 213
    //   153: aload 5
    //   155: aload 6
    //   157: iconst_0
    //   158: iload_2
    //   159: invokevirtual 327	java/util/zip/ZipOutputStream:write	([BII)V
    //   162: goto -25 -> 137
    //   165: astore_0
    //   166: aload_1
    //   167: ifnull +7 -> 174
    //   170: aload_1
    //   171: invokevirtual 244	java/io/InputStream:close	()V
    //   174: aload_0
    //   175: athrow
    //   176: astore_0
    //   177: aload 5
    //   179: astore_1
    //   180: aload_1
    //   181: ifnull +7 -> 188
    //   184: aload_1
    //   185: invokevirtual 298	java/util/zip/ZipOutputStream:close	()V
    //   188: aload_0
    //   189: athrow
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 142	java/lang/Exception:printStackTrace	()V
    //   195: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   198: ifeq +12 -> 210
    //   201: ldc 53
    //   203: iconst_4
    //   204: ldc_w 354
    //   207: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: bipush 253
    //   212: ireturn
    //   213: aload_1
    //   214: ifnull -152 -> 62
    //   217: aload_1
    //   218: invokevirtual 244	java/io/InputStream:close	()V
    //   221: goto -159 -> 62
    //   224: aload 5
    //   226: invokevirtual 298	java/util/zip/ZipOutputStream:close	()V
    //   229: aload_0
    //   230: invokevirtual 288	java/io/File:length	()J
    //   233: lstore_3
    //   234: lload_3
    //   235: ldc2_w 330
    //   238: lcmp
    //   239: iflt +17 -> 256
    //   242: iconst_1
    //   243: istore_2
    //   244: aload 5
    //   246: ifnull -199 -> 47
    //   249: aload 5
    //   251: invokevirtual 298	java/util/zip/ZipOutputStream:close	()V
    //   254: iconst_1
    //   255: ireturn
    //   256: aload 5
    //   258: ifnull +8 -> 266
    //   261: aload 5
    //   263: invokevirtual 298	java/util/zip/ZipOutputStream:close	()V
    //   266: iconst_0
    //   267: ireturn
    //   268: astore_0
    //   269: aload 6
    //   271: astore_1
    //   272: goto -92 -> 180
    //   275: astore_0
    //   276: aconst_null
    //   277: astore_1
    //   278: goto -112 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	paramString	String
    //   0	281	1	paramArrayList	ArrayList<File>
    //   46	198	2	i	int
    //   233	2	3	l	long
    //   27	235	5	localZipOutputStream	java.util.zip.ZipOutputStream
    //   1	269	6	arrayOfByte	byte[]
    //   60	13	7	localIterator	java.util.Iterator
    //   94	23	8	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   137	148	165	finally
    //   153	162	165	finally
    //   49	62	176	finally
    //   62	121	176	finally
    //   170	174	176	finally
    //   174	176	176	finally
    //   217	221	176	finally
    //   224	234	176	finally
    //   3	12	190	java/lang/Exception
    //   39	44	190	java/lang/Exception
    //   184	188	190	java/lang/Exception
    //   188	190	190	java/lang/Exception
    //   249	254	190	java/lang/Exception
    //   261	266	190	java/lang/Exception
    //   12	29	268	finally
    //   121	137	275	finally
  }
  
  public static void uploadANR(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramContext = new File(VFSAssistantUtils.getSDKPrivatePath(Environment.getDataDirectory().getAbsolutePath() + File.separator + "anr"));
    } while ((!paramContext.isDirectory()) || (paramContext.listFiles() == null));
    Object localObject = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + ZIP_DIR + File.separator + "ANR");
    String str = (String)localObject + File.separator + "upload.log.zip";
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    uploadFile(paramContext, str, paramString);
  }
  
  public static void uploadAvsdk(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    QZoneAppCtrlUploadFileLogic.3 local3;
    do
    {
      return;
      paramContext = new File(VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent" + File.separator + "mobileqq" + File.separator + "log" + File.separator + "avsdk"));
      local3 = new QZoneAppCtrlUploadFileLogic.3(paramLong1, paramLong2);
    } while ((!paramContext.isDirectory()) || (paramContext.listFiles() == null));
    Object localObject = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + ZIP_DIR + File.separator + "avsdk");
    String str = (String)localObject + File.separator + "upload.log.zip";
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    uploadFile(paramContext, local3, str, paramString);
  }
  
  public static void uploadByCustom(Context paramContext, String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (paramContext == null)) {}
    label252:
    for (;;)
    {
      return;
      String str = null;
      if (paramBoolean) {
        if (paramContext.getFilesDir() == null) {}
      }
      for (str = paramContext.getFilesDir().getParent();; str = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent"))
      {
        if (TextUtils.isEmpty(str)) {
          break label252;
        }
        paramContext = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + ZIP_DIR + File.separator + "custom");
        File localFile = new File(paramContext);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        paramContext = paramContext + File.separator + "upload.log.zip";
        paramString1 = new File(str, paramString1);
        if ((!paramString1.isFile()) || (paramString1.length() >= paramLong)) {
          break;
        }
        uploadFile(paramString1, paramContext, paramString2);
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, "uploadByCustom filename: " + paramContext);
        return;
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
    paramContext = paramContext.getFilesDir().getParent() + File.separator + "databases" + File.separator + (String)localObject;
    paramString2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + ZIP_DIR + File.separator + "DB";
    localObject = new File(VFSAssistantUtils.getSDKPrivatePath(paramString2));
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    paramString2 = VFSAssistantUtils.getSDKPrivatePath(paramString2 + File.separator + "upload.log.zip");
    uploadFile(new File(paramContext), paramString2, paramString1);
  }
  
  public static boolean uploadFile(File paramFile, FilenameFilter paramFilenameFilter, String paramString1, String paramString2)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
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
          if ((paramFilenameFilter == null) || (paramFilenameFilter.length == 0))
          {
            QLog.w("QZoneAppCtrlUploadFileLogic", 2, "files is empty");
            return false;
          }
          j = paramFilenameFilter.length;
          i = 0;
          while (i < j)
          {
            localArrayList.add(paramFilenameFilter[i]);
            i += 1;
          }
          i = stepZipLogFiles(paramString1, localArrayList);
        }
      }
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("QZoneAppCtrlUploadFileLogic", 2, "uploadFile zip file error code" + i);
        }
        FileUtils.e(paramString1);
        return false;
      }
    }
    return uploadFileToServer(paramFile, paramString1, paramString2);
  }
  
  public static boolean uploadFile(File paramFile, String paramString1, String paramString2)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return false;
    }
    if (paramFile.exists())
    {
      ArrayList localArrayList;
      if ((paramFile.getName().contains("anr")) && (paramFile.isDirectory()))
      {
        localArrayList = new ArrayList();
        File[] arrayOfFile = paramFile.listFiles();
        int j = arrayOfFile.length;
        i = 0;
        while (i < j)
        {
          localArrayList.add(arrayOfFile[i]);
          i += 1;
        }
      }
      for (int i = stepZipLogFiles(paramString1, localArrayList);; i = stepZipLogFile(paramString1, paramFile))
      {
        if (i == 0) {
          break label150;
        }
        if (QLog.isColorLevel()) {
          QLog.w("QZoneAppCtrlUploadFileLogic", 2, "uploadFile zip file error code" + i);
        }
        FileUtils.e(paramString1);
        return false;
        if (!paramFile.isFile()) {
          break;
        }
      }
    }
    label150:
    return uploadFileToServer(paramFile, paramString1, paramString2);
  }
  
  /* Error */
  public static boolean uploadFileToServer(File paramFile, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 76	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 7
    //   13: aload 7
    //   15: invokevirtual 193	java/io/File:exists	()Z
    //   18: ifne +5 -> 23
    //   21: iconst_0
    //   22: ireturn
    //   23: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   26: ifeq +58 -> 84
    //   29: ldc 53
    //   31: iconst_4
    //   32: new 67	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 443
    //   42: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_1
    //   46: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: ldc 53
    //   57: iconst_4
    //   58: new 67	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 445
    //   68: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_0
    //   72: invokevirtual 182	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   75: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: invokestatic 451	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   87: invokevirtual 452	java/util/UUID:toString	()Ljava/lang/String;
    //   90: astore_0
    //   91: new 454	java/net/URL
    //   94: dup
    //   95: ldc 50
    //   97: invokespecial 455	java/net/URL:<init>	(Ljava/lang/String;)V
    //   100: invokevirtual 459	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   103: checkcast 461	java/net/HttpURLConnection
    //   106: astore 6
    //   108: aload 6
    //   110: ldc 55
    //   112: invokevirtual 465	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   115: aload 6
    //   117: ldc 55
    //   119: invokevirtual 468	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   122: aload 6
    //   124: iconst_1
    //   125: invokevirtual 472	java/net/HttpURLConnection:setDoInput	(Z)V
    //   128: aload 6
    //   130: iconst_1
    //   131: invokevirtual 475	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   134: aload 6
    //   136: iconst_0
    //   137: invokevirtual 478	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   140: aload 6
    //   142: ldc_w 480
    //   145: invokevirtual 483	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   148: aload 6
    //   150: ldc_w 485
    //   153: ldc 18
    //   155: invokevirtual 488	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload 6
    //   160: ldc_w 490
    //   163: ldc_w 492
    //   166: invokevirtual 488	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload 6
    //   171: ldc_w 494
    //   174: new 67	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   181: ldc_w 496
    //   184: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_0
    //   188: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokevirtual 488	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload 7
    //   199: ifnull +185 -> 384
    //   202: aload 6
    //   204: invokevirtual 500	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   207: astore_1
    //   208: new 502	java/io/DataOutputStream
    //   211: dup
    //   212: aload_1
    //   213: invokespecial 503	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   216: astore 4
    //   218: new 505	java/lang/StringBuffer
    //   221: dup
    //   222: invokespecial 506	java/lang/StringBuffer:<init>	()V
    //   225: astore_1
    //   226: aload_1
    //   227: ldc 47
    //   229: invokevirtual 509	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   232: pop
    //   233: aload_1
    //   234: aload_0
    //   235: invokevirtual 509	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   238: pop
    //   239: aload_1
    //   240: ldc 41
    //   242: invokevirtual 509	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   245: pop
    //   246: aload_1
    //   247: new 67	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 511
    //   257: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload 7
    //   262: invokevirtual 303	java/io/File:getName	()Ljava/lang/String;
    //   265: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc_w 513
    //   271: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc 41
    //   276: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokevirtual 509	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   285: pop
    //   286: aload_1
    //   287: ldc_w 515
    //   290: invokevirtual 509	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   293: pop
    //   294: aload_1
    //   295: ldc 41
    //   297: invokevirtual 509	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   300: pop
    //   301: aload 4
    //   303: aload_1
    //   304: invokevirtual 516	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   307: invokevirtual 520	java/lang/String:getBytes	()[B
    //   310: invokevirtual 523	java/io/DataOutputStream:write	([B)V
    //   313: new 322	java/io/FileInputStream
    //   316: dup
    //   317: aload 7
    //   319: invokespecial 323	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   322: astore_1
    //   323: sipush 1024
    //   326: newarray byte
    //   328: astore 5
    //   330: aload_1
    //   331: aload 5
    //   333: invokevirtual 526	java/io/InputStream:read	([B)I
    //   336: istore_3
    //   337: iload_3
    //   338: iconst_m1
    //   339: if_icmpeq +47 -> 386
    //   342: aload 4
    //   344: aload 5
    //   346: iconst_0
    //   347: iload_3
    //   348: invokevirtual 527	java/io/DataOutputStream:write	([BII)V
    //   351: goto -21 -> 330
    //   354: astore_0
    //   355: aload_1
    //   356: ifnull +7 -> 363
    //   359: aload_1
    //   360: invokevirtual 244	java/io/InputStream:close	()V
    //   363: aload_0
    //   364: athrow
    //   365: astore_0
    //   366: aload 4
    //   368: astore_1
    //   369: aload_1
    //   370: ifnull +7 -> 377
    //   373: aload_1
    //   374: invokevirtual 528	java/io/DataOutputStream:close	()V
    //   377: aload_0
    //   378: athrow
    //   379: astore_0
    //   380: aload_0
    //   381: invokevirtual 529	java/net/MalformedURLException:printStackTrace	()V
    //   384: iconst_0
    //   385: ireturn
    //   386: aload_1
    //   387: ifnull +7 -> 394
    //   390: aload_1
    //   391: invokevirtual 244	java/io/InputStream:close	()V
    //   394: aload 4
    //   396: ldc 41
    //   398: invokevirtual 520	java/lang/String:getBytes	()[B
    //   401: invokevirtual 523	java/io/DataOutputStream:write	([B)V
    //   404: aload 4
    //   406: new 67	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   413: ldc 47
    //   415: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload_0
    //   419: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: ldc 41
    //   424: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokevirtual 520	java/lang/String:getBytes	()[B
    //   433: invokevirtual 523	java/io/DataOutputStream:write	([B)V
    //   436: new 67	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   443: astore_1
    //   444: aload_1
    //   445: ldc_w 531
    //   448: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload_1
    //   453: ldc 41
    //   455: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload_1
    //   460: new 67	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   467: aload_2
    //   468: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: ldc 41
    //   473: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload_1
    //   484: new 67	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   491: ldc 47
    //   493: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_0
    //   497: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: ldc 41
    //   502: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: aload_1
    //   513: ldc_w 533
    //   516: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload_1
    //   521: ldc 41
    //   523: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload_1
    //   528: ldc_w 535
    //   531: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload_1
    //   536: new 67	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   543: ldc 47
    //   545: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload_0
    //   549: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: ldc 41
    //   554: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload 4
    //   566: aload_1
    //   567: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokevirtual 520	java/lang/String:getBytes	()[B
    //   573: invokevirtual 523	java/io/DataOutputStream:write	([B)V
    //   576: aload 4
    //   578: invokevirtual 538	java/io/DataOutputStream:flush	()V
    //   581: aload 4
    //   583: ifnull +8 -> 591
    //   586: aload 4
    //   588: invokevirtual 528	java/io/DataOutputStream:close	()V
    //   591: aload 6
    //   593: invokevirtual 541	java/net/HttpURLConnection:getResponseCode	()I
    //   596: istore_3
    //   597: new 543	java/io/BufferedReader
    //   600: dup
    //   601: new 545	java/io/InputStreamReader
    //   604: dup
    //   605: aload 6
    //   607: invokevirtual 546	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   610: ldc_w 548
    //   613: invokespecial 551	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   616: invokespecial 554	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   619: astore_0
    //   620: aload_0
    //   621: invokevirtual 557	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   624: astore_1
    //   625: aload_1
    //   626: ifnull +27 -> 653
    //   629: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   632: ifeq -12 -> 620
    //   635: ldc 53
    //   637: iconst_4
    //   638: aload_1
    //   639: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   642: goto -22 -> 620
    //   645: astore_0
    //   646: aload_0
    //   647: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   650: goto -266 -> 384
    //   653: iload_3
    //   654: sipush 200
    //   657: if_icmpne -273 -> 384
    //   660: invokestatic 196	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   663: ifeq +12 -> 675
    //   666: ldc 53
    //   668: iconst_4
    //   669: ldc_w 559
    //   672: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   675: iconst_1
    //   676: ireturn
    //   677: astore_0
    //   678: aload 5
    //   680: astore_1
    //   681: goto -312 -> 369
    //   684: astore_0
    //   685: aconst_null
    //   686: astore_1
    //   687: goto -332 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	690	0	paramFile	File
    //   0	690	1	paramString1	String
    //   0	690	2	paramString2	String
    //   336	322	3	i	int
    //   216	371	4	localDataOutputStream	java.io.DataOutputStream
    //   1	678	5	arrayOfByte	byte[]
    //   106	500	6	localHttpURLConnection	java.net.HttpURLConnection
    //   11	307	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   323	330	354	finally
    //   330	337	354	finally
    //   342	351	354	finally
    //   218	313	365	finally
    //   359	363	365	finally
    //   363	365	365	finally
    //   390	394	365	finally
    //   394	581	365	finally
    //   91	197	379	java/net/MalformedURLException
    //   202	208	379	java/net/MalformedURLException
    //   373	377	379	java/net/MalformedURLException
    //   377	379	379	java/net/MalformedURLException
    //   586	591	379	java/net/MalformedURLException
    //   591	620	379	java/net/MalformedURLException
    //   620	625	379	java/net/MalformedURLException
    //   629	642	379	java/net/MalformedURLException
    //   660	675	379	java/net/MalformedURLException
    //   91	197	645	java/io/IOException
    //   202	208	645	java/io/IOException
    //   373	377	645	java/io/IOException
    //   377	379	645	java/io/IOException
    //   586	591	645	java/io/IOException
    //   591	620	645	java/io/IOException
    //   620	625	645	java/io/IOException
    //   629	642	645	java/io/IOException
    //   660	675	645	java/io/IOException
    //   208	218	677	finally
    //   313	323	684	finally
  }
  
  public static void uploadLogcat(Context paramContext, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneAppCtrlUploadFileLogic", 4, "uploadLogcat start zip");
    }
    paramContext = new File(VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + ZIP_DIR + File.separator + "LOGCAT" + File.separator + paramString + "logcatwyx.txt"));
    if (!paramContext.exists()) {
      return;
    }
    Object localObject = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + ZIP_DIR + File.separator + "LOGCAT");
    String str = (String)localObject + File.separator + "upload.log.zip";
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    uploadFile(paramContext, str, paramString);
  }
  
  public static void uploadTrace(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while ((paramLong1 <= 0L) || (paramLong2 <= paramLong1));
      localObject1 = new File(VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent" + File.separator + "MobileQQ" + File.separator + "trace")).listFiles(new QZoneAppCtrlUploadFileLogic.1(paramLong1, paramLong2));
      localObject2 = new QZoneAppCtrlUploadFileLogic.2();
      paramContext = new ArrayList();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QZoneAppCtrlUploadFileLogic", 4, "logFiles length" + localObject1.length);
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
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, "find file: " + paramContext.size());
      }
    } while (paramContext.size() == 0);
    Object localObject2 = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + ZIP_DIR + File.separator + "TRACE");
    Object localObject1 = (String)localObject2 + File.separator + "upload.log.zip";
    localObject2 = new File((String)localObject2);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    uploadFile((File)paramContext.get(paramContext.size() - 1), (String)localObject1, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.util.QZoneAppCtrlUploadFileLogic
 * JD-Core Version:    0.7.0.1
 */