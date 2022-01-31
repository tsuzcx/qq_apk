import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule.FetchCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class ljq
  implements ArticleCommentModule.FetchCommentObserver
{
  public ljq(ReadInJoyCommentListAdapter paramReadInJoyCommentListAdapter) {}
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentListView", 2, "first comment bottom refresh success");
    }
    ReadInJoyCommentListAdapter.a(this.a).a(true);
    this.a.notifyDataSetChanged();
  }
  
  public void a(ArticleInfo paramArticleInfo, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentListView", 2, "first comment bottom refresh failed ,err code =" + paramInt + "err msg = " + paramString);
    }
    ReadInJoyCommentListAdapter.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ljq
 * JD-Core Version:    0.7.0.1
 */