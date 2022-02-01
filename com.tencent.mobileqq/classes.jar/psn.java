import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.1;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.2;
import java.util.List;
import mqq.util.WeakReference;

public class psn
  implements pqr
{
  private SelectPositionModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = pfa.a().a();
  private WeakReference<pso> jdField_a_of_type_MqqUtilWeakReference;
  
  public psn(pso parampso)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a(this);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(parampso);
  }
  
  private void b(List<psl> paramList)
  {
    pso localpso = (pso)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localpso != null) && (paramList != null)) {
      localpso.a(paramList);
    }
  }
  
  public void a()
  {
    SelectPositionModule localSelectPositionModule = pfa.a().a();
    if (localSelectPositionModule != null) {
      b(localSelectPositionModule.a());
    }
  }
  
  public void a(SelectPositionModule.PositionData paramPositionData)
  {
    bkdz.a().post(new SelectCityPresenter.2(this, paramPositionData));
  }
  
  public void a(List<psl> paramList)
  {
    bkdz.a().post(new SelectCityPresenter.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psn
 * JD-Core Version:    0.7.0.1
 */