package com.tencent.mobileqq.nearby.profilecard;

import ayhd;
import azlg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class NearbyProfileEditPanel$22
  implements Runnable
{
  public NearbyProfileEditPanel$22(ayhd paramayhd) {}
  
  public void run()
  {
    ayhd.a(this.this$0, (PicInfo)this.this$0.jdField_a_of_type_JavaUtilLinkedList.poll());
    if (ayhd.a(this.this$0) == null) {
      return;
    }
    CompressInfo localCompressInfo = new CompressInfo(ayhd.a(this.this$0).c, 0);
    localCompressInfo.f = 0;
    azlg.a(localCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..uploadPhoto(), img_path = " + localCompressInfo.e);
    }
    if (!StringUtil.isEmpty(localCompressInfo.e))
    {
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.mIsUp = true;
      localTransferRequest.mLocalPath = localCompressInfo.e;
      localTransferRequest.mFileType = 8;
      this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getTransFileController().transferAsync(localTransferRequest);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.runOnUiThread(new NearbyProfileEditPanel.22.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.22
 * JD-Core Version:    0.7.0.1
 */