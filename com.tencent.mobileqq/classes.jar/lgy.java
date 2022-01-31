import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.app.PublicAccountObserver;
import java.util.ArrayList;

public class lgy
  extends PublicAccountObserver
{
  public lgy(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (paramBoolean) {
      ReadInJoyDeliverBiuActivity.a(this.a, paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lgy
 * JD-Core Version:    0.7.0.1
 */