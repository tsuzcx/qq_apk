import com.tencent.biz.now.NowLiveManager;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.observer.GetRedPointExObserver;

public class tbf
  extends GetRedPointExObserver
{
  public tbf(MainFragment paramMainFragment) {}
  
  protected void a(Object paramObject)
  {
    paramObject = MainFragment.a(this.a).a();
    if ((paramObject == null) || (!paramObject.a)) {
      return;
    }
    MainFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tbf
 * JD-Core Version:    0.7.0.1
 */