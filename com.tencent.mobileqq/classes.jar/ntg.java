import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;

public class ntg
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private nth jdField_a_of_type_Nth;
  private boolean jdField_a_of_type_Boolean;
  
  public ntg(View paramView, nth paramnth)
  {
    this(paramView, paramnth, UIUtils.dip2px(paramView.getContext(), 160.0F));
  }
  
  public ntg(View paramView, nth paramnth, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Nth = paramnth;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Nth = null;
    try
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("SoftKeyboardObserver", 1, localThrowable, new Object[0]);
    }
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
        if (this.jdField_a_of_type_Nth != null)
        {
          if (i - (j - k) < this.jdField_a_of_type_Int) {
            break label113;
          }
          if (bool != this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = bool;
            this.jdField_a_of_type_Nth.a(bool, localRect.right, localRect.bottom);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ntg
 * JD-Core Version:    0.7.0.1
 */