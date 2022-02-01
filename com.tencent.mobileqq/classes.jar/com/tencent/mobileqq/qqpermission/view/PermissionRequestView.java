package com.tencent.mobileqq.qqpermission.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;

public class PermissionRequestView
  extends FrameLayout
{
  private ImageView a;
  private TextView b;
  private TextView c;
  private Button d;
  private Button e;
  private Button f;
  private View.OnClickListener g;
  
  public PermissionRequestView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PermissionRequestView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PermissionRequestView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131627623, this);
    a();
  }
  
  private void a(View paramView, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public void a()
  {
    this.a = ((ImageView)findViewById(2131439986));
    this.b = ((TextView)findViewById(2131439989));
    this.c = ((TextView)findViewById(2131439985));
    this.e = ((Button)findViewById(2131439987));
    this.f = ((Button)findViewById(2131439988));
    PermissionRequestView.1 local1 = new PermissionRequestView.1(this);
    this.e.setOnClickListener(local1);
    this.f.setOnClickListener(local1);
    this.e.setVisibility(8);
    this.f.setVisibility(0);
    this.d = this.f;
    setScene(2);
  }
  
  public void setContent(int paramInt)
  {
    this.c.setText(paramInt);
  }
  
  public void setContent(CharSequence paramCharSequence)
  {
    this.c.setText(paramCharSequence);
  }
  
  public void setIcon(int paramInt)
  {
    this.a.setImageResource(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.a.setImageDrawable(paramDrawable);
  }
  
  public void setOnSettingClickListener(View.OnClickListener paramOnClickListener)
  {
    this.g = paramOnClickListener;
  }
  
  public void setScene(int paramInt)
  {
    float f3;
    float f1;
    float f2;
    int i;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      f3 = ViewUtils.dpToPx(8.0F);
      f1 = ViewUtils.dpToPx(7.5F);
      f2 = ViewUtils.dpToPx(16.0F);
      paramInt = ViewUtils.dpToPx(176.0F);
      i = ViewUtils.dpToPx(132.0F);
      this.f.setVisibility(this.d.getVisibility());
      this.e.setVisibility(8);
      this.d = this.f;
    }
    else
    {
      f3 = ViewUtils.dpToPx(12.0F);
      f1 = ViewUtils.dpToPx(8.0F);
      f2 = ViewUtils.dpToPx(16.0F);
      paramInt = ViewUtils.dpToPx(256.0F);
      i = ViewUtils.dpToPx(192.0F);
      this.e.setVisibility(this.d.getVisibility());
      this.f.setVisibility(8);
      this.d = this.e;
    }
    a(this.b, (int)f3);
    a(this.c, (int)f1);
    a(this.d, (int)f2);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = i;
    this.a.setLayoutParams(localLayoutParams);
  }
  
  public void setTitle(int paramInt)
  {
    this.b.setText(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.b.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.view.PermissionRequestView
 * JD-Core Version:    0.7.0.1
 */