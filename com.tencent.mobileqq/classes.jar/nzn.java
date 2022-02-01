import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class nzn
  implements sgx
{
  nzn(nzl paramnzl, AdvertisementInfo paramAdvertisementInfo) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdDislikeHelper", 2, "onUninterestConfirm");
    }
    paramView = ozs.a();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (nzl.a(this.jdField_a_of_type_Nzl) != null))
    {
      pfg localpfg = (pfg)nzl.a(this.jdField_a_of_type_Nzl).getManager(163);
      if (localpfg.a() != null) {
        localpfg.a().a(Long.valueOf(paramView).longValue(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.makeDislikeParam(paramArrayList, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mArticleID)));
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
        nzq.a(new tlx().a(nzl.a(this.jdField_a_of_type_Nzl)).a(nzq.c).b(nzq.R).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(l).a(paramView).a());
        QQToast.a(nzl.a(this.jdField_a_of_type_Nzl), -1, nzl.a(this.jdField_a_of_type_Nzl).getString(2131698588), 0).b(nzl.a(this.jdField_a_of_type_Nzl).getResources().getDimensionPixelSize(2131299011));
        nzl.a(this.jdField_a_of_type_Nzl).dismiss();
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzn
 * JD-Core Version:    0.7.0.1
 */