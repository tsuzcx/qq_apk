import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule.FetchCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class ljm
  implements ArticleCommentModule.FetchCommentObserver
{
  public ljm(ReadInJoyCommentListAdapter paramReadInJoyCommentListAdapter) {}
  
  public void a(ArticleInfo paramArticleInfo)
  {
    this.a.notifyDataSetChanged();
  }
  
  public void a(ArticleInfo paramArticleInfo, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommentListAdapter", 2, "fetch first level comment failed ,err code =" + paramInt + "err msg =" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ljm
 * JD-Core Version:    0.7.0.1
 */