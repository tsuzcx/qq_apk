import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;

public class mqt
  extends Dialog
{
  public mqt(Context paramContext, boolean paramBoolean) {}
  
  void a()
  {
    super.getWindow().setGravity(17);
    super.setContentView(2131559593);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      b();
    }
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131372529);
    localFrameLayout.setOnClickListener(new mqu(this));
    if (paramView != null) {
      localFrameLayout.addView(paramView);
    }
  }
  
  void b()
  {
    findViewById(2131372528).setOnClickListener(new mqv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mqt
 * JD-Core Version:    0.7.0.1
 */