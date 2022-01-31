package com.tencent.mobileqq.msf.core.quic;

import android.content.SharedPreferences;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.StringUtils;

public class QuicWrapper
{
  private static String DEFAULT_QUIC_FLL_PATH;
  private static final int QLOG_ERROR = 2;
  private static final int QLOG_FATAL = 3;
  private static final int QLOG_INFO = 0;
  private static final int QLOG_VERBOSE = -1;
  private static final int QLOG_WARNING = 1;
  private static final String QUIC_RES_CONFIG_SP = "quic_res_config";
  private static final String QUIC_RES_LOAD_PATH = "quic_res_load_path";
  private static final String QUIC_RES_QUIC_LIB = "libquic.so";
  private static final String QUIC_RES_SATURN_LIB = "libsaturn.so";
  private static final String QUIC_RES_VERSION = "quic_res_version";
  private static final String QUIC_SO_LIB_PATH = "/app_lib/quic/";
  public static boolean isLoaded = false;
  private static final String tag = "QuicWrapper";
  
  public static native void closeConn(long paramLong);
  
  public static native int connect(long paramLong, String paramString, int paramInt1, int paramInt2);
  
  public static synchronized native long createQuicContext(b paramb);
  
  public static native long createSyncClient(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  public static String getQuicResLoadPath()
  {
    return BaseApplication.getContext().getSharedPreferences("quic_res_config", 4).getString("quic_res_load_path", DEFAULT_QUIC_FLL_PATH);
  }
  
  public static int getQuicResVersion()
  {
    return BaseApplication.getContext().getSharedPreferences("quic_res_config", 4).getInt("quic_res_version", 0);
  }
  
  public static synchronized native boolean initialize(long paramLong);
  
  public static native QuicBundle recv(long paramLong, int paramInt1, int paramInt2);
  
  public static synchronized native void releaseQuicContext(long paramLong);
  
  public static native void releaseSyncClient(long paramLong1, long paramLong2);
  
  public static boolean reload()
  {
    if (!isLoaded)
    {
      DEFAULT_QUIC_FLL_PATH = Environment.getDataDirectory() + "/data/" + BaseApplication.getContext().getPackageName() + "/app_lib/quic/";
      String str2 = getQuicResLoadPath();
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = DEFAULT_QUIC_FLL_PATH;
      }
      long l = SystemClock.elapsedRealtime();
      boolean bool = StringUtils.loadLibrary("QuicWrapper", BaseApplication.getContext(), str1 + "libsaturn.so", null);
      isLoaded = StringUtils.loadLibrary("QuicWrapper", BaseApplication.getContext(), str1 + "libquic.so", null);
      QLog.i("QuicWrapper", 1, "load quic library " + str1 + " loadSaturn=" + bool + " loadQuic=" + isLoaded + " cost=" + (SystemClock.elapsedRealtime() - l));
      if (isLoaded) {
        setLogLevel(0, false);
      }
    }
    return isLoaded;
  }
  
  public static native int send(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static synchronized native void setLogLevel(int paramInt, boolean paramBoolean);
  
  public static class QuicBundle
  {
    public byte[] data;
    public int data_len;
    public int retcode;
    
    public QuicBundle(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
    {
      this.retcode = paramInt1;
      this.data = paramArrayOfByte;
      this.data_len = paramInt2;
    }
    
    public void putData(byte[] paramArrayOfByte)
    {
      this.data = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.quic.QuicWrapper
 * JD-Core Version:    0.7.0.1
 */