import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qlk
  implements View.OnClickListener
{
  qlk(qli paramqli) {}
  
  public void onClick(View paramView)
  {
    sgf localsgf = this.a.jdField_a_of_type_Sel.a();
    if (localsgf != null) {
      localsgf.a(null, ((ppu)this.a.jdField_a_of_type_JavaLangObject).a(), 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qlk
 * JD-Core Version:    0.7.0.1
 */