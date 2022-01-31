import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

final class rnl
  implements bfth
{
  rnl(Context paramContext, BaseData paramBaseData, AdData paramAdData) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FastWebActivity)) {
      ((FastWebActivity)this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
    }
    if (((QQAppInterface)onh.a() != null) && (paramArrayList != null))
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
      nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(nmc.c).b(nmc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a(oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a(paramView).d(nmc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a());
      bcql.a(this.jdField_a_of_type_AndroidContentContext, -1, this.jdField_a_of_type_AndroidContentContext.getString(2131699675), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rnl
 * JD-Core Version:    0.7.0.1
 */