import NS_KING_INTERFACE.stGetFeedCommentListRsp;
import NS_KING_SOCIALIZE_META.stMetaComment;
import UserGrowth.stQQGetFeedCommentListRsp;
import UserGrowth.stSimpleMetaFeed;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class tcw
  implements tgt
{
  tcw(tcu paramtcu, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean) {}
  
  public void a(the paramthe)
  {
    tcu.a(this.jdField_a_of_type_Tcu, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, true);
    Object localObject1 = null;
    stGetFeedCommentListRsp localstGetFeedCommentListRsp;
    ArrayList localArrayList;
    Object localObject2;
    if ((paramthe.jdField_a_of_type_JavaLangObject instanceof stQQGetFeedCommentListRsp))
    {
      localObject1 = (stQQGetFeedCommentListRsp)paramthe.jdField_a_of_type_JavaLangObject;
      localstGetFeedCommentListRsp = ((stQQGetFeedCommentListRsp)localObject1).rsp;
      if (localstGetFeedCommentListRsp == null)
      {
        tlo.d(tcu.a(), "stGetFeedCommentListRsp is null!");
        return;
      }
      localArrayList = localstGetFeedCommentListRsp.getComments();
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        stMetaComment localstMetaComment = (stMetaComment)((Iterator)localObject2).next();
        tlo.c(tcu.a(), "comment.isDing:" + localstMetaComment.isDing + ",comment dingNum:" + localstMetaComment.dingNum + ", comment word:" + localstMetaComment.wording);
      }
      tlo.d(tcu.a(), "-------------getCommentSize:" + localstGetFeedCommentListRsp.comments.size() + ", attachInfo:" + localstGetFeedCommentListRsp.attach_info + "isFinish：" + localstGetFeedCommentListRsp.is_finished);
      if (this.jdField_a_of_type_Boolean)
      {
        localObject2 = (ArrayList)tcu.a(this.jdField_a_of_type_Tcu).get(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id);
        if (localObject2 == null) {
          break label586;
        }
      }
    }
    label327:
    label586:
    for (int i = ((ArrayList)localObject2).size();; i = 0)
    {
      localObject1 = tcu.a(localArrayList, ((stQQGetFeedCommentListRsp)localObject1).comment_text, i);
      if (localObject2 != null)
      {
        ((ArrayList)localObject2).addAll((Collection)localObject1);
        tcu.a(this.jdField_a_of_type_Tcu).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localObject2);
        tlo.d(tcu.a(), "保存评论" + ((ArrayList)localObject1).size() + "条");
        localstGetFeedCommentListRsp.setComments((ArrayList)localObject1);
        tcu.a(this.jdField_a_of_type_Tcu, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localstGetFeedCommentListRsp.attach_info, localstGetFeedCommentListRsp.is_finished, true);
        tlo.d(tcu.a(), "获取评论 dispatch responseCommentEvent");
        localObject1 = localstGetFeedCommentListRsp;
      }
      for (;;)
      {
        paramthe = this.jdField_a_of_type_Tcu.a(new Object[] { Integer.valueOf(9), Integer.valueOf(paramthe.b), paramthe.jdField_a_of_type_JavaLangString, localObject1, Integer.valueOf(this.jdField_a_of_type_Tcu.hashCode()), Boolean.valueOf(this.jdField_a_of_type_Boolean), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id });
        uht.a().dispatch(paramthe);
        return;
        tcu.a(this.jdField_a_of_type_Tcu).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localObject1);
        break;
        localObject1 = tcu.a(localArrayList, ((stQQGetFeedCommentListRsp)localObject1).comment_text, 0);
        tcu.b(this.jdField_a_of_type_Tcu).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, Integer.valueOf(localstGetFeedCommentListRsp.total_comment_num));
        tcu.a(this.jdField_a_of_type_Tcu).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localObject1);
        tlo.d(tcu.a(), "保存评论" + ((ArrayList)localObject1).size() + "条");
        break label327;
        tlo.d(tcu.a(), "获取评论失败new！");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tcw
 * JD-Core Version:    0.7.0.1
 */