package com.tencent.timi.game.liveroom.impl.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.datareport.api.ILiveReportService.DefaultImpls;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.liveroom.impl.more.AnchorMoreSettingUtil;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/widget/AnchorOperationBarView;", "Landroid/widget/LinearLayout;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anchorOperationBarViewListener", "Lcom/tencent/timi/game/liveroom/impl/widget/AnchorOperationBarView$IAnchorOperationBarViewListener;", "isMicOn", "", "isPrivacyOn", "bindReportElement", "", "roomId", "", "getPrivacyRect", "cb", "Lkotlin/Function1;", "Landroid/graphics/Rect;", "setAnchorOperationBarViewListener", "listener", "setMicOn", "on", "setMicVisibility", "visible", "setMoreVisibility", "setPrivacyOn", "setPrivacyVisibility", "IAnchorOperationBarViewListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorOperationBarView
  extends LinearLayout
{
  private boolean a = true;
  private boolean b;
  private AnchorOperationBarView.IAnchorOperationBarViewListener c;
  private HashMap d;
  
  @JvmOverloads
  public AnchorOperationBarView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public AnchorOperationBarView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public AnchorOperationBarView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LinearLayout.inflate(paramContext, 2131629412, (ViewGroup)this);
    setOrientation(0);
    setPadding(0, 0, LayoutExKt.b(4), 0);
    ((TextView)a(2131435816)).setOnClickListener((View.OnClickListener)new AnchorOperationBarView.1(this));
    ((ImageView)a(2131438850)).setOnClickListener((View.OnClickListener)new AnchorOperationBarView.2(this));
    ((ImageView)a(2131440650)).setOnClickListener((View.OnClickListener)new AnchorOperationBarView.3(this));
    ((ImageView)a(2131438164)).setOnClickListener((View.OnClickListener)new AnchorOperationBarView.4(this));
  }
  
  public View a(int paramInt)
  {
    if (this.d == null) {
      this.d = new HashMap();
    }
    View localView2 = (View)this.d.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.d.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final void a(long paramLong)
  {
    Object localObject1 = AnchorMoreSettingUtil.a(paramLong);
    Object localObject2 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
    if (localObject1 != null)
    {
      ((ILiveReportService)localObject2).a(this, "pg_qqlive_anchorlive", (Map)localObject1);
      localObject1 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      localObject2 = (TextView)a(2131435816);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "inputTv");
      ILiveReportService.DefaultImpls.a((ILiveReportService)localObject1, (View)localObject2, false, null, "em_qqlive_inputbar", null, 22, null);
      localObject1 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      localObject2 = (ImageView)a(2131438850);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "moreIv");
      ILiveReportService.DefaultImpls.a((ILiveReportService)localObject1, (View)localObject2, false, null, "em_qqlive_morefunction_entrance", null, 22, null);
      localObject1 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      localObject2 = (ImageView)a(2131438164);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "micIv");
      ILiveReportService.DefaultImpls.a((ILiveReportService)localObject1, (View)localObject2, false, null, "em_qqlive_microphone_switch", null, 22, null);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
  }
  
  public final void a(@NotNull Function1<? super Rect, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "cb");
    ((ImageView)a(2131440650)).post((Runnable)new AnchorOperationBarView.getPrivacyRect.1(this, paramFunction1));
  }
  
  public final void setAnchorOperationBarViewListener(@NotNull AnchorOperationBarView.IAnchorOperationBarViewListener paramIAnchorOperationBarViewListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIAnchorOperationBarViewListener, "listener");
    this.c = paramIAnchorOperationBarViewListener;
  }
  
  public final void setMicOn(boolean paramBoolean)
  {
    this.a = paramBoolean;
    ImageView localImageView = (ImageView)a(2131438164);
    int i;
    if (paramBoolean) {
      i = 2130852897;
    } else {
      i = 2130852896;
    }
    localImageView.setImageResource(i);
  }
  
  public final void setMicVisibility(boolean paramBoolean)
  {
    ImageView localImageView = (ImageView)a(2131438164);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "micIv");
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  public final void setMoreVisibility(boolean paramBoolean)
  {
    ImageView localImageView = (ImageView)a(2131438850);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "moreIv");
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  public final void setPrivacyOn(boolean paramBoolean)
  {
    this.b = paramBoolean;
    ImageView localImageView = (ImageView)a(2131440650);
    int i;
    if (!paramBoolean) {
      i = 2130852900;
    } else {
      i = 2130852899;
    }
    localImageView.setImageResource(i);
  }
  
  public final void setPrivacyVisibility(boolean paramBoolean)
  {
    ImageView localImageView = (ImageView)a(2131440650);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "privacyIv");
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AnchorOperationBarView
 * JD-Core Version:    0.7.0.1
 */