import android.content.Context;
import com.tencent.mobileqq.widget.AnimationTextView;

public class rui
  extends bbgg
{
  AnimationTextView a;
  
  public rui(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = ((AnimationTextView)findViewById(2131375757));
  }
  
  public void a(String paramString)
  {
    if (this.a != null) {
      this.a.setText(paramString);
    }
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rui
 * JD-Core Version:    0.7.0.1
 */