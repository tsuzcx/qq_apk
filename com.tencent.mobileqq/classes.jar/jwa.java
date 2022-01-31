import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.AVEffectReport;
import com.tencent.av.ui.EffectSettingUi;

public class jwa
  implements View.OnClickListener
{
  public jwa(EffectSettingUi paramEffectSettingUi) {}
  
  public void onClick(View paramView)
  {
    EffectSettingUi.a(this.a.a);
    this.a.a(true);
    AVEffectReport.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jwa
 * JD-Core Version:    0.7.0.1
 */