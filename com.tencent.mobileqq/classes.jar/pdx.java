import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.WormholeView;
import com.tencent.viola.vinstance.VInstanceAction.VInstanceEventListener;

public class pdx
  implements View.OnClickListener, VInstanceAction.VInstanceEventListener, srp
{
  private int jdField_a_of_type_Int;
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private WormholeView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView;
  private pdw jdField_a_of_type_Pdw;
  private sro jdField_a_of_type_Sro;
  
  public pdx(sro paramsro, WormholeView paramWormholeView, pdw parampdw)
  {
    this.jdField_a_of_type_Sro = paramsro;
    this.jdField_a_of_type_Pdw = parampdw;
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
    if ((this.jdField_a_of_type_Sro != null) && (this.jdField_a_of_type_Sro.a(paramBaseArticleInfo, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView.a())))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView.c();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView.b();
  }
  
  public void a(WormholeView paramWormholeView)
  {
    if (this.jdField_a_of_type_Sro != null)
    {
      this.jdField_a_of_type_Sro.a(paramWormholeView.a(), this.jdField_a_of_type_Pdw.a());
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
        this.jdField_a_of_type_Sro.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getWormholeId(), this);
      }
    }
  }
  
  public void b(WormholeView paramWormholeView)
  {
    if (this.jdField_a_of_type_Sro != null)
    {
      this.jdField_a_of_type_Sro.a(paramWormholeView.a());
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
        this.jdField_a_of_type_Sro.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getWormholeId());
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131380232) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (this.jdField_a_of_type_Sro != null)) {
      this.jdField_a_of_type_Sro.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getWormholeId(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getWormholeData());
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pdx
 * JD-Core Version:    0.7.0.1
 */