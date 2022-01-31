import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

public class pop
  implements ViewBase.OnClickListener
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  
  public pop(BaseArticleInfo paramBaseArticleInfo, Context paramContext)
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
          ors.d(this.jdField_a_of_type_AndroidContentContext, str);
          noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.a).b(noy.Z).a(paramViewBase).d(noy.aN).a());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pop
 * JD-Core Version:    0.7.0.1
 */