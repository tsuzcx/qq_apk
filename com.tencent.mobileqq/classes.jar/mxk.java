import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;

public class mxk
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private mxl jdField_a_of_type_Mxl;
  private boolean jdField_a_of_type_Boolean;
  
  public mxk(View paramView, mxl parammxl)
  {
    this(paramView, parammxl, vzl.a(paramView.getContext(), 160.0F));
  }
  
  public mxk(View paramView, mxl parammxl, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Mxl = parammxl;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Mxl = null;
    try
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void onGlobalLayout()
  {
    boolean bool = true;
    Rect localRect = new Rect();
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
        int i = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight();
        int j = localRect.bottom;
        int k = localRect.top;
        if (this.jdField_a_of_type_Mxl != null)
        {
          if (i - (j - k) < this.jdField_a_of_type_Int) {
            break label113;
          }
          if (bool != this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = bool;
            this.jdField_a_of_type_Mxl.a(bool, localRect.right, localRect.bottom);
          }
        }
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        QLog.e("SoftKeyboardObserver", 1, "getWindowVisibleDisplayFrame error", localNullPointerException);
        return;
      }
      label113:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mxk
 * JD-Core Version:    0.7.0.1
 */