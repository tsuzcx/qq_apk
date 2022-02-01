import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class slk
  implements View.OnClickListener
{
  slk(slj paramslj) {}
  
  public void onClick(View paramView)
  {
    if (slj.a(this.a) != null) {
      slj.a(this.a).onClick(paramView);
    }
    paa localpaa = new paa();
    localpaa.h().e().f().b().i().m();
    localpaa.b("message_reddot_style", ozs.k());
    ocd.a(null, "", "0X800824B", "0X800824B", 0, 0, "", "", "", localpaa.a(), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     slk
 * JD-Core Version:    0.7.0.1
 */