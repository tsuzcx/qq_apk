import android.view.View;
import android.view.View.OnLongClickListener;

class tbj
  implements View.OnLongClickListener
{
  tbj(tbh paramtbh, tbg paramtbg) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Tbg.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Tbh.a.b(this.jdField_a_of_type_Tbg.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tbj
 * JD-Core Version:    0.7.0.1
 */