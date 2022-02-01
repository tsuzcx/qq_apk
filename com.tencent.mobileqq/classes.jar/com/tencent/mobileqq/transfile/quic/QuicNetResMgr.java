package com.tencent.mobileqq.transfile.quic;

import android.text.TextUtils;
import aqbq;
import bfyz;
import bjkf;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.quic.open.QuicDownloader;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import npo;

public class QuicNetResMgr
  implements INetEngine.INetEngineListener
{
  public static final String ANDROMEDA_NAME = "libandromeda.so";
  public static final String KEY_QUIC_NET_MD5 = "key_quic_net_md5";
  public static final String QUIC_LIB_NAME = "libquic_engine.so";
  public static final int RES_ERROR_INVALID_CONFIG_MD5 = 103;
  public static final int RES_ERROR_INVALID_PATH = 101;
  public static final int RES_ERROR_MD5_VERIFY_FAILED = 104;
  public static final int RES_ERROR_RES_NOTFOUND = 102;
  public static final int RES_SUCCESS = 100;
  public static final String TAG = "QuicNetResMgr";
  private boolean mIsDownloading;
  
  public static String getAndromedaSoPath()
  {
    return getQuicSoSavePath() + "libandromeda.so";
  }
  
  public static final QuicNetResMgr getInstance()
  {
    return QuicNetResMgr.QuicNetResMgrHolder.access$000();
  }
  
  public static String getQuicEngineSoPath()
  {
    return getQuicSoSavePath() + "libquic_engine.so";
  }
  
  public static String getQuicSoSavePath()
  {
    try
    {
      Object localObject = new File(BaseApplicationImpl.getApplication().getFilesDir(), "/quic_net_res");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = ((File)localObject).getAbsolutePath() + File.separator;
      return localObject;
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.e("QuicNetResMgr", 1, "npe:", localNullPointerException);
    }
    return "/quic_net_res";
  }
  
  public static String getSdcardQuicResPath()
  {
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.SDCARD_PATH);
    localStringBuilder.append("quic_net");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("res");
    localStringBuilder.append(File.separator);
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  protected boolean checkNeedDownload(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    String str = (String)bfyz.a("key_quic_net_md5", "");
    if (!str.equals(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QuicNetResMgr", 2, new Object[] { "needDownload:", Boolean.valueOf(bool), " ,curr:", str, " ,new:", paramString });
      }
      return bool;
    }
  }
  
  protected void clearDownloadTempFile(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
    }
  }
  
  /* Error */
  public void downloadQuicRes(aqbq paramaqbq)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +13 -> 16
    //   6: aload_1
    //   7: getfield 173	aqbq:a	Ljava/lang/String;
    //   10: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +14 -> 27
    //   16: ldc 30
    //   18: iconst_1
    //   19: ldc 175
    //   21: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_1
    //   28: invokevirtual 180	aqbq:a	()Z
    //   31: ifeq -7 -> 24
    //   34: aload_0
    //   35: aload_1
    //   36: getfield 183	aqbq:b	Ljava/lang/String;
    //   39: invokevirtual 185	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:checkNeedDownload	(Ljava/lang/String;)Z
    //   42: ifne +21 -> 63
    //   45: invokestatic 187	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:getAndromedaSoPath	()Ljava/lang/String;
    //   48: invokestatic 192	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   51: ifeq +12 -> 63
    //   54: invokestatic 194	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:getQuicEngineSoPath	()Ljava/lang/String;
    //   57: invokestatic 192	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   60: ifne -36 -> 24
    //   63: aload_0
    //   64: getfield 196	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:mIsDownloading	Z
    //   67: ifne -43 -> 24
    //   70: aload_0
    //   71: iconst_1
    //   72: putfield 196	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:mIsDownloading	Z
    //   75: aload_1
    //   76: getfield 173	aqbq:a	Ljava/lang/String;
    //   79: aload_1
    //   80: getfield 173	aqbq:a	Ljava/lang/String;
    //   83: ldc 198
    //   85: invokevirtual 202	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   88: iconst_1
    //   89: iadd
    //   90: invokevirtual 206	java/lang/String:substring	(I)Ljava/lang/String;
    //   93: astore_3
    //   94: new 208	com/tencent/mobileqq/transfile/HttpNetReq
    //   97: dup
    //   98: invokespecial 209	com/tencent/mobileqq/transfile/HttpNetReq:<init>	()V
    //   101: astore_2
    //   102: aload_2
    //   103: aload_0
    //   104: putfield 213	com/tencent/mobileqq/transfile/HttpNetReq:mCallback	Lcom/tencent/mobileqq/transfile/INetEngine$INetEngineListener;
    //   107: aload_2
    //   108: aload_1
    //   109: getfield 173	aqbq:a	Ljava/lang/String;
    //   112: putfield 216	com/tencent/mobileqq/transfile/HttpNetReq:mReqUrl	Ljava/lang/String;
    //   115: aload_2
    //   116: iconst_0
    //   117: putfield 219	com/tencent/mobileqq/transfile/HttpNetReq:mHttpMethod	I
    //   120: aload_2
    //   121: new 41	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   128: invokestatic 221	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:getSdcardQuicResPath	()Ljava/lang/String;
    //   131: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_3
    //   135: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: putfield 224	com/tencent/mobileqq/transfile/HttpNetReq:mOutPath	Ljava/lang/String;
    //   144: aload_2
    //   145: invokestatic 229	com/tencent/mobileqq/transfile/NetworkCenter:getInstance	()Lcom/tencent/mobileqq/transfile/NetworkCenter;
    //   148: invokevirtual 233	com/tencent/mobileqq/transfile/NetworkCenter:getNetType	()I
    //   151: invokestatic 239	com/tencent/mobileqq/utils/NetworkUtil:getConnRetryTimes	(I)I
    //   154: putfield 242	com/tencent/mobileqq/transfile/HttpNetReq:mContinuErrorLimit	I
    //   157: aload_2
    //   158: aload_1
    //   159: invokevirtual 246	com/tencent/mobileqq/transfile/HttpNetReq:setUserData	(Ljava/lang/Object;)V
    //   162: invokestatic 70	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   165: invokevirtual 250	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   168: astore_1
    //   169: ldc 252
    //   171: aload_1
    //   172: invokevirtual 257	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   175: ifeq -151 -> 24
    //   178: aload_1
    //   179: checkcast 252	com/tencent/mobileqq/app/QQAppInterface
    //   182: iconst_0
    //   183: invokevirtual 261	com/tencent/mobileqq/app/QQAppInterface:getNetEngine	(I)Lcom/tencent/mobileqq/transfile/INetEngine;
    //   186: aload_2
    //   187: invokeinterface 267 2 0
    //   192: goto -168 -> 24
    //   195: astore_1
    //   196: ldc 30
    //   198: iconst_1
    //   199: aload_1
    //   200: iconst_0
    //   201: anewarray 4	java/lang/Object
    //   204: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   207: aload_0
    //   208: iconst_0
    //   209: putfield 196	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:mIsDownloading	Z
    //   212: goto -188 -> 24
    //   215: astore_1
    //   216: aload_0
    //   217: monitorexit
    //   218: aload_1
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	QuicNetResMgr
    //   0	220	1	paramaqbq	aqbq
    //   101	86	2	localHttpNetReq	com.tencent.mobileqq.transfile.HttpNetReq
    //   93	42	3	str	String
    // Exception table:
    //   from	to	target	type
    //   162	192	195	java/lang/Exception
    //   6	16	215	finally
    //   16	24	215	finally
    //   27	63	215	finally
    //   63	162	215	finally
    //   162	192	215	finally
    //   196	212	215	finally
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = paramNetResp.mReq;
    String str = ((NetReq)localObject).mOutPath;
    localObject = (aqbq)((NetReq)localObject).getUserData();
    if (localObject == null)
    {
      QLog.e("QuicNetResMgr", 1, "DownloadResItem is null!");
      return;
    }
    long l = System.currentTimeMillis();
    int i;
    if (paramNetResp.mResult == 0)
    {
      i = verifyResMD5(str, ((aqbq)localObject).b);
      if (i != 100) {
        break label186;
      }
      if (unzipFile(str, getQuicSoSavePath()))
      {
        saveQuicResMD5(((aqbq)localObject).b);
        QuicDownloader.loadSoSupport();
        if (QLog.isColorLevel()) {
          QLog.d("QuicNetResMgr", 2, "quic unzipFile success.init so: " + QuicDownloader.initError());
        }
      }
    }
    for (;;)
    {
      clearDownloadTempFile(str);
      this.mIsDownloading = false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QuicNetResMgr", 2, new Object[] { "onResp:", Integer.valueOf(paramNetResp.mResult), " ,cost:", Long.valueOf(System.currentTimeMillis() - l) });
      return;
      label186:
      QLog.e("QuicNetResMgr", 1, new Object[] { "verifyResMD5 failed! ", Integer.valueOf(i) });
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  protected void saveQuicResMD5(String paramString)
  {
    bfyz.b("key_quic_net_md5", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QuicNetResMgr", 2, new Object[] { "saveResItem md5:", paramString });
    }
  }
  
  protected boolean unzipFile(String paramString1, String paramString2)
  {
    try
    {
      npo.a(new File(paramString1), paramString2);
      return true;
    }
    catch (IOException paramString1)
    {
      QLog.e("QuicNetResMgr", 1, "unzipFile error ", paramString1);
    }
    return false;
  }
  
  protected int verifyResMD5(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return 101;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return 103;
    }
    File localFile = new File(paramString1);
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("QuicNetResMgr", 2, "verifyResMD5 file not exist!");
      }
      return 102;
    }
    StringBuilder localStringBuilder = null;
    try
    {
      paramString1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString1));
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("verifyResMD5 configMd5:").append(paramString2).append(", calMd5:").append(paramString1);
        QLog.d("QuicNetResMgr", 2, localStringBuilder.toString());
      }
      if (paramString2.equalsIgnoreCase(paramString1)) {
        return 100;
      }
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      for (;;)
      {
        try
        {
          paramString1 = bjkf.a(localFile);
        }
        catch (Exception paramString1)
        {
          paramString1 = localStringBuilder;
        }
        return 104;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.QuicNetResMgr
 * JD-Core Version:    0.7.0.1
 */