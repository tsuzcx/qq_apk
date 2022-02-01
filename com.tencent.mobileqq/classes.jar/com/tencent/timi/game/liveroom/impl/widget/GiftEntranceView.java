package com.tencent.timi.game.liveroom.impl.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.initer.api.IniterService;
import com.tencent.timi.game.initer.api.OnPAGLibraryLoadedListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.pag.TimiPAGResourceLoader;
import com.tencent.timi.game.ui.pag.TimiPAGResourceLoader.IPAGResourceLoadListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/widget/GiftEntranceView;", "Landroid/widget/FrameLayout;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "composition", "Lorg/libpag/PAGComposition;", "giftEntrancePAGDownloadListener", "com/tencent/timi/game/liveroom/impl/widget/GiftEntranceView$giftEntrancePAGDownloadListener$1", "Lcom/tencent/timi/game/liveroom/impl/widget/GiftEntranceView$giftEntrancePAGDownloadListener$1;", "initerService", "Lcom/tencent/timi/game/initer/api/IniterService;", "kotlin.jvm.PlatformType", "isPAGLoaded", "", "isPlaying", "onPAGLibraryLoadedListener", "com/tencent/timi/game/liveroom/impl/widget/GiftEntranceView$onPAGLibraryLoadedListener$1", "Lcom/tencent/timi/game/liveroom/impl/widget/GiftEntranceView$onPAGLibraryLoadedListener$1;", "pagFile", "Lorg/libpag/PAGFile;", "pagView", "Lorg/libpag/PAGView;", "pagViewListener", "com/tencent/timi/game/liveroom/impl/widget/GiftEntranceView$pagViewListener$1", "Lcom/tencent/timi/game/liveroom/impl/widget/GiftEntranceView$pagViewListener$1;", "placeHolderIv", "Landroid/widget/ImageView;", "playCalled", "addPAGView", "", "loadAnimation", "file", "width", "height", "onAttachedToWindow", "onDetachedFromWindow", "play", "playInner", "stop", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GiftEntranceView
  extends FrameLayout
{
  public static final GiftEntranceView.Companion a = new GiftEntranceView.Companion(null);
  private PAGView b;
  private PAGFile c;
  private PAGComposition d;
  private boolean e;
  private boolean f;
  private boolean g;
  private final IniterService h = (IniterService)ServiceCenter.a(IniterService.class);
  private final ImageView i;
  private final GiftEntranceView.giftEntrancePAGDownloadListener.1 j;
  private final GiftEntranceView.onPAGLibraryLoadedListener.1 k;
  private final GiftEntranceView.pagViewListener.1 l;
  
  @JvmOverloads
  public GiftEntranceView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public GiftEntranceView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public GiftEntranceView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new ImageView(paramContext);
    paramContext.setImageResource(2130852971);
    this.i = paramContext;
    this.j = new GiftEntranceView.giftEntrancePAGDownloadListener.1(this);
    this.k = new GiftEntranceView.onPAGLibraryLoadedListener.1(this);
    this.l = new GiftEntranceView.pagViewListener.1(this);
    paramContext = (View)this.i;
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -1);
    paramAttributeSet.leftMargin = LayoutExKt.b(3);
    paramAttributeSet.topMargin = LayoutExKt.b(-12);
    paramAttributeSet.rightMargin = LayoutExKt.b(3);
    paramAttributeSet.bottomMargin = LayoutExKt.b(3);
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    paramContext = this.h;
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "initerService");
    if (paramContext.c()) {
      b();
    } else {
      this.h.a((OnPAGLibraryLoadedListener)this.k);
    }
    setBackgroundResource(2130853052);
  }
  
  private final void a(PAGFile paramPAGFile, int paramInt1, int paramInt2)
  {
    this.d = PAGComposition.Make(paramInt1, paramInt2);
    this.c = paramPAGFile;
    Object localObject = this.c;
    if (localObject != null)
    {
      paramPAGFile = ((PAGFile)localObject).getTotalMatrix();
      float f1 = paramInt1 / ((PAGFile)localObject).width();
      if (paramPAGFile != null) {
        paramPAGFile.setScale(f1, f1);
      }
      localObject = this.c;
      if (localObject != null) {
        ((PAGFile)localObject).setMatrix(paramPAGFile);
      }
    }
    paramPAGFile = this.c;
    if (paramPAGFile != null)
    {
      localObject = this.d;
      if (localObject != null) {
        ((PAGComposition)localObject).addLayer((PAGLayer)paramPAGFile);
      }
    }
    paramPAGFile = this.b;
    if (paramPAGFile != null) {
      paramPAGFile.setComposition(this.d);
    }
    paramPAGFile = this.b;
    if (paramPAGFile != null) {
      paramPAGFile.removeListener((PAGView.PAGViewListener)this.l);
    }
    paramPAGFile = this.b;
    if (paramPAGFile != null) {
      paramPAGFile.addListener((PAGView.PAGViewListener)this.l);
    }
  }
  
  private final void b()
  {
    if (this.g) {
      return;
    }
    this.g = true;
    this.b = new PAGView(getContext());
    View localView = (View)this.b;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.leftMargin = LayoutExKt.b(3);
    localLayoutParams.topMargin = LayoutExKt.b(-13);
    localLayoutParams.rightMargin = LayoutExKt.b(3);
    localLayoutParams.bottomMargin = (LayoutExKt.b(3) + LayoutExKt.b(1));
    addView(localView, (ViewGroup.LayoutParams)localLayoutParams);
  }
  
  private final void b(PAGFile paramPAGFile)
  {
    if (this.e)
    {
      Logger.b("GiftEntranceView", "play has called");
      return;
    }
    if (!this.g)
    {
      Logger.c("GiftEntranceView", "playInner# isPAGLoaded false");
      return;
    }
    this.e = true;
    Object localObject = this.b;
    if (localObject != null) {
      ((PAGView)localObject).stop();
    }
    localObject = this.b;
    if (localObject != null)
    {
      localObject = ((PAGView)localObject).getComposition();
      if (localObject != null) {
        ((PAGComposition)localObject).removeAllLayers();
      }
    }
    localObject = this.b;
    if ((localObject != null) && (!((PAGView)localObject).isPlaying()))
    {
      a(paramPAGFile, LayoutExKt.b(45), LayoutExKt.b(68));
      paramPAGFile = this.b;
      if (paramPAGFile != null) {
        paramPAGFile.setProgress(0.0D);
      }
      paramPAGFile = this.b;
      if (paramPAGFile != null) {
        paramPAGFile.setRepeatCount(0);
      }
      paramPAGFile = this.b;
      if (paramPAGFile != null) {
        paramPAGFile.play();
      }
    }
  }
  
  public final void a()
  {
    this.f = false;
    if (this.e)
    {
      if (!this.g) {
        return;
      }
      Logger.c("GiftEntranceView", "stop called");
      this.e = false;
      Object localObject = this.b;
      if (localObject != null) {
        ((PAGView)localObject).stop();
      }
      localObject = this.b;
      if (localObject != null)
      {
        localObject = ((PAGView)localObject).getComposition();
        if (localObject != null) {
          ((PAGComposition)localObject).removeAllLayers();
        }
      }
    }
  }
  
  public final void a(@Nullable PAGFile paramPAGFile)
  {
    this.f = true;
    if (paramPAGFile == null) {
      paramPAGFile = TimiPAGResourceLoader.a(TimiPAGResourceLoader.a, "https://cdn.yes.qq.com/client_business/gift_entrance_2.pag", null, 2, null);
    }
    if (paramPAGFile != null) {
      b(paramPAGFile);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    TimiPAGResourceLoader.a.a((TimiPAGResourceLoader.IPAGResourceLoadListener)this.j);
    this.h.a((OnPAGLibraryLoadedListener)this.k);
    if (!this.g)
    {
      localIniterService = this.h;
      Intrinsics.checkExpressionValueIsNotNull(localIniterService, "initerService");
      if (localIniterService.c())
      {
        b();
        return;
      }
    }
    IniterService localIniterService = this.h;
    Intrinsics.checkExpressionValueIsNotNull(localIniterService, "initerService");
    if (!localIniterService.c()) {
      this.h.a((OnPAGLibraryLoadedListener)this.k);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    TimiPAGResourceLoader.a.b((TimiPAGResourceLoader.IPAGResourceLoadListener)this.j);
    this.h.b((OnPAGLibraryLoadedListener)this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.GiftEntranceView
 * JD-Core Version:    0.7.0.1
 */