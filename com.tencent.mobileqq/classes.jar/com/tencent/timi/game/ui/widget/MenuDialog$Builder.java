package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MenuDialog$Builder
{
  private Context a;
  private CharSequence[] b;
  private DialogInterface.OnClickListener c;
  
  public MenuDialog$Builder(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public Builder a(CharSequence[] paramArrayOfCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.b = paramArrayOfCharSequence;
    this.c = paramOnClickListener;
    return this;
  }
  
  public MenuDialog a()
  {
    MenuDialog localMenuDialog = new MenuDialog(this.a, null);
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this.a).inflate(2131629428, null);
    MenuDialog.a(localMenuDialog, (LinearLayout)localViewGroup.findViewById(2131438110));
    float f = this.a.getResources().getDisplayMetrics().density;
    int i = 0;
    while (i < this.b.length)
    {
      TextView localTextView = new TextView(this.a);
      localTextView.setTextColor(-16777216);
      localTextView.setTextSize(1, 14.0F);
      int j = (int)(20.0F * f);
      localTextView.setPadding(j, 0, j, 0);
      localTextView.setBackgroundResource(2130852930);
      localTextView.setGravity(17);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, (int)(45.0F * f));
      localLayoutParams.gravity = 17;
      MenuDialog.b(localMenuDialog).addView(localTextView, localLayoutParams);
      localTextView.setTag(Integer.valueOf(i));
      localTextView.setText(this.b[i]);
      localTextView.setOnClickListener(MenuDialog.c(localMenuDialog));
      i += 1;
    }
    MenuDialog.a(localMenuDialog, this.c);
    localMenuDialog.setContentView(localViewGroup);
    return localMenuDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.MenuDialog.Builder
 * JD-Core Version:    0.7.0.1
 */