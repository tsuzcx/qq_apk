import android.animation.ObjectAnimator;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mku
{
  public int a;
  ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator = null;
  public RelativeLayout a;
  final String jdField_a_of_type_JavaLangString;
  mkx jdField_a_of_type_Mkx = null;
  public boolean a;
  
  public mku(RelativeLayout paramRelativeLayout, int paramInt, mkx parammkx)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = ("MenuView_" + paramInt);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Mkx = parammkx;
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
        if (this.jdField_a_of_type_Mkx != null) {
          this.jdField_a_of_type_Mkx.a(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
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
        ((ObjectAnimator)localObject).addListener(new mkw(this, i, paramLong));
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
    } while (this.jdField_a_of_type_Mkx == null);
    this.jdField_a_of_type_Mkx.a(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, mky parammky)
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
      if (!AudioHelper.d()) {
        break label319;
      }
      parammky = alud.a(2131709330) + this.jdField_a_of_type_Boolean + "], height[" + i + "], seq[" + paramLong + "]";
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, parammky, new Throwable("打印调用栈"));
      throw new IllegalArgumentException(parammky);
    }
    ((ObjectAnimator)localObject).setDuration(300L);
    ((ObjectAnimator)localObject).addListener(new mkv(this, i, paramLong, parammky));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ((ObjectAnimator)localObject);
    ((ObjectAnimator)localObject).start();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Mkx != null) {
      this.jdField_a_of_type_Mkx.b(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
    }
    label319:
    label320:
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
      if (this.jdField_a_of_type_Mkx != null) {
        this.jdField_a_of_type_Mkx.b(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
    } while ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_Mkx == null));
    this.jdField_a_of_type_Mkx.b(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mku
 * JD-Core Version:    0.7.0.1
 */