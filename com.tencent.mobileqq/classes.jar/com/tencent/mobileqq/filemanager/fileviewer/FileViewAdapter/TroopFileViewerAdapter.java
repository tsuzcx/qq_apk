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
  QQAppInterface a;
  public TroopFileStatusInfo a;
  
  public TroopFileViewerAdapter(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = FileManagerUtil.a(paramQQAppInterface.getApplication().getBaseContext(), paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize);
    boolean bool1 = paramFileManagerEntity.isZipInnerFile;
    boolean bool2 = false;
    if ((bool1) && (FileManagerUtil.a(paramQQAppInterface, this, true))) {
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo = TroopFileUtils.a(paramQQAppInterface, paramFileManagerEntity);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.b == 2) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.b == 3))
    {
      boolean bool3 = FileManagerUtil.a(this);
      if (c() == 3)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
        this.jdField_a_of_type_Boolean = bool1;
      }
    }
  }
  
  public int c()
  {
    if (FileUtil.a(super.g())) {
      return 3;
    }
    return super.c();
  }
  
  public int d()
  {
    if ((c() == 6) && (e() == 31)) {
      return super.d();
    }
    TroopFileStatusInfo localTroopFileStatusInfo = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo;
    if (localTroopFileStatusInfo != null) {
      return localTroopFileStatusInfo.b;
    }
    return 0;
  }
  
  public String i()
  {
    Object localObject2 = FileUtil.a(super.b());
    Object localObject1 = localObject2;
    if (104 == super.a().busId)
    {
      localObject1 = localObject2;
      if (super.a().lastTime > 0L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(BaseApplicationImpl.getContext().getString(2131692346));
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(TroopFileUtils.a(BaseApplicationImpl.getContext(), super.a().lastTime));
        localObject1 = ((StringBuilder)localObject2).toString();
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.TroopFileViewerAdapter
 * JD-Core Version:    0.7.0.1
 */