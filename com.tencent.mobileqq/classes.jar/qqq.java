import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.components.form.textbox.GdtCanvasFormItemTextBoxView;

public class qqq
  implements TextView.OnEditorActionListener
{
  public qqq(GdtCanvasFormItemTextBoxView paramGdtCanvasFormItemTextBoxView) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      GdtLog.b("GdtCanvasFormItemTextBoxView", "onEditorActionDone " + GdtCanvasFormItemTextBoxView.b(this.a));
      GdtCanvasFormItemTextBoxView.a(this.a).clearFocus();
      GdtCanvasFormItemTextBoxView.a(paramTextView);
    }
    for (;;)
    {
      return false;
      GdtLog.b("GdtCanvasFormItemTextBoxView", "onEditorAction " + paramInt + " " + GdtCanvasFormItemTextBoxView.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qqq
 * JD-Core Version:    0.7.0.1
 */