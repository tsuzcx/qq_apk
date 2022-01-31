import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class nlz
  implements rcg
{
  nlz(nlx paramnlx, AdvertisementInfo paramAdvertisementInfo) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdDislikeHelper", 2, "onUninterestConfirm");
    }
    paramView = onh.a();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (nlx.a(this.jdField_a_of_type_Nlx) != null))
    {
      osl localosl = (osl)nlx.a(this.jdField_a_of_type_Nlx).getManager(163);
      if (localosl.a() != null) {
        localosl.a().a(Long.valueOf(paramView).longValue(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.makeDislikeParam(paramArrayList, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mArticleID)));
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
        nmc.a(new nyd().a(nlx.a(this.jdField_a_of_type_Nlx)).a(nmc.c).b(nmc.P).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(l).a(paramView).a());
        bcql.a(nlx.a(this.jdField_a_of_type_Nlx), -1, nlx.a(this.jdField_a_of_type_Nlx).getString(2131699675), 0).b(nlx.a(this.jdField_a_of_type_Nlx).getResources().getDimensionPixelSize(2131298865));
        nlx.a(this.jdField_a_of_type_Nlx).dismiss();
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlz
 * JD-Core Version:    0.7.0.1
 */