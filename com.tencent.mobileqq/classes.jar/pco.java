import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.1;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.2;
import java.util.List;
import mqq.util.WeakReference;

public class pco
  implements pbm
{
  private SelectPositionModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = osg.a().a();
  private WeakReference<pcp> jdField_a_of_type_MqqUtilWeakReference;
  
  public pco(pcp parampcp)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a(this);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(parampcp);
  }
  
  private void b(List<pcm> paramList)
  {
    pcp localpcp = (pcp)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localpcp != null) && (paramList != null)) {
      localpcp.a(paramList);
    }
  }
  
  public void a()
  {
    SelectPositionModule localSelectPositionModule = osg.a().a();
    if (localSelectPositionModule != null) {
      b(localSelectPositionModule.a());
    }
  }
  
  public void a(SelectPositionModule.PositionData paramPositionData)
  {
    bdst.a().post(new SelectCityPresenter.2(this, paramPositionData));
  }
  
  public void a(List<pcm> paramList)
  {
    bdst.a().post(new SelectCityPresenter.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pco
 * JD-Core Version:    0.7.0.1
 */