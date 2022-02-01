package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qqocr.impl.R.styleable;

public class OCRBottomTabView
  extends LinearLayout
{
  private ImageView a;
  private TextView b;
  
  public OCRBottomTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public OCRBottomTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(paramContext).inflate(2131627611, this, true);
    this.b = ((TextView)findViewById(2131448211));
    this.a = ((ImageView)findViewById(2131436155));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.be);
    paramAttributeSet = paramContext.getString(R.styleable.bg);
    Drawable localDrawable = paramContext.getDrawable(R.styleable.bf);
    paramContext.recycle();
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      this.b.setText(paramAttributeSet);
    }
    if (localDrawable != null) {
      this.a.setImageDrawable(localDrawable);
    }
  }
  
  public CharSequence getTabText()
  {
    return this.b.getText();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.a.setEnabled(paramBoolean);
    this.b.setEnabled(paramBoolean);
  }
  
  public void setTabImage(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.a.setImageDrawable(paramDrawable);
    }
  }
  
  public void setTabText(String paramString)
  {
    if (paramString != null) {
      this.b.setText(paramString);
    }
  }
  
  public void setTabTextColor(int paramInt)
  {
    ColorStateList localColorStateList = ColorStateList.valueOf(paramInt);
    this.b.setTextColor(localColorStateList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OCRBottomTabView
 * JD-Core Version:    0.7.0.1
 */