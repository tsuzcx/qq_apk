package com.tencent.mobileqq.qqexpand.widget.search;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.av.utils.UITools;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ExpandSearchBarView
  extends FrameLayout
  implements View.OnClickListener, ExpandHorizontalTagsView.OnItemClickListener
{
  private ExpandSearchBarView.OnItemClickListener a;
  private ViewGroup b;
  private InterceptHorizontalScrollView c;
  private ExpandHorizontalTagsView d;
  private ImageView e;
  private TextView f;
  private boolean g = true;
  private int h = -1;
  private final Interpolator i = new LinearInterpolator();
  private ValueAnimator j = null;
  private Animator.AnimatorListener k = null;
  private ValueAnimator l = null;
  private Animator.AnimatorListener m = null;
  private boolean n = false;
  
  public ExpandSearchBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExpandSearchBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExpandSearchBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2131627403, this);
    d();
  }
  
  private void a(View paramView)
  {
    this.h = (((FrameLayout.LayoutParams)paramView.getLayoutParams()).topMargin + paramView.getHeight());
    this.n = true;
  }
  
  private void b(View paramView)
  {
    if (!this.n) {
      a(paramView);
    }
    if (this.h <= 0) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    if (this.j == null)
    {
      this.j = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.j.setDuration(200L);
      this.j.setInterpolator(this.i);
      this.j.addUpdateListener(new ExpandSearchBarView.1(this, localLayoutParams, paramView));
      this.k = new ExpandSearchBarView.2(this);
    }
    paramView = this.l;
    if ((paramView != null) && (paramView.isRunning()))
    {
      this.l.cancel();
      this.l.removeAllListeners();
    }
    this.j.removeAllListeners();
    this.j.cancel();
    this.j.addListener(this.k);
    this.j.start();
  }
  
  private void c(View paramView)
  {
    if (!this.n) {
      a(paramView);
    }
    if (this.h <= 0) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    if (this.l == null)
    {
      this.l = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.l.setDuration(200L);
      this.l.setInterpolator(this.i);
      this.l.addUpdateListener(new ExpandSearchBarView.3(this, localLayoutParams, paramView));
      this.m = new ExpandSearchBarView.4(this, paramView);
    }
    paramView = this.j;
    if ((paramView != null) && (paramView.isRunning()))
    {
      this.j.cancel();
      this.j.removeAllListeners();
    }
    this.l.removeAllListeners();
    this.l.cancel();
    this.l.addListener(this.m);
    this.l.start();
  }
  
  private void d()
  {
    this.b = ((ViewGroup)findViewById(2131445384));
    this.c = ((InterceptHorizontalScrollView)findViewById(2131445452));
    this.d = ((ExpandHorizontalTagsView)findViewById(2131445449));
    this.e = ((ImageView)findViewById(2131445409));
    this.f = ((TextView)findViewById(2131445385));
    Object localObject = this.d;
    if (localObject != null) {
      ((ExpandHorizontalTagsView)localObject).setOnItemClickListener(this);
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((ImageView)localObject).setOnClickListener(this);
      this.e.setOnTouchListener(UITools.a);
    }
    localObject = this.f;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(this);
    }
  }
  
  public void a()
  {
    if (this.g)
    {
      ValueAnimator localValueAnimator = this.j;
      if ((localValueAnimator != null) && (!localValueAnimator.isRunning()) && (((FrameLayout.LayoutParams)this.b.getLayoutParams()).topMargin != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSearchBarView", 2, "showSearchBar catch a display exception");
        }
        c();
      }
      return;
    }
    this.g = true;
    b(this.b);
  }
  
  public void a(int paramInt)
  {
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    int i1 = arrayOfInt[1];
    int i3 = getHeight();
    paramInt += i1;
    if ((paramInt > i1) && (i1 > 0))
    {
      i2 = i3;
      if (i3 > 0) {}
    }
    else
    {
      paramInt = 1920;
      i1 = 223;
      i2 = 105;
    }
    i3 = i1 * 36 / paramInt;
    int i4 = i2 + i1;
    int i2 = i4 * 36 / paramInt;
    i1 = i1 * -35 / paramInt;
    paramInt = i4 * -35 / paramInt;
    i1 = Color.argb(255, 79 - i3, 127 - i1, 255);
    paramInt = Color.argb(255, 79 - i2, 127 - paramInt, 255);
    setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i1, paramInt }));
  }
  
  public void a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    Object localObject2 = null;
    if (!bool)
    {
      i1 = 0;
      localObject1 = localObject2;
      while (i1 < this.d.getChildCount())
      {
        localObject1 = (TextView)this.d.getChildAt(i1);
        if (((((TextView)localObject1).getTag() instanceof ExpandHorizontalTagsView.TagInfo)) && (paramString.equals(((ExpandHorizontalTagsView.TagInfo)((TextView)localObject1).getTag()).b)))
        {
          i1 = ((TextView)localObject1).getRight();
          break label94;
        }
        i1 += 1;
      }
    }
    int i1 = 0;
    label94:
    int i2 = this.c.getWidth();
    if ((i1 > i2) && (i2 > 0) && (localObject1 != null)) {
      this.c.scrollTo(i1 - i2, 0);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    ExpandSearchBarView.OnItemClickListener localOnItemClickListener = this.a;
    if (localOnItemClickListener != null) {
      localOnItemClickListener.a(paramString, paramInt);
    }
  }
  
  public void b()
  {
    if (!this.g) {
      return;
    }
    this.g = false;
    c(this.b);
  }
  
  public void c()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.topMargin = 0;
    this.b.setLayoutParams(localLayoutParams);
  }
  
  public void onClick(View paramView)
  {
    ExpandSearchBarView.OnItemClickListener localOnItemClickListener = this.a;
    if (localOnItemClickListener != null) {
      localOnItemClickListener.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setItemClickListener(ExpandSearchBarView.OnItemClickListener paramOnItemClickListener)
  {
    this.a = paramOnItemClickListener;
  }
  
  public void setSearchButtonEnable(boolean paramBoolean)
  {
    ImageView localImageView = this.e;
    if (localImageView != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localImageView.setVisibility(i1);
    }
  }
  
  public void setSearchTags(ArrayList<String> paramArrayList, int paramInt)
  {
    ExpandHorizontalTagsView localExpandHorizontalTagsView = this.d;
    if (localExpandHorizontalTagsView != null) {
      localExpandHorizontalTagsView.setSearchTags(paramArrayList, paramInt);
    }
  }
  
  public void setSearchTextShow(boolean paramBoolean)
  {
    if (this.c != null)
    {
      TextView localTextView = this.f;
      if (localTextView == null) {
        return;
      }
      if (paramBoolean)
      {
        if (localTextView.getVisibility() == 8)
        {
          this.f.setVisibility(0);
          this.c.setVisibility(4);
        }
      }
      else if (localTextView.getVisibility() == 0)
      {
        this.f.setVisibility(8);
        this.c.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.search.ExpandSearchBarView
 * JD-Core Version:    0.7.0.1
 */