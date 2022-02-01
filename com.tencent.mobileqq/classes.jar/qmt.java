import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qmt
  implements View.OnClickListener
{
  qmt(qms paramqms) {}
  
  public void onClick(View paramView)
  {
    sgf localsgf = this.a.jdField_a_of_type_Sel.a();
    if (localsgf != null) {
      localsgf.a(null, ((ppu)this.a.jdField_a_of_type_JavaLangObject).a(), 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmt
 * JD-Core Version:    0.7.0.1
 */