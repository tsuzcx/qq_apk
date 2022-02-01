package com.tencent.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class AutoVerticalScrollTextView
  extends TextSwitcher
  implements Handler.Callback, ViewSwitcher.ViewFactory
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 1000L;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private AutoVerticalScrollTextView.Rotate3dAnimation jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView$Rotate3dAnimation;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private long jdField_b_of_type_Long = 800L;
  private AutoVerticalScrollTextView.Rotate3dAnimation jdField_b_of_type_ComTencentWidgetAutoVerticalScrollTextView$Rotate3dAnimation;
  
  public AutoVerticalScrollTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AutoVerticalScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  private AutoVerticalScrollTextView.Rotate3dAnimation a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AutoVerticalScrollTextView.Rotate3dAnimation localRotate3dAnimation = new AutoVerticalScrollTextView.Rotate3dAnimation(this, paramBoolean1, paramBoolean2);
    localRotate3dAnimation.setDuration(this.jdField_b_of_type_Long);
    localRotate3dAnimation.setFillAfter(false);
    localRotate3dAnimation.setInterpolator(new AccelerateInterpolator());
    return localRotate3dAnimation;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    setFactory(this);
    this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView$Rotate3dAnimation = a(true, true);
    this.jdField_b_of_type_ComTencentWidgetAutoVerticalScrollTextView$Rotate3dAnimation = a(false, true);
    setInAnimation(this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView$Rotate3dAnimation);
    setOutAnimation(this.jdField_b_of_type_ComTencentWidgetAutoVerticalScrollTextView$Rotate3dAnimation);
  }
  
  public void a()
  {
    Animation localAnimation = getInAnimation();
    AutoVerticalScrollTextView.Rotate3dAnimation localRotate3dAnimation = this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView$Rotate3dAnimation;
    if (localAnimation != localRotate3dAnimation) {
      setInAnimation(localRotate3dAnimation);
    }
    localAnimation = getOutAnimation();
    localRotate3dAnimation = this.jdField_b_of_type_ComTencentWidgetAutoVerticalScrollTextView$Rotate3dAnimation;
    if (localAnimation != localRotate3dAnimation) {
      setOutAnimation(localRotate3dAnimation);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(9001);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 9001) {
      return true;
    }
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      a();
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        this.jdField_a_of_type_Int = 0;
      }
      setText(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Int]);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(9001);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9001, this.jdField_a_of_type_Long);
    return true;
  }
  
  public View makeView()
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localTextView.setTextSize(14.0F);
    localTextView.setSingleLine(true);
    localTextView.setGravity(17);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setTextColor(Color.parseColor("#777777"));
    return localTextView;
  }
  
  public void setAnimationTime(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void setInterSwitcTime(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setTextArray(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      this.jdField_a_of_type_Int = 0;
      setText(paramArrayOfString[this.jdField_a_of_type_Int]);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9001, this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AutoVerticalScrollTextView
 * JD-Core Version:    0.7.0.1
 */