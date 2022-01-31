package dov.com.tencent.mobileqq.shortvideo.util;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import aoqk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
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
  private aoqk jdField_a_of_type_Aoqk = new aoqk(null);
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
    this.jdField_a_of_type_Aoqk.jdField_a_of_type_JavaNioByteBuffer.position(0);
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(this.jdField_a_of_type_Aoqk.jdField_a_of_type_JavaNioByteBuffer, 0) <= 0)
    {
      a();
      i = -5;
    }
    do
    {
      return i;
      this.jdField_a_of_type_Aoqk.jdField_a_of_type_JavaNioByteBuffer.position(0);
    } while (this.jdField_b_of_type_AndroidMediaMediaExtractor.readSampleData(this.jdField_a_of_type_Aoqk.jdField_a_of_type_JavaNioByteBuffer, 0) > 0);
    a();
    return -6;
  }
  
  private static int a(String paramString1, String paramString2)
  {
    return a(new ArrayList(Arrays.asList(new String[] { "-i", paramString1, "-c", "copy", paramString2 })));
  }
  
  /* Error */
  public static int a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 88	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   3: invokestatic 93	dov/com/tencent/mobileqq/shortvideo/util/FileFFmpegUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   6: astore 7
    //   8: new 95	java/io/File
    //   11: dup
    //   12: aload 7
    //   14: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 8
    //   19: aload 8
    //   21: invokevirtual 102	java/io/File:exists	()Z
    //   24: ifeq +412 -> 436
    //   27: aload 8
    //   29: iconst_1
    //   30: iconst_1
    //   31: invokevirtual 106	java/io/File:setExecutable	(ZZ)Z
    //   34: istore 6
    //   36: new 108	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   43: ldc 111
    //   45: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload 6
    //   50: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: aconst_null
    //   57: invokestatic 125	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   60: new 56	java/util/ArrayList
    //   63: dup
    //   64: invokespecial 126	java/util/ArrayList:<init>	()V
    //   67: astore 8
    //   69: aload 8
    //   71: aload 7
    //   73: invokeinterface 132 2 0
    //   78: pop
    //   79: aload 8
    //   81: ldc 134
    //   83: invokeinterface 132 2 0
    //   88: pop
    //   89: aload 8
    //   91: ldc 136
    //   93: invokeinterface 132 2 0
    //   98: pop
    //   99: aload 8
    //   101: ldc 138
    //   103: invokeinterface 132 2 0
    //   108: pop
    //   109: aload 8
    //   111: ldc 140
    //   113: invokeinterface 132 2 0
    //   118: pop
    //   119: aload 8
    //   121: ldc 60
    //   123: invokeinterface 132 2 0
    //   128: pop
    //   129: aload 8
    //   131: aload_0
    //   132: invokeinterface 132 2 0
    //   137: pop
    //   138: iload_3
    //   139: ifeq +45 -> 184
    //   142: aload 8
    //   144: ldc 142
    //   146: invokeinterface 132 2 0
    //   151: pop
    //   152: aload 8
    //   154: new 108	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   161: lload 4
    //   163: ldc2_w 143
    //   166: ldiv
    //   167: invokevirtual 147	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   170: ldc 149
    //   172: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokeinterface 132 2 0
    //   183: pop
    //   184: aload 8
    //   186: ldc 151
    //   188: invokeinterface 132 2 0
    //   193: pop
    //   194: aload 8
    //   196: ldc 64
    //   198: invokeinterface 132 2 0
    //   203: pop
    //   204: aload 8
    //   206: ldc 153
    //   208: invokeinterface 132 2 0
    //   213: pop
    //   214: aload 8
    //   216: ldc 64
    //   218: invokeinterface 132 2 0
    //   223: pop
    //   224: aload 8
    //   226: aload_1
    //   227: invokeinterface 132 2 0
    //   232: pop
    //   233: aload 8
    //   235: invokestatic 88	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   238: invokestatic 155	dov/com/tencent/mobileqq/shortvideo/util/FileFFmpegUtils:b	(Landroid/content/Context;)Ljava/lang/String;
    //   241: invokeinterface 132 2 0
    //   246: pop
    //   247: new 157	java/lang/ProcessBuilder
    //   250: dup
    //   251: iconst_0
    //   252: anewarray 58	java/lang/String
    //   255: invokespecial 160	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   258: astore_0
    //   259: aload_0
    //   260: iconst_1
    //   261: invokevirtual 164	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   264: pop
    //   265: aload_0
    //   266: aload 8
    //   268: invokevirtual 168	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   271: pop
    //   272: aload_0
    //   273: invokevirtual 172	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   276: astore_0
    //   277: new 108	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   284: astore 7
    //   286: new 174	java/io/BufferedReader
    //   289: dup
    //   290: new 176	java/io/InputStreamReader
    //   293: dup
    //   294: aload_0
    //   295: invokevirtual 182	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   298: invokespecial 185	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   301: invokespecial 188	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   304: astore 8
    //   306: aload 8
    //   308: invokevirtual 191	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   311: astore 9
    //   313: aload 9
    //   315: ifnull +21 -> 336
    //   318: aload 7
    //   320: aload 9
    //   322: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: goto -20 -> 306
    //   329: astore 8
    //   331: aload 8
    //   333: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   336: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +29 -> 368
    //   342: ldc 201
    //   344: iconst_2
    //   345: new 108	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   352: ldc 203
    //   354: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload 7
    //   359: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 210	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: aload_0
    //   369: invokevirtual 213	java/lang/Process:waitFor	()I
    //   372: pop
    //   373: aload_0
    //   374: invokevirtual 216	java/lang/Process:exitValue	()I
    //   377: istore_2
    //   378: iload_2
    //   379: ifeq +47 -> 426
    //   382: new 95	java/io/File
    //   385: dup
    //   386: aload_1
    //   387: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   390: astore_1
    //   391: aload_1
    //   392: invokevirtual 102	java/io/File:exists	()Z
    //   395: ifeq +8 -> 403
    //   398: aload_1
    //   399: invokevirtual 219	java/io/File:delete	()Z
    //   402: pop
    //   403: new 108	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   410: ldc 221
    //   412: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: iload_2
    //   416: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   419: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: aconst_null
    //   423: invokestatic 125	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   426: aload_0
    //   427: ifnull +7 -> 434
    //   430: aload_0
    //   431: invokevirtual 227	java/lang/Process:destroy	()V
    //   434: iload_2
    //   435: ireturn
    //   436: bipush 244
    //   438: ireturn
    //   439: astore_0
    //   440: ldc 229
    //   442: aload_0
    //   443: invokestatic 125	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   446: bipush 245
    //   448: ireturn
    //   449: astore 7
    //   451: ldc 229
    //   453: aload 7
    //   455: invokestatic 125	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   458: goto -85 -> 373
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	461	0	paramString1	String
    //   0	461	1	paramString2	String
    //   0	461	2	paramInt	int
    //   0	461	3	paramBoolean	boolean
    //   0	461	4	paramLong	long
    //   34	15	6	bool	boolean
    //   6	352	7	localObject1	Object
    //   449	5	7	localInterruptedException	java.lang.InterruptedException
    //   17	290	8	localObject2	Object
    //   329	3	8	localException	Exception
    //   311	10	9	str	String
    // Exception table:
    //   from	to	target	type
    //   286	306	329	java/lang/Exception
    //   306	313	329	java/lang/Exception
    //   318	326	329	java/lang/Exception
    //   272	277	439	java/io/IOException
    //   368	373	449	java/lang/InterruptedException
  }
  
  public static final int a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    return b(paramString1, paramString2, paramString3, paramInt);
  }
  
  /* Error */
  private static int a(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +12 -> 13
    //   4: aload_0
    //   5: invokeinterface 235 1 0
    //   10: ifne +8 -> 18
    //   13: bipush 247
    //   15: istore_1
    //   16: iload_1
    //   17: ireturn
    //   18: invokestatic 88	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   21: invokestatic 93	dov/com/tencent/mobileqq/shortvideo/util/FileFFmpegUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   24: astore 4
    //   26: new 95	java/io/File
    //   29: dup
    //   30: aload 4
    //   32: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 102	java/io/File:exists	()Z
    //   42: ifeq +200 -> 242
    //   45: aload 5
    //   47: iconst_1
    //   48: iconst_1
    //   49: invokevirtual 106	java/io/File:setExecutable	(ZZ)Z
    //   52: istore_3
    //   53: new 108	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   60: ldc 111
    //   62: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: iload_3
    //   66: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   69: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: aconst_null
    //   73: invokestatic 125	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: aload_0
    //   77: iconst_0
    //   78: aload 4
    //   80: invokeinterface 238 3 0
    //   85: aload_0
    //   86: iconst_1
    //   87: ldc 134
    //   89: invokeinterface 238 3 0
    //   94: aload_0
    //   95: iconst_2
    //   96: ldc 140
    //   98: invokeinterface 238 3 0
    //   103: aload_0
    //   104: iconst_3
    //   105: ldc 136
    //   107: invokeinterface 238 3 0
    //   112: aload_0
    //   113: iconst_4
    //   114: ldc 240
    //   116: invokeinterface 238 3 0
    //   121: aload_0
    //   122: invokestatic 88	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   125: invokestatic 155	dov/com/tencent/mobileqq/shortvideo/util/FileFFmpegUtils:b	(Landroid/content/Context;)Ljava/lang/String;
    //   128: invokeinterface 132 2 0
    //   133: pop
    //   134: new 242	aoqj
    //   137: dup
    //   138: aconst_null
    //   139: invokespecial 243	aoqj:<init>	(Laoqi;)V
    //   142: astore 4
    //   144: new 157	java/lang/ProcessBuilder
    //   147: dup
    //   148: iconst_0
    //   149: anewarray 58	java/lang/String
    //   152: invokespecial 160	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   155: astore 5
    //   157: aload 5
    //   159: iconst_1
    //   160: invokevirtual 164	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   163: pop
    //   164: aload 5
    //   166: aload_0
    //   167: invokevirtual 168	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   170: pop
    //   171: aload 5
    //   173: invokevirtual 172	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   176: astore_0
    //   177: aload 4
    //   179: aload_0
    //   180: putfield 246	aoqj:a	Ljava/lang/Process;
    //   183: aload 4
    //   185: invokevirtual 247	aoqj:a	()V
    //   188: aload_0
    //   189: invokevirtual 213	java/lang/Process:waitFor	()I
    //   192: pop
    //   193: aload_0
    //   194: invokevirtual 216	java/lang/Process:exitValue	()I
    //   197: istore_2
    //   198: iload_2
    //   199: ifeq +26 -> 225
    //   202: new 108	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   209: ldc 221
    //   211: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload_2
    //   215: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: aconst_null
    //   222: invokestatic 125	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   225: aload 4
    //   227: invokevirtual 249	aoqj:b	()V
    //   230: iload_2
    //   231: istore_1
    //   232: aload_0
    //   233: ifnull -217 -> 16
    //   236: aload_0
    //   237: invokevirtual 227	java/lang/Process:destroy	()V
    //   240: iload_2
    //   241: ireturn
    //   242: bipush 244
    //   244: ireturn
    //   245: astore_0
    //   246: ldc 229
    //   248: aload_0
    //   249: invokestatic 125	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   252: bipush 245
    //   254: ireturn
    //   255: astore 5
    //   257: ldc 229
    //   259: aload 5
    //   261: invokestatic 125	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   264: goto -71 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramList	List
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
  
  public static void a(String paramString, long paramLong)
  {
    long l1 = new File(paramString).length();
    long l2 = ShortVideoUtils.b(paramString);
    float f2 = 0.0F;
    float f1 = f2;
    boolean bool;
    if (l1 != 0L)
    {
      f1 = f2;
      if (l2 != 0L)
      {
        f2 = 1.0F * (float)l1 / (float)l2 * 1000.0F * 8.0F;
        f1 = f2;
        if (f2 > (float)paramLong)
        {
          f1 = f2;
          if (MediaCodecDPC.f()) {
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HwVideoMerge", 2, "resetBitrate = " + bool + " ; origin br = " + f2);
      }
      if (bool)
      {
        a(paramString, true, paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("HwVideoMerge", 2, "reEncode video : origin br = " + f2 + " ; target br = " + paramLong);
        }
      }
      for (;;)
      {
        if (MediaCodecDPC.f()) {
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(null, "actMediaCodecCQBitrate", true, (int)(f2 / 1000.0F), 0L, null, "");
        }
        return;
        if (AudioHelper.a()) {
          a(paramString, false, 0L);
        }
      }
      bool = false;
      f2 = f1;
    }
  }
  
  private static void a(String paramString, boolean paramBoolean, long paramLong)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("HwVideoMerge", 2, "reEncodeVideoWithFFmpeg " + paramString);
    }
    String str = paramString + ".temp.mp4";
    long l2 = new File(paramString).length();
    int i = a(paramString, str, 0, paramBoolean, paramLong);
    paramLong = new File(str).length();
    if (QLog.isColorLevel()) {
      QLog.i("HwVideoMerge", 2, "reEncodeVideoWithFFmpeg ffmpegReCodec cost=" + (System.currentTimeMillis() - l1) + " : originSize = " + l2 + " : targetSize = " + paramLong);
    }
    if (i != 0) {
      if (QLog.isColorLevel()) {
        QLog.i("HwVideoMerge", 2, "[NewVersion]HwVideoMerge->merge: errcode=" + i);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HwVideoMerge", 2, "reEncodeVideoWithFFmpeg cost=" + (System.currentTimeMillis() - l1));
      }
      return;
      FileUtils.d(paramString);
      FileUtils.c(str, paramString);
    }
  }
  
  private boolean a(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString));
  }
  
  public static boolean a(List paramList, String paramString, int paramInt)
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
        break label207;
      }
    } while (!QLog.isColorLevel());
    QLog.e("HwVideoMerge", 2, "ffmpegMergeTs fail, err: " + i);
    return false;
    label207:
    if (paramInt == 90) {
      i = 270;
    }
    for (;;)
    {
      paramInt = a(new ArrayList(Arrays.asList(new String[] { "-i", paramList, "-metadata:s", "rotate=" + i, "-vcodec", "copy", "-acodec", "copy", "-absf", "aac_adtstoasc", paramString })));
      if (paramInt == 0) {
        break label368;
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
    label368:
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
    //   0: invokestatic 88	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   3: invokestatic 93	dov/com/tencent/mobileqq/shortvideo/util/FileFFmpegUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   6: astore 6
    //   8: new 95	java/io/File
    //   11: dup
    //   12: aload 6
    //   14: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 5
    //   19: aload 5
    //   21: invokevirtual 102	java/io/File:exists	()Z
    //   24: ifeq +322 -> 346
    //   27: aload 5
    //   29: iconst_1
    //   30: iconst_1
    //   31: invokevirtual 106	java/io/File:setExecutable	(ZZ)Z
    //   34: istore 4
    //   36: new 108	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   43: ldc 111
    //   45: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload 4
    //   50: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: aconst_null
    //   57: invokestatic 125	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   60: aload_0
    //   61: iload_3
    //   62: invokestatic 439	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;I)I
    //   65: pop
    //   66: new 56	java/util/ArrayList
    //   69: dup
    //   70: invokespecial 126	java/util/ArrayList:<init>	()V
    //   73: astore 5
    //   75: aload 5
    //   77: aload 6
    //   79: invokeinterface 132 2 0
    //   84: pop
    //   85: aload 5
    //   87: ldc 134
    //   89: invokeinterface 132 2 0
    //   94: pop
    //   95: aload 5
    //   97: ldc 140
    //   99: invokeinterface 132 2 0
    //   104: pop
    //   105: aload 5
    //   107: ldc 136
    //   109: invokeinterface 132 2 0
    //   114: pop
    //   115: aload 5
    //   117: ldc 240
    //   119: invokeinterface 132 2 0
    //   124: pop
    //   125: aload 5
    //   127: ldc 60
    //   129: invokeinterface 132 2 0
    //   134: pop
    //   135: aload 5
    //   137: aload_0
    //   138: invokeinterface 132 2 0
    //   143: pop
    //   144: aload 5
    //   146: ldc 60
    //   148: invokeinterface 132 2 0
    //   153: pop
    //   154: aload 5
    //   156: aload_1
    //   157: invokeinterface 132 2 0
    //   162: pop
    //   163: aload 5
    //   165: ldc 151
    //   167: invokeinterface 132 2 0
    //   172: pop
    //   173: aload 5
    //   175: ldc 64
    //   177: invokeinterface 132 2 0
    //   182: pop
    //   183: aload 5
    //   185: ldc 153
    //   187: invokeinterface 132 2 0
    //   192: pop
    //   193: aload 5
    //   195: ldc 64
    //   197: invokeinterface 132 2 0
    //   202: pop
    //   203: aload 5
    //   205: aload_2
    //   206: invokeinterface 132 2 0
    //   211: pop
    //   212: aload 5
    //   214: invokestatic 88	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   217: invokestatic 155	dov/com/tencent/mobileqq/shortvideo/util/FileFFmpegUtils:b	(Landroid/content/Context;)Ljava/lang/String;
    //   220: invokeinterface 132 2 0
    //   225: pop
    //   226: new 242	aoqj
    //   229: dup
    //   230: aconst_null
    //   231: invokespecial 243	aoqj:<init>	(Laoqi;)V
    //   234: astore_0
    //   235: new 157	java/lang/ProcessBuilder
    //   238: dup
    //   239: iconst_0
    //   240: anewarray 58	java/lang/String
    //   243: invokespecial 160	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   246: astore_1
    //   247: aload_1
    //   248: iconst_1
    //   249: invokevirtual 164	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   252: pop
    //   253: aload_1
    //   254: aload 5
    //   256: invokevirtual 168	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   259: pop
    //   260: aload_1
    //   261: invokevirtual 172	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   264: astore_1
    //   265: aload_0
    //   266: aload_1
    //   267: putfield 246	aoqj:a	Ljava/lang/Process;
    //   270: aload_0
    //   271: invokevirtual 247	aoqj:a	()V
    //   274: aload_1
    //   275: invokevirtual 213	java/lang/Process:waitFor	()I
    //   278: pop
    //   279: aload_1
    //   280: invokevirtual 216	java/lang/Process:exitValue	()I
    //   283: istore_3
    //   284: iload_3
    //   285: ifeq +47 -> 332
    //   288: new 95	java/io/File
    //   291: dup
    //   292: aload_2
    //   293: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   296: astore_2
    //   297: aload_2
    //   298: invokevirtual 102	java/io/File:exists	()Z
    //   301: ifeq +8 -> 309
    //   304: aload_2
    //   305: invokevirtual 219	java/io/File:delete	()Z
    //   308: pop
    //   309: new 108	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   316: ldc 221
    //   318: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: iload_3
    //   322: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   325: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: aconst_null
    //   329: invokestatic 125	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   332: aload_0
    //   333: invokevirtual 249	aoqj:b	()V
    //   336: aload_1
    //   337: ifnull +7 -> 344
    //   340: aload_1
    //   341: invokevirtual 227	java/lang/Process:destroy	()V
    //   344: iload_3
    //   345: ireturn
    //   346: bipush 244
    //   348: ireturn
    //   349: astore_0
    //   350: ldc 229
    //   352: aload_0
    //   353: invokestatic 125	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   356: bipush 245
    //   358: ireturn
    //   359: astore 5
    //   361: ldc 229
    //   363: aload 5
    //   365: invokestatic 125	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   368: goto -89 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	paramString1	String
    //   0	371	1	paramString2	String
    //   0	371	2	paramString3	String
    //   0	371	3	paramInt	int
    //   34	15	4	bool	boolean
    //   17	238	5	localObject	Object
    //   359	5	5	localInterruptedException	java.lang.InterruptedException
    //   6	72	6	str	String
    // Exception table:
    //   from	to	target	type
    //   260	265	349	java/io/IOException
    //   274	279	359	java/lang/InterruptedException
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
      this.jdField_a_of_type_Aoqk.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
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
      this.jdField_a_of_type_Aoqk.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(localMediaFormat);
      this.jdField_a_of_type_Aoqk.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.HwVideoMerge
 * JD-Core Version:    0.7.0.1
 */