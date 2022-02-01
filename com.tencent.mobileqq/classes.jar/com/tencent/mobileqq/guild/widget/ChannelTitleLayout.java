package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import com.tencent.mobileqq.guild.animate.Interpolators;
import com.tencent.mobileqq.guild.config.GuildCoverInfo;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ChannelTitleLayout
  extends FrameLayout
{
  public static final int a = ViewUtils.dpToPx(54.0F);
  public static final int b = ViewUtils.dpToPx(60.0F);
  private static final int c = QQGuildUtil.h().getResources().getColor(2131166283);
  private ViewGroup d;
  private View.OnClickListener e;
  private FrameLayout f;
  private TextView g;
  private ImageView h;
  private ChannelTitleLayout.Param i;
  private Drawable j;
  private Drawable k;
  private final Interpolator l = Interpolators.a();
  private ChannelTitleLayout.TextViewAlphaApplier m;
  private boolean n;
  private int o;
  
  public ChannelTitleLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public ChannelTitleLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ChannelTitleLayout(@NonNull Context paramContext, @NonNull View.OnClickListener paramOnClickListener)
  {
    super(paramContext);
    this.e = paramOnClickListener;
    a(paramContext);
  }
  
  private void a(float paramFloat)
  {
    int i1 = 0;
    QLog.d("ChannelTitleLayout", 4, new Object[] { "updateLayoutByAlpha: alpha ", Float.valueOf(paramFloat) });
    setTitleByAlpha(paramFloat);
    setMoreInfoButtonDrawableByAlpha(paramFloat);
    if (paramFloat >= 0.99F) {
      i1 = -1;
    }
    setBackgroundColor(i1);
  }
  
  private void a(int paramInt)
  {
    int i1;
    int i2;
    if (paramInt == 0)
    {
      i1 = ImmersiveUtils.getScreenWidth();
      i2 = Utils.a(147.0F, getResources());
      this.g.setMaxWidth(i1 - i2);
    }
    else
    {
      i1 = ImmersiveUtils.getScreenWidth();
      i2 = Utils.a(168.0F, getResources());
      this.g.setMaxWidth(i1 - i2);
    }
    String str = QQGuildUtil.a(paramInt);
    this.h.setOnClickListener(this.e);
    QQGuildUtil.a(this.h, str);
  }
  
  private void a(String paramString)
  {
    if (!QLog.isDevelopLevel()) {
      return;
    }
    new Handler(Looper.getMainLooper()).postDelayed(new -..Lambda.ChannelTitleLayout.Q5p1eLQtyH3pVoPYYZz0foWVM9U(this, paramString), 1000L);
  }
  
  private float b(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      if (!this.i.a()) {
        return 1.0F;
      }
      float f1 = Math.max(0.0F, Math.min(1.0F, -paramInt1 / (paramInt2 - getHeight())));
      return this.l.getInterpolation(f1);
    }
    return 1.0F;
  }
  
  private void b()
  {
    Object localObject = this.f.findViewById(2131435761);
    boolean bool = this.n;
    int i2 = 8;
    if (bool) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    ((View)localObject).setVisibility(i1);
    localObject = this.f;
    int i1 = i2;
    if (this.i.c) {
      i1 = 0;
    }
    ((FrameLayout)localObject).setVisibility(i1);
    this.f.setOnClickListener(this.e);
    this.g.setOnClickListener(this.e);
  }
  
  private void c()
  {
    this.g.setText(this.i.b);
    float f1;
    if (this.i.a()) {
      f1 = 0.0F;
    } else {
      f1 = 1.0F;
    }
    setTitleByAlpha(f1);
    this.g.setVisibility(0);
  }
  
  private static boolean d()
  {
    return Build.MODEL.equals("vivo X6S A");
  }
  
  private void setMoreInfoButtonDrawableByAlpha(float paramFloat)
  {
    int i1 = ColorUtils.blendARGB(this.o, -16777216, paramFloat);
    this.k.setTint(i1);
    i1 = ColorUtils.blendARGB(this.m.d, this.m.e, paramFloat);
    this.j.setTint(i1);
  }
  
  private void setTitleByAlpha(float paramFloat)
  {
    this.m.a(this.g, paramFloat);
    ImageView localImageView = this.h;
    if (!this.n) {
      paramFloat = 1.0F;
    }
    localImageView.setAlpha(paramFloat);
  }
  
  public void a(Context paramContext)
  {
    this.d = ((ViewGroup)inflate(paramContext, 2131625049, this).findViewById(2131445137));
    this.f = ((FrameLayout)findViewById(2131435696));
    this.j = ((ImageView)this.f.findViewById(2131435761)).getDrawable();
    this.k = ((ImageView)this.f.findViewById(2131435760)).getDrawable();
    this.g = ((TextView)findViewById(2131434700));
    this.h = ((ImageView)findViewById(2131434692));
    this.d.setClipChildren(false);
    if (d()) {
      setLayerType(1, null);
    }
  }
  
  public void a(ChannelTitleLayout.Param paramParam)
  {
    this.i = paramParam;
    this.n = paramParam.b();
    ChannelTitleLayout.TextViewAlphaApplier localTextViewAlphaApplier;
    if (this.n) {
      localTextViewAlphaApplier = ChannelTitleLayout.TextViewAlphaApplier.a();
    } else {
      localTextViewAlphaApplier = ChannelTitleLayout.TextViewAlphaApplier.b();
    }
    this.m = localTextViewAlphaApplier;
    int i1;
    if (this.n) {
      i1 = GuildCoverInfo.b(paramParam.e);
    } else {
      i1 = -1;
    }
    this.o = i1;
    c();
    b();
    a(paramParam.f);
    a("updateUi");
    requestLayout();
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    QLog.d("ChannelTitleLayout", 2, new Object[] { "onListViewOffsetChange: visible? ", Boolean.valueOf(paramBoolean), " offset: ", Integer.valueOf(paramInt1), " height: ", Integer.valueOf(paramInt2), " ratio: ", Float.valueOf(paramInt1 / paramInt2), " myHeight: ", Integer.valueOf(getHeight()) });
    a(b(paramBoolean, paramInt1, paramInt2));
  }
  
  public View getMedalView()
  {
    return this.h;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.ChannelTitleLayout
 * JD-Core Version:    0.7.0.1
 */