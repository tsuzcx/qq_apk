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
  
  /* Error */
  public static LocalCache get(File paramFile, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 31	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mInstanceMap	Ljava/util/Map;
    //   6: new 79	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   13: aload_0
    //   14: invokevirtual 83	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   17: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: invokestatic 91	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:myPid	()Ljava/lang/String;
    //   23: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokeinterface 102 2 0
    //   34: checkcast 2	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache
    //   37: astore 5
    //   39: aload 5
    //   41: astore 4
    //   43: aload 4
    //   45: ifnonnull +82 -> 127
    //   48: new 2	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache
    //   51: dup
    //   52: aload_0
    //   53: lload_1
    //   54: iload_3
    //   55: invokespecial 104	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:<init>	(Ljava/io/File;JI)V
    //   58: astore 5
    //   60: getstatic 31	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mInstanceMap	Ljava/util/Map;
    //   63: new 79	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   70: aload_0
    //   71: invokevirtual 107	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   74: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokestatic 91	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:myPid	()Ljava/lang/String;
    //   80: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: aload 5
    //   88: invokeinterface 111 3 0
    //   93: pop
    //   94: aload 5
    //   96: areturn
    //   97: astore 5
    //   99: ldc 13
    //   101: aload 5
    //   103: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   106: goto -63 -> 43
    //   109: astore_0
    //   110: ldc 13
    //   112: aload_0
    //   113: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   116: aload 4
    //   118: areturn
    //   119: astore_0
    //   120: aload 5
    //   122: astore 4
    //   124: goto -14 -> 110
    //   127: aload 4
    //   129: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramFile	File
    //   0	130	1	paramLong	long
    //   0	130	3	paramInt	int
    //   1	127	4	localObject	Object
    //   37	58	5	localLocalCache	LocalCache
    //   97	24	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   3	39	97	java/lang/Exception
    //   48	60	109	java/lang/Throwable
    //   60	94	119	java/lang/Throwable
  }
  
  private static String myPid()
  {
    return "_" + Process.myPid();
  }
  
  public void clear()
  {
    if (this.mCache == null) {
      return;
    }
    LocalCache.ACacheManager.access$1500(this.mCache);
  }
  
  public File file(String paramString)
  {
    if (this.mCache == null) {}
    do
    {
      return null;
      paramString = LocalCache.ACacheManager.access$100(this.mCache, paramString);
    } while (!paramString.exists());
    return paramString;
  }
  
  /* Error */
  public byte[] getAsBinary(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   7: ifnonnull +8 -> 15
    //   10: aload 6
    //   12: astore_3
    //   13: aload_3
    //   14: areturn
    //   15: aload_0
    //   16: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   19: aload_1
    //   20: invokestatic 145	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$400	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   23: astore_3
    //   24: aload_3
    //   25: invokevirtual 40	java/io/File:exists	()Z
    //   28: istore_2
    //   29: iload_2
    //   30: ifne +27 -> 57
    //   33: aload 6
    //   35: astore_3
    //   36: iconst_0
    //   37: ifeq -24 -> 13
    //   40: new 147	java/lang/NullPointerException
    //   43: dup
    //   44: invokespecial 148	java/lang/NullPointerException:<init>	()V
    //   47: athrow
    //   48: astore_1
    //   49: ldc 13
    //   51: aload_1
    //   52: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   55: aconst_null
    //   56: areturn
    //   57: new 150	java/io/RandomAccessFile
    //   60: dup
    //   61: aload_3
    //   62: ldc 152
    //   64: invokespecial 153	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   67: astore 4
    //   69: aload 4
    //   71: astore_3
    //   72: aload 4
    //   74: invokevirtual 157	java/io/RandomAccessFile:length	()J
    //   77: l2i
    //   78: newarray byte
    //   80: astore 5
    //   82: aload 4
    //   84: astore_3
    //   85: aload 4
    //   87: aload 5
    //   89: invokevirtual 161	java/io/RandomAccessFile:read	([B)I
    //   92: ifle +74 -> 166
    //   95: aload 4
    //   97: astore_3
    //   98: aload 5
    //   100: invokestatic 167	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$Utils:access$800	([B)Z
    //   103: ifne +35 -> 138
    //   106: aload 4
    //   108: astore_3
    //   109: aload 5
    //   111: invokestatic 171	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$Utils:access$900	([B)[B
    //   114: astore_1
    //   115: aload_1
    //   116: astore_3
    //   117: aload 4
    //   119: ifnull -106 -> 13
    //   122: aload 4
    //   124: invokevirtual 174	java/io/RandomAccessFile:close	()V
    //   127: aload_1
    //   128: areturn
    //   129: astore_3
    //   130: ldc 13
    //   132: aload_3
    //   133: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   136: aload_1
    //   137: areturn
    //   138: aload 4
    //   140: ifnull +8 -> 148
    //   143: aload 4
    //   145: invokevirtual 174	java/io/RandomAccessFile:close	()V
    //   148: aload_0
    //   149: aload_1
    //   150: invokevirtual 178	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:remove	(Ljava/lang/String;)Z
    //   153: pop
    //   154: aconst_null
    //   155: areturn
    //   156: astore_3
    //   157: ldc 13
    //   159: aload_3
    //   160: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   163: goto -15 -> 148
    //   166: aload 6
    //   168: astore_3
    //   169: aload 4
    //   171: ifnull -158 -> 13
    //   174: aload 4
    //   176: invokevirtual 174	java/io/RandomAccessFile:close	()V
    //   179: aconst_null
    //   180: areturn
    //   181: astore_1
    //   182: ldc 13
    //   184: aload_1
    //   185: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: aconst_null
    //   189: areturn
    //   190: astore 5
    //   192: aconst_null
    //   193: astore_1
    //   194: aload_1
    //   195: astore_3
    //   196: ldc 13
    //   198: aload 5
    //   200: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   203: aload 6
    //   205: astore_3
    //   206: aload_1
    //   207: ifnull -194 -> 13
    //   210: aload_1
    //   211: invokevirtual 174	java/io/RandomAccessFile:close	()V
    //   214: aconst_null
    //   215: areturn
    //   216: astore_1
    //   217: ldc 13
    //   219: aload_1
    //   220: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   223: aconst_null
    //   224: areturn
    //   225: astore_1
    //   226: aconst_null
    //   227: astore_3
    //   228: aload_3
    //   229: ifnull +7 -> 236
    //   232: aload_3
    //   233: invokevirtual 174	java/io/RandomAccessFile:close	()V
    //   236: aload_1
    //   237: athrow
    //   238: astore_3
    //   239: ldc 13
    //   241: aload_3
    //   242: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   245: goto -9 -> 236
    //   248: astore_1
    //   249: goto -21 -> 228
    //   252: astore 5
    //   254: aload 4
    //   256: astore_1
    //   257: goto -63 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	LocalCache
    //   0	260	1	paramString	String
    //   28	2	2	bool	boolean
    //   12	105	3	localObject1	Object
    //   129	4	3	localIOException1	java.io.IOException
    //   156	4	3	localIOException2	java.io.IOException
    //   168	65	3	localObject2	Object
    //   238	4	3	localIOException3	java.io.IOException
    //   67	188	4	localRandomAccessFile	java.io.RandomAccessFile
    //   80	30	5	arrayOfByte	byte[]
    //   190	9	5	localException1	Exception
    //   252	1	5	localException2	Exception
    //   1	203	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   40	48	48	java/io/IOException
    //   122	127	129	java/io/IOException
    //   143	148	156	java/io/IOException
    //   174	179	181	java/io/IOException
    //   15	29	190	java/lang/Exception
    //   57	69	190	java/lang/Exception
    //   210	214	216	java/io/IOException
    //   15	29	225	finally
    //   57	69	225	finally
    //   232	236	238	java/io/IOException
    //   72	82	248	finally
    //   85	95	248	finally
    //   98	106	248	finally
    //   109	115	248	finally
    //   196	203	248	finally
    //   72	82	252	java/lang/Exception
    //   85	95	252	java/lang/Exception
    //   98	106	252	java/lang/Exception
    //   109	115	252	java/lang/Exception
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
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = getAsString(paramString);
    } while (TextUtils.isEmpty(paramString));
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
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = getAsString(paramString);
    } while (TextUtils.isEmpty(paramString));
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
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 182	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:getAsBinary	(Ljava/lang/String;)[B
    //   8: astore_1
    //   9: aload 6
    //   11: astore_2
    //   12: aload_1
    //   13: ifnull +55 -> 68
    //   16: new 218	java/io/ByteArrayInputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 221	java/io/ByteArrayInputStream:<init>	([B)V
    //   24: astore_2
    //   25: new 223	java/io/ObjectInputStream
    //   28: dup
    //   29: aload_2
    //   30: invokespecial 226	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: astore_1
    //   34: aload_1
    //   35: astore 4
    //   37: aload_2
    //   38: astore_3
    //   39: aload_1
    //   40: invokevirtual 230	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   43: astore 5
    //   45: aload 5
    //   47: astore_3
    //   48: aload_2
    //   49: ifnull +7 -> 56
    //   52: aload_2
    //   53: invokevirtual 231	java/io/ByteArrayInputStream:close	()V
    //   56: aload_3
    //   57: astore_2
    //   58: aload_1
    //   59: ifnull +9 -> 68
    //   62: aload_1
    //   63: invokevirtual 232	java/io/ObjectInputStream:close	()V
    //   66: aload_3
    //   67: astore_2
    //   68: aload_2
    //   69: areturn
    //   70: astore_2
    //   71: ldc 13
    //   73: aload_2
    //   74: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   77: goto -21 -> 56
    //   80: astore_1
    //   81: ldc 13
    //   83: aload_1
    //   84: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   87: aload_3
    //   88: areturn
    //   89: astore 5
    //   91: aconst_null
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_2
    //   95: aload_1
    //   96: astore 4
    //   98: aload_2
    //   99: astore_3
    //   100: ldc 13
    //   102: aload 5
    //   104: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_2
    //   108: ifnull +7 -> 115
    //   111: aload_2
    //   112: invokevirtual 231	java/io/ByteArrayInputStream:close	()V
    //   115: aload 6
    //   117: astore_2
    //   118: aload_1
    //   119: ifnull -51 -> 68
    //   122: aload_1
    //   123: invokevirtual 232	java/io/ObjectInputStream:close	()V
    //   126: aconst_null
    //   127: areturn
    //   128: astore_1
    //   129: ldc 13
    //   131: aload_1
    //   132: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: aconst_null
    //   136: areturn
    //   137: astore_2
    //   138: ldc 13
    //   140: aload_2
    //   141: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   144: goto -29 -> 115
    //   147: astore_1
    //   148: aconst_null
    //   149: astore 4
    //   151: aconst_null
    //   152: astore_2
    //   153: aload_2
    //   154: ifnull +7 -> 161
    //   157: aload_2
    //   158: invokevirtual 231	java/io/ByteArrayInputStream:close	()V
    //   161: aload 4
    //   163: ifnull +8 -> 171
    //   166: aload 4
    //   168: invokevirtual 232	java/io/ObjectInputStream:close	()V
    //   171: aload_1
    //   172: athrow
    //   173: astore_2
    //   174: ldc 13
    //   176: aload_2
    //   177: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   180: goto -19 -> 161
    //   183: astore_2
    //   184: ldc 13
    //   186: aload_2
    //   187: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   190: goto -19 -> 171
    //   193: astore_1
    //   194: aconst_null
    //   195: astore 4
    //   197: goto -44 -> 153
    //   200: astore_1
    //   201: aload_3
    //   202: astore_2
    //   203: goto -50 -> 153
    //   206: astore 5
    //   208: aconst_null
    //   209: astore_1
    //   210: goto -115 -> 95
    //   213: astore 5
    //   215: goto -120 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	LocalCache
    //   0	218	1	paramString	String
    //   11	58	2	localObject1	Object
    //   70	4	2	localIOException1	java.io.IOException
    //   94	24	2	localObject2	Object
    //   137	4	2	localIOException2	java.io.IOException
    //   152	6	2	localObject3	Object
    //   173	4	2	localIOException3	java.io.IOException
    //   183	4	2	localIOException4	java.io.IOException
    //   202	1	2	localObject4	Object
    //   38	164	3	localObject5	Object
    //   35	161	4	str	String
    //   43	3	5	localObject6	Object
    //   89	14	5	localException1	Exception
    //   206	1	5	localException2	Exception
    //   213	1	5	localException3	Exception
    //   1	115	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   52	56	70	java/io/IOException
    //   62	66	80	java/io/IOException
    //   16	25	89	java/lang/Exception
    //   122	126	128	java/io/IOException
    //   111	115	137	java/io/IOException
    //   16	25	147	finally
    //   157	161	173	java/io/IOException
    //   166	171	183	java/io/IOException
    //   25	34	193	finally
    //   39	45	200	finally
    //   100	107	200	finally
    //   25	34	206	java/lang/Exception
    //   39	45	213	java/lang/Exception
  }
  
  /* Error */
  public String getAsString(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   7: ifnonnull +8 -> 15
    //   10: aload 5
    //   12: astore_2
    //   13: aload_2
    //   14: areturn
    //   15: aload_0
    //   16: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   19: aload_1
    //   20: invokestatic 145	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$400	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   23: astore_3
    //   24: aload 5
    //   26: astore_2
    //   27: aload_3
    //   28: invokevirtual 40	java/io/File:exists	()Z
    //   31: ifeq -18 -> 13
    //   34: new 234	java/io/BufferedReader
    //   37: dup
    //   38: new 236	java/io/FileReader
    //   41: dup
    //   42: aload_3
    //   43: invokespecial 239	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   46: invokespecial 242	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore_3
    //   50: ldc 244
    //   52: astore 4
    //   54: aload_3
    //   55: astore_2
    //   56: aload_3
    //   57: invokevirtual 247	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore 6
    //   62: aload 6
    //   64: ifnull +30 -> 94
    //   67: aload_3
    //   68: astore_2
    //   69: new 79	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   76: aload 4
    //   78: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload 6
    //   83: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore 4
    //   91: goto -37 -> 54
    //   94: aload_3
    //   95: astore_2
    //   96: aload 4
    //   98: invokestatic 250	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$Utils:access$500	(Ljava/lang/String;)Z
    //   101: ifne +32 -> 133
    //   104: aload_3
    //   105: astore_2
    //   106: aload 4
    //   108: invokestatic 253	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$Utils:access$600	(Ljava/lang/String;)Ljava/lang/String;
    //   111: astore_1
    //   112: aload_1
    //   113: astore_2
    //   114: aload_3
    //   115: ifnull -102 -> 13
    //   118: aload_3
    //   119: invokevirtual 254	java/io/BufferedReader:close	()V
    //   122: aload_1
    //   123: areturn
    //   124: astore_2
    //   125: ldc 13
    //   127: aload_2
    //   128: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   131: aload_1
    //   132: areturn
    //   133: aload_3
    //   134: ifnull +7 -> 141
    //   137: aload_3
    //   138: invokevirtual 254	java/io/BufferedReader:close	()V
    //   141: aload_0
    //   142: aload_1
    //   143: invokevirtual 178	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:remove	(Ljava/lang/String;)Z
    //   146: pop
    //   147: aconst_null
    //   148: areturn
    //   149: astore_2
    //   150: ldc 13
    //   152: aload_2
    //   153: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   156: goto -15 -> 141
    //   159: astore 4
    //   161: aconst_null
    //   162: astore_1
    //   163: aload_1
    //   164: astore_2
    //   165: ldc 13
    //   167: aload 4
    //   169: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   172: aload 5
    //   174: astore_2
    //   175: aload_1
    //   176: ifnull -163 -> 13
    //   179: aload_1
    //   180: invokevirtual 254	java/io/BufferedReader:close	()V
    //   183: aconst_null
    //   184: areturn
    //   185: astore_1
    //   186: ldc 13
    //   188: aload_1
    //   189: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_1
    //   195: aconst_null
    //   196: astore_2
    //   197: aload_2
    //   198: ifnull +7 -> 205
    //   201: aload_2
    //   202: invokevirtual 254	java/io/BufferedReader:close	()V
    //   205: aload_1
    //   206: athrow
    //   207: astore_2
    //   208: ldc 13
    //   210: aload_2
    //   211: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   214: goto -9 -> 205
    //   217: astore_1
    //   218: goto -21 -> 197
    //   221: astore 4
    //   223: aload_3
    //   224: astore_1
    //   225: goto -62 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	LocalCache
    //   0	228	1	paramString	String
    //   12	102	2	localObject1	Object
    //   124	4	2	localIOException1	java.io.IOException
    //   149	4	2	localIOException2	java.io.IOException
    //   164	38	2	localObject2	Object
    //   207	4	2	localIOException3	java.io.IOException
    //   23	201	3	localObject3	Object
    //   52	55	4	str1	String
    //   159	9	4	localIOException4	java.io.IOException
    //   221	1	4	localIOException5	java.io.IOException
    //   1	172	5	localObject4	Object
    //   60	22	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   118	122	124	java/io/IOException
    //   137	141	149	java/io/IOException
    //   34	50	159	java/io/IOException
    //   179	183	185	java/io/IOException
    //   34	50	194	finally
    //   201	205	207	java/io/IOException
    //   56	62	217	finally
    //   69	91	217	finally
    //   96	104	217	finally
    //   106	112	217	finally
    //   165	172	217	finally
    //   56	62	221	java/io/IOException
    //   69	91	221	java/io/IOException
    //   96	104	221	java/io/IOException
    //   106	112	221	java/io/IOException
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
    //   0: new 282	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 283	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 6
    //   9: new 285	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 6
    //   15: invokespecial 288	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 5
    //   20: aload 5
    //   22: astore 4
    //   24: aload 5
    //   26: aload_2
    //   27: invokevirtual 292	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   30: aload 5
    //   32: astore 4
    //   34: aload 6
    //   36: invokevirtual 296	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   39: astore_2
    //   40: iload_3
    //   41: iconst_m1
    //   42: if_icmpeq +25 -> 67
    //   45: aload 5
    //   47: astore 4
    //   49: aload_0
    //   50: aload_1
    //   51: aload_2
    //   52: iload_3
    //   53: invokevirtual 266	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:put	(Ljava/lang/String;[BI)V
    //   56: aload 5
    //   58: ifnull +8 -> 66
    //   61: aload 5
    //   63: invokevirtual 297	java/io/ObjectOutputStream:close	()V
    //   66: return
    //   67: aload 5
    //   69: astore 4
    //   71: aload_0
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 262	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:put	(Ljava/lang/String;[B)V
    //   77: goto -21 -> 56
    //   80: astore_1
    //   81: aload 5
    //   83: astore 4
    //   85: ldc 13
    //   87: aload_1
    //   88: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: aload 5
    //   93: ifnull -27 -> 66
    //   96: aload 5
    //   98: invokevirtual 297	java/io/ObjectOutputStream:close	()V
    //   101: return
    //   102: astore_1
    //   103: ldc 13
    //   105: aload_1
    //   106: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   109: return
    //   110: astore_1
    //   111: ldc 13
    //   113: aload_1
    //   114: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   117: return
    //   118: astore_1
    //   119: aconst_null
    //   120: astore 5
    //   122: aload 5
    //   124: astore 4
    //   126: ldc 13
    //   128: aload_1
    //   129: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: aload 5
    //   134: ifnull -68 -> 66
    //   137: aload 5
    //   139: invokevirtual 297	java/io/ObjectOutputStream:close	()V
    //   142: return
    //   143: astore_1
    //   144: ldc 13
    //   146: aload_1
    //   147: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   150: return
    //   151: astore_1
    //   152: aconst_null
    //   153: astore 4
    //   155: aload 4
    //   157: ifnull +8 -> 165
    //   160: aload 4
    //   162: invokevirtual 297	java/io/ObjectOutputStream:close	()V
    //   165: aload_1
    //   166: athrow
    //   167: astore_2
    //   168: ldc 13
    //   170: aload_2
    //   171: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   174: goto -9 -> 165
    //   177: astore_1
    //   178: goto -23 -> 155
    //   181: astore_1
    //   182: goto -60 -> 122
    //   185: astore_1
    //   186: aconst_null
    //   187: astore 5
    //   189: goto -108 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	LocalCache
    //   0	192	1	paramString	String
    //   0	192	2	paramSerializable	Serializable
    //   0	192	3	paramInt	int
    //   22	139	4	localObjectOutputStream1	java.io.ObjectOutputStream
    //   18	170	5	localObjectOutputStream2	java.io.ObjectOutputStream
    //   7	28	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   24	30	80	java/lang/Exception
    //   34	40	80	java/lang/Exception
    //   49	56	80	java/lang/Exception
    //   71	77	80	java/lang/Exception
    //   96	101	102	java/lang/Throwable
    //   61	66	110	java/lang/Throwable
    //   0	20	118	java/lang/Throwable
    //   137	142	143	java/lang/Throwable
    //   0	20	151	finally
    //   160	165	167	java/lang/Throwable
    //   24	30	177	finally
    //   34	40	177	finally
    //   49	56	177	finally
    //   71	77	177	finally
    //   85	91	177	finally
    //   126	132	177	finally
    //   24	30	181	java/lang/Throwable
    //   34	40	181	java/lang/Throwable
    //   49	56	181	java/lang/Throwable
    //   71	77	181	java/lang/Throwable
    //   0	20	185	java/lang/Exception
  }
  
  /* Error */
  public void put(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   12: aload_1
    //   13: invokestatic 138	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$100	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   16: astore 5
    //   18: aconst_null
    //   19: astore_1
    //   20: new 300	java/io/BufferedWriter
    //   23: dup
    //   24: new 302	java/io/FileWriter
    //   27: dup
    //   28: aload 5
    //   30: invokespecial 303	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   33: sipush 1024
    //   36: invokespecial 306	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   39: astore_3
    //   40: aload_3
    //   41: astore_1
    //   42: aload_3
    //   43: aload_2
    //   44: invokevirtual 309	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   47: aload_3
    //   48: ifnull +11 -> 59
    //   51: aload_3
    //   52: invokevirtual 312	java/io/BufferedWriter:flush	()V
    //   55: aload_3
    //   56: invokevirtual 313	java/io/BufferedWriter:close	()V
    //   59: aload_0
    //   60: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   63: aload 5
    //   65: invokestatic 317	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   68: return
    //   69: astore_1
    //   70: ldc 13
    //   72: aload_1
    //   73: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: goto -21 -> 55
    //   79: astore_1
    //   80: ldc 13
    //   82: aload_1
    //   83: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: goto -27 -> 59
    //   89: astore 4
    //   91: aconst_null
    //   92: astore_2
    //   93: aload_2
    //   94: astore_1
    //   95: ldc 13
    //   97: aload 4
    //   99: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   102: aload_2
    //   103: ifnull +11 -> 114
    //   106: aload_2
    //   107: invokevirtual 312	java/io/BufferedWriter:flush	()V
    //   110: aload_2
    //   111: invokevirtual 313	java/io/BufferedWriter:close	()V
    //   114: aload_0
    //   115: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   118: aload 5
    //   120: invokestatic 317	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   123: return
    //   124: astore_1
    //   125: ldc 13
    //   127: aload_1
    //   128: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   131: goto -21 -> 110
    //   134: astore_1
    //   135: ldc 13
    //   137: aload_1
    //   138: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   141: goto -27 -> 114
    //   144: astore_3
    //   145: aload_1
    //   146: astore_2
    //   147: aload_3
    //   148: astore_1
    //   149: aload_2
    //   150: ifnull +11 -> 161
    //   153: aload_2
    //   154: invokevirtual 312	java/io/BufferedWriter:flush	()V
    //   157: aload_2
    //   158: invokevirtual 313	java/io/BufferedWriter:close	()V
    //   161: aload_0
    //   162: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   165: aload 5
    //   167: invokestatic 317	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   170: aload_1
    //   171: athrow
    //   172: astore_3
    //   173: ldc 13
    //   175: aload_3
    //   176: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   179: goto -22 -> 157
    //   182: astore_2
    //   183: ldc 13
    //   185: aload_2
    //   186: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   189: goto -28 -> 161
    //   192: astore_3
    //   193: aload_1
    //   194: astore_2
    //   195: aload_3
    //   196: astore_1
    //   197: goto -48 -> 149
    //   200: astore 4
    //   202: aload_3
    //   203: astore_2
    //   204: goto -111 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	LocalCache
    //   0	207	1	paramString1	String
    //   0	207	2	paramString2	String
    //   39	17	3	localBufferedWriter	java.io.BufferedWriter
    //   144	4	3	localObject1	Object
    //   172	4	3	localIOException1	java.io.IOException
    //   192	11	3	localObject2	Object
    //   89	9	4	localIOException2	java.io.IOException
    //   200	1	4	localIOException3	java.io.IOException
    //   16	150	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   51	55	69	java/io/IOException
    //   55	59	79	java/io/IOException
    //   20	40	89	java/io/IOException
    //   106	110	124	java/io/IOException
    //   110	114	134	java/io/IOException
    //   20	40	144	finally
    //   153	157	172	java/io/IOException
    //   157	161	182	java/io/IOException
    //   42	47	192	finally
    //   95	102	192	finally
    //   42	47	200	java/io/IOException
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
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   12: aload_1
    //   13: invokestatic 138	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$100	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   16: astore 5
    //   18: new 334	java/io/FileOutputStream
    //   21: dup
    //   22: aload 5
    //   24: invokespecial 335	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   27: astore_3
    //   28: aload_3
    //   29: astore_1
    //   30: aload_3
    //   31: aload_2
    //   32: invokevirtual 337	java/io/FileOutputStream:write	([B)V
    //   35: aload_3
    //   36: ifnull +11 -> 47
    //   39: aload_3
    //   40: invokevirtual 338	java/io/FileOutputStream:flush	()V
    //   43: aload_3
    //   44: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   47: aload_0
    //   48: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   51: aload 5
    //   53: invokestatic 317	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   56: return
    //   57: astore_1
    //   58: ldc 13
    //   60: aload_1
    //   61: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   64: goto -17 -> 47
    //   67: astore 4
    //   69: aconst_null
    //   70: astore_2
    //   71: aload_2
    //   72: astore_1
    //   73: ldc 13
    //   75: aload 4
    //   77: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   80: aload_2
    //   81: ifnull +11 -> 92
    //   84: aload_2
    //   85: invokevirtual 338	java/io/FileOutputStream:flush	()V
    //   88: aload_2
    //   89: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   92: aload_0
    //   93: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   96: aload 5
    //   98: invokestatic 317	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   101: return
    //   102: astore_1
    //   103: ldc 13
    //   105: aload_1
    //   106: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   109: goto -17 -> 92
    //   112: astore_2
    //   113: aconst_null
    //   114: astore_1
    //   115: aload_1
    //   116: ifnull +11 -> 127
    //   119: aload_1
    //   120: invokevirtual 338	java/io/FileOutputStream:flush	()V
    //   123: aload_1
    //   124: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   127: aload_0
    //   128: getfield 45	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   131: aload 5
    //   133: invokestatic 317	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   136: aload_2
    //   137: athrow
    //   138: astore_1
    //   139: ldc 13
    //   141: aload_1
    //   142: invokestatic 117	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   145: goto -18 -> 127
    //   148: astore_2
    //   149: goto -34 -> 115
    //   152: astore 4
    //   154: aload_3
    //   155: astore_2
    //   156: goto -85 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	LocalCache
    //   0	159	1	paramString	String
    //   0	159	2	paramArrayOfByte	byte[]
    //   27	128	3	localFileOutputStream	java.io.FileOutputStream
    //   67	9	4	localException1	Exception
    //   152	1	4	localException2	Exception
    //   16	116	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   39	47	57	java/io/IOException
    //   18	28	67	java/lang/Exception
    //   84	92	102	java/io/IOException
    //   18	28	112	finally
    //   119	127	138	java/io/IOException
    //   30	35	148	finally
    //   73	80	148	finally
    //   30	35	152	java/lang/Exception
  }
  
  public void put(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    put(paramString, LocalCache.Utils.access$700(paramInt, paramArrayOfByte));
  }
  
  public boolean remove(String paramString)
  {
    if (this.mCache == null) {
      return false;
    }
    return LocalCache.ACacheManager.access$1400(this.mCache, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.LocalCache
 * JD-Core Version:    0.7.0.1
 */