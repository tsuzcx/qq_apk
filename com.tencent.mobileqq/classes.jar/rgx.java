import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.24.1;
import com.tencent.qphone.base.util.QLog;

public class rgx
  extends osm
{
  public rgx(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void a(int paramInt, SelectPositionModule.PositionData paramPositionData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyTabFrame", 2, "onLocationChanged changeType = " + paramInt);
    }
    ReadinjoyTabFrame.a(this.a, paramInt, paramPositionData);
  }
  
  public void k()
  {
    super.k();
    if (ReadinjoyTabFrame.a(this.a) != null) {
      ReadinjoyTabFrame.a(this.a).post(new ReadinjoyTabFrame.24.1(this));
    }
  }
  
  public void l()
  {
    QLog.d("ReadInJoyTabFrame", 2, "onHideChannel");
    ReadinjoyTabFrame.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rgx
 * JD-Core Version:    0.7.0.1
 */