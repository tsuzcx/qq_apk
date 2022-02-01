package cooperation.qqreader;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

class ReaderSplashImpl$3$1
  implements Runnable
{
  ReaderSplashImpl$3$1(ReaderSplashImpl.3 param3, View paramView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(ReaderSplashImpl.a(this.jdField_a_of_type_CooperationQqreaderReaderSplashImpl$3.a));
      localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      ReaderSplashImpl.a(this.jdField_a_of_type_CooperationQqreaderReaderSplashImpl$3.a, localRelativeLayout);
      return;
    }
    ReaderSplashImpl.a(this.jdField_a_of_type_CooperationQqreaderReaderSplashImpl$3.a, ReaderSplashImpl.a(this.jdField_a_of_type_CooperationQqreaderReaderSplashImpl$3.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.ReaderSplashImpl.3.1
 * JD-Core Version:    0.7.0.1
 */