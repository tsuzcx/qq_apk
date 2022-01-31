import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;

class qse
  implements rcg
{
  qse(qrt paramqrt, VideoInfo paramVideoInfo) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = onh.a();
    AdvertisementInfo localAdvertisementInfo;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      if (qrt.a(this.jdField_a_of_type_Qrt).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
        qoi.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      }
      osg.a().a(Long.valueOf(paramView).longValue(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.makeDislikeParam(paramArrayList, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g));
      localAdvertisementInfo = nmc.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
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
        nmc.a(new nyd().a(qrt.a(this.jdField_a_of_type_Qrt)).a(nmc.c).b(nmc.P).a(localAdvertisementInfo).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(l).a(paramView).a());
        bcql.a(qrt.a(this.jdField_a_of_type_Qrt), -1, qrt.a(this.jdField_a_of_type_Qrt).getString(2131699675), 0).b(qrt.a(this.jdField_a_of_type_Qrt).getResources().getDimensionPixelSize(2131298865));
        qrt.a(this.jdField_a_of_type_Qrt).dismiss();
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qse
 * JD-Core Version:    0.7.0.1
 */