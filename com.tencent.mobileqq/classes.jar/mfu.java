import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;

public class mfu
  extends Dialog
{
  public mfu(Context paramContext, boolean paramBoolean) {}
  
  void a()
  {
    super.getWindow().setGravity(17);
    super.setContentView(2131494022);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      b();
    }
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131306819);
    localFrameLayout.setOnClickListener(new mfv(this));
    if (paramView != null) {
      localFrameLayout.addView(paramView);
    }
  }
  
  void b()
  {
    findViewById(2131306818).setOnClickListener(new mfw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mfu
 * JD-Core Version:    0.7.0.1
 */