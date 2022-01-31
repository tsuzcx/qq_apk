import android.content.Context;
import com.tencent.mobileqq.widget.AnimationTextView;

public class rhs
  extends bafb
{
  AnimationTextView a;
  
  public rhs(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = ((AnimationTextView)findViewById(2131309994));
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
 * Qualified Name:     rhs
 * JD-Core Version:    0.7.0.1
 */