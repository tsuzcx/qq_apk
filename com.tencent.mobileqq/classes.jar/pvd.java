import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pvd
  implements View.OnClickListener
{
  pvd(puz parampuz, sel paramsel, ppu paramppu) {}
  
  public void onClick(View paramView)
  {
    sgf localsgf = this.jdField_a_of_type_Sel.a();
    if (localsgf != null) {
      localsgf.a(paramView, this.jdField_a_of_type_Ppu.a(), 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pvd
 * JD-Core Version:    0.7.0.1
 */