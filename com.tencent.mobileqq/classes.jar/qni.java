import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qni
  implements View.OnClickListener
{
  qni(qng paramqng) {}
  
  public void onClick(View paramView)
  {
    ozs.a(this.a.jdField_a_of_type_AndroidContentContext, ((ppu)this.a.jdField_a_of_type_JavaLangObject).a(), 2, false, 2, false);
    sel.a(((ppu)this.a.jdField_a_of_type_JavaLangObject).a(), ((ppu)this.a.jdField_a_of_type_JavaLangObject).e());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qni
 * JD-Core Version:    0.7.0.1
 */