import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.qqstory.utils.UIUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/common/ProteusPreloadManager$PreloadContainerWrapper;", "", "container", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;)V", "getContainer", "()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "setContainer", "screenWidth", "", "getScreenWidth", "()Ljava/lang/Number;", "setScreenWidth", "(Ljava/lang/Number;)V", "isSuitableSize", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pit
{
  @NotNull
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  @NotNull
  private Number jdField_a_of_type_JavaLangNumber;
  
  public pit(@NotNull Container paramContainer)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = paramContainer;
    this.jdField_a_of_type_JavaLangNumber = ((Number)Integer.valueOf(UIUtils.getScreenWidth(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext())));
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
    int i = UIUtils.getScreenWidth(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext());
    Number localNumber = this.jdField_a_of_type_JavaLangNumber;
    if (!(localNumber instanceof Integer)) {}
    while (i != ((Integer)localNumber).intValue()) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pit
 * JD-Core Version:    0.7.0.1
 */