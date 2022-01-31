import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelViewNew;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;

public class rot
  extends wci
{
  private FolderRecommendTabFragment.FolderRecommendHeadItemView jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView;
  private TopPanelViewNew jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew;
  private vxe jdField_a_of_type_Vxe;
  
  public rot(FolderRecommendTabFragment paramFolderRecommendTabFragment, Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, wbp paramwbp)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView;
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew = new TopPanelViewNew(a());
    paramBundle = new FrameLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew.setLayoutParams(paramBundle);
    this.jdField_a_of_type_Vxe = new vxe(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew);
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView = new FolderRecommendTabFragment.FolderRecommendHeadItemView(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment, a());
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew.setOnHideBtnClickListener(new rou(this));
  }
  
  public void a(wca paramwca)
  {
    if ((paramwca.c()) && (rsp.b()) && (this.jdField_a_of_type_Vxe != null)) {
      this.jdField_a_of_type_Vxe.b();
    }
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_Vxe != null) {
      this.jdField_a_of_type_Vxe.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rot
 * JD-Core Version:    0.7.0.1
 */