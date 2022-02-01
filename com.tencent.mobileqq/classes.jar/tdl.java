import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.qphone.base.util.QLog;

public class tdl
  implements qgt
{
  public tdl(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      ReadinjoyTabFrame.e(this.a);
    }
    QLog.d("ReadInJoyTabFrame", 2, "ugcAccountCreateResult result = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tdl
 * JD-Core Version:    0.7.0.1
 */