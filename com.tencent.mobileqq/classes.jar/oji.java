import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;

public final class oji
  implements pgr
{
  public oji(CommentInfo paramCommentInfo) {}
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(this.a.authorUin)) || (paramReadInJoyUserInfo == null)) {
      return;
    }
    this.a.authorNickName = paramReadInJoyUserInfo.nick;
  }
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oji
 * JD-Core Version:    0.7.0.1
 */