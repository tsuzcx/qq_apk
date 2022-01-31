import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.1;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.2;
import java.util.List;
import mqq.util.WeakReference;

public class pcr
  implements pbp
{
  private SelectPositionModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = osj.a().a();
  private WeakReference<pcs> jdField_a_of_type_MqqUtilWeakReference;
  
  public pcr(pcs parampcs)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a(this);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(parampcs);
  }
  
  private void b(List<pcp> paramList)
  {
    pcs localpcs = (pcs)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localpcs != null) && (paramList != null)) {
      localpcs.a(paramList);
    }
  }
  
  public void a()
  {
    SelectPositionModule localSelectPositionModule = osj.a().a();
    if (localSelectPositionModule != null) {
      b(localSelectPositionModule.a());
    }
  }
  
  public void a(SelectPositionModule.PositionData paramPositionData)
  {
    bdse.a().post(new SelectCityPresenter.2(this, paramPositionData));
  }
  
  public void a(List<pcp> paramList)
  {
    bdse.a().post(new SelectCityPresenter.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pcr
 * JD-Core Version:    0.7.0.1
 */