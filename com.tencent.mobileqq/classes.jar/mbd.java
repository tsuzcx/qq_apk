import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;

final class mbd
  extends ClickableSpan
{
  mbd(mbi parammbi) {}
  
  public void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = this.a.a();
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mbd
 * JD-Core Version:    0.7.0.1
 */