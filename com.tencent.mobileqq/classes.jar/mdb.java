import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;

final class mdb
  extends ClickableSpan
{
  mdb(mdg parammdg) {}
  
  public void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = this.a.a();
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mdb
 * JD-Core Version:    0.7.0.1
 */