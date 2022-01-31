import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule.DeleteCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListAdapter.SecondCommentOperationCallback;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ljy
  implements ArticleCommentModule.DeleteCommentObserver
{
  ljy(ljx paramljx) {}
  
  public void a(ArticleInfo paramArticleInfo, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySecondCommentListAdapter", 2, "delete second comment success");
    }
    QQToast.a(ReadInJoySecondCommentListAdapter.a(this.a.a), 0, "删除成功", 0).a();
    if (ReadInJoySecondCommentListAdapter.a(this.a.a) != null) {
      ReadInJoySecondCommentListAdapter.a(this.a.a).a(paramString1, paramString2, 2, null);
    }
    this.a.a.notifyDataSetChanged();
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySecondCommentListAdapter", 2, "delete second comment failedcomment id = " + paramString1 + "sub comment id =" + paramString2 + " err code =" + paramInt + " errMsg =" + paramString3);
    }
    QQToast.a(ReadInJoySecondCommentListAdapter.a(this.a.a), 1, "删除失败", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ljy
 * JD-Core Version:    0.7.0.1
 */