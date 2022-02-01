import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class ooq
  implements bklx
{
  ooq(oop paramoop, AdvertisementInfo paramAdvertisementInfo) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramInt = 0;
    QQToast.a(oop.a(this.jdField_a_of_type_Oop), 0, 2131694579, 0).a();
    if ((paramObject != null) && ((paramObject instanceof DislikeInfo))) {}
    for (long l = ((DislikeInfo)paramObject).a;; l = 0L)
    {
      paramView = "";
      if (paramInt < paramArrayList.size())
      {
        paramObject = (DislikeInfo)paramArrayList.get(paramInt);
        if (paramObject == null) {
          break label186;
        }
        paramObject = paramView + paramObject.a;
        paramView = paramObject;
        if (paramInt != paramArrayList.size() - 1) {
          paramView = paramObject + ",";
        }
      }
      label186:
      for (;;)
      {
        paramInt += 1;
        break;
        nxw.a(new omp().a(oop.a(this.jdField_a_of_type_Oop)).a(nxw.c).b(nxw.P).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(l).a(paramView).a());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ooq
 * JD-Core Version:    0.7.0.1
 */