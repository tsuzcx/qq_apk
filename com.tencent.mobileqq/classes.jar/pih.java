import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

public class pih
  implements ViewBase.OnClickListener
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  
  public pih(BaseArticleInfo paramBaseArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (AdvertisementInfo.class.isInstance(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
    {
      paramViewBase = (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if (paramViewBase.mLocalInfo != null)
      {
        String str = paramViewBase.mLocalInfo.b;
        if (!TextUtils.isEmpty(str))
        {
          onk.e(this.jdField_a_of_type_AndroidContentContext, str);
          nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(nmf.a).b(nmf.Z).a(paramViewBase).d(nmf.aN).a());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pih
 * JD-Core Version:    0.7.0.1
 */