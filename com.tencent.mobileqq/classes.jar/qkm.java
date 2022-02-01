import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.1;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.2;
import java.util.List;
import mqq.util.WeakReference;

public class qkm
  implements qhr
{
  private SelectPositionModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = pvj.a().a();
  private WeakReference<qkn> jdField_a_of_type_MqqUtilWeakReference;
  
  public qkm(qkn paramqkn)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a(this);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramqkn);
  }
  
  private void b(List<qkk> paramList)
  {
    qkn localqkn = (qkn)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localqkn != null) && (paramList != null)) {
      localqkn.a(paramList);
    }
  }
  
  public void a()
  {
    SelectPositionModule localSelectPositionModule = pvj.a().a();
    if (localSelectPositionModule != null) {
      b(localSelectPositionModule.a());
    }
  }
  
  public void a(SelectPositionModule.PositionData paramPositionData)
  {
    bjum.a().post(new SelectCityPresenter.2(this, paramPositionData));
  }
  
  public void a(List<qkk> paramList)
  {
    bjum.a().post(new SelectCityPresenter.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qkm
 * JD-Core Version:    0.7.0.1
 */