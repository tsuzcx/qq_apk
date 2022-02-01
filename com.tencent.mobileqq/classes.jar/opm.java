import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.soft_component.VideoFeedsSoftAdBarDelegateForAd.1.1;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class opm
  implements olv
{
  opm(opl paramopl) {}
  
  public void a(orb paramorb, int paramInt1, int paramInt2)
  {
    if ((paramorb == null) || (paramorb.d == null) || (opl.a(this.a) == null) || (opl.a(this.a).a == null) || (opl.a(this.a).a.mAdvertisementSoftInfo == null)) {}
    while (!opl.a(this.a).a.mAdvertisementSoftInfo.o.equalsIgnoreCase(paramorb.d)) {
      return;
    }
    ThreadManager.getUIHandler().post(new VideoFeedsSoftAdBarDelegateForAd.1.1(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     opm
 * JD-Core Version:    0.7.0.1
 */