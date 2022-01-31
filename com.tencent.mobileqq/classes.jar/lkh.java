import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnArticleWrapperClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnBiuClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnCommentClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnJumpWrapperClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnLikeClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicRecommendHeaderClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicRecommendHeaderFollowClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;
import com.tencent.mobileqq.util.FaceDecoder;

public final class lkh
  implements ViewFactory.FoundClickableViewListener
{
  public lkh(VafContext paramVafContext, FaceDecoder paramFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IReadInJoyModel paramIReadInJoyModel, Container paramContainer, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void a(ViewBase paramViewBase)
  {
    if (paramViewBase.a() == null) {
      return;
    }
    switch (StringCommon.a(paramViewBase.a()))
    {
    case 1009: 
    default: 
      paramViewBase.a(new lkk(this, paramViewBase));
      return;
    case 1001: 
      paramViewBase.a(new lki(this, paramViewBase));
      return;
    case 1002: 
      paramViewBase.a(new OnLikeClickListener((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.a()));
      return;
    case 1003: 
      paramViewBase.a(new OnCommentClickListener((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.a()));
      return;
    case 1004: 
      paramViewBase.a(new OnBiuClickListener((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.a()));
      return;
    case 1005: 
      paramViewBase.a(new OnTopicRecommendHeaderClickListener((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.a()));
      return;
    case 1006: 
      paramViewBase.a(new OnTopicRecommendHeaderFollowClickListener((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.a()));
      return;
    case 1007: 
      paramViewBase.a().setOnClickListener(new lkj(this));
      return;
    case 1008: 
      paramViewBase.a(new OnArticleWrapperClickListener((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter));
      return;
    }
    paramViewBase.a(new OnJumpWrapperClickListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.a(), (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lkh
 * JD-Core Version:    0.7.0.1
 */