import android.view.View;
import android.view.View.OnClickListener;

class pgw
  implements View.OnClickListener
{
  pgw(pgs parampgs, pax parampax, rap paramrap) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Pax.a();
    rbu localrbu = this.jdField_a_of_type_Rap.a();
    if (localrbu != null) {
      localrbu.a(paramView, this.jdField_a_of_type_Pax.a(), 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgw
 * JD-Core Version:    0.7.0.1
 */