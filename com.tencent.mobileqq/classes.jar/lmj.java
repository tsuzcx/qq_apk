import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule.CreateCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.CreateCommentInterface;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;

public final class lmj
  implements ArticleCommentModule.CreateCommentObserver
{
  public lmj(ReadInJoyCommentUtils.CreateCommentInterface paramCreateCommentInterface) {}
  
  public void a(ArticleInfo paramArticleInfo, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentUtils", 2, "comment id = " + paramString1 + "err code = " + paramInt + "err msg " + paramString2);
    }
    this.a.a(paramString1, paramInt, paramString2);
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString, CommentInfo paramCommentInfo)
  {
    this.a.a(paramString, paramCommentInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lmj
 * JD-Core Version:    0.7.0.1
 */