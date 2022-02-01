package com.tencent.mtt.hippy.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class c
  extends ReportDialog
  implements View.OnClickListener
{
  private TextView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private c.a e;
  
  public c(Context paramContext)
  {
    super(paramContext);
    setCanceledOnTouchOutside(false);
    b();
  }
  
  private void b()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    Object localObject1 = new GradientDrawable();
    ((GradientDrawable)localObject1).setColor(-1);
    ((GradientDrawable)localObject1).setCornerRadius(PixelUtil.dp2px(8.0F));
    localLinearLayout.setBackgroundDrawable((Drawable)localObject1);
    localLinearLayout.setOrientation(1);
    this.a = new TextView(getContext());
    int i = (int)PixelUtil.dp2px(12.0F);
    this.a.setPadding(i, i, i, i);
    this.a.setTextSize(16.0F);
    this.a.setGravity(1);
    this.a.setTextColor(-16777216);
    localObject1 = new LinearLayout.LayoutParams(-1, -2);
    localLinearLayout.addView(this.a, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new ScrollView(getContext());
    ((ScrollView)localObject1).setVerticalScrollBarEnabled(false);
    this.b = new TextView(getContext());
    this.b.setGravity(17);
    this.b.setTextSize(12.0F);
    this.b.setTextColor(Color.parseColor("#424242"));
    ((ScrollView)localObject1).addView(this.b);
    Object localObject2 = new LinearLayout.LayoutParams(-1, 0);
    ((LinearLayout.LayoutParams)localObject2).gravity = 1;
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ((int)PixelUtil.dp2px(40.0F));
    ((LinearLayout.LayoutParams)localObject2).rightMargin = ((int)PixelUtil.dp2px(40.0F));
    ((LinearLayout.LayoutParams)localObject2).bottomMargin = ((int)PixelUtil.dp2px(30.0F));
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    ((View)localObject1).setBackgroundColor(Color.parseColor("#f3f3f3"));
    localLinearLayout.addView((View)localObject1, new LinearLayout.LayoutParams(-1, (int)PixelUtil.dp2px(1.0F)));
    localObject1 = new LinearLayout(getContext());
    ((LinearLayout)localObject1).setOrientation(0);
    localLinearLayout.addView((View)localObject1, new LinearLayout.LayoutParams(-1, (int)PixelUtil.dp2px(50.0F)));
    this.c = new TextView(getContext());
    this.c.setGravity(17);
    this.c.setTextSize(12.0F);
    this.c.setTextColor(-16776961);
    this.c.setFocusable(true);
    this.c.setText("reload");
    this.c.setOnClickListener(this);
    this.c.setBackgroundDrawable(a());
    localObject2 = new LinearLayout.LayoutParams(0, -1);
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    ((LinearLayout)localObject1).addView(this.c, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new View(getContext());
    ((View)localObject2).setBackgroundColor(Color.parseColor("#f3f3f3"));
    ((LinearLayout)localObject1).addView((View)localObject2, new LinearLayout.LayoutParams((int)PixelUtil.dp2px(1.0F), -1));
    this.d = new TextView(getContext());
    this.d.setGravity(17);
    this.d.setTextSize(12.0F);
    this.d.setText("cancel");
    this.d.setFocusable(true);
    this.d.setOnClickListener(this);
    this.d.setTextColor(Color.parseColor("#a1a1a1"));
    this.d.setBackgroundDrawable(a());
    localObject2 = new LinearLayout.LayoutParams(0, -1);
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    ((LinearLayout)localObject1).addView(this.d, (ViewGroup.LayoutParams)localObject2);
    setContentView(localLinearLayout);
  }
  
  StateListDrawable a()
  {
    int i = Color.parseColor("#ffddd9d9");
    StateListDrawable localStateListDrawable = new StateListDrawable();
    ColorDrawable localColorDrawable = new ColorDrawable(i);
    localStateListDrawable.addState(new int[] { 16842908, 16842910 }, localColorDrawable);
    localColorDrawable = new ColorDrawable(0);
    localStateListDrawable.addState(new int[0], localColorDrawable);
    return localStateListDrawable;
  }
  
  public void a(c.a parama)
  {
    this.e = parama;
  }
  
  public void a(Throwable paramThrowable)
  {
    this.a.setText(paramThrowable.getMessage());
    Object localObject1;
    if ((paramThrowable instanceof HippyJsException)) {
      localObject1 = this.b;
    }
    for (Object localObject2 = ((HippyJsException)paramThrowable).getStack();; localObject2 = ((StringBuilder)localObject2).toString())
    {
      ((TextView)localObject1).setText((CharSequence)localObject2);
      paramThrowable.printStackTrace();
      break;
      localObject1 = paramThrowable.getStackTrace();
      localObject2 = new StringBuilder();
      if (localObject1 != null)
      {
        int k = localObject1.length;
        int j = 0;
        int i = 0;
        while (i < k)
        {
          ((StringBuilder)localObject2).append(localObject1[i].toString());
          ((StringBuilder)localObject2).append("\n");
          ((StringBuilder)localObject2).append("\n");
          i += 1;
        }
        k = localObject1.length;
        i = j;
        while (i < k)
        {
          ((StringBuilder)localObject2).append(localObject1[i].toString());
          ((StringBuilder)localObject2).append("\n");
          ((StringBuilder)localObject2).append("\n");
          i += 1;
        }
      }
      localObject1 = this.b;
    }
    this.b.setGravity(3);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.d)
    {
      dismiss();
    }
    else if ((paramView == this.c) && (this.e != null))
    {
      dismiss();
      this.e.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.c
 * JD-Core Version:    0.7.0.1
 */