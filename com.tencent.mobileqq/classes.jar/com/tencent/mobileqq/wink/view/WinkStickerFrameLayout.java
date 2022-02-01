package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.utils.RectUtils;

public class WinkStickerFrameLayout
  extends FrameLayout
{
  private WinkStickerFrameView a;
  private View b;
  private ImageView c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private int g;
  private int h;
  private boolean i;
  private int j;
  private int k;
  private Size l;
  private Drawable m;
  private Drawable n;
  private Drawable o;
  private View p;
  private WinkStickerFrameLayout.MenuClickListener q;
  private WinkStickerModel r;
  
  public WinkStickerFrameLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WinkStickerFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WinkStickerFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void a(int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this.e.setVisibility(paramInt1);
    this.f.setVisibility(paramInt2);
    this.e.setBackgroundDrawable(paramDrawable1);
    this.f.setBackgroundDrawable(paramDrawable2);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 4;
    }
    this.p.setVisibility(paramInt1);
  }
  
  private void b(WinkStickerModel paramWinkStickerModel, WinkStickerFrameLayout.BorderIconMode paramBorderIconMode)
  {
    this.r = paramWinkStickerModel;
    if (!this.i) {
      this.i = true;
    }
    if ((this.g == 0) || (this.h == 0))
    {
      this.g = this.b.getHeight();
      this.h = (this.g - this.f.getHeight());
    }
    int i1 = this.g;
    if (paramBorderIconMode == WinkStickerFrameLayout.BorderIconMode.ShowDelete)
    {
      paramBorderIconMode = this.m;
      a(0, 8, paramBorderIconMode, paramBorderIconMode);
      i1 = this.h;
    }
    else if (paramBorderIconMode == WinkStickerFrameLayout.BorderIconMode.ShowEdit)
    {
      paramBorderIconMode = this.m;
      a(8, 0, paramBorderIconMode, paramBorderIconMode);
      i1 = this.h;
    }
    else
    {
      a(0, 0, this.o, this.n);
    }
    this.j = (this.b.getWidth() / 2);
    this.k = i1;
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-paramWinkStickerModel.rotate, paramWinkStickerModel.getCenterInView().x, paramWinkStickerModel.getCenterInView().y);
    paramBorderIconMode = RectUtils.a.a(localMatrix, paramWinkStickerModel.getLeftTopInView().x, paramWinkStickerModel.getLeftTopInView().y);
    android.graphics.PointF localPointF1 = RectUtils.a.a(localMatrix, paramWinkStickerModel.getRightBottomInView().x, paramWinkStickerModel.getLeftTopInView().y);
    android.graphics.PointF localPointF2 = RectUtils.a.a(localMatrix, paramWinkStickerModel.getLeftTopInView().x, paramWinkStickerModel.getRightBottomInView().y);
    paramWinkStickerModel = RectUtils.a.a(localMatrix, paramWinkStickerModel.getRightBottomInView().x, paramWinkStickerModel.getRightBottomInView().y);
    float f1 = (paramBorderIconMode.x + localPointF1.x) / 2.0F;
    float f4 = (paramBorderIconMode.y + localPointF1.y) / 2.0F;
    float f2 = localPointF2.x;
    f2 = paramWinkStickerModel.x;
    f2 = (localPointF2.y + paramWinkStickerModel.y) / 2.0F;
    int i2 = this.j;
    i1 = i2;
    if (f1 >= i2)
    {
      float f3 = f1 - i2;
      f1 = f3;
      if (i2 + f3 > this.l.a) {
        i1 = this.l.a - this.j;
      }
    }
    else
    {
      f1 = i1;
    }
    i1 = this.k;
    if (f4 >= i1)
    {
      f2 = f4 - i1;
      this.c.setVisibility(4);
      this.d.setVisibility(0);
    }
    else
    {
      this.c.setVisibility(0);
      this.d.setVisibility(4);
    }
    this.b.setX(f1);
    this.b.setY(f2);
  }
  
  private void c()
  {
    setVisibility(4);
    this.l = DisplayUtil.a(getContext());
    this.a = new WinkStickerFrameView(getContext());
    addView(this.a, new FrameLayout.LayoutParams(-1, -1));
    this.b = LayoutInflater.from(getContext()).inflate(2131628255, this, false);
    addView(this.b, new FrameLayout.LayoutParams(-2, -2));
    this.b.findViewById(2131432307).setOnClickListener(new -..Lambda.WinkStickerFrameLayout.A7wJTXF2000P-ZDB9xMpsE1z2Qo(this));
    this.b.findViewById(2131431709).setOnClickListener(new -..Lambda.WinkStickerFrameLayout.iP03zLrYM7MZOtsjNcvGcR6SUPA(this));
    this.c = ((ImageView)findViewById(2131428778));
    this.d = ((ImageView)findViewById(2131428775));
    this.e = ((TextView)this.b.findViewById(2131431709));
    this.f = ((TextView)this.b.findViewById(2131432307));
    this.p = this.b.findViewById(2131447434);
    this.m = getResources().getDrawable(2130848743);
    this.o = getResources().getDrawable(2130848744);
    this.n = getResources().getDrawable(2130848745);
  }
  
  public void a()
  {
    if (getVisibility() != 0) {
      setVisibility(0);
    }
  }
  
  public void a(WinkStickerModel paramWinkStickerModel, WinkStickerFrameLayout.BorderIconMode paramBorderIconMode)
  {
    a();
    this.a.a(paramWinkStickerModel);
    b(paramWinkStickerModel, paramBorderIconMode);
  }
  
  public void b()
  {
    if (getVisibility() != 4) {
      setVisibility(4);
    }
  }
  
  public void setMenuClickListener(WinkStickerFrameLayout.MenuClickListener paramMenuClickListener)
  {
    this.q = paramMenuClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.view.WinkStickerFrameLayout
 * JD-Core Version:    0.7.0.1
 */