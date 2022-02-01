package de.robv.android.xposed;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Environment;
import de.robv.android.xposed.services.BaseService;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class XSharedPreferences
  implements SharedPreferences
{
  private static final String TAG = "XSharedPreferences";
  private static File sPackageBaseDirectory = null;
  private final File mFile;
  private long mFileSize;
  private final String mFilename;
  private long mLastModified;
  private boolean mLoaded = false;
  private Map<String, Object> mMap;
  
  static
  {
    if (System.getProperty("vxp") != null) {
      sPackageBaseDirectory = new File(System.getProperty("vxp_user_dir"));
    }
  }
  
  public XSharedPreferences(File paramFile)
  {
    this.mFile = paramFile;
    this.mFilename = this.mFile.getAbsolutePath();
    startLoadFromDisk();
  }
  
  public XSharedPreferences(String paramString)
  {
    this(paramString, paramString + "_preferences");
  }
  
  public XSharedPreferences(String paramString1, String paramString2)
  {
    if (sPackageBaseDirectory == null) {}
    for (this.mFile = new File(Environment.getDataDirectory(), "data/" + paramString1 + "/shared_prefs/" + paramString2 + ".xml");; this.mFile = new File(sPackageBaseDirectory, paramString1 + "/shared_prefs/" + paramString2 + ".xml"))
    {
      this.mFilename = this.mFile.getAbsolutePath();
      startLoadFromDisk();
      return;
    }
  }
  
  private void awaitLoadedLocked()
  {
    while (!this.mLoaded) {
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  /* Error */
  private void loadFromDiskLocked()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 48	de/robv/android/xposed/XSharedPreferences:mLoaded	Z
    //   6: ifeq +4 -> 10
    //   9: return
    //   10: invokestatic 116	de/robv/android/xposed/SELinuxHelper:getAppDataFileService	()Lde/robv/android/xposed/services/BaseService;
    //   13: aload_0
    //   14: getfield 56	de/robv/android/xposed/XSharedPreferences:mFilename	Ljava/lang/String;
    //   17: aload_0
    //   18: getfield 118	de/robv/android/xposed/XSharedPreferences:mFileSize	J
    //   21: aload_0
    //   22: getfield 120	de/robv/android/xposed/XSharedPreferences:mLastModified	J
    //   25: invokevirtual 126	de/robv/android/xposed/services/BaseService:getFileInputStream	(Ljava/lang/String;JJ)Lde/robv/android/xposed/services/FileResult;
    //   28: astore_1
    //   29: aload_1
    //   30: astore_2
    //   31: aload_1
    //   32: getfield 132	de/robv/android/xposed/services/FileResult:stream	Ljava/io/InputStream;
    //   35: ifnull +93 -> 128
    //   38: aload_1
    //   39: astore_2
    //   40: aload_1
    //   41: getfield 132	de/robv/android/xposed/services/FileResult:stream	Ljava/io/InputStream;
    //   44: invokestatic 138	com/android/internal/util/XmlUtils:readMapXml	(Ljava/io/InputStream;)Ljava/util/HashMap;
    //   47: astore_3
    //   48: aload_1
    //   49: astore_2
    //   50: aload_1
    //   51: getfield 132	de/robv/android/xposed/services/FileResult:stream	Ljava/io/InputStream;
    //   54: invokevirtual 143	java/io/InputStream:close	()V
    //   57: aload_3
    //   58: astore 4
    //   60: aload_1
    //   61: astore_2
    //   62: aload 4
    //   64: astore_3
    //   65: aload_1
    //   66: ifnull +27 -> 93
    //   69: aload_1
    //   70: astore_2
    //   71: aload 4
    //   73: astore_3
    //   74: aload_1
    //   75: getfield 132	de/robv/android/xposed/services/FileResult:stream	Ljava/io/InputStream;
    //   78: ifnull +15 -> 93
    //   81: aload_1
    //   82: getfield 132	de/robv/android/xposed/services/FileResult:stream	Ljava/io/InputStream;
    //   85: invokevirtual 143	java/io/InputStream:close	()V
    //   88: aload 4
    //   90: astore_3
    //   91: aload_1
    //   92: astore_2
    //   93: aload_0
    //   94: iconst_1
    //   95: putfield 48	de/robv/android/xposed/XSharedPreferences:mLoaded	Z
    //   98: aload_3
    //   99: ifnull +227 -> 326
    //   102: aload_0
    //   103: aload_3
    //   104: putfield 145	de/robv/android/xposed/XSharedPreferences:mMap	Ljava/util/Map;
    //   107: aload_0
    //   108: aload_2
    //   109: getfield 148	de/robv/android/xposed/services/FileResult:mtime	J
    //   112: putfield 120	de/robv/android/xposed/XSharedPreferences:mLastModified	J
    //   115: aload_0
    //   116: aload_2
    //   117: getfield 151	de/robv/android/xposed/services/FileResult:size	J
    //   120: putfield 118	de/robv/android/xposed/XSharedPreferences:mFileSize	J
    //   123: aload_0
    //   124: invokevirtual 154	java/lang/Object:notifyAll	()V
    //   127: return
    //   128: aload_1
    //   129: astore_2
    //   130: aload_0
    //   131: getfield 145	de/robv/android/xposed/XSharedPreferences:mMap	Ljava/util/Map;
    //   134: astore 4
    //   136: goto -76 -> 60
    //   139: astore_1
    //   140: aload_1
    //   141: athrow
    //   142: astore_3
    //   143: aconst_null
    //   144: astore 4
    //   146: aconst_null
    //   147: astore_1
    //   148: aload_1
    //   149: astore_2
    //   150: ldc 10
    //   152: ldc 156
    //   154: aload_3
    //   155: invokestatic 162	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   158: pop
    //   159: aload_1
    //   160: astore_2
    //   161: aload 4
    //   163: astore_3
    //   164: aload_1
    //   165: ifnull -72 -> 93
    //   168: aload_1
    //   169: astore_2
    //   170: aload 4
    //   172: astore_3
    //   173: aload_1
    //   174: getfield 132	de/robv/android/xposed/services/FileResult:stream	Ljava/io/InputStream;
    //   177: ifnull -84 -> 93
    //   180: aload_1
    //   181: getfield 132	de/robv/android/xposed/services/FileResult:stream	Ljava/io/InputStream;
    //   184: invokevirtual 143	java/io/InputStream:close	()V
    //   187: aload_1
    //   188: astore_2
    //   189: aload 4
    //   191: astore_3
    //   192: goto -99 -> 93
    //   195: astore_1
    //   196: aload_1
    //   197: athrow
    //   198: astore_1
    //   199: aconst_null
    //   200: astore 4
    //   202: aconst_null
    //   203: astore_1
    //   204: aload 4
    //   206: astore_2
    //   207: aload_1
    //   208: astore_3
    //   209: aload 4
    //   211: ifnull -118 -> 93
    //   214: aload 4
    //   216: astore_2
    //   217: aload_1
    //   218: astore_3
    //   219: aload 4
    //   221: getfield 132	de/robv/android/xposed/services/FileResult:stream	Ljava/io/InputStream;
    //   224: ifnull -131 -> 93
    //   227: aload 4
    //   229: getfield 132	de/robv/android/xposed/services/FileResult:stream	Ljava/io/InputStream;
    //   232: invokevirtual 143	java/io/InputStream:close	()V
    //   235: aload 4
    //   237: astore_2
    //   238: aload_1
    //   239: astore_3
    //   240: goto -147 -> 93
    //   243: astore_1
    //   244: aload_1
    //   245: athrow
    //   246: astore_3
    //   247: aconst_null
    //   248: astore 4
    //   250: aconst_null
    //   251: astore_1
    //   252: aload_1
    //   253: astore_2
    //   254: ldc 10
    //   256: ldc 156
    //   258: aload_3
    //   259: invokestatic 162	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   262: pop
    //   263: aload_1
    //   264: astore_2
    //   265: aload 4
    //   267: astore_3
    //   268: aload_1
    //   269: ifnull -176 -> 93
    //   272: aload_1
    //   273: astore_2
    //   274: aload 4
    //   276: astore_3
    //   277: aload_1
    //   278: getfield 132	de/robv/android/xposed/services/FileResult:stream	Ljava/io/InputStream;
    //   281: ifnull -188 -> 93
    //   284: aload_1
    //   285: getfield 132	de/robv/android/xposed/services/FileResult:stream	Ljava/io/InputStream;
    //   288: invokevirtual 143	java/io/InputStream:close	()V
    //   291: aload_1
    //   292: astore_2
    //   293: aload 4
    //   295: astore_3
    //   296: goto -203 -> 93
    //   299: astore_1
    //   300: aload_1
    //   301: athrow
    //   302: astore_1
    //   303: aload_2
    //   304: ifnull +17 -> 321
    //   307: aload_2
    //   308: getfield 132	de/robv/android/xposed/services/FileResult:stream	Ljava/io/InputStream;
    //   311: ifnull +10 -> 321
    //   314: aload_2
    //   315: getfield 132	de/robv/android/xposed/services/FileResult:stream	Ljava/io/InputStream;
    //   318: invokevirtual 143	java/io/InputStream:close	()V
    //   321: aload_1
    //   322: athrow
    //   323: astore_1
    //   324: aload_1
    //   325: athrow
    //   326: aload_0
    //   327: new 164	java/util/HashMap
    //   330: dup
    //   331: invokespecial 165	java/util/HashMap:<init>	()V
    //   334: putfield 145	de/robv/android/xposed/XSharedPreferences:mMap	Ljava/util/Map;
    //   337: goto -214 -> 123
    //   340: astore_2
    //   341: goto -20 -> 321
    //   344: astore_1
    //   345: goto -42 -> 303
    //   348: astore_2
    //   349: aload_1
    //   350: astore_2
    //   351: aload 4
    //   353: astore_3
    //   354: goto -261 -> 93
    //   357: astore_3
    //   358: aconst_null
    //   359: astore 4
    //   361: goto -109 -> 252
    //   364: astore_2
    //   365: aload_3
    //   366: astore 4
    //   368: aload_2
    //   369: astore_3
    //   370: goto -118 -> 252
    //   373: astore_2
    //   374: aload 4
    //   376: astore_2
    //   377: aload_1
    //   378: astore_3
    //   379: goto -286 -> 93
    //   382: astore_2
    //   383: aconst_null
    //   384: astore_2
    //   385: aload_1
    //   386: astore 4
    //   388: aload_2
    //   389: astore_1
    //   390: goto -186 -> 204
    //   393: astore_2
    //   394: aload_1
    //   395: astore 4
    //   397: aload_3
    //   398: astore_1
    //   399: goto -195 -> 204
    //   402: astore_2
    //   403: aload_1
    //   404: astore_2
    //   405: aload 4
    //   407: astore_3
    //   408: goto -315 -> 93
    //   411: astore_3
    //   412: aconst_null
    //   413: astore 4
    //   415: goto -267 -> 148
    //   418: astore_2
    //   419: aload_3
    //   420: astore 4
    //   422: aload_2
    //   423: astore_3
    //   424: goto -276 -> 148
    //   427: astore_2
    //   428: aload_1
    //   429: astore_2
    //   430: aload 4
    //   432: astore_3
    //   433: goto -340 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	436	0	this	XSharedPreferences
    //   28	101	1	localFileResult	de.robv.android.xposed.services.FileResult
    //   139	2	1	localRuntimeException1	java.lang.RuntimeException
    //   147	41	1	localObject1	Object
    //   195	2	1	localRuntimeException2	java.lang.RuntimeException
    //   198	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   203	36	1	localObject2	Object
    //   243	2	1	localRuntimeException3	java.lang.RuntimeException
    //   251	41	1	localObject3	Object
    //   299	2	1	localRuntimeException4	java.lang.RuntimeException
    //   302	20	1	localObject4	Object
    //   323	2	1	localRuntimeException5	java.lang.RuntimeException
    //   344	42	1	localObject5	Object
    //   389	40	1	localObject6	Object
    //   1	314	2	localObject7	Object
    //   340	1	2	localException1	java.lang.Exception
    //   348	1	2	localException2	java.lang.Exception
    //   350	1	2	localObject8	Object
    //   364	5	2	localIOException1	java.io.IOException
    //   373	1	2	localException3	java.lang.Exception
    //   376	1	2	localObject9	Object
    //   382	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   384	5	2	localObject10	Object
    //   393	1	2	localFileNotFoundException3	java.io.FileNotFoundException
    //   402	1	2	localException4	java.lang.Exception
    //   404	1	2	localObject11	Object
    //   418	5	2	localXmlPullParserException1	org.xmlpull.v1.XmlPullParserException
    //   427	1	2	localException5	java.lang.Exception
    //   429	1	2	localObject12	Object
    //   47	57	3	localObject13	Object
    //   142	13	3	localXmlPullParserException2	org.xmlpull.v1.XmlPullParserException
    //   163	77	3	localObject14	Object
    //   246	13	3	localIOException2	java.io.IOException
    //   267	87	3	localObject15	Object
    //   357	9	3	localIOException3	java.io.IOException
    //   369	39	3	localObject16	Object
    //   411	9	3	localXmlPullParserException3	org.xmlpull.v1.XmlPullParserException
    //   423	10	3	localObject17	Object
    //   58	373	4	localObject18	Object
    // Exception table:
    //   from	to	target	type
    //   81	88	139	java/lang/RuntimeException
    //   10	29	142	org/xmlpull/v1/XmlPullParserException
    //   180	187	195	java/lang/RuntimeException
    //   10	29	198	java/io/FileNotFoundException
    //   227	235	243	java/lang/RuntimeException
    //   10	29	246	java/io/IOException
    //   284	291	299	java/lang/RuntimeException
    //   10	29	302	finally
    //   314	321	323	java/lang/RuntimeException
    //   314	321	340	java/lang/Exception
    //   31	38	344	finally
    //   40	48	344	finally
    //   50	57	344	finally
    //   130	136	344	finally
    //   150	159	344	finally
    //   254	263	344	finally
    //   284	291	348	java/lang/Exception
    //   31	38	357	java/io/IOException
    //   40	48	357	java/io/IOException
    //   130	136	357	java/io/IOException
    //   50	57	364	java/io/IOException
    //   227	235	373	java/lang/Exception
    //   31	38	382	java/io/FileNotFoundException
    //   40	48	382	java/io/FileNotFoundException
    //   130	136	382	java/io/FileNotFoundException
    //   50	57	393	java/io/FileNotFoundException
    //   180	187	402	java/lang/Exception
    //   31	38	411	org/xmlpull/v1/XmlPullParserException
    //   40	48	411	org/xmlpull/v1/XmlPullParserException
    //   130	136	411	org/xmlpull/v1/XmlPullParserException
    //   50	57	418	org/xmlpull/v1/XmlPullParserException
    //   81	88	427	java/lang/Exception
  }
  
  public static void setPackageBaseDirectory(File paramFile)
  {
    if ((sPackageBaseDirectory != null) && (!sPackageBaseDirectory.equals(paramFile))) {
      throw new IllegalStateException("you can only set package base dir once, p: " + sPackageBaseDirectory + " n:" + paramFile);
    }
    sPackageBaseDirectory = paramFile;
  }
  
  private void startLoadFromDisk()
  {
    try
    {
      this.mLoaded = false;
      new XSharedPreferences.1(this, "XSharedPreferences-load").start();
      return;
    }
    finally {}
  }
  
  public boolean contains(String paramString)
  {
    try
    {
      awaitLoadedLocked();
      boolean bool = this.mMap.containsKey(paramString);
      return bool;
    }
    finally {}
  }
  
  @Deprecated
  public SharedPreferences.Editor edit()
  {
    throw new UnsupportedOperationException("read-only implementation");
  }
  
  public Map<String, ?> getAll()
  {
    try
    {
      awaitLoadedLocked();
      HashMap localHashMap = new HashMap(this.mMap);
      return localHashMap;
    }
    finally {}
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    try
    {
      awaitLoadedLocked();
      paramString = (Boolean)this.mMap.get(paramString);
      if (paramString != null) {
        paramBoolean = paramString.booleanValue();
      }
      return paramBoolean;
    }
    finally {}
  }
  
  public File getFile()
  {
    return this.mFile;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    try
    {
      awaitLoadedLocked();
      paramString = (Float)this.mMap.get(paramString);
      if (paramString != null) {
        paramFloat = paramString.floatValue();
      }
      return paramFloat;
    }
    finally {}
  }
  
  public int getInt(String paramString, int paramInt)
  {
    try
    {
      awaitLoadedLocked();
      paramString = (Integer)this.mMap.get(paramString);
      if (paramString != null) {
        paramInt = paramString.intValue();
      }
      return paramInt;
    }
    finally {}
  }
  
  public long getLong(String paramString, long paramLong)
  {
    try
    {
      awaitLoadedLocked();
      paramString = (Long)this.mMap.get(paramString);
      if (paramString != null) {
        paramLong = paramString.longValue();
      }
      return paramLong;
    }
    finally {}
  }
  
  public String getString(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        awaitLoadedLocked();
        paramString1 = (String)this.mMap.get(paramString1);
        if (paramString1 != null) {
          return paramString1;
        }
      }
      finally {}
      paramString1 = paramString2;
    }
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    for (;;)
    {
      try
      {
        awaitLoadedLocked();
        paramString = (Set)this.mMap.get(paramString);
        if (paramString != null) {
          return paramString;
        }
      }
      finally {}
      paramString = paramSet;
    }
  }
  
  /* Error */
  public boolean hasFileChanged()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 116	de/robv/android/xposed/SELinuxHelper:getAppDataFileService	()Lde/robv/android/xposed/services/BaseService;
    //   7: aload_0
    //   8: getfield 56	de/robv/android/xposed/XSharedPreferences:mFilename	Ljava/lang/String;
    //   11: invokevirtual 266	de/robv/android/xposed/services/BaseService:statFile	(Ljava/lang/String;)Lde/robv/android/xposed/services/FileResult;
    //   14: astore 7
    //   16: iload_2
    //   17: istore_1
    //   18: aload_0
    //   19: getfield 120	de/robv/android/xposed/XSharedPreferences:mLastModified	J
    //   22: aload 7
    //   24: getfield 148	de/robv/android/xposed/services/FileResult:mtime	J
    //   27: lcmp
    //   28: ifne +24 -> 52
    //   31: aload_0
    //   32: getfield 118	de/robv/android/xposed/XSharedPreferences:mFileSize	J
    //   35: lstore_3
    //   36: aload 7
    //   38: getfield 151	de/robv/android/xposed/services/FileResult:size	J
    //   41: lstore 5
    //   43: lload_3
    //   44: lload 5
    //   46: lcmp
    //   47: ifeq +9 -> 56
    //   50: iload_2
    //   51: istore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_1
    //   55: ireturn
    //   56: iconst_0
    //   57: istore_1
    //   58: goto -6 -> 52
    //   61: astore 7
    //   63: ldc 10
    //   65: ldc_w 267
    //   68: aload 7
    //   70: invokestatic 162	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   73: pop
    //   74: iload_2
    //   75: istore_1
    //   76: goto -24 -> 52
    //   79: astore 7
    //   81: aload_0
    //   82: monitorexit
    //   83: aload 7
    //   85: athrow
    //   86: astore 7
    //   88: iload_2
    //   89: istore_1
    //   90: goto -38 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	XSharedPreferences
    //   17	73	1	bool1	boolean
    //   1	88	2	bool2	boolean
    //   35	9	3	l1	long
    //   41	4	5	l2	long
    //   14	23	7	localFileResult	de.robv.android.xposed.services.FileResult
    //   61	8	7	localIOException	java.io.IOException
    //   79	5	7	localObject	Object
    //   86	1	7	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   4	16	61	java/io/IOException
    //   18	43	61	java/io/IOException
    //   4	16	79	finally
    //   18	43	79	finally
    //   63	74	79	finally
    //   4	16	86	java/io/FileNotFoundException
    //   18	43	86	java/io/FileNotFoundException
  }
  
  @SuppressLint({"SetWorldReadable"})
  public boolean makeWorldReadable()
  {
    if (!SELinuxHelper.getAppDataFileService().hasDirectFileAccess()) {}
    while (!this.mFile.exists()) {
      return false;
    }
    return this.mFile.setReadable(true, false);
  }
  
  @Deprecated
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    throw new UnsupportedOperationException("listeners are not supported in this implementation");
  }
  
  public void reload()
  {
    try
    {
      if (hasFileChanged()) {
        startLoadFromDisk();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    throw new UnsupportedOperationException("listeners are not supported in this implementation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XSharedPreferences
 * JD-Core Version:    0.7.0.1
 */