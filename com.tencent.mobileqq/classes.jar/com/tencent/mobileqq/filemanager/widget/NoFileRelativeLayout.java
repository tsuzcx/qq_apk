package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;

public class NoFileRelativeLayout
  extends RelativeLayout
{
  TextView a;
  TextView b;
  ImageView c;
  Context d;
  View e;
  LinearLayout f = null;
  int g = 0;
  int h = 0;
  private View.OnClickListener i;
  
  public NoFileRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NoFileRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NoFileRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131627048, this);
    this.f = ((LinearLayout)paramAttributeSet.findViewById(2131439376));
    this.b = ((TextView)paramAttributeSet.findViewById(2131447089));
    this.a = ((TextView)paramAttributeSet.findViewById(2131447100));
    this.i = new NoFileRelativeLayout.1(this);
    ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).configHistoryTabEmptyTips(this.a, this.i);
    this.a.setVisibility(8);
    this.c = ((ImageView)paramAttributeSet.findViewById(2131435388));
    this.e = paramAttributeSet.findViewById(2131447757);
    this.d = paramContext;
  }
  
  public void a()
  {
    this.a.setVisibility(0);
  }
  
  public void b()
  {
    this.a.setVisibility(8);
  }
  
  public void setGone()
  {
    this.f.setVisibility(8);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
  }
  
  public void setImageViewBackGround(int paramInt)
  {
    this.c.setImageResource(paramInt);
  }
  
  public void setLayoutParams(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 20) {
        return;
      }
      if ((this.g == paramInt1) && (this.h == paramInt2)) {
        return;
      }
      this.g = paramInt1;
      this.h = paramInt2;
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.g, this.h - 20);
      this.f.setLayoutParams(localLayoutParams);
      this.f.invalidate();
    }
  }
  
  public void setText(int paramInt)
  {
    this.b.setText(paramInt);
  }
  
  public void setTextLeftDrawable(int paramInt)
  {
    Drawable localDrawable = this.d.getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    this.b.setCompoundDrawables(localDrawable, null, null, null);
  }
  
  public void setTopViewHeight(float paramFloat)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    localLayoutParams.weight = paramFloat;
    this.e.setLayoutParams(localLayoutParams);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.setVisibility(0);
      this.b.setVisibility(0);
      this.c.setVisibility(0);
      return;
    }
    this.f.setVisibility(4);
    this.b.setVisibility(4);
    this.c.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout
 * JD-Core Version:    0.7.0.1
 */