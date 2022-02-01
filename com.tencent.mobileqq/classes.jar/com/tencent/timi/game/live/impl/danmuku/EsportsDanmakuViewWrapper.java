package com.tencent.timi.game.live.impl.danmuku;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/EsportsDanmakuViewWrapper;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/live/impl/danmuku/IEsportsDanmaku;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clear", "", "getView", "Landroid/view/View;", "onDestroy", "onStart", "onStop", "prepare", "sendKtv", "txt", "", "sendLargeCharacterTextDanmaku", "txtColor", "priority", "sendTextDanmaku", "sendTextDanmakuWithBg", "start", "stop", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class EsportsDanmakuViewWrapper
  extends FrameLayout
  implements IEsportsDanmaku
{
  @JvmOverloads
  public EsportsDanmakuViewWrapper(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public EsportsDanmakuViewWrapper(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public EsportsDanmakuViewWrapper(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(@NotNull Context paramContext, @NotNull String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "ctx");
    Intrinsics.checkParameterIsNotNull(paramString, "txt");
    paramContext = new StringBuilder();
    paramContext.append("An operation is not implemented: ");
    paramContext.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(paramContext.toString()));
  }
  
  public void b(@NotNull Context paramContext, @NotNull String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "ctx");
    Intrinsics.checkParameterIsNotNull(paramString, "txt");
    paramContext = new StringBuilder();
    paramContext.append("An operation is not implemented: ");
    paramContext.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(paramContext.toString()));
  }
  
  public void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("An operation is not implemented: ");
    localStringBuilder.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(localStringBuilder.toString()));
  }
  
  public void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("An operation is not implemented: ");
    localStringBuilder.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(localStringBuilder.toString()));
  }
  
  public void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("An operation is not implemented: ");
    localStringBuilder.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(localStringBuilder.toString()));
  }
  
  public void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("An operation is not implemented: ");
    localStringBuilder.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(localStringBuilder.toString()));
  }
  
  @Nullable
  public View getView()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("An operation is not implemented: ");
    localStringBuilder.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.EsportsDanmakuViewWrapper
 * JD-Core Version:    0.7.0.1
 */