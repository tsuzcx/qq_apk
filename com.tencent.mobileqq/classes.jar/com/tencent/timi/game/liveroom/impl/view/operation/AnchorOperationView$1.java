package com.tencent.timi.game.liveroom.impl.view.operation;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.image.URLImageView;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.datareport.api.ILiveReportService.DefaultImpls;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import com.tencent.timi.game.utils.CommonExKt;
import com.tencent.timi.game.utils.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/operation/AnchorOperationView$1", "Landroidx/viewpager/widget/PagerAdapter;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorOperationView$1
  extends PagerAdapter
{
  AnchorOperationView$1(Context paramContext, int paramInt) {}
  
  public void destroyItem(@NotNull ViewGroup paramViewGroup, int paramInt, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    Intrinsics.checkParameterIsNotNull(paramObject, "object");
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return AnchorOperationView.c(this.a).b().size();
  }
  
  @NotNull
  public Object instantiateItem(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    View localView = View.inflate(this.b, 2131629413, null);
    OperationItem localOperationItem = (OperationItem)AnchorOperationView.c(this.a).b().get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view");
    Object localObject1 = (RoundCornerImageView)localView.findViewById(2131439649);
    ((RoundCornerImageView)localObject1).setRadius(CommonExKt.b(4));
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("loading :{");
    ((StringBuilder)localObject2).append(localOperationItem);
    ((StringBuilder)localObject2).append('}');
    Logger.b("AnchorOperationView_", 1, ((StringBuilder)localObject2).toString());
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "operationIgv");
    localObject2 = (URLImageView)localObject1;
    CommonExKt.a((URLImageView)localObject2, localOperationItem.a(), AnchorOperationView.a(this.a, (URLImageView)localObject2));
    ((RoundCornerImageView)localObject1).setOnClickListener((View.OnClickListener)new AnchorOperationView.1.instantiateItem.1(this, localOperationItem));
    paramViewGroup.addView(localView);
    localObject1 = (Map)new HashMap();
    ((Map)localObject1).put("qqlive_guajian_location_hori", String.valueOf(paramInt));
    ((Map)localObject1).put("qqlive_guajian_location_ver", String.valueOf(this.c));
    ((Map)localObject1).put("qqlive_resource_id", String.valueOf(localOperationItem.e()));
    if (localOperationItem.f()) {
      paramViewGroup = "0";
    } else {
      paramViewGroup = "1";
    }
    ((Map)localObject1).put("qqlive_guajian_type", paramViewGroup);
    ((Map)localObject1).put("qqlive_screen_orientation", "0");
    ILiveReportService.DefaultImpls.a((ILiveReportService)ServiceCenter.a(ILiveReportService.class), localView, false, null, "em_qqlive_guajian", (Map)localObject1, 6, null);
    return localView;
  }
  
  public boolean isViewFromObject(@NotNull View paramView, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramObject, "object");
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.operation.AnchorOperationView.1
 * JD-Core Version:    0.7.0.1
 */