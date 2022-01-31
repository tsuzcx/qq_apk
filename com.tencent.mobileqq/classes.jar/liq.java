import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule;
import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule.FetchCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.NativeCommentServlet.CommentObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

public class liq
  implements NativeCommentServlet.CommentObserver
{
  public liq(ArticleCommentModule paramArticleCommentModule) {}
  
  public void a(ArticleInfo paramArticleInfo, int paramInt, String paramString)
  {
    if (ArticleCommentModule.access$000(this.a) != null) {
      ArticleCommentModule.access$000(this.a).a(paramArticleInfo, paramInt, paramString);
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, JSONObject paramJSONObject, String paramString)
  {
    if (this.a.dealwithRawComment(paramJSONObject)) {
      if (ArticleCommentModule.access$000(this.a) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TRACE_COMMENT_LIST", 2, "element size=" + ArticleCommentModule.access$100(this.a).size());
        }
        ArticleCommentModule.access$000(this.a).a(paramArticleInfo);
      }
    }
    while (ArticleCommentModule.access$000(this.a) == null) {
      return;
    }
    ArticleCommentModule.access$000(this.a).a(paramArticleInfo, -1, " json formate error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     liq
 * JD-Core Version:    0.7.0.1
 */