import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@RequiresApi(api=16)
public class mxh
  implements mnz
{
  private static volatile mxh jdField_a_of_type_Mxh;
  private static volatile biiw jdField_b_of_type_Biiw;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private biiw jdField_a_of_type_Biiw;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "";
  List<mxk> jdField_a_of_type_JavaUtilList = new ArrayList();
  Queue<byte[]> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private mxl jdField_a_of_type_Mxl;
  private mxm jdField_a_of_type_Mxm;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private final Object jdField_c_of_type_JavaLangObject = new Object();
  private int d = 5;
  private int e = 0;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k = 9600000;
  
  public mxh(biiw parambiiw)
  {
    a(parambiiw);
  }
  
  private static int a(byte[] paramArrayOfByte, mxk parammxk)
  {
    if ((paramArrayOfByte == null) || (parammxk == null) || (parammxk.jdField_a_of_type_AndroidMediaMediaExtractor == null) || (parammxk.jdField_a_of_type_AndroidMediaMediaCodec == null)) {
      return 1;
    }
    int m;
    int n;
    if (parammxk.jdField_a_of_type_ArrayOfByte != null)
    {
      if (parammxk.e + paramArrayOfByte.length * parammxk.jdField_a_of_type_Int <= parammxk.jdField_a_of_type_ArrayOfByte.length)
      {
        if (parammxk.jdField_a_of_type_Int == 1) {
          System.arraycopy(parammxk.jdField_a_of_type_ArrayOfByte, parammxk.e, paramArrayOfByte, 0, paramArrayOfByte.length);
        }
        for (;;)
        {
          parammxk.e += paramArrayOfByte.length * parammxk.jdField_a_of_type_Int;
          return 0;
          m = 0;
          while (m < paramArrayOfByte.length)
          {
            paramArrayOfByte[m] = parammxk.jdField_a_of_type_ArrayOfByte[(parammxk.e + m * 2)];
            paramArrayOfByte[(m + 1)] = parammxk.jdField_a_of_type_ArrayOfByte[(parammxk.e + m * 2 + 1)];
            m += 2;
          }
        }
      }
      if (parammxk.e < parammxk.jdField_a_of_type_ArrayOfByte.length)
      {
        n = (parammxk.jdField_a_of_type_ArrayOfByte.length - parammxk.e) / parammxk.jdField_a_of_type_Int;
        if (parammxk.jdField_a_of_type_Int == 1)
        {
          System.arraycopy(parammxk.jdField_a_of_type_ArrayOfByte, parammxk.e, paramArrayOfByte, 0, n);
          parammxk.e += parammxk.jdField_a_of_type_Int * n;
          m = n;
        }
      }
    }
    for (;;)
    {
      label210:
      Object localObject = parammxk.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
      n = parammxk.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
      int i1;
      if (n >= 0)
      {
        localObject = localObject[n];
        ((ByteBuffer)localObject).clear();
        i1 = parammxk.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData((ByteBuffer)localObject, 0);
        if (i1 > 0)
        {
          parammxk.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(n, 0, i1, 0L, 0);
          parammxk.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
          label284:
          localObject = parammxk.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          i1 = parammxk.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(parammxk.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
          if ((i1 < 0) || (parammxk.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size <= (paramArrayOfByte.length - m) * parammxk.jdField_a_of_type_Int)) {
            break label561;
          }
          localObject = localObject[i1];
          if ((parammxk.jdField_a_of_type_ArrayOfByte == null) || (parammxk.jdField_a_of_type_ArrayOfByte.length != parammxk.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size)) {
            parammxk.jdField_a_of_type_ArrayOfByte = new byte[parammxk.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size];
          }
          ((ByteBuffer)localObject).get(parammxk.jdField_a_of_type_ArrayOfByte);
          ((ByteBuffer)localObject).clear();
          if (parammxk.jdField_a_of_type_Int != 1) {
            break label514;
          }
          System.arraycopy(parammxk.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte, m, paramArrayOfByte.length - m);
        }
      }
      for (;;)
      {
        parammxk.e = ((paramArrayOfByte.length - m) * parammxk.jdField_a_of_type_Int);
        parammxk.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i1, false);
        return 0;
        m = 0;
        while (m < n)
        {
          paramArrayOfByte[m] = parammxk.jdField_a_of_type_ArrayOfByte[(parammxk.e + m * 2)];
          paramArrayOfByte[(m + 1)] = parammxk.jdField_a_of_type_ArrayOfByte[(parammxk.e + m * 2 + 1)];
          m += 2;
        }
        break;
        m = 0;
        break label210;
        parammxk.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(n, 0, 0, 0L, 0);
        return 2;
        if (n != -1) {
          break label284;
        }
        return 3;
        label514:
        n = 0;
        while (n < paramArrayOfByte.length - m)
        {
          paramArrayOfByte[(m + n)] = parammxk.jdField_a_of_type_ArrayOfByte[(n * 2)];
          paramArrayOfByte[(m + n + 1)] = parammxk.jdField_a_of_type_ArrayOfByte[(n * 2 + 1)];
          n += 2;
        }
      }
      label561:
      if (i1 == -2)
      {
        paramArrayOfByte = parammxk.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
        if (paramArrayOfByte == null) {}
      }
      try
      {
        m = paramArrayOfByte.getInteger("sample-rate");
        n = paramArrayOfByte.getInteger("pcm-encoding");
        i1 = paramArrayOfByte.getInteger("channel-count");
        bija.b("AVGame_AudioProcess", "decodeMP3Frame but format changed. INFO_OUTPUT_FORMAT_CHANGED. sampleRate = " + m + ", pcmEncoding = " + n + ", channelCount = " + i1);
        return 3;
      }
      catch (NullPointerException paramArrayOfByte)
      {
        for (;;)
        {
          bija.a("AVGame_AudioProcess", "decodeMP3Frame failed. INFO_OUTPUT_FORMAT_CHANGED. NullPointerException.");
        }
      }
      catch (ClassCastException paramArrayOfByte)
      {
        for (;;)
        {
          bija.a("AVGame_AudioProcess", "decodeMP3Frame failed. INFO_OUTPUT_FORMAT_CHANGED. ClassCastException.");
        }
      }
      m = 0;
    }
  }
  
  private static RandomAccessFile a(String paramString)
  {
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramString, "r");
      return localRandomAccessFile;
    }
    catch (IOException localIOException)
    {
      bija.a("AVGame_AudioProcess", "openFile failed. pcmFilename = " + paramString, localIOException);
    }
    return null;
  }
  
  /* Error */
  private static List<byte[]> a(List<mxk> paramList, int paramInt)
  {
    // Byte code:
    //   0: new 55	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 56	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_2
    //   11: aload_0
    //   12: invokeinterface 223 1 0
    //   17: if_icmpge +556 -> 573
    //   20: aload_0
    //   21: iload_2
    //   22: invokeinterface 226 2 0
    //   27: checkcast 83	mxk
    //   30: getfield 227	mxk:jdField_b_of_type_Int	I
    //   33: ifeq +10 -> 43
    //   36: iload_2
    //   37: iconst_1
    //   38: iadd
    //   39: istore_2
    //   40: goto -30 -> 10
    //   43: aload_0
    //   44: iload_2
    //   45: invokeinterface 226 2 0
    //   50: checkcast 83	mxk
    //   53: getfield 228	mxk:d	I
    //   56: iload_1
    //   57: iadd
    //   58: i2l
    //   59: aload_0
    //   60: iload_2
    //   61: invokeinterface 226 2 0
    //   66: checkcast 83	mxk
    //   69: getfield 230	mxk:jdField_a_of_type_Long	J
    //   72: lcmp
    //   73: ifle +20 -> 93
    //   76: aload_0
    //   77: iload_2
    //   78: invokeinterface 226 2 0
    //   83: checkcast 83	mxk
    //   86: getfield 231	mxk:jdField_c_of_type_Int	I
    //   89: iconst_1
    //   90: if_icmple +364 -> 454
    //   93: iload_1
    //   94: newarray byte
    //   96: astore 4
    //   98: aload 4
    //   100: iconst_0
    //   101: invokestatic 237	java/util/Arrays:fill	([BB)V
    //   104: aload_0
    //   105: iload_2
    //   106: invokeinterface 226 2 0
    //   111: checkcast 83	mxk
    //   114: getfield 228	mxk:d	I
    //   117: iload_1
    //   118: iadd
    //   119: i2l
    //   120: aload_0
    //   121: iload_2
    //   122: invokeinterface 226 2 0
    //   127: checkcast 83	mxk
    //   130: getfield 230	mxk:jdField_a_of_type_Long	J
    //   133: lcmp
    //   134: ifle +146 -> 280
    //   137: aload_0
    //   138: iload_2
    //   139: invokeinterface 226 2 0
    //   144: checkcast 83	mxk
    //   147: astore 5
    //   149: aload 5
    //   151: aload 5
    //   153: getfield 231	mxk:jdField_c_of_type_Int	I
    //   156: iconst_1
    //   157: isub
    //   158: putfield 231	mxk:jdField_c_of_type_Int	I
    //   161: aload_0
    //   162: iload_2
    //   163: invokeinterface 226 2 0
    //   168: checkcast 83	mxk
    //   171: getfield 231	mxk:jdField_c_of_type_Int	I
    //   174: ifgt +75 -> 249
    //   177: aload_0
    //   178: iload_2
    //   179: invokeinterface 226 2 0
    //   184: checkcast 83	mxk
    //   187: getfield 240	mxk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   190: ifnull +59 -> 249
    //   193: aload_0
    //   194: iload_2
    //   195: invokeinterface 226 2 0
    //   200: checkcast 83	mxk
    //   203: getfield 240	mxk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   206: invokevirtual 243	java/io/RandomAccessFile:close	()V
    //   209: aload_0
    //   210: iload_2
    //   211: invokeinterface 246 2 0
    //   216: pop
    //   217: goto -181 -> 36
    //   220: astore 4
    //   222: aload 4
    //   224: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   227: aload_0
    //   228: iload_2
    //   229: invokeinterface 246 2 0
    //   234: pop
    //   235: goto -199 -> 36
    //   238: astore_3
    //   239: aload_0
    //   240: iload_2
    //   241: invokeinterface 246 2 0
    //   246: pop
    //   247: aload_3
    //   248: athrow
    //   249: aload_0
    //   250: iload_2
    //   251: invokeinterface 226 2 0
    //   256: checkcast 83	mxk
    //   259: iconst_0
    //   260: putfield 228	mxk:d	I
    //   263: aload_0
    //   264: iload_2
    //   265: invokeinterface 226 2 0
    //   270: checkcast 83	mxk
    //   273: getfield 240	mxk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   276: lconst_0
    //   277: invokevirtual 253	java/io/RandomAccessFile:seek	(J)V
    //   280: aload 4
    //   282: aload_0
    //   283: iload_2
    //   284: invokeinterface 226 2 0
    //   289: checkcast 83	mxk
    //   292: getfield 228	mxk:d	I
    //   295: aload_0
    //   296: iload_2
    //   297: invokeinterface 226 2 0
    //   302: checkcast 83	mxk
    //   305: getfield 240	mxk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   308: invokestatic 256	mxh:a	([BILjava/io/RandomAccessFile;)Z
    //   311: ifne +89 -> 400
    //   314: aload_0
    //   315: iload_2
    //   316: invokeinterface 226 2 0
    //   321: checkcast 83	mxk
    //   324: getfield 240	mxk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   327: invokevirtual 243	java/io/RandomAccessFile:close	()V
    //   330: aload_0
    //   331: iload_2
    //   332: invokeinterface 246 2 0
    //   337: pop
    //   338: goto -302 -> 36
    //   341: astore 5
    //   343: ldc 172
    //   345: new 174	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   352: ldc_w 258
    //   355: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: iload_2
    //   359: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 201	bija:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: goto -88 -> 280
    //   371: astore 4
    //   373: aload 4
    //   375: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   378: aload_0
    //   379: iload_2
    //   380: invokeinterface 246 2 0
    //   385: pop
    //   386: goto -350 -> 36
    //   389: astore_3
    //   390: aload_0
    //   391: iload_2
    //   392: invokeinterface 246 2 0
    //   397: pop
    //   398: aload_3
    //   399: athrow
    //   400: aload 4
    //   402: aload_0
    //   403: iload_2
    //   404: invokeinterface 226 2 0
    //   409: checkcast 83	mxk
    //   412: getfield 261	mxk:jdField_a_of_type_Float	F
    //   415: invokestatic 264	mxh:a	([BF)V
    //   418: aload_3
    //   419: aload 4
    //   421: invokeinterface 268 2 0
    //   426: pop
    //   427: aload_0
    //   428: iload_2
    //   429: invokeinterface 226 2 0
    //   434: checkcast 83	mxk
    //   437: astore 4
    //   439: aload 4
    //   441: aload 4
    //   443: getfield 228	mxk:d	I
    //   446: iload_1
    //   447: iadd
    //   448: putfield 228	mxk:d	I
    //   451: goto -415 -> 36
    //   454: ldc 172
    //   456: new 174	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   463: ldc_w 270
    //   466: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: iload_2
    //   470: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   473: ldc_w 272
    //   476: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload_0
    //   480: iload_2
    //   481: invokeinterface 226 2 0
    //   486: checkcast 83	mxk
    //   489: getfield 231	mxk:jdField_c_of_type_Int	I
    //   492: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   495: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokestatic 201	bija:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   501: aload_0
    //   502: iload_2
    //   503: invokeinterface 226 2 0
    //   508: checkcast 83	mxk
    //   511: getfield 240	mxk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   514: ifnull -478 -> 36
    //   517: aload_0
    //   518: iload_2
    //   519: invokeinterface 226 2 0
    //   524: checkcast 83	mxk
    //   527: getfield 240	mxk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   530: invokevirtual 243	java/io/RandomAccessFile:close	()V
    //   533: aload_0
    //   534: iload_2
    //   535: invokeinterface 246 2 0
    //   540: pop
    //   541: goto -505 -> 36
    //   544: astore 4
    //   546: aload 4
    //   548: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   551: aload_0
    //   552: iload_2
    //   553: invokeinterface 246 2 0
    //   558: pop
    //   559: goto -523 -> 36
    //   562: astore_3
    //   563: aload_0
    //   564: iload_2
    //   565: invokeinterface 246 2 0
    //   570: pop
    //   571: aload_3
    //   572: athrow
    //   573: aload_3
    //   574: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	575	0	paramList	List<mxk>
    //   0	575	1	paramInt	int
    //   9	556	2	m	int
    //   7	1	3	localArrayList	ArrayList
    //   238	10	3	localObject1	Object
    //   389	30	3	localObject2	Object
    //   562	12	3	localList	List<byte[]>
    //   96	3	4	arrayOfByte	byte[]
    //   220	61	4	localIOException1	IOException
    //   371	49	4	localIOException2	IOException
    //   437	5	4	localmxk1	mxk
    //   544	3	4	localIOException3	IOException
    //   147	5	5	localmxk2	mxk
    //   341	1	5	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   193	209	220	java/io/IOException
    //   193	209	238	finally
    //   222	227	238	finally
    //   263	280	341	java/io/IOException
    //   314	330	371	java/io/IOException
    //   314	330	389	finally
    //   373	378	389	finally
    //   517	533	544	java/io/IOException
    //   517	533	562	finally
    //   546	551	562	finally
  }
  
  private static List<byte[]> a(List<byte[]> paramList1, List<byte[]> paramList2)
  {
    int n = 0;
    ArrayList localArrayList = new ArrayList();
    int m;
    if (paramList1 != null)
    {
      m = 0;
      while (m < paramList1.size())
      {
        localArrayList.add(paramList1.get(m));
        m += 1;
      }
    }
    if (paramList2 != null)
    {
      m = n;
      while (m < paramList2.size())
      {
        localArrayList.add(paramList2.get(m));
        m += 1;
      }
    }
    return localArrayList;
  }
  
  public static mxh a()
  {
    if (jdField_a_of_type_Mxh == null) {}
    try
    {
      if (jdField_a_of_type_Mxh == null) {
        jdField_a_of_type_Mxh = new mxh(jdField_b_of_type_Biiw);
      }
      return jdField_a_of_type_Mxh;
    }
    finally {}
  }
  
  public static mxh a(biiw parambiiw)
  {
    if ((a()) && (jdField_b_of_type_Biiw == null))
    {
      bija.b("AVGame_AudioProcess", "destroyInstance when sMultiOperator == null.");
      a();
    }
    try
    {
      jdField_b_of_type_Biiw = parambiiw;
      bija.c("AVGame_AudioProcess", "createInstance. sMultiOperator = " + jdField_b_of_type_Biiw, new Throwable("打印调用栈"));
      return a();
    }
    finally {}
  }
  
  private static mxj a(MediaExtractor paramMediaExtractor, String paramString)
  {
    int n = 0;
    File localFile = new File(paramString);
    bija.d("AVGame_AudioProcess", "startDecodeMP3. mp3FilePath = " + paramString);
    if ((paramMediaExtractor == null) || (!localFile.exists()))
    {
      bija.a("AVGame_AudioProcess", "startDecodeMP3 failed. !mp3File.exists().");
      return null;
    }
    mxj localmxj = new mxj(null);
    for (;;)
    {
      try
      {
        paramMediaExtractor.setDataSource(paramString);
        m = 0;
        if (m < paramMediaExtractor.getTrackCount())
        {
          MediaFormat localMediaFormat = paramMediaExtractor.getTrackFormat(m);
          String str = localMediaFormat.getString("mime");
          if (str.startsWith("audio"))
          {
            i1 = localMediaFormat.getInteger("sample-rate");
            n = localMediaFormat.getInteger("channel-count");
            i2 = 16;
            if (n > 2)
            {
              bija.a("AVGame_AudioProcess", "startDecodeMP3 failed. channelNum > 2.");
              return null;
            }
            localmxj.jdField_a_of_type_Int = n;
            paramMediaExtractor.selectTrack(m);
            localmxj.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType(str);
            try
            {
              localmxj.jdField_a_of_type_AndroidMediaMediaCodec.configure(localMediaFormat, null, null, 0);
              m = i2;
              if (localmxj.jdField_a_of_type_AndroidMediaMediaCodec != null) {
                break label270;
              }
              bija.a("AVGame_AudioProcess", "startDecodeMP3 failed. mAudioCodec == null.");
              return null;
            }
            catch (Throwable paramMediaExtractor)
            {
              bija.a("AVGame_AudioProcess", "startDecodeMP3 failed. configure exception: ", paramMediaExtractor);
              localmxj.jdField_a_of_type_AndroidMediaMediaCodec.release();
              localmxj.jdField_a_of_type_AndroidMediaMediaCodec = null;
              return null;
            }
          }
          else
          {
            m += 1;
            continue;
          }
          try
          {
            localmxj.jdField_a_of_type_AndroidMediaMediaCodec.start();
            bija.d("AVGame_AudioProcess", "startDecodeMP3 successfully. mp3FilePath = " + paramString + ", fileSize = " + localFile.length() + ", sampleRate = " + i1 + ", channelNum = " + n + ", sampleSize = " + m);
            return localmxj;
          }
          catch (Exception paramMediaExtractor)
          {
            bija.a("AVGame_AudioProcess", "startDecodeMP3 failed. AudioCodec.start failed.", paramMediaExtractor);
            localmxj.jdField_a_of_type_AndroidMediaMediaCodec.release();
            localmxj.jdField_a_of_type_AndroidMediaMediaCodec = null;
            return null;
          }
        }
      }
      catch (IOException paramMediaExtractor)
      {
        bija.a("AVGame_AudioProcess", "startDecodeMP3 failed. exception: ", paramMediaExtractor);
        if (localmxj.jdField_a_of_type_AndroidMediaMediaCodec != null)
        {
          localmxj.jdField_a_of_type_AndroidMediaMediaCodec.release();
          localmxj.jdField_a_of_type_AndroidMediaMediaCodec = null;
        }
        return null;
      }
      label270:
      int i2 = 0;
      int i1 = 0;
      int m = n;
      n = i2;
    }
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Mxh != null) {
      try
      {
        if (jdField_a_of_type_Mxh != null) {
          jdField_a_of_type_Mxh.b();
        }
        jdField_b_of_type_Biiw = null;
        jdField_a_of_type_Mxh = null;
        bija.c("AVGame_AudioProcess", "destroyInstance. sMultiOperator = " + jdField_b_of_type_Biiw, new Throwable("打印调用栈"));
        return;
      }
      finally {}
    }
  }
  
  public static void a(byte[] paramArrayOfByte, float paramFloat)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    int n = 0;
    label7:
    int i1;
    int m;
    if (n < paramArrayOfByte.length / 2)
    {
      i1 = (short)(int)((short)(paramArrayOfByte[(n * 2)] & 0xFF | (paramArrayOfByte[(n * 2 + 1)] & 0xFF) << 8) * paramFloat);
      if (i1 <= 32767) {
        break label93;
      }
      m = 32767;
    }
    for (;;)
    {
      paramArrayOfByte[(n * 2)] = ((byte)(m & 0xFF));
      paramArrayOfByte[(n * 2 + 1)] = ((byte)((m & 0xFF00) >> 8));
      n += 1;
      break label7;
      break;
      label93:
      m = i1;
      if (i1 < -32768) {
        m = -32768;
      }
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Mxh != null;
  }
  
  private boolean a(biiw parambiiw)
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    if ((parambiiw == null) || (!(parambiiw instanceof nhk)))
    {
      this.jdField_a_of_type_Boolean = false;
      bija.a("AVGame_AudioProcess", "init failed. multiOperator = " + parambiiw, new Throwable("打印调用栈"));
      return false;
    }
    this.jdField_a_of_type_Biiw = parambiiw;
    this.jdField_a_of_type_Boolean = true;
    this.g = 0;
    this.h = 0;
    this.jdField_b_of_type_Long = 0L;
    this.i = 0;
    this.j = 0;
    this.jdField_c_of_type_Long = 0L;
    bija.d("AVGame_AudioProcess", "init successfully.");
    return true;
  }
  
  private static boolean a(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    int n = 0;
    int m = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (n < paramArrayOfByte.length / 2)
      {
        if ((short)(paramArrayOfByte[(n * 2)] & 0xFF | (paramArrayOfByte[(n * 2 + 1)] & 0xFF) << 8) >= 10000)
        {
          int i1 = m + 1;
          m = i1;
          if (i1 < 15) {
            break label70;
          }
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      m = 0;
      label70:
      n += 1;
    }
  }
  
  private static boolean a(byte[] paramArrayOfByte, int paramInt, RandomAccessFile paramRandomAccessFile)
  {
    long l = paramInt;
    try
    {
      paramRandomAccessFile.seek(l);
      paramInt = paramRandomAccessFile.read(paramArrayOfByte);
      if (paramArrayOfByte.length == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        if (!bool) {
          bija.a("AVGame_AudioProcess", "readFile failed. readLen = " + paramInt + ", data.length = " + paramArrayOfByte.length);
        }
        return bool;
      }
      return false;
    }
    catch (IOException paramArrayOfByte)
    {
      bija.a("AVGame_AudioProcess", "readFile failed. ", paramArrayOfByte);
    }
  }
  
  private static boolean a(byte[] paramArrayOfByte, List<byte[]> paramList)
  {
    if (paramArrayOfByte == null)
    {
      bija.b("AVGame_AudioProcess", "no to mix this data. param error. mixData == null.");
      return false;
    }
    if (paramList == null)
    {
      bija.b("AVGame_AudioProcess", "no to mix this data. param error. pcmDataList == null.");
      return false;
    }
    if (paramList.size() == 0)
    {
      bija.b("AVGame_AudioProcess", "no to mix this data. param error. pcmDataList.size() == 0.");
      return false;
    }
    if (((byte[])paramList.get(0)).length % 2 != 0)
    {
      bija.b("AVGame_AudioProcess", "no to mix this data. param error. pcmDataList.get(0).length = " + ((byte[])paramList.get(0)).length);
      return false;
    }
    if (paramArrayOfByte.length < ((byte[])paramList.get(0)).length)
    {
      bija.b("AVGame_AudioProcess", "no to mix this data. param error. mixData.length = " + paramArrayOfByte.length + ", pcmDataList.get(0).length = " + ((byte[])paramList.get(0)).length);
      return false;
    }
    int i2 = paramList.size();
    int i3 = ((byte[])paramList.get(0)).length;
    if (i2 == 1)
    {
      System.arraycopy(paramList.get(0), 0, paramArrayOfByte, 0, i3);
      return true;
    }
    int n = 0;
    label210:
    int m;
    int i1;
    if (n < i3 / 2)
    {
      m = 0;
      i1 = 0;
      while (m < i2)
      {
        int i4 = ((byte[])paramList.get(m))[(n * 2)];
        i1 += (short)((((byte[])paramList.get(m))[(n * 2 + 1)] & 0xFF) << 8 | i4 & 0xFF);
        m += 1;
      }
      i1 /= i2;
      if (i1 <= 32767) {
        break label343;
      }
      m = 32767;
    }
    for (;;)
    {
      paramArrayOfByte[(n * 2)] = ((byte)((short)m & 0xFF));
      paramArrayOfByte[(n * 2 + 1)] = ((byte)(((short)m & 0xFF00) >> 8));
      n += 1;
      break label210;
      break;
      label343:
      m = i1;
      if (i1 < -32768) {
        m = -32768;
      }
    }
  }
  
  private static List<byte[]> b(List<mxk> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    if (m < paramList.size())
    {
      if ((((mxk)paramList.get(m)).jdField_b_of_type_Int != 1) || (((mxk)paramList.get(m)).jdField_a_of_type_AndroidMediaMediaExtractor == null) || (((mxk)paramList.get(m)).jdField_a_of_type_AndroidMediaMediaCodec == null)) {}
      for (;;)
      {
        m += 1;
        break;
        byte[] arrayOfByte = new byte[paramInt];
        int n = a(arrayOfByte, (mxk)paramList.get(m));
        if (n == 0)
        {
          a(arrayOfByte, ((mxk)paramList.get(m)).jdField_a_of_type_Float);
          localArrayList.add(arrayOfByte);
        }
        else if ((n == 1) || (n == 2))
        {
          bija.a("AVGame_AudioProcess", "getPCMDataFromMP3File failed. ret = " + n);
          if (((mxk)paramList.get(m)).jdField_a_of_type_AndroidMediaMediaCodec != null) {}
          try
          {
            ((mxk)paramList.get(m)).jdField_a_of_type_AndroidMediaMediaCodec.stop();
            ((mxk)paramList.get(m)).jdField_a_of_type_AndroidMediaMediaCodec.release();
            ((mxk)paramList.get(m)).jdField_a_of_type_AndroidMediaMediaCodec = null;
            if (((mxk)paramList.get(m)).jdField_a_of_type_AndroidMediaMediaExtractor != null)
            {
              ((mxk)paramList.get(m)).jdField_a_of_type_AndroidMediaMediaExtractor.release();
              ((mxk)paramList.get(m)).jdField_a_of_type_AndroidMediaMediaExtractor = null;
            }
            if ((n == 1) || (((mxk)paramList.get(m)).jdField_c_of_type_Int <= 1)) {
              paramList.remove(m);
            }
          }
          catch (IllegalStateException localIllegalStateException)
          {
            for (;;)
            {
              bija.b("AVGame_AudioProcess", "mp3Decoder stop failed.", localIllegalStateException);
            }
          }
          if (((mxk)paramList.get(m)).jdField_c_of_type_Int > 1)
          {
            Object localObject = (mxk)paramList.get(m);
            ((mxk)localObject).jdField_c_of_type_Int -= 1;
            localObject = new MediaExtractor();
            mxj localmxj = a((MediaExtractor)localObject, ((mxk)paramList.get(m)).jdField_a_of_type_JavaLangString);
            if ((localmxj != null) && (localmxj.jdField_a_of_type_AndroidMediaMediaCodec != null))
            {
              ((mxk)paramList.get(m)).jdField_a_of_type_AndroidMediaMediaExtractor = ((MediaExtractor)localObject);
              ((mxk)paramList.get(m)).jdField_a_of_type_AndroidMediaMediaCodec = localmxj.jdField_a_of_type_AndroidMediaMediaCodec;
            }
            else
            {
              bija.a("AVGame_AudioProcess", "getPCMDataFromMP3File failed. startDecodeMP3 failed.");
              paramList.remove(m);
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    List localList;
    if (paramInt1 == 3) {
      if ((this.jdField_a_of_type_Int == 1) && ((this.jdField_b_of_type_Int & 0x2) > 0) && ((this.jdField_a_of_type_JavaUtilList.size() > 0) || (this.jdField_a_of_type_JavaUtilQueue.size() > 0)))
      {
        localList = a(a(this.jdField_a_of_type_JavaUtilList, paramInt2), b(this.jdField_a_of_type_JavaUtilList, paramInt2));
        if (this.jdField_a_of_type_JavaUtilQueue.size() <= 0) {}
      }
    }
    do
    {
      do
      {
        synchronized (this.jdField_b_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_JavaUtilQueue.size() > 0) {
            localList.add(this.jdField_a_of_type_JavaUtilQueue.poll());
          }
          a(paramArrayOfByte, localList);
          return;
        }
        if (paramInt1 != 100) {
          break;
        }
      } while ((this.jdField_c_of_type_Int != 1) || (this.jdField_a_of_type_Mxm == null));
      this.jdField_a_of_type_Mxm.a(paramArrayOfByte);
      return;
    } while (paramInt1 != 8);
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaLangObject)
      {
        if ((d()) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
        {
          if ((this.jdField_a_of_type_Long == 0L) && (a(paramArrayOfByte))) {
            this.jdField_a_of_type_Long = System.currentTimeMillis();
          }
          if (ngr.a().a(paramArrayOfByte, paramArrayOfByte.length) == 1)
          {
            ngr.a().c();
            long l = System.currentTimeMillis();
            if (this.jdField_a_of_type_Long <= 0L) {
              break label338;
            }
            paramInt1 = (int)(l - this.jdField_a_of_type_Long);
            this.jdField_a_of_type_Long = 0L;
            bija.d("AVGame_AudioProcess", "onReceiveAudioFrame. 本地识别成功。答案：" + this.jdField_a_of_type_JavaLangString + ", recogTimeLen = " + paramInt1);
            if (this.jdField_a_of_type_Mxl != null) {
              this.jdField_a_of_type_Mxl.a(this.jdField_a_of_type_JavaLangString, paramInt1);
            }
          }
        }
        return;
      }
      label338:
      paramInt1 = 0;
    }
  }
  
  public void a(String paramString)
  {
    if (!d()) {
      return;
    }
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      ngr.a().c();
      this.jdField_a_of_type_JavaLangString = paramString;
      bija.d("AVGame_AudioProcess", "updateRecogTxt. txt = " + paramString);
      ngr.a().a(paramString);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        ngr.a().b();
      }
      return;
    }
  }
  
  /* Error */
  @RequiresApi(api=21)
  public void a(String arg1, int paramInt1, float paramFloat, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 404	mxh:jdField_a_of_type_Boolean	Z
    //   4: ifeq +22 -> 26
    //   7: aload_0
    //   8: getfield 410	mxh:jdField_a_of_type_Biiw	Lbiiw;
    //   11: ifnull +15 -> 26
    //   14: aload_1
    //   15: invokestatic 501	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifne +8 -> 26
    //   21: iload 4
    //   23: ifgt +12 -> 35
    //   26: ldc 172
    //   28: ldc_w 538
    //   31: invokestatic 201	bija:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: return
    //   35: aload_0
    //   36: getfield 68	mxh:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   39: astore 7
    //   41: aload 7
    //   43: monitorenter
    //   44: iconst_0
    //   45: istore 6
    //   47: iload 6
    //   49: aload_0
    //   50: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   53: invokeinterface 223 1 0
    //   58: if_icmpge +46 -> 104
    //   61: aload_0
    //   62: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   65: iload 6
    //   67: invokeinterface 226 2 0
    //   72: checkcast 83	mxk
    //   75: getfield 466	mxk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   78: aload_1
    //   79: invokevirtual 541	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   82: ifeq +13 -> 95
    //   85: aload 7
    //   87: monitorexit
    //   88: return
    //   89: astore_1
    //   90: aload 7
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    //   95: iload 6
    //   97: iconst_1
    //   98: iadd
    //   99: istore 6
    //   101: goto -54 -> 47
    //   104: aload 7
    //   106: monitorexit
    //   107: new 83	mxk
    //   110: dup
    //   111: invokespecial 542	mxk:<init>	()V
    //   114: astore 7
    //   116: aload 7
    //   118: aload_1
    //   119: putfield 466	mxk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   122: aload 7
    //   124: iload_2
    //   125: putfield 227	mxk:jdField_b_of_type_Int	I
    //   128: aload 7
    //   130: iload 4
    //   132: putfield 231	mxk:jdField_c_of_type_Int	I
    //   135: fload_3
    //   136: ldc_w 543
    //   139: fcmpg
    //   140: ifge +91 -> 231
    //   143: ldc_w 543
    //   146: fstore 5
    //   148: aload 7
    //   150: fload 5
    //   152: putfield 261	mxk:jdField_a_of_type_Float	F
    //   155: iload_2
    //   156: ifne +126 -> 282
    //   159: aload_1
    //   160: invokestatic 545	mxh:a	(Ljava/lang/String;)Ljava/io/RandomAccessFile;
    //   163: astore_1
    //   164: aload_1
    //   165: ifnull +108 -> 273
    //   168: aload 7
    //   170: aload_1
    //   171: putfield 240	mxk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   174: aload 7
    //   176: aload_1
    //   177: invokevirtual 546	java/io/RandomAccessFile:length	()J
    //   180: putfield 230	mxk:jdField_a_of_type_Long	J
    //   183: aload_0
    //   184: getfield 68	mxh:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   187: astore_1
    //   188: aload_1
    //   189: monitorenter
    //   190: aload_0
    //   191: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   194: aload 7
    //   196: invokeinterface 268 2 0
    //   201: pop
    //   202: aload_1
    //   203: monitorexit
    //   204: ldc 172
    //   206: new 174	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   213: ldc_w 548
    //   216: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload 7
    //   221: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 316	bija:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: return
    //   231: fload_3
    //   232: fstore 5
    //   234: fload_3
    //   235: ldc_w 549
    //   238: fcmpl
    //   239: ifle -91 -> 148
    //   242: ldc_w 549
    //   245: fstore 5
    //   247: goto -99 -> 148
    //   250: astore 7
    //   252: ldc 172
    //   254: ldc_w 551
    //   257: aload 7
    //   259: invokestatic 217	bija:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   262: aload_1
    //   263: invokevirtual 243	java/io/RandomAccessFile:close	()V
    //   266: return
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   272: return
    //   273: ldc 172
    //   275: ldc_w 553
    //   278: invokestatic 201	bija:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: return
    //   282: iload_2
    //   283: iconst_1
    //   284: if_icmpne +79 -> 363
    //   287: new 119	android/media/MediaExtractor
    //   290: dup
    //   291: invokespecial 465	android/media/MediaExtractor:<init>	()V
    //   294: astore 8
    //   296: aload 8
    //   298: aload_1
    //   299: invokestatic 468	mxh:a	(Landroid/media/MediaExtractor;Ljava/lang/String;)Lmxj;
    //   302: astore_1
    //   303: aload_1
    //   304: ifnull +50 -> 354
    //   307: aload_1
    //   308: getfield 362	mxj:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   311: ifnull +43 -> 354
    //   314: aload 7
    //   316: aload 8
    //   318: putfield 86	mxk:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   321: aload 7
    //   323: aload_1
    //   324: getfield 362	mxj:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   327: putfield 89	mxk:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   330: aload 7
    //   332: aload_1
    //   333: getfield 353	mxj:jdField_a_of_type_Int	I
    //   336: putfield 93	mxk:jdField_a_of_type_Int	I
    //   339: aload 7
    //   341: new 143	android/media/MediaCodec$BufferInfo
    //   344: dup
    //   345: invokespecial 554	android/media/MediaCodec$BufferInfo:<init>	()V
    //   348: putfield 137	mxk:jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   351: goto -168 -> 183
    //   354: ldc 172
    //   356: ldc_w 556
    //   359: invokestatic 201	bija:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: return
    //   363: ldc 172
    //   365: new 174	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   372: ldc_w 558
    //   375: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: iload_2
    //   379: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   382: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 201	bija:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   388: return
    //   389: astore 7
    //   391: aload_1
    //   392: monitorexit
    //   393: aload 7
    //   395: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	this	mxh
    //   0	396	2	paramInt1	int
    //   0	396	3	paramFloat	float
    //   0	396	4	paramInt2	int
    //   146	100	5	f1	float
    //   45	55	6	m	int
    //   39	181	7	localObject1	Object
    //   250	90	7	localIOException	IOException
    //   389	5	7	localObject2	Object
    //   294	23	8	localMediaExtractor	MediaExtractor
    // Exception table:
    //   from	to	target	type
    //   47	88	89	finally
    //   90	93	89	finally
    //   104	107	89	finally
    //   174	183	250	java/io/IOException
    //   262	266	267	java/io/IOException
    //   190	204	389	finally
    //   391	393	389	finally
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    int n = 0;
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Biiw == null) || (paramArrayOfByte == null) || (paramArrayOfByte.length < paramInt))
    {
      bija.a("AVGame_AudioProcess", "addPCMData failed. !mIsInited || mMultiOperator == null || pcmData == null.");
      return;
    }
    if (this.g == 0) {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
    this.g += 1;
    this.h += paramInt;
    if (this.g == 100)
    {
      long l = System.currentTimeMillis();
      bija.d("AVGame_AudioProcess", "addPCMData. mAddCnt = " + this.g + ", mAddLen = " + this.h + ", mAddStartTime = " + this.jdField_b_of_type_Long + ", addEndTime = " + l + ", mAddTimeLen = " + (l - this.jdField_b_of_type_Long));
      this.g = 0;
      this.h = 0;
      this.jdField_b_of_type_Long = 0L;
    }
    Object localObject = this.jdField_b_of_type_JavaLangObject;
    byte[] arrayOfByte = paramArrayOfByte;
    for (;;)
    {
      try
      {
        if (this.f > 0)
        {
          arrayOfByte = new byte[this.f + paramInt];
          System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, arrayOfByte, 0, this.f);
          System.arraycopy(paramArrayOfByte, 0, arrayOfByte, this.f, paramInt);
          this.f = 0;
        }
        int i1 = arrayOfByte.length / 1920;
        if (i1 > 0)
        {
          int i2 = this.jdField_a_of_type_JavaUtilQueue.size();
          paramInt = 0;
          int m = n;
          if (paramInt < i2 + i1 - 25)
          {
            this.jdField_a_of_type_JavaUtilQueue.poll();
            paramInt += 1;
            continue;
          }
          if (m < i1)
          {
            paramArrayOfByte = new byte[1920];
            System.arraycopy(arrayOfByte, m * 1920, paramArrayOfByte, 0, 1920);
            this.jdField_a_of_type_JavaUtilQueue.offer(paramArrayOfByte);
            m += 1;
            continue;
          }
          paramInt = arrayOfByte.length % 1920;
          if (paramInt > 0)
          {
            if (this.jdField_a_of_type_ArrayOfByte == null) {
              this.jdField_a_of_type_ArrayOfByte = new byte[1920];
            }
            System.arraycopy(arrayOfByte, arrayOfByte.length - paramInt, this.jdField_a_of_type_ArrayOfByte, 0, paramInt);
            this.f = paramInt;
          }
          return;
        }
      }
      finally {}
      if (this.jdField_a_of_type_ArrayOfByte == null) {
        this.jdField_a_of_type_ArrayOfByte = new byte[1920];
      }
      paramInt = arrayOfByte.length;
      System.arraycopy(arrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, paramInt);
      this.f = paramInt;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    int m = paramInt2;
    if (paramInt2 % 2 != 0)
    {
      bija.a("AVGame_AudioProcess", "onReceiveAudioFrame. size = " + paramInt2);
      m = paramInt2 - 1;
    }
    if (this.i == 0) {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
    this.i += 1;
    this.j += m;
    long l;
    if (this.i == 400)
    {
      l = System.currentTimeMillis();
      bija.d("AVGame_AudioProcess", "onReceiveAudioFrame. mMixCnt = " + this.i + ", mMixLen = " + this.j + ", mMixStartTime = " + this.jdField_c_of_type_Long + ", mixEndTime = " + l + ", mMixTimeLen = " + (l - this.jdField_c_of_type_Long));
      this.i = 0;
      this.j = 0;
      this.jdField_c_of_type_Long = 0L;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      l = System.currentTimeMillis();
      b(paramArrayOfByte, paramInt1, m);
      l = System.currentTimeMillis() - l;
      if (l > 50L) {
        bija.b("AVGame_AudioProcess", "onReceiveAudioFrame. mix. srcType = " + paramInt1 + ", big timelen = " + l);
      }
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Biiw == null))
    {
      bija.a("AVGame_AudioProcess", "startPlay failed. !mIsInited || mMultiOperator == null.");
      return false;
    }
    if (b()) {
      return true;
    }
    if (paramInt <= 0)
    {
      bija.a("AVGame_AudioProcess", "startPlay failed. mixSrcType = " + paramInt);
      return false;
    }
    int m = ((nhk)this.jdField_a_of_type_Biiw).a(3, true);
    if (m != 0)
    {
      bija.a("AVGame_AudioProcess", "startPlay failed. registerGAudioDataCallback failed. ret = " + m);
      return false;
    }
    m = ((nhk)this.jdField_a_of_type_Biiw).a(3, 48000, 1, 16);
    if (m != 0)
    {
      bija.a("AVGame_AudioProcess", "startPlay failed. setGAudioFormat failed. ret = " + m);
      return false;
    }
    ((nhk)this.jdField_a_of_type_Biiw).a(1, this);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Int = 1;
    bija.d("AVGame_AudioProcess", "startPlay successfully. mixSrcType = " + paramInt + ", ret = " + m);
    return true;
  }
  
  public boolean a(int paramInt, mxm parammxm)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Biiw == null))
    {
      bija.a("AVGame_AudioProcess", "startRecord failed. !mIsInited || mMultiOperator == null.");
      return false;
    }
    if (mqw.a())
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 2131690263, 1).a();
      return false;
    }
    if (c()) {
      return true;
    }
    if ((paramInt <= 0) || (((paramInt & 0x4) == 0) && ((paramInt & 0x1) == 0)))
    {
      bija.a("AVGame_AudioProcess", "startRecord failed. mixSrcType = " + paramInt);
      return false;
    }
    int m;
    int n;
    if ((paramInt & 0x4) > 0)
    {
      m = ((nhk)this.jdField_a_of_type_Biiw).a(0, true);
      n = ((nhk)this.jdField_a_of_type_Biiw).a(0, 48000, 1, 16);
      if ((m != 0) || (n != 0))
      {
        bija.a("AVGame_AudioProcess", "startRecord failed. MIX_SRC_TYPE_MIC. ret1 = " + m + ", ret2 = " + n);
        return false;
      }
    }
    if ((paramInt & 0x1) > 0)
    {
      m = ((nhk)this.jdField_a_of_type_Biiw).a(4, true);
      n = ((nhk)this.jdField_a_of_type_Biiw).a(4, 48000, 1, 16);
      if ((m != 0) || (n != 0))
      {
        bija.a("AVGame_AudioProcess", "startRecord failed. MIX_SRC_TYPE_RECV. ret1 = " + m + ", ret2 = " + n);
        return false;
      }
    }
    this.jdField_a_of_type_Mxm = parammxm;
    ((nhk)this.jdField_a_of_type_Biiw).a(0, this);
    this.d = paramInt;
    this.jdField_c_of_type_Int = 1;
    bija.d("AVGame_AudioProcess", "startRecord successfully. mixSrcType = " + paramInt);
    return true;
  }
  
  public boolean a(mxl parammxl)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Biiw == null))
    {
      bija.a("AVGame_AudioProcess", "startRecog failed. !mIsInited || mMultiOperator == null.");
      return false;
    }
    if (d()) {
      return true;
    }
    if (!ngr.a().a())
    {
      bija.a("AVGame_AudioProcess", "startRecog failed. !ret.");
      return false;
    }
    int m = ((nhk)this.jdField_a_of_type_Biiw).a(8, false);
    int n = ((nhk)this.jdField_a_of_type_Biiw).a(8, 16000, 1, 16);
    if ((m != 0) || (n != 0))
    {
      bija.a("AVGame_AudioProcess", "startRecog failed. MIX_SRC_TYPE_MIC. ret1 = " + m + ", ret2 = " + n);
      return false;
    }
    ((nhk)this.jdField_a_of_type_Biiw).a(1, this);
    ((nhk)this.jdField_a_of_type_Biiw).a(true);
    this.jdField_a_of_type_Mxl = parammxl;
    this.e = 1;
    bija.d("AVGame_AudioProcess", "startRecog successfully.");
    return true;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 404	mxh:jdField_a_of_type_Boolean	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 412	mxh:g	I
    //   12: ifeq +86 -> 98
    //   15: invokestatic 507	java/lang/System:currentTimeMillis	()J
    //   18: lstore_2
    //   19: ldc 172
    //   21: new 174	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 669
    //   31: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: getfield 412	mxh:g	I
    //   38: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 566
    //   44: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_0
    //   48: getfield 414	mxh:h	I
    //   51: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: ldc_w 568
    //   57: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_0
    //   61: getfield 416	mxh:jdField_b_of_type_Long	J
    //   64: invokevirtual 389	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   67: ldc_w 570
    //   70: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: lload_2
    //   74: invokevirtual 389	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   77: ldc_w 572
    //   80: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: lload_2
    //   84: aload_0
    //   85: getfield 416	mxh:jdField_b_of_type_Long	J
    //   88: lsub
    //   89: invokevirtual 389	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   92: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 316	bija:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 412	mxh:g	I
    //   103: aload_0
    //   104: iconst_0
    //   105: putfield 414	mxh:h	I
    //   108: aload_0
    //   109: lconst_0
    //   110: putfield 416	mxh:jdField_b_of_type_Long	J
    //   113: aload_0
    //   114: getfield 418	mxh:i	I
    //   117: ifeq +86 -> 203
    //   120: invokestatic 507	java/lang/System:currentTimeMillis	()J
    //   123: lstore_2
    //   124: ldc 172
    //   126: new 174	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   133: ldc_w 671
    //   136: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_0
    //   140: getfield 418	mxh:i	I
    //   143: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   146: ldc_w 584
    //   149: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_0
    //   153: getfield 420	mxh:j	I
    //   156: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: ldc_w 586
    //   162: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload_0
    //   166: getfield 422	mxh:jdField_c_of_type_Long	J
    //   169: invokevirtual 389	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   172: ldc_w 588
    //   175: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: lload_2
    //   179: invokevirtual 389	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   182: ldc_w 590
    //   185: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: lload_2
    //   189: aload_0
    //   190: getfield 422	mxh:jdField_c_of_type_Long	J
    //   193: lsub
    //   194: invokevirtual 389	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   197: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 316	bija:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_0
    //   204: iconst_0
    //   205: putfield 418	mxh:i	I
    //   208: aload_0
    //   209: iconst_0
    //   210: putfield 420	mxh:j	I
    //   213: aload_0
    //   214: lconst_0
    //   215: putfield 422	mxh:jdField_c_of_type_Long	J
    //   218: aload_0
    //   219: invokevirtual 673	mxh:c	()V
    //   222: aload_0
    //   223: invokevirtual 675	mxh:f	()V
    //   226: aload_0
    //   227: invokevirtual 677	mxh:g	()V
    //   230: aload_0
    //   231: aconst_null
    //   232: putfield 410	mxh:jdField_a_of_type_Biiw	Lbiiw;
    //   235: aload_0
    //   236: getfield 68	mxh:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   239: astore 4
    //   241: aload 4
    //   243: monitorenter
    //   244: iconst_0
    //   245: istore_1
    //   246: iload_1
    //   247: aload_0
    //   248: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   251: invokeinterface 223 1 0
    //   256: if_icmpge +315 -> 571
    //   259: aload_0
    //   260: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   263: iload_1
    //   264: invokeinterface 226 2 0
    //   269: checkcast 83	mxk
    //   272: getfield 240	mxk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   275: astore 5
    //   277: aload 5
    //   279: ifnull +103 -> 382
    //   282: aload_0
    //   283: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   286: iload_1
    //   287: invokeinterface 226 2 0
    //   292: checkcast 83	mxk
    //   295: getfield 240	mxk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   298: invokevirtual 243	java/io/RandomAccessFile:close	()V
    //   301: aload_0
    //   302: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   305: iload_1
    //   306: invokeinterface 226 2 0
    //   311: checkcast 83	mxk
    //   314: aconst_null
    //   315: putfield 240	mxk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   318: iload_1
    //   319: iconst_1
    //   320: iadd
    //   321: istore_1
    //   322: goto -76 -> 246
    //   325: astore 5
    //   327: aload 5
    //   329: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   332: aload_0
    //   333: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   336: iload_1
    //   337: invokeinterface 226 2 0
    //   342: checkcast 83	mxk
    //   345: aconst_null
    //   346: putfield 240	mxk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   349: goto -31 -> 318
    //   352: astore 5
    //   354: aload 4
    //   356: monitorexit
    //   357: aload 5
    //   359: athrow
    //   360: astore 5
    //   362: aload_0
    //   363: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   366: iload_1
    //   367: invokeinterface 226 2 0
    //   372: checkcast 83	mxk
    //   375: aconst_null
    //   376: putfield 240	mxk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   379: aload 5
    //   381: athrow
    //   382: aload_0
    //   383: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   386: iload_1
    //   387: invokeinterface 226 2 0
    //   392: checkcast 83	mxk
    //   395: getfield 86	mxk:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   398: ifnonnull +22 -> 420
    //   401: aload_0
    //   402: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   405: iload_1
    //   406: invokeinterface 226 2 0
    //   411: checkcast 83	mxk
    //   414: getfield 89	mxk:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   417: ifnull -99 -> 318
    //   420: aload_0
    //   421: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   424: iload_1
    //   425: invokeinterface 226 2 0
    //   430: checkcast 83	mxk
    //   433: getfield 89	mxk:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   436: astore 5
    //   438: aload 5
    //   440: ifnull +58 -> 498
    //   443: aload_0
    //   444: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   447: iload_1
    //   448: invokeinterface 226 2 0
    //   453: checkcast 83	mxk
    //   456: getfield 89	mxk:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   459: invokevirtual 459	android/media/MediaCodec:stop	()V
    //   462: aload_0
    //   463: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   466: iload_1
    //   467: invokeinterface 226 2 0
    //   472: checkcast 83	mxk
    //   475: getfield 89	mxk:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   478: invokevirtual 373	android/media/MediaCodec:release	()V
    //   481: aload_0
    //   482: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   485: iload_1
    //   486: invokeinterface 226 2 0
    //   491: checkcast 83	mxk
    //   494: aconst_null
    //   495: putfield 89	mxk:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   498: aload_0
    //   499: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   502: iload_1
    //   503: invokeinterface 226 2 0
    //   508: checkcast 83	mxk
    //   511: getfield 86	mxk:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   514: ifnull -196 -> 318
    //   517: aload_0
    //   518: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   521: iload_1
    //   522: invokeinterface 226 2 0
    //   527: checkcast 83	mxk
    //   530: getfield 86	mxk:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   533: invokevirtual 460	android/media/MediaExtractor:release	()V
    //   536: aload_0
    //   537: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   540: iload_1
    //   541: invokeinterface 226 2 0
    //   546: checkcast 83	mxk
    //   549: aconst_null
    //   550: putfield 86	mxk:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   553: goto -235 -> 318
    //   556: astore 5
    //   558: ldc 172
    //   560: ldc_w 462
    //   563: aload 5
    //   565: invokestatic 464	bija:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   568: goto -87 -> 481
    //   571: aload_0
    //   572: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   575: invokeinterface 679 1 0
    //   580: aload 4
    //   582: monitorexit
    //   583: aload_0
    //   584: getfield 70	mxh:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   587: astore 4
    //   589: aload 4
    //   591: monitorenter
    //   592: aload_0
    //   593: getfield 63	mxh:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   596: invokeinterface 680 1 0
    //   601: aload 4
    //   603: monitorexit
    //   604: aload_0
    //   605: iconst_0
    //   606: putfield 404	mxh:jdField_a_of_type_Boolean	Z
    //   609: ldc 172
    //   611: ldc_w 682
    //   614: invokestatic 316	bija:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   617: return
    //   618: astore 5
    //   620: aload 4
    //   622: monitorexit
    //   623: aload 5
    //   625: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	626	0	this	mxh
    //   245	296	1	m	int
    //   18	171	2	l	long
    //   275	3	5	localRandomAccessFile	RandomAccessFile
    //   325	3	5	localIOException	IOException
    //   352	6	5	localObject2	Object
    //   360	20	5	localObject3	Object
    //   436	3	5	localMediaCodec	MediaCodec
    //   556	8	5	localIllegalStateException	IllegalStateException
    //   618	6	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   282	301	325	java/io/IOException
    //   246	277	352	finally
    //   301	318	352	finally
    //   332	349	352	finally
    //   354	357	352	finally
    //   362	382	352	finally
    //   382	420	352	finally
    //   420	438	352	finally
    //   443	481	352	finally
    //   481	498	352	finally
    //   498	553	352	finally
    //   558	568	352	finally
    //   571	583	352	finally
    //   282	301	360	finally
    //   327	332	360	finally
    //   443	481	556	java/lang/IllegalStateException
    //   592	604	618	finally
    //   620	623	618	finally
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	mxh:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: iconst_0
    //   8: istore_2
    //   9: iload_2
    //   10: aload_0
    //   11: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   14: invokeinterface 223 1 0
    //   19: if_icmpge +328 -> 347
    //   22: aload_0
    //   23: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   26: iload_2
    //   27: invokeinterface 226 2 0
    //   32: checkcast 83	mxk
    //   35: getfield 466	mxk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   38: aload_1
    //   39: invokevirtual 541	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   42: ifeq +308 -> 350
    //   45: aload_0
    //   46: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   49: iload_2
    //   50: invokeinterface 226 2 0
    //   55: checkcast 83	mxk
    //   58: getfield 240	mxk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +74 -> 137
    //   66: aload_0
    //   67: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   70: iload_2
    //   71: invokeinterface 226 2 0
    //   76: checkcast 83	mxk
    //   79: getfield 240	mxk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   82: invokevirtual 243	java/io/RandomAccessFile:close	()V
    //   85: aload_0
    //   86: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   89: iload_2
    //   90: invokeinterface 246 2 0
    //   95: pop
    //   96: aload_3
    //   97: monitorexit
    //   98: return
    //   99: astore_1
    //   100: aload_1
    //   101: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   104: aload_0
    //   105: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   108: iload_2
    //   109: invokeinterface 246 2 0
    //   114: pop
    //   115: goto -19 -> 96
    //   118: astore_1
    //   119: aload_3
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    //   123: astore_1
    //   124: aload_0
    //   125: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   128: iload_2
    //   129: invokeinterface 246 2 0
    //   134: pop
    //   135: aload_1
    //   136: athrow
    //   137: aload_0
    //   138: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   141: iload_2
    //   142: invokeinterface 226 2 0
    //   147: checkcast 83	mxk
    //   150: getfield 86	mxk:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   153: ifnonnull +22 -> 175
    //   156: aload_0
    //   157: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   160: iload_2
    //   161: invokeinterface 226 2 0
    //   166: checkcast 83	mxk
    //   169: getfield 89	mxk:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   172: ifnull +161 -> 333
    //   175: aload_0
    //   176: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   179: iload_2
    //   180: invokeinterface 226 2 0
    //   185: checkcast 83	mxk
    //   188: getfield 89	mxk:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   191: astore_1
    //   192: aload_1
    //   193: ifnull +58 -> 251
    //   196: aload_0
    //   197: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   200: iload_2
    //   201: invokeinterface 226 2 0
    //   206: checkcast 83	mxk
    //   209: getfield 89	mxk:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   212: invokevirtual 459	android/media/MediaCodec:stop	()V
    //   215: aload_0
    //   216: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   219: iload_2
    //   220: invokeinterface 226 2 0
    //   225: checkcast 83	mxk
    //   228: getfield 89	mxk:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   231: invokevirtual 373	android/media/MediaCodec:release	()V
    //   234: aload_0
    //   235: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   238: iload_2
    //   239: invokeinterface 226 2 0
    //   244: checkcast 83	mxk
    //   247: aconst_null
    //   248: putfield 89	mxk:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   251: aload_0
    //   252: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   255: iload_2
    //   256: invokeinterface 226 2 0
    //   261: checkcast 83	mxk
    //   264: getfield 86	mxk:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   267: ifnull +39 -> 306
    //   270: aload_0
    //   271: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   274: iload_2
    //   275: invokeinterface 226 2 0
    //   280: checkcast 83	mxk
    //   283: getfield 86	mxk:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   286: invokevirtual 460	android/media/MediaExtractor:release	()V
    //   289: aload_0
    //   290: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   293: iload_2
    //   294: invokeinterface 226 2 0
    //   299: checkcast 83	mxk
    //   302: aconst_null
    //   303: putfield 86	mxk:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   306: aload_0
    //   307: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   310: iload_2
    //   311: invokeinterface 246 2 0
    //   316: pop
    //   317: aload_3
    //   318: monitorexit
    //   319: return
    //   320: astore_1
    //   321: ldc 172
    //   323: ldc_w 462
    //   326: aload_1
    //   327: invokestatic 464	bija:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   330: goto -96 -> 234
    //   333: aload_0
    //   334: getfield 58	mxh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   337: iload_2
    //   338: invokeinterface 246 2 0
    //   343: pop
    //   344: aload_3
    //   345: monitorexit
    //   346: return
    //   347: aload_3
    //   348: monitorexit
    //   349: return
    //   350: iload_2
    //   351: iconst_1
    //   352: iadd
    //   353: istore_2
    //   354: goto -345 -> 9
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	mxh
    //   0	357	1	paramString	String
    //   8	346	2	m	int
    //   4	344	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   66	85	99	java/io/IOException
    //   9	62	118	finally
    //   85	96	118	finally
    //   96	98	118	finally
    //   104	115	118	finally
    //   119	121	118	finally
    //   124	137	118	finally
    //   137	175	118	finally
    //   175	192	118	finally
    //   196	234	118	finally
    //   234	251	118	finally
    //   251	306	118	finally
    //   306	319	118	finally
    //   321	330	118	finally
    //   333	346	118	finally
    //   347	349	118	finally
    //   66	85	123	finally
    //   100	104	123	finally
    //   196	234	320	java/lang/IllegalStateException
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int != 0;
  }
  
  public void c()
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Biiw == null)) {}
    while (!b()) {
      return;
    }
    try
    {
      ((nhk)this.jdField_a_of_type_Biiw).a(1, null);
      int m = ((nhk)this.jdField_a_of_type_Biiw).a(3);
      this.jdField_a_of_type_Int = 0;
      bija.d("AVGame_AudioProcess", "stopPlay successfully. ret = " + m);
      return;
    }
    catch (Exception localException)
    {
      bija.a("AVGame_AudioProcess", "stopPlay failed. ", localException);
    }
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Int != 0;
  }
  
  public void d()
  {
    if (b()) {
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  public boolean d()
  {
    return this.e != 0;
  }
  
  public void e()
  {
    if (b()) {
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public void f()
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Biiw == null)) {}
    while (!c()) {
      return;
    }
    try
    {
      this.jdField_a_of_type_Mxm = null;
      ((nhk)this.jdField_a_of_type_Biiw).a(0, null);
      if ((this.d & 0x4) > 0) {
        ((nhk)this.jdField_a_of_type_Biiw).a(0);
      }
      if ((this.d & 0x1) > 0) {
        ((nhk)this.jdField_a_of_type_Biiw).a(4);
      }
      this.jdField_c_of_type_Int = 0;
      bija.d("AVGame_AudioProcess", "stopRecord sucessfully.");
      return;
    }
    catch (Exception localException)
    {
      bija.a("AVGame_AudioProcess", "stopRecord failed.", localException);
    }
  }
  
  public void g()
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Biiw == null)) {}
    while (!d()) {
      return;
    }
    try
    {
      this.jdField_a_of_type_Mxl = null;
      ngr.a().d();
      ((nhk)this.jdField_a_of_type_Biiw).a(1, null);
      ((nhk)this.jdField_a_of_type_Biiw).a(8);
      ((nhk)this.jdField_a_of_type_Biiw).a(false);
      this.e = 0;
      bija.d("AVGame_AudioProcess", "stopRecog sucessfully.");
      return;
    }
    catch (Exception localException)
    {
      bija.a("AVGame_AudioProcess", "stopRecog failed.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxh
 * JD-Core Version:    0.7.0.1
 */