package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import java.util.Map;

public class LoadVideoTask2
  extends AsyncTask<Void, Integer, Boolean>
{
  private static final String TAG = "LoadVideoTask2";
  private Map<String, Bitmap> cache;
  private final String dataPath;
  private final String itemId;
  private final String materialId;
  private final int sampleSize;
  
  public LoadVideoTask2(Map<String, Bitmap> paramMap, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.cache = paramMap;
    this.dataPath = paramString1;
    this.itemId = paramString2;
    this.materialId = paramString3;
    this.sampleSize = paramInt;
  }
  
  /* Error */
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    // Byte code:
    //   0: new 42	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: aload_0
    //   10: getfield 28	com/tencent/ttpic/cache/LoadVideoTask2:dataPath	Ljava/lang/String;
    //   13: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload_1
    //   18: getstatic 52	java/io/File:separator	Ljava/lang/String;
    //   21: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_1
    //   26: aload_0
    //   27: getfield 30	com/tencent/ttpic/cache/LoadVideoTask2:itemId	Ljava/lang/String;
    //   30: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_1
    //   35: getstatic 52	java/io/File:separator	Ljava/lang/String;
    //   38: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_1
    //   43: aload_0
    //   44: getfield 30	com/tencent/ttpic/cache/LoadVideoTask2:itemId	Ljava/lang/String;
    //   47: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_1
    //   52: ldc 54
    //   54: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: new 56	java/io/RandomAccessFile
    //   61: dup
    //   62: aload_1
    //   63: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: ldc 62
    //   68: invokespecial 65	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: astore_1
    //   72: aload_1
    //   73: invokevirtual 69	java/io/RandomAccessFile:length	()J
    //   76: lstore 4
    //   78: aload_1
    //   79: lload 4
    //   81: ldc2_w 70
    //   84: lsub
    //   85: invokevirtual 75	java/io/RandomAccessFile:seek	(J)V
    //   88: iconst_4
    //   89: newarray byte
    //   91: astore 6
    //   93: aload_1
    //   94: aload 6
    //   96: invokevirtual 79	java/io/RandomAccessFile:read	([B)I
    //   99: pop
    //   100: aload 6
    //   102: invokestatic 84	com/tencent/ttpic/util/ByteUtil:readInt	([B)I
    //   105: istore_3
    //   106: iconst_0
    //   107: istore_2
    //   108: iload_3
    //   109: bipush 12
    //   111: if_icmple +73 -> 184
    //   114: iload_3
    //   115: sipush 400
    //   118: if_icmplt +6 -> 124
    //   121: goto +63 -> 184
    //   124: aload_1
    //   125: lload 4
    //   127: iload_3
    //   128: i2l
    //   129: lsub
    //   130: ldc2_w 85
    //   133: ladd
    //   134: invokevirtual 75	java/io/RandomAccessFile:seek	(J)V
    //   137: iload_3
    //   138: bipush 12
    //   140: isub
    //   141: iconst_4
    //   142: idiv
    //   143: istore_3
    //   144: iload_3
    //   145: newarray int
    //   147: astore 7
    //   149: iload_2
    //   150: iload_3
    //   151: if_icmpge +26 -> 177
    //   154: aload_1
    //   155: aload 6
    //   157: invokevirtual 79	java/io/RandomAccessFile:read	([B)I
    //   160: pop
    //   161: aload 7
    //   163: iload_2
    //   164: aload 6
    //   166: invokestatic 84	com/tencent/ttpic/util/ByteUtil:readInt	([B)I
    //   169: iastore
    //   170: iload_2
    //   171: iconst_1
    //   172: iadd
    //   173: istore_2
    //   174: goto -25 -> 149
    //   177: aload_1
    //   178: invokevirtual 89	java/io/RandomAccessFile:close	()V
    //   181: goto +27 -> 208
    //   184: aload_1
    //   185: invokevirtual 89	java/io/RandomAccessFile:close	()V
    //   188: iconst_0
    //   189: invokestatic 95	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   192: areturn
    //   193: astore_1
    //   194: goto +19 -> 213
    //   197: astore_1
    //   198: getstatic 97	com/tencent/ttpic/cache/LoadVideoTask2:TAG	Ljava/lang/String;
    //   201: aload_1
    //   202: invokevirtual 98	java/lang/Exception:toString	()Ljava/lang/String;
    //   205: invokestatic 103	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: iconst_1
    //   209: invokestatic 95	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   212: areturn
    //   213: goto +5 -> 218
    //   216: aload_1
    //   217: athrow
    //   218: goto -2 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	LoadVideoTask2
    //   0	221	1	paramVarArgs	Void[]
    //   107	67	2	i	int
    //   105	47	3	j	int
    //   76	50	4	l	long
    //   91	74	6	arrayOfByte	byte[]
    //   147	15	7	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   0	106	193	finally
    //   124	149	193	finally
    //   154	170	193	finally
    //   177	181	193	finally
    //   184	188	193	finally
    //   198	208	193	finally
    //   0	106	197	java/lang/Exception
    //   124	149	197	java/lang/Exception
    //   154	170	197	java/lang/Exception
    //   177	181	197	java/lang/Exception
    //   184	188	197	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadVideoTask2
 * JD-Core Version:    0.7.0.1
 */