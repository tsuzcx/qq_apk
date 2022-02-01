package com.tencent.qqlive.tvkplayer.thirdparties;

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
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 27	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mInstanceMap	Ljava/util/Map;
    //   6: new 75	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   13: aload_0
    //   14: invokevirtual 79	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   17: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: invokestatic 87	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:myPid	()Ljava/lang/String;
    //   23: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokeinterface 98 2 0
    //   34: checkcast 2	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache
    //   37: astore 5
    //   39: aload 5
    //   41: astore 4
    //   43: aload 4
    //   45: ifnonnull +65 -> 110
    //   48: new 2	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache
    //   51: dup
    //   52: aload_0
    //   53: lload_1
    //   54: iload_3
    //   55: invokespecial 100	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:<init>	(Ljava/io/File;JI)V
    //   58: astore 5
    //   60: getstatic 27	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mInstanceMap	Ljava/util/Map;
    //   63: new 75	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   70: aload_0
    //   71: invokevirtual 103	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   74: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokestatic 87	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:myPid	()Ljava/lang/String;
    //   80: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: aload 5
    //   88: invokeinterface 107 3 0
    //   93: pop
    //   94: aload 5
    //   96: areturn
    //   97: astore_0
    //   98: aload 4
    //   100: areturn
    //   101: astore_0
    //   102: aload 5
    //   104: areturn
    //   105: astore 5
    //   107: goto -64 -> 43
    //   110: aload 4
    //   112: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	paramFile	File
    //   0	113	1	paramLong	long
    //   0	113	3	paramInt	int
    //   1	110	4	localObject	Object
    //   37	66	5	localLocalCache	LocalCache
    //   105	1	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   48	60	97	java/lang/Throwable
    //   60	94	101	java/lang/Throwable
    //   3	39	105	java/lang/Exception
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
    //   4: getfield 41	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   7: ifnonnull +8 -> 15
    //   10: aload 6
    //   12: astore_3
    //   13: aload_3
    //   14: areturn
    //   15: aload_0
    //   16: getfield 41	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   19: aload_1
    //   20: invokestatic 135	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$400	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   23: astore_3
    //   24: aload_3
    //   25: invokevirtual 36	java/io/File:exists	()Z
    //   28: istore_2
    //   29: iload_2
    //   30: ifne +25 -> 55
    //   33: aload 6
    //   35: astore_3
    //   36: iconst_0
    //   37: ifeq -24 -> 13
    //   40: new 137	java/lang/NullPointerException
    //   43: dup
    //   44: invokespecial 138	java/lang/NullPointerException:<init>	()V
    //   47: athrow
    //   48: astore_1
    //   49: aload_1
    //   50: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   53: aconst_null
    //   54: areturn
    //   55: new 143	java/io/RandomAccessFile
    //   58: dup
    //   59: aload_3
    //   60: ldc 145
    //   62: invokespecial 146	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   65: astore 4
    //   67: aload 4
    //   69: astore_3
    //   70: aload 4
    //   72: invokevirtual 150	java/io/RandomAccessFile:length	()J
    //   75: l2i
    //   76: newarray byte
    //   78: astore 5
    //   80: aload 4
    //   82: astore_3
    //   83: aload 4
    //   85: aload 5
    //   87: invokevirtual 154	java/io/RandomAccessFile:read	([B)I
    //   90: ifle +70 -> 160
    //   93: aload 4
    //   95: astore_3
    //   96: aload 5
    //   98: invokestatic 160	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$Utils:access$800	([B)Z
    //   101: ifne +33 -> 134
    //   104: aload 4
    //   106: astore_3
    //   107: aload 5
    //   109: invokestatic 164	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$Utils:access$900	([B)[B
    //   112: astore_1
    //   113: aload_1
    //   114: astore_3
    //   115: aload 4
    //   117: ifnull -104 -> 13
    //   120: aload 4
    //   122: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   125: aload_1
    //   126: areturn
    //   127: astore_3
    //   128: aload_3
    //   129: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   132: aload_1
    //   133: areturn
    //   134: aload 4
    //   136: ifnull +8 -> 144
    //   139: aload 4
    //   141: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   144: aload_0
    //   145: aload_1
    //   146: invokevirtual 171	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:remove	(Ljava/lang/String;)Z
    //   149: pop
    //   150: aconst_null
    //   151: areturn
    //   152: astore_3
    //   153: aload_3
    //   154: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   157: goto -13 -> 144
    //   160: aload 6
    //   162: astore_3
    //   163: aload 4
    //   165: ifnull -152 -> 13
    //   168: aload 4
    //   170: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   173: aconst_null
    //   174: areturn
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   180: aconst_null
    //   181: areturn
    //   182: astore 5
    //   184: aconst_null
    //   185: astore_1
    //   186: aload_1
    //   187: astore_3
    //   188: aload 5
    //   190: invokevirtual 172	java/lang/Exception:printStackTrace	()V
    //   193: aload 6
    //   195: astore_3
    //   196: aload_1
    //   197: ifnull -184 -> 13
    //   200: aload_1
    //   201: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   204: aconst_null
    //   205: areturn
    //   206: astore_1
    //   207: aload_1
    //   208: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   211: aconst_null
    //   212: areturn
    //   213: astore_1
    //   214: aconst_null
    //   215: astore_3
    //   216: aload_3
    //   217: ifnull +7 -> 224
    //   220: aload_3
    //   221: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   224: aload_1
    //   225: athrow
    //   226: astore_3
    //   227: aload_3
    //   228: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   231: goto -7 -> 224
    //   234: astore_1
    //   235: goto -19 -> 216
    //   238: astore 5
    //   240: aload 4
    //   242: astore_1
    //   243: goto -57 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	LocalCache
    //   0	246	1	paramString	String
    //   28	2	2	bool	boolean
    //   12	103	3	localObject1	Object
    //   127	2	3	localIOException1	java.io.IOException
    //   152	2	3	localIOException2	java.io.IOException
    //   162	59	3	localObject2	Object
    //   226	2	3	localIOException3	java.io.IOException
    //   65	176	4	localRandomAccessFile	java.io.RandomAccessFile
    //   78	30	5	arrayOfByte	byte[]
    //   182	7	5	localException1	Exception
    //   238	1	5	localException2	Exception
    //   1	193	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   40	48	48	java/io/IOException
    //   120	125	127	java/io/IOException
    //   139	144	152	java/io/IOException
    //   168	173	175	java/io/IOException
    //   15	29	182	java/lang/Exception
    //   55	67	182	java/lang/Exception
    //   200	204	206	java/io/IOException
    //   15	29	213	finally
    //   55	67	213	finally
    //   220	224	226	java/io/IOException
    //   70	80	234	finally
    //   83	93	234	finally
    //   96	104	234	finally
    //   107	113	234	finally
    //   188	193	234	finally
    //   70	80	238	java/lang/Exception
    //   83	93	238	java/lang/Exception
    //   96	104	238	java/lang/Exception
    //   107	113	238	java/lang/Exception
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
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 176	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:getAsBinary	(Ljava/lang/String;)[B
    //   8: astore_1
    //   9: aload 6
    //   11: astore_2
    //   12: aload_1
    //   13: ifnull +55 -> 68
    //   16: new 206	java/io/ByteArrayInputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 209	java/io/ByteArrayInputStream:<init>	([B)V
    //   24: astore_2
    //   25: new 211	java/io/ObjectInputStream
    //   28: dup
    //   29: aload_2
    //   30: invokespecial 214	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: astore_1
    //   34: aload_1
    //   35: astore 4
    //   37: aload_2
    //   38: astore_3
    //   39: aload_1
    //   40: invokevirtual 218	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   43: astore 5
    //   45: aload 5
    //   47: astore_3
    //   48: aload_2
    //   49: ifnull +7 -> 56
    //   52: aload_2
    //   53: invokevirtual 219	java/io/ByteArrayInputStream:close	()V
    //   56: aload_3
    //   57: astore_2
    //   58: aload_1
    //   59: ifnull +9 -> 68
    //   62: aload_1
    //   63: invokevirtual 220	java/io/ObjectInputStream:close	()V
    //   66: aload_3
    //   67: astore_2
    //   68: aload_2
    //   69: areturn
    //   70: astore_2
    //   71: aload_2
    //   72: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   75: goto -19 -> 56
    //   78: astore_1
    //   79: aload_1
    //   80: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   83: aload_3
    //   84: areturn
    //   85: astore 5
    //   87: aconst_null
    //   88: astore_1
    //   89: aconst_null
    //   90: astore_2
    //   91: aload_1
    //   92: astore 4
    //   94: aload_2
    //   95: astore_3
    //   96: aload 5
    //   98: invokevirtual 172	java/lang/Exception:printStackTrace	()V
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 219	java/io/ByteArrayInputStream:close	()V
    //   109: aload 6
    //   111: astore_2
    //   112: aload_1
    //   113: ifnull -45 -> 68
    //   116: aload_1
    //   117: invokevirtual 220	java/io/ObjectInputStream:close	()V
    //   120: aconst_null
    //   121: areturn
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_2
    //   130: aload_2
    //   131: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   134: goto -25 -> 109
    //   137: astore_1
    //   138: aconst_null
    //   139: astore 4
    //   141: aconst_null
    //   142: astore_2
    //   143: aload_2
    //   144: ifnull +7 -> 151
    //   147: aload_2
    //   148: invokevirtual 219	java/io/ByteArrayInputStream:close	()V
    //   151: aload 4
    //   153: ifnull +8 -> 161
    //   156: aload 4
    //   158: invokevirtual 220	java/io/ObjectInputStream:close	()V
    //   161: aload_1
    //   162: athrow
    //   163: astore_2
    //   164: aload_2
    //   165: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   168: goto -17 -> 151
    //   171: astore_2
    //   172: aload_2
    //   173: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   176: goto -15 -> 161
    //   179: astore_1
    //   180: aconst_null
    //   181: astore 4
    //   183: goto -40 -> 143
    //   186: astore_1
    //   187: aload_3
    //   188: astore_2
    //   189: goto -46 -> 143
    //   192: astore 5
    //   194: aconst_null
    //   195: astore_1
    //   196: goto -105 -> 91
    //   199: astore 5
    //   201: goto -110 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	LocalCache
    //   0	204	1	paramString	String
    //   11	58	2	localObject1	Object
    //   70	2	2	localIOException1	java.io.IOException
    //   90	22	2	localObject2	Object
    //   129	2	2	localIOException2	java.io.IOException
    //   142	6	2	localObject3	Object
    //   163	2	2	localIOException3	java.io.IOException
    //   171	2	2	localIOException4	java.io.IOException
    //   188	1	2	localObject4	Object
    //   38	150	3	localObject5	Object
    //   35	147	4	str	String
    //   43	3	5	localObject6	Object
    //   85	12	5	localException1	Exception
    //   192	1	5	localException2	Exception
    //   199	1	5	localException3	Exception
    //   1	109	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   52	56	70	java/io/IOException
    //   62	66	78	java/io/IOException
    //   16	25	85	java/lang/Exception
    //   116	120	122	java/io/IOException
    //   105	109	129	java/io/IOException
    //   16	25	137	finally
    //   147	151	163	java/io/IOException
    //   156	161	171	java/io/IOException
    //   25	34	179	finally
    //   39	45	186	finally
    //   96	101	186	finally
    //   25	34	192	java/lang/Exception
    //   39	45	199	java/lang/Exception
  }
  
  /* Error */
  public String getAsString(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 41	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   7: ifnonnull +8 -> 15
    //   10: aload 5
    //   12: astore_2
    //   13: aload_2
    //   14: areturn
    //   15: aload_0
    //   16: getfield 41	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   19: aload_1
    //   20: invokestatic 135	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$400	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   23: astore_3
    //   24: aload 5
    //   26: astore_2
    //   27: aload_3
    //   28: invokevirtual 36	java/io/File:exists	()Z
    //   31: ifeq -18 -> 13
    //   34: new 222	java/io/BufferedReader
    //   37: dup
    //   38: new 224	java/io/FileReader
    //   41: dup
    //   42: aload_3
    //   43: invokespecial 227	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   46: invokespecial 230	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore_3
    //   50: ldc 232
    //   52: astore 4
    //   54: aload_3
    //   55: astore_2
    //   56: aload_3
    //   57: invokevirtual 235	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore 6
    //   62: aload 6
    //   64: ifnull +30 -> 94
    //   67: aload_3
    //   68: astore_2
    //   69: new 75	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   76: aload 4
    //   78: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload 6
    //   83: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore 4
    //   91: goto -37 -> 54
    //   94: aload_3
    //   95: astore_2
    //   96: aload 4
    //   98: invokestatic 238	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$Utils:access$500	(Ljava/lang/String;)Z
    //   101: ifne +30 -> 131
    //   104: aload_3
    //   105: astore_2
    //   106: aload 4
    //   108: invokestatic 241	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$Utils:access$600	(Ljava/lang/String;)Ljava/lang/String;
    //   111: astore_1
    //   112: aload_1
    //   113: astore_2
    //   114: aload_3
    //   115: ifnull -102 -> 13
    //   118: aload_3
    //   119: invokevirtual 242	java/io/BufferedReader:close	()V
    //   122: aload_1
    //   123: areturn
    //   124: astore_2
    //   125: aload_2
    //   126: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   129: aload_1
    //   130: areturn
    //   131: aload_3
    //   132: ifnull +7 -> 139
    //   135: aload_3
    //   136: invokevirtual 242	java/io/BufferedReader:close	()V
    //   139: aload_0
    //   140: aload_1
    //   141: invokevirtual 171	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:remove	(Ljava/lang/String;)Z
    //   144: pop
    //   145: aconst_null
    //   146: areturn
    //   147: astore_2
    //   148: aload_2
    //   149: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   152: goto -13 -> 139
    //   155: astore 4
    //   157: aconst_null
    //   158: astore_1
    //   159: aload_1
    //   160: astore_2
    //   161: aload 4
    //   163: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   166: aload 5
    //   168: astore_2
    //   169: aload_1
    //   170: ifnull -157 -> 13
    //   173: aload_1
    //   174: invokevirtual 242	java/io/BufferedReader:close	()V
    //   177: aconst_null
    //   178: areturn
    //   179: astore_1
    //   180: aload_1
    //   181: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   184: aconst_null
    //   185: areturn
    //   186: astore_1
    //   187: aconst_null
    //   188: astore_2
    //   189: aload_2
    //   190: ifnull +7 -> 197
    //   193: aload_2
    //   194: invokevirtual 242	java/io/BufferedReader:close	()V
    //   197: aload_1
    //   198: athrow
    //   199: astore_2
    //   200: aload_2
    //   201: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   204: goto -7 -> 197
    //   207: astore_1
    //   208: goto -19 -> 189
    //   211: astore 4
    //   213: aload_3
    //   214: astore_1
    //   215: goto -56 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	LocalCache
    //   0	218	1	paramString	String
    //   12	102	2	localObject1	Object
    //   124	2	2	localIOException1	java.io.IOException
    //   147	2	2	localIOException2	java.io.IOException
    //   160	34	2	localObject2	Object
    //   199	2	2	localIOException3	java.io.IOException
    //   23	191	3	localObject3	Object
    //   52	55	4	str1	String
    //   155	7	4	localIOException4	java.io.IOException
    //   211	1	4	localIOException5	java.io.IOException
    //   1	166	5	localObject4	Object
    //   60	22	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   118	122	124	java/io/IOException
    //   135	139	147	java/io/IOException
    //   34	50	155	java/io/IOException
    //   173	177	179	java/io/IOException
    //   34	50	186	finally
    //   193	197	199	java/io/IOException
    //   56	62	207	finally
    //   69	91	207	finally
    //   96	104	207	finally
    //   106	112	207	finally
    //   161	166	207	finally
    //   56	62	211	java/io/IOException
    //   69	91	211	java/io/IOException
    //   96	104	211	java/io/IOException
    //   106	112	211	java/io/IOException
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
    //   0: new 270	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 271	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 6
    //   9: new 273	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 6
    //   15: invokespecial 276	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 5
    //   20: aload 5
    //   22: astore 4
    //   24: aload 5
    //   26: aload_2
    //   27: invokevirtual 280	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   30: aload 5
    //   32: astore 4
    //   34: aload 6
    //   36: invokevirtual 284	java/io/ByteArrayOutputStream:toByteArray	()[B
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
    //   53: invokevirtual 254	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:put	(Ljava/lang/String;[BI)V
    //   56: aload 5
    //   58: ifnull +8 -> 66
    //   61: aload 5
    //   63: invokevirtual 285	java/io/ObjectOutputStream:close	()V
    //   66: return
    //   67: aload 5
    //   69: astore 4
    //   71: aload_0
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 250	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:put	(Ljava/lang/String;[B)V
    //   77: goto -21 -> 56
    //   80: astore_1
    //   81: aload 5
    //   83: astore 4
    //   85: aload_1
    //   86: invokevirtual 172	java/lang/Exception:printStackTrace	()V
    //   89: aload 5
    //   91: ifnull -25 -> 66
    //   94: aload 5
    //   96: invokevirtual 285	java/io/ObjectOutputStream:close	()V
    //   99: return
    //   100: astore_1
    //   101: return
    //   102: astore_1
    //   103: aconst_null
    //   104: astore 5
    //   106: aload 5
    //   108: astore 4
    //   110: aload_1
    //   111: invokevirtual 286	java/lang/Throwable:printStackTrace	()V
    //   114: aload 5
    //   116: ifnull -50 -> 66
    //   119: aload 5
    //   121: invokevirtual 285	java/io/ObjectOutputStream:close	()V
    //   124: return
    //   125: astore_1
    //   126: return
    //   127: astore_1
    //   128: aconst_null
    //   129: astore 4
    //   131: aload 4
    //   133: ifnull +8 -> 141
    //   136: aload 4
    //   138: invokevirtual 285	java/io/ObjectOutputStream:close	()V
    //   141: aload_1
    //   142: athrow
    //   143: astore_1
    //   144: return
    //   145: astore_2
    //   146: goto -5 -> 141
    //   149: astore_1
    //   150: goto -19 -> 131
    //   153: astore_1
    //   154: goto -48 -> 106
    //   157: astore_1
    //   158: aconst_null
    //   159: astore 5
    //   161: goto -80 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	LocalCache
    //   0	164	1	paramString	String
    //   0	164	2	paramSerializable	Serializable
    //   0	164	3	paramInt	int
    //   22	115	4	localObjectOutputStream1	java.io.ObjectOutputStream
    //   18	142	5	localObjectOutputStream2	java.io.ObjectOutputStream
    //   7	28	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   24	30	80	java/lang/Exception
    //   34	40	80	java/lang/Exception
    //   49	56	80	java/lang/Exception
    //   71	77	80	java/lang/Exception
    //   94	99	100	java/lang/Throwable
    //   0	20	102	java/lang/Throwable
    //   119	124	125	java/lang/Throwable
    //   0	20	127	finally
    //   61	66	143	java/lang/Throwable
    //   136	141	145	java/lang/Throwable
    //   24	30	149	finally
    //   34	40	149	finally
    //   49	56	149	finally
    //   71	77	149	finally
    //   85	89	149	finally
    //   110	114	149	finally
    //   24	30	153	java/lang/Throwable
    //   34	40	153	java/lang/Throwable
    //   49	56	153	java/lang/Throwable
    //   71	77	153	java/lang/Throwable
    //   0	20	157	java/lang/Exception
  }
  
  /* Error */
  public void put(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 41	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   12: aload_1
    //   13: invokestatic 128	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$100	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   16: astore 5
    //   18: aconst_null
    //   19: astore_1
    //   20: new 289	java/io/BufferedWriter
    //   23: dup
    //   24: new 291	java/io/FileWriter
    //   27: dup
    //   28: aload 5
    //   30: invokespecial 292	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   33: sipush 1024
    //   36: invokespecial 295	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   39: astore_3
    //   40: aload_3
    //   41: astore_1
    //   42: aload_3
    //   43: aload_2
    //   44: invokevirtual 298	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   47: aload_3
    //   48: ifnull +11 -> 59
    //   51: aload_3
    //   52: invokevirtual 301	java/io/BufferedWriter:flush	()V
    //   55: aload_3
    //   56: invokevirtual 302	java/io/BufferedWriter:close	()V
    //   59: aload_0
    //   60: getfield 41	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   63: aload 5
    //   65: invokestatic 306	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   68: return
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   74: goto -19 -> 55
    //   77: astore_1
    //   78: aload_1
    //   79: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   82: goto -23 -> 59
    //   85: astore 4
    //   87: aconst_null
    //   88: astore_2
    //   89: aload_2
    //   90: astore_1
    //   91: aload 4
    //   93: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   96: aload_2
    //   97: ifnull +11 -> 108
    //   100: aload_2
    //   101: invokevirtual 301	java/io/BufferedWriter:flush	()V
    //   104: aload_2
    //   105: invokevirtual 302	java/io/BufferedWriter:close	()V
    //   108: aload_0
    //   109: getfield 41	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   112: aload 5
    //   114: invokestatic 306	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   117: return
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   123: goto -19 -> 104
    //   126: astore_1
    //   127: aload_1
    //   128: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   131: goto -23 -> 108
    //   134: astore_3
    //   135: aload_1
    //   136: astore_2
    //   137: aload_3
    //   138: astore_1
    //   139: aload_2
    //   140: ifnull +11 -> 151
    //   143: aload_2
    //   144: invokevirtual 301	java/io/BufferedWriter:flush	()V
    //   147: aload_2
    //   148: invokevirtual 302	java/io/BufferedWriter:close	()V
    //   151: aload_0
    //   152: getfield 41	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   155: aload 5
    //   157: invokestatic 306	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   160: aload_1
    //   161: athrow
    //   162: astore_3
    //   163: aload_3
    //   164: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   167: goto -20 -> 147
    //   170: astore_2
    //   171: aload_2
    //   172: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   175: goto -24 -> 151
    //   178: astore_3
    //   179: aload_1
    //   180: astore_2
    //   181: aload_3
    //   182: astore_1
    //   183: goto -44 -> 139
    //   186: astore 4
    //   188: aload_3
    //   189: astore_2
    //   190: goto -101 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	LocalCache
    //   0	193	1	paramString1	String
    //   0	193	2	paramString2	String
    //   39	17	3	localBufferedWriter	java.io.BufferedWriter
    //   134	4	3	localObject1	Object
    //   162	2	3	localIOException1	java.io.IOException
    //   178	11	3	localObject2	Object
    //   85	7	4	localIOException2	java.io.IOException
    //   186	1	4	localIOException3	java.io.IOException
    //   16	140	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   51	55	69	java/io/IOException
    //   55	59	77	java/io/IOException
    //   20	40	85	java/io/IOException
    //   100	104	118	java/io/IOException
    //   104	108	126	java/io/IOException
    //   20	40	134	finally
    //   143	147	162	java/io/IOException
    //   147	151	170	java/io/IOException
    //   42	47	178	finally
    //   91	96	178	finally
    //   42	47	186	java/io/IOException
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
    //   1: getfield 41	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 41	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   12: aload_1
    //   13: invokestatic 128	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$100	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   16: astore 5
    //   18: new 323	java/io/FileOutputStream
    //   21: dup
    //   22: aload 5
    //   24: invokespecial 324	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   27: astore_3
    //   28: aload_3
    //   29: astore_1
    //   30: aload_3
    //   31: aload_2
    //   32: invokevirtual 326	java/io/FileOutputStream:write	([B)V
    //   35: aload_3
    //   36: ifnull +11 -> 47
    //   39: aload_3
    //   40: invokevirtual 327	java/io/FileOutputStream:flush	()V
    //   43: aload_3
    //   44: invokevirtual 328	java/io/FileOutputStream:close	()V
    //   47: aload_0
    //   48: getfield 41	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   51: aload 5
    //   53: invokestatic 306	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   56: return
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   62: goto -15 -> 47
    //   65: astore 4
    //   67: aconst_null
    //   68: astore_2
    //   69: aload_2
    //   70: astore_1
    //   71: aload 4
    //   73: invokevirtual 172	java/lang/Exception:printStackTrace	()V
    //   76: aload_2
    //   77: ifnull +11 -> 88
    //   80: aload_2
    //   81: invokevirtual 327	java/io/FileOutputStream:flush	()V
    //   84: aload_2
    //   85: invokevirtual 328	java/io/FileOutputStream:close	()V
    //   88: aload_0
    //   89: getfield 41	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   92: aload 5
    //   94: invokestatic 306	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   97: return
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   103: goto -15 -> 88
    //   106: astore_2
    //   107: aconst_null
    //   108: astore_1
    //   109: aload_1
    //   110: ifnull +11 -> 121
    //   113: aload_1
    //   114: invokevirtual 327	java/io/FileOutputStream:flush	()V
    //   117: aload_1
    //   118: invokevirtual 328	java/io/FileOutputStream:close	()V
    //   121: aload_0
    //   122: getfield 41	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache:mCache	Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;
    //   125: aload 5
    //   127: invokestatic 306	com/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager:access$200	(Lcom/tencent/qqlive/tvkplayer/thirdparties/LocalCache$ACacheManager;Ljava/io/File;)V
    //   130: aload_2
    //   131: athrow
    //   132: astore_1
    //   133: aload_1
    //   134: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   137: goto -16 -> 121
    //   140: astore_2
    //   141: goto -32 -> 109
    //   144: astore 4
    //   146: aload_3
    //   147: astore_2
    //   148: goto -79 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	LocalCache
    //   0	151	1	paramString	String
    //   0	151	2	paramArrayOfByte	byte[]
    //   27	120	3	localFileOutputStream	java.io.FileOutputStream
    //   65	7	4	localException1	Exception
    //   144	1	4	localException2	Exception
    //   16	110	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   39	47	57	java/io/IOException
    //   18	28	65	java/lang/Exception
    //   80	88	98	java/io/IOException
    //   18	28	106	finally
    //   113	121	132	java/io/IOException
    //   30	35	140	finally
    //   71	76	140	finally
    //   30	35	144	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.LocalCache
 * JD-Core Version:    0.7.0.1
 */