import android.view.View;
import android.view.View.OnClickListener;

class pne
  implements View.OnClickListener
{
  pne(pna parampna, pgd parampgd, rqj paramrqj) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Pgd.a();
    rro localrro = this.jdField_a_of_type_Rqj.a();
    if (localrro != null) {
      localrro.a(paramView, this.jdField_a_of_type_Pgd.a(), 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pne
 * JD-Core Version:    0.7.0.1
 */