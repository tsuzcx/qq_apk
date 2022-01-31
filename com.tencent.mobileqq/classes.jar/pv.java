import android.os.Handler;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETLayout;
import com.etrump.mixlayout.ETTextView;

public class pv
  implements Runnable
{
  public pv(ETTextView paramETTextView) {}
  
  public void run()
  {
    boolean bool2 = true;
    if (!ETTextView.a(this.a)) {
      return;
    }
    if (ETTextView.b(this.a)) {
      ETTextView.a(this.a, ETTextView.h);
    }
    boolean bool1;
    if ((ETTextView.c(this.a)) && (ETTextView.b(this.a)))
    {
      bool1 = true;
      if (!bool1) {
        break label147;
      }
      ETDecoration localETDecoration = this.a.a.a();
      if (!localETDecoration.nextFrame()) {
        break label124;
      }
      this.a.postInvalidate();
      long l = localETDecoration.getFrameDelay();
      ETTextView.a(this.a).postDelayed(this, l);
      bool1 = bool2;
    }
    label147:
    for (;;)
    {
      ETTextView.b(this.a, bool1);
      return;
      bool1 = false;
      break;
      label124:
      this.a.a.a(null);
      this.a.postInvalidate();
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pv
 * JD-Core Version:    0.7.0.1
 */