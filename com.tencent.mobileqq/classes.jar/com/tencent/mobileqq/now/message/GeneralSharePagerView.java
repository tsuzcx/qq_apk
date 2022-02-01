package com.tencent.mobileqq.now.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GeneralSharePagerView
  extends RelativeLayout
{
  FrameLayout a;
  ImageView b;
  
  public GeneralSharePagerView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GeneralSharePagerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131625541, this);
    this.a = ((FrameLayout)paramContext.findViewById(2131431368));
    this.b = ((ImageView)paramContext.findViewById(2131437354));
  }
  
  public void a(View paramView)
  {
    this.a.addView(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.message.GeneralSharePagerView
 * JD-Core Version:    0.7.0.1
 */