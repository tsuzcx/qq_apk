package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.tencent.mobileqq.profile.view.helper.ShakeEffectGenerator;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector.DragSource;
import com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector.Draggable;
import com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector.DropTarget;

public final class VipTagView
  extends TextView
  implements DragAndDropDetector.Draggable
{
  private static final int[] a = { 2131299354, 2131299355, 2131299356, 2131299357, 2131299358 };
  private int b = 0;
  private boolean c = false;
  private Paint d;
  private ValueAnimation<Float> e;
  private ShakeEffectGenerator f;
  private float g;
  private boolean h = false;
  private Bitmap i;
  
  public VipTagView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public VipTagView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VipTagView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode())
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16843087 });
      try
      {
        paramAttributeSet = paramContext.getString(0);
        paramContext.recycle();
        if (paramAttributeSet != null) {
          setLabelText(paramAttributeSet);
        }
        c();
        return;
      }
      finally
      {
        paramContext.recycle();
      }
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.h)
    {
      int j = getHeight();
      int k = this.i.getHeight();
      float f1 = this.g;
      paramCanvas.save();
      float f2 = getWidth() - this.i.getWidth();
      float f3 = j * 0.8F + k;
      paramCanvas.translate(f2, f3 + -f3 * this.g);
      this.d.setAlpha((int)(255.0F - this.g * 200.0F));
      paramCanvas.scale(f1, f1);
      paramCanvas.drawBitmap(this.i, 0.0F, 0.0F, this.d);
      paramCanvas.restore();
    }
  }
  
  private void c()
  {
    setClickable(true);
    Object localObject = getResources();
    setTextSize(0, ((Resources)localObject).getDimensionPixelSize(2131299345));
    int j = ((Resources)localObject).getDimensionPixelSize(2131299350);
    this.d = new Paint();
    this.d.setColor(-16777216);
    localObject = this.d;
    float f1 = j;
    ((Paint)localObject).setTextSize(f1);
    this.d.setTextAlign(Paint.Align.LEFT);
    this.i = Bitmap.createBitmap((int)this.d.measureText("+1"), j, Bitmap.Config.ARGB_4444);
    new Canvas(this.i).drawText("+1", 0.0F, f1, this.d);
    this.f = new ShakeEffectGenerator(this);
    this.e = new ValueAnimation(Float.valueOf(0.0F), Float.valueOf(1.0F), new VipTagView.1(this));
    this.e.setDuration(800L);
    this.e.setInterpolator(new DecelerateInterpolator());
    this.e.setAnimationListener(new VipTagView.2(this));
  }
  
  private void d()
  {
    int j = this.b;
    String str1;
    if (j <= 99) {
      str1 = String.valueOf(j);
    } else {
      str1 = "99+";
    }
    if ((getText() instanceof String))
    {
      String str2 = (String)getText();
      str2 = str2.substring(0, str2.indexOf('('));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2);
      localStringBuilder.append("(");
      localStringBuilder.append(str1);
      localStringBuilder.append(")");
      setText(localStringBuilder.toString());
    }
  }
  
  private void setBackgroundDrawableAdaptive(int paramInt)
  {
    setBackgroundResource(2130849302);
    if ((paramInt > 0) && (paramInt <= 5))
    {
      Object localObject = getBackground();
      if ((localObject instanceof GradientDrawable))
      {
        Resources localResources = getResources();
        localObject = (GradientDrawable)localObject;
        ((GradientDrawable)localObject).mutate();
        paramInt = localResources.getDimensionPixelSize(a[(paramInt - 1)]);
        ((GradientDrawable)localObject).setSize(paramInt, paramInt);
      }
    }
  }
  
  public void a()
  {
    this.b += 1;
    this.h = true;
    startAnimation(this.e);
    d();
  }
  
  public void a(DragAndDropDetector.DragSource paramDragSource, DragAndDropDetector.DropTarget paramDropTarget, float paramFloat1, float paramFloat2) {}
  
  public boolean a(DragAndDropDetector.DragSource paramDragSource, float paramFloat1, float paramFloat2)
  {
    bringToFront();
    this.f.b();
    return true;
  }
  
  public void b(DragAndDropDetector.DragSource paramDragSource, float paramFloat1, float paramFloat2) {}
  
  public boolean b()
  {
    return this.f.c();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
  }
  
  public void setLabelAndPraise(String paramString, int paramInt)
  {
    setLabelText(paramString);
    this.b = paramInt;
    d();
  }
  
  public void setLabelText(String paramString)
  {
    int k = paramString.length();
    int j = 0;
    String str = paramString;
    if (k > 5) {
      str = paramString.substring(0, 5);
    }
    paramString = str.toCharArray();
    StringBuilder localStringBuilder = new StringBuilder();
    while (j < paramString.length)
    {
      localStringBuilder.append(paramString[j]);
      if ((str.length() > 3) && (j == 1)) {
        localStringBuilder.append('\n');
      }
      j += 1;
    }
    localStringBuilder.append("\n(0)");
    setText(localStringBuilder);
    setBackgroundDrawableAdaptive(str.length());
  }
  
  public void setShakingState(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (this.c)
    {
      this.f.a();
      return;
    }
    this.f.b();
  }
  
  public void setTagColor(int paramInt1, int paramInt2)
  {
    Object localObject = getBackground();
    if ((localObject instanceof GradientDrawable))
    {
      localObject = (GradientDrawable)localObject;
      ((GradientDrawable)localObject).setColor(paramInt2);
      ((GradientDrawable)localObject).setStroke(2, paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipTagView
 * JD-Core Version:    0.7.0.1
 */