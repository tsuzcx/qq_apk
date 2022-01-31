import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;

class stc
  implements View.OnClickListener
{
  stc(stb paramstb, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (stb.a(this.jdField_a_of_type_Stb) != null) {
      stb.b(this.jdField_a_of_type_Stb).onItemClick(stb.a(this.jdField_a_of_type_Stb), paramView, this.jdField_a_of_type_Int, paramView.getId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     stc
 * JD-Core Version:    0.7.0.1
 */