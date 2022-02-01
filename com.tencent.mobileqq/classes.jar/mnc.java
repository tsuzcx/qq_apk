import android.view.MotionEvent;

class mnc
  implements mnf
{
  mnc(mmw parammmw) {}
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.a.c()) {
        break label23;
      }
      this.a.f();
    }
    for (;;)
    {
      return false;
      label23:
      if (this.a.b()) {
        this.a.e();
      } else if (mmw.a(this.a) != null) {
        mmw.a(this.a).a(paramMotionEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mnc
 * JD-Core Version:    0.7.0.1
 */