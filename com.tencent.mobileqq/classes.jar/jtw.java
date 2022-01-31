import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.AVEffectReport;
import com.tencent.av.ui.EffectSettingUi;

public class jtw
  implements View.OnClickListener
{
  public jtw(EffectSettingUi paramEffectSettingUi) {}
  
  public void onClick(View paramView)
  {
    EffectSettingUi.a(this.a.a);
    this.a.a(true);
    AVEffectReport.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jtw
 * JD-Core Version:    0.7.0.1
 */