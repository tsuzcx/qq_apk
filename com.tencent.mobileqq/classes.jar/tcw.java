import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tcw
  implements View.OnClickListener
{
  tcw(tcv paramtcv) {}
  
  public void onClick(View paramView)
  {
    if (tcv.a(this.a) != null) {
      tcv.a(this.a).onClick(paramView);
    }
    Object localObject = new pqg();
    ((pqg)localObject).h().e().f().b().i().m();
    ((pqg)localObject).b("message_reddot_style", pro.b());
    localObject = ((pqg)localObject).a();
    olh.a(null, "", "0X800824B", "0X800824B", 0, 0, "", "", "", pqd.a.a((String)localObject), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tcw
 * JD-Core Version:    0.7.0.1
 */