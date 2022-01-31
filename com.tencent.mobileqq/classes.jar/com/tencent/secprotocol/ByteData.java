package com.tencent.secprotocol;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.secprotocol.utils.ByteCodeCrashProtector;
import com.tencent.secprotocol.utils.QPDirUtils;
import com.tencent.secprotocol.utils.QPMiscUtils;
import com.tencent.secprotocol.utils.VerifyFileUtil;
import java.io.File;

public class ByteData
{
  private static final String CRASH_GETBYE_POXY = "getbyte_key";
  private static final String CRASH_LOADER_POXY = "loader_key";
  private static final String CRASH_PROTECTOR_SP = "PoxyCrashProtectSp";
  private static final String CRASH_PUTBYE_POXY = "putbyte_key";
  private static final int MSG_DATA_UPING = 161;
  private static final int MSG_DATA_WRITE_SP = 162;
  private static final long POXY_CRASH_TIME_INTERVAL = 86400000L;
  private static final Object getBytelock = new Object();
  private static final Object putBytelock = new Object();
  private static final Object writeTimelock = new Object();
  private String SP_MARK_TIME = "mark_time_";
  private String TIME_STAMP_NAME = "byte_data_time_stamp";
  private HandlerThread handlerThread = null;
  private boolean isPrint = false;
  private Context mContext = null;
  private Handler mDataHandler = null;
  private boolean mPoxyInit = false;
  private boolean mPoxyNativeLoaded = false;
  private SharedPreferences mSp;
  private String mThradName = "ByteThread";
  private long mUin = 0L;
  private byte[] status = { 0, 0, 0, 0 };
  
  private ByteData()
  {
    try
    {
      this.handlerThread = new HandlerThread(this.mThradName);
      this.handlerThread.start();
      this.mDataHandler = new ByteData.QdataHandler(this, this.handlerThread.getLooper());
      return;
    }
    catch (Exception localException)
    {
      this.status[1] = 2;
      localException.printStackTrace();
    }
  }
  
  private native byte[] getByte(Context paramContext, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4);
  
  private Context getContext()
  {
    return this.mContext;
  }
  
  public static ByteData getInstance()
  {
    return ByteData.ByteDataHolder.access$500();
  }
  
  private void initLoadlibrary()
  {
    if (this.mPoxyInit) {
      return;
    }
    new ByteCodeCrashProtector(this.mContext, this.mSp, "loader_key", 86400000L).runProtectedMethod(new ByteData.1(this));
  }
  
