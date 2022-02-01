import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qju
  implements View.OnClickListener
{
  qju(qjt paramqjt, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, LinearLayout paramLinearLayout3) {}
  
  public void onClick(View paramView)
  {
    bnrf.f(ozs.a(), this.jdField_a_of_type_AndroidWidgetLinearLayout.getTop() + this.b.getTop() + this.c.getTop());
    sgf localsgf = this.jdField_a_of_type_Qjt.jdField_a_of_type_Sel.a();
    if (localsgf != null) {
      localsgf.a(null, ((ppu)this.jdField_a_of_type_Qjt.jdField_a_of_type_JavaLangObject).a(), 2);
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "firstlayout top" + this.jdField_a_of_type_AndroidWidgetLinearLayout.getTop() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "firstlayout width" + this.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "thirdlayout top" + this.b.getTop() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "thirdlayout width" + this.b.getWidth() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "secondlayout top" + this.c.getTop() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "secondlayout width" + this.c.getWidth() });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qju
 * JD-Core Version:    0.7.0.1
 */