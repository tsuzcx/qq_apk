package com.tencent.mobileqq.filemanager.openbrowser;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import mqq.app.MobileQQ;

public class TroopFileBrowserData
  extends EntityFileBrowserData
{
  private TroopFileStatusInfo c;
  
  public TroopFileBrowserData(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramFileManagerEntity);
    boolean bool1 = paramFileManagerEntity.isZipInnerFile;
    boolean bool2 = true;
    if ((bool1) && (FileUtil.b(paramFileManagerEntity.getFilePath()))) {
      paramFileManagerEntity.status = 1;
    }
    if ((paramFileManagerEntity.isZipInnerFile) && (FileManagerUtil.a(paramQQAppInterface, paramFileManagerEntity.fileName, paramFileManagerEntity.status, true))) {
      this.b = false;
    } else {
      this.b = FileManagerUtil.a(paramQQAppInterface.getApplication().getBaseContext(), paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize);
    }
    if (!this.b) {
      return;
    }
    this.c = TroopFileUtils.a(paramQQAppInterface, paramFileManagerEntity);
    if ((this.c.e == 2) || (this.c.e == 3))
    {
      int i;
      if (FileUtil.b(paramFileManagerEntity.getFilePath())) {
        i = 3;
      } else {
        i = paramFileManagerEntity.getCloudType();
      }
      if (i != 3) {
        return;
      }
      if (paramFileManagerEntity.status == 1)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramFileManagerEntity.Uuid)) {
          break label195;
        }
        if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId))
        {
          bool1 = bool2;
          break label195;
        }
      }
      bool1 = false;
      label195:
      this.b = bool1;
    }
  }
  
  public int g()
  {
    if ((this.a.getCloudType() == 6) && (e() == 31)) {
      return super.g();
    }
    TroopFileStatusInfo localTroopFileStatusInfo = this.c;
    if (localTroopFileStatusInfo != null) {
      return localTroopFileStatusInfo.e;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.TroopFileBrowserData
 * JD-Core Version:    0.7.0.1
 */