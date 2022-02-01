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
  
  public int b()
  {
    int i = QUSDragFloatingScreenDialog.a(this.a);
    if ((i != 0) && (i != 2))
    {
      if (i != 3) {
        return 0;
      }
      return AIOUtils.b(1000.0F, this.a.getContext().getResources());
    }
    return AIOUtils.b(80.0F, this.a.getContext().getResources());
  }
  
  public int e()
  {
    if ((QUSDragFloatingScreenDialog.a(this.a) != 0) && (QUSDragFloatingScreenDialog.a(this.a) != 1)) {
      return 1;
    }
    return 0;
  }
  
  public void i()
  {
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qus.QUSDragFloatingScreenDialog.1
 * JD-Core Version:    0.7.0.1
 */