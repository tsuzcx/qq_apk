import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;

final class mai
  extends ClickableSpan
{
  mai(man paramman) {}
  
  public void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = this.a.a();
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mai
 * JD-Core Version:    0.7.0.1
 */