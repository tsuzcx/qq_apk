package com.tencent.mobileqq.filemanager.fileviewer.data;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager.FileVideoManagerCallback;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.troop.data.TroopFileInfo.FileStatus;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import java.util.UUID;

public class VideoForTroop
  implements BaseVideoBiz
{
  protected QQAppInterface a;
  private TroopFileStatusInfo b;
  private UUID c;
  
  public VideoForTroop(QQAppInterface paramQQAppInterface, TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    this.b = paramTroopFileStatusInfo;
    this.c = this.b.a;
    if (this.c != null)
    {
      this.a = paramQQAppInterface;
      return;
    }
    throw new NullPointerException("TroopFileStatusInfo Id null");
  }
  
  public String a()
  {
    return this.b.r;
  }
  
  public void a(long paramLong)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.b.d);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "notifyProgress: get troopFileTransferManager failed.");
      return;
    }
    TroopFileTransferManager.Item localItem = localTroopFileTransferManager.i(this.b.a);
    if (localItem != null)
    {
      localItem.ProgressValue = paramLong;
      localTroopFileTransferManager.b(localItem, 8);
    }
  }
  
  public void a(FileVideoDownloadManager.FileVideoManagerCallback paramFileVideoManagerCallback)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.b.d);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "getUrl: get troopFileTransferManager failed.");
      return;
    }
    localTroopFileTransferManager.a(this.b.r, this.b.t, this.b.i, this.b.u, new VideoForTroop.1(this, paramFileVideoManagerCallback));
  }
  
  public void a(String paramString)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.b.d);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "notifySuccessed: get troopFileTransferManager failed.");
      return;
    }
    TroopFileTransferManager.Item localItem = localTroopFileTransferManager.i(this.b.a);
    if (localItem != null)
    {
      boolean bool = TroopFileInfo.FileStatus.b(localItem.Status);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notifySuccessed  itemStatus[");
        localStringBuilder.append(localItem.Status);
        localStringBuilder.append("]");
        QLog.e("VideoForTroop<QFile>", 1, localStringBuilder.toString());
      }
      if ((!bool) && (this.b.e != 7))
      {
        localTroopFileTransferManager.b(localItem, 6);
      }
      else
      {
        localItem.LocalFile = paramString;
        localTroopFileTransferManager.b(localItem, 11);
      }
    }
    FileVideoDownloadManager.a(this);
  }
  
  public void a(boolean paramBoolean)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.b.d);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "notifyFileFailed: get troopFileTransferManager failed.");
      return;
    }
    TroopFileTransferManager.Item localItem = localTroopFileTransferManager.i(this.b.a);
    if (localItem != null)
    {
      if (paramBoolean)
      {
        localTroopFileTransferManager.b(localItem, 12);
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notifyFileFaild isInvalid[");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("], itemStatus[");
        localStringBuilder.append(localItem.Status);
        localStringBuilder.append("]");
        QLog.e("VideoForTroop<QFile>", 1, localStringBuilder.toString());
      }
      if ((!TroopFileInfo.FileStatus.b(localItem.Status)) && (this.b.e != 7)) {
        localTroopFileTransferManager.b(localItem, 3);
      } else {
        localTroopFileTransferManager.b(localItem, 10);
      }
    }
    FileVideoDownloadManager.a(this);
  }
  
  public long b()
  {
    return this.b.i;
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FMSettings.a().getDefaultTmpPath());
    localStringBuilder.append(MD5.b(this.b.r));
    return localStringBuilder.toString();
  }
  
  public String d()
  {
    return this.b.t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.data.VideoForTroop
 * JD-Core Version:    0.7.0.1
 */