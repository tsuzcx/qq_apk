import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sug
  implements View.OnClickListener
{
  sug(suf paramsuf) {}
  
  public void onClick(View paramView)
  {
    if (suf.a(this.a) != null) {
      suf.a(this.a).onClick(paramView);
    }
    phi localphi = new phi();
    localphi.h().e().f().b().i().m();
    localphi.b("message_reddot_style", pha.k());
    oat.a(null, "", "0X800824B", "0X800824B", 0, 0, "", "", "", localphi.a(), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sug
 * JD-Core Version:    0.7.0.1
 */