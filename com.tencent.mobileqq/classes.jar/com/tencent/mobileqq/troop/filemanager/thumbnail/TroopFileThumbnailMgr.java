package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.UUID;

public class TroopFileThumbnailMgr
{
  private static TroopFileThumbnailMgr a;
  private TroopFileThumbnailGenMgr b = new TroopFileThumbnailGenMgr();
  private TroopFileThumbnailFetchMgr c = new TroopFileThumbnailFetchMgr();
  
  public static TroopFileThumbnailMgr a()
  {
    try
    {
      if (a == null) {
        a = new TroopFileThumbnailMgr();
      }
      TroopFileThumbnailMgr localTroopFileThumbnailMgr = a;
      return localTroopFileThumbnailMgr;
    }
    finally {}
  }
  
  public static final void a(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    if (paramItem == null) {
      return;
    }
    if (paramInt == 128)
    {
      paramItem.ThumbnailDownloading_Small = true;
      paramItem.ThumbnailFileTimeMS_Small = SystemClock.uptimeMillis();
    }
    else if (paramInt == 640)
    {
      paramItem.ThumbnailDownloading_Large = true;
      paramItem.ThumbnailFileTimeMS_Large = SystemClock.uptimeMillis();
    }
    else if (paramInt == 383)
    {
      paramItem.ThumbnailDownloading_Middle = true;
      paramItem.ThumbnailFileTimeMS_Middle = SystemClock.uptimeMillis();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramItem.Id != null) {
      paramItem = paramItem.Id.toString();
    } else {
      paramItem = "";
    }
    localStringBuilder.append(paramItem);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    paramItem = localStringBuilder.toString();
    paramInt = TroopFileTransferUtil.Log.b;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramItem);
    localStringBuilder.append("] setGettingStatus. ");
    TroopFileTransferUtil.Log.c("TroopFileThumbnailMgr", paramInt, localStringBuilder.toString());
  }
  
  public static final boolean a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    int i = 0;
    if (bool1) {
      return false;
    }
    bool1 = true;
    boolean bool2;
    if (paramInt == 128)
    {
      if (FileUtils.fileExistsAndNotEmpty(paramString))
      {
        bool2 = paramItem.HasThumbnailFile_Small;
        paramItem.HasThumbnailFile_Small = true;
        if (!paramString.equalsIgnoreCase(paramItem.smallThumbFile)) {
          paramInt = 1;
        } else {
          paramInt = bool2 ^ true;
        }
        paramItem.smallThumbFile = paramString;
        paramItem.ThumbnailFileTimeMS_Small = 0L;
        break label210;
      }
    }
    else if (paramInt == 640)
    {
      if (FileUtils.fileExistsAndNotEmpty(paramString))
      {
        bool2 = paramItem.HasThumbnailFile_Large;
        paramItem.HasThumbnailFile_Large = true;
        if (!paramString.equalsIgnoreCase(paramItem.largeThumbnailFile)) {
          paramInt = 1;
        } else {
          paramInt = bool2 ^ true;
        }
        paramItem.largeThumbnailFile = paramString;
        paramItem.ThumbnailFileTimeMS_Large = 0L;
        break label210;
      }
    }
    else if ((paramInt == 383) && (FileUtils.fileExistsAndNotEmpty(paramString)))
    {
      paramInt = paramItem.HasThumbnailFile_Middle ^ true;
      paramItem.HasThumbnailFile_Middle = true;
      if (!paramString.equalsIgnoreCase(paramItem.middleThumbnailFile)) {
        paramInt = 1;
      }
      paramItem.middleThumbnailFile = paramString;
      paramItem.ThumbnailFileTimeMS_Middle = 0L;
      paramItem.ThumbnailDownloading_Middle_Fail = false;
      break label210;
    }
    bool1 = false;
    paramInt = i;
    label210:
    if (paramInt != 0) {
      TroopFileDataCenter.a(paramLong, paramItem);
    }
    return bool1;
  }
  
  public static final void b(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    if (paramItem == null) {
      return;
    }
    if (paramInt == 128) {
      paramItem.ThumbnailDownloading_Small = false;
    } else if (paramInt == 640) {
      paramItem.ThumbnailDownloading_Large = false;
    } else if (paramInt == 383) {
      paramItem.ThumbnailDownloading_Middle = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramItem.Id != null) {
      paramItem = paramItem.Id.toString();
    } else {
      paramItem = "";
    }
    localStringBuilder.append(paramItem);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    paramItem = localStringBuilder.toString();
    paramInt = TroopFileTransferUtil.Log.b;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramItem);
    localStringBuilder.append("] setStopGetStatus. ");
    TroopFileTransferUtil.Log.c("TroopFileThumbnailMgr", paramInt, localStringBuilder.toString());
  }
  
  public static final boolean b(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    if (paramLong != 0L)
    {
      if (paramItem == null) {
        return false;
      }
      if (a(paramLong, paramItem, paramInt, paramItem.getThumbnailFile(paramLong, paramInt))) {
        return true;
      }
    }
    return false;
  }
  
  private void c(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    String str = paramItem.getThumbnailFile(paramLong, 640);
    if (paramItem.LocalFile != null)
    {
      VFSFile localVFSFile = new VFSFile(paramItem.LocalFile);
      if (localVFSFile.exists())
      {
        int j = 0;
        int i = j;
        if (paramItem.origLastModifyTime != 0L)
        {
          long l = localVFSFile.lastModified();
          i = j;
          if (paramItem.origLastModifyTime != l)
          {
            i = j;
            if (TextUtils.isEmpty(paramItem.FilePath))
            {
              i = j;
              if (this.c.a(paramLong, paramItem, paramInt) == 0) {
                i = 1;
              }
            }
          }
        }
        if (i != 0) {
          return;
        }
        this.b.a(paramLong, paramItem, paramInt, null);
        return;
      }
    }
    if ((paramInt == 383) && (FileUtil.b(str)))
    {
      this.b.a(paramLong, paramItem, paramInt, str);
      return;
    }
    this.c.a(paramLong, paramItem, paramInt);
  }
  
  public static final String d()
  {
    String str = AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH;
    VFSFile localVFSFile = new VFSFile(str);
    if (!localVFSFile.exists()) {
      localVFSFile.mkdirs();
    }
    return str;
  }
  
  public void a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    if (paramLong != 0L)
    {
      if (paramItem == null) {
        return;
      }
      if (paramItem.Id == null) {
        return;
      }
      if (paramInt == 0) {
        return;
      }
      if (!paramItem.canFetchThumbnailFile(paramInt))
      {
        if ((paramInt == 383) && (paramItem.genThumb_Middle_OnGettedLargeOrOrigPic))
        {
          paramItem.genThumb_Middle_OnGettedLargeOrOrigPic = false;
          TroopFileTransferMgr.a(new TroopFileThumbnailMgr.2(this, paramItem, paramLong, paramInt), false);
        }
        return;
      }
      if (b(paramLong, paramItem, paramInt))
      {
        paramItem.StatusUpdateTimeMs = 0L;
        TroopFileDataCenter.b(paramLong, paramItem);
        return;
      }
      TroopFileTransferMgr.a(new TroopFileThumbnailMgr.3(this, paramLong, paramItem, paramInt), false);
    }
  }
  
  public void b()
  {
    TroopFileTransferUtil.Log.c("TroopFileThumbnailMgr", TroopFileTransferUtil.Log.b, "init");
    this.b.a();
    this.c.a();
  }
  
  public void c()
  {
    TroopFileTransferUtil.Log.c("TroopFileThumbnailMgr", TroopFileTransferUtil.Log.b, "release");
    if (Build.VERSION.SDK_INT == 19)
    {
      this.b.b();
      this.c.b();
      return;
    }
    TroopFileTransferMgr.a(new TroopFileThumbnailMgr.1(this), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr
 * JD-Core Version:    0.7.0.1
 */