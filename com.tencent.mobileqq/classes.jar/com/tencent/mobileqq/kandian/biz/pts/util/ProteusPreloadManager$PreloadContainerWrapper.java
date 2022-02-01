package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.qqstory.utils.UIUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/util/ProteusPreloadManager$PreloadContainerWrapper;", "", "container", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;)V", "getContainer", "()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "setContainer", "screenWidth", "", "getScreenWidth", "()Ljava/lang/Number;", "setScreenWidth", "(Ljava/lang/Number;)V", "isSuitableSize", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ProteusPreloadManager$PreloadContainerWrapper
{
  @NotNull
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  @NotNull
  private Number jdField_a_of_type_JavaLangNumber;
  
  public ProteusPreloadManager$PreloadContainerWrapper(@NotNull Container paramContainer)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = paramContainer;
    this.jdField_a_of_type_JavaLangNumber = ((Number)Integer.valueOf(UIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext())));
  }
  
  @NotNull
  public final Container a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  }
  
  @NotNull
  public final Number a()
  {
    return this.jdField_a_of_type_JavaLangNumber;
  }
  
  public final boolean a()
  {
    int i = UIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext());
    Number localNumber = this.jdField_a_of_type_JavaLangNumber;
    return ((localNumber instanceof Integer)) && (i == ((Integer)localNumber).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.ProteusPreloadManager.PreloadContainerWrapper
 * JD-Core Version:    0.7.0.1
 */