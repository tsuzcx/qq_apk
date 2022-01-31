import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class sfa
  implements CompoundButton.OnCheckedChangeListener
{
  sfa(sez paramsez) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      sez.a(this.a);
      if (sez.a(this.a)) {
        urp.a("video_shoot_slides", "clk_setting_on", 0, 0, new String[0]);
      }
    }
    for (;;)
    {
      sez.a(this.a, paramBoolean);
      return;
      sez.b(this.a);
      if (sez.a(this.a)) {
        urp.a("video_shoot_slides", "clk_setting_close", 0, 0, new String[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sfa
 * JD-Core Version:    0.7.0.1
 */