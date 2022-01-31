import android.view.View;
import com.tencent.av.ui.EffectSettingBtn;

public class jty
  implements Runnable
{
  public jty(EffectSettingBtn paramEffectSettingBtn) {}
  
  public void run()
  {
    if (!this.a.b)
    {
      this.a.a.postDelayed(EffectSettingBtn.a(this.a), 1000L);
      return;
    }
    EffectSettingBtn.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jty
 * JD-Core Version:    0.7.0.1
 */