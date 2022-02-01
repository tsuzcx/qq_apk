import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class rti
  implements sgx
{
  rti(rsx paramrsx, VideoInfo paramVideoInfo) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = ozs.a();
    AdvertisementInfo localAdvertisementInfo;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      if (rsx.a(this.jdField_a_of_type_Rsx).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
        rpt.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      }
      pfa.a().a(Long.valueOf(paramView).longValue(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.makeDislikeParam(paramArrayList, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g));
      localAdvertisementInfo = nzq.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      if ((paramObject == null) || (!(paramObject instanceof DislikeInfo))) {
        break label304;
      }
    }
    label301:
    label304:
    for (long l = ((DislikeInfo)paramObject).a;; l = 0L)
    {
      paramView = "";
      int i = 0;
      if (i < paramArrayList.size())
      {
        paramObject = (DislikeInfo)paramArrayList.get(i);
        if (paramObject == null) {
          break label301;
        }
        paramObject = paramView + paramObject.a;
        paramView = paramObject;
        if (i != paramArrayList.size() - 1) {
          paramView = paramObject + ",";
        }
      }
      for (;;)
      {
        i += 1;
        break;
        nzq.a(new tlx().a(rsx.a(this.jdField_a_of_type_Rsx)).a(nzq.c).b(nzq.R).a(localAdvertisementInfo).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(l).a(paramView).a());
        QQToast.a(rsx.a(this.jdField_a_of_type_Rsx), -1, rsx.a(this.jdField_a_of_type_Rsx).getString(2131698588), 0).b(rsx.a(this.jdField_a_of_type_Rsx).getResources().getDimensionPixelSize(2131299011));
        rsx.a(this.jdField_a_of_type_Rsx).dismiss();
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rti
 * JD-Core Version:    0.7.0.1
 */