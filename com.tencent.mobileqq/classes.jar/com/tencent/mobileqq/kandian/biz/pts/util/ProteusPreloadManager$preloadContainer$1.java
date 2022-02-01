package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ProteusPreloadManager$preloadContainer$1
  implements Runnable
{
  ProteusPreloadManager$preloadContainer$1(String paramString1, String paramString2, TemplateBean paramTemplateBean, int paramInt, VafContext paramVafContext) {}
  
  public final void run()
  {
    ProteusPreloadManager localProteusPreloadManager = ProteusPreloadManager.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('#');
    localStringBuilder.append(this.b);
    ProteusPreloadManager.a(localProteusPreloadManager, localStringBuilder.toString(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.ProteusPreloadManager.preloadContainer.1
 * JD-Core Version:    0.7.0.1
 */