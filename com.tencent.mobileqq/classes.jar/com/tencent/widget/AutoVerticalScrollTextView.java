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
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import bfqf;

public class AutoVerticalScrollTextView
  extends TextSwitcher
  implements Handler.Callback, ViewSwitcher.ViewFactory
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 1000L;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bfqf jdField_a_of_type_Bfqf;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private long jdField_b_of_type_Long = 800L;
  private bfqf jdField_b_of_type_Bfqf;
  
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
  
  private bfqf a(boolean paramBoolean1, boolean paramBoolean2)
  {
    bfqf localbfqf = new bfqf(this, paramBoolean1, paramBoolean2);
    localbfqf.setDuration(this.jdField_b_of_type_Long);
    localbfqf.setFillAfter(false);
    localbfqf.setInterpolator(new AccelerateInterpolator());
    return localbfqf;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    setFactory(this);
    this.jdField_a_of_type_Bfqf = a(true, true);
    this.jdField_b_of_type_Bfqf = a(false, true);
    setInAnimation(this.jdField_a_of_type_Bfqf);
    setOutAnimation(this.jdField_b_of_type_Bfqf);
  }
  
  public void a()
  {
    if (getInAnimation() != this.jdField_a_of_type_Bfqf) {
      setInAnimation(this.jdField_a_of_type_Bfqf);
    }
    if (getOutAnimation() != this.jdField_b_of_type_Bfqf) {
      setOutAnimation(this.jdField_b_of_type_Bfqf);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(9001);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
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
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.AutoVerticalScrollTextView
 * JD-Core Version:    0.7.0.1
 */