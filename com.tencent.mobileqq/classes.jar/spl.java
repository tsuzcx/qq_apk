import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class spl
  implements View.OnClickListener
{
  spl(spk paramspk) {}
  
  public void onClick(View paramView)
  {
    if (spk.a(this.a) != null) {
      spk.a(this.a).onClick(paramView);
    }
    pbg localpbg = new pbg();
    localpbg.h().e().f().b().i().m();
    localpbg.b("message_reddot_style", pay.k());
    odq.a(null, "", "0X800824B", "0X800824B", 0, 0, "", "", "", localpbg.a(), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     spl
 * JD-Core Version:    0.7.0.1
 */