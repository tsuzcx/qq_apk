import com.tencent.biz.pubaccount.readinjoy.view.RainView;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class syz
  implements bdye
{
  public syz(RainView paramRainView, bdzh parambdzh) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView.b(this.jdField_a_of_type_Bdzh);
    if ((RainView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView).incrementAndGet() == RainView.a() * RainView.b() * RainView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView).get()) && (RainView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView) != null))
    {
      RainView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView).set(0);
      RainView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView).set(0);
      RainView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView).a();
      if (QLog.isColorLevel()) {
        QLog.d("SpriteGLView", 2, "rain animation end");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     syz
 * JD-Core Version:    0.7.0.1
 */