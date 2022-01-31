import android.view.View;
import android.view.View.OnClickListener;

class tbl
  implements View.OnClickListener
{
  tbl(tbk paramtbk, tbj paramtbj) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Tbj.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Tbk.a.a(this.jdField_a_of_type_Tbj.itemView, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tbl
 * JD-Core Version:    0.7.0.1
 */