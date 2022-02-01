package com.tencent.mobileqq.nearby.interestTag;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;

public class InterestTagItemView
  extends RelativeLayout
{
  private Context a;
  private int b;
  private boolean c;
  private InterestTagInfo d;
  private ImageView e;
  private TextView f;
  private ImageView g;
  private InterestTagItemView.IInterestTagItemViewCallback h;
  private float i;
  private URLDrawable.URLDrawableOptions j;
  private View.OnClickListener k = new InterestTagItemView.1(this);
  
  public InterestTagItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    paramContext = LayoutInflater.from(this.a).inflate(2131627542, this);
    this.e = ((ImageView)paramContext.findViewById(2131435654));
    this.f = ((TextView)paramContext.findViewById(2131448998));
    this.g = ((ImageView)paramContext.findViewById(2131435636));
    setBackgroundResource(2130846494);
    int m = getResources().getColor(2131167212);
    findViewById(2131449305).setBackgroundColor(m);
    this.g.setOnClickListener(this.k);
    setOnClickListener(this.k);
    this.i = getResources().getDisplayMetrics().density;
    this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public void a()
  {
    boolean bool = this.h.b(this.d);
    if ((!bool) && (this.c == true)) {
      this.g.setImageResource(2130849003);
    } else if ((bool == true) && (!this.c)) {
      this.g.setImageResource(2130849004);
    }
    this.c = bool;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    ViewGroup.LayoutParams localLayoutParams = this.e.getLayoutParams();
    if (paramInt == 5)
    {
      double d1 = this.i * 50.0F;
      Double.isNaN(d1);
      localLayoutParams.height = ((int)(d1 + 0.5D));
      this.e.setLayoutParams(localLayoutParams);
    }
  }
  
  public void a(InterestTagInfo paramInterestTagInfo)
  {
    this.d = paramInterestTagInfo;
    if (this.d == null) {
      return;
    }
    int m = this.b;
    Object localObject1;
    if ((m != 5) && (m != 6))
    {
      if (m == 7)
      {
        localObject1 = new GradientDrawable();
        ((GradientDrawable)localObject1).setColor(getResources().getColor(2131166580));
        ((GradientDrawable)localObject1).setCornerRadius(this.i * 10.0F);
        ((GradientDrawable)localObject1).setShape(0);
        m = getResources().getDimensionPixelSize(2131298113);
        ((GradientDrawable)localObject1).setSize(m, m);
        this.e.setPadding(0, 0, 0, 0);
        this.e.setBackgroundResource(0);
      }
      else
      {
        localObject1 = new GradientDrawable();
        ((GradientDrawable)localObject1).setColor(getResources().getColor(2131166580));
        ((GradientDrawable)localObject1).setShape(1);
        m = getResources().getDimensionPixelSize(2131298113);
        ((GradientDrawable)localObject1).setSize(m, m);
      }
    }
    else
    {
      localObject1 = getResources().getDrawable(2131166580);
      this.e.setPadding(0, 0, 0, 0);
      this.e.setBackgroundResource(0);
    }
    boolean bool = TextUtils.isEmpty(this.d.tagIconUrl);
    Object localObject2 = null;
    Object localObject3 = null;
    if (!bool)
    {
      try
      {
        this.j = URLDrawable.URLDrawableOptions.obtain();
        if (this.b == 5)
        {
          localObject2 = this.j;
          m = getResources().getDimensionPixelSize(2131298115);
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = m;
        }
        else
        {
          localObject2 = this.j;
          m = getResources().getDimensionPixelSize(2131298113);
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = m;
        }
        localObject2 = this.j;
        int n = getResources().getDimensionPixelSize(2131298114);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = n;
        this.j.mFailedDrawable = ((Drawable)localObject1);
        this.j.mLoadingDrawable = ((Drawable)localObject1);
        localObject2 = URLDrawable.getDrawable(NearbyImgDownloader.convertURL(this.d.tagIconUrl), this.j);
        try
        {
          if (this.b == 7)
          {
            ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.b(n, m, (int)(this.i * 10.0F)));
            ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.d);
          }
          else if ((this.b != 5) && (this.b != 6))
          {
            ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.a(n, m));
            ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.b);
          }
          this.j.mFailedDrawable = null;
          this.j.mLoadingDrawable = null;
        }
        catch (Exception localException1)
        {
          localObject3 = localObject2;
        }
        localObject2 = localObject3;
      }
      catch (Exception localException2) {}
      if (QLog.isColorLevel())
      {
        QLog.i("choose_interest_tag", 2, localException2.toString());
        localObject2 = localObject3;
      }
    }
    localObject3 = this.e;
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    ((ImageView)localObject3).setImageDrawable((Drawable)localObject1);
    this.f.setText(paramInterestTagInfo.tagName);
    a();
    setTag(this.d);
    if (AppSetting.e)
    {
      paramInterestTagInfo = new StringBuilder();
      paramInterestTagInfo.append(this.f.getText());
      paramInterestTagInfo.append(HardCodeUtil.a(2131903758));
      setContentDescription(paramInterestTagInfo.toString());
    }
  }
  
  public void setCallback(InterestTagItemView.IInterestTagItemViewCallback paramIInterestTagItemViewCallback)
  {
    this.h = paramIInterestTagItemViewCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.InterestTagItemView
 * JD-Core Version:    0.7.0.1
 */