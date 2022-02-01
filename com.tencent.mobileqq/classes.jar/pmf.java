import android.app.Activity;
import android.content.Intent;
import org.jetbrains.annotations.NotNull;

public class pmf
  extends pmb
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private boolean jdField_a_of_type_Boolean;
  
  public pmf(@NotNull pmc parampmc, Activity paramActivity)
  {
    super(parampmc, "RIJDailyPopupStep");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private boolean b()
  {
    int j = 5;
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    int i = j;
    if (localIntent != null)
    {
      i = j;
      if (localIntent.hasExtra("launch_from")) {
        i = localIntent.getIntExtra("launch_from", 5);
      }
    }
    if (i == 15) {}
    for (boolean bool = true;; bool = false)
    {
      twp.a("RIJDailyFloatingPopupStep", "isOpenFloatingWindow = " + bool);
      return bool;
    }
  }
  
  protected void g() {}
  
  protected void h() {}
  
  public void i()
  {
    this.jdField_a_of_type_Boolean = b();
    a(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pmf
 * JD-Core Version:    0.7.0.1
 */