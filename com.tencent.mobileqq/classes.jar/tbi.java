import android.view.View;
import android.view.View.OnClickListener;

class tbi
  implements View.OnClickListener
{
  tbi(tbh paramtbh, tbg paramtbg) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Tbg.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Tbh.a.a(this.jdField_a_of_type_Tbg.itemView, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tbi
 * JD-Core Version:    0.7.0.1
 */