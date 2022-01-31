import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.tencent.av.widget.shimmer.ShimmerTextView;

public class mij
  implements View.OnTouchListener
{
  final int jdField_a_of_type_Int;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  ShimmerTextView jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = null;
  public mii a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  int jdField_c_of_type_Int = 0;
  Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  ImageView jdField_c_of_type_AndroidWidgetImageView = null;
  
  public mij(Context paramContext, ImageView paramImageView1, ImageView paramImageView2, ShimmerTextView paramShimmerTextView, ImageView paramImageView3)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView1;
    this.jdField_b_of_type_AndroidWidgetImageView = paramImageView2;
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = paramShimmerTextView;
    this.jdField_c_of_type_AndroidWidgetImageView = paramImageView3;
    this.jdField_c_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131297625);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.left = (this.jdField_b_of_type_AndroidGraphicsRect.left + paramInt - this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsRect.right = (this.jdField_b_of_type_AndroidGraphicsRect.right + paramInt - this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_AndroidGraphicsRect.right >= this.jdField_c_of_type_Int)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.right = this.jdField_c_of_type_Int;
      this.jdField_a_of_type_AndroidGraphicsRect.left = (this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidWidgetImageView.getWidth());
    }
    if (this.jdField_a_of_type_AndroidGraphicsRect.left <= 0)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.left = 0;
      this.jdField_a_of_type_AndroidGraphicsRect.right = (this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidWidgetImageView.getWidth());
    }
    this.jdField_a_of_type_AndroidWidgetImageView.layout(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_b_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_b_of_type_AndroidGraphicsRect.bottom);
    this.jdField_c_of_type_AndroidWidgetImageView.layout(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_c_of_type_AndroidGraphicsRect.top, this.jdField_c_of_type_AndroidGraphicsRect.right, this.jdField_c_of_type_AndroidGraphicsRect.bottom);
  }
  
  void a()
  {
    this.jdField_b_of_type_AndroidGraphicsRect.top = this.jdField_a_of_type_AndroidWidgetImageView.getTop();
    this.jdField_b_of_type_AndroidGraphicsRect.bottom = this.jdField_a_of_type_AndroidWidgetImageView.getBottom();
    this.jdField_b_of_type_AndroidGraphicsRect.left = this.jdField_a_of_type_AndroidWidgetImageView.getLeft();
    this.jdField_b_of_type_AndroidGraphicsRect.right = this.jdField_a_of_type_AndroidWidgetImageView.getRight();
    this.jdField_a_of_type_AndroidGraphicsRect.left = this.jdField_a_of_type_AndroidWidgetImageView.getLeft();
    this.jdField_a_of_type_AndroidGraphicsRect.right = this.jdField_a_of_type_AndroidWidgetImageView.getRight();
    this.jdField_c_of_type_AndroidGraphicsRect.top = this.jdField_c_of_type_AndroidWidgetImageView.getTop();
    this.jdField_c_of_type_AndroidGraphicsRect.bottom = this.jdField_c_of_type_AndroidWidgetImageView.getBottom();
    this.jdField_c_of_type_AndroidGraphicsRect.left = this.jdField_c_of_type_AndroidWidgetImageView.getLeft();
    this.jdField_c_of_type_AndroidGraphicsRect.right = this.jdField_c_of_type_AndroidWidgetImageView.getRight();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(mii parammii)
  {
    this.jdField_a_of_type_Mii = parammii;
  }
  
  public void b()
  {
    a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getRawX();
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            this.jdField_b_of_type_Int = i;
            a();
            return true;
            if (this.jdField_a_of_type_Boolean)
            {
              a(i);
              return true;
            }
          } while (Math.abs(i - this.jdField_b_of_type_Int) <= this.jdField_a_of_type_Int);
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView.setVisibility(4);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
          return true;
          if (this.jdField_a_of_type_AndroidGraphicsRect.right != this.jdField_c_of_type_Int) {
            break;
          }
        } while (this.jdField_a_of_type_Mii == null);
        this.jdField_a_of_type_Mii.a(true);
        return true;
      } while (this.jdField_a_of_type_AndroidGraphicsRect.right >= this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetImageView.layout(this.jdField_b_of_type_AndroidGraphicsRect.left, this.jdField_b_of_type_AndroidGraphicsRect.top, this.jdField_b_of_type_AndroidGraphicsRect.right, this.jdField_b_of_type_AndroidGraphicsRect.bottom);
      this.jdField_c_of_type_AndroidWidgetImageView.layout(this.jdField_c_of_type_AndroidGraphicsRect.left, this.jdField_c_of_type_AndroidGraphicsRect.top, this.jdField_c_of_type_AndroidGraphicsRect.right, this.jdField_c_of_type_AndroidGraphicsRect.bottom);
      this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    } while (this.jdField_a_of_type_Mii == null);
    this.jdField_a_of_type_Mii.a(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mij
 * JD-Core Version:    0.7.0.1
 */