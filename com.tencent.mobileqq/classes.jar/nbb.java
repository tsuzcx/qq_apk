import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class nbb
  implements qpy
{
  nbb(naz paramnaz, AdvertisementInfo paramAdvertisementInfo) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdDislikeHelper", 2, "onUninterestConfirm");
    }
    paramView = obz.a();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (naz.a(this.jdField_a_of_type_Naz) != null))
    {
      ohd localohd = (ohd)naz.a(this.jdField_a_of_type_Naz).getManager(163);
      if (localohd.a() != null) {
        localohd.a().a(Long.valueOf(paramView).longValue(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.makeDislikeParam(paramArrayList, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mArticleID)));
      }
      if ((paramObject == null) || (!(paramObject instanceof DislikeInfo))) {
        break label316;
      }
    }
    label313:
    label316:
    for (long l = ((DislikeInfo)paramObject).a;; l = 0L)
    {
      paramView = "";
      int i = 0;
      if (i < paramArrayList.size())
      {
        paramObject = (DislikeInfo)paramArrayList.get(i);
        if (paramObject == null) {
          break label313;
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
        nbe.a(new nmv().a(naz.a(this.jdField_a_of_type_Naz)).a(nbe.c).b(nbe.P).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(l).a(paramView).a());
        bbmy.a(naz.a(this.jdField_a_of_type_Naz), -1, naz.a(this.jdField_a_of_type_Naz).getString(2131633876), 0).b(naz.a(this.jdField_a_of_type_Naz).getResources().getDimensionPixelSize(2131167766));
        naz.a(this.jdField_a_of_type_Naz).dismiss();
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbb
 * JD-Core Version:    0.7.0.1
 */