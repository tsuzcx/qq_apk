package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.util.DisplayUtil;

public class VideoFeedsAioGuideView
  extends FrameLayout
  implements View.OnClickListener
{
  public static final String a = HardCodeUtil.a(2131913386);
  private TextView b;
  private ImageView c;
  private ImageView d;
  private FrameLayout.LayoutParams e;
  private VideoFeedsRecyclerView f;
  private VideoInfo g;
  private Activity h;
  private QQAppInterface i;
  private Animation j;
  private Animation k;
  private boolean l;
  private boolean m;
  private int n;
  
  public VideoFeedsAioGuideView(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    super(paramActivity);
    this.f = paramVideoFeedsRecyclerView;
    this.h = paramActivity;
    this.i = paramQQAppInterface;
    this.n = DisplayUtil.a(paramActivity, 5.0F);
    setVisibility(8);
  }
  
  private void d()
  {
    setBackgroundResource(2130843789);
    int i1 = DisplayUtil.a(this.h, 6.0F);
    int i2 = DisplayUtil.a(this.h, 3.0F);
    setPadding(i1, i2, i1, i2);
    this.b = new TextView(this.h);
    this.b.setTextSize(2, 12.0F);
    this.b.setText(a);
    this.b.setTextColor(-654311425);
    this.c = new ImageView(this.h);
    this.d = new ImageView(this.h);
    this.c.setImageResource(2130844193);
    this.d.setImageResource(2130844193);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 19;
    localLayoutParams.rightMargin = DisplayUtil.a(this.h, 10.0F);
    addView(this.b, localLayoutParams);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 21;
    localLayoutParams.topMargin = (-DisplayUtil.a(this.h, 2.0F));
    addView(this.c, localLayoutParams);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 21;
    localLayoutParams.topMargin = DisplayUtil.a(this.h, 3.0F);
    addView(this.d, localLayoutParams);
  }
  
  public void a()
  {
    setVisibility(0);
    setTranslationY(this.n);
    setAlpha(0.0F);
    animate().translationYBy(-this.n).alphaBy(1.0F).setDuration(240L);
    if (this.j == null)
    {
      this.j = new AlphaAnimation(1.0F, 0.0F);
      this.j.setDuration(360L);
      this.j.setRepeatMode(2);
      this.j.setRepeatCount(-1);
      this.j.setAnimationListener(new VideoFeedsAioGuideView.1(this));
    }
    if (this.k == null)
    {
      this.k = new AlphaAnimation(1.0F, 0.0F);
      this.k.setDuration(360L);
      this.k.setRepeatMode(2);
      this.k.setRepeatCount(-1);
      this.k.setAnimationListener(new VideoFeedsAioGuideView.2(this));
    }
    this.j.setStartOffset(180L);
    this.k.setStartOffset(0L);
    this.c.startAnimation(this.j);
    this.d.startAnimation(this.k);
    if (!this.m)
    {
      this.m = true;
      VideoR5.Builder localBuilder = new VideoR5.Builder(this.g);
      PublicAccountReportUtils.a(this.i, this.g.q, "0X8009833", "0X8009833", 0, 0, "", "", "", localBuilder.b().a(), false);
    }
  }
  
  public void a(ShortVideoItemHolder paramShortVideoItemHolder)
  {
    this.g = paramShortVideoItemHolder.az.c;
    if (!this.l)
    {
      this.l = true;
      d();
      this.e = new FrameLayout.LayoutParams(-2, -2);
      FrameLayout.LayoutParams localLayoutParams = this.e;
      localLayoutParams.gravity = 85;
      localLayoutParams.bottomMargin = DisplayUtil.a(this.h, 63.0F);
      this.e.rightMargin = DisplayUtil.a(this.h, 12.0F);
      setOnClickListener(this);
    }
    if (getParent() != paramShortVideoItemHolder.af)
    {
      if (getParent() != null) {
        ((ViewGroup)getParent()).removeView(this);
      }
      paramShortVideoItemHolder.af.addView(this, this.e);
    }
  }
  
  public void b()
  {
    setVisibility(8);
    ImageView localImageView = this.c;
    if (localImageView != null) {
      localImageView.clearAnimation();
    }
    localImageView = this.d;
    if (localImageView != null) {
      localImageView.clearAnimation();
    }
  }
  
  public void c()
  {
    if (getParent() != null) {
      ((ViewGroup)getParent()).removeView(this);
    }
  }
  
  public void onClick(View paramView)
  {
    this.f.b();
    paramView = new VideoR5.Builder(this.g);
    PublicAccountReportUtils.a(this.i, this.g.q, "0X8009834", "0X8009834", 0, 0, "", "", "", paramView.b().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAioGuideView
 * JD-Core Version:    0.7.0.1
 */