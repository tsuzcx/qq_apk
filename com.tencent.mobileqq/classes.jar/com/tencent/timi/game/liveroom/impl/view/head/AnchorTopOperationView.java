package com.tencent.timi.game.liveroom.impl.view.head;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.datareport.api.ILiveReportService.DefaultImpls;
import com.tencent.timi.game.liveroom.impl.view.operation.BaseOperationalOpt;
import com.tencent.timi.game.liveroom.impl.view.operation.BaseOperationalOpt.DefaultImpls;
import com.tencent.timi.game.liveroom.impl.view.operation.OperationData;
import com.tencent.timi.game.liveroom.impl.view.operation.OperationItem;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import com.tencent.timi.game.utils.CommonExKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/head/AnchorTopOperationView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/liveroom/impl/view/operation/BaseOperationalOpt;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultColorDrawable", "Landroid/graphics/drawable/ColorDrawable;", "isLandscape", "", "mData", "Lcom/tencent/timi/game/liveroom/impl/view/operation/OperationData;", "bindElementId", "", "getURLDrawableOptions", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "igv", "Landroid/widget/ImageView;", "onOrientationChange", "refreshUI", "setData", "data", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorTopOperationView
  extends FrameLayout
  implements BaseOperationalOpt
{
  public static final AnchorTopOperationView.Companion a = new AnchorTopOperationView.Companion(null);
  private ColorDrawable b = new ColorDrawable(Color.parseColor("#00000000"));
  private OperationData c;
  private boolean d;
  private HashMap e;
  
  @JvmOverloads
  public AnchorTopOperationView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public AnchorTopOperationView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public AnchorTopOperationView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.inflate(paramContext, 2131629420, (ViewGroup)this);
    ((RoundCornerImageView)a(2131439648)).setRadius(CommonExKt.b(11));
  }
  
  private final URLDrawable.URLDrawableOptions a(ImageView paramImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable;
    if (paramImageView.getDrawable() != null) {
      localDrawable = paramImageView.getDrawable();
    } else {
      localDrawable = (Drawable)this.b;
    }
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    if (paramImageView.getDrawable() != null) {
      paramImageView = paramImageView.getDrawable();
    } else {
      paramImageView = (Drawable)this.b;
    }
    localURLDrawableOptions.mFailedDrawable = paramImageView;
    Intrinsics.checkExpressionValueIsNotNull(localURLDrawableOptions, "options");
    return localURLDrawableOptions;
  }
  
  private final void a()
  {
    Map localMap = (Map)new HashMap();
    if (this.d) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localMap.put("qqlive_screen_orientation", localObject);
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mData");
    }
    localObject = (OperationItem)CollectionsKt.firstOrNull(((OperationData)localObject).b());
    if (localObject != null) {
      localMap.put("qqlive_resource_id", String.valueOf(((OperationItem)localObject).e()));
    }
    ILiveReportService.DefaultImpls.a((ILiveReportService)ServiceCenter.a(ILiveReportService.class), (View)this, false, null, "em_qqlive_operation", localMap, 6, null);
  }
  
  private final void b()
  {
    Object localObject1 = this.c;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mData");
    }
    localObject1 = (OperationItem)CollectionsKt.firstOrNull(((OperationData)localObject1).b());
    int j = 0;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (CharSequence)((OperationItem)localObject1).a();
      int i;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {}
    }
    else
    {
      j = 8;
    }
    setVisibility(j);
    if (localObject1 != null)
    {
      localObject2 = (RoundCornerImageView)a(2131439648);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "operationIcon");
      localObject2 = (URLImageView)localObject2;
      String str = ((OperationItem)localObject1).a();
      RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)a(2131439648);
      Intrinsics.checkExpressionValueIsNotNull(localRoundCornerImageView, "operationIcon");
      CommonExKt.a((URLImageView)localObject2, str, a((ImageView)localRoundCornerImageView));
      setOnClickListener((View.OnClickListener)new AnchorTopOperationView.refreshUI..inlined.run.lambda.1((OperationItem)localObject1, this));
    }
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
  
  public void a(@NotNull OperationItem paramOperationItem)
  {
    Intrinsics.checkParameterIsNotNull(paramOperationItem, "data");
    BaseOperationalOpt.DefaultImpls.a(this, paramOperationItem);
  }
  
  public final void setData(@NotNull OperationData paramOperationData)
  {
    Intrinsics.checkParameterIsNotNull(paramOperationData, "data");
    this.c = paramOperationData;
    a();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.head.AnchorTopOperationView
 * JD-Core Version:    0.7.0.1
 */