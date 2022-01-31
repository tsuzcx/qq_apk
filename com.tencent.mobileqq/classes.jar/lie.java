import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyVideoCompositeManager;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.qphone.base.util.QLog;

public class lie
  extends ExecuteBinResponseCallback
{
  public lie(ReadInJoyVideoCompositeManager paramReadInJoyVideoCompositeManager, PublishVideoEntry paramPublishVideoEntry, String paramString) {}
  
  public void a(String paramString)
  {
    ReadInJoyVideoCompositeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoCompositeManager, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, this.jdField_a_of_type_JavaLangString + ".doodle.mp4");
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.videocapture.ReadInJoyVideoCompositeManager", 2, "compositeVideo->combineDoodle: " + paramString);
    }
    ReadInJoyVideoCompositeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoCompositeManager, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 999, "本地视频合成涂鸦是出错！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lie
 * JD-Core Version:    0.7.0.1
 */