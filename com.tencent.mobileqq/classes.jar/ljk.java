import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule.DeleteCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ljk
  implements ArticleCommentModule.DeleteCommentObserver
{
  ljk(ljj paramljj) {}
  
  public void a(ArticleInfo paramArticleInfo, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommentListAdapter", 2, "delete first comment success");
    }
    QQToast.a(BaseApplication.getContext(), 0, "删除成功", 0).a();
    this.a.a.notifyDataSetChanged();
    paramArticleInfo = this.a.a;
    paramArticleInfo.a -= 1;
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommentListAdapter", 2, "delete first comment failed ,comment id = " + paramString1 + "sub comment id = " + paramString2 + "err code =" + paramInt + "err Msg = " + paramString3);
    }
    QQToast.a(BaseApplication.getContext(), 1, "删除失败", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ljk
 * JD-Core Version:    0.7.0.1
 */