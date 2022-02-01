package com.tencent.mobileqq.util;

import android.content.Intent;
import com.tencent.av.config.ByteBuffer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

final class ProfileCardUtil$1
  implements Runnable
{
  ProfileCardUtil$1(String paramString, Intent paramIntent, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = new CompressInfo(this.jdField_a_of_type_JavaLangString, 0);
    ((CompressInfo)localObject).f = 0;
    CompressOperator.a((CompressInfo)localObject);
    String str = "";
    boolean bool;
    int i;
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("PhotoConst.SYNCQZONE", false);
      str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("PhotoConst.SOURCE_FROM");
      if ("FROM_SELECT_PHOTO".equals(str)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.upload_local_photo", 2, ".uploadPhoto(), img_path = " + ((CompressInfo)localObject).e + ",isSyncQZone=" + bool);
      }
      TransferRequest localTransferRequest;
      if (!StringUtil.a(((CompressInfo)localObject).e))
      {
        localTransferRequest = new TransferRequest();
        localTransferRequest.mIsUp = true;
        localTransferRequest.mLocalPath = ((CompressInfo)localObject).e;
        localTransferRequest.mFileType = 22;
        localObject = new ByteBuffer();
        if (!bool) {
          break label320;
        }
      }
      label320:
      for (byte b = 1;; b = 0)
      {
        ((ByteBuffer)localObject).a(b);
        localTransferRequest.mExtentionInfo = ((ByteBuffer)localObject).a();
        localTransferRequest.mUpCallBack = new ProfileCardUtil.1.1(this, bool, str);
        ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
        if (bool)
        {
          int j = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.SYNCQZONE_CHECKSTATE", 1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C16", "0X8007C16", j, 0, "", "", "", "");
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C17", "0X8007C17", i, 0, "", "", "", "");
        return;
        if ("FROM_TAKE_PHOTO".equals(str))
        {
          i = 2;
          break;
        }
        i = 3;
        break;
      }
      i = 3;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.1
 * JD-Core Version:    0.7.0.1
 */