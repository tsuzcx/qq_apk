import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rfv
  implements View.OnClickListener
{
  rfv(rft paramrft) {}
  
  public void onClick(View paramView)
  {
    pqx.a(this.a.jdField_a_of_type_AndroidContentContext, ((qfw)this.a.jdField_a_of_type_JavaLangObject).a(), 2, false, 2, false);
    pqb.b(((qfw)this.a.jdField_a_of_type_JavaLangObject).a(), ((qfw)this.a.jdField_a_of_type_JavaLangObject).e());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rfv
 * JD-Core Version:    0.7.0.1
 */