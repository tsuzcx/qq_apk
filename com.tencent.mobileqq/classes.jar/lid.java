import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyVideoCompositeManager;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.database.PublishVideoEntry;

public class lid
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  public lid(ReadInJoyVideoCompositeManager paramReadInJoyVideoCompositeManager, PublishVideoEntry paramPublishVideoEntry, Context paramContext) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 0)
    {
      ReadInJoyVideoCompositeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoCompositeManager, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, paramInt, paramString1);
      return;
    }
    ReadInJoyVideoCompositeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoCompositeManager, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, this.jdField_a_of_type_AndroidContentContext, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lid
 * JD-Core Version:    0.7.0.1
 */