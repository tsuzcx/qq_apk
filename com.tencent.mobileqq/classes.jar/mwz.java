import android.content.Context;
import android.view.Window;

public class mwz
  extends bhuf
{
  public static boolean a;
  boolean b = false;
  
  protected mwz(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramBoolean1, paramBoolean2);
  }
  
  public static mwz a(Context paramContext)
  {
    paramContext = new mwz(paramContext, false, false);
    paramContext.getWindow().setWindowAnimations(2131755223);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mwz
 * JD-Core Version:    0.7.0.1
 */