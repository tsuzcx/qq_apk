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
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import blov;

public class QzoneAutoVerticalScrollTextView
  extends TextSwitcher
  implements Handler.Callback, ViewSwitcher.ViewFactory
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 2500L;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private blov jdField_a_of_type_Blov;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private long jdField_b_of_type_Long = 1000L;
  private blov jdField_b_of_type_Blov;
  
  public QzoneAutoVerticalScrollTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QzoneAutoVerticalScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  private blov a(boolean paramBoolean1, boolean paramBoolean2)
  {
    blov localblov = new blov(this, paramBoolean1, paramBoolean2);
    localblov.setDuration(this.jdField_b_of_type_Long);
    localblov.setFillAfter(false);
    localblov.setInterpolator(new AccelerateInterpolator());
    return localblov;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    setFactory(this);
    this.jdField_a_of_type_Blov = a(true, true);
    this.jdField_b_of_type_Blov = a(false, true);
  }
  
  public void a()
  {
    if (getInAnimation() != this.jdField_a_of_type_Blov) {
      setInAnimation(this.jdField_a_of_type_Blov);
    }
    if (getOutAnimation() != this.jdField_b_of_type_Blov) {
      setOutAnimation(this.jdField_b_of_type_Blov);
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
    localTextView.setTextSize(11.0F);
    localTextView.setSingleLine(true);
    localTextView.setGravity(19);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setTextColor(Color.parseColor("#777777"));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 17;
    localTextView.setLayoutParams(localLayoutParams);
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
      if (this.jdField_a_of_type_Int > paramArrayOfString.length - 1) {
        this.jdField_a_of_type_Int = 0;
      }
      setText(paramArrayOfString[this.jdField_a_of_type_Int]);
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(9001);
      }
      if (paramArrayOfString.length <= 1) {
        break label102;
      }
      setInAnimation(this.jdField_a_of_type_Blov);
      setOutAnimation(this.jdField_b_of_type_Blov);
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9001, this.jdField_a_of_type_Long);
      }
    }
    return;
    label102:
    setInAnimation(null);
    setOutAnimation(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.QzoneAutoVerticalScrollTextView
 * JD-Core Version:    0.7.0.1
 */