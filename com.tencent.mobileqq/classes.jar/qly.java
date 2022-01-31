import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormError;
import com.tencent.gdtad.views.canvas.components.form.textbox.GdtCanvasFormItemTextBoxData;
import com.tencent.gdtad.views.canvas.components.form.textbox.GdtCanvasFormItemTextBoxView;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasTextData;

public class qly
  implements View.OnFocusChangeListener
{
  public qly(GdtCanvasFormItemTextBoxView paramGdtCanvasFormItemTextBoxView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((this.a.a() == null) || (!this.a.a().isValid()))
    {
      GdtLog.b("GdtCanvasFormItemTextBoxView", "onFocusChange error");
      return;
    }
    if (paramBoolean)
    {
      paramView = new GdtCanvasFormError(2, -1, this.a.a().title.text);
      paramView.b = GdtCanvasFormItemTextBoxView.a(this.a);
      GdtCanvasFormItemTextBoxView.a(this.a, paramView);
      return;
    }
    GdtCanvasFormItemTextBoxView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qly
 * JD-Core Version:    0.7.0.1
 */