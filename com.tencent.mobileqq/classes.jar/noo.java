import android.view.View;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;

class noo
  implements bekw
{
  noo(non paramnon, int paramInt, VideoInfo paramVideoInfo) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    int i = 0;
    if (paramInt == this.jdField_a_of_type_Int)
    {
      bbmy.a(non.a(this.jdField_a_of_type_Non), 0, 2131629845, 0).a();
      non.a(this.jdField_a_of_type_Non).d(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      if ((paramObject == null) || (!(paramObject instanceof DislikeInfo))) {
        break label349;
      }
    }
    label346:
    label349:
    for (long l = ((DislikeInfo)paramObject).a;; l = 0L)
    {
      paramView = "";
      paramInt = i;
      if (paramInt < paramArrayList.size())
      {
        paramObject = (DislikeInfo)paramArrayList.get(paramInt);
        if (paramObject == null) {
          break label346;
        }
        paramObject = paramView + paramObject.a;
        paramView = paramObject;
        if (paramInt != paramArrayList.size() - 1) {
          paramView = paramObject + ",";
        }
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.f = l;
          paramArrayList = nbe.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
          if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(non.a(this.jdField_a_of_type_Non))) {
            nbe.a(new nmv().a(non.a(this.jdField_a_of_type_Non)).a(nbe.c).b(nbe.P).a(paramArrayList).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.f).a(paramView).a());
          }
        }
        else
        {
          return;
        }
        nbe.a(new nmv().a(non.a(this.jdField_a_of_type_Non)).a(nbe.c).b(nbe.N).a(paramArrayList).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.f).a(paramView).a());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     noo
 * JD-Core Version:    0.7.0.1
 */