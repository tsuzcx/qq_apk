import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.qqstory.playmode.child.ShareGroupHotSortPlayMode;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo.IBatchGetVideoInfoCallback;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class nlg
  implements BatchGetVideoInfo.IBatchGetVideoInfoCallback
{
  public nlg(ShareGroupHotSortPlayMode paramShareGroupHotSortPlayMode, BatchGetVideoInfo paramBatchGetVideoInfo, Bundle paramBundle) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfo.a();
    ThreadManager.getUIHandler().post(new nlj(this));
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfo.a();
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildShareGroupHotSortPlayMode.a.post(new nlh(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlg
 * JD-Core Version:    0.7.0.1
 */