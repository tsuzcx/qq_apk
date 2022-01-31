import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

class nte
  implements sjq
{
  nte(ntd paramntd, long paramLong, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      long l2 = (l1 - this.jdField_a_of_type_Long) / 1000L;
      l1 = this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDuration;
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish) {
        l1 = this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd - this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart;
      }
      QLog.d("Q.readinjoy.videocapture.ReadInJoyVideoCompositeManager", 2, "CameraCaptureMerge: duration: " + l1 + ", time cost: " + l2 + "s");
    }
    if (paramInt == 0)
    {
      ntd.a(this.jdField_a_of_type_Ntd, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, paramString2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.videocapture.ReadInJoyVideoCompositeManager", 2, new Object[] { "doCompositeCameraCaptureVideo: errorcode=%s, errorMsg=%s", Integer.valueOf(paramInt), paramString1 });
    }
    ntd.a(this.jdField_a_of_type_Ntd, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, paramInt, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nte
 * JD-Core Version:    0.7.0.1
 */