package com.tencent.mobileqq.kandian.base.utils;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AlbumUtils$LocalMediaInfo
{
  public boolean a = false;
  public boolean b = true;
  @Nullable
  public String c;
  public long d;
  @Nullable
  public String e;
  public long f;
  public String g;
  public long h;
  public String i;
  public long j;
  @NotNull
  public String k = "";
  public String l = "";
  public int m;
  public int n;
  public LocalMediaInfo o;
  private int[] p = new int[2];
  private boolean q;
  private String r;
  
  private int a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        paramString = paramString.split("x");
        if (!paramBoolean) {
          break label43;
        }
        i1 = 0;
        if (paramString.length >= 2)
        {
          i1 = Integer.parseInt(paramString[i1]);
          return i1;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("LocalMediaInfo", 1, "getWidth error", paramString);
      }
      return 0;
      label43:
      int i1 = 1;
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: getfield 75	com/tencent/mobileqq/kandian/base/utils/AlbumUtils$LocalMediaInfo:q	Z
    //   7: ifne +263 -> 270
    //   10: new 77	android/media/MediaMetadataRetriever
    //   13: dup
    //   14: invokespecial 78	android/media/MediaMetadataRetriever:<init>	()V
    //   17: astore 6
    //   19: aload 6
    //   21: astore 5
    //   23: aload 6
    //   25: aload_0
    //   26: getfield 80	com/tencent/mobileqq/kandian/base/utils/AlbumUtils$LocalMediaInfo:e	Ljava/lang/String;
    //   29: invokevirtual 84	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   32: aload 6
    //   34: astore 5
    //   36: aload 6
    //   38: bipush 18
    //   40: invokevirtual 88	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   43: invokestatic 64	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   46: istore_2
    //   47: aload 6
    //   49: astore 5
    //   51: aload 6
    //   53: bipush 19
    //   55: invokevirtual 88	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   58: invokestatic 64	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   61: istore_3
    //   62: aload 6
    //   64: astore 5
    //   66: getstatic 93	android/os/Build$VERSION:SDK_INT	I
    //   69: istore 4
    //   71: iconst_0
    //   72: istore_1
    //   73: iload 4
    //   75: bipush 17
    //   77: if_icmplt +37 -> 114
    //   80: aload 6
    //   82: astore 5
    //   84: aload 6
    //   86: bipush 24
    //   88: invokevirtual 88	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   91: invokestatic 64	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   94: istore 4
    //   96: iload 4
    //   98: bipush 90
    //   100: if_icmpeq +242 -> 342
    //   103: iload 4
    //   105: sipush 270
    //   108: if_icmpne +18 -> 126
    //   111: goto +231 -> 342
    //   114: aload 6
    //   116: astore 5
    //   118: ldc 66
    //   120: iconst_1
    //   121: ldc 95
    //   123: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: iload_1
    //   127: ifeq +66 -> 193
    //   130: aload 6
    //   132: astore 5
    //   134: new 100	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   141: astore 7
    //   143: aload 6
    //   145: astore 5
    //   147: aload 7
    //   149: iload_3
    //   150: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 6
    //   156: astore 5
    //   158: aload 7
    //   160: ldc 52
    //   162: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload 6
    //   168: astore 5
    //   170: aload 7
    //   172: iload_2
    //   173: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 6
    //   179: astore 5
    //   181: aload_0
    //   182: aload 7
    //   184: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: putfield 114	com/tencent/mobileqq/kandian/base/utils/AlbumUtils$LocalMediaInfo:r	Ljava/lang/String;
    //   190: goto +63 -> 253
    //   193: aload 6
    //   195: astore 5
    //   197: new 100	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   204: astore 7
    //   206: aload 6
    //   208: astore 5
    //   210: aload 7
    //   212: iload_2
    //   213: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 6
    //   219: astore 5
    //   221: aload 7
    //   223: ldc 52
    //   225: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 6
    //   231: astore 5
    //   233: aload 7
    //   235: iload_3
    //   236: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 6
    //   242: astore 5
    //   244: aload_0
    //   245: aload 7
    //   247: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: putfield 114	com/tencent/mobileqq/kandian/base/utils/AlbumUtils$LocalMediaInfo:r	Ljava/lang/String;
    //   253: aload 6
    //   255: astore 5
    //   257: aload_0
    //   258: iconst_1
    //   259: putfield 75	com/tencent/mobileqq/kandian/base/utils/AlbumUtils$LocalMediaInfo:q	Z
    //   262: goto +8 -> 270
    //   265: astore 7
    //   267: goto +27 -> 294
    //   270: aload 6
    //   272: ifnull +46 -> 318
    //   275: aload 6
    //   277: invokevirtual 117	android/media/MediaMetadataRetriever:release	()V
    //   280: return
    //   281: astore 5
    //   283: aconst_null
    //   284: astore 6
    //   286: goto +43 -> 329
    //   289: astore 7
    //   291: aconst_null
    //   292: astore 6
    //   294: aload 6
    //   296: astore 5
    //   298: ldc 66
    //   300: iconst_1
    //   301: ldc 119
    //   303: aload 7
    //   305: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   308: aload 6
    //   310: ifnull +8 -> 318
    //   313: aload 6
    //   315: invokevirtual 117	android/media/MediaMetadataRetriever:release	()V
    //   318: return
    //   319: astore 7
    //   321: aload 5
    //   323: astore 6
    //   325: aload 7
    //   327: astore 5
    //   329: aload 6
    //   331: ifnull +8 -> 339
    //   334: aload 6
    //   336: invokevirtual 117	android/media/MediaMetadataRetriever:release	()V
    //   339: aload 5
    //   341: athrow
    //   342: iconst_1
    //   343: istore_1
    //   344: goto -218 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	LocalMediaInfo
    //   72	272	1	i1	int
    //   46	167	2	i2	int
    //   61	175	3	i3	int
    //   69	40	4	i4	int
    //   21	235	5	localObject1	Object
    //   281	1	5	localObject2	Object
    //   296	44	5	localObject3	Object
    //   1	334	6	localObject4	Object
    //   141	105	7	localStringBuilder	java.lang.StringBuilder
    //   265	1	7	localThrowable1	Throwable
    //   289	15	7	localThrowable2	Throwable
    //   319	7	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   23	32	265	java/lang/Throwable
    //   36	47	265	java/lang/Throwable
    //   51	62	265	java/lang/Throwable
    //   66	71	265	java/lang/Throwable
    //   84	96	265	java/lang/Throwable
    //   118	126	265	java/lang/Throwable
    //   134	143	265	java/lang/Throwable
    //   147	154	265	java/lang/Throwable
    //   158	166	265	java/lang/Throwable
    //   170	177	265	java/lang/Throwable
    //   181	190	265	java/lang/Throwable
    //   197	206	265	java/lang/Throwable
    //   210	217	265	java/lang/Throwable
    //   221	229	265	java/lang/Throwable
    //   233	240	265	java/lang/Throwable
    //   244	253	265	java/lang/Throwable
    //   257	262	265	java/lang/Throwable
    //   3	19	281	finally
    //   3	19	289	java/lang/Throwable
    //   23	32	319	finally
    //   36	47	319	finally
    //   51	62	319	finally
    //   66	71	319	finally
    //   84	96	319	finally
    //   118	126	319	finally
    //   134	143	319	finally
    //   147	154	319	finally
    //   158	166	319	finally
    //   170	177	319	finally
    //   181	190	319	finally
    //   197	206	319	finally
    //   210	217	319	finally
    //   221	229	319	finally
    //   233	240	319	finally
    //   244	253	319	finally
    //   257	262	319	finally
    //   298	308	319	finally
  }
  
  private void d()
  {
    Object localObject = this.p;
    if ((localObject[0] == 0) || (localObject[1] == 0))
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.e, (BitmapFactory.Options)localObject);
      this.p[0] = ((BitmapFactory.Options)localObject).outWidth;
      this.p[1] = ((BitmapFactory.Options)localObject).outHeight;
    }
  }
  
  public int a()
  {
    if (!this.b)
    {
      d();
      return this.p[0];
    }
    c();
    if (TextUtils.isEmpty(this.r)) {
      return a(this.g, true);
    }
    return a(this.r, true);
  }
  
  public int b()
  {
    if (!this.b)
    {
      d();
      return this.p[1];
    }
    c();
    if (TextUtils.isEmpty(this.r)) {
      return a(this.g, false);
    }
    return a(this.r, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.AlbumUtils.LocalMediaInfo
 * JD-Core Version:    0.7.0.1
 */