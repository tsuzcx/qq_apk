import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
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
public class mwx
  implements moq
{
  private static volatile mwx jdField_a_of_type_Mwx;
  private static volatile bkdl jdField_b_of_type_Bkdl;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private bkdl jdField_a_of_type_Bkdl;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  List<mxa> jdField_a_of_type_JavaUtilList = new ArrayList();
  Queue<byte[]> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private mxb jdField_a_of_type_Mxb;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  private int c = 0;
  private int d = 5;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public mwx(bkdl parambkdl)
  {
    a(parambkdl);
  }
  
  private static int a(byte[] paramArrayOfByte, mxa parammxa)
  {
    if ((paramArrayOfByte == null) || (parammxa == null) || (parammxa.jdField_a_of_type_AndroidMediaMediaExtractor == null) || (parammxa.jdField_a_of_type_AndroidMediaMediaCodec == null)) {
      return 1;
    }
    int j;
    int k;
    if (parammxa.jdField_a_of_type_ArrayOfByte != null)
    {
      if (parammxa.e + paramArrayOfByte.length * parammxa.jdField_a_of_type_Int <= parammxa.jdField_a_of_type_ArrayOfByte.length)
      {
        if (parammxa.jdField_a_of_type_Int == 1) {
          System.arraycopy(parammxa.jdField_a_of_type_ArrayOfByte, parammxa.e, paramArrayOfByte, 0, paramArrayOfByte.length);
        }
        for (;;)
        {
          parammxa.e += paramArrayOfByte.length * parammxa.jdField_a_of_type_Int;
          return 0;
          j = 0;
          while (j < paramArrayOfByte.length)
          {
            paramArrayOfByte[j] = parammxa.jdField_a_of_type_ArrayOfByte[(parammxa.e + j * 2)];
            paramArrayOfByte[(j + 1)] = parammxa.jdField_a_of_type_ArrayOfByte[(parammxa.e + j * 2 + 1)];
            j += 2;
          }
        }
      }
      if (parammxa.e < parammxa.jdField_a_of_type_ArrayOfByte.length)
      {
        k = (parammxa.jdField_a_of_type_ArrayOfByte.length - parammxa.e) / parammxa.jdField_a_of_type_Int;
        if (parammxa.jdField_a_of_type_Int == 1)
        {
          System.arraycopy(parammxa.jdField_a_of_type_ArrayOfByte, parammxa.e, paramArrayOfByte, 0, k);
          parammxa.e += parammxa.jdField_a_of_type_Int * k;
          j = k;
        }
      }
    }
    for (;;)
    {
      label210:
      Object localObject = parammxa.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
      k = parammxa.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
      int m;
      if (k >= 0)
      {
        localObject = localObject[k];
        ((ByteBuffer)localObject).clear();
        m = parammxa.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData((ByteBuffer)localObject, 0);
        if (m > 0)
        {
          parammxa.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(k, 0, m, 0L, 0);
          parammxa.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
          label284:
          localObject = parammxa.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          m = parammxa.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(parammxa.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
          if ((m < 0) || (parammxa.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size <= (paramArrayOfByte.length - j) * parammxa.jdField_a_of_type_Int)) {
            break label561;
          }
          localObject = localObject[m];
          if ((parammxa.jdField_a_of_type_ArrayOfByte == null) || (parammxa.jdField_a_of_type_ArrayOfByte.length != parammxa.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size)) {
            parammxa.jdField_a_of_type_ArrayOfByte = new byte[parammxa.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size];
          }
          ((ByteBuffer)localObject).get(parammxa.jdField_a_of_type_ArrayOfByte);
          ((ByteBuffer)localObject).clear();
          if (parammxa.jdField_a_of_type_Int != 1) {
            break label514;
          }
          System.arraycopy(parammxa.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte, j, paramArrayOfByte.length - j);
        }
      }
      for (;;)
      {
        parammxa.e = ((paramArrayOfByte.length - j) * parammxa.jdField_a_of_type_Int);
        parammxa.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(m, false);
        return 0;
        j = 0;
        while (j < k)
        {
          paramArrayOfByte[j] = parammxa.jdField_a_of_type_ArrayOfByte[(parammxa.e + j * 2)];
          paramArrayOfByte[(j + 1)] = parammxa.jdField_a_of_type_ArrayOfByte[(parammxa.e + j * 2 + 1)];
          j += 2;
        }
        break;
        j = 0;
        break label210;
        parammxa.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(k, 0, 0, 0L, 0);
        return 2;
        if (k != -1) {
          break label284;
        }
        return 3;
        label514:
        k = 0;
        while (k < paramArrayOfByte.length - j)
        {
          paramArrayOfByte[(j + k)] = parammxa.jdField_a_of_type_ArrayOfByte[(k * 2)];
          paramArrayOfByte[(j + k + 1)] = parammxa.jdField_a_of_type_ArrayOfByte[(k * 2 + 1)];
          k += 2;
        }
      }
      label561:
      if (m == -2)
      {
        paramArrayOfByte = parammxa.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
        if (paramArrayOfByte == null) {}
      }
      try
      {
        j = paramArrayOfByte.getInteger("sample-rate");
        k = paramArrayOfByte.getInteger("pcm-encoding");
        m = paramArrayOfByte.getInteger("channel-count");
        bkdp.b("AVGame_AudioMix", "decodeMP3Frame but format changed. INFO_OUTPUT_FORMAT_CHANGED. sampleRate = " + j + ", pcmEncoding = " + k + ", channelCount = " + m);
        return 3;
      }
      catch (NullPointerException paramArrayOfByte)
      {
        for (;;)
        {
          bkdp.a("AVGame_AudioMix", "decodeMP3Frame failed. INFO_OUTPUT_FORMAT_CHANGED. NullPointerException.");
        }
      }
      catch (ClassCastException paramArrayOfByte)
      {
        for (;;)
        {
          bkdp.a("AVGame_AudioMix", "decodeMP3Frame failed. INFO_OUTPUT_FORMAT_CHANGED. ClassCastException.");
        }
      }
      j = 0;
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
      bkdp.a("AVGame_AudioMix", "openFile failed. pcmFilename = " + paramString, localIOException);
    }
    return null;
  }
  
  /* Error */
  private static List<byte[]> a(List<mxa> paramList, int paramInt)
  {
    // Byte code:
    //   0: new 45	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 46	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_2
    //   11: aload_0
    //   12: invokeinterface 209 1 0
    //   17: if_icmpge +555 -> 572
    //   20: aload_0
    //   21: iload_2
    //   22: invokeinterface 212 2 0
    //   27: checkcast 68	mxa
    //   30: getfield 213	mxa:jdField_b_of_type_Int	I
    //   33: ifeq +10 -> 43
    //   36: iload_2
    //   37: iconst_1
    //   38: iadd
    //   39: istore_2
    //   40: goto -30 -> 10
    //   43: aload_0
    //   44: iload_2
    //   45: invokeinterface 212 2 0
    //   50: checkcast 68	mxa
    //   53: getfield 214	mxa:d	I
    //   56: iload_1
    //   57: iadd
    //   58: i2l
    //   59: aload_0
    //   60: iload_2
    //   61: invokeinterface 212 2 0
    //   66: checkcast 68	mxa
    //   69: getfield 216	mxa:jdField_a_of_type_Long	J
    //   72: lcmp
    //   73: ifle +20 -> 93
    //   76: aload_0
    //   77: iload_2
    //   78: invokeinterface 212 2 0
    //   83: checkcast 68	mxa
    //   86: getfield 217	mxa:c	I
    //   89: iconst_1
    //   90: if_icmple +363 -> 453
    //   93: iload_1
    //   94: newarray byte
    //   96: astore 4
    //   98: aload 4
    //   100: iconst_0
    //   101: invokestatic 223	java/util/Arrays:fill	([BB)V
    //   104: aload_0
    //   105: iload_2
    //   106: invokeinterface 212 2 0
    //   111: checkcast 68	mxa
    //   114: getfield 214	mxa:d	I
    //   117: iload_1
    //   118: iadd
    //   119: i2l
    //   120: aload_0
    //   121: iload_2
    //   122: invokeinterface 212 2 0
    //   127: checkcast 68	mxa
    //   130: getfield 216	mxa:jdField_a_of_type_Long	J
    //   133: lcmp
    //   134: ifle +146 -> 280
    //   137: aload_0
    //   138: iload_2
    //   139: invokeinterface 212 2 0
    //   144: checkcast 68	mxa
    //   147: astore 5
    //   149: aload 5
    //   151: aload 5
    //   153: getfield 217	mxa:c	I
    //   156: iconst_1
    //   157: isub
    //   158: putfield 217	mxa:c	I
    //   161: aload_0
    //   162: iload_2
    //   163: invokeinterface 212 2 0
    //   168: checkcast 68	mxa
    //   171: getfield 217	mxa:c	I
    //   174: ifgt +75 -> 249
    //   177: aload_0
    //   178: iload_2
    //   179: invokeinterface 212 2 0
    //   184: checkcast 68	mxa
    //   187: getfield 226	mxa:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   190: ifnull +59 -> 249
    //   193: aload_0
    //   194: iload_2
    //   195: invokeinterface 212 2 0
    //   200: checkcast 68	mxa
    //   203: getfield 226	mxa:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   206: invokevirtual 229	java/io/RandomAccessFile:close	()V
    //   209: aload_0
    //   210: iload_2
    //   211: invokeinterface 232 2 0
    //   216: pop
    //   217: goto -181 -> 36
    //   220: astore 4
    //   222: aload 4
    //   224: invokevirtual 235	java/io/IOException:printStackTrace	()V
    //   227: aload_0
    //   228: iload_2
    //   229: invokeinterface 232 2 0
    //   234: pop
    //   235: goto -199 -> 36
    //   238: astore_3
    //   239: aload_0
    //   240: iload_2
    //   241: invokeinterface 232 2 0
    //   246: pop
    //   247: aload_3
    //   248: athrow
    //   249: aload_0
    //   250: iload_2
    //   251: invokeinterface 212 2 0
    //   256: checkcast 68	mxa
    //   259: iconst_0
    //   260: putfield 214	mxa:d	I
    //   263: aload_0
    //   264: iload_2
    //   265: invokeinterface 212 2 0
    //   270: checkcast 68	mxa
    //   273: getfield 226	mxa:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   276: lconst_0
    //   277: invokevirtual 239	java/io/RandomAccessFile:seek	(J)V
    //   280: aload 4
    //   282: aload_0
    //   283: iload_2
    //   284: invokeinterface 212 2 0
    //   289: checkcast 68	mxa
    //   292: getfield 214	mxa:d	I
    //   295: aload_0
    //   296: iload_2
    //   297: invokeinterface 212 2 0
    //   302: checkcast 68	mxa
    //   305: getfield 226	mxa:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   308: invokestatic 242	mwx:a	([BILjava/io/RandomAccessFile;)Z
    //   311: ifne +88 -> 399
    //   314: aload_0
    //   315: iload_2
    //   316: invokeinterface 212 2 0
    //   321: checkcast 68	mxa
    //   324: getfield 226	mxa:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   327: invokevirtual 229	java/io/RandomAccessFile:close	()V
    //   330: aload_0
    //   331: iload_2
    //   332: invokeinterface 232 2 0
    //   337: pop
    //   338: goto -302 -> 36
    //   341: astore 5
    //   343: ldc 158
    //   345: new 160	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   352: ldc 244
    //   354: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: iload_2
    //   358: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   361: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 187	bkdp:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: goto -87 -> 280
    //   370: astore 4
    //   372: aload 4
    //   374: invokevirtual 235	java/io/IOException:printStackTrace	()V
    //   377: aload_0
    //   378: iload_2
    //   379: invokeinterface 232 2 0
    //   384: pop
    //   385: goto -349 -> 36
    //   388: astore_3
    //   389: aload_0
    //   390: iload_2
    //   391: invokeinterface 232 2 0
    //   396: pop
    //   397: aload_3
    //   398: athrow
    //   399: aload 4
    //   401: aload_0
    //   402: iload_2
    //   403: invokeinterface 212 2 0
    //   408: checkcast 68	mxa
    //   411: getfield 247	mxa:jdField_a_of_type_Float	F
    //   414: invokestatic 250	mwx:a	([BF)V
    //   417: aload_3
    //   418: aload 4
    //   420: invokeinterface 254 2 0
    //   425: pop
    //   426: aload_0
    //   427: iload_2
    //   428: invokeinterface 212 2 0
    //   433: checkcast 68	mxa
    //   436: astore 4
    //   438: aload 4
    //   440: aload 4
    //   442: getfield 214	mxa:d	I
    //   445: iload_1
    //   446: iadd
    //   447: putfield 214	mxa:d	I
    //   450: goto -414 -> 36
    //   453: ldc 158
    //   455: new 160	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   462: ldc_w 256
    //   465: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: iload_2
    //   469: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   472: ldc_w 258
    //   475: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload_0
    //   479: iload_2
    //   480: invokeinterface 212 2 0
    //   485: checkcast 68	mxa
    //   488: getfield 217	mxa:c	I
    //   491: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 187	bkdp:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: aload_0
    //   501: iload_2
    //   502: invokeinterface 212 2 0
    //   507: checkcast 68	mxa
    //   510: getfield 226	mxa:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   513: ifnull -477 -> 36
    //   516: aload_0
    //   517: iload_2
    //   518: invokeinterface 212 2 0
    //   523: checkcast 68	mxa
    //   526: getfield 226	mxa:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   529: invokevirtual 229	java/io/RandomAccessFile:close	()V
    //   532: aload_0
    //   533: iload_2
    //   534: invokeinterface 232 2 0
    //   539: pop
    //   540: goto -504 -> 36
    //   543: astore 4
    //   545: aload 4
    //   547: invokevirtual 235	java/io/IOException:printStackTrace	()V
    //   550: aload_0
    //   551: iload_2
    //   552: invokeinterface 232 2 0
    //   557: pop
    //   558: goto -522 -> 36
    //   561: astore_3
    //   562: aload_0
    //   563: iload_2
    //   564: invokeinterface 232 2 0
    //   569: pop
    //   570: aload_3
    //   571: athrow
    //   572: aload_3
    //   573: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	574	0	paramList	List<mxa>
    //   0	574	1	paramInt	int
    //   9	555	2	j	int
    //   7	1	3	localArrayList	ArrayList
    //   238	10	3	localObject1	Object
    //   388	30	3	localObject2	Object
    //   561	12	3	localList	List<byte[]>
    //   96	3	4	arrayOfByte	byte[]
    //   220	61	4	localIOException1	IOException
    //   370	49	4	localIOException2	IOException
    //   436	5	4	localmxa1	mxa
    //   543	3	4	localIOException3	IOException
    //   147	5	5	localmxa2	mxa
    //   341	1	5	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   193	209	220	java/io/IOException
    //   193	209	238	finally
    //   222	227	238	finally
    //   263	280	341	java/io/IOException
    //   314	330	370	java/io/IOException
    //   314	330	388	finally
    //   372	377	388	finally
    //   516	532	543	java/io/IOException
    //   516	532	561	finally
    //   545	550	561	finally
  }
  
  private static List<byte[]> a(List<byte[]> paramList1, List<byte[]> paramList2)
  {
    int k = 0;
    ArrayList localArrayList = new ArrayList();
    int j;
    if (paramList1 != null)
    {
      j = 0;
      while (j < paramList1.size())
      {
        localArrayList.add(paramList1.get(j));
        j += 1;
      }
    }
    if (paramList2 != null)
    {
      j = k;
      while (j < paramList2.size())
      {
        localArrayList.add(paramList2.get(j));
        j += 1;
      }
    }
    return localArrayList;
  }
  
  public static mwx a()
  {
    if (jdField_a_of_type_Mwx == null) {}
    try
    {
      if (jdField_a_of_type_Mwx == null) {
        jdField_a_of_type_Mwx = new mwx(jdField_b_of_type_Bkdl);
      }
      return jdField_a_of_type_Mwx;
    }
    finally {}
  }
  
  public static mwx a(bkdl parambkdl)
  {
    if ((a()) && (jdField_b_of_type_Bkdl == null))
    {
      bkdp.b("AVGame_AudioMix", "destroyInstance when sMultiOperator == null.");
      a();
    }
    try
    {
      jdField_b_of_type_Bkdl = parambkdl;
      bkdp.c("AVGame_AudioMix", "createInstance. sMultiOperator = " + jdField_b_of_type_Bkdl, new Throwable("打印调用栈"));
      return a();
    }
    finally {}
  }
  
  private static mwz a(MediaExtractor paramMediaExtractor, String paramString)
  {
    int k = 0;
    File localFile = new File(paramString);
    bkdp.d("AVGame_AudioMix", "startDecodeMP3. mp3FilePath = " + paramString);
    if ((paramMediaExtractor == null) || (!localFile.exists()))
    {
      bkdp.a("AVGame_AudioMix", "startDecodeMP3 failed. !mp3File.exists().");
      return null;
    }
    mwz localmwz = new mwz(null);
    for (;;)
    {
      try
      {
        paramMediaExtractor.setDataSource(paramString);
        j = 0;
        if (j < paramMediaExtractor.getTrackCount())
        {
          MediaFormat localMediaFormat = paramMediaExtractor.getTrackFormat(j);
          String str = localMediaFormat.getString("mime");
          if (str.startsWith("audio"))
          {
            m = localMediaFormat.getInteger("sample-rate");
            k = localMediaFormat.getInteger("channel-count");
            n = 16;
            if (k > 2)
            {
              bkdp.a("AVGame_AudioMix", "startDecodeMP3 failed. channelNum > 2.");
              return null;
            }
            localmwz.jdField_a_of_type_Int = k;
            paramMediaExtractor.selectTrack(j);
            localmwz.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType(str);
            try
            {
              localmwz.jdField_a_of_type_AndroidMediaMediaCodec.configure(localMediaFormat, null, null, 0);
              j = n;
              if (localmwz.jdField_a_of_type_AndroidMediaMediaCodec != null) {
                break label270;
              }
              bkdp.a("AVGame_AudioMix", "startDecodeMP3 failed. mAudioCodec == null.");
              return null;
            }
            catch (Throwable paramMediaExtractor)
            {
              bkdp.a("AVGame_AudioMix", "startDecodeMP3 failed. configure exception: ", paramMediaExtractor);
              localmwz.jdField_a_of_type_AndroidMediaMediaCodec.release();
              localmwz.jdField_a_of_type_AndroidMediaMediaCodec = null;
              return null;
            }
          }
          else
          {
            j += 1;
            continue;
          }
          try
          {
            localmwz.jdField_a_of_type_AndroidMediaMediaCodec.start();
            bkdp.d("AVGame_AudioMix", "startDecodeMP3 successfully. mp3FilePath = " + paramString + ", fileSize = " + localFile.length() + ", sampleRate = " + m + ", channelNum = " + k + ", sampleSize = " + j);
            return localmwz;
          }
          catch (Exception paramMediaExtractor)
          {
            bkdp.a("AVGame_AudioMix", "startDecodeMP3 failed. AudioCodec.start failed.", paramMediaExtractor);
            localmwz.jdField_a_of_type_AndroidMediaMediaCodec.release();
            localmwz.jdField_a_of_type_AndroidMediaMediaCodec = null;
            return null;
          }
        }
      }
      catch (IOException paramMediaExtractor)
      {
        bkdp.a("AVGame_AudioMix", "startDecodeMP3 failed. exception: ", paramMediaExtractor);
        if (localmwz.jdField_a_of_type_AndroidMediaMediaCodec != null)
        {
          localmwz.jdField_a_of_type_AndroidMediaMediaCodec.release();
          localmwz.jdField_a_of_type_AndroidMediaMediaCodec = null;
        }
        return null;
      }
      label270:
      int n = 0;
      int m = 0;
      int j = k;
      k = n;
    }
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Mwx != null) {
      try
      {
        if (jdField_a_of_type_Mwx != null) {
          jdField_a_of_type_Mwx.b();
        }
        jdField_b_of_type_Bkdl = null;
        jdField_a_of_type_Mwx = null;
        bkdp.c("AVGame_AudioMix", "destroyInstance. sMultiOperator = " + jdField_b_of_type_Bkdl, new Throwable("打印调用栈"));
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
    int k = 0;
    label7:
    int m;
    int j;
    if (k < paramArrayOfByte.length / 2)
    {
      m = (short)(int)((short)(paramArrayOfByte[(k * 2)] & 0xFF | (paramArrayOfByte[(k * 2 + 1)] & 0xFF) << 8) * paramFloat);
      if (m <= 32767) {
        break label93;
      }
      j = 32767;
    }
    for (;;)
    {
      paramArrayOfByte[(k * 2)] = ((byte)(j & 0xFF));
      paramArrayOfByte[(k * 2 + 1)] = ((byte)((j & 0xFF00) >> 8));
      k += 1;
      break label7;
      break;
      label93:
      j = m;
      if (m < -32768) {
        j = -32768;
      }
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Mwx != null;
  }
  
  private boolean a(bkdl parambkdl)
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    if ((parambkdl == null) || (!(parambkdl instanceof ngc)))
    {
      this.jdField_a_of_type_Boolean = false;
      bkdp.a("AVGame_AudioMix", "init failed. multiOperator = " + parambkdl, new Throwable("打印调用栈"));
      return false;
    }
    this.jdField_a_of_type_Bkdl = parambkdl;
    this.jdField_a_of_type_Boolean = true;
    this.f = 0;
    this.g = 0;
    this.jdField_a_of_type_Long = 0L;
    this.h = 0;
    this.i = 0;
    this.jdField_b_of_type_Long = 0L;
    bkdp.d("AVGame_AudioMix", "init successfully.");
    return true;
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
          bkdp.a("AVGame_AudioMix", "readFile failed. readLen = " + paramInt + ", data.length = " + paramArrayOfByte.length);
        }
        return bool;
      }
      return false;
    }
    catch (IOException paramArrayOfByte)
    {
      bkdp.a("AVGame_AudioMix", "readFile failed. ", paramArrayOfByte);
    }
  }
  
  private static boolean a(byte[] paramArrayOfByte, List<byte[]> paramList)
  {
    if (paramArrayOfByte == null)
    {
      bkdp.b("AVGame_AudioMix", "no to mix this data. param error. mixData == null.");
      return false;
    }
    if (paramList == null)
    {
      bkdp.b("AVGame_AudioMix", "no to mix this data. param error. pcmDataList == null.");
      return false;
    }
    if (paramList.size() == 0)
    {
      bkdp.b("AVGame_AudioMix", "no to mix this data. param error. pcmDataList.size() == 0.");
      return false;
    }
    if (((byte[])paramList.get(0)).length % 2 != 0)
    {
      bkdp.b("AVGame_AudioMix", "no to mix this data. param error. pcmDataList.get(0).length = " + ((byte[])paramList.get(0)).length);
      return false;
    }
    if (paramArrayOfByte.length < ((byte[])paramList.get(0)).length)
    {
      bkdp.b("AVGame_AudioMix", "no to mix this data. param error. mixData.length = " + paramArrayOfByte.length + ", pcmDataList.get(0).length = " + ((byte[])paramList.get(0)).length);
      return false;
    }
    int n = paramList.size();
    int i1 = ((byte[])paramList.get(0)).length;
    if (n == 1)
    {
      System.arraycopy(paramList.get(0), 0, paramArrayOfByte, 0, i1);
      return true;
    }
    int k = 0;
    label210:
    int j;
    int m;
    if (k < i1 / 2)
    {
      j = 0;
      m = 0;
      while (j < n)
      {
        int i2 = ((byte[])paramList.get(j))[(k * 2)];
        m += (short)((((byte[])paramList.get(j))[(k * 2 + 1)] & 0xFF) << 8 | i2 & 0xFF);
        j += 1;
      }
      m /= n;
      if (m <= 32767) {
        break label343;
      }
      j = 32767;
    }
    for (;;)
    {
      paramArrayOfByte[(k * 2)] = ((byte)((short)j & 0xFF));
      paramArrayOfByte[(k * 2 + 1)] = ((byte)(((short)j & 0xFF00) >> 8));
      k += 1;
      break label210;
      break;
      label343:
      j = m;
      if (m < -32768) {
        j = -32768;
      }
    }
  }
  
  private static List<byte[]> b(List<mxa> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    if (j < paramList.size())
    {
      if ((((mxa)paramList.get(j)).jdField_b_of_type_Int != 1) || (((mxa)paramList.get(j)).jdField_a_of_type_AndroidMediaMediaExtractor == null) || (((mxa)paramList.get(j)).jdField_a_of_type_AndroidMediaMediaCodec == null)) {}
      for (;;)
      {
        j += 1;
        break;
        byte[] arrayOfByte = new byte[paramInt];
        int k = a(arrayOfByte, (mxa)paramList.get(j));
        if (k == 0)
        {
          a(arrayOfByte, ((mxa)paramList.get(j)).jdField_a_of_type_Float);
          localArrayList.add(arrayOfByte);
        }
        else if ((k == 1) || (k == 2))
        {
          bkdp.a("AVGame_AudioMix", "getPCMDataFromMP3File failed. ret = " + k);
          if (((mxa)paramList.get(j)).jdField_a_of_type_AndroidMediaMediaCodec != null) {}
          try
          {
            ((mxa)paramList.get(j)).jdField_a_of_type_AndroidMediaMediaCodec.stop();
            ((mxa)paramList.get(j)).jdField_a_of_type_AndroidMediaMediaCodec.release();
            ((mxa)paramList.get(j)).jdField_a_of_type_AndroidMediaMediaCodec = null;
            if (((mxa)paramList.get(j)).jdField_a_of_type_AndroidMediaMediaExtractor != null)
            {
              ((mxa)paramList.get(j)).jdField_a_of_type_AndroidMediaMediaExtractor.release();
              ((mxa)paramList.get(j)).jdField_a_of_type_AndroidMediaMediaExtractor = null;
            }
            if ((k == 1) || (((mxa)paramList.get(j)).c <= 1)) {
              paramList.remove(j);
            }
          }
          catch (IllegalStateException localIllegalStateException)
          {
            for (;;)
            {
              bkdp.b("AVGame_AudioMix", "mp3Decoder stop failed.", localIllegalStateException);
            }
          }
          if (((mxa)paramList.get(j)).c > 1)
          {
            Object localObject = (mxa)paramList.get(j);
            ((mxa)localObject).c -= 1;
            localObject = new MediaExtractor();
            mwz localmwz = a((MediaExtractor)localObject, ((mxa)paramList.get(j)).jdField_a_of_type_JavaLangString);
            if ((localmwz != null) && (localmwz.jdField_a_of_type_AndroidMediaMediaCodec != null))
            {
              ((mxa)paramList.get(j)).jdField_a_of_type_AndroidMediaMediaExtractor = ((MediaExtractor)localObject);
              ((mxa)paramList.get(j)).jdField_a_of_type_AndroidMediaMediaCodec = localmwz.jdField_a_of_type_AndroidMediaMediaCodec;
            }
            else
            {
              bkdp.a("AVGame_AudioMix", "getPCMDataFromMP3File failed. startDecodeMP3 failed.");
              paramList.remove(j);
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3) {
      if ((this.jdField_a_of_type_Int == 1) && ((this.jdField_b_of_type_Int & 0x2) > 0) && ((this.jdField_a_of_type_JavaUtilList.size() > 0) || (this.jdField_a_of_type_JavaUtilQueue.size() > 0)))
      {
        localList = a(a(this.jdField_a_of_type_JavaUtilList, paramInt2), b(this.jdField_a_of_type_JavaUtilList, paramInt2));
        if (this.jdField_a_of_type_JavaUtilQueue.size() <= 0) {}
      }
    }
    while ((paramInt1 != 100) || (this.c != 1) || (this.jdField_a_of_type_Mxb == null)) {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        List localList;
        if (this.jdField_a_of_type_JavaUtilQueue.size() > 0) {
          localList.add(this.jdField_a_of_type_JavaUtilQueue.poll());
        }
        a(paramArrayOfByte, localList);
        return;
      }
    }
    this.jdField_a_of_type_Mxb.a(paramArrayOfByte);
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	mwx:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: iconst_0
    //   8: istore_2
    //   9: iload_2
    //   10: aload_0
    //   11: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   14: invokeinterface 209 1 0
    //   19: if_icmpge +328 -> 347
    //   22: aload_0
    //   23: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   26: iload_2
    //   27: invokeinterface 212 2 0
    //   32: checkcast 68	mxa
    //   35: getfield 452	mxa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   38: aload_1
    //   39: invokevirtual 482	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   42: ifeq +308 -> 350
    //   45: aload_0
    //   46: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   49: iload_2
    //   50: invokeinterface 212 2 0
    //   55: checkcast 68	mxa
    //   58: getfield 226	mxa:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +74 -> 137
    //   66: aload_0
    //   67: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   70: iload_2
    //   71: invokeinterface 212 2 0
    //   76: checkcast 68	mxa
    //   79: getfield 226	mxa:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   82: invokevirtual 229	java/io/RandomAccessFile:close	()V
    //   85: aload_0
    //   86: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   89: iload_2
    //   90: invokeinterface 232 2 0
    //   95: pop
    //   96: aload_3
    //   97: monitorexit
    //   98: return
    //   99: astore_1
    //   100: aload_1
    //   101: invokevirtual 235	java/io/IOException:printStackTrace	()V
    //   104: aload_0
    //   105: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   108: iload_2
    //   109: invokeinterface 232 2 0
    //   114: pop
    //   115: goto -19 -> 96
    //   118: astore_1
    //   119: aload_3
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    //   123: astore_1
    //   124: aload_0
    //   125: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   128: iload_2
    //   129: invokeinterface 232 2 0
    //   134: pop
    //   135: aload_1
    //   136: athrow
    //   137: aload_0
    //   138: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   141: iload_2
    //   142: invokeinterface 212 2 0
    //   147: checkcast 68	mxa
    //   150: getfield 71	mxa:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   153: ifnonnull +22 -> 175
    //   156: aload_0
    //   157: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   160: iload_2
    //   161: invokeinterface 212 2 0
    //   166: checkcast 68	mxa
    //   169: getfield 74	mxa:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   172: ifnull +161 -> 333
    //   175: aload_0
    //   176: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   179: iload_2
    //   180: invokeinterface 212 2 0
    //   185: checkcast 68	mxa
    //   188: getfield 74	mxa:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   191: astore_1
    //   192: aload_1
    //   193: ifnull +58 -> 251
    //   196: aload_0
    //   197: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   200: iload_2
    //   201: invokeinterface 212 2 0
    //   206: checkcast 68	mxa
    //   209: getfield 74	mxa:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   212: invokevirtual 443	android/media/MediaCodec:stop	()V
    //   215: aload_0
    //   216: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   219: iload_2
    //   220: invokeinterface 212 2 0
    //   225: checkcast 68	mxa
    //   228: getfield 74	mxa:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   231: invokevirtual 359	android/media/MediaCodec:release	()V
    //   234: aload_0
    //   235: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   238: iload_2
    //   239: invokeinterface 212 2 0
    //   244: checkcast 68	mxa
    //   247: aconst_null
    //   248: putfield 74	mxa:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   251: aload_0
    //   252: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   255: iload_2
    //   256: invokeinterface 212 2 0
    //   261: checkcast 68	mxa
    //   264: getfield 71	mxa:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   267: ifnull +39 -> 306
    //   270: aload_0
    //   271: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   274: iload_2
    //   275: invokeinterface 212 2 0
    //   280: checkcast 68	mxa
    //   283: getfield 71	mxa:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   286: invokevirtual 444	android/media/MediaExtractor:release	()V
    //   289: aload_0
    //   290: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   293: iload_2
    //   294: invokeinterface 212 2 0
    //   299: checkcast 68	mxa
    //   302: aconst_null
    //   303: putfield 71	mxa:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   306: aload_0
    //   307: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   310: iload_2
    //   311: invokeinterface 232 2 0
    //   316: pop
    //   317: aload_3
    //   318: monitorexit
    //   319: return
    //   320: astore_1
    //   321: ldc 158
    //   323: ldc_w 446
    //   326: aload_1
    //   327: invokestatic 448	bkdp:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   330: goto -96 -> 234
    //   333: aload_0
    //   334: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   337: iload_2
    //   338: invokeinterface 232 2 0
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
    //   0	357	0	this	mwx
    //   0	357	1	paramString	String
    //   8	346	2	j	int
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
  
  /* Error */
  @RequiresApi(api=21)
  public void a(String arg1, int paramInt1, float paramFloat, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 390	mwx:jdField_a_of_type_Boolean	Z
    //   4: ifeq +22 -> 26
    //   7: aload_0
    //   8: getfield 396	mwx:jdField_a_of_type_Bkdl	Lbkdl;
    //   11: ifnull +15 -> 26
    //   14: aload_1
    //   15: invokestatic 490	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifne +8 -> 26
    //   21: iload 4
    //   23: ifgt +12 -> 35
    //   26: ldc 158
    //   28: ldc_w 492
    //   31: invokestatic 187	bkdp:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: return
    //   35: aload_0
    //   36: getfield 55	mwx:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   39: astore 7
    //   41: aload 7
    //   43: monitorenter
    //   44: iconst_0
    //   45: istore 6
    //   47: iload 6
    //   49: aload_0
    //   50: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   53: invokeinterface 209 1 0
    //   58: if_icmpge +46 -> 104
    //   61: aload_0
    //   62: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   65: iload 6
    //   67: invokeinterface 212 2 0
    //   72: checkcast 68	mxa
    //   75: getfield 452	mxa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   78: aload_1
    //   79: invokevirtual 482	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
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
    //   107: new 68	mxa
    //   110: dup
    //   111: invokespecial 493	mxa:<init>	()V
    //   114: astore 7
    //   116: aload 7
    //   118: aload_1
    //   119: putfield 452	mxa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   122: aload 7
    //   124: iload_2
    //   125: putfield 213	mxa:jdField_b_of_type_Int	I
    //   128: aload 7
    //   130: iload 4
    //   132: putfield 217	mxa:c	I
    //   135: fload_3
    //   136: ldc_w 494
    //   139: fcmpg
    //   140: ifge +91 -> 231
    //   143: ldc_w 494
    //   146: fstore 5
    //   148: aload 7
    //   150: fload 5
    //   152: putfield 247	mxa:jdField_a_of_type_Float	F
    //   155: iload_2
    //   156: ifne +126 -> 282
    //   159: aload_1
    //   160: invokestatic 496	mwx:a	(Ljava/lang/String;)Ljava/io/RandomAccessFile;
    //   163: astore_1
    //   164: aload_1
    //   165: ifnull +108 -> 273
    //   168: aload 7
    //   170: aload_1
    //   171: putfield 226	mxa:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   174: aload 7
    //   176: aload_1
    //   177: invokevirtual 497	java/io/RandomAccessFile:length	()J
    //   180: putfield 216	mxa:jdField_a_of_type_Long	J
    //   183: aload_0
    //   184: getfield 55	mwx:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   187: astore_1
    //   188: aload_1
    //   189: monitorenter
    //   190: aload_0
    //   191: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   194: aload 7
    //   196: invokeinterface 254 2 0
    //   201: pop
    //   202: aload_1
    //   203: monitorexit
    //   204: ldc 158
    //   206: new 160	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   213: ldc_w 499
    //   216: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload 7
    //   221: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 302	bkdp:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: return
    //   231: fload_3
    //   232: fstore 5
    //   234: fload_3
    //   235: ldc_w 500
    //   238: fcmpl
    //   239: ifle -91 -> 148
    //   242: ldc_w 500
    //   245: fstore 5
    //   247: goto -99 -> 148
    //   250: astore 7
    //   252: ldc 158
    //   254: ldc_w 502
    //   257: aload 7
    //   259: invokestatic 203	bkdp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   262: aload_1
    //   263: invokevirtual 229	java/io/RandomAccessFile:close	()V
    //   266: return
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 235	java/io/IOException:printStackTrace	()V
    //   272: return
    //   273: ldc 158
    //   275: ldc_w 504
    //   278: invokestatic 187	bkdp:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: return
    //   282: iload_2
    //   283: iconst_1
    //   284: if_icmpne +79 -> 363
    //   287: new 105	android/media/MediaExtractor
    //   290: dup
    //   291: invokespecial 449	android/media/MediaExtractor:<init>	()V
    //   294: astore 8
    //   296: aload 8
    //   298: aload_1
    //   299: invokestatic 454	mwx:a	(Landroid/media/MediaExtractor;Ljava/lang/String;)Lmwz;
    //   302: astore_1
    //   303: aload_1
    //   304: ifnull +50 -> 354
    //   307: aload_1
    //   308: getfield 348	mwz:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   311: ifnull +43 -> 354
    //   314: aload 7
    //   316: aload 8
    //   318: putfield 71	mxa:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   321: aload 7
    //   323: aload_1
    //   324: getfield 348	mwz:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   327: putfield 74	mxa:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   330: aload 7
    //   332: aload_1
    //   333: getfield 339	mwz:jdField_a_of_type_Int	I
    //   336: putfield 79	mxa:jdField_a_of_type_Int	I
    //   339: aload 7
    //   341: new 129	android/media/MediaCodec$BufferInfo
    //   344: dup
    //   345: invokespecial 505	android/media/MediaCodec$BufferInfo:<init>	()V
    //   348: putfield 123	mxa:jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   351: goto -168 -> 183
    //   354: ldc 158
    //   356: ldc_w 507
    //   359: invokestatic 187	bkdp:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: return
    //   363: ldc 158
    //   365: new 160	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   372: ldc_w 509
    //   375: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: iload_2
    //   379: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   382: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 187	bkdp:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   388: return
    //   389: astore 7
    //   391: aload_1
    //   392: monitorexit
    //   393: aload 7
    //   395: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	this	mwx
    //   0	396	2	paramInt1	int
    //   0	396	3	paramFloat	float
    //   0	396	4	paramInt2	int
    //   146	100	5	f1	float
    //   45	55	6	j	int
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
    int k = 0;
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bkdl == null) || (paramArrayOfByte == null) || (paramArrayOfByte.length < paramInt))
    {
      bkdp.a("AVGame_AudioMix", "addPCMData failed. !mIsInited || mMultiOperator == null || pcmData == null.");
      return;
    }
    if (this.f == 0) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    this.f += 1;
    this.g += paramInt;
    if (this.f == 100)
    {
      long l = System.currentTimeMillis();
      bkdp.d("AVGame_AudioMix", "addPCMData. mAddCnt = " + this.f + ", mAddLen = " + this.g + ", mAddStartTime = " + this.jdField_a_of_type_Long + ", addEndTime = " + l + ", mAddTimeLen = " + (l - this.jdField_a_of_type_Long));
      this.f = 0;
      this.g = 0;
      this.jdField_a_of_type_Long = 0L;
    }
    Object localObject = this.jdField_b_of_type_JavaLangObject;
    byte[] arrayOfByte = paramArrayOfByte;
    for (;;)
    {
      try
      {
        if (this.e > 0)
        {
          arrayOfByte = new byte[this.e + paramInt];
          System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, arrayOfByte, 0, this.e);
          System.arraycopy(paramArrayOfByte, 0, arrayOfByte, this.e, paramInt);
          this.e = 0;
        }
        int m = arrayOfByte.length / 1920;
        if (m > 0)
        {
          int n = this.jdField_a_of_type_JavaUtilQueue.size();
          paramInt = 0;
          int j = k;
          if (paramInt < n + m - 25)
          {
            this.jdField_a_of_type_JavaUtilQueue.poll();
            paramInt += 1;
            continue;
          }
          if (j < m)
          {
            paramArrayOfByte = new byte[1920];
            System.arraycopy(arrayOfByte, j * 1920, paramArrayOfByte, 0, 1920);
            this.jdField_a_of_type_JavaUtilQueue.offer(paramArrayOfByte);
            j += 1;
            continue;
          }
          paramInt = arrayOfByte.length % 1920;
          if (paramInt > 0)
          {
            if (this.jdField_a_of_type_ArrayOfByte == null) {
              this.jdField_a_of_type_ArrayOfByte = new byte[1920];
            }
            System.arraycopy(arrayOfByte, arrayOfByte.length - paramInt, this.jdField_a_of_type_ArrayOfByte, 0, paramInt);
            this.e = paramInt;
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
      this.e = paramInt;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    int j = paramInt2;
    if (paramInt2 % 2 != 0)
    {
      bkdp.a("AVGame_AudioMix", "onReceiveAudioFrame. size = " + paramInt2);
      j = paramInt2 - 1;
    }
    if (this.h == 0) {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
    this.h += 1;
    this.i += j;
    long l;
    if (this.h == 400)
    {
      l = System.currentTimeMillis();
      bkdp.d("AVGame_AudioMix", "onReceiveAudioFrame. mMixCnt = " + this.h + ", mMixLen = " + this.i + ", mMixStartTime = " + this.jdField_b_of_type_Long + ", mixEndTime = " + l + ", mMixTimeLen = " + (l - this.jdField_b_of_type_Long));
      this.h = 0;
      this.i = 0;
      this.jdField_b_of_type_Long = 0L;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      l = System.currentTimeMillis();
      b(paramArrayOfByte, paramInt1, j);
      l = System.currentTimeMillis() - l;
      if (l > 15L) {
        bkdp.b("AVGame_AudioMix", "onReceiveAudioFrame. mix. srcType = " + paramInt1 + ", big timelen = " + l);
      }
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bkdl == null))
    {
      bkdp.a("AVGame_AudioMix", "startPlay failed. !mIsInited || mMultiOperator == null.");
      return false;
    }
    if (b()) {
      return true;
    }
    if (paramInt <= 0)
    {
      bkdp.a("AVGame_AudioMix", "startPlay failed. mixSrcType = " + paramInt);
      return false;
    }
    int j = ((ngc)this.jdField_a_of_type_Bkdl).a(3, true);
    if (j != 0)
    {
      bkdp.a("AVGame_AudioMix", "startPlay failed. registerGAudioDataCallback failed. ret = " + j);
      return false;
    }
    j = ((ngc)this.jdField_a_of_type_Bkdl).a(3, 48000, 1, 16);
    if (j != 0)
    {
      bkdp.a("AVGame_AudioMix", "startPlay failed. setGAudioFormat failed. ret = " + j);
      return false;
    }
    ((ngc)this.jdField_a_of_type_Bkdl).a(1, this);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Int = 1;
    bkdp.d("AVGame_AudioMix", "startPlay successfully. mixSrcType = " + paramInt + ", ret = " + j);
    return true;
  }
  
  public boolean a(int paramInt, mxb parammxb)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bkdl == null))
    {
      bkdp.a("AVGame_AudioMix", "startRecord failed. !mIsInited || mMultiOperator == null.");
      return false;
    }
    if (mrn.a())
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 2131690238, 1).a();
      return false;
    }
    if (c()) {
      return true;
    }
    if ((paramInt <= 0) || (((paramInt & 0x4) == 0) && ((paramInt & 0x1) == 0)))
    {
      bkdp.a("AVGame_AudioMix", "startRecord failed. mixSrcType = " + paramInt);
      return false;
    }
    int j;
    int k;
    if ((paramInt & 0x4) > 0)
    {
      j = ((ngc)this.jdField_a_of_type_Bkdl).a(0, true);
      k = ((ngc)this.jdField_a_of_type_Bkdl).a(0, 48000, 1, 16);
      if ((j != 0) || (k != 0))
      {
        bkdp.a("AVGame_AudioMix", "startRecord failed. MIX_SRC_TYPE_MIC. ret1 = " + j + ", ret2 = " + k);
        return false;
      }
    }
    if ((paramInt & 0x1) > 0)
    {
      j = ((ngc)this.jdField_a_of_type_Bkdl).a(4, true);
      k = ((ngc)this.jdField_a_of_type_Bkdl).a(4, 48000, 1, 16);
      if ((j != 0) || (k != 0))
      {
        bkdp.a("AVGame_AudioMix", "startRecord failed. MIX_SRC_TYPE_RECV. ret1 = " + j + ", ret2 = " + k);
        return false;
      }
    }
    this.jdField_a_of_type_Mxb = parammxb;
    ((ngc)this.jdField_a_of_type_Bkdl).a(0, this);
    this.d = paramInt;
    this.c = 1;
    bkdp.d("AVGame_AudioMix", "startRecord successfully. mixSrcType = " + paramInt);
    return true;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 390	mwx:jdField_a_of_type_Boolean	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 398	mwx:f	I
    //   12: ifeq +86 -> 98
    //   15: invokestatic 516	java/lang/System:currentTimeMillis	()J
    //   18: lstore_2
    //   19: ldc 158
    //   21: new 160	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 611
    //   31: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: getfield 398	mwx:f	I
    //   38: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 520
    //   44: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_0
    //   48: getfield 400	mwx:g	I
    //   51: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: ldc_w 522
    //   57: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_0
    //   61: getfield 401	mwx:jdField_a_of_type_Long	J
    //   64: invokevirtual 375	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   67: ldc_w 524
    //   70: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: lload_2
    //   74: invokevirtual 375	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   77: ldc_w 526
    //   80: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: lload_2
    //   84: aload_0
    //   85: getfield 401	mwx:jdField_a_of_type_Long	J
    //   88: lsub
    //   89: invokevirtual 375	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   92: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 302	bkdp:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 398	mwx:f	I
    //   103: aload_0
    //   104: iconst_0
    //   105: putfield 400	mwx:g	I
    //   108: aload_0
    //   109: lconst_0
    //   110: putfield 401	mwx:jdField_a_of_type_Long	J
    //   113: aload_0
    //   114: getfield 403	mwx:h	I
    //   117: ifeq +86 -> 203
    //   120: invokestatic 516	java/lang/System:currentTimeMillis	()J
    //   123: lstore_2
    //   124: ldc 158
    //   126: new 160	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   133: ldc_w 613
    //   136: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_0
    //   140: getfield 403	mwx:h	I
    //   143: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   146: ldc_w 537
    //   149: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_0
    //   153: getfield 405	mwx:i	I
    //   156: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: ldc_w 539
    //   162: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload_0
    //   166: getfield 407	mwx:jdField_b_of_type_Long	J
    //   169: invokevirtual 375	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   172: ldc_w 541
    //   175: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: lload_2
    //   179: invokevirtual 375	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   182: ldc_w 543
    //   185: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: lload_2
    //   189: aload_0
    //   190: getfield 407	mwx:jdField_b_of_type_Long	J
    //   193: lsub
    //   194: invokevirtual 375	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   197: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 302	bkdp:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_0
    //   204: iconst_0
    //   205: putfield 403	mwx:h	I
    //   208: aload_0
    //   209: iconst_0
    //   210: putfield 405	mwx:i	I
    //   213: aload_0
    //   214: lconst_0
    //   215: putfield 407	mwx:jdField_b_of_type_Long	J
    //   218: aload_0
    //   219: invokevirtual 615	mwx:c	()V
    //   222: aload_0
    //   223: invokevirtual 617	mwx:f	()V
    //   226: aload_0
    //   227: aconst_null
    //   228: putfield 396	mwx:jdField_a_of_type_Bkdl	Lbkdl;
    //   231: aload_0
    //   232: getfield 55	mwx:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   235: astore 4
    //   237: aload 4
    //   239: monitorenter
    //   240: iconst_0
    //   241: istore_1
    //   242: iload_1
    //   243: aload_0
    //   244: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   247: invokeinterface 209 1 0
    //   252: if_icmpge +315 -> 567
    //   255: aload_0
    //   256: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   259: iload_1
    //   260: invokeinterface 212 2 0
    //   265: checkcast 68	mxa
    //   268: getfield 226	mxa:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   271: astore 5
    //   273: aload 5
    //   275: ifnull +103 -> 378
    //   278: aload_0
    //   279: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   282: iload_1
    //   283: invokeinterface 212 2 0
    //   288: checkcast 68	mxa
    //   291: getfield 226	mxa:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   294: invokevirtual 229	java/io/RandomAccessFile:close	()V
    //   297: aload_0
    //   298: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   301: iload_1
    //   302: invokeinterface 212 2 0
    //   307: checkcast 68	mxa
    //   310: aconst_null
    //   311: putfield 226	mxa:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   314: iload_1
    //   315: iconst_1
    //   316: iadd
    //   317: istore_1
    //   318: goto -76 -> 242
    //   321: astore 5
    //   323: aload 5
    //   325: invokevirtual 235	java/io/IOException:printStackTrace	()V
    //   328: aload_0
    //   329: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   332: iload_1
    //   333: invokeinterface 212 2 0
    //   338: checkcast 68	mxa
    //   341: aconst_null
    //   342: putfield 226	mxa:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   345: goto -31 -> 314
    //   348: astore 5
    //   350: aload 4
    //   352: monitorexit
    //   353: aload 5
    //   355: athrow
    //   356: astore 5
    //   358: aload_0
    //   359: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   362: iload_1
    //   363: invokeinterface 212 2 0
    //   368: checkcast 68	mxa
    //   371: aconst_null
    //   372: putfield 226	mxa:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   375: aload 5
    //   377: athrow
    //   378: aload_0
    //   379: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   382: iload_1
    //   383: invokeinterface 212 2 0
    //   388: checkcast 68	mxa
    //   391: getfield 71	mxa:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   394: ifnonnull +22 -> 416
    //   397: aload_0
    //   398: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   401: iload_1
    //   402: invokeinterface 212 2 0
    //   407: checkcast 68	mxa
    //   410: getfield 74	mxa:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   413: ifnull -99 -> 314
    //   416: aload_0
    //   417: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   420: iload_1
    //   421: invokeinterface 212 2 0
    //   426: checkcast 68	mxa
    //   429: getfield 74	mxa:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   432: astore 5
    //   434: aload 5
    //   436: ifnull +58 -> 494
    //   439: aload_0
    //   440: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   443: iload_1
    //   444: invokeinterface 212 2 0
    //   449: checkcast 68	mxa
    //   452: getfield 74	mxa:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   455: invokevirtual 443	android/media/MediaCodec:stop	()V
    //   458: aload_0
    //   459: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   462: iload_1
    //   463: invokeinterface 212 2 0
    //   468: checkcast 68	mxa
    //   471: getfield 74	mxa:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   474: invokevirtual 359	android/media/MediaCodec:release	()V
    //   477: aload_0
    //   478: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   481: iload_1
    //   482: invokeinterface 212 2 0
    //   487: checkcast 68	mxa
    //   490: aconst_null
    //   491: putfield 74	mxa:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   494: aload_0
    //   495: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   498: iload_1
    //   499: invokeinterface 212 2 0
    //   504: checkcast 68	mxa
    //   507: getfield 71	mxa:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   510: ifnull -196 -> 314
    //   513: aload_0
    //   514: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   517: iload_1
    //   518: invokeinterface 212 2 0
    //   523: checkcast 68	mxa
    //   526: getfield 71	mxa:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   529: invokevirtual 444	android/media/MediaExtractor:release	()V
    //   532: aload_0
    //   533: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   536: iload_1
    //   537: invokeinterface 212 2 0
    //   542: checkcast 68	mxa
    //   545: aconst_null
    //   546: putfield 71	mxa:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   549: goto -235 -> 314
    //   552: astore 5
    //   554: ldc 158
    //   556: ldc_w 446
    //   559: aload 5
    //   561: invokestatic 448	bkdp:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   564: goto -87 -> 477
    //   567: aload_0
    //   568: getfield 48	mwx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   571: invokeinterface 619 1 0
    //   576: aload 4
    //   578: monitorexit
    //   579: aload_0
    //   580: getfield 57	mwx:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   583: astore 4
    //   585: aload 4
    //   587: monitorenter
    //   588: aload_0
    //   589: getfield 53	mwx:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   592: invokeinterface 620 1 0
    //   597: aload 4
    //   599: monitorexit
    //   600: aload_0
    //   601: iconst_0
    //   602: putfield 390	mwx:jdField_a_of_type_Boolean	Z
    //   605: ldc 158
    //   607: ldc_w 622
    //   610: invokestatic 302	bkdp:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: return
    //   614: astore 5
    //   616: aload 4
    //   618: monitorexit
    //   619: aload 5
    //   621: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	622	0	this	mwx
    //   241	296	1	j	int
    //   18	171	2	l	long
    //   271	3	5	localRandomAccessFile	RandomAccessFile
    //   321	3	5	localIOException	IOException
    //   348	6	5	localObject2	Object
    //   356	20	5	localObject3	Object
    //   432	3	5	localMediaCodec	MediaCodec
    //   552	8	5	localIllegalStateException	IllegalStateException
    //   614	6	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   278	297	321	java/io/IOException
    //   242	273	348	finally
    //   297	314	348	finally
    //   328	345	348	finally
    //   350	353	348	finally
    //   358	378	348	finally
    //   378	416	348	finally
    //   416	434	348	finally
    //   439	477	348	finally
    //   477	494	348	finally
    //   494	549	348	finally
    //   554	564	348	finally
    //   567	579	348	finally
    //   278	297	356	finally
    //   323	328	356	finally
    //   439	477	552	java/lang/IllegalStateException
    //   588	600	614	finally
    //   616	619	614	finally
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int != 0;
  }
  
  public void c()
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bkdl == null)) {}
    while (!b()) {
      return;
    }
    try
    {
      ((ngc)this.jdField_a_of_type_Bkdl).a(1, null);
      int j = ((ngc)this.jdField_a_of_type_Bkdl).a(3);
      this.jdField_a_of_type_Int = 0;
      bkdp.d("AVGame_AudioMix", "stopPlay successfully. ret = " + j);
      return;
    }
    catch (Exception localException)
    {
      bkdp.a("AVGame_AudioMix", "stopPlay failed. ", localException);
    }
  }
  
  public boolean c()
  {
    return this.c != 0;
  }
  
  public void d()
  {
    if (b()) {
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  public void e()
  {
    if (b()) {
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public void f()
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bkdl == null)) {}
    while (!c()) {
      return;
    }
    try
    {
      this.jdField_a_of_type_Mxb = null;
      ((ngc)this.jdField_a_of_type_Bkdl).a(0, null);
      if ((this.d & 0x4) > 0) {
        ((ngc)this.jdField_a_of_type_Bkdl).a(0);
      }
      if ((this.d & 0x1) > 0) {
        ((ngc)this.jdField_a_of_type_Bkdl).a(4);
      }
      this.c = 0;
      bkdp.d("AVGame_AudioMix", "stopRecord sucessfully.");
      return;
    }
    catch (Exception localException)
    {
      bkdp.a("AVGame_AudioMix", "stopRecord failed.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mwx
 * JD-Core Version:    0.7.0.1
 */