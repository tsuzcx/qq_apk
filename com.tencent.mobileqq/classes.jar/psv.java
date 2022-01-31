import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class psv
  implements rgr
{
  public psv(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "startDrag!");
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (ReadInJoyDeliverUGCActivity.a(this.a) != 0)
    {
      Integer localInteger = (Integer)ReadInJoyDeliverUGCActivity.a(this.a).remove(paramInt1);
      ReadInJoyDeliverUGCActivity.a(this.a).add(paramInt2, localInteger);
      ndn.a(null, "", "0X800953F", "0X800953F", 0, 0, "", "", "", obz.e(), false);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "change position old position=" + paramInt1 + " new position" + paramInt2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     psv
 * JD-Core Version:    0.7.0.1
 */