import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomController.2.1;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class lta
  implements msa
{
  public lta(RandomController paramRandomController) {}
  
  public void a(String paramString, msb parammsb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "onGetNearbyPeopleProfile uin :" + paramString + ", nickname:" + parammsb.b + ", gender:" + parammsb.a);
    }
    if (paramString.equals(RandomController.a(this.a).getAccount()))
    {
      if (parammsb.a != -1) {
        RandomController.a(this.a).a(parammsb.a);
      }
      if (RandomController.a(this.a).a())
      {
        if (!RandomController.a(this.a)) {
          break label209;
        }
        RandomController.b(this.a, false);
        RandomController.a(this.a).set(0);
        RandomController.a(this.a).a(RandomController.b(this.a), RandomController.c(this.a), 1, new String[0]);
        RandomController.a(this.a).a().removeCallbacks(RandomController.b(this.a));
      }
    }
    for (;;)
    {
      RandomController.a(this.a).a().post(new RandomController.2.1(this));
      return;
      label209:
      if (RandomController.b(this.a))
      {
        RandomController.c(this.a, false);
        RandomController.a(this.a).a(this.a.b, RandomController.b(this.a));
        RandomController.a(this.a).a().removeCallbacks(RandomController.b(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lta
 * JD-Core Version:    0.7.0.1
 */