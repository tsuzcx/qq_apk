import android.support.v4.app.FragmentActivity;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesVideoCollectionPresenter;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import java.util.ArrayList;

class nwg
  implements Runnable
{
  nwg(nwf paramnwf, ArrayList paramArrayList1, int paramInt, ArrayList paramArrayList2, boolean paramBoolean, QQUserUIItem paramQQUserUIItem) {}
  
  public void run()
  {
    StoryPlayVideoActivity.a((FragmentActivity)MemoriesVideoListSegment.a(this.jdField_a_of_type_Nwf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewSegmentMemoriesVideoListSegment), MemoriesVideoListSegment.a(this.jdField_a_of_type_Nwf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewSegmentMemoriesVideoListSegment).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int, this.jdField_a_of_type_Nwf.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Nwf.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Boolean, StoryMemoriesFragment.a(this.jdField_a_of_type_Nwf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewSegmentMemoriesVideoListSegment.jdField_a_of_type_Int));
    int i = StoryMemoriesFragment.a(this.jdField_a_of_type_Nwf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewSegmentMemoriesVideoListSegment.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) {}
    for (String str = "1";; str = "2")
    {
      StoryReportor.a("memory", "clk_video", i, 0, new String[] { str, "", "", this.jdField_a_of_type_Nwf.b });
      SLog.b("Q.qqstory.memories.MemoriesVideoListSegment", "go to player , collection key = %s, feedIds = %s , vid = %s , keyIndex = %s , video pos = %d , keyList = %s", new Object[] { this.jdField_a_of_type_Nwf.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Nwf.b, Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Nwf.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilArrayList });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwg
 * JD-Core Version:    0.7.0.1
 */