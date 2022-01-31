package com.tencent.mobileqq.nearby.profilecard;

import atsa;
import auoq;
import ayvv;
import aywa;
import bbjw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class NearbyProfileEditPanel$22
  implements Runnable
{
  public NearbyProfileEditPanel$22(atsa paramatsa) {}
  
  public void run()
  {
    atsa.a(this.this$0, (PicInfo)this.this$0.jdField_a_of_type_JavaUtilLinkedList.poll());
    if (atsa.a(this.this$0) == null) {
      return;
    }
    CompressInfo localCompressInfo = new CompressInfo(atsa.a(this.this$0).c, 0);
    localCompressInfo.f = 0;
    auoq.a(localCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..uploadPhoto(), img_path = " + localCompressInfo.e);
    }
    if (!bbjw.a(localCompressInfo.e))
    {
      aywa localaywa = new aywa();
      localaywa.a = true;
      localaywa.i = localCompressInfo.e;
      localaywa.b = 8;
      this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().a(localaywa);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.runOnUiThread(new NearbyProfileEditPanel.22.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.22
 * JD-Core Version:    0.7.0.1
 */