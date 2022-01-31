import android.view.ViewGroup;
import android.widget.TextView;

public class swe
  extends swc
{
  protected TextView c = (TextView)a(2131312820);
  
  public swe(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a(ssm paramssm)
  {
    if (paramssm.b > 99)
    {
      this.c.setText("99+");
      return;
    }
    this.c.setText(String.valueOf(paramssm.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swe
 * JD-Core Version:    0.7.0.1
 */