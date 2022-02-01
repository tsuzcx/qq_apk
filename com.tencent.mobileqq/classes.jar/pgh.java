import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pgh
  implements View.OnClickListener
{
  pgh(pgg parampgg, pgj parampgj, pxs parampxs, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Pgg.a = new tgs((Activity)pgg.a(this.jdField_a_of_type_Pgg), new pgi(this), this.jdField_a_of_type_Pxs.b, this.jdField_a_of_type_Pxs.a);
    this.jdField_a_of_type_Pgg.a.b(this.jdField_a_of_type_Pgj.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgh
 * JD-Core Version:    0.7.0.1
 */