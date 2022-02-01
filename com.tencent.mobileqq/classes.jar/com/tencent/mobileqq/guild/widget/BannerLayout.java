package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.guild.animate.Interpolators;
import com.tencent.mobileqq.guild.config.GuildCoverInfo;
import com.tencent.mobileqq.guild.mainframe.helper.ChannelListViewHelper;
import com.tencent.mobileqq.guild.setting.popup.GuildMedalBubbleLayout;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.util.QQGuildViewUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class BannerLayout
  extends FrameLayout
  implements View.OnClickListener
{
  private static final int a = ChannelListViewHelper.a(QQGuildUtil.h());
  private final ImageView b;
  private final ImageView c;
  private final ImageView d;
  private final TextView e;
  private PopupWindow f;
  private GuildMedalBubbleLayout g;
  private final Interpolator h = Interpolators.a(Interpolators.a(0.15F, 0.85F, 0.2F, 0.9F), 0.2F, 1.0F);
  private final View i;
  private final Runnable j = new BannerLayout.1(this);
  
  public BannerLayout(@NonNull Context paramContext)
  {
    this(paramContext, null, 0, 0);
  }
  
  public BannerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 0);
  }
  
  public BannerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public BannerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    LayoutInflater.from(paramContext).inflate(2131625048, this);
    this.b = ((ImageView)findViewById(2131435410));
    this.c = ((ImageView)findViewById(2131435461));
    this.d = ((ImageView)findViewById(2131434692));
    this.d.setOnClickListener(this);
    this.e = ((TextView)findViewById(2131447149));
    this.i = findViewById(2131429413);
  }
  
  private PopupWindow a(Context paramContext, boolean paramBoolean)
  {
    PopupWindow localPopupWindow = new PopupWindow(-2, -2);
    this.g = new GuildMedalBubbleLayout(paramContext, paramBoolean);
    localPopupWindow.setContentView(this.g);
    return localPopupWindow;
  }
  
  private void a(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(getResources().getColor(2131166157));
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    this.b.setImageDrawable(paramString);
    QQGuildViewUtils.a(this, a);
  }
  
  private void b()
  {
    this.f.getContentView().measure(0, 0);
    int k = this.d.getWidth() / 2;
    int m = this.f.getContentView().getMeasuredWidth() / 2;
    int n = this.d.getHeight();
    int i1 = this.f.getContentView().getMeasuredHeight();
    int i2 = Utils.a(4.0F, getResources());
    this.f.showAsDropDown(this.d, k - m, -(n + i1 - i2));
  }
  
  private void b(String paramString)
  {
    QLog.d("BannerLayout", 2, new Object[] { "updateOutSideBanner, url: ", paramString });
    if (TextUtils.isEmpty(paramString))
    {
      this.c.setImageDrawable(null);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(getResources().getColor(2131168376));
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    this.c.setImageDrawable(paramString);
  }
  
  private String c(String paramString)
  {
    return GuildCoverInfo.a(paramString).d();
  }
  
  private String d(String paramString)
  {
    return GuildCoverInfo.a(paramString).b();
  }
  
  private int e(String paramString)
  {
    return GuildCoverInfo.b(paramString);
  }
  
  private String f(String paramString)
  {
    paramString = GuildCoverInfo.a(paramString).e();
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return "http://down.qq.com/innovate/guild/cover_info/default_cover_bg_image.png";
  }
  
  public int a()
  {
    if (getVisibility() == 0) {
      return a;
    }
    return 0;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    String str = c(paramString2);
    boolean bool1 = TextUtils.isEmpty(str) ^ true;
    boolean bool2 = TextUtils.isEmpty(paramString1);
    int k = 8;
    if ((bool2) && (!bool1))
    {
      setVisibility(8);
      return;
    }
    if (bool1) {
      paramString1 = f(paramString2);
    }
    a(paramString1);
    b(str);
    if (bool1) {
      QQGuildUtil.a(this.d, paramString3);
    } else {
      this.d.setVisibility(8);
    }
    this.e.setText(d(paramString2));
    this.e.setTextColor(e(paramString2));
    paramString1 = this.i;
    if (!bool1) {
      k = 0;
    }
    paramString1.setVisibility(k);
    setVisibility(0);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    PopupWindow localPopupWindow = this.f;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
    float f1;
    if (paramBoolean) {
      f1 = 1.0F - -paramInt1 / paramInt2;
    } else {
      f1 = 0.0F;
    }
    float f2 = this.h.getInterpolation(f1);
    this.e.setAlpha(f2);
    QLog.d("BannerLayout", 4, new Object[] { "onListViewOffsetChange, alpha: ", Float.valueOf(f1), " -> ", Float.valueOf(f2) });
    setAlpha(Math.max(0.0F, Math.min(f1, 1.0F)));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131434692)
    {
      if (this.f == null) {
        this.f = a(paramView.getContext(), false);
      }
      if (!this.f.isShowing())
      {
        b();
        paramView.postDelayed(this.j, 3000L);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.BannerLayout
 * JD-Core Version:    0.7.0.1
 */