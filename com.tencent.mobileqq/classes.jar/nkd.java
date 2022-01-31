import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.qqstory.playmode.child.TagStoryVidListPlayMode;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo.IBatchGetVideoInfoCallback;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class nkd
  implements BatchGetVideoInfo.IBatchGetVideoInfoCallback
{
  public nkd(TagStoryVidListPlayMode paramTagStoryVidListPlayMode, BatchGetVideoInfo paramBatchGetVideoInfo, Bundle paramBundle) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfo.a();
    ThreadManager.getUIHandler().post(new nkg(this));
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfo.a();
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildTagStoryVidListPlayMode.a.post(new nke(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nkd
 * JD-Core Version:    0.7.0.1
 */