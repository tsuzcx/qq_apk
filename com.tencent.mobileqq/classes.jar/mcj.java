import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;

public class mcj
{
  private int jdField_a_of_type_Int = 4096;
  private LruCache<String, mcl> jdField_a_of_type_AndroidUtilLruCache = new mck(this, 4194304);
  private LinkedList<mcm> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private mcm jdField_a_of_type_Mcm;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private byte[] b;
  
  public mcj(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
    this.b = new byte[paramInt];
  }
  
  /* Error */
  private static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 51	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 53	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 56	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: astore_3
    //   22: aload_3
    //   23: astore_0
    //   24: aload_3
    //   25: invokevirtual 60	java/io/FileInputStream:available	()I
    //   28: istore_1
    //   29: aload_3
    //   30: astore_0
    //   31: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +30 -> 64
    //   37: aload_3
    //   38: astore_0
    //   39: ldc 67
    //   41: iconst_2
    //   42: new 69	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   49: ldc 72
    //   51: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: iload_1
    //   55: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 87	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: iload_1
    //   65: ldc 23
    //   67: if_icmple +30 -> 97
    //   70: aload_3
    //   71: astore_0
    //   72: ldc 67
    //   74: iconst_1
    //   75: ldc 89
    //   77: invokestatic 87	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_3
    //   81: ifnull -70 -> 11
    //   84: aload_3
    //   85: invokevirtual 92	java/io/FileInputStream:close	()V
    //   88: aconst_null
    //   89: areturn
    //   90: astore_0
    //   91: aload_0
    //   92: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   95: aconst_null
    //   96: areturn
    //   97: aload_3
    //   98: astore_0
    //   99: iload_1
    //   100: newarray byte
    //   102: astore 4
    //   104: aload_3
    //   105: astore_0
    //   106: aload_3
    //   107: aload 4
    //   109: iconst_0
    //   110: iload_1
    //   111: invokevirtual 99	java/io/FileInputStream:read	([BII)I
    //   114: istore_2
    //   115: aload_3
    //   116: astore_0
    //   117: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +30 -> 150
    //   123: aload_3
    //   124: astore_0
    //   125: ldc 67
    //   127: iconst_2
    //   128: new 69	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   135: ldc 101
    //   137: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: iload_2
    //   141: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 87	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: iload_2
    //   151: iload_1
    //   152: if_icmpne +16 -> 168
    //   155: aload 4
    //   157: astore_0
    //   158: aload_3
    //   159: ifnull +7 -> 166
    //   162: aload_3
    //   163: invokevirtual 92	java/io/FileInputStream:close	()V
    //   166: aload_0
    //   167: areturn
    //   168: aconst_null
    //   169: astore_0
    //   170: goto -12 -> 158
    //   173: astore_3
    //   174: aload_3
    //   175: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   178: goto -12 -> 166
    //   181: astore 4
    //   183: aconst_null
    //   184: astore_3
    //   185: aload_3
    //   186: astore_0
    //   187: ldc 67
    //   189: iconst_1
    //   190: ldc 103
    //   192: aload 4
    //   194: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   197: aload_3
    //   198: astore_0
    //   199: aload 4
    //   201: invokevirtual 108	java/lang/OutOfMemoryError:printStackTrace	()V
    //   204: aload_3
    //   205: astore_0
    //   206: invokestatic 113	java/lang/System:gc	()V
    //   209: aload_3
    //   210: ifnull -199 -> 11
    //   213: aload_3
    //   214: invokevirtual 92	java/io/FileInputStream:close	()V
    //   217: aconst_null
    //   218: areturn
    //   219: astore_0
    //   220: aload_0
    //   221: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   224: aconst_null
    //   225: areturn
    //   226: astore 4
    //   228: aconst_null
    //   229: astore_3
    //   230: aload_3
    //   231: astore_0
    //   232: ldc 67
    //   234: iconst_1
    //   235: ldc 115
    //   237: aload 4
    //   239: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   242: aload_3
    //   243: astore_0
    //   244: aload 4
    //   246: invokevirtual 116	java/lang/Throwable:printStackTrace	()V
    //   249: aload_3
    //   250: ifnull -239 -> 11
    //   253: aload_3
    //   254: invokevirtual 92	java/io/FileInputStream:close	()V
    //   257: aconst_null
    //   258: areturn
    //   259: astore_0
    //   260: aload_0
    //   261: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   264: aconst_null
    //   265: areturn
    //   266: astore_3
    //   267: aconst_null
    //   268: astore_0
    //   269: aload_0
    //   270: ifnull +7 -> 277
    //   273: aload_0
    //   274: invokevirtual 92	java/io/FileInputStream:close	()V
    //   277: aload_3
    //   278: athrow
    //   279: astore_0
    //   280: aload_0
    //   281: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   284: goto -7 -> 277
    //   287: astore_3
    //   288: goto -19 -> 269
    //   291: astore 4
    //   293: goto -63 -> 230
    //   296: astore 4
    //   298: goto -113 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramFile	File
    //   28	125	1	i	int
    //   114	39	2	j	int
    //   21	142	3	localFileInputStream	java.io.FileInputStream
    //   173	2	3	localIOException	java.io.IOException
    //   184	70	3	localObject1	Object
    //   266	12	3	localObject2	Object
    //   287	1	3	localObject3	Object
    //   102	54	4	arrayOfByte	byte[]
    //   181	19	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   226	19	4	localThrowable1	java.lang.Throwable
    //   291	1	4	localThrowable2	java.lang.Throwable
    //   296	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   84	88	90	java/io/IOException
    //   162	166	173	java/io/IOException
    //   13	22	181	java/lang/OutOfMemoryError
    //   213	217	219	java/io/IOException
    //   13	22	226	java/lang/Throwable
    //   253	257	259	java/io/IOException
    //   13	22	266	finally
    //   273	277	279	java/io/IOException
    //   24	29	287	finally
    //   31	37	287	finally
    //   39	64	287	finally
    //   72	80	287	finally
    //   99	104	287	finally
    //   106	115	287	finally
    //   117	123	287	finally
    //   125	150	287	finally
    //   187	197	287	finally
    //   199	204	287	finally
    //   206	209	287	finally
    //   232	242	287	finally
    //   244	249	287	finally
    //   24	29	291	java/lang/Throwable
    //   31	37	291	java/lang/Throwable
    //   39	64	291	java/lang/Throwable
    //   72	80	291	java/lang/Throwable
    //   99	104	291	java/lang/Throwable
    //   106	115	291	java/lang/Throwable
    //   117	123	291	java/lang/Throwable
    //   125	150	291	java/lang/Throwable
    //   24	29	296	java/lang/OutOfMemoryError
    //   31	37	296	java/lang/OutOfMemoryError
    //   39	64	296	java/lang/OutOfMemoryError
    //   72	80	296	java/lang/OutOfMemoryError
    //   99	104	296	java/lang/OutOfMemoryError
    //   106	115	296	java/lang/OutOfMemoryError
    //   117	123	296	java/lang/OutOfMemoryError
    //   125	150	296	java/lang/OutOfMemoryError
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Mcm = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("QavRecord.PCMLoader", 2, "playBGM filePath=" + paramString);
        }
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        mcl localmcl = (mcl)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
        if (localmcl != null)
        {
          this.jdField_a_of_type_Mcm = new mcm(localmcl, true);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label96;
        }
      }
      finally {}
      QLog.i("QavRecord.PCMLoader", 2, "playBGM not in cache");
      label96:
      a(paramString);
      paramString = (mcl)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
      if (paramString != null) {
        this.jdField_a_of_type_Mcm = new mcm(paramString, true);
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QavRecord.PCMLoader", 2, "fillData len=" + paramInt);
      }
      if (paramInt > this.jdField_a_of_type_Int)
      {
        QLog.i("QavRecord.PCMLoader", 1, "fillData len > mFrameSize");
        this.jdField_a_of_type_Int *= 2;
        this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
        this.b = new byte[this.jdField_a_of_type_Int];
      }
      Arrays.fill(this.jdField_a_of_type_ArrayOfByte, (byte)0);
      mcm localmcm = this.jdField_a_of_type_Mcm;
      if (localmcm != null) {
        localmcm.a(this.jdField_a_of_type_ArrayOfByte, 0, paramInt);
      }
      Arrays.fill(this.b, (byte)0);
      if ((this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) && (i < paramInt))
      {
        localmcm = (mcm)this.jdField_a_of_type_JavaUtilLinkedList.get(0);
        if (localmcm != null)
        {
          int j = i + localmcm.a(this.b, i, paramInt);
          i = j;
          if (!localmcm.a()) {
            break label229;
          }
          this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
          i = j;
        }
        else
        {
          this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
          break label229;
        }
      }
      else
      {
        mcn.a(paramArrayOfByte, this.jdField_a_of_type_ArrayOfByte, this.b, paramInt);
        return;
      }
    }
    finally {}
    label229:
    for (;;)
    {
      break;
    }
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecord.PCMLoader", 2, "putFileToCache " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidUtilLruCache.get(paramString) != null) {
      return true;
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      QLog.i("QavRecord.PCMLoader", 1, "putFileToCache file not exist " + paramString);
      return false;
    }
    long l1 = System.currentTimeMillis();
    int i = 0;
    int j;
    do
    {
      byte[] arrayOfByte = a((File)localObject);
      if (arrayOfByte != null)
      {
        localObject = new mcl(paramString, arrayOfByte);
        this.jdField_a_of_type_AndroidUtilLruCache.put(paramString, localObject);
        long l2 = System.currentTimeMillis();
        QLog.i("QavRecord.PCMLoader", 1, "putFileToCache filePath=" + paramString + ", cost=" + (l2 - l1) + ", retry=" + i);
        return true;
      }
      j = i + 1;
      i = j;
    } while (j < 2);
    QLog.i("QavRecord.PCMLoader", 1, "putFileToCache failed, retry=" + j);
    return false;
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(String paramString)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("QavRecord.PCMLoader", 2, "playEffect filePath=" + paramString);
        }
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        mcl localmcl = (mcl)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
        if (localmcl != null)
        {
          paramString = new mcm(localmcl, false);
          this.jdField_a_of_type_JavaUtilLinkedList.add(paramString);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label102;
        }
      }
      finally {}
      QLog.i("QavRecord.PCMLoader", 2, "playEffect not in cache");
      label102:
      a(paramString);
      paramString = (mcl)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
      if (paramString != null)
      {
        paramString = new mcm(paramString, false);
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramString);
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.jdField_a_of_type_Mcm = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mcj
 * JD-Core Version:    0.7.0.1
 */