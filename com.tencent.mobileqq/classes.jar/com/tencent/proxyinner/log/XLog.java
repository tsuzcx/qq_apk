package com.tencent.proxyinner.log;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

public class XLog
{
  private static final int D = 1;
  private static final int E = 4;
  private static final int I = 2;
  private static final long MAX_DISK_SPACE = 10485760L;
  private static final int V = 0;
  private static final int W = 3;
  private static final int WTF = 5;
  public static XLog sInstance = null;
  private List<String> CACHE_LIST = Collections.synchronizedList(new ArrayList());
  private final Map<Integer, String> LEVEL_MAP = new ConcurrentHashMap();
  private final SimpleDateFormat LOG_FILE_SDF = new SimpleDateFormat("yyyy_MM_dd_HH");
  private SimpleDateFormat LOG_SDF = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
  private final int MAX_CACHE_SIZE = 100;
  Boolean isWriting = Boolean.valueOf(false);
  private Event mEvent;
  private Handler mFileHandler;
  private HandlerThread mFileThread = null;
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Bundle localBundle = paramAnonymousMessage.getData();
      if (paramAnonymousMessage.what == 0)
      {
        paramAnonymousMessage = localBundle.getString("tag");
        String str = localBundle.getString("msg");
        int i = localBundle.getInt("level");
        if (XLog.this.mEvent != null) {
          XLog.this.mEvent.onLog(paramAnonymousMessage, str, i);
        }
      }
    }
  };
  private String mLogFileDir;
  private boolean mLogHost = false;
  
  private XLog()
  {
    try
    {
      this.LOG_SDF.setTimeZone(TimeZone.getDefault());
      this.LOG_FILE_SDF.setTimeZone(TimeZone.getDefault());
      this.LEVEL_MAP.put(Integer.valueOf(0), "V");
      this.LEVEL_MAP.put(Integer.valueOf(1), "D");
      this.LEVEL_MAP.put(Integer.valueOf(2), "I");
      this.LEVEL_MAP.put(Integer.valueOf(3), "W");
      this.LEVEL_MAP.put(Integer.valueOf(4), "E");
      this.LEVEL_MAP.put(Integer.valueOf(5), "WTF");
      if (!this.mLogHost)
      {
        this.mFileThread = new HandlerThread("LOG_FILE_THREAD");
        this.mFileThread.start();
        this.mFileHandler = new Handler(this.mFileThread.getLooper());
      }
      return;
    }
    finally {}
  }
  
  public static final int d(String paramString1, String paramString2)
  {
    return getInstance().Log(paramString1, paramString2, 1);
  }
  
  public static final int e(String paramString1, String paramString2)
  {
    return getInstance().Log(paramString1, paramString2, 4);
  }
  
  public static XLog getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new XLog();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static final int i(String paramString1, String paramString2)
  {
    return getInstance().Log(paramString1, paramString2, 2);
  }
  
  public static void perfLog(String paramString)
  {
    Log.i("XProxy_Perf", paramString + " Time = " + System.currentTimeMillis());
  }
  
  private void writeLogToCache(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      paramString1 = String.format("%s %s/%s: %s", new Object[] { this.LOG_SDF.format(new Date()), this.LEVEL_MAP.get(Integer.valueOf(paramInt)), paramString1, paramString2 });
      this.CACHE_LIST.add(paramString1);
      if (this.CACHE_LIST.size() >= 100) {
        postWriteTask();
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  private void writeLogToSdCard(List<String> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +14 -> 17
    //   6: aload_1
    //   7: invokeinterface 251 1 0
    //   12: istore_3
    //   13: iload_3
    //   14: ifeq +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: new 253	java/io/File
    //   23: dup
    //   24: aload_0
    //   25: getfield 255	com/tencent/proxyinner/log/XLog:mLogFileDir	Ljava/lang/String;
    //   28: invokespecial 256	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore 6
    //   33: aload 6
    //   35: invokevirtual 259	java/io/File:exists	()Z
    //   38: ifne +9 -> 47
    //   41: aload 6
    //   43: invokevirtual 262	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aload 6
    //   49: invokevirtual 259	java/io/File:exists	()Z
    //   52: ifeq -35 -> 17
    //   55: aload 6
    //   57: invokevirtual 265	java/io/File:isDirectory	()Z
    //   60: istore_3
    //   61: iload_3
    //   62: ifeq -45 -> 17
    //   65: aload_0
    //   66: iconst_1
    //   67: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   70: putfield 110	com/tencent/proxyinner/log/XLog:isWriting	Ljava/lang/Boolean;
    //   73: new 253	java/io/File
    //   76: dup
    //   77: new 186	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   84: aload_0
    //   85: getfield 255	com/tencent/proxyinner/log/XLog:mLogFileDir	Ljava/lang/String;
    //   88: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 267
    //   94: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: getfield 82	com/tencent/proxyinner/log/XLog:LOG_FILE_SDF	Ljava/text/SimpleDateFormat;
    //   101: new 216	java/util/Date
    //   104: dup
    //   105: invokespecial 217	java/util/Date:<init>	()V
    //   108: invokevirtual 221	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   111: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc_w 269
    //   117: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokespecial 256	java/io/File:<init>	(Ljava/lang/String;)V
    //   126: astore 7
    //   128: iconst_0
    //   129: istore_2
    //   130: aload 7
    //   132: invokevirtual 259	java/io/File:exists	()Z
    //   135: ifne +11 -> 146
    //   138: aload 7
    //   140: invokevirtual 272	java/io/File:createNewFile	()Z
    //   143: pop
    //   144: iconst_1
    //   145: istore_2
    //   146: aload 7
    //   148: invokevirtual 259	java/io/File:exists	()Z
    //   151: istore_3
    //   152: iload_3
    //   153: ifne +27 -> 180
    //   156: aload_0
    //   157: iconst_0
    //   158: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   161: putfield 110	com/tencent/proxyinner/log/XLog:isWriting	Ljava/lang/Boolean;
    //   164: goto -147 -> 17
    //   167: astore_1
    //   168: aload_1
    //   169: invokevirtual 275	java/lang/Exception:printStackTrace	()V
    //   172: goto -155 -> 17
    //   175: astore_1
    //   176: aload_0
    //   177: monitorexit
    //   178: aload_1
    //   179: athrow
    //   180: new 277	java/io/PrintWriter
    //   183: dup
    //   184: new 279	java/io/BufferedWriter
    //   187: dup
    //   188: new 281	java/io/FileWriter
    //   191: dup
    //   192: aload 7
    //   194: iconst_1
    //   195: invokespecial 284	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   198: sipush 8192
    //   201: invokespecial 287	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   204: iconst_1
    //   205: invokespecial 290	java/io/PrintWriter:<init>	(Ljava/io/Writer;Z)V
    //   208: astore 7
    //   210: aload_1
    //   211: invokeinterface 294 1 0
    //   216: astore_1
    //   217: aload_1
    //   218: invokeinterface 299 1 0
    //   223: ifeq +36 -> 259
    //   226: aload 7
    //   228: aload_1
    //   229: invokeinterface 303 1 0
    //   234: checkcast 227	java/lang/String
    //   237: invokevirtual 306	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   240: goto -23 -> 217
    //   243: astore_1
    //   244: aload_1
    //   245: invokevirtual 307	java/io/IOException:printStackTrace	()V
    //   248: aload_0
    //   249: iconst_0
    //   250: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   253: putfield 110	com/tencent/proxyinner/log/XLog:isWriting	Ljava/lang/Boolean;
    //   256: goto -239 -> 17
    //   259: aload 7
    //   261: invokevirtual 310	java/io/PrintWriter:close	()V
    //   264: iload_2
    //   265: ifeq +56 -> 321
    //   268: aload 6
    //   270: invokestatic 316	com/tencent/proxyinner/utility/UtilFile:getFileSize	(Ljava/io/File;)J
    //   273: lstore 4
    //   275: aload 6
    //   277: invokestatic 320	com/tencent/proxyinner/utility/UtilFile:getFileCount	(Ljava/io/File;)I
    //   280: istore_2
    //   281: lload 4
    //   283: ldc2_w 22
    //   286: lcmp
    //   287: ifle +34 -> 321
    //   290: iload_2
    //   291: iconst_1
    //   292: if_icmple +29 -> 321
    //   295: aload 6
    //   297: invokestatic 324	com/tencent/proxyinner/utility/UtilFile:getEarliestFile	(Ljava/io/File;)Ljava/io/File;
    //   300: astore_1
    //   301: aload_1
    //   302: ifnull +19 -> 321
    //   305: aload_1
    //   306: invokevirtual 259	java/io/File:exists	()Z
    //   309: ifeq +12 -> 321
    //   312: aload_1
    //   313: invokevirtual 327	java/io/File:delete	()Z
    //   316: istore_3
    //   317: iload_3
    //   318: ifne +14 -> 332
    //   321: aload_0
    //   322: iconst_0
    //   323: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   326: putfield 110	com/tencent/proxyinner/log/XLog:isWriting	Ljava/lang/Boolean;
    //   329: goto -312 -> 17
    //   332: aload 6
    //   334: invokestatic 316	com/tencent/proxyinner/utility/UtilFile:getFileSize	(Ljava/io/File;)J
    //   337: lstore 4
    //   339: aload 6
    //   341: invokestatic 320	com/tencent/proxyinner/utility/UtilFile:getFileCount	(Ljava/io/File;)I
    //   344: istore_2
    //   345: goto -64 -> 281
    //   348: astore_1
    //   349: aload_0
    //   350: iconst_0
    //   351: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   354: putfield 110	com/tencent/proxyinner/log/XLog:isWriting	Ljava/lang/Boolean;
    //   357: aload_1
    //   358: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	XLog
    //   0	359	1	paramList	List<String>
    //   129	216	2	i	int
    //   12	306	3	bool	boolean
    //   273	65	4	l	long
    //   31	309	6	localFile	java.io.File
    //   126	134	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	13	167	java/lang/Exception
    //   20	47	167	java/lang/Exception
    //   47	61	167	java/lang/Exception
    //   156	164	167	java/lang/Exception
    //   248	256	167	java/lang/Exception
    //   321	329	167	java/lang/Exception
    //   349	359	167	java/lang/Exception
    //   6	13	175	finally
    //   20	47	175	finally
    //   47	61	175	finally
    //   156	164	175	finally
    //   168	172	175	finally
    //   248	256	175	finally
    //   321	329	175	finally
    //   349	359	175	finally
    //   65	128	243	java/io/IOException
    //   130	144	243	java/io/IOException
    //   146	152	243	java/io/IOException
    //   180	217	243	java/io/IOException
    //   217	240	243	java/io/IOException
    //   259	264	243	java/io/IOException
    //   268	281	243	java/io/IOException
    //   295	301	243	java/io/IOException
    //   305	317	243	java/io/IOException
    //   332	345	243	java/io/IOException
    //   65	128	348	finally
    //   130	144	348	finally
    //   146	152	348	finally
    //   180	217	348	finally
    //   217	240	348	finally
    //   244	248	348	finally
    //   259	264	348	finally
    //   268	281	348	finally
    //   295	301	348	finally
    //   305	317	348	finally
    //   332	345	348	finally
  }
  
  public final int Log(String paramString1, String paramString2, int paramInt)
  {
    int i = 0;
    if (this.mLogHost) {
      postLogEvent(paramString1, paramString2, paramInt);
    }
    for (;;)
    {
      if (!this.mLogHost) {
        writeLogToCache(paramString1, paramString2, paramInt);
      }
      return i;
      switch (paramInt)
      {
      case 3: 
      default: 
        break;
      case 1: 
        i = Log.d(paramString1, paramString2);
        break;
      case 2: 
        i = Log.i(paramString1, paramString2);
        break;
      case 4: 
        i = Log.e(paramString1, paramString2);
      }
    }
  }
  
  public void init(Context paramContext, String paramString, boolean paramBoolean)
  {
    this.mLogFileDir = paramString;
    this.mLogHost = paramBoolean;
  }
  
  public void postLogEvent(String paramString1, String paramString2, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    Bundle localBundle = new Bundle();
    localBundle.putString("tag", paramString1);
    localBundle.putString("msg", paramString2);
    localBundle.putInt("level", paramInt);
    localMessage.setData(localBundle);
    this.mHandler.sendMessage(localMessage);
  }
  
  public void postWriteTask()
  {
    if (!this.isWriting.booleanValue())
    {
      final ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.CACHE_LIST);
      this.CACHE_LIST = Collections.synchronizedList(new ArrayList());
      this.mFileHandler.post(new Runnable()
      {
        public void run()
        {
          XLog.this.writeLogToSdCard(localArrayList);
        }
      });
    }
  }
  
  public void setEventList(Event paramEvent)
  {
    this.mEvent = paramEvent;
  }
  
  public void setLoginInHost(boolean paramBoolean)
  {
    this.mLogHost = paramBoolean;
  }
  
  public void unInit()
  {
    if (!this.mLogHost) {
      this.mFileHandler.post(new Runnable()
      {
        public void run()
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.addAll(XLog.this.CACHE_LIST);
          XLog.this.writeLogToSdCard(localArrayList);
        }
      });
    }
  }
  
  public static abstract interface Event
  {
    public abstract void onLog(String paramString1, String paramString2, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.log.XLog
 * JD-Core Version:    0.7.0.1
 */