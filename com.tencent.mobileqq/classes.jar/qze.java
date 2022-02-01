import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class qze
  implements sew
{
  @Nullable
  private RIJRedPacketProgressView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView;
  private qzg jdField_a_of_type_Qzg;
  private rar jdField_a_of_type_Rar;
  
  public qze()
  {
    this(null);
  }
  
  public qze(@Nullable RIJRedPacketProgressView paramRIJRedPacketProgressView)
  {
    if (paramRIJRedPacketProgressView == null)
    {
      paramRIJRedPacketProgressView = pha.a(BaseActivity.sTopActivity);
      if (paramRIJRedPacketProgressView == null) {}
    }
    for (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView = paramRIJRedPacketProgressView.a();; this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView = paramRIJRedPacketProgressView)
    {
      this.jdField_a_of_type_Qzg = new qzg(this, null);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.a();
      }
      return;
    }
  }
  
  private void a(sey paramsey, sfb paramsfb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJVideoRedPacketManager", 2, "startRedPacketTiming:view=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView + ", title=" + paramsey.a);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView != null) {
      RIJRedPacketManager.a().a(new qzf(this, paramsey, paramsfb));
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJVideoRedPacketManager", 2, "stopRedPacketTiming: ");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.c();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.a();
    }
    pmk.a().a(this.jdField_a_of_type_Qzg);
  }
  
  public void a(sey paramsey, sfb paramsfb, int paramInt1, int paramInt2, Object paramObject)
  {
    if ((paramsey == null) || (paramsey.b)) {
      d();
    }
    do
    {
      return;
      if (paramInt2 == 3)
      {
        a(paramsey, paramsfb);
        return;
      }
    } while (paramInt1 != 3);
    d();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Rar != null) && (this.jdField_a_of_type_Rar.isShowing());
  }
  
  public void b()
  {
    pmk.a().b(this.jdField_a_of_type_Qzg);
  }
  
  public void c()
  {
    pmk.a().b(this.jdField_a_of_type_Qzg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qze
 * JD-Core Version:    0.7.0.1
 */