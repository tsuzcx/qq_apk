import android.animation.ObjectAnimator;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mgi
{
  public int a;
  ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator = null;
  public RelativeLayout a;
  final String jdField_a_of_type_JavaLangString;
  mgl jdField_a_of_type_Mgl = null;
  public boolean a;
  
  public mgi(RelativeLayout paramRelativeLayout, int paramInt, mgl parammgl)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = ("MenuView_" + paramInt);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Mgl = parammgl;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public RelativeLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  void a()
  {
    ObjectAnimator localObjectAnimator = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = null;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {}
    label221:
    label252:
    do
    {
      return;
      Object localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("ShowMenuView, isShow[").append(this.jdField_a_of_type_Boolean).append("], needAnimation[").append(paramBoolean).append("], lastObjectAnimator[");
      boolean bool;
      int i;
      if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null)
      {
        bool = true;
        QLog.w((String)localObject, 1, bool + "], visibility[" + this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() + "], seq[" + paramLong + "]");
        a();
        if (this.jdField_a_of_type_Mgl != null) {
          this.jdField_a_of_type_Mgl.a(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
        }
        if (!paramBoolean) {
          break label252;
        }
        i = b();
        localObject = null;
        if (paramInt != 3) {
          break label221;
        }
        localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "TranslationY", new float[] { i, 0.0F });
      }
      for (;;)
      {
        ((ObjectAnimator)localObject).setDuration(300L);
        ((ObjectAnimator)localObject).addListener(new mgk(this, i, paramLong));
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidAnimationObjectAnimator = ((ObjectAnimator)localObject);
        ((ObjectAnimator)localObject).start();
        return;
        bool = false;
        break;
        if (paramInt == 4) {
          localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 0.0F, 1.0F });
        }
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_Mgl == null);
    this.jdField_a_of_type_Mgl.a(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, mhz parammhz)
  {
    int i = 4;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      i = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility();
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("HiddenMenuView, isShow[").append(this.jdField_a_of_type_Boolean).append("], needAnimation[").append(paramBoolean).append("], visibility[").append(i).append("], lastObjectAnimator[");
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w((String)localObject, 1, bool + "], seq[" + paramLong + "]");
      a();
      if (!paramBoolean) {
        break label320;
      }
      i = b();
      localObject = null;
      if (paramInt == 2) {
        localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "TranslationY", new float[] { 0.0F, i });
      }
      if (localObject != null) {
        break;
      }
      if (!AudioHelper.e()) {
        break label319;
      }
      parammhz = anni.a(2131707706) + this.jdField_a_of_type_Boolean + "], height[" + i + "], seq[" + paramLong + "]";
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, parammhz, new Throwable("打印调用栈"));
      throw new IllegalArgumentException(parammhz);
    }
    ((ObjectAnimator)localObject).setDuration(300L);
    ((ObjectAnimator)localObject).addListener(new mgj(this, i, paramLong, parammhz));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ((ObjectAnimator)localObject);
    ((ObjectAnimator)localObject).start();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Mgl != null) {
      this.jdField_a_of_type_Mgl.b(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
    }
    label319:
    label320:
    do
    {
      return;
      if (this.jdField_a_of_type_Mgl != null) {
        this.jdField_a_of_type_Mgl.b(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_Boolean = false;
      }
    } while (this.jdField_a_of_type_Mgl == null);
    this.jdField_a_of_type_Mgl.b(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
  }
  
  int b()
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.measure(0, 0);
      i = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight();
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mgi
 * JD-Core Version:    0.7.0.1
 */