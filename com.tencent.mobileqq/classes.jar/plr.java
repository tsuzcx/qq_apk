import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.10.1;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.10.2;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class plr
  extends osp
{
  plr(plp paramplp) {}
  
  public void a(ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    paramArticleInfo = new ReadInJoySocializeRecommendFollowView.10.2(this, paramArticleInfo, paramBoolean);
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (int i = 1; i == 0; i = 0)
    {
      ThreadManager.getUIHandler().post(paramArticleInfo);
      return;
    }
    paramArticleInfo.run();
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    ReadInJoySocializeRecommendFollowView.10.1 local1 = new ReadInJoySocializeRecommendFollowView.10.1(this, paramLong, paramBoolean);
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (int i = 1; i == 0; i = 0)
    {
      ThreadManager.getUIHandler().post(local1);
      return;
    }
    local1.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     plr
 * JD-Core Version:    0.7.0.1
 */