import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class smr
  implements szt
{
  smr(smg paramsmg, VideoInfo paramVideoInfo) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = pkh.a();
    AdvertisementInfo localAdvertisementInfo;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      if (smg.a(this.jdField_a_of_type_Smg).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
        six.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      }
      pvj.a().a(Long.valueOf(paramView).longValue(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.makeDislikeParam(paramArrayList, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g));
      localAdvertisementInfo = ois.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      if ((paramObject == null) || (!(paramObject instanceof DislikeInfo))) {
        break label355;
      }
    }
    label349:
    label352:
    label355:
    for (long l = ((DislikeInfo)paramObject).jdField_a_of_type_Long;; l = 0L)
    {
      paramObject = "";
      paramView = "";
      int i = 0;
      if (i < paramArrayList.size())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.get(i);
        if (localDislikeInfo == null) {
          break label349;
        }
        paramObject = paramObject + localDislikeInfo.jdField_a_of_type_Long;
        paramView = paramView + localDislikeInfo.jdField_a_of_type_JavaLangString;
        if (i == paramArrayList.size() - 1) {
          break label352;
        }
        paramObject = paramObject + ",";
        paramView = paramView + ",";
      }
      for (;;)
      {
        i += 1;
        break;
        ois.a(new ufy().a(smg.a(this.jdField_a_of_type_Smg)).a(3).b(10).a(localAdvertisementInfo).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(l).a(paramObject).b(paramView).a());
        QQToast.a(smg.a(this.jdField_a_of_type_Smg), -1, smg.a(this.jdField_a_of_type_Smg).getString(2131699167), 0).b(smg.a(this.jdField_a_of_type_Smg).getResources().getDimensionPixelSize(2131299080));
        smg.a(this.jdField_a_of_type_Smg).dismiss();
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     smr
 * JD-Core Version:    0.7.0.1
 */