package com.tencent.timi.game.liveroom.impl.floating;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.float_window.FloatingAnimateInfo;
import com.tencent.timi.game.float_window.FloatingConfigParams;
import com.tencent.timi.game.float_window.FloatingConfigParams.FloatingBuilder;
import com.tencent.timi.game.float_window.IFloatView;
import com.tencent.timi.game.float_window.IFloatView.DefaultImpls;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/floating/TGLiveAnchorFloatingView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/float_window/IFloatView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveRoomService", "Lcom/tencent/timi/game/component/qqlive/api/ITgLiveRoomService;", "roomId", "", "getRoomId", "()J", "setRoomId", "(J)V", "getFloatingConfigParams", "Lcom/tencent/timi/game/float_window/FloatingConfigParams;", "getView", "Landroid/view/View;", "init", "onAttachFloat", "", "onBackground", "onDetachFloat", "onForground", "onHide", "onShow", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGLiveAnchorFloatingView
  extends FrameLayout
  implements IFloatView
{
  private ITgLiveRoomService a;
  private long b;
  
  @JvmOverloads
  public TGLiveAnchorFloatingView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TGLiveAnchorFloatingView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TGLiveAnchorFloatingView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "ServiceCenter.getService…eRoomService::class.java)");
    this.a = ((ITgLiveRoomService)paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(2131629445, (ViewGroup)this);
    setOnClickListener((View.OnClickListener)new TGLiveAnchorFloatingView.1(paramContext));
  }
  
  @NotNull
  public IFloatView a(long paramLong)
  {
    this.b = paramLong;
    return (IFloatView)this;
  }
  
  public void a() {}
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  @NotNull
  public FloatingAnimateInfo getAnimateInfo()
  {
    return IFloatView.DefaultImpls.a(this);
  }
  
  @NotNull
  public FloatingConfigParams getFloatingConfigParams()
  {
    return new FloatingConfigParams.FloatingBuilder().a(CommonExKt.a(70), CommonExKt.a(70)).a();
  }
  
  public final long getRoomId()
  {
    return this.b;
  }
  
  @NotNull
  public View getView()
  {
    return (View)this;
  }
  
  public final void setRoomId(long paramLong)
  {
    this.b = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.floating.TGLiveAnchorFloatingView
 * JD-Core Version:    0.7.0.1
 */