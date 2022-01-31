import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class srw
  implements CompoundButton.OnCheckedChangeListener
{
  srw(srv paramsrv) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      srv.a(this.a);
      if (srv.a(this.a)) {
        vel.a("video_shoot_slides", "clk_setting_on", 0, 0, new String[0]);
      }
    }
    for (;;)
    {
      srv.a(this.a, paramBoolean);
      return;
      srv.b(this.a);
      if (srv.a(this.a)) {
        vel.a("video_shoot_slides", "clk_setting_close", 0, 0, new String[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     srw
 * JD-Core Version:    0.7.0.1
 */