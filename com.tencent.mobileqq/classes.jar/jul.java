import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.AVEffectReport;
import com.tencent.av.ui.EffectSettingUi;

public class jul
  implements View.OnClickListener
{
  public jul(EffectSettingUi paramEffectSettingUi) {}
  
  public void onClick(View paramView)
  {
    EffectSettingUi.a(this.a.a);
    this.a.a(true);
    AVEffectReport.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jul
 * JD-Core Version:    0.7.0.1
 */