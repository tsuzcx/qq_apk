import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class lpt
  implements lqa
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new lpu(this);
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  final String jdField_a_of_type_JavaLangString = "AvTipsView_" + AudioHelper.b();
  lpw jdField_a_of_type_Lpw;
  lpx jdField_a_of_type_Lpx;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  
  static void a(TextView paramTextView, lpy paramlpy)
  {
    paramTextView.setTextSize(paramlpy.jdField_a_of_type_Int);
    paramTextView.setTextColor(paramlpy.b);
    paramTextView.setText(paramlpy.jdField_a_of_type_AndroidTextSpannableString);
    paramTextView.setVisibility(0);
    lpy.a(paramTextView, paramlpy.c, paramlpy.d);
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "RemoveMainTipsView");
    }
    if (this.jdField_a_of_type_Lpw != null) {
      this.jdField_a_of_type_Lpw.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Lpw != null) {
      this.jdField_a_of_type_Lpw.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void a(long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    float f;
    do
    {
      return;
      f = this.jdField_a_of_type_AndroidWidgetLinearLayout.getRotation();
    } while (f == paramFloat);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setRotation, rotation[" + f + "->" + paramFloat + "], seq[" + paramLong + "]");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(paramFloat);
    a(true);
  }
  
  void a(RelativeLayout.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.height = -2;
    paramLayoutParams.topMargin = (this.b + (int)mjg.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), 6.0F));
    paramLayoutParams.addRule(14, -1);
    paramLayoutParams.addRule(13, 0);
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    if (this.jdField_a_of_type_Boolean) {
      f();
    }
    ((kyu)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).b();
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
  }
  
  public void a(VideoAppInterface paramVideoAppInterface, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131306797);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131306795));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Lpw = new lpw(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_Lpx = new lpx(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    e();
  }
  
  void a(boolean paramBoolean)
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    int j;
    int k;
    do
    {
      return;
      j = this.jdField_a_of_type_AndroidViewView.getWidth();
      k = this.jdField_a_of_type_AndroidViewView.getHeight();
    } while ((this.jdField_a_of_type_Int == j) && (this.b == k) && (!paramBoolean));
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("adjustPos, w[").append(this.jdField_a_of_type_Int).append("->").append(j).append("], h[").append(this.b).append("->").append(k).append("], force[").append(paramBoolean).append("], tips_layout[");
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.w((String)localObject, 1, paramBoolean + "]");
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        break;
      }
      this.jdField_a_of_type_Int = j;
      this.b = k;
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
      j = ((kvq)localObject).d;
      if (j != 2) {
        break label319;
      }
      if ((((kvq)localObject).k) || (((kvq)localObject).j)) {
        break label416;
      }
      i = 1;
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "adjustPos, sessionType[" + ((kvq)localObject).d + "->" + i + "]");
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      switch (i)
      {
      default: 
        label304:
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
    }
    label319:
    if (j == 4)
    {
      if (((kvq)localObject).c.size() <= 0) {
        break label421;
      }
      paramBoolean = ((leb)((kvq)localObject).c.get(0)).b;
      i = ((leb)((kvq)localObject).c.get(0)).jdField_a_of_type_Int;
    }
    for (;;)
    {
      if ((!paramBoolean) || (i == 0))
      {
        i = 3;
        break;
        a((RelativeLayout.LayoutParams)localObject);
        break label304;
        b((RelativeLayout.LayoutParams)localObject);
        break label304;
        c((RelativeLayout.LayoutParams)localObject);
        break label304;
        d((RelativeLayout.LayoutParams)localObject);
        break label304;
      }
      label416:
      i = j;
      break;
      label421:
      paramBoolean = true;
    }
  }
  
  public void a(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((this.jdField_a_of_type_Lpx != null) && (this.jdField_a_of_type_Lpx.a != null))
    {
      this.jdField_a_of_type_Lpx.a.setOnClickListener(paramOnClickListener);
      if (paramBoolean) {
        mit.a(this.jdField_a_of_type_Lpx.a, 2130841457, 2131100268);
      }
      paramOnClickListener = this.jdField_a_of_type_Lpx.a;
      if (!paramBoolean) {
        break label68;
      }
    }
    label68:
    for (int i = 0;; i = 8)
    {
      paramOnClickListener.setVisibility(i);
      return;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Lpw == null) {
      return false;
    }
    return this.jdField_a_of_type_Lpw.a();
  }
  
  public boolean a(lqd paramlqd)
  {
    if (this.jdField_a_of_type_Lpw == null) {
      return false;
    }
    paramlqd = lpy.a(this.jdField_a_of_type_Lpw.a(), paramlqd, this.jdField_a_of_type_Lpw);
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "ShowMainTipsView, tipsInfo[" + paramlqd.jdField_a_of_type_AndroidTextSpannableString + "]");
    }
    return this.jdField_a_of_type_Lpw.a(paramlqd);
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "RemoveSubTipView");
    }
    if (this.jdField_a_of_type_Lpx != null) {
      this.jdField_a_of_type_Lpx.a();
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Lpw != null) && (this.jdField_a_of_type_Lpw.jdField_a_of_type_AndroidWidgetProgressBar != null)) {
      this.jdField_a_of_type_Lpw.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
    }
  }
  
  void b(RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (float f = this.jdField_a_of_type_AndroidWidgetLinearLayout.getRotation();; f = 0.0F)
    {
      if (f % 180.0F == 0.0F)
      {
        paramLayoutParams.height = -2;
        paramLayoutParams.topMargin = ((int)mjg.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), 188.0F));
        paramLayoutParams.addRule(14, -1);
        paramLayoutParams.addRule(13, 0);
        return;
      }
      paramLayoutParams.height = (mjg.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext()) * 23 / 25);
      paramLayoutParams.topMargin = 0;
      paramLayoutParams.addRule(14, 0);
      paramLayoutParams.addRule(13, -1);
      return;
    }
  }
  
  public void b(VideoAppInterface paramVideoAppInterface) {}
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Lpx == null) {
      return false;
    }
    return this.jdField_a_of_type_Lpx.a();
  }
  
  public boolean b(lqd paramlqd)
  {
    if (this.jdField_a_of_type_Lpx == null) {
      return false;
    }
    paramlqd = lpy.a(this.jdField_a_of_type_Lpx.a(), paramlqd, this.jdField_a_of_type_Lpx);
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "ShowSubTipsView, tipsInfo[" + paramlqd.jdField_a_of_type_AndroidTextSpannableString + "]");
    }
    return this.jdField_a_of_type_Lpx.a(paramlqd);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Lpw != null) {
      this.jdField_a_of_type_Lpw.a(4);
    }
    if (this.jdField_a_of_type_Lpx != null) {
      this.jdField_a_of_type_Lpx.a(4);
    }
  }
  
  void c(RelativeLayout.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.height = -2;
    paramLayoutParams.topMargin = (this.b + (int)mjg.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), 6.0F));
    paramLayoutParams.addRule(14, -1);
    paramLayoutParams.addRule(13, 0);
  }
  
  public void c(VideoAppInterface paramVideoAppInterface)
  {
    e();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Lpw != null) {
      this.jdField_a_of_type_Lpw.a(0);
    }
    if (this.jdField_a_of_type_Lpx != null) {
      this.jdField_a_of_type_Lpx.a(0);
    }
  }
  
  void d(RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (float f = this.jdField_a_of_type_AndroidWidgetLinearLayout.getRotation();; f = 0.0F)
    {
      if (f % 180.0F == 0.0F)
      {
        paramLayoutParams.height = -2;
        paramLayoutParams.topMargin = ((int)mjg.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), 188.0F));
        paramLayoutParams.addRule(14, -1);
        paramLayoutParams.addRule(13, 0);
        return;
      }
      paramLayoutParams.height = (mjg.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext()) * 23 / 25);
      paramLayoutParams.topMargin = 0;
      paramLayoutParams.addRule(14, 0);
      paramLayoutParams.addRule(13, -1);
      return;
    }
  }
  
  void e()
  {
    String str;
    StringBuilder localStringBuilder;
    if (AudioHelper.e())
    {
      str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("attach, isAttach[").append(this.jdField_a_of_type_Boolean).append("], titleBar[");
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break label131;
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.jdField_a_of_type_Boolean) {
        f();
      }
      if (!this.jdField_a_of_type_Boolean) {
        ((kyu)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).a(this);
      }
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      a(true);
      return;
    }
  }
  
  void f()
  {
    String str;
    StringBuilder localStringBuilder;
    if (AudioHelper.e())
    {
      str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("detach, isAttach[").append(this.jdField_a_of_type_Boolean).append("], qav_activity_root[");
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break label123;
      }
    }
    label123:
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.jdField_a_of_type_Boolean) {
        ((kyu)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).a(null);
      }
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        if (Build.VERSION.SDK_INT < 16) {
          break;
        }
        this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      return;
    }
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpt
 * JD-Core Version:    0.7.0.1
 */