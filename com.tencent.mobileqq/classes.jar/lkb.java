import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule.FetchCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class lkb
  implements ArticleCommentModule.FetchCommentObserver
{
  public lkb(ReadInJoySecondCommentListAdapter paramReadInJoySecondCommentListAdapter) {}
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentListView", 2, "second comment bottom refresh success");
    }
    ReadInJoySecondCommentListAdapter.a(this.a).a(true);
    this.a.notifyDataSetChanged();
  }
  
  public void a(ArticleInfo paramArticleInfo, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentListView", 2, "second comment bottom refresh failed,err code =" + paramInt + " errMsg =" + paramString);
    }
    ReadInJoySecondCommentListAdapter.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lkb
 * JD-Core Version:    0.7.0.1
 */