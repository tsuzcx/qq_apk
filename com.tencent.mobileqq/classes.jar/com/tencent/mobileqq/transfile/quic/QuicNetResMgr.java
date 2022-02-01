package com.tencent.mobileqq.transfile.quic;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.config.business.QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.quic.internal.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.IOException;

public class QuicNetResMgr
  implements INetEngineListener
{
  public static final String KEY_QUIC_NET_MD5 = "key_quic_net_md5";
  public static final int RES_ERROR_INVALID_CONFIG_MD5 = 103;
  public static final int RES_ERROR_INVALID_PATH = 101;
  public static final int RES_ERROR_MD5_VERIFY_FAILED = 104;
  public static final int RES_ERROR_RES_NOTFOUND = 102;
  public static final int RES_SUCCESS = 100;
  public static final String TAG = "QuicNetResMgr";
  private boolean mIsDownloading = false;
  
  public static String getAndromedaSoTempPath()
  {
    return getQuicSoSaveTempPath() + "libandromeda.so";
  }
  
  public static final QuicNetResMgr getInstance()
  {
    return QuicNetResMgr.QuicNetResMgrHolder.access$000();
  }
  
  public static String getQuicEngineSoTempPath()
  {
    return getQuicSoSaveTempPath() + "libquic_engine.so";
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
  
  private void moveSoPath()
  {
    if (FileUtils.a(getAndromedaSoTempPath()))
    {
      FileUtils.b(getAndromedaSoTempPath(), Utils.getAndromedaSoPath());
      QLog.d("quic", 4, "move andromeda temp file to load path.");
    }
    if (FileUtils.a(getQuicEngineSoTempPath()))
    {
      FileUtils.b(getQuicEngineSoTempPath(), Utils.getQuicEngineSoPath());
      QLog.d("quic", 4, "move quic engine temp file to load path.");
    }
  }
  
  protected boolean checkNeedDownload(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    String str = (String)SharedPreUtils.a("key_quic_net_md5", "");
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
  public void downloadQuicRes(QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean paramShortVideoQuicNetConfBean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +13 -> 16
    //   6: aload_1
    //   7: getfield 203	com/tencent/mobileqq/config/business/QQShortVideoQuicNetProcessor$ShortVideoQuicNetConfBean:a	Ljava/lang/String;
    //   10: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +14 -> 27
    //   16: ldc 24
    //   18: iconst_1
    //   19: ldc 205
    //   21: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_1
    //   28: invokevirtual 209	com/tencent/mobileqq/config/business/QQShortVideoQuicNetProcessor$ShortVideoQuicNetConfBean:a	()Z
    //   31: ifeq -7 -> 24
    //   34: aload_0
    //   35: aload_1
    //   36: getfield 211	com/tencent/mobileqq/config/business/QQShortVideoQuicNetProcessor$ShortVideoQuicNetConfBean:b	Ljava/lang/String;
    //   39: invokevirtual 213	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:checkNeedDownload	(Ljava/lang/String;)Z
    //   42: ifne +10 -> 52
    //   45: aload_0
    //   46: invokevirtual 216	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:quicSoFileExist	()Z
    //   49: ifne -25 -> 24
    //   52: aload_0
    //   53: getfield 32	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:mIsDownloading	Z
    //   56: ifne -32 -> 24
    //   59: aload_0
    //   60: iconst_1
    //   61: putfield 32	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:mIsDownloading	Z
    //   64: aload_1
    //   65: getfield 203	com/tencent/mobileqq/config/business/QQShortVideoQuicNetProcessor$ShortVideoQuicNetConfBean:a	Ljava/lang/String;
    //   68: aload_1
    //   69: getfield 203	com/tencent/mobileqq/config/business/QQShortVideoQuicNetProcessor$ShortVideoQuicNetConfBean:a	Ljava/lang/String;
    //   72: ldc 218
    //   74: invokevirtual 222	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   77: iconst_1
    //   78: iadd
    //   79: invokevirtual 226	java/lang/String:substring	(I)Ljava/lang/String;
    //   82: astore_3
    //   83: new 228	com/tencent/mobileqq/transfile/HttpNetReq
    //   86: dup
    //   87: invokespecial 229	com/tencent/mobileqq/transfile/HttpNetReq:<init>	()V
    //   90: astore_2
    //   91: aload_2
    //   92: aload_0
    //   93: putfield 233	com/tencent/mobileqq/transfile/HttpNetReq:mCallback	Lcom/tencent/mobileqq/transfile/INetEngineListener;
    //   96: aload_2
    //   97: aload_1
    //   98: getfield 203	com/tencent/mobileqq/config/business/QQShortVideoQuicNetProcessor$ShortVideoQuicNetConfBean:a	Ljava/lang/String;
    //   101: putfield 236	com/tencent/mobileqq/transfile/HttpNetReq:mReqUrl	Ljava/lang/String;
    //   104: aload_2
    //   105: iconst_0
    //   106: putfield 239	com/tencent/mobileqq/transfile/HttpNetReq:mHttpMethod	I
    //   109: aload_2
    //   110: new 37	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   117: invokestatic 241	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:getSdcardQuicResPath	()Ljava/lang/String;
    //   120: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_3
    //   124: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: putfield 244	com/tencent/mobileqq/transfile/HttpNetReq:mOutPath	Ljava/lang/String;
    //   133: aload_2
    //   134: invokestatic 249	com/tencent/mobileqq/transfile/NetworkCenter:getInstance	()Lcom/tencent/mobileqq/transfile/NetworkCenter;
    //   137: invokevirtual 253	com/tencent/mobileqq/transfile/NetworkCenter:getNetType	()I
    //   140: invokestatic 258	com/tencent/mobileqq/utils/NetworkUtil:a	(I)I
    //   143: putfield 261	com/tencent/mobileqq/transfile/HttpNetReq:mContinuErrorLimit	I
    //   146: aload_2
    //   147: aload_1
    //   148: invokevirtual 265	com/tencent/mobileqq/transfile/HttpNetReq:setUserData	(Ljava/lang/Object;)V
    //   151: invokestatic 70	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   154: invokevirtual 269	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   157: astore_1
    //   158: ldc_w 271
    //   161: aload_1
    //   162: invokevirtual 276	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   165: ifeq -141 -> 24
    //   168: aload_1
    //   169: checkcast 271	com/tencent/mobileqq/app/QQAppInterface
    //   172: ldc_w 278
    //   175: ldc_w 280
    //   178: invokevirtual 284	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   181: checkcast 278	com/tencent/mobileqq/transfile/api/IHttpEngineService
    //   184: aload_2
    //   185: invokeinterface 288 2 0
    //   190: goto -166 -> 24
    //   193: astore_1
    //   194: ldc 24
    //   196: iconst_1
    //   197: aload_1
    //   198: iconst_0
    //   199: anewarray 4	java/lang/Object
    //   202: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   205: aload_0
    //   206: iconst_0
    //   207: putfield 32	com/tencent/mobileqq/transfile/quic/QuicNetResMgr:mIsDownloading	Z
    //   210: goto -186 -> 24
    //   213: astore_1
    //   214: aload_0
    //   215: monitorexit
    //   216: aload_1
    //   217: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	QuicNetResMgr
    //   0	218	1	paramShortVideoQuicNetConfBean	QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean
    //   90	95	2	localHttpNetReq	com.tencent.mobileqq.transfile.HttpNetReq
    //   82	42	3	str	String
    // Exception table:
    //   from	to	target	type
    //   151	190	193	java/lang/Exception
    //   6	16	213	finally
    //   16	24	213	finally
    //   27	52	213	finally
    //   52	151	213	finally
    //   151	190	213	finally
    //   194	210	213	finally
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = paramNetResp.mReq;
    String str = ((NetReq)localObject).mOutPath;
    localObject = (QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean)((NetReq)localObject).getUserData();
    if (localObject == null)
    {
      QLog.e("QuicNetResMgr", 1, "DownloadResItem is null!");
      return;
    }
    long l = System.currentTimeMillis();
    int i;
    if (paramNetResp.mResult == 0)
    {
      i = verifyResMD5(str, ((QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean)localObject).b);
      if (i != 100) {
        break label153;
      }
      if (unzipFile(str, getQuicSoSaveTempPath()))
      {
        saveQuicResMD5(((QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean)localObject).b);
        moveSoPath();
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
      label153:
      QLog.e("QuicNetResMgr", 1, new Object[] { "verifyResMD5 failed! ", Integer.valueOf(i) });
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public boolean quicSoFileExist()
  {
    return ((FileUtils.a(Utils.getAndromedaSoPath())) && (FileUtils.a(Utils.getQuicEngineSoPath()))) || ((FileUtils.a(getAndromedaSoTempPath())) && (FileUtils.a(getQuicEngineSoTempPath())));
  }
  
  protected void saveQuicResMD5(String paramString)
  {
    SharedPreUtils.b("key_quic_net_md5", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QuicNetResMgr", 2, new Object[] { "saveResItem md5:", paramString });
    }
  }
  
  protected boolean unzipFile(String paramString1, String paramString2)
  {
    try
    {
      ZipUtils.unZipFile(new File(paramString1), paramString2);
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
          paramString1 = MD5FileUtil.a(localFile);
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