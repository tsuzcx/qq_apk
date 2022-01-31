import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class srt
  implements CompoundButton.OnCheckedChangeListener
{
  srt(srs paramsrs) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      srs.a(this.a);
      if (srs.a(this.a)) {
        vei.a("video_shoot_slides", "clk_setting_on", 0, 0, new String[0]);
      }
    }
    for (;;)
    {
      srs.a(this.a, paramBoolean);
      return;
      srs.b(this.a);
      if (srs.a(this.a)) {
        vei.a("video_shoot_slides", "clk_setting_close", 0, 0, new String[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     srt
 * JD-Core Version:    0.7.0.1
 */