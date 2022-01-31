package com.tencent.mobileqq.nearby.profilecard;

import asxa;
import atqs;
import axvo;
import axvt;
import baip;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class NearbyProfileEditTribePanel$16
  implements Runnable
{
  public NearbyProfileEditTribePanel$16(asxa paramasxa) {}
  
  public void run()
  {
    asxa.a(this.this$0, (PicInfo)this.this$0.jdField_a_of_type_JavaUtilLinkedList.poll());
    if (asxa.a(this.this$0) == null) {
      return;
    }
    CompressInfo localCompressInfo = new CompressInfo(asxa.a(this.this$0).c, 0);
    localCompressInfo.f = 0;
    atqs.a(localCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..uploadPhoto(), img_path = " + localCompressInfo.e);
    }
    if (!baip.a(localCompressInfo.e))
    {
      axvt localaxvt = new axvt();
      localaxvt.a = true;
      localaxvt.i = localCompressInfo.e;
      localaxvt.b = 8;
      this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().a(localaxvt);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.runOnUiThread(new NearbyProfileEditTribePanel.16.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.16
 * JD-Core Version:    0.7.0.1
 */