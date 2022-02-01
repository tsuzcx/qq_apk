package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.AnimationTextView;

public class TwoLineContentDialog
  extends QQCustomDialog
{
  AnimationTextView a;
  
  public TwoLineContentDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = ((AnimationTextView)findViewById(2131377106));
  }
  
  public void a(String paramString)
  {
    AnimationTextView localAnimationTextView = this.a;
    if (localAnimationTextView != null) {
      localAnimationTextView.setText(paramString);
    }
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.TwoLineContentDialog
 * JD-Core Version:    0.7.0.1
 */