package com.tencent.mobileqq.emoticon;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean;
import com.tencent.mobileqq.emoticonview.download.AniStickerResReloaderMgr;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQSysAndEmojiResMgr
  implements INetEngineListener
{
  public static final String EMOTICON_RES_DIRNAME = "qq_emoticon_res";
  public static final String KEY_TYPE_MD5 = "md5_type_";
  public static final int REPORT_ENTRANCE_AIO = 1;
  public static final int REPORT_ENTRANCE_FAV_TEXT = 3;
  public static final int REPORT_ENTRANCE_FORWARD_INNER = 4;
  public static final int REPORT_ENTRANCE_FORWARD_OUTER = 5;
  public static final int REPORT_ENTRANCE_MINIAIO = 2;
  public static final int RES_ERROR_INVALID_CONFIG_MD5 = 103;
  public static final int RES_ERROR_INVALID_PATH = 101;
  public static final int RES_ERROR_MD5_VERIFY_FAILED = 104;
  public static final int RES_ERROR_RES_NOTFOUND = 102;
  public static final int RES_QQEMOJI = 3;
  public static final int RES_QQSYS_APNG = 4;
  public static final int RES_QQSYS_GIF = 1;
  public static final int RES_QQSYS_LOTTIE = 5;
  public static final int RES_QQSYS_STATIC = 2;
  public static final int RES_SUCCESS = 100;
  public static final String SP_QQ_EMOTICON = "qq_emoticon_sp";
  private static final String SVG_DIR_NAME = "qsvg";
  public static final String TAG = "QQSysAndEmojiResMgr";
  protected List<String> mDownloadingList = new ArrayList(3);
  private QQEmojiResImpl mEmojiResImpl = new QQEmojiResImpl();
  private QQSysFaceResImpl mQQSysFaceResImpl = new QQSysFaceResImpl();
  
  public static String getAniStickerFullResPath(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(".json");
    return getFullResPath(5, localStringBuilder.toString());
  }
  
  public static String getAniStickerRandomResultFullResPath(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(".json");
    return getFullResPath(5, localStringBuilder.toString());
  }
  
  public static String getFullResPath(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getResSavePath());
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt == 5) {
              localStringBuilder.append("qlottie");
            }
          }
          else {
            localStringBuilder.append("sysface_res/apng");
          }
        }
        else {
          localStringBuilder.append("emoji_res");
        }
      }
      else {
        localStringBuilder.append("sysface_res/static");
      }
    }
    else {
      localStringBuilder.append("sysface_res/gif");
    }
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static final QQSysAndEmojiResMgr getInstance()
  {
    return QQSysAndEmojiResMgr.QQSysAndEmojiResMgrHolder.access$000();
  }
  
  public static String getResSavePath()
  {
    try
    {
      Object localObject = new File(BaseApplication.getContext().getFilesDir(), "/qq_emoticon_res");
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
      QLog.e("QQSysAndEmojiResMgr", 1, "npe:", localNullPointerException);
    }
    return "/qq_emoticon_res";
  }
  
  public static String getSdcardEmoticonResPath()
  {
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.SDCARD_PATH);
    localStringBuilder.append("emoji");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("res");
    localStringBuilder.append(File.separator);
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String getSvgResSaveDirPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getResSavePath());
    localStringBuilder.append("qsvg");
    return localStringBuilder.toString();
  }
  
  public static String getSvgResSavePath(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getSvgResSaveDirPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(".svg");
    return localStringBuilder.toString();
  }
  
  protected boolean checkNeedDownload(int paramInt, String paramString)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("qq_emoticon_sp", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("md5_type_");
    localStringBuilder.append(paramInt);
    localObject = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), "");
    boolean bool = ((String)localObject).equals(paramString) ^ true;
    if (QLog.isColorLevel()) {
      QLog.d("QQSysAndEmojiResMgr", 2, new Object[] { "type:", Integer.valueOf(paramInt), " ,needDownload:", Boolean.valueOf(bool), " ,curr:", localObject, " ,new:", paramString });
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
  
  public void downloadEmoticonRes()
  {
    try
    {
      Iterator localIterator = getDownloadItemList().iterator();
      while (localIterator.hasNext())
      {
        QQSysAndEmojiResMgr.DownloadResItem localDownloadResItem = (QQSysAndEmojiResMgr.DownloadResItem)localIterator.next();
        String str = localDownloadResItem.getSignature();
        if (this.mDownloadingList.contains(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQSysAndEmojiResMgr", 2, "alreary in download list!");
          }
        }
        else
        {
          this.mDownloadingList.add(str);
          sendDownloadRequest(localDownloadResItem);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  protected List<QQSysAndEmojiResMgr.DownloadResItem> getDownloadItemList()
  {
    QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean localSystemAndEmojiConfBean = QQSysAndEmojiConfProcessor.a();
    ArrayList localArrayList = new ArrayList(3);
    if ((!TextUtils.isEmpty(localSystemAndEmojiConfBean.b)) && (!TextUtils.isEmpty(localSystemAndEmojiConfBean.c)) && (checkNeedDownload(1, localSystemAndEmojiConfBean.c))) {
      localArrayList.add(new QQSysAndEmojiResMgr.DownloadResItem(localSystemAndEmojiConfBean.b, localSystemAndEmojiConfBean.c, 1));
    }
    if ((!TextUtils.isEmpty(localSystemAndEmojiConfBean.d)) && (!TextUtils.isEmpty(localSystemAndEmojiConfBean.e)) && (checkNeedDownload(2, localSystemAndEmojiConfBean.e))) {
      localArrayList.add(new QQSysAndEmojiResMgr.DownloadResItem(localSystemAndEmojiConfBean.d, localSystemAndEmojiConfBean.e, 2));
    }
    if ((!TextUtils.isEmpty(localSystemAndEmojiConfBean.f)) && (!TextUtils.isEmpty(localSystemAndEmojiConfBean.g)) && (checkNeedDownload(3, localSystemAndEmojiConfBean.g))) {
      localArrayList.add(new QQSysAndEmojiResMgr.DownloadResItem(localSystemAndEmojiConfBean.f, localSystemAndEmojiConfBean.g, 3));
    }
    if ((!TextUtils.isEmpty(localSystemAndEmojiConfBean.j)) && (!TextUtils.isEmpty(localSystemAndEmojiConfBean.k)) && ((checkNeedDownload(4, localSystemAndEmojiConfBean.k)) || (!FileUtils.fileExists(getSvgResSaveDirPath())))) {
      localArrayList.add(new QQSysAndEmojiResMgr.DownloadResItem(localSystemAndEmojiConfBean.j, localSystemAndEmojiConfBean.k, 4));
    }
    if ((!TextUtils.isEmpty(localSystemAndEmojiConfBean.l)) && (!TextUtils.isEmpty(localSystemAndEmojiConfBean.m)) && ((checkNeedDownload(5, localSystemAndEmojiConfBean.m)) || (!FileUtils.fileExists(getFullResPath(5, ""))))) {
      localArrayList.add(new QQSysAndEmojiResMgr.DownloadResItem(localSystemAndEmojiConfBean.l, localSystemAndEmojiConfBean.m, 5));
    }
    return localArrayList;
  }
  
  public QQSysAndEmojiResInfo getResImpl(int paramInt)
  {
    if (paramInt == 1) {
      try
      {
        QQSysFaceResImpl localQQSysFaceResImpl = this.mQQSysFaceResImpl;
        return localQQSysFaceResImpl;
      }
      finally
      {
        break label68;
      }
    }
    if (paramInt == 2)
    {
      localObject2 = this.mEmojiResImpl;
      return localObject2;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("not support such type:");
    ((StringBuilder)localObject2).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
    label68:
    throw ((Throwable)localObject2);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = paramNetResp.mReq;
    String str = ((NetReq)localObject).mOutPath;
    localObject = (QQSysAndEmojiResMgr.DownloadResItem)((NetReq)localObject).getUserData();
    if (localObject == null)
    {
      QLog.e("QQSysAndEmojiResMgr", 1, "DownloadResItem is null!");
      return;
    }
    long l = System.currentTimeMillis();
    if (paramNetResp.mResult == 0)
    {
      int i = verifyResMD5(str, ((QQSysAndEmojiResMgr.DownloadResItem)localObject).mMd5);
      if (i == 100)
      {
        if (unzipFile(str, getResSavePath()))
        {
          saveResItemMD5(((QQSysAndEmojiResMgr.DownloadResItem)localObject).mType, ((QQSysAndEmojiResMgr.DownloadResItem)localObject).mMd5);
          if (((QQSysAndEmojiResMgr.DownloadResItem)localObject).mType == 1) {
            updateConfig();
          } else if (((QQSysAndEmojiResMgr.DownloadResItem)localObject).mType == 2) {
            getResImpl(1).resDownloadFinish();
          } else if (((QQSysAndEmojiResMgr.DownloadResItem)localObject).mType == 3) {
            getResImpl(2).resDownloadFinish();
          } else if (((QQSysAndEmojiResMgr.DownloadResItem)localObject).mType == 5) {
            AniStickerResReloaderMgr.getInstance().resDownloadFinish();
          }
        }
      }
      else {
        QLog.e("QQSysAndEmojiResMgr", 1, new Object[] { "verifyResMD5 failed! ", Integer.valueOf(i) });
      }
    }
    clearDownloadTempFile(str);
    str = ((QQSysAndEmojiResMgr.DownloadResItem)localObject).getSignature();
    this.mDownloadingList.remove(str);
    if (QLog.isColorLevel()) {
      QLog.d("QQSysAndEmojiResMgr", 2, new Object[] { "onResp:", Integer.valueOf(paramNetResp.mResult), " ,type:", Integer.valueOf(((QQSysAndEmojiResMgr.DownloadResItem)localObject).mType), " ,cost:", Long.valueOf(System.currentTimeMillis() - l), " ,signature:", str.substring(str.lastIndexOf(47)) });
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  protected boolean saveResItemMD5(int paramInt, String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("qq_emoticon_sp", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("md5_type_");
    localStringBuilder.append(paramInt);
    localEditor.putString(localStringBuilder.toString(), paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QQSysAndEmojiResMgr", 2, new Object[] { "saveResItem:", Integer.valueOf(paramInt), " ,md5:", paramString });
    }
    return localEditor.commit();
  }
  
  protected void sendDownloadRequest(QQSysAndEmojiResMgr.DownloadResItem paramDownloadResItem)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mReqUrl = paramDownloadResItem.mUrl;
    localHttpNetReq.mHttpMethod = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getSdcardEmoticonResPath());
    localStringBuilder.append(paramDownloadResItem.mName);
    localHttpNetReq.mOutPath = localStringBuilder.toString();
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    localHttpNetReq.setUserData(paramDownloadResItem);
    try
    {
      ((IHttpEngineService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IHttpEngineService.class, "")).sendReq(localHttpNetReq);
      return;
    }
    catch (NullPointerException paramDownloadResItem)
    {
      label102:
      break label102;
    }
    QLog.e("QQSysAndEmojiResMgr", 1, "npe while getNetEngine");
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
      QLog.e("QQSysAndEmojiResMgr", 1, "unzipFile error ", paramString1);
    }
    return false;
  }
  
  protected void updateConfig()
  {
    QQSysAndEmojiResInfo.parseFaceConfigJson(getResSavePath());
    this.mQQSysFaceResImpl.parseConfigData();
    this.mEmojiResImpl.parseConfigData();
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
        QLog.e("QQSysAndEmojiResMgr", 2, "verifyResMD5 file not exist!");
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
      QLog.d("QQSysAndEmojiResMgr", 2, localStringBuilder.toString());
    }
    if (paramString2.equalsIgnoreCase(paramString1)) {
      return 100;
    }
    return 104;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr
 * JD-Core Version:    0.7.0.1
 */