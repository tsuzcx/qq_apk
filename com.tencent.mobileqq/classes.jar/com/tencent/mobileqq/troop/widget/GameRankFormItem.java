package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.mobileqq.widget.FormResHelper;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.MultiImageTextView;

public class GameRankFormItem
  extends FormSimpleItem
{
  public int a;
  
  public GameRankFormItem(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a()
  {
    if (this.D == null) {
      return;
    }
    c();
    if (this.C != null) {
      this.C.setMaxWidth(this.F);
    }
    if (this.a > 0)
    {
      if (this.t == null) {
        this.t = "";
      }
      this.D.setVisibility(0);
      int i = this.a;
      if (i >= 4)
      {
        localObject1 = this.D;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.t);
        ((StringBuilder)localObject2).append(String.valueOf(this.a));
        ((MultiImageTextView)localObject1).setText(((StringBuilder)localObject2).toString());
      }
      else if (i > 0)
      {
        localObject1 = getResources();
        i = this.a;
        if (i == 1) {
          i = 2130844862;
        } else if (i == 2) {
          i = 2130844863;
        } else {
          i = 2130844864;
        }
        localObject1 = ((Resources)localObject1).getDrawable(i);
        localObject2 = this.t;
        TextPaint localTextPaint = this.D.getPaint();
        int k = this.E;
        if (this.u == null) {
          i = 0;
        } else {
          i = this.u.getIntrinsicWidth();
        }
        int j;
        if (this.y) {
          j = this.z.getIntrinsicWidth();
        } else {
          j = 0;
        }
        localObject2 = TextUtils.ellipsize((CharSequence)localObject2, localTextPaint, k - i - j - ((Drawable)localObject1).getIntrinsicWidth(), TextUtils.TruncateAt.END);
        this.D.setText((CharSequence)localObject2);
        this.D.a((Drawable)localObject1, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight()).c();
      }
      this.D.setTextColor(FormResHelper.a(getResources(), this.x));
      Object localObject1 = this.D;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.t);
      ((StringBuilder)localObject2).append(String.valueOf(this.a));
      ((MultiImageTextView)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
      this.D.setMaxWidth(this.E);
      if ((this.u != null) && (this.y))
      {
        if ((this.v > 0) && (this.w > 0))
        {
          this.z.setBounds(0, 0, this.z.getIntrinsicWidth(), this.z.getIntrinsicHeight());
          this.u.setBounds(0, 0, this.v, this.w);
          this.D.setCompoundDrawables(this.u, null, this.z, null);
        }
        else
        {
          this.D.setCompoundDrawablesWithIntrinsicBounds(this.u, null, this.z, null);
        }
        this.D.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.u != null) && (!this.y))
      {
        if ((this.v > 0) && (this.w > 0))
        {
          this.u.setBounds(0, 0, this.v, this.w);
          this.D.setCompoundDrawables(this.u, null, null, null);
        }
        else
        {
          this.D.setCompoundDrawablesWithIntrinsicBounds(this.u, null, null, null);
        }
        this.D.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.u == null) && (this.y))
      {
        this.D.setCompoundDrawablesWithIntrinsicBounds(null, null, this.z, null);
        this.D.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.u == null) && (!this.y))
      {
        this.D.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.D.setCompoundDrawablePadding(0);
      }
    }
    else
    {
      this.D.setText("");
      if ((this.u != null) && (this.y))
      {
        this.D.setVisibility(0);
        if ((this.v > 0) && (this.w > 0))
        {
          this.u.setBounds(0, 0, this.v, this.w);
          this.z.setBounds(0, 0, this.z.getIntrinsicWidth(), this.z.getIntrinsicHeight());
          this.D.setCompoundDrawables(this.u, null, this.z, null);
        }
        else
        {
          this.D.setCompoundDrawablesWithIntrinsicBounds(this.u, null, this.z, null);
        }
        this.D.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.u != null) && (!this.y))
      {
        this.D.setVisibility(0);
        if ((this.v > 0) && (this.w > 0))
        {
          this.u.setBounds(0, 0, this.v, this.w);
          this.D.setCompoundDrawables(this.u, null, null, null);
        }
        else
        {
          this.D.setCompoundDrawablesWithIntrinsicBounds(this.u, null, null, null);
        }
        this.D.setCompoundDrawablePadding(0);
        return;
      }
      if ((this.u == null) && (this.y))
      {
        this.D.setVisibility(0);
        this.D.setCompoundDrawablesWithIntrinsicBounds(null, null, this.z, null);
        this.D.setCompoundDrawablePadding(0);
        return;
      }
      if ((this.u == null) && (!this.y)) {
        this.D.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.GameRankFormItem
 * JD-Core Version:    0.7.0.1
 */