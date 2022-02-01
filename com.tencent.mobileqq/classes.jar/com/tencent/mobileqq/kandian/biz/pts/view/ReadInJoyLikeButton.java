package com.tencent.mobileqq.kandian.biz.pts.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ColorUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase.ClickStatus;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;

public class ReadInJoyLikeButton
  extends ButtonBase
{
  private LinearLayout a;
  private ImageView b;
  private TextView c;
  private boolean d;
  private AnimatorSet e = new AnimatorSet();
  private AnimatorSet f = new AnimatorSet();
  
  public ReadInJoyLikeButton(VafContext paramVafContext)
  {
    super(paramVafContext);
    a(paramVafContext);
  }
  
  private void a()
  {
    this.e.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.b, "scaleX", new float[] { 1.0F, 0.0F }).setDuration(200L), ObjectAnimator.ofFloat(this.b, "scaleY", new float[] { 1.0F, 0.0F }).setDuration(200L) });
    this.e.addListener(new ReadInJoyLikeButton.1(this));
    this.f.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.b, "scaleX", new float[] { 0.0F, 1.1F, 1.0F }).setDuration(200L), ObjectAnimator.ofFloat(this.b, "scaleY", new float[] { 0.0F, 1.1F, 1.0F }).setDuration(200L) });
    this.f.addListener(new ReadInJoyLikeButton.2(this));
  }
  
  private void a(VafContext paramVafContext)
  {
    this.a = new LinearLayout(paramVafContext.getContext());
    this.b = new ImageView(paramVafContext.getContext());
    this.c = new TextView(paramVafContext.getContext());
    paramVafContext = new LinearLayout.LayoutParams(-2, -2);
    paramVafContext.gravity = 16;
    this.a.setOrientation(0);
    this.a.setGravity(1);
    this.a.addView(this.b, paramVafContext);
    this.a.addView(this.c, paramVafContext);
    a();
  }
  
  private void a(CharSequence paramCharSequence)
  {
    this.c.setText(paramCharSequence);
  }
  
  private void b()
  {
    c();
    super.onClick();
    boolean bool = isSelected() ^ true;
    super.setSelected(bool);
    this.c.setSelected(bool);
  }
  
  private void c()
  {
    this.d = true;
    this.b.setSelected(isSelected());
    this.e.start();
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.a;
  }
  
  public boolean onClick()
  {
    RIJUserLevelModule.getInstance().doActionsByUserLevel(getNativeView().getContext(), 3, new ReadInJoyLikeButton.3(this));
    return false;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.a.setClickable(true);
    this.a.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.c.setClickable(true);
    this.c.setIncludeFontPadding(false);
    this.c.setTextSize(0, this.mTextSize);
    this.c.setPadding(this.mCompoundDrawablePadding, 0, 0, 0);
    a(this.mText);
  }
  
  public void refresh()
  {
    super.refresh();
  }
  
  protected void setBackgroundColorForStates() {}
  
  protected void setBackgroundForStates()
  {
    Object localObject = this.a.getContext();
    localObject = DrawableUtil.getSelector(DrawableUtil.getDrawable((Context)localObject, getStatus(0).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(1).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(4).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER));
    this.a.setBackgroundDrawable((Drawable)localObject);
  }
  
  protected void setCompoundDrawableForStates()
  {
    Object localObject = this.a.getContext();
    localObject = DrawableUtil.getSelector(DrawableUtil.getDrawable((Context)localObject, getStatus(0).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(1).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(4).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER));
    this.b.setImageDrawable((Drawable)localObject);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    this.c.setSelected(paramBoolean);
    if (!this.d) {
      this.b.setSelected(paramBoolean);
    }
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(paramCharSequence, this.mText))
    {
      this.mText = paramCharSequence;
      this.c.setText(paramCharSequence);
    }
  }
  
  protected void setTextColorForStates()
  {
    ColorStateList localColorStateList = ColorUtil.getColorStateList(getStatus(0).textColor, getStatus(1).textColor, getStatus(4).textColor);
    this.c.setTextColor(localColorStateList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyLikeButton
 * JD-Core Version:    0.7.0.1
 */