package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import aqtl;
import aqtm;

public class ScrollTextView
  extends TextSwitcher
  implements ViewSwitcher.ViewFactory
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 2000L;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private aqtm jdField_a_of_type_Aqtm;
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private long jdField_b_of_type_Long = 800L;
  private aqtm jdField_b_of_type_Aqtm;
  
  public ScrollTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private aqtm a(boolean paramBoolean1, boolean paramBoolean2)
  {
    aqtm localaqtm = new aqtm(this, paramBoolean1, paramBoolean2);
    localaqtm.setDuration(this.jdField_b_of_type_Long);
    localaqtm.setFillAfter(false);
    localaqtm.setInterpolator(new AccelerateInterpolator());
    return localaqtm;
  }
  
  public Drawable a(int paramInt1, int paramInt2, int paramInt3)
  {
    Resources localResources = getContext().getResources();
    return new BitmapDrawable(localResources, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(localResources, paramInt1), paramInt2, paramInt3, true));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler = new aqtl(this);
    setFactory(this);
    this.jdField_a_of_type_Aqtm = a(true, true);
    this.jdField_b_of_type_Aqtm = a(false, true);
    setInAnimation(this.jdField_a_of_type_Aqtm);
    setOutAnimation(this.jdField_b_of_type_Aqtm);
  }
  
  public void b()
  {
    if (getInAnimation() != this.jdField_a_of_type_Aqtm) {
      setInAnimation(this.jdField_a_of_type_Aqtm);
    }
    if (getOutAnimation() != this.jdField_b_of_type_Aqtm) {
      setOutAnimation(this.jdField_b_of_type_Aqtm);
    }
  }
  
  public View makeView()
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setTextSize(14.0F);
    localTextView.setSingleLine(true);
    localTextView.setGravity(19);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setTextColor(Color.parseColor("#FFFF8000"));
    if (this.jdField_a_of_type_Boolean)
    {
      Drawable localDrawable = a(2130839653, 50, 50);
      if (localDrawable != null) {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      }
      return localTextView;
    }
    localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
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
  
  public void setShowPriority(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setTextArray(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
      if ((paramArrayOfString != null) && (paramArrayOfString.length > 1))
      {
        this.jdField_a_of_type_Int = 0;
        setText(paramArrayOfString[this.jdField_a_of_type_Int]);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9001, this.jdField_a_of_type_Long);
        return;
      }
    } while (paramArrayOfString.length != 1);
    setText(paramArrayOfString[0]);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(9001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.ScrollTextView
 * JD-Core Version:    0.7.0.1
 */