import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.1;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.2;
import java.util.List;
import mqq.util.WeakReference;

public class piq
  implements pgx
{
  private SelectPositionModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = owy.a().a();
  private WeakReference<pir> jdField_a_of_type_MqqUtilWeakReference;
  
  public piq(pir parampir)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a(this);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(parampir);
  }
  
  private void b(List<pio> paramList)
  {
    pir localpir = (pir)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localpir != null) && (paramList != null)) {
      localpir.a(paramList);
    }
  }
  
  public void a()
  {
    SelectPositionModule localSelectPositionModule = owy.a().a();
    if (localSelectPositionModule != null) {
      b(localSelectPositionModule.a());
    }
  }
  
  public void a(SelectPositionModule.PositionData paramPositionData)
  {
    bfvz.a().post(new SelectCityPresenter.2(this, paramPositionData));
  }
  
  public void a(List<pio> paramList)
  {
    bfvz.a().post(new SelectCityPresenter.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     piq
 * JD-Core Version:    0.7.0.1
 */