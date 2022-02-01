package com.tencent.mobileqq.troop.filemanager;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.util.LogUtil;

public class TroopFileDataCenter
{
  static long a;
  private QQAppInterface b;
  private long c;
  private Map<UUID, TroopFileTransferManager.Item> d;
  private boolean e;
  
  @Deprecated
  private void a()
  {
    try
    {
      boolean bool = this.e;
      if (bool) {
        return;
      }
      Iterator localIterator = this.b.getProxyManager().f().a(this.c).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (TroopFileTansferItemEntity)localIterator.next();
        if ((((TroopFileTansferItemEntity)localObject2).Id != null) && ((TextUtils.isEmpty(((TroopFileTansferItemEntity)localObject2).FilePath)) || (((TroopFileTansferItemEntity)localObject2).FilePath.startsWith("/")) || (((TroopFileTansferItemEntity)localObject2).isZipInnerFile)))
        {
          localObject2 = new TroopFileTransferManager.Item((TroopFileTansferItemEntity)localObject2);
          int i = ((TroopFileTransferManager.Item)localObject2).Status;
          if ((i != 0) && (i != 1))
          {
            if (i == 8) {
              ((TroopFileTransferManager.Item)localObject2).Status = 10;
            }
          }
          else {
            ((TroopFileTransferManager.Item)localObject2).Status = 3;
          }
          this.d.put(((TroopFileTransferManager.Item)localObject2).Id, localObject2);
        }
      }
      ThreadManager.post(new TroopFileDataCenter.2(this), 8, null, true);
      this.e = true;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null) {
      return;
    }
    if (paramItem.troopuin == 0L)
    {
      int i = TroopFileTransferUtil.Log.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveStatus. item.troopuin=0, change to:");
      localStringBuilder.append(LogUtil.wrapLogUin(String.valueOf(paramLong)));
      TroopFileTransferUtil.Log.b("TroopFileDataCenter", i, localStringBuilder.toString());
      paramItem.troopuin = paramLong;
    }
    if (paramItem.troopuin == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileDataCenter", TroopFileTransferUtil.Log.b, "saveStatus. item.troopuin=0 err");
      return;
    }
    localQQAppInterface.getProxyManager().f().a(paramItem);
  }
  
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    a(paramLong, paramItem, paramInt, 0);
  }
  
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (paramItem.Status != paramInt1) {
      bool = true;
    } else {
      bool = false;
    }
    paramItem.IsNewStatus = bool;
    if (paramItem.IsNewStatus) {
      TroopFileDataReporter.a(paramLong, paramItem, paramInt1, paramInt2);
    }
    paramItem.Status = paramInt1;
    paramItem.ErrorCode = paramInt2;
    paramItem.Pausing = 0;
    if (paramItem.W2MPause == 1) {
      paramItem.W2MPause = 0;
    }
    a(paramLong, paramItem);
    paramItem.StatusUpdateTimeMs = 0L;
    b(paramLong, paramItem);
    paramItem.IsNewStatus = false;
    b(paramLong, paramItem, paramInt2);
  }
  
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, TroopFileError.SimpleErrorInfo paramSimpleErrorInfo)
  {
    boolean bool;
    if (paramItem.Status != paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    paramItem.IsNewStatus = bool;
    paramItem.Status = paramInt;
    paramItem.ErrorCode = paramSimpleErrorInfo.b;
    paramItem.Pausing = 0;
    if (paramItem.W2MPause == 1) {
      paramItem.W2MPause = 0;
    }
    a(paramLong, paramItem);
    paramItem.StatusUpdateTimeMs = 0L;
    b(paramLong, paramItem);
    paramItem.IsNewStatus = false;
    TroopFileError.a(TroopFileTransferUtil.a(), paramSimpleErrorInfo);
  }
  
  public static void b(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    long l1 = SystemClock.uptimeMillis() - a;
    long l2 = SystemClock.uptimeMillis() - paramItem.StatusUpdateTimeMs;
    if ((a == 0L) || (paramItem.StatusUpdateTimeMs == 0L) || (l2 > 5000L) || (l2 < 0L) || (l1 > 1000L) || (l1 < 0L))
    {
      a += l1;
      paramItem.StatusUpdateTimeMs += l2;
      QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
      if (localQQAppInterface != null) {
        ((TroopFileHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER)).a(paramItem.getInfo(paramLong));
      }
    }
  }
  
  public static void b(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    TroopFileError.a(TroopFileTransferUtil.a(), paramLong, paramItem.FileName, paramItem.Status, paramInt);
  }
  
  @Deprecated
  private boolean b()
  {
    try
    {
      Object localObject1 = this.d.values();
      localObject1 = ((Collection)localObject1).iterator();
      boolean bool1 = false;
      while (((Iterator)localObject1).hasNext())
      {
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)((Iterator)localObject1).next();
        if ((!localItem.ThumbnailDownloading_Small) && (!localItem.ThumbnailDownloading_Large) && (!localItem.ThumbnailDownloading_Middle))
        {
          int i = localItem.Status;
          boolean bool2;
          if ((i != 6) && (i != 11))
          {
            bool2 = bool1;
          }
          else
          {
            if (!TextUtils.isEmpty(localItem.LocalFile))
            {
              bool2 = bool1;
              if (new VFSFile(localItem.LocalFile).exists()) {
                break label156;
              }
              a(this.c, localItem, 7);
            }
            else
            {
              a(this.c, localItem, 7);
            }
            bool2 = true;
          }
          label156:
          if ((localItem.HasThumbnailFile_Small) && (!TroopFileThumbnailMgr.b(this.c, localItem, 128))) {}
          for (;;)
          {
            bool1 = true;
            break;
            if ((!localItem.HasThumbnailFile_Large) || (TroopFileThumbnailMgr.b(this.c, localItem, 640)))
            {
              bool1 = bool2;
              if (!localItem.HasThumbnailFile_Middle) {
                break;
              }
              bool1 = bool2;
              if (TroopFileThumbnailMgr.b(this.c, localItem, 383)) {
                break;
              }
            }
          }
        }
      }
      return bool1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter
 * JD-Core Version:    0.7.0.1
 */