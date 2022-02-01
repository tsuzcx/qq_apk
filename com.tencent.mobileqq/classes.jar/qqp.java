import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

public class qqp
  implements ViewBase.OnClickListener
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  
  public qqp(BaseArticleInfo paramBaseArticleInfo, Context paramContext)
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
        Object localObject = paramViewBase.mLocalInfo.b;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = pqx.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
          ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(22).a((JumpMode)localObject).a(paramViewBase).d(33).a());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqp
 * JD-Core Version:    0.7.0.1
 */