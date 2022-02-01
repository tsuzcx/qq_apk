import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

final class ssv
  implements blna
{
  ssv(Context paramContext, BaseData paramBaseData, AdData paramAdData) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FastWebActivity)) {
      ((FastWebActivity)this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
    }
    if (((QQAppInterface)ozs.a() != null) && (paramArrayList != null))
    {
      paramView = "";
      paramInt = 0;
      if (paramInt < paramArrayList.size())
      {
        paramObject = (DislikeInfo)paramArrayList.get(paramInt);
        if (paramObject == null) {
          break label223;
        }
        paramObject = paramView + paramObject.a;
        paramView = paramObject;
        if (paramInt != paramArrayList.size() - 1) {
          paramView = paramObject + ",";
        }
      }
    }
    label223:
    for (;;)
    {
      paramInt += 1;
      break;
      nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(nzq.c).b(nzq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a(tqb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a(paramView).d(nzq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a());
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, -1, this.jdField_a_of_type_AndroidContentContext.getString(2131698588), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ssv
 * JD-Core Version:    0.7.0.1
 */