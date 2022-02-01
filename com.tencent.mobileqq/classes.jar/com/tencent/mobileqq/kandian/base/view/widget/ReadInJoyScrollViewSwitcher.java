package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ReadInJoyScrollViewSwitcher
  extends ViewSwitcher
{
  ReadInJoyScrollViewSwitcher.OnClickItemListener a;
  private int b = 400;
  private int c;
  private int d;
  private ReadInJoyScrollViewSwitcher.MyHandler e;
  private ArrayList<ReadInJoyScrollViewSwitcher.ScrollItem> f;
  
  public ReadInJoyScrollViewSwitcher(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyScrollViewSwitcher(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
    d();
  }
  
  private void a(ReadInJoyScrollViewSwitcher.ScrollItem paramScrollItem, View paramView, int paramInt)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131447062);
    localTextView.setText(paramScrollItem.a);
    paramView = (CornerImageView)paramView.findViewById(2131435219);
    paramView.setRadius(AIOUtils.b(2.0F, getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (TextUtils.isEmpty(paramScrollItem.b))
    {
      if (paramScrollItem.c > 0)
      {
        paramView.setImageDrawable(getResources().getDrawable(paramScrollItem.c));
        localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        localLayoutParams.rightMargin = AIOUtils.b(32.0F, getResources());
        localTextView.setLayoutParams(localLayoutParams);
        paramView.setVisibility(0);
      }
      else
      {
        paramView.setVisibility(8);
        paramView = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        paramView.rightMargin = AIOUtils.b(5.0F, getResources());
        localTextView.setLayoutParams(paramView);
      }
    }
    else
    {
      a(paramScrollItem.b, paramView);
      localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      localLayoutParams.rightMargin = AIOUtils.b(32.0F, getResources());
      localTextView.setLayoutParams(localLayoutParams);
      paramView.setVisibility(0);
    }
    localTextView.setOnClickListener(new ReadInJoyScrollViewSwitcher.2(this, paramScrollItem));
  }
  
  private void c()
  {
    this.f = new ArrayList();
    this.e = new ReadInJoyScrollViewSwitcher.MyHandler(this);
    setAnimateFirstView(false);
  }
  
  private void d()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(this.b);
    localTranslateAnimation.setInterpolator(new LinearInterpolator());
    localTranslateAnimation.setFillAfter(true);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(this.b);
    localAlphaAnimation.setInterpolator(new LinearInterpolator());
    localAlphaAnimation.setFillAfter(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    setInAnimation(localAnimationSet);
    localAnimationSet = new AnimationSet(true);
    localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    localTranslateAnimation.setDuration(this.b);
    localTranslateAnimation.setInterpolator(new LinearInterpolator());
    localTranslateAnimation.setFillAfter(false);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(this.b);
    localAlphaAnimation.setInterpolator(new LinearInterpolator());
    localAlphaAnimation.setFillAfter(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    setOutAnimation(localAnimationSet);
  }
  
  public void a()
  {
    if (this.f.size() < 1) {
      return;
    }
    int i;
    if (this.c == this.f.size() - 1) {
      i = 0;
    } else {
      i = this.c + 1;
    }
    this.c = i;
    a((ReadInJoyScrollViewSwitcher.ScrollItem)this.f.get(this.c), getNextView(), this.c);
    showNext();
  }
  
  protected void a(String paramString, URLImageView paramURLImageView)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.a(getContext(), 24.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.a(getContext(), 24.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = DisplayUtil.a(getContext(), 2.0F);
    try
    {
      localObject = URLDrawable.getDrawable(new URL("redtouchpicdownloadprotoc", null, paramString), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(paramString);
      paramURLImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel())
      {
        paramURLImageView = new StringBuilder();
        paramURLImageView.append("parse img exception : e = ");
        paramURLImageView.append(paramString);
        QLog.d("ReadInJoyScrollViewSwitcher", 2, paramURLImageView.toString());
      }
    }
  }
  
  public void b()
  {
    ArrayList localArrayList = this.f;
    if (localArrayList != null)
    {
      if (localArrayList.size() < 2) {
        return;
      }
      this.e.removeMessages(0);
      this.e.sendEmptyMessageDelayed(0, this.d);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.e.removeCallbacksAndMessages(null);
  }
  
  public void setOnClickListener(ReadInJoyScrollViewSwitcher.OnClickItemListener paramOnClickItemListener)
  {
    this.a = paramOnClickItemListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyScrollViewSwitcher
 * JD-Core Version:    0.7.0.1
 */