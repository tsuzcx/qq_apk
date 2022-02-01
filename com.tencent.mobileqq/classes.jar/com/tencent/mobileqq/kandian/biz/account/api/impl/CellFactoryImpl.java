package com.tencent.mobileqq.kandian.biz.account.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.base.utils.ApiCompatibilityUtils;
import com.tencent.mobileqq.kandian.biz.account.api.ICellFactory;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommend;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowGroup;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowList;
import com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell;
import com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeRecommendFollow;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/account/api/impl/CellFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/account/api/ICellFactory;", "()V", "defaultFeedItemCellMap", "", "", "Lkotlin/Function3;", "Landroid/content/Context;", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "Lcom/tencent/mobileqq/kandian/biz/framework/ReadInJoyBaseAdapter;", "Lcom/tencent/mobileqq/kandian/biz/pts/component/FeedItemCell;", "rebuildCompletedTypes", "", "recommendFollowFeedItemCellMap", "Lkotlin/Pair;", "Lkotlin/Function4;", "Ljava/lang/Class;", "Landroid/view/View;", "Lcom/tencent/mobileqq/kandian/biz/pts/component/FeedItemCellTypeRecommendFollow;", "cellRebuildCompleted", "", "type", "createFeedItemCell", "context", "model", "", "faceDecoder", "adapter", "getCellByType", "getView", "position", "viewType", "convertView", "Lcom/tencent/mobileqq/kandian/biz/common/baseui/IReadInJoyBaseAdapter;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class CellFactoryImpl
  implements ICellFactory
{
  public static final CellFactoryImpl.Companion Companion = new CellFactoryImpl.Companion(null);
  private static final String TAG = "CellFactoryImpl";
  private final Map<Integer, Function3<Context, IFaceDecoder, ReadInJoyBaseAdapter, FeedItemCell>> defaultFeedItemCellMap;
  private final Set<Integer> rebuildCompletedTypes;
  private final Map<Integer, Pair<Function4<Context, IFaceDecoder, ReadInJoyBaseAdapter, Class<? extends View>, FeedItemCellTypeRecommendFollow<? extends View>>, Class<? extends View>>> recommendFollowFeedItemCellMap;
  
  public CellFactoryImpl()
  {
    Integer localInteger1 = Integer.valueOf(0);
    Pair localPair1 = TuplesKt.to(localInteger1, CellFactoryImpl.defaultFeedItemCellMap.1.INSTANCE);
    Integer localInteger2 = Integer.valueOf(1);
    Pair localPair2 = TuplesKt.to(localInteger2, CellFactoryImpl.defaultFeedItemCellMap.2.INSTANCE);
    Pair localPair3 = TuplesKt.to(Integer.valueOf(104), CellFactoryImpl.defaultFeedItemCellMap.3.INSTANCE);
    Integer localInteger3 = Integer.valueOf(2);
    Pair localPair4 = TuplesKt.to(Integer.valueOf(106), CellFactoryImpl.defaultFeedItemCellMap.4.INSTANCE);
    Integer localInteger4 = Integer.valueOf(3);
    Pair localPair5 = TuplesKt.to(localInteger3, CellFactoryImpl.defaultFeedItemCellMap.5.INSTANCE);
    Integer localInteger5 = Integer.valueOf(39);
    Pair localPair6 = TuplesKt.to(localInteger5, CellFactoryImpl.defaultFeedItemCellMap.6.INSTANCE);
    Integer localInteger6 = Integer.valueOf(5);
    Pair localPair7 = TuplesKt.to(Integer.valueOf(116), CellFactoryImpl.defaultFeedItemCellMap.7.INSTANCE);
    Pair localPair8 = TuplesKt.to(localInteger4, CellFactoryImpl.defaultFeedItemCellMap.8.INSTANCE);
    Pair localPair9 = TuplesKt.to(Integer.valueOf(105), CellFactoryImpl.defaultFeedItemCellMap.9.INSTANCE);
    Integer localInteger7 = Integer.valueOf(14);
    this.defaultFeedItemCellMap = MapsKt.mapOf(new Pair[] { localPair1, localPair2, localPair3, localPair4, localPair5, localPair6, localPair7, localPair8, localPair9, TuplesKt.to(localInteger7, CellFactoryImpl.defaultFeedItemCellMap.10.INSTANCE), TuplesKt.to(localInteger6, CellFactoryImpl.defaultFeedItemCellMap.11.INSTANCE), TuplesKt.to(Integer.valueOf(6), CellFactoryImpl.defaultFeedItemCellMap.12.INSTANCE), TuplesKt.to(Integer.valueOf(66), CellFactoryImpl.defaultFeedItemCellMap.13.INSTANCE), TuplesKt.to(Integer.valueOf(115), CellFactoryImpl.defaultFeedItemCellMap.14.INSTANCE), TuplesKt.to(Integer.valueOf(71), CellFactoryImpl.defaultFeedItemCellMap.15.INSTANCE), TuplesKt.to(Integer.valueOf(7), CellFactoryImpl.defaultFeedItemCellMap.16.INSTANCE), TuplesKt.to(Integer.valueOf(8), CellFactoryImpl.defaultFeedItemCellMap.17.INSTANCE), TuplesKt.to(Integer.valueOf(9), CellFactoryImpl.defaultFeedItemCellMap.18.INSTANCE), TuplesKt.to(Integer.valueOf(10), CellFactoryImpl.defaultFeedItemCellMap.19.INSTANCE), TuplesKt.to(Integer.valueOf(11), CellFactoryImpl.defaultFeedItemCellMap.20.INSTANCE), TuplesKt.to(Integer.valueOf(28), CellFactoryImpl.defaultFeedItemCellMap.21.INSTANCE), TuplesKt.to(Integer.valueOf(12), CellFactoryImpl.defaultFeedItemCellMap.22.INSTANCE), TuplesKt.to(Integer.valueOf(27), CellFactoryImpl.defaultFeedItemCellMap.23.INSTANCE), TuplesKt.to(Integer.valueOf(15), CellFactoryImpl.defaultFeedItemCellMap.24.INSTANCE), TuplesKt.to(Integer.valueOf(18), CellFactoryImpl.defaultFeedItemCellMap.25.INSTANCE), TuplesKt.to(Integer.valueOf(19), CellFactoryImpl.defaultFeedItemCellMap.26.INSTANCE), TuplesKt.to(Integer.valueOf(17), CellFactoryImpl.defaultFeedItemCellMap.27.INSTANCE), TuplesKt.to(Integer.valueOf(16), CellFactoryImpl.defaultFeedItemCellMap.28.INSTANCE), TuplesKt.to(Integer.valueOf(20), CellFactoryImpl.defaultFeedItemCellMap.29.INSTANCE), TuplesKt.to(Integer.valueOf(21), CellFactoryImpl.defaultFeedItemCellMap.30.INSTANCE), TuplesKt.to(Integer.valueOf(22), CellFactoryImpl.defaultFeedItemCellMap.31.INSTANCE), TuplesKt.to(Integer.valueOf(36), CellFactoryImpl.defaultFeedItemCellMap.32.INSTANCE), TuplesKt.to(Integer.valueOf(23), CellFactoryImpl.defaultFeedItemCellMap.33.INSTANCE), TuplesKt.to(Integer.valueOf(25), CellFactoryImpl.defaultFeedItemCellMap.34.INSTANCE), TuplesKt.to(Integer.valueOf(37), CellFactoryImpl.defaultFeedItemCellMap.35.INSTANCE), TuplesKt.to(Integer.valueOf(26), CellFactoryImpl.defaultFeedItemCellMap.36.INSTANCE), TuplesKt.to(Integer.valueOf(24), CellFactoryImpl.defaultFeedItemCellMap.37.INSTANCE), TuplesKt.to(Integer.valueOf(29), CellFactoryImpl.defaultFeedItemCellMap.38.INSTANCE), TuplesKt.to(Integer.valueOf(30), CellFactoryImpl.defaultFeedItemCellMap.39.INSTANCE), TuplesKt.to(Integer.valueOf(31), CellFactoryImpl.defaultFeedItemCellMap.40.INSTANCE), TuplesKt.to(Integer.valueOf(32), CellFactoryImpl.defaultFeedItemCellMap.41.INSTANCE), TuplesKt.to(Integer.valueOf(33), CellFactoryImpl.defaultFeedItemCellMap.42.INSTANCE), TuplesKt.to(Integer.valueOf(34), CellFactoryImpl.defaultFeedItemCellMap.43.INSTANCE), TuplesKt.to(Integer.valueOf(35), CellFactoryImpl.defaultFeedItemCellMap.44.INSTANCE), TuplesKt.to(Integer.valueOf(45), CellFactoryImpl.defaultFeedItemCellMap.45.INSTANCE), TuplesKt.to(Integer.valueOf(40), CellFactoryImpl.defaultFeedItemCellMap.46.INSTANCE), TuplesKt.to(Integer.valueOf(41), CellFactoryImpl.defaultFeedItemCellMap.47.INSTANCE), TuplesKt.to(Integer.valueOf(42), CellFactoryImpl.defaultFeedItemCellMap.48.INSTANCE), TuplesKt.to(Integer.valueOf(43), CellFactoryImpl.defaultFeedItemCellMap.49.INSTANCE), TuplesKt.to(Integer.valueOf(44), CellFactoryImpl.defaultFeedItemCellMap.50.INSTANCE), TuplesKt.to(Integer.valueOf(47), CellFactoryImpl.defaultFeedItemCellMap.51.INSTANCE), TuplesKt.to(Integer.valueOf(60), CellFactoryImpl.defaultFeedItemCellMap.52.INSTANCE), TuplesKt.to(Integer.valueOf(61), CellFactoryImpl.defaultFeedItemCellMap.53.INSTANCE), TuplesKt.to(Integer.valueOf(96), CellFactoryImpl.defaultFeedItemCellMap.54.INSTANCE), TuplesKt.to(Integer.valueOf(103), CellFactoryImpl.defaultFeedItemCellMap.55.INSTANCE), TuplesKt.to(Integer.valueOf(102), CellFactoryImpl.defaultFeedItemCellMap.56.INSTANCE), TuplesKt.to(Integer.valueOf(101), CellFactoryImpl.defaultFeedItemCellMap.57.INSTANCE), TuplesKt.to(Integer.valueOf(48), CellFactoryImpl.defaultFeedItemCellMap.58.INSTANCE), TuplesKt.to(Integer.valueOf(64), CellFactoryImpl.defaultFeedItemCellMap.59.INSTANCE), TuplesKt.to(Integer.valueOf(65), CellFactoryImpl.defaultFeedItemCellMap.60.INSTANCE), TuplesKt.to(Integer.valueOf(49), CellFactoryImpl.defaultFeedItemCellMap.61.INSTANCE), TuplesKt.to(Integer.valueOf(62), CellFactoryImpl.defaultFeedItemCellMap.62.INSTANCE), TuplesKt.to(Integer.valueOf(63), CellFactoryImpl.defaultFeedItemCellMap.63.INSTANCE), TuplesKt.to(Integer.valueOf(54), CellFactoryImpl.defaultFeedItemCellMap.64.INSTANCE), TuplesKt.to(Integer.valueOf(55), CellFactoryImpl.defaultFeedItemCellMap.65.INSTANCE), TuplesKt.to(Integer.valueOf(56), CellFactoryImpl.defaultFeedItemCellMap.66.INSTANCE), TuplesKt.to(Integer.valueOf(57), CellFactoryImpl.defaultFeedItemCellMap.67.INSTANCE), TuplesKt.to(Integer.valueOf(58), CellFactoryImpl.defaultFeedItemCellMap.68.INSTANCE), TuplesKt.to(Integer.valueOf(59), CellFactoryImpl.defaultFeedItemCellMap.69.INSTANCE), TuplesKt.to(Integer.valueOf(53), CellFactoryImpl.defaultFeedItemCellMap.70.INSTANCE), TuplesKt.to(Integer.valueOf(50), CellFactoryImpl.defaultFeedItemCellMap.71.INSTANCE), TuplesKt.to(Integer.valueOf(98), CellFactoryImpl.defaultFeedItemCellMap.72.INSTANCE), TuplesKt.to(Integer.valueOf(97), CellFactoryImpl.defaultFeedItemCellMap.73.INSTANCE), TuplesKt.to(Integer.valueOf(52), CellFactoryImpl.defaultFeedItemCellMap.74.INSTANCE), TuplesKt.to(Integer.valueOf(51), CellFactoryImpl.defaultFeedItemCellMap.75.INSTANCE), TuplesKt.to(Integer.valueOf(67), CellFactoryImpl.defaultFeedItemCellMap.76.INSTANCE), TuplesKt.to(Integer.valueOf(69), CellFactoryImpl.defaultFeedItemCellMap.77.INSTANCE), TuplesKt.to(Integer.valueOf(68), CellFactoryImpl.defaultFeedItemCellMap.78.INSTANCE), TuplesKt.to(Integer.valueOf(93), CellFactoryImpl.defaultFeedItemCellMap.79.INSTANCE), TuplesKt.to(Integer.valueOf(123), CellFactoryImpl.defaultFeedItemCellMap.80.INSTANCE) });
    this.recommendFollowFeedItemCellMap = MapsKt.mapOf(new Pair[] { TuplesKt.to(Integer.valueOf(82), TuplesKt.to(CellFactoryImpl.recommendFollowFeedItemCellMap.1.INSTANCE, ComponentContentRecommend.class)), TuplesKt.to(Integer.valueOf(87), TuplesKt.to(CellFactoryImpl.recommendFollowFeedItemCellMap.2.INSTANCE, ComponentContentRecommendFollowList.class)), TuplesKt.to(Integer.valueOf(88), TuplesKt.to(CellFactoryImpl.recommendFollowFeedItemCellMap.3.INSTANCE, ComponentContentRecommendFollowGroup.class)) });
    this.rebuildCompletedTypes = SetsKt.setOf(new Integer[] { localInteger1, localInteger2, Integer.valueOf(104), Integer.valueOf(106), localInteger3, localInteger5, Integer.valueOf(116), localInteger4, Integer.valueOf(105), localInteger6, Integer.valueOf(66), Integer.valueOf(115), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(27), Integer.valueOf(28), localInteger7, Integer.valueOf(47), Integer.valueOf(60), Integer.valueOf(96), Integer.valueOf(61), Integer.valueOf(48), Integer.valueOf(64), Integer.valueOf(65), Integer.valueOf(49), Integer.valueOf(62), Integer.valueOf(63), Integer.valueOf(103), Integer.valueOf(102), Integer.valueOf(101), Integer.valueOf(15), Integer.valueOf(18), Integer.valueOf(19), Integer.valueOf(16), Integer.valueOf(17), Integer.valueOf(20), Integer.valueOf(30), Integer.valueOf(29), Integer.valueOf(22), Integer.valueOf(21), Integer.valueOf(23), Integer.valueOf(25), Integer.valueOf(24), Integer.valueOf(26), Integer.valueOf(32), Integer.valueOf(31), Integer.valueOf(33), Integer.valueOf(34), Integer.valueOf(35), Integer.valueOf(36), Integer.valueOf(37), Integer.valueOf(40), Integer.valueOf(42), Integer.valueOf(41), Integer.valueOf(43), Integer.valueOf(44), Integer.valueOf(45), Integer.valueOf(54), Integer.valueOf(55), Integer.valueOf(56), Integer.valueOf(57), Integer.valueOf(58), Integer.valueOf(59), Integer.valueOf(53), Integer.valueOf(68), Integer.valueOf(69), Integer.valueOf(67), Integer.valueOf(76), Integer.valueOf(77), Integer.valueOf(78), Integer.valueOf(79), Integer.valueOf(71), Integer.valueOf(72), Integer.valueOf(73), Integer.valueOf(74), Integer.valueOf(75), Integer.valueOf(82), Integer.valueOf(87), Integer.valueOf(88), Integer.valueOf(93), Integer.valueOf(107), Integer.valueOf(108), Integer.valueOf(123) });
  }
  
  private final FeedItemCell createFeedItemCell(int paramInt, Context paramContext, Object paramObject, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    paramContext = getCellByType(paramInt, paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
    if (paramContext != null) {
      try
      {
        paramContext.a(paramObject);
        paramContext.a();
        paramContext.d();
        return paramContext;
      }
      catch (Exception paramObject)
      {
        QLog.e("CellFactoryImpl", 1, paramObject.getMessage());
      }
    }
    return paramContext;
  }
  
  public boolean cellRebuildCompleted(int paramInt)
  {
    return this.rebuildCompletedTypes.contains(Integer.valueOf(paramInt));
  }
  
  @VisibleForTesting
  @Nullable
  public final FeedItemCell getCellByType(int paramInt, @NotNull Context paramContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Object localObject = (Pair)this.recommendFollowFeedItemCellMap.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      localObject = (FeedItemCellTypeRecommendFollow)((Function4)((Pair)localObject).getFirst()).invoke(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter, ((Pair)localObject).getSecond());
      if (localObject != null) {
        return (FeedItemCell)localObject;
      }
    }
    localObject = (Function3)this.defaultFeedItemCellMap.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      return (FeedItemCell)((Function3)localObject).invoke(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
    }
    return null;
  }
  
  @Nullable
  public View getView(int paramInt1, @Nullable Object paramObject, int paramInt2, @Nullable View paramView, @NotNull Context paramContext, @Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, @Nullable IFaceDecoder paramIFaceDecoder)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if ((paramView != null) && ((paramView.getTag() instanceof FeedItemCell)))
    {
      paramContext = paramView.getTag();
      if (paramContext != null) {
        paramIReadInJoyBaseAdapter = (FeedItemCell)paramContext;
      } else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell");
      }
    }
    else
    {
      paramIFaceDecoder = createFeedItemCell(paramInt2, paramContext, paramObject, paramIFaceDecoder, (ReadInJoyBaseAdapter)paramIReadInJoyBaseAdapter);
      paramIReadInJoyBaseAdapter = paramIFaceDecoder;
      if (paramIFaceDecoder != null) {
        try
        {
          paramView = paramIFaceDecoder.a();
          Intrinsics.checkExpressionValueIsNotNull(paramView, "convertView");
          paramView.setTag(paramIFaceDecoder);
          if (!UtilsForComponent.b(paramInt2))
          {
            ApiCompatibilityUtils.a(paramView, paramContext.getResources().getDrawable(2130841773));
            paramIReadInJoyBaseAdapter = paramIFaceDecoder;
          }
          else
          {
            ApiCompatibilityUtils.a(paramView, paramContext.getResources().getDrawable(2131166928));
            paramIReadInJoyBaseAdapter = paramIFaceDecoder;
          }
        }
        catch (Exception paramObject)
        {
          QLog.e("CellFactoryImpl", 1, "getView: ", (Throwable)paramObject);
          return null;
        }
      }
    }
    if (paramIReadInJoyBaseAdapter != null)
    {
      paramIReadInJoyBaseAdapter.a(paramInt1).a(paramObject);
      paramIReadInJoyBaseAdapter.o();
      paramIReadInJoyBaseAdapter.p();
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.api.impl.CellFactoryImpl
 * JD-Core Version:    0.7.0.1
 */