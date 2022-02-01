package com.tencent.mobileqq.colornote.smallscreen;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.colornote.layout.AutoBgFrameLayout;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.RoundImageView;

public class SmallColorNoteItem
  extends LinearLayout
{
  private View a;
  private RelativeLayout b;
  private AutoBgFrameLayout c;
  private RoundImageView d;
  private TextView e;
  private TextView f;
  private boolean g;
  
  public SmallColorNoteItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SmallColorNoteItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public SmallColorNoteItem(Context paramContext, boolean paramBoolean, ViewGroup paramViewGroup)
  {
    super(paramContext);
    a(paramBoolean, paramViewGroup);
  }
  
  private void a(boolean paramBoolean, ViewGroup paramViewGroup)
  {
    this.g = paramBoolean;
    if (paramBoolean) {
      this.a = LayoutInflater.from(getContext()).inflate(2131624507, paramViewGroup, false);
    } else {
      this.a = LayoutInflater.from(getContext()).inflate(2131624506, paramViewGroup, false);
    }
    paramViewGroup = this.a;
    this.b = ((RelativeLayout)paramViewGroup.findViewById(2131431369));
    this.c = ((AutoBgFrameLayout)paramViewGroup.findViewById(2131439409));
    this.d = ((RoundImageView)paramViewGroup.findViewById(2131439410));
    this.e = ((TextView)paramViewGroup.findViewById(2131439420));
    this.f = ((TextView)paramViewGroup.findViewById(2131439418));
  }
  
  public void a()
  {
    RoundImageView localRoundImageView = this.d;
    if (localRoundImageView != null) {
      localRoundImageView.setVisibility(4);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new ViewGroup.LayoutParams(-1, paramInt1);
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    ((ViewGroup.LayoutParams)localObject).height = paramInt1;
    float f1 = paramInt1 * 1.0F / paramInt2;
    paramInt1 = (int)(DisplayUtil.a(getContext(), 6.0F) * f1);
    localObject = this.b;
    if (this.g) {
      paramInt2 = 0;
    } else {
      paramInt2 = paramInt1;
    }
    int i;
    if (this.g) {
      i = paramInt1;
    } else {
      i = 0;
    }
    ((RelativeLayout)localObject).setPadding(paramInt2, paramInt1, i, paramInt1);
    this.d.setmRadius((int)(DisplayUtil.a(getContext(), 3.0F) * f1), false);
    localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = ((int)(DisplayUtil.a(getContext(), 20.0F) * f1));
    ((RelativeLayout.LayoutParams)localObject).width = ((int)(DisplayUtil.a(getContext(), 20.0F) * f1));
    this.e.setTextSize((int)(8.0F * f1));
    this.f.setTextSize((int)(6.0F * f1));
    localObject = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
    paramInt1 = Math.max(DisplayUtil.a(getContext(), 2.0F), (int)(f1 * DisplayUtil.a(getContext(), 4.0F)));
    if (this.g) {
      paramInt2 = 0;
    } else {
      paramInt2 = paramInt1;
    }
    ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt2;
    if (this.g) {
      paramInt2 = paramInt1;
    } else {
      paramInt2 = 0;
    }
    ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt2;
    localObject = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    if (this.g) {
      paramInt2 = 0;
    } else {
      paramInt2 = paramInt1;
    }
    ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt2;
    if (!this.g) {
      paramInt1 = 0;
    }
    ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt1;
  }
  
  public void b()
  {
    RoundImageView localRoundImageView = this.d;
    if (localRoundImageView != null) {
      localRoundImageView.setVisibility(0);
    }
  }
  
  public void c()
  {
    TextView localTextView = this.e;
    if (localTextView != null) {
      localTextView.setVisibility(4);
    }
    localTextView = this.f;
    if (localTextView != null) {
      localTextView.setVisibility(4);
    }
  }
  
  public void d()
  {
    TextView localTextView = this.e;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    localTextView = this.f;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
  }
  
  public View getRoot()
  {
    return this.a;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setAttachLeft(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setSubTitle(String paramString)
  {
    TextView localTextView = this.f;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void setTitle(String paramString)
  {
    TextView localTextView = this.e;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.SmallColorNoteItem
 * JD-Core Version:    0.7.0.1
 */