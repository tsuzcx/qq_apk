package cooperation.qqreader;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bivh;
import bivk;

public class ReaderSplashImpl$3$1
  implements Runnable
{
  public ReaderSplashImpl$3$1(bivk parambivk, View paramView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(bivh.a(this.jdField_a_of_type_Bivk.a));
      localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      bivh.a(this.jdField_a_of_type_Bivk.a, localRelativeLayout);
      return;
    }
    bivh.a(this.jdField_a_of_type_Bivk.a, bivh.a(this.jdField_a_of_type_Bivk.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.ReaderSplashImpl.3.1
 * JD-Core Version:    0.7.0.1
 */