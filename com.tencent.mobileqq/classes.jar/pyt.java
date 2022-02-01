import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

public class pyt
  implements ViewBase.OnClickListener
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  
  public pyt(BaseArticleInfo paramBaseArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo))
    {
      paramViewBase = (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if (paramViewBase.mLocalInfo != null)
      {
        String str = paramViewBase.mLocalInfo.b;
        if (!TextUtils.isEmpty(str))
        {
          ozs.d(this.jdField_a_of_type_AndroidContentContext, str);
          nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(nzq.a).b(nzq.ab).a(paramViewBase).d(nzq.aX).a());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyt
 * JD-Core Version:    0.7.0.1
 */