import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class quu
  implements View.OnClickListener
{
  quu(qus paramqus) {}
  
  public void onClick(View paramView)
  {
    pha.a(this.a.jdField_a_of_type_AndroidContentContext, ((pxk)this.a.jdField_a_of_type_JavaLangObject).a(), 2, false, 2, false);
    snh.a(((pxk)this.a.jdField_a_of_type_JavaLangObject).a(), ((pxk)this.a.jdField_a_of_type_JavaLangObject).e());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     quu
 * JD-Core Version:    0.7.0.1
 */