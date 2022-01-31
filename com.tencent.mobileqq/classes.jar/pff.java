import android.view.View;
import android.view.View.OnClickListener;

class pff
  implements View.OnClickListener
{
  pff(pfb parampfb, ram paramram, pau parampau) {}
  
  public void onClick(View paramView)
  {
    rbr localrbr = this.jdField_a_of_type_Ram.a();
    if (localrbr != null) {
      localrbr.a(paramView, this.jdField_a_of_type_Pau.a(), 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pff
 * JD-Core Version:    0.7.0.1
 */