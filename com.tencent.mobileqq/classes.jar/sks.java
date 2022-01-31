import android.content.Context;
import com.tencent.mobileqq.widget.AnimationTextView;

public class sks
  extends bdjz
{
  AnimationTextView a;
  
  public sks(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = ((AnimationTextView)findViewById(2131376308));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sks
 * JD-Core Version:    0.7.0.1
 */