package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper;

class QfileBaseLocalFileTabView$7$2
  implements Runnable
{
  QfileBaseLocalFileTabView$7$2(QfileBaseLocalFileTabView.7 param7, boolean paramBoolean, long paramLong, int paramInt, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileBaseLocalFileTabView$7.a.f();
    if (!this.jdField_a_of_type_Boolean)
    {
      QQFileManagerUtil.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      ((IOpenWeiyunVipHelper)QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileBaseLocalFileTabView$7.a.a, this.jdField_a_of_type_Int);
      return;
    }
    QQFileManagerUtil.a(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.2
 * JD-Core Version:    0.7.0.1
 */