import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule;
import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule.CreateCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.NativeCommentServlet.CreateCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class lir
  implements NativeCommentServlet.CreateCommentObserver
{
  public lir(ArticleCommentModule paramArticleCommentModule, ArticleCommentModule.CreateCommentObserver paramCreateCommentObserver, String paramString) {}
  
  public void a(ArticleInfo paramArticleInfo, int paramInt1, String paramString1, JSONObject paramJSONObject, String paramString2, JSONArray paramJSONArray, int paramInt2)
  {
    int i;
    String str;
    try
    {
      paramJSONArray = paramJSONObject.optString("msg");
      i = paramJSONObject.getInt("ret");
      if (i != 0)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$CreateCommentObserver == null) {
          break label440;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$CreateCommentObserver.a(paramArticleInfo, paramString1, i, paramJSONArray);
        return;
      }
      str = paramJSONObject.getJSONObject("data").getString("comment_id");
      paramJSONArray = null;
      if (paramInt1 != 1) {
        break label181;
      }
      paramJSONObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.buildComment(paramArticleInfo, str, paramInt2, paramString2, null);
      paramJSONObject.toLogString("createComment main commentinfo=");
      ArticleCommentModule.access$100(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule).add(0, paramJSONObject);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$CreateCommentObserver == null) {
        break label440;
      }
      paramJSONArray = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$CreateCommentObserver;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.commentType != 1) || (paramInt1 != 1)) {
        break label428;
      }
      paramString2 = null;
      label139:
      paramJSONArray.a(paramArticleInfo, paramString2, paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$CreateCommentObserver == null) {
        break label440;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$CreateCommentObserver.a(paramArticleInfo, paramString1, -1, "parser local data error");
    return;
    label181:
    if ((paramInt1 == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.commentType == 1)) {
      i = 0;
    }
    for (;;)
    {
      if (i < ArticleCommentModule.access$100(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule).size())
      {
        paramJSONArray = (CommentInfo)ArticleCommentModule.access$100(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule).get(i);
        if ((TextUtils.isEmpty(paramJSONArray.commentId)) || (!paramJSONArray.commentId.equalsIgnoreCase(paramString1))) {
          break label444;
        }
        if (paramJSONArray.mCommentItemLists == null) {
          paramJSONArray.mCommentItemLists = new ArrayList();
        }
        paramJSONObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.buildComment(paramArticleInfo, str, paramInt2, paramString2, this.jdField_a_of_type_JavaLangString);
        paramJSONObject.toLogString("createComment sub in main List commentinfo=");
        paramJSONArray.mCommentItemLists.add(paramJSONObject);
        paramJSONArray.sub_comments_total += 1;
        break label441;
        paramJSONObject = paramJSONArray;
        if (paramInt1 != 2) {
          break;
        }
        paramJSONObject = paramJSONArray;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.commentType != 2) {
          break;
        }
        if (ArticleCommentModule.access$100(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule) == null) {
          ArticleCommentModule.access$102(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule, new ArrayList());
        }
        paramJSONObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.buildComment(paramArticleInfo, str, paramInt2, paramString2, this.jdField_a_of_type_JavaLangString);
        paramJSONObject.toLogString("createComment sub commentinfo=");
        ArticleCommentModule.access$100(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule).add(0, paramJSONObject);
        break;
        label428:
        paramString2 = paramString1;
        break label139;
      }
      paramJSONObject = null;
      break label441;
      label440:
      return;
      label441:
      break;
      label444:
      i += 1;
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$CreateCommentObserver != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$CreateCommentObserver.a(paramArticleInfo, paramString1, paramInt, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lir
 * JD-Core Version:    0.7.0.1
 */