import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.components.form.textbox.GdtCanvasFormItemTextBoxData;
import com.tencent.gdtad.views.canvas.components.form.textbox.GdtCanvasFormItemTextBoxView;

public class qqo
  implements TextWatcher
{
  public qqo(GdtCanvasFormItemTextBoxView paramGdtCanvasFormItemTextBoxView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.a.a() == null) || (!this.a.a().isValid()) || (paramEditable == null))
    {
      GdtLog.d("GdtCanvasFormItemTextBoxView", "afterTextChanged error");
      return;
    }
    GdtLog.b("GdtCanvasFormItemTextBoxView", "afterTextChanged " + paramEditable.toString());
    this.a.a().content.text = paramEditable.toString();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qqo
 * JD-Core Version:    0.7.0.1
 */