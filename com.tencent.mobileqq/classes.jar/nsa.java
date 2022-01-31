import com.tencent.biz.qqstory.network.handler.VidToSimpleInfoHandler.GetSimpleInfoListEvent;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager.GetFeedVidListObserver;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class nsa
  extends ShareGroupManager.GetFeedVidListObserver
{
  public nsa(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity) {}
  
  public void a(VideoCollectionItem paramVideoCollectionItem, boolean paramBoolean)
  {
    VidToSimpleInfoHandler.GetSimpleInfoListEvent localGetSimpleInfoListEvent = new VidToSimpleInfoHandler.GetSimpleInfoListEvent();
    localGetSimpleInfoListEvent.jdField_a_of_type_JavaLangString = paramVideoCollectionItem.collectionId;
    localGetSimpleInfoListEvent.jdField_a_of_type_JavaUtilList = paramVideoCollectionItem.collectionVideoUIItemList;
    Dispatchers.get().dispatch(localGetSimpleInfoListEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsa
 * JD-Core Version:    0.7.0.1
 */