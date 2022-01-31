import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule.FetchCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class ljz
  implements ArticleCommentModule.FetchCommentObserver
{
  public ljz(ReadInJoySecondCommentListAdapter paramReadInJoySecondCommentListAdapter) {}
  
  public void a(ArticleInfo paramArticleInfo)
  {
    ReadInJoySecondCommentListAdapter.a(this.a).a = true;
    this.a.notifyDataSetChanged();
  }
  
  public void a(ArticleInfo paramArticleInfo, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySecondCommentListAdapter", 2, "fetch second level comment failed ,err code =" + paramInt + "err msg =" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ljz
 * JD-Core Version:    0.7.0.1
 */