  private boolean loadUpgradedLibrary()
  {
    if ((this.mPoxyNativeLoaded) && (this.mPoxyInit)) {
      return true;
    }
    String str = QPDirUtils.getQQProtectQSecLibsDir(getContext()) + File.separator + "libpoxy.so";
    File localFile = new File(str);
    if ((localFile.exists()) && (VerifyFileUtil.verifySoFile(localFile, null))) {
      try
      {
        System.load(str);
        return true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
    return false;
  }
  
  private native int putByte(Context paramContext, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4);
  
  /* Error */
  private void putDwoning(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 84	com/tencent/secprotocol/ByteData:mPoxyNativeLoaded	Z
    //   6: ifeq +16 -> 22
    //   9: aload_0
    //   10: getfield 86	com/tencent/secprotocol/ByteData:mPoxyInit	Z
    //   13: istore_2
    //   14: iload_2
    //   15: ifeq +7 -> 22
    //   18: aload_1
    //   19: ifnonnull +6 -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: getstatic 59	com/tencent/secprotocol/ByteData:putBytelock	Ljava/lang/Object;
    //   28: astore_3
    //   29: aload_3
    //   30: monitorenter
    //   31: new 163	com/tencent/secprotocol/utils/ByteCodeCrashProtector
    //   34: dup
    //   35: aload_0
    //   36: getfield 72	com/tencent/secprotocol/ByteData:mContext	Landroid/content/Context;
    //   39: aload_0
    //   40: getfield 165	com/tencent/secprotocol/ByteData:mSp	Landroid/content/SharedPreferences;
    //   43: ldc 17
    //   45: ldc2_w 25
    //   48: invokespecial 168	com/tencent/secprotocol/utils/ByteCodeCrashProtector:<init>	(Landroid/content/Context;Landroid/content/SharedPreferences;Ljava/lang/String;J)V
    //   51: new 223	com/tencent/secprotocol/ByteData$2
    //   54: dup
    //   55: aload_0
    //   56: aload_1
    //   57: invokespecial 225	com/tencent/secprotocol/ByteData$2:<init>	(Lcom/tencent/secprotocol/ByteData;Ljava/lang/Object;)V
    //   60: invokevirtual 177	com/tencent/secprotocol/utils/ByteCodeCrashProtector:runProtectedMethod	(Lcom/tencent/secprotocol/utils/ByteCodeCrashProtector$IProtectedMethod;)V
    //   63: aload_3
    //   64: monitorexit
    //   65: goto -43 -> 22
    //   68: astore_1
    //   69: aload_3
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    //   73: astore_1
    //   74: aload_1
    //   75: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   78: goto -56 -> 22
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	ByteData
    //   0	86	1	paramObject	Object
    //   13	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   31	65	68	finally
    //   69	71	68	finally
    //   25	31	73	java/lang/Exception
    //   71	73	73	java/lang/Exception
    //   2	14	81	finally
    //   25	31	81	finally
    //   71	73	81	finally
    //   74	78	81	finally
  }
  
  private void setContext(Context paramContext)
  {
    if ((paramContext instanceof Context)) {
      this.mContext = paramContext;
    }
  }
  
  private void writeSp(long paramLong)
  {
    for (;;)
    {
      try
      {
        if (this.mPoxyNativeLoaded)
        {
          boolean bool = this.mPoxyInit;
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        localException.printStackTrace();
        continue;
      }
      finally {}
      return;
      localObject1 = QPMiscUtils.md5sum(String.valueOf(this.mUin));
      localObject1 = this.mContext.getSharedPreferences(this.SP_MARK_TIME + (String)localObject1, 0).edit();
      ((SharedPreferences.Editor)localObject1).putLong(this.TIME_STAMP_NAME, paramLong);
      ((SharedPreferences.Editor)localObject1).commit();
    }
  }
  
  boolean checkObject(Object paramObject)
  {
    return (!(paramObject instanceof byte[])) || (paramObject == null) || (((byte[])paramObject).length <= 0);
  }
  
  /* Error */
  public byte[] getCode(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 91	com/tencent/secprotocol/ByteData:status	[B
    //   6: iconst_1
    //   7: baload
    //   8: ifne +26 -> 34
    //   11: aload_0
    //   12: aload 12
    //   14: invokevirtual 267	com/tencent/secprotocol/ByteData:checkObject	(Ljava/lang/Object;)Z
    //   17: ifne +17 -> 34
    //   20: aload_0
    //   21: getfield 84	com/tencent/secprotocol/ByteData:mPoxyNativeLoaded	Z
    //   24: ifeq +10 -> 34
    //   27: aload_0
    //   28: getfield 86	com/tencent/secprotocol/ByteData:mPoxyInit	Z
    //   31: ifne +14 -> 45
    //   34: aload_0
    //   35: getfield 91	com/tencent/secprotocol/ByteData:status	[B
    //   38: astore 9
    //   40: aload_0
    //   41: monitorexit
    //   42: aload 9
    //   44: areturn
    //   45: aload_0
    //   46: lload_3
    //   47: putfield 74	com/tencent/secprotocol/ByteData:mUin	J
    //   50: iconst_1
    //   51: anewarray 263	[B
    //   54: astore 13
    //   56: getstatic 57	com/tencent/secprotocol/ByteData:getBytelock	Ljava/lang/Object;
    //   59: astore 14
    //   61: aload 14
    //   63: monitorenter
    //   64: new 163	com/tencent/secprotocol/utils/ByteCodeCrashProtector
    //   67: dup
    //   68: aload_0
    //   69: getfield 72	com/tencent/secprotocol/ByteData:mContext	Landroid/content/Context;
    //   72: aload_0
    //   73: getfield 165	com/tencent/secprotocol/ByteData:mSp	Landroid/content/SharedPreferences;
    //   76: ldc 8
    //   78: ldc2_w 25
    //   81: invokespecial 168	com/tencent/secprotocol/utils/ByteCodeCrashProtector:<init>	(Landroid/content/Context;Landroid/content/SharedPreferences;Ljava/lang/String;J)V
    //   84: new 269	com/tencent/secprotocol/ByteData$3
    //   87: dup
    //   88: aload_0
    //   89: aload 13
    //   91: lload_1
    //   92: lload_3
    //   93: lload 5
    //   95: lload 7
    //   97: aload 9
    //   99: aload 10
    //   101: aload 11
    //   103: aload 12
    //   105: invokespecial 272	com/tencent/secprotocol/ByteData$3:<init>	(Lcom/tencent/secprotocol/ByteData;[[BJJJJLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   108: invokevirtual 177	com/tencent/secprotocol/utils/ByteCodeCrashProtector:runProtectedMethod	(Lcom/tencent/secprotocol/utils/ByteCodeCrashProtector$IProtectedMethod;)V
    //   111: aload 13
    //   113: iconst_0
    //   114: aaload
    //   115: astore 9
    //   117: aload 14
    //   119: monitorexit
    //   120: goto -80 -> 40
    //   123: astore 9
    //   125: aload 14
    //   127: monitorexit
    //   128: aload 9
    //   130: athrow
    //   131: astore 9
    //   133: aload 9
    //   135: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   138: aload 13
    //   140: iconst_0
    //   141: iconst_4
    //   142: newarray byte
    //   144: aastore
    //   145: aload 13
    //   147: iconst_0
    //   148: aaload
    //   149: iconst_3
    //   150: iconst_1
    //   151: bastore
    //   152: aload 13
    //   154: iconst_0
    //   155: aaload
    //   156: astore 9
    //   158: goto -118 -> 40
    //   161: astore 9
    //   163: aload_0
    //   164: monitorexit
    //   165: aload 9
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	ByteData
    //   0	168	1	paramLong1	long
    //   0	168	3	paramLong2	long
    //   0	168	5	paramLong3	long
    //   0	168	7	paramLong4	long
    //   0	168	9	paramObject1	Object
    //   0	168	10	paramObject2	Object
    //   0	168	11	paramObject3	Object
    //   0	168	12	paramObject4	Object
    //   54	99	13	arrayOfByte	byte[][]
    // Exception table:
    //   from	to	target	type
    //   64	111	123	finally
    //   117	120	123	finally
    //   125	128	123	finally
    //   56	64	131	java/lang/Exception
    //   128	131	131	java/lang/Exception
    //   2	34	161	finally
    //   34	40	161	finally
    //   45	56	161	finally
    //   56	64	161	finally
    //   128	131	161	finally
    //   133	145	161	finally
  }
  
  public byte[] getStatus()
  {
    return this.status;
  }
  
  /* Error */
  public void init(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 277	com/tencent/secprotocol/ByteData:getInstance	()Lcom/tencent/secprotocol/ByteData;
    //   6: invokespecial 184	com/tencent/secprotocol/ByteData:getContext	()Landroid/content/Context;
    //   9: if_acmpeq +14 -> 23
    //   12: aload_0
    //   13: getfield 86	com/tencent/secprotocol/ByteData:mPoxyInit	Z
    //   16: ifne +7 -> 23
    //   19: aload_1
    //   20: ifnonnull +16 -> 36
    //   23: aload_0
    //   24: ldc_w 279
    //   27: ldc_w 281
    //   30: invokevirtual 285	com/tencent/secprotocol/ByteData:logCat	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: invokestatic 277	com/tencent/secprotocol/ByteData:getInstance	()Lcom/tencent/secprotocol/ByteData;
    //   39: aload_1
    //   40: invokespecial 287	com/tencent/secprotocol/ByteData:setContext	(Landroid/content/Context;)V
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 72	com/tencent/secprotocol/ByteData:mContext	Landroid/content/Context;
    //   48: new 181	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   55: ldc_w 289
    //   58: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_0
    //   62: getfield 72	com/tencent/secprotocol/ByteData:mContext	Landroid/content/Context;
    //   65: invokestatic 292	com/tencent/secprotocol/utils/QPMiscUtils:getProcessName	(Landroid/content/Context;)Ljava/lang/String;
    //   68: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: iconst_0
    //   75: invokevirtual 245	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   78: putfield 165	com/tencent/secprotocol/ByteData:mSp	Landroid/content/SharedPreferences;
    //   81: aload_0
    //   82: invokespecial 294	com/tencent/secprotocol/ByteData:initLoadlibrary	()V
    //   85: goto -52 -> 33
    //   88: astore_1
    //   89: aload_1
    //   90: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   93: goto -60 -> 33
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	ByteData
    //   0	101	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   36	85	88	java/lang/Exception
    //   2	19	96	finally
    //   23	33	96	finally
    //   36	85	96	finally
    //   89	93	96	finally
  }
  
  public void logCat(String paramString1, String paramString2)
  {
    if (this.isPrint) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public void putUping(int paramInt, Object paramObject)
  {
    if (paramInt == 1) {}
    try
    {
      localMessage = this.mDataHandler.obtainMessage(161);
      localMessage.obj = paramObject;
      logCat("ByteData", "poxy_java: putUping" + paramInt + " cabk report log " + paramObject);
      this.mDataHandler.sendMessage(localMessage);
      return;
    }
    catch (Exception paramObject)
    {
      Message localMessage;
      paramObject.printStackTrace();
    }
    if (paramInt == 2)
    {
      localMessage = this.mDataHandler.obtainMessage(162);
      localMessage.obj = paramObject;
      logCat("ByteData", "poxy_java: putUping" + paramInt + " Time: " + paramObject);
      this.mDataHandler.sendMessage(localMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData
 * JD-Core Version:    0.7.0.1
 */