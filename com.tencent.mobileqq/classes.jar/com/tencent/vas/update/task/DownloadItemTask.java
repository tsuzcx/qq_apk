package com.tencent.vas.update.task;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.callback.listener.ITaskDownloadCallback;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.DLReportInfo;
import com.tencent.vas.update.entity.DownloadResultParams;
import com.tencent.vas.update.entity.UpdateUrlInfoPtr;
import com.tencent.vas.update.entity.db.ItemLocalFileMd5;
import com.tencent.vas.update.entity.db.ItemLocalVerPrt;
import com.tencent.vas.update.entity.db.ItemUpdateVerPtr;
import com.tencent.vas.update.factory.api.ICommonManager;
import com.tencent.vas.update.factory.api.IDbManager;
import com.tencent.vas.update.factory.api.IVasLog;
import com.tencent.vas.update.module.api.IDownloadModule;
import com.tencent.vas.update.module.api.IVasUpdateSystem;
import com.tencent.vas.update.util.FileUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.io.File;

public class DownloadItemTask
  implements ITaskDownloadCallback
{
  private String a;
  private ItemUpdateVerPtr b;
  private BusinessUpdateParams c;
  private BusinessItemInfo d;
  private UpdateUrlInfoPtr e;
  private int f;
  
  public DownloadItemTask(@NonNull BusinessUpdateParams paramBusinessUpdateParams, @NonNull ItemUpdateVerPtr paramItemUpdateVerPtr, @NonNull BusinessItemInfo paramBusinessItemInfo)
  {
    this.c = paramBusinessUpdateParams;
    this.b = paramItemUpdateVerPtr;
    this.d = paramBusinessItemInfo;
  }
  
  private Pair<String, Integer> a(String paramString1, String paramString2)
  {
    if (!FileUtil.removeFile(paramString2, f()))
    {
      paramString2 = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkFileMode save storage file fail , id = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" , storagePath = ");
      localStringBuilder.append(f());
      paramString2.c("VasUpdate_BaseItemTask", localStringBuilder.toString());
      return new Pair(null, Integer.valueOf(12));
    }
    return new Pair(f(), Integer.valueOf(0));
  }
  
  private Pair<String, Integer> a(String paramString1, String paramString2, String paramString3)
  {
    if (this.e.mDeltaMode == 1) {
      return b(paramString1, paramString2);
    }
    if (this.e.mDeltaMode == 0) {
      return a(paramString1, paramString3);
    }
    paramString2 = VasUpdateWrapper.getLog();
    paramString3 = new StringBuilder();
    paramString3.append("checkFileMode delta mode error , id = ");
    paramString3.append(paramString1);
    paramString2.c("VasUpdate_BaseItemTask", paramString3.toString());
    return new Pair(null, Integer.valueOf(16));
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 != 0)
    {
      localObject1 = VasUpdateWrapper.getLog();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("selfNotifyCompleted fail itemId = ");
      ((StringBuilder)localObject2).append(this.c.mItemId);
      ((StringBuilder)localObject2).append(" , nUpdateErrorCode = ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" , nHttpCode = ");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(" , message = ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" retryCount = ");
      ((StringBuilder)localObject2).append(this.b.mRunCount);
      ((IVasLog)localObject1).c("VasUpdate_BaseItemTask", ((StringBuilder)localObject2).toString());
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
      ((StringBuilder)localObject2).append(this.b.mRunCount);
      ((IVasLog)localObject1).b("VasUpdate_BaseItemTask", ((StringBuilder)localObject2).toString());
    }
    DLReportInfo localDLReportInfo = new DLReportInfo();
    Object localObject1 = this.e;
    boolean bool = true;
    if ((localObject1 == null) || (((UpdateUrlInfoPtr)localObject1).mDeltaMode != 1)) {
      bool = false;
    }
    localDLReportInfo.mIsIncrement = bool;
    localDLReportInfo.mRetryCount = this.b.mRunCount;
    localObject1 = this.e;
    Object localObject2 = "";
    if (localObject1 != null) {
      localObject1 = ((UpdateUrlInfoPtr)localObject1).mSrcMd5;
    } else {
      localObject1 = "";
    }
    localDLReportInfo.mSrcMd5 = ((String)localObject1);
    UpdateUrlInfoPtr localUpdateUrlInfoPtr = this.e;
    localObject1 = localObject2;
    if (localUpdateUrlInfoPtr != null) {
      localObject1 = localUpdateUrlInfoPtr.mDstMd5;
    }
    localDLReportInfo.mDstMd5 = ((String)localObject1);
    b(paramInt1);
    localObject1 = new DownloadResultParams();
    ((DownloadResultParams)localObject1).a = this.f;
    ((DownloadResultParams)localObject1).b = paramInt1;
    ((DownloadResultParams)localObject1).c = paramInt2;
    ((DownloadResultParams)localObject1).d = paramString;
    VasUpdateWrapper.getVasUpdateSystem().a(this.c, (DownloadResultParams)localObject1, localDLReportInfo);
  }
  
  private void a(@NonNull UpdateUrlInfoPtr paramUpdateUrlInfoPtr)
  {
    this.e = paramUpdateUrlInfoPtr;
    Object localObject1 = VasUpdateWrapper.getVasUpdateSystem().a(paramUpdateUrlInfoPtr.mBid);
    Object localObject2;
    if (VasUpdateWrapper.getLog().a())
    {
      localObject2 = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetUrlSuccess  bid = ");
      localStringBuilder.append(paramUpdateUrlInfoPtr.mBid);
      localStringBuilder.append(" , scid = ");
      localStringBuilder.append(paramUpdateUrlInfoPtr.mScid);
      localStringBuilder.append(" savePath = ");
      localStringBuilder.append(e());
      ((IVasLog)localObject2).b("VasUpdate_BaseItemTask", localStringBuilder.toString());
    }
    if (localObject1 == null) {
      return;
    }
    if ((((IBusinessCallback)localObject1).isFileExist(this.c, this.d)) && (b(paramUpdateUrlInfoPtr.mDstMd5)))
    {
      localObject1 = VasUpdateWrapper.getLog();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleGetUrlSuccess  up-to-date , itemId = ");
      ((StringBuilder)localObject2).append(paramUpdateUrlInfoPtr.mItemId);
      ((IVasLog)localObject1).c("VasUpdate_BaseItemTask", ((StringBuilder)localObject2).toString());
      c(this.c.mItemId);
      a(0, 0, "");
      return;
    }
    if (b(paramUpdateUrlInfoPtr)) {
      return;
    }
    if (!TextUtils.isEmpty(paramUpdateUrlInfoPtr.mFileContent))
    {
      if (FileUtil.removeFile(paramUpdateUrlInfoPtr.mFileContent, c()))
      {
        notifyDownloadComplete(paramUpdateUrlInfoPtr.mItemId, 0, 0, "file content success");
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("temp file move error , file = ");
      ((StringBuilder)localObject1).append(paramUpdateUrlInfoPtr.mFileContent);
      a(12, 0, ((StringBuilder)localObject1).toString());
      return;
    }
    VasUpdateWrapper.getVasUpdateSystem().b().a(this.c.mItemId, paramUpdateUrlInfoPtr.mUrl, this.c.mFrom, c(), this);
  }
  
  private Pair<String, Integer> b(String paramString1, String paramString2)
  {
    Object localObject2 = f();
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (((String)localObject2).equalsIgnoreCase(e()))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(".copy");
        localObject1 = ((StringBuilder)localObject1).toString();
        if (!VasUpdateWrapper.getCommonManager().b(e(), (String)localObject1))
        {
          paramString2 = VasUpdateWrapper.getLog();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("checkFileMode copyFile fail , id = ");
          ((StringBuilder)localObject1).append(paramString1);
          paramString2.c("VasUpdate_BaseItemTask", ((StringBuilder)localObject1).toString());
          return new Pair(null, Integer.valueOf(22));
        }
        localObject2 = VasUpdateWrapper.getLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkFileMode copyFile success sgeFile = ");
        localStringBuilder.append((String)localObject1);
        ((IVasLog)localObject2).c("VasUpdate_BaseItemTask", localStringBuilder.toString());
      }
    }
    if (c(paramString1, paramString2, (String)localObject1)) {
      return new Pair(null, Integer.valueOf(15));
    }
    return new Pair(localObject1, Integer.valueOf(0));
  }
  
  private void b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 10) {
        return;
      }
      if (paramInt == 24)
      {
        VasUpdateWrapper.getVasUpdateSystem().b(this.c);
        return;
      }
      this.b.mLastRunTime = (System.currentTimeMillis() / 1000L);
      Object localObject1 = this.b;
      ((ItemUpdateVerPtr)localObject1).mRunCount += 1;
      Object localObject2 = this.b;
      localObject1 = this.e;
      if (localObject1 != null) {
        localObject1 = ((UpdateUrlInfoPtr)localObject1).mAppVersion;
      } else {
        localObject1 = ((ItemUpdateVerPtr)localObject2).mAppVersion;
      }
      ((ItemUpdateVerPtr)localObject2).mAppVersion = ((String)localObject1);
      localObject1 = VasUpdateWrapper.getLog();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("selfNotifyCompleted fail localData = ");
      ((StringBuilder)localObject2).append(this.b.toString());
      ((StringBuilder)localObject2).append(" mDLFrom = ");
      ((StringBuilder)localObject2).append(this.f);
      ((IVasLog)localObject1).c("VasUpdate_BaseItemTask", ((StringBuilder)localObject2).toString());
      if (this.f != 3) {
        VasUpdateWrapper.getDbManager().a(1, this.b.mItemId, ItemUpdateVerPtr.convertItemUpdateVerPrtToJson(this.b));
      }
    }
  }
  
  private boolean b(@NonNull UpdateUrlInfoPtr paramUpdateUrlInfoPtr)
  {
    int i = paramUpdateUrlInfoPtr.mCode;
    if (i != -20002)
    {
      if (i != 0)
      {
        if (i != 1)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("update response code error , code = ");
          localStringBuilder.append(paramUpdateUrlInfoPtr.mCode);
          a(4, 0, localStringBuilder.toString());
          return true;
        }
        a(10, 0, "update limit code = 1");
        return true;
      }
      return false;
    }
    a(24, 0, "resources empty limit getUrl = -20002");
    return true;
  }
  
  private boolean b(@NonNull String paramString)
  {
    ItemLocalFileMd5 localItemLocalFileMd5 = ItemLocalFileMd5.parseJsonToItemLocalFileMd5(VasUpdateWrapper.getDbManager().a(2, this.c.mItemId));
    if (localItemLocalFileMd5 != null)
    {
      if (!paramString.equalsIgnoreCase(localItemLocalFileMd5.mOriginMd5)) {
        return false;
      }
      Object localObject = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkFileValid local : ");
      localStringBuilder.append(localItemLocalFileMd5.toString());
      ((IVasLog)localObject).b("VasUpdate_BaseItemTask", localStringBuilder.toString());
      localObject = new File(e());
      if ((((File)localObject).lastModified() != 0L) && (localItemLocalFileMd5.mLastFileModified != 0L) && (((File)localObject).lastModified() != localItemLocalFileMd5.mLastFileModified))
      {
        VasUpdateWrapper.getLog().c("VasUpdate_BaseItemTask", "checkFileValid file has modified");
        return false;
      }
      if (this.d.mIsCanPatch)
      {
        if (!new File(f()).exists())
        {
          VasUpdateWrapper.getLog().c("VasUpdate_BaseItemTask", "checkFileValid sge doesn't exist");
          return false;
        }
        if (!paramString.equalsIgnoreCase(VasUpdateWrapper.getCommonManager().a(f())))
        {
          VasUpdateWrapper.getLog().c("VasUpdate_BaseItemTask", "checkFileValid sge invalid");
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean b(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3))
    {
      paramString2 = VasUpdateWrapper.getLog();
      paramString3 = new StringBuilder();
      paramString3.append("checkFileMode storage compress error path = null , itemId = ");
      paramString3.append(paramString1);
      paramString2.c("VasUpdate_BaseItemTask", paramString3.toString());
      return true;
    }
    if (!this.d.mIsCanPatch) {
      FileUtil.deleteFile(paramString2);
    }
    return false;
  }
  
  private String c()
  {
    this.a = d();
    FileUtil.checkFilePathExist(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.c.mItemId);
    localStringBuilder.append(".tmp");
    this.a = localStringBuilder.toString();
    return this.a;
  }
  
  private void c(String paramString)
  {
    this.b.mAppVersion = this.e.mAppVersion;
    this.b.mSrcMd5 = this.e.mDstMd5;
    if (this.b.checkItemIsCurrentVersion())
    {
      VasUpdateWrapper.getDbManager().b(1, paramString);
      return;
    }
    VasUpdateWrapper.getDbManager().a(1, paramString, ItemUpdateVerPtr.convertItemUpdateVerPrtToJson(this.b));
  }
  
  private boolean c(String paramString1, String paramString2)
  {
    if ((!this.d.mSaveInDir) && (!TextUtils.isEmpty(paramString2)) && (!paramString2.equalsIgnoreCase(e())) && (!FileUtil.removeFile(paramString2, e())))
    {
      paramString2 = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkFileMode move file fail , id = ");
      localStringBuilder.append(paramString1);
      paramString2.c("VasUpdate_BaseItemTask", localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  private boolean c(String paramString1, String paramString2, String paramString3)
  {
    if (!VasUpdateWrapper.getCommonManager().a(paramString3, paramString2))
    {
      paramString2 = VasUpdateWrapper.getLog();
      paramString3 = new StringBuilder();
      paramString3.append("checkFileMode filePatch fail , id = ");
      paramString3.append(paramString1);
      paramString2.c("VasUpdate_BaseItemTask", paramString3.toString());
      return true;
    }
    IVasLog localIVasLog = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkFileMode file patch success, id = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" sgeFile = ");
    localStringBuilder.append(paramString3);
    localIVasLog.b("VasUpdate_BaseItemTask", localStringBuilder.toString());
    FileUtil.deleteFile(paramString2);
    return false;
  }
  
  private String d()
  {
    String str = e();
    if (TextUtils.isEmpty(str))
    {
      localObject = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSaveFilePathDir path = null , itemId = ");
      localStringBuilder.append(this.c.mItemId);
      ((IVasLog)localObject).c("VasUpdate_BaseItemTask", localStringBuilder.toString());
    }
    Object localObject = str;
    if (!this.d.mSaveInDir)
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
  
  private void d(String paramString)
  {
    File localFile = new File(e());
    if (localFile.exists())
    {
      ItemLocalFileMd5 localItemLocalFileMd5 = new ItemLocalFileMd5();
      localItemLocalFileMd5.mItemId = paramString;
      localItemLocalFileMd5.mLastFileModified = localFile.lastModified();
      localItemLocalFileMd5.mOriginMd5 = this.e.mDstMd5;
      VasUpdateWrapper.getDbManager().a(2, paramString, ItemLocalFileMd5.convertItemLocalFileMd5ToJson(localItemLocalFileMd5));
    }
  }
  
  private boolean d(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3))
    {
      paramString2 = VasUpdateWrapper.getLog();
      paramString3 = new StringBuilder();
      paramString3.append("checkFileMode compress error path = null , itemId = ");
      paramString3.append(paramString1);
      paramString2.c("VasUpdate_BaseItemTask", paramString3.toString());
      return true;
    }
    FileUtil.deleteFile(paramString2);
    paramString2 = VasUpdateWrapper.getLog();
    paramString3 = new StringBuilder();
    paramString3.append("uncompress success id = ");
    paramString3.append(paramString1);
    paramString2.b("VasUpdate_BaseItemTask", paramString3.toString());
    return false;
  }
  
  private String e()
  {
    return this.d.mSavePath;
  }
  
  private boolean e(String paramString)
  {
    if (VasUpdateWrapper.getLog().a())
    {
      localObject = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkFileMode mSaveInDir = ");
      localStringBuilder.append(this.d.mSaveInDir);
      localStringBuilder.append(" , storageMode = ");
      localStringBuilder.append(this.e.mStorageMode);
      localStringBuilder.append(" mIsCanPatch = ");
      localStringBuilder.append(this.d.mIsCanPatch);
      localStringBuilder.append(" savePath = ");
      localStringBuilder.append(e());
      ((IVasLog)localObject).b("VasUpdate_BaseItemTask", localStringBuilder.toString());
    }
    Object localObject = this.e;
    if ((localObject != null) && (!TextUtils.isEmpty(((UpdateUrlInfoPtr)localObject).mDstMd5)))
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (this.e.mDstMd5.equalsIgnoreCase(VasUpdateWrapper.getCommonManager().a(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  private String f()
  {
    String str = e();
    Object localObject = str;
    if (this.d.mSaveInDir)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.c.mItemId);
      ((StringBuilder)localObject).append(".sge");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public int a(@NonNull UpdateUrlInfoPtr paramUpdateUrlInfoPtr, String paramString1, String paramString2)
  {
    Object localObject = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start checkFileMode itemId = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" ; tempFile = ");
    localStringBuilder.append(paramString2);
    ((IVasLog)localObject).b("VasUpdate_BaseItemTask", localStringBuilder.toString());
    localObject = paramString2;
    if (paramUpdateUrlInfoPtr.mCompressMode != 0)
    {
      localObject = VasUpdateWrapper.getLog();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkFileMode handle compressMode , mode = ");
      localStringBuilder.append(paramUpdateUrlInfoPtr.mCompressMode);
      ((IVasLog)localObject).b("VasUpdate_BaseItemTask", localStringBuilder.toString());
      localObject = VasUpdateWrapper.getCommonManager().a(paramUpdateUrlInfoPtr.mCompressMode, paramString2);
      if (d(paramString1, paramString2, (String)localObject)) {
        return 13;
      }
    }
    paramString2 = VasUpdateWrapper.getLog();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkFileMode id = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" mDeltaMode = ");
    localStringBuilder.append(paramUpdateUrlInfoPtr.mDeltaMode);
    paramString2.b("VasUpdate_BaseItemTask", localStringBuilder.toString());
    paramString2 = a(paramString1, (String)localObject, (String)localObject);
    if ((paramString2.second != null) && (((Integer)paramString2.second).intValue() != 0)) {
      return ((Integer)paramString2.second).intValue();
    }
    paramString2 = (String)paramString2.first;
    if (!e(paramString2))
    {
      paramUpdateUrlInfoPtr = VasUpdateWrapper.getLog();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkFileMode checkFileMd5 error , id = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" returnFile = ");
      ((StringBuilder)localObject).append(paramString2);
      paramUpdateUrlInfoPtr.c("VasUpdate_BaseItemTask", ((StringBuilder)localObject).toString());
      FileUtil.deleteFile(paramString2);
      return 17;
    }
    if ((this.d.mSaveInDir) && (paramUpdateUrlInfoPtr.mStorageMode != 0))
    {
      localObject = VasUpdateWrapper.getCommonManager().a(paramUpdateUrlInfoPtr.mStorageMode, paramString2);
      paramUpdateUrlInfoPtr = (UpdateUrlInfoPtr)localObject;
      if (b(paramString1, paramString2, (String)localObject)) {
        return 13;
      }
    }
    else
    {
      paramUpdateUrlInfoPtr = paramString2;
    }
    if (c(paramString1, paramUpdateUrlInfoPtr)) {
      return 12;
    }
    return 0;
  }
  
  public ItemUpdateVerPtr a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(int paramInt, @NonNull UpdateUrlInfoPtr paramUpdateUrlInfoPtr)
  {
    if (paramInt == 0)
    {
      a(paramUpdateUrlInfoPtr);
      return;
    }
    a(4, 0, "task handleGetUrlRsp result != 0");
  }
  
  public boolean a(String paramString)
  {
    IBusinessCallback localIBusinessCallback = VasUpdateWrapper.getVasUpdateSystem().a(this.c.mBid);
    VasUpdateWrapper.getLog().b("VasUpdate_BaseItemTask", "checkSrcFileIsNeedReDownload");
    if (localIBusinessCallback != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return true;
      }
      if (!localIBusinessCallback.isFileExist(this.c, this.d)) {
        return true;
      }
      if (b(paramString)) {
        return false;
      }
      try
      {
        new File(e()).delete();
        new File(f()).delete();
        localIBusinessCallback.deleteFile(this.c, this.d);
        return true;
      }
      catch (Throwable paramString)
      {
        VasUpdateWrapper.getLog().a("VasUpdate_BaseItemTask", "checkFileValid exception", paramString);
        paramString.printStackTrace();
      }
    }
    return true;
  }
  
  public void b()
  {
    a(2, 0, "send get url pb error");
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
    ((IVasLog)localObject).b("VasUpdate_BaseItemTask", localStringBuilder.toString());
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
      a(paramInt1, paramInt2, (String)localObject);
      return;
    }
    paramString2 = this.e;
    if (paramString2 == null) {
      paramInt1 = 999;
    } else {
      paramInt1 = a(paramString2, paramString1, c());
    }
    if (paramInt1 != 0)
    {
      paramString2 = new StringBuilder();
      paramString2.append("checkFileMode error itemId = ");
      paramString2.append(paramString1);
      paramString2.append(" fileModeRes = ");
      paramString2.append(paramInt1);
      a(paramInt1, paramInt2, paramString2.toString());
      return;
    }
    paramString2 = new ItemLocalVerPrt();
    paramString2.mItemId = this.b.mItemId;
    paramString2.mMd5 = this.e.mDstMd5;
    VasUpdateWrapper.getDbManager().a(0, paramString2.mItemId, ItemLocalVerPrt.convertItemLocalVerPrtToJson(paramString2));
    c(this.b.mItemId);
    d(paramString1);
    a(0, paramInt2, "");
  }
  
  public void notifyDownloadProgress(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    if ((VasUpdateWrapper.getLog().a()) && (paramInt == 100))
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
      localIVasLog.b("VasUpdate_BaseItemTask", localStringBuilder.toString());
    }
    VasUpdateWrapper.getVasUpdateSystem().a(this.c, paramLong1, paramLong2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.task.DownloadItemTask
 * JD-Core Version:    0.7.0.1
 */