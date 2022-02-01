package com.tencent.timi.game.liveroom.impl.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/AnchorPrivateGuideView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "colorBg", "paint", "Landroid/graphics/Paint;", "pdf", "Landroid/graphics/PorterDuffXfermode;", "privateBtnRect", "Landroid/graphics/Rect;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setPrivateBtnRect", "rect", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorPrivateGuideView
  extends FrameLayout
{
  private PorterDuffXfermode a;
  private final Paint b = new Paint();
  private final int c = Color.argb(204, 0, 0, 0);
  private Rect d;
  private HashMap e;
  
  @JvmOverloads
  public AnchorPrivateGuideView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public AnchorPrivateGuideView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public AnchorPrivateGuideView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(2131629415, (ViewGroup)this);
    this.a = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    setWillNotDraw(false);
    this.b.setAntiAlias(true);
    this.b.setColor(-65536);
    setLayerType(1, null);
    ((TextView)a(2131430807)).setOnClickListener((View.OnClickListener)new AnchorPrivateGuideView.1(this));
    setOnClickListener((View.OnClickListener)AnchorPrivateGuideView.2.a);
  }
  
  public View a(int paramInt)
  {
    if (this.e == null) {
      this.e = new HashMap();
    }
    View localView2 = (View)this.e.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.e.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  protected void onDraw(@Nullable Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = this.d;
    if (localObject != null)
    {
      if (paramCanvas != null) {
        paramCanvas.drawARGB(204, 0, 0, 0);
      }
      this.b.setXfermode((Xfermode)this.a);
      if (paramCanvas != null)
      {
        float f1 = ((Rect)localObject).centerX();
        float f2 = ((Rect)localObject).centerY();
        localObject = a(2131432709);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "eyePos");
        paramCanvas.drawCircle(f1, f2, ((View)localObject).getWidth() / 2.0F, this.b);
      }
      this.b.setXfermode((Xfermode)null);
    }
  }
  
  public final void setPrivateBtnRect(@NotNull Rect paramRect)
  {
    Intrinsics.checkParameterIsNotNull(paramRect, "rect");
    setAlpha(0.0F);
    post((Runnable)new AnchorPrivateGuideView.setPrivateBtnRect.1(this, paramRect));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorPrivateGuideView
 * JD-Core Version:    0.7.0.1
 */