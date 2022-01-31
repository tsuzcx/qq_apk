import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager.GetFeedIdVidListEvent;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager.GetFeedVidListObserver;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;

public class nxg
  extends ShareGroupManager.GetFeedVidListObserver
{
  public nxg(ShareGroupManager paramShareGroupManager, int paramInt1, String paramString, int paramInt2) {}
  
  public void a(VideoCollectionItem paramVideoCollectionItem, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == paramVideoCollectionItem.videoVidList.size())
    {
      boolean bool = true;
      paramBoolean = bool;
      if (QLog.isColorLevel())
      {
        QLog.e("Q.qqstory.discover.ShareGroupManager", 2, "currentVidListSize == videoCollectionItem.videoVidList.size():" + paramVideoCollectionItem.toString());
        paramBoolean = bool;
      }
    }
    if (paramBoolean)
    {
      ShareGroupManager.GetFeedIdVidListEvent localGetFeedIdVidListEvent = new ShareGroupManager.GetFeedIdVidListEvent();
      localGetFeedIdVidListEvent.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localGetFeedIdVidListEvent.jdField_a_of_type_JavaUtilArrayList = paramVideoCollectionItem.videoVidList;
      Dispatchers.get().dispatch(localGetFeedIdVidListEvent);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupManager.a(this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxg
 * JD-Core Version:    0.7.0.1
 */