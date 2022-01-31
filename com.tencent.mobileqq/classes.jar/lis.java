import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule;
import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule.DeleteCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.List;

public class lis
  implements ArticleCommentModule.DeleteCommentObserver
{
  public lis(ArticleCommentModule paramArticleCommentModule, String paramString1, String paramString2, ArticleCommentModule.DeleteCommentObserver paramDeleteCommentObserver) {}
  
  public void a(ArticleInfo paramArticleInfo, int paramInt, String paramString1, String paramString2)
  {
    int j = 0;
    int i = j;
    if (paramInt == 2) {
      i = j;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.commentType != 1) {
        break label216;
      }
      paramInt = 0;
    }
    catch (Exception localException)
    {
      Object localObject1;
      Object localObject2;
      label115:
      CommentInfo localCommentInfo;
      while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$DeleteCommentObserver != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$DeleteCommentObserver.a(paramArticleInfo, paramString1, paramString2, -1, "parser local data error");
        return;
        i = 0;
        while (i == 0)
        {
          paramInt += 1;
          break;
          i = 0;
          break label115;
        }
      }
    }
    if (paramInt < ArticleCommentModule.access$100(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule).size())
    {
      localObject1 = (CommentInfo)ArticleCommentModule.access$100(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule).get(paramInt);
      if ((TextUtils.isEmpty(((CommentInfo)localObject1).commentId)) || (!((CommentInfo)localObject1).commentId.equalsIgnoreCase(paramString1))) {
        break label350;
      }
      localObject2 = ((CommentInfo)ArticleCommentModule.access$100(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule).get(paramInt)).mCommentItemLists;
      if (localObject2 != null) {
        break label357;
      }
      break label350;
      if (i >= ((List)localObject2).size()) {
        break label344;
      }
      localCommentInfo = (CommentInfo)((List)localObject2).get(i);
      if ((TextUtils.isEmpty(localCommentInfo.commentId)) || (!localCommentInfo.commentId.equalsIgnoreCase(paramString2))) {
        break label372;
      }
      ((CommentInfo)localObject1).toLogString("delete sub comment:");
      ((List)localObject2).remove(i);
      i = 1;
      break label363;
    }
    label388:
    for (;;)
    {
      label188:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$DeleteCommentObserver != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$DeleteCommentObserver.a(paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.commentType, paramString1, paramString2);
        return;
      }
      for (;;)
      {
        label216:
        if (i >= ArticleCommentModule.access$100(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule).size()) {
          break label388;
        }
        localObject2 = (CommentInfo)ArticleCommentModule.access$100(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule).get(i);
        localObject1 = this.jdField_a_of_type_JavaLangString;
        if (paramInt == 2) {
          localObject1 = this.b;
        }
        if ((!TextUtils.isEmpty(((CommentInfo)localObject2).commentId)) && (((CommentInfo)localObject2).commentId.equalsIgnoreCase((String)localObject1)))
        {
          ((CommentInfo)localObject2).toLogString("delete comment:");
          ArticleCommentModule.access$100(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule).remove(i);
          break label188;
          label344:
          label350:
          label357:
          label363:
          return;
          label372:
          i += 1;
          break;
        }
        i += 1;
      }
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$DeleteCommentObserver != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$DeleteCommentObserver.a(paramArticleInfo, paramString1, paramString2, paramInt, paramString3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lis
 * JD-Core Version:    0.7.0.1
 */