package com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class TroopFileViewerAdapter
  extends EntityFileViewerAdapter
{
  QQAppInterface d;
  public TroopFileStatusInfo e;
  
  public TroopFileViewerAdapter(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramFileManagerEntity);
    this.d = paramQQAppInterface;
    this.a = FileManagerUtil.a(paramQQAppInterface.getApplication().getBaseContext(), paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize);
    boolean bool1 = paramFileManagerEntity.isZipInnerFile;
    boolean bool2 = false;
    if ((bool1) && (FileManagerUtil.a(paramQQAppInterface, this, true))) {
      this.a = false;
    }
    this.e = TroopFileUtils.a(paramQQAppInterface, paramFileManagerEntity);
    if ((this.e.e == 2) || (this.e.e == 3))
    {
      boolean bool3 = FileManagerUtil.a(this);
      if (m() == 3)
      {
        bool1 = bool2;
        if (this.a)
        {
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
        this.a = bool1;
      }
    }
  }
  
  public int m()
  {
    if (FileUtil.b(super.o())) {
      return 3;
    }
    return super.m();
  }
  
  public int n()
  {
    if ((m() == 6) && (q() == 31)) {
      return super.n();
    }
    TroopFileStatusInfo localTroopFileStatusInfo = this.e;
    if (localTroopFileStatusInfo != null) {
      return localTroopFileStatusInfo.e;
    }
    return 0;
  }
  
  public String t()
  {
    Object localObject2 = FileUtil.a(super.c());
    Object localObject1 = localObject2;
    if (104 == super.r().busId)
    {
      localObject1 = localObject2;
      if (super.r().lastTime > 0L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(BaseApplicationImpl.getContext().getString(2131889334));
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(TroopFileUtils.a(BaseApplicationImpl.getContext(), super.r().lastTime));
        localObject1 = ((StringBuilder)localObject2).toString();
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.TroopFileViewerAdapter
 * JD-Core Version:    0.7.0.1
 */