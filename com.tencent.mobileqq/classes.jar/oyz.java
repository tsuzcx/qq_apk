import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class oyz
  implements View.OnClickListener
{
  oyz(oyy paramoyy, ozb paramozb, pqc parampqc, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Oyy.a = new sxm((Activity)oyy.a(this.jdField_a_of_type_Oyy), new oza(this), this.jdField_a_of_type_Pqc.b, this.jdField_a_of_type_Pqc.a);
    this.jdField_a_of_type_Oyy.a.b(this.jdField_a_of_type_Ozb.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyz
 * JD-Core Version:    0.7.0.1
 */