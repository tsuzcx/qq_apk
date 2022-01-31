import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class mdn
  extends FriendListObserver
{
  public mdn(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {}
    label142:
    label143:
    label149:
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        Object localObject = VideoFeedsPlayActivity.a(this.a);
        if (localObject != null) {}
        for (localObject = ContactUtils.b((QQAppInterface)localObject, paramString, false);; localObject = null)
        {
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label149;
          }
          Iterator localIterator = VideoFeedsPlayActivity.a(this.a).iterator();
          if (localIterator.hasNext())
          {
            VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
            if ((!paramString.equals(localVideoInfo.j)) || (((String)localObject).equals(localVideoInfo.k))) {
              break label142;
            }
            localVideoInfo.k = ((String)localObject);
            i = 1;
          }
          for (;;)
          {
            break;
            if ((i == 0) || (VideoFeedsPlayActivity.a(this.a) == null)) {
              break label143;
            }
            VideoFeedsPlayActivity.a(this.a).a(paramString);
            return;
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdn
 * JD-Core Version:    0.7.0.1
 */