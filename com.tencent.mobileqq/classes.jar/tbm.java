import android.view.View;
import android.view.View.OnLongClickListener;

class tbm
  implements View.OnLongClickListener
{
  tbm(tbk paramtbk, tbj paramtbj) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Tbj.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Tbk.a.b(this.jdField_a_of_type_Tbj.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tbm
 * JD-Core Version:    0.7.0.1
 */