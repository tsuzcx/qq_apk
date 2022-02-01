import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.WormholeView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.viola.vinstance.VInstanceAction.VInstanceEventListener;

public class png
  implements View.OnClickListener, VInstanceAction.VInstanceEventListener, tka
{
  private int jdField_a_of_type_Int;
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private WormholeView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView;
  private pnf jdField_a_of_type_Pnf;
  private tjz jdField_a_of_type_Tjz;
  
  public png(tjz paramtjz, WormholeView paramWormholeView, pnf parampnf)
  {
    this.jdField_a_of_type_Tjz = paramtjz;
    this.jdField_a_of_type_Pnf = parampnf;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView = paramWormholeView;
    paramWormholeView.setLifeListener(this);
    paramWormholeView.a();
    paramWormholeView.setOnErrorViewClickListener(this);
  }
  
  private boolean a(String paramString)
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getWormholeId()));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView == null) {
      return;
    }
    if ((this.jdField_a_of_type_Tjz != null) && (this.jdField_a_of_type_Tjz.a(paramBaseArticleInfo, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView.a())))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView.c();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView.b();
  }
  
  public void a(WormholeView paramWormholeView)
  {
    if (this.jdField_a_of_type_Tjz != null)
    {
      this.jdField_a_of_type_Tjz.a(paramWormholeView.a(), this.jdField_a_of_type_Pnf.a());
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
        this.jdField_a_of_type_Tjz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getWormholeId(), this);
      }
    }
  }
  
  public void b(WormholeView paramWormholeView)
  {
    if (this.jdField_a_of_type_Tjz != null)
    {
      this.jdField_a_of_type_Tjz.a(paramWormholeView.a());
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
        this.jdField_a_of_type_Tjz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getWormholeId());
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131381452) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (this.jdField_a_of_type_Tjz != null)) {
      this.jdField_a_of_type_Tjz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getWormholeId(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getWormholeData());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onError(String paramString)
  {
    if ((a(paramString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView.d();
    }
  }
  
  public void onRefreshItem(String paramString)
  {
    if (a(paramString)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     png
 * JD-Core Version:    0.7.0.1
 */