package com.tencent.mobileqq.troop.activity;

import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;

class TroopBarPublishActivity$14
  implements Runnable
{
  TroopBarPublishActivity$14(TroopBarPublishActivity paramTroopBarPublishActivity, String paramString1, String paramString2, long paramLong) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = VideoCompositeHelper.a(this.jdField_a_of_type_JavaLangString);
    this.this$0.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.a = this.this$0.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish;
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish)
    {
      TroopBarPublishActivity.a(this.this$0, this.b, this.jdField_a_of_type_Long);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = true;
    VideoCompositeHelper localVideoCompositeHelper = new VideoCompositeHelper();
    TroopBarPublishActivity.14.1 local1 = new TroopBarPublishActivity.14.1(this);
    localVideoCompositeHelper.a(this.this$0.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, this.b + ".tmp.mp4", false, true, local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.14
 * JD-Core Version:    0.7.0.1
 */