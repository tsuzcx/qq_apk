import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList.6.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class qvh
  extends pkt
{
  public qvh(ComponentContentRecommendFollowList paramComponentContentRecommendFollowList) {}
  
  public void b(long paramLong, boolean paramBoolean)
  {
    ComponentContentRecommendFollowList.6.1 local1 = new ComponentContentRecommendFollowList.6.1(this, paramLong, paramBoolean);
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (int i = 1; i == 0; i = 0)
    {
      ThreadManager.getUIHandler().post(local1);
      return;
    }
    local1.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qvh
 * JD-Core Version:    0.7.0.1
 */