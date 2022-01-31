import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelViewNew;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;

public class ssy
  extends yei
{
  private FolderRecommendTabFragment.FolderRecommendHeadItemView jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView;
  private TopPanelViewNew jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew;
  private xyr jdField_a_of_type_Xyr;
  
  public ssy(FolderRecommendTabFragment paramFolderRecommendTabFragment, Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, ydp paramydp)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView;
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew = new TopPanelViewNew(a());
    paramBundle = new FrameLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew.setLayoutParams(paramBundle);
    this.jdField_a_of_type_Xyr = new xyr(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew);
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView = new FolderRecommendTabFragment.FolderRecommendHeadItemView(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment, a());
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew.setOnHideBtnClickListener(new ssz(this));
  }
  
  public void a(yeb paramyeb)
  {
    if ((paramyeb.c()) && (swy.b()) && (this.jdField_a_of_type_Xyr != null)) {
      this.jdField_a_of_type_Xyr.b();
    }
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_Xyr != null) {
      this.jdField_a_of_type_Xyr.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ssy
 * JD-Core Version:    0.7.0.1
 */