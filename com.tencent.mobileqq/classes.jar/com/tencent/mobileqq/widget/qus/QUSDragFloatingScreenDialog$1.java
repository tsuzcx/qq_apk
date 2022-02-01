package com.tencent.mobileqq.widget.qus;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class QUSDragFloatingScreenDialog$1
  extends QUSDragFloatControllerAdapter
{
  public int a()
  {
    switch (QUSDragFloatingScreenDialog.a(this.a))
    {
    case 1: 
    default: 
      return 0;
    case 0: 
    case 2: 
      return AIOUtils.a(80.0F, this.a.getContext().getResources());
    }
    return AIOUtils.a(1000.0F, this.a.getContext().getResources());
  }
  
  public View a()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.a.getContext());
    localFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    TextView localTextView = new TextView(this.a.getContext());
    localTextView.setText("QUSDragFloatingScreenDialog test");
    localFrameLayout.addView(localTextView);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localTextView.setLayoutParams(localLayoutParams);
    return localFrameLayout;
  }
  
  public int d()
  {
    int i = 1;
    if ((QUSDragFloatingScreenDialog.a(this.a) == 0) || (QUSDragFloatingScreenDialog.a(this.a) == 1)) {
      i = 0;
    }
    return i;
  }
  
  public void d()
  {
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qus.QUSDragFloatingScreenDialog.1
 * JD-Core Version:    0.7.0.1
 */