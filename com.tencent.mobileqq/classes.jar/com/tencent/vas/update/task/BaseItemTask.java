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
    UpdateUrlInfoPtr localUpdateUrlInfoPtr = this.mUpdateUrlInfo;
    if ((localUpdateUrlInfoPtr != null) && (!TextUtils.isEmpty(localUpdateUrlInfoPtr.mDstMd5)))
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (this.mUpdateUrlInfo.mDstMd5.equalsIgnoreCase(VasUpdateWrapper.getCommonManager().getFileMd5(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean checkFileValid(@NonNull String paramString)
  {
    ItemLocalFileMd5 localItemLocalFileMd5 = ItemLocalFileMd5.parseJsonToItemLocalFileMd5(VasUpdateWrapper.getDbManager().selectItem(2, this.mParams.mItemId));
    if (localItemLocalFileMd5 != null)
    {
      if (!paramString.equalsIgnoreCase(localItemLocalFileMd5.mOriginMd5)) {
        return false;
      }
      Object localObject = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkFileValid local : ");
      localStringBuilder.append(localItemLocalFileMd5.toString());
      ((IVasLog)localObject).i("VasUpdate_BaseItemTask", localStringBuilder.toString());
      localObject = new File(getSaveFilePath());
      if ((((File)localObject).lastModified() != 0L) && (localItemLocalFileMd5.mLastFileModified != 0L) && (((File)localObject).lastModified() != localItemLocalFileMd5.mLastFileModified))
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
    return false;
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
    String str = getSaveFilePath();
    Object localObject = str;
    if (this.mItemInfo.mSaveInDir)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.mParams.mItemId);
      ((StringBuilder)localObject).append(".sge");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private void handleGetUrlSuccess(@NonNull UpdateUrlInfoPtr paramUpdateUrlInfoPtr)
  {
    this.mUpdateUrlInfo = paramUpdateUrlInfoPtr;
    Object localObject1 = VasUpdateSystem.getInstance().getObserver(paramUpdateUrlInfoPtr.mBid);
    Object localObject2;
    if (VasUpdateWrapper.getLog().isColorLevel())
    {
      localObject2 = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetUrlSuccess  bid = ");
      localStringBuilder.append(paramUpdateUrlInfoPtr.mBid);
      localStringBuilder.append(" , scid = ");
      localStringBuilder.append(paramUpdateUrlInfoPtr.mScid);
      localStringBuilder.append(" savePath = ");
      localStringBuilder.append(getSaveFilePath());
      ((IVasLog)localObject2).i("VasUpdate_BaseItemTask", localStringBuilder.toString());
    }
    if (localObject1 == null) {
      return;
    }
    if ((((IBusinessCallback)localObject1).isFileExist(this.mParams, this.mItemInfo)) && (checkFileValid(paramUpdateUrlInfoPtr.mDstMd5)))
    {
      localObject1 = VasUpdateWrapper.getLog();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleGetUrlSuccess  up-to-date , itemId = ");
      ((StringBuilder)localObject2).append(paramUpdateUrlInfoPtr.mItemId);
      ((IVasLog)localObject1).e("VasUpdate_BaseItemTask", ((StringBuilder)localObject2).toString());
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
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("update response code error , code = ");
      ((StringBuilder)localObject1).append(paramUpdateUrlInfoPtr.mCode);
      selfNotifyCompleted(4, 0, ((StringBuilder)localObject1).toString());
      return;
    }
    if (!TextUtils.isEmpty(paramUpdateUrlInfoPtr.mFileContent))
    {
      if (FileUtil.removeFile(paramUpdateUrlInfoPtr.mFileContent, getTempFilePath()))
      {
        notifyDownloadComplete(paramUpdateUrlInfoPtr.mItemId, 0, 0, "file content success");
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("temp file move error , file = ");
      ((StringBuilder)localObject1).append(paramUpdateUrlInfoPtr.mFileContent);
      selfNotifyCompleted(12, 0, ((StringBuilder)localObject1).toString());
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
    if (paramInt1 != 0)
    {
      localObject1 = VasUpdateWrapper.getLog();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("selfNotifyCompleted fail itemId = ");
      ((StringBuilder)localObject2).append(this.mParams.mItemId);
      ((StringBuilder)localObject2).append(" nUpdateErrorCode = ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" , nHttpCode = ");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(" , message = ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" retryCount = ");
      ((StringBuilder)localObject2).append(this.mLocalUpdateVer.mRunCount);
      ((IVasLog)localObject1).e("VasUpdate_BaseItemTask", ((StringBuilder)localObject2).toString());
    }
    else
    {
      localObject1 = VasUpdateWrapper.getLog();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("selfNotifyCompleted nUpdateErrorCode = ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" , nHttpCode = ");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(" , message = ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" retryCount = ");
      ((StringBuilder)localObject2).append(this.mLocalUpdateVer.mRunCount);
      ((IVasLog)localObject1).i("VasUpdate_BaseItemTask", ((StringBuilder)localObject2).toString());
    }
    DLReportInfo localDLReportInfo = new DLReportInfo();
    Object localObject1 = this.mUpdateUrlInfo;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (((UpdateUrlInfoPtr)localObject1).mDeltaMode == 1) {
        bool1 = true;
      }
    }
    localDLReportInfo.mIsIncrement = bool1;
    localDLReportInfo.mRetryCount = this.mLocalUpdateVer.mRunCount;
    localObject1 = this.mUpdateUrlInfo;
    Object localObject2 = "";
    if (localObject1 != null) {
      localObject1 = ((UpdateUrlInfoPtr)localObject1).mSrcMd5;
    } else {
      localObject1 = "";
    }
    localDLReportInfo.mSrcMd5 = ((String)localObject1);
    UpdateUrlInfoPtr localUpdateUrlInfoPtr = this.mUpdateUrlInfo;
    localObject1 = localObject2;
    if (localUpdateUrlInfoPtr != null) {
      localObject1 = localUpdateUrlInfoPtr.mDstMd5;
    }
    localDLReportInfo.mDstMd5 = ((String)localObject1);
    if ((paramInt1 != 0) && (paramInt1 != 10))
    {
      this.mLocalUpdateVer.mLastRunTime = (System.currentTimeMillis() / 1000L);
      localObject1 = this.mLocalUpdateVer;
      ((ItemUpdateVerPtr)localObject1).mRunCount += 1;
      localObject2 = this.mLocalUpdateVer;
      localObject1 = this.mUpdateUrlInfo;
      if (localObject1 != null) {
        localObject1 = ((UpdateUrlInfoPtr)localObject1).mAppVersion;
      } else {
        localObject1 = ((ItemUpdateVerPtr)localObject2).mAppVersion;
      }
      ((ItemUpdateVerPtr)localObject2).mAppVersion = ((String)localObject1);
      localObject1 = VasUpdateWrapper.getLog();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("selfNotifyCompleted fail localData = ");
      ((StringBuilder)localObject2).append(this.mLocalUpdateVer.toString());
      ((StringBuilder)localObject2).append(" mDLFrom = ");
      ((StringBuilder)localObject2).append(this.mDLFrom);
      ((IVasLog)localObject1).e("VasUpdate_BaseItemTask", ((StringBuilder)localObject2).toString());
      if (this.mDLFrom != 3) {
        VasUpdateWrapper.getDbManager().updateItem(1, this.mLocalUpdateVer.mItemId, ItemUpdateVerPtr.convertItemUpdateVerPrtToJson(this.mLocalUpdateVer));
      }
    }
    VasUpdateSystem.getInstance().onTaskItemComplete(this.mParams, this.mDLFrom, paramInt1, paramInt2, paramString, localDLReportInfo);
  }
  
  public int checkFileMode(String paramString1, String paramString2)
  {
    if (this.mUpdateUrlInfo == null) {
      return 999;
    }
    if (VasUpdateWrapper.getLog().isColorLevel())
    {
      localObject1 = VasUpdateWrapper.getLog();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("start checkFileMode itemId = ");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(" ; tempFile = ");
      ((StringBuilder)localObject2).append(paramString2);
      ((IVasLog)localObject1).i("VasUpdate_BaseItemTask", ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = paramString2;
    if (this.mUpdateUrlInfo.mCompressMode != 0)
    {
      localObject1 = VasUpdateWrapper.getLog();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkFileMode handle compressMode , mode = ");
      ((StringBuilder)localObject2).append(this.mUpdateUrlInfo.mCompressMode);
      ((IVasLog)localObject1).i("VasUpdate_BaseItemTask", ((StringBuilder)localObject2).toString());
      localObject1 = VasUpdateWrapper.getCommonManager().unCompressFile(this.mUpdateUrlInfo.mCompressMode, paramString2);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramString2 = VasUpdateWrapper.getLog();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkFileMode compress error path = null , itemId = ");
        ((StringBuilder)localObject1).append(paramString1);
        paramString2.e("VasUpdate_BaseItemTask", ((StringBuilder)localObject1).toString());
        return 13;
      }
      FileUtil.deleteFile(paramString2);
      paramString2 = VasUpdateWrapper.getLog();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("uncompress success id = ");
      ((StringBuilder)localObject2).append(paramString1);
      paramString2.i("VasUpdate_BaseItemTask", ((StringBuilder)localObject2).toString());
    }
    paramString2 = VasUpdateWrapper.getLog();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("checkFileMode id = ");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append(" mDeltaMode = ");
    ((StringBuilder)localObject2).append(this.mUpdateUrlInfo.mDeltaMode);
    paramString2.i("VasUpdate_BaseItemTask", ((StringBuilder)localObject2).toString());
    if (this.mUpdateUrlInfo.mDeltaMode == 1)
    {
      localObject2 = getStorageFilePath();
      paramString2 = (String)localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramString2 = (String)localObject2;
        if (((String)localObject2).equalsIgnoreCase(getSaveFilePath()))
        {
          paramString2 = new StringBuilder();
          paramString2.append((String)localObject2);
          paramString2.append(".copy");
          paramString2 = paramString2.toString();
          if (!VasUpdateWrapper.getCommonManager().copyFile(getSaveFilePath(), paramString2))
          {
            paramString2 = VasUpdateWrapper.getLog();
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("checkFileMode copyFile fail , id = ");
            ((StringBuilder)localObject1).append(paramString1);
            paramString2.e("VasUpdate_BaseItemTask", ((StringBuilder)localObject1).toString());
            return 22;
          }
          localObject2 = VasUpdateWrapper.getLog();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkFileMode copyFile success sgeFile = ");
          localStringBuilder.append(paramString2);
          ((IVasLog)localObject2).e("VasUpdate_BaseItemTask", localStringBuilder.toString());
        }
      }
      if (!VasUpdateWrapper.getCommonManager().filePatch(paramString2, (String)localObject1))
      {
        paramString2 = VasUpdateWrapper.getLog();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkFileMode filePatch fail , id = ");
        ((StringBuilder)localObject1).append(paramString1);
        paramString2.e("VasUpdate_BaseItemTask", ((StringBuilder)localObject1).toString());
        return 15;
      }
      localObject2 = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkFileMode file patch success, id = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" sgeFile = ");
      localStringBuilder.append(paramString2);
      ((IVasLog)localObject2).i("VasUpdate_BaseItemTask", localStringBuilder.toString());
      FileUtil.deleteFile((String)localObject1);
    }
    else
    {
      if (this.mUpdateUrlInfo.mDeltaMode != 0) {
        break label1080;
      }
      if (!FileUtil.removeFile((String)localObject1, getStorageFilePath()))
      {
        paramString2 = VasUpdateWrapper.getLog();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkFileMode save storage file fail , id = ");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(" , storagePath = ");
        ((StringBuilder)localObject1).append(getStorageFilePath());
        paramString2.e("VasUpdate_BaseItemTask", ((StringBuilder)localObject1).toString());
        return 12;
      }
      paramString2 = getStorageFilePath();
    }
    if (!checkFileMd5(paramString2))
    {
      localObject1 = VasUpdateWrapper.getLog();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkFileMode checkFileMd5 error , id = ");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(" returnFile = ");
      ((StringBuilder)localObject2).append(paramString2);
      ((IVasLog)localObject1).e("VasUpdate_BaseItemTask", ((StringBuilder)localObject2).toString());
      FileUtil.deleteFile(paramString2);
      return 17;
    }
    if (VasUpdateWrapper.getLog().isColorLevel())
    {
      localObject1 = VasUpdateWrapper.getLog();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkFileMode mSaveInDir = ");
      ((StringBuilder)localObject2).append(this.mItemInfo.mSaveInDir);
      ((StringBuilder)localObject2).append(" , storageMode = ");
      ((StringBuilder)localObject2).append(this.mUpdateUrlInfo.mStorageMode);
      ((StringBuilder)localObject2).append(" mIsCanPatch = ");
      ((StringBuilder)localObject2).append(this.mItemInfo.mIsCanPatch);
      ((StringBuilder)localObject2).append(" savePath = ");
      ((StringBuilder)localObject2).append(getSaveFilePath());
      ((IVasLog)localObject1).i("VasUpdate_BaseItemTask", ((StringBuilder)localObject2).toString());
    }
    if ((this.mItemInfo.mSaveInDir) && (this.mUpdateUrlInfo.mStorageMode != 0))
    {
      localObject2 = VasUpdateWrapper.getCommonManager().unCompressFile(this.mUpdateUrlInfo.mStorageMode, paramString2);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramString2 = VasUpdateWrapper.getLog();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkFileMode storage compress error path = null , itemId = ");
        ((StringBuilder)localObject1).append(paramString1);
        paramString2.e("VasUpdate_BaseItemTask", ((StringBuilder)localObject1).toString());
        return 13;
      }
      localObject1 = localObject2;
      if (!this.mItemInfo.mIsCanPatch)
      {
        FileUtil.deleteFile(paramString2);
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = paramString2;
    }
    if ((!this.mItemInfo.mSaveInDir) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equalsIgnoreCase(getSaveFilePath())) && (!FileUtil.removeFile((String)localObject1, getSaveFilePath())))
    {
      paramString2 = VasUpdateWrapper.getLog();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkFileMode move file fail , id = ");
      ((StringBuilder)localObject1).append(paramString1);
      paramString2.e("VasUpdate_BaseItemTask", ((StringBuilder)localObject1).toString());
      return 12;
    }
    return 0;
    label1080:
    paramString2 = VasUpdateWrapper.getLog();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkFileMode delta mode error , id = ");
    ((StringBuilder)localObject1).append(paramString1);
    paramString2.e("VasUpdate_BaseItemTask", ((StringBuilder)localObject1).toString());
    return 16;
  }
  
  public boolean checkSrcFileIsNeedReDownload(String paramString)
  {
    IBusinessCallback localIBusinessCallback = VasUpdateSystem.getInstance().getObserver(this.mParams.mBid);
    VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "checkSrcFileIsNeedReDownload");
    if (localIBusinessCallback != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return true;
      }
      if (!localIBusinessCallback.isFileExist(this.mParams, this.mItemInfo)) {
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
    String str = getSaveFilePath();
    if (TextUtils.isEmpty(str))
    {
      localObject = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSaveFilePathDir path = null , itemId = ");
      localStringBuilder.append(this.mParams.mItemId);
      ((IVasLog)localObject).e("VasUpdate_BaseItemTask", localStringBuilder.toString());
    }
    Object localObject = str;
    if (!this.mItemInfo.mSaveInDir)
    {
      localObject = str;
      if (!TextUtils.isEmpty(str))
      {
        int i = str.lastIndexOf(File.separator);
        localObject = str;
        if (i > 0) {
          localObject = str.substring(0, i);
        }
      }
    }
    return localObject;
  }
  
  protected String getTempFilePath()
  {
    this.mStrTempFilePath = getSaveFilePathDir();
    FileUtil.checkFilePathExist(this.mStrTempFilePath);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mStrTempFilePath);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.mParams.mItemId);
    localStringBuilder.append(".tmp");
    this.mStrTempFilePath = localStringBuilder.toString();
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
    Object localObject = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("complete itemId = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" nUpdateErrorCode = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" nHttpCode = ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" message = ");
    localStringBuilder.append(paramString2);
    ((IVasLog)localObject).i("VasUpdate_BaseItemTask", localStringBuilder.toString());
    if (paramInt1 != 0)
    {
      localObject = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString2 = new StringBuilder();
        paramString2.append("itemId =  ");
        paramString2.append(paramString1);
        paramString2.append(" download fail , error code = ");
        paramString2.append(paramInt1);
        paramString2.append(" httpCode = ");
        paramString2.append(paramInt2);
        localObject = paramString2.toString();
      }
      selfNotifyCompleted(paramInt1, paramInt2, (String)localObject);
      return;
    }
    paramInt1 = checkFileMode(paramString1, getTempFilePath());
    if (paramInt1 != 0)
    {
      paramString2 = new StringBuilder();
      paramString2.append("checkFileMode error itemId = ");
      paramString2.append(paramString1);
      paramString2.append(" fileModeRes = ");
      paramString2.append(paramInt1);
      selfNotifyCompleted(paramInt1, paramInt2, paramString2.toString());
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
    if ((VasUpdateWrapper.getLog().isColorLevel()) && (paramInt == 100))
    {
      IVasLog localIVasLog = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("progress itemId = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" rate = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" current = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" max = ");
      localStringBuilder.append(paramLong2);
      localIVasLog.i("VasUpdate_BaseItemTask", localStringBuilder.toString());
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