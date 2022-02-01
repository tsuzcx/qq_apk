package com.tencent.mobileqq.troop.activity;

import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

class TroopBarPublishActivity$14$1
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  TroopBarPublishActivity$14$1(TroopBarPublishActivity.14 param14) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("tribe_publish_TroopBarPublishActivity", 2, "compositeVideo: errorCode = " + paramInt);
      }
      this.a.this$0.a(null, this.a.a);
      return;
    }
    this.a.this$0.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.b = this.a.this$0.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth;
    this.a.this$0.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.c = this.a.this$0.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight;
    this.a.this$0.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.a = ((int)this.a.this$0.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDuration);
    this.a.this$0.a(paramString2, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.14.1
 * JD-Core Version:    0.7.0.1
 */