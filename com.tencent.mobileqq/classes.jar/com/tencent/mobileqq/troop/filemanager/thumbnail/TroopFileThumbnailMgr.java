package com.tencent.mobileqq.troop.filemanager.thumbnail;

import ajmi;
import ajmj;
import ajmk;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.UUID;

public class TroopFileThumbnailMgr
{
  private static TroopFileThumbnailMgr jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailMgr;
  private TroopFileThumbnailFetchMgr jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailFetchMgr = new TroopFileThumbnailFetchMgr();
  private TroopFileThumbnailGenMgr jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenMgr = new TroopFileThumbnailGenMgr();
  
  public static TroopFileThumbnailMgr a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailMgr == null) {
        jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailMgr = new TroopFileThumbnailMgr();
      }
      TroopFileThumbnailMgr localTroopFileThumbnailMgr = jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailMgr;
      return localTroopFileThumbnailMgr;
    }
    finally {}
  }
  
  public static final String a()
  {
    String str = AppConstants.bb;
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  public static final void a(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    if (paramItem == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (paramInt == 128)
    {
      paramItem.ThumbnailDownloading_Small = true;
      paramItem.ThumbnailFileTimeMS_Small = SystemClock.uptimeMillis();
      localStringBuilder = new StringBuilder();
      if (paramItem.Id == null) {
        break label142;
      }
    }
    label142:
    for (paramItem = paramItem.Id.toString();; paramItem = "")
    {
      paramItem = paramItem + "_" + paramInt;
      TroopFileTransferUtil.Log.c("TroopFileThumbnailMgr", TroopFileTransferUtil.Log.a, "[" + paramItem + "] setGettingStatus. ");
      return;
      if (paramInt == 640)
      {
        paramItem.ThumbnailDownloading_Large = true;
        paramItem.ThumbnailFileTimeMS_Large = SystemClock.uptimeMillis();
        break;
      }
      if (paramInt != 383) {
        break;
      }
      paramItem.ThumbnailDownloading_Middle = true;
      paramItem.ThumbnailFileTimeMS_Middle = SystemClock.uptimeMillis();
      break;
    }
  }
  
  public static final boolean a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    if ((paramLong == 0L) || (paramItem == null)) {}
    while (!a(paramLong, paramItem, paramInt, paramItem.getThumbnailFile(paramLong, paramInt))) {
      return false;
    }
    return true;
  }
  
  public static final boolean a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, String paramString)
  {
    int i = 0;
    int j = 0;
    boolean bool3 = false;
    int k = 0;
    int m = 0;
    int n = 0;
    boolean bool2 = false;
    boolean bool4 = true;
    boolean bool1 = true;
    if (TextUtils.isEmpty(paramString)) {
      return bool2;
    }
    if (paramInt == 128)
    {
      if (!FileUtils.b(paramString)) {
        break label256;
      }
      paramInt = i;
      if (!paramItem.HasThumbnailFile_Small) {
        paramInt = 1;
      }
      paramItem.HasThumbnailFile_Small = true;
      if (!paramString.equalsIgnoreCase(paramItem.smallThumbFile)) {
        paramInt = 1;
      }
      paramItem.smallThumbFile = paramString;
      paramItem.ThumbnailFileTimeMS_Small = 0L;
    }
    for (;;)
    {
      bool2 = bool1;
      if (paramInt == 0) {
        break;
      }
      TroopFileDataCenter.a(paramLong, paramItem);
      return bool1;
      if (paramInt == 640)
      {
        if (!FileUtils.b(paramString)) {
          break label247;
        }
        paramInt = k;
        if (!paramItem.HasThumbnailFile_Large) {
          paramInt = 1;
        }
        paramItem.HasThumbnailFile_Large = true;
        if (!paramString.equalsIgnoreCase(paramItem.largeThumbnailFile)) {
          paramInt = 1;
        }
        paramItem.largeThumbnailFile = paramString;
        paramItem.ThumbnailFileTimeMS_Large = 0L;
        bool1 = bool4;
      }
      for (;;)
      {
        break;
        if ((paramInt == 383) && (FileUtils.b(paramString)))
        {
          paramInt = n;
          if (!paramItem.HasThumbnailFile_Middle) {
            paramInt = 1;
          }
          paramItem.HasThumbnailFile_Middle = true;
          if (!paramString.equalsIgnoreCase(paramItem.middleThumbnailFile)) {
            paramInt = 1;
          }
          paramItem.middleThumbnailFile = paramString;
          paramItem.ThumbnailFileTimeMS_Middle = 0L;
          bool1 = true;
          break;
        }
        paramInt = 0;
        bool1 = bool3;
        break;
        label247:
        bool1 = false;
        paramInt = m;
      }
      label256:
      bool1 = false;
      paramInt = j;
    }
  }
  
  private void b(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    String str = paramItem.getThumbnailFile(paramLong, 640);
    if (paramItem.LocalFile != null)
    {
      File localFile = new File(paramItem.LocalFile);
      if (localFile.exists())
      {
        int j = 0;
        int i = j;
        if (paramItem.origLastModifyTime != 0L)
        {
          long l = localFile.lastModified();
          i = j;
          if (paramItem.origLastModifyTime != l)
          {
            i = j;
            if (TextUtils.isEmpty(paramItem.FilePath))
            {
              i = j;
              if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailFetchMgr.a(paramLong, paramItem, paramInt) == 0) {
                i = 1;
              }
            }
          }
        }
        if (i == 0) {
          this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenMgr.a(paramLong, paramItem, paramInt, null);
        }
        return;
      }
    }
    if ((paramInt == 383) && (FileUtil.b(str)))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenMgr.a(paramLong, paramItem, paramInt, str);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailFetchMgr.a(paramLong, paramItem, paramInt);
  }
  
  public static final void b(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    if (paramItem == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (paramInt == 128)
    {
      paramItem.ThumbnailDownloading_Small = false;
      localStringBuilder = new StringBuilder();
      if (paramItem.Id == null) {
        break label121;
      }
    }
    label121:
    for (paramItem = paramItem.Id.toString();; paramItem = "")
    {
      paramItem = paramItem + "_" + paramInt;
      TroopFileTransferUtil.Log.c("TroopFileThumbnailMgr", TroopFileTransferUtil.Log.a, "[" + paramItem + "] setStopGetStatus. ");
      return;
      if (paramInt == 640)
      {
        paramItem.ThumbnailDownloading_Large = false;
        break;
      }
      if (paramInt != 383) {
        break;
      }
      paramItem.ThumbnailDownloading_Middle = false;
      break;
    }
  }
  
  public void a()
  {
    TroopFileTransferUtil.Log.c("TroopFileThumbnailMgr", TroopFileTransferUtil.Log.a, "init");
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenMgr.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailFetchMgr.a();
  }
  
  public void a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    if ((paramLong == 0L) || (paramItem == null)) {}
    do
    {
      do
      {
        return;
      } while ((paramItem.Id == null) || (paramInt == 0));
      if (paramItem.canFetchThumbnailFile(paramInt)) {
        break;
      }
    } while ((paramInt != 383) || (!paramItem.genThumb_Middle_OnGettedLargeOrOrigPic));
    paramItem.genThumb_Middle_OnGettedLargeOrOrigPic = false;
    TroopFileTransferMgr.a(new ajmj(this, paramItem, paramLong, paramInt), false);
    return;
    if (a(paramLong, paramItem, paramInt))
    {
      paramItem.StatusUpdateTimeMs = 0L;
      TroopFileDataCenter.b(paramLong, paramItem);
      return;
    }
    TroopFileTransferMgr.a(new ajmk(this, paramLong, paramItem, paramInt), false);
  }
  
  public void b()
  {
    TroopFileTransferUtil.Log.c("TroopFileThumbnailMgr", TroopFileTransferUtil.Log.a, "release");
    TroopFileTransferMgr.a(new ajmi(this), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr
 * JD-Core Version:    0.7.0.1
 */