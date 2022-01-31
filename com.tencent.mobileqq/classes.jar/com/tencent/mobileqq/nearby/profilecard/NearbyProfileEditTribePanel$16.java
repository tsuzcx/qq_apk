package com.tencent.mobileqq.nearby.profilecard;

import avop;
import awkj;
import bayf;
import bayk;
import bdnn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class NearbyProfileEditTribePanel$16
  implements Runnable
{
  public NearbyProfileEditTribePanel$16(avop paramavop) {}
  
  public void run()
  {
    avop.a(this.this$0, (PicInfo)this.this$0.jdField_a_of_type_JavaUtilLinkedList.poll());
    if (avop.a(this.this$0) == null) {
      return;
    }
    CompressInfo localCompressInfo = new CompressInfo(avop.a(this.this$0).c, 0);
    localCompressInfo.f = 0;
    awkj.a(localCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..uploadPhoto(), img_path = " + localCompressInfo.e);
    }
    if (!bdnn.a(localCompressInfo.e))
    {
      bayk localbayk = new bayk();
      localbayk.a = true;
      localbayk.i = localCompressInfo.e;
      localbayk.b = 8;
      this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().a(localbayk);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.runOnUiThread(new NearbyProfileEditTribePanel.16.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.16
 * JD-Core Version:    0.7.0.1
 */