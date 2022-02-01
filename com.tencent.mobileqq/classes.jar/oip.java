import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class oip
  implements szt
{
  oip(oin paramoin, AdvertisementInfo paramAdvertisementInfo) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdDislikeHelper", 2, "onUninterestConfirm");
    }
    paramView = pkh.a();
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (oin.a(this.jdField_a_of_type_Oin) != null))
    {
      localObject = (pvp)oin.a(this.jdField_a_of_type_Oin).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (((pvp)localObject).a() != null) {
        ((pvp)localObject).a().a(Long.valueOf(paramView).longValue(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.makeDislikeParam(paramArrayList, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mArticleID)));
      }
      if ((paramObject == null) || (!(paramObject instanceof DislikeInfo))) {
        break label367;
      }
    }
    label361:
    label364:
    label367:
    for (long l = ((DislikeInfo)paramObject).jdField_a_of_type_Long;; l = 0L)
    {
      paramObject = "";
      paramView = "";
      int i = 0;
      if (i < paramArrayList.size())
      {
        localObject = (DislikeInfo)paramArrayList.get(i);
        if (localObject == null) {
          break label361;
        }
        paramObject = paramObject + ((DislikeInfo)localObject).jdField_a_of_type_Long;
        paramView = paramView + ((DislikeInfo)localObject).jdField_a_of_type_JavaLangString;
        if (i == paramArrayList.size() - 1) {
          break label364;
        }
        paramObject = paramObject + ",";
        paramView = paramView + ",";
      }
      for (;;)
      {
        i += 1;
        break;
        ois.a(new ufy().a(oin.a(this.jdField_a_of_type_Oin)).a(3).b(10).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(l).a(paramObject).b(paramView).a());
        QQToast.a(oin.a(this.jdField_a_of_type_Oin), -1, oin.a(this.jdField_a_of_type_Oin).getString(2131699167), 0).b(oin.a(this.jdField_a_of_type_Oin).getResources().getDimensionPixelSize(2131299080));
        oin.a(this.jdField_a_of_type_Oin).dismiss();
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oip
 * JD-Core Version:    0.7.0.1
 */