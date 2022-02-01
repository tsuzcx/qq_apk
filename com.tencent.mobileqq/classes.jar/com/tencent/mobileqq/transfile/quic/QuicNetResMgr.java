package com.tencent.mobileqq.transfile.quic;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.quic.internal.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getQuicSoSaveTempPath());
    localStringBuilder.append("libandromeda.so");
    return localStringBuilder.toString();
  }
  
  public static final QuicNetResMgr getInstance()
  {
    return QuicNetResMgr.QuicNetResMgrHolder.access$000();
  }
  
  public static String getQuicEngineSoTempPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getQuicSoSaveTempPath());
    localStringBuilder.append("libquic_engine.so");
    return localStringBuilder.toString();
  }
  
  public static String getQuicSoSaveTempPath()
  {
    try
    {
      Object localObject = new File(BaseApplicationImpl.getApplication().getFilesDir(), "/quic_net_res/temp");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      localStringBuilder.append(File.separator);
      localObject = localStringBuilder.toString();
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
    if (FileUtils.fileExists(getAndromedaSoTempPath()))
    {
      FileUtils.moveFile(getAndromedaSoTempPath(), Utils.getAndromedaSoPath());
      QLog.d("quic", 4, "move andromeda temp file to load path.");
    }
    if (FileUtils.fileExists(getQuicEngineSoTempPath()))
    {
      FileUtils.moveFile(getQuicEngineSoTempPath(), Utils.getQuicEngineSoPath());
      QLog.d("quic", 4, "move quic engine temp file to load path.");
    }
  }
  
  protected boolean checkNeedDownload(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    String str = (String)SharedPreUtils.a("key_quic_net_md5", "");
    boolean bool = str.equals(paramString) ^ true;
    if (QLog.isColorLevel()) {
      QLog.d("QuicNetResMgr", 2, new Object[] { "needDownload:", Boolean.valueOf(bool), " ,curr:", str, " ,new:", paramString });
    }
    return bool;
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
  
  public void downloadQuicRes(QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean paramShortVideoQuicNetConfBean)
  {
    if (paramShortVideoQuicNetConfBean != null) {}
    try
    {
      if (!TextUtils.isEmpty(paramShortVideoQuicNetConfBean.a))
      {
        if ((paramShortVideoQuicNetConfBean.a()) && ((checkNeedDownload(paramShortVideoQuicNetConfBean.b)) || (!quicSoFileExist())))
        {
          boolean bool = this.mIsDownloading;
          if (bool) {
            return;
          }
          this.mIsDownloading = true;
          String str = paramShortVideoQuicNetConfBean.a.substring(paramShortVideoQuicNetConfBean.a.lastIndexOf("/") + 1);
          HttpNetReq localHttpNetReq = new HttpNetReq();
          localHttpNetReq.mCallback = this;
          localHttpNetReq.mReqUrl = paramShortVideoQuicNetConfBean.a;
          localHttpNetReq.mHttpMethod = 0;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(getSdcardQuicResPath());
          localStringBuilder.append(str);
          localHttpNetReq.mOutPath = localStringBuilder.toString();
          localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
          localHttpNetReq.setUserData(paramShortVideoQuicNetConfBean);
          try
          {
            paramShortVideoQuicNetConfBean = BaseApplicationImpl.getApplication().getRuntime();
            if (QQAppInterface.class.isInstance(paramShortVideoQuicNetConfBean)) {
              ((IHttpEngineService)((QQAppInterface)paramShortVideoQuicNetConfBean).getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
            }
          }
          catch (Exception paramShortVideoQuicNetConfBean)
          {
            QLog.e("QuicNetResMgr", 1, paramShortVideoQuicNetConfBean, new Object[0]);
            this.mIsDownloading = false;
          }
          return;
        }
        return;
      }
      QLog.e("QuicNetResMgr", 1, "bean or url is null!");
      return;
    }
    finally {}
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
    if (paramNetResp.mResult == 0)
    {
      int i = verifyResMD5(str, ((QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean)localObject).b);
      if (i == 100)
      {
        if (unzipFile(str, getQuicSoSaveTempPath()))
        {
          saveQuicResMD5(((QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean)localObject).b);
          moveSoPath();
        }
      }
      else {
        QLog.e("QuicNetResMgr", 1, new Object[] { "verifyResMD5 failed! ", Integer.valueOf(i) });
      }
    }
    clearDownloadTempFile(str);
    this.mIsDownloading = false;
    if (QLog.isColorLevel()) {
      QLog.d("QuicNetResMgr", 2, new Object[] { "onResp:", Integer.valueOf(paramNetResp.mResult), " ,cost:", Long.valueOf(System.currentTimeMillis() - l) });
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public boolean quicSoFileExist()
  {
    return ((FileUtils.fileExists(Utils.getAndromedaSoPath())) && (FileUtils.fileExists(Utils.getQuicEngineSoPath()))) || ((FileUtils.fileExists(getAndromedaSoTempPath())) && (FileUtils.fileExists(getQuicEngineSoTempPath())));
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
    localStringBuilder = null;
    try
    {
      paramString1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString1));
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      label69:
      label78:
      break label69;
    }
    try
    {
      paramString1 = MD5FileUtil.a(localFile);
    }
    catch (Exception paramString1)
    {
      paramString1 = localStringBuilder;
      break label78;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("verifyResMD5 configMd5:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", calMd5:");
      localStringBuilder.append(paramString1);
      QLog.d("QuicNetResMgr", 2, localStringBuilder.toString());
    }
    if (paramString2.equalsIgnoreCase(paramString1)) {
      return 100;
    }
    return 104;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.QuicNetResMgr
 * JD-Core Version:    0.7.0.1
 */