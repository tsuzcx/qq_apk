package com.tencent.mobileqq.transfile.quic;

import android.text.TextUtils;
import aret;
import bhhr;
import bkvq;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.quic.open.QuicDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import nwp;

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
  
  public static String getAndromedaSoTempPath()
  {
    return getQuicSoSaveTempPath() + "libandromeda.so";
  }
  
  public static final QuicNetResMgr getInstance()
  {
    return QuicNetResMgr.QuicNetResMgrHolder.access$000();
  }
  
  public static String getQuicEngineSoPath()
  {
    return getQuicSoSavePath() + "libquic_engine.so";
  }
  
  public static String getQuicEngineSoTempPath()
  {
    return getQuicSoSaveTempPath() + "libquic_engine.so";
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
  
  public static String getQuicSoSaveTempPath()
  {
    try
    {
      Object localObject = new File(BaseApplicationImpl.getApplication().getFilesDir(), "/quic_net_res/temp");
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
    return "/quic_net_res/temp";
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
    String str = (String)bhhr.a("key_quic_net_md5", "");
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
  public void downloadQuicRes(aret paramaret)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +13 -> 16
    //   6: aload_1
    //   7: getfield 180	aret:a	Ljava/lang/String;
    //   10: invokestatic 168	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +14 -> 27
    //   16: ldc 30
    //   18: iconst_1
    //   19: ldc 182
    //   21: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_1
    //   28: invokevirtual 187	aret:a	()Z
    //   31: ifeq -7 -> 24
    //   34: aload_0
    //   35: aload_1
    //   36: getfield 190	aret:b	Ljava/lang/String;
    //   39: invokevirtual 192	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:checkNeedDownload	(Ljava/lang/String;)Z
    //   42: ifne +10 -> 52
    //   45: aload_0
    //   46: invokevirtual 195	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:quicSoFileExist	()Z
    //   49: ifne -25 -> 24
    //   52: aload_0
    //   53: getfield 197	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:mIsDownloading	Z
    //   56: ifne -32 -> 24
    //   59: aload_0
    //   60: iconst_1
    //   61: putfield 197	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:mIsDownloading	Z
    //   64: aload_1
    //   65: getfield 180	aret:a	Ljava/lang/String;
    //   68: aload_1
    //   69: getfield 180	aret:a	Ljava/lang/String;
    //   72: ldc 199
    //   74: invokevirtual 203	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   77: iconst_1
    //   78: iadd
    //   79: invokevirtual 207	java/lang/String:substring	(I)Ljava/lang/String;
    //   82: astore_3
    //   83: new 209	com/tencent/mobileqq/transfile/HttpNetReq
    //   86: dup
    //   87: invokespecial 210	com/tencent/mobileqq/transfile/HttpNetReq:<init>	()V
    //   90: astore_2
    //   91: aload_2
    //   92: aload_0
    //   93: putfield 214	com/tencent/mobileqq/transfile/HttpNetReq:mCallback	Lcom/tencent/mobileqq/transfile/INetEngine$INetEngineListener;
    //   96: aload_2
    //   97: aload_1
    //   98: getfield 180	aret:a	Ljava/lang/String;
    //   101: putfield 217	com/tencent/mobileqq/transfile/HttpNetReq:mReqUrl	Ljava/lang/String;
    //   104: aload_2
    //   105: iconst_0
    //   106: putfield 220	com/tencent/mobileqq/transfile/HttpNetReq:mHttpMethod	I
    //   109: aload_2
    //   110: new 41	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   117: invokestatic 222	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:getSdcardQuicResPath	()Ljava/lang/String;
    //   120: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_3
    //   124: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: putfield 225	com/tencent/mobileqq/transfile/HttpNetReq:mOutPath	Ljava/lang/String;
    //   133: aload_2
    //   134: invokestatic 230	com/tencent/mobileqq/transfile/NetworkCenter:getInstance	()Lcom/tencent/mobileqq/transfile/NetworkCenter;
    //   137: invokevirtual 234	com/tencent/mobileqq/transfile/NetworkCenter:getNetType	()I
    //   140: invokestatic 240	com/tencent/mobileqq/utils/NetworkUtil:getConnRetryTimes	(I)I
    //   143: putfield 243	com/tencent/mobileqq/transfile/HttpNetReq:mContinuErrorLimit	I
    //   146: aload_2
    //   147: aload_1
    //   148: invokevirtual 247	com/tencent/mobileqq/transfile/HttpNetReq:setUserData	(Ljava/lang/Object;)V
    //   151: invokestatic 75	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   154: invokevirtual 251	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   157: astore_1
    //   158: ldc 253
    //   160: aload_1
    //   161: invokevirtual 258	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   164: ifeq -140 -> 24
    //   167: aload_1
    //   168: checkcast 253	com/tencent/mobileqq/app/QQAppInterface
    //   171: iconst_0
    //   172: invokevirtual 262	com/tencent/mobileqq/app/QQAppInterface:getNetEngine	(I)Lcom/tencent/mobileqq/transfile/INetEngine;
    //   175: aload_2
    //   176: invokeinterface 268 2 0
    //   181: goto -157 -> 24
    //   184: astore_1
    //   185: ldc 30
    //   187: iconst_1
    //   188: aload_1
    //   189: iconst_0
    //   190: anewarray 4	java/lang/Object
    //   193: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   196: aload_0
    //   197: iconst_0
    //   198: putfield 197	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:mIsDownloading	Z
    //   201: goto -177 -> 24
    //   204: astore_1
    //   205: aload_0
    //   206: monitorexit
    //   207: aload_1
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	QuicNetResMgr
    //   0	209	1	paramaret	aret
    //   90	86	2	localHttpNetReq	com.tencent.mobileqq.transfile.HttpNetReq
    //   82	42	3	str	String
    // Exception table:
    //   from	to	target	type
    //   151	181	184	java/lang/Exception
    //   6	16	204	finally
    //   16	24	204	finally
    //   27	52	204	finally
    //   52	151	204	finally
    //   151	181	204	finally
    //   185	201	204	finally
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = paramNetResp.mReq;
    String str = ((NetReq)localObject).mOutPath;
    localObject = (aret)((NetReq)localObject).getUserData();
    if (localObject == null)
    {
      QLog.e("QuicNetResMgr", 1, "DownloadResItem is null!");
      return;
    }
    long l = System.currentTimeMillis();
    int i;
    if (paramNetResp.mResult == 0)
    {
      i = verifyResMD5(str, ((aret)localObject).b);
      if (i != 100) {
        break label186;
      }
      if (unzipFile(str, getQuicSoSaveTempPath()))
      {
        saveQuicResMD5(((aret)localObject).b);
        QuicDownloader.tryLoadSoSupport();
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
  
  public boolean quicSoFileExist()
  {
    return ((FileUtils.fileExists(getAndromedaSoPath())) && (FileUtils.fileExists(getQuicEngineSoPath()))) || ((FileUtils.fileExists(getAndromedaSoTempPath())) && (FileUtils.fileExists(getQuicEngineSoTempPath())));
  }
  
  protected void saveQuicResMD5(String paramString)
  {
    bhhr.b("key_quic_net_md5", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QuicNetResMgr", 2, new Object[] { "saveResItem md5:", paramString });
    }
  }
  
  protected boolean unzipFile(String paramString1, String paramString2)
  {
    try
    {
      nwp.a(new File(paramString1), paramString2);
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
          paramString1 = bkvq.a(localFile);
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