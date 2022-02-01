import android.content.Context;
import android.view.Window;

public class mvg
  extends blir
{
  public static boolean a;
  boolean b = false;
  
  protected mvg(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramBoolean1, paramBoolean2);
  }
  
  public static mvg a(Context paramContext)
  {
    paramContext = new mvg(paramContext, false, false);
    paramContext.getWindow().setWindowAnimations(2131755227);
    return paramContext;
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public void dismiss()
  {
    a = false;
    this.b = false;
    super.dismiss();
  }
  
  public void onDetachedFromWindow()
  {
    if (this.b)
    {
      a = false;
      this.b = false;
    }
    super.onDetachedFromWindow();
  }
  
  public void onStop()
  {
    if (this.b)
    {
      a = false;
      this.b = false;
    }
    super.onStop();
  }
  
  public void show()
  {
    if (a == true) {
      return;
    }
    a = true;
    this.b = true;
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mvg
 * JD-Core Version:    0.7.0.1
 */