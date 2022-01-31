import com.tencent.biz.pubaccount.PublicAccountArticleObserver;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class mci
  extends PublicAccountArticleObserver
{
  public mci(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onSendArticleLikeReq isSuccess=" + paramBoolean + ", articleID=" + paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onQueryArticleLikeCount isSuccess=" + paramBoolean + ", articleID=" + paramString + ", likeCount=" + paramInt);
    }
    if ((paramBoolean) && (paramString != null))
    {
      Iterator localIterator = VideoFeedsPlayActivity.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
        String str = localVideoInfo.a();
        if ((str != null) && (str.equals(paramString))) {
          localVideoInfo.k = paramInt;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mci
 * JD-Core Version:    0.7.0.1
 */