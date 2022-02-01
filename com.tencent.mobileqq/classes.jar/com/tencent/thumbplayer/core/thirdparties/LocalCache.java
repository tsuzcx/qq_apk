package com.tencent.thumbplayer.core.thirdparties;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Process;
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
    //   0: getstatic 27	com/tencent/thumbplayer/core/thirdparties/LocalCache:mInstanceMap	Ljava/util/Map;
    //   3: astore 4
    //   5: new 75	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   12: astore 5
    //   14: aload 5
    //   16: aload_0
    //   17: invokevirtual 79	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   20: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 5
    //   26: invokestatic 87	com/tencent/thumbplayer/core/thirdparties/LocalCache:myPid	()Ljava/lang/String;
    //   29: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 4
    //   35: aload 5
    //   37: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokeinterface 98 2 0
    //   45: checkcast 2	com/tencent/thumbplayer/core/thirdparties/LocalCache
    //   48: astore 4
    //   50: goto +6 -> 56
    //   53: aconst_null
    //   54: astore 4
    //   56: aload 4
    //   58: astore 5
    //   60: aload 4
    //   62: ifnonnull +63 -> 125
    //   65: new 2	com/tencent/thumbplayer/core/thirdparties/LocalCache
    //   68: dup
    //   69: aload_0
    //   70: lload_1
    //   71: iload_3
    //   72: invokespecial 100	com/tencent/thumbplayer/core/thirdparties/LocalCache:<init>	(Ljava/io/File;JI)V
    //   75: astore 5
    //   77: getstatic 27	com/tencent/thumbplayer/core/thirdparties/LocalCache:mInstanceMap	Ljava/util/Map;
    //   80: astore 4
    //   82: new 75	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   89: astore 6
    //   91: aload 6
    //   93: aload_0
    //   94: invokevirtual 103	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   97: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 6
    //   103: invokestatic 87	com/tencent/thumbplayer/core/thirdparties/LocalCache:myPid	()Ljava/lang/String;
    //   106: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 4
    //   112: aload 6
    //   114: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: aload 5
    //   119: invokeinterface 107 3 0
    //   124: pop
    //   125: aload 5
    //   127: areturn
    //   128: astore 4
    //   130: goto -77 -> 53
    //   133: astore_0
    //   134: aload 4
    //   136: areturn
    //   137: astore_0
    //   138: goto -13 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramFile	File
    //   0	141	1	paramLong	long
    //   0	141	3	paramInt	int
    //   3	108	4	localObject1	Object
    //   128	7	4	localException	Exception
    //   12	114	5	localObject2	Object
    //   89	24	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	50	128	java/lang/Exception
    //   65	77	133	java/lang/Throwable
    //   77	125	137	java/lang/Throwable
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
    //   1: getfield 41	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: aload_2
    //   12: aload_1
    //   13: invokestatic 135	com/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager:access$400	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   16: astore_2
    //   17: aload_2
    //   18: invokevirtual 36	java/io/File:exists	()Z
    //   21: ifne +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: new 137	java/io/RandomAccessFile
    //   29: dup
    //   30: aload_2
    //   31: ldc 139
    //   33: invokespecial 140	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: invokevirtual 144	java/io/RandomAccessFile:length	()J
    //   43: l2i
    //   44: newarray byte
    //   46: astore 4
    //   48: aload_3
    //   49: astore_2
    //   50: aload_3
    //   51: aload 4
    //   53: invokevirtual 148	java/io/RandomAccessFile:read	([B)I
    //   56: ifle +54 -> 110
    //   59: aload_3
    //   60: astore_2
    //   61: aload 4
    //   63: invokestatic 154	com/tencent/thumbplayer/core/thirdparties/LocalCache$Utils:access$800	([B)Z
    //   66: ifne +24 -> 90
    //   69: aload_3
    //   70: astore_2
    //   71: aload 4
    //   73: invokestatic 158	com/tencent/thumbplayer/core/thirdparties/LocalCache$Utils:access$900	([B)[B
    //   76: astore_1
    //   77: aload_3
    //   78: invokevirtual 161	java/io/RandomAccessFile:close	()V
    //   81: aload_1
    //   82: areturn
    //   83: astore_2
    //   84: aload_2
    //   85: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   88: aload_1
    //   89: areturn
    //   90: aload_3
    //   91: invokevirtual 161	java/io/RandomAccessFile:close	()V
    //   94: goto +8 -> 102
    //   97: astore_2
    //   98: aload_2
    //   99: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   102: aload_0
    //   103: aload_1
    //   104: invokevirtual 168	com/tencent/thumbplayer/core/thirdparties/LocalCache:remove	(Ljava/lang/String;)Z
    //   107: pop
    //   108: aconst_null
    //   109: areturn
    //   110: aload_3
    //   111: invokevirtual 161	java/io/RandomAccessFile:close	()V
    //   114: aconst_null
    //   115: areturn
    //   116: astore_1
    //   117: aload_1
    //   118: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   121: aconst_null
    //   122: areturn
    //   123: astore_2
    //   124: aload_3
    //   125: astore_1
    //   126: aload_2
    //   127: astore_3
    //   128: goto +12 -> 140
    //   131: astore_1
    //   132: aconst_null
    //   133: astore_2
    //   134: goto +30 -> 164
    //   137: astore_3
    //   138: aconst_null
    //   139: astore_1
    //   140: aload_1
    //   141: astore_2
    //   142: aload_3
    //   143: invokevirtual 169	java/lang/Exception:printStackTrace	()V
    //   146: aload_1
    //   147: ifnull +14 -> 161
    //   150: aload_1
    //   151: invokevirtual 161	java/io/RandomAccessFile:close	()V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_1
    //   157: aload_1
    //   158: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   161: aconst_null
    //   162: areturn
    //   163: astore_1
    //   164: aload_2
    //   165: ifnull +15 -> 180
    //   168: aload_2
    //   169: invokevirtual 161	java/io/RandomAccessFile:close	()V
    //   172: goto +8 -> 180
    //   175: astore_2
    //   176: aload_2
    //   177: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   180: aload_1
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	LocalCache
    //   0	182	1	paramString	String
    //   4	67	2	localObject1	Object
    //   83	2	2	localIOException1	java.io.IOException
    //   97	2	2	localIOException2	java.io.IOException
    //   123	4	2	localException1	Exception
    //   133	36	2	str	String
    //   175	2	2	localIOException3	java.io.IOException
    //   36	92	3	localObject2	Object
    //   137	6	3	localException2	Exception
    //   46	26	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   77	81	83	java/io/IOException
    //   90	94	97	java/io/IOException
    //   110	114	116	java/io/IOException
    //   39	48	123	java/lang/Exception
    //   50	59	123	java/lang/Exception
    //   61	69	123	java/lang/Exception
    //   71	77	123	java/lang/Exception
    //   11	24	131	finally
    //   26	37	131	finally
    //   11	24	137	java/lang/Exception
    //   26	37	137	java/lang/Exception
    //   150	154	156	java/io/IOException
    //   39	48	163	finally
    //   50	59	163	finally
    //   61	69	163	finally
    //   71	77	163	finally
    //   142	146	163	finally
    //   168	172	175	java/io/IOException
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
    paramString = getAsString(paramString);
    try
    {
      paramString = new JSONArray(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public JSONObject getAsJSONObject(String paramString)
  {
    paramString = getAsString(paramString);
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public Object getAsObject(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 173	com/tencent/thumbplayer/core/thirdparties/LocalCache:getAsBinary	(Ljava/lang/String;)[B
    //   5: astore_1
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_1
    //   9: ifnull +184 -> 193
    //   12: new 203	java/io/ByteArrayInputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 206	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: astore_1
    //   21: new 208	java/io/ObjectInputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 211	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   29: astore 6
    //   31: aload_1
    //   32: astore_2
    //   33: aload 6
    //   35: astore 4
    //   37: aload 6
    //   39: invokevirtual 215	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   42: astore_3
    //   43: aload_1
    //   44: invokevirtual 216	java/io/ByteArrayInputStream:close	()V
    //   47: goto +8 -> 55
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   55: aload 6
    //   57: invokevirtual 217	java/io/ObjectInputStream:close	()V
    //   60: aload_3
    //   61: areturn
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   67: aload_3
    //   68: areturn
    //   69: astore 5
    //   71: aload_1
    //   72: astore_3
    //   73: aload 6
    //   75: astore_1
    //   76: goto +36 -> 112
    //   79: astore 4
    //   81: aload_1
    //   82: astore_2
    //   83: aload 4
    //   85: astore_1
    //   86: goto +73 -> 159
    //   89: astore 5
    //   91: aconst_null
    //   92: astore_2
    //   93: aload_1
    //   94: astore_3
    //   95: aload_2
    //   96: astore_1
    //   97: goto +15 -> 112
    //   100: astore_1
    //   101: aconst_null
    //   102: astore_2
    //   103: goto +56 -> 159
    //   106: astore 5
    //   108: aconst_null
    //   109: astore_1
    //   110: aload_1
    //   111: astore_3
    //   112: aload_3
    //   113: astore_2
    //   114: aload_1
    //   115: astore 4
    //   117: aload 5
    //   119: invokevirtual 169	java/lang/Exception:printStackTrace	()V
    //   122: aload_3
    //   123: ifnull +15 -> 138
    //   126: aload_3
    //   127: invokevirtual 216	java/io/ByteArrayInputStream:close	()V
    //   130: goto +8 -> 138
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   138: aload_1
    //   139: ifnull +14 -> 153
    //   142: aload_1
    //   143: invokevirtual 217	java/io/ObjectInputStream:close	()V
    //   146: aconst_null
    //   147: areturn
    //   148: astore_1
    //   149: aload_1
    //   150: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   153: aconst_null
    //   154: areturn
    //   155: astore_1
    //   156: aload 4
    //   158: astore_3
    //   159: aload_2
    //   160: ifnull +15 -> 175
    //   163: aload_2
    //   164: invokevirtual 216	java/io/ByteArrayInputStream:close	()V
    //   167: goto +8 -> 175
    //   170: astore_2
    //   171: aload_2
    //   172: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   175: aload_3
    //   176: ifnull +15 -> 191
    //   179: aload_3
    //   180: invokevirtual 217	java/io/ObjectInputStream:close	()V
    //   183: goto +8 -> 191
    //   186: astore_2
    //   187: aload_2
    //   188: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   191: aload_1
    //   192: athrow
    //   193: aconst_null
    //   194: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	LocalCache
    //   0	195	1	paramString	String
    //   32	82	2	localObject1	Object
    //   133	31	2	localIOException1	java.io.IOException
    //   170	2	2	localIOException2	java.io.IOException
    //   186	2	2	localIOException3	java.io.IOException
    //   7	173	3	localObject2	Object
    //   35	1	4	localObjectInputStream1	java.io.ObjectInputStream
    //   79	5	4	localObject3	Object
    //   115	42	4	str	String
    //   69	1	5	localException1	Exception
    //   89	1	5	localException2	Exception
    //   106	12	5	localException3	Exception
    //   29	45	6	localObjectInputStream2	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   43	47	50	java/io/IOException
    //   55	60	62	java/io/IOException
    //   37	43	69	java/lang/Exception
    //   21	31	79	finally
    //   21	31	89	java/lang/Exception
    //   12	21	100	finally
    //   12	21	106	java/lang/Exception
    //   126	130	133	java/io/IOException
    //   142	146	148	java/io/IOException
    //   37	43	155	finally
    //   117	122	155	finally
    //   163	167	170	java/io/IOException
    //   179	183	186	java/io/IOException
  }
  
  /* Error */
  public String getAsString(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: aload_2
    //   12: aload_1
    //   13: invokestatic 135	com/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager:access$400	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   16: astore_2
    //   17: aload_2
    //   18: invokevirtual 36	java/io/File:exists	()Z
    //   21: ifne +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: new 219	java/io/BufferedReader
    //   29: dup
    //   30: new 221	java/io/FileReader
    //   33: dup
    //   34: aload_2
    //   35: invokespecial 224	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   38: invokespecial 227	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_3
    //   42: ldc 229
    //   44: astore 4
    //   46: aload_3
    //   47: astore_2
    //   48: aload_3
    //   49: invokevirtual 232	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore 5
    //   54: aload 5
    //   56: ifnull +46 -> 102
    //   59: aload_3
    //   60: astore_2
    //   61: new 75	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   68: astore 6
    //   70: aload_3
    //   71: astore_2
    //   72: aload 6
    //   74: aload 4
    //   76: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_3
    //   81: astore_2
    //   82: aload 6
    //   84: aload 5
    //   86: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_3
    //   91: astore_2
    //   92: aload 6
    //   94: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: astore 4
    //   99: goto -53 -> 46
    //   102: aload_3
    //   103: astore_2
    //   104: aload 4
    //   106: invokestatic 235	com/tencent/thumbplayer/core/thirdparties/LocalCache$Utils:access$500	(Ljava/lang/String;)Z
    //   109: ifne +24 -> 133
    //   112: aload_3
    //   113: astore_2
    //   114: aload 4
    //   116: invokestatic 238	com/tencent/thumbplayer/core/thirdparties/LocalCache$Utils:access$600	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore_1
    //   120: aload_3
    //   121: invokevirtual 239	java/io/BufferedReader:close	()V
    //   124: aload_1
    //   125: areturn
    //   126: astore_2
    //   127: aload_2
    //   128: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   131: aload_1
    //   132: areturn
    //   133: aload_3
    //   134: invokevirtual 239	java/io/BufferedReader:close	()V
    //   137: goto +8 -> 145
    //   140: astore_2
    //   141: aload_2
    //   142: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   145: aload_0
    //   146: aload_1
    //   147: invokevirtual 168	com/tencent/thumbplayer/core/thirdparties/LocalCache:remove	(Ljava/lang/String;)Z
    //   150: pop
    //   151: aconst_null
    //   152: areturn
    //   153: astore_2
    //   154: aload_3
    //   155: astore_1
    //   156: aload_2
    //   157: astore_3
    //   158: goto +12 -> 170
    //   161: astore_1
    //   162: aconst_null
    //   163: astore_2
    //   164: goto +30 -> 194
    //   167: astore_3
    //   168: aconst_null
    //   169: astore_1
    //   170: aload_1
    //   171: astore_2
    //   172: aload_3
    //   173: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   176: aload_1
    //   177: ifnull +14 -> 191
    //   180: aload_1
    //   181: invokevirtual 239	java/io/BufferedReader:close	()V
    //   184: aconst_null
    //   185: areturn
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   191: aconst_null
    //   192: areturn
    //   193: astore_1
    //   194: aload_2
    //   195: ifnull +15 -> 210
    //   198: aload_2
    //   199: invokevirtual 239	java/io/BufferedReader:close	()V
    //   202: goto +8 -> 210
    //   205: astore_2
    //   206: aload_2
    //   207: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   210: goto +5 -> 215
    //   213: aload_1
    //   214: athrow
    //   215: goto -2 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	LocalCache
    //   0	218	1	paramString	String
    //   4	110	2	localObject1	Object
    //   126	2	2	localIOException1	java.io.IOException
    //   140	2	2	localIOException2	java.io.IOException
    //   153	4	2	localIOException3	java.io.IOException
    //   163	36	2	str1	String
    //   205	2	2	localIOException4	java.io.IOException
    //   41	117	3	localObject2	Object
    //   167	6	3	localIOException5	java.io.IOException
    //   44	71	4	str2	String
    //   52	33	5	str3	String
    //   68	25	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   120	124	126	java/io/IOException
    //   133	137	140	java/io/IOException
    //   48	54	153	java/io/IOException
    //   61	70	153	java/io/IOException
    //   72	80	153	java/io/IOException
    //   82	90	153	java/io/IOException
    //   92	99	153	java/io/IOException
    //   104	112	153	java/io/IOException
    //   114	120	153	java/io/IOException
    //   26	42	161	finally
    //   26	42	167	java/io/IOException
    //   180	184	186	java/io/IOException
    //   48	54	193	finally
    //   61	70	193	finally
    //   72	80	193	finally
    //   82	90	193	finally
    //   92	99	193	finally
    //   104	112	193	finally
    //   114	120	193	finally
    //   172	176	193	finally
    //   198	202	205	java/io/IOException
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
    //   13: new 267	java/io/ByteArrayOutputStream
    //   16: dup
    //   17: invokespecial 268	java/io/ByteArrayOutputStream:<init>	()V
    //   20: astore 8
    //   22: aload 5
    //   24: astore 4
    //   26: new 270	java/io/ObjectOutputStream
    //   29: dup
    //   30: aload 8
    //   32: invokespecial 273	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   35: astore 5
    //   37: aload 5
    //   39: aload_2
    //   40: invokevirtual 277	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   43: aload 8
    //   45: invokevirtual 281	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   48: astore_2
    //   49: iload_3
    //   50: iconst_m1
    //   51: if_icmpeq +13 -> 64
    //   54: aload_0
    //   55: aload_1
    //   56: aload_2
    //   57: iload_3
    //   58: invokevirtual 251	com/tencent/thumbplayer/core/thirdparties/LocalCache:put	(Ljava/lang/String;[BI)V
    //   61: goto +9 -> 70
    //   64: aload_0
    //   65: aload_1
    //   66: aload_2
    //   67: invokevirtual 247	com/tencent/thumbplayer/core/thirdparties/LocalCache:put	(Ljava/lang/String;[B)V
    //   70: aload 5
    //   72: invokevirtual 282	java/io/ObjectOutputStream:close	()V
    //   75: return
    //   76: astore_1
    //   77: aload 5
    //   79: astore 4
    //   81: goto +60 -> 141
    //   84: astore_2
    //   85: aload 5
    //   87: astore_1
    //   88: goto +18 -> 106
    //   91: astore_2
    //   92: aload 5
    //   94: astore_1
    //   95: goto +31 -> 126
    //   98: astore_1
    //   99: goto +42 -> 141
    //   102: astore_2
    //   103: aload 6
    //   105: astore_1
    //   106: aload_1
    //   107: astore 4
    //   109: aload_2
    //   110: invokevirtual 283	java/lang/Throwable:printStackTrace	()V
    //   113: aload_1
    //   114: ifnull +26 -> 140
    //   117: aload_1
    //   118: invokevirtual 282	java/io/ObjectOutputStream:close	()V
    //   121: return
    //   122: astore_2
    //   123: aload 7
    //   125: astore_1
    //   126: aload_1
    //   127: astore 4
    //   129: aload_2
    //   130: invokevirtual 169	java/lang/Exception:printStackTrace	()V
    //   133: aload_1
    //   134: ifnull +6 -> 140
    //   137: goto -20 -> 117
    //   140: return
    //   141: aload 4
    //   143: ifnull +8 -> 151
    //   146: aload 4
    //   148: invokevirtual 282	java/io/ObjectOutputStream:close	()V
    //   151: goto +5 -> 156
    //   154: aload_1
    //   155: athrow
    //   156: goto -2 -> 154
    //   159: astore_1
    //   160: return
    //   161: astore_2
    //   162: goto -11 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	LocalCache
    //   0	165	1	paramString	String
    //   0	165	2	paramSerializable	Serializable
    //   0	165	3	paramInt	int
    //   11	136	4	localObject1	Object
    //   7	86	5	localObjectOutputStream	java.io.ObjectOutputStream
    //   1	103	6	localObject2	Object
    //   4	120	7	localObject3	Object
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
    //   109	113	98	finally
    //   129	133	98	finally
    //   13	22	102	java/lang/Throwable
    //   26	37	102	java/lang/Throwable
    //   13	22	122	java/lang/Exception
    //   26	37	122	java/lang/Exception
    //   70	75	159	java/lang/Throwable
    //   117	121	159	java/lang/Throwable
    //   146	151	161	java/lang/Throwable
  }
  
  /* Error */
  public void put(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_3
    //   11: aload_1
    //   12: invokestatic 128	com/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager:access$100	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 4
    //   20: aconst_null
    //   21: astore_1
    //   22: new 286	java/io/BufferedWriter
    //   25: dup
    //   26: new 288	java/io/FileWriter
    //   29: dup
    //   30: aload 5
    //   32: invokespecial 289	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   35: sipush 1024
    //   38: invokespecial 292	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   41: astore_3
    //   42: aload_3
    //   43: aload_2
    //   44: invokevirtual 295	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   47: aload_3
    //   48: invokevirtual 298	java/io/BufferedWriter:flush	()V
    //   51: goto +8 -> 59
    //   54: astore_1
    //   55: aload_1
    //   56: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   59: aload_3
    //   60: invokevirtual 299	java/io/BufferedWriter:close	()V
    //   63: goto +63 -> 126
    //   66: astore_1
    //   67: goto +55 -> 122
    //   70: astore_2
    //   71: aload_3
    //   72: astore_1
    //   73: goto +63 -> 136
    //   76: astore_1
    //   77: aload_3
    //   78: astore_2
    //   79: aload_1
    //   80: astore_3
    //   81: goto +11 -> 92
    //   84: astore_2
    //   85: goto +51 -> 136
    //   88: astore_3
    //   89: aload 4
    //   91: astore_2
    //   92: aload_2
    //   93: astore_1
    //   94: aload_3
    //   95: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   98: aload_2
    //   99: ifnull +27 -> 126
    //   102: aload_2
    //   103: invokevirtual 298	java/io/BufferedWriter:flush	()V
    //   106: goto +8 -> 114
    //   109: astore_1
    //   110: aload_1
    //   111: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   114: aload_2
    //   115: invokevirtual 299	java/io/BufferedWriter:close	()V
    //   118: goto +8 -> 126
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   126: aload_0
    //   127: getfield 41	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   130: aload 5
    //   132: invokestatic 303	com/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   135: return
    //   136: aload_1
    //   137: ifnull +27 -> 164
    //   140: aload_1
    //   141: invokevirtual 298	java/io/BufferedWriter:flush	()V
    //   144: goto +8 -> 152
    //   147: astore_3
    //   148: aload_3
    //   149: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   152: aload_1
    //   153: invokevirtual 299	java/io/BufferedWriter:close	()V
    //   156: goto +8 -> 164
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   164: aload_0
    //   165: getfield 41	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   168: aload 5
    //   170: invokestatic 303	com/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   173: aload_2
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	LocalCache
    //   0	175	1	paramString1	String
    //   0	175	2	paramString2	String
    //   4	77	3	localObject1	Object
    //   88	7	3	localIOException1	java.io.IOException
    //   147	2	3	localIOException2	java.io.IOException
    //   18	72	4	localObject2	Object
    //   15	154	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   47	51	54	java/io/IOException
    //   59	63	66	java/io/IOException
    //   42	47	70	finally
    //   42	47	76	java/io/IOException
    //   22	42	84	finally
    //   94	98	84	finally
    //   22	42	88	java/io/IOException
    //   102	106	109	java/io/IOException
    //   114	118	121	java/io/IOException
    //   140	144	147	java/io/IOException
    //   152	156	159	java/io/IOException
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
    //   1: getfield 41	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_3
    //   11: aload_1
    //   12: invokestatic 128	com/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager:access$100	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 4
    //   20: aconst_null
    //   21: astore_1
    //   22: new 320	java/io/FileOutputStream
    //   25: dup
    //   26: aload 5
    //   28: invokespecial 321	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   31: astore_3
    //   32: aload_3
    //   33: aload_2
    //   34: invokevirtual 323	java/io/FileOutputStream:write	([B)V
    //   37: aload_3
    //   38: invokevirtual 324	java/io/FileOutputStream:flush	()V
    //   41: aload_3
    //   42: invokevirtual 325	java/io/FileOutputStream:close	()V
    //   45: goto +55 -> 100
    //   48: astore_1
    //   49: goto +47 -> 96
    //   52: astore_2
    //   53: aload_3
    //   54: astore_1
    //   55: goto +55 -> 110
    //   58: astore_1
    //   59: aload_3
    //   60: astore_2
    //   61: aload_1
    //   62: astore_3
    //   63: goto +11 -> 74
    //   66: astore_2
    //   67: goto +43 -> 110
    //   70: astore_3
    //   71: aload 4
    //   73: astore_2
    //   74: aload_2
    //   75: astore_1
    //   76: aload_3
    //   77: invokevirtual 169	java/lang/Exception:printStackTrace	()V
    //   80: aload_2
    //   81: ifnull +19 -> 100
    //   84: aload_2
    //   85: invokevirtual 324	java/io/FileOutputStream:flush	()V
    //   88: aload_2
    //   89: invokevirtual 325	java/io/FileOutputStream:close	()V
    //   92: goto +8 -> 100
    //   95: astore_1
    //   96: aload_1
    //   97: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   100: aload_0
    //   101: getfield 41	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   104: aload 5
    //   106: invokestatic 303	com/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   109: return
    //   110: aload_1
    //   111: ifnull +19 -> 130
    //   114: aload_1
    //   115: invokevirtual 324	java/io/FileOutputStream:flush	()V
    //   118: aload_1
    //   119: invokevirtual 325	java/io/FileOutputStream:close	()V
    //   122: goto +8 -> 130
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   130: aload_0
    //   131: getfield 41	com/tencent/thumbplayer/core/thirdparties/LocalCache:mCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;
    //   134: aload 5
    //   136: invokestatic 303	com/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   139: aload_2
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	LocalCache
    //   0	141	1	paramString	String
    //   0	141	2	paramArrayOfByte	byte[]
    //   4	59	3	localObject1	Object
    //   70	7	3	localException	Exception
    //   18	54	4	localObject2	Object
    //   15	120	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   37	45	48	java/io/IOException
    //   32	37	52	finally
    //   32	37	58	java/lang/Exception
    //   22	32	66	finally
    //   76	80	66	finally
    //   22	32	70	java/lang/Exception
    //   84	92	95	java/io/IOException
    //   114	122	125	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.thirdparties.LocalCache
 * JD-Core Version:    0.7.0.1
 */