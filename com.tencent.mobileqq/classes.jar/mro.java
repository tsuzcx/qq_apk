import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class mro
  extends ReportDialog
{
  public mro(Context paramContext, boolean paramBoolean) {}
  
  void a()
  {
    super.getWindow().setGravity(17);
    super.setContentView(2131559788);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      b();
    }
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131373652);
    localFrameLayout.setOnClickListener(new mrp(this));
    if (paramView != null) {
      localFrameLayout.addView(paramView);
    }
  }
  
  void b()
  {
    findViewById(2131373651).setOnClickListener(new mrq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mro
 * JD-Core Version:    0.7.0.1
 */