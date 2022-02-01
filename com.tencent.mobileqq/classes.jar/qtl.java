import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qtl
  implements View.OnClickListener
{
  qtl(qtj paramqtj) {}
  
  public void onClick(View paramView)
  {
    pay.a(this.a.jdField_a_of_type_AndroidContentContext, ((pvc)this.a.jdField_a_of_type_JavaLangObject).a(), 2, false, 2, false);
    pgw.b(((pvc)this.a.jdField_a_of_type_JavaLangObject).a(), ((pvc)this.a.jdField_a_of_type_JavaLangObject).e());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qtl
 * JD-Core Version:    0.7.0.1
 */