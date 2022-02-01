import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.PtsData;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/item/NewPtsViewCreator$PTSLiteItemViewHolder;", "Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/item/BaseItemViewHolder;", "itemView", "Landroid/view/View;", "data", "Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/BaseData;", "(Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/item/NewPtsViewCreator;Landroid/view/View;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/BaseData;)V", "isReusable", "", "bindData", "", "oldData", "isVirtualCall", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class syn
  extends syj
{
  private boolean jdField_a_of_type_Boolean;
  
  public syn(View paramView, @NotNull BaseData paramBaseData)
  {
    super(paramBaseData, localObject);
  }
  
  public void a(@NotNull BaseData paramBaseData1, @NotNull BaseData paramBaseData2, boolean paramBoolean)
  {
    Object localObject = null;
    Intrinsics.checkParameterIsNotNull(paramBaseData1, "oldData");
    Intrinsics.checkParameterIsNotNull(paramBaseData2, "data");
    paramBaseData2 = (PtsData)paramBaseData2;
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramBaseData2.a == null) {
        PtsData.a(paramBaseData2, null, 1, null);
      }
      PTSComposer localPTSComposer = paramBaseData2.a;
      if (localPTSComposer != null)
      {
        syl localsyl = this.jdField_a_of_type_Syl;
        PTSItemData localPTSItemData = paramBaseData2.a();
        paramBaseData1 = localObject;
        if (localPTSItemData != null) {
          paramBaseData1 = localPTSItemData.getJSONData();
        }
        localPTSComposer.setData(syl.a(localsyl, paramBaseData1));
        paramBaseData1 = this.jdField_a_of_type_AndroidViewView;
        if (paramBaseData1 == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.pts.core.itemview.PTSItemView");
        }
        localPTSComposer.layoutToView((PTSItemView)paramBaseData1, (IPTSLiteEventListener)syl.a(this.jdField_a_of_type_Syl), true);
      }
      this.jdField_a_of_type_Syl.a(false, paramBaseData2);
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     syn
 * JD-Core Version:    0.7.0.1
 */