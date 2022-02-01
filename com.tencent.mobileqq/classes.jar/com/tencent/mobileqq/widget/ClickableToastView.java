package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import java.lang.reflect.Field;

public class ClickableToastView
  extends LinearLayout
{
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private Handler jdField_a_of_type_AndroidOsHandler = new ClickableToastView.1(this, Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ClickableToastView.RightActionParams jdField_a_of_type_ComTencentMobileqqWidgetClickableToastView$RightActionParams = new ClickableToastView.RightActionParams();
  private CharSequence jdField_a_of_type_JavaLangCharSequence = null;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 2500;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  private ClickableToastView(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentResResources = paramActivity.getResources();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramActivity).inflate(2131558867, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364194));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378964));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378961));
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window"));
  }
  
  public static int a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return 2130839273;
      }
      return 2130848044;
    }
    return 2130848043;
  }
  
  public static ClickableToastView a(Activity paramActivity, int paramInt, CharSequence paramCharSequence, ClickableToastView.RightActionParams paramRightActionParams)
  {
    paramActivity = new ClickableToastView(paramActivity);
    paramActivity.a(paramCharSequence);
    paramActivity.setType(paramInt);
    paramActivity.setToastIcon(a(paramInt));
    if (paramRightActionParams != null) {
      paramActivity.setRightActionParams(paramRightActionParams);
    }
    return paramActivity;
  }
  
  private void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  private int b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {}
      return -16777216;
    }
    return -16578533;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
    Object localObject = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    ((WindowManager.LayoutParams)localObject).gravity = 55;
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = LiuHaiUtils.a(this.jdField_a_of_type_AndroidAppActivity);
    localObject = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    ((WindowManager.LayoutParams)localObject).format = 1;
    ((WindowManager.LayoutParams)localObject).type = 2;
    ((WindowManager.LayoutParams)localObject).flags = 40;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 2131755914;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).height = -2;
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(Build.MANUFACTURER);
      if (((StringBuilder)localObject).toString().equalsIgnoreCase("SAMSUNG"))
      {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("layoutInDisplayCutoutMode").setInt(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams, 1);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ClickableToastView", 2, QLog.getStackTraceString(localException));
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableToastView$RightActionParams.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableToastView$RightActionParams.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(QQToast.b(this.jdField_a_of_type_Int), PorterDuff.Mode.MULTIPLY);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableToastView$RightActionParams.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClickableToastView$RightActionParams.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165501);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableToastView$RightActionParams.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableToastView$RightActionParams.jdField_b_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClickableToastView$RightActionParams.jdField_b_of_type_Int = 16;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, this.jdField_a_of_type_ComTencentMobileqqWidgetClickableToastView$RightActionParams.jdField_b_of_type_Int);
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131378958);
    if (Build.VERSION.SDK_INT >= 21) {
      ((View)localObject).setElevation(6.0F);
    }
    if (this.jdField_a_of_type_JavaLangCharSequence != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(b(this.jdField_a_of_type_Int));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      localObject = this.jdField_a_of_type_JavaLangCharSequence.toString();
      TextPaint localTextPaint = this.jdField_b_of_type_AndroidWidgetTextView.getPaint();
      float f2 = localTextPaint.measureText((String)localObject);
      DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics();
      float f1 = localDisplayMetrics.densityDpi / 160 * 50;
      f1 = localDisplayMetrics.widthPixels - f1;
      if (f2 > f1)
      {
        f2 = this.jdField_b_of_type_AndroidWidgetTextView.getTextSize() * 5.0F / 6.0F / localDisplayMetrics.density;
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, f2);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        f2 = localTextPaint.measureText((String)localObject);
        if (f2 > f1)
        {
          f1 = this.jdField_b_of_type_AndroidWidgetTextView.getTextSize() * f1 / f2 / localDisplayMetrics.scaledDensity;
          this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, f1);
        }
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ClickableToastView.2(this));
  }
  
  public void a()
  {
    d();
    e();
    c();
    this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, this.jdField_b_of_type_Int);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if ((localActivity != null) && (!localActivity.isFinishing()) && (this.jdField_a_of_type_AndroidViewView.getParent() != null)) {
      try
      {
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeView error:");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.e("ClickableToastView", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void setRightActionParams(ClickableToastView.RightActionParams paramRightActionParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetClickableToastView$RightActionParams = paramRightActionParams;
  }
  
  public void setToastIcon(int paramInt)
  {
    setToastIcon(this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramInt));
  }
  
  public void setToastIcon(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Int != -1) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    }
  }
  
  public void setType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ClickableToastView
 * JD-Core Version:    0.7.0.1
 */