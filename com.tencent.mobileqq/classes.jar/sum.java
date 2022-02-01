import android.os.Handler;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.23.1;
import com.tencent.qphone.base.util.QLog;

public class sum
  extends pmn
{
  public sum(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void a(int paramInt, SelectPositionModule.PositionData paramPositionData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyTabFrame", 2, "onLocationChanged changeType = " + paramInt);
    }
    ReadinjoyTabFrame.a(this.a, paramInt, paramPositionData);
  }
  
  public void e(boolean paramBoolean)
  {
    if ((paramBoolean) && (RIJRedPacketManager.a().e())) {
      ReadinjoyTabFrame.a(this.a).setVisibility(0);
    }
  }
  
  public void j()
  {
    super.j();
    if (ReadinjoyTabFrame.a(this.a) != null) {
      ReadinjoyTabFrame.a(this.a).post(new ReadinjoyTabFrame.23.1(this));
    }
  }
  
  public void k()
  {
    QLog.d("ReadInJoyTabFrame", 2, "onHideChannel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sum
 * JD-Core Version:    0.7.0.1
 */