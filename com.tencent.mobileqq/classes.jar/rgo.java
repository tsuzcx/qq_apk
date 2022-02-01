import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class rgo
{
  public int a;
  public long a;
  public LocalMediaInfo a;
  @Nullable
  public String a;
  public boolean a;
  private int[] a;
  public int b;
  public long b;
  @Nullable
  public String b;
  private boolean b;
  public long c;
  public String c;
  public long d;
  public String d;
  @NotNull
  public String e = "";
  public String f = "";
  private String g;
  
  public rgo()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ArrayOfInt = new int[2];
  }
  
  private int a(String paramString, boolean paramBoolean)
  {
    int j = 0;
    try
    {
      paramString = paramString.split("x");
      if (paramBoolean) {}
      for (int i = 0;; i = 1)
      {
        if (paramString.length >= 2) {
          j = Integer.parseInt(paramString[i]);
        }
        return j;
      }
      return 0;
    }
    catch (Throwable paramString)
    {
      QLog.e("LocalMediaInfo", 1, "getWidth error", paramString);
    }
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 62	rgo:jdField_b_of_type_Boolean	Z
    //   6: ifne +244 -> 250
    //   9: new 64	android/media/MediaMetadataRetriever
    //   12: dup
    //   13: invokespecial 65	android/media/MediaMetadataRetriever:<init>	()V
    //   16: astore 5
    //   18: aload 5
    //   20: aload_0
    //   21: getfield 67	rgo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   24: invokevirtual 71	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   27: aload 5
    //   29: bipush 18
    //   31: invokevirtual 75	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   34: invokestatic 51	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   37: istore_2
    //   38: aload 5
    //   40: bipush 19
    //   42: invokevirtual 75	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   45: invokestatic 51	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   48: istore_3
    //   49: getstatic 80	android/os/Build$VERSION:SDK_INT	I
    //   52: bipush 17
    //   54: if_icmplt +80 -> 134
    //   57: aload 5
    //   59: bipush 24
    //   61: invokevirtual 75	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   64: invokestatic 51	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   67: istore 4
    //   69: iload 4
    //   71: bipush 90
    //   73: if_icmpeq +183 -> 256
    //   76: iload 4
    //   78: sipush 270
    //   81: if_icmpne +6 -> 87
    //   84: goto +172 -> 256
    //   87: iload_1
    //   88: ifeq +80 -> 168
    //   91: aload_0
    //   92: new 82	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   99: iload_3
    //   100: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   103: ldc 39
    //   105: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: iload_2
    //   109: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: putfield 96	rgo:g	Ljava/lang/String;
    //   118: aload_0
    //   119: iconst_1
    //   120: putfield 62	rgo:jdField_b_of_type_Boolean	Z
    //   123: aload 5
    //   125: ifnull +8 -> 133
    //   128: aload 5
    //   130: invokevirtual 99	android/media/MediaMetadataRetriever:release	()V
    //   133: return
    //   134: ldc 53
    //   136: iconst_1
    //   137: ldc 101
    //   139: invokestatic 104	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: goto -55 -> 87
    //   145: astore 6
    //   147: ldc 53
    //   149: iconst_1
    //   150: ldc 106
    //   152: aload 6
    //   154: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   157: aload 5
    //   159: ifnull -26 -> 133
    //   162: aload 5
    //   164: invokevirtual 99	android/media/MediaMetadataRetriever:release	()V
    //   167: return
    //   168: aload_0
    //   169: new 82	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   176: iload_2
    //   177: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: ldc 39
    //   182: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: iload_3
    //   186: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: putfield 96	rgo:g	Ljava/lang/String;
    //   195: goto -77 -> 118
    //   198: astore 7
    //   200: aload 5
    //   202: astore 6
    //   204: aload 7
    //   206: astore 5
    //   208: aload 6
    //   210: ifnull +8 -> 218
    //   213: aload 6
    //   215: invokevirtual 99	android/media/MediaMetadataRetriever:release	()V
    //   218: aload 5
    //   220: athrow
    //   221: astore 5
    //   223: aconst_null
    //   224: astore 6
    //   226: goto -18 -> 208
    //   229: astore 7
    //   231: aload 5
    //   233: astore 6
    //   235: aload 7
    //   237: astore 5
    //   239: goto -31 -> 208
    //   242: astore 6
    //   244: aconst_null
    //   245: astore 5
    //   247: goto -100 -> 147
    //   250: aconst_null
    //   251: astore 5
    //   253: goto -130 -> 123
    //   256: iconst_1
    //   257: istore_1
    //   258: goto -171 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	rgo
    //   1	257	1	i	int
    //   37	140	2	j	int
    //   48	138	3	k	int
    //   67	15	4	m	int
    //   16	203	5	localObject1	Object
    //   221	11	5	localObject2	Object
    //   237	15	5	localObject3	Object
    //   145	8	6	localThrowable1	Throwable
    //   202	32	6	localObject4	Object
    //   242	1	6	localThrowable2	Throwable
    //   198	7	7	localObject5	Object
    //   229	7	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   18	69	145	java/lang/Throwable
    //   91	118	145	java/lang/Throwable
    //   118	123	145	java/lang/Throwable
    //   134	142	145	java/lang/Throwable
    //   168	195	145	java/lang/Throwable
    //   18	69	198	finally
    //   91	118	198	finally
    //   118	123	198	finally
    //   134	142	198	finally
    //   168	195	198	finally
    //   2	18	221	finally
    //   147	157	229	finally
    //   2	18	242	java/lang/Throwable
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ArrayOfInt[0] == 0) || (this.jdField_a_of_type_ArrayOfInt[1] == 0))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.jdField_b_of_type_JavaLangString, localOptions);
      this.jdField_a_of_type_ArrayOfInt[0] = localOptions.outWidth;
      this.jdField_a_of_type_ArrayOfInt[1] = localOptions.outHeight;
    }
  }
  
  public int a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      b();
      return this.jdField_a_of_type_ArrayOfInt[0];
    }
    a();
    if (TextUtils.isEmpty(this.g)) {
      return a(this.c, true);
    }
    return a(this.g, true);
  }
  
  public int b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      b();
      return this.jdField_a_of_type_ArrayOfInt[1];
    }
    a();
    if (TextUtils.isEmpty(this.g)) {
      return a(this.c, false);
    }
    return a(this.g, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rgo
 * JD-Core Version:    0.7.0.1
 */