package com.tencent.mobileqq.utils.dialogutils;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

class QQCustomMenuNoIconLayout$MenuLine
  extends LinearLayout
{
  public QQCustomMenuNoIconLayout$MenuLine(QQCustomMenuNoIconLayout paramQQCustomMenuNoIconLayout, Context paramContext)
  {
    super(paramContext);
    setOrientation(0);
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = new View(QQCustomMenuNoIconLayout.a(this.a));
    Resources localResources = QQCustomMenuNoIconLayout.a(this.a).getResources();
    int i;
    if (paramBoolean) {
      i = 2131165818;
    } else {
      i = 2131165820;
    }
    localView.setBackgroundColor(localResources.getColor(i));
    addView(localView, new LinearLayout.LayoutParams(1, -1));
    localView = new View(QQCustomMenuNoIconLayout.a(this.a));
    localResources = QQCustomMenuNoIconLayout.a(this.a).getResources();
    if (paramBoolean) {
      i = 2131165819;
    } else {
      i = 2131165821;
    }
    localView.setBackgroundColor(localResources.getColor(i));
    addView(localView, new LinearLayout.LayoutParams(1, -1));
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramView.setLayoutParams(paramLayoutParams);
    addView(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout.MenuLine
 * JD-Core Version:    0.7.0.1
 */