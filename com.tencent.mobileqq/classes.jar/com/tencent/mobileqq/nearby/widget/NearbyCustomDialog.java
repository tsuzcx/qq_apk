package com.tencent.mobileqq.nearby.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;

public class NearbyCustomDialog
  extends Dialog
{
  protected RelativeLayout a;
  protected TextView b;
  protected TextView c;
  protected LinearLayout d;
  protected ImageView e;
  protected View.OnClickListener f = new NearbyCustomDialog.1(this);
  
  public NearbyCustomDialog(Context paramContext)
  {
    super(paramContext, 2131953338);
    a();
  }
  
  private void a()
  {
    setContentView(2131624605);
    this.a = ((RelativeLayout)findViewById(2131434917));
    this.b = ((TextView)findViewById(2131447463));
    this.c = ((TextView)findViewById(2131437922));
    this.d = ((LinearLayout)findViewById(2131429674));
    this.e = ((ImageView)findViewById(2131435536));
    this.e.setOnClickListener(this.f);
    this.e.setContentDescription(HardCodeUtil.a(2131904993));
  }
  
  public NearbyCustomDialog a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.a.addView(paramView, paramLayoutParams);
    return this;
  }
  
  public NearbyCustomDialog a(ButtonInfo paramButtonInfo)
  {
    Button localButton = new Button(getContext());
    int i = -1;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = UIUtils.a(getContext(), 10.0F);
    Object localObject;
    if (paramButtonInfo.a != null) {
      localObject = paramButtonInfo.a;
    } else {
      localObject = "";
    }
    localButton.setText((CharSequence)localObject);
    localButton.setTextSize(20.0F);
    if (paramButtonInfo.b != null) {
      localObject = paramButtonInfo.b;
    } else {
      localObject = getContext().getResources().getDrawable(2130839460);
    }
    localButton.setBackgroundDrawable((Drawable)localObject);
    if (paramButtonInfo.c != -1) {
      i = paramButtonInfo.c;
    }
    localButton.setTextColor(i);
    localButton.setOnClickListener(new NearbyCustomDialog.2(this, paramButtonInfo));
    this.d.addView(localButton, localLayoutParams);
    return this;
  }
  
  public NearbyCustomDialog a(CharSequence paramCharSequence)
  {
    this.b.setText(paramCharSequence);
    return this;
  }
  
  public NearbyCustomDialog b(CharSequence paramCharSequence)
  {
    this.c.setText(paramCharSequence);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyCustomDialog
 * JD-Core Version:    0.7.0.1
 */