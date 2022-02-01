package com.tencent.mobileqq.kandian.biz.viola.barrage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.kandian.glue.viola.adapter.ui.ComponentAdapter;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "appearState", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageItemView$AppearState;", "getAppearState", "()Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageItemView$AppearState;", "setAppearState", "(Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageItemView$AppearState;)V", "authorImageView", "Landroid/widget/ImageView;", "barrageTextView", "Landroid/widget/TextView;", "barrageType", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageItemView$BarrageType;", "blockDistance", "getBlockDistance", "()I", "setBlockDistance", "(I)V", "busyInLineEntry", "", "getBusyInLineEntry", "()Z", "setBusyInLineEntry", "(Z)V", "componentAdapter", "Lcom/tencent/mobileqq/kandian/glue/viola/adapter/ui/ComponentAdapter;", "placeLines", "", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageTrack$BarrageLine;", "getPlaceLines", "()Ljava/util/List;", "setPlaceLines", "(Ljava/util/List;)V", "calculateBlockDistance", "updateBarrageBg", "", "alpha", "", "updateUi", "barrageInfo", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageInfo;", "barrageConfig", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageConfig;", "AppearState", "BarrageType", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BarrageItemView
  extends LinearLayout
{
  public static final BarrageItemView.Companion a = new BarrageItemView.Companion(null);
  private static final int j = DisplayUtil.a((Context)BaseApplication.getContext(), 10.0F);
  private static final int k = DisplayUtil.a((Context)BaseApplication.getContext(), 24.0F);
  private final TextView b;
  private final ImageView c;
  private BarrageItemView.BarrageType d = BarrageItemView.BarrageType.SHORT;
  private final ComponentAdapter e = new ComponentAdapter();
  private boolean f;
  private int g;
  @NotNull
  private List<BarrageTrack.BarrageLine> h = CollectionsKt.emptyList();
  @NotNull
  private BarrageItemView.AppearState i = BarrageItemView.AppearState.NONE;
  
  @JvmOverloads
  public BarrageItemView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public BarrageItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public BarrageItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131626479, (ViewGroup)this);
    paramContext = findViewById(2131448294);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_barrage)");
    this.b = ((TextView)paramContext);
    paramContext = findViewById(2131436268);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_author)");
    this.c = ((ImageView)paramContext);
    a(0.2F);
    paramInt = j;
    setPadding(paramInt, 0, paramInt, 0);
    setGravity(16);
    setMinimumHeight(k);
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
  }
  
  private final void a(float paramFloat)
  {
    Drawable localDrawable = getResources().getDrawable(2130842674);
    Intrinsics.checkExpressionValueIsNotNull(localDrawable, "shapeDrawable");
    localDrawable.setAlpha((int)(paramFloat * 'ÿ'));
    setBackgroundDrawable(localDrawable);
  }
  
  private final int b()
  {
    if (this.d == BarrageItemView.BarrageType.DOUBLE_LINE)
    {
      Size localSize = DisplayUtil.a((Context)BaseApplication.getContext());
      Intrinsics.checkExpressionValueIsNotNull(localSize, "DisplayUtil.getScreenSiz…Application.getContext())");
      return localSize.a() / 2;
    }
    return BarrageController.a.a()[kotlin.random.Random.Default.nextInt(BarrageController.a.a().length)].intValue();
  }
  
  public final void a(@NotNull BarrageInfo paramBarrageInfo, @NotNull BarrageConfig paramBarrageConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramBarrageInfo, "barrageInfo");
    Intrinsics.checkParameterIsNotNull(paramBarrageConfig, "barrageConfig");
    a(paramBarrageConfig.e());
    paramBarrageInfo.a();
    this.b.setText((CharSequence)paramBarrageInfo.g);
    if (paramBarrageInfo.e != null)
    {
      paramBarrageConfig = this.c;
      int m;
      if (paramBarrageInfo.e.d) {
        m = 0;
      } else {
        m = 8;
      }
      paramBarrageConfig.setVisibility(m);
    }
    this.d = a.a(paramBarrageInfo.c);
    if (this.d == BarrageItemView.BarrageType.DOUBLE_LINE) {
      this.b.setLines(2);
    } else {
      this.b.setLines(1);
    }
    this.g = b();
  }
  
  @NotNull
  public final BarrageItemView.AppearState getAppearState()
  {
    return this.i;
  }
  
  public final int getBlockDistance()
  {
    return this.g;
  }
  
  public final boolean getBusyInLineEntry()
  {
    return this.f;
  }
  
  @NotNull
  public final List<BarrageTrack.BarrageLine> getPlaceLines()
  {
    return this.h;
  }
  
  public final void setAppearState(@NotNull BarrageItemView.AppearState paramAppearState)
  {
    Intrinsics.checkParameterIsNotNull(paramAppearState, "<set-?>");
    this.i = paramAppearState;
  }
  
  public final void setBlockDistance(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void setBusyInLineEntry(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public final void setPlaceLines(@NotNull List<BarrageTrack.BarrageLine> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "<set-?>");
    this.h = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageItemView
 * JD-Core Version:    0.7.0.1
 */