import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.1;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.2;
import java.util.List;
import mqq.util.WeakReference;

public class pyh
  implements pwl
{
  private SelectPositionModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = pkm.a().a();
  private WeakReference<pyi> jdField_a_of_type_MqqUtilWeakReference;
  
  public pyh(pyi parampyi)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a(this);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(parampyi);
  }
  
  private void b(List<pyf> paramList)
  {
    pyi localpyi = (pyi)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localpyi != null) && (paramList != null)) {
      localpyi.a(paramList);
    }
  }
  
  public void a()
  {
    SelectPositionModule localSelectPositionModule = pkm.a().a();
    if (localSelectPositionModule != null) {
      b(localSelectPositionModule.a());
    }
  }
  
  public void a(SelectPositionModule.PositionData paramPositionData)
  {
    bijk.a().post(new SelectCityPresenter.2(this, paramPositionData));
  }
  
  public void a(List<pyf> paramList)
  {
    bijk.a().post(new SelectCityPresenter.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyh
 * JD-Core Version:    0.7.0.1
 */