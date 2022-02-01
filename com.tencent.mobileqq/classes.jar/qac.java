import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.1;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.2;
import java.util.List;
import mqq.util.WeakReference;

public class qac
  implements pyh
{
  private SelectPositionModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = pmh.a().a();
  private WeakReference<qad> jdField_a_of_type_MqqUtilWeakReference;
  
  public qac(qad paramqad)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a(this);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramqad);
  }
  
  private void b(List<qaa> paramList)
  {
    qad localqad = (qad)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localqad != null) && (paramList != null)) {
      localqad.a(paramList);
    }
  }
  
  public void a()
  {
    SelectPositionModule localSelectPositionModule = pmh.a().a();
    if (localSelectPositionModule != null) {
      b(localSelectPositionModule.a());
    }
  }
  
  public void a(SelectPositionModule.PositionData paramPositionData)
  {
    bjda.a().post(new SelectCityPresenter.2(this, paramPositionData));
  }
  
  public void a(List<qaa> paramList)
  {
    bjda.a().post(new SelectCityPresenter.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qac
 * JD-Core Version:    0.7.0.1
 */