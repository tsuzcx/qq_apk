import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule;
import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule.CommentLikeObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.NativeCommentServlet.CommentLikeObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import org.json.JSONObject;

public class lit
  implements NativeCommentServlet.CommentLikeObserver
{
  public lit(ArticleCommentModule paramArticleCommentModule, ArticleCommentModule.CommentLikeObserver paramCommentLikeObserver, int paramInt) {}
  
  public void a(ArticleInfo paramArticleInfo, String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$CommentLikeObserver != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$CommentLikeObserver.a(paramArticleInfo, paramString1, paramInt, paramString2);
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString, JSONObject paramJSONObject)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$CommentLikeObserver != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$CommentLikeObserver.a(paramArticleInfo, paramString, this.jdField_a_of_type_Int);
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$CommentLikeObserver == null) {}
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$CommentLikeObserver.a(paramArticleInfo, paramString, -1, "parser local data error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lit
 * JD-Core Version:    0.7.0.1
 */