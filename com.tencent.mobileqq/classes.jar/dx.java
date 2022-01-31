import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.widget.Switch;

public class dx
  implements CompoundButton.OnCheckedChangeListener
{
  public dx(LiteAdvanceActivity paramLiteAdvanceActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!LiteAdvanceActivity.a(this.a, paramBoolean))
    {
      paramCompoundButton = LiteAdvanceActivity.a(this.a);
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramCompoundButton.setChecked(paramBoolean);
        bcql.a(this.a, 1, ajya.a(2131706194), 0).b(this.a.getTitleBarHeight());
        return;
      }
    }
    LiteAdvanceActivity.b(this.a, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     dx
 * JD-Core Version:    0.7.0.1
 */