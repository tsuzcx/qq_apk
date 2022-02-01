import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.22.1;
import com.tencent.qphone.base.util.QLog;

public class tdb
  extends pvq
{
  public tdb(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void a(int paramInt, SelectPositionModule.PositionData paramPositionData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyTabFrame", 2, "onLocationChanged changeType = " + paramInt);
    }
    ReadinjoyTabFrame.a(this.a, paramInt, paramPositionData);
  }
  
  public void l()
  {
    super.l();
    if (ReadinjoyTabFrame.a(this.a) != null) {
      ReadinjoyTabFrame.a(this.a).post(new ReadinjoyTabFrame.22.1(this));
    }
  }
  
  public void m()
  {
    QLog.d("ReadInJoyTabFrame", 2, "onHideChannel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tdb
 * JD-Core Version:    0.7.0.1
 */