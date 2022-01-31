import android.os.Looper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qcx
  extends oxe
{
  public qcx(ComponentContentRecommend paramComponentContentRecommend) {}
  
  public void a(boolean paramBoolean, long paramLong, List<RecommendFollowInfo> paramList)
  {
    if ((ComponentContentRecommend.a(this.a) == null) || (ComponentContentRecommend.a(this.a).mRecommendFollowInfos == null))
    {
      QQToast.a(ComponentContentRecommend.a(this.a), 1, alud.a(2131702708), 1).a();
      ComponentContentRecommend.a(this.a).clearAnimation();
    }
    while (ComponentContentRecommend.a(this.a).mArticleID != paramLong) {
      return;
    }
    if ((!paramBoolean) || (paramList == null) || (paramList.size() <= 0))
    {
      QQToast.a(ComponentContentRecommend.a(this.a), 1, alud.a(2131702711), 1).a();
      ComponentContentRecommend.a(this.a).clearAnimation();
      return;
    }
    ComponentContentRecommend.a(this.a).clearAnimation();
    ComponentContentRecommend.a(this.a).mRecommendFollowInfos.a.clear();
    ComponentContentRecommend.a(this.a).mRecommendFollowInfos.a.addAll(paramList);
    owy.a().d(ComponentContentRecommend.a(this.a));
    ComponentContentRecommend.a(this.a).clear();
    ComponentContentRecommend.a(this.a).addAll(paramList);
    ComponentContentRecommend.a(this.a).notifyDataSetChanged();
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (int i = 1; i == 0; i = 0)
    {
      QLog.e(ComponentContentRecommend.a, 2, "Please call this method in main thread!!!");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(ComponentContentRecommend.a, 2, "onUpdateAfterAccountFollow uin = " + paramLong + " isFollow = " + paramBoolean);
    }
    Iterator localIterator = ComponentContentRecommend.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
      if (paramLong == localRecommendFollowInfo.uin) {
        localRecommendFollowInfo.isFollowed = paramBoolean;
      }
    }
    ComponentContentRecommend.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qcx
 * JD-Core Version:    0.7.0.1
 */