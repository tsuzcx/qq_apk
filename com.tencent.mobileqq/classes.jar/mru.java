import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class mru
  extends ReportDialog
{
  public mru(Context paramContext, boolean paramBoolean) {}
  
  void a()
  {
    super.getWindow().setGravity(17);
    super.setContentView(2131559827);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      b();
    }
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131373781);
    localFrameLayout.setOnClickListener(new mrv(this));
    if (paramView != null) {
      localFrameLayout.addView(paramView);
    }
  }
  
  void b()
  {
    findViewById(2131373780).setOnClickListener(new mrw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mru
 * JD-Core Version:    0.7.0.1
 */