package com.tencent.qqmini.sdk.core.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.FileProvider;
import android.system.Os;
import android.system.StructStat;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

public class FileUtils
{
  private static final String TAG = "FileUtils";
  public static String sAuthority;
  public static Boolean sIsTargetThanN;
  
  public static void broadcastCarmera(Context paramContext, File paramFile)
  {
    FileProvider7Helper.savePhotoToSysAlbum(paramContext, paramFile);
  }
  
  public static boolean checkDirAndCreate(String paramString)
  {
    Object localObject = new File(paramString);
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mkdirs failed, path: ");
      ((StringBuilder)localObject).append(paramString);
      QMLog.w("FileUtils", ((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
  
  public static void copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  /* Error */
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 4
    //   11: aload_1
    //   12: invokevirtual 36	java/io/File:exists	()Z
    //   15: ifeq +8 -> 23
    //   18: aload_1
    //   19: invokevirtual 80	java/io/File:delete	()Z
    //   22: pop
    //   23: new 82	java/io/FileOutputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 85	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   31: astore_1
    //   32: new 87	java/io/BufferedInputStream
    //   35: dup
    //   36: new 89	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: invokespecial 93	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: astore_0
    //   48: sipush 1024
    //   51: newarray byte
    //   53: astore 4
    //   55: aload_0
    //   56: aload 4
    //   58: invokevirtual 94	java/io/BufferedInputStream:read	([B)I
    //   61: istore_2
    //   62: iload_2
    //   63: iconst_m1
    //   64: if_icmpeq +18 -> 82
    //   67: aload_1
    //   68: aload 4
    //   70: iconst_0
    //   71: iload_2
    //   72: invokevirtual 95	java/io/FileOutputStream:write	([BII)V
    //   75: aload_1
    //   76: invokevirtual 98	java/io/FileOutputStream:flush	()V
    //   79: goto -24 -> 55
    //   82: iconst_1
    //   83: istore_3
    //   84: aload_1
    //   85: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   88: aload_0
    //   89: invokevirtual 102	java/io/BufferedInputStream:close	()V
    //   92: iconst_1
    //   93: ireturn
    //   94: astore 5
    //   96: aload_0
    //   97: astore 4
    //   99: aload 5
    //   101: astore_0
    //   102: goto +28 -> 130
    //   105: goto +53 -> 158
    //   108: goto +76 -> 184
    //   111: astore_0
    //   112: goto +18 -> 130
    //   115: aload 5
    //   117: astore_0
    //   118: goto +40 -> 158
    //   121: aload 6
    //   123: astore_0
    //   124: goto +60 -> 184
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull +10 -> 141
    //   134: aload_1
    //   135: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   138: goto +3 -> 141
    //   141: aload 4
    //   143: ifnull +8 -> 151
    //   146: aload 4
    //   148: invokevirtual 102	java/io/BufferedInputStream:close	()V
    //   151: aload_0
    //   152: athrow
    //   153: aconst_null
    //   154: astore_1
    //   155: aload 5
    //   157: astore_0
    //   158: aload_1
    //   159: ifnull +10 -> 169
    //   162: aload_1
    //   163: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   166: goto +3 -> 169
    //   169: aload_0
    //   170: ifnull +32 -> 202
    //   173: aload_0
    //   174: invokevirtual 102	java/io/BufferedInputStream:close	()V
    //   177: iconst_0
    //   178: ireturn
    //   179: aconst_null
    //   180: astore_1
    //   181: aload 6
    //   183: astore_0
    //   184: aload_1
    //   185: ifnull +10 -> 195
    //   188: aload_1
    //   189: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   192: goto +3 -> 195
    //   195: aload_0
    //   196: ifnull +6 -> 202
    //   199: goto -26 -> 173
    //   202: iconst_0
    //   203: ireturn
    //   204: astore_0
    //   205: goto -26 -> 179
    //   208: astore_0
    //   209: goto -56 -> 153
    //   212: astore_0
    //   213: goto -92 -> 121
    //   216: astore_0
    //   217: goto -102 -> 115
    //   220: astore 4
    //   222: goto -114 -> 108
    //   225: astore 4
    //   227: goto -122 -> 105
    //   230: astore_1
    //   231: goto -143 -> 88
    //   234: astore_0
    //   235: iload_3
    //   236: ireturn
    //   237: astore_1
    //   238: goto -97 -> 141
    //   241: astore_1
    //   242: goto -91 -> 151
    //   245: astore_1
    //   246: goto -77 -> 169
    //   249: astore_1
    //   250: goto -55 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramFile1	File
    //   0	253	1	paramFile2	File
    //   61	11	2	i	int
    //   1	235	3	bool	boolean
    //   9	138	4	localObject1	Object
    //   220	1	4	localIOException	IOException
    //   225	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   3	1	5	localObject2	Object
    //   94	62	5	localObject3	Object
    //   6	176	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   48	55	94	finally
    //   55	62	94	finally
    //   67	79	94	finally
    //   32	48	111	finally
    //   11	23	127	finally
    //   23	32	127	finally
    //   11	23	204	java/io/IOException
    //   23	32	204	java/io/IOException
    //   11	23	208	java/lang/OutOfMemoryError
    //   23	32	208	java/lang/OutOfMemoryError
    //   32	48	212	java/io/IOException
    //   32	48	216	java/lang/OutOfMemoryError
    //   48	55	220	java/io/IOException
    //   55	62	220	java/io/IOException
    //   67	79	220	java/io/IOException
    //   48	55	225	java/lang/OutOfMemoryError
    //   55	62	225	java/lang/OutOfMemoryError
    //   67	79	225	java/lang/OutOfMemoryError
    //   84	88	230	java/io/IOException
    //   88	92	234	java/io/IOException
    //   173	177	234	java/io/IOException
    //   134	138	237	java/io/IOException
    //   146	151	241	java/io/IOException
    //   162	166	245	java/io/IOException
    //   188	192	249	java/io/IOException
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (paramString1.exists()) {}
    try
    {
      boolean bool = copyFile(paramString1, createFile(paramString2));
      return bool;
    }
    catch (IOException paramString1)
    {
      label27:
      break label27;
    }
    return false;
  }
  
  public static File createFile(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      if ((paramString.getParentFile() != null) && (!paramString.getParentFile().exists()))
      {
        if (paramString.getParentFile().mkdirs())
        {
          paramString.createNewFile();
          return paramString;
        }
      }
      else {
        paramString.createNewFile();
      }
    }
    return paramString;
  }
  
  public static long delete(String paramString, boolean paramBoolean)
  {
    long l = 0L;
    if (paramString == null) {
      return 0L;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return 0L;
    }
    if (paramString.isFile())
    {
      l = paramString.length();
      paramString.delete();
      return l;
    }
    File[] arrayOfFile = paramString.listFiles();
    if (arrayOfFile == null) {
      return 0L;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      l += delete(arrayOfFile[i].getAbsolutePath(), paramBoolean);
      i += 1;
    }
    if (!paramBoolean) {
      paramString.delete();
    }
    return l;
  }
  
  public static long deleteDirectory(String paramString)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramString != null)
    {
      if (paramString.trim().length() == 0) {
        return 0L;
      }
      paramString = new File(paramString);
      if (!paramString.exists()) {
        return 0L;
      }
      File[] arrayOfFile = paramString.listFiles();
      l2 = l1;
      if (arrayOfFile != null)
      {
        l2 = l1;
        if (arrayOfFile.length > 0)
        {
          int i = 0;
          for (;;)
          {
            l2 = l1;
            if (i >= arrayOfFile.length) {
              break;
            }
            if (arrayOfFile[i].isDirectory())
            {
              l1 += deleteDirectory(arrayOfFile[i].getAbsolutePath());
            }
            else
            {
              l1 += arrayOfFile[i].length();
              arrayOfFile[i].delete();
            }
            i += 1;
          }
        }
      }
      paramString.delete();
    }
    return l2;
  }
  
