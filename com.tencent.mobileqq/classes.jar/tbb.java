import UserGrowth.stFeed;
import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import java.util.List;

public class tbb
  extends bieg<stFeed, biej<stFeed>>
{
  public WSFollowFragment a;
  private WSPlayerManager a;
  public tgd a;
  private tgd b;
  
  public tbb(WSFollowFragment paramWSFollowFragment)
  {
    super(paramWSFollowFragment.getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment = paramWSFollowFragment;
  }
  
  private String a(tgd paramtgd)
  {
    if (paramtgd == null) {
      return "WSPlayableHolder is null.";
    }
    if (paramtgd.jdField_a_of_type_Thl == null) {
      return "WSPlayableHolder.mPlayerParam is null.";
    }
    if (paramtgd.jdField_a_of_type_Thl.jdField_a_of_type_Thp == null) {
      return "WSPlayableHolder.mPlayerParam.mVideoInfo is null.";
    }
    return paramtgd.jdField_a_of_type_Thl.jdField_a_of_type_Thp.d;
  }
  
  public int a(int paramInt)
  {
    Object localObject = a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (stFeed)((List)localObject).get(paramInt);
      if (localObject != null) {
        return ((stFeed)localObject).feed_type;
      }
    }
    return 2;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.getActivity();
  }
  
  public biej<stFeed> a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = tfq.a(paramInt, paramViewGroup, this);
    tlo.a("WSFollowContinuePlayLog", "===> WSFollowAdapter onCreateCustomViewHolder viewHolder:" + paramViewGroup);
    return paramViewGroup;
  }
  
  public WSFollowFragment a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment;
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  }
  
  public void a()
  {
    tgd localtgd = this.b;
    if ((localtgd == null) || (localtgd == this.jdField_a_of_type_Tgd)) {
      tlo.d("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] prePlayVideoHolder:" + localtgd);
    }
    int i;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Tgd == null) || (this.jdField_a_of_type_Tgd.jdField_a_of_type_Thl == null) || (this.jdField_a_of_type_Tgd.jdField_a_of_type_Thl.jdField_a_of_type_Tho == null));
      i = this.jdField_a_of_type_Tgd.jdField_a_of_type_Thl.jdField_a_of_type_Tho.e();
      tlo.e("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] playingPlayerState:" + i + ", prePlayVideoHolder:" + localtgd);
    } while ((i == 0) || (i == 1) || (i == 2));
    tlo.a("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] goto prePlayVideo prePlayVideoHolder:" + localtgd);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localtgd.jdField_a_of_type_Thl);
  }
  
  public void a(biej<stFeed> parambiej)
  {
    tlo.b("WSFollowAdapter", "[WSFollowAdapter.java][onViewAttachedToWindow] holder: " + parambiej);
    if (((parambiej instanceof tfk)) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.getUserVisibleHint())) {
      ((tfk)parambiej).d();
    }
  }
  
  public void a(biej<stFeed> parambiej, int paramInt)
  {
    stFeed localstFeed = (stFeed)a(paramInt);
    if (localstFeed == null) {}
    do
    {
      return;
      if ((parambiej instanceof tfk))
      {
        parambiej.a(localstFeed);
        tfk localtfk = (tfk)parambiej;
        localtfk.jdField_a_of_type_Thp = thn.a(localstFeed.feed);
        tel.a().a(localtfk);
        localtfk.jdField_a_of_type_Thf = tel.a().a(localtfk);
        localtfk.jdField_a_of_type_Thl = tel.a().a(localtfk, 0L, paramInt);
        tlo.a("WSFollowContinuePlayLog", "===> WSFollowAdapter onBindCustomViewHolder1 holder:" + parambiej);
        tlo.a("WSFollowContinuePlayLog", "===> WSFollowAdapter onBindCustomViewHolder2 position:" + paramInt + ", title: " + localtfk.jdField_a_of_type_Thp.d);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.b(localtfk);
        return;
      }
    } while (!(parambiej instanceof tfr));
    ((tfr)parambiej).a(localstFeed);
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
    paramWSPlayerManager = new tig(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramWSPlayerManager);
  }
  
  public void a(tgd paramtgd)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d();
    this.jdField_a_of_type_Tgd = paramtgd;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(paramtgd.jdField_a_of_type_Thl, false);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(true);
    tel.a().a(paramtgd.jdField_a_of_type_Thl);
  }
  
  public void b(biej<stFeed> parambiej)
  {
    super.onViewDetachedFromWindow(parambiej);
    if ((parambiej instanceof tfk)) {
      ((tfk)parambiej).c();
    }
  }
  
  public void b(tgd paramtgd)
  {
    this.b = paramtgd;
    tlo.e("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][setPrePlayingHolder]\nplayingTitle:" + a(this.jdField_a_of_type_Tgd) + "\nprePlayTitle:" + a(this.b) + "\nPlayingHolder:" + this.jdField_a_of_type_Tgd + "\nPrePlayHolder:" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tbb
 * JD-Core Version:    0.7.0.1
 */