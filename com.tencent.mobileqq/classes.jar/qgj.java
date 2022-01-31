import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;

class qgj
  implements qpy
{
  qgj(qfy paramqfy, VideoInfo paramVideoInfo) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = obz.a();
    AdvertisementInfo localAdvertisementInfo;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      if (qfy.a(this.jdField_a_of_type_Qfy).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
        qcn.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      }
      ogy.a().a(Long.valueOf(paramView).longValue(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.makeDislikeParam(paramArrayList, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g));
      localAdvertisementInfo = nbe.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
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
        nbe.a(new nmv().a(qfy.a(this.jdField_a_of_type_Qfy)).a(nbe.c).b(nbe.P).a(localAdvertisementInfo).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(l).a(paramView).a());
        bbmy.a(qfy.a(this.jdField_a_of_type_Qfy), -1, qfy.a(this.jdField_a_of_type_Qfy).getString(2131633876), 0).b(qfy.a(this.jdField_a_of_type_Qfy).getResources().getDimensionPixelSize(2131167766));
        qfy.a(this.jdField_a_of_type_Qfy).dismiss();
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qgj
 * JD-Core Version:    0.7.0.1
 */