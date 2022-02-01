package com.tencent.mobileqq.filemanager.util;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

final class QQFileManagerUtilImpl$15
  implements Runnable
{
  QQFileManagerUtilImpl$15(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).insertAIOGrayTips(this.a, this.b.peerUin, this.a.getCurrentAccountUin(), this.b.peerType, -3014, BaseApplication.getContext().getString(2131889618));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.15
 * JD-Core Version:    0.7.0.1
 */