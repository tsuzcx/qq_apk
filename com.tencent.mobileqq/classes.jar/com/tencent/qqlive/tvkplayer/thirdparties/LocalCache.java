package com.tencent.qqlive.tvkplayer.thirdparties;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class LocalCache
{
  private static final int MAX_COUNT = 2147483647;
  private static final int MAX_SIZE = 50000000;
  private static final String TAG = "MediaPlayerMgr[LocalCache.java]";
  public static final int TIME_DAY = 86400;
  public static final int TIME_HOUR = 3600;
  private static Map<String, LocalCache> mInstanceMap = new HashMap();
  private LocalCache.ACacheManager mCache;
  
  private LocalCache(File paramFile, long paramLong, int paramInt)
  {
    if ((!paramFile.exists()) && (!paramFile.mkdirs()))
    {
      this.mCache = null;
      return;
    }
    this.mCache = new LocalCache.ACacheManager(this, paramFile, paramLong, paramInt, null);
  }
  
  public static LocalCache get(Context paramContext)
  {
    return get(paramContext, "LocalCache");
  }
  
  public static LocalCache get(Context paramContext, long paramLong, int paramInt)
  {
    return get(new File(paramContext.getCacheDir(), "LocalCache"), paramLong, paramInt);
  }
  
  public static LocalCache get(Context paramContext, String paramString)
  {
    return get(new File(paramContext.getCacheDir(), paramString), 50000000L, 2147483647);
  }
  
  public static LocalCache get(File paramFile)
  {
    return get(paramFile, 50000000L, 2147483647);
  }
  
  public static LocalCache get(File paramFile, long paramLong, int paramInt)
  {
    Object localObject2;
    try
    {
      Object localObject1 = mInstanceMap;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramFile.getAbsoluteFile());
      ((StringBuilder)localObject3).append(myPid());
      localObject1 = (LocalCache)((Map)localObject1).get(((StringBuilder)localObject3).toString());
    }
    catch (Exception localException)
    {
      TVKLogUtil.e("MediaPlayerMgr[LocalCache.java]", localException);
      localObject2 = null;
    }
    Object localObject3 = localObject2;
    if (localObject2 == null)
    {
      try
      {
        localObject3 = new LocalCache(paramFile, paramLong, paramInt);
        try
        {
          localObject2 = mInstanceMap;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramFile.getAbsolutePath());
          localStringBuilder.append(myPid());
          ((Map)localObject2).put(localStringBuilder.toString(), localObject3);
          return localObject3;
        }
        catch (Throwable paramFile)
        {
          localObject2 = localObject3;
        }
        TVKLogUtil.e("MediaPlayerMgr[LocalCache.java]", paramFile);
      }
      catch (Throwable paramFile) {}
      localObject3 = localObject2;
    }
    return localObject3;
  }
  
  private static String myPid()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_");
    localStringBuilder.append(Process.myPid());
    return localStringBuilder.toString();
  }
  
  public void clear()
  {
    LocalCache.ACacheManager localACacheManager = this.mCache;
    if (localACacheManager == null) {
      return;
    }
    LocalCache.ACacheManager.access$1500(localACacheManager);
  }
  
  public File file(String paramString)
  {
    LocalCache.ACacheManager localACacheManager = this.mCache;
    if (localACacheManager == null) {
      return null;
    }
    paramString = LocalCache.ACacheManager.access$100(localACacheManager, paramString);
    if (paramString.exists()) {
      return paramString;
    }
    return null;
  }
  
  /* Error */
  public byte[] getAsBinary(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: aload_2
    //   12: aload_1
    //   13: invokestatic 145	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$400	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   16: astore_2
    //   17: aload_2
    //   18: invokevirtual 40	java/io/File:exists	()Z
    //   21: ifne +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: new 147	java/io/RandomAccessFile
    //   29: dup
    //   30: aload_2
    //   31: ldc 149
    //   33: invokespecial 150	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: invokevirtual 154	java/io/RandomAccessFile:length	()J
    //   43: l2i
    //   44: newarray byte
    //   46: astore 4
    //   48: aload_3
    //   49: astore_2
    //   50: aload_3
    //   51: aload 4
    //   53: invokevirtual 158	java/io/RandomAccessFile:read	([B)I
    //   56: ifle +58 -> 114
    //   59: aload_3
    //   60: astore_2
    //   61: aload 4
    //   63: invokestatic 164	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$Utils:access$800	([B)Z
    //   66: ifne +26 -> 92
    //   69: aload_3
    //   70: astore_2
    //   71: aload 4
    //   73: invokestatic 168	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$Utils:access$900	([B)[B
    //   76: astore_1
    //   77: aload_3
    //   78: invokevirtual 171	java/io/RandomAccessFile:close	()V
    //   81: aload_1
    //   82: areturn
    //   83: astore_2
    //   84: ldc 13
    //   86: aload_2
    //   87: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: aload_1
    //   91: areturn
    //   92: aload_3
    //   93: invokevirtual 171	java/io/RandomAccessFile:close	()V
    //   96: goto +10 -> 106
    //   99: astore_2
    //   100: ldc 13
    //   102: aload_2
    //   103: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload_0
    //   107: aload_1
    //   108: invokevirtual 175	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:remove	(Ljava/lang/String;)Z
    //   111: pop
    //   112: aconst_null
    //   113: areturn
    //   114: aload_3
    //   115: invokevirtual 171	java/io/RandomAccessFile:close	()V
    //   118: aconst_null
    //   119: areturn
    //   120: astore_1
    //   121: ldc 13
    //   123: aload_1
    //   124: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_2
    //   130: aload_3
    //   131: astore_1
    //   132: aload_2
    //   133: astore_3
    //   134: goto +12 -> 146
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_2
    //   140: goto +34 -> 174
    //   143: astore_3
    //   144: aconst_null
    //   145: astore_1
    //   146: aload_1
    //   147: astore_2
    //   148: ldc 13
    //   150: aload_3
    //   151: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   154: aload_1
    //   155: ifnull +16 -> 171
    //   158: aload_1
    //   159: invokevirtual 171	java/io/RandomAccessFile:close	()V
    //   162: aconst_null
    //   163: areturn
    //   164: astore_1
    //   165: ldc 13
    //   167: aload_1
    //   168: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   171: aconst_null
    //   172: areturn
    //   173: astore_1
    //   174: aload_2
    //   175: ifnull +17 -> 192
    //   178: aload_2
    //   179: invokevirtual 171	java/io/RandomAccessFile:close	()V
    //   182: goto +10 -> 192
    //   185: astore_2
    //   186: ldc 13
    //   188: aload_2
    //   189: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   192: aload_1
    //   193: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	LocalCache
    //   0	194	1	paramString	String
    //   4	67	2	localObject1	Object
    //   83	4	2	localIOException1	java.io.IOException
    //   99	4	2	localIOException2	java.io.IOException
    //   129	4	2	localException1	Exception
    //   139	40	2	str	String
    //   185	4	2	localIOException3	java.io.IOException
    //   36	98	3	localObject2	Object
    //   143	8	3	localException2	Exception
    //   46	26	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   77	81	83	java/io/IOException
    //   92	96	99	java/io/IOException
    //   114	118	120	java/io/IOException
    //   39	48	129	java/lang/Exception
    //   50	59	129	java/lang/Exception
    //   61	69	129	java/lang/Exception
    //   71	77	129	java/lang/Exception
    //   11	24	137	finally
    //   26	37	137	finally
    //   11	24	143	java/lang/Exception
    //   26	37	143	java/lang/Exception
    //   158	162	164	java/io/IOException
    //   39	48	173	finally
    //   50	59	173	finally
    //   61	69	173	finally
    //   71	77	173	finally
    //   148	154	173	finally
    //   178	182	185	java/io/IOException
  }
  
  public Bitmap getAsBitmap(String paramString)
  {
    if (getAsBinary(paramString) == null) {
      return null;
    }
    return LocalCache.Utils.access$1100(getAsBinary(paramString));
  }
  
  public Drawable getAsDrawable(String paramString)
  {
    if (getAsBinary(paramString) == null) {
      return null;
    }
    return LocalCache.Utils.access$1300(LocalCache.Utils.access$1100(getAsBinary(paramString)));
  }
  
  public JSONArray getAsJSONArray(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = getAsString(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONArray(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      TVKLogUtil.e("MediaPlayerMgr[LocalCache.java]", paramString);
    }
    return null;
  }
  
  public JSONObject getAsJSONObject(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = getAsString(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      TVKLogUtil.e("MediaPlayerMgr[LocalCache.java]", paramString);
    }
    return null;
  }
  
  /* Error */
  public Object getAsObject(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 179	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:getAsBinary	(Ljava/lang/String;)[B
    //   5: astore_1
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_1
    //   9: ifnull +198 -> 207
    //   12: new 215	java/io/ByteArrayInputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 218	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: astore_1
    //   21: new 220	java/io/ObjectInputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 223	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   29: astore 6
    //   31: aload_1
    //   32: astore_2
    //   33: aload 6
    //   35: astore 4
    //   37: aload 6
    //   39: invokevirtual 227	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   42: astore_3
    //   43: aload_1
    //   44: invokevirtual 228	java/io/ByteArrayInputStream:close	()V
    //   47: goto +10 -> 57
    //   50: astore_1
    //   51: ldc 13
    //   53: aload_1
    //   54: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   57: aload 6
    //   59: invokevirtual 229	java/io/ObjectInputStream:close	()V
    //   62: aload_3
    //   63: areturn
    //   64: astore_1
    //   65: ldc 13
    //   67: aload_1
    //   68: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   71: aload_3
    //   72: areturn
    //   73: astore 5
    //   75: aload_1
    //   76: astore_3
    //   77: aload 6
    //   79: astore_1
    //   80: goto +36 -> 116
    //   83: astore 4
    //   85: aload_1
    //   86: astore_2
    //   87: aload 4
    //   89: astore_1
    //   90: goto +79 -> 169
    //   93: astore 5
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_1
    //   98: astore_3
    //   99: aload_2
    //   100: astore_1
    //   101: goto +15 -> 116
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_2
    //   107: goto +62 -> 169
    //   110: astore 5
    //   112: aconst_null
    //   113: astore_1
    //   114: aload_1
    //   115: astore_3
    //   116: aload_3
    //   117: astore_2
    //   118: aload_1
    //   119: astore 4
    //   121: ldc 13
    //   123: aload 5
    //   125: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_3
    //   129: ifnull +17 -> 146
    //   132: aload_3
    //   133: invokevirtual 228	java/io/ByteArrayInputStream:close	()V
    //   136: goto +10 -> 146
    //   139: astore_2
    //   140: ldc 13
    //   142: aload_2
    //   143: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   146: aload_1
    //   147: ifnull +16 -> 163
    //   150: aload_1
    //   151: invokevirtual 229	java/io/ObjectInputStream:close	()V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_1
    //   157: ldc 13
    //   159: aload_1
    //   160: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   163: aconst_null
    //   164: areturn
    //   165: astore_1
    //   166: aload 4
    //   168: astore_3
    //   169: aload_2
    //   170: ifnull +17 -> 187
    //   173: aload_2
    //   174: invokevirtual 228	java/io/ByteArrayInputStream:close	()V
    //   177: goto +10 -> 187
    //   180: astore_2
    //   181: ldc 13
    //   183: aload_2
    //   184: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   187: aload_3
    //   188: ifnull +17 -> 205
    //   191: aload_3
    //   192: invokevirtual 229	java/io/ObjectInputStream:close	()V
    //   195: goto +10 -> 205
    //   198: astore_2
    //   199: ldc 13
    //   201: aload_2
    //   202: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload_1
    //   206: athrow
    //   207: aconst_null
    //   208: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	LocalCache
    //   0	209	1	paramString	String
    //   32	86	2	localObject1	Object
    //   139	35	2	localIOException1	java.io.IOException
    //   180	4	2	localIOException2	java.io.IOException
    //   198	4	2	localIOException3	java.io.IOException
    //   7	185	3	localObject2	Object
    //   35	1	4	localObjectInputStream1	java.io.ObjectInputStream
    //   83	5	4	localObject3	Object
    //   119	48	4	str	String
    //   73	1	5	localException1	Exception
    //   93	1	5	localException2	Exception
    //   110	14	5	localException3	Exception
    //   29	49	6	localObjectInputStream2	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   43	47	50	java/io/IOException
    //   57	62	64	java/io/IOException
    //   37	43	73	java/lang/Exception
    //   21	31	83	finally
    //   21	31	93	java/lang/Exception
    //   12	21	104	finally
    //   12	21	110	java/lang/Exception
    //   132	136	139	java/io/IOException
    //   150	154	156	java/io/IOException
    //   37	43	165	finally
    //   121	128	165	finally
    //   173	177	180	java/io/IOException
    //   191	195	198	java/io/IOException
  }
  
  /* Error */
  public String getAsString(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: aload_2
    //   12: aload_1
    //   13: invokestatic 145	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$400	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   16: astore_2
    //   17: aload_2
    //   18: invokevirtual 40	java/io/File:exists	()Z
    //   21: ifne +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: new 231	java/io/BufferedReader
    //   29: dup
    //   30: new 233	java/io/FileReader
    //   33: dup
    //   34: aload_2
    //   35: invokespecial 236	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   38: invokespecial 239	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_3
    //   42: ldc 241
    //   44: astore 4
    //   46: aload_3
    //   47: astore_2
    //   48: aload_3
    //   49: invokevirtual 244	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore 5
    //   54: aload 5
    //   56: ifnull +46 -> 102
    //   59: aload_3
    //   60: astore_2
    //   61: new 79	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   68: astore 6
    //   70: aload_3
    //   71: astore_2
    //   72: aload 6
    //   74: aload 4
    //   76: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_3
    //   81: astore_2
    //   82: aload 6
    //   84: aload 5
    //   86: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_3
    //   91: astore_2
    //   92: aload 6
    //   94: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: astore 4
    //   99: goto -53 -> 46
    //   102: aload_3
    //   103: astore_2
    //   104: aload 4
    //   106: invokestatic 247	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$Utils:access$500	(Ljava/lang/String;)Z
    //   109: ifne +26 -> 135
    //   112: aload_3
    //   113: astore_2
    //   114: aload 4
    //   116: invokestatic 250	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$Utils:access$600	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore_1
    //   120: aload_3
    //   121: invokevirtual 251	java/io/BufferedReader:close	()V
    //   124: aload_1
    //   125: areturn
    //   126: astore_2
    //   127: ldc 13
    //   129: aload_2
    //   130: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   133: aload_1
    //   134: areturn
    //   135: aload_3
    //   136: invokevirtual 251	java/io/BufferedReader:close	()V
    //   139: goto +10 -> 149
    //   142: astore_2
    //   143: ldc 13
    //   145: aload_2
    //   146: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   149: aload_0
    //   150: aload_1
    //   151: invokevirtual 175	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:remove	(Ljava/lang/String;)Z
    //   154: pop
    //   155: aconst_null
    //   156: areturn
    //   157: astore_2
    //   158: aload_3
    //   159: astore_1
    //   160: aload_2
    //   161: astore_3
    //   162: goto +12 -> 174
    //   165: astore_1
    //   166: aconst_null
    //   167: astore_2
    //   168: goto +34 -> 202
    //   171: astore_3
    //   172: aconst_null
    //   173: astore_1
    //   174: aload_1
    //   175: astore_2
    //   176: ldc 13
    //   178: aload_3
    //   179: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   182: aload_1
    //   183: ifnull +16 -> 199
    //   186: aload_1
    //   187: invokevirtual 251	java/io/BufferedReader:close	()V
    //   190: aconst_null
    //   191: areturn
    //   192: astore_1
    //   193: ldc 13
    //   195: aload_1
    //   196: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   199: aconst_null
    //   200: areturn
    //   201: astore_1
    //   202: aload_2
    //   203: ifnull +17 -> 220
    //   206: aload_2
    //   207: invokevirtual 251	java/io/BufferedReader:close	()V
    //   210: goto +10 -> 220
    //   213: astore_2
    //   214: ldc 13
    //   216: aload_2
    //   217: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   220: goto +5 -> 225
    //   223: aload_1
    //   224: athrow
    //   225: goto -2 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	LocalCache
    //   0	228	1	paramString	String
    //   4	110	2	localObject1	Object
    //   126	4	2	localIOException1	java.io.IOException
    //   142	4	2	localIOException2	java.io.IOException
    //   157	4	2	localIOException3	java.io.IOException
    //   167	40	2	str1	String
    //   213	4	2	localIOException4	java.io.IOException
    //   41	121	3	localObject2	Object
    //   171	8	3	localIOException5	java.io.IOException
    //   44	71	4	str2	String
    //   52	33	5	str3	String
    //   68	25	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   120	124	126	java/io/IOException
    //   135	139	142	java/io/IOException
    //   48	54	157	java/io/IOException
    //   61	70	157	java/io/IOException
    //   72	80	157	java/io/IOException
    //   82	90	157	java/io/IOException
    //   92	99	157	java/io/IOException
    //   104	112	157	java/io/IOException
    //   114	120	157	java/io/IOException
    //   26	42	165	finally
    //   26	42	171	java/io/IOException
    //   186	190	192	java/io/IOException
    //   48	54	201	finally
    //   61	70	201	finally
    //   72	80	201	finally
    //   82	90	201	finally
    //   92	99	201	finally
    //   104	112	201	finally
    //   114	120	201	finally
    //   176	182	201	finally
    //   206	210	213	java/io/IOException
  }
  
  public void put(String paramString, Bitmap paramBitmap)
  {
    put(paramString, LocalCache.Utils.access$1000(paramBitmap));
  }
  
  public void put(String paramString, Bitmap paramBitmap, int paramInt)
  {
    put(paramString, LocalCache.Utils.access$1000(paramBitmap), paramInt);
  }
  
  public void put(String paramString, Drawable paramDrawable)
  {
    put(paramString, LocalCache.Utils.access$1200(paramDrawable));
  }
  
  public void put(String paramString, Drawable paramDrawable, int paramInt)
  {
    put(paramString, LocalCache.Utils.access$1200(paramDrawable), paramInt);
  }
  
  public void put(String paramString, Serializable paramSerializable)
  {
    put(paramString, paramSerializable, -1);
  }
  
  /* Error */
  public void put(String paramString, Serializable paramSerializable, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: aload 5
    //   11: astore 4
    //   13: new 279	java/io/ByteArrayOutputStream
    //   16: dup
    //   17: invokespecial 280	java/io/ByteArrayOutputStream:<init>	()V
    //   20: astore 8
    //   22: aload 5
    //   24: astore 4
    //   26: new 282	java/io/ObjectOutputStream
    //   29: dup
    //   30: aload 8
    //   32: invokespecial 285	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   35: astore 5
    //   37: aload 5
    //   39: aload_2
    //   40: invokevirtual 289	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   43: aload 8
    //   45: invokevirtual 293	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   48: astore_2
    //   49: iload_3
    //   50: iconst_m1
    //   51: if_icmpeq +13 -> 64
    //   54: aload_0
    //   55: aload_1
    //   56: aload_2
    //   57: iload_3
    //   58: invokevirtual 263	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:put	(Ljava/lang/String;[BI)V
    //   61: goto +9 -> 70
    //   64: aload_0
    //   65: aload_1
    //   66: aload_2
    //   67: invokevirtual 259	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:put	(Ljava/lang/String;[B)V
    //   70: aload 5
    //   72: invokevirtual 294	java/io/ObjectOutputStream:close	()V
    //   75: return
    //   76: astore_1
    //   77: aload 5
    //   79: astore 4
    //   81: goto +73 -> 154
    //   84: astore_2
    //   85: aload 5
    //   87: astore_1
    //   88: goto +18 -> 106
    //   91: astore_2
    //   92: aload 5
    //   94: astore_1
    //   95: goto +33 -> 128
    //   98: astore_1
    //   99: goto +55 -> 154
    //   102: astore_2
    //   103: aload 6
    //   105: astore_1
    //   106: aload_1
    //   107: astore 4
    //   109: ldc 13
    //   111: aload_2
    //   112: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: aload_1
    //   116: ifnull +37 -> 153
    //   119: aload_1
    //   120: invokevirtual 294	java/io/ObjectOutputStream:close	()V
    //   123: return
    //   124: astore_2
    //   125: aload 7
    //   127: astore_1
    //   128: aload_1
    //   129: astore 4
    //   131: ldc 13
    //   133: aload_2
    //   134: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   137: aload_1
    //   138: ifnull +15 -> 153
    //   141: aload_1
    //   142: invokevirtual 294	java/io/ObjectOutputStream:close	()V
    //   145: return
    //   146: astore_1
    //   147: ldc 13
    //   149: aload_1
    //   150: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   153: return
    //   154: aload 4
    //   156: ifnull +18 -> 174
    //   159: aload 4
    //   161: invokevirtual 294	java/io/ObjectOutputStream:close	()V
    //   164: goto +10 -> 174
    //   167: astore_2
    //   168: ldc 13
    //   170: aload_2
    //   171: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   174: aload_1
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	LocalCache
    //   0	176	1	paramString	String
    //   0	176	2	paramSerializable	Serializable
    //   0	176	3	paramInt	int
    //   11	149	4	localObject1	Object
    //   7	86	5	localObjectOutputStream	java.io.ObjectOutputStream
    //   1	103	6	localObject2	Object
    //   4	122	7	localObject3	Object
    //   20	24	8	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   37	49	76	finally
    //   54	61	76	finally
    //   64	70	76	finally
    //   37	49	84	java/lang/Throwable
    //   54	61	84	java/lang/Throwable
    //   64	70	84	java/lang/Throwable
    //   37	49	91	java/lang/Exception
    //   54	61	91	java/lang/Exception
    //   64	70	91	java/lang/Exception
    //   13	22	98	finally
    //   26	37	98	finally
    //   109	115	98	finally
    //   131	137	98	finally
    //   13	22	102	java/lang/Throwable
    //   26	37	102	java/lang/Throwable
    //   13	22	124	java/lang/Exception
    //   26	37	124	java/lang/Exception
    //   70	75	146	java/lang/Throwable
    //   119	123	146	java/lang/Throwable
    //   141	145	146	java/lang/Throwable
    //   159	164	167	java/lang/Throwable
  }
  
  /* Error */
  public void put(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_3
    //   11: aload_1
    //   12: invokestatic 138	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$100	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 4
    //   20: aconst_null
    //   21: astore_1
    //   22: new 297	java/io/BufferedWriter
    //   25: dup
    //   26: new 299	java/io/FileWriter
    //   29: dup
    //   30: aload 5
    //   32: invokespecial 300	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   35: sipush 1024
    //   38: invokespecial 303	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   41: astore_3
    //   42: aload_3
    //   43: aload_2
    //   44: invokevirtual 306	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   47: aload_3
    //   48: invokevirtual 309	java/io/BufferedWriter:flush	()V
    //   51: goto +10 -> 61
    //   54: astore_1
    //   55: ldc 13
    //   57: aload_1
    //   58: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   61: aload_3
    //   62: invokevirtual 310	java/io/BufferedWriter:close	()V
    //   65: goto +69 -> 134
    //   68: astore_1
    //   69: goto +59 -> 128
    //   72: astore_2
    //   73: aload_3
    //   74: astore_1
    //   75: goto +69 -> 144
    //   78: astore_1
    //   79: aload_3
    //   80: astore_2
    //   81: aload_1
    //   82: astore_3
    //   83: goto +11 -> 94
    //   86: astore_2
    //   87: goto +57 -> 144
    //   90: astore_3
    //   91: aload 4
    //   93: astore_2
    //   94: aload_2
    //   95: astore_1
    //   96: ldc 13
    //   98: aload_3
    //   99: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   102: aload_2
    //   103: ifnull +31 -> 134
    //   106: aload_2
    //   107: invokevirtual 309	java/io/BufferedWriter:flush	()V
    //   110: goto +10 -> 120
    //   113: astore_1
    //   114: ldc 13
    //   116: aload_1
    //   117: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload_2
    //   121: invokevirtual 310	java/io/BufferedWriter:close	()V
    //   124: goto +10 -> 134
    //   127: astore_1
    //   128: ldc 13
    //   130: aload_1
    //   131: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   134: aload_0
    //   135: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   138: aload 5
    //   140: invokestatic 314	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   143: return
    //   144: aload_1
    //   145: ifnull +31 -> 176
    //   148: aload_1
    //   149: invokevirtual 309	java/io/BufferedWriter:flush	()V
    //   152: goto +10 -> 162
    //   155: astore_3
    //   156: ldc 13
    //   158: aload_3
    //   159: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   162: aload_1
    //   163: invokevirtual 310	java/io/BufferedWriter:close	()V
    //   166: goto +10 -> 176
    //   169: astore_1
    //   170: ldc 13
    //   172: aload_1
    //   173: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   176: aload_0
    //   177: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   180: aload 5
    //   182: invokestatic 314	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   185: aload_2
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	LocalCache
    //   0	187	1	paramString1	String
    //   0	187	2	paramString2	String
    //   4	79	3	localObject1	Object
    //   90	9	3	localIOException1	java.io.IOException
    //   155	4	3	localIOException2	java.io.IOException
    //   18	74	4	localObject2	Object
    //   15	166	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   47	51	54	java/io/IOException
    //   61	65	68	java/io/IOException
    //   42	47	72	finally
    //   42	47	78	java/io/IOException
    //   22	42	86	finally
    //   96	102	86	finally
    //   22	42	90	java/io/IOException
    //   106	110	113	java/io/IOException
    //   120	124	127	java/io/IOException
    //   148	152	155	java/io/IOException
    //   162	166	169	java/io/IOException
  }
  
  public void put(String paramString1, String paramString2, int paramInt)
  {
    put(paramString1, LocalCache.Utils.access$300(paramInt, paramString2));
  }
  
  public void put(String paramString, JSONArray paramJSONArray)
  {
    put(paramString, paramJSONArray.toString());
  }
  
  public void put(String paramString, JSONArray paramJSONArray, int paramInt)
  {
    put(paramString, paramJSONArray.toString(), paramInt);
  }
  
  public void put(String paramString, JSONObject paramJSONObject)
  {
    put(paramString, paramJSONObject.toString());
  }
  
  public void put(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    put(paramString, paramJSONObject.toString(), paramInt);
  }
  
  /* Error */
  public void put(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_3
    //   11: aload_1
    //   12: invokestatic 138	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$100	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 4
    //   20: aconst_null
    //   21: astore_1
    //   22: new 331	java/io/FileOutputStream
    //   25: dup
    //   26: aload 5
    //   28: invokespecial 332	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   31: astore_3
    //   32: aload_3
    //   33: aload_2
    //   34: invokevirtual 334	java/io/FileOutputStream:write	([B)V
    //   37: aload_3
    //   38: invokevirtual 335	java/io/FileOutputStream:flush	()V
    //   41: aload_3
    //   42: invokevirtual 336	java/io/FileOutputStream:close	()V
    //   45: goto +10 -> 55
    //   48: astore_1
    //   49: ldc 13
    //   51: aload_1
    //   52: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   55: aload_0
    //   56: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   59: aload 5
    //   61: invokestatic 314	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   64: return
    //   65: astore_2
    //   66: aload_3
    //   67: astore_1
    //   68: goto +46 -> 114
    //   71: astore_1
    //   72: aload_3
    //   73: astore_2
    //   74: aload_1
    //   75: astore_3
    //   76: goto +11 -> 87
    //   79: astore_2
    //   80: goto +34 -> 114
    //   83: astore_3
    //   84: aload 4
    //   86: astore_2
    //   87: aload_2
    //   88: astore_1
    //   89: ldc 13
    //   91: aload_3
    //   92: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   95: aload_2
    //   96: ifnull -41 -> 55
    //   99: aload_2
    //   100: invokevirtual 335	java/io/FileOutputStream:flush	()V
    //   103: aload_2
    //   104: invokevirtual 336	java/io/FileOutputStream:close	()V
    //   107: goto -52 -> 55
    //   110: astore_1
    //   111: goto -62 -> 49
    //   114: aload_1
    //   115: ifnull +21 -> 136
    //   118: aload_1
    //   119: invokevirtual 335	java/io/FileOutputStream:flush	()V
    //   122: aload_1
    //   123: invokevirtual 336	java/io/FileOutputStream:close	()V
    //   126: goto +10 -> 136
    //   129: astore_1
    //   130: ldc 13
    //   132: aload_1
    //   133: invokestatic 108	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   136: aload_0
    //   137: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   140: aload 5
    //   142: invokestatic 314	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   145: goto +5 -> 150
    //   148: aload_2
    //   149: athrow
    //   150: goto -2 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	LocalCache
    //   0	153	1	paramString	String
    //   0	153	2	paramArrayOfByte	byte[]
    //   4	72	3	localObject1	Object
    //   83	9	3	localException	Exception
    //   18	67	4	localObject2	Object
    //   15	126	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   37	45	48	java/io/IOException
    //   32	37	65	finally
    //   32	37	71	java/lang/Exception
    //   22	32	79	finally
    //   89	95	79	finally
    //   22	32	83	java/lang/Exception
    //   99	107	110	java/io/IOException
    //   118	126	129	java/io/IOException
  }
  
  public void put(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    put(paramString, LocalCache.Utils.access$700(paramInt, paramArrayOfByte));
  }
  
  public boolean remove(String paramString)
  {
    LocalCache.ACacheManager localACacheManager = this.mCache;
    if (localACacheManager == null) {
      return false;
    }
    return LocalCache.ACacheManager.access$1400(localACacheManager, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.LocalCache
 * JD-Core Version:    0.7.0.1
 */