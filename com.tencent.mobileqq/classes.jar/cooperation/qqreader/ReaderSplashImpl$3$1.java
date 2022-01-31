package cooperation.qqreader;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bgui;
import bgul;

public class ReaderSplashImpl$3$1
  implements Runnable
{
  public ReaderSplashImpl$3$1(bgul parambgul, View paramView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(bgui.a(this.jdField_a_of_type_Bgul.a));
      localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      bgui.a(this.jdField_a_of_type_Bgul.a, localRelativeLayout);
      return;
    }
    bgui.a(this.jdField_a_of_type_Bgul.a, bgui.a(this.jdField_a_of_type_Bgul.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.ReaderSplashImpl.3.1
 * JD-Core Version:    0.7.0.1
 */