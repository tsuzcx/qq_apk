import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class qfw
  implements rjj
{
  @Nullable
  private RIJRedPacketProgressView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView;
  private qfy jdField_a_of_type_Qfy;
  private qhj jdField_a_of_type_Qhj;
  
  public qfw()
  {
    this(null);
  }
  
  public qfw(@Nullable RIJRedPacketProgressView paramRIJRedPacketProgressView)
  {
    if (paramRIJRedPacketProgressView == null)
    {
      paramRIJRedPacketProgressView = ors.a(BaseActivity.sTopActivity);
      if (paramRIJRedPacketProgressView == null) {}
    }
    for (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView = paramRIJRedPacketProgressView.a();; this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView = paramRIJRedPacketProgressView)
    {
      this.jdField_a_of_type_Qfy = new qfy(this, null);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.a();
      }
      return;
    }
  }
  
  private void a(rjk paramrjk, rjn paramrjn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJVideoRedPacketManager", 2, "startRedPacketTiming:view=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView + ", title=" + paramrjk.a);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView != null) {
      RIJRedPacketManager.a().a(new qfx(this, paramrjk, paramrjn));
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
    oxb.a().a(this.jdField_a_of_type_Qfy);
  }
  
  public void a(rjk paramrjk, rjn paramrjn, int paramInt1, int paramInt2, Object paramObject)
  {
    if ((paramrjk == null) || (paramrjk.b)) {
      d();
    }
    do
    {
      return;
      if (paramInt2 == 3)
      {
        a(paramrjk, paramrjn);
        return;
      }
    } while (paramInt1 != 3);
    d();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Qhj != null) && (this.jdField_a_of_type_Qhj.isShowing());
  }
  
  public void b()
  {
    oxb.a().b(this.jdField_a_of_type_Qfy);
  }
  
  public void c()
  {
    oxb.a().b(this.jdField_a_of_type_Qfy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qfw
 * JD-Core Version:    0.7.0.1
 */