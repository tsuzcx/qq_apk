import android.view.View;
import android.view.View.OnLongClickListener;

class soq
  implements View.OnLongClickListener
{
  soq(soo paramsoo, son paramson) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Son.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Soo.a.b(this.jdField_a_of_type_Son.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     soq
 * JD-Core Version:    0.7.0.1
 */