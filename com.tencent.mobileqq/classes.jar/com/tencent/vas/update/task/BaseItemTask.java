package com.tencent.vas.update.task;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.vas.update.VasUpdateSystem;
import com.tencent.vas.update.callback.ICommonManager;
import com.tencent.vas.update.callback.IDbManager;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.callback.listener.ITaskDownloadCallback;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.DLReportInfo;
import com.tencent.vas.update.entity.UpdateUrlInfoPtr;
import com.tencent.vas.update.entity.db.ItemLocalFileMd5;
import com.tencent.vas.update.entity.db.ItemLocalVerPrt;
import com.tencent.vas.update.entity.db.ItemUpdateVerPtr;
import com.tencent.vas.update.module.download.DownloadModule;
import com.tencent.vas.update.util.FileUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.io.File;

public class BaseItemTask
  implements ITaskDownloadCallback
{
  private static final String TAG = "VasUpdate_BaseItemTask";
  protected int mDLFrom;
  protected BusinessItemInfo mItemInfo;
  protected ItemUpdateVerPtr mLocalUpdateVer;
  protected BusinessUpdateParams mParams;
  protected String mStrTempFilePath;
  protected UpdateUrlInfoPtr mUpdateUrlInfo;
  
  public BaseItemTask(@NonNull BusinessUpdateParams paramBusinessUpdateParams, @NonNull ItemUpdateVerPtr paramItemUpdateVerPtr, @NonNull BusinessItemInfo paramBusinessItemInfo)
  {
    this.mParams = paramBusinessUpdateParams;
    this.mLocalUpdateVer = paramItemUpdateVerPtr;
    this.mItemInfo = paramBusinessItemInfo;
  }
  
  private boolean checkFileMd5(String paramString)
  {
    if ((this.mUpdateUrlInfo == null) || (TextUtils.isEmpty(this.mUpdateUrlInfo.mDstMd5)) || (TextUtils.isEmpty(paramString))) {}
    while (!this.mUpdateUrlInfo.mDstMd5.equalsIgnoreCase(VasUpdateWrapper.getCommonManager().getFileMd5(paramString))) {
      return false;
    }
    return true;
  }
  
  private boolean checkFileValid(@NonNull String paramString)
  {
    ItemLocalFileMd5 localItemLocalFileMd5 = ItemLocalFileMd5.parseJsonToItemLocalFileMd5(VasUpdateWrapper.getDbManager().selectItem(2, this.mParams.mItemId));
    if ((localItemLocalFileMd5 == null) || (!paramString.equalsIgnoreCase(localItemLocalFileMd5.mOriginMd5))) {
      return false;
    }
    VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "checkFileValid local : " + localItemLocalFileMd5.toString());
    File localFile = new File(getSaveFilePath());
    if ((localFile.lastModified() != 0L) && (localItemLocalFileMd5.mLastFileModified != 0L) && (localFile.lastModified() != localItemLocalFileMd5.mLastFileModified))
    {
      VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileValid file has modified");
      return false;
    }
    if (this.mItemInfo.mIsCanPatch)
    {
      if (!new File(getStorageFilePath()).exists())
      {
        VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileValid sge doesn't exist");
        return false;
      }
      if (!paramString.equalsIgnoreCase(VasUpdateWrapper.getCommonManager().getFileMd5(getStorageFilePath())))
      {
        VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileValid sge invalid");
        return false;
      }
    }
    return true;
  }
  
  private void checkItemUpdateDb(String paramString)
  {
    this.mLocalUpdateVer.mAppVersion = this.mUpdateUrlInfo.mAppVersion;
    this.mLocalUpdateVer.mSrcMd5 = this.mUpdateUrlInfo.mDstMd5;
    if (this.mLocalUpdateVer.checkItemIsCurrentVersion())
    {
      VasUpdateWrapper.getDbManager().deleteItem(1, paramString);
      return;
    }
    VasUpdateWrapper.getDbManager().updateItem(1, paramString, ItemUpdateVerPtr.convertItemUpdateVerPrtToJson(this.mLocalUpdateVer));
  }
  
  private String getStorageFilePath()
  {
    String str2 = getSaveFilePath();
    String str1 = str2;
    if (this.mItemInfo.mSaveInDir) {
      str1 = str2 + File.separator + this.mParams.mItemId + ".sge";
    }
    return str1;
  }
  
  private void handleGetUrlSuccess(@NonNull UpdateUrlInfoPtr paramUpdateUrlInfoPtr)
  {
    this.mUpdateUrlInfo = paramUpdateUrlInfoPtr;
    IBusinessCallback localIBusinessCallback = VasUpdateSystem.getInstance().getObserver(paramUpdateUrlInfoPtr.mBid);
    if (VasUpdateWrapper.getLog().isColorLevel()) {
      VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "handleGetUrlSuccess  bid = " + paramUpdateUrlInfoPtr.mBid + " , scid = " + paramUpdateUrlInfoPtr.mScid + " savePath = " + getSaveFilePath());
    }
    if (localIBusinessCallback == null) {
      return;
    }
    if ((localIBusinessCallback.isFileExist(this.mParams, this.mItemInfo)) && (checkFileValid(paramUpdateUrlInfoPtr.mDstMd5)))
    {
      VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "handleGetUrlSuccess  up-to-date , itemId = " + paramUpdateUrlInfoPtr.mItemId);
      checkItemUpdateDb(this.mParams.mItemId);
      selfNotifyCompleted(0, 0, "");
      return;
    }
    if (paramUpdateUrlInfoPtr.mCode == 1)
    {
      selfNotifyCompleted(10, 0, "update limit code = 1");
      return;
    }
    if (paramUpdateUrlInfoPtr.mCode != 0)
    {
      selfNotifyCompleted(4, 0, "update response code error , code = " + paramUpdateUrlInfoPtr.mCode);
      return;
    }
    if (!TextUtils.isEmpty(paramUpdateUrlInfoPtr.mFileContent))
    {
      if (FileUtil.removeFile(paramUpdateUrlInfoPtr.mFileContent, getTempFilePath()))
      {
        notifyDownloadComplete(paramUpdateUrlInfoPtr.mItemId, 0, 0, "file content success");
        return;
      }
      selfNotifyCompleted(12, 0, "temp file move error , file = " + paramUpdateUrlInfoPtr.mFileContent);
      return;
    }
    VasUpdateSystem.getInstance().getDownloadModule().startDownload(this.mParams.mItemId, paramUpdateUrlInfoPtr.mUrl, this.mParams.mFrom, getTempFilePath(), this);
  }
  
  private void saveMd5MapDb(String paramString)
  {
    File localFile = new File(getSaveFilePath());
    if (localFile.exists())
    {
      ItemLocalFileMd5 localItemLocalFileMd5 = new ItemLocalFileMd5();
      localItemLocalFileMd5.mItemId = paramString;
      localItemLocalFileMd5.mLastFileModified = localFile.lastModified();
      localItemLocalFileMd5.mOriginMd5 = this.mUpdateUrlInfo.mDstMd5;
      VasUpdateWrapper.getDbManager().updateItem(2, paramString, ItemLocalFileMd5.convertItemLocalFileMd5ToJson(localItemLocalFileMd5));
    }
  }
  
  private void selfNotifyCompleted(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool2 = false;
    DLReportInfo localDLReportInfo;
    label162:
    label185:
    ItemUpdateVerPtr localItemUpdateVerPtr;
    if (paramInt1 != 0)
    {
      VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "selfNotifyCompleted fail itemId = " + this.mParams.mItemId + " nUpdateErrorCode = " + paramInt1 + " , nHttpCode = " + paramInt2 + " , message = " + paramString + " retryCount = " + this.mLocalUpdateVer.mRunCount);
      localDLReportInfo = new DLReportInfo();
      boolean bool1 = bool2;
      if (this.mUpdateUrlInfo != null)
      {
        bool1 = bool2;
        if (this.mUpdateUrlInfo.mDeltaMode == 1) {
          bool1 = true;
        }
      }
      localDLReportInfo.mIsIncrement = bool1;
      localDLReportInfo.mRetryCount = this.mLocalUpdateVer.mRunCount;
      if (this.mUpdateUrlInfo == null) {
        break label432;
      }
      localObject = this.mUpdateUrlInfo.mSrcMd5;
      localDLReportInfo.mSrcMd5 = ((String)localObject);
      if (this.mUpdateUrlInfo == null) {
        break label439;
      }
      localObject = this.mUpdateUrlInfo.mDstMd5;
      localDLReportInfo.mDstMd5 = ((String)localObject);
      if ((paramInt1 != 0) && (paramInt1 != 10))
      {
        this.mLocalUpdateVer.mLastRunTime = (System.currentTimeMillis() / 1000L);
        localObject = this.mLocalUpdateVer;
        ((ItemUpdateVerPtr)localObject).mRunCount += 1;
        localItemUpdateVerPtr = this.mLocalUpdateVer;
        if (this.mUpdateUrlInfo == null) {
          break label446;
        }
      }
    }
    label432:
    label439:
    label446:
    for (Object localObject = this.mUpdateUrlInfo.mAppVersion;; localObject = this.mLocalUpdateVer.mAppVersion)
    {
      localItemUpdateVerPtr.mAppVersion = ((String)localObject);
      VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "selfNotifyCompleted fail localData = " + this.mLocalUpdateVer.toString() + " mDLFrom = " + this.mDLFrom);
      if (this.mDLFrom != 3) {
        VasUpdateWrapper.getDbManager().updateItem(1, this.mLocalUpdateVer.mItemId, ItemUpdateVerPtr.convertItemUpdateVerPrtToJson(this.mLocalUpdateVer));
      }
      VasUpdateSystem.getInstance().onTaskItemComplete(this.mParams, this.mDLFrom, paramInt1, paramInt2, paramString, localDLReportInfo);
      return;
      VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "selfNotifyCompleted nUpdateErrorCode = " + paramInt1 + " , nHttpCode = " + paramInt2 + " , message = " + paramString + " retryCount = " + this.mLocalUpdateVer.mRunCount);
      break;
      localObject = "";
      break label162;
      localObject = "";
      break label185;
    }
  }
  
  public int checkFileMode(String paramString1, String paramString2)
  {
    if (this.mUpdateUrlInfo == null) {
      return 999;
    }
    if (VasUpdateWrapper.getLog().isColorLevel()) {
      VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "start checkFileMode itemId = " + paramString1 + " ; tempFile = " + paramString2);
    }
    String str1 = paramString2;
    if (this.mUpdateUrlInfo.mCompressMode != 0)
    {
      VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "checkFileMode handle compressMode , mode = " + this.mUpdateUrlInfo.mCompressMode);
      str1 = VasUpdateWrapper.getCommonManager().unCompressFile(this.mUpdateUrlInfo.mCompressMode, paramString2);
      if (TextUtils.isEmpty(str1))
      {
        VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileMode compress error path = null , itemId = " + paramString1);
        return 13;
      }
      FileUtil.deleteFile(paramString2);
      VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "uncompress success id = " + paramString1);
    }
    VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "checkFileMode id = " + paramString1 + " mDeltaMode = " + this.mUpdateUrlInfo.mDeltaMode);
    if (this.mUpdateUrlInfo.mDeltaMode == 1)
    {
      String str2 = getStorageFilePath();
      paramString2 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        paramString2 = str2;
        if (str2.equalsIgnoreCase(getSaveFilePath()))
        {
          paramString2 = str2 + ".copy";
          if (!VasUpdateWrapper.getCommonManager().copyFile(getSaveFilePath(), paramString2))
          {
            VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileMode copyFile fail , id = " + paramString1);
            return 22;
          }
          VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileMode copyFile success sgeFile = " + paramString2);
        }
      }
      if (!VasUpdateWrapper.getCommonManager().filePatch(paramString2, str1))
      {
        VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileMode filePatch fail , id = " + paramString1);
        return 15;
      }
      VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "checkFileMode file patch success, id = " + paramString1 + " sgeFile = " + paramString2);
      FileUtil.deleteFile(str1);
    }
    while (!checkFileMd5(paramString2))
    {
      VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileMode checkFileMd5 error , id = " + paramString1 + " returnFile = " + paramString2);
      FileUtil.deleteFile(paramString2);
      return 17;
      if (this.mUpdateUrlInfo.mDeltaMode == 0)
      {
        if (!FileUtil.removeFile(str1, getStorageFilePath()))
        {
          VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileMode save storage file fail , id = " + paramString1 + " , storagePath = " + getStorageFilePath());
          return 12;
        }
        paramString2 = getStorageFilePath();
      }
      else
      {
        VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileMode delta mode error , id = " + paramString1);
        return 16;
      }
    }
    if (VasUpdateWrapper.getLog().isColorLevel()) {
      VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "checkFileMode mSaveInDir = " + this.mItemInfo.mSaveInDir + " , storageMode = " + this.mUpdateUrlInfo.mStorageMode + " mIsCanPatch = " + this.mItemInfo.mIsCanPatch + " savePath = " + getSaveFilePath());
    }
    str1 = paramString2;
    if (this.mItemInfo.mSaveInDir)
    {
      str1 = paramString2;
      if (this.mUpdateUrlInfo.mStorageMode != 0)
      {
        str1 = VasUpdateWrapper.getCommonManager().unCompressFile(this.mUpdateUrlInfo.mStorageMode, paramString2);
        if (TextUtils.isEmpty(str1))
        {
          VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileMode storage compress error path = null , itemId = " + paramString1);
          return 13;
        }
        if (!this.mItemInfo.mIsCanPatch) {
          FileUtil.deleteFile(paramString2);
        }
      }
    }
    if ((!this.mItemInfo.mSaveInDir) && (!TextUtils.isEmpty(str1)) && (!str1.equalsIgnoreCase(getSaveFilePath())) && (!FileUtil.removeFile(str1, getSaveFilePath())))
    {
      VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileMode move file fail , id = " + paramString1);
      return 12;
    }
    return 0;
  }
  
  public boolean checkSrcFileIsNeedReDownload(String paramString)
  {
    IBusinessCallback localIBusinessCallback = VasUpdateSystem.getInstance().getObserver(this.mParams.mBid);
    VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "checkSrcFileIsNeedReDownload");
    if ((localIBusinessCallback == null) || (TextUtils.isEmpty(paramString))) {}
    while (!localIBusinessCallback.isFileExist(this.mParams, this.mItemInfo)) {
      return true;
    }
    if (checkFileValid(paramString)) {
      return false;
    }
    try
    {
      new File(getSaveFilePath()).delete();
      new File(getStorageFilePath()).delete();
      localIBusinessCallback.deleteFile(this.mParams, this.mItemInfo);
      return true;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return true;
  }
  
  public ItemUpdateVerPtr getItemUpdateVer()
  {
    return this.mLocalUpdateVer;
  }
  
  protected String getSaveFilePath()
  {
    return this.mItemInfo.mSavePath;
  }
  
  protected String getSaveFilePathDir()
  {
    String str2 = getSaveFilePath();
    if (TextUtils.isEmpty(str2)) {
      VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "getSaveFilePathDir path = null , itemId = " + this.mParams.mItemId);
    }
    String str1 = str2;
    if (!this.mItemInfo.mSaveInDir)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        int i = str2.lastIndexOf(File.separator);
        str1 = str2;
        if (i > 0) {
          str1 = str2.substring(0, i);
        }
      }
    }
    return str1;
  }
  
  protected String getTempFilePath()
  {
    this.mStrTempFilePath = getSaveFilePathDir();
    FileUtil.checkFilePathExist(this.mStrTempFilePath);
    this.mStrTempFilePath = (this.mStrTempFilePath + File.separator + this.mParams.mItemId + ".tmp");
    return this.mStrTempFilePath;
  }
  
  public void handleGetUrlRsp(int paramInt, @NonNull UpdateUrlInfoPtr paramUpdateUrlInfoPtr)
  {
    if (paramInt == 0)
    {
      handleGetUrlSuccess(paramUpdateUrlInfoPtr);
      return;
    }
    selfNotifyCompleted(4, 0, "task handleGetUrlRsp result != 0");
  }
  
  public void notifyDownloadComplete(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "complete itemId = " + paramString1 + " nUpdateErrorCode = " + paramInt1 + " nHttpCode = " + paramInt2 + " message = " + paramString2);
    if (paramInt1 != 0)
    {
      String str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = "itemId =  " + paramString1 + " download fail , error code = " + paramInt1 + " httpCode = " + paramInt2;
      }
      selfNotifyCompleted(paramInt1, paramInt2, str);
      return;
    }
    paramInt1 = checkFileMode(paramString1, getTempFilePath());
    if (paramInt1 != 0)
    {
      selfNotifyCompleted(paramInt1, paramInt2, "checkFileMode error itemId = " + paramString1 + " fileModeRes = " + paramInt1);
      return;
    }
    paramString2 = new ItemLocalVerPrt();
    paramString2.mItemId = this.mLocalUpdateVer.mItemId;
    paramString2.mMd5 = this.mUpdateUrlInfo.mDstMd5;
    VasUpdateWrapper.getDbManager().updateItem(0, paramString2.mItemId, ItemLocalVerPrt.convertItemLocalVerPrtToJson(paramString2));
    checkItemUpdateDb(this.mLocalUpdateVer.mItemId);
    saveMd5MapDb(paramString1);
    selfNotifyCompleted(0, paramInt2, "");
  }
  
  public void notifyDownloadProgress(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    if ((VasUpdateWrapper.getLog().isColorLevel()) && (paramInt == 100)) {
      VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "progress itemId = " + paramString + " rate = " + paramInt + " current = " + paramLong1 + " max = " + paramLong2);
    }
    VasUpdateSystem.getInstance().onTaskItemProgress(this.mParams, paramLong1, paramLong2, paramInt);
  }
  
  public void onSendPbMsgError()
  {
    selfNotifyCompleted(2, 0, "send get url pb error");
  }
  
  public void setDLFrom(int paramInt)
  {
    this.mDLFrom = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.task.BaseItemTask
 * JD-Core Version:    0.7.0.1
 */