import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.ui.QavPanel;

public class jzk
  implements Animation.AnimationListener
{
  public jzk(QavPanel paramQavPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.d.clearAnimation();
    this.a.e.clearAnimation();
    this.a.f.clearAnimation();
    this.a.g.clearAnimation();
    this.a.jdField_a_of_type_AndroidWidgetFrameLayout.clearAnimation();
    this.a.jdField_b_of_type_AndroidWidgetFrameLayout.clearAnimation();
    paramAnimation = this.a.getResources().getDisplayMetrics();
    int j = (int)(paramAnimation.widthPixels * QavPanel.a());
    int i = (int)(paramAnimation.widthPixels * QavPanel.b());
    if (i > this.a.a() * 2 / 5) {
      i = this.a.a() * 2 / 5;
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams;
      if (this.a.jdField_b_of_type_Boolean)
      {
        k = (int)(paramAnimation.widthPixels * QavPanel.c());
        QavPanel.a(this.a, 2131365396, j, k);
        if (this.a.a(2131365392) == 0) {
          QavPanel.a(this.a, 2131365392, j + 10, k - 5);
        }
        for (;;)
        {
          k = (int)(paramAnimation.widthPixels * QavPanel.d());
          QavPanel.a(this.a, 2131365398, j, k);
          QavPanel.a(this.a, 2131365400, j, k);
          QavPanel.a(this.a, 2131365402, j, k);
          if (this.a.jdField_a_of_type_AndroidWidgetImageButton != null)
          {
            k = (int)(paramAnimation.widthPixels * QavPanel.e());
            localLayoutParams = (RelativeLayout.LayoutParams)this.a.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
            localLayoutParams.width = i;
            localLayoutParams.height = i;
            localLayoutParams.leftMargin = k;
            this.a.jdField_a_of_type_AndroidWidgetImageButton.setLayoutParams(localLayoutParams);
          }
          i = (int)(paramAnimation.widthPixels * QavPanel.e());
          k = (int)(paramAnimation.widthPixels * QavPanel.b());
          QavPanel.a(this.a, 2131365394, j, i * 2 + k - 5);
          return;
          QavPanel.a(this.a, 2131365390, j + 10, k - 5);
        }
      }
      int k = (int)(paramAnimation.widthPixels * QavPanel.f());
      QavPanel.a(this.a, 2131365396, j, k);
      if (this.a.a(2131365392) == 0) {
        QavPanel.a(this.a, 2131365392, j + 10, k - 5);
      }
      for (;;)
      {
        k = (int)(paramAnimation.widthPixels * QavPanel.g());
        QavPanel.a(this.a, 2131365398, j, k);
        QavPanel.a(this.a, 2131365400, j, k);
        QavPanel.a(this.a, 2131365402, j, k);
        if (this.a.jdField_a_of_type_AndroidWidgetImageButton != null)
        {
          k = (int)(paramAnimation.widthPixels * QavPanel.h());
          localLayoutParams = (RelativeLayout.LayoutParams)this.a.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
          localLayoutParams.width = i;
          localLayoutParams.height = i;
          localLayoutParams.leftMargin = k;
          this.a.jdField_a_of_type_AndroidWidgetImageButton.setLayoutParams(localLayoutParams);
        }
        i = (int)(paramAnimation.widthPixels * QavPanel.h());
        k = (int)(paramAnimation.widthPixels * QavPanel.b());
        QavPanel.a(this.a, 2131365394, j, i * 2 + k - 5);
        return;
        QavPanel.a(this.a, 2131365390, j + 10, k - 5);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jzk
 * JD-Core Version:    0.7.0.1
 */