package com.tencent.timi.game.base.ui;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "mProgressDrawable", "Landroid/graphics/drawable/Drawable;", "getMProgressDrawable", "()Landroid/graphics/drawable/Drawable;", "setMProgressDrawable", "(Landroid/graphics/drawable/Drawable;)V", "hide", "", "setHintText", "textResId", "text", "show", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGamePageLoadingView
  extends FrameLayout
{
  @NotNull
  private final String a = "TimiGamePageLoadingView_";
  @NotNull
  private Drawable b;
  private HashMap c;
  
  @JvmOverloads
  public TimiGamePageLoadingView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TimiGamePageLoadingView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TimiGamePageLoadingView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.inflate(paramContext, 2131629513, (ViewGroup)this);
    setBackgroundResource(2131168376);
    paramContext = a(2131437623);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "loadingCircleView");
    paramContext = paramContext.getBackground();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "loadingCircleView.background");
    this.b = paramContext;
    setVisibility(8);
    setOnClickListener((View.OnClickListener)new TimiGamePageLoadingView.1(this));
  }
  
  public View a(int paramInt)
  {
    if (this.c == null) {
      this.c = new HashMap();
    }
    View localView2 = (View)this.c.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.c.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final void a()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      ((Animatable)localDrawable).start();
      setVisibility(0);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.Animatable");
  }
  
  public final void b()
  {
    setVisibility(8);
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      ((Animatable)localDrawable).stop();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.Animatable");
  }
  
  @NotNull
  public final Drawable getMProgressDrawable()
  {
    return this.b;
  }
  
  @NotNull
  public final String getTAG()
  {
    return this.a;
  }
  
  public final void setHintText(int paramInt)
  {
    String str = getContext().getString(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(str, "context.getString(textResId)");
    setHintText(str);
  }
  
  public final void setHintText(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    TextView localTextView = (TextView)a(2131435050);
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "hintTxv");
    localTextView.setText((CharSequence)paramString);
  }
  
  public final void setMProgressDrawable(@NotNull Drawable paramDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "<set-?>");
    this.b = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.base.ui.TimiGamePageLoadingView
 * JD-Core Version:    0.7.0.1
 */