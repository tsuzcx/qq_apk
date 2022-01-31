import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFriendStoryFeedVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MultiRecommendItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupVideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tbn
  extends slu
{
  public String a;
  public ArrayList<StoryVideoItem> a;
  public boolean a;
  public String c;
  
  public tbn(qqstory_service.RspFriendStoryFeedVideoList paramRspFriendStoryFeedVideoList)
  {
    super(paramRspFriendStoryFeedVideoList.result);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramRspFriendStoryFeedVideoList.next_cookie.get().toStringUtf8();
    this.c = paramRspFriendStoryFeedVideoList.union_id.get().toStringUtf8();
    if (paramRspFriendStoryFeedVideoList.is_end.get() == 1) {}
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (!paramRspFriendStoryFeedVideoList.share_group_video_info_list.has()) {
        break;
      }
      paramRspFriendStoryFeedVideoList = paramRspFriendStoryFeedVideoList.share_group_video_info_list.get().iterator();
      while (paramRspFriendStoryFeedVideoList.hasNext())
      {
        localObject1 = (qqstory_struct.ShareGroupVideoInfo)paramRspFriendStoryFeedVideoList.next();
        localObject2 = new StoryVideoItem();
        ((StoryVideoItem)localObject2).convertFrom("Q.qqstory.net:GetFeedVideoListResponse", (qqstory_struct.ShareGroupVideoInfo)localObject1);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      }
      bool = false;
    }
    if (paramRspFriendStoryFeedVideoList.multi_rcmd_feed_info_list.has())
    {
      localObject1 = (sqs)sqg.a(2);
      paramRspFriendStoryFeedVideoList = paramRspFriendStoryFeedVideoList.multi_rcmd_feed_info_list.get().iterator();
      while (paramRspFriendStoryFeedVideoList.hasNext())
      {
        localObject2 = (qqstory_struct.MultiRecommendItem)paramRspFriendStoryFeedVideoList.next();
        if (((qqstory_struct.MultiRecommendItem)localObject2).feed_video_info_list.has())
        {
          String str = ((qqstory_struct.MultiRecommendItem)localObject2).feed_id.get().toStringUtf8();
          Iterator localIterator = ((qqstory_struct.MultiRecommendItem)localObject2).feed_video_info_list.get().iterator();
          while (localIterator.hasNext())
          {
            Object localObject3 = (qqstory_struct.FeedVideoInfo)localIterator.next();
            StoryVideoItem localStoryVideoItem = new StoryVideoItem();
            localStoryVideoItem.convertFrom("Q.qqstory.net:GetFeedVideoListResponse", (qqstory_struct.FeedVideoInfo)localObject3);
            localStoryVideoItem.mAttachedFeedId = str;
            this.jdField_a_of_type_JavaUtilArrayList.add(localStoryVideoItem);
            localObject3 = new QQUserUIItem();
            ((QQUserUIItem)localObject3).convertFrom(((qqstory_struct.MultiRecommendItem)localObject2).user);
            localObject3 = ((sqs)localObject1).a((QQUserUIItem)localObject3);
            localStoryVideoItem.mOwnerUid = ((QQUserUIItem)localObject3).uid;
            localStoryVideoItem.mOwnerName = ((QQUserUIItem)localObject3).getDisplayName();
          }
        }
      }
    }
    paramRspFriendStoryFeedVideoList = paramRspFriendStoryFeedVideoList.feed_video_info_list.get().iterator();
    while (paramRspFriendStoryFeedVideoList.hasNext())
    {
      localObject1 = (qqstory_struct.FeedVideoInfo)paramRspFriendStoryFeedVideoList.next();
      localObject2 = new StoryVideoItem();
      ((StoryVideoItem)localObject2).convertFrom("Q.qqstory.net:GetFeedVideoListResponse", (qqstory_struct.FeedVideoInfo)localObject1);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tbn
 * JD-Core Version:    0.7.0.1
 */