  public static boolean deleteFile(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          deleteFile(arrayOfFile[i]);
          i += 1;
        }
      }
    }
    return paramFile.delete();
  }
  
  public static boolean deleteFile(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString.delete();
    }
    return true;
  }
  
  public static long deleteFilesInDirectory(String paramString)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramString != null)
    {
      if (paramString.trim().length() == 0) {
        return 0L;
      }
      paramString = new File(paramString).listFiles();
      l2 = l1;
      if (paramString != null)
      {
        l2 = l1;
        if (paramString.length > 0)
        {
          int i = 0;
          for (;;)
          {
            l2 = l1;
            if (i >= paramString.length) {
              break;
            }
            if (paramString[i].isDirectory())
            {
              l1 += deleteDirectory(paramString[i].getAbsolutePath());
            }
            else
            {
              l1 += paramString[i].length();
              paramString[i].delete();
            }
            i += 1;
          }
        }
      }
    }
    return l2;
  }
  
  public static void deleteSubFile(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if ((paramFile != null) && (paramFile.length > 0))
      {
        int i = 0;
        while (i < paramFile.length)
        {
          deleteFile(paramFile[i]);
          i += 1;
        }
      }
    }
  }
  
  public static boolean fileExists(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  /* Error */
  public static byte[] fileToBytes(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 36	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 87	java/io/BufferedInputStream
    //   12: dup
    //   13: new 89	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: invokespecial 93	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore 6
    //   26: aload 6
    //   28: astore 5
    //   30: aload_0
    //   31: invokevirtual 124	java/io/File:length	()J
    //   34: lstore_3
    //   35: lload_3
    //   36: ldc2_w 160
    //   39: lcmp
    //   40: ifgt +141 -> 181
    //   43: lload_3
    //   44: lconst_0
    //   45: lcmp
    //   46: ifgt +6 -> 52
    //   49: goto +132 -> 181
    //   52: aload 6
    //   54: astore 5
    //   56: lload_3
    //   57: l2i
    //   58: newarray byte
    //   60: astore 7
    //   62: iconst_0
    //   63: istore_1
    //   64: aload 6
    //   66: astore 5
    //   68: iload_1
    //   69: aload 7
    //   71: arraylength
    //   72: if_icmpge +32 -> 104
    //   75: aload 6
    //   77: astore 5
    //   79: aload 6
    //   81: aload 7
    //   83: iload_1
    //   84: aload 7
    //   86: arraylength
    //   87: iload_1
    //   88: isub
    //   89: invokevirtual 164	java/io/InputStream:read	([BII)I
    //   92: istore_2
    //   93: iload_2
    //   94: iflt +10 -> 104
    //   97: iload_1
    //   98: iload_2
    //   99: iadd
    //   100: istore_1
    //   101: goto -37 -> 64
    //   104: aload 6
    //   106: astore 5
    //   108: iload_1
    //   109: aload 7
    //   111: arraylength
    //   112: if_icmpge +53 -> 165
    //   115: aload 6
    //   117: astore 5
    //   119: new 41	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   126: astore 8
    //   128: aload 6
    //   130: astore 5
    //   132: aload 8
    //   134: ldc 166
    //   136: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 6
    //   142: astore 5
    //   144: aload 8
    //   146: aload_0
    //   147: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 6
    //   153: astore 5
    //   155: ldc 8
    //   157: aload 8
    //   159: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 172	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload 6
    //   167: invokevirtual 173	java/io/InputStream:close	()V
    //   170: aload 7
    //   172: areturn
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 176	java/lang/Throwable:printStackTrace	()V
    //   178: aload 7
    //   180: areturn
    //   181: aload 6
    //   183: astore 5
    //   185: new 41	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   192: astore 7
    //   194: aload 6
    //   196: astore 5
    //   198: aload 7
    //   200: ldc 178
    //   202: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 6
    //   208: astore 5
    //   210: aload 7
    //   212: lload_3
    //   213: invokevirtual 181	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 6
    //   219: astore 5
    //   221: ldc 8
    //   223: aload 7
    //   225: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 172	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload 6
    //   233: invokevirtual 173	java/io/InputStream:close	()V
    //   236: aconst_null
    //   237: areturn
    //   238: astore_0
    //   239: aload_0
    //   240: invokevirtual 176	java/lang/Throwable:printStackTrace	()V
    //   243: aconst_null
    //   244: areturn
    //   245: astore_0
    //   246: aconst_null
    //   247: astore 5
    //   249: goto +76 -> 325
    //   252: aconst_null
    //   253: astore 6
    //   255: aload 6
    //   257: astore 5
    //   259: new 41	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   266: astore 7
    //   268: aload 6
    //   270: astore 5
    //   272: aload 7
    //   274: ldc 183
    //   276: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 6
    //   282: astore 5
    //   284: aload 7
    //   286: aload_0
    //   287: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 6
    //   293: astore 5
    //   295: ldc 8
    //   297: aload 7
    //   299: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 172	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload 6
    //   307: ifnull +15 -> 322
    //   310: aload 6
    //   312: invokevirtual 173	java/io/InputStream:close	()V
    //   315: aconst_null
    //   316: areturn
    //   317: astore_0
    //   318: aload_0
    //   319: invokevirtual 176	java/lang/Throwable:printStackTrace	()V
    //   322: aconst_null
    //   323: areturn
    //   324: astore_0
    //   325: aload 5
    //   327: ifnull +18 -> 345
    //   330: aload 5
    //   332: invokevirtual 173	java/io/InputStream:close	()V
    //   335: goto +10 -> 345
    //   338: astore 5
    //   340: aload 5
    //   342: invokevirtual 176	java/lang/Throwable:printStackTrace	()V
    //   345: goto +5 -> 350
    //   348: aload_0
    //   349: athrow
    //   350: goto -2 -> 348
    //   353: astore 5
    //   355: goto -103 -> 252
    //   358: astore 5
    //   360: goto -105 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	paramFile	File
    //   63	50	1	i	int
    //   92	8	2	j	int
    //   34	179	3	l	long
    //   28	303	5	localBufferedInputStream1	java.io.BufferedInputStream
    //   338	3	5	localThrowable1	Throwable
    //   353	1	5	localThrowable2	Throwable
    //   358	1	5	localThrowable3	Throwable
    //   24	287	6	localBufferedInputStream2	java.io.BufferedInputStream
    //   60	238	7	localObject	Object
    //   126	32	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   165	170	173	java/lang/Throwable
    //   231	236	238	java/lang/Throwable
    //   9	26	245	finally
    //   310	315	317	java/lang/Throwable
    //   30	35	324	finally
    //   56	62	324	finally
    //   68	75	324	finally
    //   79	93	324	finally
    //   108	115	324	finally
    //   119	128	324	finally
    //   132	140	324	finally
    //   144	151	324	finally
    //   155	165	324	finally
    //   185	194	324	finally
    //   198	206	324	finally
    //   210	217	324	finally
    //   221	231	324	finally
    //   259	268	324	finally
    //   272	280	324	finally
    //   284	291	324	finally
    //   295	305	324	finally
    //   330	335	338	java/lang/Throwable
    //   9	26	353	java/lang/Throwable
    //   30	35	358	java/lang/Throwable
    //   56	62	358	java/lang/Throwable
    //   68	75	358	java/lang/Throwable
    //   79	93	358	java/lang/Throwable
    //   108	115	358	java/lang/Throwable
    //   119	128	358	java/lang/Throwable
    //   132	140	358	java/lang/Throwable
    //   144	151	358	java/lang/Throwable
    //   155	165	358	java/lang/Throwable
    //   185	194	358	java/lang/Throwable
    //   198	206	358	java/lang/Throwable
    //   210	217	358	java/lang/Throwable
    //   221	231	358	java/lang/Throwable
  }
  
  public static ArrayList<String> getChildFiles(String paramString, boolean paramBoolean)
  {
    Object localObject = new File(paramString);
    paramString = new ArrayList();
    localObject = ((File)localObject).listFiles();
    int i = 0;
    try
    {
      int j = localObject.length;
      while (i < j)
      {
        if (localObject[i].isDirectory())
        {
          if (paramBoolean) {
            paramString.add(localObject[i].getCanonicalPath());
          }
          paramString.addAll(getChildFiles(localObject[i].getCanonicalPath(), paramBoolean));
        }
        else
        {
          paramString.add(localObject[i].getCanonicalPath());
        }
        i += 1;
      }
      StringBuilder localStringBuilder;
      return paramString;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getChildFiles error. ");
      localStringBuilder.append(localException);
      QMLog.e("FileUtils.getChildFiles", localStringBuilder.toString());
    }
  }
  
  public static String getExtension(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.endsWith(".rename") == true)
    {
      String str = paramString.replace(".rename", "");
      i = str.lastIndexOf(".");
      if (i == -1) {
        return "";
      }
      if (str.substring(i).replaceAll("[0-9]*", "").replace("(", "").replace(")", "").equalsIgnoreCase(".apk") == true) {
        return ".apk.rename";
      }
    }
    int i = paramString.lastIndexOf(".");
    if (i >= 0) {
      return paramString.substring(i);
    }
    return "";
  }
  
  public static long getFileOrFolderSize(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    long l1 = 0L;
    if (bool)
    {
      QMLog.e("FileUtils", "getFileOrFolderSize error, path is empty, please check");
      return 0L;
    }
    paramString = new File(paramString);
    long l2 = l1;
    if (paramString.exists())
    {
      if (paramString.isFile()) {
        return paramString.length();
      }
      l2 = l1;
      if (paramString.isDirectory())
      {
        paramString = paramString.listFiles();
        l2 = l1;
        if (paramString != null)
        {
          if (paramString.length <= 0) {
            return 0L;
          }
          int j = paramString.length;
          int i = 0;
          for (;;)
          {
            l2 = l1;
            if (i >= j) {
              break;
            }
            Object localObject = paramString[i];
            l2 = l1;
            if (localObject != null)
            {
              l2 = l1;
              if (localObject.exists())
              {
                if (localObject.isDirectory()) {}
                for (l2 = getFileOrFolderSize(localObject.getAbsolutePath());; l2 = localObject.length())
                {
                  l2 = l1 + l2;
                  break;
                  l2 = l1;
                  if (!localObject.isFile()) {
                    break;
                  }
                }
              }
            }
            i += 1;
            l1 = l2;
          }
        }
      }
    }
    return l2;
  }
  
  public static long getFileSizes(String paramString)
  {
    try
    {
      long l = new File(paramString).length();
      return l;
    }
    catch (Exception paramString)
    {
      label14:
      break label14;
    }
    return 0L;
  }
  
  public static ArrayList<FileInfo> getFiles(String paramString, boolean paramBoolean, int paramInt)
  {
    try
    {
      paramString = new File(paramString).listFiles();
      if (paramString == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length)
      {
        Object localObject = paramString[i];
        if (((paramBoolean) || (!localObject.getName().startsWith("."))) && ((localObject.isDirectory()) || (localObject.length() != 0L)))
        {
          FileInfo localFileInfo = new FileInfo();
          localFileInfo.setName(localObject.getName());
          localFileInfo.setDirectory(localObject.isDirectory());
          localFileInfo.setPath(localObject.getPath());
          localFileInfo.setSize(localObject.length());
          localFileInfo.setDate(localObject.lastModified());
          localArrayList.add(localFileInfo);
        }
        i += 1;
      }
      if (paramInt == 0)
      {
        Collections.sort(localArrayList, new FileUtils.MyFileCompare());
        return localArrayList;
      }
      Collections.sort(localArrayList, new FileCompare());
      return localArrayList;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static JSONObject getStats(String paramString)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        paramString = Os.stat(paramString);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("mode", paramString.st_mode);
        ((JSONObject)localObject).put("size", paramString.st_size);
        ((JSONObject)localObject).put("lastAccessedTime", paramString.st_atime);
        ((JSONObject)localObject).put("lastModifiedTime", paramString.st_mtime);
        return localObject;
      }
      catch (Exception paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getStats error. ");
        ((StringBuilder)localObject).append(paramString);
        QMLog.e("FileUtils.getStats", ((StringBuilder)localObject).toString());
      }
    } else {
      try
      {
        paramString = new File(paramString);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("mode", 0);
        ((JSONObject)localObject).put("size", paramString.length());
        ((JSONObject)localObject).put("lastAccessedTime", paramString.lastModified());
        ((JSONObject)localObject).put("lastModifiedTime", paramString.lastModified());
        return localObject;
      }
      catch (Exception paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getStats error. ");
        ((StringBuilder)localObject).append(paramString);
        QMLog.e("FileUtils.getStats", ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public static JSONObject getStatsByDir(String paramString)
  {
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("/", getStats(paramString));
      Object localObject2 = getChildFiles(paramString, true);
      paramString = new File(paramString);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString.getCanonicalPath());
      ((StringBuilder)localObject3).append("/");
      paramString = ((StringBuilder)localObject3).toString();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        ((JSONObject)localObject1).put(((String)localObject3).replace(paramString, ""), getStats((String)localObject3));
      }
      return localObject1;
    }
    catch (Exception paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getStatsByDir error. ");
      ((StringBuilder)localObject1).append(paramString);
      QMLog.e("FileUtils.getStatsByDir", ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  public static Uri getUriForFile(Context paramContext, File paramFile)
  {
    if (isTargetBeyondN(paramContext)) {
      return getUriForFile24(paramContext, paramFile);
    }
    return Uri.fromFile(paramFile);
  }
  
  private static Uri getUriForFile24(Context paramContext, File paramFile)
  {
    if (sAuthority == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getApplicationContext().getPackageName());
      localStringBuilder.append(".fileprovider");
      sAuthority = localStringBuilder.toString();
    }
    return FileProvider.getUriForFile(paramContext, sAuthority, paramFile);
  }
  
  public static void isFileValied(File paramFile)
  {
    if (paramFile.exists())
    {
      if (!paramFile.isDirectory())
      {
        if (paramFile.canRead()) {
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("File '");
        localStringBuilder.append(paramFile);
        localStringBuilder.append("' cannot be read");
        throw new IOException(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("File '");
      localStringBuilder.append(paramFile);
      localStringBuilder.append("' exists but is a directory");
      throw new IOException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("File '");
    localStringBuilder.append(paramFile);
    localStringBuilder.append("' does not exist");
    throw new FileNotFoundException(localStringBuilder.toString());
  }
  
  public static boolean isTargetBeyondN(Context paramContext)
  {
    if (sIsTargetThanN == null)
    {
      boolean bool;
      if ((Build.VERSION.SDK_INT >= 24) && (paramContext.getApplicationContext().getApplicationInfo().targetSdkVersion >= 24)) {
        bool = true;
      } else {
        bool = false;
      }
      sIsTargetThanN = Boolean.valueOf(bool);
    }
    return sIsTargetThanN.booleanValue();
  }
  
  /* Error */
  public static String readFileFromAssets(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 461	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: aload_1
    //   5: invokevirtual 467	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokevirtual 470	java/io/InputStream:available	()I
    //   15: newarray byte
    //   17: astore_2
    //   18: aload_1
    //   19: astore_0
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 66	java/io/InputStream:read	([B)I
    //   25: pop
    //   26: aload_1
    //   27: astore_0
    //   28: new 137	java/lang/String
    //   31: dup
    //   32: aload_2
    //   33: ldc_w 472
    //   36: invokespecial 475	java/lang/String:<init>	([BLjava/lang/String;)V
    //   39: astore_2
    //   40: aload_1
    //   41: ifnull +41 -> 82
    //   44: aload_1
    //   45: invokevirtual 173	java/io/InputStream:close	()V
    //   48: aload_2
    //   49: areturn
    //   50: astore_0
    //   51: new 41	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   58: astore_1
    //   59: aload_1
    //   60: ldc_w 477
    //   63: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_1
    //   68: aload_0
    //   69: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: ldc 8
    //   75: aload_1
    //   76: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 210	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_2
    //   83: areturn
    //   84: astore_1
    //   85: goto +99 -> 184
    //   88: astore_2
    //   89: goto +12 -> 101
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_0
    //   95: goto +89 -> 184
    //   98: astore_2
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_1
    //   102: astore_0
    //   103: new 41	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   110: astore_3
    //   111: aload_1
    //   112: astore_0
    //   113: aload_3
    //   114: ldc_w 479
    //   117: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_1
    //   122: astore_0
    //   123: aload_3
    //   124: aload_2
    //   125: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload_1
    //   130: astore_0
    //   131: ldc 8
    //   133: aload_3
    //   134: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 210	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload_1
    //   141: ifnull +41 -> 182
    //   144: aload_1
    //   145: invokevirtual 173	java/io/InputStream:close	()V
    //   148: aconst_null
    //   149: areturn
    //   150: astore_0
    //   151: new 41	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   158: astore_1
    //   159: aload_1
    //   160: ldc_w 477
    //   163: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_1
    //   168: aload_0
    //   169: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: ldc 8
    //   175: aload_1
    //   176: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 210	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aconst_null
    //   183: areturn
    //   184: aload_0
    //   185: ifnull +42 -> 227
    //   188: aload_0
    //   189: invokevirtual 173	java/io/InputStream:close	()V
    //   192: goto +35 -> 227
    //   195: astore_0
    //   196: new 41	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   203: astore_2
    //   204: aload_2
    //   205: ldc_w 477
    //   208: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_2
    //   213: aload_0
    //   214: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: ldc 8
    //   220: aload_2
    //   221: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 210	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload_1
    //   228: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	paramContext	Context
    //   0	229	1	paramString	String
    //   17	66	2	localObject	Object
    //   88	1	2	localException1	Exception
    //   98	27	2	localException2	Exception
    //   203	18	2	localStringBuilder1	StringBuilder
    //   110	24	3	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   44	48	50	java/io/IOException
    //   11	18	84	finally
    //   20	26	84	finally
    //   28	40	84	finally
    //   103	111	84	finally
    //   113	121	84	finally
    //   123	129	84	finally
    //   131	140	84	finally
    //   11	18	88	java/lang/Exception
    //   20	26	88	java/lang/Exception
    //   28	40	88	java/lang/Exception
    //   0	9	92	finally
    //   0	9	98	java/lang/Exception
    //   144	148	150	java/io/IOException
    //   188	192	195	java/io/IOException
  }
  
  public static String readFileToStr(File paramFile)
  {
    if (paramFile != null) {
      try
      {
        if (paramFile.exists())
        {
          paramFile = readFileToString(paramFile);
          return paramFile;
        }
      }
      catch (Throwable paramFile)
      {
        paramFile.printStackTrace();
        return "";
      }
    }
    return null;
  }
  
  /* Error */
  public static String readFileToString(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokestatic 486	com/tencent/qqmini/sdk/core/utils/FileUtils:isFileValied	(Ljava/io/File;)V
    //   13: new 89	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: astore_3
    //   22: new 488	java/io/InputStreamReader
    //   25: dup
    //   26: aload_3
    //   27: ldc_w 490
    //   30: invokespecial 493	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   33: astore_2
    //   34: aload_0
    //   35: invokevirtual 124	java/io/File:length	()J
    //   38: l2i
    //   39: istore_1
    //   40: iload_1
    //   41: sipush 12288
    //   44: if_icmple +53 -> 97
    //   47: sipush 4096
    //   50: newarray char
    //   52: astore_0
    //   53: new 41	java/lang/StringBuilder
    //   56: dup
    //   57: sipush 12288
    //   60: invokespecial 496	java/lang/StringBuilder:<init>	(I)V
    //   63: astore 5
    //   65: aload_2
    //   66: aload_0
    //   67: invokevirtual 499	java/io/InputStreamReader:read	([C)I
    //   70: istore_1
    //   71: iconst_m1
    //   72: iload_1
    //   73: if_icmpeq +15 -> 88
    //   76: aload 5
    //   78: aload_0
    //   79: iconst_0
    //   80: iload_1
    //   81: invokevirtual 502	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: goto -20 -> 65
    //   88: aload 5
    //   90: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_0
    //   94: goto +22 -> 116
    //   97: iload_1
    //   98: newarray char
    //   100: astore_0
    //   101: new 137	java/lang/String
    //   104: dup
    //   105: aload_0
    //   106: iconst_0
    //   107: aload_2
    //   108: aload_0
    //   109: invokevirtual 499	java/io/InputStreamReader:read	([C)I
    //   112: invokespecial 505	java/lang/String:<init>	([CII)V
    //   115: astore_0
    //   116: aload_3
    //   117: invokevirtual 173	java/io/InputStream:close	()V
    //   120: aload_0
    //   121: astore_3
    //   122: aload_2
    //   123: invokevirtual 506	java/io/InputStreamReader:close	()V
    //   126: aload_3
    //   127: areturn
    //   128: astore_0
    //   129: goto +24 -> 153
    //   132: aload_2
    //   133: astore_0
    //   134: goto +44 -> 178
    //   137: astore_0
    //   138: aconst_null
    //   139: astore_2
    //   140: goto +13 -> 153
    //   143: aconst_null
    //   144: astore_0
    //   145: goto +33 -> 178
    //   148: astore_0
    //   149: aconst_null
    //   150: astore_3
    //   151: aload_3
    //   152: astore_2
    //   153: aload_3
    //   154: ifnull +10 -> 164
    //   157: aload_3
    //   158: invokevirtual 173	java/io/InputStream:close	()V
    //   161: goto +3 -> 164
    //   164: aload_2
    //   165: ifnull +7 -> 172
    //   168: aload_2
    //   169: invokevirtual 506	java/io/InputStreamReader:close	()V
    //   172: aload_0
    //   173: athrow
    //   174: aconst_null
    //   175: astore_3
    //   176: aload_3
    //   177: astore_0
    //   178: aload_3
    //   179: ifnull +10 -> 189
    //   182: aload_3
    //   183: invokevirtual 173	java/io/InputStream:close	()V
    //   186: goto +3 -> 189
    //   189: aload_0
    //   190: ifnull +11 -> 201
    //   193: aload 4
    //   195: astore_3
    //   196: aload_0
    //   197: astore_2
    //   198: goto -76 -> 122
    //   201: aconst_null
    //   202: areturn
    //   203: astore_0
    //   204: goto -30 -> 174
    //   207: astore_0
    //   208: goto -65 -> 143
    //   211: astore_0
    //   212: goto -80 -> 132
    //   215: astore_3
    //   216: aload_0
    //   217: astore_3
    //   218: goto -96 -> 122
    //   221: astore_0
    //   222: aload_3
    //   223: areturn
    //   224: astore_3
    //   225: goto -61 -> 164
    //   228: astore_2
    //   229: goto -57 -> 172
    //   232: astore_2
    //   233: goto -44 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramFile	File
    //   39	59	1	i	int
    //   33	165	2	localObject1	Object
    //   228	1	2	localException1	Exception
    //   232	1	2	localException2	Exception
    //   21	175	3	localObject2	Object
    //   215	1	3	localException3	Exception
    //   217	6	3	localFile	File
    //   224	1	3	localException4	Exception
    //   1	193	4	localObject3	Object
    //   63	26	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   34	40	128	finally
    //   47	65	128	finally
    //   65	71	128	finally
    //   76	85	128	finally
    //   88	94	128	finally
    //   97	116	128	finally
    //   22	34	137	finally
    //   13	22	148	finally
    //   13	22	203	java/lang/Exception
    //   22	34	207	java/lang/Exception
    //   34	40	211	java/lang/Exception
    //   47	65	211	java/lang/Exception
    //   65	71	211	java/lang/Exception
    //   76	85	211	java/lang/Exception
    //   88	94	211	java/lang/Exception
    //   97	116	211	java/lang/Exception
    //   116	120	215	java/lang/Exception
    //   122	126	221	java/lang/Exception
    //   157	161	224	java/lang/Exception
    //   168	172	228	java/lang/Exception
    //   182	186	232	java/lang/Exception
  }
  
  public static boolean rename(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      paramString1 = new File(paramString1);
      bool1 = bool2;
      if (paramString1.exists()) {
        bool1 = paramString1.renameTo(new File(paramString2));
      }
    }
    return bool1;
  }
  
  public static boolean renameFile(File paramFile1, File paramFile2)
  {
    boolean bool1;
    if (paramFile2.exists()) {
      bool1 = paramFile2.delete();
    } else {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = paramFile1.renameTo(paramFile2);
    }
    return bool2;
  }
  
  public static boolean renameFile(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return renameFile(new File(paramString1), new File(paramString2));
    }
    return false;
  }
  
  public static boolean saveVideoToAlbum(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {
      return false;
    }
    paramString2 = new File(paramString2);
    String str = paramString2.getParent();
    if (str != null) {
      checkDirAndCreate(str);
    }
    boolean bool = copyFile(paramString1, paramString2);
    paramString1 = new StringBuilder();
    paramString1.append("saveVideoToAlbum: ");
    paramString1.append(bool);
    QMLog.i("FileUtils", paramString1.toString());
    broadcastCarmera(paramContext, paramString2);
    return true;
  }
  
  public static boolean writeFile(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {}
    try
    {
      paramString1.createNewFile();
    }
    catch (IOException localIOException)
    {
      label24:
      boolean bool2;
      break label24;
    }
    bool2 = false;
    break label31;
    bool2 = true;
    try
    {
      label31:
      paramString1 = new FileOutputStream(paramString1, false);
    }
    catch (FileNotFoundException paramString1)
    {
      label44:
      boolean bool1;
      break label44;
    }
    paramString1 = null;
    bool2 = false;
    bool1 = bool2;
    if (paramString1 != null) {}
    try
    {
      paramString1.write(paramString2.getBytes());
      bool1 = bool2;
    }
    catch (IOException paramString2)
    {
      label67:
      break label67;
    }
    bool1 = false;
    bool2 = bool1;
    if (paramString1 != null) {}
    try
    {
      paramString1.flush();
      bool2 = bool1;
    }
    catch (IOException paramString2)
    {
      label84:
      break label84;
    }
    bool2 = false;
    bool1 = bool2;
    if (paramString1 != null) {}
    try
    {
      paramString1.close();
      return bool2;
    }
    catch (IOException paramString1)
    {
      label98:
      break label98;
    }
    bool1 = false;
    return bool1;
  }
  
  public static boolean writeFile(String paramString, byte[] paramArrayOfByte)
  {
    return writeFile(paramString, paramArrayOfByte, false);
  }
  
  public static boolean writeFile(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return writeFile(paramString, paramArrayOfByte, paramBoolean, paramArrayOfByte.length);
  }
  
  /* Error */
  public static boolean writeFile(String paramString, byte[] paramArrayOfByte, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: new 29	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 32	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 4
    //   15: aload_0
    //   16: invokevirtual 36	java/io/File:exists	()Z
    //   19: ifne +26 -> 45
    //   22: aload_0
    //   23: invokevirtual 113	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 36	java/io/File:exists	()Z
    //   29: ifne +11 -> 40
    //   32: aload_0
    //   33: invokevirtual 113	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 39	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_0
    //   41: invokevirtual 116	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: new 82	java/io/FileOutputStream
    //   48: dup
    //   49: aload_0
    //   50: iload_2
    //   51: invokespecial 534	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   54: astore_0
    //   55: aload_0
    //   56: aload_1
    //   57: iconst_0
    //   58: iload_3
    //   59: invokevirtual 95	java/io/FileOutputStream:write	([BII)V
    //   62: aload_0
    //   63: invokevirtual 98	java/io/FileOutputStream:flush	()V
    //   66: aload_0
    //   67: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   70: iconst_1
    //   71: ireturn
    //   72: astore 4
    //   74: aload_0
    //   75: astore_1
    //   76: aload 4
    //   78: astore_0
    //   79: goto +10 -> 89
    //   82: goto +17 -> 99
    //   85: astore_0
    //   86: aload 4
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +7 -> 97
    //   93: aload_1
    //   94: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   97: aload_0
    //   98: athrow
    //   99: aload_0
    //   100: ifnull +7 -> 107
    //   103: aload_0
    //   104: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   107: iconst_0
    //   108: ireturn
    //   109: astore_0
    //   110: aload 5
    //   112: astore_0
    //   113: goto -14 -> 99
    //   116: astore_1
    //   117: goto -35 -> 82
    //   120: astore_0
    //   121: iconst_0
    //   122: ireturn
    //   123: astore_1
    //   124: goto -27 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramString	String
    //   0	127	1	paramArrayOfByte	byte[]
    //   0	127	2	paramBoolean	boolean
    //   0	127	3	paramInt	int
    //   13	1	4	localObject1	Object
    //   72	15	4	localObject2	Object
    //   10	101	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   55	66	72	finally
    //   15	40	85	finally
    //   40	45	85	finally
    //   45	55	85	finally
    //   15	40	109	java/io/IOException
    //   40	45	109	java/io/IOException
    //   45	55	109	java/io/IOException
    //   55	66	116	java/io/IOException
    //   66	70	120	java/io/IOException
    //   103	107	120	java/io/IOException
    //   93	97	123	java/io/IOException
  }
  
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString)
  {
    return writeFile(paramArrayOfByte, paramString, false);
  }
  
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    return writeFile(paramArrayOfByte, paramString, paramBoolean, paramArrayOfByte.length);
  }
  
  /* Error */
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: new 29	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 32	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 4
    //   15: aload_1
    //   16: invokevirtual 36	java/io/File:exists	()Z
    //   19: ifne +26 -> 45
    //   22: aload_1
    //   23: invokevirtual 113	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 36	java/io/File:exists	()Z
    //   29: ifne +11 -> 40
    //   32: aload_1
    //   33: invokevirtual 113	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 39	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_1
    //   41: invokevirtual 116	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: new 82	java/io/FileOutputStream
    //   48: dup
    //   49: aload_1
    //   50: iload_2
    //   51: invokespecial 534	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   54: astore_1
    //   55: aload_1
    //   56: aload_0
    //   57: iconst_0
    //   58: iload_3
    //   59: invokevirtual 95	java/io/FileOutputStream:write	([BII)V
    //   62: aload_1
    //   63: invokevirtual 98	java/io/FileOutputStream:flush	()V
    //   66: aload_1
    //   67: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   70: iconst_1
    //   71: ireturn
    //   72: astore_0
    //   73: goto +10 -> 83
    //   76: goto +17 -> 93
    //   79: astore_0
    //   80: aload 4
    //   82: astore_1
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   91: aload_0
    //   92: athrow
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   101: iconst_0
    //   102: ireturn
    //   103: astore_0
    //   104: aload 5
    //   106: astore_1
    //   107: goto -14 -> 93
    //   110: astore_0
    //   111: goto -35 -> 76
    //   114: astore_0
    //   115: iconst_0
    //   116: ireturn
    //   117: astore_1
    //   118: goto -27 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramArrayOfByte	byte[]
    //   0	121	1	paramString	String
    //   0	121	2	paramBoolean	boolean
    //   0	121	3	paramInt	int
    //   13	68	4	localObject1	Object
    //   10	95	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   55	66	72	finally
    //   15	40	79	finally
    //   40	45	79	finally
    //   45	55	79	finally
    //   15	40	103	java/io/IOException
    //   40	45	103	java/io/IOException
    //   45	55	103	java/io/IOException
    //   55	66	110	java/io/IOException
    //   66	70	114	java/io/IOException
    //   97	101	114	java/io/IOException
    //   87	91	117	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */