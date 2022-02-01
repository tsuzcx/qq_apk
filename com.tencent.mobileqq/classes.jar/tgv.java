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
final class tgv
  extends tgr
{
  private boolean jdField_a_of_type_Boolean;
  
  public tgv(View paramView, @NotNull BaseData paramBaseData)
  {
    super(paramBaseData, localObject);
  }
  
  public void b(@NotNull BaseData paramBaseData1, @NotNull BaseData paramBaseData2, boolean paramBoolean)
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
        tgt localtgt = this.jdField_a_of_type_Tgt;
        PTSItemData localPTSItemData = paramBaseData2.a();
        paramBaseData1 = localObject;
        if (localPTSItemData != null) {
          paramBaseData1 = localPTSItemData.getJSONData();
        }
        localPTSComposer.setData(tgt.a(localtgt, paramBaseData1));
        paramBaseData1 = this.jdField_a_of_type_AndroidViewView;
        if (paramBaseData1 == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.pts.core.itemview.PTSItemView");
        }
        localPTSComposer.layoutToView((PTSItemView)paramBaseData1, (IPTSLiteEventListener)tgt.a(this.jdField_a_of_type_Tgt), true);
      }
      this.jdField_a_of_type_Tgt.a(false, paramBaseData2);
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tgv
 * JD-Core Version:    0.7.0.1
 */