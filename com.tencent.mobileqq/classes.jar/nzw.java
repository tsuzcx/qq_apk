import android.view.View;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;

class nzw
  implements bfth
{
  nzw(nzv paramnzv, int paramInt, VideoInfo paramVideoInfo) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    int i = 0;
    if (paramInt == this.jdField_a_of_type_Int)
    {
      bcql.a(nzv.a(this.jdField_a_of_type_Nzv), 0, 2131695527, 0).a();
      nzv.a(this.jdField_a_of_type_Nzv).d(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
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
          paramArrayList = nmc.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
          if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(nzv.a(this.jdField_a_of_type_Nzv))) {
            nmc.a(new nyd().a(nzv.a(this.jdField_a_of_type_Nzv)).a(nmc.c).b(nmc.P).a(paramArrayList).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.f).a(paramView).a());
          }
        }
        else
        {
          return;
        }
        nmc.a(new nyd().a(nzv.a(this.jdField_a_of_type_Nzv)).a(nmc.c).b(nmc.N).a(paramArrayList).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.f).a(paramView).a());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzw
 * JD-Core Version:    0.7.0.1
 */