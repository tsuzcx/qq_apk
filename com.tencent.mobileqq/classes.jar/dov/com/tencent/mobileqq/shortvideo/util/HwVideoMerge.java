package dov.com.tencent.mobileqq.shortvideo.util;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@TargetApi(18)
public class HwVideoMerge
{
  private int jdField_a_of_type_Int;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  private HwVideoMerge.SampaleData jdField_a_of_type_DovComTencentMobileqqShortvideoUtilHwVideoMerge$SampaleData = new HwVideoMerge.SampaleData(null);
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private MediaExtractor jdField_b_of_type_AndroidMediaMediaExtractor;
  private String jdField_b_of_type_JavaLangString;
  
  public HwVideoMerge(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  private int a()
  {
    int i = 0;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilHwVideoMerge$SampaleData.jdField_a_of_type_JavaNioByteBuffer.position(0);
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilHwVideoMerge$SampaleData.jdField_a_of_type_JavaNioByteBuffer, 0) <= 0)
    {
      a();
      i = -5;
    }
    do
    {
      return i;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilHwVideoMerge$SampaleData.jdField_a_of_type_JavaNioByteBuffer.position(0);
    } while (this.jdField_b_of_type_AndroidMediaMediaExtractor.readSampleData(this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilHwVideoMerge$SampaleData.jdField_a_of_type_JavaNioByteBuffer, 0) > 0);
    a();
    return -6;
  }
  
  private static int a(String paramString1, String paramString2)
  {
    return a(new ArrayList(Arrays.asList(new String[] { "-i", paramString1, "-c", "copy", paramString2 })));
  }
  
  public static final int a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    return b(paramString1, paramString2, paramString3, paramInt);
  }
  
  /* Error */
  private static int a(List<String> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +12 -> 13
    //   4: aload_0
    //   5: invokeinterface 88 1 0
    //   10: ifne +8 -> 18
    //   13: bipush 247
    //   15: istore_1
    //   16: iload_1
    //   17: ireturn
    //   18: invokestatic 94	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   21: invokestatic 99	dov/com/tencent/mobileqq/shortvideo/util/FileFFmpegUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   24: astore 4
    //   26: new 101	java/io/File
    //   29: dup
    //   30: aload 4
    //   32: invokespecial 104	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 108	java/io/File:exists	()Z
    //   42: ifeq +200 -> 242
    //   45: aload 5
    //   47: iconst_1
    //   48: iconst_1
    //   49: invokevirtual 112	java/io/File:setExecutable	(ZZ)Z
    //   52: istore_3
    //   53: new 114	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   60: ldc 117
    //   62: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: iload_3
    //   66: invokevirtual 124	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   69: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: aconst_null
    //   73: invokestatic 131	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: aload_0
    //   77: iconst_0
    //   78: aload 4
    //   80: invokeinterface 135 3 0
    //   85: aload_0
    //   86: iconst_1
    //   87: ldc 137
    //   89: invokeinterface 135 3 0
    //   94: aload_0
    //   95: iconst_2
    //   96: ldc 139
    //   98: invokeinterface 135 3 0
    //   103: aload_0
    //   104: iconst_3
    //   105: ldc 141
    //   107: invokeinterface 135 3 0
    //   112: aload_0
    //   113: iconst_4
    //   114: ldc 143
    //   116: invokeinterface 135 3 0
    //   121: aload_0
    //   122: invokestatic 94	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   125: invokestatic 145	dov/com/tencent/mobileqq/shortvideo/util/FileFFmpegUtils:b	(Landroid/content/Context;)Ljava/lang/String;
    //   128: invokeinterface 148 2 0
    //   133: pop
    //   134: new 150	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream
    //   137: dup
    //   138: aconst_null
    //   139: invokespecial 151	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream:<init>	(Ldov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge$1;)V
    //   142: astore 4
    //   144: new 153	java/lang/ProcessBuilder
    //   147: dup
    //   148: iconst_0
    //   149: anewarray 58	java/lang/String
    //   152: invokespecial 156	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   155: astore 5
    //   157: aload 5
    //   159: iconst_1
    //   160: invokevirtual 160	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   163: pop
    //   164: aload 5
    //   166: aload_0
    //   167: invokevirtual 164	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   170: pop
    //   171: aload 5
    //   173: invokevirtual 168	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   176: astore_0
    //   177: aload 4
    //   179: aload_0
    //   180: putfield 171	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream:a	Ljava/lang/Process;
    //   183: aload 4
    //   185: invokevirtual 172	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream:a	()V
    //   188: aload_0
    //   189: invokevirtual 177	java/lang/Process:waitFor	()I
    //   192: pop
    //   193: aload_0
    //   194: invokevirtual 180	java/lang/Process:exitValue	()I
    //   197: istore_2
    //   198: iload_2
    //   199: ifeq +26 -> 225
    //   202: new 114	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   209: ldc 182
    //   211: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload_2
    //   215: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: aconst_null
    //   222: invokestatic 131	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   225: aload 4
    //   227: invokevirtual 187	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream:b	()V
    //   230: iload_2
    //   231: istore_1
    //   232: aload_0
    //   233: ifnull -217 -> 16
    //   236: aload_0
    //   237: invokevirtual 190	java/lang/Process:destroy	()V
    //   240: iload_2
    //   241: ireturn
    //   242: bipush 244
    //   244: ireturn
    //   245: astore_0
    //   246: ldc 192
    //   248: aload_0
    //   249: invokestatic 131	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   252: bipush 245
    //   254: ireturn
    //   255: astore 5
    //   257: ldc 192
    //   259: aload 5
    //   261: invokestatic 131	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   264: goto -71 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramList	List<String>
    //   15	217	1	i	int
    //   197	44	2	j	int
    //   52	14	3	bool	boolean
    //   24	202	4	localObject1	Object
    //   35	137	5	localObject2	Object
    //   255	5	5	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   171	177	245	java/io/IOException
    //   188	193	255	java/lang/InterruptedException
  }
  
  private final MediaExtractor a(String paramString)
  {
    if (a(paramString)) {
      localMediaExtractor = new MediaExtractor();
    }
    try
    {
      localMediaExtractor.setDataSource(paramString);
      int i = localMediaExtractor.getTrackCount();
      if (i != 1) {
        localMediaExtractor.release();
      }
      return localMediaExtractor;
    }
    catch (IOException localIOException1)
    {
      try
      {
        b("createExtractor:invalid media file:numTracks=" + i + " path=" + paramString, null);
        return null;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localMediaExtractor = null;
        }
      }
      localIOException1 = localIOException1;
      b("createExtractor path:" + paramString, localIOException1);
      localMediaExtractor.release();
      return null;
    }
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
    if (this.jdField_b_of_type_AndroidMediaMediaExtractor != null)
    {
      this.jdField_b_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_b_of_type_AndroidMediaMediaExtractor = null;
    }
  }
  
  private boolean a(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString));
  }
  
  public static boolean a(List<String> paramList, String paramString, int paramInt)
  {
    String str1 = "concat:";
    int i = 0;
    String str2;
    if (i < paramList.size())
    {
      String str3 = (String)paramList.get(i);
      str2 = str1;
      if (i > 0) {
        str2 = str1 + "|";
      }
      str1 = str3.replace(".mp4", ".ts");
      int j = b(str3, str1);
      if (j != 0) {
        if (QLog.isColorLevel()) {
          QLog.e("HwVideoMerge", 2, "ffmpegMp4toTs fail, err: " + j);
        }
      }
    }
    do
    {
      return false;
      str1 = str2 + str1;
      i += 1;
      break;
      paramList = paramString.replace(".mp4", ".ts");
      i = a(str1, paramList);
      if (i == 0) {
        break label199;
      }
    } while (!QLog.isColorLevel());
    QLog.e("HwVideoMerge", 2, "ffmpegMergeTs fail, err: " + i);
    return false;
    label199:
    if (paramInt == 90) {
      i = 270;
    }
    for (;;)
    {
      paramInt = a(new ArrayList(Arrays.asList(new String[] { "-i", paramList, "-metadata:s", "rotate=" + i, "-vcodec", "copy", "-acodec", "copy", "-absf", "aac_adtstoasc", paramString })));
      if (paramInt == 0) {
        break label362;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("HwVideoMerge", 2, "ffmpegTstoMp4 fail, err: " + paramInt);
      return false;
      i = paramInt;
      if (paramInt == 270) {
        i = 90;
      }
    }
    label362:
    return true;
  }
  
  private static int b(String paramString, int paramInt)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = null;
      try
      {
        String str = localMediaMetadataRetriever.extractMetadata(24);
        paramString = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("HwVideoMerge", 2, localException, new Object[0]);
        }
      }
      localMediaMetadataRetriever.release();
      if (paramString == null) {
        return paramInt;
      }
      int i;
      return paramInt;
    }
    catch (IllegalArgumentException paramString)
    {
      try
      {
        i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException paramString) {}
      paramString = paramString;
      return paramInt;
    }
  }
  
  private static int b(String paramString1, String paramString2)
  {
    return a(new ArrayList(Arrays.asList(new String[] { "-i", paramString1, "-c", "copy", "-bsf:v", "h264_mp4toannexb", "-f", "mpegts", paramString2 })));
  }
  
  public static final int b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int j = new HwVideoMerge(paramString1, paramString2).a(null, paramInt);
    int i;
    if ((j == -2) || (j == -4) || (j == -6)) {
      if (new File(paramString1).renameTo(new File(paramString3))) {
        i = 0;
      }
    }
    do
    {
      return i;
      return -10;
      i = j;
    } while (j != -9);
    return c(paramString1, paramString2, paramString3, paramInt);
  }
  
  private static void b(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.d("HwVideoMerge", 2, paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d("HwVideoMerge", 2, paramString);
  }
  
  /* Error */
  private static int c(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 94	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   3: invokestatic 99	dov/com/tencent/mobileqq/shortvideo/util/FileFFmpegUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   6: astore 6
    //   8: new 101	java/io/File
    //   11: dup
    //   12: aload 6
    //   14: invokespecial 104	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 5
    //   19: aload 5
    //   21: invokevirtual 108	java/io/File:exists	()Z
    //   24: ifeq +324 -> 348
    //   27: aload 5
    //   29: iconst_1
    //   30: iconst_1
    //   31: invokevirtual 112	java/io/File:setExecutable	(ZZ)Z
    //   34: istore 4
    //   36: new 114	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   43: ldc 117
    //   45: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload 4
    //   50: invokevirtual 124	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: aconst_null
    //   57: invokestatic 131	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   60: aload_0
    //   61: iload_3
    //   62: invokestatic 322	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;I)I
    //   65: pop
    //   66: new 56	java/util/ArrayList
    //   69: dup
    //   70: invokespecial 323	java/util/ArrayList:<init>	()V
    //   73: astore 5
    //   75: aload 5
    //   77: aload 6
    //   79: invokeinterface 148 2 0
    //   84: pop
    //   85: aload 5
    //   87: ldc 137
    //   89: invokeinterface 148 2 0
    //   94: pop
    //   95: aload 5
    //   97: ldc 139
    //   99: invokeinterface 148 2 0
    //   104: pop
    //   105: aload 5
    //   107: ldc 141
    //   109: invokeinterface 148 2 0
    //   114: pop
    //   115: aload 5
    //   117: ldc 143
    //   119: invokeinterface 148 2 0
    //   124: pop
    //   125: aload 5
    //   127: ldc 60
    //   129: invokeinterface 148 2 0
    //   134: pop
    //   135: aload 5
    //   137: aload_0
    //   138: invokeinterface 148 2 0
    //   143: pop
    //   144: aload 5
    //   146: ldc 60
    //   148: invokeinterface 148 2 0
    //   153: pop
    //   154: aload 5
    //   156: aload_1
    //   157: invokeinterface 148 2 0
    //   162: pop
    //   163: aload 5
    //   165: ldc_w 261
    //   168: invokeinterface 148 2 0
    //   173: pop
    //   174: aload 5
    //   176: ldc 64
    //   178: invokeinterface 148 2 0
    //   183: pop
    //   184: aload 5
    //   186: ldc_w 263
    //   189: invokeinterface 148 2 0
    //   194: pop
    //   195: aload 5
    //   197: ldc 64
    //   199: invokeinterface 148 2 0
    //   204: pop
    //   205: aload 5
    //   207: aload_2
    //   208: invokeinterface 148 2 0
    //   213: pop
    //   214: aload 5
    //   216: invokestatic 94	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   219: invokestatic 145	dov/com/tencent/mobileqq/shortvideo/util/FileFFmpegUtils:b	(Landroid/content/Context;)Ljava/lang/String;
    //   222: invokeinterface 148 2 0
    //   227: pop
    //   228: new 150	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream
    //   231: dup
    //   232: aconst_null
    //   233: invokespecial 151	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream:<init>	(Ldov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge$1;)V
    //   236: astore_0
    //   237: new 153	java/lang/ProcessBuilder
    //   240: dup
    //   241: iconst_0
    //   242: anewarray 58	java/lang/String
    //   245: invokespecial 156	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   248: astore_1
    //   249: aload_1
    //   250: iconst_1
    //   251: invokevirtual 160	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   254: pop
    //   255: aload_1
    //   256: aload 5
    //   258: invokevirtual 164	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   261: pop
    //   262: aload_1
    //   263: invokevirtual 168	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   266: astore_1
    //   267: aload_0
    //   268: aload_1
    //   269: putfield 171	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream:a	Ljava/lang/Process;
    //   272: aload_0
    //   273: invokevirtual 172	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream:a	()V
    //   276: aload_1
    //   277: invokevirtual 177	java/lang/Process:waitFor	()I
    //   280: pop
    //   281: aload_1
    //   282: invokevirtual 180	java/lang/Process:exitValue	()I
    //   285: istore_3
    //   286: iload_3
    //   287: ifeq +47 -> 334
    //   290: new 101	java/io/File
    //   293: dup
    //   294: aload_2
    //   295: invokespecial 104	java/io/File:<init>	(Ljava/lang/String;)V
    //   298: astore_2
    //   299: aload_2
    //   300: invokevirtual 108	java/io/File:exists	()Z
    //   303: ifeq +8 -> 311
    //   306: aload_2
    //   307: invokevirtual 326	java/io/File:delete	()Z
    //   310: pop
    //   311: new 114	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   318: ldc 182
    //   320: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: iload_3
    //   324: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: aconst_null
    //   331: invokestatic 131	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   334: aload_0
    //   335: invokevirtual 187	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream:b	()V
    //   338: aload_1
    //   339: ifnull +7 -> 346
    //   342: aload_1
    //   343: invokevirtual 190	java/lang/Process:destroy	()V
    //   346: iload_3
    //   347: ireturn
    //   348: bipush 244
    //   350: ireturn
    //   351: astore_0
    //   352: ldc 192
    //   354: aload_0
    //   355: invokestatic 131	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   358: bipush 245
    //   360: ireturn
    //   361: astore 5
    //   363: ldc 192
    //   365: aload 5
    //   367: invokestatic 131	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   370: goto -89 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	373	0	paramString1	String
    //   0	373	1	paramString2	String
    //   0	373	2	paramString3	String
    //   0	373	3	paramInt	int
    //   34	15	4	bool	boolean
    //   17	240	5	localObject	Object
    //   361	5	5	localInterruptedException	java.lang.InterruptedException
    //   6	72	6	str	String
    // Exception table:
    //   from	to	target	type
    //   262	267	351	java/io/IOException
    //   276	281	361	java/lang/InterruptedException
  }
  
  public int a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidMediaMediaExtractor = a(this.jdField_a_of_type_JavaLangString);
    int i;
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor == null) {
      i = -1;
    }
    MediaFormat localMediaFormat;
    Object localObject;
    int j;
    do
    {
      return i;
      this.jdField_b_of_type_AndroidMediaMediaExtractor = a(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_b_of_type_AndroidMediaMediaExtractor == null)
      {
        a();
        return -2;
      }
      localMediaFormat = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(0);
      localObject = localMediaFormat.getString("mime");
      this.jdField_a_of_type_Int = localMediaFormat.getInteger("width");
      this.jdField_b_of_type_Int = localMediaFormat.getInteger("height");
      if (!((String)localObject).startsWith("video/")) {
        break;
      }
      this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(0);
      localObject = this.jdField_b_of_type_AndroidMediaMediaExtractor.getTrackFormat(0);
      if (!((MediaFormat)localObject).getString("mime").startsWith("audio/")) {
        break label198;
      }
      this.jdField_b_of_type_AndroidMediaMediaExtractor.selectTrack(0);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilHwVideoMerge$SampaleData.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      j = a();
      i = j;
    } while (j != 0);
    if (!a(paramString))
    {
      a();
      return -9;
      a();
      return -3;
      label198:
      a();
      return -4;
    }
    try
    {
      if (new File(paramString).exists())
      {
        a();
        return -8;
      }
      this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(paramString, 0);
      paramInt = b(this.jdField_a_of_type_JavaLangString, paramInt);
      this.jdField_a_of_type_AndroidMediaMediaMuxer.setOrientationHint(paramInt);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilHwVideoMerge$SampaleData.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(localMediaFormat);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilHwVideoMerge$SampaleData.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject);
      return j;
    }
    catch (IOException paramString)
    {
      this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
      a();
    }
    return -7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.HwVideoMerge
 * JD-Core Version:    0.7.0.1
 */