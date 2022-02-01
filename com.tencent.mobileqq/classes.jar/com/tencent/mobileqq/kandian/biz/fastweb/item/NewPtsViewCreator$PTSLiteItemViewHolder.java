package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.entity.PtsData;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/fastweb/item/NewPtsViewCreator$PTSLiteItemViewHolder;", "Lcom/tencent/mobileqq/kandian/biz/fastweb/entity/BaseItemViewHolder;", "itemView", "Landroid/view/View;", "data", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/BaseData;", "(Lcom/tencent/mobileqq/kandian/biz/fastweb/item/NewPtsViewCreator;Landroid/view/View;Lcom/tencent/mobileqq/kandian/repo/feeds/entity/BaseData;)V", "isReusable", "", "bindData", "", "oldData", "isVirtualCall", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
final class NewPtsViewCreator$PTSLiteItemViewHolder
  extends BaseItemViewHolder
{
  private boolean jdField_a_of_type_Boolean;
  
  public NewPtsViewCreator$PTSLiteItemViewHolder(View paramView, @NotNull BaseData paramBaseData)
  {
    super(paramBaseData, localObject);
  }
  
  public void a(@NotNull BaseData paramBaseData1, @NotNull BaseData paramBaseData2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseData1, "oldData");
    Intrinsics.checkParameterIsNotNull(paramBaseData2, "data");
    paramBaseData2 = (PtsData)paramBaseData2;
    if (this.jdField_a_of_type_Boolean)
    {
      PTSComposer localPTSComposer = paramBaseData2.a;
      paramBaseData1 = null;
      if (localPTSComposer == null) {
        PtsData.a(paramBaseData2, null, 1, null);
      }
      localPTSComposer = paramBaseData2.a;
      if (localPTSComposer != null)
      {
        NewPtsViewCreator localNewPtsViewCreator = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemNewPtsViewCreator;
        PTSItemData localPTSItemData = paramBaseData2.a();
        if (localPTSItemData != null) {
          paramBaseData1 = localPTSItemData.getJSONData();
        }
        localPTSComposer.setData(NewPtsViewCreator.a(localNewPtsViewCreator, paramBaseData1));
        paramBaseData1 = this.jdField_a_of_type_AndroidViewView;
        if (paramBaseData1 != null) {
          localPTSComposer.layoutToView((PTSItemView)paramBaseData1, (IPTSLiteEventListener)NewPtsViewCreator.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemNewPtsViewCreator), true);
        } else {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.pts.core.itemview.PTSItemView");
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemNewPtsViewCreator.a(false, paramBaseData2);
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.NewPtsViewCreator.PTSLiteItemViewHolder
 * JD-Core Version:    0.7.0.1
 */