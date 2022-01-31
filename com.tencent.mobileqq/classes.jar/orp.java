import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.1;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.2;
import java.util.List;
import mqq.util.WeakReference;

public class orp
  implements oqo
{
  private SelectPositionModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = ogy.a().a();
  private WeakReference<orq> jdField_a_of_type_MqqUtilWeakReference;
  
  public orp(orq paramorq)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a(this);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramorq);
  }
  
  private void b(List<orn> paramList)
  {
    orq localorq = (orq)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localorq != null) && (paramList != null)) {
      localorq.a(paramList);
    }
  }
  
  public void a()
  {
    SelectPositionModule localSelectPositionModule = ogy.a().a();
    if (localSelectPositionModule != null) {
      b(localSelectPositionModule.a());
    }
  }
  
  public void a(SelectPositionModule.PositionData paramPositionData)
  {
    bcod.a().post(new SelectCityPresenter.2(this, paramPositionData));
  }
  
  public void a(List<orn> paramList)
  {
    bcod.a().post(new SelectCityPresenter.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     orp
 * JD-Core Version:    0.7.0.1
 */