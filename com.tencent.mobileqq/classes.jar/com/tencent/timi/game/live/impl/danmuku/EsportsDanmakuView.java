package com.tencent.timi.game.live.impl.danmuku;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.inject.DanmakuContext.Builder;
import com.tencent.common.danmaku.inject.IDanmakuCreator;
import com.tencent.common.danmaku.inject.IDanmakuWindowCreator;
import com.tencent.common.danmaku.inject.VideoDanmakuConfig;
import com.tencent.common.danmaku.inject.VideoDanmakuConfig.ILogger;
import com.tencent.common.danmaku.inject.WindowConfig;
import com.tencent.common.danmaku.render.BaseDanmakuRender;
import com.tencent.common.danmaku.util.DrawUtils;
import com.tencent.common.danmaku.util.Logger;
import com.tencent.mobileqq.danmaku.QQDanmakuManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.ex.LayoutExKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/EsportsDanmakuView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/live/impl/danmuku/IEsportsDanmaku;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "danmakuRender", "Lcom/tencent/timi/game/live/impl/danmuku/DanmakuRender;", "isDanmakuStart", "", "()Z", "isPause", "isStart", "normalDanmakuManager", "Lcom/tencent/timi/game/live/impl/danmuku/CustomDanmakuManager;", "normalDanmakuStartTime", "", "normalDanmakuTextureView", "Landroid/view/TextureView;", "prepared", "rowCount", "clear", "", "generateDanmakuManager", "danmakuView", "Landroid/view/View;", "type", "getView", "onDestroy", "onSizeChanged", "w", "h", "oldw", "oldh", "onStart", "onStop", "prepare", "prepareDanmakuManager", "recreateManager", "reloadConfig", "height", "sendKtv", "txt", "", "sendLargeCharacterTextDanmaku", "txtColor", "priority", "sendTextDanmaku", "sendTextDanmakuWithBg", "start", "stop", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class EsportsDanmakuView
  extends FrameLayout
  implements IEsportsDanmaku
{
  public static final EsportsDanmakuView.Companion a = new EsportsDanmakuView.Companion(null);
  private CustomDanmakuManager b;
  private long c = -1L;
  private TextureView d;
  private final DanmakuRender e = new DanmakuRender();
  private boolean f;
  private boolean g;
  private boolean h = true;
  private int i;
  
  static
  {
    QQDanmakuManager.a();
    VideoDanmakuConfig.a(true);
  }
  
  @JvmOverloads
  public EsportsDanmakuView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public EsportsDanmakuView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public EsportsDanmakuView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final CustomDanmakuManager a(View paramView, int paramInt1, int paramInt2)
  {
    DanmakuContext localDanmakuContext = DanmakuContext.k().a((IDanmakuWindowCreator)EsportsDanmakuView.generateDanmakuManager.1.a).b(paramInt2).a((IDanmakuCreator)EsportsDanmakuView.generateDanmakuManager.2.a).a((BaseDanmakuRender)this.e).a(-4).a(true).a();
    Intrinsics.checkExpressionValueIsNotNull(localDanmakuContext, "DanmakuContext.newBuilde…\n                .build()");
    paramView = new CustomDanmakuManager(paramView, localDanmakuContext);
    paramView.b(true);
    paramView.c(true);
    return paramView;
  }
  
  private final void a(int paramInt)
  {
    if (((paramInt == 1) || (paramInt == 2)) && (this.c == -1L))
    {
      CustomDanmakuManager localCustomDanmakuManager = this.b;
      if (localCustomDanmakuManager != null) {
        localCustomDanmakuManager.a();
      }
      Logger.b("EsportsDanmakuView", "normalDanmakuManager start");
      this.c = System.currentTimeMillis();
    }
  }
  
  private final int b(int paramInt)
  {
    Logger.a((VideoDanmakuConfig.ILogger)new EsportsDanmakuView.reloadConfig.1());
    int j = paramInt - LayoutExKt.b(8) - LayoutExKt.b(8);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("contentHeight: ");
    ((StringBuilder)localObject1).append(j);
    Logger.b("EsportsDanmakuView", ((StringBuilder)localObject1).toString());
    float f2 = j;
    float f3 = DrawUtils.a(LayoutExKt.b(12.0F));
    float f1 = 2;
    j = (int)(f2 / (f3 + LayoutExKt.b(8.0F) * f1));
    f3 = j;
    float f4 = DrawUtils.a(LayoutExKt.b(12.0F));
    float f5 = LayoutExKt.b(8.0F);
    localObject1 = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplication.getContext()");
    localObject1 = ((BaseApplication)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplication.getContext().resources");
    f2 = (f2 - f3 * (f4 + f5 * f1)) / ((Resources)localObject1).getDisplayMetrics().density;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("density: ");
    Object localObject2 = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplication.getContext()");
    localObject2 = ((BaseApplication)localObject2).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplication.getContext().resources");
    ((StringBuilder)localObject1).append(((Resources)localObject2).getDisplayMetrics().density);
    Logger.b("EsportsDanmakuView", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("rowCount: ");
    ((StringBuilder)localObject1).append(j);
    ((StringBuilder)localObject1).append("; marginTop: ");
    int k = (int)(8 + f2 / f1);
    ((StringBuilder)localObject1).append(k);
    ((StringBuilder)localObject1).append("; height: ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("; lineHeight: ");
    ((StringBuilder)localObject1).append(DrawUtils.a(LayoutExKt.b(12.0F)) + f1 * LayoutExKt.b(8.0F));
    Logger.b("EsportsDanmakuView", ((StringBuilder)localObject1).toString());
    localObject1 = DanmakuContext.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "this");
    ((WindowConfig)localObject1).a(j);
    ((WindowConfig)localObject1).c(7000);
    ((WindowConfig)localObject1).c(2.0F);
    ((WindowConfig)localObject1).b(2.0F);
    ((WindowConfig)localObject1).b(k);
    ((WindowConfig)localObject1).a(8.0F);
    ((WindowConfig)localObject1).d(12.0F);
    ((WindowConfig)localObject1).b(true);
    ((WindowConfig)localObject1).d(true);
    ((WindowConfig)localObject1).g(0.0F);
    ((WindowConfig)localObject1).f(0.0F);
    ((WindowConfig)localObject1).d(false);
    return j;
  }
  
  private final boolean g()
  {
    return (this.g) && (!this.h);
  }
  
  private final void h()
  {
    if (!g()) {
      return;
    }
    Object localObject = this.d;
    if (localObject != null) {
      removeView((View)localObject);
    }
    this.d = new TextureView(getContext());
    addView((View)this.d, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    a();
    localObject = this.b;
    if (localObject != null) {
      ((CustomDanmakuManager)localObject).g();
    }
    localObject = this.d;
    if (localObject != null)
    {
      Logger.e("EsportsDanmakuView", "recreate danmakuManager");
      this.b = a((View)localObject, 1, this.i);
    }
  }
  
  public void a()
  {
    post((Runnable)new EsportsDanmakuView.prepare.1(this));
  }
  
  public void a(@NotNull Context paramContext, @NotNull String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "ctx");
    Intrinsics.checkParameterIsNotNull(paramString, "txt");
    if (!g()) {
      return;
    }
    a(1);
    paramContext = this.b;
    if (paramContext != null)
    {
      paramString = paramContext.a(1, new DanmakuDataBean(paramString, false));
      Intrinsics.checkExpressionValueIsNotNull(paramString, "danmaku");
      paramString.g(System.currentTimeMillis() - this.c);
      paramContext.c(paramString);
    }
  }
  
  public void b()
  {
    Logger.e("EsportsDanmakuView", "onDestroy");
    this.g = false;
    this.c = -1L;
    CustomDanmakuManager localCustomDanmakuManager = this.b;
    if (localCustomDanmakuManager != null) {
      localCustomDanmakuManager.g();
    }
  }
  
  public void b(@NotNull Context paramContext, @NotNull String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "ctx");
    Intrinsics.checkParameterIsNotNull(paramString, "txt");
    if (!g()) {
      return;
    }
    a(2);
    paramContext = this.b;
    if (paramContext != null)
    {
      paramString = paramContext.a(2, new DanmakuDataBean(paramString, true));
      Intrinsics.checkExpressionValueIsNotNull(paramString, "danmaku");
      paramString.g(System.currentTimeMillis() - this.c);
      paramContext.c(paramString);
    }
  }
  
  public void c()
  {
    Logger.e("EsportsDanmakuView", "onResume");
    this.h = false;
    h();
  }
  
  public void d()
  {
    Logger.e("EsportsDanmakuView", "onPause");
    this.h = true;
    this.c = -1L;
    CustomDanmakuManager localCustomDanmakuManager = this.b;
    if (localCustomDanmakuManager != null) {
      localCustomDanmakuManager.f();
    }
    localCustomDanmakuManager = this.b;
    if (localCustomDanmakuManager != null) {
      localCustomDanmakuManager.d();
    }
    localCustomDanmakuManager = this.b;
    if (localCustomDanmakuManager != null) {
      localCustomDanmakuManager.g();
    }
  }
  
  public void e()
  {
    Logger.e("EsportsDanmakuView", "start");
    this.g = true;
    h();
  }
  
  public void f()
  {
    Logger.e("EsportsDanmakuView", "stop");
    this.g = false;
    this.c = -1L;
    CustomDanmakuManager localCustomDanmakuManager = this.b;
    if (localCustomDanmakuManager != null) {
      localCustomDanmakuManager.f();
    }
    localCustomDanmakuManager = this.b;
    if (localCustomDanmakuManager != null) {
      localCustomDanmakuManager.d();
    }
    localCustomDanmakuManager = this.b;
    if (localCustomDanmakuManager != null) {
      localCustomDanmakuManager.g();
    }
  }
  
  @NotNull
  public View getView()
  {
    return (View)this;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    CustomDanmakuManager localCustomDanmakuManager = this.b;
    if (localCustomDanmakuManager != null) {
      localCustomDanmakuManager.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.EsportsDanmakuView
 * JD-Core Version:    0.7.0.1
 */