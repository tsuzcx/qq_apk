import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class svn
  implements syq<tlp, tnu>
{
  svn(VideoListFeedItem paramVideoListFeedItem, List paramList, tcw paramtcw) {}
  
  public void a(@NonNull tlp paramtlp, @Nullable tnu paramtnu, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool = false;
    if ((paramtnu == null) || (paramErrorMessage.isFail())) {
      bool = true;
    }
    if ((!bool) && (paramtnu.a() != null) && (paramtnu.a().size() != 1)) {
      bool = true;
    }
    for (;;)
    {
      ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add share group fail:%b", new Object[] { Boolean.valueOf(bool) });
      paramtlp = new svv(false);
      paramtlp.b = false;
      paramtlp.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
      paramErrorMessage = new svu();
      paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem;
      Object localObject;
      label176:
      StoryVideoItem localStoryVideoItem1;
      if (!bool)
      {
        localObject = (tnv)paramtnu.a().get(0);
        if (((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem)) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId.equals(((tnv)localObject).b))) {
          paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label501;
        }
        localStoryVideoItem1 = (StoryVideoItem)((Iterator)localObject).next();
        if (!bool) {
          break label495;
        }
      }
      label495:
      for (int i = 6;; i = 5)
      {
        localStoryVideoItem1.mUploadStatus = i;
        svt localsvt = new svt();
        localsvt.a = this.jdField_a_of_type_Tcw.a(localStoryVideoItem1);
        paramErrorMessage.jdField_a_of_type_JavaUtilArrayList.add(localsvt);
        if (bool) {
          break label176;
        }
        StoryVideoItem localStoryVideoItem2 = new StoryVideoItem();
        localStoryVideoItem2.copy(localStoryVideoItem1);
        List localList = paramtnu.a();
        localStoryVideoItem2.mVid = ((String)((tnv)localList.get(0)).a.get(localStoryVideoItem1.sourceVid));
        localStoryVideoItem2.mVideoIndex = 0L;
        if (TextUtils.isEmpty(localStoryVideoItem2.mVid))
        {
          ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "cannot find true vid for sourceVid=%s, %s", new Object[] { localStoryVideoItem1.sourceVid, localList });
          vxp.a(localStoryVideoItem2.mVid);
          localStoryVideoItem2.mVid = StoryVideoItem.makeFakeVid();
        }
        localsvt.b = this.jdField_a_of_type_Tcw.a(localStoryVideoItem2);
        break label176;
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = new ShareGroupFeedItem();
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.copy(paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId = ((tnv)localObject).b;
        if (paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.videoCount == 0) {
          paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.videoCount = 1;
        }
        vxp.a(((tnv)localObject).b);
        localObject = (uvx)tcz.a(11);
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)((uvx)localObject).a(paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem));
        ((uvx)localObject).a(paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.ownerId, paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.date, paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId);
        break;
      }
      label501:
      paramtlp.jdField_a_of_type_JavaUtilArrayList.add(paramErrorMessage);
      stb.a().dispatch(paramtlp);
      ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add shareGroup video return: %s", new Object[] { paramtlp });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svn
 * JD-Core Version:    0.7.0.1
 */