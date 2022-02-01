package cooperation.qqreader;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bmpb;
import bmpe;

public class ReaderSplashImpl$3$1
  implements Runnable
{
  public ReaderSplashImpl$3$1(bmpe parambmpe, View paramView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(bmpb.a(this.jdField_a_of_type_Bmpe.a));
      localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      bmpb.a(this.jdField_a_of_type_Bmpe.a, localRelativeLayout);
      return;
    }
    bmpb.a(this.jdField_a_of_type_Bmpe.a, bmpb.a(this.jdField_a_of_type_Bmpe.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.ReaderSplashImpl.3.1
 * JD-Core Version:    0.7.0.1
 */