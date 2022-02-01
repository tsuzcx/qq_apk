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
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bivy;
import bivz;
import biwa;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.lang.reflect.Field;

public class ClickableToastView
  extends LinearLayout
{
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new bivy(this, Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private biwa jdField_a_of_type_Biwa;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  boolean jdField_a_of_type_Boolean = false;
  private TextView b;
  
  private ClickableToastView(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentResResources = paramActivity.getResources();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramActivity).inflate(2131558893, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364077));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379123));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379119));
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window"));
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2130839284;
    case 1: 
      return 2130847814;
    }
    return 2130847815;
  }
  
  public static ClickableToastView a(Activity paramActivity, int paramInt, CharSequence paramCharSequence, biwa parambiwa)
  {
    paramActivity = new ClickableToastView(paramActivity);
    paramActivity.a(paramCharSequence);
    paramActivity.setType(paramInt);
    paramActivity.setToastIcon(a(paramInt));
    paramActivity.setRightActionParams(parambiwa);
    return paramActivity;
  }
  
  private void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return -16777216;
    }
    return -16578533;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 55;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = 0;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = LiuHaiUtils.a(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = 1;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 40;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131755556;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -1;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = -2;
    try
    {
      if (("" + Build.MANUFACTURER).equalsIgnoreCase("SAMSUNG")) {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("layoutInDisplayCutoutMode").setInt(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams, 1);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ClickableToastView", 2, QLog.getStackTraceString(localException));
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Biwa.jdField_a_of_type_JavaLangString);
    this.b.setText(this.jdField_a_of_type_JavaLangCharSequence);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(QQToast.b(this.jdField_a_of_type_Int), PorterDuff.Mode.MULTIPLY);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Biwa.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_Biwa.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165511);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Biwa.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Biwa.b == 0) {
        this.jdField_a_of_type_Biwa.b = 16;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, this.jdField_a_of_type_Biwa.b);
      Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131379115);
      if (Build.VERSION.SDK_INT >= 21) {
        ((View)localObject).setElevation(6.0F);
      }
      if (this.jdField_a_of_type_JavaLangCharSequence != null)
      {
        this.b.setTextColor(b(this.jdField_a_of_type_Int));
        this.b.setText(this.jdField_a_of_type_JavaLangCharSequence);
        localObject = this.jdField_a_of_type_JavaLangCharSequence.toString();
        TextPaint localTextPaint = this.b.getPaint();
        float f2 = localTextPaint.measureText((String)localObject);
        DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics();
        float f1 = localDisplayMetrics.densityDpi / 160 * 50;
        f1 = localDisplayMetrics.widthPixels - f1;
        if (f2 > f1)
        {
          f2 = this.b.getTextSize() * 5.0F / 6.0F / localDisplayMetrics.density;
          this.b.setTextSize(2, f2);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          f2 = localTextPaint.measureText((String)localObject);
          if (f2 > f1)
          {
            f1 = this.b.getTextSize() * f1 / f2 / localDisplayMetrics.scaledDensity;
            this.b.setTextSize(2, f1);
          }
        }
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new bivz(this));
  }
  
  public void a()
  {
    d();
    e();
    c();
    this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 2500L);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  public void setRightActionParams(biwa parambiwa)
  {
    this.jdField_a_of_type_Biwa = parambiwa;
  }
  
  public void setToastIcon(int paramInt)
  {
    setToastIcon(this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramInt));
  }
  
  public void setToastIcon(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ClickableToastView
 * JD-Core Version:    0.7.0.1
 */