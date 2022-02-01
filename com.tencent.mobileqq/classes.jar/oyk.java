import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;

public final class oyk
  implements qhl
{
  public oyk(CommentInfo paramCommentInfo) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2) {}
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(this.a.authorUin)) || (paramReadInJoyUserInfo == null)) {
      return;
    }
    this.a.authorNickName = paramReadInJoyUserInfo.nick;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyk
 * JD-Core Version:    0.7.0.1
 */