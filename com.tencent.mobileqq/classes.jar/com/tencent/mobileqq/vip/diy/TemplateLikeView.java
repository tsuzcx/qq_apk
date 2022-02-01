package com.tencent.mobileqq.vip.diy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.widget.VoteViewV2;

public class TemplateLikeView
  extends VoteViewV2
{
  protected ViewGroup a = (ViewGroup)findViewById(2131449992);
  protected ViewGroup b = (ViewGroup)findViewById(2131436857);
  protected TextView c = (TextView)findViewById(2131449999);
  protected int d = 0;
  protected int e = 0;
  protected int f;
  protected int g;
  protected URLDrawable h;
  
  public TemplateLikeView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TemplateLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TemplateLikeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    TextView localTextView;
    if (this.o == 1)
    {
      localTextView = this.c;
      if (localTextView != null)
      {
        localTextView.setTextColor(getContext().getResources().getColor(2131168118));
        this.l.setTextColor(getContext().getResources().getColor(2131168118));
      }
    }
    else
    {
      localTextView = this.c;
      if (localTextView != null)
      {
        localTextView.setTextColor(getContext().getResources().getColor(2131168212));
        this.l.setTextColor(getContext().getResources().getColor(2131168212));
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, NewVoteAnimHelper paramNewVoteAnimHelper, boolean paramBoolean3)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramNewVoteAnimHelper, paramBoolean3);
    paramNewVoteAnimHelper = this.a.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
    float f1 = this.d + this.e;
    TextPaint localTextPaint = this.c.getPaint();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131912128));
    localStringBuilder.append(this.j.getText().toString());
    this.f = ((int)(f1 + localTextPaint.measureText(localStringBuilder.toString()) + UIUtils.a(getContext(), 30.0F)));
    paramInt1 = this.f;
    paramNewVoteAnimHelper.width = paramInt1;
    localLayoutParams.width = paramInt1;
    this.a.setLayoutParams(paramNewVoteAnimHelper);
    this.b.setLayoutParams(localLayoutParams);
    paramNewVoteAnimHelper = super.getLayoutParams();
    paramNewVoteAnimHelper.width = this.f;
    super.setLayoutParams(paramNewVoteAnimHelper);
    paramNewVoteAnimHelper = this.h;
    if (paramNewVoteAnimHelper != null) {
      paramNewVoteAnimHelper.invalidateSelf();
    }
  }
  
  protected int getLayout()
  {
    return 2131628462;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    SLog.e("zhiqiang", "invalidateDrawable");
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    SLog.b("zhiqiang", "draw +++++++++++");
  }
  
  public void setContainerLayoutParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e = paramInt4;
    this.d = paramInt3;
    ViewGroup.LayoutParams localLayoutParams1 = this.a.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams2 = this.b.getLayoutParams();
    float f1 = this.d + this.e;
    TextPaint localTextPaint = this.c.getPaint();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131912130));
    localStringBuilder.append(this.m);
    this.f = ((int)(f1 + localTextPaint.measureText(localStringBuilder.toString()) + UIUtils.a(getContext(), 30.0F)));
    this.g = paramInt2;
    paramInt1 = this.f;
    localLayoutParams1.width = paramInt1;
    paramInt2 = this.g;
    localLayoutParams1.height = paramInt2;
    localLayoutParams2.width = paramInt1;
    localLayoutParams2.height = paramInt2;
    this.a.setLayoutParams(localLayoutParams1);
    this.b.setLayoutParams(localLayoutParams2);
  }
  
  public void setVoteContainerBackground(URLDrawable paramURLDrawable)
  {
    URLDrawable localURLDrawable = this.h;
    if (localURLDrawable != null) {
      localURLDrawable.setURLDrawableListener(null);
    }
    this.h = paramURLDrawable;
    if ((paramURLDrawable != null) && (paramURLDrawable.getStatus() != 1)) {
      paramURLDrawable.setURLDrawableListener(new TemplateLikeView.1(this));
    }
    this.a.setBackgroundDrawable(paramURLDrawable);
    this.b.setBackgroundDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.TemplateLikeView
 * JD-Core Version:    0.7.0.1
 */